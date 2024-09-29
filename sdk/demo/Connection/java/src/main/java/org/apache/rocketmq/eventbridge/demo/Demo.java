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
            // demo.testListEnumsResponse();
            // demo.testListConnections();
            // demo.testCreateConnection();
            // demo.testGetConnections();
            // demo.testUpdateConnection();
            // demo.testGetConnections();
            // demo.testDeleteConnection();
            // demo.testListConnections();
            demo.testSelectOneConnection();
        } catch (Exception e) {
            // TODO: handle exception
        }
    }

    /**
     * <b>description</b> :
     * <p>test func for Connection Controller apis:
     * createConnection    *
     * deleteConnection    *
     * updateConnection    *
     * getConnection       *
     * selectOneConnection *
     * listConnections     *
     * listEnumsResponse   *</p>
     */
    public void testCreateConnection() throws Exception {
        org.apache.rocketmq.eventbridge.sdk.models.CreateConnectionRequest request = org.apache.rocketmq.eventbridge.sdk.models.CreateConnectionRequest.build(TeaConverter.buildMap(
            new TeaPair("connectionName", "new-connection"),
            new TeaPair("networkParameters", TeaConverter.buildMap(
                new TeaPair("networkType", "PublicNetwork")
            ))
        ));
        try {
            org.apache.rocketmq.eventbridge.sdk.models.CreateConnectionResponse res = _sdkClient.createConnection(request);
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

    public void testDeleteConnection() throws Exception {
        org.apache.rocketmq.eventbridge.sdk.models.DeleteConnectionRequest request = org.apache.rocketmq.eventbridge.sdk.models.DeleteConnectionRequest.build(TeaConverter.buildMap(
            new TeaPair("connectionName", "new-connection")
        ));
        try {
            org.apache.rocketmq.eventbridge.sdk.models.DeleteConnectionResponse res = _sdkClient.deleteConnection(request);
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

    public void testUpdateConnection() throws Exception {
        org.apache.rocketmq.eventbridge.sdk.models.UpdateConnectionRequest request = org.apache.rocketmq.eventbridge.sdk.models.UpdateConnectionRequest.build(TeaConverter.buildMap(
            new TeaPair("connectionName", "new-connection"),
            new TeaPair("networkParameters", TeaConverter.buildMap(
                new TeaPair("networkType", "PrivateNetwork"),
                new TeaPair("securityGroupId", "eb-167adad548759-security_grop/sg-bp1addad26peuh9qh9rtyb"),
                new TeaPair("vpcId", "eb-test/vpc-bp1symadadwnwgmqud"),
                new TeaPair("vswitcheId", "vsw-bp1iu4x7aeradadown1og8,vsw-bp193sqmadadlaszpeqbt2c")
            ))
        ));
        try {
            org.apache.rocketmq.eventbridge.sdk.models.UpdateConnectionResponse res = _sdkClient.updateConnection(request);
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

    public void testGetConnections() throws Exception {
        org.apache.rocketmq.eventbridge.sdk.models.GetConnectionRequest request = org.apache.rocketmq.eventbridge.sdk.models.GetConnectionRequest.build(TeaConverter.buildMap(
            new TeaPair("connectionName", "new-connection")
        ));
        try {
            org.apache.rocketmq.eventbridge.sdk.models.GetConnectionResponse res = _sdkClient.getConnection(request);
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

    public void testSelectOneConnection() throws Exception {
        org.apache.rocketmq.eventbridge.sdk.models.GetConnectionRequest request = org.apache.rocketmq.eventbridge.sdk.models.GetConnectionRequest.build(TeaConverter.buildMap(
            new TeaPair("connectionName", "new-connection")
        ));
        try {
            org.apache.rocketmq.eventbridge.sdk.models.GetConnectionResponse res = _sdkClient.selectOneConnection(request);
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

    public void testListConnections() throws Exception {
        org.apache.rocketmq.eventbridge.sdk.models.ListConnectionsRequest request = new org.apache.rocketmq.eventbridge.sdk.models.ListConnectionsRequest();
        try {
            org.apache.rocketmq.eventbridge.sdk.models.ListConnectionsResponse res = _sdkClient.listConnections(request);
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

    public void testListEnumsResponse() throws Exception {
        try {
            org.apache.rocketmq.eventbridge.sdk.models.ListEnumsResponseResponse res = _sdkClient.listEnumsResponse();
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
