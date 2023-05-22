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

CREATE TABLE IF NOT EXISTS `event_connection` (
    `id` int(11) unsigned NOT NULL AUTO_INCREMENT,
    `account_id` varchar(255) NOT NULL COMMENT 'event_connection account id',
    `name` varchar(128) NOT NULL DEFAULT '' COMMENT '名称',
    `authorization_type` varchar(128) DEFAULT NULL COMMENT '授权类型',
    `auth_parameters` text DEFAULT NULL COMMENT '',
    `network_type` varchar(128) NOT NULL DEFAULT '' COMMENT '网络类型',
    `network_parameters` text DEFAULT NULL COMMENT '网络配置',
    `description` varchar(255) DEFAULT NULL COMMENT 'a description about the event_connection',
    `gmt_create` datetime DEFAULT NULL COMMENT 'create time',
    `gmt_modify` datetime DEFAULT NULL COMMENT 'modify time',
    PRIMARY KEY (`id`),
    UNIQUE KEY `name_uniq_key_event_connection` (`name`)
    ) ENGINE=InnoDB  DEFAULT CHARSET=utf8
;


CREATE TABLE IF NOT EXISTS `event_api_destination` (
    `id` int(11) unsigned NOT NULL AUTO_INCREMENT,
    `account_id` varchar(255) NOT NULL COMMENT 'event_api_destination account id',
    `name` varchar(128) NOT NULL DEFAULT '' COMMENT '名称',
    `protocol` varchar(128) NOT NULL DEFAULT '' COMMENT '类型',
    `api_params` text NOT NULL COMMENT 'API 参数',
    `connection_name` varchar(128) DEFAULT NULL COMMENT '连接信息',
    `invocation_rate_limit_per_second` int(11) COMMENT '每秒推送速率',
    `description` varchar(255) DEFAULT NULL COMMENT 'a description about the event_api_destination',
    `gmt_create` datetime DEFAULT NULL COMMENT 'create time',
    `gmt_modify` datetime DEFAULT NULL COMMENT 'modify time',
    PRIMARY KEY (`id`),
    UNIQUE KEY `name_uniq_key_event_api_destination` (`name`)
    ) ENGINE=InnoDB  DEFAULT CHARSET=utf8
;
