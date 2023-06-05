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

CREATE TABLE IF NOT EXISTS `event_bus` (
  `id` bigint(20) unsigned NOT NULL AUTO_INCREMENT,
  `account_id` varchar(255) NOT NULL COMMENT 'bus account id',
  `name` varchar(255) NOT NULL COMMENT 'bus name',
  `description` varchar(256) DEFAULT NULL COMMENT 'bus description',
  `gmt_create` datetime DEFAULT NULL COMMENT 'create time',
  `gmt_modify` datetime DEFAULT NULL COMMENT 'modify time',
  PRIMARY KEY (`id`),
  UNIQUE KEY `name_uniq_key_event_bus` (`account_id`,`name`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

CREATE TABLE IF NOT EXISTS `event_topic` (
  `id` int(11) unsigned NOT NULL AUTO_INCREMENT,
  `account_id` varchar(255) DEFAULT 'SYSTEM' COMMENT 'source account id',
  `bus` varchar(255) NOT NULL COMMENT 'bus name',
  `name` varchar(255) NOT NULL COMMENT 'topic name',
  `msg_ttl` int(11) NOT NULL COMMENT 'msg ttl',
  `cluster` varchar(255) NOT NULL COMMENT 'the cluster of topic',
  `status` tinyint(4) NOT NULL COMMENT '0:disable, 1:enable',
  `gmt_create` datetime DEFAULT NULL COMMENT 'create time',
  `gmt_modify` datetime DEFAULT NULL COMMENT 'modify time',
  PRIMARY KEY (`id`),
  UNIQUE KEY `name_uniq_key_event_topicdd` (`name`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

CREATE TABLE IF NOT EXISTS `event_source` (
  `id` int(11) unsigned NOT NULL AUTO_INCREMENT,
  `account_id` varchar(255) DEFAULT 'SYSTEM' COMMENT 'source account id',
  `bus` varchar(255) NOT NULL COMMENT 'bus name',
  `name` varchar(255) NOT NULL DEFAULT '' COMMENT 'source name',
  `status` int(11) NOT NULL DEFAULT '0' COMMENT '0:disable, 1:enable',
  `type` int(11) NOT NULL DEFAULT '1' COMMENT 'event source type',
  `class_name` varchar(255) COMMENT 'event source class name',
  `config` text COMMENT 'event source runner config',
  `description` varchar(1024) DEFAULT NULL COMMENT 'event source description',
  `gmt_create` datetime DEFAULT NULL COMMENT 'create time',
  `gmt_modify` datetime DEFAULT NULL COMMENT 'modify time',
  PRIMARY KEY (`id`),
  UNIQUE KEY `name_uniq_key_event_source` (`account_id`,`name`)
) ENGINE=InnoDB  DEFAULT CHARSET=utf8
;

CREATE TABLE IF NOT EXISTS `event_type` (
  `id` bigint(20) unsigned NOT NULL AUTO_INCREMENT,
  `account_id` varchar(255) NOT NULL COMMENT 'bus account id',
  `bus` varchar(255) NOT NULL COMMENT 'bus name',
  `source` varchar(255) NOT NULL DEFAULT '' COMMENT 'event source name',
  `name` varchar(255) NOT NULL DEFAULT '' COMMENT 'event type name',
  `description` varchar(255) DEFAULT NULL COMMENT 'a description about the event type',
  `gmt_create` datetime DEFAULT NULL COMMENT 'create time',
  `gmt_modify` datetime DEFAULT NULL COMMENT 'modify time',
  PRIMARY KEY (`id`),
  UNIQUE KEY `name_uniq_key_event_type` (`source`,`name`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8
;

CREATE TABLE IF NOT EXISTS  `event_rule` (
  `id` bigint(20) unsigned NOT NULL AUTO_INCREMENT,
  `account_id` varchar(255) NOT NULL COMMENT 'bus account id',
  `bus` varchar(255) NOT NULL COMMENT 'bus name',
  `name` varchar(255) NOT NULL COMMENT 'rule name',
  `filter_pattern` varchar(4096) DEFAULT NULL COMMENT 'event filter pattern',
  `status` tinyint(4) NOT NULL COMMENT '0:disable, 1:enable',
  `description` varchar(255) DEFAULT NULL COMMENT 'a description about the event rule',
  `gmt_create` datetime DEFAULT NULL COMMENT 'create time',
  `gmt_modify` datetime DEFAULT NULL COMMENT 'modify time',
  UNIQUE KEY `id` (`id`),
  UNIQUE KEY `name_uniq_key_event_rule` (`account_id`,`name`,`bus`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8
;

CREATE TABLE IF NOT EXISTS `event_source_runner` (
  `id` int(11) unsigned NOT NULL AUTO_INCREMENT,
  `account_id` varchar(255) DEFAULT 'SYSTEM' COMMENT 'source account id',
  `bus` varchar(255) NOT NULL COMMENT 'bus name',
  `source` varchar(255) NOT NULL DEFAULT '' COMMENT 'source name',
  `run_options` varchar(1024) DEFAULT NULL COMMENT 'event source runner options',
  `run_context` varchar(1024) DEFAULT NULL COMMENT 'event source running context',
  `gmt_create` datetime DEFAULT NULL COMMENT 'create time',
  `gmt_modify` datetime DEFAULT NULL COMMENT 'modify time',
  PRIMARY KEY (`id`),
  UNIQUE KEY `name_uniq_key_event_source_runner` (`account_id`,`bus`,`source`)
) ENGINE=InnoDB  DEFAULT CHARSET=utf8
;

CREATE TABLE IF NOT EXISTS `event_target` (
  `id` int(11) unsigned NOT NULL AUTO_INCREMENT,
  `account_id` varchar(255) DEFAULT 'SYSTEM' COMMENT 'target account id',
  `bus` varchar(255) NOT NULL COMMENT 'bus name',
  `rule` varchar(255) NOT NULL DEFAULT '' COMMENT 'rule name',
  `name` varchar(255) NOT NULL DEFAULT '' COMMENT 'target name',
  `class_name` varchar(255) NOT NULL COMMENT 'event target class name',
  `config` text NOT NULL COMMENT 'event target runner config',
  `run_options` varchar(1024) DEFAULT NULL COMMENT 'event target runner options',
  `gmt_create` datetime DEFAULT NULL COMMENT 'create time',
  `gmt_modify` datetime DEFAULT NULL COMMENT 'modify time',
  PRIMARY KEY (`id`),
  UNIQUE KEY `name_uniq_key_event_target` (`account_id`,`bus`,`rule`,`name`)
) ENGINE=InnoDB  DEFAULT CHARSET=utf8
;



CREATE TABLE IF NOT EXISTS `event_target_runner` (
  `id` int(11) unsigned NOT NULL AUTO_INCREMENT,
  `account_id` varchar(255) DEFAULT 'SYSTEM' COMMENT 'target account id',
  `bus` varchar(255) NOT NULL COMMENT 'bus name',
  `rule` varchar(255) NOT NULL DEFAULT '' COMMENT 'rule name',
  `target` varchar(255) NOT NULL DEFAULT '' COMMENT 'target name',
  `run_context` varchar(1024) DEFAULT NULL COMMENT 'event target running context',
  `gmt_create` datetime DEFAULT NULL COMMENT 'create time',
  `gmt_modify` datetime DEFAULT NULL COMMENT 'modify time',
  PRIMARY KEY (`id`),
  UNIQUE KEY `name_uniq_key_event_target_runner` (`account_id`,`bus`,`rule`,`target`)
) ENGINE=InnoDB  DEFAULT CHARSET=utf8
;


CREATE TABLE IF NOT EXISTS `event_source_class` (
  `id` int(11) unsigned NOT NULL AUTO_INCREMENT,
  `name` varchar(255) NOT NULL DEFAULT '' COMMENT 'source class name',
  `api_params` text NOT NULL COMMENT 'event source api params',
  `required_params` text NOT NULL COMMENT 'event source required params',
  `transform` text NOT NULL COMMENT 'transform the event source data',
  `visual_config` text DEFAULT NULL COMMENT 'event source fore-end visual config',
  `description` varchar(255) DEFAULT NULL COMMENT 'a description about the source class',
  `gmt_create` datetime DEFAULT NULL COMMENT 'create time',
  `gmt_modify` datetime DEFAULT NULL COMMENT 'modify time',
  PRIMARY KEY (`id`),
  UNIQUE KEY `name_uniq_key_event_source_class` (`name`)
) ENGINE=InnoDB  DEFAULT CHARSET=utf8
;


CREATE TABLE IF NOT EXISTS `event_target_class` (
  `id` int(11) unsigned NOT NULL AUTO_INCREMENT,
  `name` varchar(255) NOT NULL DEFAULT '' COMMENT 'target class name',
  `api_params` text NOT NULL COMMENT 'event target api params',
  `target_transform` text NOT NULL COMMENT 'event target required data',
  `required_params` text NOT NULL COMMENT 'event target required params',
  `visual_config` text DEFAULT NULL COMMENT 'event target fore-end visual config',
  `description` varchar(255) DEFAULT NULL COMMENT 'a description about the target class',
  `gmt_create` datetime DEFAULT NULL COMMENT 'create time',
  `gmt_modify` datetime DEFAULT NULL COMMENT 'modify time',
  PRIMARY KEY (`id`),
  UNIQUE KEY `name_uniq_key_event_target_class` (`name`)
) ENGINE=InnoDB  DEFAULT CHARSET=utf8
;
