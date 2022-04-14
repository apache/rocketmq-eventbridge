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

import java.util.List;

import com.google.common.collect.Lists;
import org.apache.rocketmq.eventbridge.adapter.api.dto.bus.CreateEventBusRequest;
import org.apache.rocketmq.eventbridge.adapter.api.dto.bus.CreateEventBusResponse;
import org.apache.rocketmq.eventbridge.adapter.api.dto.bus.DeleteEventBusRequest;
import org.apache.rocketmq.eventbridge.adapter.api.dto.bus.DeleteEventBusResponse;
import org.apache.rocketmq.eventbridge.adapter.api.dto.bus.EventBusDTO;
import org.apache.rocketmq.eventbridge.adapter.api.dto.bus.GetEventBusRequest;
import org.apache.rocketmq.eventbridge.adapter.api.dto.bus.GetEventBusResponse;
import org.apache.rocketmq.eventbridge.adapter.api.dto.bus.ListEventBusesRequest;
import org.apache.rocketmq.eventbridge.adapter.api.dto.bus.ListEventBusesResponse;
import org.apache.rocketmq.eventbridge.domain.model.PaginationResult;
import org.apache.rocketmq.eventbridge.domain.model.bus.EventBus;
import org.apache.rocketmq.eventbridge.domain.rpc.AccountAPI;
import org.apache.rocketmq.eventbridge.domain.service.EventBusDomainService;
import org.apache.rocketmq.eventbridge.domain.model.bus.EventBusService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/bus/")
public class EventBusController {

    @Autowired
    EventBusService eventBusService;

    @Autowired
    EventBusDomainService eventBusDomainService;

    @Autowired
    AccountAPI accountAPI;

    @PostMapping(value = {"createEventBus"})
    public CreateEventBusResponse createEventBus(@RequestBody CreateEventBusRequest createEventBusRequest) {
        eventBusService.createEventBus(accountAPI.getResourceOwnerAccountId(), createEventBusRequest.getEventBusName(),
            createEventBusRequest.getDescription());
        return new CreateEventBusResponse(createEventBusRequest.getEventBusName());
    }

    @PostMapping(value = {"getEventBus"})
    public GetEventBusResponse getEventBus(@RequestBody GetEventBusRequest getEventBusRequest) {
        EventBus eventbus = eventBusService.getEventBus(accountAPI.getResourceOwnerAccountId(),
            getEventBusRequest.getEventBusName());
        return new GetEventBusResponse(eventbus.getName(), eventbus.getDescription(), eventbus.getGmtCreate()
            .getTime());
    }

    @PostMapping(value = {"deleteEventBus"})
    public DeleteEventBusResponse deleteEventBus(@RequestBody DeleteEventBusRequest deleteEventBusRequest) {
        eventBusDomainService.deleteEventBusCheckDependencies(accountAPI.getResourceOwnerAccountId(),
            deleteEventBusRequest.getEventBusName());
        return new DeleteEventBusResponse();
    }

    @PostMapping(value = {"listEventBuses"})
    public ListEventBusesResponse listEventBuses(@RequestBody ListEventBusesRequest listEventBusesRequest) {
        PaginationResult<List<EventBus>> paginationResult = eventBusService.listEventBuses(
            accountAPI.getResourceOwnerAccountId(), listEventBusesRequest.getNextToken(),
            listEventBusesRequest.getMaxResults());
        List<EventBusDTO> eventBuses = Lists.newArrayList();
        paginationResult.getData()
            .forEach(eventBus -> {
                EventBusDTO eventBusDTO = new EventBusDTO();
                eventBusDTO.setEventBusName(eventBusDTO.getEventBusName());
                eventBusDTO.setDescription(eventBus.getDescription());
                eventBuses.add(eventBusDTO);
            });
        return new ListEventBusesResponse(eventBuses, paginationResult.getNextToken(), paginationResult.getTotal(),
            listEventBusesRequest.getMaxResults());
    }

}
