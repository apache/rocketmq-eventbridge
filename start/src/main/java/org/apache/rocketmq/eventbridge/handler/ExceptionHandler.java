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

package org.apache.rocketmq.eventbridge.handler;

import java.nio.charset.StandardCharsets;

import com.google.common.net.MediaType;
import com.google.gson.Gson;
import io.netty.handler.codec.http.HttpHeaderNames;
import lombok.extern.slf4j.Slf4j;
import org.apache.rocketmq.eventbridge.adapter.api.dto.BaseResponse;
import org.apache.rocketmq.eventbridge.domain.common.exception.EventBridgeErrorCode;
import org.apache.rocketmq.eventbridge.exception.EventBridgeException;
import org.springframework.boot.web.reactive.error.ErrorWebExceptionHandler;
import org.springframework.core.annotation.Order;
import org.springframework.core.io.buffer.DataBuffer;
import org.springframework.http.HttpStatus;
import org.springframework.http.server.reactive.ServerHttpResponse;
import org.springframework.stereotype.Component;
import org.springframework.web.server.ResponseStatusException;
import org.springframework.web.server.ServerWebExchange;
import reactor.core.publisher.Mono;
import reactor.ipc.netty.ByteBufMono;

@Component
@Order(-1)
@Slf4j
public class ExceptionHandler implements ErrorWebExceptionHandler {
    @Override
    public Mono<Void> handle(ServerWebExchange exchange, Throwable throwable) {
        ServerHttpResponse serverHttpResponse = exchange.getResponse();
        BaseResponse baseResponse = new BaseResponse();
        HttpStatus httpStatus = null;
        if (throwable instanceof EventBridgeException) {
            EventBridgeException eventBridgeException = (EventBridgeException)throwable;
            baseResponse.setCode(eventBridgeException.getCode());
            baseResponse.setMessage(eventBridgeException.getMessage());
            httpStatus = HttpStatus.resolve(eventBridgeException.getHttpCode());
        } else if (throwable instanceof ResponseStatusException) {
            baseResponse.setMessage(((ResponseStatusException)throwable).getMessage());
            httpStatus = ((ResponseStatusException)throwable).getStatus();
        } else {
            baseResponse.setCode(EventBridgeErrorCode.InternalError.getCode());
            baseResponse.setMessage(EventBridgeErrorCode.InternalError.getMsg());
            httpStatus = HttpStatus.resolve(EventBridgeErrorCode.InternalError.getHttpCode());
            log.error("Catch unexpected exception.", throwable);
        }
        System.out.println("Response:" + new Gson().toJson(baseResponse));
        byte[] responseByte = new Gson().toJson(baseResponse)
            .getBytes(StandardCharsets.UTF_8);
        DataBuffer buffer = serverHttpResponse.bufferFactory()
            .allocateBuffer()
            .write(responseByte);
        serverHttpResponse.setStatusCode(httpStatus);
        serverHttpResponse.getHeaders()
            .add(HttpHeaderNames.CONTENT_TYPE.toString(), MediaType.JSON_UTF_8.toString());
        return serverHttpResponse.writeAndFlushWith(Mono.just(ByteBufMono.just(buffer)));
    }
}
