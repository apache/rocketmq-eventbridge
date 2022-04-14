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

 import java.util.List;

 import org.apache.rocketmq.eventbridge.domain.model.PaginationResult;
 import org.apache.rocketmq.eventbridge.domain.repository.EventTypeRepository;
 import org.springframework.stereotype.Service;

 @Service
 public class EventTypeService {

     private final EventSourceService eventSourceService;
     private final EventTypeRepository eventTypeRepository;

     public EventTypeService(EventSourceService eventSourceService, EventTypeRepository eventTypeRepository) {
         this.eventSourceService = eventSourceService;
         this.eventTypeRepository = eventTypeRepository;
     }

     public PaginationResult<List<EventType>> listEventTypes(String accountId, String eventBusName,
         String eventSourceName, String nextToken, int maxResults) {
         eventSourceService.checkExist(accountId, eventBusName, eventSourceName);
         List<EventType> pageResult = eventTypeRepository.listEventTypes(accountId, eventBusName, eventSourceName,
             nextToken, maxResults);
         PaginationResult<List<EventType>> result = new PaginationResult();
         result.setData(pageResult);
         result.setTotal(this.getEventTypeCount(accountId, eventBusName, eventSourceName));
         result.setNextToken(String.valueOf(Integer.parseInt(nextToken) + maxResults));
         return result;
     }

     private int getEventTypeCount(String accountId, String eventBusName, String eventSourceName) {
         return eventTypeRepository.getEventTypeCount(accountId, eventBusName, eventSourceName);
     }

     public boolean createEventType(String accountId, String eventBusName, String eventSourceName, String eventTypeName,
         String description) {
         eventSourceService.checkExist(accountId, eventBusName, eventSourceName);
         return eventTypeRepository.createEventType(accountId, eventBusName, eventSourceName, eventTypeName,
             description);
     }

     public boolean updateEventType(String accountId, String eventBusName, String eventSourceName, String eventTypeName,
         String description) {
         eventSourceService.checkExist(accountId, eventBusName, eventSourceName);
         return eventTypeRepository.updateEventType(accountId, eventBusName, eventSourceName, eventTypeName,
             description);
     }

     public boolean deleteEventType(String accountId, String eventBusName, String eventSourceName, String eventTypeName,
         String description) {
         eventSourceService.checkExist(accountId, eventBusName, eventSourceName);
         return eventTypeRepository.deleteEventType(accountId, eventBusName, eventSourceName, eventTypeName);
     }

 }