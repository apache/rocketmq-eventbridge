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

import com.alibaba.fastjson.JSON;
import com.google.common.collect.Maps;
import lombok.extern.slf4j.Slf4j;
import org.apache.rocketmq.eventbridge.domain.common.EventBridgeConstants;
import org.apache.rocketmq.eventbridge.domain.common.enums.NetworkTypeEnum;
import org.apache.rocketmq.eventbridge.domain.common.exception.EventBridgeErrorCode;
import org.apache.rocketmq.eventbridge.domain.model.AbstractResourceService;
import org.apache.rocketmq.eventbridge.domain.model.PaginationResult;
import org.apache.rocketmq.eventbridge.domain.model.connection.parameter.ApiKeyAuthParameters;
import org.apache.rocketmq.eventbridge.domain.model.connection.parameter.AuthParameters;
import org.apache.rocketmq.eventbridge.domain.model.connection.parameter.BasicAuthParameters;
import org.apache.rocketmq.eventbridge.domain.model.connection.parameter.BodyParameter;
import org.apache.rocketmq.eventbridge.domain.model.connection.parameter.HeaderParameter;
import org.apache.rocketmq.eventbridge.domain.model.connection.parameter.OAuthHttpParameters;
import org.apache.rocketmq.eventbridge.domain.model.connection.parameter.OAuthParameters;
import org.apache.rocketmq.eventbridge.domain.model.connection.parameter.QueryStringParameter;
import org.apache.rocketmq.eventbridge.domain.repository.ConnectionRepository;
import org.apache.rocketmq.eventbridge.domain.rpc.NetworkServiceAPI;
import org.apache.rocketmq.eventbridge.domain.rpc.SecretManagerAPI;
import org.apache.rocketmq.eventbridge.exception.EventBridgeException;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.util.CollectionUtils;

import java.util.List;
import java.util.Map;

import static org.apache.rocketmq.eventbridge.domain.common.exception.EventBridgeErrorCode.ConnectionCountExceedLimit;

@Slf4j
@Service
public class ConnectionService extends AbstractResourceService {

    protected final ConnectionRepository connectionRepository;
    protected SecretManagerAPI secretManagerAPI;
    protected NetworkServiceAPI networkServiceAPI;

    public ConnectionService(ConnectionRepository connectionRepository, SecretManagerAPI secretManagerAPI, NetworkServiceAPI networkServiceAPI) {
        this.connectionRepository = connectionRepository;
        this.secretManagerAPI = secretManagerAPI;
        this.networkServiceAPI = networkServiceAPI;
    }

    @Transactional(rollbackFor = Exception.class, propagation = Propagation.REQUIRED)
    public String createConnection(ConnectionDTO connectionDTO) {
        try {
            if (checkConnection(connectionDTO.getAccountId(), connectionDTO.getConnectionName()) != null) {
                throw new EventBridgeException(EventBridgeErrorCode.ConnectionAlreadyExist, connectionDTO.getConnectionName());
            }
            super.checkQuota(this.getConnectionCount(connectionDTO.getAccountId(), connectionDTO.getConnectionName()), EventBridgeConstants.CONNECTION_COUNT_LIMIT, ConnectionCountExceedLimit);
            checkAuth(connectionDTO.getAuthParameters());
            checkNetworkType(connectionDTO.getNetworkParameters().getNetworkType());
            connectionDTO.setAuthParameters(setSecretData(connectionDTO.getAuthParameters(), connectionDTO.getAccountId(), connectionDTO.getConnectionName()));
            if (connectionRepository.createConnection(connectionDTO)) {
                if (NetworkTypeEnum.PRIVATE_NETWORK.getNetworkType().equals(connectionDTO.getNetworkParameters().getNetworkType())) {
                    networkServiceAPI.createPrivateNetwork();
                }
                return connectionDTO.getConnectionName();
            }
        } catch (Exception e) {
            log.error("ConnectionService | createConnection | error", e);
            throw new EventBridgeException(e);
        }
        return null;
    }

    @Transactional(rollbackFor = Exception.class, propagation = Propagation.REQUIRED)
    public void deleteConnection(String accountId, String connectionName) {
        try {
            if (checkConnection(accountId, connectionName) == null) {
                throw new EventBridgeException(EventBridgeErrorCode.ConnectionNotExist, connectionName);
            }
            final ConnectionDTO connection = getConnection(accountId, connectionName);
            if (NetworkTypeEnum.PRIVATE_NETWORK.getNetworkType().equals(connection.getNetworkParameters().getNetworkType())) {
                networkServiceAPI.deletePrivateNetwork();
            }
            connectionRepository.deleteConnection(accountId, connectionName);
            secretManagerAPI.deleteSecretName(secretManagerAPI.getSecretName(accountId, connectionName));
        } catch (Exception e) {
            log.error("ConnectionService | deleteConnection | error", e);
            throw new EventBridgeException(e);
        }
    }

    @Transactional(rollbackFor = Exception.class, propagation = Propagation.REQUIRED)
    public void updateConnection(ConnectionDTO connectionDTO, String accountId) {
        try {
            if (checkConnection(accountId, connectionDTO.getConnectionName()) == null) {
                throw new EventBridgeException(EventBridgeErrorCode.ConnectionNotExist, connectionDTO.getConnectionName());
            }
            checkAuth(connectionDTO.getAuthParameters());
            checkNetworkType(connectionDTO.getNetworkParameters().getNetworkType());
            connectionDTO.setAuthParameters(setSecretData(connectionDTO.getAuthParameters(), accountId, connectionDTO.getConnectionName()));
            connectionRepository.updateConnection(connectionDTO);
        } catch (Exception e) {
            log.error("ConnectionService | updateConnection | error", e);
            throw new EventBridgeException(e);
        }
    }

    public ConnectionDTO getConnection(String accountId, String connectionName) {
        try {
            final ConnectionDTO connectionDTO = connectionRepository.getConnection(accountId, connectionName);
            if (connectionDTO == null) {
                throw new EventBridgeException(EventBridgeErrorCode.ConnectionNotExist, connectionName);
            }
            return connectionDTO;
        } catch (Exception e) {
            log.error("ConnectionService | getConnection | error", e);
            throw new EventBridgeException(e);
        }
    }

    public ConnectionDTO checkConnection(String accountId, String connectionName) {
        return connectionRepository.getConnection(accountId, connectionName);
    }

    public PaginationResult<List<ConnectionDTO>> listConnections(String accountId, String connectionName, String nextToken, int maxResults) {
        try {
            List<ConnectionDTO> connectionDTOS = connectionRepository.listConnections(accountId, connectionName, nextToken, maxResults);
            PaginationResult<List<ConnectionDTO>> result = new PaginationResult();
            result.setData(connectionDTOS);
            result.setTotal(this.getConnectionCount(accountId, connectionName));
            result.setNextToken(String.valueOf(Integer.parseInt(nextToken) + maxResults));
            return result;
        } catch (Exception e) {
            log.error("ConnectionService | listConnections | error", e);
            throw new EventBridgeException(e);
        }
    }

    public int getConnectionCount(String accountId, String connectionName) {
        return connectionRepository.getConnectionCount(accountId, connectionName);
    }

    private void checkAuth(AuthParameters authParameters) {
        final BasicAuthParameters basicAuthParameters = authParameters.getBasicAuthParameters();
        final ApiKeyAuthParameters apiKeyAuthParameters = authParameters.getApiKeyAuthParameters();
        final OAuthParameters oauthParameters = authParameters.getOauthParameters();
        boolean check = (apiKeyAuthParameters != null || basicAuthParameters != null) && (apiKeyAuthParameters != null || oauthParameters != null) && (basicAuthParameters != null || oauthParameters != null);
        if (check) {
            throw new EventBridgeException(EventBridgeErrorCode.ConnectionAuthParametersInvalid);
        }
    }

    private AuthParameters setSecretData(AuthParameters authParameters, String accountId, String connectionName) throws Exception {
        final BasicAuthParameters basicAuthParameters = authParameters.getBasicAuthParameters();
        final ApiKeyAuthParameters apiKeyAuthParameters = authParameters.getApiKeyAuthParameters();
        final OAuthParameters oauthParameters = authParameters.getOauthParameters();
        if (basicAuthParameters != null) {
            Map<String, String> basicAuthParametersMap = Maps.newHashMap();
            basicAuthParametersMap.put("username", basicAuthParameters.getUsername());
            basicAuthParametersMap.put("password", basicAuthParameters.getPassword());
            final String secretName = secretManagerAPI.createSecretName(accountId, connectionName, JSON.toJSONString(basicAuthParametersMap));
            basicAuthParameters.setPassword(secretName);
            return authParameters;
        }
        if (apiKeyAuthParameters != null) {
            Map<String, String> apiKeyAuthParametersMap = Maps.newHashMap();
            apiKeyAuthParametersMap.put("apiKeyName", apiKeyAuthParameters.getApiKeyName());
            apiKeyAuthParametersMap.put("apiKeyValue", apiKeyAuthParameters.getApiKeyValue());
            final String secretName = secretManagerAPI.createSecretName(accountId, connectionName, JSON.toJSONString(apiKeyAuthParametersMap));
            apiKeyAuthParameters.setApiKeyValue(secretName);
            return authParameters;
        }
        final OAuthHttpParameters oauthHttpParameters = oauthParameters.getOauthHttpParameters();
        final OAuthHttpParameters valueSecret = getValueSecret(oauthHttpParameters, accountId, connectionName);
        authParameters.getOauthParameters().setOauthHttpParameters(valueSecret);
        return authParameters;
    }

    private OAuthHttpParameters getValueSecret(OAuthHttpParameters oauthHttpParameters, String accountId, String connectionName) throws Exception {
        final List<BodyParameter> bodyParameters = oauthHttpParameters.getBodyParameters();
        final List<QueryStringParameter> queryStringParameters = oauthHttpParameters.getQueryStringParameters();
        final List<HeaderParameter> headerParameters = oauthHttpParameters.getHeaderParameters();
        if (!CollectionUtils.isEmpty(bodyParameters)) {
            for (BodyParameter bodyParameter : bodyParameters) {
                if (Boolean.parseBoolean(bodyParameter.getIsValueSecret())) {
                    final String secretName = getString(accountId, connectionName, bodyParameter.getKey(), bodyParameter.getValue());
                    bodyParameter.setValue(secretName);
                    oauthHttpParameters.setBodyParameters(bodyParameters);
                    return oauthHttpParameters;
                }
            }
        }
        if (!CollectionUtils.isEmpty(queryStringParameters)) {
            for (QueryStringParameter queryStringParameter : queryStringParameters) {
                if (Boolean.parseBoolean(queryStringParameter.getIsValueSecret())) {
                    final String secretName = getString(accountId, connectionName, queryStringParameter.getKey(), queryStringParameter.getValue());
                    queryStringParameter.setValue(secretName);
                    oauthHttpParameters.setQueryStringParameters(queryStringParameters);
                    return oauthHttpParameters;
                }
            }
        }
        for (HeaderParameter headerParameter : headerParameters) {
            if (Boolean.parseBoolean(headerParameter.getIsValueSecret())) {
                final String secretName = getString(accountId, connectionName, headerParameter.getKey(), headerParameter.getValue());
                headerParameter.setValue(secretName);
                break;
            }
        }
        oauthHttpParameters.setHeaderParameters(headerParameters);
        return oauthHttpParameters;
    }

    private String getString(String accountId, String connectionName, String key, String value) throws Exception {
        Map<String, String> queryStringParameterMap = Maps.newHashMap();
        queryStringParameterMap.put("oauthHttpParameterKey", key);
        queryStringParameterMap.put("oauthHttpParameterValue", value);
        return secretManagerAPI.createSecretName(accountId, connectionName, JSON.toJSONString(queryStringParameterMap));
    }

    private void checkNetworkType(String type) {
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
