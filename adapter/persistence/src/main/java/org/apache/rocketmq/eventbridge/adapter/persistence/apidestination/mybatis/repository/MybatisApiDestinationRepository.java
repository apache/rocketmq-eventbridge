package org.apache.rocketmq.eventbridge.adapter.persistence.apidestination.mybatis.repository;

import org.apache.rocketmq.eventbridge.adapter.persistence.apidestination.mybatis.mapper.EventApiDestinationMapper;
import org.apache.rocketmq.eventbridge.domain.model.apidestination.EventApiDestination;
import org.apache.rocketmq.eventbridge.domain.repository.ApiDestinationRepository;
import org.springframework.stereotype.Repository;

@Repository
public class MybatisApiDestinationRepository implements ApiDestinationRepository {

    private EventApiDestinationMapper eventApiDestinationMapper;

    public MybatisApiDestinationRepository(EventApiDestinationMapper eventApiDestinationMapper) {
        this.eventApiDestinationMapper = eventApiDestinationMapper;
    }

    @Override
    public String createApiDestination() {
        EventApiDestination eventApiDestination = new EventApiDestination();
        eventApiDestinationMapper.insertSelective(eventApiDestination);
        return null;
    }

    @Override
    public String updateApiDestination() {
        // TODO 根据name更新
        EventApiDestination eventApiDestination = new EventApiDestination();
        eventApiDestinationMapper.updateByPrimaryKeySelective(eventApiDestination);
        return null;
    }

    @Override
    public String getApiDestination() {
        // TODO 修改SQL进行查询
        eventApiDestinationMapper.selectByPrimaryKey(0);
        return null;
    }

    @Override
    public String deleteApiDestination() {
        // TODO 根据name进行删除
        eventApiDestinationMapper.deleteByPrimaryKey(0);
        return null;
    }

    @Override
    public String listApiDestinations() {
        // TODO 修改SQL进行查询
        eventApiDestinationMapper.selectByPrimaryKey(0);
        return null;
    }
}
