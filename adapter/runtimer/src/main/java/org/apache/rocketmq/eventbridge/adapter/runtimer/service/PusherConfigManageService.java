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
 *  Unless required by applicable law or agreed to in writing, software
 *  distributed under the License is distributed on an "AS IS" BASIS,
 *  WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 *  See the License for the specific language governing permissions and
 *  limitations under the License.
 */

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

    /**
     * Persist all the configs in a store.
     */
    void persist();

    /**
     * Register a listener to listen all config update operations.
     *
     * @param listener
     */
    void registerListener(TargetConfigUpdateListener listener);

    interface TargetConfigUpdateListener {

        /**
         * Invoke while connector config changed.
         */
        void onConfigUpdate(PusherTargetEntity targetEntity);
    }

}
