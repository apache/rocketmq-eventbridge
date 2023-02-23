package org.apache.rocketmq.eventbridge.adapter.runtimer.boot;

import org.apache.rocketmq.client.consumer.DefaultMQPushConsumer;

import java.util.HashSet;
import java.util.Set;

public class RuntimerSinkTask implements Runnable{

    public static final String BROKER_NAME = "brokerName";
    public static final String QUEUE_ID = "queueId";
    public static final String TOPIC = "topic";
    public static final String QUEUE_OFFSET = "queueOffset";
    private static final Integer MAX_MESSAGE_NUM = 32;
    private static final long PULL_MSG_ERROR_BACKOFF_MS = 1000 * 5;
    private static final Set<String> MQ_SYS_KEYS = new HashSet<String>() {
        {
            add("MIN_OFFSET");
            add("TRACE_ON");
            add("MAX_OFFSET");
            add("MSG_REGION");
            add("UNIQ_KEY");
            add("WAIT");
            add("TAGS");
        }
    };
    /**
     * A RocketMQ consumer to push message from MQ.
     */
    private final DefaultMQPushConsumer consumer;

    public RuntimerSinkTask(DefaultMQPushConsumer consumer) {
        this.consumer = consumer;
    }

    public void initializeAndStart(){

    }

    @Override
    public void run() {

    }
}
