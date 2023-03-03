package org.apache.rocketmq.eventbridge.adapter.runtimer.boot;

import org.apache.rocketmq.client.consumer.DefaultLitePullConsumer;
import org.apache.rocketmq.client.exception.MQClientException;
import org.apache.rocketmq.common.message.MessageExt;
import org.apache.rocketmq.common.message.MessageQueue;
import org.apache.rocketmq.eventbridge.adapter.runtimer.boot.listener.ListenerFactory;
import org.apache.rocketmq.eventbridge.adapter.runtimer.common.QueueState;
import org.springframework.util.CollectionUtils;

import java.util.List;
import java.util.concurrent.*;

/**
 * listen the event and offer to queue
 * @author artisan
 */
public class EventBusListener implements Runnable{

    private final ConcurrentHashMap<MessageQueue, Long> messageQueuesOffsetMap;

    private final ConcurrentHashMap<MessageQueue, QueueState> messageQueuesStateMap;

    private List<String> topics;

    private ListenerFactory listenerFactory;

    private ExecutorService executorService = new ThreadPoolExecutor(20,60, 1000,TimeUnit.MICROSECONDS, new LinkedBlockingDeque<>(100));

    private BlockingQueue<MessageExt> eventMessage = new LinkedBlockingQueue(50000);

    public EventBusListener(ListenerFactory listenerFactory){
        this.messageQueuesOffsetMap = new ConcurrentHashMap<>(256);
        this.messageQueuesStateMap = new ConcurrentHashMap<>(256);
        this.listenerFactory = listenerFactory;
    }

    public void init(List<String> topics){
        this.topics = topics;
    }

    @Override
    public void run() {
        for(String topic : topics){
            executorService.submit(() -> {
                DefaultLitePullConsumer pullConsumer = listenerFactory.initDefaultMQPullConsumer();
                try {
                    pullConsumer.subscribe(topic, "*");
                    pullConsumer.start();
                    List<MessageExt> messageExts = pullConsumer.poll(3000);
                    if(CollectionUtils.isEmpty(messageExts)){
                        return;
                    }
                    for(MessageExt messageExt : messageExts){
                        listenerFactory.offerListenEvent(messageExt);
                    }
                } catch (MQClientException e) {
                    e.printStackTrace();
                }finally {
                    pullConsumer.commitSync();
                }
            });
        }
    }

}
