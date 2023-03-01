package org.apache.rocketmq.eventbridge.adapter.runtimer;

import org.apache.rocketmq.eventbridge.adapter.runtimer.common.*;
import org.apache.rocketmq.eventbridge.adapter.runtimer.common.plugin.Plugin;
import org.apache.rocketmq.eventbridge.adapter.runtimer.config.RuntimerConfig;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.util.CollectionUtils;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.concurrent.atomic.AtomicReference;

/**
 * EventBridge运行器
 * @author artisan
 */
public class Runtimer extends ServiceThread {

    private static final Logger logger = LoggerFactory.getLogger(Runtimer.class);

    private AtomicReference<RuntimerState> runtimerState;

    private RuntimerConfig runtimerConfig;

    private Plugin plugin;

    Map<String, List<ConnectKeyValue>> latestTaskConfigs = new HashMap<>();


    public Runtimer(RuntimerConfig runtimerConfig, Plugin plugin){
        this.runtimerConfig = runtimerConfig;
        this.plugin = plugin;
    }

    @Override
    public String getServiceName() {
        return Runtimer.class.getSimpleName();
    }

    public void start(){
        runtimerState = new AtomicReference<>(RuntimerState.START);
        super.start();
    }

    public void stop(){

    }


    @Override
    public void run() {
        logger.info(">>>runtimer started!");
        while (!stopped){
            if(CollectionUtils.isEmpty(latestTaskConfigs)){

            }
        }
    }
}
