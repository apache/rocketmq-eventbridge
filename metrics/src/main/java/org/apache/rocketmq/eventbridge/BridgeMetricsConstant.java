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

import java.util.HashMap;
import java.util.Map;

public class BridgeMetricsConstant {
    public static final String OPEN_TELEMETRY_METER_NAME = "bridge-meter";
    public static final String HISTOGRAM_MESSAGE_SIZE = "eventbridge_message_size";
    public static final String EVENTBUS_IN_EVENTS_TOTAL = "eventbridge_eventbus_in_events_total";
    public static final String EVENTRULE_FILTER_EVENTS_TOTAL = "eventbridge_eventrule_filter_events_total";
    public static final String EVENTRULE_LATENCY_SECONDS = "eventbridge_eventrule_latency_seconds";

    public static final String EVENTRULE_TRIGGER_LATENCY = "eventbridge_eventrule_trigger_latency";


    public enum  Status {
        SUCCESS("success"),
        FAILED("failed");

        private String status;
        Status(String status){
            this.status = status;
        }
        public String getStatus() {
            return status;
        }
    }

}
