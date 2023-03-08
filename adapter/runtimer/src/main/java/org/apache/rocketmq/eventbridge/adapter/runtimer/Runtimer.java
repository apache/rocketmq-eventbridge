package org.apache.rocketmq.eventbridge.adapter.runtimer;

import org.apache.rocketmq.eventbridge.adapter.runtimer.boot.EventBusListener;
import org.apache.rocketmq.eventbridge.adapter.runtimer.boot.EventRuleTransfer;
import org.apache.rocketmq.eventbridge.adapter.runtimer.boot.EventTargetPusher;
import org.apache.rocketmq.eventbridge.adapter.runtimer.boot.listener.ListenerFactory;
import org.apache.rocketmq.eventbridge.adapter.runtimer.common.entity.PusherTargetEntity;
import org.apache.rocketmq.eventbridge.adapter.runtimer.common.entity.TargetKeyValue;
import org.apache.rocketmq.eventbridge.adapter.runtimer.common.RuntimerState;
import org.apache.rocketmq.eventbridge.adapter.runtimer.common.ServiceThread;
import org.apache.rocketmq.eventbridge.adapter.runtimer.common.plugin.Plugin;
import org.apache.rocketmq.eventbridge.adapter.runtimer.config.RuntimerConfig;
import org.apache.rocketmq.eventbridge.adapter.runtimer.service.PusherConfigManageService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;

import javax.annotation.PostConstruct;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Objects;
import java.util.concurrent.atomic.AtomicReference;

/**
 * EventBridge运行器
 *
 * @author artisan
 */
@Component
public class Runtimer extends ServiceThread {

    private static final Logger logger = LoggerFactory.getLogger(Runtimer.class);

    private AtomicReference<RuntimerState> runtimerState;

    private RuntimerConfig runtimerConfig;

    private Plugin plugin;

    private ListenerFactory listenerFactory;

    private PusherConfigManageService pusherConfigManageService;

    private Map<String, List<TargetKeyValue>> taskConfigs = new HashMap<>();

    private EventBusListener listener;

    private EventRuleTransfer transfer;

    private EventTargetPusher pusher;

    public Runtimer(RuntimerConfig runtimerConfig, Plugin plugin, ListenerFactory listenerFactory, PusherConfigManageService configManageService) {
        this.runtimerConfig = runtimerConfig;
        this.plugin = plugin;
        this.listenerFactory = listenerFactory;
        this.pusherConfigManageService = configManageService;
    }

    @PostConstruct
    public void initAndStart() {
        this.taskConfigs = pusherConfigManageService.getTaskConfigs();
        listener = new EventBusListener(listenerFactory);
        listener.initOrUpdateListenConsumer(taskConfigs);
        transfer = new EventRuleTransfer(plugin, listenerFactory);
        transfer.initOrUpdateTaskTransform(taskConfigs);
        pusher = new EventTargetPusher(plugin, listenerFactory);
        pusher.initOrUpdatePusherTask(taskConfigs);
        this.start();
    }

    @Override
    public String getServiceName() {
        return Runtimer.class.getSimpleName();
    }

    public void start() {
        runtimerState = new AtomicReference<>(RuntimerState.START);
        super.start();
    }

    @Override
    public void run() {
        logger.info(">>>runtimer started!");

        listener.start();

        transfer.start();

        pusher.start();

        while (!stopped) {
            PusherTargetEntity pusherTargetEntity = listenerFactory.takeTaskConfig();
            if (Objects.nonNull(pusherTargetEntity)) {
                Map<String, List<TargetKeyValue>> curMap = new HashMap<>();
                curMap.put(pusherTargetEntity.getConnectName(), pusherTargetEntity.getTargetKeyValues());
                listener.initOrUpdateListenConsumer(curMap);
                transfer.initOrUpdateTaskTransform(curMap);
                pusher.initOrUpdatePusherTask(curMap);
            }
        }
    }
}
