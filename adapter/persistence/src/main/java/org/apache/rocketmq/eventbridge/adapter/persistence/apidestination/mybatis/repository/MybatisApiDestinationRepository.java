/*
 * Licensed to the Apache Software Foundation (ASF) under one or more
 * contributor license agreements.  See the NOTICE file distributed with
 * this work for additional information regarding copyright ownership.
 * The ASF licenses this file to You under the Apache License, Version 2.0
 * (the "License"); you may not use this file except in compliance with
 * the License.  You may obtain a copy of the License at
 *
 *     http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */

package org.apache.rocketmq.eventbridge.adapter.persistence.apidestination.mybatis.repository;

import org.apache.rocketmq.eventbridge.adapter.persistence.apidestination.mybatis.mapper.EventApiDestinationMapper;
import org.apache.rocketmq.eventbridge.domain.model.apidestination.ApiDestination;
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
    public Boolean createApiDestination(ApiDestination apiDestination) {
        apiDestination.setGmtCreate(new Date());
        apiDestination.setGmtModify(new Date());
        apiDestination.setProtocol("Http");
        return eventApiDestinationMapper.insertSelective(apiDestination) == 1;
    }

    @Override
    public Boolean updateApiDestination(ApiDestination apiDestination) {
        apiDestination.setGmtModify(new Date());
        return eventApiDestinationMapper.updateByNameAndAccountId(apiDestination) == 1;
    }

    @Override
    public ApiDestination getApiDestination(String accountId, String apiDestinationName) {
        return eventApiDestinationMapper.selectByAccountIdAndName(accountId, apiDestinationName);
    }

    @Override
    public Boolean deleteApiDestination(String accountId, String apiDestinationName) {
        return eventApiDestinationMapper.deleteByAccountIdAndName(accountId, apiDestinationName) == 1;
    }

    @Override
    public List<ApiDestination> listApiDestinations(String accountId, String apiDestinationName, String nextToken,
                                                    int maxResults) {
        return eventApiDestinationMapper.listApiDestinations(accountId, apiDestinationName, Integer.parseInt(nextToken), maxResults);
    }

    @Override
    public int getApiDestinationCount(String accountId, String apiDestinationName) {
        return eventApiDestinationMapper.getApiDestinationCount(accountId, apiDestinationName);
    }
}
