package org.apache.rocketmq.eventbridge.domain.model.connection;

import org.apache.rocketmq.eventbridge.domain.model.AbstractResourceService;
import org.apache.rocketmq.eventbridge.domain.repository.ConnectionRepository;
import org.apache.rocketmq.eventbridge.domain.repository.EventDataRepository;
import org.springframework.stereotype.Service;

@Service
public class ConnectionService extends AbstractResourceService {

    protected final ConnectionRepository connectionRepository;
    protected final EventDataRepository eventDataRepository;

    public ConnectionService(ConnectionRepository connectionRepository, EventDataRepository eventDataRepository) {
        this.connectionRepository = connectionRepository;
        this.eventDataRepository = eventDataRepository;
    }

    public String createConnection() {
        connectionRepository.createConnection();
        return null;
    }

    public String deleteConnection() {
        connectionRepository.deleteConnection();
        return null;
    }

    public String updateConnection() {
        connectionRepository.updateConnection();
        return null;
    }

    public String getConnection() {
        connectionRepository.getConnection();
        return null;
    }

    public String listConnections() {
        connectionRepository.listConnections();
        return null;
    }
}
