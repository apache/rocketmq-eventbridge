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
package org.apache.rocketmq.eventbridge.adapter.persistence.bus.mybatis.repository;

import java.util.List;
import org.apache.rocketmq.eventbridge.adapter.persistence.bus.mybatis.mapper.EventBusMapper;
import org.apache.rocketmq.eventbridge.domain.model.bus.EventBus;
import org.apache.rocketmq.eventbridge.domain.repository.EventBusRepository;
import org.springframework.stereotype.Repository;

@Repository
public class MybatisEventBusRepository implements EventBusRepository {

    private EventBusMapper eventBusMapper;

    public MybatisEventBusRepository(EventBusMapper eventBusMapper) {
        this.eventBusMapper = eventBusMapper;
    }

    @Override
    public boolean createEventBus(String accountId, String eventBusName, String description) {
        return eventBusMapper.createEventBus(accountId, eventBusName, description) == 1;
    }

    @Override
    public boolean deleteEventBus(String accountId, String eventBusName) {
        return eventBusMapper.deleteEventBus(accountId, eventBusName) == 1;
    }

    @Override
    public EventBus getEventBus(String accountId, String eventBusName) {
        return eventBusMapper.getEventBus(accountId, eventBusName);
    }

    @Override
    public int getEventBusesCount(String accountId) {
        return eventBusMapper.getEventBusesCount(accountId);
    }

    @Override
    public List<EventBus> listEventBuses(String accountId, String nextToken, int maxResults) {
        return eventBusMapper.listEventBuses(accountId, Integer.parseInt(nextToken), maxResults);
    }

}