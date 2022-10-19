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

package org.apache.rocketmq.eventbridge.tools.pattern;

import com.google.gson.JsonElement;
import java.util.ArrayList;
import java.util.List;

/**
 * Given the below json rule, contains two pattern entries, the ruleName of second RuleEntry is `risk-score`, while the
 * rulePath is `$.detail.risk-score`
 * <p>
 * { "source": ["aliyun.rocketmq"], "detail": { "risk-score": [80], } }
 */
public class PatternEntry {
    /**
     * Name of the PatternEntry
     */
    private String patternName;

    /**
     * Path of the PatternEntry, follow the spec of json-path
     *
     * @see "https://github.com/json-path/JsonPath"
     */
    private String patternPath;

    /**
     * Type of the PatternEntry
     */
    private PatternType patternType = PatternType.OR;

    /**
     * Condition of the PatternEntry
     */
    private List<PatternCondition> conditionList = new ArrayList<>();

    public PatternEntry(final String patternName, final String patternPath) {
        this.patternName = patternName;
        this.patternPath = patternPath;
    }

    public void addRuleCondition(PatternCondition patternCondition) {
        this.conditionList.add(patternCondition);
    }

    public String getPatternName() {
        return patternName;
    }

    public String getPatternPath() {
        return patternPath;
    }

    public boolean match(JsonElement jsonElement) {
        if (patternType == PatternType.OR) {
            for (final PatternCondition patternCondition : conditionList) {
                if (patternCondition.match(jsonElement)) {
                    return true;
                }
            }

            return false;
        }

        if (patternType == PatternType.AND) {
            for (final PatternCondition patternCondition : conditionList) {
                if (!patternCondition.match(jsonElement)) {
                    return false;
                }
            }

            return true;
        }

        return false;
    }

    /**
     * Returns the condition list for test only
     *
     * @return the condition list
     */
    List<PatternCondition> getConditionList() {
        return conditionList;
    }
}
