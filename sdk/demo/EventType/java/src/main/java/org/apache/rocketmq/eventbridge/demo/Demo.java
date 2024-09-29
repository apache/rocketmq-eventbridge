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
            demo.testListEventTypes();
        } catch (Exception e) {
            // TODO: handle exception
        }
    }

    /**
     * <b>description</b> :
     * <p>EventType Controller apis:
     * listEventTypes *</p>
     */
    public void testListEventTypes() throws Exception {
        org.apache.rocketmq.eventbridge.sdk.models.ListEventTypesRequest request = org.apache.rocketmq.eventbridge.sdk.models.ListEventTypesRequest.build(TeaConverter.buildMap(
            new TeaPair("eventBusName", "newBus"),
            new TeaPair("eventSourceName", "newSource"),
            new TeaPair("maxResults", 10),
            new TeaPair("nextToken", "0")
        ));
        try {
            org.apache.rocketmq.eventbridge.sdk.models.ListEventTypesResponse res = _sdkClient.listEventTypes(request);
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
