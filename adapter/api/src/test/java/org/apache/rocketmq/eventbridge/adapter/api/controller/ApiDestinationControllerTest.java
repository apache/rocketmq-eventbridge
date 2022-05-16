package org.apache.rocketmq.eventbridge.adapter.api.controller;

import com.google.common.collect.Lists;
import org.apache.rocketmq.eventbridge.adapter.api.dto.apidestination.CreateApiDestinationRequest;
import org.apache.rocketmq.eventbridge.adapter.api.dto.apidestination.CreateApiDestinationResponse;
import org.apache.rocketmq.eventbridge.adapter.api.dto.apidestination.DeleteApiDestinationRequest;
import org.apache.rocketmq.eventbridge.adapter.api.dto.apidestination.DeleteApiDestinationResponse;
import org.apache.rocketmq.eventbridge.adapter.api.dto.apidestination.GetApiDestinationRequest;
import org.apache.rocketmq.eventbridge.adapter.api.dto.apidestination.GetApiDestinationResponse;
import org.apache.rocketmq.eventbridge.adapter.api.dto.apidestination.HttpApiParameters;
import org.apache.rocketmq.eventbridge.adapter.api.dto.apidestination.ListApiDestinationsRequest;
import org.apache.rocketmq.eventbridge.adapter.api.dto.apidestination.ListApiDestinationsResponse;
import org.apache.rocketmq.eventbridge.adapter.api.dto.apidestination.UpdateApiDestinationRequest;
import org.apache.rocketmq.eventbridge.adapter.api.dto.apidestination.UpdateApiDestinationResponse;
import org.apache.rocketmq.eventbridge.adapter.api.dto.connection.CreateConnectionRequest;
import org.apache.rocketmq.eventbridge.domain.common.exception.EventBridgeErrorCode;
import org.apache.rocketmq.eventbridge.domain.model.PaginationResult;
import org.apache.rocketmq.eventbridge.domain.model.apidestination.ApiDestinationService;
import org.apache.rocketmq.eventbridge.domain.model.apidestination.EventApiDestination;
import org.apache.rocketmq.eventbridge.domain.rpc.AccountAPI;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
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

@RunWith(MockitoJUnitRunner.class)
public class ApiDestinationControllerTest {

    @InjectMocks
    private ApiDestinationController apiDestinationController;
    @Mock
    private ApiDestinationService apiDestinationService;
    @Mock
    private Validator validator;
    @Mock
    private AccountAPI accountAPI;

    @Before
    public void testBefore() {
        Mockito.when(accountAPI.getResourceOwnerAccountId()).thenReturn(UUID.randomUUID().toString());
    }

    @Test
    public void testCreateApiDestination() {
        Set<ConstraintViolation<CreateConnectionRequest>> constraintViolations = new HashSet<>();
        Mockito.when(validator.validate(any(CreateConnectionRequest.class))).thenReturn(constraintViolations);
        Mockito.when(apiDestinationService.createApiDestination(any())).thenReturn(UUID.randomUUID().toString());
        CreateApiDestinationRequest createApiDestinationRequest = new CreateApiDestinationRequest();
        createApiDestinationRequest.setApiDestinationName(UUID.randomUUID().toString());
        createApiDestinationRequest.setDescription(UUID.randomUUID().toString());
        HttpApiParameters httpApiParameters = new HttpApiParameters();
        httpApiParameters.setEndpoint(UUID.randomUUID().toString());
        httpApiParameters.setMethod(UUID.randomUUID().toString());
        createApiDestinationRequest.setHttpApiParameters(httpApiParameters);
        createApiDestinationRequest.setInvocationRateLimitPerSecond(11);
        final CreateApiDestinationResponse apiDestination = apiDestinationController.createApiDestination(createApiDestinationRequest);
        Assert.assertEquals(apiDestination.getCode(), EventBridgeErrorCode.Success.getCode());
    }

    @Test
    public void testUpdateApiDestination() {
        Set<ConstraintViolation<UpdateApiDestinationRequest>> constraintViolations = new HashSet<>();
        Mockito.when(validator.validate(any(UpdateApiDestinationRequest.class))).thenReturn(constraintViolations);
        Mockito.when(apiDestinationService.updateApiDestination(any())).thenReturn(Boolean.TRUE);
        UpdateApiDestinationRequest updateApiDestinationRequest = new UpdateApiDestinationRequest();
        updateApiDestinationRequest.setApiDestinationName(UUID.randomUUID().toString());
        updateApiDestinationRequest.setDescription(UUID.randomUUID().toString());
        HttpApiParameters httpApiParameters = new HttpApiParameters();
        httpApiParameters.setEndpoint(UUID.randomUUID().toString());
        httpApiParameters.setMethod(UUID.randomUUID().toString());
        updateApiDestinationRequest.setHttpApiParameters(httpApiParameters);
        updateApiDestinationRequest.setInvocationRateLimitPerSecond(11);
        final UpdateApiDestinationResponse updateApiDestinationResponse = apiDestinationController.updateApiDestination(updateApiDestinationRequest);
        Assert.assertEquals(updateApiDestinationResponse.getCode(), EventBridgeErrorCode.Success.getCode());
    }

    @Test
    public void testGetApiDestination() {
        Set<ConstraintViolation<GetApiDestinationRequest>> constraintViolations = new HashSet<>();
        Mockito.when(validator.validate(any(GetApiDestinationRequest.class))).thenReturn(constraintViolations);
        EventApiDestination eventApiDestination = new EventApiDestination();
        eventApiDestination.setName(UUID.randomUUID().toString());
        Mockito.when(apiDestinationService.getApiDestination(any(), any())).thenReturn(eventApiDestination);
        GetApiDestinationRequest getApiDestinationRequest = new GetApiDestinationRequest();
        getApiDestinationRequest.setApiDestinationName(UUID.randomUUID().toString());
        final GetApiDestinationResponse apiDestination = apiDestinationController.getApiDestination(getApiDestinationRequest);
        Assert.assertEquals(apiDestination.getCode(), EventBridgeErrorCode.Success.getCode());
    }

    @Test
    public void testDeleteApiDestination() {
        Set<ConstraintViolation<DeleteApiDestinationRequest>> constraintViolations = new HashSet<>();
        Mockito.when(validator.validate(any(DeleteApiDestinationRequest.class))).thenReturn(constraintViolations);
        Mockito.when(apiDestinationService.deleteApiDestination(any(), any())).thenReturn(Boolean.TRUE);
        DeleteApiDestinationRequest deleteApiDestinationRequest = new DeleteApiDestinationRequest();
        deleteApiDestinationRequest.setApiDestinationName(UUID.randomUUID().toString());
        final DeleteApiDestinationResponse deleteApiDestinationResponse = apiDestinationController.deleteApiDestination(deleteApiDestinationRequest);
        Assert.assertEquals(deleteApiDestinationResponse.getCode(), EventBridgeErrorCode.Success.getCode());
    }

    @Test
    public void testListApiDestinations() {
        Set<ConstraintViolation<ListApiDestinationsRequest>> constraintViolations = new HashSet<>();
        Mockito.when(validator.validate(any(ListApiDestinationsRequest.class))).thenReturn(constraintViolations);
        PaginationResult<List<EventApiDestination>> result = new PaginationResult();
        List<EventApiDestination> eventApiDestinationList = Lists.newArrayList();
        EventApiDestination eventApiDestination = new EventApiDestination();
        eventApiDestination.setName(UUID.randomUUID().toString());
        eventApiDestinationList.add(eventApiDestination);
        result.setData(eventApiDestinationList);
        result.setTotal(9);
        result.setNextToken("0");
        Mockito.when(apiDestinationService.listApiDestinations(any(), any(), any(), anyInt())).thenReturn(result);
        ListApiDestinationsRequest listApiDestinationsRequest = new ListApiDestinationsRequest();
        listApiDestinationsRequest.setApiDestinationNamePrefix(UUID.randomUUID().toString());
        listApiDestinationsRequest.setNextToken("0");
        listApiDestinationsRequest.setMaxResults(10);
        final ListApiDestinationsResponse listApiDestinationsResponse = apiDestinationController.listApiDestinations(listApiDestinationsRequest);
        Assert.assertEquals(listApiDestinationsResponse.getCode(), EventBridgeErrorCode.Success.getCode());
    }
}
