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
            demo.testListApiDestinations();
        } catch (Exception e) {
            // TODO: handle exception
        }
    }

    /**
     * <b>description</b> :
     * <p>ApiDestination Controller apis:
     * createApiDestination *
     * updateApiDestination *
     * getApiDestination    *
     * deleteApiDestination *
     * listApiDestinations  *</p>
     */
    public void testCreateApiDestination() throws Exception {
        org.apache.rocketmq.eventbridge.sdk.models.CreateApiDestinationRequest request = org.apache.rocketmq.eventbridge.sdk.models.CreateApiDestinationRequest.build(TeaConverter.buildMap(
            new TeaPair("apiDestinationName", "new-api-destination"),
            new TeaPair("connectionName", "new-connection"),
            new TeaPair("description", "demo api destination for test"),
            new TeaPair("httpApiParameters", org.apache.rocketmq.eventbridge.sdk.models.CreateApiDestinationRequest.CreateApiDestinationRequestHttpApiParameters.build(TeaConverter.buildMap(
                new TeaPair("endpoint", _endpoint),
                new TeaPair("method", "POST")
            )))
        ));
        try {
            org.apache.rocketmq.eventbridge.sdk.models.CreateApiDestinationResponse res = _sdkClient.createApiDestination(request);
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

    public void testUpdateApiDestination() throws Exception {
        org.apache.rocketmq.eventbridge.sdk.models.UpdateApiDestinationRequest request = org.apache.rocketmq.eventbridge.sdk.models.UpdateApiDestinationRequest.build(TeaConverter.buildMap(
            new TeaPair("apiDestinationName", "new-api-destination"),
            new TeaPair("connectionName", "new-connection"),
            new TeaPair("description", "!updated! demo api destination for test"),
            new TeaPair("httpApiParameters", org.apache.rocketmq.eventbridge.sdk.models.UpdateApiDestinationRequest.UpdateApiDestinationRequestHttpApiParameters.build(TeaConverter.buildMap(
                new TeaPair("endpoint", _endpoint),
                new TeaPair("method", "GET")
            )))
        ));
        try {
            org.apache.rocketmq.eventbridge.sdk.models.UpdateApiDestinationResponse res = _sdkClient.updateApiDestination(request);
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

    public void testGetApiDestination() throws Exception {
        org.apache.rocketmq.eventbridge.sdk.models.GetApiDestinationRequest request = org.apache.rocketmq.eventbridge.sdk.models.GetApiDestinationRequest.build(TeaConverter.buildMap(
            new TeaPair("apiDestinationName", "new-api-destination")
        ));
        try {
            org.apache.rocketmq.eventbridge.sdk.models.GetApiDestinationResponse res = _sdkClient.getApiDestination(request);
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

    public void testDeleteApiDestination() throws Exception {
        org.apache.rocketmq.eventbridge.sdk.models.DeleteApiDestinationRequest request = org.apache.rocketmq.eventbridge.sdk.models.DeleteApiDestinationRequest.build(TeaConverter.buildMap(
            new TeaPair("apiDestinationName", "new-api-destination")
        ));
        try {
            org.apache.rocketmq.eventbridge.sdk.models.DeleteApiDestinationResponse res = _sdkClient.deleteApiDestination(request);
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

    public void testListApiDestinations() throws Exception {
        org.apache.rocketmq.eventbridge.sdk.models.ListApiDestinationsRequest request = org.apache.rocketmq.eventbridge.sdk.models.ListApiDestinationsRequest.build(TeaConverter.buildMap(
            new TeaPair("maxResults", 2)
        ));
        try {
            org.apache.rocketmq.eventbridge.sdk.models.ListApiDestinationsResponse res = _sdkClient.listApiDestinations(request);
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
