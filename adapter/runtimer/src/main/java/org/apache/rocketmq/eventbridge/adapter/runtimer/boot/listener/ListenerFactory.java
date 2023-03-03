package org.apache.rocketmq.eventbridge.adapter.runtimer.boot.listener;

import com.google.common.base.Splitter;
import com.google.common.collect.Lists;
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
import java.util.concurrent.BlockingQueue;
import java.util.concurrent.LinkedBlockingQueue;

@Component
public class ListenerFactory {

    private static final String SEMICOLON = ";";

    private static final String SYS_TASK_CG_PREFIX = "listener-";

    private static final String SYS_DEFAULT_CONSUME_GROUP = "event-bridge-default-group";

    private BlockingQueue<MessageExt> eventMessage = new LinkedBlockingQueue(50000);

    @Value("rocketmq.namesrvAddr")
    private String namesrvAddr;

    public DefaultLitePullConsumer initDefaultMQPullConsumer() {
        DefaultLitePullConsumer consumer = new DefaultLitePullConsumer();
        consumer.setConsumerGroup(SYS_DEFAULT_CONSUME_GROUP);
        consumer.setNamesrvAddr(namesrvAddr);
        return consumer;
    }

    /**
     * Offer listener event
     * @param messageExts
     * @return
     */
    public boolean offerListenEvent(List<MessageExt> messageExts){
        if(CollectionUtils.isEmpty(messageExts)){
            return false;
        }
        messageExts.forEach(event->eventMessage.offer(event));
        return true;
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
}
