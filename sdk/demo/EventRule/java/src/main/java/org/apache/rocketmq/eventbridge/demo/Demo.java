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
            // demo.testListEventRules();
            demo.testCreateEventRule();
            // demo.testGetEventRule();
            // demo.testUpdateEventRule();
            // demo.testGetEventRule();
            // demo.testDisableEventRule();
            // demo.testGetEventRule();
            // demo.testEnableEventRule();
            // demo.testGetEventRule();
            // demo.testDeleteEventRule();
            // demo.testListEventRules();
        } catch (Exception e) {
            // TODO: handle exception
        }
    }

    /**
     * <b>description</b> :
     * <p>EventRule Controller apis:
     * createEventRule  *
     * getEventRule     *
     * deleteEventRule  *
     * updateEventRule  *
     * listEventRules   *
     * enableEventRule  *
     * disableEventRule *</p>
     */
    public void testCreateEventRule() throws Exception {
        org.apache.rocketmq.eventbridge.sdk.models.CreateEventRuleRequest request = org.apache.rocketmq.eventbridge.sdk.models.CreateEventRuleRequest.build(TeaConverter.buildMap(
            new TeaPair("eventBusName", "newBus"),
            new TeaPair("eventRuleName", "newRule"),
            new TeaPair("description", "an event rule for test"),
            new TeaPair("filterPattern", "{}")
        ));
        try {
            org.apache.rocketmq.eventbridge.sdk.models.CreateEventRuleResponse res = _sdkClient.createEventRule(request);
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

    public void testGetEventRule() throws Exception {
        org.apache.rocketmq.eventbridge.sdk.models.GetEventRuleRequest request = org.apache.rocketmq.eventbridge.sdk.models.GetEventRuleRequest.build(TeaConverter.buildMap(
            new TeaPair("eventBusName", "newBus"),
            new TeaPair("eventRuleName", "newRule")
        ));
        try {
            org.apache.rocketmq.eventbridge.sdk.models.GetEventRuleResponse res = _sdkClient.getEventRule(request);
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

    public void testDeleteEventRule() throws Exception {
        org.apache.rocketmq.eventbridge.sdk.models.DeleteEventRuleRequest request = org.apache.rocketmq.eventbridge.sdk.models.DeleteEventRuleRequest.build(TeaConverter.buildMap(
            new TeaPair("eventBusName", "newBus"),
            new TeaPair("eventRuleName", "newRule")
        ));
        try {
            org.apache.rocketmq.eventbridge.sdk.models.DeleteEventRuleResponse res = _sdkClient.deleteEventRule(request);
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

    public void testUpdateEventRule() throws Exception {
        org.apache.rocketmq.eventbridge.sdk.models.UpdateEventRuleRequest request = org.apache.rocketmq.eventbridge.sdk.models.UpdateEventRuleRequest.build(TeaConverter.buildMap(
            new TeaPair("eventBusName", "newBus"),
            new TeaPair("eventRuleName", "newRule"),
            new TeaPair("description", "new description for testing update API"),
            new TeaPair("filterPattern", "{}")
        ));
        try {
            org.apache.rocketmq.eventbridge.sdk.models.UpdateEventRuleResponse res = _sdkClient.updateEventRule(request);
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

    public void testListEventRules() throws Exception {
        org.apache.rocketmq.eventbridge.sdk.models.ListEventRulesRequest request = org.apache.rocketmq.eventbridge.sdk.models.ListEventRulesRequest.build(TeaConverter.buildMap(
            new TeaPair("eventBusName", "newBus"),
            new TeaPair("maxResults", 2),
            new TeaPair("nextToken", "0")
        ));
        try {
            org.apache.rocketmq.eventbridge.sdk.models.ListEventRulesResponse res = _sdkClient.listEventRules(request);
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

    public void testEnableEventRule() throws Exception {
        org.apache.rocketmq.eventbridge.sdk.models.EnableEventRuleRequest request = org.apache.rocketmq.eventbridge.sdk.models.EnableEventRuleRequest.build(TeaConverter.buildMap(
            new TeaPair("eventBusName", "newBus"),
            new TeaPair("eventRuleName", "newRule")
        ));
        try {
            org.apache.rocketmq.eventbridge.sdk.models.EnableEventRuleResponse res = _sdkClient.enableEventRule(request);
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

    public void testDisableEventRule() throws Exception {
        org.apache.rocketmq.eventbridge.sdk.models.DisableEventRuleRequest request = org.apache.rocketmq.eventbridge.sdk.models.DisableEventRuleRequest.build(TeaConverter.buildMap(
            new TeaPair("eventBusName", "newBus"),
            new TeaPair("eventRuleName", "newRule")
        ));
        try {
            org.apache.rocketmq.eventbridge.sdk.models.DisableEventRuleResponse res = _sdkClient.disableEventRule(request);
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
