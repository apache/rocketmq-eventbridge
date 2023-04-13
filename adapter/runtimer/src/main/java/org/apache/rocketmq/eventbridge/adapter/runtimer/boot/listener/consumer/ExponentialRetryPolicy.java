package org.apache.rocketmq.eventbridge.adapter.runtimer.boot.listener.consumer;

import com.google.common.base.MoreObjects;

import java.util.concurrent.TimeUnit;

/**
 * @Author changfeng
 * @Date 2023/4/9 10:11 上午
 */
public class ExponentialRetryPolicy implements RetryPolicy {
    private long initial = TimeUnit.SECONDS.toMillis(5);
    private long max = TimeUnit.HOURS.toMillis(2);
    private long multiplier = 2;
    private int retryCount = 0;

    public ExponentialRetryPolicy() {
    }

    public ExponentialRetryPolicy(long initial, long max, long multiplier) {
        this.initial = initial;
        this.max = max;
        this.multiplier = multiplier;
    }

    public long getInitial() {
        return initial;
    }

    public void setInitial(long initial) {
        this.initial = initial;
    }

    public long getMax() {
        return max;
    }

    public void setMax(long max) {
        this.max = max;
    }

    public long getMultiplier() {
        return multiplier;
    }

    public void setMultiplier(long multiplier) {
        this.multiplier = multiplier;
    }

    @Override
    public String toString() {
        return MoreObjects.toStringHelper(this)
                .add("initial", initial)
                .add("max", max)
                .add("multiplier", multiplier)
                .toString();
    }

    @Override
    public long nextDelayDuration() {
        if (retryCount < 0) {
            retryCount = 0;
        }
        if (retryCount > 32) {
            retryCount = 32;
        }
        return Math.min(max, initial * (long) Math.pow(multiplier, retryCount++));
    }
}
