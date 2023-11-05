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

import io.openmessaging.connector.api.data.ConnectRecord;
import org.apache.rocketmq.eventbridge.adapter.runtime.boot.common.CirculatorContext;
import org.apache.rocketmq.eventbridge.adapter.runtime.common.entity.TargetRunnerConfig;
import org.apache.rocketmq.eventbridge.adapter.runtime.config.RuntimeConfigDefine;

public class RunnerUtil {

    public static String getAccountId(CirculatorContext circulatorContext, ConnectRecord connectRecord) {
        String runnerName = connectRecord.getExtension(RuntimeConfigDefine.RUNNER_NAME);
        TargetRunnerConfig runnerConfig = circulatorContext.getRunnerConfig(runnerName);
        return runnerConfig.getAccountId();
    }


    public static String getAccountId(CirculatorContext circulatorContext, String runnerName) {
        TargetRunnerConfig runnerConfig = circulatorContext.getRunnerConfig(runnerName);
        return runnerConfig.getAccountId();
    }

    public static String getRunnerName(ConnectRecord connectRecord) {
        return connectRecord.getExtension(RuntimeConfigDefine.RUNNER_NAME);
    }
}
