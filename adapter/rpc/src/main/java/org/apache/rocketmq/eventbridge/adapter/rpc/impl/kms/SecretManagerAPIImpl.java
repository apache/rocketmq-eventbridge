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

package org.apache.rocketmq.eventbridge.adapter.rpc.impl.kms;

import com.aliyun.kms20160120.Client;
import com.aliyun.kms20160120.models.CreateSecretRequest;
import com.aliyun.kms20160120.models.CreateSecretResponse;
import com.aliyun.kms20160120.models.DeleteSecretRequest;
import com.aliyun.tea.TeaException;
import lombok.extern.slf4j.Slf4j;
import org.apache.rocketmq.eventbridge.domain.rpc.SecretManagerAPI;
import org.apache.rocketmq.eventbridge.exception.EventBridgeException;
import org.springframework.stereotype.Component;

import javax.annotation.Resource;

@Slf4j
@Component
public class SecretManagerAPIImpl implements SecretManagerAPI {

    @Resource
    private Client client;

    @Override
    public String createSecretName(String accountId, String connectionName, String secretData) throws Exception {
        String secretName;
        try {
            deleteSecretName(getSecretName(accountId, connectionName));
        } catch (TeaException teaException) {
            if (!"Forbidden.ResourceNotFound".equals(teaException.getCode()) || !teaException.getMessage().contains("code: 404, Resource not found")) {
                log.error("KmsAPIImpl | createSecretName | TeaException | error => ", teaException);
                throw new EventBridgeException(teaException);
            }
        } catch (Exception e) {
            log.error("KmsAPIImpl | createSecretName | Exception | error => ", e);
            throw new EventBridgeException(e);
        } finally {
            CreateSecretRequest createSecretRequest = new CreateSecretRequest()
                    .setSecretName(getSecretName(accountId, connectionName))
                    .setVersionId("v1")
                    .setSecretData(secretData);
            log.info("KmsService | createSecretName | SecretName : {}, SecretData : {}", getSecretName(accountId, connectionName), secretData);
            final CreateSecretResponse createSecretResponse = client.createSecret(createSecretRequest);
            secretName = createSecretResponse.getBody().getSecretName();
        }
        return secretName;
    }

    @Override
    public void deleteSecretName(String secretName) throws Exception {
        DeleteSecretRequest deleteSecretRequest = new DeleteSecretRequest();
        deleteSecretRequest.setSecretName(secretName);
        deleteSecretRequest.setForceDeleteWithoutRecovery("true");
        client.deleteSecret(deleteSecretRequest);
    }

    @Override
    public String getSecretName(String accountId, String connectionName) {
        return accountId + "/eventbus/connection/" + connectionName + "/auth";
    }
}
