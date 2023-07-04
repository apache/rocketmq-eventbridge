package org.apache.rocketmq.eventbridge.metrics;

import io.opentelemetry.api.common.Attributes;
import io.opentelemetry.api.metrics.LongUpDownCounter;
import io.opentelemetry.context.Context;


public class NopLongUpDownCounter implements LongUpDownCounter {
    @Override public void add(long l) {

    }

    @Override public void add(long l, Attributes attributes) {

    }

    @Override public void add(long l, Attributes attributes, Context context) {

    }
}