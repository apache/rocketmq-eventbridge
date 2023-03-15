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

import java.util.Set;
import java.util.concurrent.Executors;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.TimeUnit;
import lombok.extern.slf4j.Slf4j;
import org.apache.rocketmq.common.utils.ThreadUtils;
import org.apache.rocketmq.eventbridge.adapter.runtimer.common.entity.TargetRunnerConfig;
import org.apache.rocketmq.eventbridge.adapter.runtimer.common.plugin.Plugin;

@Slf4j
public class TargetRunnerConfigOnDBObserver extends AbstractTargetRunnerConfigObserver {

    private static ScheduledExecutorService service = Executors.newSingleThreadScheduledExecutor(
        ThreadUtils.newThreadFactory("TargetRunnerConfigOnDBObserver", false));

    public TargetRunnerConfigOnDBObserver(Plugin plugin) {
        this.addListen(this);
    }

    @Override
    public Set<TargetRunnerConfig> getLatestTargetRunnerConfig() {
        return null;
    }

    public void addListen(
        TargetRunnerConfigOnDBObserver pusherConfigOnFileService) {
        service.scheduleAtFixedRate(() -> {
            try {
                Set<TargetRunnerConfig> latest = this.getLatestTargetRunnerConfig();
                Set<TargetRunnerConfig> last = super.getTargetRunnerConfig();
                TargetRunnerConfig changed = null;
                super.onAddTargetRunner(changed);
                super.onUpdateTargetRunner(changed);
                super.onDeleteTargetRunner(changed);
            } catch (Throwable e) {
                log.error("Watch failed.", e);
            }
        }, 0, 3, TimeUnit.SECONDS);
    }

}