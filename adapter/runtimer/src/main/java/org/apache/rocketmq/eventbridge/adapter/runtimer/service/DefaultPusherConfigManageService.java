package org.apache.rocketmq.eventbridge.adapter.runtimer.service;

import com.google.common.collect.Lists;
import io.openmessaging.KeyValue;
import io.openmessaging.connector.api.component.connector.Connector;
import org.apache.rocketmq.eventbridge.adapter.runtimer.boot.listener.ListenerFactory;
import org.apache.rocketmq.eventbridge.adapter.runtimer.common.entity.PusherTargetEntity;
import org.apache.rocketmq.eventbridge.adapter.runtimer.common.entity.TargetKeyValue;
import org.apache.rocketmq.eventbridge.adapter.runtimer.common.FilePathConfigUtil;
import org.apache.rocketmq.eventbridge.adapter.runtimer.common.plugin.Plugin;
import org.apache.rocketmq.eventbridge.adapter.runtimer.common.store.FileBaseKeyValueStore;
import org.apache.rocketmq.eventbridge.adapter.runtimer.common.store.KeyValueStore;
import org.apache.rocketmq.eventbridge.adapter.runtimer.config.RuntimeConfigDefine;
import org.apache.rocketmq.eventbridge.adapter.runtimer.config.RuntimerConfig;
import org.apache.rocketmq.eventbridge.adapter.runtimer.converter.JsonConverter;
import org.apache.rocketmq.eventbridge.adapter.runtimer.converter.ListConverter;
import org.springframework.stereotype.Component;
import org.springframework.util.CollectionUtils;

import java.util.*;
import java.util.concurrent.CopyOnWriteArraySet;

@Component
public class DefaultPusherConfigManageService implements PusherConfigManageService {

    private Plugin plugin;

    private ListenerFactory listenerFactory;

    /**
     * Current connector configs in the store.
     */
    private KeyValueStore<String, TargetKeyValue> connectorKeyValueStore;

    /**
     * Current task configs in the store.
     */
    private KeyValueStore<String, List<TargetKeyValue>> taskKeyValueStore;

    private Set<String> connectTopicNames;

    public DefaultPusherConfigManageService(RuntimerConfig runtimerConfig, Plugin plugin, ListenerFactory listenerFactory){
        this.connectorKeyValueStore = new FileBaseKeyValueStore<>(
                FilePathConfigUtil.getConnectorConfigPath(runtimerConfig.getStorePathRootDir()),
                new JsonConverter(),
                new JsonConverter(TargetKeyValue.class));
        this.taskKeyValueStore = new FileBaseKeyValueStore<>(
                FilePathConfigUtil.getTaskConfigPath(runtimerConfig.getStorePathRootDir()),
                new JsonConverter(),
                new ListConverter(TargetKeyValue.class));
        this.connectTopicNames = new CopyOnWriteArraySet<>();
        this.plugin = plugin;
        this.listenerFactory = listenerFactory;
    }

    /**
     * get all connector configs enabled
     *
     * @return
     */
    @Override
    public Map<String, TargetKeyValue> getConnectorConfigs() {
        Map<String, TargetKeyValue> result = new HashMap<>();
        Map<String, TargetKeyValue> connectorConfigs = connectorKeyValueStore.getKVMap();
        for (String connectorName : connectorConfigs.keySet()) {
            TargetKeyValue config = connectorConfigs.get(connectorName);
            if (0 != config.getInt(RuntimeConfigDefine.CONFIG_DELETED)) {
                continue;
            }
            result.put(connectorName, config);
        }
        return result;
    }

    @Override
    public String putConnectTargetConfig(String connectorName, TargetKeyValue configs) throws Exception {
        TargetKeyValue exist = connectorKeyValueStore.get(connectorName);
        if (null != exist) {
            Long updateTimestamp = exist.getLong(RuntimeConfigDefine.UPDATE_TIMESTAMP);
            if (null != updateTimestamp) {
                configs.put(RuntimeConfigDefine.UPDATE_TIMESTAMP, updateTimestamp);
            }
        }
        if (configs.equals(exist)) {
            return "Connector with same config already exist.";
        }

        Long currentTimestamp = System.currentTimeMillis();
        configs.put(RuntimeConfigDefine.UPDATE_TIMESTAMP, currentTimestamp);
        for (String requireConfig : RuntimeConfigDefine.REQUEST_CONFIG) {
            if (!configs.containsKey(requireConfig)) {
                return "Request config key: " + requireConfig;
            }
        }

        String connectorClass = configs.getString(RuntimeConfigDefine.CONNECTOR_CLASS);
        ClassLoader classLoader = plugin.getPluginClassLoader(connectorClass);
        Class clazz;
        if (null != classLoader) {
            clazz = Class.forName(connectorClass, true, classLoader);
        } else {
            clazz = Class.forName(connectorClass);
        }
        final Connector connector = (Connector) clazz.getDeclaredConstructor().newInstance();
        connector.validate(configs);
        connector.init(configs);
        connectorKeyValueStore.put(connectorName, configs);
        recomputeTaskConfigs(connectorName, connector, currentTimestamp, configs);
        return "";
    }

    @Override
    public void recomputeTaskConfigs(String connectorName, Connector connector, Long currentTimestamp, TargetKeyValue configs) {
        int maxTask = configs.getInt(RuntimeConfigDefine.MAX_TASK, 1);
        List<KeyValue> taskConfigs = connector.taskConfigs(maxTask);
        List<TargetKeyValue> converterdConfigs = new ArrayList<>();
        for (KeyValue keyValue : taskConfigs) {
            TargetKeyValue newKeyValue = new TargetKeyValue();
            for (String key : keyValue.keySet()) {
                newKeyValue.put(key, keyValue.getString(key));
            }
            newKeyValue.put(RuntimeConfigDefine.TASK_CLASS, connector.taskClass().getName());
            newKeyValue.put(RuntimeConfigDefine.UPDATE_TIMESTAMP, currentTimestamp);

            newKeyValue.put(RuntimeConfigDefine.CONNECT_TOPICNAME, configs.getString(RuntimeConfigDefine.CONNECT_TOPICNAME));
            newKeyValue.put(RuntimeConfigDefine.CONNECT_TOPICNAMES, configs.getString(RuntimeConfigDefine.CONNECT_TOPICNAMES));
            Set<String> connectConfigKeySet = configs.keySet();
            for (String connectConfigKey : connectConfigKeySet) {
                if (connectConfigKey.startsWith(RuntimeConfigDefine.TRANSFORMS)) {
                    newKeyValue.put(connectConfigKey, configs.getString(connectConfigKey));
                }
            }
            converterdConfigs.add(newKeyValue);
            connectTopicNames.add(configs.getString(RuntimeConfigDefine.CONNECT_TOPICNAME));
        }
        putTaskConfigs(connectorName, converterdConfigs);
    }

    @Override
    public void removeConnectorConfig(String connectorName) {
        TargetKeyValue config = connectorKeyValueStore.get(connectorName);
        config.put(RuntimeConfigDefine.UPDATE_TIMESTAMP, System.currentTimeMillis());
        config.put(RuntimeConfigDefine.CONFIG_DELETED, 1);
        List<TargetKeyValue> taskConfigList = taskKeyValueStore.get(connectorName);
        taskConfigList.add(config);
        connectorKeyValueStore.put(connectorName, config);
        putTaskConfigs(connectorName, taskConfigList);
    }

    @Override
    public Map<String, List<TargetKeyValue>> getTaskConfigs() {
        Map<String, List<TargetKeyValue>> result = new HashMap<>();
        Map<String, List<TargetKeyValue>> taskConfigs = taskKeyValueStore.getKVMap();
        Map<String, TargetKeyValue> filteredConnector = getConnectorConfigs();
        for (String connectorName : taskConfigs.keySet()) {
            if (!filteredConnector.containsKey(connectorName)) {
                continue;
            }
            result.put(connectorName, taskConfigs.get(connectorName));
        }
        return result;
    }

    @Override
    public Set<PusherTargetEntity> getTargetInfo() {
        Set<PusherTargetEntity> result = new HashSet<>();
        Map<String, List<TargetKeyValue>> taskConfigs = taskKeyValueStore.getKVMap();
        Map<String, TargetKeyValue> filteredConnector = getConnectorConfigs();
        for (String connectorName : taskConfigs.keySet()) {
            if (!filteredConnector.containsKey(connectorName)) {
                continue;
            }
            PusherTargetEntity targetEntity = new PusherTargetEntity();
            targetEntity.setConnectName(connectorName);
            targetEntity.setTargetKeyValues(taskConfigs.get(connectorName));
            result.add(targetEntity);
        }
        return result;
    }

    @Override
    public List<String> getConnectTopics(){
        if(CollectionUtils.isEmpty(connectTopicNames)){
            return Lists.newArrayList();
        }
        return Lists.newArrayList(connectTopicNames);
    }


    private void putTaskConfigs(String connectorName, List<TargetKeyValue> configs) {
        List<TargetKeyValue> exist = taskKeyValueStore.get(connectorName);
        if (null != exist && exist.size() > 0) {
            taskKeyValueStore.remove(connectorName);
        }
        taskKeyValueStore.put(connectorName, configs);
        PusherTargetEntity targetEntity = new PusherTargetEntity();
        targetEntity.setConnectName(connectorName);
        targetEntity.setTargetKeyValues(configs);
        listenerFactory.offerTaskConfig(targetEntity);
    }

}
