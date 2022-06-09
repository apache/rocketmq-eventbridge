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
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */

package org.apache.rocketmq.eventbridge.domain.common;

import java.util.Set;
import java.util.regex.Pattern;

import com.google.common.collect.Sets;

public class EventBridgeConstants {

    //common name pattern
    public static final Pattern RESOURCE_NAME_PATTERN = Pattern.compile("^[A-Za-z|0-9][A-Za-z|0-9|_|-]+$");

    //event bus
    public static final int EVENT_BUS_NAME_MAX_LENGTH = 127;
    public static final int EVENT_BUS_NAME_MIN_LENGTH = 1;
    public static final int EVENT_BUS_COUNT_LIMIT = 10;
    public static final Set<String> RESERVED_EVENT_BUS_NAMES = Sets.newHashSet("default");
    public static final String RESERVED_EVENT_BUS_PREFIX = "eventbridge-reserved-";

    //event rule
    public static final int EVENT_RULE_NAME_MAX_LENGTH = 127;
    public static final int EVENT_RULE_NAME_MIN_LENGTH = 1;
    public static final int EVENT_RULE_COUNT_LIMIT = 10;
    public static final String RESERVED_EVENT_RULE_PREFIX = "eventbridge-reserved-";

    //event source
    public static final int EVENT_SOURCE_NAME_MAX_LENGTH = 127;
    public static final int EVENT_SOURCE_NAME_MIN_LENGTH = 1;
    public static final int EVENT_SOURCE_COUNT_LIMIT = 10;
    public static final String RESERVED_EVENT_SOURCE_PREFIX = "eventbridge-reserved-";

    //api destination
    public static final int API_DESTINATION_COUNT_LIMIT = 10;

    //connection
    public static final int CONNECTION_COUNT_LIMIT = 10;

    public static final String SYSTEM_ENVIRONMENT_ACCOUNT_ID = "AccountId";

}
