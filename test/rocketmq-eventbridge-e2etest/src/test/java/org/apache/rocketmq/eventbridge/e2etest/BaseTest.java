/*
  Licensed to the Apache Software Foundation (ASF) under one or more
  contributor license agreements.  See the NOTICE file distributed with
  this work for additional information regarding copyright ownership.
  The ASF licenses this file to You under the Apache License, Version 2.0
  (the "License"); you may not use this file except in compliance with
  the License.  You may obtain a copy of the License at

      http://www.apache.org/licenses/LICENSE-2.0

  Unless required by applicable law or agreed to in writing, software
  distributed under the License is distributed on an "AS IS" BASIS,
  WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
  See the License for the specific language governing permissions and
  limitations under the License.
 */
package org.apache.rocketmq.eventbridge.e2etest;

import com.fasterxml.jackson.core.JsonParseException;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.core.Version;
import com.fasterxml.jackson.databind.DeserializationFeature;
import com.fasterxml.jackson.databind.JsonMappingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.module.SimpleModule;
import org.junit.Assert;
import org.junit.Before;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.web.client.TestRestTemplate;
import org.springframework.boot.web.server.LocalServerPort;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;

import java.io.IOException;
import java.net.URL;
import java.util.Map;

public class BaseTest {

    protected final static ObjectMapper mapper = new ObjectMapper();

    static {
        SimpleModule m = new SimpleModule("WorkflowJob", Version.unknownVersion());
        mapper.registerModule(m);

        mapper.configure(DeserializationFeature.FAIL_ON_UNKNOWN_PROPERTIES, false);
    }

    protected URL baseUrl;

    @LocalServerPort
    protected int port;

    @Autowired
    protected TestRestTemplate template;

    @Before
    public void setUp() throws Exception {
        this.baseUrl = new URL("http://localhost:" + port);
    }

    protected <T> T parseDataFromResponse(ResponseEntity<Object> response, Class<T> dataType, Map<Class, Class> modelMapping) {
        Assert.assertEquals(HttpStatus.OK, response.getStatusCode());
        ObjectMapper mapper = new ObjectMapper();
        mapper.configure(DeserializationFeature.FAIL_ON_UNKNOWN_PROPERTIES, false);
        try {
            for (Map.Entry<Class, Class> e : modelMapping.entrySet()) {
                SimpleModule model = new SimpleModule(e.getKey().getSimpleName(), Version.unknownVersion());
                model.addAbstractTypeMapping(e.getKey(), e.getValue());
                mapper.registerModule(model);
            }
            return mapper.readValue(mapper.writeValueAsString(response.getBody()), dataType);
        } catch (JsonParseException e) {
            e.printStackTrace();
            Assert.fail(e.toString());
        } catch (JsonMappingException e) {
            e.printStackTrace();
            Assert.fail(e.toString());
        } catch (JsonProcessingException e) {
            e.printStackTrace();
            Assert.fail(e.toString());
        } catch (IOException e) {
            e.printStackTrace();
            Assert.fail(e.toString());
        }

        return null;
    }

    protected <T> T parseDataFromResponse(ResponseEntity<Object> response, Class<T> dataType) {
        Assert.assertEquals(HttpStatus.OK, response.getStatusCode());

        try {
            return mapper.readValue(mapper.writeValueAsString(response.getBody()), dataType);
        } catch (JsonParseException e) {
            e.printStackTrace();
            Assert.fail(e.toString());
        } catch (JsonMappingException e) {
            e.printStackTrace();
            Assert.fail(e.toString());
        } catch (JsonProcessingException e) {
            e.printStackTrace();
            Assert.fail(e.toString());
        } catch (IOException e) {
            e.printStackTrace();
            Assert.fail(e.toString());
        }

        return null;
    }
}
