package org.apache.rocketmq.eventbridge.runtimer.service.backpressure;

/**
 * @Author lkm
 * @Description 消费速度比生产速度快时，驻留容量的变化以及生产速度的变化
 * @Date 上午8:43
 */
public class ProductSlowerPIDControllerTest {

    public static void main(String[] args) {
        PIDContextTest pidContextTest = new PIDContextTest();

        //Kp=1,Ki=0.2,kD=0 此处是参考Spark 默认参数
        PIDController pid = new PIDController(5, 0, 0);
        pid.setResidentCapacity(1000);
        pid.setMaxSpeed(20);

        RateEstimatorTest rateEstimatorEventQueue =new RateEstimatorTest(pidContextTest, pid,"eventQueue");
        rateEstimatorEventQueue.start();

        RateEstimatorTest rateEstimatorTargetQueue = new RateEstimatorTest(pidContextTest, pid,"targetQueue");
        rateEstimatorTargetQueue.start();

        new ProducterTest(pidContextTest,rateEstimatorEventQueue).start();

        new TransformTest(pidContextTest,rateEstimatorTargetQueue).start();

        new ConsumerTest(pidContextTest).start();
    }
}
