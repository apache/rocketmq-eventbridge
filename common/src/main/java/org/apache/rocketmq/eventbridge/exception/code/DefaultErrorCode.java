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

public enum DefaultErrorCode implements BaseErrorCode {
    //Default
    Success(200, "Success", "success"),
    InternalError(500, "InternalError", "InternalError"),
    LoginFailed(409, "LoginFailed", "Login failed."),
    ;

    private final int httpCode;
    private final String code;
    private final String msg;

    DefaultErrorCode(int httpCode, String code, String s) {
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
