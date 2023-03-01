package org.apache.rocketmq.eventbridge.adapter.runtimer.boot;

/**
 * receive event and transfer the rule to pusher
 */
public class EventRuleTransfer {

    public void init(){

    }

    public Object doTransform(Object channelRecord){
        return channelRecord;
    }
}
