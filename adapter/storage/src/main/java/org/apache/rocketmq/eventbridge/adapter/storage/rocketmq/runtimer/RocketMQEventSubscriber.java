/*
 * Licensed to the Apache Software Foundation (ASF) under one or more
 * contributor license agreements.  See the NOTICE file distributed with
 * this work for additional information regarding copyright ownership.
 * The ASF licenses this file to You under the Apache License, Version 2.0
 * (the "License"); you may not use this file except in compliance with
 * the License.  You may obtain a copy of the License at
 *
 *     http://www.apache.org/licenses/LICENSE-2.0
 *
 *  Unless required by applicable law or agreed to in writing, software
 *  distributed under the License is distributed on an "AS IS" BASIS,
 *  WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 *  See the License for the specific language governing permissions and
 *  limitations under the License.
 */

package org.apache.rocketmq.eventbridge.adapter.storage.rocketmq.runtimer;

import com.alibaba.fastjson.JSON;
import com.google.common.collect.Lists;
import com.google.common.collect.Maps;
import com.google.gson.Gson;
import io.openmessaging.KeyValue;
import io.openmessaging.connector.api.data.ConnectRecord;
import io.openmessaging.connector.api.data.RecordOffset;
import io.openmessaging.connector.api.data.RecordPartition;
import io.openmessaging.connector.api.data.Schema;
import io.openmessaging.internal.DefaultKeyValue;
import org.apache.commons.collections.CollectionUtils;
import org.apache.commons.collections.MapUtils;
import org.apache.commons.lang3.StringUtils;
import org.apache.rocketmq.acl.common.AclClientRPCHook;
import org.apache.rocketmq.acl.common.SessionCredentials;
import org.apache.rocketmq.client.AccessChannel;
import org.apache.rocketmq.common.message.MessageExt;
import org.apache.rocketmq.eventbridge.adapter.runtime.boot.listener.EventSubscriber;
import org.apache.rocketmq.eventbridge.adapter.runtime.common.ServiceThread;
import org.apache.rocketmq.eventbridge.adapter.runtime.common.entity.SubscribeRunnerKeys;
import org.apache.rocketmq.eventbridge.adapter.runtime.common.enums.RefreshTypeEnum;
import org.apache.rocketmq.eventbridge.adapter.runtime.config.RuntimeConfigDefine;
import org.apache.rocketmq.eventbridge.adapter.runtime.service.TargetRunnerConfigObserver;
import org.apache.rocketmq.eventbridge.adapter.storage.rocketmq.runtimer.consumer.ClientConfig;
import org.apache.rocketmq.eventbridge.adapter.storage.rocketmq.runtimer.consumer.LitePullConsumer;
import org.apache.rocketmq.eventbridge.adapter.storage.rocketmq.runtimer.consumer.LitePullConsumerImpl;
import org.apache.rocketmq.eventbridge.domain.storage.EventDataRepository;
import org.apache.rocketmq.eventbridge.exception.EventBridgeException;
import org.apache.rocketmq.remoting.RPCHook;
import org.apache.rocketmq.remoting.proxy.SocksProxyConfig;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.DependsOn;
import org.springframework.core.io.support.PropertiesLoaderUtils;
import org.springframework.stereotype.Component;

import javax.annotation.PostConstruct;
import java.nio.charset.StandardCharsets;
import java.time.Duration;
import java.util.*;
import java.util.concurrent.BlockingQueue;
import java.util.concurrent.CompletableFuture;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.CopyOnWriteArrayList;
import java.util.concurrent.LinkedBlockingQueue;
import java.util.stream.Collectors;

/**
 * RocketMQ implement event subscriber
 */
@Component
@DependsOn("flyway")
public class RocketMQEventSubscriber extends EventSubscriber {

    private static final Logger logger = LoggerFactory.getLogger(RocketMQEventSubscriber.class);

    @Autowired
    private EventDataRepository eventDataRepository;

    @Autowired
    private TargetRunnerConfigObserver runnerConfigObserver;

    private final BlockingQueue<MessageExt> messageBuffer = new LinkedBlockingQueue<>(50000);

    private Integer pullTimeOut;
    private Integer pullBatchSize;

    private ClientConfig clientConfig;
    private BridgeConfig bridgeConfig;
    private SessionCredentials sessionCredentials;
    private String socksProxy;
    private Map<String, ConsumeWorker> consumeWorkerMap = new ConcurrentHashMap<>();

    private static final String SEMICOLON = ";";

    private static final String DEFAULT_GROUP_PREFIX = "event-bridge-group";

    public static final String QUEUE_OFFSET = "queueOffset";
    public static final String MSG_ID = "msgId";

    @PostConstruct
    public void initRocketMQEventSubscriber(){
        this.initMqProperties();
        this.initConsumeWorkers();
    }

    @Override
    public void refresh(SubscribeRunnerKeys subscribeRunnerKeys, RefreshTypeEnum refreshTypeEnum) {
        switch (refreshTypeEnum) {
            case ADD:
            case UPDATE:
                putConsumeWorker(subscribeRunnerKeys);
                break;
            case DELETE:
                removeConsumeWorker(subscribeRunnerKeys);
                break;
            default:
                break;
        }
    }

    @Override
    public BridgeMetricsManager getMetricsManager() {
        BridgeMetricsManager bridgeMetricsManager = new BridgeMetricsManager(bridgeConfig);
        return bridgeMetricsManager;
    }

    @Override
    public List<ConnectRecord> pull() {
        ArrayList<MessageExt> messages = new ArrayList<>();
        messageBuffer.drainTo(messages, pullBatchSize);
        if (CollectionUtils.isEmpty(messages)) {
            logger.trace("consumer poll message empty.");
            return null;
        }
        List<ConnectRecord> connectRecords = new CopyOnWriteArrayList<>();
        List<CompletableFuture<Void>> completableFutures = Lists.newArrayList();
        messages.forEach(item->{
            CompletableFuture<Void> recordCompletableFuture = CompletableFuture.supplyAsync(()-> convertToSinkRecord(item))
                    .exceptionally((exception) -> {
                        logger.error("execute completable job failed，stackTrace-", exception);
                        return null;
                    })
                    .thenAccept(connectRecords::add);
            completableFutures.add(recordCompletableFuture);
        });

        CompletableFuture.allOf(completableFutures.toArray(new CompletableFuture[messages.size()])).join();

        return connectRecords;
    }

    /**
     * group by runner name batch commit
     * @param connectRecordList
     */
    @Override
    public void commit(List<ConnectRecord> connectRecordList) {
        if(CollectionUtils.isEmpty(connectRecordList)){
            logger.warn("commit event record data empty!");
            return;
        }
        String runnerName = connectRecordList.iterator().next().getExtension(RuntimeConfigDefine.RUNNER_NAME);
        List<String> msgIds = connectRecordList.stream().map(item -> item.getPosition()
                .getPartition().getPartition().get(MSG_ID).toString()).collect(Collectors.toList());
        consumeWorkerMap.get(runnerName).commit(msgIds);
    }

    @Override
    public void close() {
        for (Map.Entry<String, ConsumeWorker> item : consumeWorkerMap.entrySet()) {
            ConsumeWorker consumeWorker =  item.getValue();
            consumeWorker.shutdown();
        }
    }

    /**
     * init rocketmq ref config
     */
    private void initMqProperties() {
        try {
            ClientConfig clientConfig = new ClientConfig();
            Properties properties = PropertiesLoaderUtils.loadAllProperties("runtime.properties");
            String namesrvAddr = properties.getProperty("rocketmq.namesrvAddr");
            String consumerGroup = properties.getProperty("rocketmq.consumerGroup");
            pullTimeOut = Integer.valueOf(properties.getProperty("rocketmq.consumer.pullTimeOut"));
            pullBatchSize = Integer.valueOf(properties.getProperty("rocketmq.consumer.pullBatchSize"));
            String accessChannel = properties.getProperty("rocketmq.accessChannel");
            String namespace = properties.getProperty("rocketmq.namespace");
            String accessKey = properties.getProperty("rocketmq.consumer.accessKey");
            String secretKey = properties.getProperty("rocketmq.consumer.secretKey");
            String socks5UserName = properties.getProperty("rocketmq.consumer.socks5UserName");
            String socks5Password = properties.getProperty("rocketmq.consumer.socks5Password");
            String socks5Endpoint = properties.getProperty("rocketmq.consumer.socks5Endpoint");

            clientConfig.setNameSrvAddr(namesrvAddr);
            clientConfig.setAccessChannel(AccessChannel.CLOUD.name().equals(accessChannel) ?
                    AccessChannel.CLOUD : AccessChannel.LOCAL);
            clientConfig.setNamespace(namespace);
            this.clientConfig = clientConfig;

            if (StringUtils.isNotBlank(accessKey) && StringUtils.isNotBlank(secretKey)) {
                this.sessionCredentials = new SessionCredentials(accessKey, secretKey);
            }

            if (StringUtils.isNotBlank(socks5UserName) && StringUtils.isNotBlank(socks5Password)
                    && StringUtils.isNotBlank(socks5Endpoint)) {
                SocksProxyConfig proxyConfig = new SocksProxyConfig();
                proxyConfig.setUsername(socks5UserName);
                proxyConfig.setPassword(socks5Password);
                proxyConfig.setAddr(socks5Endpoint);
                Map<String, SocksProxyConfig> proxyConfigMap = Maps.newHashMap();
                proxyConfigMap.put("0.0.0.0/0", proxyConfig);
                this.socksProxy = new Gson().toJson(proxyConfigMap);
            }

        }catch (Exception exception){
            logger.error("init rocket mq property exception, stack trace-", exception);
        }
    }

    /**
     * init rocket mq pull consumer
     */
    private void initConsumeWorkers() {
        Set<SubscribeRunnerKeys> subscribeRunnerKeysSet =  runnerConfigObserver.getSubscribeRunnerKeys();
        if(subscribeRunnerKeysSet == null || subscribeRunnerKeysSet.isEmpty()){
            return;
        }
        for (SubscribeRunnerKeys subscribeRunnerKeys : subscribeRunnerKeysSet) {
            LitePullConsumer litePullConsumer = initLitePullConsumer(subscribeRunnerKeys);
            ConsumeWorker consumeWorker = new ConsumeWorker(litePullConsumer, subscribeRunnerKeys.getRunnerName());
            consumeWorkerMap.put(subscribeRunnerKeys.getRunnerName(), consumeWorker);
            consumeWorker.start();
        }
    }

    /**
     * first init default rocketmq pull consumer
     * @return
     */
    public LitePullConsumer initLitePullConsumer(SubscribeRunnerKeys subscribeRunnerKeys) {
        String topic = getTopicName(subscribeRunnerKeys);
        RPCHook rpcHook = this.sessionCredentials != null ? new AclClientRPCHook(this.sessionCredentials) : null;
        ClientConfig consumerConfig = ClientConfig.cloneConfig(this.clientConfig);
        String groupName = createGroupName(subscribeRunnerKeys);
        consumerConfig.setConsumerGroup(groupName);
        LitePullConsumerImpl pullConsumer = new LitePullConsumerImpl(consumerConfig, rpcHook);
        if (StringUtils.isNotBlank(this.socksProxy)) {
            pullConsumer.setSockProxyJson(this.socksProxy);
        }
        try {
            pullConsumer.attachTopic(topic, "*");
            pullConsumer.startup();
        } catch (Exception exception) {
            logger.error("init default pull consumer exception, topic -" + topic + "-stackTrace-", exception);
            throw new EventBridgeException(" init rocketmq consumer failed");
        }
        return pullConsumer;
    }

    private String getTopicName(SubscribeRunnerKeys subscribeRunnerKeys) {
        return eventDataRepository.getTopicNameWithOutCache(subscribeRunnerKeys.getAccountId(), subscribeRunnerKeys.getEventBusName());
    }

    private String createGroupName(SubscribeRunnerKeys subscribeRunnerKeys) {
        StringBuilder sb = new StringBuilder();
        sb.append(DEFAULT_GROUP_PREFIX).append("-");
        sb.append(subscribeRunnerKeys.getAccountId()).append("-");
        sb.append(subscribeRunnerKeys.getRunnerName());
        return sb.toString().replace(".", "-");
    }

    /**
     * MessageExt convert to connect record
     * @param messageExt
     * @return
     */
    private ConnectRecord convertToSinkRecord(MessageExt messageExt) {
        Map<String, String> properties = messageExt.getProperties();
        Schema schema;
        Long timestamp;
        ConnectRecord sinkRecord;
        String connectTimestamp = properties.get(RuntimeConfigDefine.CONNECT_TIMESTAMP);
        timestamp = StringUtils.isNotEmpty(connectTimestamp) ? Long.valueOf(connectTimestamp) : null;
        String connectSchema = properties.get(RuntimeConfigDefine.CONNECT_SCHEMA);
        schema = StringUtils.isNotEmpty(connectSchema) ? JSON.parseObject(connectSchema, Schema.class) : null;
        byte[] body = messageExt.getBody();
        RecordPartition recordPartition = convertToRecordPartition(messageExt.getTopic(), messageExt.getBrokerName(), messageExt.getQueueId(), messageExt.getMsgId());
        RecordOffset recordOffset = convertToRecordOffset(messageExt.getQueueOffset());
        String bodyStr = new String(body, StandardCharsets.UTF_8);
        sinkRecord = new ConnectRecord(recordPartition, recordOffset, timestamp, schema, bodyStr);
        KeyValue keyValue = new DefaultKeyValue();
        if (MapUtils.isNotEmpty(properties)) {
            for (Map.Entry<String, String> entry : properties.entrySet()) {
                keyValue.put(entry.getKey(), entry.getValue());
            }
        }
        sinkRecord.addExtension(keyValue);
        return sinkRecord;
    }

    private RecordPartition convertToRecordPartition(String topic, String brokerName, int queueId, String msgId) {
        Map<String, String> map = new HashMap<>();
        map.put("topic", topic);
        map.put("brokerName", brokerName);
        map.put("queueId", queueId + "");
        map.put(MSG_ID, msgId);
        RecordPartition recordPartition = new RecordPartition(map);
        return recordPartition;
    }

    private RecordOffset convertToRecordOffset(Long offset) {
        Map<String, String> offsetMap = new HashMap<>();
        offsetMap.put(QUEUE_OFFSET, offset + "");
        RecordOffset recordOffset = new RecordOffset(offsetMap);
        return recordOffset;
    }

    private void putConsumeWorker(SubscribeRunnerKeys subscribeRunnerKeys) {
        ConsumeWorker consumeWorker = consumeWorkerMap.get(subscribeRunnerKeys.getRunnerName());
        if (!Objects.isNull(consumeWorker)){
            consumeWorker.shutdown();
        }
        LitePullConsumer litePullConsumer = initLitePullConsumer(subscribeRunnerKeys);
        ConsumeWorker newWorker = new ConsumeWorker(litePullConsumer, subscribeRunnerKeys.getRunnerName());
        consumeWorkerMap.put(subscribeRunnerKeys.getRunnerName(), newWorker);
        newWorker.start();
    }

    private void removeConsumeWorker(SubscribeRunnerKeys subscribeRunnerKeys) {
        ConsumeWorker consumeWorker = consumeWorkerMap.remove(subscribeRunnerKeys.getRunnerName());
        if (!Objects.isNull(consumeWorker)){
            consumeWorker.shutdown();
        }
    }

    class ConsumeWorker extends ServiceThread {

        private final LitePullConsumer pullConsumer;
        private final String runnerName;

        public ConsumeWorker(LitePullConsumer pullConsumer, String runnerName) {
            this.pullConsumer = pullConsumer;
            this.runnerName = runnerName;
        }

        @Override
        public String getServiceName() {
            return ConsumeWorker.class.getSimpleName();
        }

        @Override
        public void run() {
            while (!stopped) {
                try {
                    List<MessageExt> messages = pullConsumer.poll(pullBatchSize, Duration.ofSeconds(pullTimeOut));
                    for (MessageExt message : messages) {
                        message.putUserProperty(RuntimeConfigDefine.RUNNER_NAME, runnerName);
                        messageBuffer.put(message);
                    }
                } catch (Exception exception) {
                    logger.error(getServiceName() + " - RocketMQEventSubscriber pull record exception, stackTrace - ", exception);
                }
            }
        }

        public void commit(List<String> messageIds){
            this.pullConsumer.commit(messageIds);
        }

        @Override
        public void shutdown() {
            pullConsumer.shutdown();
            super.shutdown();
        }
    }

}