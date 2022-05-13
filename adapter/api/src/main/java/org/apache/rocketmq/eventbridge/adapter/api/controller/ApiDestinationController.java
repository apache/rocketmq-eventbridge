package org.apache.rocketmq.eventbridge.adapter.api.controller;

import com.alibaba.fastjson.JSON;
import com.google.common.collect.Lists;
import org.apache.rocketmq.eventbridge.adapter.api.annotations.WebLog;
import org.apache.rocketmq.eventbridge.adapter.api.dto.apidestination.ApiDestinationsVO;
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
import org.apache.rocketmq.eventbridge.domain.model.PaginationResult;
import org.apache.rocketmq.eventbridge.domain.model.apidestination.ApiDestinationService;
import org.apache.rocketmq.eventbridge.domain.model.apidestination.EventApiDestination;
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
    public CreateApiDestinationResponse createApiDestination(@RequestBody CreateApiDestinationRequest createApiDestinationRequest) {
        final Set<ConstraintViolation<CreateApiDestinationRequest>> validate = validator.validate(createApiDestinationRequest);
        List<String> errMessage = validate.stream().map(ConstraintViolation::getMessage).collect(Collectors.toList());
        if (!CollectionUtils.isEmpty(errMessage)) {
            return new CreateApiDestinationResponse(null).parameterCheckFailRes(errMessage.toString());
        }
        EventApiDestination eventApiDestination = getEventApiDestination(createApiDestinationRequest.getHttpApiParameters(), createApiDestinationRequest.getDescription(), createApiDestinationRequest.getConnectionName(), createApiDestinationRequest.getInvocationRateLimitPerSecond(), createApiDestinationRequest.getApiDestinationName(), accountAPI);
        return new CreateApiDestinationResponse(apiDestinationService.createApiDestination(eventApiDestination)).success();
    }

    @WebLog
    @PostMapping("updateApiDestination")
    public UpdateApiDestinationResponse updateApiDestination(@RequestBody UpdateApiDestinationRequest updateApiDestinationRequest) {
        final Set<ConstraintViolation<UpdateApiDestinationRequest>> validate = validator.validate(updateApiDestinationRequest);
        List<String> errMessage = validate.stream().map(ConstraintViolation::getMessage).collect(Collectors.toList());
        if (!CollectionUtils.isEmpty(errMessage)) {
            return new UpdateApiDestinationResponse().parameterCheckFailRes(errMessage.toString());
        }
        EventApiDestination eventApiDestination = getEventApiDestination(updateApiDestinationRequest.getHttpApiParameters(), updateApiDestinationRequest.getDescription(), updateApiDestinationRequest.getConnectionName(), updateApiDestinationRequest.getInvocationRateLimitPerSecond(), updateApiDestinationRequest.getApiDestinationName(), accountAPI);
        apiDestinationService.updateApiDestination(eventApiDestination);
        return new UpdateApiDestinationResponse().success();
    }

    @WebLog
    @PostMapping("getApiDestination")
    public GetApiDestinationResponse getApiDestination(@RequestBody GetApiDestinationRequest getApiDestinationRequest) {
        final Set<ConstraintViolation<GetApiDestinationRequest>> validate = validator.validate(getApiDestinationRequest);
        List<String> errMessage = validate.stream().map(ConstraintViolation::getMessage).collect(Collectors.toList());
        if (!CollectionUtils.isEmpty(errMessage)) {
            return new GetApiDestinationResponse(null, null, null, null, null).parameterCheckFailRes(errMessage.toString());
        }
        final EventApiDestination apiDestination = apiDestinationService.getApiDestination(accountAPI.getResourceOwnerAccountId(), getApiDestinationRequest.getApiDestinationName());
        return new GetApiDestinationResponse(apiDestination.getName(), apiDestination.getConnectionName(), apiDestination.getDescription(), apiDestination.getApiParams(), apiDestination.getInvocationRateLimitPerSecond()).success();
    }

    @WebLog
    @PostMapping("deleteApiDestination")
    public DeleteApiDestinationResponse deleteApiDestination(@RequestBody DeleteApiDestinationRequest deleteApiDestinationRequest) {
        final Set<ConstraintViolation<DeleteApiDestinationRequest>> validate = validator.validate(deleteApiDestinationRequest);
        List<String> errMessage = validate.stream().map(ConstraintViolation::getMessage).collect(Collectors.toList());
        if (!CollectionUtils.isEmpty(errMessage)) {
            return new DeleteApiDestinationResponse().parameterCheckFailRes(errMessage.toString());
        }
        apiDestinationService.deleteApiDestination(accountAPI.getResourceOwnerAccountId(), deleteApiDestinationRequest.getApiDestinationName());
        return new DeleteApiDestinationResponse().success();
    }

    @WebLog
    @PostMapping("listApiDestinations")
    public ListApiDestinationsResponse listApiDestinations(@RequestBody ListApiDestinationsRequest listApiDestinationsRequest) {
        final Set<ConstraintViolation<ListApiDestinationsRequest>> validate = validator.validate(listApiDestinationsRequest);
        List<String> errMessage = validate.stream().map(ConstraintViolation::getMessage).collect(Collectors.toList());
        if (!CollectionUtils.isEmpty(errMessage)) {
            return new ListApiDestinationsResponse(null, null, null, 0).parameterCheckFailRes(errMessage.toString());
        }
        final PaginationResult<List<EventApiDestination>> listPaginationResult = apiDestinationService.listApiDestinations(accountAPI.getResourceOwnerAccountId(),
                listApiDestinationsRequest.getApiDestinationNamePrefix(), listApiDestinationsRequest.getNextToken(), listApiDestinationsRequest.getMaxResults());
        List<ApiDestinationsVO> apiDestinationsVOS = Lists.newArrayList();
        listPaginationResult.getData()
                .forEach(eventApiDestination -> {
                    ApiDestinationsVO apiDestinationsVO = new ApiDestinationsVO();
                    BeanUtils.copyProperties(eventApiDestination, apiDestinationsVO);
                    apiDestinationsVO.setApiDestinationName(eventApiDestination.getName());
                    apiDestinationsVO.setHttpApiParameters(eventApiDestination.getApiParams());
                    apiDestinationsVOS.add(apiDestinationsVO);
                });
        return new ListApiDestinationsResponse(apiDestinationsVOS, listPaginationResult.getNextToken(), listPaginationResult.getTotal(), listApiDestinationsRequest.getMaxResults()).success();
    }

    private EventApiDestination getEventApiDestination(HttpApiParameters apiParams, String description, String connectionName, Integer invocationRateLimitPerSecond, String name, AccountAPI accountAPI) {
        EventApiDestination eventApiDestination = new EventApiDestination();
        eventApiDestination.setApiParams(JSON.toJSONString(apiParams));
        eventApiDestination.setDescription(description);
        eventApiDestination.setConnectionName(connectionName);
        eventApiDestination.setInvocationRateLimitPerSecond(invocationRateLimitPerSecond);
        eventApiDestination.setName(name);
        eventApiDestination.setAccountId(accountAPI.getResourceOwnerAccountId());
        return eventApiDestination;
    }
}
