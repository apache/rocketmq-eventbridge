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

package org.apache.rocketmq.eventbridge.exception;

import java.text.MessageFormat;

import org.apache.rocketmq.eventbridge.exception.code.BaseErrorCode;
import org.apache.rocketmq.eventbridge.exception.code.DefaultErrorCode;

public class EventBridgeException extends RuntimeException {

    private int httpCode;
    private String code;

    public EventBridgeException(String msg) {
        super(MessageFormat.format(DefaultErrorCode.InternalError.getMsg(), msg));
        this.code = DefaultErrorCode.InternalError.getCode();
    }

    public EventBridgeException(String msg, Throwable throwable) {
        super(MessageFormat.format(DefaultErrorCode.InternalError.getMsg(), msg), throwable);
        this.code = DefaultErrorCode.InternalError.getCode();
    }

    public EventBridgeException(Throwable throwable) {
        super(throwable);
        this.code = DefaultErrorCode.InternalError.getCode();
    }

    public EventBridgeException(BaseErrorCode errorCode, Throwable throwable, Object... args) {
        super(MessageFormat.format(errorCode.getMsg(), args), throwable);
        this.code = errorCode.getCode();
    }

    public EventBridgeException(BaseErrorCode errorCode, Object... args) {
        super(MessageFormat.format(errorCode.getMsg(), args));
        this.code = errorCode.getCode();
    }

    public String getCode() {
        return code;
    }

    public int getHttpCode() {
        return httpCode;
    }
}
