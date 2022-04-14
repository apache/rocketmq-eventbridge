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

import java.io.IOException;
import java.nio.charset.Charset;
import java.nio.charset.StandardCharsets;
import java.util.ArrayList;
import java.util.List;
import javax.ws.rs.core.MediaType;

import com.fasterxml.jackson.core.JsonGenerator;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.SerializerProvider;
import com.fasterxml.jackson.databind.ser.std.StdSerializer;
import com.google.common.base.Strings;
import io.cloudevents.CloudEvent;
import io.cloudevents.core.data.BytesCloudEventData;
import org.springframework.util.CollectionUtils;

/**
 * @author jingluo.sl
 * <p>
 * 2020-08-14 10:57
 **/
public class BatchedCloudEventSerializer extends StdSerializer<ArrayList<CloudEvent>> {

    private final boolean forceDataBase64Serialization;
    private final boolean forceStringSerialization;

    protected BatchedCloudEventSerializer(boolean forceDataBase64Serialization, boolean forceStringSerialization) {
        super(new ObjectMapper().getTypeFactory()
            .constructCollectionType(List.class, CloudEvent.class));
        this.forceDataBase64Serialization = forceDataBase64Serialization;
        this.forceStringSerialization = forceStringSerialization;
    }

    private boolean shouldSerializeBase64(String contentType) {
        if (BatchedJsonFormat.dataIsJsonContentType(contentType)) {
            return this.forceDataBase64Serialization;
        } else {
            return !this.forceStringSerialization;
        }
    }

    @Override
    public void serialize(ArrayList<CloudEvent> events, JsonGenerator gen, SerializerProvider provider)
        throws IOException {
        if (CollectionUtils.isEmpty(events)) {
            return;
        }
        gen.writeStartArray();
        for (CloudEvent value : events) {
            gen.writeStartObject();
            // Serialize attributes
            if (!Strings.isNullOrEmpty(value.getId())) {
                gen.writeStringField("id", value.getId());
            }
            if (value.getSource() != null && value.getSource()
                .toString()
                .length() > 0) {
                gen.writeStringField("source", String.valueOf(value.getSource()));
            }
            if (value.getSpecVersion() != null) {
                gen.writeStringField("specversion", value.getSpecVersion()
                    .toString());
            }
            if (!Strings.isNullOrEmpty(value.getType())) {
                gen.writeStringField("type", value.getType());
            }

            if (!Strings.isNullOrEmpty(value.getDataContentType())) {
                gen.writeStringField("datacontenttype", value.getDataContentType());
            }

            if (value.getDataSchema() != null) {
                gen.writeStringField("dataschema", String.valueOf(value.getDataSchema()));
            }

            if (!Strings.isNullOrEmpty(value.getSubject())) {
                gen.writeStringField("subject", value.getSubject());
            }
            if (value.getTime() != null) {
                gen.writeStringField("time", value.getTime()
                    .toString());
            }

            // Serialize extend attributes
            for (String name : value.getExtensionNames()) {
                gen.writeStringField(name, String.valueOf(value.getExtension(name)));
            }

            // Serialize data
            byte[] data = ((BytesCloudEventData)(value.getData())).toBytes();
            String contentType = value.getDataContentType();
            if (data != null) {
                if (shouldSerializeBase64(contentType)) {
                    gen.writeFieldName("data_base64");
                    gen.writeBinary(data);
                } else if (BatchedJsonFormat.dataIsJsonContentType(contentType)) {
                    String charsetStr = MediaType.valueOf(contentType)
                        .getParameters()
                        .get(MediaType.CHARSET_PARAMETER);
                    Charset charset = Strings.isNullOrEmpty(charsetStr) ? StandardCharsets.UTF_8 : Charset.forName(
                        charsetStr);
                    char[] dataAsString = new String(data, charset).toCharArray();
                    gen.writeFieldName("data");
                    gen.writeRawValue(dataAsString, 0, dataAsString.length);
                } else {
                    gen.writeFieldName("data");
                    gen.writeUTF8String(data, 0, data.length);
                }
            }
            gen.writeEndObject();
        }
        gen.writeEndArray();
    }
}
