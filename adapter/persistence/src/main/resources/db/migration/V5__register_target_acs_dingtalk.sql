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

INSERT INTO `event_target_class` (`name`,`api_params`,`target_transform`,`required_params`,`visual_config`,`description`,`gmt_create`,`gmt_modify`)
VALUES
('acs.dingtalk','{
                     "WebHook":{
                         "type":"String",
                         "desc":"the endpoint of webhook.",
                         "required":true
                     },
                     "SecretKey":{
                         "type":"String",
                         "desc":"the secret key.",
                         "required":true
                     },
                     "Body":{
                         "type":"boolean",
                         "desc":"the content of request"
                     }
                 }','{"data":"${Body}" }'
                 ,'{
                       "webHook":"${WebHook}",
                       "secretKey":"${SecretKey}",
                       "class":"org.apache.rocketmq.connect.dingtalk.sink.DingTalkSinkConnector"
                   }',NULL,'aliyun dingtalk connector config',now(),now());