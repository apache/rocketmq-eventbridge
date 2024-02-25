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
 *  Unless required by applicable law or agreed to in writing, software
 *  distributed under the License is distributed on an "AS IS" BASIS,
 *  WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 *  See the License for the specific language governing permissions and
 *  limitations under the License.
 */

package org.apache.rocketmq.eventbridge.adapter.runtime.converter;

import com.alibaba.fastjson.JSON;
import io.openmessaging.connector.api.data.Converter;
import io.openmessaging.connector.api.data.RecordOffset;
import org.apache.rocketmq.eventbridge.adapter.runtime.common.LoggerName;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.io.UnsupportedEncodingException;

/**
 * record offset converter.
 */
public class RecordOffsetConverter implements Converter<RecordOffset> {

    private static final Logger log = LoggerFactory.getLogger(LoggerName.EVENT_BRIDGE_RUNTIMER);

    @Override
    public byte[] objectToByte(RecordOffset recordOffset) {
        try {
            String json = JSON.toJSONString(recordOffset);
            return json.getBytes("UTF-8");
        } catch (Exception e) {
            log.error("JsonConverter#objectToByte failed", e);
        }
        return new byte[0];
    }

    @Override
    public RecordOffset byteToObject(byte[] bytes) {
        try {
            String text = new String(bytes, "UTF-8");
            RecordOffset res = JSON.parseObject(text, RecordOffset.class);
            return res;
        } catch (UnsupportedEncodingException e) {
            log.error("JsonConverter#byteToObject failed", e);
        }
        return null;
    }
}
