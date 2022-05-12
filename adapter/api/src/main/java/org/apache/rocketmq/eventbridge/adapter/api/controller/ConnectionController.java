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
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;
import java.util.List;

@RestController
@RequestMapping("/connection/")
public class ConnectionController {

    @Resource
    private ConnectionService connectionService;
    @Resource
    private AccountAPI accountAPI;

    @PostMapping("createConnection")
    public CreateConnectionResponse createConnection(@RequestBody CreateConnectionRequest createConnectionRequest) {
        EventConnectionWithBLOBs eventConnectionWithBLOBs = new EventConnectionWithBLOBs();
        eventConnectionWithBLOBs.setName(createConnectionRequest.getConnectionName());
        eventConnectionWithBLOBs.setAuthParameters(JSON.toJSONString(createConnectionRequest.getAuthParameters()));
        eventConnectionWithBLOBs.setNetworkParameters(JSON.toJSONString(createConnectionRequest.getNetworkParameters()));
        eventConnectionWithBLOBs.setDescription(createConnectionRequest.getDescription());
        eventConnectionWithBLOBs.setAccountId(accountAPI.getResourceOwnerAccountId());
        eventConnectionWithBLOBs.setAuthorizationType(createConnectionRequest.getAuthParameters().getAuthorizationType());
        return new CreateConnectionResponse(connectionService.createConnection(eventConnectionWithBLOBs)).success();
    }

    @PostMapping("deleteConnection")
    public DeleteConnectionResponse deleteConnection(@RequestBody DeleteConnectionRequest deleteConnectionRequest) {
        connectionService.deleteConnection(accountAPI.getResourceOwnerAccountId(), deleteConnectionRequest.getConnectionName());
        return new DeleteConnectionResponse().success();
    }

    @PostMapping("updateConnection")
    public UpdateConnectionResponse updateConnection(@RequestBody UpdateConnectionRequest updateConnectionRequest) {
        EventConnectionWithBLOBs eventConnectionWithBLOBs = new EventConnectionWithBLOBs();
        eventConnectionWithBLOBs.setName(updateConnectionRequest.getConnectionName());
        eventConnectionWithBLOBs.setAuthParameters(JSON.toJSONString(updateConnectionRequest.getAuthParameters()));
        eventConnectionWithBLOBs.setNetworkParameters(JSON.toJSONString(updateConnectionRequest.getNetworkParameters()));
        eventConnectionWithBLOBs.setDescription(updateConnectionRequest.getDescription());
        eventConnectionWithBLOBs.setAccountId(accountAPI.getResourceOwnerAccountId());
        eventConnectionWithBLOBs.setAuthorizationType(updateConnectionRequest.getAuthParameters().getAuthorizationType());
        connectionService.updateConnection(eventConnectionWithBLOBs);
        return new UpdateConnectionResponse().success();
    }

    @PostMapping("getConnection")
    public GetConnectionResponse getConnection(@RequestBody GetConnectionRequest getConnectionRequest) {
        final EventConnectionWithBLOBs connection = connectionService.getConnection(accountAPI.getResourceOwnerAccountId(), getConnectionRequest.getConnectionName());
        final NetworkParameters networkParameters = JSON.parseObject(connection.getNetworkParameters(), NetworkParameters.class);
        final AuthParameters authParameters = JSON.parseObject(connection.getAuthParameters(), AuthParameters.class);
        return new GetConnectionResponse(connection.getName(), connection.getDescription(), networkParameters, authParameters).success();
    }

    @PostMapping("listConnections")
    public ListConnectionResponse listConnections(@RequestBody ListConnectionRequest listConnectionRequest) {
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

}
