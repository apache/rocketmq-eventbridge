package org.apache.rocketmq.eventbridge.domain.model.apidestination;

import org.apache.rocketmq.eventbridge.domain.model.AbstractResourceService;
import org.apache.rocketmq.eventbridge.domain.repository.ApiDestinationRepository;
import org.apache.rocketmq.eventbridge.domain.repository.EventSourceRepository;
import org.springframework.stereotype.Service;

@Service
public class ApiDestinationService extends AbstractResourceService {

    private final ApiDestinationRepository apiDestinationRepository;
    private final EventSourceRepository eventSourceRepository;

    public ApiDestinationService(ApiDestinationRepository apiDestinationRepository, EventSourceRepository eventSourceRepository) {
        this.apiDestinationRepository = apiDestinationRepository;
        this.eventSourceRepository = eventSourceRepository;
    }

    public String createApiDestination() {
        apiDestinationRepository.createApiDestination();
        return null;
    }

    public String updateApiDestination() {
        apiDestinationRepository.updateApiDestination();
        return null;
    }

    public String getApiDestination() {
        apiDestinationRepository.getApiDestination();
        return null;
    }

    public String deleteApiDestination() {
        apiDestinationRepository.deleteApiDestination();
        return null;
    }

    public String listApiDestinations() {
        apiDestinationRepository.listApiDestinations();
        return null;
    }
}
