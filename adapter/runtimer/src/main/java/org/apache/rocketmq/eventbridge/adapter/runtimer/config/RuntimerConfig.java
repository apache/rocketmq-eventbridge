package org.apache.rocketmq.eventbridge.adapter.runtimer.config;

import lombok.Data;
import org.springframework.beans.factory.annotation.Configurable;

@Data
@Configurable
public class RuntimerConfig {

    private String runtimeName;

    private String pluginPath;

    private String storePathRootDir;

}
