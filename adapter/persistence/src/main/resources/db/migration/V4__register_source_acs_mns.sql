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

INSERT INTO `event_source_class` (`name`,`api_params`,`required_params`,`transform`,`visual_config`,`description`,`gmt_create`,`gmt_modify`) VALUES ('acs.mns','{\n    \"RegionId\":{\n        \"type\":\"String\",\n        \"desc\":\"the region of aliyun mns.\",\n        \"required\":true,\n        \"defaultValue\":\"\"\n    },\n    \"QueueName\":{\n        \"type\":\"String\",\n        \"desc\":\"the queue name of aliyun mns.\",\n        \"required\":true,\n        \"defaultValue\":\"\"\n    },\n    \"IsBase64Decode\":{\n        \"type\":\"boolean\",\n        \"desc\":\"base64 decode or not\"\n    },\n    \"AliyunAccountId\":{\n        \"type\":\"String\",\n        \"desc\":\"the account id of aliyun mns.\",\n        \"required\":true\n    },\n    \"AccessKeyId\":{\n        \"type\":\"String\",\n        \"desc\":\"the access key id of aliyun mns.\",\n        \"required\":true\n    },\n    \"AccessKeySecret\":{\n        \"type\":\"String\",\n        \"desc\":\"the access key idsecret of aliyun mns.\",\n        \"required\":true\n    }\n}','{\n    \"accountEndpoint\":\"http://${AliyunAccountId}.mns.${RegionId}.aliyuncs.com\",\n    \"accountId\":\"${AliyunAccountId}\",\n    \"queueName\":\"${QueueName}\",\n    \"isBase64Decode\":\"${IsBase64Decode}\",\n    \"accessKeyId\":\"${AccessKeyId}\",\n    \"accessKeySecret\":\"${AccessKeySecret}\",\n    \"class\":\"org.apache.rocketmq.connect.mns.source.MNSSourceConnector\"\n}','{\n    \"data\":\"{\\\"value\\\":\\\"$.data\\\",\\\"form\\\":\\\"JSONPATH\\\"}\",\n    \"subject\":\"{\\\"value\\\":\\\"acs:mns:${RegionId}:${AliyunAccountId}:queues/${QueueName}\\\",\\\"form\\\":\\\"CONSTANT\\\"}\",\n    \"type\":\"{\\\"value\\\":\\\"mns.sendMsg\\\",\\\"form\\\":\\\"CONSTANT\\\"}\"\n}',NULL,'aliyun mns source',now(),now());
