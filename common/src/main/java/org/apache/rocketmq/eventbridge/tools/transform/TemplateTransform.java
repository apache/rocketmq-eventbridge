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

import java.util.List;

import org.apache.rocketmq.eventbridge.exception.EventBridgeException;

public class TemplateTransform implements Transform {

    /**
     * The extact expr
     * e.g："{"id":"$.id","name":"$.data.name"}"
     */
    private Extract jsonPathExtract;

    /**
     * format the data by the Template
     */
    private Template template;

    public TemplateTransform(Extract jsonPathExtract, Template template) {
        this.jsonPathExtract = jsonPathExtract;
        this.template = template;
    }


    @Override
    public Data process(Data inputData) throws EventBridgeException {
        List<Variable> variableList = extract(inputData, jsonPathExtract);
        Data output = format(variableList, template);
        return output;
    }
}
