package org.apache.rocketmq.eventbridge.adapter.runtime.boot;

import org.apache.rocketmq.eventbridge.adapter.runtime.boot.listener.EventSubscriber;
import org.apache.rocketmq.eventbridge.adapter.runtime.common.ServiceThread;
import org.apache.rocketmq.eventbridge.metrics.BridgeConfig;
import org.apache.rocketmq.eventbridge.metrics.BridgeMetricsManager;

public class EventMonitor extends ServiceThread {

    private final EventSubscriber eventSubscriber;

    public EventMonitor(EventSubscriber eventSubscriber) {
        this.eventSubscriber = eventSubscriber;
    }
    @Override
    public String getServiceName() {
        return EventMonitor.class.getSimpleName();
    }

    @Override
    public void run() {
        BridgeConfig bridgeConfig = eventSubscriber.fetchMetricsConf();
        BridgeMetricsManager metricsManager = new BridgeMetricsManager(bridgeConfig);
        metricsManager.init();
    }
}
