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
import io.openmessaging.connector.api.component.task.sink.SinkTask;
import io.openmessaging.connector.api.data.ConnectRecord;
import org.apache.commons.collections.CollectionUtils;
import org.apache.commons.lang3.StringUtils;
import org.apache.rocketmq.eventbridge.adapter.runtime.boot.common.CirculatorContext;
import org.apache.rocketmq.eventbridge.adapter.runtime.boot.common.OffsetManager;
import org.apache.rocketmq.eventbridge.adapter.runtime.common.ServiceThread;
import org.apache.rocketmq.eventbridge.adapter.runtime.error.ErrorHandler;
import org.apache.rocketmq.eventbridge.adapter.runtime.rate.AbsRateEstimator;
import org.apache.rocketmq.eventbridge.adapter.runtime.rate.EstimateMetrics;
import org.apache.rocketmq.eventbridge.adapter.runtime.rate.RunnerMetrics;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.List;
import java.util.Objects;
import java.util.concurrent.ExecutorService;

/**
 * event target push to sink task
 *
 * @author artisan
 */
public class EventTargetTrigger extends ServiceThread {

    private static final Logger logger = LoggerFactory.getLogger(EventTargetTrigger.class);

    private final CirculatorContext circulatorContext;
    private final OffsetManager offsetManager;
    private final ErrorHandler errorHandler;
    private final AbsRateEstimator absRateEstimator;

    public EventTargetTrigger(CirculatorContext circulatorContext, OffsetManager offsetManager,
                              ErrorHandler errorHandler, AbsRateEstimator absRateEstimator) {
        this.circulatorContext = circulatorContext;
        this.offsetManager = offsetManager;
        this.errorHandler = errorHandler;
        this.absRateEstimator = absRateEstimator;
    }

    @Override
    public void run() {
        while (!stopped) {
            // 获取transform完成的runnerName进行推送
            String runnerName = circulatorContext.takeTargetRunnerName();
            // 开始处理本批次数据同时，立刻通知transform获取下一批次的数据
            circulatorContext.offerRuleQueue(runnerName);

            if (StringUtils.isBlank(runnerName)) {
                logger.info("no push data ");
                this.waitForRunning(1000);
                continue;
            }

            // 获取可以拉取的runnerName
            RunnerMetrics runnerMetrics = circulatorContext.getpushMetrics(runnerName);
            if (Objects.isNull(runnerMetrics)) { //如果为空表示runnerName已经被移除
                continue;
            }
            List<ConnectRecord> recordList = circulatorContext.takeTargetMap(runnerName, runnerMetrics.getCwnd());

            if (CollectionUtils.isEmpty(recordList)) {
                this.waitForRunning(1000);
                continue;
            }

            // Map<String, List<ConnectRecord>> targetRecordMap = circulatorContext.takeTargetRecords(batchSize);
            if (CollectionUtils.isEmpty(recordList)) {
                logger.info("current target pusher is empty");
                this.waitForRunning(1000);
                continue;
            }
            if (logger.isDebugEnabled()) {
                logger.debug("start push content by pusher - {}", JSON.toJSONString(recordList));
            }

            // 开始执行时间戳，用于计算本次tps
            long startTimestamp = System.currentTimeMillis();
            ExecutorService executorService = circulatorContext.getExecutorService(runnerName);
            executorService.execute(() -> {
                int cwnd = runnerMetrics.getCwnd();
                int ssthresh = runnerMetrics.getSsthresh();
                SinkTask sinkTask = circulatorContext.getPusherTaskMap().get(runnerName);
                try {
                    sinkTask.put(recordList);
                    offsetManager.commit(recordList);

                    // 计算本次处理速率，作用于下一次
                    EstimateMetrics estimateMetrics = new EstimateMetrics(runnerName, EstimateMetrics.CommonTypeEnum.PUSHER);
                    estimateMetrics.setRunnerName(runnerName);
                    estimateMetrics.setBatchSize(recordList.size());
                    estimateMetrics.setSsthresh(ssthresh);
                    estimateMetrics.setCwnd(cwnd);
                    estimateMetrics.setStartTimestamp(startTimestamp);
                    estimateMetrics.setEndTimestamp(System.currentTimeMillis());

                    RunnerMetrics compute = absRateEstimator.compute(estimateMetrics);
                    // 发布本次接收窗口
                    circulatorContext.publishPushMetrics(compute);
                    // 计算本次处理速率，作用于下一次

                } catch (Exception exception) {
                    logger.error(getServiceName() + " push target exception, stackTrace-", exception);

                    // 异常TPS计算
                    EstimateMetrics estimateMetrics = new EstimateMetrics(runnerName, EstimateMetrics.CommonTypeEnum.PUSHER);
                    estimateMetrics.setRunnerName(runnerName);
                    estimateMetrics.setSsthresh(ssthresh);
                    estimateMetrics.setCwnd(cwnd);
                    estimateMetrics.setError(true);

                    RunnerMetrics compute = absRateEstimator.compute(estimateMetrics);
                    // 发布本次接收窗口
                    circulatorContext.publishPushMetrics(compute);
                    // 异常TPS计算

                    recordList.forEach(triggerRecord -> errorHandler.handle(triggerRecord, exception));
                }
            });
        }
    }

    @Override
    public String getServiceName() {
        return EventTargetTrigger.class.getSimpleName();
    }

}
