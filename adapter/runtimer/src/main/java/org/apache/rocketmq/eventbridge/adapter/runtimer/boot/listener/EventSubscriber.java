package org.apache.rocketmq.eventbridge.adapter.runtimer.boot.listener;

import io.openmessaging.connector.api.data.ConnectRecord;
import java.util.List;
import org.apache.rocketmq.eventbridge.adapter.runtimer.common.entity.TargetRunnerConfig;

public abstract class EventSubscriber implements TargetRunnerListener {

    abstract void refresh();

    /**
     * Pull connect records from store, Blocking method when is empty.
     *
     * @return
     */
    public abstract List<ConnectRecord> pull();

    /**
     * Commit the connect records.
     *
     * @param connectRecordList
     */
    public abstract void commit(List<ConnectRecord> connectRecordList);

    /**
     * Call when add new target runner to runtimer.
     *
     * @param targetRunnerConfig
     */
    @Override
    public void onAddTargetRunner(TargetRunnerConfig targetRunnerConfig) {
        this.refresh();
    }

    /**
     * Call when the old target runner updated.
     *
     * @param targetRunnerConfig
     */
    @Override
    public void onUpdateTargetRunner(TargetRunnerConfig targetRunnerConfig) {

        this.refresh();
    }

    /**
     * Call when the old target runner deleted from runtimer.
     *
     * @param targetRunnerConfig
     */
    @Override
    public void onDeleteTargetRunner(TargetRunnerConfig targetRunnerConfig) {
        this.refresh();
    }

}