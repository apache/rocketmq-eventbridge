// This file is auto-generated, don't edit it. Thanks.
package org.apache.rocketmq.eventbridge.demo;

import com.aliyun.tea.*;

public class Demo {

    public com.aliyun.teaopenapi.models.Config _config;
    public org.apache.rocketmq.eventbridge.sdk.Client _sdkClient;
    public String _endpoint;
    public Demo() throws Exception {
        this._endpoint = "127.0.0.1:7001";
        this._config = com.aliyun.teaopenapi.models.Config.build(TeaConverter.buildMap(
            new TeaPair("endpoint", _endpoint)
        ));
        this._sdkClient = new org.apache.rocketmq.eventbridge.sdk.Client(_config);
    }

    public static void main(String[] args) {
        try {
            Demo demo = new Demo();
            // demo.testListEventSources();
            demo.testCreateEventSource();
            // demo.testGetEventSource();
            // demo.testUpdateEventSource();
            // demo.testGetEventSource();
            // demo.testDeleteEventSource();
            demo.testListEventSources();
        } catch (Exception e) {
            // TODO: handle exception
        }
    }

    /**
     * <b>description</b> :
     * <p>EventSource Controller apis:
     * createEventSource *
     * updateEventSource *
     * deleteEventSource *
     * getEventSource    *
     * listEventSources  *</p>
     */
    public void testCreateEventSource() throws Exception {
        org.apache.rocketmq.eventbridge.sdk.models.CreateEventSourceRequest request = org.apache.rocketmq.eventbridge.sdk.models.CreateEventSourceRequest.build(TeaConverter.buildMap(
            new TeaPair("eventBusName", "newBus"),
            new TeaPair("eventSourceName", "newSource"),
            new TeaPair("description", "a source for test")
        ));
        try {
            org.apache.rocketmq.eventbridge.sdk.models.CreateEventSourceResponse res = _sdkClient.createEventSource(request);
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

    public void testUpdateEventSource() throws Exception {
        org.apache.rocketmq.eventbridge.sdk.models.UpdateEventSourceRequest request = org.apache.rocketmq.eventbridge.sdk.models.UpdateEventSourceRequest.build(TeaConverter.buildMap(
            new TeaPair("eventBusName", "newBus"),
            new TeaPair("eventSourceName", "newSource"),
            new TeaPair("description", "new description for testing Update API")
        ));
        try {
            org.apache.rocketmq.eventbridge.sdk.models.UpdateEventSourceResponse res = _sdkClient.updateEventSource(request);
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

    public void testDeleteEventSource() throws Exception {
        org.apache.rocketmq.eventbridge.sdk.models.DeleteEventSourceRequest request = org.apache.rocketmq.eventbridge.sdk.models.DeleteEventSourceRequest.build(TeaConverter.buildMap(
            new TeaPair("eventBusName", "newBus"),
            new TeaPair("eventSourceName", "newSource")
        ));
        try {
            org.apache.rocketmq.eventbridge.sdk.models.DeleteEventSourceResponse res = _sdkClient.deleteEventSource(request);
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

    public void testGetEventSource() throws Exception {
        org.apache.rocketmq.eventbridge.sdk.models.GetEventSourceRequest request = org.apache.rocketmq.eventbridge.sdk.models.GetEventSourceRequest.build(TeaConverter.buildMap(
            new TeaPair("eventBusName", "newBus"),
            new TeaPair("eventSourceName", "newSource")
        ));
        try {
            org.apache.rocketmq.eventbridge.sdk.models.GetEventSourceResponse res = _sdkClient.getEventSource(request);
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

    public void testListEventSources() throws Exception {
        org.apache.rocketmq.eventbridge.sdk.models.ListEventSourcesRequest request = org.apache.rocketmq.eventbridge.sdk.models.ListEventSourcesRequest.build(TeaConverter.buildMap(
            new TeaPair("eventBusName", "newBus"),
            new TeaPair("eventSourceType", "USER_DEFINED"),
            new TeaPair("maxResults", 10),
            new TeaPair("nextToken", "0")
        ));
        try {
            org.apache.rocketmq.eventbridge.sdk.models.ListEventSourcesResponse res = _sdkClient.listEventSources(request);
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
