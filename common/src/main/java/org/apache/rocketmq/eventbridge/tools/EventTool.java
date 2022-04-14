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

package org.apache.rocketmq.eventbridge.tools;

import java.util.List;
import java.util.Map;

import com.google.common.base.Strings;
import com.google.common.collect.Lists;
import com.google.common.collect.Maps;
import org.apache.rocketmq.eventbridge.config.AppConfig;
import org.apache.rocketmq.eventbridge.event.EventBridgeEvent;
import org.apache.rocketmq.eventbridge.exception.EventBridgeException;

import static org.apache.rocketmq.eventbridge.exception.code.EventErrorCode.EventBusEmpty;

public abstract class EventTool {

    public static String getEventBus(EventBridgeEvent eventBridgeEvent) {
        if (eventBridgeEvent == null) {
            return null;
        }
        Object eventBusName = eventBridgeEvent.getExtension(AppConfig.getGlobalConfig()
            .getGetEventBusExtensionKey());
        if (eventBusName == null) {
            return null;
        }
        return eventBusName.toString();
    }

    public static Map<String, List<EventBridgeEvent>> groupEventByEventBus(List<EventBridgeEvent> eventList) {
        Map<String, List<EventBridgeEvent>> eventMap = Maps.newHashMap();
        eventList.forEach(eventBridgeEvent -> {
            String eventBusName = getEventBus(eventBridgeEvent);
            if (Strings.isNullOrEmpty(eventBusName)) {
                throw new EventBridgeException(EventBusEmpty);
            }
            if (!eventMap.containsKey(eventBusName)) {
                List<EventBridgeEvent> events = Lists.newArrayList(eventBridgeEvent);
                eventMap.put(eventBusName, events);
            } else {
                List<EventBridgeEvent> events = eventMap.get(eventBusName);
                events.add(eventBridgeEvent);
            }
        });
        return eventMap;
    }
}
