package org.apache.rocketmq.eventbridge.adapter.runtimer.boot;

import org.apache.rocketmq.common.message.MessageExt;
import org.apache.rocketmq.eventbridge.adapter.runtimer.common.ServiceThread;
import org.apache.rocketmq.eventbridge.adapter.runtimer.common.plugin.Plugin;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.concurrent.BlockingQueue;
import java.util.concurrent.LinkedBlockingQueue;

/**
 * receive event and transfer the rule to pusher
 */
public class EventRuleTransfer extends ServiceThread {

    private static final Logger logger = LoggerFactory.getLogger(EventRuleTransfer.class);


    public EventRuleTransfer(Plugin plugin){

    }

    public void init(){

    }

    @Override
    public String getServiceName() {
        return null;
    }

    @Override
    public void run() {

    }
}
