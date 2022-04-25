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

package org.apache.rocketmq.eventbridge.tools;

/**
 * @Author changfeng
 * @Date 2022/4/25 11:22 上午
 */
public class ARNHelper {
    public static final String EVENTBUS_ALL = "eventbus/*";
    public static final String EVENTBUS_PATTERN = "eventbus/%s";
    public static final String EVENTRULE_ALL = "eventbus/%s/rule/*";
    public static final String EVENTRULE_PATTERN = "eventbus/%s/rule/%s";

    public static String getEventBusARN(String region, String accountId, String eventBusName) {
        return String.format(RamResource.EventBus.getArnPattern(), region, accountId, eventBusName);
    }

    public static String getRuleARN(String region, String accountId, String eventBusName, String ruleName) {
        return String.format(RamResource.EventRule.getArnPattern(), region, accountId, eventBusName, ruleName);
    }

    public static String getEventSourceARN(String region, String accountId, String eventBusName,
                                           String eventSourceFullName) {
        return String.format(RamResource.EventSource.getArnPattern(), region, accountId, eventBusName,
                eventSourceFullName);
    }

    public static String getEventStreamingARN(String region, String accountId, String eventStreamingName) {
        return String.format(RamResource.EventStreaming.getArnPattern(), region, accountId, eventStreamingName);
    }

    public static String buildEventBusAll() {
        return EVENTBUS_ALL;
    }

    public static String buildEventBus(String eventBusName) {
        return String.format(EVENTBUS_PATTERN, eventBusName);
    }

    public static String buildEventRuleAll(String eventBusName) {
        return String.format(EVENTRULE_ALL, eventBusName);
    }

    public static String buildEventRule(String eventBusName, String eventRuleName) {
        return String.format(EVENTRULE_PATTERN, eventBusName, eventRuleName);
    }
}
