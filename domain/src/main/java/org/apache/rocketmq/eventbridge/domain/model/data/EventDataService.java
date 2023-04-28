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

package org.apache.rocketmq.eventbridge.domain.model.data;

import org.apache.rocketmq.eventbridge.domain.model.bus.EventBusService;
import org.apache.rocketmq.eventbridge.domain.storage.EventDataRepository;
import org.apache.rocketmq.eventbridge.event.EventBridgeEvent;
import org.apache.rocketmq.eventbridge.tools.EventTool;
import org.springframework.stereotype.Service;

@Service
public class EventDataService {

    private final EventDataRepository eventDataRepository;
    private final EventBusService eventBusService;

    public EventDataService(EventDataRepository eventDataRepository, EventBusService eventBusService) {
        this.eventDataRepository = eventDataRepository;
        this.eventBusService = eventBusService;
    }

    public void putEvent(String accountId, EventBridgeEvent event, PutEventCallback putEventCallback) {
        String eventBusName = EventTool.getEventBus(event);
        eventBusService.checkExist(accountId, eventBusName);
        eventDataRepository.putEvent(accountId, eventBusName, event, putEventCallback);
    }
}
