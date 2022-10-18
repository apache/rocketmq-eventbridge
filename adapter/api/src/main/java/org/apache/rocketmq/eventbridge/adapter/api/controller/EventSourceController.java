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
import java.util.List;
import org.apache.rocketmq.eventbridge.adapter.api.dto.source.CreateEventSourceRequest;
import org.apache.rocketmq.eventbridge.adapter.api.dto.source.CreateEventSourceResponse;
import org.apache.rocketmq.eventbridge.adapter.api.dto.source.DeleteEventSourceRequest;
import org.apache.rocketmq.eventbridge.adapter.api.dto.source.DeleteEventSourceResponse;
import org.apache.rocketmq.eventbridge.adapter.api.dto.source.EventSourceDTO;
import org.apache.rocketmq.eventbridge.adapter.api.dto.source.GetEventSourceRequest;
import org.apache.rocketmq.eventbridge.adapter.api.dto.source.GetEventSourceResponse;
import org.apache.rocketmq.eventbridge.adapter.api.dto.source.ListEventSourcesRequest;
import org.apache.rocketmq.eventbridge.adapter.api.dto.source.ListEventSourcesResponse;
import org.apache.rocketmq.eventbridge.adapter.api.dto.source.UpdateEventSourceRequest;
import org.apache.rocketmq.eventbridge.adapter.api.dto.source.UpdateEventSourceResponse;
import org.apache.rocketmq.eventbridge.domain.common.enums.EventSourceTypeEnum;
import org.apache.rocketmq.eventbridge.domain.model.PaginationResult;
import org.apache.rocketmq.eventbridge.domain.model.source.EventSource;
import org.apache.rocketmq.eventbridge.domain.model.source.EventSourceService;
import org.apache.rocketmq.eventbridge.domain.model.source.EventSourceServiceFactory;
import org.apache.rocketmq.eventbridge.domain.rpc.AccountAPI;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import reactor.core.publisher.Mono;

@RestController
@RequestMapping("/source/")
public class EventSourceController {

    @Autowired
    AccountAPI accountAPI;

    @Autowired
    EventSourceServiceFactory eventSourceServiceFactory;

    @PostMapping(value = {"createEventSource"})
    public Mono<CreateEventSourceResponse> createEventSource(
        @RequestBody CreateEventSourceRequest createEventSourceRequest) {
        return Mono.subscriberContext()
            .map(ctx -> {
                EventSourceService eventSourceService = eventSourceServiceFactory.getEventSourceService(
                    EventSourceTypeEnum.USER_DEFINED.name(), createEventSourceRequest.getClassName());
                eventSourceService.createEventSource(accountAPI.getResourceOwnerAccountId(ctx),
                    createEventSourceRequest.getEventBusName(), createEventSourceRequest.getEventSourceName(),
                    createEventSourceRequest.getDescription(), createEventSourceRequest.getClassName(),
                    createEventSourceRequest.getConfig());
                return new CreateEventSourceResponse(createEventSourceRequest.getEventSourceName());
            });
    }

    @PostMapping(value = {"updateEventSource"})
    public Mono<UpdateEventSourceResponse> updateEventSource(
        @RequestBody UpdateEventSourceRequest updateEventSourceRequest) {
        return Mono.subscriberContext()
            .map(ctx -> {
                EventSourceService eventSourceService = eventSourceServiceFactory.getEventSourceService(
                    accountAPI.getResourceOwnerAccountId(ctx), updateEventSourceRequest.getEventBusName(),
                    updateEventSourceRequest.getEventSourceName());
                eventSourceService.updateEventSource(accountAPI.getResourceOwnerAccountId(ctx),
                    updateEventSourceRequest.getEventBusName(), updateEventSourceRequest.getEventSourceName(),
                    updateEventSourceRequest.getDescription(), updateEventSourceRequest.getClassName(),
                    updateEventSourceRequest.getStatus(), updateEventSourceRequest.getConfig());
                return new UpdateEventSourceResponse();
            });
    }

    @PostMapping(value = {"deleteEventSource"})
    public Mono<DeleteEventSourceResponse> deleteEventSource(
        @RequestBody DeleteEventSourceRequest deleteEventSourceRequest) {
        return Mono.subscriberContext()
            .map(ctx -> {
                EventSourceService eventSourceService = eventSourceServiceFactory.getEventSourceService(
                    accountAPI.getResourceOwnerAccountId(ctx), deleteEventSourceRequest.getEventBusName(),
                    deleteEventSourceRequest.getEventSourceName());
                eventSourceService.deleteEventSource(accountAPI.getResourceOwnerAccountId(ctx),
                    deleteEventSourceRequest.getEventBusName(), deleteEventSourceRequest.getEventSourceName());
                return new DeleteEventSourceResponse();
            });
    }

    @PostMapping(value = {"getEventSource"})
    public Mono<GetEventSourceResponse> getEventSource(@RequestBody GetEventSourceRequest getEventSourceRequest) {
        return Mono.subscriberContext()
            .map(ctx -> {
                EventSourceService eventSourceService = eventSourceServiceFactory.getEventSourceService(
                    accountAPI.getResourceOwnerAccountId(ctx), getEventSourceRequest.getEventBusName(),
                    getEventSourceRequest.getEventSourceName());
                EventSource eventSource = eventSourceService.getEventSource(accountAPI.getResourceOwnerAccountId(ctx),
                    getEventSourceRequest.getEventBusName(), getEventSourceRequest.getEventSourceName());
                return new GetEventSourceResponse(eventSource.getEventBusName(), eventSource.getName(),
                    eventSource.getDescription(), eventSource.getClassName(), eventSource.getConfig());
            });
    }

    @PostMapping(value = {"listEventSources"})
    public Mono<ListEventSourcesResponse> listEventSources(
        @RequestBody ListEventSourcesRequest listEventSourcesRequest) {
        return Mono.subscriberContext()
            .map(ctx -> {
                EventSourceService eventSourceService = eventSourceServiceFactory.getDefaultEventSourceService();
                PaginationResult<List<EventSource>> paginationResult = eventSourceService.listEventSources(
                    accountAPI.getResourceOwnerAccountId(ctx), listEventSourcesRequest.getEventBusName(),
                    listEventSourcesRequest.getNextToken(), listEventSourcesRequest.getMaxResults());
                List<EventSourceDTO> eventSourceDTOS = Lists.newArrayList();
                paginationResult.getData()
                    .forEach(eventSource -> {
                        EventSourceDTO eventSourceDTO = EventSourceDTO.builder()
                            .eventBusName(eventSource.getEventBusName())
                            .eventSourceName(eventSource.getName())
                            .description(eventSource.getDescription())
                            .gmtCreate(eventSource.getGmtCreate())
                            .gmtModify(eventSource.getGmtModify())
                            .build();
                        eventSourceDTOS.add(eventSourceDTO);
                    });
                return new ListEventSourcesResponse(eventSourceDTOS, paginationResult.getNextToken(),
                    paginationResult.getTotal(), listEventSourcesRequest.getMaxResults());
            });
    }

}
