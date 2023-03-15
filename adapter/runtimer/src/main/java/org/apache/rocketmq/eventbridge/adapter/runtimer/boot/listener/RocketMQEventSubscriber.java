package org.apache.rocketmq.eventbridge.adapter.runtimer.boot.listener;

import io.openmessaging.connector.api.data.ConnectRecord;
import java.util.List;

public class RocketMQEventSubscriber extends EventSubscriber {

    private ListenerFactory listenerFactory;

    public RocketMQEventSubscriber(
        ListenerFactory listenerFactory) {
        this.listenerFactory = listenerFactory;
    }

    @Override void refresh() {

    }

    @Override public List<ConnectRecord> pull() {
        return null;
    }

    @Override
    public void commit(List<ConnectRecord> connectRecordList) {

    }
}