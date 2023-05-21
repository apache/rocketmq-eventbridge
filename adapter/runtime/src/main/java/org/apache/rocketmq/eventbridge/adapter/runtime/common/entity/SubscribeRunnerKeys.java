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

package org.apache.rocketmq.eventbridge.adapter.runtime.common.entity;

import lombok.Data;

import java.io.Serializable;
import java.util.Objects;

/**
 * Support target runner config with few keys for subscriber
 */
@Data
public class SubscribeRunnerKeys implements Serializable {

    private String accountId;

    private String runnerName;

    private String eventBusName;

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        SubscribeRunnerKeys that = (SubscribeRunnerKeys) o;
        return Objects.equals(accountId, that.accountId) && Objects.equals(runnerName, that.runnerName) && Objects.equals(eventBusName, that.eventBusName);
    }

    @Override
    public int hashCode() {
        return Objects.hash(accountId, runnerName, eventBusName);
    }

    @Override
    public String toString() {
        return "SubscribeRunnerKeys{" +
                "accountId='" + accountId + '\'' +
                ", runnerName='" + runnerName + '\'' +
                ", eventBusName='" + eventBusName + '\'' +
                '}';
    }
}
