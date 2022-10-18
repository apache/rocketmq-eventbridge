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

package org.apache.rocketmq.eventbridge.adapter.api.converter.format;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.JavaType;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.module.SimpleModule;
import io.cloudevents.CloudEvent;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import org.apache.rocketmq.eventbridge.exception.EventBridgeException;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class BatchedJsonFormat {

    public static final String CONTENT_TYPE = "application/cloudevents-batch+json";

    private static final Logger LOGGER = LoggerFactory.getLogger(BatchedJsonFormat.class);

    private final ObjectMapper mapper;
    private final boolean forceDataBase64Serialization;
    private final boolean forceStringSerialization;
    private final JavaType type;

    public BatchedJsonFormat(boolean forceDataBase64Serialization, boolean forceStringSerialization) {
        this.mapper = new ObjectMapper();
        this.type = mapper.getTypeFactory()
            .constructCollectionType(ArrayList.class, CloudEvent.class);
        this.mapper.registerModule(getCloudEventJacksonModule(forceDataBase64Serialization, forceStringSerialization));
        this.forceDataBase64Serialization = forceDataBase64Serialization;
        this.forceStringSerialization = forceStringSerialization;
    }

    public BatchedJsonFormat() {
        this(false, false);
    }

    /**
     * @return a copy of this JsonFormat that serialize events with json data with Base64 encoding
     */
    public BatchedJsonFormat withForceJsonDataToBase64() {
        return new BatchedJsonFormat(true, this.forceStringSerialization);
    }

    /**
     * @return a copy of this JsonFormat that serialize events with non-json data as string
     */
    public BatchedJsonFormat withForceNonJsonDataToString() {
        return new BatchedJsonFormat(this.forceDataBase64Serialization, true);
    }

    public byte[] serialize(List<CloudEvent> event) {
        try {
            return mapper.writeValueAsBytes(event);
        } catch (JsonProcessingException e) {
            throw new EventBridgeException("serialize event failed.");
        }
    }

    public List<CloudEvent> deserialize(byte[] bytes) {
        try {
            return mapper.readValue(bytes, type);
        } catch (IOException e) {
            throw new EventBridgeException("serialize event failed.");
        }
    }

    public String serializedContentType() {
        return CONTENT_TYPE;
    }

    /**
     * @return a JacksonModule with CloudEvent serializer/deserializer with default values
     */
    public static SimpleModule getCloudEventJacksonModule() {
        return getCloudEventJacksonModule(false, false);
    }

    /**
     * @return a JacksonModule with CloudEvent serializer/deserializer customizing the data serialization. Look at
     * {@link #withForceJsonDataToBase64()} and {@link #withForceNonJsonDataToString()} for more details.
     */
    public static SimpleModule getCloudEventJacksonModule(boolean forceDataBase64Serialization,
        boolean forceStringSerialization) {
        final SimpleModule ceModule = new SimpleModule("CloudEvent");
        ceModule.addDeserializer(ArrayList.class, new BatchedCloudEventDeserializer());
        ceModule.addSerializer(new BatchedCloudEventSerializer(forceDataBase64Serialization, forceStringSerialization));
        return ceModule;
    }

    protected static boolean dataIsJsonContentType(String contentType) {
        // If content type, spec states that we should assume is json
        return contentType == null || contentType.startsWith("application/json") || contentType.startsWith("text/json");
    }
}
