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

package org.apache.rocketmq.eventbridge.adapter.runtime.utils;

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
