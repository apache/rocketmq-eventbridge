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

public class EventBridgeMetricsConstant {

    public static final String HISTOGRAM_EVENTBRIDGE_PUTEVENTS_LATENCY = "eventbridge_putevents_latency";

    public static final String HISTOGRAM_EVENTBRIDGE_PUTEVENTS_SIZE = "eventbridge_putevents_size";

    public static final String GAUGE_EVENTBRIDGE_EVENT_RULE_LATENCY = "eventbridge_event_rule_latency";

    public static final String COUNTER_EVENTBRIDGE_EVENT_RULE_LAG_EVENTS_TOTAL = "eventbridge_event_rule_lag_events_total";

    public static final String COUNTER_EVENTBRIDGE_EVENTS_TRANSFER_IN_TOTAL = "eventbridge_events_transfer_in_total";

    public static final String COUNTER_EVENTBRIDGE_EVENTS_TRANSFER_OUT_TOTAL = "eventbridge_events_transfer_out_total";

    public static final String GAUGE_EVENTBRIDGE_EVENTS_TRANSFER_LATENCY = "eventbridge_events_transfer_latency";

    public static final String HISTOGRAM_EVENTBRIDGE_EVENTS_TRIGGER_LATENCY = "eventbridge_events_trigger_latency";

    public static final String GAUGE_EVENTBRIDGE_EVENTS_LATENCY = "eventbridge_events_latency";

    //状态
    public static final String LABEL_STATUS = "status";

    //名称
    public static final String LABEL_EVENT_BUS_NAME = "event_bus_name";

    //账户Id
    public static final String LABEL_ACCOUNT_ID = "accountId";

    //件源
    public static final String LABEL_EVENT_SOURCE = "event_source";

    //事件类型
    public static final String LABEL_EVENT_TYPE = "event_type";

    //规则名称
    public static final String LABEL_EVENT_RULE_NAME = "event_rule_name";

    //转换类型
    public static final String LABEL_TRANSFORM_TYPE = "transform_type";

    //目标名称
    public static final String LABEL_EVENT_TARGET_NAME = "event_target_name";

    //目标类型
    public static final String LABEL_EVENT_TARGET_TYPE = "event_target_type";
}
