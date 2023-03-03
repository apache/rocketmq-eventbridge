package org.apache.rocketmq.eventbridge.adapter.runtimer.service;

import com.google.common.collect.Lists;
import io.openmessaging.KeyValue;
import io.openmessaging.connector.api.component.connector.Connector;
import org.apache.rocketmq.eventbridge.adapter.runtimer.common.ConnectKeyValue;
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

@Component
public class DefaultPusherConfigManageService implements PusherConfigManageService {

    private final Plugin plugin;

    /**
     * Current connector configs in the store.
     */
    private KeyValueStore<String, ConnectKeyValue> connectorKeyValueStore;

    /**
     * Current task configs in the store.
     */
    private KeyValueStore<String, List<ConnectKeyValue>> taskKeyValueStore;

    private Set<String> connectTopicNames;

    public DefaultPusherConfigManageService(RuntimerConfig runtimerConfig, Plugin plugin){
        this.connectorKeyValueStore = new FileBaseKeyValueStore<>(
                FilePathConfigUtil.getConnectorConfigPath(runtimerConfig.getStorePathRootDir()),
                new JsonConverter(),
                new JsonConverter(ConnectKeyValue.class));
        this.taskKeyValueStore = new FileBaseKeyValueStore<>(
                FilePathConfigUtil.getTaskConfigPath(runtimerConfig.getStorePathRootDir()),
                new JsonConverter(),
                new ListConverter(ConnectKeyValue.class));
        this.plugin = plugin;
    }

    /**
     * get all connector configs enabled
     *
     * @return
     */
    @Override
    public Map<String, ConnectKeyValue> getConnectorConfigs() {
        Map<String, ConnectKeyValue> result = new HashMap<>();
        Map<String, ConnectKeyValue> connectorConfigs = connectorKeyValueStore.getKVMap();
        for (String connectorName : connectorConfigs.keySet()) {
            ConnectKeyValue config = connectorConfigs.get(connectorName);
            if (0 != config.getInt(RuntimeConfigDefine.CONFIG_DELETED)) {
                continue;
            }
            result.put(connectorName, config);
        }
        return result;
    }

    @Override
    public String putConnectorConfig(String connectorName, ConnectKeyValue configs) throws Exception {
        ConnectKeyValue exist = connectorKeyValueStore.get(connectorName);
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
    public void recomputeTaskConfigs(String connectorName, Connector connector, Long currentTimestamp, ConnectKeyValue configs) {
        int maxTask = configs.getInt(RuntimeConfigDefine.MAX_TASK, 1);
        List<KeyValue> taskConfigs = connector.taskConfigs(maxTask);
        List<ConnectKeyValue> converterdConfigs = new ArrayList<>();
        for (KeyValue keyValue : taskConfigs) {
            ConnectKeyValue newKeyValue = new ConnectKeyValue();
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
        ConnectKeyValue config = connectorKeyValueStore.get(connectorName);
        config.put(RuntimeConfigDefine.UPDATE_TIMESTAMP, System.currentTimeMillis());
        config.put(RuntimeConfigDefine.CONFIG_DELETED, 1);
        List<ConnectKeyValue> taskConfigList = taskKeyValueStore.get(connectorName);
        taskConfigList.add(config);
        connectorKeyValueStore.put(connectorName, config);
        putTaskConfigs(connectorName, taskConfigList);
    }

    @Override
    public Map<String, List<ConnectKeyValue>> getTaskConfigs() {
        Map<String, List<ConnectKeyValue>> result = new HashMap<>();
        Map<String, List<ConnectKeyValue>> taskConfigs = taskKeyValueStore.getKVMap();
        Map<String, ConnectKeyValue> filteredConnector = getConnectorConfigs();
        for (String connectorName : taskConfigs.keySet()) {
            if (!filteredConnector.containsKey(connectorName)) {
                continue;
            }
            result.put(connectorName, taskConfigs.get(connectorName));
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

    private void putTaskConfigs(String connectorName, List<ConnectKeyValue> configs) {
        List<ConnectKeyValue> exist = taskKeyValueStore.get(connectorName);
        if (null != exist && exist.size() > 0) {
            taskKeyValueStore.remove(connectorName);
        }
        taskKeyValueStore.put(connectorName, configs);
    }

}
