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

package org.apache.rocketmq.eventbridge.adapter.runtimer.boot.transfer;

import com.alibaba.fastjson.JSON;
import com.google.common.base.Splitter;
import io.openmessaging.KeyValue;
import io.openmessaging.connector.api.component.Transform;
import io.openmessaging.connector.api.data.ConnectRecord;
import io.openmessaging.internal.DefaultKeyValue;
import java.util.Map;
import org.apache.commons.collections.CollectionUtils;
import org.apache.commons.lang3.StringUtils;
import org.apache.rocketmq.eventbridge.adapter.runtimer.common.LoggerName;
import org.apache.rocketmq.eventbridge.adapter.runtimer.common.plugin.Plugin;
import org.apache.rocketmq.eventbridge.adapter.runtimer.common.plugin.PluginClassLoader;
import org.apache.rocketmq.eventbridge.adapter.runtimer.config.RuntimerConfigDefine;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;
import java.util.Set;

public class TransformEngine<R extends ConnectRecord> implements AutoCloseable {

    private static final Logger log = LoggerFactory.getLogger(LoggerName.EventBridge_RUNTIMER);

    private final List<Transform> transformList;

    private Map<String,List<Transform>> transformListMap;

    private final KeyValue config;

    private final Plugin plugin;

    private static final String COMMA = ",";

    private static final String PREFIX = RuntimerConfigDefine.TRANSFORMS + "-";

    public TransformEngine(KeyValue config, Plugin plugin) {
        this.config = config;
        this.plugin = plugin;
        transformList = new ArrayList<>(8);
        init();
    }

    private void init() {
        String transformsStr = config.getString(RuntimerConfigDefine.TRANSFORMS);
        if (StringUtils.isBlank(transformsStr)) {
            log.warn("no transforms config, {}", JSON.toJSONString(config));
            return;
        }
        List<String> transformList = Splitter.on(COMMA).omitEmptyStrings().trimResults().splitToList(transformsStr);
        if (CollectionUtils.isEmpty(transformList)) {
            log.warn("transforms config is null, {}", JSON.toJSONString(config));
            return;
        }
        transformList.stream().forEach(transformStr -> {
            String transformClassKey = PREFIX + transformStr + "-class";
            String transformClass = config.getString(transformClassKey);
            try {
                Transform transform = getTransform(transformClass);
                KeyValue transformConfig = new DefaultKeyValue();
                Set<String> configKeys = config.keySet();
                for (String key : configKeys) {
                    if (key.startsWith(PREFIX + transformStr) && !key.equals(transformClassKey)) {
                        String originKey = key.replace(PREFIX + transformStr + "-", "");
                        transformConfig.put(originKey, config.getString(key));
                    }
                }
                transform.validate(transformConfig);
                transform.init(transformConfig);
                this.transformList.add(transform);
            } catch (Exception e) {
                log.error("transform new instance error", e);
            }
        });
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
