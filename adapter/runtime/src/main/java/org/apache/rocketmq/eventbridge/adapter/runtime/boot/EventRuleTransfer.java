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
import org.apache.commons.collections.CollectionUtils;
import org.apache.commons.collections.MapUtils;
import org.apache.commons.lang3.StringUtils;
import org.apache.rocketmq.eventbridge.adapter.runtime.boot.common.CirculatorContext;
import org.apache.rocketmq.eventbridge.adapter.runtime.boot.common.OffsetManager;
import org.apache.rocketmq.eventbridge.adapter.runtime.boot.transfer.TransformEngine;
import org.apache.rocketmq.eventbridge.adapter.runtime.common.ServiceThread;
import org.apache.rocketmq.eventbridge.adapter.runtime.error.ErrorHandler;
import org.apache.rocketmq.eventbridge.adapter.runtime.rate.AbsRateEstimator;
import org.apache.rocketmq.eventbridge.adapter.runtime.rate.EstimateMetrics;
import org.apache.rocketmq.eventbridge.adapter.runtime.rate.RunnerMetrics;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import javax.annotation.PostConstruct;
import java.util.List;
import java.util.Map;
import java.util.Objects;
import java.util.concurrent.CompletableFuture;

/**
 * receive event and transfer the rule to pusher
 */
public class EventRuleTransfer extends ServiceThread {

    private static final Logger logger = LoggerFactory.getLogger(EventRuleTransfer.class);

    private volatile Integer batchSize = 100;

    private final CirculatorContext circulatorContext;
    private final OffsetManager offsetManager;
    private final ErrorHandler errorHandler;
    private final AbsRateEstimator absRateEstimator;

    public EventRuleTransfer(CirculatorContext circulatorContext, OffsetManager offsetManager,
                             ErrorHandler errorHandler,AbsRateEstimator absRateEstimator) {
        this.circulatorContext = circulatorContext;
        this.offsetManager = offsetManager;
        this.errorHandler = errorHandler;
        this.absRateEstimator = absRateEstimator;
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
            // 获取transform完成的runnerName进行推送
            String runnerName = circulatorContext.takeRuleRunnerName();
            // 开始处理本批次数据同时，立刻通知bus获取下一批次的数据
            circulatorContext.offerBusQueue(runnerName);

            if (StringUtils.isBlank(runnerName)) {
                logger.info("no push data ");
                this.waitForRunning(1000);
                continue;
            }

            // 获取可以拉取的runnerName
            RunnerMetrics transformMetrics = circulatorContext.getTransformMetrics(runnerName);
            if (Objects.isNull(transformMetrics)) {
                continue;
            }

            //Map<String, List<ConnectRecord>> eventRecordMap = circulatorContext.takeEventRecords(batchSize);
            List<ConnectRecord> curEventRecords = circulatorContext.takeEventRecord(runnerName, transformMetrics.getCwnd());

            if (CollectionUtils.isEmpty(curEventRecords)) {
                logger.info("listen eventRecords is empty, continue by curTime - {}", System.currentTimeMillis());
                this.waitForRunning(1000);
                continue;
            }
            Map<String, TransformEngine<ConnectRecord>> latestTransformMap = circulatorContext.getTaskTransformMap();
            if (MapUtils.isEmpty(latestTransformMap)) {
                logger.warn("latest transform engine is empty, continue by curTime - {}", System.currentTimeMillis());
                this.waitForRunning(3000);
                continue;
            }

            // 开始执行时间戳，用于计算本次tps
            long startTimestamp = System.currentTimeMillis();
            List<ConnectRecord> afterTransformConnect = Lists.newArrayList();
            List<CompletableFuture<Void>> completableFutures = Lists.newArrayList();

            TransformEngine<ConnectRecord> curTransformEngine = latestTransformMap.get(runnerName);
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


            int cwnd = transformMetrics.getCwnd();
            int ssthresh = transformMetrics.getSsthresh();

            try {
                CompletableFuture.allOf(completableFutures.toArray(new CompletableFuture[curEventRecords.size()])).get();
                circulatorContext.offerTargetTaskQueue(afterTransformConnect);

                // 写入pusher的任务队列通知pusher数据转换完成
                circulatorContext.offerTargetQueue(runnerName);

                // 计算本次处理速率，作用于下一次
                EstimateMetrics estimateMetrics = new EstimateMetrics(runnerName, EstimateMetrics.CommonTypeEnum.TRANS);
                estimateMetrics.setRunnerName(runnerName);
                estimateMetrics.setBatchSize(afterTransformConnect.size());
                estimateMetrics.setSsthresh(ssthresh);

                RunnerMetrics pushMetrics = circulatorContext.getpushMetrics(runnerName);
                int rwnd = pushMetrics.getCwnd();

                int transformers = (curTransformEngine.getTransformSize() > 0) ? curTransformEngine.getTransformSize(): 1;
                int finalCwnd = cwnd * transformers;
                estimateMetrics.setCwnd(finalCwnd);
                estimateMetrics.setRwnd(rwnd);
                estimateMetrics.setStartTimestamp(startTimestamp);
                estimateMetrics.setEndTimestamp(System.currentTimeMillis());

                RunnerMetrics compute = absRateEstimator.compute(estimateMetrics);
                // 发布本次接收窗口
                circulatorContext.publishTransformMetrics(compute);
                // 计算本次处理速率，作用于下一次

                logger.info("offer target task queues succeed, transforms - {}", JSON.toJSONString(afterTransformConnect));
            } catch (Exception exception) {
                logger.error("transfer event record failed, stackTrace-", exception);

                // 异常TPS计算
                EstimateMetrics estimateMetrics = new EstimateMetrics(runnerName, EstimateMetrics.CommonTypeEnum.TRANS);
                estimateMetrics.setRunnerName(runnerName);
                estimateMetrics.setSsthresh(ssthresh);
                estimateMetrics.setCwnd(cwnd);
                estimateMetrics.setError(true);

                RunnerMetrics compute = absRateEstimator.compute(estimateMetrics);
                // 发布本次接收窗口
                circulatorContext.publishTransformMetrics(compute);
                // 异常TPS计算

                afterTransformConnect.forEach(transferRecord -> errorHandler.handle(transferRecord, exception));
            }
        }
    }
}