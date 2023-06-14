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

import java.util.List;
import lombok.extern.slf4j.Slf4j;
import org.springframework.core.annotation.Order;
import org.springframework.http.server.reactive.ServerHttpRequest;
import org.springframework.stereotype.Component;
import org.springframework.web.server.ServerWebExchange;
import org.springframework.web.server.WebFilter;
import org.springframework.web.server.WebFilterChain;
import reactor.core.publisher.Mono;

import static org.apache.rocketmq.eventbridge.enums.props.Constants.HEADER_KEY_LOGIN_ACCOUNT_ID;
import static org.apache.rocketmq.eventbridge.enums.props.Constants.HEADER_KEY_PARENT_ACCOUNT_ID;

@Component
@Order(value = 2)
@Slf4j
public class LoginFilter implements WebFilter {

    @Override
    public Mono<Void> filter(ServerWebExchange exchange, WebFilterChain chain) {
        ServerHttpRequest request = exchange.getRequest();
        return chain.filter(exchange)
            .subscriberContext(ctx -> {
                List<String> parentAccountIds = request.getHeaders()
                    .get(HEADER_KEY_PARENT_ACCOUNT_ID.getName());
                List<String> loginAccountIds = request.getHeaders()
                    .get(HEADER_KEY_LOGIN_ACCOUNT_ID.getName());
                return ctx.put(HEADER_KEY_PARENT_ACCOUNT_ID.getName(),
                    parentAccountIds != null && !parentAccountIds.isEmpty() ? parentAccountIds.get(0) : "")
                    .put(HEADER_KEY_LOGIN_ACCOUNT_ID.getName(),
                        loginAccountIds != null && !loginAccountIds.isEmpty() ? loginAccountIds.get(0) : "");
            });
    }
}
