package org.apache.rocketmq.eventbridge.adapter.runtimer.boot.listener.consumer;

/**
 * @Author changfeng
 * @Date 2023/4/9 10:10 上午
 */
public interface RetryPolicy {
    long nextDelayDuration();
}
