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

import com.google.common.base.Splitter;
import com.google.common.collect.Lists;
import com.google.common.collect.Sets;
import io.openmessaging.connector.api.data.ConnectRecord;
import io.openmessaging.connector.api.data.RecordOffset;
import io.openmessaging.connector.api.data.RecordPartition;
import org.apache.commons.collections.CollectionUtils;
import org.apache.commons.lang3.StringUtils;
import org.apache.rocketmq.client.consumer.DefaultLitePullConsumer;
import org.apache.rocketmq.common.message.MessageExt;
import org.apache.rocketmq.common.message.MessageQueue;
import org.apache.rocketmq.eventbridge.adapter.runtimer.common.entity.PusherTargetEntity;
import org.apache.rocketmq.eventbridge.adapter.runtimer.common.entity.TargetKeyValue;
import org.apache.rocketmq.eventbridge.adapter.runtimer.common.LoggerName;
import org.apache.rocketmq.eventbridge.adapter.runtimer.config.RuntimeConfigDefine;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

import java.util.*;
import java.util.concurrent.BlockingQueue;
import java.util.concurrent.LinkedBlockingQueue;

@Component
public class ListenerFactory {

    private final static Logger logger = LoggerFactory.getLogger(LoggerName.EventBus_Listener);

    private static final String SEMICOLON = ";";

    private static final String SYS_DEFAULT_GROUP = "default-%s-group";

    public static final String QUEUE_OFFSET = "queueOffset";

    private BlockingQueue<PusherTargetEntity> pusherTargetQueue = new LinkedBlockingQueue<>(1000);

    private BlockingQueue<MessageExt> eventMessage = new LinkedBlockingQueue(50000);

    private BlockingQueue<Map<TargetKeyValue, ConnectRecord>> targetQueue = new LinkedBlockingQueue<>(50000);

    @Value("${rocketmq.namesrvAddr:}")
    private String namesrvAddr;

    public DefaultLitePullConsumer initDefaultMQPullConsumer(String topic) {
        DefaultLitePullConsumer consumer = new DefaultLitePullConsumer();
        try {
            consumer.setConsumerGroup(String.format(SYS_DEFAULT_GROUP, topic));
            consumer.setNamesrvAddr(namesrvAddr);
            consumer.subscribe(topic, "*");
            consumer.start();
        }catch (Exception exception){
            logger.error("init default pull consumer exception, topic -" + topic + "-stackTrace-", exception);
        }
        return consumer;
    }

    public PusherTargetEntity takeTaskConfig(){
        if(pusherTargetQueue.isEmpty()){
            return null;
        }
        try {
            return pusherTargetQueue.take();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        return null;
    }

    /**
     * Offer listener event
     * @param messageExt
     * @return
     */
    public boolean offerListenEvent(MessageExt messageExt){
        return eventMessage.offer(messageExt);
    }

    public MessageExt takeListenerEvent() {
        if(eventMessage.isEmpty()){
            return null;
        }
        try {
            return eventMessage.take();
        }catch (Exception exception){
            exception.printStackTrace();
        }
        return null;
    }

    public String createInstance(String servers) {
        String[] serversArray = servers.split(";");
        List<String> serversList = new ArrayList<String>();
        for (String server : serversArray) {
            if (!serversList.contains(server)) {
                serversList.add(server);
            }
        }
        Collections.sort(serversList);
        return String.valueOf(serversList.toString().hashCode());
    }

    /**
     * parse topic list by task config
     * @param taskConfig
     * @return
     */
    public List<String> parseTopicList(TargetKeyValue taskConfig) {
        String messageQueueStr = taskConfig.getString(RuntimeConfigDefine.CONNECT_TOPICNAME);
        if (StringUtils.isBlank(messageQueueStr)) {
            return null;
        }
        List<String> topicList = Splitter.on(SEMICOLON).omitEmptyStrings().trimResults().splitToList(messageQueueStr);
        return Lists.newArrayList(new HashSet<>(topicList));
    }

    /**
     * parse topic list by task config list
     * @param taskConfigs
     * @return
     */
    public List<String> parseTopicListByList(List<TargetKeyValue> taskConfigs) {
        Set<String> allTopicList = Sets.newHashSet();
        for(TargetKeyValue taskConfig : taskConfigs){
            String messageQueueStr = taskConfig.getString(RuntimeConfigDefine.CONNECT_TOPICNAME);
            if (StringUtils.isBlank(messageQueueStr)) {
                continue;
            }
            List<String> topicList = Splitter.on(SEMICOLON).omitEmptyStrings().trimResults().splitToList(messageQueueStr);
            allTopicList.addAll(topicList);
        }
        return Lists.newArrayList(allTopicList);
    }

    /**
     * parse msg queue by queue json
     * @param messageQueueStr
     * @return
     */
    public MessageQueue parseMessageQueueList(String messageQueueStr) {
        List<String> messageQueueStrList = Splitter.on(SEMICOLON).omitEmptyStrings().trimResults().splitToList(messageQueueStr);
        if (CollectionUtils.isEmpty(messageQueueStrList) || messageQueueStrList.size() != 3) {
            return null;
        }
        return new MessageQueue(messageQueueStrList.get(0), messageQueueStrList.get(1), Integer.valueOf(messageQueueStrList.get(2)));
    }

    public RecordPartition convertToRecordPartition(String topic, String brokerName, int queueId) {
        Map<String, String> map = new HashMap<>();
        map.put("topic", topic);
        map.put("brokerName", brokerName);
        map.put("queueId", queueId + "");
        RecordPartition recordPartition = new RecordPartition(map);
        return recordPartition;
    }

    public RecordOffset convertToRecordOffset(Long offset) {
        Map<String, String> offsetMap = new HashMap<>();
        offsetMap.put(QUEUE_OFFSET, offset + "");
        RecordOffset recordOffset = new RecordOffset(offsetMap);
        return recordOffset;
    }

    public boolean offerTargetTaskQueue(Map<TargetKeyValue, ConnectRecord> targetMap){
        return targetQueue.offer(targetMap);
    }

    public Map<TargetKeyValue, ConnectRecord> takeTargetMap(){
        if(targetQueue.isEmpty()){
            return null;
        }
        try{
            return targetQueue.take();
        }catch (Exception exception){
            exception.printStackTrace();
        }
        return null;
    }
}
