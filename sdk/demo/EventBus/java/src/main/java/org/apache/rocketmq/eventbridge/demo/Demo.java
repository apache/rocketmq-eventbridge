// This file is auto-generated, don't edit it. Thanks.
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
package org.apache.rocketmq.eventbridge.demo;

import com.aliyun.tea.*;

public class Demo {

    public org.apache.rocketmq.eventbridge.sdk.Client _sdkClient;
    public String _endpoint;
    public Demo() throws Exception {
        this._endpoint = "127.0.0.1:7001";
        com.aliyun.teaopenapi.models.Config config = com.aliyun.teaopenapi.models.Config.build(TeaConverter.buildMap(
            new TeaPair("endpoint", _endpoint)
        ));
        this._sdkClient = new org.apache.rocketmq.eventbridge.sdk.Client(config);
    }

    public static void main(String[] args) {
        try {
            Demo demo = new Demo();
            // demo.testListEventBuses();
            // demo.testCreateEventBus();
            // demo.testGetEventBus();
            // demo.testDeleteEventBus();
            demo.testListEventBuses();
        } catch (Exception e) {
            // TODO: handle exception
        }
    }

    /**
     * <b>description</b> :
     * <p>test func for EventBus Controller apis:
     * createEventBus *
     * getEventBus    *
     * deleteEventBus *
     * listEventBuses *</p>
     */
    public void testCreateEventBus() throws Exception {
        org.apache.rocketmq.eventbridge.sdk.models.CreateEventBusRequest request = org.apache.rocketmq.eventbridge.sdk.models.CreateEventBusRequest.build(TeaConverter.buildMap(
            new TeaPair("eventBusName", "newBus")
        ));
        try {
            org.apache.rocketmq.eventbridge.sdk.models.CreateEventBusResponse res = _sdkClient.createEventBus(request);
            com.aliyun.teaconsole.Client.log(com.aliyun.teautil.Common.toJSONString(res.body));
        } catch (TeaException err) {
            com.aliyun.teaconsole.Client.log("err!");
            com.aliyun.teaconsole.Client.log(err.message);
        } catch (Exception _err) {
            TeaException err = new TeaException(_err.getMessage(), _err);
            com.aliyun.teaconsole.Client.log("err!");
            com.aliyun.teaconsole.Client.log(err.message);
        } finally {
            com.aliyun.teaconsole.Client.log("test end!");
        }        
    }

    public void testDeleteEventBus() throws Exception {
        org.apache.rocketmq.eventbridge.sdk.models.DeleteEventBusRequest request = org.apache.rocketmq.eventbridge.sdk.models.DeleteEventBusRequest.build(TeaConverter.buildMap(
            new TeaPair("eventBusName", "newBus")
        ));
        try {
            org.apache.rocketmq.eventbridge.sdk.models.DeleteEventBusResponse res = _sdkClient.deleteEventBus(request);
            com.aliyun.teaconsole.Client.log(com.aliyun.teautil.Common.toJSONString(res.body));
        } catch (TeaException err) {
            com.aliyun.teaconsole.Client.log("err!");
            com.aliyun.teaconsole.Client.log(err.message);
        } catch (Exception _err) {
            TeaException err = new TeaException(_err.getMessage(), _err);
            com.aliyun.teaconsole.Client.log("err!");
            com.aliyun.teaconsole.Client.log(err.message);
        } finally {
            com.aliyun.teaconsole.Client.log("test end!");
        }        
    }

    public void testGetEventBus() throws Exception {
        org.apache.rocketmq.eventbridge.sdk.models.GetEventBusRequest request = org.apache.rocketmq.eventbridge.sdk.models.GetEventBusRequest.build(TeaConverter.buildMap(
            new TeaPair("eventBusName", "newBus")
        ));
        try {
            org.apache.rocketmq.eventbridge.sdk.models.GetEventBusResponse res = _sdkClient.getEventBus(request);
            com.aliyun.teaconsole.Client.log(com.aliyun.teautil.Common.toJSONString(res.body));
        } catch (TeaException err) {
            com.aliyun.teaconsole.Client.log("err!");
            com.aliyun.teaconsole.Client.log(err.message);
        } catch (Exception _err) {
            TeaException err = new TeaException(_err.getMessage(), _err);
            com.aliyun.teaconsole.Client.log("err!");
            com.aliyun.teaconsole.Client.log(err.message);
        } finally {
            com.aliyun.teaconsole.Client.log("test end!");
        }        
    }

    public void testListEventBuses() throws Exception {
        org.apache.rocketmq.eventbridge.sdk.models.ListEventBusesRequest request = org.apache.rocketmq.eventbridge.sdk.models.ListEventBusesRequest.build(TeaConverter.buildMap(
            new TeaPair("maxResults", 2)
        ));
        try {
            org.apache.rocketmq.eventbridge.sdk.models.ListEventBusesResponse res = _sdkClient.listEventBuses(request);
            com.aliyun.teaconsole.Client.log(com.aliyun.teautil.Common.toJSONString(res.body));
        } catch (TeaException err) {
            com.aliyun.teaconsole.Client.log("err!");
            com.aliyun.teaconsole.Client.log(err.message);
        } catch (Exception _err) {
            TeaException err = new TeaException(_err.getMessage(), _err);
            com.aliyun.teaconsole.Client.log("err!");
            com.aliyun.teaconsole.Client.log(err.message);
        } finally {
            com.aliyun.teaconsole.Client.log("test end!");
        }        
    }
}
