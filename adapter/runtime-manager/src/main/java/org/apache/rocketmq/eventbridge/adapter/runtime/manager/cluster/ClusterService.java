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

package org.apache.rocketmq.eventbridge.adapter.runtime.manager.cluster;

import com.google.common.base.Strings;

import java.util.List;

import org.apache.commons.codec.digest.DigestUtils;
import org.apache.rocketmq.eventbridge.adapter.runtime.manager.repository.ClusterRepository;
import org.apache.rocketmq.eventbridge.domain.common.exception.EventBridgeErrorCode;
import org.apache.rocketmq.eventbridge.exception.EventBridgeException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class ClusterService {

    @Autowired
    private ClusterRepository clusterRepository;

    public boolean createCluster(Cluster cluster) {
        return clusterRepository.createCluster(cluster);
    }

    public boolean scaleCluster(String clusterName, int replica) {
        return true;
    }

    public Cluster getCluster(String clusterName) {
        Cluster cluster = clusterRepository.getCluster(clusterName);
        if (cluster == null) {
            throw new EventBridgeException(EventBridgeErrorCode.EventClusterNotExist, clusterName);
        }
        return cluster;
    }

    public List<Cluster> listCluster() {
        return clusterRepository.listCluster();
    }

    public String calMD5(Cluster cluster) {
        String str = cluster.getName() + cluster.getResources() + cluster.getReplica() + cluster.getImage();
        return DigestUtils.md5Hex(str);
    }

    public boolean isFinalState(Cluster cluster) {
        String md5 = this.calMD5(cluster);
        if (!Strings.isNullOrEmpty(md5) && md5.equals(cluster.getMd5())) {
            return true;
        } else {
            return false;
        }
    }

    public boolean refreshMD5(int clusterId, String md5) {
        return clusterRepository.updateCluster(clusterId, md5);
    }

    public int calLoad(Cluster cluster) {
        return 1;
    }
}