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

package org.apache.rocketmq.eventbridge.domain.model.connection;

import com.google.gson.Gson;
import lombok.extern.slf4j.Slf4j;
import org.apache.commons.lang3.StringUtils;
import org.apache.rocketmq.eventbridge.domain.common.EventBridgeConstants;
import org.apache.rocketmq.eventbridge.domain.common.enums.NetworkTypeEnum;
import org.apache.rocketmq.eventbridge.domain.common.exception.EventBridgeErrorCode;
import org.apache.rocketmq.eventbridge.domain.model.AbstractResourceService;
import org.apache.rocketmq.eventbridge.domain.model.PaginationResult;
import org.apache.rocketmq.eventbridge.domain.model.connection.parameter.*;
import org.apache.rocketmq.eventbridge.domain.repository.ApiDestinationRepository;
import org.apache.rocketmq.eventbridge.domain.repository.ConnectionRepository;
import org.apache.rocketmq.eventbridge.domain.rpc.NetworkServiceAPI;
import org.apache.rocketmq.eventbridge.domain.rpc.SecretManagerAPI;
import org.apache.rocketmq.eventbridge.exception.EventBridgeException;
import org.apache.rocketmq.eventbridge.exception.code.DefaultErrorCode;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.util.CollectionUtils;

import java.util.List;

import static org.apache.rocketmq.eventbridge.domain.common.exception.EventBridgeErrorCode.ConnectionCountExceedLimit;

@Slf4j
@Service
public class ConnectionService extends AbstractResourceService {

    protected final ConnectionRepository connectionRepository;
    protected SecretManagerAPI secretManagerAPI;
    protected NetworkServiceAPI networkServiceAPI;

    protected ApiDestinationRepository apiDestinationRepository;

    public ConnectionService(ConnectionRepository connectionRepository,
                             SecretManagerAPI secretManagerAPI, NetworkServiceAPI networkServiceAPI, ApiDestinationRepository apiDestinationRepository) {
        this.connectionRepository = connectionRepository;
        this.secretManagerAPI = secretManagerAPI;
        this.networkServiceAPI = networkServiceAPI;
        this.apiDestinationRepository = apiDestinationRepository;
    }

    @Transactional(rollbackFor = Exception.class, propagation = Propagation.REQUIRED)
    public String createConnection(ConnectionDTO connectionDTO) {
        if (!CollectionUtils.isEmpty(checkConnection(connectionDTO.getAccountId(), connectionDTO.getConnectionName()))) {
            throw new EventBridgeException(EventBridgeErrorCode.ConnectionAlreadyExist, connectionDTO.getConnectionName());
        }
        super.checkQuota(this.getConnectionCount(connectionDTO.getAccountId()), EventBridgeConstants.CONNECTION_COUNT_LIMIT, ConnectionCountExceedLimit);
        checkNetworkType(connectionDTO.getNetworkParameters().getNetworkType());
        try {
            if (connectionDTO.getAuthParameters() != null) {
                connectionDTO.setAuthParameters(setSecretData(connectionDTO.getAuthParameters(), connectionDTO.getAccountId(), connectionDTO.getConnectionName()));
            }
            if (connectionRepository.createConnection(connectionDTO)) {
                if (NetworkTypeEnum.PRIVATE_NETWORK.getNetworkType().equals(connectionDTO.getNetworkParameters().getNetworkType())) {
                    networkServiceAPI.createPrivateNetwork();
                }
                return connectionDTO.getConnectionName();
            }
        } catch (Exception e) {
            log.error("ConnectionService | createConnection | error", e);
            throw new EventBridgeException(DefaultErrorCode.InternalError.getCode(), e.getMessage());
        }
        return null;
    }

    @Transactional(rollbackFor = Exception.class, propagation = Propagation.REQUIRED)
    public void deleteConnection(String accountId, String connectionName) {
        if (CollectionUtils.isEmpty(checkConnection(accountId, connectionName))) {
            throw new EventBridgeException(EventBridgeErrorCode.ConnectionNotExist, connectionName);
        }
        if (!CollectionUtils.isEmpty(apiDestinationRepository.queryApiDestinationByConnectionName(accountId, connectionName))) {
            throw new EventBridgeException(EventBridgeErrorCode.ConnectionBoundApiDestination, connectionName);
        }
        List<ConnectionDTO> connection = getConnection(accountId, connectionName);
        ConnectionDTO connectionDTO = connection.get(0);
        if (NetworkTypeEnum.PRIVATE_NETWORK.getNetworkType().equals(connectionDTO.getNetworkParameters().getNetworkType())) {
            networkServiceAPI.deletePrivateNetwork();
        }
        try {
            connectionRepository.deleteConnection(accountId, connectionName);
            if (secretManagerAPI.querySecretName(secretManagerAPI.getSecretName(accountId, connectionName))) {
                secretManagerAPI.deleteSecretName(secretManagerAPI.getSecretName(accountId, connectionName));
            }
        } catch (Exception e) {
            log.error("ConnectionService | deleteConnection | error", e);
            throw new EventBridgeException(DefaultErrorCode.InternalError.getCode(), e.getMessage());
        }
    }

    @Transactional(rollbackFor = Exception.class, propagation = Propagation.REQUIRED)
    public void updateConnection(ConnectionDTO connectionDTO, String accountId) {
        if (CollectionUtils.isEmpty(checkConnection(accountId, connectionDTO.getConnectionName()))) {
            throw new EventBridgeException(EventBridgeErrorCode.ConnectionNotExist, connectionDTO.getConnectionName());
        }
        checkNetworkType(connectionDTO.getNetworkParameters().getNetworkType());
        try {
            if (connectionDTO.getAuthParameters() != null) {
                connectionDTO.setAuthParameters(updateSecretData(connectionDTO.getAuthParameters(), accountId, connectionDTO.getConnectionName(), connectionDTO.getConnectionName()));
            }
            connectionRepository.updateConnection(connectionDTO);
        } catch (Exception e) {
            log.error("ConnectionService | updateConnection | error", e);
            throw new EventBridgeException(DefaultErrorCode.InternalError.getCode(), e.getMessage());
        }
    }

    public List<ConnectionDTO> getConnection(String accountId, String connectionName) {
        final List<ConnectionDTO> connectionDTO = connectionRepository.getConnection(accountId, connectionName);
        if (connectionDTO == null) {
            throw new EventBridgeException(EventBridgeErrorCode.ConnectionNotExist, connectionName);
        }
        return connectionDTO;
    }

    public List<ConnectionDTO> checkConnection(String accountId, String connectionName) {
        return connectionRepository.getConnection(accountId, connectionName);
    }

    public PaginationResult<List<ConnectionDTO>> listConnections(String accountId, String connectionName, String nextToken, int maxResults) {
        List<ConnectionDTO> connectionDTOS = connectionRepository.listConnections(accountId, connectionName, nextToken, maxResults);
        PaginationResult<List<ConnectionDTO>> result = new PaginationResult();
        result.setData(connectionDTOS);
        result.setTotal(this.getConnectionCount(accountId));
        result.setNextToken(String.valueOf(Integer.parseInt(nextToken) + maxResults));
        return result;
    }

    public int getConnectionCount(String accountId) {
        return connectionRepository.getConnectionCount(accountId);
    }

    private AuthParameters setSecretData(AuthParameters authParameters, String accountId, String connectionName) throws Exception {
        final BasicAuthParameters basicAuthParameters = authParameters.getBasicAuthParameters();
        final ApiKeyAuthParameters apiKeyAuthParameters = authParameters.getApiKeyAuthParameters();
        final OAuthParameters oauthParameters = authParameters.getOauthParameters();
        if (basicAuthParameters != null) {
            final String secretName = secretManagerAPI.createSecretName(accountId, connectionName, new Gson().toJson(basicAuthParameters));
            basicAuthParameters.setPassword(secretName);
            return authParameters;
        }
        if (apiKeyAuthParameters != null) {
            final String secretName = secretManagerAPI.createSecretName(accountId, connectionName, new Gson().toJson(apiKeyAuthParameters));
            apiKeyAuthParameters.setApiKeyValue(secretName);
            return authParameters;
        }
        if (oauthParameters != null) {
            final OAuthHttpParameters oauthHttpParameters = oauthParameters.getOauthHttpParameters();
            if (oauthHttpParameters != null) {
                saveClientByKms(accountId, connectionName, oauthParameters);
            }
        }
        return authParameters;
    }

    private void saveClientByKms(String accountId, String connectionName, OAuthParameters oauthParameters) throws Exception {
        OAuthParameters.ClientParameters clientParameters = oauthParameters.getClientParameters();
        clientParameters.setClientSecret(secretManagerAPI.createSecretName(accountId, connectionName, new Gson().toJson(clientParameters)));
        oauthParameters.setClientParameters(clientParameters);
    }

    private AuthParameters updateSecretData(AuthParameters authParameters, String accountId, String connectionName, String name) throws Exception {
        ConnectionDTO connection = connectionRepository.getConnectionByName(name);
        if (authParameters == null) {
            return null;
        }
        final BasicAuthParameters basicAuthParameters = authParameters.getBasicAuthParameters();
        final ApiKeyAuthParameters apiKeyAuthParameters = authParameters.getApiKeyAuthParameters();
        final OAuthParameters oauthParameters = authParameters.getOauthParameters();
        if (basicAuthParameters != null) {
            String secretName = null;
            if (connection.getAuthParameters() != null && connection.getAuthParameters().getBasicAuthParameters() != null) {
                BasicAuthParameters oldBasicAuthParameters = connection.getAuthParameters().getBasicAuthParameters();
                secretName = secretManagerAPI.updateSecretValue(oldBasicAuthParameters.getPassword(), accountId, connectionName, basicAuthParameters.getUsername(), basicAuthParameters.getPassword());
            } else {
                secretName = secretManagerAPI.createSecretName(accountId, connectionName, new Gson().toJson(basicAuthParameters));
            }

            basicAuthParameters.setPassword(secretName);
            return authParameters;
        }
        if (apiKeyAuthParameters != null) {
            String secretName = null;
            if (connection.getAuthParameters() != null && connection.getAuthParameters().getApiKeyAuthParameters() != null) {
                ApiKeyAuthParameters oldApiKeyAuthParameters = connection.getAuthParameters().getApiKeyAuthParameters();
                secretName = secretManagerAPI.updateSecretValue(oldApiKeyAuthParameters.getApiKeyValue(), accountId, connectionName, apiKeyAuthParameters.getApiKeyName(), apiKeyAuthParameters.getApiKeyValue());
            } else {
                secretName = secretManagerAPI.createSecretName(accountId, connectionName, new Gson().toJson(apiKeyAuthParameters));
            }
            apiKeyAuthParameters.setApiKeyValue(secretName);
            return authParameters;
        }
        if (oauthParameters == null) {
            return authParameters;
        }
        updateClientByKms(accountId, connectionName, oauthParameters, connection);
        return authParameters;
    }

    private void updateClientByKms(String accountId, String connectionName, OAuthParameters oauthParameters, ConnectionDTO connection) throws Exception {
        OAuthParameters.ClientParameters clientParameters = oauthParameters.getClientParameters();
        String clientSecretSecretValue = null;
        if (connection.getAuthParameters() != null && connection.getAuthParameters().getOauthParameters() != null) {
            OAuthParameters.ClientParameters oldClientParameters = connection.getAuthParameters().getOauthParameters().getClientParameters();
            clientSecretSecretValue = secretManagerAPI.updateSecretValue(oldClientParameters.getClientSecret(),
                    accountId, connectionName, connection.getAuthParameters().getOauthParameters().getClientParameters().getClientID(),
                    connection.getAuthParameters().getOauthParameters().getClientParameters().getClientSecret());
        } else {
            clientSecretSecretValue = secretManagerAPI.createSecretName(accountId, connectionName, new Gson().toJson(clientParameters));
        }
        clientParameters.setClientSecret(clientSecretSecretValue);
        oauthParameters.setClientParameters(clientParameters);
    }

    private void checkNetworkType(String type) {
        if (StringUtils.isBlank(type)) {
            return;
        }
        boolean check = true;
        for (NetworkTypeEnum networkTypeEnum : NetworkTypeEnum.values()) {
            if (networkTypeEnum.getNetworkType().equals(type)) {
                check = false;
                break;
            }
        }
        if (check) {
            throw new EventBridgeException(EventBridgeErrorCode.ConnectionNetworkParametersInvalid);
        }
    }
}
