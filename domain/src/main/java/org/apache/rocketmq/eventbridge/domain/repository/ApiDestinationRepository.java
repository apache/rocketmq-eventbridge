package org.apache.rocketmq.eventbridge.domain.repository;

import org.apache.rocketmq.eventbridge.domain.model.apidestination.EventApiDestination;

import java.util.List;

public interface ApiDestinationRepository {

    Boolean createApiDestination(EventApiDestination eventApiDestination);

    Boolean updateApiDestination(EventApiDestination eventApiDestination);

    EventApiDestination getApiDestination(String accountId, String apiDestinationName);

    Boolean deleteApiDestination(String accountId, String apiDestinationName);

    List<EventApiDestination> listApiDestinations(String accountId, String apiDestinationName, String nextToken,
                                                  int maxResults);

    int getApiDestinationCount(String accountId, String apiDestinationName);
}
