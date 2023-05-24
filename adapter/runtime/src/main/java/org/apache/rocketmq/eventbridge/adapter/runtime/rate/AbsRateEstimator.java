package org.apache.rocketmq.eventbridge.adapter.runtime.rate;

/**
 * @Author lkm
 * @Description
 * @Date 下午7:10
 */
public abstract class AbsRateEstimator {

    public abstract RunnerMetrics compute(EstimateMetrics estimateMetrics);
}
