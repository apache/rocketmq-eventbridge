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

import org.apache.rocketmq.eventbridge.adapter.runtimer.boot.EventBusListener;
import org.apache.rocketmq.eventbridge.adapter.runtimer.boot.EventRuleTransfer;
import org.apache.rocketmq.eventbridge.adapter.runtimer.boot.EventTargetPusher;
import org.apache.rocketmq.eventbridge.adapter.runtimer.boot.listener.ListenerFactory;
import org.apache.rocketmq.eventbridge.adapter.runtimer.common.entity.PusherTargetEntity;
import org.apache.rocketmq.eventbridge.adapter.runtimer.common.entity.TargetKeyValue;
import org.apache.rocketmq.eventbridge.adapter.runtimer.common.RuntimerState;
import org.apache.rocketmq.eventbridge.adapter.runtimer.common.ServiceThread;
import org.apache.rocketmq.eventbridge.adapter.runtimer.common.plugin.Plugin;
import org.apache.rocketmq.eventbridge.adapter.runtimer.config.RuntimerConfig;
import org.apache.rocketmq.eventbridge.adapter.runtimer.service.PusherConfigManageService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;

import javax.annotation.PostConstruct;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Objects;
import java.util.concurrent.Executor;
import java.util.concurrent.Executors;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.atomic.AtomicReference;

/**
 * event bridge runtimer
 *
 * @author artisan
 */
@Component
public class Runtimer extends ServiceThread{

    private static final Logger logger = LoggerFactory.getLogger(Runtimer.class);

    private AtomicReference<RuntimerState> runtimerState;

    private Plugin plugin;

    private ListenerFactory listenerFactory;

    private PusherConfigManageService pusherConfigManageService;

    private Map<String, List<TargetKeyValue>> taskConfigs = new HashMap<>();

    private EventBusListener listener;

    private EventRuleTransfer transfer;

    private EventTargetPusher pusher;

    private ScheduledExecutorService scheduledExecutorService = Executors.newSingleThreadScheduledExecutor((Runnable r) -> new Thread(r, "RuntimerScheduledThread"));

    public Runtimer(Plugin plugin, ListenerFactory listenerFactory, PusherConfigManageService configManageService) {
        this.plugin = plugin;
        this.listenerFactory = listenerFactory;
        this.pusherConfigManageService = configManageService;
    }

    @PostConstruct
    public void initAndStart() {
        logger.info("init runtimer task config");
        this.taskConfigs = pusherConfigManageService.getTaskConfigs();
        listener = new EventBusListener(listenerFactory, pusherConfigManageService);
        listener.initOrUpdateListenConsumer(taskConfigs);
        transfer = new EventRuleTransfer(plugin, listenerFactory, pusherConfigManageService);
        transfer.initOrUpdateTaskTransform(taskConfigs);
        pusher = new EventTargetPusher(plugin, listenerFactory, pusherConfigManageService);
        pusher.initOrUpdatePusherTask(taskConfigs);
        startRuntimer();
    }

    public void startRuntimer() {
        runtimerState = new AtomicReference<>(RuntimerState.START);
        this.start();
    }

    @Override
    public String getServiceName() {
        return Runtimer.class.getSimpleName();
    }

    @Override
    public void run() {

        listener.start();

        transfer.start();

        pusher.start();

        scheduledExecutorService.scheduleAtFixedRate(() -> {
            try {
                this.pusherConfigManageService.persist();
            } catch (Exception e) {
                logger.error("schedule persist config error.", e);
            }
        }, 500, 500, TimeUnit.MILLISECONDS);

    }
}
