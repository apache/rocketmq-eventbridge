# Csharp版本sdk

<mark>
请注意！由于 sdk 生成所基于的 openAPI  Client 模块存在 bug，部分 api 暂不可用。等待 openAPI 修复中
</mark>

相关 Issue：https://github.com/aliyun/darabonba-openapi/issues/169

## sdk 使用

/sdk/generated/csharp 即为已经生成好的 sdk 源码和项目依赖。使用样例在 /sdk/demo/\*/generated/csharp 下。

每个 api 都有单独的测试函数，实际使用时在 main 函数中调用即可。除 EventData 外的各 Controller 默认的测试接口均为 list 接口（如 EventBusController 的 ListEventBuses）。如需测试其他接口，在 main 函数中调用对应的测试函数即可。

下面以 ListEventBuses 接口为例说明如何使用 sdk 和 demo。

### 打包 sdk

在目录 /sdk/generated/csharp/core 下执行如下打包命令
```sh
dotnet pack -c Release
```
应有类似如下输出:
```
Determining projects to restore...
  ...
  ...
  Successfully created package '/root/rocketmq-eventbridge/sdk/csharp/core/bin/Release/RocketMQ.Eventbridge.SDK.1.0.0.nupkg'.
```
检查 /sdk/generated/csharp/core/bin/Release/ 下应有 RocketMQ.Eventbridge.SDK.1.0.0.nupkg 文件，此时 sdk 打包完成。

### demo 添加 sdk 依赖

此时，需要在 demo 中手动添加 sdk 的本地依赖，也就是之前生成的 package。
在 /sdk/demo/EventBus/generated/csharp/core 下执行：
```sh
dotnet add package RocketMQ.Eventbridge.SDK --version 1.0.0 --source ../../../../../generated/csharp/core/bin/Release
```

应有类似如下输出：
```log
Determining projects to restore...
  Writing /tmp/tmpU2fqVy.tmp
info : X.509 certificate chain validation will use the fallback certificate bundle at '/usr/share/dotnet/sdk/8.0.401/trustedroots/codesignctl.pem'.
info : X.509 certificate chain validation will use the fallback certificate bundle at '/usr/share/dotnet/sdk/8.0.401/trustedroots/timestampctl.pem'.
info : Adding PackageReference for package 'RocketMQ.Eventbridge.SDK' into project '/root/rocketmq-eventbridge/sdk/demo/EventBus/csharp/core/sdkDemo.csproj'.
info : Restoring packages for /root/rocketmq-eventbridge/sdk/demo/EventBus/csharp/core/sdkDemo.csproj...
info : Installed RocketMQ.Eventbridge.SDK 1.0.0 from /root/rocketmq-eventbridge/sdk/csharp/core/bin/Release to /root/.nuget/packages/rocketmq.eventbridge.sdk/1.0.0 with content hash lxzRlGQsVxPB9fC1fsDntUt6QG7hWLZPuGCuhunJHyoN7+o78vm/UPNI7FeUkEBVeMJHVRtn0EUF0Pd9NMEcMw==.
info : Package 'RocketMQ.Eventbridge.SDK' is compatible with all the specified frameworks in project '/root/rocketmq-eventbridge/sdk/demo/EventBus/csharp/core/sdkDemo.csproj'.
info : PackageReference for package 'RocketMQ.Eventbridge.SDK' version '1.0.0' updated in file '/root/rocketmq-eventbridge/sdk/demo/EventBus/csharp/core/sdkDemo.csproj'.
info : PackageReference for package 'RocketMQ.Eventbridge.SDK' version '1.0.0' updated in file '/root/rocketmq-eventbridge/sdk/demo/EventBus/csharp/core/sdkDemo.csproj'.
info : Generating MSBuild file /root/rocketmq-eventbridge/sdk/demo/EventBus/csharp/core/obj/sdkDemo.csproj.nuget.g.props.
info : Generating MSBuild file /root/rocketmq-eventbridge/sdk/demo/EventBus/csharp/core/obj/sdkDemo.csproj.nuget.g.targets.
info : Writing assets file to disk. Path: /root/rocketmq-eventbridge/sdk/demo/EventBus/csharp/core/obj/project.assets.json
log  : Restored /root/rocketmq-eventbridge/sdk/demo/EventBus/csharp/core/sdkDemo.csproj (in 243 ms).
```

此时依赖添加完成。

### 配置项目（根据运行框架可选）

运行 csharp 需要相应的 sdk 和运行环境，检查本地已有的 sdk 版本可以通过 `dotnet --list-sdks` 或 `dotnet --info`检索。这里测试环境的配置：
```sh
.NET SDKs installed:
  8.0.401 [/usr/share/dotnet/sdk]

.NET runtimes installed:
  Microsoft.AspNetCore.App 8.0.8 [/usr/share/dotnet/shared/Microsoft.AspNetCore.App]
  Microsoft.NETCore.App 8.0.8 [/usr/share/dotnet/shared/Microsoft.NETCore.App]
```

如果您的环境配置未安装 8.0.8 版本的.net 运行环境，需要自行安装才能运行程序。如果您希望调整项目运行框架，请在 /sdk/demo/EventBus/generated/csharp/core 下的 sdkDemo.csproj 配置文件中修改相应配置。

### 编译运行

在 /sdk/demo/EventBus/generated/csharp/core 目录下执行 `dotnet run --framework netcoreapp8.0` 命令即可运行代码。请确保这里选择的 framework 已安装在环境中，否则会报错。

### 测试效果

成功在本地部署 RocketMQ（nameServer + broker） 和 Eventbridge 后，运行测试代码即可（EventBridge 监听端口需为默认的 7001）。返回体的 body 会自动输出到命令行。

以 ListEventBuses API 为例：

```js
[LOG] {"Code":null,"EventBuses":[{"Description":"A demo bus.","EventBusName":"demo-bus"},{"Description":null,"EventBusName":"newBus"}],"Message":null,"RequestId":"c6f87b96-8106-4068-959b-b14831c66051","NextToken":null,"Total":2,"MaxResults":2}
[LOG] test end!
```


## sdk 生成

生成条件：
- darabonba 安装完成
- dotnet 安装完成

生成指令(在`/sdk`目录下运行)：
```
dara install
dara codegen csharp generated/csharp
```
dara codegen 运行完后 /sdk/generated/csharp 下会生成 /core 目录，其下是项目代码和配置文件。

### sdk 依赖调整

首先，根据测试经验，需要调整项目的依赖版本。在 /sdk/generated/csharp/core/sdk.csproj 中，将
```xml
  <PackageReference Include="Tea" Version="1.0.11"/>
```
修改为
```xml
  <PackageReference Include="Tea" Version="1.1.0"/>
```
并添加版本信息
```xml
  <PropertyGroup>
    <Version>1.0.0</Version>
  </PropertyGroup>
```

### 生成测试代码

所有测试代码的 dara 版本均在 /sdk/demo/*/ 下的 demo.dara 中，每个 api 都有单独的测试函数，实际使用时在 main 函数中调用即可。

下面以 ListEventBuses 接口为例生成 csharp 测试代码

进入 /sdk/demo/EventBus/ 下
```sh
dara install
dara codegen csharp generated/csharp
```
dara codegen 运行完后 /sdk/demo/EventBus/generated/csharp 下会生成 /core 目录，其下是项目代码和配置文件

### 配置项目

运行 csharp 需要相应的 sdk 和运行环境，检查本地已有的 sdk 版本可以通过 `dotnet --list-sdks` 或 `dotnet --info`检索。这里给出测试环境的配置：
```sh
> dotnet --list-sdks
8.0.401 [/usr/share/dotnet/sdk]

> dotnet --info
.NET SDK:
 Version:           8.0.401
 Commit:            811edcc344
 Workload version:  8.0.400-manifests.b6724b7a
 MSBuild version:   17.11.4+37eb419ad

Runtime Environment:
 OS Name:     ubuntu
 OS Version:  20.04
 OS Platform: Linux
 RID:         linux-x64
 Base Path:   /usr/share/dotnet/sdk/8.0.401/

Host:
  Version:      8.0.8
  Architecture: x64
  Commit:       08338fcaa5

.NET SDKs installed:
  8.0.401 [/usr/share/dotnet/sdk]

.NET runtimes installed:
  Microsoft.AspNetCore.App 8.0.8 [/usr/share/dotnet/shared/Microsoft.AspNetCore.App]
  Microsoft.NETCore.App 8.0.8 [/usr/share/dotnet/shared/Microsoft.NETCore.App]
```

在 /sdk/demo/EventBus/generated/csharp/core 下打开 sdkDemo.csproj 项目配置文件，修改相应的配置项。这里给出测试使用的配置:
```xml
<?xml version="1.0" encoding="UTF-8" standalone="yes"?>
<Project Sdk="Microsoft.NET.Sdk">
  <PropertyGroup>
    <TargetFrameworks>netstandard2.0;net45;netcoreapp8.0</TargetFrameworks>
    <RootNamespace>RocketMQ.Eventbridge.Demo</RootNamespace>
    <OutputType>Exe</OutputType>
    <GeneratePackageOnBuild>false</GeneratePackageOnBuild>
    <GenerateAssemblyInfo>false</GenerateAssemblyInfo>
    <AssemblyName>RocketMQ.Eventbridge.Demo</AssemblyName>
    <Version/>
    <LangVersion>5</LangVersion>
    <Description>open source eventbridge (20240701) SDK Demo Library for .NET</Description>
  </PropertyGroup>
  <PropertyGroup Condition=" '$(TargetFramework)' == 'netstandard2.0'">
    <DefineConstants>NETSTANDARD2_0</DefineConstants>
  </PropertyGroup>
  <PropertyGroup Condition=" '$(TargetFramework)' == 'net45' ">
    <DefineConstants>NET45</DefineConstants>
  </PropertyGroup>
  <ItemGroup Condition=" '$(TargetFramework)' == 'net45' ">
    <Reference Include="mscorlib"/>
    <Reference Include="System"/>
    <Reference Include="System.Core"/>
    <Reference Include="Microsoft.CSharp"/>
    <Reference Include="System.Data"/>
    <Reference Include="System.Web"/>
    <Reference Include="System.Drawing"/>
    <Reference Include="System.Security"/>
    <Reference Include="System.Xml"/>
    <Reference Include="System.Configuration"/>
    <Reference Include="System.Net.Http"/>
  </ItemGroup>
  <ItemGroup>
    <PackageReference Include="Microsoft.NETFramework.ReferenceAssemblies" Version="1.0.0-preview.2">
      <PrivateAssets>all</PrivateAssets>
      <IncludeAssets>runtime; build; native; contentfiles; analyzers</IncludeAssets>
    </PackageReference>
    <PackageReference Include="AlibabaCloud.TeaUtil" Version="0.1.19"/>
    <PackageReference Include="AlibabaCloud.OpenApiClient" Version="0.1.12"/>
    <PackageReference Include="RocketMQ.Eventbridge.SDK" Version="1.0.0"/>
    <PackageReference Include="AlibabaCloud.TeaConsole" Version="0.1.0"/>
    <PackageReference Include="Tea" Version="1.1.0"/>
  </ItemGroup>
</Project>
```

### 添加 main 函数
由于不同语言 main 函数格式不同，需要手动添加 main 函数来执行测试函数。仍以 ListEventBuses 为例，
在 /sdk/demo/EventBus/generated/csharp/core 下编辑 Demo.cs。在`Demo`类内部添加 Main 函数如下：

```csharp
        static void Main(string[] _args){
            Demo demo = new Demo();
            demo.TestListEventBuses();
        }
```

### 运行

参考 sdk 使用的步骤即可。