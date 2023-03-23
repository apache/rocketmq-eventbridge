package org.apache.rocketmq.eventbridge.runtimer.service;

import java.time.Duration;
import org.apache.rocketmq.eventbridge.adapter.runtimer.boot.listener.TargetRunnerListener;
import org.apache.rocketmq.eventbridge.adapter.runtimer.common.entity.TargetRunnerConfig;
import org.apache.rocketmq.eventbridge.adapter.runtimer.service.TargetRunnerConfigOnFileObserver;
import org.junit.Assert;
import org.junit.Test;

import static org.apache.rocketmq.eventbridge.runtimer.service.TestConstants.DEMO_TARGET_RUNNER_CONFIG_FILE_NAME;
import static org.awaitility.Awaitility.await;

public class TargetRunnerConfigOnFileObserverTest {

    @Test
    public void testGetLatestTargetRunnerConfig() {
        TargetRunnerConfigOnFileObserver targetRunnerConfigOnFileObserver = new TargetRunnerConfigOnFileObserver(getConfigFilePath());
        System.out.println(targetRunnerConfigOnFileObserver.getLatestTargetRunnerConfig());
        Assert.assertTrue(!targetRunnerConfigOnFileObserver.getLatestTargetRunnerConfig().stream().findFirst().get().getComponents().isEmpty());
    }

    @Test
    public void testListen_Add() throws InterruptedException {
        String path = getConfigFilePath();
        TargetRunnerConfigUtil.resetTargetRunner(path);

        TargetRunnerConfigOnFileObserver targetRunnerConfigOnFileObserver = new TargetRunnerConfigOnFileObserver(path);
        TestTargetRunnerListener targetRunnerListener = new TestTargetRunnerListener();
        targetRunnerConfigOnFileObserver.registerListener(targetRunnerListener);

        Thread.sleep(3000L);
        TargetRunnerConfigUtil.addTargetRunner(path);
        await().atMost(Duration.ofSeconds(10)).until(() -> {
            return targetRunnerListener.addTargetRunner && !targetRunnerListener.updateTargetRunner && !targetRunnerListener.deleteTargetRunner;
        });
    }

    @Test
    public void testListen_Delete() throws InterruptedException {
        String path = getConfigFilePath();
        TargetRunnerConfigUtil.resetTargetRunner(path);

        TargetRunnerConfigOnFileObserver targetRunnerConfigOnFileObserver = new TargetRunnerConfigOnFileObserver(path);
        TestTargetRunnerListener targetRunnerListener = new TestTargetRunnerListener();
        targetRunnerConfigOnFileObserver.registerListener(targetRunnerListener);

        Thread.sleep(3000L);
        TargetRunnerConfigUtil.deleteTargetRunner(path);
        await().atMost(Duration.ofSeconds(10)).until(() -> {
            return !targetRunnerListener.addTargetRunner && !targetRunnerListener.updateTargetRunner && targetRunnerListener.deleteTargetRunner;
        });
    }

    @Test
    public void testListen_Update() throws InterruptedException {
        String path = getConfigFilePath();
        TargetRunnerConfigUtil.resetTargetRunner(path);

        TargetRunnerConfigOnFileObserver targetRunnerConfigOnFileObserver = new TargetRunnerConfigOnFileObserver(path);
        TestTargetRunnerListener targetRunnerListener = new TestTargetRunnerListener();
        targetRunnerConfigOnFileObserver.registerListener(targetRunnerListener);

        Thread.sleep(3000L);
        TargetRunnerConfigUtil.updateTargetRunner(path);
        await().atMost(Duration.ofSeconds(10)).until(() -> {
            return !targetRunnerListener.addTargetRunner && targetRunnerListener.updateTargetRunner && !targetRunnerListener.deleteTargetRunner;
        });
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