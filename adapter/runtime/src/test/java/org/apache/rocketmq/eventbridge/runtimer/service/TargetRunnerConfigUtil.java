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
package org.apache.rocketmq.eventbridge.runtimer.service;

import com.google.common.collect.Lists;
import com.google.common.collect.Maps;
import com.google.common.collect.Sets;
import com.google.common.reflect.TypeToken;
import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.lang.reflect.Type;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.UUID;
import org.apache.commons.io.FileUtils;
import org.apache.rocketmq.eventbridge.adapter.runtime.common.entity.TargetRunnerConfig;
import org.apache.rocketmq.eventbridge.exception.EventBridgeException;

import static org.apache.rocketmq.eventbridge.runtimer.service.TestConstants.DEMO_TARGET_RUNNER_NAME;

public class TargetRunnerConfigUtil {
    /**
     * add target runner
     *
     * @param path
     */

    public static void addTargetRunner(String path) {
        Set<TargetRunnerConfig> latest = getLatest(path);
        latest.add(buildNewTargetRunnerConfig());
        persistenceToFile(path, latest);
    }

    /**
     * update target runner
     *
     * @param path
     */
    public static void updateTargetRunner(String path) {
        Set<TargetRunnerConfig> latest = getLatest(path);
        latest.stream().findFirst().get().getComponents().get(0).put("newKey", "newValue");
        persistenceToFile(path, latest);
    }

    /**
     * update target runner
     *
     * @param path
     */
    public static void deleteTargetRunner(String path) {
        persistenceToFile(path, Sets.newHashSet());
    }

    /**
     * delete target runner
     *
     * @param path
     */
    public static void resetTargetRunner(String path) {
        TargetRunnerConfig targetRunnerConfig = buildNewTargetRunnerConfig(DEMO_TARGET_RUNNER_NAME);
        try {
            BufferedWriter out = new BufferedWriter(new FileWriter(path));
            out.write(new GsonBuilder().setPrettyPrinting().create().toJson(Lists.newArrayList(targetRunnerConfig)));
            out.close();
        } catch (IOException e) {
            throw new EventBridgeException("Load component properties failed.", e);
        } catch (Throwable e) {
            throw e;
        }
    }

    public static Set<TargetRunnerConfig> getLatest(String path) {
        String config = null;
        try {
            File file = new File(path);
            config = FileUtils.readFileToString(file, "UTF-8");
        } catch (Throwable e) {
            e.printStackTrace();
        }
        Type workerConfigType = new TypeToken<HashSet<TargetRunnerConfig>>() {
        }.getType();
        return new Gson().fromJson(config, workerConfigType);
    }

    private static void persistenceToFile(String path, Set<TargetRunnerConfig> taskConfigList) {
        try {
            BufferedWriter out = new BufferedWriter(new FileWriter(path));
            out.write(new GsonBuilder().setPrettyPrinting().create().toJson(taskConfigList));
            out.close();
        } catch (IOException e) {
            throw new EventBridgeException("Load component properties failed.", e);
        } catch (Throwable e) {
            throw e;
        }
    }

    private static TargetRunnerConfig buildNewTargetRunnerConfig(String name) {
        TargetRunnerConfig targetRunnerConfig = new TargetRunnerConfig();
        targetRunnerConfig.setName(name);
        List<Map<String, String>> components = Lists.newArrayList();
        Map<String, String> component = Maps.newHashMap();
        component.put("K1", UUID.randomUUID().toString());
        components.add(component);
        targetRunnerConfig.setComponents(components);
        return targetRunnerConfig;
    }

    private static TargetRunnerConfig buildNewTargetRunnerConfig() {
        return buildNewTargetRunnerConfig(UUID.randomUUID().toString());
    }

}