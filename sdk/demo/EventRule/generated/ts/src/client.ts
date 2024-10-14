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
   * EventRule Controller apis:
   * createEventRule  *
   * getEventRule     *
   * deleteEventRule  *
   * updateEventRule  *
   * listEventRules   *
   * enableEventRule  *
   * disableEventRule *
   */
  async testCreateEventRule(): Promise<void> {
    let request = new $SDKClient.CreateEventRuleRequest({
      eventBusName: "newBus",
      eventRuleName: "newRule",
      description: "an event rule for test",
      filterPattern: "{}",
    });
    try {
      let res = await this._sdkClient.createEventRule(request);
      Console.log(Util.toJSONString(res.body));
    } catch (err) {
      Console.log("err!");
      Console.log(err.message);
    } finally {
      Console.log("test end!");
    }    
  }

  async testGetEventRule(): Promise<void> {
    let request = new $SDKClient.GetEventRuleRequest({
      eventBusName: "newBus",
      eventRuleName: "newRule",
    });
    try {
      let res = await this._sdkClient.getEventRule(request);
      Console.log(Util.toJSONString(res.body));
    } catch (err) {
      Console.log("err!");
      Console.log(err.message);
    } finally {
      Console.log("test end!");
    }    
  }

  async testDeleteEventRule(): Promise<void> {
    let request = new $SDKClient.DeleteEventRuleRequest({
      eventBusName: "newBus",
      eventRuleName: "newRule",
    });
    try {
      let res = await this._sdkClient.deleteEventRule(request);
      Console.log(Util.toJSONString(res.body));
    } catch (err) {
      Console.log("err!");
      Console.log(err.message);
    } finally {
      Console.log("test end!");
    }    
  }

  async testUpdateEventRule(): Promise<void> {
    let request = new $SDKClient.UpdateEventRuleRequest({
      eventBusName: "newBus",
      eventRuleName: "newRule",
      description: "new description for testing update API",
      filterPattern: "{}",
    });
    try {
      let res = await this._sdkClient.updateEventRule(request);
      Console.log(Util.toJSONString(res.body));
    } catch (err) {
      Console.log("err!");
      Console.log(err.message);
    } finally {
      Console.log("test end!");
    }    
  }

  async testListEventRules(): Promise<void> {
    let request = new $SDKClient.ListEventRulesRequest({
      eventBusName: "newBus",
      maxResults: 2,
      nextToken: "0",
    });
    try {
      let res = await this._sdkClient.listEventRules(request);
      Console.log(Util.toJSONString(res.body));
    } catch (err) {
      Console.log("err!");
      Console.log(err.message);
    } finally {
      Console.log("test end!");
    }    
  }

  async testEnableEventRule(): Promise<void> {
    let request = new $SDKClient.EnableEventRuleRequest({
      eventBusName: "newBus",
      eventRuleName: "newRule",
    });
    try {
      let res = await this._sdkClient.enableEventRule(request);
      Console.log(Util.toJSONString(res.body));
    } catch (err) {
      Console.log("err!");
      Console.log(err.message);
    } finally {
      Console.log("test end!");
    }    
  }

  async testDisableEventRule(): Promise<void> {
    let request = new $SDKClient.DisableEventRuleRequest({
      eventBusName: "newBus",
      eventRuleName: "newRule",
    });
    try {
      let res = await this._sdkClient.disableEventRule(request);
      Console.log(Util.toJSONString(res.body));
    } catch (err) {
      Console.log("err!");
      Console.log(err.message);
    } finally {
      Console.log("test end!");
    }    
  }

}
