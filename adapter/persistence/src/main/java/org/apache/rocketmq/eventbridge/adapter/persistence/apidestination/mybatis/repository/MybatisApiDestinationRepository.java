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

import org.apache.rocketmq.eventbridge.adapter.persistence.apidestination.mybatis.converter.ApiDestinationConverter;
import org.apache.rocketmq.eventbridge.adapter.persistence.apidestination.mybatis.dataobject.ApiDestinationDO;
import org.apache.rocketmq.eventbridge.adapter.persistence.apidestination.mybatis.mapper.EventApiDestinationMapper;
import org.apache.rocketmq.eventbridge.domain.model.apidestination.ApiDestinationDTO;
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
    public Boolean createApiDestination(ApiDestinationDTO apiDestinationDTO) {
        final ApiDestinationDO apiDestinationDO = ApiDestinationConverter.dtoConverterDo(apiDestinationDTO);
        apiDestinationDO.setGmtCreate(new Date());
        apiDestinationDO.setGmtModify(new Date());
        apiDestinationDO.setProtocol("Http");
        return eventApiDestinationMapper.insertSelective(apiDestinationDO) == 1;
    }

    @Override
    public Boolean updateApiDestination(ApiDestinationDTO apiDestinationDTO) {
        final ApiDestinationDO apiDestinationDO = ApiDestinationConverter.dtoConverterDo(apiDestinationDTO);
        apiDestinationDO.setGmtModify(new Date());
        return eventApiDestinationMapper.updateByNameAndAccountId(apiDestinationDO) == 1;
    }

    @Override
    public ApiDestinationDTO getApiDestination(String accountId, String apiDestinationName) {
        return ApiDestinationConverter.doConverterDto(eventApiDestinationMapper.selectByAccountIdAndName(accountId, apiDestinationName));
    }

    @Override
    public Boolean deleteApiDestination(String accountId, String apiDestinationName) {
        return eventApiDestinationMapper.deleteByAccountIdAndName(accountId, apiDestinationName) == 1;
    }

    @Override
    public List<ApiDestinationDTO> listApiDestinations(String accountId, String apiDestinationName, String nextToken,
                                                       int maxResults) {
        return ApiDestinationConverter.doListConverterDtoList(eventApiDestinationMapper.listApiDestinations(accountId, apiDestinationName, Integer.parseInt(nextToken), maxResults));
    }

    @Override
    public int getApiDestinationCount(String accountId) {
        return eventApiDestinationMapper.getApiDestinationCount(accountId);
    }
}
