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

public class PatternErrorMessages {
    public static final String EMPTY_PATTERN = "Event pattern is not valid, reason: the pattern is empty";
    public static final String INVALID_JSON_STRING
        = "Event pattern is not valid, reason: the pattern isn't a valid json format string";
    public static final String NON_SUPPORTED_JSON
        = "Event pattern is not valid, reason: the pattern should be a JSON object";
    public static final String INVALID_PATTERN_VALUE = "Event pattern is not valid, reason: the pattern has invalid "
        + "pattern value: ";
    public static final String UNRECOGNIZED_PATTERN_KEY = "Event pattern is not valid, reason: the pattern has "
        + "unrecognized pattern key: ";
    public static final String NO_DATA_PATTERN_KEY = "Event pattern is not valid, reason: the data pattern doesn't "
        + "have any pattern key";
    public static final String NESTED_PATTERN_VALUE = "Event pattern is not valid, reason: nested pattern value isn't"
        + " supported, pattern key: ";
    public static final String INVALID_PATTERN_CONDITION = "Event pattern is not valid, reason: each pattern "
        + "condition should only have one condition key";
    public static final String UNRECOGNIZED_PATTERN_CONDITION = "Event pattern is not valid, reason: the pattern "
        + "condition is unrecognized: ";

    public static final String EMPTY_PREFIX_CONDITION
        = "Event pattern is not valid, reason: the prefix condition doesn't support empty string value";
    public static final String INVALID_PREFIX_CONDITION = "Event pattern is not valid, reason: the prefix condition "
        + "only support string value";

    public static final String EMPTY_SUFFIX_CONDITION
        = "Event pattern is not valid, reason: the suffix condition doesn't support empty string value";
    public static final String INVALID_SUFFIX_CONDITION = "Event pattern is not valid, reason: the suffix condition "
        + "only support string value";

    public static final String INVALID_EXISTS_CONDITION = "Event pattern is not valid, reason: the exists condition "
        + "only support boolean value";

    public static final String INVALID_CIDR_CONDITION = "Event pattern is not valid, reason: the prefix condition "
        + "only support string value";

    public static final String INVALID_NESTED_ANYTHING_BUT_CONDITION
        = "Event pattern is not valid, reason: anything but condition only support prefix or suffix";
    public static final String INVALID_ANYTHING_BUT_CONDITION = "Event pattern is not valid, reason: the anything-but"
        + " condition only support null or primitive values";

    public static final String INVALID_NUMERIC_CONDITION_VALUE = "Event pattern is not valid, reason: the numeric "
        + "value must be between -1.0E9 and 1.0E9 inclusive";
    public static final String INVALID_NUMERIC_CONDITION = "Event pattern is not valid, reason: the numeric "
        + "condition needs an array value";
    public static final String UNRECOGNIZED_NUMERIC_CONDITION_VALUE
        = "Event pattern is not valid, reason: the numeric value should contains an operator and a number";

    public static final String UNRECOGNIZED_NUMERIC_CONDITION_EXP
        = "Event pattern is not valid, reason: the numeric exp only support >,<,>=,<=,=,!=";
}
