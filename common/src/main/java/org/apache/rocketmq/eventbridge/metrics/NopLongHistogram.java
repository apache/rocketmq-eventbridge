package org.apache.rocketmq.eventbridge.metrics;

import io.opentelemetry.api.common.Attributes;
import io.opentelemetry.api.metrics.LongHistogram;
import io.opentelemetry.context.Context;

public class NopLongHistogram implements LongHistogram {
    @Override public void record(long l) {

    }

    @Override public void record(long l, Attributes attributes) {

    }

    @Override public void record(long l, Attributes attributes, Context context) {

    }
}