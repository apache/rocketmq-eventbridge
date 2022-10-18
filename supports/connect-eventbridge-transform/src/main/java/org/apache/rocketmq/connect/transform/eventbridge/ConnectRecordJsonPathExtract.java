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

import java.util.List;

import com.google.common.collect.Lists;
import com.google.gson.Gson;
import io.openmessaging.connector.api.data.ConnectRecord;
import org.apache.rocketmq.eventbridge.exception.EventBridgeException;
import org.apache.rocketmq.eventbridge.tools.transform.Data;
import org.apache.rocketmq.eventbridge.tools.transform.JsonPathExtract;
import org.apache.rocketmq.eventbridge.tools.transform.JsonPathUtil;
import org.apache.rocketmq.eventbridge.tools.transform.ObjectData;
import org.apache.rocketmq.eventbridge.tools.transform.Variable;

import static org.apache.rocketmq.eventbridge.tools.transform.JsonPathUtil.JSONPATH_PREFIX;
import static org.apache.rocketmq.eventbridge.tools.transform.JsonPathUtil.JSONPATH_PREFIX_WITH_POINT;

public class ConnectRecordJsonPathExtract extends JsonPathExtract {

    public ConnectRecordJsonPathExtract(String extractJson) throws EventBridgeException {
        super(extractJson);
    }

    @Override
    public List<Variable> parse(Data data) throws EventBridgeException {
        if (data instanceof ObjectData && ((ObjectData) data).getClassType()
            .equals(ConnectRecord.class)) {
            return parseElementFromConnectRecord((ConnectRecord) ((ObjectData) data).getData());
        } else {
            return super.parse(data);
        }
    }

    public List<Variable> parseElementFromConnectRecord(ConnectRecord connectRecord) throws EventBridgeException {
        if (extractList == null || extractList.isEmpty()) {
            return Lists.newArrayListWithCapacity(0);
        }
        List<Variable> variableList = Lists.newArrayListWithCapacity(extractList.size());
        for (JsonPathElement element : extractList) {
            if (JsonPathUtil.isValidAndDefinite(element.getJsonPath())) {
                if (element.getJsonPath()
                    .equals(JSONPATH_PREFIX) || element.getJsonPath()
                    .equals(JSONPATH_PREFIX_WITH_POINT)) {
                    variableList.add(new Variable(element.getVariableName(), connectRecord.getData()));
                } else if (element.getJsonPath()
                    .equals(JsonPathUtil.JSONPATH_DATA)) {
                    variableList.add(new Variable(element.getVariableName(), connectRecord.getData()));
                } else if (element.getJsonPath()
                    .startsWith(JsonPathUtil.JSONPATH_DATA)) {
                    String StringData = connectRecord.getData() instanceof String ? (String) (connectRecord.getData())
                        : new Gson().toJson(connectRecord.getData());
                    variableList.add(new Variable(element.getVariableName(), JsonPathUtil.readJsonPathValue(StringData,
                        JsonPathUtil.removeDataOfJsonPath(element.getJsonPath()))));
                } else {
                    String key = element.getJsonPath()
                        .substring(2, element.getJsonPath()
                            .length());
                    variableList.add(new Variable(element.getVariableName(), connectRecord.getExtension(key)));
                }
            } else {
                variableList.add(new Variable(element.getVariableName(), element.getJsonPath()));
            }

        }
        return variableList;
    }
}
