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

package org.apache.rocketmq.eventbridge.adapter.runtime.boot.listener;

import io.openmessaging.connector.api.data.ConnectRecord;
import org.apache.rocketmq.eventbridge.adapter.runtime.boot.common.TargetRunnerListener;
import org.apache.rocketmq.eventbridge.adapter.runtime.common.entity.SubscribeRunnerKeys;
import org.apache.rocketmq.eventbridge.adapter.runtime.common.entity.TargetRunnerConfig;
import org.apache.rocketmq.eventbridge.adapter.runtime.common.enums.RefreshTypeEnum;
import org.apache.rocketmq.eventbridge.metrics.BridgeConfig;

import java.util.List;

public abstract class EventSubscriber implements TargetRunnerListener {

    /**
     * Refresh subscriber inner data when runner keys changed
     * @param subscribeRunnerKeys
     * @param refreshTypeEnum
     */
    public abstract void refresh(SubscribeRunnerKeys subscribeRunnerKeys, RefreshTypeEnum refreshTypeEnum);

    /**
     * fetch metrics configuration
     * @return
     */
    public abstract BridgeConfig fetchMetricsConf();
    /**
     * Pull connect records from store, Blocking method when is empty.
     *
     * @return
     */
    public abstract List<ConnectRecord> pull();

    /**
     * Commit the connect records.
     *
     * @param connectRecordList
     */
    public abstract void commit(List<ConnectRecord> connectRecordList);

    /**
     * Put the connect record to the eventbus.
     * @param eventBusName
     * @param connectRecord
     * @param delaySec
     */
    public  boolean put(String eventBusName, ConnectRecord connectRecord, int delaySec){
        // convert the eventBusName to Topic ?
        return true;
    }

    /**
     * Call when add new target runner to runtimer.
     *
     * @param targetRunnerConfig
     */
    @Override
    public void onAddTargetRunner(TargetRunnerConfig targetRunnerConfig) {
        this.refresh(targetRunnerConfig.getSubscribeRunnerKeys(), RefreshTypeEnum.ADD);
    }

    /**
     * Call when the old target runner updated.
     *
     * @param targetRunnerConfig
     */
    @Override
    public void onUpdateTargetRunner(TargetRunnerConfig targetRunnerConfig) {
        this.refresh(targetRunnerConfig.getSubscribeRunnerKeys(), RefreshTypeEnum.UPDATE);
    }

    /**
     * Call when the old target runner deleted from runtimer.
     *
     * @param targetRunnerConfig
     */
    @Override
    public void onDeleteTargetRunner(TargetRunnerConfig targetRunnerConfig) {
        this.refresh(targetRunnerConfig.getSubscribeRunnerKeys(), RefreshTypeEnum.DELETE);
    }

}