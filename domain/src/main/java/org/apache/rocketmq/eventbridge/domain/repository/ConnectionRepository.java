package org.apache.rocketmq.eventbridge.domain.repository;

public interface ConnectionRepository {

    String createConnection();

    String deleteConnection();

    String updateConnection();

    String getConnection();

    String listConnections();

}
