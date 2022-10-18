package org.apache.rocketmq.eventbridge.filter;

import com.google.gson.Gson;
import org.apache.rocketmq.eventbridge.exception.EventBridgeException;
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

@Component
@Order(value = 1)
public class LogFilter implements WebFilter {
    private static final Logger log = LoggerFactory.getLogger("accessLog");
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
        return chain.filter(exchange.mutate().request(accessPermissionDecorator).build());
    }
}
