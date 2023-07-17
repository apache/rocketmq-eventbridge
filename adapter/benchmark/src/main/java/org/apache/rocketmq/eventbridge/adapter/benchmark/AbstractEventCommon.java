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

import org.apache.rocketmq.common.UtilAll;

import java.io.File;
import java.io.IOException;
import java.io.LineNumberReader;
import java.math.BigDecimal;
import java.math.RoundingMode;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.atomic.AtomicReference;
import java.util.concurrent.atomic.LongAdder;

public abstract class AbstractEventCommon {
    protected File file;
    protected LineNumberReader lineNumberReader;
    protected AtomicReference<Integer> previousRowCount;
    protected ScheduledExecutorService executorService;
    protected LongAdder writeCount = new LongAdder();
    protected LongAdder costTime = new LongAdder();

    protected String twoDecimal(double doubleValue) {
        BigDecimal bigDecimal = new BigDecimal(doubleValue).setScale(2, RoundingMode.HALF_UP);
        return bigDecimal.toString();
    }

    protected void printStats() throws IOException {

        int currentRowCount = getLineNumber();
        if (previousRowCount.get() == null || previousRowCount.get() == 0) {
            previousRowCount.set(currentRowCount);
            return;
        }

        // tps: 每秒钟能处理的消息数； 消息总数/消耗时长
        final long tps = currentRowCount - previousRowCount.get();
        previousRowCount.set(currentRowCount);
        writeCount.add(currentRowCount);
        costTime.add(1000);
        // 条/ms
        final double delayTime = writeCount.longValue() / costTime.longValue();
        String delayTimeStr = twoDecimal(delayTime);

        String info = String.format("Current Time: %s  |  TPS: %d     |  delayTime: %sms",
                UtilAll.timeMillisToHumanString2(System.currentTimeMillis()), tps, delayTimeStr);

        System.out.println(info);
    }


    public abstract void start();

    protected int getLineNumber() throws IOException {
        lineNumberReader.skip(Long.MAX_VALUE);
        int lineNumber = lineNumberReader.getLineNumber();
        //实际上是读取换行符数量 , 所以需要+1
        return lineNumber;
    }
}