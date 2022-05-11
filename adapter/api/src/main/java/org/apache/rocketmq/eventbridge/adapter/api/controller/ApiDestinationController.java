package org.apache.rocketmq.eventbridge.adapter.api.controller;

import com.alibaba.fastjson.JSON;
import com.google.common.collect.Lists;
import org.apache.rocketmq.eventbridge.adapter.api.dto.apidestination.ApiDestinationsVO;
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
import org.apache.rocketmq.eventbridge.domain.model.apidestination.ApiDestinationService;
import org.apache.rocketmq.eventbridge.domain.model.apidestination.EventApiDestination;
import org.apache.rocketmq.eventbridge.domain.rpc.AccountAPI;
import org.springframework.beans.BeanUtils;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;
import java.util.List;

@RestController
@RequestMapping("/api-destination/")
public class ApiDestinationController {

    @Resource
    private ApiDestinationService apiDestinationService;
    @Resource
    private AccountAPI accountAPI;

    @PostMapping("createApiDestination")
    public CreateApiDestinationResponse createApiDestination(@RequestBody CreateApiDestinationRequest createApiDestinationRequest) {
        EventApiDestination eventApiDestination = new EventApiDestination();
        eventApiDestination.setApiParams(JSON.toJSONString(createApiDestinationRequest.getHttpApiParameters()));
        eventApiDestination.setDescription(createApiDestinationRequest.getDescription());
        eventApiDestination.setConnectionName(createApiDestinationRequest.getConnectionName());
        eventApiDestination.setInvocationRateLimitPerSecond(createApiDestinationRequest.getInvocationRateLimitPerSecond());
        eventApiDestination.setName(createApiDestinationRequest.getApiDestinationName());
        return new CreateApiDestinationResponse(apiDestinationService.createApiDestination(eventApiDestination));
    }

    @PostMapping("updateApiDestination")
    public UpdateApiDestinationResponse updateApiDestination(@RequestBody UpdateApiDestinationRequest updateApiDestinationRequest) {
        EventApiDestination eventApiDestination = new EventApiDestination();
        eventApiDestination.setApiParams(JSON.toJSONString(updateApiDestinationRequest.getHttpApiParameters()));
        eventApiDestination.setDescription(updateApiDestinationRequest.getDescription());
        eventApiDestination.setConnectionName(updateApiDestinationRequest.getConnectionName());
        eventApiDestination.setInvocationRateLimitPerSecond(updateApiDestinationRequest.getInvocationRateLimitPerSecond());
        eventApiDestination.setName(updateApiDestinationRequest.getApiDestinationName());
        eventApiDestination.setAccountId(accountAPI.getResourceOwnerAccountId());
        apiDestinationService.updateApiDestination(eventApiDestination);
        return new UpdateApiDestinationResponse();
    }

    @PostMapping("getApiDestination")
    public GetApiDestinationResponse getApiDestination(@RequestBody GetApiDestinationRequest getApiDestinationRequest) {
        final EventApiDestination apiDestination = apiDestinationService.getApiDestination(accountAPI.getResourceOwnerAccountId(), getApiDestinationRequest.getApiDestinationName());
        return new GetApiDestinationResponse(apiDestination.getName(),apiDestination.getConnectionName(), apiDestination.getDescription(), apiDestination.getApiParams(), apiDestination.getInvocationRateLimitPerSecond());
    }

    @PostMapping("deleteApiDestination")
    public DeleteApiDestinationResponse deleteApiDestination(@RequestBody DeleteApiDestinationRequest deleteApiDestinationRequest) {
        apiDestinationService.deleteApiDestination(accountAPI.getResourceOwnerAccountId(), deleteApiDestinationRequest.getApiDestinationName());
        return new DeleteApiDestinationResponse();
    }

    @PostMapping("listApiDestinations")
    public ListApiDestinationsResponse listApiDestinations(@RequestBody ListApiDestinationsRequest listApiDestinationsRequest) {
        final PaginationResult<List<EventApiDestination>> listPaginationResult = apiDestinationService.listApiDestinations(accountAPI.getResourceOwnerAccountId(),
                listApiDestinationsRequest.getApiDestinationNamePrefix(), listApiDestinationsRequest.getNextToken(), listApiDestinationsRequest.getMaxResults());
        List<ApiDestinationsVO> apiDestinationsVOS = Lists.newArrayList();
        listPaginationResult.getData()
                .forEach(eventApiDestination -> {
                    ApiDestinationsVO apiDestinationsVO = new ApiDestinationsVO();
                    BeanUtils.copyProperties(eventApiDestination, apiDestinationsVO);
                    apiDestinationsVO.setApiDestinationName(eventApiDestination.getName());
                    apiDestinationsVOS.add(apiDestinationsVO);
                });
        return new ListApiDestinationsResponse(apiDestinationsVOS, listPaginationResult.getNextToken(), listPaginationResult.getTotal(), listApiDestinationsRequest.getMaxResults());
    }
}
