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

import org.apache.rocketmq.client.consumer.DefaultMQPullConsumer;
import org.apache.rocketmq.client.exception.MQClientException;
import org.apache.rocketmq.common.consumer.ConsumeFromWhere;
import org.apache.rocketmq.common.message.MessageExt;
import org.apache.rocketmq.common.message.MessageQueue;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.time.Duration;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.concurrent.BlockingQueue;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.LinkedBlockingQueue;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.atomic.AtomicReference;

/**
 * @Author changfeng
 * @Date 2023/4/9 10:06 上午
 */
public class LocalMessageCache {
    private static final Logger log = LoggerFactory.getLogger(LocalMessageCache.class);
    private final BlockingQueue<ConsumeRequest> consumeRequestCache;
    private final Map<String, ConsumeRequest> consumedRequest;
    private final ConcurrentHashMap<MessageQueue, Long> pullOffsetTable;
    private final DefaultMQPullConsumer rocketmqPullConsumer;
    private final ClientConfig clientConfig;

    LocalMessageCache(final DefaultMQPullConsumer rocketmqPullConsumer, final ClientConfig clientConfig) {
        consumeRequestCache = new LinkedBlockingQueue<>(clientConfig.getRmqPullMessageCacheCapacity());
        this.consumedRequest = new ConcurrentHashMap<>();
        this.pullOffsetTable = new ConcurrentHashMap<>();
        this.rocketmqPullConsumer = rocketmqPullConsumer;
        this.clientConfig = clientConfig;
    }

    int nextPullBatchNums() {
        return Math.min(clientConfig.getRmqPullMessageBatchNums(), consumeRequestCache.remainingCapacity());
    }

    long nextPullOffset(MessageQueue remoteQueue) {
        final AtomicReference<RuntimeException> outerException = new AtomicReference<>();
        final Long existsOffset = pullOffsetTable.computeIfAbsent(remoteQueue, messageQueue -> {
            try {
                // Got -1 when MQBrokerException occurred, aka broker returns non-0 code, e.g. ResponseCode.QUERY_NOT_FOUND
                // or any runtime exception thrown from rpc hook.
                // Got -2 when other exception occurred, include broker not exists, network or client exception
                long offset = rocketmqPullConsumer.fetchConsumeOffset(remoteQueue, false);
                if (offset == -2) {
                    outerException.set(new RuntimeException("fetchConsumeOffsetFromBroker exception, please check rocketmq client for more details"));
                    return null;
                }
                if (offset == -1 || offset == 0) {
                    // Follow the CONSUME_FROM_WHERE to compute next pull offset
                    // But note that if broker thrown any unexpected runtime exception may cause offset rollback.
                    // We don't handle this risk because of MetaQ doesn't have any rpc hook
                    final ConsumeFromWhere fromWhere = clientConfig.getConsumeFromWhere();
                    switch (fromWhere) {
                        case CONSUME_FROM_LAST_OFFSET:
                            offset = this.rocketmqPullConsumer.maxOffset(remoteQueue);
                            break;
                        case CONSUME_FROM_FIRST_OFFSET:
                            offset = this.rocketmqPullConsumer.minOffset(remoteQueue);
                            break;
                        case CONSUME_FROM_TIMESTAMP:
                            offset = this.rocketmqPullConsumer.searchOffset(remoteQueue, clientConfig.getConsumeTimestamp());
                            break;
                    }
                }
                if (offset >= 0) {
                    // Got an offset from offset store
                    return offset;
                }
                // Maybe wrong ConsumeFromWhere configured, so couldn't find any offset
                return null;
            } catch (Exception e) {
                outerException.set(new RuntimeException(e));
                return null;
            }
        });
        if (outerException.get() != null) {
            throw outerException.get();
        }
        if (existsOffset == null) {
            final String errorMsg = "[BUG] No offset found in offset store or pullOffsetTable without any exception";
            log.warn(errorMsg);
            throw new RuntimeException(errorMsg);
        }
        return existsOffset;
    }

    void updatePullOffset(MessageQueue remoteQueue, long nextPullOffset) {
        pullOffsetTable.put(remoteQueue, nextPullOffset);
    }

    void removePullOffset(MessageQueue remoteQueue) {
        pullOffsetTable.remove(remoteQueue);
    }

    void shrinkPullOffsetTable(Set<MessageQueue> mqDivided) {
        pullOffsetTable.entrySet().removeIf(next -> !mqDivided.contains(next.getKey()));
    }

    void submitConsumeRequest(ConsumeRequest consumeRequest) {
        try {
            consumeRequestCache.put(consumeRequest);
        } catch (InterruptedException ignore) {
        }
    }

    public List<MessageExt> poll(final int pullBatchSize, final Duration timeout) {
        List<MessageExt> messageList = new ArrayList<>();
        try {
            List<ConsumeRequest> consumeRequestList = new ArrayList<>();
            consumeRequestCache.drainTo(consumeRequestList, pullBatchSize);
            if (consumeRequestList.size() == 0) {
                final ConsumeRequest consumeRequest = consumeRequestCache.poll(timeout.toMillis(), TimeUnit.MILLISECONDS);
                if (consumeRequest != null) {
                    consumeRequestList.add(consumeRequest);
                    // drainTo again
                    consumeRequestCache.drainTo(consumeRequestList, pullBatchSize - 1);
                }
            }
            for (final ConsumeRequest consumeRequest : consumeRequestList) {
                MessageExt messageExt = consumeRequest.getMessageExt();
                consumedRequest.put(messageExt.getMsgId(), consumeRequest);
                messageList.add(messageExt);
            }
        } catch (InterruptedException e) {
            log.warn("Poll from local cache interrupted.", e);
        }
        return messageList;
    }

    public void commit(final List<String> messageList) {
        for (final String msgId : messageList) {
            ConsumeRequest consumeRequest = consumedRequest.remove(msgId);
            if (consumeRequest != null) {
                long offset = consumeRequest.getProcessQueue().removeMessage(Collections.singletonList(consumeRequest.getMessageExt()));
                try {
                    rocketmqPullConsumer.updateConsumeOffset(consumeRequest.getMessageQueue(), offset);
                } catch (MQClientException e) {
                    log.error("A error occurred in update consume offset process.", e);
                }
            }
        }
        if (clientConfig.isCommitSync()) {
            rocketmqPullConsumer.getDefaultMQPullConsumerImpl().persistConsumerOffset();
        }
    }
}
