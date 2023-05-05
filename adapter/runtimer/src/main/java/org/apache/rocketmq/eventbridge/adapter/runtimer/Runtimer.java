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

import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.ThreadPoolExecutor;
import java.util.concurrent.atomic.AtomicReference;
import javax.annotation.PostConstruct;
import org.apache.rocketmq.eventbridge.adapter.runtimer.boot.EventBusListener;
import org.apache.rocketmq.eventbridge.adapter.runtimer.boot.EventRuleTransfer;
import org.apache.rocketmq.eventbridge.adapter.runtimer.boot.EventTargetPusher;
import org.apache.rocketmq.eventbridge.adapter.runtimer.boot.OffsetManager;
import org.apache.rocketmq.eventbridge.adapter.runtimer.boot.hook.AbstractStartAndShutdown;
import org.apache.rocketmq.eventbridge.adapter.runtimer.boot.hook.StartAndShutdown;
import org.apache.rocketmq.eventbridge.adapter.runtimer.boot.listener.CirculatorContext;
import org.apache.rocketmq.eventbridge.adapter.runtimer.boot.listener.EventSubscriber;
import org.apache.rocketmq.eventbridge.adapter.runtimer.common.RuntimerState;
import org.apache.rocketmq.eventbridge.adapter.runtimer.common.ShutdownHookThread;
import org.apache.rocketmq.eventbridge.adapter.runtimer.common.enums.ConfigModeEnum;
import org.apache.rocketmq.eventbridge.adapter.runtimer.error.ErrorHandler;
import org.apache.rocketmq.eventbridge.adapter.runtimer.service.TargetRunnerConfigObserver;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
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

    public Runtimer(
        CirculatorContext circulatorContext,
        TargetRunnerConfigObserver runnerConfigObserver,
        OffsetManager offsetManager,
        EventSubscriber eventSubscriber,
        ErrorHandler errorHandler) {
        this.circulatorContext = circulatorContext;
        this.runnerConfigObserver = runnerConfigObserver;
        this.offsetManager = offsetManager;
        this.eventSubscriber = eventSubscriber;
        this.errorHandler = errorHandler;
    }

    @PostConstruct
    public void initAndStart() throws Exception {
        logger.info("Start init runtimer.");
        circulatorContext.initListenerMetadata(runnerConfigObserver.getTargetRunnerConfig());
        runnerConfigObserver.registerListener(circulatorContext);
        runnerConfigObserver.registerListener(eventSubscriber);
        EventBusListener eventBusListener = new EventBusListener(circulatorContext, eventSubscriber, errorHandler);
        EventRuleTransfer eventRuleTransfer = new EventRuleTransfer(circulatorContext, offsetManager, errorHandler);
        EventTargetPusher eventTargetPusher = new EventTargetPusher(circulatorContext, offsetManager, errorHandler);
        RUNTIME_START_AND_SHUTDOWN.appendStartAndShutdown(eventBusListener);
        RUNTIME_START_AND_SHUTDOWN.appendStartAndShutdown(eventRuleTransfer);
        RUNTIME_START_AND_SHUTDOWN.appendStartAndShutdown(eventTargetPusher);

        // start servers one by one.
        RUNTIME_START_AND_SHUTDOWN.start();

        Runtime.getRuntime().addShutdownHook(new Thread(() -> {
            logger.info("try to shutdown server");
            try {
                RUNTIME_START_AND_SHUTDOWN.shutdown();
            } catch (Exception e) {
                logger.error("err when shutdown rocketmq-proxy", e);
            }
        }));

        startRuntimer();
    }

    private static class RuntimeStartAndShutdown extends AbstractStartAndShutdown {
        @Override
        public void appendStartAndShutdown(StartAndShutdown startAndShutdown) {
            super.appendStartAndShutdown(startAndShutdown);
        }
    }

    public void startRuntimer() {
        runtimerState = new AtomicReference<>(RuntimerState.START);
    }

}
