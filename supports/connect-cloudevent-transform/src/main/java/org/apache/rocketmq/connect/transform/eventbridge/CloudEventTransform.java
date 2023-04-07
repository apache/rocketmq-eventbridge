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

import com.google.common.base.Strings;
import com.google.gson.Gson;
import io.cloudevents.SpecVersion;
import io.cloudevents.core.v1.CloudEventV1;
import io.openmessaging.KeyValue;
import io.openmessaging.connector.api.component.ComponentContext;
import io.openmessaging.connector.api.data.ConnectRecord;
import org.apache.rocketmq.eventbridge.tools.transform.*;

import java.time.Instant;
import java.util.UUID;

public class CloudEventTransform implements io.openmessaging.connector.api.component.Transform {

    private Transform idTransform;
    private Transform sourceTransform;
    private Transform specversionTransform;
    private Transform typeTransform;
    private Transform datacontenttypeTransform;
    private Transform timeTransform;
    private Transform subjectTransform;

    @Override
    public ConnectRecord doTransform(ConnectRecord record) {
        Object data = record.getData();
        record.addExtension(CloudEventV1.ID, this.buildId(resetRecord(record, data)));
        record.addExtension(CloudEventV1.SOURCE, this.buildSource(resetRecord(record, data)));
        record.addExtension(CloudEventV1.SPECVERSION, this.buildSpecversion(resetRecord(record, data)));
        record.addExtension(CloudEventV1.TYPE, this.buildType(resetRecord(record, data)));
        record.addExtension(CloudEventV1.DATACONTENTTYPE, this.buildDataContentType(resetRecord(record, data)));
        record.addExtension(CloudEventV1.TIME, this.buildTime(resetRecord(record, data)));
        record.addExtension(CloudEventV1.SUBJECT, this.buildSubject(resetRecord(record, data)));
        record.setData(data);
        return record;
    }

    private ConnectRecord resetRecord(ConnectRecord record, Object data) {
        record.setData(data);
        return record;
    }

    private String buildId(ConnectRecord record) {
        if (idTransform == null) {
            return UUID.randomUUID()
                .toString();
        }
        Data result = idTransform.process(new ObjectData(record, ConnectRecord.class));
        String id;
        if (result == null) {
            id = UUID.randomUUID()
                .toString();
        } else {
            id = withStringData(result);
        }
        if (Strings.isNullOrEmpty(id)) {
            return UUID.randomUUID()
                .toString();
        } else {
            return id;
        }
    }

    private String buildSource(ConnectRecord record) {
        if (sourceTransform == null) {
            return null;
        }
        Data result = sourceTransform.process(new ObjectData(record, ConnectRecord.class));
        if (result == null) {
            return null;
        } else {
            return withStringData(result);
        }
    }

    private String buildType(ConnectRecord record) {
        if (typeTransform == null) {
            return null;
        }
        Data result = typeTransform.process(new ObjectData(record, ConnectRecord.class));
        if (result == null) {
            return null;
        } else {
            return withStringData(result);
        }
    }

    private String buildDataContentType(ConnectRecord record) {
        if (datacontenttypeTransform == null) {
            return null;
        }
        Data result = datacontenttypeTransform.process(new ObjectData(record, ConnectRecord.class));
        if (result == null) {
            return null;
        } else {
            return withStringData(result);
        }
    }

    private String buildSpecversion(ConnectRecord record) {
        if (specversionTransform == null) {
            return SpecVersion.V1.toString();
        }
        Data result = specversionTransform.process(new ObjectData(record, ConnectRecord.class));
        if (result == null) {
            return SpecVersion.V1.toString();
        } else {
            return withStringData(result);
        }
    }

    private String buildSubject(ConnectRecord record) {
        if (subjectTransform == null) {
            return null;
        }
        Data result = subjectTransform.process(new ObjectData(record, ConnectRecord.class));
        if (result == null) {
            return null;
        } else {
            return withStringData(result);
        }
    }

    private String buildTime(ConnectRecord record) {
        if (timeTransform == null) {
            return Instant.ofEpochMilli(System.currentTimeMillis())
                .toString();
        }
        Data result = timeTransform.process(new ObjectData(record, ConnectRecord.class));
        if (result == null) {
            return Instant.ofEpochMilli(System.currentTimeMillis())
                .toString();
        } else {
            return withStringData(result);
        }
    }

    private static String withStringData(Data result) {
        if (result instanceof StringData) {
            return ((StringData) result).getData();
        } else if (result instanceof ObjectData) {
            return ((ObjectData) result).toString();
        } else {
            return result.toString();
        }
    }

    @Override
    public void validate(KeyValue config) {

    }

    @Override
    public void init(KeyValue config) {
        this.idTransform = buildTransform(config, CloudEventV1.ID);
        this.sourceTransform = buildTransform(config, CloudEventV1.SOURCE);
        this.specversionTransform = buildTransform(config, CloudEventV1.SPECVERSION);
        this.typeTransform = buildTransform(config, CloudEventV1.TYPE);
        this.datacontenttypeTransform = buildTransform(config, CloudEventV1.DATACONTENTTYPE);
        this.timeTransform = buildTransform(config, CloudEventV1.TIME);
        this.subjectTransform = buildTransform(config, CloudEventV1.SUBJECT);
    }

    @Override
    public void start(ComponentContext componentContext) {

    }

    private Transform buildTransform(KeyValue config, String key) {
        String transformConfig = config.getString(key);
        if (transformConfig == null || Strings.isNullOrEmpty(transformConfig)) {
            return null;
        }
        TransformParam transformParam = new Gson().fromJson(transformConfig, TransformParam.class);
        return EventBridgeTransformBuilder.buildTransform(transformParam);
    }

    @Override
    public void stop() {

    }

}
