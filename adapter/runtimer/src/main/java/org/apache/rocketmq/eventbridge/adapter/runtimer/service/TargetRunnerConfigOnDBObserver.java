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

import com.google.common.collect.Maps;
import com.google.common.collect.Sets;
import com.google.gson.Gson;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.concurrent.Executors;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.TimeUnit;
import javax.annotation.PostConstruct;
import lombok.extern.slf4j.Slf4j;
import org.apache.rocketmq.common.utils.ThreadUtils;
import org.apache.rocketmq.eventbridge.adapter.runtimer.common.entity.TargetRunnerConfig;
import org.apache.rocketmq.eventbridge.domain.model.run.EventTargetRunner;
import org.apache.rocketmq.eventbridge.domain.repository.EventTargetRepository;
import org.apache.rocketmq.eventbridge.domain.repository.EventTargetRunnerRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;

import static org.apache.rocketmq.eventbridge.adapter.runtimer.config.RuntimerConfigDefine.TARGET_RUNNER_KEY;

@Slf4j
@Component
public class TargetRunnerConfigOnDBObserver extends AbstractTargetRunnerConfigObserver {

    private static ScheduledExecutorService service = Executors.newSingleThreadScheduledExecutor(
        ThreadUtils.newThreadFactory("TargetRunnerConfigOnDBObserver", false));

    @Autowired
    EventTargetRunnerRepository eventTargetRunnerRepository;

    @Autowired
    EventTargetRepository eventTargetRepository;

    public TargetRunnerConfigOnDBObserver() {
    }

    @Override
    @Transactional
    public Set<TargetRunnerConfig> getLatestTargetRunnerConfig() {
        List<EventTargetRunner> eventTargetRunners = eventTargetRunnerRepository.listEventTargetRunners(null, null, null);
        Set<TargetRunnerConfig> targetRunnerConfigs = Sets.newHashSet();
        for (EventTargetRunner eventTargetRunner : eventTargetRunners) {
            targetRunnerConfigs.add(new Gson().fromJson(eventTargetRunner.getRunContext(), TargetRunnerConfig.class));
        }
        return targetRunnerConfigs;
    }

    private Map<String, String> buildEventBusComponent(String eventBusName) {
        Map<String, String> component = Maps.newHashMap();
        component.put(TARGET_RUNNER_KEY, eventBusName);
        return component;
    }

    @PostConstruct
    public void addListen() {
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
        }, 0, 30, TimeUnit.SECONDS);
    }

}