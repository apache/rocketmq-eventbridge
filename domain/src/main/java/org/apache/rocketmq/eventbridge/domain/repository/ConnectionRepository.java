package org.apache.rocketmq.eventbridge.domain.repository;

import org.apache.rocketmq.eventbridge.domain.model.connection.EventConnectionWithBLOBs;

import java.util.List;

public interface ConnectionRepository {

    String createConnection(EventConnectionWithBLOBs eventConnectionWithBLOBs);

    boolean deleteConnection(String accountId, String connectionName);

    boolean updateConnection(EventConnectionWithBLOBs eventConnectionWithBLOBs);

    EventConnectionWithBLOBs getConnection(String accountId, String connectionName);

    List<EventConnectionWithBLOBs> listConnections(String accountId, String connectionName, String nextToken,
                                                   int maxResults);

    int getConnectionCount(String accountId, String connectionName);
}
