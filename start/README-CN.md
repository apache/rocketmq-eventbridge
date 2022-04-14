## start 
* 含义：启动引导模块；
* 作用：用于定义当前运行环境需要加载的模块、配置项等；

主要包含以下几个模块：

###  common
* enums
* constants

###  model
* 含义：核心业务服务层，用于管理领域内的核心业务模型；

###  repository：
* 含义：定义model持久化的API
* 注意：这里虽然是依赖的外部服务，但是是从domain的视角主动定义依赖的API格式，而不是以提供的RPC视角定义API格式；

### rpc：
* 含义：定义来依赖的外部API
* 同样注意：这里虽然是依赖的外部服务，但是是从domain的视角主动定义依赖的API格式，而不是以提供的RPC视角定义API格式；

### service
* 含义: 用于存放跨领域的服务，不直接依赖repository，而是依赖model中的service；
* 格式：xxxDomainService

