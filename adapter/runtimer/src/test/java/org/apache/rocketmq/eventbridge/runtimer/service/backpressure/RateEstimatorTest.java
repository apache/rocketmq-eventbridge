package org.apache.rocketmq.eventbridge.runtimer.service.backpressure;

import com.google.common.util.concurrent.RateLimiter;
import org.apache.rocketmq.eventbridge.adapter.runtimer.common.ServiceThread;

import java.util.concurrent.TimeUnit;

/**
 * @Author lkm
 * @Description
 * @Date 下午4:45
 */
public class RateEstimatorTest extends ServiceThread {
    private PIDContextTest pidContextTest;

    private PIDController pid;  // PID控制器
    private volatile RateLimiter rateLimiter;

    private String queueName;

    public RateEstimatorTest(PIDContextTest pidContextTest, PIDController pid, String queueName) {
        this.pidContextTest = pidContextTest;
        this.pid = pid;
        this.queueName = queueName;
        rateLimiter = RateLimiter.create(1);
    }

    @Override
    public String getServiceName() {
        return ProducterTest.class.getSimpleName();
    }

    @Override
    public void run() {
        while (!stopped) {
            long input;
            if ("eventQueue".equals(queueName)) {
                input = pidContextTest.getEventQueue().size();
            } else {
                input = pidContextTest.getTargetQueue().size();
            }

            // double output = pid.compute(input, 10000);
            long newSpeed = pid.mappeSpeed(input, 50000, queueName);
            rateLimiter = RateLimiter.create(newSpeed);
            // System.out.printf("newSpeed=>%s;queue size=>%s \n", newSpeed, input);
            try {
                TimeUnit.SECONDS.sleep(1);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }

    public double acquire(int permits) {
        return rateLimiter.acquire(permits);
    }
}
