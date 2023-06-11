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

package org.apache.rocketmq.eventbridge.adapter.runtime.boot;

import com.alibaba.fastjson.JSON;
import com.google.common.collect.Lists;
import io.openmessaging.connector.api.data.ConnectRecord;
import java.util.List;
import java.util.Map;
import java.util.Objects;
import java.util.concurrent.CompletableFuture;
import javax.annotation.PostConstruct;
import org.apache.commons.collections.MapUtils;
import org.apache.rocketmq.eventbridge.adapter.runtime.boot.common.CirculatorContext;
import org.apache.rocketmq.eventbridge.adapter.runtime.boot.common.OffsetManager;
import org.apache.rocketmq.eventbridge.adapter.runtime.boot.transfer.TransformEngine;
import org.apache.rocketmq.eventbridge.adapter.runtime.common.ServiceThread;
import org.apache.rocketmq.eventbridge.adapter.runtime.error.ErrorHandler;
import org.apache.rocketmq.eventbridge.adapter.runtime.utils.ExceptionUtil;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 * receive event and transfer the rule to pusher
 */
public class EventRuleTransfer extends ServiceThread {

    private static final Logger logger = LoggerFactory.getLogger(EventRuleTransfer.class);

    private volatile Integer batchSize = 100;

    private final CirculatorContext circulatorContext;
    private final OffsetManager offsetManager;
    private final ErrorHandler errorHandler;

    public EventRuleTransfer(CirculatorContext circulatorContext, OffsetManager offsetManager,
        ErrorHandler errorHandler) {
        this.circulatorContext = circulatorContext;
        this.offsetManager = offsetManager;
        this.errorHandler = errorHandler;
    }

    @Override
    public String getServiceName() {
        return this.getClass().getSimpleName();
    }

    @PostConstruct
    public void init() {
        super.start();
    }

    @Override
    public void run() {
        List<ConnectRecord> afterTransformConnect= Lists.newArrayList();
        while (!stopped) {
            try {
                Map<String, List<ConnectRecord>> eventRecordMap = circulatorContext.takeEventRecords(batchSize);
                if (MapUtils.isEmpty(eventRecordMap)) {
                    logger.trace("listen eventRecords is empty, continue by curTime - {}", System.currentTimeMillis());
                    this.waitForRunning(1000);
                    continue;
                }
                Map<String, TransformEngine<ConnectRecord>> latestTransformMap = circulatorContext.getTaskTransformMap();
                if (MapUtils.isEmpty(latestTransformMap)) {
                    logger.warn("latest transform engine is empty, continue by curTime - {}", System.currentTimeMillis());
                    this.waitForRunning(3000);
                    continue;
                }

                afterTransformConnect.clear();
                List<CompletableFuture<Void>> completableFutures = Lists.newArrayList();
                for (String runnerName : eventRecordMap.keySet()) {
                    TransformEngine<ConnectRecord> curTransformEngine = latestTransformMap.get(runnerName);
                    List<ConnectRecord> curEventRecords = eventRecordMap.get(runnerName);
                    curEventRecords.forEach(pullRecord -> {
                        CompletableFuture<Void> transformFuture = CompletableFuture.supplyAsync(() -> curTransformEngine.doTransforms(pullRecord))
                            .exceptionally((exception) -> {
                                logger.error("transfer do transform event record failed，stackTrace-", exception);
                                errorHandler.handle(pullRecord, exception);
                                return null;
                            })
                            .thenAccept(pushRecord -> {
                                if (Objects.nonNull(pushRecord)) {
                                    afterTransformConnect.add(pushRecord);
                                } else {
                                    offsetManager.commit(pullRecord);
                                }
                            });
                        completableFutures.add(transformFuture);
                    });
                }
                CompletableFuture.allOf(completableFutures.toArray(new CompletableFuture[eventRecordMap.values().size()])).get();
                circulatorContext.offerTargetTaskQueue(afterTransformConnect);
                logger.info("offer target task queues succeed, transforms - {}", JSON.toJSONString(afterTransformConnect));
            } catch (Exception exception) {
                logger.error("transfer event record failed, stackTrace-", exception);
                afterTransformConnect.forEach(transferRecord -> errorHandler.handle(transferRecord, exception));
            }

        }
    }

    @Override
    public void start() {
        thread.start();
    }

    @Override
    public void shutdown() {
        try {
            circulatorContext.releaseTaskTransform();
        } catch (Exception e) {
            logger.error(String.format("current thread: %s, error Track: %s ", getServiceName(), ExceptionUtil.getErrorMessage(e)));
        }
    }

}
