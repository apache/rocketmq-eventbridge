package org.apache.rocketmq.eventbridge.adapter.persistence.apidestination.mybatis.repository;

import org.apache.rocketmq.eventbridge.adapter.persistence.apidestination.mybatis.mapper.ApiDestinationMapper;
import org.apache.rocketmq.eventbridge.domain.repository.ApiDestinationRepository;
import org.springframework.stereotype.Repository;

@Repository
public class MybatisApiDestinationRepository implements ApiDestinationRepository {

    private ApiDestinationMapper apiDestinationMapper;

    public MybatisApiDestinationRepository(ApiDestinationMapper apiDestinationMapper) {
        this.apiDestinationMapper = apiDestinationMapper;
    }
}
