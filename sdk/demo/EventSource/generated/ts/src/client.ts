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
   * EventSource Controller apis:
   * createEventSource *
   * updateEventSource *
   * deleteEventSource *
   * getEventSource    *
   * listEventSources  *
   */
  async testCreateEventSource(): Promise<void> {
    let request = new $SDKClient.CreateEventSourceRequest({
      eventBusName: "newBus",
      eventSourceName: "newSource",
      description: "a source for test",
    });
    try {
      let res = await this._sdkClient.createEventSource(request);
      Console.log(Util.toJSONString(res.body));
    } catch (err) {
      Console.log("err!");
      Console.log(err.message);
    } finally {
      Console.log("test end!");
    }    
  }

  async testUpdateEventSource(): Promise<void> {
    let request = new $SDKClient.UpdateEventSourceRequest({
      eventBusName: "newBus",
      eventSourceName: "newSource",
      description: "new description for testing Update API",
    });
    try {
      let res = await this._sdkClient.updateEventSource(request);
      Console.log(Util.toJSONString(res.body));
    } catch (err) {
      Console.log("err!");
      Console.log(err.message);
    } finally {
      Console.log("test end!");
    }    
  }

  async testDeleteEventSource(): Promise<void> {
    let request = new $SDKClient.DeleteEventSourceRequest({
      eventBusName: "newBus",
      eventSourceName: "newSource",
    });
    try {
      let res = await this._sdkClient.deleteEventSource(request);
      Console.log(Util.toJSONString(res.body));
    } catch (err) {
      Console.log("err!");
      Console.log(err.message);
    } finally {
      Console.log("test end!");
    }    
  }

  async testGetEventSource(): Promise<void> {
    let request = new $SDKClient.GetEventSourceRequest({
      eventBusName: "newBus",
      eventSourceName: "newSource",
    });
    try {
      let res = await this._sdkClient.getEventSource(request);
      Console.log(Util.toJSONString(res.body));
    } catch (err) {
      Console.log("err!");
      Console.log(err.message);
    } finally {
      Console.log("test end!");
    }    
  }

  async testListEventSources(): Promise<void> {
    let request = new $SDKClient.ListEventSourcesRequest({
      eventBusName: "newBus",
      eventSourceType: "USER_DEFINED",
      maxResults: 10,
      nextToken: "0",
    });
    try {
      let res = await this._sdkClient.listEventSources(request);
      Console.log(Util.toJSONString(res.body));
    } catch (err) {
      Console.log("err!");
      Console.log(err.message);
    } finally {
      Console.log("test end!");
    }    
  }

}
