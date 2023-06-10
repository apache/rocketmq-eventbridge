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

package org.apache.rocketmq.eventbridge.adapter.runtime.config;

import org.apache.rocketmq.eventbridge.adapter.runtime.common.enums.ConfigModeEnum;
import org.apache.rocketmq.eventbridge.adapter.runtime.service.TargetRunnerConfigObserver;
import org.apache.rocketmq.eventbridge.adapter.runtime.service.TargetRunnerConfigOnDBObserver;
import org.apache.rocketmq.eventbridge.adapter.runtime.service.TargetRunnerConfigOnFileObserver;
import org.apache.rocketmq.eventbridge.domain.repository.EventTargetRepository;
import org.apache.rocketmq.eventbridge.domain.repository.EventTargetRunnerRepository;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.DependsOn;

@Configuration
public class RuntimeConfiguration {

    @Bean(name = "runnerConfigObserver")
    public TargetRunnerConfigObserver targetRunnerConfigObserver(@Value("${runtime.config.mode}") String configMode,
        EventTargetRunnerRepository eventTargetRunnerRepository, EventTargetRepository eventTargetRepository) {
        switch (ConfigModeEnum.parse(configMode)) {
            case DB:
                return new TargetRunnerConfigOnDBObserver(eventTargetRunnerRepository, eventTargetRepository);
            default:
                return new TargetRunnerConfigOnFileObserver();
        }
    }

}