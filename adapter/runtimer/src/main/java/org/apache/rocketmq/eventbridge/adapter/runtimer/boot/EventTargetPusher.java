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
import java.util.Objects;
import java.util.concurrent.ExecutorService;
import org.apache.rocketmq.eventbridge.adapter.runtimer.boot.listener.CirculatorContext;
import org.apache.rocketmq.eventbridge.adapter.runtimer.common.ServiceThread;
import org.apache.rocketmq.eventbridge.adapter.runtimer.config.RuntimerConfigDefine;
import org.apache.rocketmq.eventbridge.adapter.runtimer.error.ErrorHandler;
import org.apache.rocketmq.eventbridge.adapter.runtimer.utils.ShutdownUtils;
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
    private ExecutorService executorService;

    public EventTargetPusher(CirculatorContext circulatorContext, OffsetManager offsetManager,
        ErrorHandler errorHandler) {
        this.circulatorContext = circulatorContext;
        this.offsetManager = offsetManager;
        this.errorHandler = errorHandler;
    }

    @Override
    public void run() {
        while (!stopped) {
            ConnectRecord targetRecord = circulatorContext.takeTargetMap();
            if (Objects.isNull(targetRecord)) {
                logger.info("current target pusher is empty");
                this.waitForRunning(1000);
                continue;
            }
            if (logger.isDebugEnabled()) {
                logger.debug("start push content by pusher - {}", JSON.toJSONString(targetRecord));
            }

            executorService = circulatorContext.getExecutorService(targetRecord.getExtensions().getString(RuntimerConfigDefine.TASK_CLASS));
            executorService.execute(() -> {
                try {
                    String runnerName = targetRecord.getExtensions().getString(RuntimerConfigDefine.RUNNER_NAME);
                    SinkTask sinkTask = circulatorContext.getPusherTaskMap().get(runnerName);
                    sinkTask.put(Lists.newArrayList(targetRecord));
                    offsetManager.commit(targetRecord);
                } catch (Exception exception) {
                    logger.error(getServiceName() + " push target exception, record - " + targetRecord + " , stackTrace-", exception);
                }
            });
        }
    }

    @Override
    public String getServiceName() {
        return EventTargetPusher.class.getSimpleName();
    }

    @Override
    public void start() {
        thread.start();
    }

    @Override
    public void shutdown() {
        ShutdownUtils.shutdownThreadPool(executorService);
        try {
            circulatorContext.close();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
