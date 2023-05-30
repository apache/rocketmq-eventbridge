package org.apache.rocketmq.eventbridge.metrics;

public class BridgeMetricsConstant {
    public static final String OPEN_TELEMETRY_METER_NAME = "bridge-meter";

    public static final String GAUGE_PROCESSOR_GAUGE = "target_queue_gauge";
    public static final String RULE_QUEUE_GAUGE = "rule_queue_gauge";

    public static final String COUNTER_MESSAGES_IN_TOTAL = "eventbridge_messages_in_total";
    public static final String COUNTER_MESSAGES_OUT_TOTAL = "eventbridge_messages_out_total";
    public static final String COUNTER_THROUGHPUT_IN_TOTAL = "eventbridge_throughput_in_total";
    public static final String COUNTER_THROUGHPUT_OUT_TOTAL = "eventbridge_throughput_out_total";
    public static final String HISTOGRAM_MESSAGE_SIZE = "eventbridge_message_size";


    /** eventbridge process message latency**/
    public static final String HISTOGRAM_RPC_LATENCY = "process_latency";

    public static final String LABEL_AGGREGATION = "aggregation";
    public static final String AGGREGATION_DELTA = "delta";
    public static final String LABEL_PROCESSOR = "processor";
}
