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

package org.apache.rocketmq.eventbridge.domain.service;

import org.apache.rocketmq.eventbridge.domain.common.enums.AuthorizationTypeEnum;
import org.apache.rocketmq.eventbridge.domain.common.enums.NetworkTypeEnum;
import org.apache.rocketmq.eventbridge.domain.model.PaginationResult;
import org.apache.rocketmq.eventbridge.domain.model.connection.ConnectionService;
import org.apache.rocketmq.eventbridge.domain.model.connection.ConnectionWithBLOBs;
import org.apache.rocketmq.eventbridge.domain.model.connection.parameter.AuthParameters;
import org.apache.rocketmq.eventbridge.domain.model.connection.parameter.BasicAuthParameters;
import org.apache.rocketmq.eventbridge.domain.model.connection.parameter.ConnectionDTO;
import org.apache.rocketmq.eventbridge.domain.model.connection.parameter.NetworkParameters;
import org.apache.rocketmq.eventbridge.domain.repository.ConnectionRepository;
import org.apache.rocketmq.eventbridge.domain.rpc.SecretManagerAPI;
import org.apache.rocketmq.eventbridge.domain.rpc.NetworkServiceAPI;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.MockitoJUnitRunner;
import org.springframework.test.util.ReflectionTestUtils;

import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

import static org.mockito.ArgumentMatchers.any;
import static org.mockito.ArgumentMatchers.anyInt;
import static org.mockito.ArgumentMatchers.anyString;

@RunWith(MockitoJUnitRunner.class)
public class ConnectionServiceTest {

    @InjectMocks
    private ConnectionService connectionService;
    @Mock
    private SecretManagerAPI kmsAPI;
    @Mock
    private ConnectionRepository connectionRepository;
    @Mock
    private NetworkServiceAPI networkServiceAPI;

    @Before
    public void testBefore() throws Exception {
        ReflectionTestUtils.setField(connectionService, "connectionCountLimit", "9");
        Mockito.when(connectionRepository.createConnection(any())).thenReturn(Boolean.TRUE);
        Mockito.when(connectionRepository.deleteConnection(anyString(), anyString())).thenReturn(Boolean.TRUE);
        Mockito.when(connectionRepository.updateConnection(any(ConnectionWithBLOBs.class))).thenReturn(Boolean.TRUE);
        Mockito.when(connectionRepository.listConnections(anyString(), anyString(), anyString(), anyInt())).thenReturn(new ArrayList<>());
        Mockito.when(connectionRepository.getConnectionCount(any(), any())).thenReturn(8);
        ConnectionWithBLOBs eventConnectionWithBLOBs = new ConnectionWithBLOBs();
        eventConnectionWithBLOBs.setName(UUID.randomUUID().toString());
        eventConnectionWithBLOBs.setNetworkType(NetworkTypeEnum.PUBLIC_NETWORK.getNetworkType());
        Mockito.when(connectionRepository.getConnection(any(), any())).thenReturn(eventConnectionWithBLOBs);
        Mockito.when(networkServiceAPI.createPrivateNetwork()).thenReturn(Boolean.TRUE);
        Mockito.when(networkServiceAPI.deletePrivateNetwork()).thenReturn(Boolean.FALSE);
    }

    @Test
    public void testCreateConnection() throws Exception {
        Mockito.when(connectionRepository.getConnection(any(), any())).thenReturn(null);
        Mockito.when(kmsAPI.createSecretName(anyString(), anyString(), anyString())).thenReturn(UUID.randomUUID().toString());
        Mockito.doNothing().when(kmsAPI).deleteSecretName(anyString());
        Mockito.when(kmsAPI.getSecretName(anyString(), anyString())).thenReturn(UUID.randomUUID().toString());
        ConnectionDTO connectionDTO = new ConnectionDTO();
        connectionDTO.setConnectionName(UUID.randomUUID().toString());
        connectionDTO.setDescription(UUID.randomUUID().toString());
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
        final String connection = connectionService.createConnection(connectionDTO, UUID.randomUUID().toString());
        Assert.assertNotNull(connection);
    }

    @Test
    public void testDeleteConnection() throws Exception {
        Mockito.doNothing().when(kmsAPI).deleteSecretName(anyString());
        Mockito.when(connectionRepository.deleteConnection(any(), any())).thenReturn(Boolean.TRUE);
        connectionService.deleteConnection(UUID.randomUUID().toString(), UUID.randomUUID().toString());
    }

    @Test
    public void testUpdateConnection() {
        Mockito.when(connectionRepository.updateConnection(any())).thenReturn(Boolean.TRUE);
        ConnectionDTO connectionDTO = new ConnectionDTO();
        connectionDTO.setConnectionName(UUID.randomUUID().toString());
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
        connectionService.updateConnection(connectionDTO, UUID.randomUUID().toString());
    }

    @Test
    public void testGetConnection() {
        final ConnectionWithBLOBs connection = connectionService.getConnection(UUID.randomUUID().toString(), UUID.randomUUID().toString());
        Assert.assertNotNull(connection);
    }

    @Test
    public void testListConnections() {
        final PaginationResult<List<ConnectionWithBLOBs>> listPaginationResult = connectionService.listConnections(UUID.randomUUID().toString(), UUID.randomUUID().toString(), "0", 10);
        Assert.assertNotNull(listPaginationResult.getData());
    }
}
