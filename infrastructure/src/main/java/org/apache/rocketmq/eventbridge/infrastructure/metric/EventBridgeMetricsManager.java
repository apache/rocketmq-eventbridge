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

@UtilityClass
public class EventBridgeMetricsManager {

    public static Supplier<AttributesBuilder> attributesBuilderSupplier = Attributes::builder;

    public final static List<Metric> metrics = new ArrayList<>();

    public static Histogram eventbridgePutEventsLatency = new DoubleHistogram("eventbridge_putevents_latency");

    public static Histogram eventbridgePutEventsSize = new DoubleHistogram("eventbridge_putevents_size");

    public static ObservableGauge observableDoubleGauge = new DoubleObserverGauge("eventbridge_event_rule_latency");

    public static Counter eventbridgeEventRuleLagEventsTotal = new LongCounter("eventbridge_event_rule_lag_events_total");

    public static Counter eventbridgeEventsTransferInTotal = new LongCounter("eventbridge_events_transfer_in_total");

    public static Counter eventbridgeEventsTransferOutTotal = new LongCounter("eventbridge_events_transfer_out_total");

    public static ObservableGauge eventbridgeEventsTransferLatency = new DoubleObserverGauge("eventbridge_events_transfer_latency");

    public static Histogram eventbridgeEventsTriggerLatency = new DoubleHistogram("eventbridge_events_trigger_latency");

    public static ObservableGauge eventbridgeEventsLatency = new DoubleObserverGauge("eventbridge_events_latency");

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
