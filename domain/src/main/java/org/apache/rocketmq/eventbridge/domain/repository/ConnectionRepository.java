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

package org.apache.rocketmq.eventbridge.domain.repository;

import java.util.List;
import org.apache.rocketmq.eventbridge.domain.model.connection.ConnectionDTO;

public interface ConnectionRepository {

    Boolean createConnection(ConnectionDTO connectionDTO);

    boolean deleteConnection(String accountId, String connectionName);

    boolean updateConnection(ConnectionDTO connectionDTO);

    List<ConnectionDTO> getConnection(String accountId, String connectionName);

    List<ConnectionDTO> listConnections(String accountId, String connectionName, String nextToken,
                                        int maxResults);

    int getConnectionCount(String accountId);

    int getConnectionCount(String accountId, String connectionName);

    ConnectionDTO getConnectionById(Integer id);

    ConnectionDTO getConnectionByNameAccountId(String name, String accountId);
}
