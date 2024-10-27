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

CREATE TABLE `event_worker` (
  `id` varchar(128) NOT NULL,
  `cluster_id` varchar(128) DEFAULT NULL COMMENT 'the cluster id of worker',
  `name` varchar(128) DEFAULT NULL COMMENT 'worker name',
  `image` varchar(1024) DEFAULT NULL COMMENT 'the image of cluster',
  `resources` varchar(1024) DEFAULT NULL COMMENT 'the spec of worker',
  `config` text DEFAULT NULL COMMENT 'the config of worker',
  `status` varchar(128) DEFAULT NULL COMMENT 'Worker name',
  `gmt_create` datetime DEFAULT NULL COMMENT 'create time',
  `gmt_modify` datetime DEFAULT NULL COMMENT 'modify time',
  `md5` varchar(128) DEFAULT NULL COMMENT 'worker config md5',
  PRIMARY KEY (`id`),
  UNIQUE KEY `connect_worker_name_index`(`name`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8
;
