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
import org.apache.rocketmq.eventbridge.adapter.api.dto.ResponseResult;
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
import org.apache.rocketmq.eventbridge.domain.common.exception.EventBridgeErrorCode;
import org.apache.rocketmq.eventbridge.domain.model.PaginationResult;
import org.apache.rocketmq.eventbridge.domain.model.connection.ConnectionService;
import org.apache.rocketmq.eventbridge.domain.model.connection.parameter.AuthParameters;
import org.apache.rocketmq.eventbridge.domain.model.connection.parameter.BasicAuthParameters;
import org.apache.rocketmq.eventbridge.domain.model.connection.ConnectionDTO;
import org.apache.rocketmq.eventbridge.domain.model.connection.parameter.NetworkParameters;
import org.apache.rocketmq.eventbridge.domain.rpc.AccountAPI;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.BDDMockito;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.MockitoJUnitRunner;

import javax.validation.ConstraintViolation;
import javax.validation.Validator;
import java.util.HashSet;
import java.util.List;
import java.util.Set;
import java.util.UUID;

import static org.mockito.ArgumentMatchers.any;
import static org.mockito.ArgumentMatchers.anyInt;
import static org.mockito.ArgumentMatchers.anyString;

@RunWith(MockitoJUnitRunner.class)
public class ConnectionControllerTest {

    @InjectMocks
    private ConnectionController connectionController;
    @Mock
    private ConnectionService connectionService;
    @Mock
    private Validator validator;
    @Mock
    private AccountAPI accountAPI;

    @Before
    public void testBefore() throws Exception {
        Mockito.when(accountAPI.getResourceOwnerAccountId()).thenReturn(UUID.randomUUID().toString());
    }

    @Test
    public void testCreateConnection() {
        Mockito.when(connectionService.createConnection(any(ConnectionDTO.class))).thenReturn(UUID.randomUUID().toString());
        Set<ConstraintViolation<CreateConnectionRequest>> constraintViolations = new HashSet<>();
        Mockito.when(validator.validate(any(CreateConnectionRequest.class))).thenReturn(constraintViolations);
        CreateConnectionRequest createConnectionRequest = new CreateConnectionRequest();
        createConnectionRequest.setConnectionName(UUID.randomUUID().toString());
        createConnectionRequest.setDescription(UUID.randomUUID().toString());
        NetworkParameters networkParameters = new NetworkParameters();
        networkParameters.setNetworkType(NetworkTypeEnum.PUBLIC_NETWORK.getNetworkType());
        networkParameters.setSecurityGroupId(UUID.randomUUID().toString());
        networkParameters.setVpcId(UUID.randomUUID().toString());
        networkParameters.setVswitcheId(UUID.randomUUID().toString());
        createConnectionRequest.setNetworkParameters(networkParameters);
        AuthParameters authParameters = new AuthParameters();
        BasicAuthParameters basicAuthParameters = new BasicAuthParameters();
        basicAuthParameters.setPassword(UUID.randomUUID().toString());
        basicAuthParameters.setUsername(UUID.randomUUID().toString());
        authParameters.setBasicAuthParameters(basicAuthParameters);
        authParameters.setAuthorizationType(AuthorizationTypeEnum.BASIC_AUTH.getType());
        createConnectionRequest.setAuthParameters(authParameters);
        final ResponseResult<CreateConnectionResponse> connection = connectionController.createConnection(createConnectionRequest);
        Assert.assertEquals(connection.getCode(), EventBridgeErrorCode.Success.getCode());
    }

    @Test
    public void testDeleteConnection() {
        Mockito.doNothing().when(connectionService).deleteConnection(anyString(), anyString());
        Set<ConstraintViolation<DeleteConnectionRequest>> constraintViolations = new HashSet<>();
        Mockito.when(validator.validate(any(DeleteConnectionRequest.class))).thenReturn(constraintViolations);
        DeleteConnectionRequest deleteConnectionRequest = new DeleteConnectionRequest();
        deleteConnectionRequest.setConnectionName(UUID.randomUUID().toString());
        final ResponseResult<DeleteConnectionResponse> deleteConnectionResponseResponseResult = connectionController.deleteConnection(deleteConnectionRequest);
        Assert.assertEquals(deleteConnectionResponseResponseResult.getCode(), EventBridgeErrorCode.Success.getCode());
    }

    @Test
    public void testUpdateConnection() {
        Mockito.doNothing().when(connectionService).updateConnection(any(ConnectionDTO.class), anyString());
        Set<ConstraintViolation<UpdateConnectionRequest>> constraintViolations = new HashSet<>();
        Mockito.when(validator.validate(any(UpdateConnectionRequest.class))).thenReturn(constraintViolations);
        UpdateConnectionRequest updateConnectionRequest = new UpdateConnectionRequest();
        updateConnectionRequest.setConnectionName(UUID.randomUUID().toString());
        updateConnectionRequest.setDescription(UUID.randomUUID().toString());
        NetworkParameters networkParameters = new NetworkParameters();
        networkParameters.setNetworkType(NetworkTypeEnum.PUBLIC_NETWORK.getNetworkType());
        networkParameters.setSecurityGroupId(UUID.randomUUID().toString());
        networkParameters.setVpcId(UUID.randomUUID().toString());
        networkParameters.setVswitcheId(UUID.randomUUID().toString());
        updateConnectionRequest.setNetworkParameters(networkParameters);
        AuthParameters authParameters = new AuthParameters();
        BasicAuthParameters basicAuthParameters = new BasicAuthParameters();
        basicAuthParameters.setPassword(UUID.randomUUID().toString());
        basicAuthParameters.setUsername(UUID.randomUUID().toString());
        authParameters.setBasicAuthParameters(basicAuthParameters);
        authParameters.setAuthorizationType(AuthorizationTypeEnum.BASIC_AUTH.getType());
        updateConnectionRequest.setAuthParameters(authParameters);
        final ResponseResult<UpdateConnectionResponse> updateConnectionResponseResponseResult = connectionController.updateConnection(updateConnectionRequest);
        Assert.assertEquals(updateConnectionResponseResponseResult.getCode(), EventBridgeErrorCode.Success.getCode());
    }

    @Test
    public void testGetConnection() {
        Set<ConstraintViolation<GetConnectionRequest>> constraintViolations = new HashSet<>();
        Mockito.when(validator.validate(any(GetConnectionRequest.class))).thenReturn(constraintViolations);
        final ConnectionDTO connectionDTO = new ConnectionDTO();
        NetworkParameters networkParameters = new NetworkParameters();
        networkParameters.setNetworkType(NetworkTypeEnum.PUBLIC_NETWORK.getNetworkType());
        networkParameters.setSecurityGroupId(UUID.randomUUID().toString());
        networkParameters.setVpcId(UUID.randomUUID().toString());
        networkParameters.setVswitcheId(UUID.randomUUID().toString());
        connectionDTO.setNetworkParameters(networkParameters);
        AuthParameters authParameters = new AuthParameters();
        BasicAuthParameters basicAuthParameters = new BasicAuthParameters();
        basicAuthParameters.setPassword(UUID.randomUUID().toString());
        basicAuthParameters.setUsername(UUID.randomUUID().toString());
        authParameters.setBasicAuthParameters(basicAuthParameters);
        authParameters.setAuthorizationType(AuthorizationTypeEnum.BASIC_AUTH.getType());
        connectionDTO.setAuthParameters(authParameters);
        BDDMockito.given(connectionService.getConnection(any(), any())).willReturn(connectionDTO);
        GetConnectionRequest getConnectionRequest = new GetConnectionRequest();
        getConnectionRequest.setConnectionName(UUID.randomUUID().toString());
        final ResponseResult<GetConnectionResponse> connection = connectionController.getConnection(getConnectionRequest);
        Assert.assertEquals(connection.getCode(), EventBridgeErrorCode.Success.getCode());
    }

    @Test
    public void testListConnections() {
        PaginationResult<List<ConnectionDTO>> result = new PaginationResult();
        List<ConnectionDTO> eventConnectionWithBLOBs = Lists.newArrayList();
        ConnectionDTO eventConnection = new ConnectionDTO();
        eventConnection.setConnectionName(UUID.randomUUID().toString());
        eventConnectionWithBLOBs.add(eventConnection);
        result.setData(eventConnectionWithBLOBs);
        result.setTotal(9);
        result.setNextToken("0");
        Mockito.when(connectionService.listConnections(any(), any(), any(), anyInt())).thenReturn(result);
        Set<ConstraintViolation<ListConnectionRequest>> constraintViolations = new HashSet<>();
        Mockito.when(validator.validate(any(ListConnectionRequest.class))).thenReturn(constraintViolations);
        ListConnectionRequest listConnectionRequest = new ListConnectionRequest();
        listConnectionRequest.setConnectionNamePrefix(UUID.randomUUID().toString());
        listConnectionRequest.setNextToken("0");
        listConnectionRequest.setMaxResults(10);
        final ResponseResult<ListConnectionResponse> listConnectionResponseResponseResult = connectionController.listConnections(listConnectionRequest);
        Assert.assertEquals(listConnectionResponseResponseResult.getCode(), EventBridgeErrorCode.Success.getCode());
    }

    @Test
    public void testListEnumsResponse() {
        final ResponseResult<ListEnumsResponse> listEnumsResponseResponseResult = connectionController.listEnumsResponse();
        Assert.assertEquals(listEnumsResponseResponseResult.getData().getNetworkTypeEnums().size(), NetworkTypeEnum.values().length);
    }
}
