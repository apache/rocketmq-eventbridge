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
import org.apache.rocketmq.eventbridge.adapter.runtimer.boot.listener.CirculatorContext;
import org.apache.rocketmq.eventbridge.adapter.runtimer.common.ServiceThread;
import org.apache.rocketmq.eventbridge.adapter.runtimer.config.RuntimerConfigDefine;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.Map;
import java.util.Objects;

/**
 * event target push to sink task
 *
 * @author artisan
 */
public class EventTargetPusher extends ServiceThread{

    private static final Logger logger = LoggerFactory.getLogger(EventTargetPusher.class);

    private CirculatorContext circulatorContext;

    public EventTargetPusher(CirculatorContext circulatorContext) {
        this.circulatorContext = circulatorContext;
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
            if(logger.isDebugEnabled()){
                logger.debug("start push content by pusher - {}", JSON.toJSONString(targetRecord));
            }

            Map<String, SinkTask> latestTaskMap = circulatorContext.getPusherTaskMap();
            String runnerName = targetRecord.getExtensions().getString(RuntimerConfigDefine.RUNNER_NAME);
            SinkTask sinkTask = latestTaskMap.get(runnerName);
            // add thread pool
            sinkTask.put(Lists.newArrayList(targetRecord));
        }
    }

    @Override
    public String getServiceName() {
        return EventTargetPusher.class.getSimpleName();
    }


}
