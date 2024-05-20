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

#### Deploy Apache RocketMQ

Apache RocketMQ is a great messaging service,and we choose it as our message service.You can deploy the apache rocketmq
according to the manual: [RocketMQ Quick Start](https://rocketmq.apache.org/docs/quick-start/)

### Deploy Apache RocketMQ EventBridge

* Download EventBridge Binary Package

You can download it from [here](https://www.apache.org/dyn/closer.cgi?path=rocketmq/rocketmq-eventbridge/1.1.0/rocketmq-eventbridge-1.1.0-bin-release.zip) EventBridge binary package: rocketmq-eventbridge-xxx-bin-release.zip. After downloading, unzip it. You will get a directory as follows:
```text
/rocketmq-eventbridge-xxx-bin-release/
|——bin
|   |——runserver.sh
|   |——eventbridge.sh
|——config
|   |——application.properties
|——plugin
|   |——eventbridge-connect-file-with-dependencies.jar
|   |——connect-filter-transform-with-dependencies.jar
|   |——connect-eventbridge-transform-with-dependencies.jar
|——rocketmq-eventbridge.jar
```

* Config

  Before running, we need to configure the running environment of EventBridge and modify the RocketMQ nameserver connection address in config/application.properties.

```properties
rocketmq.namesrvAddr=localhost:9876
```

* Start EventBridge

Note: The downloaded EventBridge binary package may not have permission to execute. You can authorize it in advance through chmod.

```shell
sh bin/eventbridge.sh start 
```
The default log directory is ~/rocketmq-eventbridge/rocketmq-eventbridge.log. You can modify log.path and app.name in config/application.properties to observe whether the service starts normally through the log.

## Demo

####

* Put Events to EventBus

  When the service is started, the system will initialize an EventBus named "demo-bus" by default, and create a rule under the Bus by default to subscribe to all events on the Bus and push and write them to a local file. So we can test and verify in the following ways:
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

* Check whether the event is successfully written to the target end of the Rule subscription

  The Rule created by default will write data to the local file "~/demo". You can judge whether the event sent is successfully delivered to the target by viewing the file content.

```agsl
root % tail -f ～/demo
A test event.
A test event.
A test event.
```