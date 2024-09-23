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

package org.apache.rocketmq.eventbridge.adapter.runtime.manager.worker;

public enum WorkerStatusEnum {
    UNKNOWN(-1, "Unknown"),

    WAIT_DEPLOY(0, "Deployed"),
    STARTING(3, "Starting"),
    RUN(5, "Run"),
    STOP(10, "Stop"),
    RELEASING(11, "Releasing");

    private int value;
    private String desc;

    WorkerStatusEnum(int value, String desc) {
        this.value = value;
        this.desc = desc;
    }

    public static WorkerStatusEnum valueOf(int value) {
        for (WorkerStatusEnum temp : WorkerStatusEnum.values()) {
            if (temp.getValue() == value) {
                return temp;
            }
        }
        return UNKNOWN;
    }

    public static WorkerStatusEnum nameOf(String name) {
        for (WorkerStatusEnum temp : WorkerStatusEnum.values()) {
            if (temp.name().equals(name)) {
                return temp;
            }
        }
        return UNKNOWN;
    }

    public String getDesc() {
        return desc;
    }

    public int getValue() {
        return value;
    }
}
