# Python版本sdk

> 由于阿里云已经不再支持 python2，所以这里 python 统一指代 python3 

## sdk 使用
/sdk/generated/python 即为已经生成好的 sdk 源码和项目依赖。使用样例在 /sdk/demo/\*/generated/python 下。

每个 api 都有单独的测试函数，实际使用时在 main 函数中调用即可。除 EventData 外的各 Controller 默认的测试接口均为 list 接口（如 EventBusController 的 ListEventBuses）。如需测试其他接口，在 main 函数中调用对应的测试函数即可。

下面以 ListEventBuses 接口为例说明如何使用 sdk 和 demo。

使用条件：
- 安装 python3

### 安装 sdk 

在 /sdk/generated/python 目录下运行 `python3 setup.py install`，即可将 sdk 作为库安装到本地仓库。

### 编译运行

可通过在 /sdk/demo/EventBus/generated/python 目录下执行 `python3 demo.py` 执行测试代码。

成功在本地部署 RocketMQ（nameServer + broker） 和 Eventbridge 后，运行测试代码即可（EventBridge 监听端口需为默认的 7001）。返回体的 body 会自动输出到命令行。

以 ListEventBuses API 为例：

```js
[LOG] {"eventBuses":[{"description":"A demo bus.","eventBusName":"demo-bus"},{"eventBusName":"newBus"}],"requestId":"4484bc24-2519-42fa-92b7-908ffcb2b22b","total":2,"maxResults":2}
[LOG] test end!
```

## sdk 生成

如果重新从 darabonba 生成 python 版本的 sdk 和 demo，需要先安装以下依赖：

生成条件：
- darabonba 安装完成
- python 安装完成

生成指令(在`/sdk`目录下运行)：
```
dara install
dara codegen python generated/python
```
dara codegen 运行完后 /sdk/generated/python 下会生成源代码和 setup.py

### 生成测试代码

所有测试代码的 dara 版本均在 /sdk/demo/*/ 下的 demo.dara 中，每个 api 都有单独的测试函数，实际使用时在 main 函数中调用即可。

下面以测试 ListEventBuses 接口为例生成 python 测试代码

进入 /sdk/demo/EventBus/ 下
```
dara install
dara codegen python generated/python
```

dara codegen 运行完后 /sdk/demo/EventBus/generated/python 下会生成源代码和 setup.py

### 添加 main 函数
由于不同语言 main 函数格式不同，需要手动添加 main 函数来执行测试函数。仍以 ListEventBuses 为例，在 /sdk/demo/EventBus/generated/python/rocketmq_eventbridge_demo/demo.py 中追加写入如下代码：

```py3
demo = Demo()
demo.test_list_event_buses()
```

同时，需要将文件内的 Demo 类的 Init 函数修改如下：
```py3
    def __init__(self):
        self._endpoint = '127.0.0.1:7001'
        config = open_api_models.Config(
            endpoint=self._endpoint
        )
        self._sdk_client = SDKClientClient(config)
```

### 运行

参考 sdk 使用的步骤即可。