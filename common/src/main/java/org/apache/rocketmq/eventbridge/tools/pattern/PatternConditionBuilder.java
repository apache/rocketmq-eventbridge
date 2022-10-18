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

import com.google.common.base.Strings;
import com.google.gson.JsonArray;
import com.google.gson.JsonElement;
import java.net.InetAddress;
import java.util.Iterator;
import java.util.Map;
import java.util.Set;
import org.apache.commons.net.util.SubnetUtils;

/**
 * The handler to build a {@link PatternCondition} from a specific JsonElement. Each inherited class should a default
 * constructor which will be used in {@link ComplexConditionBuilders#builder()}
 */
public interface PatternConditionBuilder {
    /**
     * Builds a RuleCondition from a JsonElement
     *
     * @param jsonElement contains the condition value
     * @return the RuleCondition
     * @throws InvalidEventPatternException if any error occurs
     */
    PatternCondition build(final JsonElement jsonElement);
}

class PrefixConditionBuilder implements PatternConditionBuilder {

    @Override
    public PatternCondition build(final JsonElement jsonElement) {
        if (jsonElement.isJsonPrimitive() && jsonElement.getAsJsonPrimitive()
            .isString()) {
            String prefix = jsonElement.getAsJsonPrimitive()
                .getAsString();
            if (Strings.isNullOrEmpty(prefix)) {
                throw new InvalidEventPatternException(PatternErrorMessages.EMPTY_PREFIX_CONDITION);
            }
            return new PrefixCondition(prefix);
        }
        throw new InvalidEventPatternException(PatternErrorMessages.INVALID_PREFIX_CONDITION);
    }
}

class SuffixConditionBuilder implements PatternConditionBuilder {

    @Override
    public PatternCondition build(final JsonElement jsonElement) {
        if (jsonElement.isJsonPrimitive() && jsonElement.getAsJsonPrimitive()
            .isString()) {
            String suffix = jsonElement.getAsJsonPrimitive()
                .getAsString();
            if (Strings.isNullOrEmpty(suffix)) {
                throw new InvalidEventPatternException(PatternErrorMessages.EMPTY_SUFFIX_CONDITION);
            }
            return new SuffixCondition(suffix);
        }
        throw new InvalidEventPatternException(PatternErrorMessages.INVALID_SUFFIX_CONDITION);
    }
}

/**
 * AnythingButCondition is really flexible, it can be used to combine any other RuleCondition. we should add some
 * limitations: 1. the value condition only can be PrefixCondition or SuffixCondition 2. the anything but list only can
 * contains primitive type
 */
class AnythingButConditionBuilder implements PatternConditionBuilder {

    @Override
    public PatternCondition build(final JsonElement jsonElement) {
        AnythingButCondition butCondition = new AnythingButCondition();
        if (jsonElement.isJsonPrimitive() || jsonElement.isJsonNull()) {
            butCondition.addRuleCondition(new EqualCondition(jsonElement));
            return butCondition;
        }

        if (jsonElement.isJsonObject()) {
            final Set<Map.Entry<String, JsonElement>> entries = jsonElement.getAsJsonObject()
                .entrySet();
            for (final Map.Entry<String, JsonElement> elementEntry : entries) {
                if (!(ComplexConditionBuilders.prefix.toString()
                    .equals(elementEntry.getKey()) || ComplexConditionBuilders.suffix.toString()
                    .equals(elementEntry.getKey()))) {
                    throw new InvalidEventPatternException(PatternErrorMessages.INVALID_NESTED_ANYTHING_BUT_CONDITION);
                }
            }
            butCondition.addRuleCondition(PatternEvaluatorBuilder.parseCondition(jsonElement.getAsJsonObject()));
            return butCondition;
        }

        if (jsonElement.isJsonArray()) {
            for (final JsonElement element : jsonElement.getAsJsonArray()) {
                if (element.isJsonNull() || element.isJsonPrimitive()) {
                    butCondition.addRuleCondition(new EqualCondition(element));
                    continue;
                }
                throw new InvalidEventPatternException(PatternErrorMessages.INVALID_ANYTHING_BUT_CONDITION);
            }
            return butCondition;
        }

        // Can't be here, throw a exception
        throw new InvalidEventPatternException(PatternErrorMessages.INVALID_ANYTHING_BUT_CONDITION);
    }
}

class NumericConditionBuilder implements PatternConditionBuilder {
    public static final double MAX_VAL = 1.0E9;
    public static final double MIN_VAL = -1.0E9;

    @Override
    public PatternCondition build(final JsonElement jsonElement) {
        if (!jsonElement.isJsonArray()) {
            throw new InvalidEventPatternException(PatternErrorMessages.INVALID_NUMERIC_CONDITION);
        }

        final JsonArray numericArray = jsonElement.getAsJsonArray();
        if (numericArray.size() != 2 && numericArray.size() != 4) {
            throw new InvalidEventPatternException(
                "Event pattern is not valid, reason: the numeric array value should have 2 or 4 elements");
        }

        NumericCondition condition = new NumericCondition();

        final Iterator<JsonElement> iterator = numericArray.iterator();
        while (iterator.hasNext()) {
            final JsonElement operator = iterator.next();
            final JsonElement data = iterator.next();
            if (operator.isJsonPrimitive() && operator.getAsJsonPrimitive()
                .isString() && data.isJsonPrimitive() && data.getAsJsonPrimitive()
                .isNumber()) {

                final double num = data.getAsJsonPrimitive()
                    .getAsDouble();
                if (Double.compare(num, MAX_VAL) > 0 || Double.compare(num, MIN_VAL) < 0) {
                    throw new InvalidEventPatternException(PatternErrorMessages.INVALID_NUMERIC_CONDITION_VALUE);
                }

                final NumericOperators operatorExp = NumericOperators.getOperatorByExp(operator.getAsJsonPrimitive()
                    .getAsString());
                if (operatorExp == null) {
                    throw new InvalidEventPatternException(PatternErrorMessages.UNRECOGNIZED_NUMERIC_CONDITION_EXP);
                }
                condition.addOperatorAndData(operatorExp, num);
                continue;
            }
            throw new InvalidEventPatternException(PatternErrorMessages.UNRECOGNIZED_NUMERIC_CONDITION_VALUE);

        }

        return condition;
    }
}

class CIDRConditionBuilder implements PatternConditionBuilder {

    @Override
    public PatternCondition build(final JsonElement jsonElement) {
        if (jsonElement.isJsonPrimitive() && jsonElement.getAsJsonPrimitive()
            .isString()) {
            String cidrExp = jsonElement.getAsJsonPrimitive()
                .getAsString();
            if (Strings.isNullOrEmpty(cidrExp)) {
                throw new InvalidEventPatternException(PatternErrorMessages.INVALID_CIDR_CONDITION);
            }

            try {
                if (cidrExp.contains("/")) {
                    // Don't remove these unused variables to keep the side effects
                    SubnetUtils snu = new SubnetUtils(cidrExp);
                } else {
                    final InetAddress name = InetAddress.getByName(cidrExp);
                }
            } catch (Exception e) {
                throw new InvalidEventPatternException(PatternErrorMessages.INVALID_CIDR_CONDITION);
            }

            return new CIDRCondition(cidrExp);
        }
        throw new InvalidEventPatternException(PatternErrorMessages.INVALID_CIDR_CONDITION);
    }
}

class ExistsConditionBuilder implements PatternConditionBuilder {

    @Override
    public PatternCondition build(final JsonElement jsonElement) {
        if (jsonElement.isJsonPrimitive() && jsonElement.getAsJsonPrimitive()
            .isBoolean()) {
            return new ExistsCondition(jsonElement.getAsJsonPrimitive()
                .getAsBoolean());
        }
        throw new InvalidEventPatternException(PatternErrorMessages.INVALID_EXISTS_CONDITION);
    }
}
