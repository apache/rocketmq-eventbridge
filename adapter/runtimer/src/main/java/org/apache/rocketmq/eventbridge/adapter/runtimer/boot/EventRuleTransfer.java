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

package org.apache.rocketmq.eventbridge.adapter.runtimer.boot;

import com.alibaba.fastjson.JSON;
import io.openmessaging.connector.api.data.ConnectRecord;
import org.apache.rocketmq.eventbridge.adapter.runtimer.boot.listener.ListenerFactory;
import org.apache.rocketmq.eventbridge.adapter.runtimer.boot.transfer.TransformEngine;
import org.apache.rocketmq.eventbridge.adapter.runtimer.common.ServiceThread;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.Objects;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.LinkedBlockingDeque;
import java.util.concurrent.ThreadPoolExecutor;
import java.util.concurrent.TimeUnit;

/**
 * receive event and transfer the rule to pusher
 */
public class EventRuleTransfer extends ServiceThread {

    private static final Logger logger = LoggerFactory.getLogger(EventRuleTransfer.class);

    private ListenerFactory listenerFactory;

    private ExecutorService executorService = new ThreadPoolExecutor(20, 60, 1000, TimeUnit.MICROSECONDS, new LinkedBlockingDeque<>(100));

    public EventRuleTransfer(ListenerFactory listenerFactory) {
        this.listenerFactory = listenerFactory;
    }

    @Override
    public String getServiceName() {
        return this.getClass().getSimpleName();
    }

    @Override
    public void run() {
        while (!stopped) {
            // add CompletableFuture
            ConnectRecord eventRecord = listenerFactory.takeEventRecord();
            if (Objects.isNull(eventRecord)) {
                logger.info("listen eventRecord is empty, continue by curTime - {}", System.currentTimeMillis());
                this.waitForRunning(1000);
                continue;
            }
            executorService.submit(() -> {
                // extension add sub
                // rule - target
                listenerFactory.getTaskTransformMap().entrySet().forEach(entry -> {
                    TransformEngine<ConnectRecord> transformEngine = entry.getValue();
                    ConnectRecord transformRecord = transformEngine.doTransforms(eventRecord);
                    if (Objects.isNull(transformRecord)) {
                        return;
                    }
                    // a bean for maintain
                    listenerFactory.offerTargetTaskQueue(transformRecord);
                    logger.debug("offer target task queue succeed, targetMap - {}", JSON.toJSONString(transformRecord));
                });
            });
        }
    }
}
