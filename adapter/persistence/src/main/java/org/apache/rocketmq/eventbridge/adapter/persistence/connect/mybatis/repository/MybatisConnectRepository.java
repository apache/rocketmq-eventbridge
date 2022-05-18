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

import org.apache.rocketmq.eventbridge.adapter.persistence.connect.mybatis.mapper.EventConnectionMapper;
import org.apache.rocketmq.eventbridge.domain.model.connection.ConnectionWithBLOBs;
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
    public Boolean createConnection(ConnectionWithBLOBs eventConnectionWithBLOBs) {
        eventConnectionWithBLOBs.setGmtCreate(new Date());
        eventConnectionWithBLOBs.setGmtModify(new Date());
        return eventConnectionMapper.insertSelective(eventConnectionWithBLOBs) == 1;
    }

    @Override
    public boolean deleteConnection(String accountId, String connectionName) {
        return eventConnectionMapper.deleteByNameAndAccountId(accountId, connectionName) == 1;
    }

    @Override
    public boolean updateConnection(ConnectionWithBLOBs eventConnectionWithBLOBs) {
        eventConnectionWithBLOBs.setGmtModify(new Date());
        return eventConnectionMapper.updateByAccountIdAndName(eventConnectionWithBLOBs) == 1;
    }

    @Override
    public ConnectionWithBLOBs getConnection(String accountId, String connectionName) {
        return eventConnectionMapper.selectByNameAndAccountId(accountId, connectionName);
    }

    @Override
    public List<ConnectionWithBLOBs> listConnections(String accountId, String connectionName, String nextToken,
                                                     int maxResults) {
        return eventConnectionMapper.listConnections(accountId, connectionName, Integer.parseInt(nextToken), maxResults);
    }

    @Override
    public int getConnectionCount(String accountId, String connectionName) {
        return eventConnectionMapper.getConnectionCount(accountId, connectionName);
    }
}
