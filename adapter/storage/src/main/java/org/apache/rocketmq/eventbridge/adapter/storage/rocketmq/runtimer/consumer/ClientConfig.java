/*
 * Licensed to the Apache Software Foundation (ASF) under one or more
 * contributor license agreements.  See the NOTICE file distributed with
 * this work for additional information regarding copyright ownership.
 * The ASF licenses this file to You under the Apache License, Version 2.0
 * (the "License"); you may not use this file except in compliance with
 * the License.  You may obtain a copy of the License at
 *
 *     http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */

package org.apache.rocketmq.eventbridge.adapter.storage.rocketmq.runtimer.consumer;

import org.apache.rocketmq.client.AccessChannel;
import org.apache.rocketmq.common.consumer.ConsumeFromWhere;

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

    public AccessChannel getAccessChannel() {
        return accessChannel;
    }

    public void setAccessChannel(AccessChannel accessChannel) {
        this.accessChannel = accessChannel;
    }

    public static ClientConfig cloneConfig(ClientConfig clientConfig) {
        ClientConfig newConfig = new ClientConfig();
        newConfig.setRmqPullMessageBatchNums(clientConfig.getRmqPullMessageBatchNums());
        newConfig.setConsumeFromWhere(clientConfig.getConsumeFromWhere());
        newConfig.setConsumeTimestamp(clientConfig.getConsumeTimestamp());
        newConfig.setNameSrvAddr(clientConfig.getNameSrvAddr());
        newConfig.setNamespace(clientConfig.getNamespace());
        newConfig.setConsumerGroup(clientConfig.getConsumerGroup());
        newConfig.setPullInterval(clientConfig.getPullInterval());
        newConfig.setCommitSync(clientConfig.isCommitSync());
        newConfig.setAccessChannel(clientConfig.getAccessChannel());
        return newConfig;
    }
}
