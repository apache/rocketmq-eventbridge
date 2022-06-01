
## Apache RocketMQ EventBridge
RocketMQ EventBridge is a subproject of rocketmq to make it easier to build event-driven applications. In addition, rocketmq-eventbridge can route events between many services and applications based on the standard CloudEvents 1.0 specification. Users can use rocketmq-eventbridge to build loosely coupled and distributed event-driven architectures.

## Architecture
Events are sent to the event bus in two ways: 1) Push events through the SDK or Webhook actively; 2) Pulled events by eventbridge passively. Events obtained in both ways will be stored on the event bus. EventBus is the core concept in EventBridge, which allows you to subscribe to the events, filter the events, and push to the specified target by creating the event rule. The event on the event bus is stored by rocketmq. Through rocketmq-connect, we can pull the event from the register source to the event bus, or push the events from the event bus to the registered target.

- `application`  应用服务模块, 定义Application Service
- `adapter` 适配层
    - `persistence` 持久化相关, 一般存放Repository的实现(包含DO对象)
    - `api` 暴露给外部的api接口提供者
    - `rpc` 添加自己反转依赖的SPI, 以及SPI的实现适配
- `domain` 领域设计的核心模块
    - 每个聚合通过package隔离，定义于`model`package下
    - org.apache.rocketmq.eventbridge.domain.service` 存放当前子域下的所有领域服务
- `start` 启动入口(多个子域被打包在同一个应用jar包中时, start模块会被排除)


## Demo
#### Dependencies
* rocketmq-connect
  
* Mysql 

#### 

* Create EventBus
```
http://127.0.0.1:7001/bus/createEventBus
```
```json
{
"eventBusName":"demo",
"description":"a demo bus."
}
```


* Create EventSource
```
http://127.0.0.1:7001/source/createEventSource
```
```json
{
"eventBusName":"demo",
"eventSourceName":"demo-source",
"description":"a demo bus."
}
```


* Create EventRule
```
http://127.0.0.1:7001/rule/createRule
```
```json
{
  "eventBusName":"demo",
  "eventRuleName":"demo",
  "description":"test",
  "filterPattern":"{}"
}
```

* Create Target

This is a sample with DingTalk target.
```
http://127.0.0.1:7001/target/createEventTargets
```
```json
{
    "eventBusName":"demo",
    "eventRuleName":"demo",
    "eventTargetRunners":[
        {
            "eventTargetName":"demo",
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
```
URL: http://127.0.0.1:7001/putEvents
Header: Content-Type:"application/cloudevents+json; charset=UTF-8"
```
```json
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
    "aliyuneventbusname":"demo"
}
```