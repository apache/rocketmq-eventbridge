package org.apache.rocketmq.eventbridge.runtimer.service.backpressure;

import org.apache.rocketmq.eventbridge.adapter.runtimer.common.ServiceThread;

import java.util.UUID;

/**
 * @Author lkm
 * @Description
 * @Date 下午4:37
 */
public class ProducterTest extends ServiceThread {
    private PIDContextTest pidContextTest;
    private RateEstimatorTest rateEstimatorTest;

    public ProducterTest(PIDContextTest pidContextTest, RateEstimatorTest rateEstimatorTest) {
        this.pidContextTest = pidContextTest;
        this.rateEstimatorTest = rateEstimatorTest;
    }

    @Override
    public String getServiceName() {
        return RateEstimatorTest.class.getSimpleName();
    }

    @Override
    public void run() {
        while (!stopped) {
            // 用于控制速度。例如计算得到速度为20条/s，令牌桶设置为20。需要1秒生成20个，每次拿一个，拿20次拿完即止，等待下一次采样
            rateEstimatorTest.acquire(1);
            try {
                pidContextTest.getEventQueue().put(UUID.randomUUID().toString());
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }
}
