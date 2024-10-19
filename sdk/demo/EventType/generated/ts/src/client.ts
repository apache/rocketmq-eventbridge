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
   * EventType Controller apis:
   * listEventTypes *
   */
  async testListEventTypes(): Promise<void> {
    let request = new $SDKClient.ListEventTypesRequest({
      eventBusName: "newBus",
      eventSourceName: "newSource",
      maxResults: 10,
      nextToken: "0",
    });
    try {
      let res = await this._sdkClient.listEventTypes(request);
      Console.log(Util.toJSONString(res.body));
    } catch (err) {
      Console.log("err!");
      Console.log(err.message);
    } finally {
      Console.log("test end!");
    }    
  }

}
