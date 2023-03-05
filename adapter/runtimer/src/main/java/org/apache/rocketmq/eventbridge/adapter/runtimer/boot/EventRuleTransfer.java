package org.apache.rocketmq.eventbridge.adapter.runtimer.boot;

import com.alibaba.fastjson.JSON;
import io.openmessaging.KeyValue;
import io.openmessaging.connector.api.data.ConnectRecord;
import io.openmessaging.connector.api.data.RecordOffset;
import io.openmessaging.connector.api.data.RecordPartition;
import io.openmessaging.connector.api.data.Schema;
import io.openmessaging.internal.DefaultKeyValue;
import org.apache.commons.collections.MapUtils;
import org.apache.commons.lang3.StringUtils;
import org.apache.rocketmq.common.message.MessageExt;
import org.apache.rocketmq.eventbridge.adapter.runtimer.boot.listener.ListenerFactory;
import org.apache.rocketmq.eventbridge.adapter.runtimer.boot.transfer.TransformEngine;
import org.apache.rocketmq.eventbridge.adapter.runtimer.common.ConnectKeyValue;
import org.apache.rocketmq.eventbridge.adapter.runtimer.common.ServiceThread;
import org.apache.rocketmq.eventbridge.adapter.runtimer.common.plugin.Plugin;
import org.apache.rocketmq.eventbridge.adapter.runtimer.config.RuntimeConfigDefine;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.nio.charset.StandardCharsets;
import java.util.*;
import java.util.concurrent.*;

/**
 * receive event and transfer the rule to pusher
 */
public class EventRuleTransfer extends ServiceThread {

    private static final Logger logger = LoggerFactory.getLogger(EventRuleTransfer.class);

    private ListenerFactory listenerFactory;

    private Plugin plugin;

    Map<ConnectKeyValue/*taskConfig*/, TransformEngine<ConnectRecord>/*taskTransform*/> taskTransformMap = new ConcurrentHashMap<>(20);

    private ExecutorService executorService = new ThreadPoolExecutor(20,60, 1000,TimeUnit.MICROSECONDS, new LinkedBlockingDeque<>(100));

    public EventRuleTransfer(Plugin plugin, ListenerFactory listenerFactory){
        this.plugin = plugin;
        this.listenerFactory = listenerFactory;
    }

    public void initOrUpdateTaskTransform(Map<String, List<ConnectKeyValue>> taskConfig){
        this.taskTransformMap.putAll(initSinkTaskTransformInfo(taskConfig));
    }

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

    @Override
    public String getServiceName() {
        return this.getClass().getSimpleName();
    }

    @Override
    public void run() {
        while (!stopped){
            MessageExt messageExt = listenerFactory.takeListenerEvent();
            if(Objects.isNull(messageExt)){
                continue;
            }
            executorService.submit(() -> {
                ConnectRecord connectRecord = convertToSinkDataEntry(messageExt);
                for (ConnectKeyValue connectKeyValue : taskTransformMap.keySet()){
                    TransformEngine<ConnectRecord> transformEngine = taskTransformMap.get(connectKeyValue);
                    ConnectRecord transformRecord = transformEngine.doTransforms(connectRecord);
                    if(Objects.isNull(transformRecord)){
                        continue;
                    }
                    Map<ConnectKeyValue,ConnectRecord> targetMap = new HashMap<>();
                    targetMap.put(connectKeyValue, transformRecord);
                    listenerFactory.offerTargetTaskQueue(targetMap);
                }
            });
        }
    }

    /**
     * Init sink task transform map
     * key: task config
     * value: transformEngine
     * @param taskConfig
     * @return
     */
    private Map<ConnectKeyValue, TransformEngine<ConnectRecord>> initSinkTaskTransformInfo(Map<String, List<ConnectKeyValue>> taskConfig) {
        Map<ConnectKeyValue, TransformEngine<ConnectRecord>> curTaskTransformMap = new HashMap<>();
        Set<ConnectKeyValue> allTaskKeySet = new HashSet<>();
        for(String connectName : taskConfig.keySet()){
            List<ConnectKeyValue> taskKeyList = taskConfig.get(connectName);
            allTaskKeySet.addAll(new HashSet<>(taskKeyList));
        }
        for(ConnectKeyValue keyValue : allTaskKeySet){
            TransformEngine<ConnectRecord> transformChain = new TransformEngine<>(keyValue, plugin);
            curTaskTransformMap.put(keyValue, transformChain);
        }
        return curTaskTransformMap;
    }

    /**
     * MessageExt convert to connect record
     * @param message
     * @return
     */
    private ConnectRecord convertToSinkDataEntry(MessageExt message) {
        Map<String, String> properties = message.getProperties();
        Schema schema;
        Long timestamp;
        ConnectRecord sinkDataEntry;
        String connectTimestamp = properties.get(RuntimeConfigDefine.CONNECT_TIMESTAMP);
        timestamp = StringUtils.isNotEmpty(connectTimestamp) ? Long.valueOf(connectTimestamp) : null;
        String connectSchema = properties.get(RuntimeConfigDefine.CONNECT_SCHEMA);
        schema = StringUtils.isNotEmpty(connectSchema) ? JSON.parseObject(connectSchema, Schema.class) : null;
        byte[] body = message.getBody();
        RecordPartition recordPartition = listenerFactory.convertToRecordPartition(message.getTopic(), message.getBrokerName(), message.getQueueId());
        RecordOffset recordOffset = listenerFactory.convertToRecordOffset(message.getQueueOffset());
        String bodyStr = new String(body, StandardCharsets.UTF_8);
        sinkDataEntry = new ConnectRecord(recordPartition, recordOffset, timestamp, schema, bodyStr);
        KeyValue keyValue = new DefaultKeyValue();
        if (MapUtils.isNotEmpty(properties)) {
            for (Map.Entry<String, String> entry : properties.entrySet()) {
                if (MQ_SYS_KEYS.contains(entry.getKey())) {
                    keyValue.put("MQ-SYS-" + entry.getKey(), entry.getValue());
                } else if (entry.getKey().startsWith("connect-ext-")) {
                    keyValue.put(entry.getKey().replaceAll("connect-ext-", ""), entry.getValue());
                } else {
                    keyValue.put(entry.getKey(), entry.getValue());
                }
            }
        }
        sinkDataEntry.addExtension(keyValue);
        return sinkDataEntry;
    }
}
