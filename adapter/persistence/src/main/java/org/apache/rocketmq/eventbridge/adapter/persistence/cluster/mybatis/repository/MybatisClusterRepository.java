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

package org.apache.rocketmq.eventbridge.adapter.persistence.cluster.mybatis.repository;

import java.util.List;

import org.apache.rocketmq.eventbridge.adapter.persistence.cluster.mybatis.mapper.EventClusterMapper;
import org.apache.rocketmq.eventbridge.adapter.runtime.manager.cluster.Cluster;
import org.apache.rocketmq.eventbridge.adapter.runtime.manager.repository.ClusterRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

@Repository
public class MybatisClusterRepository implements ClusterRepository {

    @Autowired
    EventClusterMapper eventClusterMapper;

    @Override
    public List<Cluster> listCluster() {
        List<Cluster> clusterDOList = eventClusterMapper.listCluster();
        return clusterDOList;
    }

    @Override
    public boolean updateCluster(int clusterId, String md5) {
        return eventClusterMapper.updateCluster(clusterId, md5) == 1;
    }

    @Override
    public boolean createCluster(Cluster cluster) {
        return eventClusterMapper.createCluster(cluster.getName(), cluster.getResources(), cluster.getReplica(), cluster.getImage(), cluster.getMd5()) == 1;
    }

    @Override
    public Cluster getCluster(String clusterName) {
        return eventClusterMapper.getCluster(clusterName);
    }

}