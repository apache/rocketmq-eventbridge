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

package org.apache.rocketmq.eventbridge.adapter.api.controller;

import com.google.common.collect.Lists;
import io.cloudevents.CloudEvent;
import org.apache.rocketmq.eventbridge.adapter.api.converter.EventConverterAdapter;
import org.apache.rocketmq.eventbridge.adapter.api.converter.HttpEventConverter;
import org.apache.rocketmq.eventbridge.adapter.api.dto.data.PutEventsResponse;
import org.apache.rocketmq.eventbridge.adapter.api.handler.EventDataHandler;
import org.apache.rocketmq.eventbridge.domain.rpc.AccountAPI;
import org.apache.rocketmq.eventbridge.event.EventBridgeEvent;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.server.reactive.ServerHttpRequest;
import org.springframework.util.CollectionUtils;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestHeader;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.server.ServerWebExchange;
import reactor.core.publisher.Mono;

import java.util.List;
import java.util.Map;

@RestController
@RequestMapping("/")
public class EventDataController {

    @Autowired
    EventDataHandler eventDataHandler;

    @Autowired
    AccountAPI accountAPI;

    @Autowired
    EventConverterAdapter eventConverterAdapter;

    @Autowired
    HttpEventConverter httpEventConverter;

    @PostMapping(value = {"putEvents"})
    public Mono<PutEventsResponse> putEvents(@RequestHeader Map<String, String> headers, @RequestBody byte[] body) {
        return Mono.subscriberContext()
            .flatMap(ctx -> {
                List<CloudEvent> cloudEvents = eventConverterAdapter.toEventsRequest(headers, body);
                List<EventBridgeEvent> eventList = this.converterEventBridgeEvent(cloudEvents);
                return eventDataHandler.putEvents(accountAPI.getResourceOwnerAccountId(ctx), eventList);
            });
    }

    @RequestMapping(value = {"webhook/putEvents"})
    public Mono<PutEventsResponse> putHttpEvents(ServerWebExchange serverWebExchange,
        @RequestHeader Map<String, String> headers, @RequestBody byte[] body, @RequestParam("token") String token) {
        return Mono.subscriberContext()
            .flatMap(ctx -> {
                ServerHttpRequest request = serverWebExchange.getRequest();
                List<CloudEvent> cloudEvents = httpEventConverter.toEventBridgeEvent(request, body, headers,
                    accountAPI.getResourceOwnerAccountId(ctx), token);
                List<EventBridgeEvent> eventList = this.converterEventBridgeEvent(cloudEvents);
                return eventDataHandler.putEvents(accountAPI.getResourceOwnerAccountId(ctx), eventList);
            });
    }

    private List<EventBridgeEvent> converterEventBridgeEvent(List<CloudEvent> cloudEvents) {
        List<EventBridgeEvent> eventList = Lists.newArrayListWithCapacity(cloudEvents.size());
        if (CollectionUtils.isEmpty(cloudEvents)) {
            return eventList;
        }
        cloudEvents.forEach(cloudEvent -> {
            EventBridgeEvent event = EventBridgeEvent.builder()
                .id(cloudEvent.getId())
                .source(cloudEvent.getSource())
                .type(cloudEvent.getType())
                .subject(cloudEvent.getSubject())
                .specversion(cloudEvent.getSpecVersion()
                    .toString())
                .dataschema(cloudEvent.getDataSchema())
                .datacontenttype(cloudEvent.getDataContentType())
                .time(cloudEvent.getTime())
                .data(cloudEvent.getData()
                    .toBytes())
                .build();
            if (cloudEvent.getExtensionNames() != null) {
                cloudEvent.getExtensionNames()
                    .forEach(extensionName -> {
                        event.addExtension(extensionName, cloudEvent.getExtension(extensionName));
                    });
            }
            eventList.add(event);
        });
        return eventList;
    }
}
