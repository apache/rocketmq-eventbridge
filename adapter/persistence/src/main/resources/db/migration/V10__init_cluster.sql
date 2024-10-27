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

CREATE TABLE IF NOT EXISTS  `event_cluster` (
  `id` int(128) unsigned NOT NULL AUTO_INCREMENT COMMENT 'cluster id',
  `name` varchar(128) DEFAULT NULL COMMENT 'cluster name',
  `resources` varchar(1024) DEFAULT NULL COMMENT 'the spec of worker on cluster',
  `replica` int(11) DEFAULT '2' COMMENT 'the replica of cluster',
  `image` varchar(1024) DEFAULT NULL COMMENT 'the image of cluster',
  `md5` varchar(4096) DEFAULT NULL,
  `gmt_create` datetime DEFAULT NULL COMMENT 'create time',
  `gmt_modify` datetime DEFAULT NULL COMMENT 'modify time',
  PRIMARY KEY (`id`),
  UNIQUE KEY `event_cluster_index_unique_name` (`name`)
) ENGINE=InnoDB  DEFAULT CHARSET=utf8
;