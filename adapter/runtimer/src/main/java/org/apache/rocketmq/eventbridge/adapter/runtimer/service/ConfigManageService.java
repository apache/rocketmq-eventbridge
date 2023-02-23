package org.apache.rocketmq.eventbridge.adapter.runtimer.service;

import org.apache.rocketmq.eventbridge.adapter.runtimer.config.RuntimerConfig;

/**
 * RuntimerChannel Config Management
 */
public interface ConfigManageService {

    void start();

    void stop();

    void persist();

    void initialize(RuntimerConfig runtimerConfig);

    void pauseChannel();

    void resumeChannel();

    void registerListener();
}
