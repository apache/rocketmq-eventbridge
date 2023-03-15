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

package org.apache.rocketmq.eventbridge.adapter.runtimer.boot.listener;

import io.openmessaging.connector.api.data.ConnectRecord;
import java.util.List;
import org.apache.rocketmq.eventbridge.adapter.runtimer.common.entity.TargetRunnerConfig;

public abstract class EventSubscriber implements TargetRunnerListener {

    abstract void refresh();

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
     * Call when add new target runner to runtimer.
     *
     * @param targetRunnerConfig
     */
    @Override
    public void onAddTargetRunner(TargetRunnerConfig targetRunnerConfig) {
        this.refresh();
    }

    /**
     * Call when the old target runner updated.
     *
     * @param targetRunnerConfig
     */
    @Override
    public void onUpdateTargetRunner(TargetRunnerConfig targetRunnerConfig) {

        this.refresh();
    }

    /**
     * Call when the old target runner deleted from runtimer.
     *
     * @param targetRunnerConfig
     */
    @Override
    public void onDeleteTargetRunner(TargetRunnerConfig targetRunnerConfig) {
        this.refresh();
    }

}