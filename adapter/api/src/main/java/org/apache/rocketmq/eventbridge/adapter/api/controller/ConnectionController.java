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
import org.apache.rocketmq.eventbridge.adapter.api.dto.BaseRequest;
import org.apache.rocketmq.eventbridge.adapter.api.dto.connection.*;
import org.apache.rocketmq.eventbridge.domain.common.enums.AuthorizationTypeEnum;
import org.apache.rocketmq.eventbridge.domain.common.enums.NetworkTypeEnum;
import org.apache.rocketmq.eventbridge.domain.model.PaginationResult;
import org.apache.rocketmq.eventbridge.domain.model.connection.ConnectionDTO;
import org.apache.rocketmq.eventbridge.domain.model.connection.ConnectionService;
import org.apache.rocketmq.eventbridge.domain.model.connection.parameter.ApiKeyAuthParameters;
import org.apache.rocketmq.eventbridge.domain.model.connection.parameter.BasicAuthParameters;
import org.apache.rocketmq.eventbridge.domain.model.connection.parameter.OAuthParameters;
import org.apache.rocketmq.eventbridge.domain.rpc.AccountAPI;
import org.springframework.beans.BeanUtils;
import org.springframework.util.CollectionUtils;
import org.springframework.web.bind.annotation.*;
import reactor.core.publisher.Mono;
import reactor.util.context.Context;

import javax.annotation.Resource;
import javax.validation.ConstraintViolation;
import javax.validation.Validator;
import java.util.Arrays;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.stream.Collectors;

@RestController
@RequestMapping("/connection/")
public class ConnectionController {

    @Resource
    private ConnectionService connectionService;
    @Resource
    private AccountAPI accountAPI;
    @Resource
    private Validator validator;

    @WebLog
    @PostMapping("createConnection")
    public Mono<CreateConnectionResponse> createConnection(
            @RequestBody CreateConnectionRequest createConnectionRequest) {
        return Mono.subscriberContext()
                .map(ctx -> {
                    final Set<ConstraintViolation<CreateConnectionRequest>> validate = validator.validate(
                            createConnectionRequest);
                    List<String> errMessage = validate.stream()
                            .map(ConstraintViolation::getMessage)
                            .collect(Collectors.toList());
                    if (!CollectionUtils.isEmpty(errMessage)) {
                        return new CreateConnectionResponse(null).parameterCheckFailRes(errMessage.toString());
                    }
                    ConnectionDTO connectionDTO = getEventConnectionWithBLOBs(ctx, createConnectionRequest);
                    return new CreateConnectionResponse(connectionService.createConnection(connectionDTO)).success();
                });
    }

    @WebLog
    @PostMapping("deleteConnection")
    public Mono<DeleteConnectionResponse> deleteConnection(
            @RequestBody DeleteConnectionRequest deleteConnectionRequest) {
        return Mono.subscriberContext()
                .map(ctx -> {
                    final Set<ConstraintViolation<DeleteConnectionRequest>> validate = validator.validate(
                            deleteConnectionRequest);
                    List<String> errMessage = validate.stream()
                            .map(ConstraintViolation::getMessage)
                            .collect(Collectors.toList());
                    if (!CollectionUtils.isEmpty(errMessage)) {
                        return new DeleteConnectionResponse().parameterCheckFailRes(errMessage.toString());
                    }
                    connectionService.deleteConnection(accountAPI.getResourceOwnerAccountId(ctx),
                            deleteConnectionRequest.getConnectionName());
                    return new DeleteConnectionResponse().success();
                });
    }

    @WebLog
    @PostMapping("updateConnection")
    public Mono<UpdateConnectionResponse> updateConnection(
            @RequestBody UpdateConnectionRequest updateConnectionRequest) {
        return Mono.subscriberContext()
                .map(ctx -> {
                    final Set<ConstraintViolation<UpdateConnectionRequest>> validate = validator.validate(
                            updateConnectionRequest);
                    List<String> errMessage = validate.stream()
                            .map(ConstraintViolation::getMessage)
                            .collect(Collectors.toList());
                    if (!CollectionUtils.isEmpty(errMessage)) {
                        return new UpdateConnectionResponse().parameterCheckFailRes(errMessage.toString());
                    }
                    ConnectionDTO connectionDTO = getEventConnectionWithBLOBs(ctx, updateConnectionRequest);
                    connectionService.updateConnection(connectionDTO, accountAPI.getResourceOwnerAccountId(ctx));
                    return new UpdateConnectionResponse().success();
                });
    }

    @WebLog
    @PostMapping("getConnection")
    public Mono<GetConnectionResponse> getConnection(@RequestBody GetConnectionRequest getConnectionRequest) {
        return Mono.subscriberContext()
                .map(ctx -> {
                    final Set<ConstraintViolation<GetConnectionRequest>> validate = validator.validate(
                            getConnectionRequest);
                    List<String> errMessage = validate.stream()
                            .map(ConstraintViolation::getMessage)
                            .collect(Collectors.toList());
                    if (!CollectionUtils.isEmpty(errMessage)) {
                        return new GetConnectionResponse(null).parameterCheckFailRes(
                                errMessage.toString());
                    }
                    final List<ConnectionDTO> connectionDTOS = connectionService.getConnection(accountAPI.getResourceOwnerAccountId(ctx), getConnectionRequest.getConnectionName());
                    List<ConnectionResponse> connectionResponses = Lists.newArrayList();
                    connectionDTOS.forEach(connectionDTO -> {
                        ConnectionResponse connectionResponse = new ConnectionResponse();
                        BeanUtils.copyProperties(connectionDTO, connectionResponse);
                        connectionResponse.setGmtCreate(connectionDTO.getGmtCreate().getTime());
                        connectionResponse.setApiDestinationName(connectionDTO.getApiDestinationName());
                        connectionResponse.setId(connectionDTO.getId());
                        connectionResponses.add(dataMasking(connectionResponse));
                    });
                    return new GetConnectionResponse(connectionResponses).success();
                });
    }

    @WebLog
    @PostMapping("selectOneConnection")
    public Mono<GetConnectionResponse> selectOneConnection(@RequestBody GetConnectionRequest getConnectionRequest) {
        return Mono.subscriberContext()
                .map(ctx -> {
                    final Set<ConstraintViolation<GetConnectionRequest>> validate = validator.validate(getConnectionRequest);
                    List<String> errMessage = validate.stream().map(ConstraintViolation::getMessage).collect(Collectors.toList());
                    if (!CollectionUtils.isEmpty(errMessage)) {
                        return new GetConnectionResponse(null).parameterCheckFailRes(errMessage.toString());
                    }
                    final List<ConnectionDTO> connectionDTOS = connectionService.getConnection(accountAPI.getResourceOwnerAccountId(ctx), getConnectionRequest.getConnectionName());
                    List<ConnectionResponse> connectionResponses = Lists.newArrayList();
                    connectionDTOS.forEach(connectionDTO -> {
                        ConnectionResponse connectionResponse = new ConnectionResponse();
                        BeanUtils.copyProperties(connectionDTO, connectionResponse);
                        connectionResponse.setGmtCreate(connectionDTO.getGmtCreate().getTime());
                        connectionResponse.setApiDestinationName(connectionDTO.getApiDestinationName());
                        connectionResponse.setId(connectionDTO.getId());
                        connectionResponses.add(connectionResponse);
                    });
                    return new GetConnectionResponse(connectionResponses).success();
                });
    }

    @WebLog
    @PostMapping("listConnections")
    public Mono<ListConnectionResponse> listConnections(@RequestBody ListConnectionRequest listConnectionRequest) {
        return Mono.subscriberContext()
                .map(ctx -> {
                    final Set<ConstraintViolation<ListConnectionRequest>> validate = validator.validate(
                            listConnectionRequest);
                    List<String> errMessage = validate.stream()
                            .map(ConstraintViolation::getMessage)
                            .collect(Collectors.toList());
                    if (!CollectionUtils.isEmpty(errMessage)) {
                        return new ListConnectionResponse(null, null, null, 0).parameterCheckFailRes(errMessage.toString());
                    }
                    final PaginationResult<List<ConnectionDTO>> listPaginationResult = connectionService.listConnections(
                            accountAPI.getResourceOwnerAccountId(ctx), listConnectionRequest.getConnectionNamePrefix(),
                            listConnectionRequest.getNextToken(), listConnectionRequest.getMaxResults());
                    List<ConnectionResponse> connectionResponses = Lists.newArrayList();
                    listPaginationResult.getData()
                            .forEach(connectionDTO -> {
                                ConnectionResponse connectionResponse = new ConnectionResponse();
                                BeanUtils.copyProperties(connectionDTO, connectionResponse);
                                connectionResponse.setGmtCreate(connectionDTO.getGmtCreate().getTime());
                                connectionResponse.setApiDestinationName(connectionDTO.getApiDestinationName());
                                connectionResponse.setId(connectionDTO.getId());
                                connectionResponses.add(dataMasking(connectionResponse));
                            });
                    return new ListConnectionResponse(connectionResponses, listPaginationResult.getNextToken(),
                            listPaginationResult.getTotal(), listConnectionRequest.getMaxResults()).success();
                });
    }

    @PostMapping("listEnumsResponse")
    public Mono<ListEnumsResponse> listEnumsResponse() {
        return Mono.subscriberContext()
                .map(ctx -> {
                    ListEnumsResponse listEnumsResponse = new ListEnumsResponse();
                    listEnumsResponse.setAuthorizationTypeEnums(Arrays.stream(AuthorizationTypeEnum.values())
                            .collect(Collectors.toList()));
                    listEnumsResponse.setNetworkTypeEnums(Arrays.stream(NetworkTypeEnum.values())
                            .collect(Collectors.toList()));
                    return listEnumsResponse.success();
                });
    }

    private ConnectionDTO getEventConnectionWithBLOBs(Context ctx, BaseRequest baseRequest) {
        ConnectionDTO connectionDTO = new ConnectionDTO();
        BeanUtils.copyProperties(baseRequest, connectionDTO);
        connectionDTO.setAccountId(accountAPI.getResourceOwnerAccountId(ctx));
        return connectionDTO;
    }

    private ConnectionResponse dataMasking(ConnectionResponse connectionResponse) {
        if (connectionResponse.getAuthParameters() == null) {
            return connectionResponse;
        }
        ApiKeyAuthParameters apiKeyAuthParameters = connectionResponse.getAuthParameters().getApiKeyAuthParameters();
        BasicAuthParameters basicAuthParameters = connectionResponse.getAuthParameters().getBasicAuthParameters();
        OAuthParameters oauthParameters = connectionResponse.getAuthParameters().getOauthParameters();
        if (apiKeyAuthParameters != null) {
            apiKeyAuthParameters.setApiKeyValue("**");
            connectionResponse.getAuthParameters().setApiKeyAuthParameters(apiKeyAuthParameters);
            return connectionResponse;
        }
        if (basicAuthParameters != null) {
            basicAuthParameters.setPassword("**");
            connectionResponse.getAuthParameters().setBasicAuthParameters(basicAuthParameters);
            return connectionResponse;
        }
        if (oauthParameters != null) {
            OAuthParameters.ClientParameters clientParameters = oauthParameters.getClientParameters();
            clientParameters.setClientSecret("**");
            oauthParameters.setClientParameters(clientParameters);
        }
        return connectionResponse;
    }
}
