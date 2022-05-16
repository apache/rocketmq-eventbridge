package org.apache.rocketmq.eventbridge.adapter.api.controller;

import com.alibaba.fastjson.JSON;
import com.google.common.collect.Lists;
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
import org.apache.rocketmq.eventbridge.domain.model.connection.EventConnectionWithBLOBs;
import org.apache.rocketmq.eventbridge.domain.model.connection.parameter.AuthParameters;
import org.apache.rocketmq.eventbridge.domain.model.connection.parameter.BasicAuthParameters;
import org.apache.rocketmq.eventbridge.domain.model.connection.parameter.ConnectionDTO;
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
        Mockito.doNothing().when(connectionService).deleteConnection(anyString(), anyString());
        Mockito.doNothing().when(connectionService).updateConnection(any(ConnectionDTO.class), anyString());
        Mockito.when(connectionService.getConnectionCount(any(), any())).thenReturn(9);
        accountAPI = Mockito.mock(AccountAPI.class);
        Mockito.when(accountAPI.getResourceOwnerAccountId()).thenReturn(UUID.randomUUID().toString());
    }

    @Test
    public void testCreateConnection() {
        Mockito.when(connectionService.createConnection(any(ConnectionDTO.class), anyString())).thenReturn(UUID.randomUUID().toString());
        validator = Mockito.mock(Validator.class);
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
        final CreateConnectionResponse connection = connectionController.createConnection(createConnectionRequest);
        Assert.assertEquals(connection.getCode(), EventBridgeErrorCode.Success.getCode());
    }

    @Test
    public void testDeleteConnection() {
        validator = Mockito.mock(Validator.class);
        Set<ConstraintViolation<DeleteConnectionRequest>> constraintViolations = new HashSet<>();
        Mockito.when(validator.validate(any(DeleteConnectionRequest.class))).thenReturn(constraintViolations);
        DeleteConnectionRequest deleteConnectionRequest = new DeleteConnectionRequest();
        deleteConnectionRequest.setConnectionName(UUID.randomUUID().toString());
        final DeleteConnectionResponse deleteConnectionResponse = connectionController.deleteConnection(deleteConnectionRequest);
        Assert.assertEquals(deleteConnectionResponse.getCode(), EventBridgeErrorCode.Success.getCode());
    }

    @Test
    public void testUpdateConnection() {
        validator = Mockito.mock(Validator.class);
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
        final UpdateConnectionResponse updateConnectionResponse = connectionController.updateConnection(updateConnectionRequest);
        Assert.assertEquals(updateConnectionResponse.getCode(), EventBridgeErrorCode.Success.getCode());
    }

    @Test
    public void testGetConnection() {
        validator = Mockito.mock(Validator.class);
        Set<ConstraintViolation<GetConnectionRequest>> constraintViolations = new HashSet<>();
        Mockito.when(validator.validate(any(GetConnectionRequest.class))).thenReturn(constraintViolations);
        final EventConnectionWithBLOBs connection = new EventConnectionWithBLOBs();
        connection.setNetworkType(NetworkTypeEnum.PUBLIC_NETWORK.getNetworkType());
        NetworkParameters networkParameters = new NetworkParameters();
        networkParameters.setNetworkType(NetworkTypeEnum.PUBLIC_NETWORK.getNetworkType());
        networkParameters.setSecurityGroupId(UUID.randomUUID().toString());
        networkParameters.setVpcId(UUID.randomUUID().toString());
        networkParameters.setVswitcheId(UUID.randomUUID().toString());
        connection.setNetworkParameters(JSON.toJSONString(networkParameters));
        AuthParameters authParameters = new AuthParameters();
        BasicAuthParameters basicAuthParameters = new BasicAuthParameters();
        basicAuthParameters.setPassword(UUID.randomUUID().toString());
        basicAuthParameters.setUsername(UUID.randomUUID().toString());
        authParameters.setBasicAuthParameters(basicAuthParameters);
        authParameters.setAuthorizationType(AuthorizationTypeEnum.BASIC_AUTH.getType());
        connection.setAuthParameters(JSON.toJSONString(authParameters));
        connection.setAuthorizationType(AuthorizationTypeEnum.BASIC_AUTH.getType());
        BDDMockito.given(connectionService.getConnection(any(), any())).willReturn(connection);
        GetConnectionRequest getConnectionRequest = new GetConnectionRequest();
        getConnectionRequest.setConnectionName(UUID.randomUUID().toString());
        final GetConnectionResponse getConnectionResponse = connectionController.getConnection(getConnectionRequest);
        Assert.assertEquals(getConnectionResponse.getCode(), EventBridgeErrorCode.Success.getCode());
    }

    @Test
    public void testListConnections() {
        PaginationResult<List<EventConnectionWithBLOBs>> result = new PaginationResult();
        List<EventConnectionWithBLOBs> eventConnectionWithBLOBs = Lists.newArrayList();
        EventConnectionWithBLOBs  eventConnection = new EventConnectionWithBLOBs();
        eventConnection.setName(UUID.randomUUID().toString());
        eventConnectionWithBLOBs.add(eventConnection);
        result.setData(eventConnectionWithBLOBs);
        result.setTotal(9);
        result.setNextToken("0");
        Mockito.when(connectionService.listConnections(any(), any(), any(), anyInt())).thenReturn(result);
        validator = Mockito.mock(Validator.class);
        Set<ConstraintViolation<ListConnectionRequest>> constraintViolations = new HashSet<>();
        Mockito.when(validator.validate(any(ListConnectionRequest.class))).thenReturn(constraintViolations);
        ListConnectionRequest listConnectionRequest = new ListConnectionRequest();
        listConnectionRequest.setConnectionNamePrefix(UUID.randomUUID().toString());
        listConnectionRequest.setNextToken("0");
        listConnectionRequest.setMaxResults(10);
        final ListConnectionResponse listConnectionResponse = connectionController.listConnections(listConnectionRequest);
        Assert.assertEquals(listConnectionResponse.getCode(), EventBridgeErrorCode.Success.getCode());
    }

    @Test
    public void testListEnumsResponse() {
        final ListEnumsResponse listEnumsResponse = connectionController.listEnumsResponse();
        Assert.assertEquals(listEnumsResponse.getNetworkTypeEnums().size(), NetworkTypeEnum.values().length);
    }
}