package org.apache.rocketmq.eventbridge.adapter.runtimer.service;

import io.openmessaging.connector.api.component.connector.Connector;
import org.apache.rocketmq.eventbridge.adapter.runtimer.common.entity.PusherTargetEntity;
import org.apache.rocketmq.eventbridge.adapter.runtimer.common.entity.TargetKeyValue;

import java.util.List;
import java.util.Map;
import java.util.Set;

/**
 * manage the pusher connector/task config info
 */
public interface PusherConfigManageService {

    /**
     * Get all connector configs
     *
     * @return
     */
    Map<String, TargetKeyValue> getConnectorConfigs();

    /**
     * Put the configs.
     *
     * @param connectorName
     * @param configs
     * @return
     * @throws Exception
     */
    String putConnectTargetConfig(String connectorName, TargetKeyValue configs) throws Exception;

    /**
     * Remove the connector
     *
     * @param connectorName
     */
    void removeConnectorConfig(String connectorName);

    void recomputeTaskConfigs(String connectorName, Connector connector, Long currentTimestamp, TargetKeyValue configs);

    /**
     * Get all Task configs.
     *
     * @return
     */
    Map<String, List<TargetKeyValue>> getTaskConfigs();

    /**
     * get target info
     * @return
     */
    Set<PusherTargetEntity> getTargetInfo();

    /**
     * Get all topics
     * @return
     */
    List<String> getConnectTopics();

}
