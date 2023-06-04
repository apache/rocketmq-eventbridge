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
import java.util.Map;
import java.util.Objects;
import java.util.concurrent.ConcurrentHashMap;

import org.apache.commons.collections.CollectionUtils;
import org.apache.rocketmq.eventbridge.adapter.runtime.boot.common.CirculatorContext;
import org.apache.rocketmq.eventbridge.adapter.runtime.boot.common.TargetRunnerListener;
import org.apache.rocketmq.eventbridge.adapter.runtime.boot.listener.EventSubscriber;
import org.apache.rocketmq.eventbridge.adapter.runtime.common.ServiceThread;
import org.apache.rocketmq.eventbridge.adapter.runtime.common.entity.SubscribeRunnerKeys;
import org.apache.rocketmq.eventbridge.adapter.runtime.common.entity.TargetRunnerConfig;
import org.apache.rocketmq.eventbridge.adapter.runtime.error.ErrorHandler;
import org.apache.rocketmq.eventbridge.adapter.runtime.rate.RunnerMetrics;
import org.apache.rocketmq.eventbridge.adapter.runtime.service.TargetRunnerConfigObserver;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 * listen the event and offer to queue
 *
 * @author artisan
 */
public class EventBusListener implements TargetRunnerListener {

    private static final Logger logger = LoggerFactory.getLogger(EventBusListener.class);
    private Map<String, ListenerWorker> workerMap = new ConcurrentHashMap<>();

    private final CirculatorContext circulatorContext;
    private final EventSubscriber eventSubscriber;
    private final ErrorHandler errorHandler;
    private final TargetRunnerConfigObserver runnerConfigObserver;

    public EventBusListener(CirculatorContext circulatorContext, EventSubscriber eventSubscriber,
        ErrorHandler errorHandler,TargetRunnerConfigObserver runnerConfigObserver) {
        this.circulatorContext = circulatorContext;
        this.eventSubscriber = eventSubscriber;
        this.errorHandler = errorHandler;
        this.runnerConfigObserver = runnerConfigObserver;
        initWorkers();
    }

    @Override
    public void onAddTargetRunner(TargetRunnerConfig targetRunnerConfig) {
        putWorker(targetRunnerConfig.getSubscribeRunnerKeys());
    }

    @Override
    public void onUpdateTargetRunner(TargetRunnerConfig targetRunnerConfig) {
        putWorker(targetRunnerConfig.getSubscribeRunnerKeys());
    }

    @Override
    public void onDeleteTargetRunner(TargetRunnerConfig targetRunnerConfig) {
        removeWorker(targetRunnerConfig.getSubscribeRunnerKeys());
    }


    private void initWorkers() {
        for (SubscribeRunnerKeys subscribeRunnerKeys : runnerConfigObserver.getSubscribeRunnerKeys()) {
            ListenerWorker listenerWorker = new ListenerWorker(subscribeRunnerKeys.getRunnerName());
            workerMap.put(subscribeRunnerKeys.getRunnerName(), listenerWorker);
            listenerWorker.start();
        }
    }

    private void putWorker(SubscribeRunnerKeys subscribeRunnerKeys) {
        ListenerWorker listenerWorker = workerMap.get(subscribeRunnerKeys.getRunnerName());
        if (!Objects.isNull(listenerWorker)) {
            listenerWorker.shutdown();
        }
        ListenerWorker newWorker = new ListenerWorker(subscribeRunnerKeys.getRunnerName());
        workerMap.put(subscribeRunnerKeys.getRunnerName(), newWorker);
        newWorker.start();
    }

    private void removeWorker(SubscribeRunnerKeys subscribeRunnerKeys) {
        ListenerWorker listenerWorker = workerMap.remove(subscribeRunnerKeys.getRunnerName());
        if (!Objects.isNull(listenerWorker)) {
            listenerWorker.shutdown();
        }
    }

    class ListenerWorker extends ServiceThread {

        private final String runnerName;

        public ListenerWorker(String runnerName) {
            this.runnerName = runnerName;
        }

        @Override
        public String getServiceName() {
            return ListenerWorker.class.getSimpleName();
        }

        @Override
        public void run() {
            while (!stopped) {

                // 基于慢启动算法 transform的速度受trigger的速度影响，此处使用transform的速度做为listener的pull速度
                RunnerMetrics runnerMetrics = circulatorContext.getTransformMetrics(runnerName);
                if (Objects.isNull(runnerMetrics)) {
                    continue;
                }

                List<ConnectRecord> pullRecordList = Lists.newArrayList();
                try {
                    int cwnd = runnerMetrics.getCwnd();
                    // 根据计算的tps获取数据
                    pullRecordList = eventSubscriber.pull(runnerName,cwnd);

                    if (CollectionUtils.isEmpty(pullRecordList)) {
                        this.waitForRunning(1000);
                        continue;
                    }
                    circulatorContext.offerEventRecords(pullRecordList);
                    long time = runnerMetrics.getCwndMillisecond(pullRecordList.size());
                    // 通过线程等待实现tps控制
                    if (time > 0 && !CollectionUtils.isEmpty(pullRecordList)) {
                        this.waitForRunning(time);
                    }
                } catch (Exception exception) {
                    logger.error(getServiceName() + " - event bus pull record exception, stackTrace - ", exception);
                    pullRecordList.forEach(pullRecord -> errorHandler.handle(pullRecord, exception));
                }
            }
        }

        @Override
        public void shutdown() {
            super.shutdown();
        }
    }
}