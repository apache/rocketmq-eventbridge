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

import com.google.common.collect.Lists;
import io.openmessaging.connector.api.data.ConnectRecord;
import java.util.List;
import java.util.Objects;

import org.apache.commons.collections.CollectionUtils;
import org.apache.commons.lang3.StringUtils;
import org.apache.rocketmq.eventbridge.adapter.runtime.boot.common.CirculatorContext;
import org.apache.rocketmq.eventbridge.adapter.runtime.boot.listener.EventSubscriber;
import org.apache.rocketmq.eventbridge.adapter.runtime.common.ServiceThread;
import org.apache.rocketmq.eventbridge.adapter.runtime.error.ErrorHandler;
import org.apache.rocketmq.eventbridge.adapter.runtime.rate.RunnerMetrics;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 * listen the event and offer to queue
 *
 * @author artisan
 */
public class EventBusListener extends ServiceThread {

    private static final Logger logger = LoggerFactory.getLogger(EventBusListener.class);

    private final CirculatorContext circulatorContext;
    private final EventSubscriber eventSubscriber;
    private final ErrorHandler errorHandler;

    public EventBusListener(CirculatorContext circulatorContext, EventSubscriber eventSubscriber,
        ErrorHandler errorHandler) {
        this.circulatorContext = circulatorContext;
        this.eventSubscriber = eventSubscriber;
        this.errorHandler = errorHandler;
    }

    @Override
    public void run() {
        while (!stopped) {
            // 从任务列表中获取本次拉取的队列
            String runnerName = circulatorContext.takeBusRunnerName();
            if (StringUtils.isBlank(runnerName)) {
                logger.info("no push data ");
                this.waitForRunning(1000);
                continue;
            }

            // 获取可以拉取的runnerName
            RunnerMetrics runnerMetrics = circulatorContext.getTransformMetrics(runnerName);

            // 如果为空表示runner已经被移除，runnerName不需要重新入队
            if (Objects.isNull(runnerMetrics)) {
                continue;
            }

            List<ConnectRecord> pullRecordList = Lists.newArrayList();
            try {
                // 根据计算的tps获取数据
                pullRecordList = eventSubscriber.pull(runnerName,runnerMetrics.getCwnd());
                if (CollectionUtils.isEmpty(pullRecordList)) {
                    this.waitForRunning(1000);
                    // 自旋，当本次获取不到数据时等待时间窗口后重新开始拉取
                    circulatorContext.offerBusQueue(runnerName);
                    continue;
                }
                circulatorContext.offerEventRecords(pullRecordList);
            } catch (Exception exception) {
                logger.error(getServiceName() + " - event bus pull record exception, stackTrace - ", exception);
                // 自旋，当本次获取不到数据时等待时间窗口后重新开始拉取
                // circulatorContext.offerBusQueue(runnerName);
                pullRecordList.forEach(pullRecord -> errorHandler.handle(pullRecord, exception));
            }
        }
    }

    @Override
    public String getServiceName() {
        return EventBusListener.class.getSimpleName();
    }
}