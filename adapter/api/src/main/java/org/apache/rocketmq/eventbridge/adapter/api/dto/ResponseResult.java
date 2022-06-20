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

package org.apache.rocketmq.eventbridge.adapter.api.dto;

import lombok.Builder;
import lombok.Data;
import lombok.EqualsAndHashCode;
import org.apache.rocketmq.eventbridge.domain.common.exception.EventBridgeErrorCode;

import java.io.Serializable;
import java.util.UUID;

@EqualsAndHashCode(callSuper = true)
@Data
@Builder
public class ResponseResult<T> extends BaseDTO {

    public String requestId;
    private String code;
    private String message;
    private String success;
    private T data;

    public static <T> ResponseResult<T> success() {
        return success(null);
    }

    public static <T> ResponseResult<T> success(T data) {
        return ResponseResult.<T>builder()
                .message(EventBridgeErrorCode.Success.getMsg())
                .code(EventBridgeErrorCode.Success.getCode())
                .success(Boolean.TRUE.toString())
                .data(data)
                .requestId(UUID.randomUUID()
                        .toString())
                .build();
    }

    public static <T extends Serializable> ResponseResult<T> fail(String message) {
        return fail(null, message);
    }

    public static <T> ResponseResult<T> fail(T data, String message) {
        return ResponseResult.<T>builder().data(data)
                .message(message)
                .code(Integer.toString(409))
                .success(Boolean.FALSE.toString())
                .message(message)
                .data(data)
                .requestId(UUID.randomUUID()
                        .toString())
                .build();
    }
}
