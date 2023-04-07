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
import org.apache.rocketmq.eventbridge.adapter.runtimer.boot.listener.EventSubscriber;
import org.apache.rocketmq.eventbridge.adapter.runtimer.boot.listener.CirculatorContext;
import org.apache.rocketmq.eventbridge.adapter.runtimer.boot.listener.RocketMQEventSubscriber;
import org.apache.rocketmq.eventbridge.adapter.runtimer.common.RuntimerState;
import org.apache.rocketmq.eventbridge.adapter.runtimer.service.AbstractTargetRunnerConfigObserver;
import org.apache.rocketmq.eventbridge.adapter.runtimer.service.TargetRunnerConfigObserver;
import org.apache.rocketmq.eventbridge.adapter.runtimer.service.TargetRunnerConfigOnFileObserver;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;

import javax.annotation.PostConstruct;
import java.util.concurrent.atomic.AtomicReference;

/**
 * event bridge runtimer
 *
 * @author artisan
 */
@Component
public class Runtimer {

    private static final Logger logger = LoggerFactory.getLogger(Runtimer.class);

    private AtomicReference<RuntimerState> runtimerState;

    private CirculatorContext circulatorContext;

    private TargetRunnerConfigObserver runnerConfigObserver;

    public Runtimer(CirculatorContext circulatorContext) {
        this.circulatorContext = circulatorContext;
        this.runnerConfigObserver = new TargetRunnerConfigOnFileObserver();
    }

    @PostConstruct
    public void initAndStart() {
        logger.info("init runtimer task config");
        circulatorContext.initListenerMetadata(runnerConfigObserver.getTargetRunnerConfig());
        EventSubscriber eventSubscriber = new RocketMQEventSubscriber(runnerConfigObserver);
        runnerConfigObserver.registerListener(circulatorContext);
        runnerConfigObserver.registerListener(eventSubscriber);
        new EventBusListener(circulatorContext, eventSubscriber).start();
        new EventRuleTransfer(circulatorContext).start();
        new EventTargetPusher(circulatorContext).start();
        startRuntimer();
    }

    public void startRuntimer() {
        runtimerState = new AtomicReference<>(RuntimerState.START);
    }

}
