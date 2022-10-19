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
package org.apache.rocketmq.eventbridge.adapter.persistence.type.mybatis.repository;

import java.util.List;
import org.apache.rocketmq.eventbridge.adapter.persistence.type.mybatis.mapper.EventTypeMapper;
import org.apache.rocketmq.eventbridge.domain.model.source.EventType;
import org.apache.rocketmq.eventbridge.domain.repository.EventTypeRepository;
import org.springframework.stereotype.Repository;

@Repository
public class MybatisEventTypeRepository implements EventTypeRepository {

    private final EventTypeMapper eventTypeMapper;

    public MybatisEventTypeRepository(EventTypeMapper eventTypeMapper) {
        this.eventTypeMapper = eventTypeMapper;
    }

    @Override
    public boolean createEventType(String accountId, String eventBusName, String eventSourceName, String eventTypeName,
        String description) {
        return eventTypeMapper.createEventType(accountId, eventBusName, eventSourceName, eventTypeName, description)
            == 1;
    }

    @Override
    public boolean deleteEventType(String accountId, String eventBusName, String eventSourceName,
        String eventTypeName) {
        return eventTypeMapper.deleteEventType(accountId, eventBusName, eventSourceName, eventTypeName) == 1;
    }

    @Override
    public int getEventTypeCount(String accountId, String eventBusName, String eventSourceName) {
        return eventTypeMapper.getEventTypeCount(accountId, eventBusName, eventSourceName);
    }

    @Override
    public List<EventType> listEventTypes(String accountId, String eventBusName, String eventSourceName,
        String nextToken, int maxResults) {
        return eventTypeMapper.listEventTypes(accountId, eventBusName, eventSourceName, Integer.parseInt(nextToken),
            maxResults);
    }

    @Override
    public boolean updateEventType(String accountId, String eventBusName, String eventSourceName, String eventTypeName,
        String description) {
        return eventTypeMapper.updateEventType(accountId, eventBusName, eventSourceName, eventTypeName, description)
            == 1;
    }

}