package org.apache.rocketmq.eventbridge.domain.model.connection;

import com.alibaba.fastjson.JSONObject;
import lombok.extern.slf4j.Slf4j;
import org.apache.rocketmq.eventbridge.domain.common.enums.NetworkTypeEnum;
import org.apache.rocketmq.eventbridge.domain.common.exception.EventBridgeErrorCode;
import org.apache.rocketmq.eventbridge.domain.model.AbstractResourceService;
import org.apache.rocketmq.eventbridge.domain.model.PaginationResult;
import org.apache.rocketmq.eventbridge.domain.repository.ConnectionRepository;
import org.apache.rocketmq.eventbridge.domain.repository.EventDataRepository;
import org.apache.rocketmq.eventbridge.exception.EventBridgeException;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

import static org.apache.rocketmq.eventbridge.domain.common.exception.EventBridgeErrorCode.ConnectionCountExceedLimit;

@Slf4j
@Service
public class ConnectionService extends AbstractResourceService {

    protected final ConnectionRepository connectionRepository;
    protected final EventDataRepository eventDataRepository;

    public ConnectionService(ConnectionRepository connectionRepository, EventDataRepository eventDataRepository) {
        this.connectionRepository = connectionRepository;
        this.eventDataRepository = eventDataRepository;
    }

    @Value("${connection.count.limit}")
    private String connectionCountLimit;

    @Transactional(rollbackFor = Exception.class, propagation = Propagation.REQUIRED)
    public String createConnection(EventConnectionWithBLOBs eventConnectionWithBLOBs) {
        try {
            if (checkConnection(eventConnectionWithBLOBs.getAccountId(), eventConnectionWithBLOBs.getName()) != null) {
                throw new EventBridgeException(EventBridgeErrorCode.ConnectionAlreadyExist, eventConnectionWithBLOBs.getName());
            }
            super.checkQuota(this.getConnectionCount(eventConnectionWithBLOBs.getAccountId(), eventConnectionWithBLOBs.getName()), Integer.parseInt(connectionCountLimit),
                    ConnectionCountExceedLimit);
            checkAuth(eventConnectionWithBLOBs.getAuthParameters());
            checkNetworkType(eventConnectionWithBLOBs.getNetworkType());
            if (connectionRepository.createConnection(eventConnectionWithBLOBs)) {
                return eventConnectionWithBLOBs.getName();
            }
        } catch (Exception e) {
            log.error("ConnectionService | createConnection | error", e);
            throw new EventBridgeException(e);
        }
        return null;
    }

    @Transactional(rollbackFor = Exception.class, propagation = Propagation.REQUIRED)
    public boolean deleteConnection(String accountId, String connectionName) {
        try {
            if (checkConnection(accountId, connectionName) == null) {
                throw new EventBridgeException(EventBridgeErrorCode.ConnectionNotExist, connectionName);
            }
            return connectionRepository.deleteConnection(accountId, connectionName);
        } catch (Exception e) {
            log.error("ConnectionService | deleteConnection | error", e);
            throw new EventBridgeException(e);
        }
    }

    @Transactional(rollbackFor = Exception.class, propagation = Propagation.REQUIRED)
    public boolean updateConnection(EventConnectionWithBLOBs eventConnectionWithBLOBs) {
        try {
            if (checkConnection(eventConnectionWithBLOBs.getAccountId(), eventConnectionWithBLOBs.getName()) == null) {
                throw new EventBridgeException(EventBridgeErrorCode.ConnectionNotExist, eventConnectionWithBLOBs.getName());
            }
            checkAuth(eventConnectionWithBLOBs.getAuthParameters());
            checkNetworkType(eventConnectionWithBLOBs.getNetworkType());
            return connectionRepository.updateConnection(eventConnectionWithBLOBs);
        } catch (Exception e) {
            log.error("ConnectionService | updateConnection | error", e);
            throw new EventBridgeException(e);
        }
    }

    public EventConnectionWithBLOBs getConnection(String accountId, String connectionName) {
        try {
            final EventConnectionWithBLOBs connection = connectionRepository.getConnection(accountId, connectionName);
            if (connection == null) {
                throw new EventBridgeException(EventBridgeErrorCode.ConnectionNotExist, connectionName);
            }
            return connection;
        } catch (Exception e) {
            log.error("ConnectionService | getConnection | error", e);
            throw new EventBridgeException(e);
        }
    }

    public EventConnectionWithBLOBs checkConnection(String accountId, String connectionName) {
        return connectionRepository.getConnection(accountId, connectionName);
    }

    public PaginationResult<List<EventConnectionWithBLOBs>> listConnections(String accountId, String connectionName, String nextToken,
                                                                            int maxResults) {
        try {
            List<EventConnectionWithBLOBs> eventConnectionWithBLOBs = connectionRepository.listConnections(accountId, connectionName, nextToken, maxResults);
            PaginationResult<List<EventConnectionWithBLOBs>> result = new PaginationResult();
            result.setData(eventConnectionWithBLOBs);
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

    private void checkAuth(String authParams) {
        final JSONObject jsonObject = JSONObject.parseObject(authParams);
        final JSONObject apiKeyAuthParameters = getJSONObject(jsonObject, "apiKeyAuthParameters");
        final JSONObject basicAuthParameters = getJSONObject(jsonObject, "basicAuthParameters");
        final JSONObject oauthParameters = getJSONObject(jsonObject, "oauthParameters");
        boolean check = (apiKeyAuthParameters != null || basicAuthParameters != null) && (apiKeyAuthParameters != null || oauthParameters != null) && (basicAuthParameters != null || oauthParameters != null);
        if (check) {
            throw new EventBridgeException(EventBridgeErrorCode.ConnectionAuthParametersInvalid);
        }
    }

    private JSONObject getJSONObject(JSONObject jsonObject, String key) {
        try {
            return jsonObject.getJSONObject(key);
        } catch (Exception e) {
            log.error("ConnectionService | getJSONObject | error", e);
        }
        return null;
    }

    private void checkNetworkType(String type) {
        boolean check = true;
        for (NetworkTypeEnum  networkTypeEnum:NetworkTypeEnum.values()) {
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
