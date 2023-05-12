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

package org.apache.rocketmq.eventbridge.adapter.runtimer.common.entity;

import java.io.Serializable;
import java.util.List;
import java.util.Map;
import java.util.Objects;
import lombok.Data;

import static org.apache.rocketmq.eventbridge.adapter.runtimer.config.RuntimerConfigDefine.TARGET_RUNNER_KEY;
import static org.apache.rocketmq.eventbridge.adapter.runtimer.config.RuntimerConfigDefine.ACCOUNT_ID;

/**
 * pusher target key config
 */
@Data
public class TargetRunnerConfig implements Serializable {

    private String name;

    /**
     * All data are reserved in this map.
     */
    private List<Map<String, String>> components;

    private RunOptions runOptions = new RunOptions();

    @Override
    public boolean equals(Object o) {
        if (this == o)
            return true;
        if (o == null || getClass() != o.getClass())
            return false;
        TargetRunnerConfig config = (TargetRunnerConfig) o;
        return Objects.equals(name, config.name) && isEqualsComponents(components, config.getComponents());
    }

    @Override
    public int hashCode() {
        return Objects.hash(name, components);
    }

    @Override
    public String toString() {
        return "TargetRunnerConfig{" +
                "name='" + name + '\'' +
                ", components=" + components +
                ", runOptions=" + runOptions +
                '}';
    }

    private boolean isEqualsComponents(List<Map<String, String>> source, List<Map<String, String>> target) {
        if (source == null || target == null) {
            if (source != target) {
                return false;
            } else {
                return true;
            }
        }

        if (source.isEmpty() || target.isEmpty()) {
            if (source.isEmpty() && target.isEmpty()) {
                return true;
            } else {
                return false;
            }
        }

        if (source.size() != target.size()) {
            return false;
        }
        for (int index = 0; index < source.size(); index++) {
            Map<String, String> sourceComponent = source.get(index);
            Map<String, String> targetComponent = target.get(index);
            if (sourceComponent.size() != targetComponent.size()) {
                return false;
            }
            for (Map.Entry<String, String> entry : sourceComponent.entrySet()) {
                String element = targetComponent.get(entry.getKey());
                if (element == null && entry.getValue() == null) {
                    return true;
                } else if (element.equals(entry.getValue())) {
                    return true;
                } else {
                    return false;
                }
            }
        }
        return true;
    }

    public String getEventBusName() {
        return components.get(0).get(TARGET_RUNNER_KEY);
    }

    public String getAccountId() {
        return components.get(0).get(ACCOUNT_ID);
    }

    public TargetRunnerLite getRunnerLite(){
        TargetRunnerLite targetRunnerLite = new TargetRunnerLite();
        targetRunnerLite.setRunnerName(this.getName());
        targetRunnerLite.setAccountId(this.getAccountId());
        targetRunnerLite.setEventBusName(this.getEventBusName());
        return targetRunnerLite;
    }
}
