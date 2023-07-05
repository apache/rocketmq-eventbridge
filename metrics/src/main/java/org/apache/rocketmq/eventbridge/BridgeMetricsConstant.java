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
}
