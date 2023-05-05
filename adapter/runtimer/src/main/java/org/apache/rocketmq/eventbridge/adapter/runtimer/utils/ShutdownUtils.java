package org.apache.rocketmq.eventbridge.adapter.runtimer.utils;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.List;
import java.util.concurrent.CompletableFuture;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.TimeUnit;

public class ShutdownUtils {

    private static final Logger logger = LoggerFactory.getLogger(ShutdownUtils.class);

    public static void shutdownThreadPool(ExecutorService executor) {
        if (executor != null) {
            executor.shutdown();
            try {
                executor.awaitTermination(60, TimeUnit.SECONDS);
            } catch (Exception e) {
                logger.error("Shutdown threadPool failed", e);
            }
            if (!executor.isTerminated()) {
                executor.shutdownNow();
            }
        }
    }

    /**
     * set final value
     * @param completableFutures
     */
    public static void completedFuture(List<CompletableFuture<Void>> completableFutures){
        for (CompletableFuture<Void> future: completableFutures) {
            future.cancel(true);
        } }
}
