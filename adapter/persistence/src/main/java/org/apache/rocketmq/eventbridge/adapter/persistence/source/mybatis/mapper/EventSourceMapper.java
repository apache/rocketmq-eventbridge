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
 package org.apache.rocketmq.eventbridge.adapter.persistence.source.mybatis.mapper;

 import java.util.List;
 import org.apache.ibatis.annotations.Param;
 import org.apache.rocketmq.eventbridge.adapter.persistence.source.mybatis.dataobject.EventSourceDO;

 public interface EventSourceMapper {

     int createEventSource(@Param("accountId") String accountId, @Param("eventBusName") String eventBusName,
         @Param("eventSourceName") String eventSourceName, @Param("description") String description,
         @Param("status") Integer status, @Param("type") Integer type, @Param("className") String className,
         @Param("config") String config);

     int deleteEventSource(@Param("accountId") String accountId, @Param("eventBusName") String eventBusName,
         @Param("eventSourceName") String eventSourceName);

     EventSourceDO getEventSource(@Param("accountId") String accountId, @Param("eventBusName") String eventBusName,
         @Param("eventSourceName") String eventSourceName);

     int getEventSourceCount(@Param("accountId") String accountId, @Param("eventBusName") String eventBusName);

     List<EventSourceDO> listEventSources(@Param("accountId") String accountId,
         @Param("eventBusName") String eventBusName, @Param("nextToken") int nextToken,
         @Param("maxResults") int maxResults);

     int updateEventSource(@Param("accountId") String accountId, @Param("eventBusName") String eventBusName,
         @Param("eventSourceName") String eventSourceName, @Param("description") String description,
         @Param("status") Integer status, @Param("config") String config);
 }