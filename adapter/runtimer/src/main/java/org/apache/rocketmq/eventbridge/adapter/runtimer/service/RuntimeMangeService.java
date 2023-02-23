package org.apache.rocketmq.eventbridge.adapter.runtimer.service;

import org.apache.rocketmq.eventbridge.adapter.runtimer.config.RuntimerConfig;

public interface RuntimeMangeService {

    void initialize(RuntimerConfig runtimerConfig);

    /**
     * Start the runtimer manager.
     */
    void start();

    /**
     * Stop the runtimer manager.
     */
    void stop();

    void registerListener();
}
