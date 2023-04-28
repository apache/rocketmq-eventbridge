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
import com.google.common.collect.Lists;
import io.openmessaging.connector.api.data.ConnectRecord;
import org.apache.commons.collections.CollectionUtils;
import org.apache.commons.collections.MapUtils;
import org.apache.rocketmq.eventbridge.adapter.runtimer.boot.listener.CirculatorContext;
import org.apache.rocketmq.eventbridge.adapter.runtimer.boot.transfer.TransformEngine;
import org.apache.rocketmq.eventbridge.adapter.runtimer.common.ServiceThread;
import org.apache.rocketmq.eventbridge.adapter.runtimer.config.RuntimerConfigDefine;
import org.apache.rocketmq.eventbridge.adapter.runtimer.error.ErrorHandler;
import org.apache.rocketmq.eventbridge.adapter.runtimer.rate.AbsRateEstimator;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;

import javax.annotation.PostConstruct;
import java.util.List;
import java.util.Map;
import java.util.Objects;
import java.util.Set;
import java.util.concurrent.CompletableFuture;
import java.util.stream.Collectors;

/**
 * receive event and transfer the rule to pusher
 */
public class EventRuleTransfer extends ServiceThread {

    private static final Logger logger = LoggerFactory.getLogger(EventRuleTransfer.class);

    @Autowired
    private final CirculatorContext circulatorContext;
    @Autowired
    private final OffsetManager offsetManager;
    @Autowired
    private final ErrorHandler errorHandler;

    private final AbsRateEstimator rateEstimator;

    public EventRuleTransfer(CirculatorContext circulatorContext, OffsetManager offsetManager,
                             ErrorHandler errorHandler, AbsRateEstimator rateEstimator) {
        this.circulatorContext = circulatorContext;
        this.offsetManager = offsetManager;
        this.errorHandler = errorHandler;
        this.rateEstimator = rateEstimator;
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
        while (!stopped) {
            try {
                rateEstimator.acquireTargetQueueLimiter();
            } catch (InterruptedException e) {
                logger.error("acquireTargetQueueLimiter exception - stack-> ", e);
            }
            ConnectRecord eventRecord = circulatorContext.takeEventRecord();
            if (Objects.isNull(eventRecord)) {
                logger.info("listen eventRecord is empty, continue by curTime - {}", System.currentTimeMillis());
                this.waitForRunning(1000);
                continue;
            }
            Map<String, TransformEngine<ConnectRecord>> latestTransformMap = circulatorContext.getTaskTransformMap();
            if (MapUtils.isEmpty(latestTransformMap)) {
                logger.warn("latest transform engine is empty, continue by curTime - {}", System.currentTimeMillis());
                this.waitForRunning(3000);
                continue;
            }
            // the event channel take rocket mq topic name as default
            String eventChannelName = RuntimerConfigDefine.CHANNEL_NAME;
            String eventChannel = eventRecord.getExtension(eventChannelName);
            Set<TransformEngine<ConnectRecord>> adaptTransformSet = latestTransformMap.values().stream()
                    .filter(engine -> eventChannel.equals(engine.getConnectConfig(eventChannelName)))
                    .collect(Collectors.toSet());
            if (CollectionUtils.isEmpty(adaptTransformSet)) {
                logger.warn("adapt specific topic ref transform engine is empty, eventChannelName- {}", eventChannel);
                this.waitForRunning(3000);
                continue;
            }
            List<ConnectRecord> afterTransformConnect = Lists.newArrayList();
            List<CompletableFuture<Void>> completableFutures = Lists.newArrayList();
            adaptTransformSet.forEach(transfer -> {
                CompletableFuture<Void> transformFuture = CompletableFuture.supplyAsync(() -> transfer.doTransforms(eventRecord))
                        .exceptionally((exception) -> {
                            logger.error("transfer do transform event record failed，stackTrace-", exception);
                            errorHandler.handle(eventRecord, exception);
                            return null;
                        })
                        .thenAccept(record -> {
                            if (Objects.nonNull(record)) {
                                String runnerNameKey = RuntimerConfigDefine.RUNNER_NAME;
                                String taskClassKey = RuntimerConfigDefine.TASK_CLASS;
                                record.getExtensions().put(runnerNameKey, transfer.getConnectConfig(runnerNameKey));
                                record.getExtensions().put(taskClassKey, transfer.getConnectConfig(taskClassKey));
                                afterTransformConnect.add(record);
                            } else {
                                offsetManager.commit(eventRecord);
                            }
                        });
                completableFutures.add(transformFuture);
            });

            try {
                CompletableFuture.allOf(completableFutures.toArray(new CompletableFuture[adaptTransformSet.size()])).get();
                circulatorContext.offerTargetTaskQueue(afterTransformConnect);
                logger.info("offer target task queues succeed, transforms - {}", JSON.toJSONString(afterTransformConnect));
            } catch (Exception exception) {
                logger.error("transfer event record failed, stackTrace-", exception);
            }

        }
    }
}
