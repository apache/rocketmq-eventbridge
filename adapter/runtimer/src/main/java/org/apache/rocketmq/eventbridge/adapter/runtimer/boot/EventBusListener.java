package org.apache.rocketmq.eventbridge.adapter.runtimer.boot;

import com.google.common.collect.Lists;
import org.apache.commons.collections.MapUtils;
import org.apache.rocketmq.client.consumer.DefaultLitePullConsumer;
import org.apache.rocketmq.common.message.MessageExt;
import org.apache.rocketmq.common.message.MessageQueue;
import org.apache.rocketmq.eventbridge.adapter.runtimer.boot.listener.ListenerFactory;
import org.apache.rocketmq.eventbridge.adapter.runtimer.common.entity.TargetKeyValue;
import org.apache.rocketmq.eventbridge.adapter.runtimer.common.QueueState;
import org.apache.rocketmq.eventbridge.adapter.runtimer.common.ServiceThread;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.util.CollectionUtils;

import java.util.*;
import java.util.concurrent.*;

/**
 * listen the event and offer to queue
 * @author artisan
 */
public class EventBusListener extends ServiceThread {

    private Logger logger = LoggerFactory.getLogger(EventBusListener.class);

    private final ConcurrentHashMap<MessageQueue, Long> messageQueuesOffsetMap;

    private final ConcurrentHashMap<MessageQueue, QueueState> messageQueuesStateMap;

    private List<String> topics = new CopyOnWriteArrayList<>();

    private List<DefaultLitePullConsumer> listenConsumer = new CopyOnWriteArrayList<>();

    private ListenerFactory listenerFactory;

    private ExecutorService executorService = new ThreadPoolExecutor(20,60, 1000,TimeUnit.MICROSECONDS, new LinkedBlockingDeque<>(100));

    private BlockingQueue<MessageExt> eventMessage = new LinkedBlockingQueue(50000);

    public EventBusListener(ListenerFactory listenerFactory){
        this.messageQueuesOffsetMap = new ConcurrentHashMap<>(256);
        this.messageQueuesStateMap = new ConcurrentHashMap<>(256);
        this.listenerFactory = listenerFactory;
    }

    /**
     * init listen consumer
     * @param taskConfig
     */
    public void initOrUpdateListenConsumer(Map<String, List<TargetKeyValue>> taskConfig){
        if(MapUtils.isEmpty(taskConfig)){
            logger.warn("initListenConsumer by taskConfig param is empty");
            return;
        }
        List<TargetKeyValue> targetKeyValues = initTaskKeyInfo(taskConfig);
        this.topics.addAll(listenerFactory.parseTopicListByList(targetKeyValues));
        for (String topic : topics){
            DefaultLitePullConsumer pullConsumer = listenerFactory.initDefaultMQPullConsumer(topic);
            listenConsumer.add(pullConsumer);
        }
    }

    /**
     * init all task config info
     * @param taskConfig
     * @return
     */
    private List<TargetKeyValue> initTaskKeyInfo(Map<String, List<TargetKeyValue>> taskConfig) {
        Set<TargetKeyValue> targetKeyValues = new HashSet<>();
        for(String connectName : taskConfig.keySet()){
            targetKeyValues.addAll(taskConfig.get(connectName));
        }
        return Lists.newArrayList(targetKeyValues);
    }

    @Override
    public void run() {
        while (!stopped){
            for(DefaultLitePullConsumer pullConsumer : listenConsumer) {
                executorService.submit(() -> {
                    try {
                        List<MessageExt> messageExts = pullConsumer.poll(3000);
                        if (CollectionUtils.isEmpty(messageExts)) {
                            return;
                        }
                        for (MessageExt messageExt : messageExts) {
                            listenerFactory.offerListenEvent(messageExt);
                        }
                    } finally {
                        pullConsumer.commitSync();

                        pullConsumer.shutdown();
                    }
                });
            }
        }
    }

    @Override
    public String getServiceName() {
        return this.getClass().getSimpleName();
    }
}
