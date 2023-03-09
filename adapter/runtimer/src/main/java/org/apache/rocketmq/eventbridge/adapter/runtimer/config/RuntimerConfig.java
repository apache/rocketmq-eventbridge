package org.apache.rocketmq.eventbridge.adapter.runtimer.config;

import lombok.Data;
import org.springframework.beans.factory.annotation.Configurable;
import org.springframework.beans.factory.annotation.Value;

@Data
@Configurable
public class RuntimerConfig {

    @Value("${rumtimer.name:}")
    private String runtimeName;

    @Value("${runtimer.pluginpath:}")
    private String pluginPath;

    @Value("${runtimer.storePathRootDir:}")
    private String storePathRootDir;

}
