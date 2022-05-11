package org.apache.rocketmq.eventbridge.adapter.persistence.connect.mybatis.repository;

import org.apache.rocketmq.eventbridge.adapter.persistence.connect.mybatis.mapper.EventConnectionMapper;
import org.apache.rocketmq.eventbridge.domain.model.connection.EventConnectionWithBLOBs;
import org.apache.rocketmq.eventbridge.domain.repository.ConnectionRepository;
import org.springframework.stereotype.Repository;

import java.util.Date;
import java.util.List;


@Repository
public class MybatisConnectRepository implements ConnectionRepository {

    private EventConnectionMapper eventConnectionMapper;

    public MybatisConnectRepository(EventConnectionMapper eventConnectionMapper) {
        this.eventConnectionMapper = eventConnectionMapper;
    }

    @Override
    public String createConnection(EventConnectionWithBLOBs eventConnectionWithBLOBs) {
        eventConnectionWithBLOBs.setGmtCreate(new Date());
        eventConnectionWithBLOBs.setGmtModify(new Date());
        eventConnectionMapper.insertSelective(eventConnectionWithBLOBs);
        return eventConnectionWithBLOBs.getName();
    }

    @Override
    public boolean deleteConnection(String accountId, String connectionName) {
        return eventConnectionMapper.deleteByNameAndAccountId(accountId, connectionName) == 1;
    }

    @Override
    public boolean updateConnection(EventConnectionWithBLOBs eventConnectionWithBLOBs) {
        eventConnectionWithBLOBs.setGmtModify(new Date());
        return eventConnectionMapper.updateByAccountIdAndName(eventConnectionWithBLOBs) == 1;
    }

    @Override
    public EventConnectionWithBLOBs getConnection(String accountId, String connectionName) {
        return eventConnectionMapper.selectByNameAndAccountId(accountId, connectionName);
    }

    @Override
    public List<EventConnectionWithBLOBs> listConnections(String accountId, String connectionName, String nextToken,
                                                          int maxResults) {
        return eventConnectionMapper.listConnections(accountId, connectionName, Integer.parseInt(nextToken), maxResults);
    }

    @Override
    public int getConnectionCount(String accountId, String connectionName) {
        return eventConnectionMapper.getConnectionCount(accountId, connectionName);
    }
}
