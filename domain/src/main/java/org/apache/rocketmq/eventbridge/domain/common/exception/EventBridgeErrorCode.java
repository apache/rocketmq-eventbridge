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

package org.apache.rocketmq.eventbridge.domain.common.exception;

import org.apache.rocketmq.eventbridge.exception.code.BaseErrorCode;

public enum EventBridgeErrorCode implements BaseErrorCode {
    //Default
    Success(200, "Success", "success"),
    InternalError(500, "InternalError", "InternalError"),

    //Put Events
    PutEventsRequestMoreThanOneEventBus(409, "PutEventsRequestMoreThanOneEventBus",
        "The put events request has more than one  event bus [{0}] "),

    //Event Bus
    EventBusNotExist(409, "EventBusNotExist", "The event bus [{0}] not existed!"),
    EventBusNameInvalid(409, "EventBusNameInvalid", "The event bus name [{0}] is invalid!"),
    EventBusAlreadyExist(409, "EventBusAlreadyExist", "The event bus [{0}] already existed!"),
    EventBusCountExceedLimit(409, "EventBusCountExceedLimit",
        "The current count of event bus is [{0}], which will exceed the limit quota [{1}]"),
    EventBusRuleNotEmptyForDelete(409, "EventBusRuleNotEmptyForDelete",
        "The rules of eventbus [{0}] exist, please delete them before delete event bus."),
    EventBusSourceNotEmptyForDelete(409, "EventBusSourceNotEmptyForDelete",
        "The source of eventbus  [{0}] exist, please delete them before delete event bus."),

    //Event Source
    EventSourceNotExist(409, "EventSourceNotExist", "The event source [{0}] of event bus [{1}] not existed!"),
    EventSourceAlreadyExist(409, "EventSourceAlreadyExist",
        "The event source [{0}] of event bus [{1}] already existed!"),
    EventSourceCountExceedLimit(409, "EventSourceCountExceedLimit",
        "The current count of event source is [{0}], which will exceed the limit quota [{1}]"),
    EventSourceNameInvalid(409, "EventSourceNameInvalid", "The event source name [{0}] is invalid!"),
    EventSourceTypeInvalid(409, "EventSourceTypeInvalid", "The event source type[{0}] is invalid!"),
    EventSourceTypeOrClassInvalid(409, "EventSourceTypeOrClassInvalid",
        "The event source type[{0}] or class[{1}] is invalid!"),

    //Event Target
    EventTargetNotExist(409, "EventTargetNotExist",
        "The event target [{0}] of event rule [{1}] on eventbus [{2}] is not existed!"),
    EventTargetAlreadyExist(409, "EventTargetAlreadyExist",
        "The event target [{0}] of event rule [{1}] on eventbus [{2}] already existed!"),

    //Event Source Class
    EventSourceClassNotExist(409, "EventSourceClassNotExist", "The event source class [{0}] not existed!"),
    EventSourceMissingAttribute(409, "EventSourceMissingAttribute", "Missing the attribute [{0}:{1}] "),
    EventSourceIneffectiveAttribute(409, "EventSourceIneffectiveAttribute",
        "The attribute [{0}] is ineffective, " + "which effective attribute is [{1}]."),

    //Event Target Class
    EventTargetClassNotExist(409, "EventTargetClassNotExist", "The event target class [{0}] not existed!"),
    EventTargetMissingAttribute(409, "EventTargetMissingAttribute", "Missing the attribute [{0}:{1}] "),
    EventTargetIneffectiveAttribute(409, "EventTargetIneffectiveAttribute",
        "The attribute [{0}] is ineffective, " + "which effective attribute is [{1}]."),

    //Event Rule
    EventRuleNotExist(409, "EventRuleNotExist", "The event rule [{0}] of event bus [{1}] not existed!"),
    EventRuleNameInvalid(409, "EventRuleNameInvalid", "The event rule name [{0}] is invalid!"),
    EventRuleCountExceedLimit(409, "EventRuleCountExceedLimit",
        "The current count of event rule is [{0}], which will exceed the limit quota [{1}]"),
    EventRuleAlreadyExist(409, "EventRuleAlreadyExist", "The event rule [{0}] of event bus [{1}] already existed!"),

    ;

    private final int httpCode;
    private final String code;
    private final String msg;

    EventBridgeErrorCode(int httpCode, String code, String s) {
        this.httpCode = httpCode;
        this.code = code;
        this.msg = s;
    }

    @Override
    public int getHttpCode() {
        return httpCode;
    }

    @Override
    public String getCode() {
        return code;
    }

    @Override
    public String getMsg() {
        return msg;
    }
}
