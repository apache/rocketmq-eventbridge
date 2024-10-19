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
   * ApiDestination Controller apis:
   * createApiDestination *
   * updateApiDestination *
   * getApiDestination    *
   * deleteApiDestination *
   * listApiDestinations  *
   */
  async testCreateApiDestination(): Promise<void> {
    let request = new $SDKClient.CreateApiDestinationRequest({
      apiDestinationName: "new-api-destination",
      connectionName: "new-connection",
      description: "demo api destination for test",
      httpApiParameters: new $SDKClient.CreateApiDestinationRequestHttpApiParameters({
        endpoint: this._endpoint,
        method: "POST",
      }),
    });
    try {
      let res = await this._sdkClient.createApiDestination(request);
      Console.log(Util.toJSONString(res.body));
    } catch (err) {
      Console.log("err!");
      Console.log(err.message);
    } finally {
      Console.log("test end!");
    }    
  }

  async testUpdateApiDestination(): Promise<void> {
    let request = new $SDKClient.UpdateApiDestinationRequest({
      apiDestinationName: "new-api-destination",
      connectionName: "new-connection",
      description: "!updated! demo api destination for test",
      httpApiParameters: new $SDKClient.UpdateApiDestinationRequestHttpApiParameters({
        endpoint: this._endpoint,
        method: "GET",
      }),
    });
    try {
      let res = await this._sdkClient.updateApiDestination(request);
      Console.log(Util.toJSONString(res.body));
    } catch (err) {
      Console.log("err!");
      Console.log(err.message);
    } finally {
      Console.log("test end!");
    }    
  }

  async testGetApiDestination(): Promise<void> {
    let request = new $SDKClient.GetApiDestinationRequest({
      apiDestinationName: "new-api-destination",
    });
    try {
      let res = await this._sdkClient.getApiDestination(request);
      Console.log(Util.toJSONString(res.body));
    } catch (err) {
      Console.log("err!");
      Console.log(err.message);
    } finally {
      Console.log("test end!");
    }    
  }

  async testDeleteApiDestination(): Promise<void> {
    let request = new $SDKClient.DeleteApiDestinationRequest({
      apiDestinationName: "new-api-destination",
    });
    try {
      let res = await this._sdkClient.deleteApiDestination(request);
      Console.log(Util.toJSONString(res.body));
    } catch (err) {
      Console.log("err!");
      Console.log(err.message);
    } finally {
      Console.log("test end!");
    }    
  }

  async testListApiDestinations(): Promise<void> {
    let request = new $SDKClient.ListApiDestinationsRequest({
      maxResults: 2,
    });
    try {
      let res = await this._sdkClient.listApiDestinations(request);
      Console.log(Util.toJSONString(res.body));
    } catch (err) {
      Console.log("err!");
      Console.log(err.message);
    } finally {
      Console.log("test end!");
    }    
  }

}
