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
 package org.apache.rocketmq.eventbridge.domain.model.bus;

 import java.util.List;

 import org.apache.rocketmq.eventbridge.domain.common.exception.EventBridgeErrorCode;
 import org.apache.rocketmq.eventbridge.domain.model.AbstractResourceService;
 import org.apache.rocketmq.eventbridge.domain.model.PaginationResult;
 import org.apache.rocketmq.eventbridge.domain.repository.EventBusRepository;
 import org.apache.rocketmq.eventbridge.domain.repository.EventDataRepository;
 import org.apache.rocketmq.eventbridge.exception.EventBridgeException;
 import org.springframework.dao.DuplicateKeyException;
 import org.springframework.stereotype.Service;
 import org.springframework.transaction.annotation.Transactional;

 import static org.apache.rocketmq.eventbridge.domain.common.EventBridgeConstants.EVENT_BUS_NAME_MAX_LENGTH;
 import static org.apache.rocketmq.eventbridge.domain.common.EventBridgeConstants.EVENT_BUS_NAME_MIN_LENGTH;
 import static org.apache.rocketmq.eventbridge.domain.common.EventBridgeConstants.EVENT_RULE_COUNT_LIMIT;
 import static org.apache.rocketmq.eventbridge.domain.common.EventBridgeConstants.RESERVED_EVENT_BUS_NAMES;
 import static org.apache.rocketmq.eventbridge.domain.common.EventBridgeConstants.RESERVED_EVENT_BUS_PREFIX;
 import static org.apache.rocketmq.eventbridge.domain.common.EventBridgeConstants.RESOURCE_NAME_PATTERN;
 import static org.apache.rocketmq.eventbridge.domain.common.exception.EventBridgeErrorCode.EventBusAlreadyExist;
 import static org.apache.rocketmq.eventbridge.domain.common.exception.EventBridgeErrorCode.EventBusCountExceedLimit;
 import static org.apache.rocketmq.eventbridge.domain.common.exception.EventBridgeErrorCode.EventBusNameInvalid;

 @Service
 public class EventBusService extends AbstractResourceService {

     protected final EventBusRepository eventBusRepository;
     protected final EventDataRepository eventDataRepository;

     public EventBusService(EventBusRepository eventBusRepository, EventDataRepository eventDataRepository) {
         this.eventBusRepository = eventBusRepository;
         this.eventDataRepository = eventDataRepository;
     }

     @Transactional
     public boolean createEventBus(String accountId, String eventBusName, String description) {
         boolean isSucceed;
         super.checkNameValidate(eventBusName, RESOURCE_NAME_PATTERN, EVENT_BUS_NAME_MIN_LENGTH,
             EVENT_BUS_NAME_MAX_LENGTH, RESERVED_EVENT_BUS_NAMES, RESERVED_EVENT_BUS_PREFIX, EventBusNameInvalid);
         super.checkQuota(this.getEventBusesCount(accountId), EVENT_RULE_COUNT_LIMIT, EventBusCountExceedLimit);

         try {
             isSucceed = eventBusRepository.createEventBus(accountId, eventBusName, description);
         } catch (DuplicateKeyException e) {
             throw new EventBridgeException(EventBusAlreadyExist, eventBusName);
         }
         if (!isSucceed && eventBusRepository.getEventBus(accountId, eventBusName) != null) {
             throw new EventBridgeException(EventBusAlreadyExist, eventBusName);
         }
         return isSucceed && eventDataRepository.createEventBusPersistence(accountId, eventBusName);
     }

     public EventBus getEventBus(String accountId, String eventBusName) {
         EventBus eventBus = eventBusRepository.getEventBus(accountId, eventBusName);
         if (eventBus == null) {
             throw new EventBridgeException(EventBridgeErrorCode.EventBusNotExist, eventBusName);
         }
         return eventBus;
     }

     public int getEventBusesCount(String accountId) {
         return eventBusRepository.getEventBusesCount(accountId);
     }

     public PaginationResult<List<EventBus>> listEventBuses(String accountId, String nextToken, int maxResults) {
         int total = getEventBusesCount(accountId);
         List<EventBus> eventBuses = eventBusRepository.listEventBuses(accountId, nextToken, maxResults);
         PaginationResult<List<EventBus>> result = new PaginationResult();
         result.setData(eventBuses);
         result.setTotal(total);
         result.setNextToken(String.valueOf(Integer.parseInt(nextToken) + maxResults));
         return result;
     }

     public boolean deleteEventBus(String accountId, String eventBusName) {
         this.checkExist(accountId, eventBusName);
         boolean isSucceed = this.eventBusRepository.deleteEventBus(accountId, eventBusName);
         return isSucceed && this.eventDataRepository.deleteEventBusPersistence(accountId, eventBusName);
     }

     public void checkExist(String accountId, String eventBusName) {
         if (eventBusRepository.getEventBus(accountId, eventBusName) == null) {
             throw new EventBridgeException(EventBridgeErrorCode.EventBusNotExist, eventBusName);
         }
     }

 }