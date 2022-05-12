package org.apache.rocketmq.eventbridge.adapter.api.controller;

import com.alibaba.fastjson.JSON;
import com.google.common.collect.Lists;
import org.apache.rocketmq.eventbridge.adapter.api.dto.connection.AuthParameters;
import org.apache.rocketmq.eventbridge.adapter.api.dto.connection.ConnectionVO;
import org.apache.rocketmq.eventbridge.adapter.api.dto.connection.CreateConnectionRequest;
import org.apache.rocketmq.eventbridge.adapter.api.dto.connection.CreateConnectionResponse;
import org.apache.rocketmq.eventbridge.adapter.api.dto.connection.DeleteConnectionRequest;
import org.apache.rocketmq.eventbridge.adapter.api.dto.connection.DeleteConnectionResponse;
import org.apache.rocketmq.eventbridge.adapter.api.dto.connection.GetConnectionRequest;
import org.apache.rocketmq.eventbridge.adapter.api.dto.connection.GetConnectionResponse;
import org.apache.rocketmq.eventbridge.adapter.api.dto.connection.ListConnectionRequest;
import org.apache.rocketmq.eventbridge.adapter.api.dto.connection.ListConnectionResponse;
import org.apache.rocketmq.eventbridge.adapter.api.dto.connection.NetworkParameters;
import org.apache.rocketmq.eventbridge.adapter.api.dto.connection.UpdateConnectionRequest;
import org.apache.rocketmq.eventbridge.adapter.api.dto.connection.UpdateConnectionResponse;
import org.apache.rocketmq.eventbridge.domain.model.PaginationResult;
import org.apache.rocketmq.eventbridge.domain.model.connection.ConnectionService;
import org.apache.rocketmq.eventbridge.domain.model.connection.EventConnectionWithBLOBs;
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
@RequestMapping("/connection/")
public class ConnectionController {

    @Resource
    private ConnectionService connectionService;
    @Resource
    private AccountAPI accountAPI;
    @Resource
    private Validator validator;

    @PostMapping("createConnection")
    public CreateConnectionResponse createConnection(@RequestBody  CreateConnectionRequest createConnectionRequest) {
        final Set<ConstraintViolation<CreateConnectionRequest>> validate = validator.validate(createConnectionRequest);
        List<String> errMessage = validate.stream().map(ConstraintViolation::getMessage).collect(Collectors.toList());
        if (!CollectionUtils.isEmpty(errMessage)) {
            return new CreateConnectionResponse(null).parameterCheckFailRes(errMessage.toString());
        }
        EventConnectionWithBLOBs eventConnectionWithBLOBs = getEventConnectionWithBLOBs(createConnectionRequest.getConnectionName(),
                createConnectionRequest.getNetworkParameters().getNetworkType(),
                createConnectionRequest.getAuthParameters(),
                createConnectionRequest.getNetworkParameters(),
                createConnectionRequest.getDescription(),
                accountAPI);
        return new CreateConnectionResponse(connectionService.createConnection(eventConnectionWithBLOBs)).success();
    }

    @PostMapping("deleteConnection")
    public DeleteConnectionResponse deleteConnection(@RequestBody DeleteConnectionRequest deleteConnectionRequest) {
        final Set<ConstraintViolation<DeleteConnectionRequest>> validate = validator.validate(deleteConnectionRequest);
        List<String> errMessage = validate.stream().map(ConstraintViolation::getMessage).collect(Collectors.toList());
        if (!CollectionUtils.isEmpty(errMessage)) {
            return new DeleteConnectionResponse().parameterCheckFailRes(errMessage.toString());
        }
        connectionService.deleteConnection(accountAPI.getResourceOwnerAccountId(), deleteConnectionRequest.getConnectionName());
        return new DeleteConnectionResponse().success();
    }

    @PostMapping("updateConnection")
    public UpdateConnectionResponse updateConnection(@RequestBody UpdateConnectionRequest updateConnectionRequest) {
        final Set<ConstraintViolation<UpdateConnectionRequest>> validate = validator.validate(updateConnectionRequest);
        List<String> errMessage = validate.stream().map(ConstraintViolation::getMessage).collect(Collectors.toList());
        if (!CollectionUtils.isEmpty(errMessage)) {
            return new UpdateConnectionResponse().parameterCheckFailRes(errMessage.toString());
        }
        EventConnectionWithBLOBs eventConnectionWithBLOBs = getEventConnectionWithBLOBs(updateConnectionRequest.getConnectionName(),
                updateConnectionRequest.getNetworkParameters().getNetworkType(),
                updateConnectionRequest.getAuthParameters(),
                updateConnectionRequest.getNetworkParameters(),
                updateConnectionRequest.getDescription(),
                accountAPI);
        connectionService.updateConnection(eventConnectionWithBLOBs);
        return new UpdateConnectionResponse().success();
    }

    @PostMapping("getConnection")
    public GetConnectionResponse getConnection(@RequestBody GetConnectionRequest getConnectionRequest) {
        final Set<ConstraintViolation<GetConnectionRequest>> validate = validator.validate(getConnectionRequest);
        List<String> errMessage = validate.stream().map(ConstraintViolation::getMessage).collect(Collectors.toList());
        if (!CollectionUtils.isEmpty(errMessage)) {
            return new GetConnectionResponse(null, null, null, null).parameterCheckFailRes(errMessage.toString());
        }
        final EventConnectionWithBLOBs connection = connectionService.getConnection(accountAPI.getResourceOwnerAccountId(), getConnectionRequest.getConnectionName());
        final NetworkParameters networkParameters = JSON.parseObject(connection.getNetworkParameters(), NetworkParameters.class);
        final AuthParameters authParameters = JSON.parseObject(connection.getAuthParameters(), AuthParameters.class);
        return new GetConnectionResponse(connection.getName(), connection.getDescription(), networkParameters, authParameters).success();
    }

    @PostMapping("listConnections")
    public ListConnectionResponse listConnections(@RequestBody ListConnectionRequest listConnectionRequest) {
        final Set<ConstraintViolation<ListConnectionRequest>> validate = validator.validate(listConnectionRequest);
        List<String> errMessage = validate.stream().map(ConstraintViolation::getMessage).collect(Collectors.toList());
        if (!CollectionUtils.isEmpty(errMessage)) {
            return new ListConnectionResponse(null, null, null, 0).parameterCheckFailRes(errMessage.toString());
        }
        final PaginationResult<List<EventConnectionWithBLOBs>> listPaginationResult = connectionService.listConnections(accountAPI.getResourceOwnerAccountId(),
                listConnectionRequest.getConnectionNamePrefix(), listConnectionRequest.getNextToken(), listConnectionRequest.getMaxResults());
        List<ConnectionVO> connectionVOS = Lists.newArrayList();
        listPaginationResult.getData()
                .forEach(eventConnectionWithBLOBs -> {
                    ConnectionVO connectionVO = new ConnectionVO();
                    BeanUtils.copyProperties(eventConnectionWithBLOBs, connectionVO);
                    connectionVO.setConnectionName(eventConnectionWithBLOBs.getName());
                    connectionVOS.add(connectionVO);
                });
        return new ListConnectionResponse(connectionVOS, listPaginationResult.getNextToken(), listPaginationResult.getTotal(), listConnectionRequest.getMaxResults()).success();
    }

    private EventConnectionWithBLOBs getEventConnectionWithBLOBs(String name, String networkType, AuthParameters AuthParameters, NetworkParameters networkParameters, String description, AccountAPI accountAPI) {
        EventConnectionWithBLOBs eventConnectionWithBLOBs = new EventConnectionWithBLOBs();
        eventConnectionWithBLOBs.setName(name);
        eventConnectionWithBLOBs.setAuthParameters(JSON.toJSONString(AuthParameters));
        eventConnectionWithBLOBs.setNetworkParameters(JSON.toJSONString(networkParameters));
        eventConnectionWithBLOBs.setDescription(description);
        eventConnectionWithBLOBs.setAccountId(accountAPI.getResourceOwnerAccountId());
        eventConnectionWithBLOBs.setAuthorizationType(AuthParameters.getAuthorizationType());
        eventConnectionWithBLOBs.setNetworkType(networkType);
        return eventConnectionWithBLOBs;
    }

}
