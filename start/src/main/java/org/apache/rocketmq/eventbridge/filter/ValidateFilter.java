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

import lombok.extern.slf4j.Slf4j;
import org.apache.rocketmq.eventbridge.infrastructure.validate.AuthValidation;
import org.apache.rocketmq.eventbridge.infrastructure.validate.spi.ValidationServiceFactory;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.core.annotation.Order;
import org.springframework.http.server.reactive.ServerHttpRequest;
import org.springframework.stereotype.Component;
import org.springframework.web.server.ServerWebExchange;
import org.springframework.web.server.WebFilter;
import org.springframework.web.server.WebFilterChain;
import reactor.core.publisher.Mono;
import reactor.util.context.Context;

import javax.annotation.PostConstruct;
import java.util.Arrays;
import java.util.List;
import java.util.concurrent.CopyOnWriteArrayList;
import java.util.concurrent.atomic.AtomicReference;
import java.util.stream.Collectors;

@Component
@Order(value = 3)
@Slf4j
public class ValidateFilter implements WebFilter {

    private List<AuthValidation> validations = new CopyOnWriteArrayList<>();

    @Value(value = "${auth.validation:default}")
    private String validationName;

    @PostConstruct
    public void init() {
        List<String> validationNames = Arrays.stream(validationName.split(",")).collect(Collectors.toList());
        boolean match = Arrays.stream(validationName.split(",")).allMatch(validationName -> validationName.equals("default"));
        if (!match) {
            validationNames.add(0, "default");
        }
        validationNames.forEach(action -> validations.add(ValidationServiceFactory.getInstance(action)));
    }

    @Override
    public Mono<Void> filter(ServerWebExchange exchange, WebFilterChain chain) {
        ServerHttpRequest request = exchange.getRequest();
        return chain.filter(exchange)
            .subscriberContext(ctx -> {
                AtomicReference<Context> result = new AtomicReference<Context>();
                validations.forEach(validation -> result.set(validation.validate(request, ctx)));
                return result.get();
            });
    }
}
