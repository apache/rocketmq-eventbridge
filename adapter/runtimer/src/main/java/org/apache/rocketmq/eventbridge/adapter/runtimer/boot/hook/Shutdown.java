package org.apache.rocketmq.eventbridge.adapter.runtimer.boot.hook;

public interface Shutdown {
    void shutdown() throws Exception;
}
