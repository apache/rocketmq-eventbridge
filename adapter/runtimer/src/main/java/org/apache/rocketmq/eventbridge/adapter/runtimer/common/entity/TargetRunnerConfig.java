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

import lombok.Data;

import java.io.Serializable;
import java.util.List;

/**
 * pusher target key config
 */
@Data
public class TargetRunnerConfig implements Serializable {

    private String connectName;

    private List<TargetKeyValue> targetKeyValues;

    @Override
    public boolean equals(Object object){
        if (object != null && object.getClass() == this.getClass()) {
            TargetRunnerConfig targetEntity = (TargetRunnerConfig) object;
            return this.connectName.equals(targetEntity.getConnectName())
                    && this.targetKeyValues.size() == targetEntity.getTargetKeyValues().size()
                    && this.targetKeyValues.containsAll(targetEntity.getTargetKeyValues());
        }
        return false;
    }

    @Override
    public int hashCode(){
        return this.connectName.hashCode() + this.targetKeyValues.hashCode();
    }
}
