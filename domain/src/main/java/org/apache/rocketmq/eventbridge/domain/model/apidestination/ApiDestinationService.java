package org.apache.rocketmq.eventbridge.domain.model.apidestination;

import org.apache.rocketmq.eventbridge.domain.model.AbstractResourceService;
import org.apache.rocketmq.eventbridge.domain.model.bus.EventBusService;
import org.apache.rocketmq.eventbridge.domain.repository.EventSourceRepository;
import org.springframework.stereotype.Service;

@Service
public class ApiDestinationService extends AbstractResourceService {

    private final EventBusService eventBusService;
    private final EventSourceRepository eventSourceRepository;

    public ApiDestinationService(EventBusService eventBusService, EventSourceRepository eventSourceRepository) {
        this.eventBusService = eventBusService;
        this.eventSourceRepository = eventSourceRepository;
    }

    public String createApiDestination() {
        return null;
    }

    public String updateApiDestination() {
        return null;
    }

    public String getApiDestination() {
        return null;
    }

    public String deleteApiDestination() {
        return null;
    }

    public String listApiDestinations() {
        return null;
    }
}
