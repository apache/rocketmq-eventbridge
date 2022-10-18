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
import lombok.extern.slf4j.Slf4j;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Pointcut;
import org.springframework.stereotype.Component;

@Slf4j
@Aspect
@Component
public class WebLogAspect {

    @Pointcut("@annotation(org.apache.rocketmq.eventbridge.adapter.api.annotations.WebLog)")
    public void webLog() {

    }

    @Around("webLog()")
    public Object doControllerAround(ProceedingJoinPoint proceedingJoinPoint) throws Throwable {
        long startTime = System.currentTimeMillis();
        log.info("========================================== Start ==========================================");
        log.info("Class Method   : {}.{}", proceedingJoinPoint.getSignature().
            getDeclaringTypeName(), proceedingJoinPoint.getSignature().getName());
        log.info("Request Args   : {}", new Gson().toJson(proceedingJoinPoint.getArgs()));
        Object result = proceedingJoinPoint.proceed();
        log.info("Response Args : {}", new Gson().toJson(result));
        log.info("Time-Consuming : {} ms", System.currentTimeMillis() - startTime);
        log.info("=========================================== End ===========================================");
        log.info("");
        return result;
    }

}
