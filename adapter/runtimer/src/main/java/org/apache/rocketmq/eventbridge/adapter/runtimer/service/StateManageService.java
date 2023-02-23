package org.apache.rocketmq.eventbridge.adapter.runtimer.service;

import org.apache.rocketmq.eventbridge.adapter.runtimer.config.RuntimerConfig;
import org.apache.rocketmq.eventbridge.adapter.runtimer.config.common.ChannelStatus;

public interface StateManageService {

    void initialize(RuntimerConfig runtimerConfig);

    /**
     * Start dependent services (if needed)
     */
    void start();

    /**
     * Stop dependent services (if needed)
     */
    void stop();

    /**
     * Set the state of the channel to the given value.
     *
     * @param status the status of the channel
     */
    void put(ChannelStatus status);

}
