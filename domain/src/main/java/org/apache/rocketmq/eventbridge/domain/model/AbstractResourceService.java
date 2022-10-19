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
package org.apache.rocketmq.eventbridge.domain.model;

import com.google.common.base.Strings;
import java.util.Set;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import org.apache.rocketmq.eventbridge.domain.common.exception.EventBridgeErrorCode;
import org.apache.rocketmq.eventbridge.exception.EventBridgeException;

public abstract class AbstractResourceService {

    protected void checkQuota(int currentSize, int quota, EventBridgeErrorCode errorCode) {
        if (currentSize >= quota) {
            throw new EventBridgeException(errorCode, currentSize, quota);
        }
    }

    protected void checkNameValidate(String name, Pattern namePattern, int minLength, int maxLength,
        Set<String> reservedNames, String reservedPrefix, EventBridgeErrorCode errorCode) {
        if (Strings.isNullOrEmpty(name)) {
            throw new EventBridgeException(errorCode, name);
        }
        int len = name.length();
        if (len > maxLength || len < minLength) {
            throw new EventBridgeException(errorCode, name);
        }

        Matcher isMatch = namePattern.matcher(name);
        if (!isMatch.matches()) {
            throw new EventBridgeException(errorCode, name);
        }
        if (reservedNames != null && reservedNames.contains(name)) {
            throw new EventBridgeException(errorCode, name);
        }
        if (name.startsWith(reservedPrefix)) {
            throw new EventBridgeException(errorCode, name);
        }
    }
}
