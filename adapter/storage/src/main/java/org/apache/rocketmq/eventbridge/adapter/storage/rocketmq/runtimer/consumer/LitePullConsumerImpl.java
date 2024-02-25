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

import org.apache.commons.collections.CollectionUtils;
import org.apache.commons.lang3.StringUtils;
import org.apache.rocketmq.client.consumer.DefaultMQPullConsumer;
import org.apache.rocketmq.client.consumer.MessageQueueListener;
import org.apache.rocketmq.client.consumer.PullCallback;
import org.apache.rocketmq.client.consumer.PullResult;
import org.apache.rocketmq.client.consumer.rebalance.AllocateMessageQueueAveragelyByCircle;
import org.apache.rocketmq.client.exception.MQBrokerException;
import org.apache.rocketmq.client.exception.MQClientException;
import org.apache.rocketmq.client.impl.consumer.ProcessQueue;
import org.apache.rocketmq.common.ServiceState;
import org.apache.rocketmq.common.message.MessageExt;
import org.apache.rocketmq.common.message.MessageQueue;
import org.apache.rocketmq.common.utils.ThreadUtils;
import org.apache.rocketmq.remoting.RPCHook;
import org.apache.rocketmq.remoting.protocol.ResponseCode;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.time.Duration;
import java.util.Collections;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.ScheduledThreadPoolExecutor;
import java.util.concurrent.TimeUnit;

public class LitePullConsumerImpl implements LitePullConsumer {
    private static final Logger LOGGER = LoggerFactory.getLogger(LitePullConsumerImpl.class);
    private final DefaultMQPullConsumer rocketmqPullConsumer;
    private final LocalMessageCache localMessageCache;
    private final ClientConfig clientConfig;
    private final Map<MessageQueue, ProcessQueue> runningQueueMap = new ConcurrentHashMap<>();
    private final ScheduledExecutorService scheduleService = new ScheduledThreadPoolExecutor(1,
            ThreadUtils.newThreadFactory("PullConsumerScheduleService", false));
    private static final Long PULL_TIME_DELAY_MILLS_WHEN_BROKER_FLOW_CONTROL = 30L;
    private static final Long PULL_TIME_DELAY_MILLS_WHEN_EXCEPTION = TimeUnit.SECONDS.toMillis(3);
    private static final String DEFAULT_INSTANCE_NAME = "EventBridge_Consumer_INSTANCE";
    private static final Integer PULL_BATCH_NUM = 32;

    public LitePullConsumerImpl(final ClientConfig clientConfig, final RPCHook rpcHook) {
        this.clientConfig = clientConfig;
        rocketmqPullConsumer = new DefaultMQPullConsumer(clientConfig.getConsumerGroup(), rpcHook);
        rocketmqPullConsumer.setNamesrvAddr(clientConfig.getNameSrvAddr());
        rocketmqPullConsumer.setAllocateMessageQueueStrategy(new AllocateMessageQueueAveragelyByCircle());
        rocketmqPullConsumer.setInstanceName(DEFAULT_INSTANCE_NAME);
        if (clientConfig.getAccessChannel() != null) {
            rocketmqPullConsumer.setAccessChannel(clientConfig.getAccessChannel());
        }
        if (StringUtils.isNotBlank(clientConfig.getNamespace())) {
            rocketmqPullConsumer.setNamespace(clientConfig.getNamespace());
        }
        localMessageCache = new LocalMessageCache(rocketmqPullConsumer, clientConfig);
    }

    @Override
    public void startup() throws MQClientException {
        rocketmqPullConsumer.start();
        LOGGER.info("RocketmqPullConsumer start.");
    }

    @Override
    public void shutdown() {
        rocketmqPullConsumer.shutdown();
        shutdownThreadPool(scheduleService);
    }

    private void shutdownThreadPool(ExecutorService executor) {
        if (executor != null) {
            executor.shutdown();
            try {
                executor.awaitTermination(60, TimeUnit.SECONDS);
            } catch (Exception e) {
                LOGGER.error("Shutdown threadPool failed", e);
            }
            if (!executor.isTerminated()) {
                executor.shutdownNow();
            }
        }
    }

    @Override
    public void attachTopic(final String topic, final String tag) {
        rocketmqPullConsumer.setRegisterTopics(new HashSet<>(Collections.singletonList(topic)));
        rocketmqPullConsumer.registerMessageQueueListener(topic, new MessageQueueListener() {
            @Override
            public void messageQueueChanged(String topic, Set<MessageQueue> mqAll, Set<MessageQueue> mqDivided) {
                submitPullTask(topic, tag, mqDivided);
                localMessageCache.shrinkPullOffsetTable(mqDivided);
                LOGGER.info("Load balance result of topic {} changed, mqAll {}, mqDivided {}.", topic, mqAll, mqDivided);
            }
        });
    }

    @Override
    public void subscribe(final String topic) {
        rocketmqPullConsumer.getDefaultMQPullConsumerImpl().subscriptionAutomatically(topic);

    }

    @Override
    public void unsubscribe(final String topic) {
        rocketmqPullConsumer.getDefaultMQPullConsumerImpl().unsubscribe(topic);
    }

    @Override
    public List<MessageExt> poll(final int pullBatchSize, final Duration timeout) {
        return localMessageCache.poll(pullBatchSize, timeout);
    }

    @Override
    public void commit(final List<String> messageIdList) {
        localMessageCache.commit(messageIdList);
    }

    @Override
    public void setSockProxyJson(final String proxyJson) {
        rocketmqPullConsumer.setSocksProxyConfig(proxyJson);
    }

    private void submitPullTask(String topic, String tag, Set<MessageQueue> assignedQueues) {
        Set<MessageQueue> runningQueues = runningQueueMap.keySet();
        for (MessageQueue runningQueue : runningQueues) {
            if (runningQueue == null || !assignedQueues.contains(runningQueue)) {
                ProcessQueue processQueue = runningQueueMap.remove(runningQueue);
                if (processQueue != null) {
                    processQueue.setDropped(true);
                }
            }
        }
        if (CollectionUtils.isEmpty(assignedQueues)) {
            LOGGER.warn("Not found any messageQueue, topic:{}", topic);
            return;
        }

        for (MessageQueue messageQueue : assignedQueues) {
            ProcessQueue processQueue = rocketmqPullConsumer.getDefaultMQPullConsumerImpl().getRebalanceImpl()
                    .getProcessQueueTable().get(messageQueue);
            if (runningQueueMap.putIfAbsent(messageQueue, processQueue) == null) {
                try {
                    PullTask pullTask = new PullTask(messageQueue, tag);
                    pullImmediately(pullTask);
                    LOGGER.info("Submit pullTask:{}", messageQueue);
                } catch (Exception e) {
                    LOGGER.error("Failed submit pullTask:{}, {}, wait next balancing", topic, messageQueue, e);
                    // Failed to add pull task, waiting for the next round of re-balance
                    processQueue = rocketmqPullConsumer.getDefaultMQPullConsumerImpl().getRebalanceImpl()
                            .getProcessQueueTable().remove(messageQueue);
                    if (processQueue != null) {
                        processQueue.setDropped(true);
                    }
                    runningQueueMap.remove(messageQueue);
                }
            }
        }

    }

    void pullImmediately(PullTask pullTask) {
        scheduleService.schedule(new Runnable() {
            @Override
            public void run() {
                pullTask.run();
            }
        }, 0, TimeUnit.MILLISECONDS);
    }

    void pullLater(PullTask pullTask, long delay, TimeUnit unit) {
        scheduleService.schedule(new Runnable() {
            @Override
            public void run() {
                pullTask.run();
            }
        }, delay, unit);
    }

    class PullTask implements Runnable {

        private final String tag;
        private final MessageQueue messageQueue;

        public PullTask(MessageQueue messageQueue, String tag) {
            this.messageQueue = messageQueue;
            this.tag = tag;
        }

        @Override
        public void run() {
            try {
                if (!ServiceState.RUNNING.equals(rocketmqPullConsumer.getDefaultMQPullConsumerImpl().getServiceState())) {
                    LOGGER.warn("RocketmqPullConsumer not running, pullTask exit.");
                    return;
                }
                ProcessQueue processQueue = rocketmqPullConsumer.getDefaultMQPullConsumerImpl().getRebalanceImpl()
                        .getProcessQueueTable().get(messageQueue);
                if (processQueue == null || processQueue.isDropped()) {
                    LOGGER.info("ProcessQueue {} dropped, pullTask exit", messageQueue);
                    return;
                }
                long offset = localMessageCache.nextPullOffset(messageQueue);

                rocketmqPullConsumer.pullBlockIfNotFound(this.messageQueue, this.tag, offset, PULL_BATCH_NUM, new PullCallback() {
                    @Override
                    public void onSuccess(PullResult pullResult) {
                        try {
                            if (!ServiceState.RUNNING.equals(rocketmqPullConsumer.getDefaultMQPullConsumerImpl().getServiceState())) {
                                LOGGER.warn("rocketmqPullConsumer not running, pullTask exit.");
                                return;
                            }

                            ProcessQueue pq = rocketmqPullConsumer.getDefaultMQPullConsumerImpl().getRebalanceImpl()
                                    .getProcessQueueTable().get(messageQueue);
                            switch (pullResult.getPullStatus()) {
                                case FOUND:
                                    if (pq != null && !pq.isDropped()) {
                                        pq.putMessage(pullResult.getMsgFoundList());
                                        for (final MessageExt messageExt : pullResult.getMsgFoundList()) {
                                            localMessageCache.submitConsumeRequest(new ConsumeRequest(messageExt, messageQueue, pq), Long.MAX_VALUE);
                                        }
                                        localMessageCache.updatePullOffset(messageQueue, pullResult.getNextBeginOffset());
                                        pullImmediately(PullTask.this);
                                    } else {
                                        localMessageCache.removePullOffset(messageQueue);
                                        LOGGER.info("ProcessQueue {} dropped, discard the pulled message.", messageQueue);
                                    }
                                    break;
                                case OFFSET_ILLEGAL:
                                    LOGGER.warn("The pull request offset is illegal, offset is {}, message queue is {}, " +
                                                    "pull result is {}, delay {} ms for next pull",
                                            offset, messageQueue, pullResult, PULL_TIME_DELAY_MILLS_WHEN_EXCEPTION);
                                    localMessageCache.updatePullOffset(messageQueue, pullResult.getNextBeginOffset());
                                    pullLater(PullTask.this, PULL_TIME_DELAY_MILLS_WHEN_EXCEPTION, TimeUnit.MILLISECONDS);
                                    break;
                                case NO_NEW_MSG:
                                case NO_MATCHED_MSG:
                                    LOGGER.info("No NEW_MSG or MATCHED_MSG for mq:{}, pull again.", messageQueue);
                                    localMessageCache.updatePullOffset(messageQueue, pullResult.getNextBeginOffset());
                                    pullImmediately(PullTask.this);
                                    break;
                                default:
                                    LOGGER.warn("Failed to process pullResult, mq:{} {}", messageQueue, pullResult);
                                    break;
                            }
                        } catch (Throwable t) {
                            LOGGER.error("Exception occurs when process pullResult", t);
                            pullLater(PullTask.this, PULL_TIME_DELAY_MILLS_WHEN_EXCEPTION, TimeUnit.MILLISECONDS);
                        }
                    }

                    @Override
                    public void onException(Throwable e) {
                        long delayTimeMillis = 0L;
                        if (e instanceof MQBrokerException && ((MQBrokerException) e).getResponseCode() == ResponseCode.FLOW_CONTROL) {
                            delayTimeMillis = PULL_TIME_DELAY_MILLS_WHEN_BROKER_FLOW_CONTROL;
                        } else {
                            delayTimeMillis = PULL_TIME_DELAY_MILLS_WHEN_EXCEPTION;
                        }
                        LOGGER.error("Exception happens when pull message process, delay {} ms for message queue {}",
                                delayTimeMillis, messageQueue, e);
                        pullLater(PullTask.this, delayTimeMillis, TimeUnit.MILLISECONDS);
                    }
                });
            } catch (Throwable t) {
                LOGGER.error("Error occurs when pull message process, delay {} ms for message queue {}",
                        PULL_TIME_DELAY_MILLS_WHEN_EXCEPTION, messageQueue, t);
                pullLater(PullTask.this, PULL_TIME_DELAY_MILLS_WHEN_EXCEPTION, TimeUnit.MILLISECONDS);
            }
        }

    }
}
