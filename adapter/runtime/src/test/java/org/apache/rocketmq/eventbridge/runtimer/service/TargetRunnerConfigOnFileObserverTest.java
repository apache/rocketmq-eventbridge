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

import java.time.Duration;
import org.apache.rocketmq.eventbridge.adapter.runtime.boot.common.TargetRunnerListener;
import org.apache.rocketmq.eventbridge.adapter.runtime.common.entity.TargetRunnerConfig;
import org.apache.rocketmq.eventbridge.adapter.runtime.service.TargetRunnerConfigOnFileObserver;
import org.junit.Assert;
import org.junit.Ignore;
import org.junit.Test;

import static org.apache.rocketmq.eventbridge.runtimer.service.TestConstants.DEMO_TARGET_RUNNER_CONFIG_FILE_NAME;
import static org.awaitility.Awaitility.await;

public class TargetRunnerConfigOnFileObserverTest {

    @Test
    @Ignore
    public void testGetLatestTargetRunnerConfig() {
        TargetRunnerConfigUtil.resetTargetRunner(getConfigFilePath());
        TargetRunnerConfigOnFileObserver targetRunnerConfigOnFileObserver = new TargetRunnerConfigOnFileObserver(getConfigFilePath());
        System.out.println(targetRunnerConfigOnFileObserver.getLatestTargetRunnerConfig());
        Assert.assertTrue(!targetRunnerConfigOnFileObserver.getLatestTargetRunnerConfig().stream().findFirst().get().getComponents().isEmpty());
    }

    @Test
    @Ignore
    public void testListen_Add() throws InterruptedException {
        String path = getConfigFilePath();
        TestTargetRunnerListener targetRunnerListener = initTargetRunnerConfigOnFileObserver(path);
        TargetRunnerConfigUtil.addTargetRunner(path);
        await().atMost(Duration.ofSeconds(60)).until(() -> {
            return targetRunnerListener.addTargetRunner && !targetRunnerListener.updateTargetRunner && !targetRunnerListener.deleteTargetRunner;
        });
    }

    @Test
    @Ignore
    public void testListen_Delete() throws InterruptedException {
        String path = getConfigFilePath();
        TestTargetRunnerListener targetRunnerListener = initTargetRunnerConfigOnFileObserver(path);
        TargetRunnerConfigUtil.deleteTargetRunner(path);
        await().atMost(Duration.ofSeconds(60)).until(() -> {
            return !targetRunnerListener.addTargetRunner && !targetRunnerListener.updateTargetRunner && targetRunnerListener.deleteTargetRunner;
        });
    }

    @Test
    @Ignore
    public void testListen_Update() throws InterruptedException {
        String path = getConfigFilePath();
        TestTargetRunnerListener targetRunnerListener = initTargetRunnerConfigOnFileObserver(path);
        TargetRunnerConfigUtil.updateTargetRunner(path);
        await().atMost(Duration.ofSeconds(60)).until(() -> {
            return !targetRunnerListener.addTargetRunner && targetRunnerListener.updateTargetRunner && !targetRunnerListener.deleteTargetRunner;
        });
    }

    private  TestTargetRunnerListener initTargetRunnerConfigOnFileObserver(String path) throws InterruptedException {
        TargetRunnerConfigUtil.resetTargetRunner(path);
        TargetRunnerConfigOnFileObserver targetRunnerConfigOnFileObserver = new TargetRunnerConfigOnFileObserver(path);
        TestTargetRunnerListener targetRunnerListener = new TestTargetRunnerListener();
        targetRunnerConfigOnFileObserver.registerListener(targetRunnerListener);
        Thread.sleep(3000L);
        return targetRunnerListener;
    }

    private String getConfigFilePath() {
        return this.getClass().getClassLoader().getResource(DEMO_TARGET_RUNNER_CONFIG_FILE_NAME).getPath();
    }

    class TestTargetRunnerListener implements TargetRunnerListener {
        boolean addTargetRunner = false;
        boolean updateTargetRunner = false;
        boolean deleteTargetRunner = false;

        @Override public void onAddTargetRunner(TargetRunnerConfig targetRunnerConfig) {
            System.out.println("watch target runner");
            this.addTargetRunner = true;
        }

        @Override public void onUpdateTargetRunner(TargetRunnerConfig targetRunnerConfig) {
            System.out.println("watch update runner");
            this.updateTargetRunner = true;
        }

        @Override public void onDeleteTargetRunner(TargetRunnerConfig targetRunnerConfig) {
            System.out.println("watch delete runner");
            this.deleteTargetRunner = true;
        }
    }
}