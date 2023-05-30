package org.apache.rocketmq.eventbridge.metrics;

import com.google.common.base.Splitter;
import com.google.common.collect.Lists;
import io.opentelemetry.api.common.Attributes;
import io.opentelemetry.api.common.AttributesBuilder;
import io.opentelemetry.api.metrics.LongCounter;
import io.opentelemetry.api.metrics.LongHistogram;
import io.opentelemetry.api.metrics.Meter;
import io.opentelemetry.api.metrics.ObservableLongGauge;
import io.opentelemetry.exporter.otlp.metrics.OtlpGrpcMetricExporter;
import io.opentelemetry.exporter.otlp.metrics.OtlpGrpcMetricExporterBuilder;
import io.opentelemetry.exporter.prometheus.PrometheusHttpServer;
import io.opentelemetry.exporter.logging.LoggingMetricExporter;
import io.opentelemetry.sdk.OpenTelemetrySdk;
import io.opentelemetry.sdk.metrics.Aggregation;
import io.opentelemetry.sdk.metrics.InstrumentSelector;
import io.opentelemetry.sdk.metrics.InstrumentType;
import io.opentelemetry.sdk.metrics.SdkMeterProvider;
import io.opentelemetry.sdk.metrics.SdkMeterProviderBuilder;
import io.opentelemetry.sdk.metrics.View;
import io.opentelemetry.sdk.metrics.data.AggregationTemporality;
import io.opentelemetry.sdk.metrics.export.PeriodicMetricReader;
import io.opentelemetry.sdk.resources.Resource;

import java.time.Duration;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.concurrent.BlockingDeque;
import java.util.concurrent.LinkedBlockingDeque;
import java.util.concurrent.TimeUnit;
import org.apache.commons.lang3.StringUtils;
import org.apache.rocketmq.eventbridge.metrcis.NopLongCounter;
import org.apache.rocketmq.eventbridge.metrcis.NopLongHistogram;
import org.apache.rocketmq.eventbridge.metrcis.NopObservableLongGauge;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.slf4j.bridge.SLF4JBridgeHandler;


import static org.apache.rocketmq.eventbridge.metrics.BridgeMetricsConstant.AGGREGATION_DELTA;
import static org.apache.rocketmq.eventbridge.metrics.BridgeMetricsConstant.COUNTER_MESSAGES_IN_TOTAL;
import static org.apache.rocketmq.eventbridge.metrics.BridgeMetricsConstant.COUNTER_MESSAGES_OUT_TOTAL;
import static org.apache.rocketmq.eventbridge.metrics.BridgeMetricsConstant.COUNTER_THROUGHPUT_IN_TOTAL;
import static org.apache.rocketmq.eventbridge.metrics.BridgeMetricsConstant.COUNTER_THROUGHPUT_OUT_TOTAL;
import static org.apache.rocketmq.eventbridge.metrics.BridgeMetricsConstant.GAUGE_PROCESSOR_WATERMARK;
import static org.apache.rocketmq.eventbridge.metrics.BridgeMetricsConstant.HISTOGRAM_MESSAGE_SIZE;
import static org.apache.rocketmq.eventbridge.metrics.BridgeMetricsConstant.HISTOGRAM_RPC_LATENCY;
import static org.apache.rocketmq.eventbridge.metrics.BridgeMetricsConstant.LABEL_AGGREGATION;
import static org.apache.rocketmq.eventbridge.metrics.BridgeMetricsConstant.LABEL_PROCESSOR;
import static org.apache.rocketmq.eventbridge.metrics.BridgeMetricsConstant.OPEN_TELEMETRY_METER_NAME;

/**
 * 待接入Runtimer或者RocketMQEventSubscriber
 */
public class BridgeMetricsManager  {
    private static final Logger LOGGER = LoggerFactory.getLogger(BridgeMetricsManager.class);

    private final BridgeConfig brokerConfig;
    private final static Map<String, String> LABEL_MAP = new HashMap<>();
    private OtlpGrpcMetricExporter metricExporter;
    private PeriodicMetricReader periodicMetricReader;
    private PrometheusHttpServer prometheusHttpServer;
    private LoggingMetricExporter loggingMetricExporter;
    private Meter brokerMeter;

    // broker stats metrics
    public static ObservableLongGauge processorWatermark = new NopObservableLongGauge();

    //invoke timeout
    public static LongHistogram invokeLatency = new NopLongHistogram();

    // request metrics
    public static LongCounter messagesInTotal = new NopLongCounter();
    public static LongCounter messagesOutTotal = new NopLongCounter();
    public static LongCounter throughputInTotal = new NopLongCounter();
    public static LongCounter throughputOutTotal = new NopLongCounter();
    public static LongHistogram messageSize = new NopLongHistogram();

    public BridgeMetricsManager(BridgeConfig brokerConfig) {
        this.brokerConfig = brokerConfig;
    }


    public static AttributesBuilder newAttributesBuilder() {
        AttributesBuilder attributesBuilder = Attributes.builder();
        LABEL_MAP.forEach(attributesBuilder::put);
        return attributesBuilder;
    }

    private boolean checkConfig() {
        if (brokerConfig == null) {
            return false;
        }
        BridgeConfig.MetricsExporterType exporterType = brokerConfig.getMetricsExporterType();
        if (!exporterType.isEnable()) {
            return false;
        }

        switch (exporterType) {
            case OTLP_GRPC:
                return StringUtils.isNotBlank(brokerConfig.getMetricsGrpcExporterTarget());
            case PROM:
                return true;
            case LOG:
                return true;
        }
        return false;
    }

    public void init() {
        BridgeConfig.MetricsExporterType metricsExporterType = brokerConfig.getMetricsExporterType();
        if (metricsExporterType == BridgeConfig.MetricsExporterType.DISABLE) {
            return;
        }

        if (!checkConfig()) {
            LOGGER.error("check metrics config failed, will not export metrics");
            return;
        }

        String labels = brokerConfig.getMetricsLabel();
        if (StringUtils.isNotBlank(labels)) {
            List<String> kvPairs = Splitter.on(',').omitEmptyStrings().splitToList(labels);
            for (String item : kvPairs) {
                String[] split = item.split(":");
                if (split.length != 2) {
                    LOGGER.warn("metricsLabel is not valid: {}", labels);
                    continue;
                }
                LABEL_MAP.put(split[0], split[1]);
            }
        }
        if (brokerConfig.isMetricsInDelta()) {
            LABEL_MAP.put(LABEL_AGGREGATION, AGGREGATION_DELTA);
        }

        SdkMeterProviderBuilder providerBuilder = SdkMeterProvider.builder()
            .setResource(Resource.empty());

        if (metricsExporterType == BridgeConfig.MetricsExporterType.OTLP_GRPC) {
            String endpoint = brokerConfig.getMetricsGrpcExporterTarget();
            if (!endpoint.startsWith("http")) {
                endpoint = "https://" + endpoint;
            }
            OtlpGrpcMetricExporterBuilder metricExporterBuilder = OtlpGrpcMetricExporter.builder()
                .setEndpoint(endpoint)
                .setTimeout(brokerConfig.getMetricGrpcExporterTimeOutInMills(), TimeUnit.MILLISECONDS)
                .setAggregationTemporalitySelector(type -> {
                    if (brokerConfig.isMetricsInDelta() &&
                        (type == InstrumentType.COUNTER || type == InstrumentType.OBSERVABLE_COUNTER || type == InstrumentType.HISTOGRAM)) {
                        return AggregationTemporality.DELTA;
                    }
                    return AggregationTemporality.CUMULATIVE;
                });

            String headers = brokerConfig.getMetricsGrpcExporterHeader();
            if (StringUtils.isNotBlank(headers)) {
                Map<String, String> headerMap = new HashMap<>();
                List<String> kvPairs = Splitter.on(',').omitEmptyStrings().splitToList(headers);
                for (String item : kvPairs) {
                    String[] split = item.split(":");
                    if (split.length != 2) {
                        LOGGER.warn("metricsGrpcExporterHeader is not valid: {}", headers);
                        continue;
                    }
                    headerMap.put(split[0], split[1]);
                }
                headerMap.forEach(metricExporterBuilder::addHeader);
            }

            metricExporter = metricExporterBuilder.build();

            periodicMetricReader = PeriodicMetricReader.builder(metricExporter)
                .setInterval(brokerConfig.getMetricGrpcExporterIntervalInMills(), TimeUnit.MILLISECONDS)
                .build();

            providerBuilder.registerMetricReader(periodicMetricReader);
        }

        if (metricsExporterType == BridgeConfig.MetricsExporterType.PROM) {
            String promExporterHost = brokerConfig.getMetricsPromExporterHost();
            if (StringUtils.isBlank(promExporterHost)) {
                promExporterHost = brokerConfig.getEventBridgeAddress();
            }
            prometheusHttpServer = PrometheusHttpServer.builder()
                .setHost(promExporterHost)
                .setPort(brokerConfig.getMetricsPromExporterPort())
                .build();
            providerBuilder.registerMetricReader(prometheusHttpServer);
        }

        if (metricsExporterType == BridgeConfig.MetricsExporterType.LOG) {
            SLF4JBridgeHandler.removeHandlersForRootLogger();
            SLF4JBridgeHandler.install();
            loggingMetricExporter = LoggingMetricExporter.create(brokerConfig.isMetricsInDelta() ? AggregationTemporality.DELTA : AggregationTemporality.CUMULATIVE);
            java.util.logging.Logger.getLogger(LoggingMetricExporter.class.getName()).setLevel(java.util.logging.Level.FINEST);
            periodicMetricReader = PeriodicMetricReader.builder(loggingMetricExporter)
                .setInterval(brokerConfig.getMetricLoggingExporterIntervalInMills(), TimeUnit.MILLISECONDS)
                .build();
            providerBuilder.registerMetricReader(periodicMetricReader);
        }

        registerMetricsView(providerBuilder);

        brokerMeter = OpenTelemetrySdk.builder()
            .setMeterProvider(providerBuilder.build())
            .build()
            .getMeter(OPEN_TELEMETRY_METER_NAME);

        initStatsMetrics();
        initRequestMetrics();
    }

    private void registerMetricsView(SdkMeterProviderBuilder providerBuilder) {
        // message size buckets, 1k, 4k, 512k, 1M, 2M, 4M
        List<Double> messageSizeBuckets = Arrays.asList(
            1d * 1024, //1KB
            4d * 1024, //4KB
            512d * 1024, //512KB
            1d * 1024 * 1024, //1MB
            2d * 1024 * 1024, //2MB
            4d * 1024 * 1024 //4MB
        );
        InstrumentSelector messageSizeSelector = InstrumentSelector.builder()
            .setType(InstrumentType.HISTOGRAM)
            .setName(HISTOGRAM_MESSAGE_SIZE)
            .build();
        View messageSizeView = View.builder()
            .setAggregation(Aggregation.explicitBucketHistogram(messageSizeBuckets))
            .build();
        providerBuilder.registerView(messageSizeSelector, messageSizeView);

        for (Pair<InstrumentSelector, View> selectorViewPair : getMetricsView()) {
            providerBuilder.registerView(selectorViewPair.getObject1(), selectorViewPair.getObject2());
        }
    }

    private void initStatsMetrics() {

        BlockingDeque<Integer> eventTargetQueue = new LinkedBlockingDeque<>(100);
        BlockingDeque<Integer> eventRuleQueue = new LinkedBlockingDeque<>(1000);
        BlockingDeque<Integer> eventSinkQueue = new LinkedBlockingDeque(1000);
        processorWatermark = brokerMeter.gaugeBuilder(GAUGE_PROCESSOR_WATERMARK)
            .setDescription("Request processor watermark")
            .ofLongs()
            .buildWithCallback(measurement -> {
                measurement.record(eventTargetQueue.size(), newAttributesBuilder().put(LABEL_PROCESSOR, "send").build());
                measurement.record(eventRuleQueue.size(), newAttributesBuilder().put(LABEL_PROCESSOR, "async_put").build());
                measurement.record(eventSinkQueue.size(), newAttributesBuilder().put(LABEL_PROCESSOR, "pull").build());
            });
    }

    private void initRequestMetrics() {
        messagesInTotal = brokerMeter.counterBuilder(COUNTER_MESSAGES_IN_TOTAL)
            .setDescription("Total number of incoming messages")
            .build();

        messagesOutTotal = brokerMeter.counterBuilder(COUNTER_MESSAGES_OUT_TOTAL)
            .setDescription("Total number of outgoing messages")
            .build();

        throughputInTotal = brokerMeter.counterBuilder(COUNTER_THROUGHPUT_IN_TOTAL)
            .setDescription("Total traffic of incoming messages")
            .build();

        throughputOutTotal = brokerMeter.counterBuilder(COUNTER_THROUGHPUT_OUT_TOTAL)
            .setDescription("Total traffic of outgoing messages")
            .build();

        messageSize = brokerMeter.histogramBuilder(HISTOGRAM_MESSAGE_SIZE)
            .setDescription("Incoming messages size")
            .ofLongs()
            .build();
    }

    public static void initMetrics(Meter meter) {
        invokeLatency = meter.histogramBuilder(HISTOGRAM_RPC_LATENCY)
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


    public void shutdown() {
        if (brokerConfig.getMetricsExporterType() == BridgeConfig.MetricsExporterType.OTLP_GRPC) {
            periodicMetricReader.forceFlush();
            periodicMetricReader.shutdown();
            metricExporter.shutdown();
        }
        if (brokerConfig.getMetricsExporterType() == BridgeConfig.MetricsExporterType.PROM) {
            prometheusHttpServer.forceFlush();
            prometheusHttpServer.shutdown();
        }
        if (brokerConfig.getMetricsExporterType() == BridgeConfig.MetricsExporterType.LOG) {
            periodicMetricReader.forceFlush();
            periodicMetricReader.shutdown();
            loggingMetricExporter.shutdown();
        }
    }

}
