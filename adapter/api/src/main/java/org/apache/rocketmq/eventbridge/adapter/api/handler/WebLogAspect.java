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

package org.apache.rocketmq.eventbridge.adapter.api.handler;

import com.google.gson.Gson;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Pointcut;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;
import reactor.core.publisher.Mono;

import java.util.Objects;

@Aspect
@Component
public class WebLogAspect {

    private static final Logger log = LoggerFactory.getLogger("accessLog");

    @Pointcut("@annotation(org.apache.rocketmq.eventbridge.adapter.api.annotations.WebLog)")
    public void webLog() {

    }

    @Around("webLog()")
    public Object doControllerAround(ProceedingJoinPoint proceedingJoinPoint) throws Throwable {
        Object result = proceedingJoinPoint.proceed();
        if (result instanceof Mono) {
            Mono monoResult = (Mono) result;
            return monoResult.doOnSuccess(o -> {
                String response = "";
                if (Objects.nonNull(o)) {
                    response = o.toString();
                }
                log.info("Class Method   : {}.{} | Request Args   : {} | Response Args : {}",
                        proceedingJoinPoint.getSignature().getDeclaringTypeName(),
                        proceedingJoinPoint.getSignature().getName(),
                        new Gson().toJson(proceedingJoinPoint.getArgs()),
                        response);
            });
        }
        return result;
    }

}
