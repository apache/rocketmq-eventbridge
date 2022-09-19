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

package org.apache.rocketmq.eventbridge.adapter.persistence.connect.mybatis.converter;

import com.google.gson.Gson;
import org.apache.rocketmq.eventbridge.adapter.persistence.connect.mybatis.dataobject.ConnectionDO;
import org.apache.rocketmq.eventbridge.domain.model.connection.parameter.AuthParameters;
import org.apache.rocketmq.eventbridge.domain.model.connection.ConnectionDTO;
import org.apache.rocketmq.eventbridge.domain.model.connection.parameter.NetworkParameters;

import java.util.List;
import java.util.stream.Collectors;

public class ConnectConverter {

    public static ConnectionDTO doConvertDto(ConnectionDO connectionDO) {
        if (connectionDO == null) {
            return null;
        }
        ConnectionDTO connectionDTO = new ConnectionDTO();
        connectionDTO.setConnectionName(connectionDO.getName());
        connectionDTO.setDescription(connectionDO.getDescription());
        connectionDTO.setAuthParameters(new Gson().fromJson(connectionDO.getAuthParameters(), AuthParameters.class));
        connectionDTO.setNetworkParameters(
            new Gson().fromJson(connectionDO.getNetworkParameters(), NetworkParameters.class));
        return connectionDTO;
    }

    public static ConnectionDO dtoConvertDo(ConnectionDTO connectionDTO) {
        if (connectionDTO == null) {
            return null;
        }
        ConnectionDO connectionDO = new ConnectionDO();
        connectionDO.setAccountId(connectionDTO.getAccountId());
        connectionDO.setAuthorizationType(connectionDTO.getAuthParameters()
            .getAuthorizationType());
        connectionDO.setName(connectionDTO.getConnectionName());
        connectionDO.setNetworkParameters(new Gson().toJson(connectionDTO.getNetworkParameters()));
        connectionDO.setDescription(connectionDTO.getDescription());
        connectionDO.setNetworkType(connectionDTO.getNetworkParameters()
            .getNetworkType());
        connectionDO.setAuthParameters(new Gson().toJson(connectionDTO.getAuthParameters()));
        return connectionDO;
    }

    public static List<ConnectionDTO> doListConvertDtoList(List<ConnectionDO> connectionDOS) {
        return connectionDOS.stream()
            .map(ConnectConverter::doConvertDto)
            .collect(Collectors.toList());
    }
}
