package org.apache.rocketmq.eventbridge.adapter.runtimer.boot.listener.consumer;

import org.apache.rocketmq.client.AccessChannel;
import org.apache.rocketmq.common.consumer.ConsumeFromWhere;

/**
 * @Author changfeng
 * @Date 2023/4/9 10:08 上午
 */
public class ClientConfig {
    private int rmqPullMessageCacheCapacity = 1000;
    private int rmqPullMessageBatchNums = 20;
    private ConsumeFromWhere consumeFromWhere = ConsumeFromWhere.CONSUME_FROM_LAST_OFFSET;
    private long consumeTimestamp = System.currentTimeMillis();
    private String nameSrvAddr;
    private String namespace;
    private String consumerGroup;
    private int pullInterval = 0;
    // All the offsets will be committed in the commit thread if enable this flag.
    // To avoid too many rpc calls, disable it and rely on the inner offset automatic commit mechanism
    private boolean commitSync = false;
    private String routeHookEndpoint;
    private AccessChannel accessChannel;

    public int getRmqPullMessageCacheCapacity() {
        return rmqPullMessageCacheCapacity;
    }

    public void setRmqPullMessageCacheCapacity(final int capacity) {
        this.rmqPullMessageCacheCapacity = capacity;
    }

    public int getRmqPullMessageBatchNums() {
        return rmqPullMessageBatchNums;
    }

    public void setRmqPullMessageBatchNums(final int nums) {
        this.rmqPullMessageBatchNums = nums;
    }

    public ConsumeFromWhere getConsumeFromWhere() {
        return consumeFromWhere;
    }

    public void setConsumeFromWhere(
            final ConsumeFromWhere consumeFromWhere) {
        this.consumeFromWhere = consumeFromWhere;
    }

    public long getConsumeTimestamp() {
        return consumeTimestamp;
    }

    public void setConsumeTimestamp(final long consumeTimestamp) {
        this.consumeTimestamp = consumeTimestamp;
    }

    public String getNameSrvAddr() {
        return nameSrvAddr;
    }

    public void setNameSrvAddr(final String nameSrvAddr) {
        this.nameSrvAddr = nameSrvAddr;
    }

    public String getNamespace() {
        return namespace;
    }

    public void setNamespace(String namespace) {
        this.namespace = namespace;
    }

    public String getConsumerGroup() {
        return consumerGroup;
    }

    public void setConsumerGroup(final String consumerGroup) {
        this.consumerGroup = consumerGroup;
    }

    public int getPullInterval() {
        return pullInterval;
    }

    public void setPullInterval(final int pullInterval) {
        this.pullInterval = pullInterval;
    }

    public boolean isCommitSync() {
        return commitSync;
    }

    public void setCommitSync(final boolean commitSync) {
        this.commitSync = commitSync;
    }

    public String getRouteHookEndpoint() {
        return routeHookEndpoint;
    }

    public void setRouteHookEndpoint(final String routeHookEndpoint) {
        this.routeHookEndpoint = routeHookEndpoint;
    }

    public AccessChannel getAccessChannel() {
        return accessChannel;
    }

    public void setAccessChannel(AccessChannel accessChannel) {
        this.accessChannel = accessChannel;
    }
}
