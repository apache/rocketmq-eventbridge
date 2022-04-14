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

 import org.apache.rocketmq.eventbridge.domain.model.bus.EventBusService;
 import org.apache.rocketmq.eventbridge.domain.model.rule.EventRuleService;
 import org.apache.rocketmq.eventbridge.domain.model.source.EventSourceService;
 import org.apache.rocketmq.eventbridge.exception.EventBridgeException;
 import org.springframework.stereotype.Service;
 import org.springframework.transaction.annotation.Transactional;

 import static org.apache.rocketmq.eventbridge.domain.common.exception.EventBridgeErrorCode.EventBusRuleNotEmptyForDelete;
 import static org.apache.rocketmq.eventbridge.domain.common.exception.EventBridgeErrorCode.EventBusSourceNotEmptyForDelete;

 @Service
 public class EventBusDomainService {

     private final EventSourceService eventSourceService;
     private final EventRuleService eventRuleService;
     private final EventBusService eventBusService;

     public EventBusDomainService(EventSourceService eventSourceService, EventRuleService eventRuleService,
         EventBusService eventBusService) {
         this.eventSourceService = eventSourceService;
         this.eventRuleService = eventRuleService;
         this.eventBusService = eventBusService;
     }

     @Transactional
     public boolean deleteEventBusCheckDependencies(String accountId, String eventBusName) {
         //check bus exist
         eventBusService.checkExist(accountId, eventBusName);
         //check rules not exist
         if (eventRuleService.getEventRulesCount(accountId, eventBusName) > 0) {
             throw new EventBridgeException(EventBusRuleNotEmptyForDelete, eventBusName);
         }
         //check sources not exist
         if (eventSourceService.getEventSourceCount(accountId, eventBusName) > 0) {
             throw new EventBridgeException(EventBusSourceNotEmptyForDelete, eventBusName);
         }
         return eventBusService.deleteEventBus(accountId, eventBusName);
     }

 }