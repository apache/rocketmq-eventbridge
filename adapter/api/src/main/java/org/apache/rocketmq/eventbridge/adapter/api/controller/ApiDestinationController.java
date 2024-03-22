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
import java.util.Set;
import java.util.stream.Collectors;
import javax.annotation.Resource;
import javax.validation.ConstraintViolation;
import javax.validation.Validator;
import org.apache.rocketmq.eventbridge.adapter.api.annotations.WebLog;
import org.apache.rocketmq.eventbridge.adapter.api.dto.apidestination.ApiDestinationsResponse;
import org.apache.rocketmq.eventbridge.adapter.api.dto.apidestination.CreateApiDestinationRequest;
import org.apache.rocketmq.eventbridge.adapter.api.dto.apidestination.CreateApiDestinationResponse;
import org.apache.rocketmq.eventbridge.adapter.api.dto.apidestination.DeleteApiDestinationRequest;
import org.apache.rocketmq.eventbridge.adapter.api.dto.apidestination.DeleteApiDestinationResponse;
import org.apache.rocketmq.eventbridge.adapter.api.dto.apidestination.GetApiDestinationRequest;
import org.apache.rocketmq.eventbridge.adapter.api.dto.apidestination.GetApiDestinationResponse;
import org.apache.rocketmq.eventbridge.adapter.api.dto.apidestination.ListApiDestinationsRequest;
import org.apache.rocketmq.eventbridge.adapter.api.dto.apidestination.ListApiDestinationsResponse;
import org.apache.rocketmq.eventbridge.adapter.api.dto.apidestination.UpdateApiDestinationRequest;
import org.apache.rocketmq.eventbridge.adapter.api.dto.apidestination.UpdateApiDestinationResponse;
import org.apache.rocketmq.eventbridge.domain.common.exception.EventBridgeErrorCode;
import org.apache.rocketmq.eventbridge.domain.model.PaginationResult;
import org.apache.rocketmq.eventbridge.domain.model.apidestination.ApiDestinationDTO;
import org.apache.rocketmq.eventbridge.domain.model.apidestination.ApiDestinationService;
import org.apache.rocketmq.eventbridge.domain.model.apidestination.parameter.HttpApiParameters;
import org.apache.rocketmq.eventbridge.domain.rpc.AccountAPI;
import org.apache.rocketmq.eventbridge.exception.EventBridgeException;
import org.springframework.beans.BeanUtils;
import org.springframework.util.CollectionUtils;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import reactor.core.publisher.Mono;
import reactor.util.context.Context;

@RestController
@RequestMapping("/api-destination/")
public class ApiDestinationController {

    @Resource
    private ApiDestinationService apiDestinationService;
    @Resource
    private AccountAPI accountAPI;
    @Resource
    private Validator validator;

    @WebLog
    @PostMapping("createApiDestination")
    public Mono<CreateApiDestinationResponse> createApiDestination(
        @RequestBody CreateApiDestinationRequest createApiDestinationRequest) {
        return Mono.subscriberContext()
            .map(ctx -> {
                final Set<ConstraintViolation<CreateApiDestinationRequest>> validate = validator.validate(
                    createApiDestinationRequest);
                List<String> errMessage = validate.stream()
                    .map(ConstraintViolation::getMessage)
                    .collect(Collectors.toList());
                if (!CollectionUtils.isEmpty(errMessage)) {
                    throw new EventBridgeException(EventBridgeErrorCode.RequestParameterInvalid, errMessage.toString());
                }
                ApiDestinationDTO apiDestinationDTO = getEventApiDestination(
                    createApiDestinationRequest.getHttpApiParameters(), createApiDestinationRequest.getDescription(),
                    createApiDestinationRequest.getConnectionName(),
                    createApiDestinationRequest.getInvocationRateLimitPerSecond(),
                    createApiDestinationRequest.getApiDestinationName(), accountAPI, ctx);
                return new CreateApiDestinationResponse(
                    apiDestinationService.createApiDestination(apiDestinationDTO)).success();
            });
    }

    @WebLog
    @PostMapping("updateApiDestination")
    public Mono<UpdateApiDestinationResponse> updateApiDestination(
        @RequestBody UpdateApiDestinationRequest updateApiDestinationRequest) {
        return Mono.subscriberContext()
            .map(ctx -> {
                final Set<ConstraintViolation<UpdateApiDestinationRequest>> validate = validator.validate(
                    updateApiDestinationRequest);
                List<String> errMessage = validate.stream()
                    .map(ConstraintViolation::getMessage)
                    .collect(Collectors.toList());
                if (!CollectionUtils.isEmpty(errMessage)) {
                    throw new EventBridgeException(EventBridgeErrorCode.RequestParameterInvalid, errMessage.toString());
                }
                ApiDestinationDTO apiDestinationDTO = getEventApiDestination(
                    updateApiDestinationRequest.getHttpApiParameters(), updateApiDestinationRequest.getDescription(),
                    updateApiDestinationRequest.getConnectionName(),
                    updateApiDestinationRequest.getInvocationRateLimitPerSecond(),
                    updateApiDestinationRequest.getApiDestinationName(), accountAPI, ctx);
                apiDestinationService.updateApiDestination(apiDestinationDTO);
                return new UpdateApiDestinationResponse().success();
            });
    }

    @WebLog
    @PostMapping("getApiDestination")
    public Mono<GetApiDestinationResponse> getApiDestination(
        @RequestBody GetApiDestinationRequest getApiDestinationRequest) {
        return Mono.subscriberContext()
            .map(ctx -> {
                final Set<ConstraintViolation<GetApiDestinationRequest>> validate = validator.validate(
                    getApiDestinationRequest);
                List<String> errMessage = validate.stream()
                    .map(ConstraintViolation::getMessage)
                    .collect(Collectors.toList());
                if (!CollectionUtils.isEmpty(errMessage)) {
                    throw new EventBridgeException(EventBridgeErrorCode.RequestParameterInvalid, errMessage.toString());
                }
                final ApiDestinationDTO apiDestinationDTO = apiDestinationService.getApiDestination(
                    accountAPI.getResourceOwnerAccountId(ctx), getApiDestinationRequest.getApiDestinationName());
                return new GetApiDestinationResponse(apiDestinationDTO.getName(), apiDestinationDTO.getConnectionName(),
                    apiDestinationDTO.getDescription(), apiDestinationDTO.getApiParams(),
                    apiDestinationDTO.getInvocationRateLimitPerSecond(), apiDestinationDTO.getGmtCreate()
                    .getTime()).success();
            });
    }

    @WebLog
    @PostMapping("deleteApiDestination")
    public Mono<DeleteApiDestinationResponse> deleteApiDestination(
        @RequestBody DeleteApiDestinationRequest deleteApiDestinationRequest) {
        return Mono.subscriberContext()
            .map(ctx -> {
                final Set<ConstraintViolation<DeleteApiDestinationRequest>> validate = validator.validate(
                    deleteApiDestinationRequest);
                List<String> errMessage = validate.stream()
                    .map(ConstraintViolation::getMessage)
                    .collect(Collectors.toList());
                if (!CollectionUtils.isEmpty(errMessage)) {
                    throw new EventBridgeException(EventBridgeErrorCode.RequestParameterInvalid, errMessage.toString());
                }
                apiDestinationService.deleteApiDestination(accountAPI.getResourceOwnerAccountId(ctx),
                    deleteApiDestinationRequest.getApiDestinationName());
                return new DeleteApiDestinationResponse().success();
            });
    }

    @WebLog
    @PostMapping("listApiDestinations")
    public Mono<ListApiDestinationsResponse> listApiDestinations(
        @RequestBody ListApiDestinationsRequest listApiDestinationsRequest) {
        return Mono.subscriberContext()
            .map(ctx -> {
                final Set<ConstraintViolation<ListApiDestinationsRequest>> validate = validator.validate(
                    listApiDestinationsRequest);
                List<String> errMessage = validate.stream()
                    .map(ConstraintViolation::getMessage)
                    .collect(Collectors.toList());
                if (!CollectionUtils.isEmpty(errMessage)) {
                    throw new EventBridgeException(EventBridgeErrorCode.RequestParameterInvalid, errMessage.toString());
                }
                listApiDestinationsRequest.checkMaxResultsAndNextToken();
                final PaginationResult<List<ApiDestinationDTO>> listPaginationResult
                    = apiDestinationService.listApiDestinations(accountAPI.getResourceOwnerAccountId(ctx),
                    listApiDestinationsRequest.getApiDestinationNamePrefix(),
                        listApiDestinationsRequest.getConnectionName(), listApiDestinationsRequest.getNextToken(),
                    listApiDestinationsRequest.getMaxResults());
                List<ApiDestinationsResponse> apiDestinationsResponses = Lists.newArrayList();
                listPaginationResult.getData()
                    .forEach(eventApiDestination -> {
                        ApiDestinationsResponse apiDestinationsResponse = new ApiDestinationsResponse();
                        BeanUtils.copyProperties(eventApiDestination, apiDestinationsResponse);
                        apiDestinationsResponse.setApiDestinationName(eventApiDestination.getName());
                        apiDestinationsResponse.setHttpApiParameters(eventApiDestination.getApiParams());
                        apiDestinationsResponse.setGmtCreate(eventApiDestination.getGmtCreate()
                            .getTime());
                        apiDestinationsResponses.add(apiDestinationsResponse);
                    });
                return new ListApiDestinationsResponse(apiDestinationsResponses, listPaginationResult.getNextToken(),
                    listPaginationResult.getTotal(), listApiDestinationsRequest.getMaxResults()).success();
            });
    }

    private ApiDestinationDTO getEventApiDestination(HttpApiParameters apiParams, String description,
        String connectionName, Integer invocationRateLimitPerSecond, String name, AccountAPI accountAPI, Context ctx) {
        ApiDestinationDTO apiDestinationDTO = new ApiDestinationDTO();
        apiDestinationDTO.setApiParams(apiParams);
        apiDestinationDTO.setDescription(description);
        apiDestinationDTO.setConnectionName(connectionName);
        apiDestinationDTO.setInvocationRateLimitPerSecond(invocationRateLimitPerSecond);
        apiDestinationDTO.setName(name);
        apiDestinationDTO.setAccountId(accountAPI.getResourceOwnerAccountId(ctx));
        return apiDestinationDTO;
    }
}
