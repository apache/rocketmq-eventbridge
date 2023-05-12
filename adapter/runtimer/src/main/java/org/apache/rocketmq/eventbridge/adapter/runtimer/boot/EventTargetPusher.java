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
import io.openmessaging.connector.api.component.task.sink.SinkTask;
import io.openmessaging.connector.api.data.ConnectRecord;

import java.util.List;
import java.util.Map;
import java.util.Objects;
import java.util.concurrent.ExecutorService;

import org.apache.commons.collections.MapUtils;
import org.apache.rocketmq.eventbridge.adapter.runtimer.boot.listener.CirculatorContext;
import org.apache.rocketmq.eventbridge.adapter.runtimer.common.ServiceThread;
import org.apache.rocketmq.eventbridge.adapter.runtimer.config.RuntimerConfigDefine;
import org.apache.rocketmq.eventbridge.adapter.runtimer.error.ErrorHandler;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 * event target push to sink task
 *
 * @author artisan
 */
public class EventTargetPusher extends ServiceThread {

    private static final Logger logger = LoggerFactory.getLogger(EventTargetPusher.class);

    private final CirculatorContext circulatorContext;
    private final OffsetManager offsetManager;
    private final ErrorHandler errorHandler;
    private volatile Integer batchSize = 100;

    public EventTargetPusher(CirculatorContext circulatorContext, OffsetManager offsetManager,
        ErrorHandler errorHandler) {
        this.circulatorContext = circulatorContext;
        this.offsetManager = offsetManager;
        this.errorHandler = errorHandler;
    }

    @Override
    public void run() {
        while (!stopped) {
            Map<String, List<ConnectRecord>> targetRecordMap = circulatorContext.takeTargetRecords(batchSize);
            if (MapUtils.isEmpty(targetRecordMap)) {
                logger.info("current target pusher is empty");
                this.waitForRunning(1000);
                continue;
            }
            if (logger.isDebugEnabled()) {
                logger.debug("start push content by pusher - {}", JSON.toJSONString(targetRecordMap));
            }

            for(String runnerName: targetRecordMap.keySet()){
                ExecutorService executorService = circulatorContext.getExecutorService(runnerName);
                executorService.execute(() -> {
                    try {
                        SinkTask sinkTask = circulatorContext.getPusherTaskMap().get(runnerName);
                        List<ConnectRecord> pushRecords = targetRecordMap.get(runnerName);
                        sinkTask.put(pushRecords);
                        offsetManager.commit(pushRecords);
                    } catch (Exception exception) {
                        logger.error(getServiceName() + " push target exception, stackTrace-", exception);
                    }
                });
            }
        }
    }

    @Override
    public String getServiceName() {
        return EventTargetPusher.class.getSimpleName();
    }

}
