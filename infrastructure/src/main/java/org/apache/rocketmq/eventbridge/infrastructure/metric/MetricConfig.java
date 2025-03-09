/*
 * Licensed to the Apache Software Foundation (ASF) under one
 * or more contributor license agreements.  See the NOTICE file
 * distributed with this work for additional information
 * regarding copyright ownership.  The ASF licenses this file
 * to you under the Apache License, Version 2.0 (the
 * "License"); you may not use this file except in compliance
 * with the License.  You may obtain a copy of the License at
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

import lombok.Data;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.boot.context.properties.EnableConfigurationProperties;
import org.springframework.context.annotation.Configuration;

@Data
@ConfigurationProperties(prefix="metrics")
@EnableConfigurationProperties
@Configuration
public class MetricConfig {

    private MetricsExporterType metricsExporterType = MetricsExporterType.DISABLE;

    private String labels;

    private boolean inDelta = false;

    private int otelCardinalityLimit = 50 * 1000;

    private String grpcExporterTarget = "";

    private String grpcExporterHeader = "";

    private long grpcExporterTimeOutInMills = 3 * 1000;

    private long grpcExporterIntervalInMills = 60 * 1000;

    private long loggingExporterIntervalInMills = 10 * 1000;

    private int metricsOtelCardinalityLimit = 50 * 1000;

    private int promExporterPort = 5557;

    private String promExporterHost = "localhost";
}
