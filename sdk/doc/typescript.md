# Typescript版本sdk

## sdk 使用
/sdk/generated/ts 即为已经生成好的 sdk 源码和项目依赖。使用样例在 /sdk/demo/\*/generated/ts 下。

每个 api 都有单独的测试函数，实际使用时在 main 函数中调用即可。除 EventData 外的各 Controller 默认的测试接口均为 list 接口（如 EventBusController 的 ListEventBuses）。如需测试其他接口，在 main 函数中调用对应的测试函数即可。

下面以 ListEventBuses 接口为例说明如何使用 sdk 和 demo。

使用条件：
- 安装 nodejs

### 安装 sdk 依赖

在 /sdk/generated/ts 下运行 `npm install` 即可

### 安装 demo 依赖

在 /sdk/demo/EventBus/generated/ts 目录下执行 `npm install` 即可

### 编译运行

在 /sdk/demo/EventBus/generated/ts 目录下执行 `tsc` 命令即可编译，编译完成会生成 /sdk/demo/EventBus/generated/ts/dist 目录。

进入 /sdk/demo/EventBus/generated/ts/dist/demo/EventBus/ts/src 目录，命令行中执行 `node main.js` 即可执行测试代码。

### 测试效果

成功在本地部署 RocketMQ（nameServer + broker） 和 Eventbridge 后，运行测试代码即可（EventBridge 监听端口需为默认的 7001）。返回体的 body 会自动输出到命令行。

以 ListEventBuses API 为例：

```js
[LOG] {"eventBuses":[{"description":"A demo bus.","eventBusName":"demo-bus"},{"eventBusName":"newBus"}],"requestId":"4484bc24-2519-42fa-92b7-908ffcb2b22b","total":2,"maxResults":2}
[LOG] test end!
```



## sdk 生成

如果重新从 darabonba 生成 typescript 版本的 sdk 和 demo，需要先安装以下依赖：

生成条件：
- darabonba 安装完成
- npm 安装完成
    - npm 换源（可选）
- node-typescript 安装完成（linux）

生成指令(在`/sdk`目录下运行)：
```
dara install
dara codegen ts generated/ts
```
dara codegen 运行完后 /sdk/generated/ts 下会生成 /src 目录、package.json 和 tsconfig.json。

### 生成测试代码

所有测试代码的 dara 版本均在 /sdk/demo/*/ 下的 demo.dara 中，每个 api 都有单独的测试函数，实际使用时在 main 函数中调用即可。

下面以 ListEventBuses 接口为例生成 ts 测试代码

进入 /sdk/demo/EventBus 下
```
dara install
dara codegen ts generated/ts
```

生成完毕后可在 /sdk/demo/EventBus/generated/ts/src 下看到 client.ts

### 添加 main 函数
由于不同语言 main 函数格式不同，需要手动添加 main 函数来执行测试函数。仍以 ListEventBuses 为例，
在 /sdk/demo/EventBus/generated/ts/src 下添加 main.ts。其内部代码如下：

```ts
import Client from './client'

let c = new Client()
c.testListEventBuses()
```

### 安装 demo 依赖

由于 demo 中引用的 sdk client 尚未发布，所以需要在 /sdk/demo/EventBus/generated/ts/package.json 中删除依赖：
```js
"dependencies": {
    ...
    "@org.apache.rocketmq/eventbridge-sdk": "0.0.0",（删除该行）
    ...
},
```
同时，需要在 /sdk/demo/EventBus/generated/ts/src/client.ts 中将 SDKClient 的引用路径**修改**为本地路径：
```ts
import SDKClient, * as $SDKClient from '../../../../../generated/ts/src/client';
```

### 运行

参考 sdk 使用的步骤即可。