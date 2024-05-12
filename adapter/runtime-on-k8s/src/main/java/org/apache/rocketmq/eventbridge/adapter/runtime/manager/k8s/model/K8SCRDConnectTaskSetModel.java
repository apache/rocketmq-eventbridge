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

package org.apache.rocketmq.eventbridge.adapter.runtime.manager.k8s.model;

import com.google.common.collect.Lists;
import com.google.common.collect.Maps;
import java.util.Collections;
import java.util.List;
import java.util.Map;

public class K8SCRDConnectTaskSetModel {
    private String apiVersion = "ops.eventbus.aliyun.com/v1";
    private String kind = "ConnectTaskSet";
    private Map<String, Object> metadata = Maps.newHashMap();
    private Spec spec;

    public K8SCRDConnectTaskSetModel(String taskName, String lanucherConfig, String taskConfig, int replicas,
        String image) {
        metadata.put("name", taskName);
        metadata.put("namespace", "connect");
        metadata.put("labels", Collections.singletonMap("app", "connect-task"));
        spec = new Spec(lanucherConfig, taskConfig, replicas, image);
    }

    private class Spec {
        private int replicas;
        private Selector selector = new Selector();
        private Template template;
        private String taskConfig;
        private String launcherConfig;

        public Spec(String launcherConfig, String taskConfig, int replicas, String image) {
            this.launcherConfig = launcherConfig;
            this.taskConfig = taskConfig;
            this.replicas = replicas;
            this.template = new Template(image);
        }

        private class Selector {
            private Map<String, Object> matchLabels = Maps.newHashMap();

            public Selector() {
                matchLabels.put("app", "source-task");
            }
        }

        private class Template {
            private Map<String, Object> metadata = Maps.newHashMap();
            private Map<String, Object> spec = Maps.newHashMap();

            public Template(String image) {
                this.metadata.put("labels", Collections.singletonMap("app", "source-task"));
                List<Map<String, Object>> containers = Lists.newArrayList();
                Map<String, Object> container = Maps.newHashMap();
                container.put("name", "main");
                container.put("image", image);
                containers.add(container);
                this.spec.put("containers", containers);
                this.spec.put("imagePullSecrets",
                    Lists.newArrayList(Collections.singletonMap("name", "regsecret-vpc")));
                this.spec.put("affinity", Collections.singletonMap("nodeAffinity",
                    Collections.singletonMap("requiredDuringSchedulingIgnoredDuringExecution",
                        Collections.singletonMap("nodeSelectorTerms", Lists.newArrayList(
                            Collections.singletonMap("matchExpressions",
                                Lists.newArrayList(new MatchExpressions("tasktype", "connect"))))))));
                this.spec.put("tolerations", Lists.newArrayList(new Tolerations("connect", "worker")));
            }
        }
    }

    private class Tolerations {
        private String key;
        private String value;
        private String operator = "Equal";
        private String effect = "NoSchedule";

        public Tolerations(String key, String value) {
            this.key = key;
            this.value = value;
        }
    }

    private class MatchExpressions {
        private String key;
        private String operator = "In";
        private List<String> values = Lists.newArrayList();

        public MatchExpressions(String key, String value) {
            this.key = key;
            this.values.add(value);
        }
    }
}
