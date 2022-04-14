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
 package org.apache.rocketmq.eventbridge.domain.model.run;

 import java.util.Map;

 import com.google.common.base.Strings;
 import com.google.common.collect.Maps;
 import org.apache.rocketmq.eventbridge.domain.common.enums.EventTargetStatusEnum;
 import org.apache.rocketmq.eventbridge.domain.model.AbstractRunnerService;
 import org.apache.rocketmq.eventbridge.domain.model.Component;
 import org.apache.rocketmq.eventbridge.domain.model.classes.EventTargetClassService;
 import org.apache.rocketmq.eventbridge.domain.model.target.EventTarget;
 import org.apache.rocketmq.eventbridge.domain.repository.EventTargetRunnerRepository;
 import org.apache.rocketmq.eventbridge.domain.rpc.TargetRunnerAPI;
 import org.apache.rocketmq.eventbridge.exception.EventBridgeException;
 import org.apache.rocketmq.eventbridge.tools.transform.TransformParam;
 import org.springframework.dao.DuplicateKeyException;
 import org.springframework.stereotype.Service;

 import static org.apache.rocketmq.eventbridge.config.EventBridgeConstants.ACCOUNT_ID_KEY;
 import static org.apache.rocketmq.eventbridge.config.EventBridgeConstants.EVENT_BUS_NAME_KEY;
 import static org.apache.rocketmq.eventbridge.domain.common.exception.EventBridgeErrorCode.EventTargetAlreadyExist;
 import static org.apache.rocketmq.eventbridge.domain.common.exception.EventBridgeErrorCode.EventTargetNotExist;

 @Service
 public class EventTargetRunnerService extends AbstractRunnerService {

     private final EventTargetRunnerRepository eventTargetRunnerRepository;
     private final TargetRunnerAPI targetRunnerAPI;
     private final EventTargetClassService eventTargetClassService;

     public EventTargetRunnerService(EventTargetRunnerRepository eventTargetRunnerRepository,
         TargetRunnerAPI targetRunnerAPI, EventTargetClassService eventTargetClassService) {
         this.eventTargetRunnerRepository = eventTargetRunnerRepository;
         this.targetRunnerAPI = targetRunnerAPI;
         this.eventTargetClassService = eventTargetClassService;
     }

     public boolean createEventTargetRunner(String accountId, String eventBusName, String eventRuleName,
         EventTarget eventTarget, String filterPattern) {
         try {
             Component source = this.buildDefaultSourceComponent(accountId, eventBusName);
             Component target = eventTargetClassService.renderConfig(accountId, eventTarget.getClassName(),
                 eventTarget.getConfig());
             Map<String, TransformParam> targetTransform = eventTargetClassService.renderTargetTransform(accountId,
                 eventTarget.getClassName(), eventTarget.getConfig());
             String runContext = targetRunnerAPI.createAndStartEventTargetRunner(accountId,
                 this.buildRunnerName(accountId, eventBusName, eventRuleName, eventTarget.getName()), source, target,
                 filterPattern, targetTransform, eventTarget.getRunOptions());
             eventTargetRunnerRepository.createTargetRunner(accountId, eventBusName, eventRuleName,
                 eventTarget.getName(), eventTarget.getClassName(), eventTarget.getConfig(),
                 eventTarget.getRunOptions(), runContext);
         } catch (DuplicateKeyException e) {
             throw new EventBridgeException(EventTargetAlreadyExist, eventTarget.getName(), eventRuleName,
                 eventBusName);
         }
         return true;
     }

     public boolean deleteTargetRunner(String accountId, String eventBusName, String eventRuleName,
         String eventTargetName) {
         if (Strings.isNullOrEmpty(eventTargetName)) {
             return false;
         }
         this.checkExist(accountId, eventBusName, eventRuleName, eventTargetName);
         EventTargetRunner eventTargetRunner = this.getEventTargetRunner(accountId, eventBusName, eventRuleName,
             eventTargetName);
         targetRunnerAPI.delete(eventTargetRunner.getRunContext());
         eventTargetRunnerRepository.deleteEventTargetRunner(accountId, eventBusName, eventRuleName, eventTargetName);
         return true;
     }

     public boolean updateTargetRunner(String accountId, String eventBusName, String eventRuleName,
         EventTarget eventTarget, String filterPattern) {
         this.checkExist(accountId, eventBusName, eventRuleName, eventTarget.getName());
         Component source = this.buildDefaultSourceComponent(accountId, eventBusName);
         Component target = eventTargetClassService.renderConfig(accountId, eventTarget.getClassName(),
             eventTarget.getConfig());
         EventTargetRunner eventTargetRunnerDetail = eventTargetRunnerRepository.getEventTargetRunner(accountId,
             eventBusName, eventRuleName, eventTarget.getName());
         Map<String, TransformParam> targetTransform = eventTargetClassService.renderTargetTransform(accountId,
             eventTarget.getClassName(), eventTarget.getConfig());
         String runContext = targetRunnerAPI.updateEventTargetRunner(accountId,
             this.buildRunnerName(accountId, eventBusName, eventRuleName, eventTarget.getName()), source, target,
             filterPattern, targetTransform, eventTarget.getRunOptions(), eventTargetRunnerDetail.getRunContext());
         eventTargetRunnerRepository.updateTargetRunner(accountId, eventBusName, eventRuleName, eventTarget.getName(),
             eventTarget.getConfig(), eventTarget.getRunOptions(), runContext);

         return true;
     }


     public EventTargetRunner getEventTargetRunner(String accountId, String eventBusName, String eventRuleName,
         String eventTargetName) {
         EventTargetRunner eventTargetRunner = eventTargetRunnerRepository.getEventTargetRunner(accountId, eventBusName,
             eventRuleName, eventTargetName);
         EventTargetStatusEnum status = targetRunnerAPI.getEventTargetRunnerStatus(eventTargetRunner.getRunContext());
         eventTargetRunner.setStatus(status);
         return eventTargetRunner;
     }

     public boolean pause(String accountId, String eventBusName, String eventRuleName,
         String eventTargetName) {
         EventTargetRunner eventTargetRunner = eventTargetRunnerRepository.getEventTargetRunner(accountId, eventBusName,
             eventRuleName, eventTargetName);
         targetRunnerAPI.pause(eventTargetRunner.getRunContext());
         return true;
     }

     public boolean start(String accountId, String eventBusName, String eventRuleName, String eventTargetName) {
         EventTargetRunner eventTargetRunner = eventTargetRunnerRepository.getEventTargetRunner(accountId, eventBusName,
             eventRuleName, eventTargetName);
         targetRunnerAPI.start(eventTargetRunner.getRunContext());
         return true;
     }

     private Component buildDefaultSourceComponent(String accountId, String eventBusName) {
         Map<String, Object> config = Maps.newHashMap();
         config.put(EVENT_BUS_NAME_KEY, eventBusName);
         config.put(ACCOUNT_ID_KEY, accountId);
         return new Component(this.buildDefaultComponentName(), config);
     }

     public void checkExist(String accountId, String eventBusName, String eventRuleName, String eventTargetName) {
         EventTargetRunner eventTargetRunner = this.eventTargetRunnerRepository.getEventTargetRunner(accountId,
             eventBusName, eventRuleName, eventTargetName);
         if (eventTargetRunner == null) {
             throw new EventBridgeException(EventTargetNotExist, eventTargetName, eventRuleName, eventBusName);
         }
     }
 }