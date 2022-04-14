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

import java.util.Map;

import com.google.common.base.Strings;
import com.google.common.collect.Maps;

/**
 * NumericOperators provides some built-in operator to compare two JSON numbers in Double manner
 */
public enum NumericOperators {
    /**
     * Check two numbers whether is equal
     */
    EQUAL("="),
    /**
     * Check two numbers whether is not equal
     */
    NOT_EQUAL("!="),
    /**
     * Check two numbers which is greater
     */
    GREATER_THAN(">"),
    /**
     * Check two numbers whether is equal equal
     */
    GREATER_THAN_EQUAL(">="),
    /**
     * Check two numbers whether is less
     */
    LESS_THAN("<"),
    /**
     * Check two numbers whether is less equal
     */
    LESS_THAN_EQUAL("<=");

    private static final double THRESHOLD = 1.0E-7;

    private static final Map<String, NumericOperators> OPERATOR_MAP = Maps.newConcurrentMap();

    static {
        for (final NumericOperators operator : NumericOperators.values()) {
            OPERATOR_MAP.put(operator.toString(), operator);
        }
    }

    public static NumericOperators getOperatorByExp(String exp) {
        if (Strings.isNullOrEmpty(exp)) {
            return null;
        }
        return OPERATOR_MAP.get(exp);
    }

    private final String exp;

    NumericOperators(final String exp) {
        this.exp = exp;
    }

    public boolean match(double src, double dst) {
        // dst is between -1.0E9 and 1.0E9, inclusive
        final int result = compareDouble(src, dst);
        switch (this) {
            case EQUAL:
                return result == 0;
            case NOT_EQUAL:
                return result != 0;
            case GREATER_THAN:
                return result > 0;
            case GREATER_THAN_EQUAL:
                return result >= 0;
            case LESS_THAN:
                return result < 0;
            case LESS_THAN_EQUAL:
                return result <= 0;
            default: // Never be here
                return false;
        }
    }

    private int compareDouble(double src, double dst) {
        if (Math.abs(src - dst) <= THRESHOLD) {
            return 0;
        }
        return Double.compare(src, dst);
    }

    @Override
    public String toString() {
        return exp;
    }
}
