package org.apache.rocketmq.eventbridge.adapter.persistence.connect.mybatis.repository;

import org.apache.rocketmq.eventbridge.adapter.persistence.connect.mybatis.mapper.ConnectMapper;
import org.apache.rocketmq.eventbridge.domain.repository.ConnectionRepository;
import org.springframework.stereotype.Repository;


@Repository
public class MybatisConnectRepository implements ConnectionRepository {

    private ConnectMapper connectMapper;

    public MybatisConnectRepository(ConnectMapper connectMapper) {
        this.connectMapper = connectMapper;
    }
}
