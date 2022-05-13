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
        // 打印请求相关参数
        log.info("========================================== Start ==========================================");
        // 打印调用 controller 的全路径以及执行方法
        log.info("Class Method   : {}.{}", proceedingJoinPoint.getSignature().
                getDeclaringTypeName(), proceedingJoinPoint.getSignature().getName());
        // 打印请求入参
        log.info("Request Args   : {}", new Gson().toJson(proceedingJoinPoint.getArgs()));
        Object result = proceedingJoinPoint.proceed();
        // 打印出参
        log.info("Response Args : {}", new Gson().toJson(result));
        // 执行耗时
        log.info("Time-Consuming : {} ms", System.currentTimeMillis() - startTime);
        log.info("=========================================== End ===========================================");
        // 每个请求之间空一行
        log.info("");
        return result;
    }

}
