
## Apache RocketMQ EventBridge
RocketMQ EventBridge is a subproject of rocketmq to make it easier to build event-driven applications. In addition, rocketmq-eventbridge can route events between many services and applications based on the standard CloudEvents 1.0 specification. Users can use rocketmq-eventbridge to build loosely coupled and distributed event-driven architectures.

## Architecture
Events are sent to the event bus in two ways: 1) Push events through the SDK or Webhook actively; 2) Pulled events by eventbridge passively. Events obtained in both ways will be stored on the event bus. EventBus is the core concept in EventBridge, which allows you to subscribe to the events, filter the events, and push to the specified target by creating the event rule. The event on the event bus is stored by rocketmq. Through rocketmq-connect, we can pull the event from the register source to the event bus, or push the events from the event bus to the registered target.

- `adapter` Adapt to different operating environments
    - `persistence` Implement the repository API in the domain layer and persist the model data.
    - `api` The open API provided by EventBridge.
    - `rpc` Implement the rpc API in the domain layer to adapter the run environment.
- `common` The common code of all modules.
- `domain` The core code of EventBridge.
    - model:The core properties and behaviors of model on EventBridge.
    - service: The domain services which across multiple domains.
- `start` 

## Quick Start
RocketMQ EventBridge rely on a message service to store the event, and needs one connect service to collect or forward events.Here, we choose the Apache RocketMQ as our message service， and choose the Apache RocketMQ Connect as our connect service.Of course, you can also choose other alternative services. Eventbridge do not limit it. You only need to provide the relevant adapter API implementation.
#### Apache RocketMQ
Apache RocketMQ is a great messaging service,and we choose it as our message service.You can deploy the apache rocketmq according to the manual: [RocketMQ Quick Start](https://rocketmq.apache.org/docs/quick-start/)

#### Apache RocketMQ Connect
Apache RocketMQ Connect can connect the external upstream and downstream services,and You can deploy it according to the manual: [RocketMQ Connect Quick Start](https://github.com/apache/rocketmq-connect)
. Before deploy the Apache RocketMQ Connect, you should download the plugins below and put it to the "pluginPaths" which defined on rocketmq-connect.

* [rocketmq-connect-eventbridge-0.0.1-SNAPSHOT-jar-with-dependencies.jar](https://cn-hangzhou-eventbridge.oss-cn-hangzhou.aliyuncs.com/rocketmq-connect-eventbridge-0.0.1-SNAPSHOT-jar-with-dependencies.jar)
* [rocketmq-connect-dingtalk-1.0-SNAPSHOT-jar-with-dependencies.jar](https://cn-hangzhou-eventbridge.oss-cn-hangzhou.aliyuncs.com/rocketmq-connect-dingtalk-1.0-SNAPSHOT-jar-with-dependencies.jar)
* [connect-cloudevent-transform-1.0.0-SNAPSHOT-jar-with-dependencies.jar](https://cn-hangzhou-eventbridge.oss-cn-hangzhou.aliyuncs.com/connect-cloudevent-transform-1.0.0-SNAPSHOT-jar-with-dependencies.jar)
* [connect-filter-transform-1.0.0-SNAPSHOT-jar-with-dependencies.jar](https://cn-hangzhou-eventbridge.oss-cn-hangzhou.aliyuncs.com/connect-filter-transform-1.0.0-SNAPSHOT-jar-with-dependencies.jar)
* [connect-eventbridge-transform-1.0.0-SNAPSHOT-jar-with-dependencies.jar](https://cn-hangzhou-eventbridge.oss-cn-hangzhou.aliyuncs.com/connect-eventbridge-transform-1.0.0-SNAPSHOT-jar-with-dependencies.jar)

#### Apache RocketMQ EventBridge

Before run the project,configure the following properties which :
```
# The config of mysql databse.
spring.datasource.url=jdbc:mysql://xxxx:3306/xxxx?characterEncoding=utf8
spring.datasource.username=xxx
spring.datasource.password=xxxx

# The endpoint of rocketmq nameserver.
rocketmq.namesrvAddr=xxxxx:9876

# The cluster name of rocketmq.
rocketmq.cluster.name=DefaultCluster

# The endpoint of rocketmq-connect.
rocketmq.connect.endpoint=xxxxxx:8082

```
After that ,you should register the targets which you want to create, into the 'event_target_class' table.

| key                                             | description | 
| ----------------------------------------------- | -------- | 
| name | the target class name     |  
|api_params  | the required params when create target.     |  
|target_transform   |the default transform with target data.     |  
|required_params |the required params of connect.  |


* register the "acs.eventbridge" target.

api_params:
```json
{
    "RegionId":{
        "type":"String",
        "desc":"the region of aliyun eventbridge.",
        "required":true
    },
    "AliyunEventBus":{
        "type":"String",
        "desc":"the bus of aliyun eventbridge.",
        "required":true
    }
}
```

target_transform:
```json
{
  "data":"{\"form\":\"JSONPATH\",\"value\":\"$.data\"}",
  "id":"{\"form\":\"JSONPATH\",\"value\":\"$.id\"}",
  "type":"{\"form\":\"JSONPATH\",\"value\":\"$.type\"}",
  "specversion":"{\"form\":\"JSONPATH\",\"value\":\"$. specversion\"}",
  "subject":"{\"form\":\"JSONPATH\",\"value\":\"$.subject\"}",
  "source":"{\"form\":\"JSONPATH\",\"value\":\"$.source\"}"
}
```


required_params:
```json
{
  "aliyuneventbusname":"${AliyunEventBus}",
  "accessKeyId":"the accessKeyId of aliyun accountId",
  "accessKeySecret":"the accessKeySecret of aliyun accountId",
  "accountEndpoint":"xxxx.eventbridge.${RegionId}.aliyuncs.com",
  "class":"org.apache.rocketmq.connect.eventbridge.sink.EventBridgeSinkConnector"
}
```

* register the "acs.dingtalk" target.


api_params:
```json
{
  "WebHook":{
    "type":"String",
    "desc":"the webhook endpoint of dingtalk.",
    "required":true
  },
  "SecretKey":{
    "type":"String",
    "desc":"the secret key of dingtalk webhookd.",
    "required":true
  },
  "Body":{
    "type":"boolean",
    "desc":"the content which push to dingtalk."
  }
}
```

target_transform:
```json
{
  "data":"${Body}"
}
```


target_transform:
```json
{
  "webHook":"${WebHook}",
  "secretKey":"${SecretKey}",
  "class":"org.apache.rocketmq.connect.dingtalk.sink.DingTalkSinkConnector"
}
```


## Demo
####
* Create EventBus

```text
POST /bus/createEventBus HTTP/1.1
Host: demo.eventbridge.com
Content-Type: application/json; charset=utf-8
{
"eventBusName":"demo-bus",
"description":"a demo bus."
}
```


* Create EventSource

```text
POST /source/createEventSource HTTP/1.1
Host: demo.eventbridge.com
Content-Type: application/json; charset=utf-8
{
"eventBusName":"demo-bus",
"eventSourceName":"demo-source",
"description":"A demo source."
}
```


* Create EventRule
```text
POST /rule/createEventRule HTTP/1.1
Host: demo.eventbridge.com
Content-Type: application/json; charset=utf-8
{
  "eventBusName":"demo-bus",
  "eventRuleName":"demo-rule",
  "description":"A demo rule.",
  "filterPattern":"{}"
}
```

* Create Target

This is a sample with EventBridge target:
```text
POST /target/createEventTargets HTTP/1.1
Host: demo.eventbridge.com
Content-Type: application/json; charset=utf-8
{
"eventBusName":"demo-bus",
"eventRuleName":"demo-rule",
"eventTargets":[
        {
        "eventTargetName":"eventbridge-target",
        "className":"acs.eventbridge",
            "config":{
            "RegionId":"cn-hangzhou",
            "AliyunEventBus":"rocketmq-eventbridge"
            }
        }
    ]
}
```

This is a sample with DingTalk target:
```text
POST /target/createEventTargets HTTP/1.1
Host: demo.eventbridge.com
Content-Type: application/json; charset=utf-8
{
    "eventBusName":"demo-bus",
    "eventRuleName":"demo-rule",
    "eventTargets":[
        {
            "eventTargetName":"dingtalk-target",
            "className":"acs.dingtalk",
            "config":{
            "WebHook":"https://oapi.dingtalk.com/robot/send?access_token=b43a54b702314415c2acdae97eda1e092528b7a9dddb31510a5b4430be2ef867",
            "SecretKey":"SEC53483bf496b8f9e0b4ab0ab669d422208e6ccfaedfd5120ea6b8426b9ecd47aa",
            "Body":"{\"template\":\"{\\\"text\\\":{\\\"content\\\":\\\"${content}\\\"},\\\"msgtype\\\":\\\"text\\\"}\",\"form\":\"TEMPLATE\",\"value\":\"{\\\"content\\\":\\\"$.data.body\\\"}\"}"
            }
        }
    ]
}
```

* Put Events to EventBus

```textgit subtree push --prefix=rocketmq-eventbridge  
POST /putEvents HTTP/1.1
Host: demo.eventbridge.com
Content-Type:"application/cloudevents+json; charset=UTF-8"
{
  "specversion" : "1.0",
  "type" : "com.github.pull_request.opened",
  "source" : "https://github.com/cloudevents/spec/pull",
  "subject" : "123",
  "id" : "A234-1234-1234",
  "time" : "2018-04-05T17:31:00Z",
  "datacontenttype" : "application/json",
  "data" : {
    "body":"demo"
  },
  "aliyuneventbusname":"demo-bus"
}
```
* Use HttpSource to put events

EventBridge HttpSource allows you to put events to eventbus in the form of webhook.

Here is an example explaining how to put events using EventBridge HttpSource.

1. Create an EventBridge HttpSource

    - eventSourceName: Name of EventSource
    - eventBusName: Name of EventBus
    - description: Description
    - className: HttpEvent. This parameter is a fixed value and cannot be modified.
    - config: HttpSource Config
    - Type: Request type. Available values are 'HTTP', 'HTTPS' and 'HTTP&HTTPS'.
    - Method: Allowed HTTP request methods. The request will be filtered if the http request method type for accessing the webhook does not meet the configuration.
    - SecurityConfig: Security configuration type. Available values are 'none', 'ip' and 'referer'.
    - Ip: IP security configuration. Http requests whose source ip is not in the configured network segment will be filtered if the security configuration is selected as 'ip'.
    - Referer: Referer security configuration. HTTP requests whose referer is not in this configuration will be filtered if the security configuration is selected as 'referer'.

A webhook will be generated after the creation of HttpSource.
```
http://127.0.0.1:7001/source/createEventSource
```
```json
{
  "eventSourceName": "httpEventSourceDemo",
  "eventBusName": "demo",
  "description": "http source demo",
  "className": "HttpEvent",
  "config": {
    "Type": "HTTP&HTTPS",
    "Method": ["GET", "POST"],
    "SecurityConfig": "ip",
    "Ip": ["10.0.0.0/8"],
    "Referer":[]
  }
}
```
2. Put event to EventBus

Http request to access this webhook will be converted into a CloudEvent and delivered to eventbus.

```
curl -d '{"username": "testUser", "testData": "testData"}' -H 'Content-Type: application/json' -H 'Accept-Language: en-US' http://127.0.0.1:7001/webhook/putEvents?token=43146d108b224eb2adc581aedd28f272007320d14b9d
```

generated CloudEvent demo
```json
{
  "datacontenttype": "application/json",
  "data": {
    "body": {
      "username": "testUser",
      "testData": "testData"
    },
    "headers": {
      "Accept": "*/*",
      "User-Agent": "curl/7.64.1",
      "Host": "127.0.0.1:7001",
      "Accept-Language": "en-US",
      "Content-Length": "48",
      "Content-Type": "application/json"
    },
    "httpMethod": "POST",
    "path": "/webhook/putEvents",
    "queryString": {}
  },
  "subject": "DemoBus/httpEventSourceDemo",
  "source": "httpEventSourceDemo",
  "type": "eventbridge:Events:HTTPEvent",
  "specversion": "1.0",
  "id": "75bc099b-130a-45a8-82e1-3f9a7f0d10f3",
  "time": "2022-05-12T17:20:30.264+08:00"
}
```

