package org.apache.rocketmq.eventbridge.domain.model.connection;

import org.apache.rocketmq.eventbridge.domain.model.AbstractResourceService;
import org.apache.rocketmq.eventbridge.domain.repository.EventBusRepository;
import org.apache.rocketmq.eventbridge.domain.repository.EventDataRepository;
import org.springframework.stereotype.Service;

@Service
public class ConnectionService extends AbstractResourceService {

    protected final EventBusRepository eventBusRepository;
    protected final EventDataRepository eventDataRepository;

    public ConnectionService(EventBusRepository eventBusRepository, EventDataRepository eventDataRepository) {
        this.eventBusRepository = eventBusRepository;
        this.eventDataRepository = eventDataRepository;
    }

    public String createConnection() {
        return null;
    }

    public String deleteConnection() {
        return null;
    }

    public String updateConnection() {
        return null;
    }

    public String getConnection() {
        return null;
    }

    public String listConnections() {
        return null;
    }
}
