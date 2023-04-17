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

package org.apache.rocketmq.eventbridge.adapter.runtimer.boot.listener;

import com.alibaba.fastjson.JSON;
import com.google.common.collect.Lists;
import com.google.common.collect.Maps;
import com.google.common.collect.Sets;
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
import org.apache.rocketmq.common.UtilAll;
import org.apache.rocketmq.common.message.MessageExt;
import org.apache.rocketmq.common.utils.NetworkUtil;
import org.apache.rocketmq.eventbridge.adapter.runtimer.boot.listener.consumer.ClientConfig;
import org.apache.rocketmq.eventbridge.adapter.runtimer.boot.listener.consumer.LitePullConsumer;
import org.apache.rocketmq.eventbridge.adapter.runtimer.boot.listener.consumer.LitePullConsumerImpl;
import org.apache.rocketmq.eventbridge.adapter.runtimer.common.entity.TargetRunnerConfig;
import org.apache.rocketmq.eventbridge.adapter.runtimer.common.enums.RefreshTypeEnum;
import org.apache.rocketmq.eventbridge.adapter.runtimer.config.RuntimerConfigDefine;
import org.apache.rocketmq.eventbridge.adapter.runtimer.service.TargetRunnerConfigObserver;
import org.apache.rocketmq.eventbridge.exception.EventBridgeException;
import org.apache.rocketmq.remoting.RPCHook;
import org.apache.rocketmq.remoting.proxy.SocksProxyConfig;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.core.io.support.PropertiesLoaderUtils;

import java.nio.charset.StandardCharsets;
import java.time.Duration;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Objects;
import java.util.Properties;
import java.util.Set;
import java.util.concurrent.CompletableFuture;

/**
 * RocketMQ implement event subscriber
 */
public class RocketMQEventSubscriber extends EventSubscriber {

    private static final Logger logger = LoggerFactory.getLogger(RocketMQEventSubscriber.class);

    private LitePullConsumer pullConsumer;

    private final TargetRunnerConfigObserver runnerConfigObserver;

    private Integer pullTimeOut;
    private Integer pullBatchSize;

    private ClientConfig clientConfig;
    private SessionCredentials sessionCredentials;
    private String socksProxy;

    private static final String SEMICOLON = ";";

    private static final String SYS_DEFAULT_GROUP = "event-bridge-default-group";

    public static final String QUEUE_OFFSET = "queueOffset";

    public RocketMQEventSubscriber(TargetRunnerConfigObserver runnerConfigObserver) {
        this.runnerConfigObserver = runnerConfigObserver;
        this.initMqProperties();
        this.initPullConsumer();
    }

    @Override
    public void refresh(TargetRunnerConfig targetRunnerConfig, RefreshTypeEnum refreshTypeEnum) {
        if(Objects.isNull(pullConsumer)){
            pullConsumer = initLitePullConsumer();
            return;
        }
        Set<String> currentTopics = parseTopicsByRunnerConfigs(Sets.newHashSet(targetRunnerConfig));
        for (String topic : currentTopics){
            switch (refreshTypeEnum){
                case ADD:
                case UPDATE:
                        subscribe(topic);
                        break;
                case DELETE:
                        unSubscribe(topic);
                        break;
                default:
                    break;
            }
        }
    }

    @Override
    public List<ConnectRecord> pull() {
        List<MessageExt> messages = pullConsumer.poll(pullBatchSize, Duration.ofSeconds(pullTimeOut));
        if (CollectionUtils.isEmpty(messages)) {
            logger.info("consumer poll message empty , consumer - {}", JSON.toJSONString(pullConsumer));
            return null;
        }
        List<ConnectRecord> connectRecords = Lists.newArrayList();
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

    @Override
    public void commit(List<ConnectRecord> connectRecordList) {
        // TODO
    }

    /**
     * parse topics by specific target runner configs
     * @param targetRunnerConfigs
     * @return
     */
    public Set<String> parseTopicsByRunnerConfigs(Set<TargetRunnerConfig> targetRunnerConfigs){
        if(CollectionUtils.isEmpty(targetRunnerConfigs)){
            logger.warn("target runner config is empty, parse to topic failed!");
            return null;
        }
        Set<String> listenTopics = Sets.newHashSet();
        for(TargetRunnerConfig runnerConfig : targetRunnerConfigs){
            List<Map<String,String>> runnerConfigMap = runnerConfig.getComponents();
            if(CollectionUtils.isEmpty(runnerConfigMap)){
                logger.warn("target runner config components is empty, config info - {}", runnerConfig);
                continue;
            }
            listenTopics.add(runnerConfigMap.iterator().next().get(RuntimerConfigDefine.CONNECT_TOPICNAME));
        }
        return listenTopics;
    }

    /**
     * init rocketmq ref config
     */
    private void initMqProperties() {
        try {
            ClientConfig clientConfig = new ClientConfig();
            Properties properties = PropertiesLoaderUtils.loadAllProperties("runtimer.properties");
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
            clientConfig.setConsumerGroup(StringUtils.isBlank(consumerGroup) ?
                    createGroupName(SYS_DEFAULT_GROUP) : consumerGroup);
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
    private void initPullConsumer() {
        pullConsumer = initLitePullConsumer();
    }

    /**
     * first init default rocketmq pull consumer
     * @return
     */
    public LitePullConsumer initLitePullConsumer() {
        if (pullConsumer != null) {
            try {
                pullConsumer.shutdown();
            } catch (Exception e) {
                logger.error("Consumer shutdown failed.", e);
            }
        }

        Set<TargetRunnerConfig> targetRunnerConfigs = runnerConfigObserver.getTargetRunnerConfig();
        Set<String> topics = parseTopicsByRunnerConfigs(targetRunnerConfigs);

        RPCHook rpcHook = this.sessionCredentials != null ? new AclClientRPCHook(this.sessionCredentials) : null;
        this.pullConsumer = new LitePullConsumerImpl(this.clientConfig, rpcHook);
        if (StringUtils.isNotBlank(this.socksProxy)) {
            pullConsumer.setSockProxyJson(this.socksProxy);
        }
        try {
            for(String topic : topics){
                pullConsumer.attachTopic(topic, "*");
            }
            pullConsumer.startup();
        } catch (Exception exception) {
            logger.error("init default pull consumer exception, topic -" + topics.toString() + "-stackTrace-", exception);
            throw new EventBridgeException(" init rocketmq consumer failed");
        }
        return pullConsumer;
    }

    private String createGroupName(String prefix) {
        StringBuilder sb = new StringBuilder();
        sb.append(prefix).append("-");
        sb.append(NetworkUtil.getLocalAddress()).append("-");
        sb.append(UtilAll.getPid()).append("-");
        sb.append(System.nanoTime());
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
        String connectTimestamp = properties.get(RuntimerConfigDefine.CONNECT_TIMESTAMP);
        timestamp = StringUtils.isNotEmpty(connectTimestamp) ? Long.valueOf(connectTimestamp) : null;
        String connectSchema = properties.get(RuntimerConfigDefine.CONNECT_SCHEMA);
        schema = StringUtils.isNotEmpty(connectSchema) ? JSON.parseObject(connectSchema, Schema.class) : null;
        byte[] body = messageExt.getBody();
        RecordPartition recordPartition = convertToRecordPartition(messageExt.getTopic(), messageExt.getBrokerName(), messageExt.getQueueId());
        RecordOffset recordOffset = convertToRecordOffset(messageExt.getQueueOffset());
        String bodyStr = new String(body, StandardCharsets.UTF_8);
        sinkRecord = new ConnectRecord(recordPartition, recordOffset, timestamp, schema, bodyStr);
        KeyValue keyValue = new DefaultKeyValue();
        keyValue.put(RuntimerConfigDefine.CONNECT_TOPICNAME, messageExt.getTopic());
        if (MapUtils.isNotEmpty(properties)) {
            for (Map.Entry<String, String> entry : properties.entrySet()) {
                keyValue.put(entry.getKey(), entry.getValue());
            }
        }
        sinkRecord.addExtension(keyValue);
        return sinkRecord;
    }

    private RecordPartition convertToRecordPartition(String topic, String brokerName, int queueId) {
        Map<String, String> map = new HashMap<>();
        map.put("topic", topic);
        map.put("brokerName", brokerName);
        map.put("queueId", queueId + "");
        RecordPartition recordPartition = new RecordPartition(map);
        return recordPartition;
    }

    private RecordOffset convertToRecordOffset(Long offset) {
        Map<String, String> offsetMap = new HashMap<>();
        offsetMap.put(QUEUE_OFFSET, offset + "");
        RecordOffset recordOffset = new RecordOffset(offsetMap);
        return recordOffset;
    }

    /**
     * new topic for subscribe
     * @param topic
     */
    private void subscribe(String topic) {
        pullConsumer.subscribe(topic);
    }

    /**
     * unsubscribe old topic
     * @param topic
     */
    private void unSubscribe(String topic) {
        pullConsumer.unsubscribe(topic);
    }

}