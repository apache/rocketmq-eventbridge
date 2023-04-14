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

package org.apache.rocketmq.eventbridge.adapter.runtimer.retry;

import com.google.common.base.Strings;
import io.openmessaging.connector.api.data.ConnectRecord;
import lombok.extern.slf4j.Slf4j;
import org.apache.rocketmq.eventbridge.adapter.runtimer.boot.listener.TargetRunnerContext;
import org.apache.rocketmq.eventbridge.adapter.runtimer.common.entity.TargetRunnerConfig;
import org.apache.rocketmq.eventbridge.enums.PushRetryStrategyEnum;
import org.springframework.beans.factory.annotation.Autowired;

import static org.apache.rocketmq.eventbridge.adapter.runtimer.config.RuntimerConfigDefine.CONNECT_RECORDS_KEY;
import static org.apache.rocketmq.eventbridge.adapter.runtimer.config.RuntimerConfigDefine.RUNNER_NAME;

@Slf4j
public class ErrorHandler {

    @Autowired
    EventBusStorage eventBusStorage;

    public void handle(ConnectRecord connectRecord, Throwable t) {
        String eventRunnerName = connectRecord.getExtension(RUNNER_NAME);
        TargetRunnerConfig targetRunnerConfig = TargetRunnerContext.getTargetRunnerConfig(eventRunnerName);
        String eventBusName = targetRunnerConfig.getEventBusName();
        PushRetryStrategyEnum pushRetryStrategyEnum = PushRetryStrategyEnum.parse(targetRunnerConfig.getRunOptions().getRetryStrategy());
        int retryTimes = parseRetryTimes(connectRecord);
        int delaySec = calcDelaySec(retryTimes, pushRetryStrategyEnum);
        if (delaySec > 0) {
            eventBusStorage.put(eventBusName, connectRecord, delaySec);
        }
    }

    private int parseRetryTimes(ConnectRecord connectRecord) {
        int retryTimes = 0;
        String retryTag = connectRecord.getExtension(CONNECT_RECORDS_KEY);
        if (Strings.isNullOrEmpty(retryTag)) {
            return retryTimes;
        }
        try {
            retryTimes = Integer.parseInt(retryTag);
        } catch (Throwable e) {
            log.warn("parse retry times failed. retryTag={}", retryTag);
        }
        return retryTimes;
    }

    /**
     * Return right time or -1 (already done)
     *
     * @param retryTimes
     * @param pushRetryStrategyEnum
     * @return
     */
    private int calcDelaySec(int retryTimes, PushRetryStrategyEnum pushRetryStrategyEnum) {

        switch (pushRetryStrategyEnum) {
            case BACKOFF_RETRY:
                if (retryTimes >= pushRetryStrategyEnum.getRetryTimes()) {
                    return -1;
                }
                return 10;
            case EXPONENTIAL_DECAY_RETRY:
                if (retryTimes >= pushRetryStrategyEnum.getRetryTimes()) {
                    return -1;
                }
                int pow = (int) Math.pow(2, 3 + retryTimes);
                return (pow > 512 ? 512 : pow);
            default:
                return -1;
        }
    }

}