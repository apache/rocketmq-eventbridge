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

import java.net.InetAddress;
import java.util.ArrayList;
import java.util.List;

import com.google.gson.JsonElement;
import com.google.gson.JsonNull;
import com.google.gson.JsonPrimitive;
import org.apache.commons.net.util.SubnetUtils;

/**
 * The interface of all PatternCondition implementation
 */
public interface PatternCondition {
    /**
     * Tests the provided json element whether matches the pattern condition
     *
     * @param jsonData the provided json element to test
     *
     * @return true if match, false otherwise
     */
    boolean match(JsonElement jsonData);
}

abstract class AbstractPatternCondition implements PatternCondition {
    @Override
    public boolean match(JsonElement jsonData) {
        if (jsonData == null) {
            // Only ExistsCondition instance accept a null data
            return this instanceof ExistsCondition && this.matchPrimitive(null);
        }

        if (!check(jsonData)) {
            return false;
        }

        if (jsonData.isJsonPrimitive()) {
            return matchPrimitive(jsonData.getAsJsonPrimitive());
        }

        if (jsonData.isJsonNull()) {
            return matchNull(jsonData.getAsJsonNull());
        }

        // If the value in the event is an array, then the pattern matches if the intersection of the pattern array
        // and the event array is non-empty.
        for (final JsonElement element : jsonData.getAsJsonArray()) {
            if (element.isJsonPrimitive() && matchPrimitive(element.getAsJsonPrimitive())) {
                return true;
            }

            if (element.isJsonNull() && matchNull(element.getAsJsonNull())) {
                return true;
            }
        }

        return false;
    }

    boolean check(JsonElement jsonData) {
        if (jsonData.isJsonObject()) {
            return false;
        }

        if (jsonData.isJsonArray()) {
            for (final JsonElement element : jsonData.getAsJsonArray()) {
                if (!(element.isJsonPrimitive() || element.isJsonNull())) {
                    return false;
                }
            }
        }

        return true;
    }

    abstract boolean matchPrimitive(JsonPrimitive jsonPrimitive);

    abstract boolean matchNull(JsonNull jsonNull);
}

/**
 * If the value is an array, then the rule pattern matches if any element matches the equal condition.
 */
class EqualCondition extends AbstractPatternCondition {
    /**
     * Only accept JsonPrimitive or JsonNull
     */
    private final JsonElement val;

    public EqualCondition(final JsonElement val) {
        this.val = val;
    }

    @Override
    boolean matchPrimitive(final JsonPrimitive jsonPrimitive) {
        // JsonNull is not equal to "null"
        if (val instanceof JsonNull) {
            return false;
        }

        // Number matching is at the string representation level.
        // For example, 300, 300.0, and 3.0e2 are not considered equal.
        return val.getAsString()
            .equals(jsonPrimitive.getAsString());
    }

    @Override
    boolean matchNull(final JsonNull jsonNull) {
        return val.equals(jsonNull);
    }
}

class PrefixCondition extends AbstractPatternCondition {
    /**
     * Don't accept null string
     */
    private final String prefix;

    public PrefixCondition(final String prefix) {
        this.prefix = prefix;
    }

    @Override
    boolean matchPrimitive(final JsonPrimitive jsonPrimitive) {
        return jsonPrimitive.isString() && jsonPrimitive.getAsString()
            .startsWith(prefix);
    }

    @Override
    boolean matchNull(final JsonNull jsonNull) {
        return false;
    }
}

class SuffixCondition extends AbstractPatternCondition {
    /**
     * Don't accept null string
     */
    private final String suffix;

    public SuffixCondition(final String suffix) {
        this.suffix = suffix;
    }

    @Override
    boolean matchPrimitive(final JsonPrimitive jsonPrimitive) {
        return jsonPrimitive.isString() && jsonPrimitive.getAsString()
            .endsWith(suffix);
    }

    @Override
    boolean matchNull(final JsonNull jsonNull) {
        return false;
    }
}

/**
 * AnythingButCondition matches anything except what's provided in the rule. You can use anything-but with strings and
 * numeric values, including lists that contain only strings, or only numbers.
 */
class AnythingButCondition extends AbstractPatternCondition {
    private List<PatternCondition> anythingButs = new ArrayList<>();

    public void addRuleCondition(PatternCondition patternCondition) {
        anythingButs.add(patternCondition);
    }

    @Override
    boolean matchPrimitive(final JsonPrimitive jsonPrimitive) {
        return matchJsonElement(jsonPrimitive);
    }

    @Override
    boolean matchNull(final JsonNull jsonNull) {
        return matchJsonElement(jsonNull);
    }

    private boolean matchJsonElement(final JsonElement jsonElement) {
        for (final PatternCondition condition : anythingButs) {
            if (condition.match(jsonElement)) {
                return false;
            }
        }
        return true;
    }
}

class NumericCondition extends AbstractPatternCondition {
    private List<Double> dataList = new ArrayList<>();
    private List<NumericOperators> operatorList = new ArrayList<>();

    public void addOperatorAndData(NumericOperators operator, double data) {
        dataList.add(data);
        operatorList.add(operator);
    }

    @Override
    boolean matchPrimitive(final JsonPrimitive jsonPrimitive) {
        if (!jsonPrimitive.isNumber()) {
            return false;
        }

        for (int i = 0; i < operatorList.size(); i++) {
            if (!operatorList.get(i)
                .match(jsonPrimitive.getAsDouble(), dataList.get(i))) {
                return false;
            }
        }
        return true;
    }

    @Override
    boolean matchNull(final JsonNull jsonNull) {
        return false;
    }
}

/**
 * IP address matching is available for both IPv4 and IPv6 addresses
 */
class CIDRCondition extends AbstractPatternCondition {
    private final String cidrExp;

    public CIDRCondition(final String cidrExp) {
        this.cidrExp = cidrExp;
    }

    private boolean matchIpAddress(final String data) {
        boolean flag;
        try {
            if (cidrExp.contains("/")) {
                SubnetUtils snu = new SubnetUtils(cidrExp);
                flag = snu.getInfo()
                    .isInRange(data);
            } else {
                flag = InetAddress.getByName(data)
                    .equals(InetAddress.getByName(cidrExp));
            }
        } catch (Exception e) {
            flag = false;
            //Invalid ip address
        }
        return flag;
    }

    @Override
    boolean matchPrimitive(final JsonPrimitive jsonPrimitive) {
        return jsonPrimitive.isString() && matchIpAddress(jsonPrimitive.getAsString());
    }

    @Override
    boolean matchNull(final JsonNull jsonNull) {
        return false;
    }
}

class ExistsCondition extends AbstractPatternCondition {
    private final boolean exists;

    ExistsCondition(final boolean exists) {
        this.exists = exists;
    }

    @Override
    boolean matchPrimitive(final JsonPrimitive jsonPrimitive) {
        return exists == (jsonPrimitive != null);
    }

    @Override
    boolean matchNull(final JsonNull jsonNull) {
        return exists == (jsonNull != null);
    }
}
