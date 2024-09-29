# Daranbonba

通过 darabonba 生成的多语言 SDK 实现对 eventBridge 进行 RPC 管控

# 多语言 SDK 生成

## dara 安装

```
npm install @darabonba/cli -g
```

## 生成代码

以 java 为例，在 `/path/to/eventbridge/sdk/` 下，执行以下命令：

```sh
#安装依赖
dara install
#生成 java 版本到 ./java 目录下
dara codegen java ./java

```


# SDK 使用参考

以 Java 为例

dara codegen 运行完后 ./java 下会生成 src 目录和 pom.xml，此时可以通过 maven 安装依赖。

## POM 修改

darabonba 生成 maven 项目时会自动生成 pom.xml，但其中的一些配置可能需要修改。这里需要使用 JDK 8 运行代码，因此需将 maven-compiler-plugin 配置修改如下

```js
<plugin>
    <groupId>org.apache.maven.plugins</groupId>
    <artifactId>maven-compiler-plugin</artifactId>
    <version>3.6.1</version>
    <configuration>
        <source>8</source>
        <target>8</target>
    </configuration>
</plugin>

```

修改完成后，可在 /sdk/java 目录下运行 `maven -e install` 安装依赖。

## 生成测试代码

所有测试代码的 dara 版本均在 /sdk/demo 下，对应 /adapter/api/src/.../controller 下的 api 结构，每个 api 都有单独的 dara 测试模块。

下面以 CreateEventBus 接口为例生成 java 测试代码

进入 /sdk/demo/eventBusDemo/createEventBusDemo 下
```
dara install
dara codegen java ../../../java/
```

生成完毕后可在 /sdk/java/src/.../demo 下看到 CreateEventBusDemo.java

## 添加 main 函数
由于不同语言 main 函数格式不同，需要手动添加 main 函数来执行测试函数。仍以 CreateEventBus 为例，
在 CreateEventBusDemo.java 的 CreateEventBusDemo class 中添加如下代码

```java
    public static void main(String args[]){
        try {
            CreateEventBusDemo demo = new CreateEventBusDemo();
            demo.testCreateEventBus();
        } catch(Exception e){
            // TODO: deal with exception
        }
    }
```


## 测试效果

成功在本地部署 RocketMQ（nameServer + broker） 和 Eventbridge 后，运行测试代码即可（EventBridge 监听端口需为默认的 7001）。返回体的 body 会输出到命令行。

以 listEventBuses API 为例：

```sh
200
{"eventBuses":[{"eventBusName":"add-bus"},{"description":"A demo bus.","eventBusName":"demo-bus"}],"total":2,"requestId":"fa5d4ab6-4961-4c2c-a4b9-2845d44f8d82","maxResults":2}

```

