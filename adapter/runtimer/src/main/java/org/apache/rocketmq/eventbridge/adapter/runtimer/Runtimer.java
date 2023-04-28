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

import java.util.concurrent.atomic.AtomicReference;
import javax.annotation.PostConstruct;
import org.apache.rocketmq.eventbridge.adapter.runtimer.boot.EventBusListener;
import org.apache.rocketmq.eventbridge.adapter.runtimer.boot.EventRuleTransfer;
import org.apache.rocketmq.eventbridge.adapter.runtimer.boot.EventTargetPusher;
import org.apache.rocketmq.eventbridge.adapter.runtimer.boot.OffsetManager;
import org.apache.rocketmq.eventbridge.adapter.runtimer.boot.listener.CirculatorContext;
import org.apache.rocketmq.eventbridge.adapter.runtimer.boot.listener.EventSubscriber;
import org.apache.rocketmq.eventbridge.adapter.runtimer.common.RuntimerState;
import org.apache.rocketmq.eventbridge.adapter.runtimer.error.ErrorHandler;
import org.apache.rocketmq.eventbridge.adapter.runtimer.rate.AbsRateEstimator;
import org.apache.rocketmq.eventbridge.adapter.runtimer.rate.PIDRateEstimator;
import org.apache.rocketmq.eventbridge.adapter.runtimer.rate.RunnerMetrics;
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

    private AbsRateEstimator absRateEstimator;

    private RunnerMetrics runnerMetrics;

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
    public void initAndStart() {
        logger.info("Start init runtimer.");
        circulatorContext.initListenerMetadata(runnerConfigObserver.getTargetRunnerConfig());
        runnerConfigObserver.registerListener(circulatorContext);
        runnerConfigObserver.registerListener(eventSubscriber);

        absRateEstimator=new PIDRateEstimator(circulatorContext,runnerMetrics);
        absRateEstimator.start();

        new EventBusListener(circulatorContext, eventSubscriber, errorHandler,absRateEstimator).start();
        new EventRuleTransfer(circulatorContext, offsetManager, errorHandler,absRateEstimator).start();
        new EventTargetPusher(circulatorContext, offsetManager, errorHandler).start();
        startRuntimer();
    }

    public void startRuntimer() {
        runtimerState = new AtomicReference<>(RuntimerState.START);
    }

}
