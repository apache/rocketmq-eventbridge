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

package org.apache.rocketmq.eventbridge.adapter.runtimer.boot;

import com.alibaba.fastjson.JSON;
import com.google.common.collect.Lists;
import io.openmessaging.KeyValue;
import io.openmessaging.connector.api.data.ConnectRecord;
import io.openmessaging.connector.api.data.RecordOffset;
import io.openmessaging.connector.api.data.RecordPartition;
import io.openmessaging.connector.api.data.Schema;
import io.openmessaging.internal.DefaultKeyValue;
import org.apache.commons.collections.MapUtils;
import org.apache.commons.lang3.StringUtils;
import org.apache.rocketmq.client.consumer.DefaultLitePullConsumer;
import org.apache.rocketmq.common.message.MessageExt;
import org.apache.rocketmq.common.message.MessageQueue;
import org.apache.rocketmq.eventbridge.adapter.runtimer.boot.listener.ListenerFactory;
import org.apache.rocketmq.eventbridge.adapter.runtimer.common.entity.PusherTargetEntity;
import org.apache.rocketmq.eventbridge.adapter.runtimer.common.entity.TargetKeyValue;
import org.apache.rocketmq.eventbridge.adapter.runtimer.common.QueueState;
import org.apache.rocketmq.eventbridge.adapter.runtimer.common.ServiceThread;
import org.apache.rocketmq.eventbridge.adapter.runtimer.config.RuntimerConfigDefine;
import org.apache.rocketmq.eventbridge.adapter.runtimer.service.PusherConfigManageService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.util.CollectionUtils;

import java.nio.charset.StandardCharsets;
import java.util.*;
import java.util.concurrent.*;

/**
 * listen the event and offer to queue
 * @author artisan
 */
public class EventBusListener extends ServiceThread {

    private Logger logger = LoggerFactory.getLogger(EventBusListener.class);

    private final ConcurrentHashMap<MessageQueue, Long> messageQueuesOffsetMap;

    private final ConcurrentHashMap<MessageQueue, QueueState> messageQueuesStateMap;

    private List<String> topics = new CopyOnWriteArrayList<>();

    private List<DefaultLitePullConsumer> listenConsumer = new CopyOnWriteArrayList<>();

    private ListenerFactory listenerFactory;

    private PusherConfigManageService pusherConfigManageService;

    private ExecutorService executorService = new ThreadPoolExecutor(20,60, 1000,TimeUnit.MICROSECONDS, new LinkedBlockingDeque<>(100));

    private BlockingQueue<MessageExt> eventMessage = new LinkedBlockingQueue(50000);

    public EventBusListener(ListenerFactory listenerFactory, PusherConfigManageService pusherConfigManageService){
        this.messageQueuesOffsetMap = new ConcurrentHashMap<>(256);
        this.messageQueuesStateMap = new ConcurrentHashMap<>(256);
        this.listenerFactory = listenerFactory;
        this.pusherConfigManageService = pusherConfigManageService;
        this.pusherConfigManageService.registerListener(new ConsumerUpdateListenerImpl());
    }

    /**
     * init listen consumer
     * @param taskConfig
     */
    public void initOrUpdateListenConsumer(Map<String, List<TargetKeyValue>> taskConfig){
        if(MapUtils.isEmpty(taskConfig)){
            logger.warn("initListenConsumer by taskConfig param is empty");
            return;
        }
        List<TargetKeyValue> targetKeyValues = initTaskKeyInfo(taskConfig);
        this.topics.addAll(listenerFactory.parseTopicListByList(targetKeyValues));
        for (String topic : topics){
            DefaultLitePullConsumer pullConsumer = listenerFactory.initDefaultMQPullConsumer(topic);
            listenConsumer.add(pullConsumer);
        }
        logger.info("init or update consumer succeed , consumer is - {}", JSON.toJSONString(listenConsumer));
    }

    /**
     * init all task config info
     * @param taskConfig
     * @return
     */
    private List<TargetKeyValue> initTaskKeyInfo(Map<String, List<TargetKeyValue>> taskConfig) {
        Set<TargetKeyValue> targetKeyValues = new HashSet<>();
        for(String connectName : taskConfig.keySet()){
            targetKeyValues.addAll(taskConfig.get(connectName));
        }
        return Lists.newArrayList(targetKeyValues);
    }

    @Override
    public void run() {
        while (!stopped){
            if(CollectionUtils.isEmpty(listenConsumer)){
                logger.info("current listen consumer is empty");
                this.waitForRunning(1000);
                continue;
            }
            for(DefaultLitePullConsumer pullConsumer : listenConsumer) {
                executorService.submit(() -> {
                    try {
                        List<MessageExt> messageExts = pullConsumer.poll(3000);
                        if (CollectionUtils.isEmpty(messageExts)) {
                            logger.info("consumer poll message empty , consumer - {}", JSON.toJSONString(pullConsumer));
                            return;
                        }
                        for (MessageExt messageExt : messageExts) {
                            ConnectRecord eventRecord = convertToSinkRecord(messageExt);
                            listenerFactory.offerEventRecord(eventRecord);
                            logger.debug("consumer - {} - offer listen event record -  {} - by - message event- {}", JSON.toJSONString(pullConsumer), eventRecord, messageExt);
                        }
                    } finally {
                        pullConsumer.commitSync();
                    }
                });
            }
        }
    }

    @Override
    public String getServiceName() {
        return this.getClass().getSimpleName();
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
        RecordPartition recordPartition = listenerFactory.convertToRecordPartition(messageExt.getTopic(), messageExt.getBrokerName(), messageExt.getQueueId());
        RecordOffset recordOffset = listenerFactory.convertToRecordOffset(messageExt.getQueueOffset());
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

    /**
     * consumer update listener
     */
    class ConsumerUpdateListenerImpl implements PusherConfigManageService.TargetConfigUpdateListener {

        @Override
        public void onConfigUpdate(PusherTargetEntity targetEntity) {
            logger.info("consumer update by new target config changed, target info -{}", JSON.toJSONString(targetEntity));
            Map<String, List<TargetKeyValue>> lastTargetMap = new HashMap<>();
            lastTargetMap.put(targetEntity.getConnectName(), targetEntity.getTargetKeyValues());
            initOrUpdateListenConsumer(lastTargetMap);
        }
    }
}
