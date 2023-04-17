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
package org.apache.rocketmq.eventbridge.enums;

import com.google.common.base.Strings;

/**
 * The different levels of error tolerance.
 */
public enum ErrorToleranceEnum {

    /**
     * Tolerate no errors.
     */
    NONE,

    /**
     * Tolerate all errors.
     */
    ALL;

    public static ErrorToleranceEnum parse(String code) {
        if (Strings.isNullOrEmpty(code)) {
            return ALL;
        }
        for (ErrorToleranceEnum toleranceTypeEnum : ErrorToleranceEnum.values()) {
            if (toleranceTypeEnum.name()
                .equals(code)) {
                return toleranceTypeEnum;
            }
        }
        return ALL;
    }

}