# Go版本sdk

## sdk 使用

/sdk/generated/go 即为已经生成好的 sdk 源码和项目依赖。使用样例在 /sdk/demo/\*/generated/go 下。

每个 api 都有单独的测试函数，实际使用时在 main 函数中调用即可。除 EventData 外的各 Controller 默认的测试接口均为 list 接口（如 EventBusController 的 ListEventBuses）。如需测试其他接口，在 main 函数中调用对应的测试函数即可。

下面以 ListEventBuses 接口为例说明如何使用 sdk 和 demo。

### 依赖安装

在 /sdk/demo/EventBus/generated/go/ 路径下执行 `go mod tidy` 即可。

### 测试效果

在 /sdk/demo/EventBus/generated/go/ 路径下执行 `go run main.go` 即可。

成功在本地部署 RocketMQ（nameServer + broker） 和 Eventbridge 后，运行测试代码即可（EventBridge 监听端口需为默认的 7001）。返回体的 body 会自动输出到命令行。

以 ListEventBuses API 为例：

```js
[LOG] {"eventBuses":[{"description":"A demo bus.","eventBusName":"demo-bus"},{"eventBusName":"newBus"}],"requestId":"4484bc24-2519-42fa-92b7-908ffcb2b22b","total":2,"maxResults":2}
[LOG] test end!
```


## sdk 生成

生成条件：
- darabonba 安装完成
- go 1.19 以上 安装完成

生成指令(在`/sdk`目录下运行)：
```
dara install
dara codegen go generated/go
```
dara codegen 运行完后 /sdk/generated/go 下会生成 /client 目录和 go.mod。


### 生成测试代码

所有测试代码的 dara 版本均在 /sdk/demo/EventBus 下的 demo.dara 中，每个 api 都有单独的测试函数，实际使用时在 main 函数中调用即可。

下面以 ListEventBuses 接口为例生成 go 测试代码

进入 /sdk/demo/EventBus 下
```
dara install
dara codegen go generated/go
```

生成完毕后可在 /sdk/demo/EventBus/generated/go/client 下看到 client.go，通过编辑器打开改文件并修改
`SdkClient sdkclient.Client` 为 `SdkClient *sdkclient.Client`

### 添加 sdk 依赖
由于 sdk 未发布到线上，需要在 go.mod 中修改为本地引用。在 /sdk/demo/EventBus/generated/go/go.mod 末尾添加如下部分：
```
replace github.com/org-apache-rocketmq/eventbridge-sdk v0.0.0 => ../../../../generated/go/
```

### 添加 main 函数
由于不同语言 main 函数格式不同，需要手动添加 main 函数来执行测试函数。仍以 ListEventBuses 为例，
在 /sdk/demo/EventBus/generated/go/ 添加 main.go，并在其中写入如下代码：

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

### 运行

参考 sdk 使用的步骤即可。