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

 import org.apache.rocketmq.eventbridge.adapter.persistence.source.mybatis.converter.EventSourceRunnerConverter;
 import org.apache.rocketmq.eventbridge.adapter.persistence.source.mybatis.dataobject.EventSourceRunnerDO;
 import org.apache.rocketmq.eventbridge.adapter.persistence.source.mybatis.mapper.EventSourceRunnerMapper;
 import org.apache.rocketmq.eventbridge.domain.model.run.EventSourceRunner;
 import org.apache.rocketmq.eventbridge.domain.repository.EventSourceRunnerRepository;
 import org.springframework.stereotype.Repository;

 @Repository
 public class MybatisEventSourceRunnerRepository implements EventSourceRunnerRepository {

     private final EventSourceRunnerMapper eventSourceRunnerMapper;

     public MybatisEventSourceRunnerRepository(EventSourceRunnerMapper eventSourceRunnerMapper) {
         this.eventSourceRunnerMapper = eventSourceRunnerMapper;
     }

     @Override
     public boolean createEventSourceRunner(String accountId, String eventBusName, String eventSourceName,
         String runContext) {
         return eventSourceRunnerMapper.createEventSourceRunner(accountId, eventBusName, eventSourceName, runContext)
             == 1;
     }

     @Override
     public boolean deleteEventSourceRunner(String accountId, String eventBusName, String eventSourceName) {
         return eventSourceRunnerMapper.deleteEventSourceRunner(accountId, eventBusName, eventSourceName) == 1;
     }

     @Override
     public boolean updateEventSourceRunner(String accountId, String eventBusName, String eventSourceName,
         String runContext) {
         return eventSourceRunnerMapper.updateEventSourceRunner(accountId, eventBusName, eventSourceName, runContext)
             == 1;
     }

     @Override
     public EventSourceRunner getEventSourceRunner(String accountId, String eventBusName, String eventSourceName) {
         EventSourceRunnerDO eventSourceRunnerDO = eventSourceRunnerMapper.getEventSourceRunner(accountId, eventBusName,
             eventSourceName);
         if (eventSourceRunnerDO == null) {
             return null;
         }
         return EventSourceRunnerConverter.convert(eventSourceRunnerDO);
     }
 }