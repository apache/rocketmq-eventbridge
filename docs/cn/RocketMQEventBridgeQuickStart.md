## Apache RocketMQ EventBridge 快速开始

RocketMQ EventBridge 需要一个消息服务来存储事件，另外需要一个Runtime来订阅并推送事件。这里我们选择 Apache RocketMQ 作为我们的消息服务，选择 Apache RocketMQ Connect 作为我们的Runtime来订阅和推送事件。当然，您也可以选择其他消息服务代替，EventBridge并不对此做限制。未来EventBridge也计划基于OpenMessaging Connect API 实现自己的Runtime，以便更好的提供事件驱动服务。


系统要求:
* 64位操作系统，推荐 Linux/Unix/macOS
* 64位 JDK 1.8+

### 部署Apache RocketMQ EventBridge

* 获取 EventBridge

你可以从[这里](https://www.apache.org/dyn/closer.cgi?path=rocketmq/rocketmq-eventbridge/1.0.0/rocketmq-eventbridge-1.0.0-bin-release.zip)下载EventBridge的二进制包：rocketmq-eventbridge-xxx-bin-release.zip,下载完毕后进行解压缩，你会得到一个如下目录：
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


* 配置

运行前，我们需要配置EventBridge的运行环境，修改config/application.properties中的RocketMQ nameserver连接地址。RocketMQ部署参考: [Apache RocketMQ Quick Start](https://rocketmq.apache.org/docs/4.x/introduction/02quickstart)

```properties
rocketmq.namesrvAddr=localhost:9876
```

* 启动 EventBridge

注意：下载的EventBridge二进制包可能没有权限执行，可以通过chmod提前授权。

```shell
sh bin/eventbridge.sh start 
```
log默认目录为～/rocketmq-eventbridge/rocketmq-eventbridge.log,可以修改config/application.properties中的log.path和app.name进行修改，通过日志来观察服务是否正常启动。

### 测试Apache RocketMQ EventBridge

当服务启动后，系统默认会初始化一个名称为“demo-bus”的EventBus，并在该Bus下默认创建一个规则，用于订阅该Bus上的所有事件，并推送写入到一个本地文件。所以我们可以通过如下方式来进行测试验证：
* 发送事件
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

* 查看事件是否成功写入Rule订阅的目标端

默认创建的Rule会将数据写入本地文件“～/demo”，可以通过查看文件内容来判断发送的事件，是否成功投递到目标端。

```agsl
root % tail -f ～/demo
A test event.
A test event.
A test event.
```