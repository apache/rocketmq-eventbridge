package org.apache.rocketmq.eventbridge.adapter.persistence.apidestination.mybatis.repository;

import org.apache.rocketmq.eventbridge.adapter.persistence.apidestination.mybatis.mapper.EventApiDestinationMapper;
import org.apache.rocketmq.eventbridge.domain.model.apidestination.EventApiDestination;
import org.apache.rocketmq.eventbridge.domain.repository.ApiDestinationRepository;
import org.springframework.stereotype.Repository;

import java.util.Date;
import java.util.List;

@Repository
public class MybatisApiDestinationRepository implements ApiDestinationRepository {

    private EventApiDestinationMapper eventApiDestinationMapper;

    public MybatisApiDestinationRepository(EventApiDestinationMapper eventApiDestinationMapper) {
        this.eventApiDestinationMapper = eventApiDestinationMapper;
    }

    @Override
    public Boolean createApiDestination(EventApiDestination eventApiDestination) {
        eventApiDestination.setGmtCreate(new Date());
        eventApiDestination.setGmtModify(new Date());
        eventApiDestination.setProtocol("Http");
        return eventApiDestinationMapper.insertSelective(eventApiDestination) == 1;
    }

    @Override
    public Boolean updateApiDestination(EventApiDestination eventApiDestination) {
        eventApiDestination.setGmtModify(new Date());
        return eventApiDestinationMapper.updateByNameAndAccountId(eventApiDestination) == 1;
    }

    @Override
    public EventApiDestination getApiDestination(String accountId, String apiDestinationName) {
        return eventApiDestinationMapper.selectByAccountIdAndName(accountId, apiDestinationName);
    }

    @Override
    public Boolean deleteApiDestination(String accountId, String apiDestinationName) {
        return eventApiDestinationMapper.deleteByAccountIdAndName(accountId, apiDestinationName) == 1;
    }

    @Override
    public List<EventApiDestination> listApiDestinations(String accountId, String apiDestinationName, String nextToken,
                                                         int maxResults) {
        return eventApiDestinationMapper.listApiDestinations(accountId, apiDestinationName, Integer.parseInt(nextToken), maxResults);
    }

    @Override
    public int getApiDestinationCount(String accountId, String apiDestinationName) {
        return eventApiDestinationMapper.getApiDestinationCount(accountId, apiDestinationName);
    }
}
