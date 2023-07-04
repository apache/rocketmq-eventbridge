package org.apache.rocketmq.eventbridge.metrics;

import io.opentelemetry.api.common.Attributes;
import io.opentelemetry.api.metrics.LongCounter;
import io.opentelemetry.context.Context;

public class NopLongCounter implements LongCounter {
    @Override public void add(long l) {

    }

    @Override public void add(long l, Attributes attributes) {

    }

    @Override public void add(long l, Attributes attributes, Context context) {

    }
}
