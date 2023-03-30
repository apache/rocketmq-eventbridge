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
import com.google.common.collect.Sets;
import io.openmessaging.KeyValue;
import io.openmessaging.connector.api.data.ConnectRecord;
import io.openmessaging.connector.api.data.RecordOffset;
import io.openmessaging.connector.api.data.RecordPartition;
import io.openmessaging.connector.api.data.Schema;
import io.openmessaging.internal.DefaultKeyValue;
import org.apache.commons.collections.MapUtils;
import org.apache.commons.lang3.StringUtils;
import org.apache.rocketmq.client.consumer.DefaultLitePullConsumer;
import org.apache.rocketmq.client.exception.MQClientException;
import org.apache.rocketmq.common.message.MessageExt;
import org.apache.rocketmq.eventbridge.adapter.runtimer.common.entity.TargetRunnerConfig;
import org.apache.rocketmq.eventbridge.adapter.runtimer.common.enums.RefreshTypeEnum;
import org.apache.rocketmq.eventbridge.adapter.runtimer.config.RuntimerConfigDefine;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.util.CollectionUtils;

import java.nio.charset.StandardCharsets;
import java.util.List;
import java.util.Map;
import java.util.Objects;
import java.util.Set;

/**
 * RocketMQ implement event subscriber
 */
public class RocketMQEventSubscriber extends EventSubscriber {

    private static final Logger logger = LoggerFactory.getLogger(RocketMQEventSubscriber.class);

    private ListenerFactory listenerFactory;

    private DefaultLitePullConsumer pullConsumer;

    private Integer DEFAULT_PULL_TIME_OUT = 3000;

    public RocketMQEventSubscriber(ListenerFactory listenerFactory) {
        this.listenerFactory = listenerFactory;
        this.initPullConsumer();
    }

    @Override
    public void refresh(TargetRunnerConfig targetRunnerConfig, RefreshTypeEnum refreshTypeEnum) {
        if(Objects.isNull(pullConsumer)){
            pullConsumer = listenerFactory.initDefaultMQPullConsumer();
            return;
        }
        Set<String> currentTopics = listenerFactory.parseTopicsByRunnerConfigs(Sets.newHashSet(targetRunnerConfig));
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
        List<MessageExt> messageExts = pullConsumer.poll(DEFAULT_PULL_TIME_OUT);
        if (CollectionUtils.isEmpty(messageExts)) {
            logger.info("consumer poll message empty , consumer - {}", JSON.toJSONString(pullConsumer));
            return null;
        }
        List<ConnectRecord> connectRecords = Lists.newArrayList();
        for (MessageExt messageExt : messageExts) {
            ConnectRecord eventRecord = convertToSinkRecord(messageExt);
            connectRecords.add(eventRecord);
            if(logger.isDebugEnabled()){
                logger.debug("offer listen event record -  {} - by message event- {}", eventRecord, messageExt);
            }
        }
        return connectRecords;
    }

    @Override
    public void commit(List<ConnectRecord> connectRecordList) {

    }

    /**
     * init rocket mq pull consumer
     */
    private void initPullConsumer() {
        pullConsumer = listenerFactory.initDefaultMQPullConsumer();
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
     * new topic for subscribe
     * @param topic
     */
    private void subscribe(String topic) {
        try {
            pullConsumer.subscribe(topic, "*");
        } catch (MQClientException exception) {
            logger.error("rocketmq event subscribe new topic failed, stack trace - ", exception);
        }
    }

    /**
     * unsubscribe old topic
     * @param topic
     */
    private void unSubscribe(String topic) {
        pullConsumer.unsubscribe(topic);
    }



}