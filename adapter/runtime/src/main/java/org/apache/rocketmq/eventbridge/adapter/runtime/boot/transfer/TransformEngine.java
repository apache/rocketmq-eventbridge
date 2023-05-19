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
 *  Unless required by applicable law or agreed to in writing, software
 *  distributed under the License is distributed on an "AS IS" BASIS,
 *  WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 *  See the License for the specific language governing permissions and
 *  limitations under the License.
 */

package org.apache.rocketmq.eventbridge.adapter.runtime.boot.transfer;

import io.openmessaging.KeyValue;
import io.openmessaging.connector.api.component.Transform;
import io.openmessaging.connector.api.data.ConnectRecord;
import io.openmessaging.internal.DefaultKeyValue;
import org.apache.commons.collections.CollectionUtils;
import org.apache.rocketmq.eventbridge.adapter.runtime.common.LoggerName;
import org.apache.rocketmq.eventbridge.adapter.runtime.common.entity.TargetKeyValue;
import org.apache.rocketmq.eventbridge.adapter.runtime.common.plugin.Plugin;
import org.apache.rocketmq.eventbridge.adapter.runtime.common.plugin.PluginClassLoader;
import org.apache.rocketmq.eventbridge.adapter.runtime.config.RuntimeConfigDefine;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.Objects;

public class TransformEngine<R extends ConnectRecord> implements AutoCloseable {

    private static final Logger logger = LoggerFactory.getLogger(LoggerName.EventRule_Transfer);

    private final List<Transform> transformList;

    private List<Map<String, String>> transferConfigs;

    private final KeyValue config;

    private final Plugin plugin;

    private static final String COMMA = ",";

    private static final String PREFIX = RuntimeConfigDefine.TRANSFORMS + "-";

    public TransformEngine(List<Map<String, String>> transferConfigs, Plugin plugin) {
        this.transferConfigs = transferConfigs;
        this.config = formatTargetKey(transferConfigs);
        this.plugin = plugin;
        transformList = new ArrayList<>(8);
        init();
    }

    private void init() {
        int endIndex = transferConfigs.size() - 1;
        for (int index = 1; index < endIndex; index++) {
            Map<String, String> transferMap = transferConfigs.get(index);
            String transformClass = transferMap.get(RuntimeConfigDefine.RUNNER_CLASS);
            try {
                Transform transform = getTransform(transformClass);
                KeyValue transformConfig = new DefaultKeyValue();
                for (String key : transferMap.keySet()) {
                    if (!key.equals(RuntimeConfigDefine.RUNNER_CLASS)) {
                        transformConfig.put(key, transferMap.get(key));
                    }
                }
                transform.validate(transformConfig);
                transform.init(transformConfig);
                this.transformList.add(transform);
            } catch (Exception e) {
                logger.error("transform new instance error", e);
            }
        }
    }

    /**
     * format listener and pusher key
     * @param components
     * @return
     */
    private TargetKeyValue formatTargetKey(List<Map<String, String>> components) {
        if(CollectionUtils.isEmpty(components)){
            return null;
        }
        int startIndex = 0;
        int endIndex = components.size() - 1;
        // init listener key
        TargetKeyValue targetKeyValue = new TargetKeyValue(components.get(startIndex));
        // init pusher key
        targetKeyValue.put(RuntimeConfigDefine.TASK_CLASS, components.get(endIndex).get(RuntimeConfigDefine.RUNNER_CLASS));
        return targetKeyValue;
    }

    /**
     * transform event record for target record
     * @param connectRecord
     * @return
     */
    public R doTransforms(R connectRecord) {
        if (transformList.size() == 0) {
            return connectRecord;
        }
        for (final Transform<R> transform : transformList) {
            final R currentRecord = connectRecord;
            connectRecord = transform.doTransform(currentRecord);
            if (connectRecord == null) {
                break;
            }
        }
        return connectRecord;
    }

    /**
     * get task config value by key
     * @param configKey
     * @return
     */
    public String getConnectConfig(String configKey){
        return config.getString(configKey);
    }

    private Transform getTransform(String transformClass) throws Exception {
        ClassLoader loader = plugin.getPluginClassLoader(transformClass);
        final ClassLoader currentThreadLoader = plugin.currentThreadLoader();
        Class transformClazz;
        boolean isolationFlag = false;
        if (loader instanceof PluginClassLoader) {
            transformClazz = ((PluginClassLoader) loader).loadClass(transformClass, false);
            isolationFlag = true;
        } else {
            transformClazz = Class.forName(transformClass);
        }
        final Transform transform = (Transform) transformClazz.getDeclaredConstructor().newInstance();
        if (isolationFlag) {
            Plugin.compareAndSwapLoaders(loader);
        }

        Plugin.compareAndSwapLoaders(currentThreadLoader);
        return transform;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        TransformEngine<?> that = (TransformEngine<?>) o;
        return transformList.equals(that.transformList) && config.equals(that.config);
    }

    @Override
    public int hashCode() {
        return Objects.hash(transformList, config);
    }

    /**
     * close transforms
     *
     * @throws Exception if this resource cannot be closed
     */
    @Override
    public void close() throws Exception {
        for (Transform transform : transformList) {
            transform.stop();
        }
    }
}
