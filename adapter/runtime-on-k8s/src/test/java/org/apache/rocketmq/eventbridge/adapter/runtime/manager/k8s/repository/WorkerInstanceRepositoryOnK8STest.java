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
package org.apache.rocketmq.eventbridge.adapter.runtime.manager.k8s.repository;

import com.google.common.collect.Maps;
import com.google.gson.Gson;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import lombok.extern.slf4j.Slf4j;
import org.apache.rocketmq.eventbridge.adapter.runtime.manager.worker.WorkerResource;
import org.apache.rocketmq.eventbridge.adapter.runtime.manager.worker.WorkerStatusEnum;
import org.junit.Ignore;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import static org.junit.Assert.assertEquals;

@Slf4j
@RunWith(SpringRunner.class)
@SpringBootTest(classes = WorkerInstanceRepositoryOnK8STest.class)
@SpringBootApplication(scanBasePackages = {"org.apache.rocketmq.eventbridge.adapter.runtime.manager.k8s.*"})
@Ignore
public class WorkerInstanceRepositoryOnK8STest {

    @Autowired
    private WorkerInstanceRepositoryOnK8S workerInstanceRepositoryOnK8S;

    @Test
    public void applyWorkerInstance() {
        Map<String, Object> environments = Maps.newHashMap();
        environments.put("key1", "value1");
        environments.put("key2", "value2");
        workerInstanceRepositoryOnK8S.applyWorkerInstance("worker-4", "apache/rocketmq-eventbridge:1.1.0", new Gson().fromJson("{\"cpu\":100,\"memory\":100}", WorkerResource.class), environments);
    }

    @Test
    public void applyWorkerInstanceWithConfigMap() {
        Map<String, Object> environments = Maps.newHashMap();
        environments.put("key1", "value1");
        environments.put("key2", "value2");
        List<Map<String, String>> volums = new ArrayList<>();
        volums.add(new HashMap<String, String>(){{
            put("name", "worker-config");
        }});
        environments.put("volums", volums);
        workerInstanceRepositoryOnK8S.applyWorkerInstance("worker-4", "apache/rocketmq-eventbridge:1.1.0", new Gson().fromJson("{\"cpu\":100,\"memory\":100}", WorkerResource.class), environments);
    }

    @Test
    public void deleteWorkerInstance() {
        Map<String, Object> environments = Maps.newHashMap();
        environments.put("key1", "value1");
        environments.put("key2", "value2");
        workerInstanceRepositoryOnK8S.deleteWorkerInstance("worker-4", environments);
    }

    @Test
    public void getWorkerInstanceStatus() {
        Map<String, Object> environments = Maps.newHashMap();
        environments.put("key1", "value1");
        environments.put("key2", "value2");
        assertEquals(WorkerStatusEnum.RUN, workerInstanceRepositoryOnK8S.getWorkerInstanceStatus("worker-4", environments));
    }

    @Test
    public void applyWorkerInstanceConfigFile() {
        Map<String, Object> environments = Maps.newHashMap();
        environments.put("key1", "value1");
        environments.put("key2", "value2");
        String taskConfig = "[\n" +
                "  {\n" +
                "    \"name\":\"demo-runner\",\n" +
                "    \"components\":[\n" +
                "      {\n" +
                "        \"accountId\": \"654321\",\n" +
                "        \"eventBusName\":\"demo-bus\"\n" +
                "      },\n" +
                "      {\n" +
                "        \"filterPattern\":\"{}\",\n" +
                "        \"class\":\"org.apache.rocketmq.connect.transform.eventbridge.EventBridgeFilterTransform\"\n" +
                "      },\n" +
                "      {\n" +
                "        \"data\":\"{\\\"form\\\":\\\"TEMPLATE\\\",\\\"value\\\":\\\"{\\\\\\\"content\\\\\\\":\\\\\\\"$.data.body\\\\\\\"}\\\",\\\"template\\\":\\\"{\\\\\\\"text\\\\\\\":{\\\\\\\"content\\\\\\\":\\\\\\\"${content}\\\\\\\"},\\\\\\\"msgtype\\\\\\\":\\\\\\\"text\\\\\\\"}\\\"}\",\n" +
                "        \"class\": \"org.apache.rocketmq.connect.transform.eventbridge.EventBridgeTransform\"\n" +
                "      },\n" +
                "      {\n" +
                "        \"class\":\"org.apache.rocketmq.connect.dingtalk.sink.DingTalkSinkTask\",\n" +
                "        \"webHook\":\"xxxxxxxxxxx\",\n" +
                "        \"secretKey\":\"xxxxxxxxxxx\"\n" +
                "      }\n" +
                "    ]\n" +
                "  }\n" +
                "]";
        workerInstanceRepositoryOnK8S.applyWorkerInstanceConfigFile("worker-config", "task-config", taskConfig, environments);
    }

    @Test
    @Ignore
    public void getWorkerInstanceConfigFile() {
        Map<String, Object> environments = Maps.newHashMap();
        environments.put("key1", "value1");
        environments.put("key2", "value2");
        workerInstanceRepositoryOnK8S.getWorkerInstanceConfigFile("worker-4", "/eventbridge/task-config", environments);
    }
}