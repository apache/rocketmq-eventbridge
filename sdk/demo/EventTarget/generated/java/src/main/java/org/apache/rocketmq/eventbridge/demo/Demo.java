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
        java.util.Map<String, Object> config_ = TeaConverter.buildMap(
            new TeaPair("fileName", "~/Target"),
            new TeaPair("line", "{    \"form\":\"JSONPATH\",    \"value\":\"$.data\"}")
        );
        java.util.Map<String, Object> config2_ = TeaConverter.buildMap(
            new TeaPair("fileName", "~/Target222"),
            new TeaPair("line", "{    \"form\":\"JSONPATH\",    \"value\":\"$.data\"}")
        );
        org.apache.rocketmq.eventbridge.sdk.models.CreateEventTargetsRequest request = org.apache.rocketmq.eventbridge.sdk.models.CreateEventTargetsRequest.build(TeaConverter.buildMap(
            new TeaPair("eventBusName", "newBus"),
            new TeaPair("eventRuleName", "newRule"),
            new TeaPair("eventTargets", java.util.Arrays.asList(
                org.apache.rocketmq.eventbridge.sdk.models.EventTarget.build(TeaConverter.buildMap(
                    new TeaPair("eventTargetName", "newTarget"),
                    new TeaPair("className", "file"),
                    new TeaPair("config", config_),
                    new TeaPair("runOptions", org.apache.rocketmq.eventbridge.sdk.models.EventTarget.EventTargetRunOptions.build(TeaConverter.buildMap(
                        new TeaPair("errorsTolerance", ""),
                        new TeaPair("retryStrategy", org.apache.rocketmq.eventbridge.sdk.models.EventTarget.EventTargetRunOptionsRetryStrategy.build(TeaConverter.buildMap(
                            new TeaPair("pushRetryStrategy", ""),
                            new TeaPair("maximumEventAgeInSeconds", 100),
                            new TeaPair("maximumRetryAttempts", 100)
                        ))),
                        new TeaPair("deadLetterQueue", org.apache.rocketmq.eventbridge.sdk.models.EventTarget.EventTargetRunOptionsDeadLetterQueue.build(TeaConverter.buildMap(
                            new TeaPair("type", "")
                        )))
                    )))
                )),
                org.apache.rocketmq.eventbridge.sdk.models.EventTarget.build(TeaConverter.buildMap(
                    new TeaPair("eventTargetName", "newTarget222"),
                    new TeaPair("className", "file"),
                    new TeaPair("config", config2_),
                    new TeaPair("runOptions", org.apache.rocketmq.eventbridge.sdk.models.EventTarget.EventTargetRunOptions.build(TeaConverter.buildMap(
                        new TeaPair("errorsTolerance", ""),
                        new TeaPair("retryStrategy", org.apache.rocketmq.eventbridge.sdk.models.EventTarget.EventTargetRunOptionsRetryStrategy.build(TeaConverter.buildMap(
                            new TeaPair("pushRetryStrategy", ""),
                            new TeaPair("maximumEventAgeInSeconds", 100),
                            new TeaPair("maximumRetryAttempts", 100)
                        ))),
                        new TeaPair("deadLetterQueue", org.apache.rocketmq.eventbridge.sdk.models.EventTarget.EventTargetRunOptionsDeadLetterQueue.build(TeaConverter.buildMap(
                            new TeaPair("type", "")
                        )))
                    )))
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
        java.util.Map<String, Object> config_ = TeaConverter.buildMap(
            new TeaPair("fileName", "~/Target"),
            new TeaPair("line", "{    \"form\":\"JSONPATH\",    \"value\":\"$.data\"}")
        );
        java.util.Map<String, Object> config2_ = TeaConverter.buildMap(
            new TeaPair("fileName", "~/Target222"),
            new TeaPair("line", "{    \"form\":\"JSONPATH\",    \"value\":\"$.data\"}")
        );
        org.apache.rocketmq.eventbridge.sdk.models.UpdateEventTargetsRequest request = org.apache.rocketmq.eventbridge.sdk.models.UpdateEventTargetsRequest.build(TeaConverter.buildMap(
            new TeaPair("eventBusName", "newBus"),
            new TeaPair("eventRuleName", "newRule"),
            new TeaPair("eventTargets", java.util.Arrays.asList(
                org.apache.rocketmq.eventbridge.sdk.models.EventTarget.build(TeaConverter.buildMap(
                    new TeaPair("eventTargetName", "newTarget"),
                    new TeaPair("className", "file"),
                    new TeaPair("config", config_)
                )),
                org.apache.rocketmq.eventbridge.sdk.models.EventTarget.build(TeaConverter.buildMap(
                    new TeaPair("eventTargetName", "newTarget222"),
                    new TeaPair("className", "file"),
                    new TeaPair("config", config2_)
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
