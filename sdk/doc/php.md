# 生成Php版本sdk

生成条件：
- darabonba 安装完成
- php、composer 安装完成
- 视环境可能需要安装 PHP extension curl、SimpleXML

生成指令(在`/sdk`目录下运行)：
```
dara install
dara codegen php php
```
dara codegen 运行完后 /sdk/php 下会生成源代码和 composer.json。

修改 composer.json 如下：
```json
{
  "name": "rocketmq/eventbridge-sdk",
  "description": "RocketMQ eventbridge (20240701) SDK Library for PHP",
  "type": "library",
  "license": "Apache-2.0",
  "authors": [],
  "version": "0.0.0",
  "require": {
    "php": ">5.5",
    "alibabacloud/tea-utils": "^0.2.21",
    "alibabacloud/darabonba-openapi": "^0.2.12"
  },
  "autoload": {
    "psr-4": {
      "RocketMQ\\Eventbridge\\SDK\\": "src"
    }
  },
  "scripts": {
    "fixer": "php-cs-fixer fix ./"
  },
  "config": {
    "sort-packages": true,
    "preferred-install": "dist",
    "optimize-autoloader": true
  },
  "prefer-stable": true
}
```

## 生成测试代码

所有测试代码的 dara 版本均在 /sdk/demo/*/ 下的 demo.dara 中，每个 api 都有单独的测试函数，实际使用时在 main 函数中调用即可。

下面以测试 ListEventBuses 接口为例生成 php 测试代码

进入 /sdk/demo/EventBus/ 下
```
dara install
dara codegen php php
```

dara codegen 运行完后 /sdk/demo/EventBus/php 下会生成源代码和 composer.json。

修改 composer.json 如下：
```json
{
  "name": "rocketmq/eventbridge-sdk-demo",
  "description": "RocketMQ eventbridge (20240701) SDK Demo for PHP",
  "type": "library",
  "license": "Apache-2.0",
  "authors": [],
  "require": {
    "php": ">5.5",
    "alibabacloud/tea-utils": "^0.2.21",
    "alibabacloud/darabonba-openapi": "^0.2.12",
    "rocketmq/eventbridge-sdk": "^0.0.0",
    "alibabacloud/tea-console": "^0.1.0"
  },
  "autoload": {
    "psr-4": {
      "RocketMQ\\Eventbridge\\SDK\\Demo\\": "src"
    }
  },
  "scripts": {
    "fixer": "php-cs-fixer fix ./"
  },
  "config": {
    "sort-packages": true,
    "preferred-install": "dist",
    "optimize-autoloader": true
  },
  "prefer-stable": true,
  "repositories": {
    "rocketmq":{
      "type" : "path",
      "url": "../../../php"
    }
  }
}
```

然后，在 /sdk/demo/EventBus/php 目录下运行 composer install 即可安装依赖

## 添加 main 函数
由于不同语言 main 函数格式不同，需要手动添加 main 函数来执行测试函数。仍以 ListEventBuses 为例，在 /sdk/demo/EventBus/php 添加 main.php，并在其中写入如下代码：

```php
<?php

namespace RocketMQ\Eventbridge\SDK\Demo;
require 'vendor/autoload.php';
include 'src/Demo.php';

$demo = new Demo();
$demo->testListEventBuses();
```

## 测试效果

成功在本地部署 RocketMQ（nameServer + broker） 和 Eventbridge 后，运行测试代码即可（EventBridge 监听端口需为默认的 7001）。返回体的 body 会自动输出到命令行。

以 ListEventBuses API 为例：

```js
[LOG] {"eventBuses":[{"description":"A demo bus.","eventBusName":"demo-bus"},{"eventBusName":"newBus"}],"requestId":"4484bc24-2519-42fa-92b7-908ffcb2b22b","total":2,"maxResults":2}
[LOG] test end!
```
