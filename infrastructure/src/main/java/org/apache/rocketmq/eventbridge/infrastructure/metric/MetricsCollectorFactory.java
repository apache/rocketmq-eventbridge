/*
 * Licensed to the Apache Software Foundation (ASF) under one or more
 * contributor license agreements.  See the NOTICE file distributed with
 * this work for additional information regarding copyright ownership.
 * The ASF licenses this file to You under the Apache License, Version 2.0
 * (the "License"); you may not use this file except in compliance with
 * the License.  You may obtain a copy of the License at
 *
 *     http://www.apache.org/licenses/LICENSE-2.0
 *
 *  Unless required by applicable law or agreed to in writing, software
 *  distributed under the License is distributed on an "AS IS" BASIS,
 *  WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 *  See the License for the specific language governing permissions and
 *  limitations under the License.
 */

package org.apache.rocketmq.eventbridge.infrastructure.metric;

import com.google.common.base.Splitter;
import io.opentelemetry.api.metrics.Meter;
import io.opentelemetry.exporter.logging.otlp.OtlpJsonLoggingMetricExporter;
import io.opentelemetry.exporter.otlp.metrics.OtlpGrpcMetricExporter;
import io.opentelemetry.exporter.otlp.metrics.OtlpGrpcMetricExporterBuilder;
import io.opentelemetry.exporter.prometheus.PrometheusHttpServer;
import io.opentelemetry.sdk.OpenTelemetrySdk;
import io.opentelemetry.sdk.metrics.Aggregation;
import io.opentelemetry.sdk.metrics.InstrumentSelector;
import io.opentelemetry.sdk.metrics.InstrumentType;
import io.opentelemetry.sdk.metrics.SdkMeterProvider;
import io.opentelemetry.sdk.metrics.SdkMeterProviderBuilder;
import io.opentelemetry.sdk.metrics.View;
import io.opentelemetry.sdk.metrics.data.AggregationTemporality;
import io.opentelemetry.sdk.metrics.export.MetricExporter;
import io.opentelemetry.sdk.metrics.export.PeriodicMetricReader;
import io.opentelemetry.sdk.resources.Resource;
import lombok.extern.slf4j.Slf4j;
import org.apache.commons.lang3.StringUtils;
import org.slf4j.bridge.SLF4JBridgeHandler;

import java.time.Duration;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.concurrent.TimeUnit;
import java.util.logging.Logger;

@Slf4j
public class MetricsCollectorFactory {
    public static final String OPEN_TELEMETRY_METER_NAME = "eventbridge-meter";

    public static final String HISTOGRAM_MESSAGE_SIZE = "eventbridge_message_size";

    public static final String EVENTBUS_IN_EVENTS_TOTAL = "eventbridge_eventbus_in_events_total";

    public static final String EVENTRULE_FILTER_EVENTS_TOTAL = "eventbridge_eventrule_filter_events_total";

    public static final String EVENTRULE_LATENCY_SECONDS = "eventbridge_eventrule_latency_seconds";

    public static final String EVENTRULE_TRIGGER_LATENCY = "eventbridge_eventrule_trigger_latency";


    private final static Map<String, String> LABEL_MAP = new HashMap<>();

    private static class MetricsCollectorHolder{
        static MetricsCollectorFactory instance = new MetricsCollectorFactory();
    }

    public static MetricsCollectorFactory getInstance(){
        return MetricsCollectorFactory.MetricsCollectorHolder.instance;
    }


    private MetricsCollectorFactory() {

    }

    public void start(MetricConfig metricConfig) {

        if (!checkConfig(metricConfig)) {
            log.error("check metrics config failed, will not export metrics");
            return;
        }

        MetricsExporterType metricsExporterType = metricConfig.getMetricsExporterType();
        if (metricsExporterType == MetricsExporterType.DISABLE) {
            return;
        }

        SdkMeterProviderBuilder providerBuilder = SdkMeterProvider.builder()
                .setResource(Resource.empty());
        PeriodicMetricReader periodicMetricReader;
        if (metricsExporterType == MetricsExporterType.OTLP_GRPC) {
            String endpoint = metricConfig.getGrpcExporterTarget();
            if (!endpoint.startsWith("http")) {
                endpoint = "https://" + endpoint;
            }
            OtlpGrpcMetricExporterBuilder metricExporterBuilder = OtlpGrpcMetricExporter.builder()
                    .setEndpoint(endpoint)
                    .setTimeout(metricConfig.getGrpcExporterTimeOutInMills(), TimeUnit.MILLISECONDS)
                    .setAggregationTemporalitySelector(type -> {
                        if (metricConfig.isInDelta() &&
                                (type == InstrumentType.COUNTER || type == InstrumentType.OBSERVABLE_COUNTER || type == InstrumentType.HISTOGRAM)) {
                            return AggregationTemporality.DELTA;
                        }
                        return AggregationTemporality.CUMULATIVE;
                    });

            String headers = metricConfig.getGrpcExporterHeader();
            if (StringUtils.isNotBlank(headers)) {
                Map<String, String> headerMap = new HashMap<>();
                List<String> kvPairs = Splitter.on(',').omitEmptyStrings().splitToList(headers);
                for (String item : kvPairs) {
                    String[] split = item.split(":");
                    if (split.length != 2) {
                        log.warn("metricsGrpcExporterHeader is not valid: {}", headers);
                        continue;
                    }
                    headerMap.put(split[0], split[1]);
                }
                headerMap.forEach(metricExporterBuilder::addHeader);
            }

            OtlpGrpcMetricExporter metricExporter = metricExporterBuilder.build();

            periodicMetricReader = PeriodicMetricReader.builder(metricExporter)
                    .setInterval(metricConfig.getGrpcExporterIntervalInMills(), TimeUnit.MILLISECONDS)
                    .build();

            providerBuilder.registerMetricReader(periodicMetricReader);
        }
        PrometheusHttpServer prometheusHttpServer;
        if (metricsExporterType == MetricsExporterType.PROM) {
            String promExporterHost = metricConfig.getPromExporterHost();
            prometheusHttpServer = PrometheusHttpServer.builder()
                    .setHost(promExporterHost)
                    .setPort(metricConfig.getPromExporterPort())
                    .build();
            providerBuilder.registerMetricReader(prometheusHttpServer);
        }

        MetricExporter loggingMetricExporter;
        if (metricsExporterType == MetricsExporterType.LOG) {
            SLF4JBridgeHandler.removeHandlersForRootLogger();
            SLF4JBridgeHandler.install();
            loggingMetricExporter = OtlpJsonLoggingMetricExporter.create(metricConfig.isInDelta() ? AggregationTemporality.DELTA : AggregationTemporality.CUMULATIVE);
            Logger.getLogger(OtlpJsonLoggingMetricExporter.class.getName()).setLevel(java.util.logging.Level.FINEST);
            periodicMetricReader = PeriodicMetricReader.builder(loggingMetricExporter)
                    .setInterval(metricConfig.getLoggingExporterIntervalInMills(), TimeUnit.MILLISECONDS)
                    .build();
            providerBuilder.registerMetricReader(periodicMetricReader);
        }

        registerMetricsView(providerBuilder);

        Meter brokerMeter = OpenTelemetrySdk.builder()
                .setMeterProvider(providerBuilder.build())
                .build()
                .getMeter(OPEN_TELEMETRY_METER_NAME);
        EventBridgeMetricsManager.initMetricsView(brokerMeter);
    }

    public static boolean checkConfig(MetricConfig metricConfig) {
        if (metricConfig == null) {
            return false;
        }
        MetricsExporterType exporterType = metricConfig.getMetricsExporterType();
        if (!exporterType.isEnable()) {
            return false;
        }

        switch (exporterType) {
            case OTLP_GRPC:
                return StringUtils.isNotBlank(metricConfig.getGrpcExporterTarget());
            case PROM:
                return true;
            case LOG:
                return true;
        }
        return false;
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
                .setName(EVENTRULE_TRIGGER_LATENCY)
                .build();
        View view = View.builder()
                .setAggregation(Aggregation.explicitBucketHistogram(rpcCostTimeBuckets))
                .build();

        providerBuilder.registerView(selector, view);
    }

}
