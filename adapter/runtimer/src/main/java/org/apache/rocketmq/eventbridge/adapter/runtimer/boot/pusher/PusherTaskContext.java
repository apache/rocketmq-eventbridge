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
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 *
 */

package org.apache.rocketmq.eventbridge.adapter.runtimer.boot.pusher;

import com.alibaba.fastjson.JSON;
import io.openmessaging.connector.api.component.task.sink.SinkTaskContext;
import io.openmessaging.connector.api.data.RecordOffset;
import io.openmessaging.connector.api.data.RecordPartition;
import org.apache.commons.collections.MapUtils;
import org.apache.commons.lang3.StringUtils;
import org.apache.rocketmq.common.message.MessageQueue;
import org.apache.rocketmq.eventbridge.adapter.runtimer.common.ConnectKeyValue;
import org.apache.rocketmq.eventbridge.adapter.runtimer.common.LoggerName;
import org.apache.rocketmq.eventbridge.adapter.runtimer.common.QueueState;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.concurrent.ConcurrentHashMap;

public class PusherTaskContext implements SinkTaskContext {

    /**
     * The configs of current sink task.
     */
    private final ConnectKeyValue taskConfig;

    private static final Logger log = LoggerFactory.getLogger(LoggerName.EventBridge_RUNTIMER);

    private final Map<MessageQueue, Long> messageQueuesOffsetMap = new ConcurrentHashMap<>(64);

    private final Map<MessageQueue, QueueState> messageQueuesStateMap = new ConcurrentHashMap<>(64);

    public static final String BROKER_NAME = "brokerName";
    public static final String QUEUE_ID = "queueId";
    public static final String TOPIC = "topic";
    public static final String QUEUE_OFFSET = "queueOffset";

    public PusherTaskContext(ConnectKeyValue taskConfig) {
        this.taskConfig = taskConfig;
    }

    @Override
    public void resetOffset(RecordPartition recordPartition, RecordOffset recordOffset) {
        if (null == recordPartition || null == recordPartition.getPartition() || null == recordOffset || null == recordOffset.getOffset()) {
            log.warn("recordPartition {} info is null or recordOffset {} info is null", recordPartition, recordOffset);
            return;
        }
        String brokerName = (String) recordPartition.getPartition().get(BROKER_NAME);
        String topic = (String) recordPartition.getPartition().get(TOPIC);
        Integer queueId = Integer.valueOf((String) recordPartition.getPartition().get(QUEUE_ID));
        if (StringUtils.isEmpty(brokerName) || StringUtils.isEmpty(topic) || null == queueId) {
            log.warn("brokerName is null or queueId is null or queueName is null, brokerName {}, queueId {} queueId {}", brokerName, queueId, topic);
            return;
        }
        MessageQueue messageQueue = new MessageQueue(topic, brokerName, queueId);
        Long offset = Long.valueOf((String) recordOffset.getOffset().get(QUEUE_OFFSET));
        if (null == offset) {
            log.warn("resetOffset, offset is null");
            return;
        }
        messageQueuesOffsetMap.put(messageQueue, offset);
    }

    @Override
    public void resetOffset(Map<RecordPartition, RecordOffset> offsets) {
        if (MapUtils.isEmpty(offsets)) {
            log.warn("resetOffset, offsets {} is null", offsets);
            return;
        }
        for (Map.Entry<RecordPartition, RecordOffset> entry : offsets.entrySet()) {
            if (null == entry || null == entry.getKey() || null == entry.getKey().getPartition() || null == entry.getValue() || null == entry.getValue().getOffset()) {
                log.warn("recordPartition {} info is null or recordOffset {} info is null, entry {}", entry);
                continue;
            }
            RecordPartition recordPartition = entry.getKey();
            String brokerName = (String) recordPartition.getPartition().get(BROKER_NAME);
            String topic = (String) recordPartition.getPartition().get(TOPIC);
            Integer queueId = Integer.valueOf((String) recordPartition.getPartition().get(QUEUE_ID));
            if (StringUtils.isEmpty(brokerName) || StringUtils.isEmpty(topic) || null == queueId) {
                log.warn("brokerName is null or queueId is null or queueName is null, brokerName {}, queueId {} queueId {}", brokerName, queueId, topic);
                continue;
            }
            MessageQueue messageQueue = new MessageQueue(topic, brokerName, queueId);
            RecordOffset recordOffset = entry.getValue();
            Long offset = Long.valueOf((String) recordOffset.getOffset().get(QUEUE_OFFSET));
            if (null == offset) {
                log.warn("resetOffset, offset is null");
                continue;
            }
            messageQueuesOffsetMap.put(messageQueue, offset);
        }
    }

    @Override
    public void pause(List<RecordPartition> recordPartitions) {
        if (recordPartitions == null || recordPartitions.size() == 0) {
            log.warn("recordPartitions is null or recordPartitions.size() is zero. recordPartitions {}", JSON.toJSONString(recordPartitions));
            return;
        }
        for (RecordPartition recordPartition : recordPartitions) {
            if (null == recordPartition || null == recordPartition.getPartition()) {
                log.warn("recordPartition {} info is null", recordPartition);
                continue;
            }
            String brokerName = (String) recordPartition.getPartition().get(BROKER_NAME);
            String topic = (String) recordPartition.getPartition().get(TOPIC);
            Integer queueId = Integer.valueOf((String) recordPartition.getPartition().get(QUEUE_ID));
            if (StringUtils.isEmpty(brokerName) || StringUtils.isEmpty(topic) || null == queueId) {
                log.warn("brokerName is null or queueId is null or queueName is null, brokerName {}, queueId {} queueId {}", brokerName, queueId, topic);
                continue;
            }
            MessageQueue messageQueue = new MessageQueue(topic, brokerName, queueId);
            if (!messageQueuesOffsetMap.containsKey(messageQueue)) {
                log.warn("sink task current messageQueuesOffsetMap {} not contain messageQueue {}", messageQueuesOffsetMap, messageQueue);
                continue;
            }
            messageQueuesStateMap.put(messageQueue, QueueState.PAUSE);
        }
    }

    @Override
    public void resume(List<RecordPartition> recordPartitions) {
        if (recordPartitions == null || recordPartitions.size() == 0) {
            log.warn("recordPartitions is null or recordPartitions.size() is zero. recordPartitions {}", JSON.toJSONString(recordPartitions));
            return;
        }
        for (RecordPartition recordPartition : recordPartitions) {
            if (null == recordPartition || null == recordPartition.getPartition()) {
                log.warn("recordPartition {} info is null", recordPartition);
                continue;
            }
            String brokerName = (String) recordPartition.getPartition().get(BROKER_NAME);
            String topic = (String) recordPartition.getPartition().get(TOPIC);
            Integer queueId = Integer.valueOf((String) recordPartition.getPartition().get(QUEUE_ID));
            if (StringUtils.isEmpty(brokerName) || StringUtils.isEmpty(topic) || null == queueId) {
                log.warn("brokerName is null or queueId is null or queueName is null, brokerName {}, queueId {} queueId {}", brokerName, queueId, topic);
                continue;
            }
            MessageQueue messageQueue = new MessageQueue(topic, brokerName, queueId);
            if (!messageQueuesOffsetMap.containsKey(messageQueue)) {
                log.warn("sink task current messageQueuesOffsetMap {} not contain messageQueue {}", messageQueuesOffsetMap, messageQueue);
                continue;
            }
            messageQueuesStateMap.remove(messageQueue);
        }
    }

    @Override public Set<RecordPartition> assignment() {
        return null;
    }

    @Override public String getConnectorName() {
        return taskConfig.getString("connectorName");
    }

    @Override public String getTaskName() {
        return taskConfig.getString("taskId");
    }

    public Map<MessageQueue, Long> queuesOffsets() {
        return this.messageQueuesOffsetMap;
    }

    public void cleanQueuesOffsets() {
        this.messageQueuesOffsetMap.clear();
    }


}
