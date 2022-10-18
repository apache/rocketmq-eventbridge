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

package org.apache.rocketmq.eventbridge.tools.transform;

import org.apache.rocketmq.eventbridge.exception.EventBridgeException;

public class TransformValidator {

    /**
     * throw EventBusException if is not validate transform
     *
     * @param form
     * @param template
     * @param value
     * @throws EventBridgeException
     */
    public static void validateTransform(TransformEnum form, String template,
        String value) throws EventBridgeException {
        ObjectUtil.checkNotNullOrEmpty(new EventBridgeException(TransformErrorCode.InvalidConfig, form), form);
        switch (form) {
            case ORIGINAL:
                break;
            case CONSTANT:
                ObjectUtil.checkNotNullOrEmpty(new EventBridgeException(TransformErrorCode.InvalidConfig, value), value);
                break;
            case JSONPATH:
                ObjectUtil.checkNotNullOrEmpty(new EventBridgeException(TransformErrorCode.InvalidConfig, value), value);
                if (!JsonPathUtil.isValidAndDefinite(value)) {
                    throw new EventBridgeException(TransformErrorCode.InvalidConfig, value);
                }
                break;
            case TEMPLATE:
                ObjectUtil.checkNotNullOrEmpty(new EventBridgeException(TransformErrorCode.InvalidConfig, value), value);
                ObjectUtil.checkNotNullOrEmpty(new EventBridgeException(TransformErrorCode.InvalidConfig, value),
                    new JsonPathExtract(value).getExtractList());
                ObjectUtil.checkNotNullOrEmpty(new EventBridgeException(TransformErrorCode.InvalidConfig, value),
                    new StringSubstitutorTemplate(template));
                break;
            default:
                break;
        }
    }
}
