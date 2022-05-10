package org.apache.rocketmq.eventbridge.adapter.api.controller;

import org.apache.rocketmq.eventbridge.adapter.api.dto.connection.CreateConnectionRequest;
import org.apache.rocketmq.eventbridge.adapter.api.dto.connection.CreateConnectionResponse;
import org.apache.rocketmq.eventbridge.adapter.api.dto.connection.DeleteConnectionRequest;
import org.apache.rocketmq.eventbridge.adapter.api.dto.connection.DeleteConnectionResponse;
import org.apache.rocketmq.eventbridge.adapter.api.dto.connection.GetConnectionRequest;
import org.apache.rocketmq.eventbridge.adapter.api.dto.connection.GetConnectionResponse;
import org.apache.rocketmq.eventbridge.adapter.api.dto.connection.ListConnectionRequest;
import org.apache.rocketmq.eventbridge.adapter.api.dto.connection.ListConnectionResponse;
import org.apache.rocketmq.eventbridge.adapter.api.dto.connection.UpdateConnectionRequest;
import org.apache.rocketmq.eventbridge.adapter.api.dto.connection.UpdateConnectionResponse;
import org.apache.rocketmq.eventbridge.domain.model.connection.ConnectionService;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;

@RestController
@RequestMapping("/connection/")
public class ConnectionController {

    @Resource
    private ConnectionService connectionService;

    @PostMapping("createConnection")
    public CreateConnectionResponse createConnection(@RequestBody CreateConnectionRequest createConnectionRequest) {
        connectionService.createConnection();
        return new CreateConnectionResponse(null);
    }

    @PostMapping("deleteConnection")
    public DeleteConnectionResponse deleteConnection(@RequestBody DeleteConnectionRequest deleteConnectionRequest) {
        connectionService.deleteConnection();
        return new DeleteConnectionResponse(null);
    }

    @PostMapping("updateConnection")
    public UpdateConnectionResponse updateConnection(@RequestBody UpdateConnectionRequest updateConnectionRequest) {
        connectionService.updateConnection();
        return new UpdateConnectionResponse(null);
    }

    @PostMapping("getConnection")
    public GetConnectionResponse getConnection(@RequestBody GetConnectionRequest getConnectionRequest) {
        connectionService.getConnection();
        return new GetConnectionResponse(null);
    }

    @PostMapping("listConnections")
    public ListConnectionResponse listConnections(@RequestBody ListConnectionRequest listConnectionRequest) {
        connectionService.listConnections();
        return new ListConnectionResponse(null);
    }

}
