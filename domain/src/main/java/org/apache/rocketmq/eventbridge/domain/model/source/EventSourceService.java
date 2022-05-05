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
 package org.apache.rocketmq.eventbridge.domain.model.source;

 import com.google.common.base.Strings;
 import org.apache.rocketmq.eventbridge.domain.common.enums.EventSourceStatusEnum;
 import org.apache.rocketmq.eventbridge.domain.common.enums.EventSourceTypeEnum;
 import org.apache.rocketmq.eventbridge.domain.model.AbstractResourceService;
 import org.apache.rocketmq.eventbridge.domain.model.PaginationResult;
 import org.apache.rocketmq.eventbridge.domain.model.bus.EventBusService;
 import org.apache.rocketmq.eventbridge.domain.repository.EventSourceRepository;
 import org.apache.rocketmq.eventbridge.exception.EventBridgeException;
 import org.springframework.dao.DuplicateKeyException;
 import org.springframework.stereotype.Service;
 import org.springframework.transaction.annotation.Transactional;

 import java.util.List;
 import java.util.Map;

 import static org.apache.rocketmq.eventbridge.domain.common.EventBridgeConstants.EVENT_SOURCE_COUNT_LIMIT;
 import static org.apache.rocketmq.eventbridge.domain.common.EventBridgeConstants.EVENT_SOURCE_NAME_MAX_LENGTH;
 import static org.apache.rocketmq.eventbridge.domain.common.EventBridgeConstants.EVENT_SOURCE_NAME_MIN_LENGTH;
 import static org.apache.rocketmq.eventbridge.domain.common.EventBridgeConstants.RESERVED_EVENT_SOURCE_PREFIX;
 import static org.apache.rocketmq.eventbridge.domain.common.EventBridgeConstants.RESOURCE_NAME_PATTERN;
 import static org.apache.rocketmq.eventbridge.domain.common.exception.EventBridgeErrorCode.EventSourceAlreadyExist;
 import static org.apache.rocketmq.eventbridge.domain.common.exception.EventBridgeErrorCode.EventSourceCountExceedLimit;
 import static org.apache.rocketmq.eventbridge.domain.common.exception.EventBridgeErrorCode.EventSourceNameInvalid;
 import static org.apache.rocketmq.eventbridge.domain.common.exception.EventBridgeErrorCode.EventSourceNotExist;

 @Service
 public class EventSourceService extends AbstractResourceService {

     protected final EventBusService eventBusService;
     protected final EventSourceRepository eventSourceRepository;

     public EventSourceService(EventBusService eventBusService, EventSourceRepository eventSourceRepository) {
         this.eventBusService = eventBusService;
         this.eventSourceRepository = eventSourceRepository;
     }

     public boolean match(EventSourceTypeEnum type, String className) {
         if (Strings.isNullOrEmpty(className)) {
             return Boolean.TRUE;
         }
         return Boolean.FALSE;
     }

     @Transactional
     public boolean createEventSource(String accountId, String eventBusName, String eventSourceName, String description,
         String className, Map<String, Object> inputConfig) {
         this.eventBusService.checkExist(accountId, eventBusName);
         super.checkQuota(this.getEventSourceCount(accountId, eventBusName), EVENT_SOURCE_COUNT_LIMIT,
             EventSourceCountExceedLimit);
         super.checkNameValidate(eventSourceName, RESOURCE_NAME_PATTERN, EVENT_SOURCE_NAME_MIN_LENGTH,
             EVENT_SOURCE_NAME_MAX_LENGTH, null, RESERVED_EVENT_SOURCE_PREFIX, EventSourceNameInvalid);
         boolean isSucceed;
         try {
             isSucceed = eventSourceRepository.createEventSource(accountId, eventBusName, eventSourceName, description,
                 EventSourceStatusEnum.ACTIVATED, EventSourceTypeEnum.USER_DEFINED, className, inputConfig);
         } catch (DuplicateKeyException e) {
             throw new EventBridgeException(EventSourceAlreadyExist, eventSourceName, eventBusName);
         }
         return isSucceed;
     }

     @Transactional
     public boolean deleteEventSource(String accountId, String eventBusName, String eventSourceName) {
         this.checkExist(accountId, eventBusName, eventSourceName);
         return eventSourceRepository.deleteEventSource(accountId, eventBusName, eventSourceName);

     }

     @Transactional
     public boolean updateEventSource(String accountId, String eventBusName, String eventSourceName, String description,
         String className, Map<String, Object> inputConfig) {
         this.checkExist(accountId, eventBusName, eventSourceName);
         return eventSourceRepository.updateEventSource(accountId, eventBusName, eventSourceName, description,
             inputConfig);

     }

     public EventSource getEventSource(String accountId, String eventBusName, String eventSourceName) {
         this.checkExist(accountId, eventBusName, eventSourceName);
         return eventSourceRepository.getEventSource(accountId, eventBusName, eventSourceName);
     }

     public PaginationResult<List<EventSource>> listEventSources(String accountId, String eventBusName,
         String nextToken, int maxResults) {
         List<EventSource> eventSources = eventSourceRepository.listEventSources(accountId, eventBusName, nextToken,
             maxResults);
         PaginationResult<List<EventSource>> result = new PaginationResult();
         result.setData(eventSources);
         result.setTotal(this.getEventSourceCount(accountId, eventBusName));
         result.setNextToken(String.valueOf(Integer.parseInt(nextToken) + maxResults));
         return result;
     }

     public int getEventSourceCount(String accountId, String eventBusName) {
         this.eventBusService.checkExist(accountId, eventBusName);
         return eventSourceRepository.getEventSourceCount(accountId, eventBusName);
     }

     public void checkExist(String accountId, String eventBusName, String eventSourceName) {
         this.eventBusService.checkExist(accountId, eventBusName);
         EventSource eventSource = eventSourceRepository.getEventSource(accountId, eventBusName, eventSourceName);
         if (eventSource == null) {
             throw new EventBridgeException(EventSourceNotExist, eventSourceName, eventBusName);
         }
     }
 }