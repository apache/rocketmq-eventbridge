package org.apache.rocketmq.eventbridge.runtimer.service.backpressure;

import org.apache.rocketmq.common.CountDownLatch2;
import org.apache.rocketmq.eventbridge.adapter.runtimer.common.ServiceThread;

import java.text.SimpleDateFormat;
import java.util.Objects;
import java.util.Random;

/**
 * @Author lkm
 * @Description
 * @Date 下午4:37
 */
public class ConsumerTest extends ServiceThread {
    private PIDContextTest pidContextTest;

    SimpleDateFormat simpleDateFormat = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");

    public ConsumerTest(PIDContextTest pidContextTest) {
        this.pidContextTest = pidContextTest;
    }

    CountDownLatch2 countDownLatch2 = new CountDownLatch2(300);

    @Override
    public String getServiceName() {
        return ConsumerTest.class.getSimpleName();
    }

    Random random = new Random();

    @Override
    public void run() {
        while (!stopped) {
            try {
                if (!pidContextTest.canExecute()) {
                    this.waitForRunning(1000);
                }
                String a = pidContextTest.getTargetQueue().take();
                //System.out.printf("处理信息：a=>%s,\t当前队列数据容量：input=>%s,\t\tcurrentTime=>%s \n", a, pidContextTest.getTargetQueue().size(), simpleDateFormat.format(new Date()));
                if (Objects.isNull(a)) {
                    this.waitForRunning(random.nextInt(1000));
                }
            } catch (InterruptedException e) {
                e.printStackTrace();
            }

            pidContextTest.getThreadPoolExecutor().execute(() -> {
                // 当下游消费速度在一定范围波动时
                this.waitForRunning(random.nextInt(100));
            });
        }
    }
}
