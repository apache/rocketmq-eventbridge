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
import org.apache.rocketmq.eventbridge.adapter.api.converter.EventTargetDTOConverter;
import org.apache.rocketmq.eventbridge.adapter.api.dto.rule.CreateRuleRequest;
import org.apache.rocketmq.eventbridge.adapter.api.dto.rule.CreateRuleResponse;
import org.apache.rocketmq.eventbridge.adapter.api.dto.rule.DeleteRuleRequest;
import org.apache.rocketmq.eventbridge.adapter.api.dto.rule.DeleteRuleResponse;
import org.apache.rocketmq.eventbridge.adapter.api.dto.rule.DisableRuleRequest;
import org.apache.rocketmq.eventbridge.adapter.api.dto.rule.DisableRuleResponse;
import org.apache.rocketmq.eventbridge.adapter.api.dto.rule.EnableRuleRequest;
import org.apache.rocketmq.eventbridge.adapter.api.dto.rule.EnableRuleResponse;
import org.apache.rocketmq.eventbridge.adapter.api.dto.rule.EventRuleDTO;
import org.apache.rocketmq.eventbridge.adapter.api.dto.rule.GetRuleRequest;
import org.apache.rocketmq.eventbridge.adapter.api.dto.rule.GetRuleResponse;
import org.apache.rocketmq.eventbridge.adapter.api.dto.rule.ListRulesRequest;
import org.apache.rocketmq.eventbridge.adapter.api.dto.rule.ListRulesResponse;
import org.apache.rocketmq.eventbridge.adapter.api.dto.rule.UpdateRuleRequest;
import org.apache.rocketmq.eventbridge.adapter.api.dto.rule.UpdateRuleResponse;
import org.apache.rocketmq.eventbridge.adapter.api.dto.target.EventTargetDTO;
import org.apache.rocketmq.eventbridge.domain.model.PaginationResult;
import org.apache.rocketmq.eventbridge.domain.model.rule.EventRule;
import org.apache.rocketmq.eventbridge.domain.model.rule.EventRuleDetail;
import org.apache.rocketmq.eventbridge.domain.model.rule.EventRuleService;
import org.apache.rocketmq.eventbridge.domain.rpc.AccountAPI;
import org.apache.rocketmq.eventbridge.domain.service.EventRuleDomainService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import reactor.core.publisher.Mono;

@RestController
@RequestMapping("/rule/")
public class EventRuleController {

    @Autowired
    private EventRuleService eventRuleService;

    @Autowired
    private EventRuleDomainService eventRuleDomainService;

    @Autowired
    AccountAPI accountAPI;

    @PostMapping(value = {"createEventRule"})
    public Mono<CreateRuleResponse> createRule(@RequestBody CreateRuleRequest createRuleRequest) {
        return Mono.subscriberContext()
            .map(ctx -> {
                eventRuleService.createEventRule(accountAPI.getResourceOwnerAccountId(ctx),
                    createRuleRequest.getEventBusName(), createRuleRequest.getEventRuleName(),
                    createRuleRequest.getDescription(), createRuleRequest.getFilterPattern());
                return new CreateRuleResponse(createRuleRequest.getEventRuleName());
            });
    }

    @PostMapping(value = {"getEventRule"})
    public Mono<GetRuleResponse> getRule(@RequestBody GetRuleRequest getRuleRequest) {
        return Mono.subscriberContext()
            .map(ctx -> {
                EventRuleDetail eventRuleDetail = eventRuleDomainService.getEventRuleDetail(
                    accountAPI.getResourceOwnerAccountId(ctx), getRuleRequest.getEventBusName(),
                    getRuleRequest.getEventRuleName());

                List<EventTargetDTO> eventTargets = EventTargetDTOConverter.convert(eventRuleDetail.getEventTargets());
                GetRuleResponse getRuleResponse = GetRuleResponse.builder()
                    .eventBusName(eventRuleDetail.getEventBusName())
                    .eventRuleName(eventRuleDetail.getName())
                    .description(eventRuleDetail.getDescription())
                    .filterPattern(eventRuleDetail.getFilterPattern())
                    .status(eventRuleDetail.getStatus())
                    .gmtCreate(eventRuleDetail.getGmtCreate())
                    .gmtModify(eventRuleDetail.getGmtModify())
                    .eventTargets(eventTargets)
                    .build();
                return getRuleResponse;
            });
    }

    @PostMapping(value = {"deleteEventRule"})
    public Mono<DeleteRuleResponse> deleteRule(@RequestBody DeleteRuleRequest deleteRuleRequest) {
        return Mono.subscriberContext()
            .map(ctx -> {
                eventRuleDomainService.deleteEventRuleWithDependencies(accountAPI.getResourceOwnerAccountId(ctx),
                    deleteRuleRequest.getEventBusName(), deleteRuleRequest.getEventRuleName());
                return new DeleteRuleResponse();
            });
    }

    @PostMapping(value = {"updateEventRule"})
    public Mono<UpdateRuleResponse> updateRule(@RequestBody UpdateRuleRequest updateRuleRequest) {
        return Mono.subscriberContext()
            .map(ctx -> {
                eventRuleDomainService.updateEventRuleWithDependencies(accountAPI.getResourceOwnerAccountId(ctx),

                    updateRuleRequest.getEventBusName(), updateRuleRequest.getEventRuleName(),
                    updateRuleRequest.getDescription(), updateRuleRequest.getFilterPattern());
                return new UpdateRuleResponse();
            });
    }

    @PostMapping(value = {"listEventRules"})
    public Mono<ListRulesResponse> listRules(@RequestBody ListRulesRequest listRulesRequest) {
        return Mono.subscriberContext()
            .map(ctx -> {
                PaginationResult<List<EventRule>> paginationResult = eventRuleService.listEventRules(
                    accountAPI.getResourceOwnerAccountId(ctx), listRulesRequest.getEventBusName(),
                    listRulesRequest.getNextToken(), listRulesRequest.getMaxResults());
                List<EventRuleDTO> eventRules = Lists.newArrayList();
                paginationResult.getData()
                    .forEach(eventRule -> {
                        EventRuleDTO eventRuleDTO = EventRuleDTO.builder()
                            .eventBusName(eventRule.getEventBusName())
                            .eventRuleName(eventRule.getName())
                            .description(eventRule.getDescription())
                            .filterPattern(eventRule.getFilterPattern())
                            .status(eventRule.getStatus())
                            .gmtCreate(eventRule.getGmtCreate())
                            .gmtModify(eventRule.getGmtModify())
                            .build();
                        eventRules.add(eventRuleDTO);
                    });
                return new ListRulesResponse(eventRules, paginationResult.getNextToken(), paginationResult.getTotal(),
                    listRulesRequest.getMaxResults());
            });
    }

    @PostMapping(value = {"enableEventRule"})
    public Mono<EnableRuleResponse> enableRule(@RequestBody EnableRuleRequest enableRuleRequest) {
        return Mono.subscriberContext()
            .map(ctx -> {
                eventRuleDomainService.enableEventRuleWithDependencies(accountAPI.getResourceOwnerAccountId(ctx),
                    enableRuleRequest.getEventBusName(), enableRuleRequest.getEventRuleName());
                return new EnableRuleResponse();
            });
    }

    @PostMapping(value = {"disableEventRule"})
    public Mono<DisableRuleResponse> disableRule(@RequestBody DisableRuleRequest disableRuleRequest) {
        return Mono.subscriberContext()
            .map(ctx -> {
                eventRuleDomainService.disableEventRuleWithDependencies(accountAPI.getResourceOwnerAccountId(ctx),
                    disableRuleRequest.getEventBusName(), disableRuleRequest.getEventRuleName());
                return new DisableRuleResponse();
            });
    }

}
