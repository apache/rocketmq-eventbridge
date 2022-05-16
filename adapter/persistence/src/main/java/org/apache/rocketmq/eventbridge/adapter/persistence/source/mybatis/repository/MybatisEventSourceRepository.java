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
 package org.apache.rocketmq.eventbridge.adapter.persistence.source.mybatis.repository;

 import java.util.List;
 import java.util.Map;

 import com.google.gson.Gson;
 import org.apache.rocketmq.eventbridge.adapter.persistence.source.mybatis.converter.EventSourceConverter;
 import org.apache.rocketmq.eventbridge.adapter.persistence.source.mybatis.dataobject.EventSourceDO;
 import org.apache.rocketmq.eventbridge.adapter.persistence.source.mybatis.mapper.EventSourceMapper;
 import org.apache.rocketmq.eventbridge.domain.common.enums.EventSourceStatusEnum;
 import org.apache.rocketmq.eventbridge.domain.common.enums.EventSourceTypeEnum;
 import org.apache.rocketmq.eventbridge.domain.model.source.EventSource;
 import org.apache.rocketmq.eventbridge.domain.repository.EventSourceRepository;
 import org.springframework.stereotype.Repository;

 @Repository
 public class MybatisEventSourceRepository implements EventSourceRepository {

     private final EventSourceMapper eventSourceMapper;

     public MybatisEventSourceRepository(EventSourceMapper eventSourceMapper) {
         this.eventSourceMapper = eventSourceMapper;
     }

     @Override
     public boolean createEventSource(String accountId, String eventBusName, String eventSourceName, String description,
         EventSourceStatusEnum status, EventSourceTypeEnum type, String className, Map<String, Object> config) {
         return eventSourceMapper.createEventSource(accountId, eventBusName, eventSourceName, description,
             status.getCode(), type.getCode(), className, new Gson().toJson(config)) == 1;
     }

     @Override
     public EventSource getEventSource(String accountId, String eventBusName, String eventSourceName) {
         EventSourceDO eventSourceDO = eventSourceMapper.getEventSource(accountId, eventBusName, eventSourceName);
         if (eventSourceDO == null) {
             return null;
         }
         return EventSourceConverter.convert(eventSourceDO);
     }

     @Override
     public int getEventSourceCount(String accountId, String eventBusName) {
         return eventSourceMapper.getEventSourceCount(accountId, eventBusName);
     }

     @Override
     public List<EventSource> listEventSources(String accountId, String eventBusName, String nextToken,
         int maxResults) {
         List<EventSourceDO> eventSourceDOS = eventSourceMapper.listEventSources(accountId, eventBusName,
             Integer.parseInt(nextToken), maxResults);
         return EventSourceConverter.convert(eventSourceDOS);
     }

     @Override
     public boolean deleteEventSource(String accountId, String eventBusName, String eventSourceName) {
         return eventSourceMapper.deleteEventSource(accountId, eventBusName, eventSourceName) == 1;
     }

     @Override
     public boolean updateEventSource(String accountId, String eventBusName, String eventSourceName, String description,
         Integer status, Map<String, Object> config) {
         return eventSourceMapper.updateEventSource(accountId, eventBusName, eventSourceName, description, status, new Gson().toJson(config))
             == 1;
     }
 }