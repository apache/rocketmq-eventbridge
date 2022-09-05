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
import org.apache.rocketmq.eventbridge.adapter.api.dto.connection.ConnectionResponse;
import org.apache.rocketmq.eventbridge.adapter.api.dto.connection.CreateConnectionRequest;
import org.apache.rocketmq.eventbridge.adapter.api.dto.connection.CreateConnectionResponse;
import org.apache.rocketmq.eventbridge.adapter.api.dto.connection.DeleteConnectionRequest;
import org.apache.rocketmq.eventbridge.adapter.api.dto.connection.DeleteConnectionResponse;
import org.apache.rocketmq.eventbridge.adapter.api.dto.connection.GetConnectionRequest;
import org.apache.rocketmq.eventbridge.adapter.api.dto.connection.GetConnectionResponse;
import org.apache.rocketmq.eventbridge.adapter.api.dto.connection.ListConnectionRequest;
import org.apache.rocketmq.eventbridge.adapter.api.dto.connection.ListConnectionResponse;
import org.apache.rocketmq.eventbridge.adapter.api.dto.connection.ListEnumsResponse;
import org.apache.rocketmq.eventbridge.adapter.api.dto.connection.UpdateConnectionRequest;
import org.apache.rocketmq.eventbridge.adapter.api.dto.connection.UpdateConnectionResponse;
import org.apache.rocketmq.eventbridge.domain.common.enums.AuthorizationTypeEnum;
import org.apache.rocketmq.eventbridge.domain.common.enums.NetworkTypeEnum;
import org.apache.rocketmq.eventbridge.domain.model.PaginationResult;
import org.apache.rocketmq.eventbridge.domain.model.connection.ConnectionService;
import org.apache.rocketmq.eventbridge.domain.model.connection.ConnectionDTO;
import org.apache.rocketmq.eventbridge.domain.model.connection.parameter.ApiKeyAuthParameters;
import org.apache.rocketmq.eventbridge.domain.model.connection.parameter.BasicAuthParameters;
import org.apache.rocketmq.eventbridge.domain.model.connection.parameter.OAuthParameters;
import org.apache.rocketmq.eventbridge.domain.rpc.AccountAPI;
import org.springframework.beans.BeanUtils;
import org.springframework.util.CollectionUtils;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestHeader;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

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
    public CreateConnectionResponse createConnection(@RequestBody CreateConnectionRequest createConnectionRequest,@RequestHeader
    Map<String, Object> headers) {
        final Set<ConstraintViolation<CreateConnectionRequest>> validate = validator.validate(createConnectionRequest);
        List<String> errMessage = validate.stream().map(ConstraintViolation::getMessage).collect(Collectors.toList());
        if (!CollectionUtils.isEmpty(errMessage)) {
            return new CreateConnectionResponse(null).parameterCheckFailRes(errMessage.toString());
        }
        ConnectionDTO connectionDTO = getEventConnectionWithBLOBs(createConnectionRequest, headers);
        return new CreateConnectionResponse(connectionService.createConnection(connectionDTO)).success();
    }

    @WebLog
    @PostMapping("deleteConnection")
    public DeleteConnectionResponse deleteConnection(@RequestBody DeleteConnectionRequest deleteConnectionRequest,@RequestHeader Map<String, Object> headers) {
        final Set<ConstraintViolation<DeleteConnectionRequest>> validate = validator.validate(deleteConnectionRequest);
        List<String> errMessage = validate.stream().map(ConstraintViolation::getMessage).collect(Collectors.toList());
        if (!CollectionUtils.isEmpty(errMessage)) {
            return new DeleteConnectionResponse().parameterCheckFailRes(errMessage.toString());
        }
        connectionService.deleteConnection(accountAPI.getResourceOwnerAccountId(headers), deleteConnectionRequest.getConnectionName());
        return new DeleteConnectionResponse().success();
    }

    @WebLog
    @PostMapping("updateConnection")
    public UpdateConnectionResponse updateConnection(@RequestBody UpdateConnectionRequest updateConnectionRequest,@RequestHeader Map<String, Object> headers) {
        final Set<ConstraintViolation<UpdateConnectionRequest>> validate = validator.validate(updateConnectionRequest);
        List<String> errMessage = validate.stream().map(ConstraintViolation::getMessage).collect(Collectors.toList());
        if (!CollectionUtils.isEmpty(errMessage)) {
            return new UpdateConnectionResponse().parameterCheckFailRes(errMessage.toString());
        }
        ConnectionDTO connectionDTO = getEventConnectionWithBLOBs(updateConnectionRequest,headers);
        connectionService.updateConnection(connectionDTO, accountAPI.getResourceOwnerAccountId(headers));
        return new UpdateConnectionResponse().success();
    }

    @WebLog
    @PostMapping("getConnection")
    public GetConnectionResponse getConnection(@RequestBody GetConnectionRequest getConnectionRequest,@RequestHeader Map<String, Object> headers) {
        final Set<ConstraintViolation<GetConnectionRequest>> validate = validator.validate(getConnectionRequest);
        List<String> errMessage = validate.stream().map(ConstraintViolation::getMessage).collect(Collectors.toList());
        if (!CollectionUtils.isEmpty(errMessage)) {
            return new GetConnectionResponse(null).parameterCheckFailRes(errMessage.toString());
        }
        final List<ConnectionDTO> connectionDTOS = connectionService.getConnection(accountAPI.getResourceOwnerAccountId(headers), getConnectionRequest.getConnectionName());
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
    }

    @WebLog
    @PostMapping("selectOneConnection")
    public GetConnectionResponse selectOneConnection(@RequestBody GetConnectionRequest getConnectionRequest,@RequestHeader Map<String, Object> headers) {
        final Set<ConstraintViolation<GetConnectionRequest>> validate = validator.validate(getConnectionRequest);
        List<String> errMessage = validate.stream().map(ConstraintViolation::getMessage).collect(Collectors.toList());
        if (!CollectionUtils.isEmpty(errMessage)) {
            return new GetConnectionResponse(null).parameterCheckFailRes(errMessage.toString());
        }
        final List<ConnectionDTO> connectionDTOS = connectionService.getConnection(accountAPI.getResourceOwnerAccountId(headers), getConnectionRequest.getConnectionName());
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
    }

    @WebLog
    @PostMapping("listConnections")
    public ListConnectionResponse listConnections(@RequestBody ListConnectionRequest listConnectionRequest,@RequestHeader Map<String, Object> headers) {
        final Set<ConstraintViolation<ListConnectionRequest>> validate = validator.validate(listConnectionRequest);
        List<String> errMessage = validate.stream().map(ConstraintViolation::getMessage).collect(Collectors.toList());
        if (!CollectionUtils.isEmpty(errMessage)) {
            return new ListConnectionResponse(null, null, null, 0).parameterCheckFailRes(errMessage.toString());
        }
        final PaginationResult<List<ConnectionDTO>> listPaginationResult = connectionService.listConnections(accountAPI.getResourceOwnerAccountId(headers),
                listConnectionRequest.getConnectionNamePrefix(), listConnectionRequest.getNextToken(), listConnectionRequest.getMaxResults());
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
        return new ListConnectionResponse(connectionResponses, listPaginationResult.getNextToken(), listPaginationResult.getTotal(), listConnectionRequest.getMaxResults()).success();
    }

    @PostMapping("listEnumsResponse")
    public ListEnumsResponse listEnumsResponse(@RequestHeader Map<String, Object> headers) {
        ListEnumsResponse listEnumsResponse = new ListEnumsResponse();
        listEnumsResponse.setAuthorizationTypeEnums(Arrays.stream(AuthorizationTypeEnum.values()).collect(Collectors.toList()));
        listEnumsResponse.setNetworkTypeEnums(Arrays.stream(NetworkTypeEnum.values()).collect(Collectors.toList()));
        return listEnumsResponse.success();
    }

    private ConnectionDTO getEventConnectionWithBLOBs(BaseRequest baseRequest,Map<String, Object> headers) {
        ConnectionDTO connectionDTO = new ConnectionDTO();
        BeanUtils.copyProperties(baseRequest, connectionDTO);
        connectionDTO.setAccountId(accountAPI.getResourceOwnerAccountId(headers));
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
