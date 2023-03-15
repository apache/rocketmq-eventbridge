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

import com.google.common.collect.Sets;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;
import org.apache.rocketmq.eventbridge.adapter.runtimer.boot.listener.TargetRunnerListener;
import org.apache.rocketmq.eventbridge.adapter.runtimer.common.entity.TargetKeyValue;
import org.apache.rocketmq.eventbridge.adapter.runtimer.common.entity.TargetRunnerConfig;
import org.springframework.stereotype.Service;
import org.springframework.util.CollectionUtils;

@Service
public abstract class AbstractTargetRunnerConfigObserver implements TargetRunnerConfigObserver {

    private Set<TargetRunnerConfig> targetRunnerConfigs = Sets.newHashSet();

    /**
     * All listeners to trigger while config change.
     */
    private Set<TargetRunnerListener> targetRunnerConfigListeners = new HashSet<>();

    public Set<TargetRunnerConfig> getTargetRunnerConfig() {
        return targetRunnerConfigs;
    }

    public abstract Set<TargetRunnerConfig> getLatestTargetRunnerConfig();

    @Override
    public void registerListener(TargetRunnerListener listener) {
        this.targetRunnerConfigListeners.add(listener);
    }

    void onAddTargetRunner(TargetRunnerConfig targetRunnerConfig) {
        this.targetRunnerConfigs.add(targetRunnerConfig);
        if (CollectionUtils.isEmpty(this.targetRunnerConfigListeners)) {
            return;
        }
        for (TargetRunnerListener listener : this.targetRunnerConfigListeners) {
            listener.onAddTargetRunner(targetRunnerConfig);
        }
    }

    /**
     * Call when the old target runner updated.
     *
     * @param targetRunnerConfig
     */
    void onUpdateTargetRunner(TargetRunnerConfig targetRunnerConfig) {
        this.targetRunnerConfigs.add(targetRunnerConfig);
        if (CollectionUtils.isEmpty(this.targetRunnerConfigListeners)) {
            return;
        }
        for (TargetRunnerListener listener : this.targetRunnerConfigListeners) {
            listener.onUpdateTargetRunner(targetRunnerConfig);
        }
    }

    /**
     * Call when the old target runner deleted from runtimer.
     *
     * @param targetRunnerConfig
     */
    void onDeleteTargetRunner(TargetRunnerConfig targetRunnerConfig) {
        this.targetRunnerConfigs.remove(targetRunnerConfig);
        if (CollectionUtils.isEmpty(this.targetRunnerConfigListeners)) {
            return;
        }
        for (TargetRunnerListener listener : this.targetRunnerConfigListeners) {
            listener.onDeleteTargetRunner(targetRunnerConfig);
        }
    }

    public Map<String, List<TargetKeyValue>> getTaskConfigs() {
        return null;
    }
}
