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
import io.opentelemetry.api.metrics.ObservableLongMeasurement;
import org.apache.rocketmq.eventbridge.infrastructure.metric.otlp.NopObservableLongCounter;

public class LongObserverCounter implements ObservableCounter<Long, Attributes, ObservableLongMeasurement> {

    private io.opentelemetry.api.metrics.ObservableLongMeasurement observableLongCounter = new NopObservableLongCounter();

    private final String metricName;

    public LongObserverCounter(String metricName) {
        this.metricName = metricName;
    }

    @Override
    public void inc(Attributes attachment) {
        observableLongCounter.record(1, attachment);
    }

    @Override
    public void inc(Long n, Attributes attachment) {
        observableLongCounter.record(n, attachment);
    }

    @Override
    public String getMetricName() {
        return this.metricName;
    }

    @Override
    public void setInstrument(ObservableLongMeasurement instrument) {
        this.observableLongCounter = instrument;
    }
}
