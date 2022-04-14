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

 import java.util.Map;

 import com.google.gson.Gson;
 import org.apache.rocketmq.eventbridge.adapter.persistence.target.mybatis.converter.EventTargetRunnerConverter;
 import org.apache.rocketmq.eventbridge.adapter.persistence.target.mybatis.dataobject.EventTargetRunnerDO;
 import org.apache.rocketmq.eventbridge.adapter.persistence.target.mybatis.mapper.EventTargetRunnerMapper;
 import org.apache.rocketmq.eventbridge.domain.model.run.EventTargetRunner;
 import org.apache.rocketmq.eventbridge.domain.model.run.RunOptions;
 import org.apache.rocketmq.eventbridge.domain.repository.EventTargetRunnerRepository;
 import org.springframework.stereotype.Repository;

 @Repository
 public class MybatisEventTargetRunnerRepository implements EventTargetRunnerRepository {

     private final EventTargetRunnerMapper eventTargetRunnerMapper;

     public MybatisEventTargetRunnerRepository(EventTargetRunnerMapper eventTargetRunnerMapper) {
         this.eventTargetRunnerMapper = eventTargetRunnerMapper;
     }

     @Override
     public boolean createTargetRunner(String accountId, String eventBusName, String eventRuleName, String name,
         String className, Map<String, Object> config, RunOptions runOptions, String runContext) {
         return eventTargetRunnerMapper.createEventTargetRunner(accountId, eventBusName, eventRuleName, name, className,
             new Gson().toJson(config), new Gson().toJson(runOptions), runContext) == 1;
     }

     @Override
     public boolean updateTargetRunner(String accountId, String eventBusName, String eventRuleName, String name,
         Map<String, Object> config, RunOptions runOptions, String runContext) {
         return eventTargetRunnerMapper.updateEventTargetRunner(accountId, eventBusName, eventRuleName, name,
             new Gson().toJson(config), new Gson().toJson(runOptions), runContext) == 1;
     }

     @Override
     public EventTargetRunner getEventTargetRunner(String accountId, String eventBusName, String eventRuleName,
         String eventTargetName) {
         EventTargetRunnerDO eventTargetRunnerDO = eventTargetRunnerMapper.getEventTargetRunner(accountId, eventBusName,
             eventRuleName, eventTargetName);
         if (eventTargetRunnerDO == null) {
             return null;
         }
         return EventTargetRunnerConverter.convert(eventTargetRunnerDO);
     }

     @Override
     public boolean deleteEventTargetRunner(String accountId, String eventBusName, String eventRuleName,
         String eventTargetName) {
         return eventTargetRunnerMapper.deleteEventTargetRunner(accountId, eventBusName, eventRuleName, eventTargetName)
             == 1;
     }

 }