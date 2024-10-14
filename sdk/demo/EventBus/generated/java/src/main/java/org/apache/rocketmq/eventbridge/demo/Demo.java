// This file is auto-generated, don't edit it. Thanks.
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
