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

package org.apache.rocketmq.eventbridge.domain.repository;

import java.util.List;
import java.util.Map;

import org.apache.rocketmq.eventbridge.domain.common.enums.EventSourceStatusEnum;
import org.apache.rocketmq.eventbridge.domain.common.enums.EventSourceTypeEnum;
import org.apache.rocketmq.eventbridge.domain.model.source.EventSource;

public interface EventSourceRepository {

    boolean createEventSource(String accountId, String eventBusName, String eventSourceName, String description,
        EventSourceStatusEnum status, EventSourceTypeEnum type, String className, Map<String, Object> config);

    boolean deleteEventSource(String accountId, String eventBusName, String eventSourceName);

    EventSource getEventSource(String accountId, String eventBusName, String eventSourceName);

    int getEventSourceCount(String accountId, String eventBusName);

    List<EventSource> listEventSources(String accountId, String eventBusName, String nextToken, int maxResults);

    boolean updateEventSource(String accountId, String eventBusName, String eventSourceName, String description,
        Integer status, Map<String, Object> config);
}
