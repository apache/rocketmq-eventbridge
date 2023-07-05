package org.apache.rocketmq.eventbridge.adapter.runtime.boot;

import org.apache.rocketmq.eventbridge.BridgeMetricsManager;
import org.apache.rocketmq.eventbridge.adapter.runtime.boot.listener.EventSubscriber;
import org.apache.rocketmq.eventbridge.adapter.runtime.common.ServiceThread;

public class EventMonitor extends ServiceThread {

    private BridgeMetricsManager bridgeMetricsManager;

    public EventMonitor(EventSubscriber eventSubscriber) {
        this.bridgeMetricsManager = eventSubscriber.getMetricsManager();
    }
    @Override
    public String getServiceName() {
        return EventMonitor.class.getSimpleName();
    }

    @Override
    public void run() {
        bridgeMetricsManager.init();
    }

    @Override
    public void shutdown() {
        bridgeMetricsManager.shutdown();
    }
}