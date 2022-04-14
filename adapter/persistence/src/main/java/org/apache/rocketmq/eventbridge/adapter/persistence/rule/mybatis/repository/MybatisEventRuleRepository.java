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
 package org.apache.rocketmq.eventbridge.adapter.persistence.rule.mybatis.repository;

 import java.util.List;

 import org.apache.rocketmq.eventbridge.adapter.persistence.rule.mybatis.mapper.EventRuleMapper;
 import org.apache.rocketmq.eventbridge.domain.common.enums.EventRuleStatusEnum;
 import org.apache.rocketmq.eventbridge.domain.model.rule.EventRule;
 import org.apache.rocketmq.eventbridge.domain.repository.EventRuleRepository;
 import org.springframework.stereotype.Repository;

 @Repository
 public class MybatisEventRuleRepository implements EventRuleRepository {

     private final EventRuleMapper eventRuleMapper;

     public MybatisEventRuleRepository(EventRuleMapper eventRuleMapper) {
         this.eventRuleMapper = eventRuleMapper;
     }

     @Override
     public boolean createEventRule(String accountId, String eventBusName, String eventRuleName, String description,
         String filterPattern, EventRuleStatusEnum status) {
         return eventRuleMapper.createEventRule(accountId, eventBusName, eventRuleName, description, filterPattern,
             status.getCode()) == 1;
     }

     @Override
     public boolean updateEventRule(String accountId, String eventBusName, String eventRuleName, String description,
         String filterPattern) {
         return eventRuleMapper.updateEventRule(accountId, eventBusName, eventRuleName, description, filterPattern,
             null) == 1;
     }

     @Override
     public boolean updateEventRuleStatus(String accountId, String eventBusName, String eventRuleName,
         EventRuleStatusEnum status) {
         return eventRuleMapper.updateEventRule(accountId, eventBusName, eventRuleName, null, null, status.getCode())
             == 1;
     }

     @Override
     public boolean deleteEventRule(String accountId, String eventBusName, String eventRuleName) {
         return eventRuleMapper.deleteEventRule(accountId, eventBusName, eventRuleName) == 1;
     }

     @Override
     public EventRule getEventRule(String accountId, String eventBusName, String eventRuleName) {
         return eventRuleMapper.getEventRule(accountId, eventBusName, eventRuleName);

     }

     @Override
     public int getEventRulesCount(String accountId, String eventBusName) {
         return eventRuleMapper.getEventRulesCount(accountId, eventBusName);
     }

     @Override
     public List<EventRule> listEventRules(String accountId, String eventBusName, String nextToken, int maxResults) {
         return eventRuleMapper.listEventRules(accountId, eventBusName, Integer.parseInt(nextToken), maxResults);
     }

 }