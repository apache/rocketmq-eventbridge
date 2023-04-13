package org.apache.rocketmq.eventbridge.adapter.runtimer.boot.listener.consumer;

import org.apache.rocketmq.client.exception.MQClientException;
import org.apache.rocketmq.common.message.MessageExt;

import java.time.Duration;
import java.util.List;

/**
 * @Author changfeng
 * @Date 2023/4/9 10:09 上午
 */
public interface LitePullConsumer {
    void startup() throws MQClientException;

    void shutdown();

    void attachTopic(String topic, String tag);

    List<MessageExt> poll(int pullBatchSize, Duration timeout);

    void commit(List<String> messageIdList);

    void setSockProxyJson(String proxyJson);

    void subscribe(String topic);

    void unsubscribe(String topic);
}
