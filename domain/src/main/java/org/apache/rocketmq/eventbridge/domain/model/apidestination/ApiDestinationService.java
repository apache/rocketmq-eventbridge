package org.apache.rocketmq.eventbridge.domain.model.apidestination;

import lombok.extern.slf4j.Slf4j;
import org.apache.rocketmq.eventbridge.domain.common.exception.EventBridgeErrorCode;
import org.apache.rocketmq.eventbridge.domain.model.AbstractResourceService;
import org.apache.rocketmq.eventbridge.domain.model.PaginationResult;
import org.apache.rocketmq.eventbridge.domain.repository.ApiDestinationRepository;
import org.apache.rocketmq.eventbridge.domain.repository.EventSourceRepository;
import org.apache.rocketmq.eventbridge.exception.EventBridgeException;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

import static org.apache.rocketmq.eventbridge.domain.common.exception.EventBridgeErrorCode.ApiDestinationCountExceedLimit;

@Slf4j
@Service
public class ApiDestinationService extends AbstractResourceService {

    private final ApiDestinationRepository apiDestinationRepository;
    private final EventSourceRepository eventSourceRepository;

    public ApiDestinationService(ApiDestinationRepository apiDestinationRepository, EventSourceRepository eventSourceRepository) {
        this.apiDestinationRepository = apiDestinationRepository;
        this.eventSourceRepository = eventSourceRepository;
    }

    @Value("${api.destination.limit}")
    private String apiDestinationLimit;

    @Transactional(rollbackFor = Exception.class, propagation = Propagation.REQUIRED)
    public String createApiDestination(EventApiDestination eventApiDestination) {
        try {
            if (checkApiDestination(eventApiDestination.getAccountId(), eventApiDestination.getName()) != null) {
                throw new EventBridgeException(EventBridgeErrorCode.ApiDestinationAlreadyExist, eventApiDestination.getName());
            }
            super.checkQuota(this.getApiDestinationCount(eventApiDestination.getAccountId(), eventApiDestination.getName()), Integer.parseInt(apiDestinationLimit),
                    ApiDestinationCountExceedLimit);
            final Boolean apiDestination = apiDestinationRepository.createApiDestination(eventApiDestination);
            if (apiDestination) {
                return eventApiDestination.getName();
            }
            return null;
        } catch (Exception e) {
            log.error("ApiDestinationService | createApiDestination | error", e);
            throw new EventBridgeException(e);
        }
    }

    @Transactional(rollbackFor = Exception.class, propagation = Propagation.REQUIRED)
    public Boolean updateApiDestination(EventApiDestination eventApiDestination) {
        try {
            if (checkApiDestination(eventApiDestination.getAccountId(), eventApiDestination.getName()) == null) {
                throw new EventBridgeException(EventBridgeErrorCode.ApiDestinationNotExist, eventApiDestination.getName());
            }
            return apiDestinationRepository.updateApiDestination(eventApiDestination);
        } catch (Exception e) {
            log.error("ApiDestinationService | updateApiDestination | error", e);
            throw new EventBridgeException(e);
        }
    }

    public EventApiDestination getApiDestination(String accountId, String apiDestinationName) {
        try {
            if (checkApiDestination(accountId, accountId) == null) {
                throw new EventBridgeException(EventBridgeErrorCode.ApiDestinationNotExist, accountId);
            }
            return apiDestinationRepository.getApiDestination(accountId, apiDestinationName);
        } catch (Exception e) {
            log.error("ApiDestinationService | getApiDestination | error", e);
            throw new EventBridgeException(e);
        }
    }

    public EventApiDestination checkApiDestination(String accountId, String apiDestinationName) {
        return apiDestinationRepository.getApiDestination(accountId, apiDestinationName);
    }

    @Transactional(rollbackFor = Exception.class, propagation = Propagation.REQUIRED)
    public Boolean deleteApiDestination(String accountId, String apiDestinationName) {
        try {
            if (checkApiDestination(accountId, accountId) == null) {
                throw new EventBridgeException(EventBridgeErrorCode.ApiDestinationNotExist, accountId);
            }
            return apiDestinationRepository.deleteApiDestination(accountId, apiDestinationName);
        } catch (Exception e) {
            log.error("ApiDestinationService | deleteApiDestination | error", e);
            throw new EventBridgeException(e);
        }
    }

    public PaginationResult<List<EventApiDestination>> listApiDestinations(String accountId, String apiDestinationName, String nextToken,
                                                                           int maxResults) {
        try {
            final List<EventApiDestination> eventApiDestinations = apiDestinationRepository.listApiDestinations(accountId, apiDestinationName, nextToken, maxResults);
            PaginationResult<List<EventApiDestination>> result = new PaginationResult();
            result.setData(eventApiDestinations);
            result.setTotal(this.getApiDestinationCount(accountId, apiDestinationName));
            result.setNextToken(String.valueOf(Integer.parseInt(nextToken) + maxResults));
            return result;
        } catch (Exception e) {
            log.error("ApiDestinationService | listApiDestinations | error", e);
            throw new EventBridgeException(e);
        }
    }

    private int getApiDestinationCount(String accountId, String apiDestinationName) {
        return apiDestinationRepository.getApiDestinationCount(accountId, apiDestinationName);
    }
}
