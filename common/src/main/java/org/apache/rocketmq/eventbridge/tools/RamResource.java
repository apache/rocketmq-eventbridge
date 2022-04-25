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
public enum RamResource {
    EventBusAll("acs:eventbridge:%s:%s:eventbus/*"),

    /**
     * EventBus 资源Pattern
     */
    EventBus("acs:eventbridge:%s:%s:eventbus/%s"),

    EventRuleAll("acs:eventbridge:%s:%s:eventbus/%s/rule/*"),

    /**
     * EventRule 资源Pattern
     */
    EventRule("acs:eventbridge:%s:%s:eventbus/%s/rule/%s"),

    /**
     * EventSource 资源Pattern
     */
    EventSource("acs:eventbridge:%s:%s:eventbus/%s/eventsource/%s"),

    /**
     * EventStreaming 资源Pattern
     */
    EventStreaming("acs:eventbridge:%s:%s:eventstreaming/%s"),

    ;

    private String arnPattern;

    RamResource(String arnPattern) {
        this.arnPattern = arnPattern;
    }

    public String getArnPattern() {
        return arnPattern;
    }
}
