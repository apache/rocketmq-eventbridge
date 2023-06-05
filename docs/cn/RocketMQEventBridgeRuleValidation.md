## Apache RocketMQ EventBridge 参数规则验证

RocketMQ EventBridge 如何扩展参数验证


### 引入依赖包
```xml
<dependency>
    <groupId>org.apache.rocketmq</groupId>
    <artifactId>rocketmq-eventbridge-infrastructure</artifactId>
    <version>1.0.0</version>
</dependency>
```

### 如何进行扩展
```
public class XXXXAuthValidation implements AuthValidation {

    @Override
    public Context validate(ServerHttpRequest request, Context ctx) {
        ...
        return ctx.put(keyxxx, valxxxx);
    }

    @Override
    public String getType() {
        return "验证器名称";
    }
}
```

### resources目录下增加spi配置
```text
/resources/
|——META-INF
|   |——services
|      |——org.apache.rocketmq.eventbridge.infrastructure.validate.AuthValidation
|           org.apache.rocketmq.eventbridge.infrastructure.validate.XXXXAuthValidation
```

### 配置
```properties
auth.validation=验证器名称(如有多个以逗号分割)
```
