package org.apache.rocketmq.eventbridge.runtimer.service.backpressure;

import org.apache.rocketmq.eventbridge.adapter.runtimer.common.ServiceThread;

import java.text.SimpleDateFormat;
import java.util.Objects;

/**
 * @Author lkm
 * @Description
 * @Date 下午4:37
 */
public class TransformTest extends ServiceThread {
    private PIDContextTest pidContextTest;
    private RateEstimatorTest rateEstimatorTest;

    SimpleDateFormat simpleDateFormat = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");

    public TransformTest(PIDContextTest pidContextTest, RateEstimatorTest rateEstimatorTest) {
        this.pidContextTest = pidContextTest;
        this.rateEstimatorTest = rateEstimatorTest;
    }

    @Override
    public String getServiceName() {
        return TransformTest.class.getSimpleName();
    }

    @Override
    public void run() {
        while (!stopped) {
            try {
                rateEstimatorTest.acquire(5);
                String a = pidContextTest.getEventQueue().take();
                if (Objects.isNull(a)) {
                    this.waitForRunning(1000);
                }
                // 模拟有5个转换器
                for (int i = 0; i < 5; i++) {
                    pidContextTest.getTargetQueue().put(a);
                }
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }
}
