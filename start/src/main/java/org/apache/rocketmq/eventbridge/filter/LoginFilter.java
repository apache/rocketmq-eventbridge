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
 package org.apache.rocketmq.eventbridge.filter;

 import com.google.gson.Gson;
 import org.apache.rocketmq.eventbridge.exception.EventBridgeException;
 import org.apache.rocketmq.eventbridge.exception.code.DefaultErrorCode;
 import org.slf4j.Logger;
 import org.slf4j.LoggerFactory;
 import org.springframework.core.annotation.Order;
 import org.springframework.core.io.buffer.DataBuffer;
 import org.springframework.http.server.reactive.ServerHttpRequestDecorator;
 import org.springframework.stereotype.Component;
 import org.springframework.web.server.ServerWebExchange;
 import org.springframework.web.server.WebFilter;
 import org.springframework.web.server.WebFilterChain;
 import reactor.core.publisher.Flux;
 import reactor.core.publisher.Mono;

 import java.io.ByteArrayOutputStream;
 import java.io.IOException;
 import java.nio.channels.Channels;
 import java.nio.charset.StandardCharsets;
 import java.util.List;

 @Component
 @Order(value = 2)
 public class LoginFilter implements WebFilter {

     private static final Logger log = LoggerFactory.getLogger("accessLog");

     public static final String HEADER_KEY_LOGIN_ACCOUNT_ID = "loginAccountId";
     public static final String HEADER_KEY_PARENT_ACCOUNT_ID = "parentAccountId";
     public static final String HEADER_KEY_RESOURCE_OWNER_ACCOUNT_ID = "resourceOwnerAccountId";

     @Override
     public Mono<Void> filter(ServerWebExchange exchange, WebFilterChain chain) {
         ServerHttpRequestDecorator accessPermissionDecorator = new ServerHttpRequestDecorator(exchange.getRequest()) {
             @Override
             public Flux<DataBuffer> getBody() {
                 return super.getBody().doOnNext(dataBuffer -> {
                     try {
                         ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream();
                         Channels.newChannel(byteArrayOutputStream).write(dataBuffer.asByteBuffer().asReadOnlyBuffer());
                         String requestBody = new String(byteArrayOutputStream.toByteArray(), StandardCharsets.UTF_8);
                                 log.info("url : {} | requestParam : {} | requestMethod : {} | requestBody : {}",
                                 exchange.getRequest().getURI(),
                                 exchange.getRequest().getQueryParams(),
                                 exchange.getRequest().getMethodValue(),
                                 new Gson().toJson(requestBody));
                     } catch (IOException e) {
                         log.error("LoginFilter | filter => e ", e);
                         throw new EventBridgeException(e);
                     }
                 });
             }
         };
         return chain.filter(exchange.mutate().request(accessPermissionDecorator).build()).subscriberContext(ctx -> {
             List<String> parentAccountIds = accessPermissionDecorator.getHeaders()
                     .get(HEADER_KEY_PARENT_ACCOUNT_ID);
             List<String> loginAccountIds = accessPermissionDecorator.getHeaders()
                     .get(HEADER_KEY_LOGIN_ACCOUNT_ID);
             List<String> resourceOwnerIds = accessPermissionDecorator.getHeaders()
                     .get(HEADER_KEY_RESOURCE_OWNER_ACCOUNT_ID);
             if (resourceOwnerIds == null || resourceOwnerIds.isEmpty()) {
                 throw new EventBridgeException(DefaultErrorCode.LoginFailed);
             }
             return ctx.put(HEADER_KEY_PARENT_ACCOUNT_ID,
                             parentAccountIds != null && !parentAccountIds.isEmpty() ? parentAccountIds.get(0) : "")
                     .put(HEADER_KEY_LOGIN_ACCOUNT_ID,
                             loginAccountIds != null && !loginAccountIds.isEmpty() ? loginAccountIds.get(0) : "")
                     .put(HEADER_KEY_RESOURCE_OWNER_ACCOUNT_ID,
                             resourceOwnerIds != null && !resourceOwnerIds.isEmpty() ? resourceOwnerIds.get(0) : "");
         });
     }
 }
