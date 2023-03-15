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

import java.nio.file.FileSystems;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.nio.file.StandardWatchEventKinds;
import java.nio.file.WatchKey;
import java.nio.file.WatchService;
import java.util.Set;
import java.util.concurrent.Executors;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.TimeUnit;
import lombok.extern.slf4j.Slf4j;
import org.apache.rocketmq.common.utils.ThreadUtils;
import org.apache.rocketmq.eventbridge.adapter.runtimer.common.entity.TargetRunnerConfig;
import org.apache.rocketmq.eventbridge.adapter.runtimer.common.plugin.Plugin;
import org.springframework.beans.factory.annotation.Value;

@Slf4j
public class TargetRunnerConfigOnFileObserver extends AbstractTargetRunnerConfigObserver {

    @Value("${runtimer.storePathRootDir:}")
    private String storeRootPath;

    @Value("${runtimer.store.targetRunner.config:targetRunner-config}")
    private String fileName;

    private static ScheduledExecutorService service = Executors.newSingleThreadScheduledExecutor(
        ThreadUtils.newThreadFactory("TargetRunnerConfigOnFileObserver", false));

    public TargetRunnerConfigOnFileObserver(Plugin plugin) {
        this.addListen(storeRootPath, fileName, this);
    }

    @Override
    public Set<TargetRunnerConfig> getLatestTargetRunnerConfig() {
        return null;
    }

    public void addListen(String pathStr, String fileName,
        TargetRunnerConfigOnFileObserver pusherConfigOnFileService) {
        log.info("Watching task file changing:{}", pathStr + fileName);
        service.scheduleAtFixedRate(() -> {
            try {
                WatchService watchService = FileSystems.getDefault()
                    .newWatchService();
                Path path = Paths.get(pathStr);
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
        Set<TargetRunnerConfig> latest = this.getLatestTargetRunnerConfig();
        Set<TargetRunnerConfig> last = super.getTargetRunnerConfig();
        TargetRunnerConfig changed = null;
        super.onAddTargetRunner(changed);
        super.onUpdateTargetRunner(changed);
        super.onDeleteTargetRunner(changed);
    }

}