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
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */

package org.apache.rocketmq.eventbridge.enums;

import com.google.common.base.Strings;

public enum PushRetryStrategyEnum {
    /**
     * 3 times: every 10s~20s
     */
    BACKOFF_RETRY(1, 3),
    /**
     * 176 times: 1，2，4，8，16，32，64，128，256，512，512...512秒 ... 512s(176)
     */
    EXPONENTIAL_DECAY_RETRY(2, 176);

    private int code;
    private int retryTimes;

    PushRetryStrategyEnum(int code, int retryTimes) {
        this.code = code;
        this.retryTimes = retryTimes;
    }

    public static PushRetryStrategyEnum parse(String pushRetryStrategy) {
        if (Strings.isNullOrEmpty(pushRetryStrategy)) {
            return BACKOFF_RETRY;
        }
        for (PushRetryStrategyEnum pushRetryStrategyEnum : PushRetryStrategyEnum.values()) {
            if (pushRetryStrategyEnum.equals(pushRetryStrategy)) {
                return pushRetryStrategyEnum;
            }
        }
        return BACKOFF_RETRY;
    }

    public int getCode() {
        return code;
    }

    public int getRetryTimes() {
        return retryTimes;
    }
}
