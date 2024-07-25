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
            demo.testListEventTargets();
            // demo.testCreateEventTargets();
            // demo.testListEventTargets();
            // demo.testUpdateEventTargets();
            // demo.testListEventTargets();
            // demo.testDeleteEventTargets();
            // demo.testListEventTargets();
        } catch (Exception e) {
            // TODO: handle exception
        }
    }

    /**
     * <b>description</b> :
     * <p>EventTarget Controller apis:
     * createEventTargets *
     * updateEventTargets *
     * deleteEventTargets *
     * listEventTargets   *</p>
     */
    public void testCreateEventTargets() throws Exception {
        org.apache.rocketmq.eventbridge.sdk.models.CreateEventTargetsRequest request = org.apache.rocketmq.eventbridge.sdk.models.CreateEventTargetsRequest.build(TeaConverter.buildMap(
            new TeaPair("eventBusName", "newBus"),
            new TeaPair("eventRuleName", "newRule"),
            new TeaPair("eventTargets", java.util.Arrays.asList(
                org.apache.rocketmq.eventbridge.sdk.models.EventTarget.build(TeaConverter.buildMap(
                    new TeaPair("eventTargetName", "newTarget"),
                    new TeaPair("className", "file"),
                    new TeaPair("config", TeaConverter.buildMap(
                        new TeaPair("fileName", "~/Target"),
                        new TeaPair("line", "{    \"form\":\"JSONPATH\",    \"value\":\"$.data\"}")
                    )),
                    new TeaPair("runOptions", TeaConverter.buildMap(
                        new TeaPair("errorsTolerance", ""),
                        new TeaPair("retryStrategy", TeaConverter.buildMap(
                            new TeaPair("pushRetryStrategy", ""),
                            new TeaPair("maximumEventAgeInSeconds", 100),
                            new TeaPair("maximumRetryAttempts", 100)
                        )),
                        new TeaPair("deadLetterQueue", TeaConverter.buildMap(
                            new TeaPair("type", ""),
                            new TeaPair("config", new java.util.HashMap<>())
                        ))
                    ))
                )),
                org.apache.rocketmq.eventbridge.sdk.models.EventTarget.build(TeaConverter.buildMap(
                    new TeaPair("eventTargetName", "newTarget222"),
                    new TeaPair("className", "file"),
                    new TeaPair("config", TeaConverter.buildMap(
                        new TeaPair("fileName", "~/Target222"),
                        new TeaPair("line", "{    \"form\":\"JSONPATH\",    \"value\":\"$.data\"}")
                    )),
                    new TeaPair("runOptions", TeaConverter.buildMap(
                        new TeaPair("errorsTolerance", ""),
                        new TeaPair("retryStrategy", TeaConverter.buildMap(
                            new TeaPair("pushRetryStrategy", ""),
                            new TeaPair("maximumEventAgeInSeconds", 100),
                            new TeaPair("maximumRetryAttempts", 100)
                        )),
                        new TeaPair("deadLetterQueue", TeaConverter.buildMap(
                            new TeaPair("type", ""),
                            new TeaPair("config", new java.util.HashMap<>())
                        ))
                    ))
                ))
            ))
        ));
        try {
            org.apache.rocketmq.eventbridge.sdk.models.CreateEventTargetsResponse res = _sdkClient.createEventTargets(request);
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

    public void testUpdateEventTargets() throws Exception {
        org.apache.rocketmq.eventbridge.sdk.models.UpdateEventTargetsRequest request = org.apache.rocketmq.eventbridge.sdk.models.UpdateEventTargetsRequest.build(TeaConverter.buildMap(
            new TeaPair("eventBusName", "newBus"),
            new TeaPair("eventRuleName", "newRule"),
            new TeaPair("eventTargets", java.util.Arrays.asList(
                org.apache.rocketmq.eventbridge.sdk.models.EventTarget.build(TeaConverter.buildMap(
                    new TeaPair("eventTargetName", "newTarget"),
                    new TeaPair("className", "file"),
                    new TeaPair("config", TeaConverter.buildMap(
                        new TeaPair("fileName", "~/newTarget"),
                        new TeaPair("line", "{    \"form\":\"JSONPATH\",    \"value\":\"$.data\"}")
                    ))
                )),
                org.apache.rocketmq.eventbridge.sdk.models.EventTarget.build(TeaConverter.buildMap(
                    new TeaPair("eventTargetName", "newTarget222"),
                    new TeaPair("className", "file"),
                    new TeaPair("config", TeaConverter.buildMap(
                        new TeaPair("fileName", "~/newTarget222"),
                        new TeaPair("line", "{    \"form\":\"JSONPATH\",    \"value\":\"$.data\"}")
                    ))
                ))
            ))
        ));
        try {
            org.apache.rocketmq.eventbridge.sdk.models.UpdateEventTargetsResponse res = _sdkClient.updateEventTargets(request);
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

    public void testDeleteEventTargets() throws Exception {
        org.apache.rocketmq.eventbridge.sdk.models.DeleteEventTargetsRequest request = org.apache.rocketmq.eventbridge.sdk.models.DeleteEventTargetsRequest.build(TeaConverter.buildMap(
            new TeaPair("eventBusName", "newBus"),
            new TeaPair("eventRuleName", "newRule"),
            new TeaPair("eventTargetNames", java.util.Arrays.asList(
                "newTarget",
                "newTarget222"
            ))
        ));
        try {
            org.apache.rocketmq.eventbridge.sdk.models.DeleteEventTargetsResponse res = _sdkClient.deleteEventTargets(request);
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

    public void testListEventTargets() throws Exception {
        org.apache.rocketmq.eventbridge.sdk.models.ListEventTargetsRequest request = org.apache.rocketmq.eventbridge.sdk.models.ListEventTargetsRequest.build(TeaConverter.buildMap(
            new TeaPair("eventBusName", "newBus"),
            new TeaPair("eventRuleName", "newRule")
        ));
        try {
            org.apache.rocketmq.eventbridge.sdk.models.ListEventTargetsResponse res = _sdkClient.listEventTargets(request);
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
