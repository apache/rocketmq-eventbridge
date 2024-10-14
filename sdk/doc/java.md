# Java版本sdk

## sdk 使用

/sdk/generated/java 即为已经生成好的 sdk 源码和项目依赖。使用样例在 /sdk/demo/\*/generated/java 下。

每个 api 都有单独的测试函数，实际使用时在 main 函数中调用即可。除 EventData 外的各 Controller 默认的测试接口均为 list 接口（如 EventBusController 的 ListEventBuses）。如需测试其他接口，在 main 函数中调用对应的测试函数即可。

下面以 ListEventBuses 接口为例说明如何使用 sdk 和 demo。

### sdk 安装到本地仓库

sdk 生成后，可通过 maven 安装到本地仓库，方便其他项目使用。

在 /sdk/generated/java 目录下运行 `mvn install` 安装依赖。安装成功时输出应包含如下内容：
```bash
$ mvn install
...
...
[INFO] Installing /root/rocketmq-eventbridge/sdk/java/target/sdk-0.0.0.jar to /root/.m2/repository/org/apache/rocketmq/eventbridge/sdk/0.0.0/sdk-0.0.0.jar
[INFO] Installing /root/rocketmq-eventbridge/sdk/java/pom.xml to /root/.m2/repository/org/apache/rocketmq/eventbridge/sdk/0.0.0/sdk-0.0.0.pom
[INFO] ------------------------------------------------------------------------
[INFO] BUILD SUCCESS
[INFO] ------------------------------------------------------------------------
[INFO] Total time:  2.691 s
[INFO] Finished at: 2024-08-17T17:21:58+08:00
[INFO] ------------------------------------------------------------------------
```

此时 sdk 已打包安装到本地仓库，可生成测试代码调用。

### demo 编译

在 /sdk/demo/EventBus/generated/java 路径下执行 mvn compile，编译通过后即可在 IDE 中或通过命令行工具进行测试

### 测试效果

成功在本地部署 RocketMQ（nameServer + broker） 和 Eventbridge 后，运行测试代码即可（EventBridge 监听端口需为默认的 7001）。返回体的 body 会自动输出到命令行。

以 ListEventBuses API 为例：

```js
[LOG] {"eventBuses":[{"description":"A demo bus.","eventBusName":"demo-bus"},{"eventBusName":"newBus"}],"requestId":"4484bc24-2519-42fa-92b7-908ffcb2b22b","total":2,"maxResults":2}
[LOG] test end!
```


## sdk 生成

生成条件：
- darabonba 安装完成
- JDK 8 安装完成
- maven 安装完成

生成指令(在`/sdk`目录下运行)：
```
dara install
dara codegen java generated/java
```
dara codegen 运行完后 /sdk/generated/java 下会生成 /src 目录和 pom.xml，此时可以通过 maven 安装依赖。

### POM修改

darabonba 生成 maven 项目时会自动生成 pom.xml，但其中的一些配置需要修改。这里由于需要使用 JDK 8 运行代码，因此需将 maven-compiler-plugin 配置修改如下

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
另外由于需要把 sdk 安装到本地 maven 仓库，所以配置跳过 gpg 签名，继续修改 POM 如下：
```js
<plugin>
  <groupId>org.apache.maven.plugins</groupId>
  <artifactId>maven-gpg-plugin</artifactId>
  <version>1.6</version>
  <configuration>
    <skip>true</skip>
  </configuration>
  <executions>
    <execution>
    <id>sign-artifacts</id>
    <phase>verify</phase>
    <goals>
      <goal>sign</goal>
    </goals>
    </execution>
  </executions>
</plugin>
```

### 生成测试代码

所有测试代码的 dara 版本均在 /sdk/demo/*/ 下的 demo.dara 中，每个 api 都有单独的测试函数，实际使用时在 main 函数中调用即可。

下面以 ListEventBuses 接口为例生成 java 测试代码

进入 /sdk/demo/EventBus 下
```
dara install
dara codegen java generated/java
```

生成完毕后可在 /sdk/demo/EventBus/generated/java/src/.../demo 下看到 Demo.java

> 此时也需要安装 sdk 的 POM 修改方式修改 demo 的 POM

### 添加 main 函数
由于不同语言 main 函数格式不同，需要手动添加 main 函数来执行测试函数。仍以 ListEventBuses 为例，
在 Demo.java 的 Demo class 中添加如下代码

```java
    public static void main(String[] args) {
        try {
            Demo demo = new Demo();
            demo.testListEventBuses();
        } catch (Exception e) {
            // TODO: handle exception
        }
    }
```

### 运行

参考 sdk 使用的步骤即可。