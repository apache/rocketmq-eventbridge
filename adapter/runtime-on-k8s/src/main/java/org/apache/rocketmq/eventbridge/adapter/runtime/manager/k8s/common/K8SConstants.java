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

package org.apache.rocketmq.eventbridge.adapter.runtime.manager.k8s.common;

public class K8SConstants {
    public static final String CONNECT_TASK_SETS_GROUP = "ops.eventbus.aliyun.com";
    public static final String CONNECT_TASK_SETS_VERSION = "v1";
    public static final String CONNECT_TASK_SETS_PLURAL = "connecttasksets";
    public static final String DEFAULT_ASK_TASK_USER = "EB_ASK_CONNECT";
    public static final String DEFAULT_CLUSTER_SUPPORT_CONNECTOR = "ALL";
    public static final String DEFAULT_CONNECTOR_KEY_TASK_SIZE = "TASK_SIZE";

    public static final String SELECTOR_LABEL_KEY = "app";

    public static final String DEPLOYMENT_KIND = "Deployment";
}
