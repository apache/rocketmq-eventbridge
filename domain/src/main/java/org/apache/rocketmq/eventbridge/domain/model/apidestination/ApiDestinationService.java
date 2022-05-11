package org.apache.rocketmq.eventbridge.domain.model.apidestination;

import org.apache.rocketmq.eventbridge.domain.model.AbstractResourceService;
import org.apache.rocketmq.eventbridge.domain.model.PaginationResult;
import org.apache.rocketmq.eventbridge.domain.repository.ApiDestinationRepository;
import org.apache.rocketmq.eventbridge.domain.repository.EventSourceRepository;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
public class ApiDestinationService extends AbstractResourceService {

    private final ApiDestinationRepository apiDestinationRepository;
    private final EventSourceRepository eventSourceRepository;

    public ApiDestinationService(ApiDestinationRepository apiDestinationRepository, EventSourceRepository eventSourceRepository) {
        this.apiDestinationRepository = apiDestinationRepository;
        this.eventSourceRepository = eventSourceRepository;
    }

    @Transactional(rollbackFor = Exception.class, propagation = Propagation.REQUIRED)
    public String createApiDestination(EventApiDestination eventApiDestination) {
        final Boolean apiDestination = apiDestinationRepository.createApiDestination(eventApiDestination);
        if (apiDestination) {
            return eventApiDestination.getName();
        }
        return null;
    }

    @Transactional(rollbackFor = Exception.class, propagation = Propagation.REQUIRED)
    public Boolean updateApiDestination(EventApiDestination eventApiDestination) {
        return apiDestinationRepository.updateApiDestination(eventApiDestination);
    }

    public EventApiDestination getApiDestination(String accountId, String apiDestinationName) {
        apiDestinationRepository.getApiDestination(accountId, apiDestinationName);
        return null;
    }

    @Transactional(rollbackFor = Exception.class, propagation = Propagation.REQUIRED)
    public Boolean deleteApiDestination(String accountId, String apiDestinationName) {
        return apiDestinationRepository.deleteApiDestination(accountId, apiDestinationName);
    }

    public PaginationResult<List<EventApiDestination>> listApiDestinations(String accountId, String apiDestinationName, String nextToken,
                                                                           int maxResults) {
        final List<EventApiDestination> eventApiDestinations = apiDestinationRepository.listApiDestinations(accountId, apiDestinationName, nextToken, maxResults);
        PaginationResult<List<EventApiDestination>> result = new PaginationResult();
        result.setData(eventApiDestinations);
        result.setTotal(this.getApiDestinationCount(accountId, apiDestinationName));
        result.setNextToken(String.valueOf(Integer.parseInt(nextToken) + maxResults));
        return result;
    }

    private int getApiDestinationCount(String accountId, String apiDestinationName) {
        return apiDestinationRepository.getApiDestinationCount(accountId, apiDestinationName);
    }
}
