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

package org.apache.rocketmq.eventbridge.adapter.runtimer.service;

import com.google.common.collect.Maps;
import com.google.common.reflect.TypeToken;
import com.google.gson.Gson;
import java.io.File;
import java.io.IOException;
import java.lang.reflect.Type;
import java.nio.file.FileSystems;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.nio.file.StandardWatchEventKinds;
import java.nio.file.WatchKey;
import java.nio.file.WatchService;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;
import java.util.concurrent.Executors;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.TimeUnit;
import lombok.extern.slf4j.Slf4j;
import org.apache.commons.io.FileUtils;
import org.apache.rocketmq.common.utils.ThreadUtils;
import org.apache.rocketmq.eventbridge.adapter.runtimer.common.entity.TargetRunnerConfig;
import org.apache.rocketmq.eventbridge.exception.EventBridgeException;

@Slf4j
public class TargetRunnerConfigOnFileObserver extends AbstractTargetRunnerConfigObserver {

    private String pathName;

    private static ScheduledExecutorService service = Executors.newSingleThreadScheduledExecutor(
        ThreadUtils.newThreadFactory("TargetRunnerConfigOnFileObserver", false));

    public TargetRunnerConfigOnFileObserver(String pathName) {
        this.pathName = pathName;
        super.getTargetRunnerConfig().addAll(getLatestTargetRunnerConfig());
        this.addListen(pathName, this);
    }

    public TargetRunnerConfigOnFileObserver() {
        super.getTargetRunnerConfig().addAll(getLatestTargetRunnerConfig());
        this.addListen(pathName, this);
    }

    @Override
    public Set<TargetRunnerConfig> getLatestTargetRunnerConfig() {
        String config = null;
        try {
            File file = new File(pathName);
            config = FileUtils.readFileToString(file, "UTF-8");
            Type workerConfigType = new TypeToken<HashSet<TargetRunnerConfig>>() {
            }.getType();
            Set<TargetRunnerConfig> taskConfigList = new Gson().fromJson(config, workerConfigType);
            return taskConfigList;
        } catch (IOException e) {
            throw new EventBridgeException("Load component properties failed.", e);
        } catch (Throwable e) {
            log.error("fail to parse config={} from file={}", config, pathName);
            throw e;
        }
    }

    public void addListen(String pathName,
        TargetRunnerConfigOnFileObserver pusherConfigOnFileService) {
        log.info("Watching task file changing:{}", pathName);
        int index = pathName.lastIndexOf("/");
        String filePath = pathName.substring(0, index);
        String fileName = pathName.substring(index + 1);
        service.scheduleAtFixedRate(() -> {
            try {
                WatchService watchService = FileSystems.getDefault()
                    .newWatchService();
                Path path = Paths.get(filePath);
                path.register(watchService, StandardWatchEventKinds.ENTRY_CREATE, StandardWatchEventKinds.ENTRY_DELETE,
                    StandardWatchEventKinds.ENTRY_MODIFY);
                WatchKey watchKey;
                while (true) {
                    watchKey = watchService.take();
                    if (watchKey != null && !watchKey.pollEvents()
                        .isEmpty()) {
                        log.info("Watched the file changed events.");
                        pusherConfigOnFileService.diff();
                    }
                    watchKey.reset();
                }
            } catch (Throwable e) {
                log.error("Watch file failed.", e);
            }
        }, 0, 3, TimeUnit.SECONDS);
    }

    public void diff() {
        Map<String, TargetRunnerConfig> lastMap = toMap(super.getTargetRunnerConfig());
        Map<String, TargetRunnerConfig> latestMap = toMap(this.getLatestTargetRunnerConfig());
        lastMap.entrySet().forEach(entry -> {
            TargetRunnerConfig latest = latestMap.get(entry.getKey());
            if (latest == null) {
                super.onDeleteTargetRunner(entry.getValue());
            } else if (!latest.equals(entry.getValue())) {
                super.onUpdateTargetRunner(entry.getValue());
            }
        });

        latestMap.entrySet().forEach(entry -> {
            TargetRunnerConfig latest = lastMap.get(entry.getKey());
            if (latest == null) {
                super.onAddTargetRunner(entry.getValue());
            }
        });
    }

    private Map<String, TargetRunnerConfig> toMap(Set<TargetRunnerConfig> targetRunnerConfigs) {
        if (targetRunnerConfigs == null || targetRunnerConfigs.isEmpty()) {
            return Maps.newHashMapWithExpectedSize(0);
        }
        Map<String, TargetRunnerConfig> map = Maps.newHashMap();
        targetRunnerConfigs.forEach(entry -> map.put(entry.getName(), entry));
        return map;
    }

}