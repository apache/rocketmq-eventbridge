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
import org.apache.rocketmq.eventbridge.adapter.api.annotations.WebLog;
import org.apache.rocketmq.eventbridge.adapter.api.dto.ResponseResult;
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
import org.apache.rocketmq.eventbridge.domain.model.PaginationResult;
import org.apache.rocketmq.eventbridge.domain.model.apidestination.ApiDestinationDTO;
import org.apache.rocketmq.eventbridge.domain.model.apidestination.ApiDestinationService;
import org.apache.rocketmq.eventbridge.domain.model.apidestination.parameter.HttpApiParameters;
import org.apache.rocketmq.eventbridge.domain.rpc.AccountAPI;
import org.springframework.beans.BeanUtils;
import org.springframework.util.CollectionUtils;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;
import javax.validation.ConstraintViolation;
import javax.validation.Validator;
import java.util.List;
import java.util.Set;
import java.util.stream.Collectors;

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
    public ResponseResult<CreateApiDestinationResponse> createApiDestination(@RequestBody CreateApiDestinationRequest createApiDestinationRequest) {
        final Set<ConstraintViolation<CreateApiDestinationRequest>> validate = validator.validate(createApiDestinationRequest);
        List<String> errMessage = validate.stream().map(ConstraintViolation::getMessage).collect(Collectors.toList());
        if (!CollectionUtils.isEmpty(errMessage)) {
            return ResponseResult.fail(errMessage.toString());
        }
        ApiDestinationDTO apiDestinationDTO = getEventApiDestination(createApiDestinationRequest.getHttpApiParameters(), createApiDestinationRequest.getDescription(), createApiDestinationRequest.getConnectionName(), createApiDestinationRequest.getInvocationRateLimitPerSecond(), createApiDestinationRequest.getApiDestinationName(), accountAPI);
        return ResponseResult.success(new CreateApiDestinationResponse(apiDestinationService.createApiDestination(apiDestinationDTO)));
    }

    @WebLog
    @PostMapping("updateApiDestination")
    public ResponseResult<UpdateApiDestinationResponse> updateApiDestination(@RequestBody UpdateApiDestinationRequest updateApiDestinationRequest) {
        final Set<ConstraintViolation<UpdateApiDestinationRequest>> validate = validator.validate(updateApiDestinationRequest);
        List<String> errMessage = validate.stream().map(ConstraintViolation::getMessage).collect(Collectors.toList());
        if (!CollectionUtils.isEmpty(errMessage)) {
            return ResponseResult.fail(errMessage.toString());
        }
        ApiDestinationDTO apiDestinationDTO = getEventApiDestination(updateApiDestinationRequest.getHttpApiParameters(), updateApiDestinationRequest.getDescription(), updateApiDestinationRequest.getConnectionName(), updateApiDestinationRequest.getInvocationRateLimitPerSecond(), updateApiDestinationRequest.getApiDestinationName(), accountAPI);
        apiDestinationService.updateApiDestination(apiDestinationDTO);
        return ResponseResult.success();
    }

    @WebLog
    @PostMapping("getApiDestination")
    public ResponseResult<GetApiDestinationResponse> getApiDestination(@RequestBody GetApiDestinationRequest getApiDestinationRequest) {
        final Set<ConstraintViolation<GetApiDestinationRequest>> validate = validator.validate(getApiDestinationRequest);
        List<String> errMessage = validate.stream().map(ConstraintViolation::getMessage).collect(Collectors.toList());
        if (!CollectionUtils.isEmpty(errMessage)) {
            return ResponseResult.fail(errMessage.toString());
        }
        final ApiDestinationDTO apiDestinationDTO = apiDestinationService.getApiDestination(accountAPI.getResourceOwnerAccountId(), getApiDestinationRequest.getApiDestinationName());
        return ResponseResult.success(new GetApiDestinationResponse(apiDestinationDTO.getName(), apiDestinationDTO.getConnectionName(), apiDestinationDTO.getDescription(), apiDestinationDTO.getApiParams(), apiDestinationDTO.getInvocationRateLimitPerSecond()));
    }

    @WebLog
    @PostMapping("deleteApiDestination")
    public ResponseResult<DeleteApiDestinationResponse> deleteApiDestination(@RequestBody DeleteApiDestinationRequest deleteApiDestinationRequest) {
        final Set<ConstraintViolation<DeleteApiDestinationRequest>> validate = validator.validate(deleteApiDestinationRequest);
        List<String> errMessage = validate.stream().map(ConstraintViolation::getMessage).collect(Collectors.toList());
        if (!CollectionUtils.isEmpty(errMessage)) {
            return ResponseResult.fail(errMessage.toString());
        }
        apiDestinationService.deleteApiDestination(accountAPI.getResourceOwnerAccountId(), deleteApiDestinationRequest.getApiDestinationName());
        return ResponseResult.success();
    }

    @WebLog
    @PostMapping("listApiDestinations")
    public ResponseResult<ListApiDestinationsResponse> listApiDestinations(@RequestBody ListApiDestinationsRequest listApiDestinationsRequest) {
        final Set<ConstraintViolation<ListApiDestinationsRequest>> validate = validator.validate(listApiDestinationsRequest);
        List<String> errMessage = validate.stream().map(ConstraintViolation::getMessage).collect(Collectors.toList());
        if (!CollectionUtils.isEmpty(errMessage)) {
            return ResponseResult.fail(errMessage.toString());
        }
        final PaginationResult<List<ApiDestinationDTO>> listPaginationResult = apiDestinationService.listApiDestinations(accountAPI.getResourceOwnerAccountId(),
                listApiDestinationsRequest.getApiDestinationNamePrefix(), listApiDestinationsRequest.getNextToken(), listApiDestinationsRequest.getMaxResults());
        List<ApiDestinationsResponse> apiDestinationsResponses = Lists.newArrayList();
        listPaginationResult.getData()
                .forEach(eventApiDestination -> {
                    ApiDestinationsResponse apiDestinationsResponse = new ApiDestinationsResponse();
                    BeanUtils.copyProperties(eventApiDestination, apiDestinationsResponse);
                    apiDestinationsResponse.setApiDestinationName(eventApiDestination.getName());
                    apiDestinationsResponse.setHttpApiParameters(eventApiDestination.getApiParams());
                    apiDestinationsResponses.add(apiDestinationsResponse);
                });
        return ResponseResult.success(new ListApiDestinationsResponse(apiDestinationsResponses, listPaginationResult.getNextToken(), listPaginationResult.getTotal(), listApiDestinationsRequest.getMaxResults()));
    }

    private ApiDestinationDTO getEventApiDestination(HttpApiParameters apiParams, String description, String connectionName, Integer invocationRateLimitPerSecond, String name, AccountAPI accountAPI) {
        ApiDestinationDTO apiDestinationDTO = new ApiDestinationDTO();
        apiDestinationDTO.setApiParams(apiParams);
        apiDestinationDTO.setDescription(description);
        apiDestinationDTO.setConnectionName(connectionName);
        apiDestinationDTO.setInvocationRateLimitPerSecond(invocationRateLimitPerSecond);
        apiDestinationDTO.setName(name);
        apiDestinationDTO.setAccountId(accountAPI.getResourceOwnerAccountId());
        return apiDestinationDTO;
    }
}
