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

package org.apache.rocketmq.eventbridge.adapter.runtimer;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.concurrent.Executors;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.atomic.AtomicReference;
import javax.annotation.PostConstruct;
import org.apache.rocketmq.eventbridge.adapter.runtimer.boot.EventBusListener;
import org.apache.rocketmq.eventbridge.adapter.runtimer.boot.EventRuleTransfer;
import org.apache.rocketmq.eventbridge.adapter.runtimer.boot.EventTargetPusher;
import org.apache.rocketmq.eventbridge.adapter.runtimer.boot.listener.ListenerFactory;
import org.apache.rocketmq.eventbridge.adapter.runtimer.boot.listener.RocketMQEventSubscriber;
import org.apache.rocketmq.eventbridge.adapter.runtimer.common.RuntimerState;
import org.apache.rocketmq.eventbridge.adapter.runtimer.common.entity.TargetKeyValue;
import org.apache.rocketmq.eventbridge.adapter.runtimer.common.plugin.Plugin;
import org.apache.rocketmq.eventbridge.adapter.runtimer.service.TargetRunnerConfigObserver;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;

/**
 * event bridge runtimer
 *
 * @author artisan
 */
@Component
public class Runtimer {

    private static final Logger logger = LoggerFactory.getLogger(Runtimer.class);

    private AtomicReference<RuntimerState> runtimerState;

    private Plugin plugin;

    private ListenerFactory listenerFactory;

    private TargetRunnerConfigObserver targetRunnerConfigObserver;

    private Map<String, List<TargetKeyValue>> taskConfigs = new HashMap<>();

    private EventBusListener listener;

    private EventRuleTransfer transfer;

    private EventTargetPusher pusher;

    private ScheduledExecutorService scheduledExecutorService = Executors.newSingleThreadScheduledExecutor((Runnable r) -> new Thread(r, "RuntimerScheduledThread"));

    public Runtimer(Plugin plugin, ListenerFactory listenerFactory, TargetRunnerConfigObserver configManageService) {
        this.plugin = plugin;
        this.listenerFactory = listenerFactory;
        this.targetRunnerConfigObserver = configManageService;
    }

    @PostConstruct
    public void initAndStart() {
        logger.info("init runtimer task config");
        new EventBusListener(listenerFactory, new RocketMQEventSubscriber(listenerFactory)).start();
        new EventRuleTransfer(listenerFactory).start();
        new EventTargetPusher(listenerFactory).start();
        startRuntimer();
    }

    public void startRuntimer() {
        runtimerState = new AtomicReference<>(RuntimerState.START);
    }

}
