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

import java.util.List;
import java.util.Map;
import java.util.Set;
import org.apache.rocketmq.eventbridge.adapter.runtimer.boot.listener.TargetRunnerListener;
import org.apache.rocketmq.eventbridge.adapter.runtimer.common.entity.TargetKeyValue;
import org.apache.rocketmq.eventbridge.adapter.runtimer.common.entity.TargetRunnerConfig;

/**
 * manage the pusher connector/task config info
 */
public interface TargetRunnerConfigObserver {

    /**
     * Get the target runner config of runtimer.
     * @return
     */
    Set<TargetRunnerConfig> getTargetRunnerConfig();

    /**
     * Register a listener to listen all config update operations.
     *
     * @param listener
     */
    void registerListener(TargetRunnerListener listener);

    @Deprecated
    Map<String, List<TargetKeyValue>> getTaskConfigs();
}
