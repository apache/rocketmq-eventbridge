package org.apache.rocketmq.eventbridge.domain.repository;

public interface ApiDestinationRepository {

    String createApiDestination();

    String updateApiDestination();

    String getApiDestination();

    String deleteApiDestination();

    String listApiDestinations();

}
