package org.apache.rocketmq.eventbridge.adapter.runtimer.boot.listener.consumer;

import org.apache.rocketmq.client.impl.consumer.ProcessQueue;
import org.apache.rocketmq.common.message.MessageExt;
import org.apache.rocketmq.common.message.MessageQueue;

/**
 * @Author changfeng
 * @Date 2023/4/9 10:07 上午
 */
public class ConsumeRequest {
    private final MessageExt messageExt;
    private final MessageQueue messageQueue;
    private final ProcessQueue processQueue;

    public ConsumeRequest(final MessageExt messageExt, final MessageQueue messageQueue,
                          final ProcessQueue processQueue) {
        this.messageExt = messageExt;
        this.messageQueue = messageQueue;
        this.processQueue = processQueue;
    }

    public MessageExt getMessageExt() {
        return messageExt;
    }

    public MessageQueue getMessageQueue() {
        return messageQueue;
    }

    public ProcessQueue getProcessQueue() {
        return processQueue;
    }
}
