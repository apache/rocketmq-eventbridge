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

package org.apache.rocketmq.eventbridge.adapter.rpc.impl.connect.dto;

import com.google.common.base.Strings;
import org.apache.rocketmq.eventbridge.domain.common.enums.EventSourceStatusEnum;
import org.apache.rocketmq.eventbridge.domain.common.enums.EventTargetStatusEnum;

public enum ActionStatusResponseEnum {
    RUNNING("running", EventSourceStatusEnum.ACTIVATED, EventTargetStatusEnum.RUNNING),
    FAILED("not running", EventSourceStatusEnum.FROZEN, EventTargetStatusEnum.FAILED);

    private String code;

    private EventSourceStatusEnum eventSourceStatusEnum;

    private EventTargetStatusEnum eventTargetStatusEnum;

    ActionStatusResponseEnum(String code, EventSourceStatusEnum eventSourceStatusEnum,
        EventTargetStatusEnum eventTargetStatusEnum) {
        this.code = code;
        this.eventSourceStatusEnum = eventSourceStatusEnum;
        this.eventTargetStatusEnum = eventTargetStatusEnum;
    }

    public static ActionStatusResponseEnum parseConnectStatusEnum(String code) {
        if (Strings.isNullOrEmpty(code)) {
            return null;
        }
        for (ActionStatusResponseEnum connectStatusResponseEnum : ActionStatusResponseEnum.values()) {
            if (connectStatusResponseEnum.getCode()
                .equals(code)) {
                return connectStatusResponseEnum;
            }
        }
        return null;
    }

    public static EventTargetStatusEnum parseEventTargetStatusEnum(String code) {
        ActionStatusResponseEnum connectStatusResponseEnum = parseConnectStatusEnum(code);
        if (connectStatusResponseEnum != null) {
            return connectStatusResponseEnum.getEventTargetStatusEnum();
        } else {
            return null;
        }
    }

    public static EventSourceStatusEnum parseEventSourceStatusEnum(String code) {
        ActionStatusResponseEnum connectStatusResponseEnum = parseConnectStatusEnum(code);
        if (connectStatusResponseEnum != null) {
            return connectStatusResponseEnum.getEventSourceStatusEnum();
        } else {
            return null;
        }
    }

    public String getCode() {
        return code;
    }

    public EventSourceStatusEnum getEventSourceStatusEnum() {
        return eventSourceStatusEnum;
    }

    public EventTargetStatusEnum getEventTargetStatusEnum() {
        return eventTargetStatusEnum;
    }
}
