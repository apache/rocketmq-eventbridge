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

 import java.util.Map;
 import java.util.Optional;

 import org.apache.rocketmq.eventbridge.domain.common.enums.EventSourceTypeEnum;
 import org.apache.rocketmq.eventbridge.domain.model.classes.EventSourceClassService;
 import org.apache.rocketmq.eventbridge.exception.EventBridgeException;
 import org.springframework.context.ApplicationContext;
 import org.springframework.stereotype.Service;

 import static org.apache.rocketmq.eventbridge.domain.common.exception.EventBridgeErrorCode.EventSourceTypeOrClassInvalid;

 @Service
 public class EventSourceServiceFactory {

     private EventSourceService eventSourceService;
     private EventSourceClassService eventSourceClassService;
     private ApplicationContext applicationContext;

     public EventSourceServiceFactory(EventSourceService eventSourceService,
         EventSourceClassService eventSourceClassService, ApplicationContext applicationContext) {
         this.eventSourceService = eventSourceService;
         this.eventSourceClassService = eventSourceClassService;
         this.applicationContext = applicationContext;
     }

     public EventSourceService getEventSourceService(String eventSourceType, String className) {
         EventSourceTypeEnum type = EventSourceTypeEnum.parseFromName(eventSourceType);
         Map<String, EventSourceService> eventSourceServiceMap = applicationContext.getBeansOfType(
             EventSourceService.class);
         Optional<EventSourceService> eventSourceServiceOptional = eventSourceServiceMap.values()
             .stream()
             .filter(eventSourceService -> eventSourceService.match(type, className))
             .findFirst();
         if (!eventSourceServiceOptional.isPresent()) {
             throw new EventBridgeException(EventSourceTypeOrClassInvalid, type, className);
         }
         return eventSourceServiceOptional.get();
     }

     public EventSourceService getEventSourceService(String accountId, String eventBusName, String eventSourceName) {
         EventSource eventSource = eventSourceService.getEventSource(accountId, eventBusName, eventSourceName);
         return getEventSourceService(eventSource.getType().name(), eventSource.getClassName());
     }

     public EventSourceService getDefaultEventSourceService() {
         return eventSourceService;
     }
 }