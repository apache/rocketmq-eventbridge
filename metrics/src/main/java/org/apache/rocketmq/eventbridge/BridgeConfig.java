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

package org.apache.rocketmq.eventbridge;

public class BridgeConfig {
    public enum MetricsExporterType {
        DISABLE(0),
        OTLP_GRPC(1),
        PROM(2),
        LOG(3);

        private final int value;

        MetricsExporterType(int value) {
            this.value = value;
        }

        public int getValue() {
            return value;
        }

        public static MetricsExporterType valueOf(int value) {
            switch (value) {
                case 1:
                    return OTLP_GRPC;
                case 2:
                    return PROM;
                case 3:
                    return LOG;
                default:
                    return DISABLE;
            }
        }

        public boolean isEnable() {
            return this.value > 0;
        }
    }

    private MetricsExporterType metricsExporterType = MetricsExporterType.DISABLE;

    private String metricsGrpcExporterTarget = "";
    private String metricsGrpcExporterHeader = "";
    private long metricGrpcExporterTimeOutInMills = 3 * 1000;
    private long metricGrpcExporterIntervalInMills = 60 * 1000;
    private long metricLoggingExporterIntervalInMills = 10 * 1000;

    private int metricsPromExporterPort = 5557;
    private String metricsPromExporterHost = "";

    // Label pairs in CSV. Each label follows pattern of Key:Value. eg: instance_id:xxx,uid:xxx
    private String metricsLabel = "";

    private boolean metricsInDelta = false;

    private String eventBridgeAddress;


    public MetricsExporterType getMetricsExporterType() {
        return metricsExporterType;
    }

    public void setMetricsExporterType(MetricsExporterType metricsExporterType) {
        this.metricsExporterType = metricsExporterType;
    }

    public void setMetricsExporterType(int metricsExporterType) {
        this.metricsExporterType = MetricsExporterType.valueOf(metricsExporterType);
    }

    public void setMetricsExporterType(String metricsExporterType) {
        this.metricsExporterType = MetricsExporterType.valueOf(metricsExporterType);
    }

    public String getMetricsGrpcExporterTarget() {
        return metricsGrpcExporterTarget;
    }

    public void setMetricsGrpcExporterTarget(String metricsGrpcExporterTarget) {
        this.metricsGrpcExporterTarget = metricsGrpcExporterTarget;
    }

    public String getMetricsGrpcExporterHeader() {
        return metricsGrpcExporterHeader;
    }

    public void setMetricsGrpcExporterHeader(String metricsGrpcExporterHeader) {
        this.metricsGrpcExporterHeader = metricsGrpcExporterHeader;
    }

    public long getMetricGrpcExporterTimeOutInMills() {
        return metricGrpcExporterTimeOutInMills;
    }

    public void setMetricGrpcExporterTimeOutInMills(long metricGrpcExporterTimeOutInMills) {
        this.metricGrpcExporterTimeOutInMills = metricGrpcExporterTimeOutInMills;
    }

    public long getMetricGrpcExporterIntervalInMills() {
        return metricGrpcExporterIntervalInMills;
    }

    public void setMetricGrpcExporterIntervalInMills(long metricGrpcExporterIntervalInMills) {
        this.metricGrpcExporterIntervalInMills = metricGrpcExporterIntervalInMills;
    }

    public long getMetricLoggingExporterIntervalInMills() {
        return metricLoggingExporterIntervalInMills;
    }

    public void setMetricLoggingExporterIntervalInMills(long metricLoggingExporterIntervalInMills) {
        this.metricLoggingExporterIntervalInMills = metricLoggingExporterIntervalInMills;
    }

    public String getMetricsLabel() {
        return metricsLabel;
    }

    public void setMetricsLabel(String metricsLabel) {
        this.metricsLabel = metricsLabel;
    }

    public boolean isMetricsInDelta() {
        return metricsInDelta;
    }

    public void setMetricsInDelta(boolean metricsInDelta) {
        this.metricsInDelta = metricsInDelta;
    }

    public int getMetricsPromExporterPort() {
        return metricsPromExporterPort;
    }

    public void setMetricsPromExporterPort(int metricsPromExporterPort) {
        this.metricsPromExporterPort = metricsPromExporterPort;
    }

    public String getMetricsPromExporterHost() {
        return metricsPromExporterHost;
    }

    public void setMetricsPromExporterHost(String metricsPromExporterHost) {
        this.metricsPromExporterHost = metricsPromExporterHost;
    }

    public String getEventBridgeAddress() {
        return eventBridgeAddress;
    }

    public void setEventBridgeAddress(String eventBridgeAddress) {
        this.eventBridgeAddress = eventBridgeAddress;
    }
}
