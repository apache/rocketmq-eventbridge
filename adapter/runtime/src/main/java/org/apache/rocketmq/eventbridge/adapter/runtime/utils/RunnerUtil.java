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
