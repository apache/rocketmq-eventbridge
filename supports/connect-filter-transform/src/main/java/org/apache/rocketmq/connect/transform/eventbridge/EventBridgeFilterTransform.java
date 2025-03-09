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
package org.apache.rocketmq.connect.transform.eventbridge;

import com.google.common.collect.Maps;
import com.google.gson.Gson;
import com.google.gson.JsonElement;
import io.cloudevents.SpecVersion;
import io.openmessaging.KeyValue;
import io.openmessaging.connector.api.component.ComponentContext;
import io.openmessaging.connector.api.data.ConnectRecord;
import org.apache.rocketmq.eventbridge.infrastructure.metric.EventBridgeMetricsConstant;
import org.apache.rocketmq.eventbridge.infrastructure.metric.EventBridgeMetricsManager;
import org.apache.rocketmq.eventbridge.tools.pattern.PatternEvaluator;
import org.apache.rocketmq.eventbridge.tools.pattern.PatternEvaluatorBuilder;

import java.util.Map;

public class EventBridgeFilterTransform implements io.openmessaging.connector.api.component.Transform {

    private PatternEvaluator evaluator;

    @Override
    public ConnectRecord doTransform(ConnectRecord record) {
        exportMetrics(record);
        if (!evaluator.evaluateData(new Gson().toJson(record.getData()))) {
            return null;
        } else if (!evaluator.evaluateSpecAttr(this.buildSpecAttr(record))) {
            return null;
        } else if (!evaluator.evaluateExtensionAttr(this.buildExtensionAttr(record))) {
            return null;
        } else {
            return record;
        }
    }

    private static void exportMetrics(ConnectRecord connectRecord) {
        EventBridgeMetricsManager.eventbridgeEventsTransferInTotal.inc(1L,
                EventBridgeMetricsManager.newAttributesBuilder()
                        .put(EventBridgeMetricsConstant.LABEL_STATUS, "success")
                        .put(EventBridgeMetricsConstant.LABEL_EVENT_BUS_NAME, connectRecord.getExtension("eventbusname"))
                        .put(EventBridgeMetricsConstant.LABEL_ACCOUNT_ID, connectRecord.getExtension("id"))
                        .put(EventBridgeMetricsConstant.LABEL_EVENT_SOURCE, connectRecord.getExtension("source"))
                        .put(EventBridgeMetricsConstant.LABEL_EVENT_TYPE, connectRecord.getExtension("type"))
                        .put(EventBridgeMetricsConstant.LABEL_EVENT_RULE_NAME, connectRecord.getExtension("runner-name"))
                        .put(EventBridgeMetricsConstant.LABEL_TRANSFORM_TYPE, "filter").build());
    }

    private Map<String, JsonElement> buildSpecAttr(ConnectRecord record) {
        Map<String, JsonElement> extensionsAttrs = Maps.newHashMap();
        SpecVersion.V1.getAllAttributes()
            .forEach(key -> {
                if (record.getExtensions()
                    .containsKey(key)) {
                    extensionsAttrs.put(key, new Gson().toJsonTree(record.getExtensions()
                        .getString(key)));
                }
            });
        return extensionsAttrs;
    }

    private Map<String, JsonElement> buildExtensionAttr(ConnectRecord record) {
        Map<String, JsonElement> extensionsAttrs = Maps.newHashMap();
        return extensionsAttrs;
    }

    @Override
    public void validate(KeyValue config) {

    }

    @Override
    public void start(ComponentContext componentContext) {

    }

    @Override
    public void init(KeyValue config) {
        this.evaluator = PatternEvaluatorBuilder.build(config.getString("filterPattern"));
    }

    @Override
    public void stop() {

    }

}
