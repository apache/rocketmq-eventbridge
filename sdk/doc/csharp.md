# 生成Csharp版本sdk

生成条件：
- darabonba 安装完成
- dotnet 安装完成

生成指令(在`/sdk`目录下运行)：
```
dara install
dara codegen csharp csharp
```
dara codegen 运行完后 /sdk/csharp 下会生成 /core 目录，其下是项目代码和配置文件


## 打包 sdk

在目录 /sdk/csharp/core 下执行如下打包命令
```sh
dotnet pack -c Release
```
应有类似如下输出:
```
Determining projects to restore...
  Restored /root/rocketmq-eventbridge/sdk/csharp/core/sdk.csproj (in 281 ms).
  sdk -> /root/rocketmq-eventbridge/sdk/csharp/core/bin/Release/net45/RocketMQ.Eventbridge.SDK.dll
  sdk -> /root/rocketmq-eventbridge/sdk/csharp/core/bin/Release/netstandard2.0/RocketMQ.Eventbridge.SDK.dll
  The package RocketMQ.Eventbridge.SDK.1.0.0 is missing a readme. Go to https://aka.ms/nuget/authoring-best-practices/readme to learn why package readmes are important.
  Successfully created package '/root/rocketmq-eventbridge/sdk/csharp/core/bin/Release/RocketMQ.Eventbridge.SDK.1.0.0.nupkg'.
```
检查 /sdk/csharp/core/bin/Release/ 下应有 RocketMQ.Eventbridge.SDK.1.0.0.nupkg 文件，此时 sdk 打包完成。

## 生成测试代码

所有测试代码的 dara 版本均在 /sdk/demo/*/ 下的 demo.dara 中，每个 api 都有单独的测试函数，实际使用时在 main 函数中调用即可。

下面以 ListEventBuses 接口为例生成 csharp 测试代码

进入 /sdk/demo/EventBus/ 下
```
dara install
dara codegen csharp csharp
```
dara codegen 运行完后 /sdk/demo/EventBus/csharp 下会生成 /core 目录，其下是项目代码和配置文件

## 配置项目

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

.NET workloads installed:
Configured to use loose manifests when installing new manifests.
There are no installed workloads to display.

Host:
  Version:      8.0.8
  Architecture: x64
  Commit:       08338fcaa5

.NET SDKs installed:
  8.0.401 [/usr/share/dotnet/sdk]

.NET runtimes installed:
  Microsoft.AspNetCore.App 8.0.8 [/usr/share/dotnet/shared/Microsoft.AspNetCore.App]
  Microsoft.NETCore.App 8.0.8 [/usr/share/dotnet/shared/Microsoft.NETCore.App]

Other architectures found:
  None

Environment variables:
  Not set

global.json file:
  Not found

Learn more:
  https://aka.ms/dotnet/info

Download .NET:
  https://aka.ms/dotnet/download
```

在 /sdk/demo/EventBus/csharp/core 下打开 sdkDemo.csproj 项目配置文件，修改相应的配置项。这里给出测试使用的配置:
```json
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
    <PackageReference Include="AlibabaCloud.OpenApiClient" Version="0.1.11"/>
    <PackageReference Include="RocketMQ.Eventbridge.SDK" Version="1.0.0"/>
    <PackageReference Include="AlibabaCloud.TeaConsole" Version="0.1.0"/>
    <PackageReference Include="Tea" Version="1.0.11"/>
  </ItemGroup>
</Project>
```

此时，还需要手动添加 sdk 的本地依赖，也就是之前生成的 package。
在 /sdk/demo/EventBus/csharp/core 下执行：
```
dotnet add package RocketMQ.Eventbridge.SDK --version 1.0.0 --source ../../../../csharp/core/bin/Release
```

应有类似如下输出：
```
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

## 添加 main 函数
由于不同语言 main 函数格式不同，需要手动添加 main 函数来执行测试函数。仍以 ListEventBuses 为例，
在 /sdk/demo/EventBus/csharp/core 下编辑 Demo.cs。在`Demo`类内部添加 Main 函数如下：

```csharp
        static void Main(string[] _args){
            Demo demo = new Demo();
            demo.TestListEventBuses();
        }
```

## 编译运行

在 /sdk/demo/EventBus/csharp/core 目录下执行 `dotnet run --framework netcoreapp8.0` 命令即可运行代码。请确保这里选择的 framework 已安装在环境中，否则会报错。

## 测试效果

成功在本地部署 RocketMQ（nameServer + broker） 和 Eventbridge 后，运行测试代码即可（EventBridge 监听端口需为默认的 7001）。返回体的 body 会自动输出到命令行。

以 ListEventBuses API 为例：

```js
[LOG] {"Code":null,"EventBuses":[{"Description":"A demo bus.","EventBusName":"demo-bus"},{"Description":null,"EventBusName":"newBus"}],"Message":null,"RequestId":"c6f87b96-8106-4068-959b-b14831c66051","NextToken":null,"Total":2,"MaxResults":2}
[LOG] test end!
```

