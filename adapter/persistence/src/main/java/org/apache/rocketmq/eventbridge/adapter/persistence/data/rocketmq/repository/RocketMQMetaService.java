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
package org.apache.rocketmq.eventbridge.adapter.persistence.data.rocketmq.repository;

import java.util.Collection;
import java.util.HashSet;
import java.util.List;
import java.util.Set;
import lombok.extern.slf4j.Slf4j;
import org.apache.rocketmq.client.exception.MQBrokerException;
import org.apache.rocketmq.client.exception.MQClientException;
import org.apache.rocketmq.common.protocol.body.ClusterInfo;
import org.apache.rocketmq.common.protocol.route.BrokerData;
import org.apache.rocketmq.eventbridge.exception.EventBridgeException;
import org.apache.rocketmq.eventbridge.exception.code.DefaultErrorCode;
import org.apache.rocketmq.remoting.exception.RemotingConnectException;
import org.apache.rocketmq.remoting.exception.RemotingSendRequestException;
import org.apache.rocketmq.remoting.exception.RemotingTimeoutException;
import org.apache.rocketmq.tools.admin.DefaultMQAdminExt;
import org.springframework.stereotype.Service;

@Service
@Slf4j
public class RocketMQMetaService {

    private final DefaultMQAdminExt defaultMQAdminExt;

    private final static int DEFAULT_QUEUE_NUM = 1;

    public RocketMQMetaService(DefaultMQAdminExt defaultMQAdminExt) {
        this.defaultMQAdminExt = defaultMQAdminExt;
    }

    public boolean createTopic(String clusterName, String topicName) {
        try {
            defaultMQAdminExt.createTopic(clusterName, topicName, DEFAULT_QUEUE_NUM);
        } catch (MQClientException e) {
            log.error("Create topic failed.", e);
            throw new EventBridgeException(DefaultErrorCode.InternalError, e);
        }
        return Boolean.TRUE;
    }

    public boolean deleteTopic(String clusterName, String topicName) {
        try {
            Set<String> brokerAddressSet = fetchMasterAndSlaveAddrByClusterName(clusterName);
            defaultMQAdminExt.deleteTopicInBroker(brokerAddressSet, topicName);
            List<String> nameServerList = defaultMQAdminExt.getNameServerAddressList();
            defaultMQAdminExt.deleteTopicInNameServer(new HashSet<String>(nameServerList), topicName);
        } catch (Throwable e) {
            log.error("Delete topic failed.", e);
            throw new EventBridgeException(DefaultErrorCode.InternalError, e);
        }
        return Boolean.TRUE;
    }

    private Set<String> fetchMasterAndSlaveAddrByClusterName(String clusterName)
        throws InterruptedException, RemotingConnectException, RemotingTimeoutException, RemotingSendRequestException,
        MQBrokerException {
        Set<String> brokerAddressSet = new HashSet<String>();
        ClusterInfo clusterInfoSerializeWrapper = defaultMQAdminExt.examineBrokerClusterInfo();
        Set<String> brokerNameSet = clusterInfoSerializeWrapper.getClusterAddrTable()
            .get(clusterName);
        if (brokerNameSet != null) {
            for (String brokerName : brokerNameSet) {
                BrokerData brokerData = clusterInfoSerializeWrapper.getBrokerAddrTable()
                    .get(brokerName);
                if (brokerData != null) {
                    final Collection<String> addrs = brokerData.getBrokerAddrs()
                        .values();
                    brokerAddressSet.addAll(addrs);
                }
            }
        }
        return brokerAddressSet;
    }
}
