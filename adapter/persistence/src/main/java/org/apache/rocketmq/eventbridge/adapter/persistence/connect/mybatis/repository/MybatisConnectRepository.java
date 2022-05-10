package org.apache.rocketmq.eventbridge.adapter.persistence.connect.mybatis.repository;

import org.apache.rocketmq.eventbridge.adapter.persistence.connect.mybatis.mapper.EventConnectionMapper;
import org.apache.rocketmq.eventbridge.domain.model.connection.EventConnectionWithBLOBs;
import org.apache.rocketmq.eventbridge.domain.repository.ConnectionRepository;
import org.springframework.stereotype.Repository;


@Repository
public class MybatisConnectRepository implements ConnectionRepository {

    private EventConnectionMapper eventConnectionMapper;

    public MybatisConnectRepository(EventConnectionMapper eventConnectionMapper) {
        this.eventConnectionMapper = eventConnectionMapper;
    }

    @Override
    public String createConnection() {
        EventConnectionWithBLOBs eventConnectionWithBLOBs = new EventConnectionWithBLOBs();
        eventConnectionMapper.insertSelective(eventConnectionWithBLOBs);
        return null;
    }

    @Override
    public String deleteConnection() {
        // TODO 根据name进行删除
        eventConnectionMapper.deleteByPrimaryKey(0);
        return null;
    }

    @Override
    public String updateConnection() {
        // TODO 根据name进行更新
        EventConnectionWithBLOBs eventConnectionWithBLOBs = new EventConnectionWithBLOBs();
        eventConnectionMapper.updateByPrimaryKeySelective(eventConnectionWithBLOBs);
        return null;
    }

    @Override
    public String getConnection() {
        // TODO 查询单条数据
        eventConnectionMapper.selectByPrimaryKey(0);
        return null;
    }

    @Override
    public String listConnections() {
        // TODO 分页查询
        eventConnectionMapper.selectByPrimaryKey(0);
        return null;
    }
}
