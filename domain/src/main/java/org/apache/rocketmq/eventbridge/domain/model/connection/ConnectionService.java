package org.apache.rocketmq.eventbridge.domain.model.connection;

import org.apache.rocketmq.eventbridge.domain.model.AbstractResourceService;
import org.apache.rocketmq.eventbridge.domain.model.PaginationResult;
import org.apache.rocketmq.eventbridge.domain.repository.ConnectionRepository;
import org.apache.rocketmq.eventbridge.domain.repository.EventDataRepository;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
public class ConnectionService extends AbstractResourceService {

    protected final ConnectionRepository connectionRepository;
    protected final EventDataRepository eventDataRepository;

    public ConnectionService(ConnectionRepository connectionRepository, EventDataRepository eventDataRepository) {
        this.connectionRepository = connectionRepository;
        this.eventDataRepository = eventDataRepository;
    }

    @Transactional(rollbackFor = Exception.class, propagation = Propagation.REQUIRED)
    public String createConnection(EventConnectionWithBLOBs eventConnectionWithBLOBs) {
        return connectionRepository.createConnection(eventConnectionWithBLOBs);
    }

    @Transactional(rollbackFor = Exception.class, propagation = Propagation.REQUIRED)
    public boolean deleteConnection(String accountId, String connectionName) {
        // TODO 校验
        return connectionRepository.deleteConnection(accountId, connectionName);
    }

    @Transactional(rollbackFor = Exception.class, propagation = Propagation.REQUIRED)
    public boolean updateConnection(EventConnectionWithBLOBs eventConnectionWithBLOBs) {
        return connectionRepository.updateConnection(eventConnectionWithBLOBs);
    }

    public EventConnectionWithBLOBs getConnection(String accountId, String connectionName) {
        return connectionRepository.getConnection(accountId, connectionName);
    }

    public PaginationResult<List<EventConnectionWithBLOBs>> listConnections(String accountId, String connectionName, String nextToken,
                                                                            int maxResults) {
        List<EventConnectionWithBLOBs> eventConnectionWithBLOBs = connectionRepository.listConnections(accountId, connectionName, nextToken, maxResults);
        PaginationResult<List<EventConnectionWithBLOBs>> result = new PaginationResult();
        result.setData(eventConnectionWithBLOBs);
        result.setTotal(this.getConnectionCount(accountId, connectionName));
        result.setNextToken(String.valueOf(Integer.parseInt(nextToken) + maxResults));
        return result;
    }

    public int getConnectionCount(String accountId, String connectionName) {
        return connectionRepository.getConnectionCount(accountId, connectionName);
    }
}
