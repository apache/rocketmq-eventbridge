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

package org.apache.rocketmq.eventbridge.adapter.runtime;

import org.apache.rocketmq.eventbridge.BridgeMetricsManager;
import org.apache.rocketmq.eventbridge.adapter.runtime.boot.EventBusListener;
import org.apache.rocketmq.eventbridge.adapter.runtime.boot.EventMonitor;
import org.apache.rocketmq.eventbridge.adapter.runtime.boot.EventRuleTransfer;
import org.apache.rocketmq.eventbridge.adapter.runtime.boot.EventTargetTrigger;
import org.apache.rocketmq.eventbridge.adapter.runtime.boot.common.CirculatorContext;
import org.apache.rocketmq.eventbridge.adapter.runtime.boot.common.OffsetManager;
import org.apache.rocketmq.eventbridge.adapter.runtime.boot.listener.EventSubscriber;
import org.apache.rocketmq.eventbridge.adapter.runtime.common.RuntimeState;
import org.apache.rocketmq.eventbridge.adapter.runtime.error.ErrorHandler;
import org.apache.rocketmq.eventbridge.adapter.runtime.service.TargetRunnerConfigObserver;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import org.apache.rocketmq.eventbridge.adapter.runtime.boot.hook.StartAndShutdown;
import org.apache.rocketmq.eventbridge.adapter.runtime.boot.hook.AbstractStartAndShutdown;


import javax.annotation.PostConstruct;
import java.util.concurrent.atomic.AtomicReference;

/**
 * event bridge runtime
 *
 * @author artisan
 */
@Component
public class Runtime {

    private static final Logger logger = LoggerFactory.getLogger(Runtime.class);

    private AtomicReference<RuntimeState> runtimerState;

    private static final RuntimeStartAndShutdown RUNTIME_START_AND_SHUTDOWN = new RuntimeStartAndShutdown();

    @Autowired
    private CirculatorContext circulatorContext;
    @Autowired
    private TargetRunnerConfigObserver runnerConfigObserver;
    @Autowired
    private OffsetManager offsetManager;
    @Autowired
    private EventSubscriber eventSubscriber;
    @Autowired
    private ErrorHandler errorHandler;

    @PostConstruct
    public void initAndStart() throws Exception {
        logger.info("Start init runtime.");
        circulatorContext.initCirculatorContext(runnerConfigObserver.getTargetRunnerConfig());
        runnerConfigObserver.registerListener(circulatorContext);
        runnerConfigObserver.registerListener(eventSubscriber);

        EventMonitor eventMonitor = new EventMonitor(eventSubscriber);
        BridgeMetricsManager metricsManager = eventSubscriber.getMetricsManager();
        EventBusListener eventBusListener = new EventBusListener(circulatorContext, eventSubscriber, errorHandler, metricsManager);
        EventRuleTransfer eventRuleTransfer = new EventRuleTransfer(circulatorContext, offsetManager, errorHandler, metricsManager);
        EventTargetTrigger eventTargetPusher = new EventTargetTrigger(circulatorContext, offsetManager, errorHandler, metricsManager);
        RUNTIME_START_AND_SHUTDOWN.appendStartAndShutdown(eventMonitor);
        RUNTIME_START_AND_SHUTDOWN.appendStartAndShutdown(eventBusListener);
        RUNTIME_START_AND_SHUTDOWN.appendStartAndShutdown(eventRuleTransfer);
        RUNTIME_START_AND_SHUTDOWN.appendStartAndShutdown(eventTargetPusher);

        // start servers one by one.
        RUNTIME_START_AND_SHUTDOWN.start();

        java.lang.Runtime.getRuntime().addShutdownHook(new Thread(() -> {
            logger.info("try to shutdown server");
            try {
                RUNTIME_START_AND_SHUTDOWN.shutdown();
            } catch (Exception e) {
                logger.error("err when shutdown runtime ", e);
            }
        }));

        startRuntimer();
    }

    private static class RuntimeStartAndShutdown extends AbstractStartAndShutdown {
        @Override
        protected void appendStartAndShutdown(StartAndShutdown startAndShutdown) {
            super.appendStartAndShutdown(startAndShutdown);
        }
    }

    public void startRuntimer() {
        runtimerState = new AtomicReference<>(RuntimeState.START);
    }

}
