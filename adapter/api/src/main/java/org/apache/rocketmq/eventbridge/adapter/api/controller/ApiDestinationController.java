package org.apache.rocketmq.eventbridge.adapter.api.controller;

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
import org.apache.rocketmq.eventbridge.domain.model.apidestination.ApiDestinationService;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;

@RestController
@RequestMapping("/api-destination/")
public class ApiDestinationController {

    @Resource
    private ApiDestinationService apiDestinationService;

    @PostMapping("createApiDestination")
    public CreateApiDestinationResponse createApiDestination(@RequestBody CreateApiDestinationRequest createApiDestinationRequest) {
        apiDestinationService.createApiDestination();
        return new CreateApiDestinationResponse();
    }

    @PostMapping("updateApiDestination")
    public UpdateApiDestinationResponse updateApiDestination(@RequestBody UpdateApiDestinationRequest updateApiDestinationRequest) {
        apiDestinationService.updateApiDestination();
        return new UpdateApiDestinationResponse();
    }

    @PostMapping("getApiDestination")
    public GetApiDestinationResponse getApiDestination(@RequestBody GetApiDestinationRequest getApiDestinationRequest) {
        apiDestinationService.getApiDestination();
        return new GetApiDestinationResponse();
    }

    @PostMapping("deleteApiDestination")
    public DeleteApiDestinationResponse deleteApiDestination(@RequestBody DeleteApiDestinationRequest deleteApiDestinationRequest) {
        apiDestinationService.deleteApiDestination();
        return new DeleteApiDestinationResponse();
    }

    @PostMapping("listApiDestinations")
    public ListApiDestinationsResponse listApiDestinations(@RequestBody ListApiDestinationsRequest listApiDestinationsRequest) {
        apiDestinationService.listApiDestinations();
        return new ListApiDestinationsResponse();
    }
}
