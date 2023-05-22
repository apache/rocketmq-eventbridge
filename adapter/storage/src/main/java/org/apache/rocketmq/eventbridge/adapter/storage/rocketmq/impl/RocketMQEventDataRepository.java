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
 */

package org.apache.rocketmq.eventbridge.adapter.storage.rocketmq.impl;

import com.google.gson.Gson;
import lombok.SneakyThrows;
import lombok.extern.slf4j.Slf4j;
import org.apache.commons.lang3.StringUtils;
import org.apache.rocketmq.client.producer.DefaultMQProducer;
import org.apache.rocketmq.common.message.Message;
import org.apache.rocketmq.eventbridge.adapter.persistence.data.mybatis.dataobject.EventTopicDO;
import org.apache.rocketmq.eventbridge.adapter.persistence.data.mybatis.mapper.EventTopicMapper;
import org.apache.rocketmq.eventbridge.adapter.storage.rocketmq.api.EventDataOnRocketMQConnectAPI;
import org.apache.rocketmq.eventbridge.config.AppConfig;
import org.apache.rocketmq.eventbridge.domain.common.exception.EventBridgeErrorCode;
import org.apache.rocketmq.eventbridge.domain.model.data.PutEventCallback;
import org.apache.rocketmq.eventbridge.domain.storage.EventDataRepository;
import org.apache.rocketmq.eventbridge.event.EventBridgeEvent;
import org.apache.rocketmq.eventbridge.exception.EventBridgeException;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.stereotype.Repository;

@Repository
@Slf4j
public class RocketMQEventDataRepository implements EventDataRepository {

    private final EventDataOnRocketMQConnectAPI eventDataOnRocketMQConnectAPI;
    private final EventTopicMapper eventTopicMapper;
    private final DefaultMQProducer producer;
    private final RocketMQMetaService rocketMQMetaService;

    @Value("${rocketmq.cluster.name:}")
    private String clusterName;

    public RocketMQEventDataRepository(EventDataOnRocketMQConnectAPI eventDataOnRocketMQConnectAPI,
        EventTopicMapper eventTopicMapper, DefaultMQProducer producer, RocketMQMetaService rocketMQMetaService) {
        this.eventDataOnRocketMQConnectAPI = eventDataOnRocketMQConnectAPI;
        this.eventTopicMapper = eventTopicMapper;
        this.producer = producer;
        this.rocketMQMetaService = rocketMQMetaService;
    }

    @Override
    public boolean createEventBusPersistence(String accountId, String eventBusName) {
        String topicName = eventDataOnRocketMQConnectAPI.buildTopicName(accountId, eventBusName);
        eventTopicMapper.createTopic(accountId, eventBusName, topicName, clusterName);
        return rocketMQMetaService.createTopic(clusterName, topicName);
    }

    @SneakyThrows
    @Override
    public boolean deleteEventBusPersistence(String accountId, String eventBusName) {
        EventTopicDO eventTopicDO = eventTopicMapper.getTopic(accountId, eventBusName);
        eventTopicMapper.deleteTopic(accountId, eventBusName);
        return rocketMQMetaService.deleteTopic(eventTopicDO.getCluster(), eventTopicDO.getName());
    }

    @Override
    public boolean putEvent(String accountId, String eventBusName, EventBridgeEvent eventBridgeEvent,
        PutEventCallback putEventCallback) {
        String topicName = this.getTopicName(accountId, eventBusName);
        Message msg = eventDataOnRocketMQConnectAPI.converter(accountId, topicName, eventBridgeEvent);
        try {
            producer.send(msg, new DefaultSendCallback(putEventCallback), 1000L);
        } catch (Throwable e) {
            throw new EventBridgeException(EventBridgeErrorCode.InternalError, e);
        }
        return true;
    }

    @Override
    public String getEventBusPersistentContext(String accountId, String eventBusName) {
        EventTopicDO eventTopicDO = eventTopicMapper.getTopic(accountId, eventBusName);
        return new Gson().toJson(eventTopicDO);
    }

    @Cacheable(value = "topicCache")
    @Override
    public String getTopicName(String accountId, String eventBusName) {
        String topicName = eventDataOnRocketMQConnectAPI.buildTopicName(accountId, eventBusName);
        if (StringUtils.isBlank(AppConfig.getGlobalConfig().getDefaultDataPersistentClusterName())) {
            return topicName;
        }
        EventTopicDO eventTopicDO = eventTopicMapper.getTopic(accountId, eventBusName);
        if (eventTopicDO != null) {
            topicName = eventTopicDO.getName();
        } else {
            topicName = eventDataOnRocketMQConnectAPI.buildTopicName(accountId, eventBusName);
            eventTopicMapper.createTopic(accountId, eventBusName, topicName, AppConfig.getGlobalConfig()
                .getDefaultDataPersistentClusterName());
        }
        return topicName;
    }

}
