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
import org.apache.rocketmq.eventbridge.metrics.BridgeMetricsManager;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

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
    public void initAndStart() {
        logger.info("Start init runtime.");
        circulatorContext.initCirculatorContext(runnerConfigObserver.getTargetRunnerConfig());
        runnerConfigObserver.registerListener(circulatorContext);
        runnerConfigObserver.registerListener(eventSubscriber);
        BridgeMetricsManager metricsManager = eventSubscriber.getMetricsManager();
        new EventMonitor(eventSubscriber).start();
        new EventBusListener(circulatorContext, eventSubscriber, errorHandler, metricsManager).start();
        new EventRuleTransfer(circulatorContext, offsetManager, errorHandler, metricsManager).start();
        new EventTargetTrigger(circulatorContext, offsetManager, errorHandler, metricsManager).start();
        startRuntimer();
    }

    public void startRuntimer() {
        runtimerState = new AtomicReference<>(RuntimeState.START);
    }

}
