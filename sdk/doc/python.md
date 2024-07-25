# 生成Python版本sdk

由于阿里云已经不再支持 python2，所以这里 python 统一指代 python3 

生成条件：
- darabonba 安装完成
- python 安装完成

生成指令(在`/sdk`目录下运行)：
```
dara install
dara codegen python python
```
dara codegen 运行完后 /sdk/python 下会生成源代码和 setup.py

在 /sdk/python 目录下运行 python3 setup.py install，即可将 sdk 作为库安装到本地仓库。


## 生成测试代码

所有测试代码的 dara 版本均在 /sdk/demo/*/ 下的 demo.dara 中，每个 api 都有单独的测试函数，实际使用时在 main 函数中调用即可。

下面以测试 ListEventBuses 接口为例生成 python 测试代码

进入 /sdk/demo/EventBus/ 下
```
dara install
dara codegen python python
```

dara codegen 运行完后 /sdk/demo/EventBus/python 下会生成源代码和 setup.py

## 添加 main 函数
由于不同语言 main 函数格式不同，需要手动添加 main 函数来执行测试函数。仍以 ListEventBuses 为例，在 /sdk/demo/EventBus/python/rocketmq_eventbridge_demo/demo.py 中追加写入如下代码：

```python
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

此时即可通过 python3 demo.py 执行测试代码。

## 测试效果

成功在本地部署 RocketMQ（nameServer + broker） 和 Eventbridge 后，运行测试代码即可（EventBridge 监听端口需为默认的 7001）。返回体的 body 会自动输出到命令行。

以 ListEventBuses API 为例：

```js
[LOG] {"eventBuses":[{"description":"A demo bus.","eventBusName":"demo-bus"},{"eventBusName":"newBus"}],"requestId":"4484bc24-2519-42fa-92b7-908ffcb2b22b","total":2,"maxResults":2}
[LOG] test end!
```

