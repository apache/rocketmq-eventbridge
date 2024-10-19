// This file is auto-generated, don't edit it
import Util from '@alicloud/tea-util';
import OpenApi, * as $OpenApi from '@alicloud/openapi-client';
import SDKClient, * as $SDKClient from '../../../../../generated/ts/src/client';
import Console from '@alicloud/tea-console';
import * as $tea from '@alicloud/tea-typescript';


export default class Client {
  _sdkClient: SDKClient;
  _endpoint: string;

  constructor() {
    this._endpoint = "127.0.0.1:7001";
    let config = new $OpenApi.Config({
      endpoint: this._endpoint,
    });
    this._sdkClient = new SDKClient(config);
  }


  /**
   * @remarks
   * test func for Connection Controller apis:
   * createConnection    *
   * deleteConnection    *
   * updateConnection    *
   * getConnection       *
   * selectOneConnection *
   * listConnections     *
   * listEnumsResponse   *
   */
  async testCreateConnection(): Promise<void> {
    let request = new $SDKClient.CreateConnectionRequest({
      connectionName: "new-connection",
      networkParameters: new $SDKClient.CreateConnectionRequestNetworkParameters({
        networkType: "PublicNetwork",
      }),
    });
    try {
      let res = await this._sdkClient.createConnection(request);
      Console.log(Util.toJSONString(res.body));
    } catch (err) {
      Console.log("err!");
      Console.log(err.message);
    } finally {
      Console.log("test end!");
    }    
  }

  async testDeleteConnection(): Promise<void> {
    let request = new $SDKClient.DeleteConnectionRequest({
      connectionName: "new-connection",
    });
    try {
      let res = await this._sdkClient.deleteConnection(request);
      Console.log(Util.toJSONString(res.body));
    } catch (err) {
      Console.log("err!");
      Console.log(err.message);
    } finally {
      Console.log("test end!");
    }    
  }

  async testUpdateConnection(): Promise<void> {
    let request = new $SDKClient.UpdateConnectionRequest({
      connectionName: "new-connection",
      networkParameters: new $SDKClient.UpdateConnectionRequestNetworkParameters({
        networkType: "PrivateNetwork",
        securityGroupId: "eb-167adad548759-security_grop/sg-bp1addad26peuh9qh9rtyb",
        vpcId: "eb-test/vpc-bp1symadadwnwgmqud",
        vswitcheId: "vsw-bp1iu4x7aeradadown1og8,vsw-bp193sqmadadlaszpeqbt2c",
      }),
    });
    try {
      let res = await this._sdkClient.updateConnection(request);
      Console.log(Util.toJSONString(res.body));
    } catch (err) {
      Console.log("err!");
      Console.log(err.message);
    } finally {
      Console.log("test end!");
    }    
  }

  async testGetConnections(): Promise<void> {
    let request = new $SDKClient.GetConnectionRequest({
      connectionName: "new-connection",
    });
    try {
      let res = await this._sdkClient.getConnection(request);
      Console.log(Util.toJSONString(res.body));
    } catch (err) {
      Console.log("err!");
      Console.log(err.message);
    } finally {
      Console.log("test end!");
    }    
  }

  async testSelectOneConnection(): Promise<void> {
    let request = new $SDKClient.GetConnectionRequest({
      connectionName: "new-connection",
    });
    try {
      let res = await this._sdkClient.selectOneConnection(request);
      Console.log(Util.toJSONString(res.body));
    } catch (err) {
      Console.log("err!");
      Console.log(err.message);
    } finally {
      Console.log("test end!");
    }    
  }

  async testListConnections(): Promise<void> {
    let request = new $SDKClient.ListConnectionsRequest({
      maxResults: 2,
    });
    try {
      let res = await this._sdkClient.listConnections(request);
      Console.log(Util.toJSONString(res.body));
    } catch (err) {
      Console.log("err!");
      Console.log(err.message);
    } finally {
      Console.log("test end!");
    }    
  }

  async testListEnumsResponse(): Promise<void> {
    try {
      let res = await this._sdkClient.listEnumsResponse();
      Console.log(Util.toJSONString(res.body));
    } catch (err) {
      Console.log("err!");
      Console.log(err.message);
    } finally {
      Console.log("test end!");
    }    
  }

}
