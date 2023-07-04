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

import java.util.List;
import java.util.Map;
import java.util.concurrent.ExecutorService;

import org.apache.commons.collections.MapUtils;
import org.apache.rocketmq.eventbridge.adapter.runtime.boot.common.OffsetManager;
import org.apache.rocketmq.eventbridge.adapter.runtime.boot.common.CirculatorContext;
import org.apache.rocketmq.eventbridge.adapter.runtime.common.ServiceThread;
import org.apache.rocketmq.eventbridge.adapter.runtime.config.RuntimeConfigDefine;
import org.apache.rocketmq.eventbridge.adapter.runtime.error.ErrorHandler;
import org.apache.rocketmq.eventbridge.adapter.runtime.utils.ExceptionUtil;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

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
    private volatile Integer batchSize = 100;

    public EventTargetTrigger(CirculatorContext circulatorContext, OffsetManager offsetManager,
                              ErrorHandler errorHandler) {
        this.circulatorContext = circulatorContext;
        this.offsetManager = offsetManager;
        this.errorHandler = errorHandler;
    }

    @Override
    public void run() {
        while (!stopped) {
            long startTime = System.currentTimeMillis();
            Map<String, List<ConnectRecord>> targetRecordMap = circulatorContext.takeTargetRecords(batchSize);
            if (MapUtils.isEmpty(targetRecordMap)) {
                logger.trace("current target pusher is empty");
                this.waitForRunning(1000);
                continue;
            }
            if (logger.isDebugEnabled()) {
                logger.debug("start push content by pusher - {}", JSON.toJSONString(targetRecordMap));
            }

            for(String runnerName: targetRecordMap.keySet()){
                ExecutorService executorService = circulatorContext.getExecutorService(runnerName);
                executorService.execute(() -> {
                    SinkTask sinkTask = circulatorContext.getPusherTaskMap().get(runnerName);
                    List<ConnectRecord> triggerRecords = targetRecordMap.get(runnerName);
                    try {
                        sinkTask.put(triggerRecords);
                        offsetManager.commit(triggerRecords);
                        //circulatorContext.successCount(3,triggerRecords.size(),System.currentTimeMillis() - startTime);
                        circulatorContext.successCount(4,triggerRecords.size(),System.currentTimeMillis() - Long.parseLong(triggerRecords.get(0).getExtension(RuntimeConfigDefine.RECEIVE_TIME)));
                    } catch (Exception exception) {
                        logger.error(getServiceName() + " push target exception, stackTrace-", exception);
                        triggerRecords.forEach(triggerRecord -> errorHandler.handle(triggerRecord, exception));
                        //circulatorContext.failCount(3);
                        circulatorContext.failCount(4);
                    }
                });
            }
        }
    }

    @Override
    public String getServiceName() {
        return EventTargetTrigger.class.getSimpleName();
    }

    @Override
    public void start() {
        thread.start();
    }

    @Override
    public void shutdown() {
        try {
            circulatorContext.releaseExecutorService();
            circulatorContext.releaseTriggerTask();
        } catch (Exception e) {
            logger.error(String.format("current thread: %s, error Track: %s ", getServiceName(), ExceptionUtil.getErrorMessage(e)));
        }
    }
}
