package org.apache.rocketmq.eventbridge.runtimer.service.backpressure;

/**
 * @Author lkm
 * @Description 模拟消费速度比生产速度慢时，驻留容量的变化以及生产速度的变化
 * @Date 上午8:43
 */
public class ConsumerSlowerPIDControllerTest {

    public static void main(String[] args) {
        PIDContextTest pidContextTest = new PIDContextTest();

        //Kp=1,Ki=0.2,kD=0 此处是参考Spark 默认参数
        PIDController pidEventQueue = new PIDController(1, 0.008, 0);
        // 队列驻留数据条数
        pidEventQueue.setResidentCapacity(300);
        // 最大生产速度
        pidEventQueue.setMaxSpeed(100);

        // TargetQueue反压计算参数
        PIDController pidTargetQueue = new PIDController(1, 0.008, 0);
        // 队列驻留数据条数
        pidTargetQueue.setResidentCapacity(300);
        pidTargetQueue.setMaxSpeed(100);

        // TargetQueue反压估算器
        RateEstimatorTest rateEstimatorEventQueue =new RateEstimatorTest(pidContextTest, pidEventQueue,"eventQueue");
        rateEstimatorEventQueue.start();

        RateEstimatorTest rateEstimatorTargetQueue = new RateEstimatorTest(pidContextTest, pidTargetQueue,"targetQueue");
        rateEstimatorTargetQueue.start();

        // 生产者，模拟从队列获取消息
        new ProducterTest(pidContextTest,rateEstimatorEventQueue).start();

        // 转换器，模拟将eventrecord转换成pusherrecord
        new TransformTest(pidContextTest,rateEstimatorTargetQueue).start();

        // 模拟消费者
        new ConsumerTest(pidContextTest).start();
    }
}
