package org.apache.rocketmq.eventbridge.runtimer.service.backpressure;

import com.google.common.util.concurrent.ThreadFactoryBuilder;

import java.util.concurrent.*;

/**
 * @Author lkm
 * @Description
 * @Date 下午4:00
 */
public class PIDContextTest {
    private BlockingQueue<String> eventQueue = new LinkedBlockingQueue<>(50000);
    private BlockingQueue<String> targetQueue = new LinkedBlockingQueue<>(50000);
    private ExecutorService threadPoolExecutor;

    public PIDContextTest() {
        threadPoolExecutor = initDefaultThreadPoolExecutor();
    }

    public BlockingQueue<String> getEventQueue() {
        return eventQueue;
    }

    public BlockingQueue<String> getTargetQueue() {
        return targetQueue;
    }


    public ExecutorService getThreadPoolExecutor() {
        return threadPoolExecutor;
    }

    public synchronized boolean  canExecute() {
        // System.out.printf("thread queue size=>%s", ((ThreadPoolExecutor) threadPoolExecutor).getQueue().size());
        return ((ThreadPoolExecutor) threadPoolExecutor).getQueue().size() < 300;
    }

    /**
     * init default thread poll param, support auto config
     *
     * @return
     */
    private ExecutorService initDefaultThreadPoolExecutor() {
        ThreadFactoryBuilder threadFactory = new ThreadFactoryBuilder().setNameFormat("pid-test");
        return new ThreadPoolExecutor(4, 8, 10, TimeUnit.MILLISECONDS, new LinkedBlockingQueue<>(300), threadFactory.build());
    }
}
