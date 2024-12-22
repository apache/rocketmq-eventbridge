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

import io.opentelemetry.api.common.Attributes;
import org.apache.rocketmq.eventbridge.infrastructure.metric.otlp.NopDoubleHistogram;

public class DoubleHistogram implements Histogram<Double, Attributes, io.opentelemetry.api.metrics.DoubleHistogram> {

    private io.opentelemetry.api.metrics.DoubleHistogram doubleHistogram = new NopDoubleHistogram();

    @Override
    public void update(Double value, Attributes attachment) {
        doubleHistogram.record(value, attachment);
    }

    @Override
    public io.opentelemetry.api.metrics.DoubleHistogram getValue() {
        return doubleHistogram;
    }

    @Override
    public String getMetricName() {
        return "LongHistogram";
    }

    @Override
    public void setInstrument(io.opentelemetry.api.metrics.DoubleHistogram instrument) {
        this.doubleHistogram = instrument;
    }
}
