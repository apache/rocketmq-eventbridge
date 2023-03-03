package org.apache.rocketmq.eventbridge.adapter.runtimer.service;

import io.openmessaging.connector.api.component.connector.Connector;
import org.apache.rocketmq.eventbridge.adapter.runtimer.common.ConnectKeyValue;

import java.util.List;
import java.util.Map;

/**
 * manage the pusher connector/task config info
 */
public interface PusherConfigManageService {

    /**
     * Get all connector configs
     *
     * @return
     */
    Map<String, ConnectKeyValue> getConnectorConfigs();

    /**
     * Put the configs.
     *
     * @param connectorName
     * @param configs
     * @return
     * @throws Exception
     */
    String putConnectorConfig(String connectorName, ConnectKeyValue configs) throws Exception;

    /**
     * Remove the connector
     *
     * @param connectorName
     */
    void removeConnectorConfig(String connectorName);

    void recomputeTaskConfigs(String connectorName, Connector connector, Long currentTimestamp, ConnectKeyValue configs);

    /**
     * Get all Task configs.
     *
     * @return
     */
    Map<String, List<ConnectKeyValue>> getTaskConfigs();

    /**
     * Get all topics
     * @return
     */
    List<String> getConnectTopics();

}
