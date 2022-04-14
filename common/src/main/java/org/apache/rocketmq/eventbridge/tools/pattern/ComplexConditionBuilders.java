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

import java.lang.reflect.Constructor;
import java.util.Map;

import com.google.common.collect.Maps;

/**
 * ComplexConditionBuilders provides some enum fields to construct {@link PatternConditionBuilder} which can be used to
 * build {@link PatternCondition}
 */
public enum ComplexConditionBuilders {
    /**
     * To build a PrefixCondition
     */
    prefix(PrefixConditionBuilder.class),
    /**
     * To build a SuffixCondition
     */
    suffix(SuffixConditionBuilder.class),
    /**
     * To build a AnythingButCondition
     */
    anything_but(AnythingButConditionBuilder.class),
    /**
     * To build a NumericCondition
     */
    numeric(NumericConditionBuilder.class),
    /**
     * To build a CIDRCondition
     */
    cidr(CIDRConditionBuilder.class),
    /**
     * To build an ExistsCondition
     */
    exists(ExistsConditionBuilder.class);

    private static final Map<String, PatternConditionBuilder> CONDITION_BUILDER = Maps.newConcurrentMap();

    static {
        for (final ComplexConditionBuilders conditionName : ComplexConditionBuilders.values()) {
            CONDITION_BUILDER.put(conditionName.toString(), conditionName.builder());
        }
    }

    public static PatternConditionBuilder getConditionBuilderByName(String name) {
        return CONDITION_BUILDER.get(name);
    }

    private final Class<? extends PatternConditionBuilder> builderClass;

    ComplexConditionBuilders(final Class<? extends PatternConditionBuilder> builderClass) {
        this.builderClass = builderClass;
    }

    PatternConditionBuilder builder() {
        Constructor<? extends PatternConditionBuilder> ctor;
        try {
            ctor = this.builderClass.getDeclaredConstructor();
            return ctor.newInstance();
        } catch (Exception e) {
            throw new RuntimeException("Couldn't construct the builder for " + builderClass.getSimpleName(), e);
        }
    }

    @Override
    public String toString() {
        return name().replace('_', '-');
    }
}
