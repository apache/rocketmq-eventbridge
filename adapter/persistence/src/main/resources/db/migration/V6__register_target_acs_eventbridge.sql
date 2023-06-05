# Licensed to the Apache Software Foundation (ASF) under one or more
# contributor license agreements.  See the NOTICE file distributed with
# this work for additional information regarding copyright ownership.
# The ASF licenses this file to You under the Apache License, Version 2.0
# (the "License"); you may not use this file except in compliance with
# the License.  You may obtain a copy of the License at
#
#     http://www.apache.org/licenses/LICENSE-2.0
#
# Unless required by applicable law or agreed to in writing, software
# distributed under the License is distributed on an "AS IS" BASIS,
# WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
# See the License for the specific language governing permissions and
# limitations under the License.

INSERT INTO `event_target_class` (`name`,`api_params`,`target_transform`,`required_params`,`visual_config`,`description`,`gmt_create`,`gmt_modify`)
VALUES
('acs.eventbridge','{\n    \"RegionId\":{\n        \"type\":\"String\",\n        \"desc\":\"the region of aliyun eventbridge.\",\n        \"required\":true\n    },\n    \"AliyunAccountId\":{\n        \"type\":\"String\",\n        \"desc\":\"the account id of aliyun eventbridge.\",\n        \"required\":true\n    },\n    \"AliyunEventBus\":{\n        \"type\":\"String\",\n        \"desc\":\"the bus of aliyun eventbridge.\",\n        \"required\":true\n    },\n    \"AccessKeyId\":{\n        \"type\":\"String\",\n        \"desc\":\"the accessKeyId of aliyun eventbridge.\",\n        \"required\":true\n    },\n    \"AccessKeySecret\":{\n        \"type\":\"String\",\n        \"desc\":\"the accessKeySecret of aliyun eventbridge.\",\n        \"required\":true\n    }\n}','{\n    \"data\":\"{\\\"form\\\":\\\"JSONPATH\\\",\\\"value\\\":\\\"$.data\\\"}\",\n    \"id\":\"{\\\"form\\\":\\\"JSONPATH\\\",\\\"value\\\":\\\"$.id\\\"}\",\n    \"type\":\"{\\\"form\\\":\\\"JSONPATH\\\",\\\"value\\\":\\\"$.type\\\"}\",\n    \"specversion\":\"{\\\"form\\\":\\\"JSONPATH\\\",\\\"value\\\":\\\"$. specversion\\\"}\",\n    \"subject\":\"{\\\"form\\\":\\\"JSONPATH\\\",\\\"value\\\":\\\"$.subject\\\"}\",\n    \"source\":\"{\\\"form\\\":\\\"JSONPATH\\\",\\\"value\\\":\\\"$.source\\\"}\"\n}','{\n    \"aliyuneventbusname\":\"${AliyunEventBus}\",\n    \"accessKeyId\":\"${AccessKeyId}\",\n    \"accessKeySecret\":\"${AccessKeySecret}\",\n    \"accountEndpoint\":\"${AliyunAccountId}.eventbridge.${RegionId}.aliyuncs.com\",\n    \"class\":\"org.apache.rocketmq.connect.eventbridge.sink.EventBridgeSinkConnector\"\n}',NULL,'aliyun eventbridge connector config',now(),now());