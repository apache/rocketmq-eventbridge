package org.apache.rocketmq.eventbridge.metrics;

import com.google.common.collect.Lists;
import io.opentelemetry.api.metrics.LongHistogram;
import io.opentelemetry.api.metrics.Meter;
import io.opentelemetry.sdk.metrics.Aggregation;
import io.opentelemetry.sdk.metrics.InstrumentSelector;
import io.opentelemetry.sdk.metrics.InstrumentType;
import io.opentelemetry.sdk.metrics.View;
import org.apache.rocketmq.eventbridge.metrcis.NopLongHistogram;

import java.time.Duration;
import java.util.Arrays;
import java.util.List;

import static org.apache.rocketmq.eventbridge.metrics.RemotingMetricsConstant.HISTOGRAM_RPC_LATENCY;


public class RemotingMetricsManager {
    public static LongHistogram rpcLatency = new NopLongHistogram();

    //TODO 接入延迟统计
    public static void initMetrics(Meter meter) {
        rpcLatency = meter.histogramBuilder(HISTOGRAM_RPC_LATENCY)
            .setDescription("Rpc latency")
            .setUnit("milliseconds")
            .ofLongs()
            .build();
    }

    public static List<Pair<InstrumentSelector, View>> getMetricsView() {
        List<Double> rpcCostTimeBuckets = Arrays.asList(
            (double) Duration.ofMillis(1).toMillis(),
            (double) Duration.ofMillis(3).toMillis(),
            (double) Duration.ofMillis(5).toMillis(),
            (double) Duration.ofMillis(7).toMillis(),
            (double) Duration.ofMillis(10).toMillis(),
            (double) Duration.ofMillis(100).toMillis(),
            (double) Duration.ofSeconds(1).toMillis(),
            (double) Duration.ofSeconds(2).toMillis(),
            (double) Duration.ofSeconds(3).toMillis()
        );
        InstrumentSelector selector = InstrumentSelector.builder()
            .setType(InstrumentType.HISTOGRAM)
            .setName(HISTOGRAM_RPC_LATENCY)
            .build();
        View view = View.builder()
            .setAggregation(Aggregation.explicitBucketHistogram(rpcCostTimeBuckets))
            .build();
        return Lists.newArrayList(new Pair<>(selector, view));
    }

}
