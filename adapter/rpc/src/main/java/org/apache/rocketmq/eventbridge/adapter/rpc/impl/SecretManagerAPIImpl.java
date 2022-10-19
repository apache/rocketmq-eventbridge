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

package org.apache.rocketmq.eventbridge.adapter.rpc.impl;

import org.apache.rocketmq.eventbridge.domain.rpc.SecretManagerAPI;
import org.springframework.stereotype.Component;

@Component
public class SecretManagerAPIImpl implements SecretManagerAPI {

    @Override
    public String createSecretName(String accountId, String connectionName, String secretData) {
        return null;
    }

    @Override
    public void deleteSecretName(String secretName) {

    }

    @Override
    public String getSecretName(String accountId, String connectionName) {
        return null;
    }

    @Override
    public Boolean querySecretName(String secretName) {
        return Boolean.TRUE;
    }

    @Override
    public Object getSecretValue(String secretName) {
        return null;
    }

    @Override
    public String updateSecretValue(String oldSecretName, String accountId, String connectionName, String key, String value) {
        return null;
    }
}
