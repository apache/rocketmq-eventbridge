package org.apache.rocketmq.eventbridge.adapter.runtimer.service;

import org.apache.rocketmq.eventbridge.adapter.runtimer.config.common.ChannelTaskConfig;

public interface AllocateChannelTaskStrategy {

    ChannelTaskConfig allocate();
}
