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
import com.google.common.base.Splitter;
import com.google.common.collect.Lists;
import com.google.common.collect.Sets;
import io.openmessaging.connector.api.component.task.sink.SinkTask;
import io.openmessaging.connector.api.data.ConnectRecord;
import io.openmessaging.connector.api.data.RecordOffset;
import io.openmessaging.connector.api.data.RecordPartition;
import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.concurrent.BlockingQueue;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.LinkedBlockingQueue;
import java.util.stream.Collectors;

import org.apache.commons.collections.CollectionUtils;
import org.apache.commons.lang3.StringUtils;
import org.apache.rocketmq.client.consumer.DefaultLitePullConsumer;
import org.apache.rocketmq.common.UtilAll;
import org.apache.rocketmq.common.message.MessageExt;
import org.apache.rocketmq.common.message.MessageQueue;
import org.apache.rocketmq.eventbridge.adapter.runtimer.boot.transfer.TransformEngine;
import org.apache.rocketmq.eventbridge.adapter.runtimer.common.LoggerName;
import org.apache.rocketmq.eventbridge.adapter.runtimer.common.entity.TargetKeyValue;
import org.apache.rocketmq.eventbridge.adapter.runtimer.common.entity.TargetRunnerConfig;
import org.apache.rocketmq.eventbridge.adapter.runtimer.common.plugin.Plugin;
import org.apache.rocketmq.eventbridge.adapter.runtimer.config.RuntimerConfigDefine;
import org.apache.rocketmq.eventbridge.exception.EventBridgeException;
import org.apache.rocketmq.remoting.common.RemotingUtil;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

@Component
public class ListenerFactory implements TargetRunnerListener {

    private final static Logger logger = LoggerFactory.getLogger(LoggerName.EventBus_Listener);

    private static final String SEMICOLON = ";";

    private static final String SYS_DEFAULT_GROUP = "event-bridge-default-group";

    public static final String QUEUE_OFFSET = "queueOffset";

    private Plugin plugin;

    private BlockingQueue<TargetRunnerConfig> pusherTargetQueue = new LinkedBlockingQueue<>(1000);

    private BlockingQueue<MessageExt> eventMessage = new LinkedBlockingQueue(50000);

    private BlockingQueue<ConnectRecord> eventRecord = new LinkedBlockingQueue<>(50000);

    private BlockingQueue<ConnectRecord> targetQueue = new LinkedBlockingQueue<>(50000);

    private Map<String/*TargetRunnerName*/, TransformEngine<ConnectRecord>> taskTransformMap = new ConcurrentHashMap<>(20);

    private Map<String/*TargetRunnerName*/, SinkTask> pusherTaskMap = new ConcurrentHashMap<>(20);

    private Map<String/*TargetRunnerName*/, TargetRunnerConfig> targetRunnerConfigMap = new ConcurrentHashMap<>(20);

    @Value("${rocketmq.namesrvAddr:}")
    private String namesrvAddr;

    /**
     * first init default rocketmq pull consumer
     * @param topics
     * @return
     */
    public DefaultLitePullConsumer initDefaultMQPullConsumer(Set<String> topics) {
        DefaultLitePullConsumer consumer = new DefaultLitePullConsumer();
        consumer.setConsumerGroup(SYS_DEFAULT_GROUP);
        consumer.setNamesrvAddr(namesrvAddr);
        try {
            for(String topic : topics){
                consumer.subscribe(topic, "*");
            }
            consumer.start();
        } catch (Exception exception) {
            logger.error("init default pull consumer exception, topic -" + topics.toString() + "-stackTrace-", exception);
            throw new EventBridgeException(" init rocketmq consumer failed");
        }
        return consumer;
    }

    public static String createGroupName(String prefix) {
        StringBuilder sb = new StringBuilder();
        sb.append(prefix).append("-");
        sb.append(RemotingUtil.getLocalAddress()).append("-");
        sb.append(UtilAll.getPid()).append("-");
        sb.append(System.nanoTime());
        return sb.toString().replace(".", "-");
    }

    public TargetRunnerConfig takeTaskConfig() {
        if (pusherTargetQueue.isEmpty()) {
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
     *
     * @param messageExt
     * @return
     */
    public boolean offerListenEvent(MessageExt messageExt) {
        return eventMessage.offer(messageExt);
    }

    public MessageExt takeListenerEvent() {
        if (eventMessage.isEmpty()) {
            return null;
        }
        try {
            return eventMessage.take();
        } catch (Exception exception) {
            exception.printStackTrace();
        }
        return null;
    }

    /**
     * offer event records
     *
     * @param connectRecords
     */
   public boolean  offerEventRecords(List<ConnectRecord> connectRecords) {
        return eventRecord.addAll(connectRecords);
    }

    /**
     * take event record
     *
     * @return
     */
    public ConnectRecord takeEventRecord() {
        if (eventRecord.isEmpty()) {
            return null;
        }
        try {
            return eventRecord.take();
        } catch (Exception exception) {
            logger.error("take event record exception - stack-> ", exception);
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
     *
     * @param taskConfig
     * @return
     */
    public List<String> parseTopicList(TargetKeyValue taskConfig) {
        String messageQueueStr = taskConfig.getString(RuntimerConfigDefine.CONNECT_TOPICNAME);
        if (StringUtils.isBlank(messageQueueStr)) {
            return null;
        }
        List<String> topicList = Splitter.on(SEMICOLON).omitEmptyStrings().trimResults().splitToList(messageQueueStr);
        return Lists.newArrayList(new HashSet<>(topicList));
    }

    /**
     * parse topic list by task config list
     *
     * @param taskConfigs
     * @return
     */
    public List<String> parseTopicListByList(List<TargetKeyValue> taskConfigs) {
        Set<String> allTopicList = Sets.newHashSet();
        for (TargetKeyValue taskConfig : taskConfigs) {
            String messageQueueStr = taskConfig.getString(RuntimerConfigDefine.CONNECT_TOPICNAME);
            if (StringUtils.isBlank(messageQueueStr)) {
                continue;
            }
            List<String> topicList = Splitter.on(SEMICOLON).omitEmptyStrings().trimResults().splitToList(messageQueueStr);
            allTopicList.addAll(topicList);
        }
        return Lists.newArrayList(allTopicList);
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
                continue;
            }
            listenTopics.addAll(runnerConfigMap.stream().map(item->item.get(RuntimerConfigDefine.CONNECT_TOPICNAME)).collect(Collectors.toSet()));
        }
        return listenTopics;
    }

    /**
     * parse msg queue by queue json
     *
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

    public boolean offerTargetTaskQueue(ConnectRecord connectRecord) {
        return targetQueue.offer(connectRecord);
    }

    public ConnectRecord takeTargetMap() {
        if (targetQueue.isEmpty()) {
            return null;
        }
        try {
            return targetQueue.take();
        } catch (Exception exception) {
            exception.printStackTrace();
        }
        return null;
    }

    /**
     * Init sink task transform map key: task config value: transformEngine
     *
     * @param taskConfig
     * @return
     */
    private Map<TargetKeyValue, TransformEngine<ConnectRecord>> initSinkTaskTransformInfo(
        Map<String, List<TargetKeyValue>> taskConfig) {
        Map<TargetKeyValue, TransformEngine<ConnectRecord>> curTaskTransformMap = new HashMap<>();
        Set<TargetKeyValue> allTaskKeySet = new HashSet<>();
        for (String connectName : taskConfig.keySet()) {
            List<TargetKeyValue> taskKeyList = taskConfig.get(connectName);
            allTaskKeySet.addAll(new HashSet<>(taskKeyList));
        }
        for (TargetKeyValue keyValue : allTaskKeySet) {
            TransformEngine<ConnectRecord> transformChain = new TransformEngine<>(keyValue, plugin);
            curTaskTransformMap.put(keyValue, transformChain);
        }
        logger.info("init sink task transform info succeed, transform map - {}", JSON.toJSONString(curTaskTransformMap));
        return curTaskTransformMap;
    }


    @Override public void onAddTargetRunner(TargetRunnerConfig targetRunnerConfig) {
        // refresh taskTransformMap & pusherTaskMap & targetRunnerConfigMap
    }

    @Override public void onUpdateTargetRunner(TargetRunnerConfig targetRunnerConfig) {

    }

    @Override public void onDeleteTargetRunner(TargetRunnerConfig targetRunnerConfig) {

    }

    public Map<String, TransformEngine<ConnectRecord>> getTaskTransformMap() {
        return taskTransformMap;
    }

    public Map<String, SinkTask> getPusherTaskMap() {
        return pusherTaskMap;
    }

    public Map<String, TargetRunnerConfig> getTargetRunnerConfigMap() {
        return targetRunnerConfigMap;
    }

}
