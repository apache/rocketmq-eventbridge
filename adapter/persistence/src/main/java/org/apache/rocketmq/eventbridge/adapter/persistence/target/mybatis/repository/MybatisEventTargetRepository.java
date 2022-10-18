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
 package org.apache.rocketmq.eventbridge.adapter.persistence.target.mybatis.repository;

 import com.google.gson.Gson;
 import java.util.List;
 import java.util.Map;
 import org.apache.rocketmq.eventbridge.adapter.persistence.target.mybatis.converter.EventTargetConverter;
 import org.apache.rocketmq.eventbridge.adapter.persistence.target.mybatis.dataobject.EventTargetDO;
 import org.apache.rocketmq.eventbridge.adapter.persistence.target.mybatis.mapper.EventTargetMapper;
 import org.apache.rocketmq.eventbridge.domain.model.run.RunOptions;
 import org.apache.rocketmq.eventbridge.domain.model.target.EventTarget;
 import org.apache.rocketmq.eventbridge.domain.repository.EventTargetRepository;
 import org.springframework.stereotype.Repository;

 @Repository
 public class MybatisEventTargetRepository implements EventTargetRepository {

     private final EventTargetMapper eventTargetMapper;

     public MybatisEventTargetRepository(EventTargetMapper eventTargetMapper) {
         this.eventTargetMapper = eventTargetMapper;
     }

     @Override
     public boolean createEventTarget(String accountId, String eventBusName, String eventRuleName, String name,
         String className, Map<String, Object> config, RunOptions runOptions) {
         return eventTargetMapper.createEventTarget(accountId, eventBusName, eventRuleName, name, className,
             new Gson().toJson(config), new Gson().toJson(runOptions)) == 1;
     }

     @Override
     public List<EventTarget> listEventTargets(String accountId, String eventBusName, String eventRuleName) {
         List<EventTargetDO> eventTargetDOS = eventTargetMapper.listEventTargets(accountId,
             eventBusName, eventRuleName);
         return EventTargetConverter.convert(eventTargetDOS);
     }

     @Override
     public boolean updateEventTarget(String accountId, String eventBusName, String eventRuleName, String name,
         Map<String, Object> config, RunOptions runOptions) {
         return eventTargetMapper.updateEventTarget(accountId, eventBusName, eventRuleName, name,
             new Gson().toJson(config), new Gson().toJson(runOptions)) == 1;
     }

     @Override
     public EventTarget getEventTarget(String accountId, String eventBusName, String eventRuleName,
         String eventTargetName) {
         EventTargetDO eventTargetDO = eventTargetMapper.getEventTarget(accountId, eventBusName,
             eventRuleName, eventTargetName);
         if (eventTargetDO == null) {
             return null;
         }
         return EventTargetConverter.convert(eventTargetDO);
     }

     @Override
     public boolean deleteEventTarget(String accountId, String eventBusName, String eventRuleName,
         String eventTargetName) {
         return eventTargetMapper.deleteEventTarget(accountId, eventBusName, eventRuleName, eventTargetName)
             == 1;
     }

 }