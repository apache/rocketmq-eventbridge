架构
事件网关将接收用户发送到 EventBridge 的事件，并将事件传递到内置存储 RocketMQ。
当用户将规则配置为订阅事件总线上的事件时，推送运行时将侦听与规则关联的总线，一旦总线上收到事件，它将事件推送到规则指定的目标。
如果在规则上配置了筛选和转换，则事件将在推送前进行预处理。

推送运行时如何侦听事件总线
这里有两种方法：

方案一-独立模式：每个规则单独创建一个MQ订阅，监控BUS上是否存在与规则关联的事件;在此模式下，每个规则订阅都是一个独立的任务。

方案 2 - 共享模式：推送运行时计时器中的统一组件监控与分配给当前运行时的所有规则关联的 BUS;如果监控总线上发生事件，则会将事件分发到指定的规则进行过滤和转换。最后，它通过接收器连接器被推到目标侧;

由于事件规则与流式处理方案不同，因此大多数情况下，规则监视的总线上可能没有事件;为了降低监控 MQ 的成本，推荐方案 2：推送运行时中的统一组件监控分配给当前运行时计时器的所有规则并共享资源。

推送运行时管理器
问题分析：

如果每个正在运行的推送运行时需要加载所有规则，当规则越来越多时，推送运行时无法水平扩展，将成为瓶颈。

方案：
推送运行时集群只需要加载分配给它的规则，并根据规则的定义监听指定的 BUS。一旦总线上发生事件，就会根据过滤规则过滤事件，推送到目标终端目标。
推送运行时管理器的职责：

所有推送运行时生命周期都由推送运行时管理器管理。
如何将规则分配给推送运行时由推送运行时管理器管理。

接口设计/更改
方法签名更改
方法行为更改 
CLI 命令更改
日志格式或内容更改 
问题分析：
EventBridge 是一个开放的架构。事件网关接收的事件可能不会存储在 RocketMQ 中。因此，在设计推送运行时，需要支持对不同 MQ 的监控。因此，我们需要在这里定义一组标准 SPI，并实现不同的 MQ 监控组件;
推送运行时侦听总线上的事件后，会对事件进行过滤和转换，最后将事件推送到规则中指定的目的地。在推送之前，事件将被过滤和转换。这些过程需要定义SPI以供以后扩展，并促进生态合作伙伴的共建。
方案： 目前，OpenMessaging Connect API 已经定义了完整的 SPI，并具有一定的生态。因此，我们考虑重用OpenMessaging Connect API作为我们的标准SPI。

兼容性、弃用和迁移计划
此提案不需要修改 API 规范。这只会向事件桥添加新的运行时组件。

实施大纲
我们将此提案分为几个任务：

任务 1：推送运行时实现

监视当前运行时需要处理的事件规则，以及与事件规则关联的总线。
通过长池监控 MQ 组件。当检测到新事件时，它会立即将事件写入本地缓冲区，并且监视组件将继续监视后续事件;（事件推送不会阻塞监听线程）
轮询组件从缓冲区获取事件，并根据上下文信息 （规则） 筛选和转换事件，然后将其发送到接收器连接器。
Put 可以是异步操作或同步操作。
运行时每次提交站点之前，都会调用 PreCommit 获取当前事件成功提交的偏移量，然后通过 MQ 监控组件提交站点。
图像

任务 2：推送运行时管理器实现

推送运行时管理器如何将规则分配给推送运行时
通过现有的event_target_runner表将事件规则分配给指定的推送运行时。

添加event_runtimer表以管理所有运行时节点

推送管理器根据指标信息（例如每个运行时计时器的负载（例如 CPU、内存、推送延迟时间和线程池的剩余大小）将运行时分配给规则目标。在早期阶段，可以根据分配给每个运行时的规则目标数量均匀分布;

推送运行时计时器如何获取分配给它的规则目标
可以提前创建运行时，然后在event_runtimer表中进行配置。如果底层基础设施支持自动创建容器的功能，您可以通过 PushManager 调用基础设施服务，动态创建运行时，并在event_runtimer表中自动注册它们。

所有创建的运行时都有一个系统变量：runtimer-name，用于指定当前运行时的信息。当运行计时器启动时，它可以根据运行时程序名称获取分配给它的规则目标。

此外，规则目标信息将在运行过程中更改。此时，PushManger 需要将最新更改的规则-目标信息通知相应的运行计时器。收到通知后，运行计时器将重新加载最新的规则目标。

在开发和设计推送运行时时，请依赖Openmessaging Connect的API。