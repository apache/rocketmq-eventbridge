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
import org.apache.rocketmq.eventbridge.adapter.api.dto.type.EventTypeDTO;
import org.apache.rocketmq.eventbridge.adapter.api.dto.type.ListEventTypesRequest;
import org.apache.rocketmq.eventbridge.adapter.api.dto.type.ListEventTypesResponse;
import org.apache.rocketmq.eventbridge.domain.model.PaginationResult;
import org.apache.rocketmq.eventbridge.domain.model.source.EventType;
import org.apache.rocketmq.eventbridge.domain.model.source.EventTypeService;
import org.apache.rocketmq.eventbridge.domain.rpc.AccountAPI;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import reactor.core.publisher.Mono;

@RestController
@RequestMapping("/type/")
public class EventTypeController {

    @Autowired
    AccountAPI accountAPI;

    @Autowired
    EventTypeService eventTypeService;

    @PostMapping(value = {"listEventTypes"})
    public Mono<ListEventTypesResponse> listEventTypes(@RequestBody ListEventTypesRequest listEventTypesRequest) {
        return Mono.subscriberContext()
            .map(ctx -> {
                PaginationResult<List<EventType>> paginationResult = eventTypeService.listEventTypes(
                    accountAPI.getResourceOwnerAccountId(ctx), listEventTypesRequest.getEventBusName(),
                    listEventTypesRequest.getEventSourceName(), listEventTypesRequest.getNextToken(),
                    listEventTypesRequest.getMaxResults());

                List<EventTypeDTO> eventTypeDTOS = Lists.newArrayList();
                paginationResult.getData()
                    .forEach(eventType -> {
                        EventTypeDTO eventTypeDTO = EventTypeDTO.builder()
                            .eventBusName(eventType.getEventBusName())
                            .eventSourceName(eventType.getEventSourceName())
                            .eventTypeName(eventType.getName())
                            .description(eventType.getDescription())
                            .gmtCreate(eventType.getGmtCreate())
                            .gmtModify(eventType.getGmtModify())
                            .build();
                        eventTypeDTOS.add(eventTypeDTO);
                    });
                return new ListEventTypesResponse(eventTypeDTOS, paginationResult.getNextToken(),
                    paginationResult.getTotal(), listEventTypesRequest.getMaxResults());
            });
    }

}
