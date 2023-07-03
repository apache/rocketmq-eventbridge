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
package org.apache.rocketmq.eventbridge.adapter.benchmark;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONObject;
import org.apache.rocketmq.common.UtilAll;

import java.io.PrintStream;
import java.lang.management.ManagementFactory;
import java.lang.management.OperatingSystemMXBean;
import java.lang.management.ThreadMXBean;
import java.math.BigDecimal;
import java.math.RoundingMode;
import java.util.LinkedList;
import java.util.concurrent.ScheduledExecutorService;

public abstract class AbstractEventCommon {
    protected OperatingSystemMXBean osMxBean;

    protected ThreadMXBean threadBean;

    protected StatsBenchmarkCommon statsBenchmarkCommon;

    protected LinkedList<Long[]> snapshotList;

    protected PrintStream printStream;

    protected ScheduledExecutorService executorService;

    public AbstractEventCommon() {
        osMxBean = ManagementFactory.getOperatingSystemMXBean();
        threadBean = ManagementFactory.getThreadMXBean();
        statsBenchmarkCommon = new StatsBenchmarkCommon();
        snapshotList = new LinkedList<>();
    }

    public void successCount(int batchSize,long timesStamp) {
        statsBenchmarkCommon.getSuccessCount().increment();
        statsBenchmarkCommon.getRecordCount().add(batchSize);
        snapshotList.addLast(statsBenchmarkCommon.createSnapshot(timesStamp));
    }

    public void failCount() {
        statsBenchmarkCommon.getFailCount().increment();
    }

    protected final long MB = 1024 * 1024;
    protected final long GB = 1024 * 1024 * 1024;

    protected String getSystemState() {
        String osJson = JSON.toJSONString(osMxBean);
        JSONObject jsonObject = JSON.parseObject(osJson);

        Long totalPhysicalMemorySize = jsonObject.getLong("totalPhysicalMemorySize") / MB;
        Long freePhysicalMemorySize = jsonObject.getLong("freePhysicalMemorySize") / MB;
        double freePhysicalMemory = (totalPhysicalMemorySize - freePhysicalMemorySize * 1.0) / totalPhysicalMemorySize;
        double freePhysicalMemoryRate = freePhysicalMemory * 100;

        Runtime runtime = Runtime.getRuntime();
        // java虚拟机中的内存总量，可用内存空间 单位为byte，默认为系统的1/64
        long totalMemory = runtime.totalMemory();
        // java虚拟机试图使用的最大内存量 最大可用内存空间 单位byte，默认为系统的1/4
        long maxMemory = runtime.maxMemory();
        // java 虚拟机中的空闲内存量 空闲空间 单位byte， 默认为系统的1/4
        long freeMemory = runtime.freeMemory();
        double usedMemoryJava = (totalMemory - freeMemory * 1.0) / totalMemory;
        double usedMemoryJavaRate = usedMemoryJava * 100;

        StringBuilder result = new StringBuilder();
        result
                .append("系统总内存:")
                .append(twoDecimal(totalPhysicalMemorySize / 1024))
                .append("GB  |  系统内存使用量: ")
                .append(twoDecimal(freePhysicalMemoryRate))
                .append("%  |  虚拟机内存总量:")
                .append(twoDecimal(totalMemory / MB))
                .append("MB  |  虚拟机内存使用量:")
                .append(twoDecimal(usedMemoryJavaRate)).append("%");

        return result.toString();
    }

    protected String twoDecimal(double doubleValue) {
        BigDecimal bigDecimal = new BigDecimal(doubleValue).setScale(2, RoundingMode.HALF_UP);
        return bigDecimal.toString();
    }

    protected void printStats() {
        if (snapshotList.size() >= 10) {
            Long[] begin = snapshotList.getFirst();
            Long[] end = snapshotList.getLast();

            // final long tps = (long) (((end[1] - begin[1]) / (double) (end[0] - begin[0])) * 1000L);
            // tps: 每秒钟能处理的消息数； 消息条数/时间差
            final long tps = (long) (((end[3] - begin[3]) / (double) (end[0] - begin[0])) * 1000L);

            final long failCount = end[2] - begin[2];

            // 处理的消息条数
            double c = (double) (end[3] - begin[3]);
            c = c <= 0 ? 1 : c;
            // 时间
            double t = (double) (end[0] - begin[0]);
            // 条/ms
            final double delayTime =  t /  c;
            String delayTimeStr = twoDecimal(delayTime);

            String sysState = getSystemState();

            String info = String.format("Current Time: %s  |  TPS: %d     |  delayTime: %sms     |  Consume Fail: %d     |  %s",
                    UtilAll.timeMillisToHumanString2(System.currentTimeMillis()), tps, delayTimeStr, failCount, sysState);

            printStream.println(info);
        }
    }
}