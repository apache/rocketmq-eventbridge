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

package org.apache.rocketmq.eventbridge.event;

import java.net.URI;
import java.time.OffsetDateTime;
import java.util.Map;
import java.util.Set;

import com.google.common.collect.Maps;
import io.cloudevents.SpecVersion;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@AllArgsConstructor
@NoArgsConstructor
@Builder
public @Data
class EventBridgeEvent {

    private String id;
    private URI source;
    private String type;
    private String datacontenttype;
    private URI dataschema;
    private String subject;
    private OffsetDateTime time;
    private byte[] data;
    private String specversion;
    private Map<String, Object> extensions;

    public static Set<String> getAttributeKeys() {
        return SpecVersion.V1.getAllAttributes();
    }

    public Object getExtension(String extensionKey) {
        if (extensions == null || extensions.isEmpty()) {
            return null;
        } else {
            return extensions.get(extensionKey);
        }
    }

    public void addExtension(String extensionKey, Object extensionValue) {
        if (extensions == null) {
            extensions = Maps.newHashMap();
        }
        extensions.put(extensionKey, extensionValue);
    }

}
