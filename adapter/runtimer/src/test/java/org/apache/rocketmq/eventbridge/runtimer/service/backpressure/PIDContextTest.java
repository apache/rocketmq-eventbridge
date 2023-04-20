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
package org.apache.rocketmq.eventbridge.runtimer.service.backpressure;

import com.google.common.util.concurrent.ThreadFactoryBuilder;

import java.util.concurrent.*;

public class PIDContextTest {
    private BlockingQueue<String> eventQueue = new LinkedBlockingQueue<>(50000);
    private BlockingQueue<String> targetQueue = new LinkedBlockingQueue<>(50000);
    private ExecutorService threadPoolExecutor;

    public PIDContextTest() {
        threadPoolExecutor = initDefaultThreadPoolExecutor();
    }

    public BlockingQueue<String> getEventQueue() {
        return eventQueue;
    }

    public BlockingQueue<String> getTargetQueue() {
        return targetQueue;
    }


    public ExecutorService getThreadPoolExecutor() {
        return threadPoolExecutor;
    }

    public synchronized boolean  canExecute() {
        // System.out.printf("thread queue size=>%s", ((ThreadPoolExecutor) threadPoolExecutor).getQueue().size());
        return ((ThreadPoolExecutor) threadPoolExecutor).getQueue().size() < 300;
    }

    /**
     * init default thread poll param, support auto config
     *
     * @return
     */
    private ExecutorService initDefaultThreadPoolExecutor() {
        ThreadFactoryBuilder threadFactory = new ThreadFactoryBuilder().setNameFormat("pid-test");
        return new ThreadPoolExecutor(4, 8, 10, TimeUnit.MILLISECONDS, new LinkedBlockingQueue<>(300), threadFactory.build());
    }
}
