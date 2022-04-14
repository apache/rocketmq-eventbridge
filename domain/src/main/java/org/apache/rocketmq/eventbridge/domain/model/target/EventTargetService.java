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
 package org.apache.rocketmq.eventbridge.domain.model.target;

 import java.util.List;

 import org.apache.rocketmq.eventbridge.domain.model.AbstractRunnerService;
 import org.apache.rocketmq.eventbridge.domain.model.classes.EventTargetClassService;
 import org.apache.rocketmq.eventbridge.domain.model.rule.EventRule;
 import org.apache.rocketmq.eventbridge.domain.model.rule.EventRuleService;
 import org.apache.rocketmq.eventbridge.domain.model.run.EventTargetRunner;
 import org.apache.rocketmq.eventbridge.domain.model.run.EventTargetRunnerService;
 import org.apache.rocketmq.eventbridge.domain.repository.EventTargetRepository;
 import org.apache.rocketmq.eventbridge.exception.EventBridgeException;
 import org.springframework.dao.DuplicateKeyException;
 import org.springframework.stereotype.Service;
 import org.springframework.transaction.annotation.Transactional;
 import org.springframework.util.CollectionUtils;

 import static org.apache.rocketmq.eventbridge.domain.common.exception.EventBridgeErrorCode.EventTargetAlreadyExist;
 import static org.apache.rocketmq.eventbridge.domain.common.exception.EventBridgeErrorCode.EventTargetNotExist;

 @Service
 public class EventTargetService extends AbstractRunnerService {

     private final EventTargetRepository eventTargetRepository;
     private final EventTargetRunnerService eventTargetRunnerService;
     private final EventTargetClassService eventTargetClassService;
     private final EventRuleService eventRuleService;

     public EventTargetService(EventTargetRepository eventTargetRepository,
         EventTargetRunnerService eventTargetRunnerService, EventTargetClassService eventTargetClassService,
         EventRuleService eventRuleService) {
         this.eventTargetRepository = eventTargetRepository;
         this.eventTargetRunnerService = eventTargetRunnerService;
         this.eventTargetClassService = eventTargetClassService;
         this.eventRuleService = eventRuleService;
     }

     @Transactional
     public boolean createTargets(String accountId, String eventBusName, String eventRuleName,
         List<EventTarget> eventTargetList) {
         EventRule eventRule = eventRuleService.getEventRule(accountId, eventBusName, eventRuleName);
         if (CollectionUtils.isEmpty(eventTargetList)) {
             return false;
         }
         eventTargetList.forEach(eventTarget -> {
             try {
                 eventTargetRepository.createEventTarget(accountId, eventBusName, eventRuleName, eventTarget.getName(),
                     eventTarget.getClassName(), eventTarget.getConfig(), eventTarget.getRunOptions());
             } catch (DuplicateKeyException e) {
                 throw new EventBridgeException(EventTargetAlreadyExist, eventTarget.getName(), eventRuleName,
                     eventBusName);
             }
             eventTargetRunnerService.createEventTargetRunner(accountId, eventBusName, eventRuleName, eventTarget,
                 eventRule.getFilterPattern());

         });
         return true;
     }

     public boolean deleteTargets(String accountId, String eventBusName, String eventRuleName,
         List<String> eventTargetNames) {
         if (CollectionUtils.isEmpty(eventTargetNames)) {
             return false;
         }
         eventTargetNames.forEach(eventTargetName -> {
             this.checkExist(accountId, eventBusName, eventRuleName, eventTargetName);
         });

         eventTargetNames.forEach(eventTargetName -> {
             eventTargetRunnerService.deleteTargetRunner(accountId, eventBusName, eventRuleName, eventTargetName);
             eventTargetRepository.deleteEventTarget(accountId, eventBusName, eventRuleName, eventTargetName);
         });
         return true;
     }

     public boolean updateTargets(String accountId, String eventBusName, String eventRuleName, String filterPattern) {
         List<EventTarget> eventTargetList = this.listTargets(accountId, eventBusName, eventRuleName);
         eventTargetList.forEach(eventTarget -> {
             this.checkExist(accountId, eventBusName, eventRuleName, eventTarget.getName());
         });
         eventTargetList.forEach(eventTarget -> {
             eventTargetRepository.updateEventTarget(accountId, eventBusName, eventRuleName, eventTarget.getName(),
                 eventTarget.getConfig(), eventTarget.getRunOptions());
             eventTargetRunnerService.updateTargetRunner(accountId, eventBusName, eventRuleName, eventTarget,
                 filterPattern);

         });
         return true;
     }

     public boolean updateTargets(String accountId, String eventBusName, String eventRuleName,
         List<EventTarget> eventTargetList) {
         if (CollectionUtils.isEmpty(eventTargetList)) {
             return false;
         }
         eventTargetList.forEach(eventTarget -> {
             this.checkExist(accountId, eventBusName, eventRuleName, eventTarget.getName());
         });

         EventRule eventRule = eventRuleService.getEventRule(accountId, eventBusName, eventRuleName);
         eventTargetList.forEach(eventTarget -> {
             eventTargetRepository.updateEventTarget(accountId, eventBusName, eventRuleName, eventTarget.getName(),
                 eventTarget.getConfig(), eventTarget.getRunOptions());
             eventTargetRunnerService.updateTargetRunner(accountId, eventBusName, eventRuleName, eventTarget,
                 eventRule.getFilterPattern());

         });
         return true;
     }

     public List<EventTarget> listTargets(String accountId, String eventBusName, String eventRuleName) {
         List<EventTarget> eventTargetList = eventTargetRepository.listEventTargets(accountId, eventBusName,
             eventRuleName);
         eventTargetList.forEach(eventTarget -> {
             EventTargetRunner eventTargetRunner = eventTargetRunnerService.getEventTargetRunner(accountId,
                 eventBusName, eventRuleName, eventTarget.getName());
             eventTarget.setStatus(eventTargetRunner.getStatus());
         });
         return eventTargetList;
     }

     public boolean deleteTargets(String accountId, String eventBusName, String eventRuleName) {
         List<EventTarget> eventTargetList = eventTargetRepository.listEventTargets(accountId, eventBusName,
             eventRuleName);
         eventTargetList.forEach(eventTarget -> {
             this.checkExist(accountId, eventBusName, eventRuleName, eventTarget.getName());
         });

         eventTargetList.forEach(eventTarget -> {
             eventTargetRepository.deleteEventTarget(accountId, eventBusName, eventRuleName, eventTarget.getName());
             eventTargetRunnerService.deleteTargetRunner(accountId, eventBusName, eventRuleName, eventTarget.getName());
         });
         return true;
     }

     public boolean disableTargets(String accountId, String eventBusName, String eventRuleName) {
         List<EventTarget> eventTargets = eventTargetRepository.listEventTargets(accountId, eventBusName,
             eventRuleName);
         eventTargets.forEach(eventTarget -> {
             eventTargetRunnerService.pause(accountId, eventBusName, eventRuleName, eventTarget.getName());
         });
         return true;
     }

     public boolean enableTargets(String accountId, String eventBusName, String eventRuleName) {
         List<EventTarget> eventTargetList = eventTargetRepository.listEventTargets(accountId, eventBusName,
             eventRuleName);
         eventTargetList.forEach(eventTarget -> {
             eventTargetRunnerService.start(accountId, eventBusName, eventRuleName, eventTarget.getName());
         });
         return true;
     }

     public void checkExist(String accountId, String eventBusName, String eventRuleName, String eventTargetName) {
         EventTarget eventTarget = this.eventTargetRepository.getEventTarget(accountId, eventBusName, eventRuleName,
             eventTargetName);
         if (eventTarget == null) {
             throw new EventBridgeException(EventTargetNotExist, eventTargetName, eventRuleName, eventBusName);
         }
     }
 }