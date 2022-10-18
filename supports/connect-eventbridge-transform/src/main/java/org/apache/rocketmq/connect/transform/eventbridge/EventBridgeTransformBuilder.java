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

package org.apache.rocketmq.connect.transform.eventbridge;

import org.apache.rocketmq.eventbridge.exception.EventBridgeException;
import org.apache.rocketmq.eventbridge.tools.transform.JsonPathTransform;
import org.apache.rocketmq.eventbridge.tools.transform.JsonUtil;
import org.apache.rocketmq.eventbridge.tools.transform.Template;
import org.apache.rocketmq.eventbridge.tools.transform.TemplateBuilder;
import org.apache.rocketmq.eventbridge.tools.transform.TemplateTransform;
import org.apache.rocketmq.eventbridge.tools.transform.Transform;
import org.apache.rocketmq.eventbridge.tools.transform.TransformBuilder;
import org.apache.rocketmq.eventbridge.tools.transform.TransformErrorCode;
import org.apache.rocketmq.eventbridge.tools.transform.TransformParam;

public class EventBridgeTransformBuilder extends TransformBuilder {

    public static Transform buildTransform(TransformParam transformParam) throws EventBridgeException {
        switch (transformParam.getForm()) {
            case CONSTANT:
                return buildConstantTransform(transformParam.getValue());
            case JSONPATH:
                return buildJsonTransform(transformParam.getValue());
            case ORIGINAL:
                return buildOriginalTransform();
            case TEMPLATE:
                return buildTemplateTransForm(transformParam.getValue(), transformParam.getTemplate());
            case INSERT_FIELD:
                return buildInsertFieldTransform(transformParam.getValue());
            case DELETE_FIELD:
                return buildDeleteFieldTransform(transformParam.getValue());
            case UPDATE_FIELD:
                return buildUpdateFieldTransform(transformParam.getValue());
            default:
                throw new EventBridgeException(TransformErrorCode.InvalidConfig);
        }
    }

    /**
     * build JsonTransform
     *
     * @param extractJson
     * @return
     * @throws EventBridgeException
     */
    public static Transform buildJsonTransform(String extractJson) throws EventBridgeException {
        ConnectRecordJsonPathExtract jsonPathExtract = new ConnectRecordJsonPathExtract(
            JsonUtil.buildJsonString("VAR_PLACEHOLDE", extractJson));
        if (jsonPathExtract.getExtractList() == null || jsonPathExtract.getExtractList()
            .size() != 1) {
            throw new EventBridgeException(TransformErrorCode.InvalidConfig);
        }
        return new JsonPathTransform(jsonPathExtract);
    }

    /**
     * build TemplateTransForm
     *
     * @param extractJson
     * @param template
     * @return
     * @throws EventBridgeException
     */
    public static Transform buildTemplateTransForm(String extractJson, String template) throws EventBridgeException {
        ConnectRecordJsonPathExtract jsonPathExtract = new ConnectRecordJsonPathExtract(extractJson);
        Template templateEntry = TemplateBuilder.stringSubstitutorTemplate(template);
        return new TemplateTransform(jsonPathExtract, templateEntry);
    }
}
