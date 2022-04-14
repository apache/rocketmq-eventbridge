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
 package org.apache.rocketmq.eventbridge.domain.service;

 import java.util.List;

 import com.google.common.base.Strings;
 import org.apache.rocketmq.eventbridge.domain.model.rule.EventRule;
 import org.apache.rocketmq.eventbridge.domain.model.rule.EventRuleDetail;
 import org.apache.rocketmq.eventbridge.domain.model.rule.EventRuleService;
 import org.apache.rocketmq.eventbridge.domain.model.run.EventTargetRunner;
 import org.apache.rocketmq.eventbridge.domain.model.run.EventTargetRunnerService;
 import org.apache.rocketmq.eventbridge.domain.model.target.EventTarget;
 import org.apache.rocketmq.eventbridge.domain.model.target.EventTargetService;
 import org.springframework.stereotype.Service;
 import org.springframework.transaction.annotation.Transactional;

 @Service
 public class EventRuleDomainService {

     private final EventTargetService eventTargetService;
     private final EventRuleService eventRuleService;

     public EventRuleDomainService(EventTargetService eventTargetService, EventRuleService eventRuleService) {
         this.eventTargetService = eventTargetService;
         this.eventRuleService = eventRuleService;
     }

     public EventRuleDetail getEventRuleDetail(String accountId, String eventBusName, String eventRuleName) {
         EventRule eventRule = eventRuleService.getEventRule(accountId, eventBusName, eventRuleName);
         List<EventTarget> eventTargetList = eventTargetService.listTargets(accountId, eventBusName,
             eventRuleName);
         EventRuleDetail eventRuleDetail = new EventRuleDetail(eventRule.getAccountId(), eventRule.getEventBusName(),
             eventRule.getName(), eventRule.getDescription(), eventRule.getFilterPattern(), eventRule.getStatus(),
             eventRule.getGmtCreate(), eventRule.getGmtModify());
         eventRuleDetail.setEventTargets(eventTargetList);
         return eventRuleDetail;
     }

     @Transactional
     public boolean deleteEventRuleWithDependencies(String accountId, String eventBusName, String eventRuleName) {
         boolean isSucceed = eventRuleService.deleteEventRule(accountId, eventBusName, eventRuleName);
         return isSucceed && eventTargetService.deleteTargets(accountId, eventBusName, eventRuleName);
     }

     @Transactional
     public boolean updateEventRuleWithDependencies(String accountId, String eventBusName, String eventRuleName,
         String description, String filterPattern) {
         boolean isSucceed = eventRuleService.updateEventRule(accountId, eventBusName, eventRuleName, description,
             filterPattern);
         if (!Strings.isNullOrEmpty(filterPattern)) {
             return isSucceed && eventTargetService.updateTargets(accountId, eventBusName, eventRuleName,
                 filterPattern);
         } else {
             return isSucceed;
         }
     }

     @Transactional
     public boolean disableEventRuleWithDependencies(String accountId, String eventBusName, String eventRuleName) {
         boolean isSucceed = eventRuleService.disableEventRule(accountId, eventBusName, eventRuleName);
         return isSucceed && eventTargetService.disableTargets(accountId, eventBusName, eventRuleName);
     }

     @Transactional
     public boolean enableEventRuleWithDependencies(String accountId, String eventBusName, String eventRuleName) {
         boolean isSucceed = eventRuleService.enableEventRule(accountId, eventBusName, eventRuleName);
         return isSucceed && eventTargetService.enableTargets(accountId, eventBusName, eventRuleName);
     }

 }