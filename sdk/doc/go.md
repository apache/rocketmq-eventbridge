# 生成Go版本sdk

生成条件：
- darabonba 安装完成
- go 1.19 以上 安装完成

生成指令(在`/sdk`目录下运行)：
```
dara install
dara codegen go go
```
dara codegen 运行完后 /sdk/go 下会生成 /client 目录和 go.mod。


## 生成测试代码

所有测试代码的 dara 版本均在 /sdk/demo/EventBus 下的 demo.dara 中，每个 api 都有单独的测试函数，实际使用时在 main 函数中调用即可。

下面以 ListEventBuses 接口为例生成 go 测试代码

进入 /sdk/demo/EventBus 下
```
dara install
dara codegen go go
```

生成完毕后可在 /sdk/demo/EventBus/go/client 下看到 client.go，通过编辑器打开改文件并修改
`SdkClient sdkclient.Client` 为 `SdkClient *sdkclient.Client`

## 添加 sdk 依赖
由于 sdk 未发布到线上，需要在 go.mod 中修改为本地引用。在 /sdk/demo/EventBus/go/go.mod 末尾添加如下部分：
```
replace github.com/org-apache-rocketmq/eventbridge-sdk v0.0.0 => ../../../go/
```
修改完毕后，在 mod 文件路径下执行 go mod tidy 即可。

## 添加 main 函数
由于不同语言 main 函数格式不同，需要手动添加 main 函数来执行测试函数。仍以 ListEventBuses 为例，
在 /sdk/demo/EventBus/go/ 添加 main.go，并在其中写入如下代码：

```go
package main

import (
	"client/client"
)

func main() {
	demo := new(client.DemoClient)
	demo.Init()
	demo.TestListEventBuses()
}
```

## 测试效果

成功在本地部署 RocketMQ（nameServer + broker） 和 Eventbridge 后，运行测试代码即可（EventBridge 监听端口需为默认的 7001）。返回体的 body 会自动输出到命令行。

以 ListEventBuses API 为例：

```js
[LOG] {"eventBuses":[{"description":"A demo bus.","eventBusName":"demo-bus"},{"eventBusName":"newBus"}],"requestId":"4484bc24-2519-42fa-92b7-908ffcb2b22b","total":2,"maxResults":2}
[LOG] test end!
```

