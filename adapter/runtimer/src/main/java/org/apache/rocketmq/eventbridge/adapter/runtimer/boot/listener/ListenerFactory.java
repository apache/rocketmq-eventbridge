package org.apache.rocketmq.eventbridge.adapter.runtimer.boot.listener;

import com.google.common.base.Splitter;
import com.google.common.collect.Lists;
import io.openmessaging.connector.api.data.ConnectRecord;
import io.openmessaging.connector.api.data.RecordOffset;
import io.openmessaging.connector.api.data.RecordPartition;
import org.apache.commons.collections.CollectionUtils;
import org.apache.commons.lang3.StringUtils;
import org.apache.rocketmq.client.consumer.DefaultLitePullConsumer;
import org.apache.rocketmq.common.message.MessageExt;
import org.apache.rocketmq.common.message.MessageQueue;
import org.apache.rocketmq.eventbridge.adapter.runtimer.common.ConnectKeyValue;
import org.apache.rocketmq.eventbridge.adapter.runtimer.config.RuntimeConfigDefine;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

import java.util.*;
import java.util.concurrent.BlockingDeque;
import java.util.concurrent.BlockingQueue;
import java.util.concurrent.LinkedBlockingDeque;
import java.util.concurrent.LinkedBlockingQueue;

@Component
public class ListenerFactory {

    private static final String SEMICOLON = ";";

    private static final String SYS_DEFAULT_CONSUME_GROUP = "event-bridge-default-group";

    public static final String QUEUE_OFFSET = "queueOffset";

    private BlockingQueue<Map<String, List<ConnectKeyValue>>> taskConfig = new LinkedBlockingQueue<>(1000);

    private BlockingQueue<MessageExt> eventMessage = new LinkedBlockingQueue(50000);

    private BlockingQueue<Map<ConnectKeyValue, ConnectRecord>> targetQueue = new LinkedBlockingQueue<>(50000);

    @Value("rocketmq.namesrvAddr")
    private String namesrvAddr;

    public DefaultLitePullConsumer initDefaultMQPullConsumer() {
        DefaultLitePullConsumer consumer = new DefaultLitePullConsumer();
        consumer.setConsumerGroup(SYS_DEFAULT_CONSUME_GROUP);
        consumer.setNamesrvAddr(namesrvAddr);
        return consumer;
    }

    public boolean offerTaskConfig(Map<String, List<ConnectKeyValue>> newTaskConfig){
        return taskConfig.offer(newTaskConfig);
    }

    public Map<String, List<ConnectKeyValue>> takeTaskConfig(){
        try {
            return taskConfig.take();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        return null;
    }

    /**
     * Offer listener event
     * @param messageExt
     * @return
     */
    public boolean offerListenEvent(MessageExt messageExt){
        return eventMessage.offer(messageExt);
    }

    public MessageExt takeListenerEvent() {
        try {
            return eventMessage.take();
        }catch (Exception exception){
            exception.printStackTrace();
        }
        return null;
    }

    public String createInstance(String servers) {
        String[] serversArray = servers.split(";");
        List<String> serversList = new ArrayList<String>();
        for (String server : serversArray) {
            if (!serversList.contains(server)) {
                serversList.add(server);
            }
        }
        Collections.sort(serversList);
        return String.valueOf(serversList.toString().hashCode());
    }

    /**
     * parse topic list by task config
     * @param taskConfig
     * @return
     */
    public Set<String> parseTopicList(ConnectKeyValue taskConfig) {
        String messageQueueStr = taskConfig.getString(RuntimeConfigDefine.CONNECT_TOPICNAME);
        if (StringUtils.isBlank(messageQueueStr)) {
            return null;
        }
        List<String> topicList = Splitter.on(SEMICOLON).omitEmptyStrings().trimResults().splitToList(messageQueueStr);
        return new HashSet<>(topicList);
    }

    /**
     * parse topic list by task config list
     * @param taskConfigs
     * @return
     */
    public Set<String> parseTopicListByList(List<ConnectKeyValue> taskConfigs) {
        List<String> allTopicList = Lists.newArrayList();
        for(ConnectKeyValue taskConfig : taskConfigs){
            String messageQueueStr = taskConfig.getString(RuntimeConfigDefine.CONNECT_TOPICNAME);
            if (StringUtils.isBlank(messageQueueStr)) {
                continue;
            }
            List<String> topicList = Splitter.on(SEMICOLON).omitEmptyStrings().trimResults().splitToList(messageQueueStr);
            allTopicList.addAll(topicList);
        }
        return new HashSet<>(allTopicList);
    }

    /**
     * parse msg queue by queue json
     * @param messageQueueStr
     * @return
     */
    public MessageQueue parseMessageQueueList(String messageQueueStr) {
        List<String> messageQueueStrList = Splitter.on(SEMICOLON).omitEmptyStrings().trimResults().splitToList(messageQueueStr);
        if (CollectionUtils.isEmpty(messageQueueStrList) || messageQueueStrList.size() != 3) {
            return null;
        }
        return new MessageQueue(messageQueueStrList.get(0), messageQueueStrList.get(1), Integer.valueOf(messageQueueStrList.get(2)));
    }

    public RecordPartition convertToRecordPartition(String topic, String brokerName, int queueId) {
        Map<String, String> map = new HashMap<>();
        map.put("topic", topic);
        map.put("brokerName", brokerName);
        map.put("queueId", queueId + "");
        RecordPartition recordPartition = new RecordPartition(map);
        return recordPartition;
    }

    public RecordOffset convertToRecordOffset(Long offset) {
        Map<String, String> offsetMap = new HashMap<>();
        offsetMap.put(QUEUE_OFFSET, offset + "");
        RecordOffset recordOffset = new RecordOffset(offsetMap);
        return recordOffset;
    }

    public boolean offerTargetTaskQueue(Map<ConnectKeyValue, ConnectRecord> targetMap){
        return targetQueue.offer(targetMap);
    }

    public Map<ConnectKeyValue, ConnectRecord> takeTargetMap(){
        if(targetQueue.isEmpty()){
            return null;
        }
        try{
            return targetQueue.take();
        }catch (Exception exception){
            exception.printStackTrace();
        }
        return null;
    }
}
