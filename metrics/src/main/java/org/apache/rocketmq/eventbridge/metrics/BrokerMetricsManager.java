package org.apache.rocketmq.eventbridge.metrics;

import com.google.common.base.Splitter;
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


import static org.apache.rocketmq.eventbridge.metrics.BrokerMetricsConstant.AGGREGATION_DELTA;
import static org.apache.rocketmq.eventbridge.metrics.BrokerMetricsConstant.COUNTER_MESSAGES_IN_TOTAL;
import static org.apache.rocketmq.eventbridge.metrics.BrokerMetricsConstant.COUNTER_MESSAGES_OUT_TOTAL;
import static org.apache.rocketmq.eventbridge.metrics.BrokerMetricsConstant.COUNTER_THROUGHPUT_IN_TOTAL;
import static org.apache.rocketmq.eventbridge.metrics.BrokerMetricsConstant.COUNTER_THROUGHPUT_OUT_TOTAL;
import static org.apache.rocketmq.eventbridge.metrics.BrokerMetricsConstant.GAUGE_PROCESSOR_WATERMARK;
import static org.apache.rocketmq.eventbridge.metrics.BrokerMetricsConstant.HISTOGRAM_MESSAGE_SIZE;
import static org.apache.rocketmq.eventbridge.metrics.BrokerMetricsConstant.LABEL_AGGREGATION;
import static org.apache.rocketmq.eventbridge.metrics.BrokerMetricsConstant.LABEL_PROCESSOR;
import static org.apache.rocketmq.eventbridge.metrics.BrokerMetricsConstant.OPEN_TELEMETRY_METER_NAME;

/**
 * 待接入Runtimer或者RocketMQEventSubscriber
 */
public class BrokerMetricsManager {
    private static final Logger LOGGER = LoggerFactory.getLogger(BrokerMetricsManager.class);

    private final BrokerConfig brokerConfig;
    private final static Map<String, String> LABEL_MAP = new HashMap<>();
    private OtlpGrpcMetricExporter metricExporter;
    private PeriodicMetricReader periodicMetricReader;
    private PrometheusHttpServer prometheusHttpServer;
    private LoggingMetricExporter loggingMetricExporter;
    private Meter brokerMeter;

    // broker stats metrics
    public static ObservableLongGauge processorWatermark = new NopObservableLongGauge();

    // request metrics
    public static LongCounter messagesInTotal = new NopLongCounter();
    public static LongCounter messagesOutTotal = new NopLongCounter();
    public static LongCounter throughputInTotal = new NopLongCounter();
    public static LongCounter throughputOutTotal = new NopLongCounter();
    public static LongHistogram messageSize = new NopLongHistogram();

    public BrokerMetricsManager(BrokerConfig brokerConfig) {
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
        BrokerConfig.MetricsExporterType exporterType = brokerConfig.getMetricsExporterType();
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

    private void init() {
        BrokerConfig.MetricsExporterType metricsExporterType = brokerConfig.getMetricsExporterType();
        if (metricsExporterType == BrokerConfig.MetricsExporterType.DISABLE) {
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

        if (metricsExporterType == BrokerConfig.MetricsExporterType.OTLP_GRPC) {
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

        if (metricsExporterType == BrokerConfig.MetricsExporterType.PROM) {
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

        if (metricsExporterType == BrokerConfig.MetricsExporterType.LOG) {
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

        for (Pair<InstrumentSelector, View> selectorViewPair : RemotingMetricsManager.getMetricsView()) {
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


    public void shutdown() {
        if (brokerConfig.getMetricsExporterType() == BrokerConfig.MetricsExporterType.OTLP_GRPC) {
            periodicMetricReader.forceFlush();
            periodicMetricReader.shutdown();
            metricExporter.shutdown();
        }
        if (brokerConfig.getMetricsExporterType() == BrokerConfig.MetricsExporterType.PROM) {
            prometheusHttpServer.forceFlush();
            prometheusHttpServer.shutdown();
        }
        if (brokerConfig.getMetricsExporterType() == BrokerConfig.MetricsExporterType.LOG) {
            periodicMetricReader.forceFlush();
            periodicMetricReader.shutdown();
            loggingMetricExporter.shutdown();
        }
    }

}
