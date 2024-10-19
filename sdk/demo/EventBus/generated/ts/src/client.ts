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
   * test func for EventBus Controller apis:
   * createEventBus *
   * getEventBus    *
   * deleteEventBus *
   * listEventBuses *
   */
  async testCreateEventBus(): Promise<void> {
    let request = new $SDKClient.CreateEventBusRequest({
      eventBusName: "newBus",
    });
    try {
      let res = await this._sdkClient.createEventBus(request);
      Console.log(Util.toJSONString(res.body));
    } catch (err) {
      Console.log("err!");
      Console.log(err.message);
    } finally {
      Console.log("test end!");
    }    
  }

  async testDeleteEventBus(): Promise<void> {
    let request = new $SDKClient.DeleteEventBusRequest({
      eventBusName: "newBus",
    });
    try {
      let res = await this._sdkClient.deleteEventBus(request);
      Console.log(Util.toJSONString(res.body));
    } catch (err) {
      Console.log("err!");
      Console.log(err.message);
    } finally {
      Console.log("test end!");
    }    
  }

  async testGetEventBus(): Promise<void> {
    let request = new $SDKClient.GetEventBusRequest({
      eventBusName: "newBus",
    });
    try {
      let res = await this._sdkClient.getEventBus(request);
      Console.log(Util.toJSONString(res.body));
    } catch (err) {
      Console.log("err!");
      Console.log(err.message);
    } finally {
      Console.log("test end!");
    }    
  }

  async testListEventBuses(): Promise<void> {
    let request = new $SDKClient.ListEventBusesRequest({
      maxResults: 2,
    });
    try {
      let res = await this._sdkClient.listEventBuses(request);
      Console.log(Util.toJSONString(res.body));
    } catch (err) {
      Console.log("err!");
      Console.log(err.message);
    } finally {
      Console.log("test end!");
    }    
  }

}
