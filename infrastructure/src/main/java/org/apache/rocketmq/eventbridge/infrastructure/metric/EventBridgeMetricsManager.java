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
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */
package org.apache.rocketmq.eventbridge.infrastructure.metric;

import io.opentelemetry.api.common.Attributes;
import io.opentelemetry.api.common.AttributesBuilder;
import io.opentelemetry.api.metrics.Meter;
import lombok.experimental.UtilityClass;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.function.Supplier;

import static org.apache.rocketmq.eventbridge.infrastructure.metric.EventBridgeMetricsConstant.COUNTER_EVENTBRIDGE_EVENTS_TRANSFER_IN_TOTAL;
import static org.apache.rocketmq.eventbridge.infrastructure.metric.EventBridgeMetricsConstant.COUNTER_EVENTBRIDGE_EVENTS_TRANSFER_OUT_TOTAL;
import static org.apache.rocketmq.eventbridge.infrastructure.metric.EventBridgeMetricsConstant.COUNTER_EVENTBRIDGE_EVENT_RULE_LAG_EVENTS_TOTAL;
import static org.apache.rocketmq.eventbridge.infrastructure.metric.EventBridgeMetricsConstant.GAUGE_EVENTBRIDGE_EVENTS_LATENCY;
import static org.apache.rocketmq.eventbridge.infrastructure.metric.EventBridgeMetricsConstant.GAUGE_EVENTBRIDGE_EVENTS_TRANSFER_LATENCY;
import static org.apache.rocketmq.eventbridge.infrastructure.metric.EventBridgeMetricsConstant.GAUGE_EVENTBRIDGE_EVENT_RULE_LATENCY;
import static org.apache.rocketmq.eventbridge.infrastructure.metric.EventBridgeMetricsConstant.HISTOGRAM_EVENTBRIDGE_EVENTS_TRIGGER_LATENCY;
import static org.apache.rocketmq.eventbridge.infrastructure.metric.EventBridgeMetricsConstant.HISTOGRAM_EVENTBRIDGE_PUTEVENTS_LATENCY;
import static org.apache.rocketmq.eventbridge.infrastructure.metric.EventBridgeMetricsConstant.HISTOGRAM_EVENTBRIDGE_PUTEVENTS_SIZE;

@UtilityClass
public class EventBridgeMetricsManager {

    public static Supplier<AttributesBuilder> attributesBuilderSupplier = Attributes::builder;

    public final static List<Metric> metrics = new ArrayList<>();

    public static Histogram eventbridgePutEventsLatency = new DoubleHistogram(HISTOGRAM_EVENTBRIDGE_PUTEVENTS_LATENCY);

    public static Histogram eventbridgePutEventsSize = new DoubleHistogram(HISTOGRAM_EVENTBRIDGE_PUTEVENTS_SIZE);

    public static ObservableGauge observableDoubleGauge = new DoubleObserverGauge(GAUGE_EVENTBRIDGE_EVENT_RULE_LATENCY);

    public static Counter eventbridgeEventRuleLagEventsTotal = new LongCounter(COUNTER_EVENTBRIDGE_EVENT_RULE_LAG_EVENTS_TOTAL);

    public static Counter eventbridgeEventsTransferInTotal = new LongCounter(COUNTER_EVENTBRIDGE_EVENTS_TRANSFER_IN_TOTAL);

    public static Counter eventbridgeEventsTransferOutTotal = new LongCounter(COUNTER_EVENTBRIDGE_EVENTS_TRANSFER_OUT_TOTAL);

    public static ObservableGauge eventbridgeEventsTransferLatency = new DoubleObserverGauge(GAUGE_EVENTBRIDGE_EVENTS_TRANSFER_LATENCY);

    public static Histogram eventbridgeEventsTriggerLatency = new DoubleHistogram(HISTOGRAM_EVENTBRIDGE_EVENTS_TRIGGER_LATENCY);

    public static ObservableGauge eventbridgeEventsLatency = new DoubleObserverGauge(GAUGE_EVENTBRIDGE_EVENTS_LATENCY);

    private final static Map<String, String> LABEL_MAP = new HashMap<>();

    static  {
        metrics.add(eventbridgePutEventsLatency);
        metrics.add(eventbridgePutEventsSize);
        metrics.add(observableDoubleGauge);
        metrics.add(eventbridgeEventRuleLagEventsTotal);
        metrics.add(eventbridgeEventsTransferInTotal);
        metrics.add(eventbridgeEventsTransferOutTotal);
        metrics.add(eventbridgeEventsTransferLatency);
        metrics.add(eventbridgeEventsTriggerLatency);
        metrics.add(eventbridgeEventsLatency);
    }

    public static AttributesBuilder newAttributesBuilder() {
        AttributesBuilder attributesBuilder;
        if (attributesBuilderSupplier == null) {
            attributesBuilderSupplier = Attributes::builder;
        }
        attributesBuilder = attributesBuilderSupplier.get();
        LABEL_MAP.forEach(attributesBuilder::put);
        return attributesBuilder;
    }

    public static void initMetricsView(Meter brokerMeter) {
        for(Metric metric : metrics) {
            if (metric instanceof Counter) {
                metric.setInstrument(brokerMeter.counterBuilder(metric.getMetricName()).build());;
            } else if (metric instanceof ObservableCounter) {
                metric.setInstrument(brokerMeter.counterBuilder(metric.getMetricName()).buildObserver());
            } else if (metric instanceof Histogram) {
                metric.setInstrument(brokerMeter.histogramBuilder(metric.getMetricName()).build());
            } else if (metric instanceof Gauge) {
                metric.setInstrument(brokerMeter.gaugeBuilder(metric.getMetricName()).build());
            } else if (metric instanceof ObservableGauge) {
                metric.setInstrument(brokerMeter.gaugeBuilder(metric.getMetricName()).buildObserver());
            }
        }

    }

}
