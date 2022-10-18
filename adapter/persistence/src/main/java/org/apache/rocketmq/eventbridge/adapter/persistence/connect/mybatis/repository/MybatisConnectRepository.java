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

package org.apache.rocketmq.eventbridge.adapter.persistence.connect.mybatis.repository;

import com.google.gson.Gson;
import java.util.Date;
import java.util.List;
import lombok.extern.slf4j.Slf4j;
import org.apache.rocketmq.eventbridge.adapter.persistence.connect.mybatis.converter.ConnectConverter;
import org.apache.rocketmq.eventbridge.adapter.persistence.connect.mybatis.dataobject.ConnectionDO;
import org.apache.rocketmq.eventbridge.adapter.persistence.connect.mybatis.mapper.EventConnectionMapper;
import org.apache.rocketmq.eventbridge.domain.model.connection.ConnectionDTO;
import org.apache.rocketmq.eventbridge.domain.repository.ConnectionRepository;
import org.springframework.stereotype.Repository;

@Slf4j
@Repository
public class MybatisConnectRepository implements ConnectionRepository {

    private EventConnectionMapper eventConnectionMapper;

    public MybatisConnectRepository(EventConnectionMapper eventConnectionMapper) {
        this.eventConnectionMapper = eventConnectionMapper;
    }

    @Override
    public Boolean createConnection(ConnectionDTO connectionDTO) {
        final ConnectionDO connectionDO = ConnectConverter.dtoConvertDo(connectionDTO);
        connectionDO.setGmtCreate(new Date());
        connectionDO.setGmtModify(new Date());
        return eventConnectionMapper.insertSelective(connectionDO) == 1;
    }

    @Override
    public boolean deleteConnection(String accountId, String connectionName) {
        return eventConnectionMapper.deleteByNameAndAccountId(accountId, connectionName) == 1;
    }

    @Override
    public boolean updateConnection(ConnectionDTO connectionDTO) {
        final ConnectionDO connectionDO = ConnectConverter.dtoConvertDo(connectionDTO);
        connectionDO.setGmtModify(new Date());
        return eventConnectionMapper.updateByAccountIdAndName(connectionDO) == 1;
    }

    @Override
    public List<ConnectionDTO> getConnection(String accountId, String connectionName) {
        final List<ConnectionDO> connectionDO = eventConnectionMapper.selectByNameAndAccountId(accountId, connectionName);
        log.info("MybatisConnectRepository ｜ connectionDO ：{}", new Gson().toJson(connectionDO));
        return ConnectConverter.doListConvertDtoList(connectionDO);
    }

    @Override
    public List<ConnectionDTO> listConnections(String accountId, String connectionName, String nextToken,
        int maxResults) {
        List<ConnectionDO> connectionDOS = eventConnectionMapper.listConnections(accountId, connectionName, Integer.parseInt(nextToken), maxResults);
        return ConnectConverter.doListConvertDtoList(connectionDOS);
    }

    @Override
    public int getConnectionCount(String accountId) {
        return eventConnectionMapper.getConnectionCount(accountId);
    }

    @Override
    public ConnectionDTO getConnectionById(Integer id) {
        ConnectionDO connectionDO = eventConnectionMapper.selectByPrimaryKey(id);
        return ConnectConverter.doConvertDto(connectionDO);
    }

    @Override
    public ConnectionDTO getConnectionByName(String name) {
        return ConnectConverter.doConvertDto(eventConnectionMapper.selectByName(name));
    }
}
