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

package org.apache.rocketmq.eventbridge.domain.common.enums;

import org.apache.rocketmq.eventbridge.exception.EventBridgeException;

import static org.apache.rocketmq.eventbridge.domain.common.exception.EventBridgeErrorCode.EventSourceTypeInvalid;

public enum EventSourceTypeEnum {
    OFFICIAL_SERVICE(1),

    PARTNER_SAAS(2),

    USER_DEFINED(3);

    private int code;

    EventSourceTypeEnum(int code) {
        this.code = code;
    }

    public int getCode() {
        return this.code;
    }

    public static EventSourceTypeEnum parseFromCode(int code) {
        for (EventSourceTypeEnum sourceType : EventSourceTypeEnum.values()) {
            if (sourceType.code == code) {
                return sourceType;
            }
        }
        throw new EventBridgeException(EventSourceTypeInvalid, code);
    }

    public static EventSourceTypeEnum parseFromName(String name) {
        for (EventSourceTypeEnum sourceType : EventSourceTypeEnum.values()) {
            if (sourceType.toString()
                .equals(name)) {
                return sourceType;
            }
        }
        throw new EventBridgeException(EventSourceTypeInvalid, name);
    }

}
