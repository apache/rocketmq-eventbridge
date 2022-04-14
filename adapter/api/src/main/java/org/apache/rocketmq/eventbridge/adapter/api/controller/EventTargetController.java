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
import java.util.stream.Collectors;

import org.apache.rocketmq.eventbridge.adapter.api.converter.EventTargetConverter;
import org.apache.rocketmq.eventbridge.adapter.api.converter.EventTargetDTOConverter;
import org.apache.rocketmq.eventbridge.adapter.api.dto.target.CreateTargetsRequest;
import org.apache.rocketmq.eventbridge.adapter.api.dto.target.CreateTargetsResponse;
import org.apache.rocketmq.eventbridge.adapter.api.dto.target.DeleteTargetsRequest;
import org.apache.rocketmq.eventbridge.adapter.api.dto.target.DeleteTargetsResponse;
import org.apache.rocketmq.eventbridge.adapter.api.dto.target.EventTargetDTO;
import org.apache.rocketmq.eventbridge.adapter.api.dto.target.ListTargetsRequest;
import org.apache.rocketmq.eventbridge.adapter.api.dto.target.ListTargetsResponse;
import org.apache.rocketmq.eventbridge.adapter.api.dto.target.UpdateTargetsRequest;
import org.apache.rocketmq.eventbridge.adapter.api.dto.target.UpdateTargetsResponse;
import org.apache.rocketmq.eventbridge.domain.model.target.EventTarget;
import org.apache.rocketmq.eventbridge.domain.model.target.EventTargetService;
import org.apache.rocketmq.eventbridge.domain.rpc.AccountAPI;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/target/")
public class EventTargetController {

    @Autowired
    EventTargetService eventTargetService;

    @Autowired
    AccountAPI accountAPI;

    @PostMapping(value = {"createEventTargets"})
    public CreateTargetsResponse createTargets(@RequestBody CreateTargetsRequest createTargetsRequest) {
        List<EventTarget> eventTargetList = EventTargetConverter.convertEventTargets(
            accountAPI.getResourceOwnerAccountId(), createTargetsRequest.getEventBusName(),
            createTargetsRequest.getEventRuleName(), createTargetsRequest.getEventTargets());
        eventTargetService.createTargets(accountAPI.getResourceOwnerAccountId(), createTargetsRequest.getEventBusName(),
            createTargetsRequest.getEventRuleName(), eventTargetList);
        return new CreateTargetsResponse();
    }

    @PostMapping(value = {"updateEventTargets"})
    public UpdateTargetsResponse updateTargets(@RequestBody UpdateTargetsRequest updateTargetsRequest) {
        List<EventTarget> eventTargetList = EventTargetConverter.convertEventTargets(
            accountAPI.getResourceOwnerAccountId(), updateTargetsRequest.getEventBusName(),
            updateTargetsRequest.getEventRuleName(), updateTargetsRequest.getEventTargets());
        eventTargetService.updateTargets(accountAPI.getResourceOwnerAccountId(), updateTargetsRequest.getEventBusName(),
            updateTargetsRequest.getEventRuleName(), eventTargetList);
        return new UpdateTargetsResponse();
    }

    @PostMapping(value = {"deleteEventTargets"})
    public DeleteTargetsResponse deleteTargets(@RequestBody DeleteTargetsRequest deleteTargetsRequest) {
        eventTargetService.deleteTargets(accountAPI.getResourceOwnerAccountId(), deleteTargetsRequest.getEventBusName(),
            deleteTargetsRequest.getEventRuleName(), deleteTargetsRequest.getEventTargetNames());
        return new DeleteTargetsResponse();
    }

    @PostMapping(value = {"listEventTargets"})
    public ListTargetsResponse listEventTargets(@RequestBody ListTargetsRequest listTargetsRequest) {
        List<EventTarget> eventTargetRunnerList = eventTargetService.listTargets(accountAPI.getResourceOwnerAccountId(),
            listTargetsRequest.getEventBusName(), listTargetsRequest.getEventRuleName());
        List<EventTargetDTO> eventTargets = eventTargetRunnerList.stream()
            .map(entry -> EventTargetDTOConverter.convert(entry))
            .collect(Collectors.toList());
        ListTargetsResponse listTargetsResponse = new ListTargetsResponse();
        listTargetsResponse.setEventBusName(listTargetsRequest.getEventBusName());
        listTargetsResponse.setEventRuleName(listTargetsRequest.getEventRuleName());
        listTargetsResponse.setEventTargets(eventTargets);
        return listTargetsResponse;
    }

}
