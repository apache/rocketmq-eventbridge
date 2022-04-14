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

package org.apache.rocketmq.eventbridge.exception.code;

public enum EventErrorCode implements BaseErrorCode {
    EventHTTPProtocolBindingInvalid(409, "EventHTTPProtocolBindingInvalid",
        "The event with http protocol binding is invalid. which header is [{0}]"),
    EventBusEmpty(409, "EventBusEmpty", "The event bus is empty."),
    EventIdEmpty(409, "EventIdEmpty", "The event id is empty."),
    EventDataEmpty(409, "EventDataEmpty", "The event data is empty."),
    EventSchemaInvalid(409, "EventSourceInvalid", "The event schema [{0}] is invalid!"),
    EventSourceInvalid(409, "EventSourceInvalid", "The event source [{0}] is invalid!"),
    EventSubjectInvalid(409, "EventSubjectInvalid", "The event source [{0}] is invalid!"),
    EventTypeInvalid(409, "EventTypeInvalid", "The event type [{0}] is invalid!"),
    EventSpecversionInvalid(409, "EventSpecversionInvalid",
        "The event specversion [{0}] is invalid! which must bu in [1.0,0.3]"),
    EventContentTypeInvalid(409, "EventContentTypeInvalid",
        "The event content type [{0}] is invalid! which not in supported types:[{1}]"),
    EventExtensionsAttributeExceedLimit(409, "EventExtensionsAttributeExceedLimit",
        "The extensions attribute size is [{0}], which exceed the limit [{1}]"),
    EventExtensionsAttributeInvalid(409, "EventExtensionsAttributeInvalid", "The extensions attribute is invalid."),
    EventInvalid(409, "EventInvalid",
        "The event is invalid in request! View the spec detail on https://github.com/cloudevents/spec"),
    EventSizeExceed(409, "EventSizeExceed", "The single event entry size[{0}] exceed the limit [{1}]! "),

    ;

    private final int httpCode;
    private final String code;
    private final String msg;

    EventErrorCode(int httpCode, String code, String s) {
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
