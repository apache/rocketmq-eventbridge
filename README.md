## Apache RocketMQ EventBridge

RocketMQ EventBridge is a subproject of rocketmq to make it easier to build event-driven applications. In addition,
rocketmq-eventbridge can route events between many services and applications based on the standard CloudEvents 1.0
specification. Users can use rocketmq-eventbridge to build loosely coupled and distributed event-driven architectures.

## Architecture

Events are sent to the event bus in two ways: 1) Push events through the SDK or Webhook actively; 2) Pulled events by
eventbridge passively. Events obtained in both ways will be stored on the event bus. EventBus is the core concept in
EventBridge, which allows you to subscribe to the events, filter the events, and push to the specified target by
creating the event rule. The event on the event bus is stored by rocketmq. Through rocketmq-connect, we can pull the
event from the register source to the event bus, or push the events from the event bus to the registered target.

<img width="919" alt="image" src="https://user-images.githubusercontent.com/8605835/192938456-bc158f1c-ca4a-458c-9044-7c98cf048a5d.png">

The code architecture of EventBridge include 4 core modules:

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

RocketMQ EventBridge rely on a message service to store the event, and needs one connect service to collect or forward
events.Here, we choose the Apache RocketMQ as our message service， and choose the Apache RocketMQ Connect as our connect
service.Of course, you can also choose other alternative services. Eventbridge do not limit it. You only need to provide
the relevant adapter API implementation.

#### Apache RocketMQ

Apache RocketMQ is a great messaging service,and we choose it as our message service.You can deploy the apache rocketmq
according to the manual: [RocketMQ Quick Start](https://rocketmq.apache.org/docs/quick-start/)

#### Apache RocketMQ Connect

Apache RocketMQ Connect can connect the external upstream and downstream services,and You can deploy it according to the
manual: [RocketMQ Connect Quick Start](https://github.com/apache/rocketmq-connect)
. Before deploy the Apache RocketMQ Connect, you should download the plugins below and put it to the "pluginpath" which
defined on rocketmq-connect.

* [rocketmq-connect-eventbridge.jar](https://cn-hangzhou-eventbridge.oss-cn-hangzhou.aliyuncs.com/rocketmq-connect-eventbridge-0.0.1-SNAPSHOT-jar-with-dependencies.jar)
* [eventbridge-connect-file.jar](https://cn-hangzhou-eventbridge.oss-cn-hangzhou.aliyuncs.com/eventbridge-connect-file-1.0.0-SNAPSHOT-jar-with-dependencies.jar)
* [connect-cloudevent-transform.jar](https://cn-hangzhou-eventbridge.oss-cn-hangzhou.aliyuncs.com/connect-cloudevent-transform-1.0.0-SNAPSHOT-jar-with-dependencies.jar)
* [connect-filter-transform.jar](https://cn-hangzhou-eventbridge.oss-cn-hangzhou.aliyuncs.com/connect-filter-transform-1.0.0-SNAPSHOT-jar-with-dependencies.jar)
* [connect-eventbridge-transform.jar](https://cn-hangzhou-eventbridge.oss-cn-hangzhou.aliyuncs.com/connect-eventbridge-transform-1.0.0-SNAPSHOT-jar-with-dependencies.jar)

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
runtime.pluginpath=xxxx

```
Config the runtime.pluginpath to set the directory of plugin.

## Demo

####

* Put Events to EventBus
  The system creates a demo bus by default, and you can send events directly to the bus.
```text
curl  -X POST http://127.0.0.1:7001/putEvents  \
-H "Content-Type: application/json; charset=UTF-8"  \
-H "ce-specversion:1.0"  \
-H "ce-type:com.github.pull_request.opened"  \
-H "ce-source:https://github.com/cloudevents/spec/pull"  \
-H "ce-subject:demo"  \
-H "ce-id:1234-1234-1234"  \
-H "ce-datacontenttype:application/json"  \
-H "ce-time:2018-04-05T17:31:00Z"  \
-H "ce-eventbusname:demo-bus"  \
-d 'A test event.'
```

* Check if the local file received a write event

In addition, by default, the system will create a demo rule for you to subscribe and push to the file. You can check whether there are events received in the directory:～/demo
```agsl
root % tail -f ～/demo
A test event.
A test event.
A test event.
```

Why does the file output the data attribute of CloudEvent instead of other attributes?This is because the configuration in the demo rule is to output "$.data" in CloudEvent to the file line.
You can refer to this [document](docs/CreateFileTarget.md)  to configure and modify event targets.
