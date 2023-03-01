package org.apache.rocketmq.eventbridge.adapter.runtimer.boot.pusher;

import io.openmessaging.KeyValue;
import io.openmessaging.connector.api.component.task.sink.SinkTaskContext;
import io.openmessaging.connector.api.data.RecordOffset;
import io.openmessaging.connector.api.data.RecordPartition;

import java.util.List;
import java.util.Map;
import java.util.Set;

public class RuntimerSinkTaskContext implements SinkTaskContext {

    @Override
    public String getConnectorName() {
        return null;
    }

    @Override
    public String getTaskName() {
        return null;
    }

    @Override
    public KeyValue configs() {
        return null;
    }

    @Override
    public void resetOffset(RecordPartition recordPartition, RecordOffset recordOffset) {

    }

    @Override
    public void resetOffset(Map<RecordPartition, RecordOffset> offsets) {

    }

    @Override
    public void pause(List<RecordPartition> partitions) {

    }

    @Override
    public void resume(List<RecordPartition> partitions) {

    }

    @Override
    public Set<RecordPartition> assignment() {
        return null;
    }
}
