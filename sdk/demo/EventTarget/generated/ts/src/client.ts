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
   * EventTarget Controller apis:
   * createEventTargets *
   * updateEventTargets *
   * deleteEventTargets *
   * listEventTargets   *
   */
  async testCreateEventTargets(): Promise<void> {
    let config_ : {[key: string ]: any} = {
      fileName: "~/Target",
      line: "{    \"form\":\"JSONPATH\",    \"value\":\"$.data\"}",
    };
    let config2_ : {[key: string ]: any} = {
      fileName: "~/Target222",
      line: "{    \"form\":\"JSONPATH\",    \"value\":\"$.data\"}",
    };
    let request = new $SDKClient.CreateEventTargetsRequest({
      eventBusName: "newBus",
      eventRuleName: "newRule",
      eventTargets: [
        new $SDKClient.EventTarget({
          eventTargetName: "newTarget",
          className: "file",
          config: config_,
          runOptions: new $SDKClient.EventTargetRunOptions({
            errorsTolerance: "",
            retryStrategy: new $SDKClient.EventTargetRunOptionsRetryStrategy({
              pushRetryStrategy: "",
              maximumEventAgeInSeconds: 100,
              maximumRetryAttempts: 100,
            }),
            deadLetterQueue: new $SDKClient.EventTargetRunOptionsDeadLetterQueue({
              type: "",
            }),
          }),
        }),
        new $SDKClient.EventTarget({
          eventTargetName: "newTarget222",
          className: "file",
          config: config2_,
          runOptions: new $SDKClient.EventTargetRunOptions({
            errorsTolerance: "",
            retryStrategy: new $SDKClient.EventTargetRunOptionsRetryStrategy({
              pushRetryStrategy: "",
              maximumEventAgeInSeconds: 100,
              maximumRetryAttempts: 100,
            }),
            deadLetterQueue: new $SDKClient.EventTargetRunOptionsDeadLetterQueue({
              type: "",
            }),
          }),
        })
      ],
    });
    try {
      let res = await this._sdkClient.createEventTargets(request);
      Console.log(Util.toJSONString(res.body));
    } catch (err) {
      Console.log("err!");
      Console.log(err.message);
    } finally {
      Console.log("test end!");
    }    
  }

  async testUpdateEventTargets(): Promise<void> {
    let config_ : {[key: string ]: any} = {
      fileName: "~/Target",
      line: "{    \"form\":\"JSONPATH\",    \"value\":\"$.data\"}",
    };
    let config2_ : {[key: string ]: any} = {
      fileName: "~/Target222",
      line: "{    \"form\":\"JSONPATH\",    \"value\":\"$.data\"}",
    };
    let request = new $SDKClient.UpdateEventTargetsRequest({
      eventBusName: "newBus",
      eventRuleName: "newRule",
      eventTargets: [
        new $SDKClient.EventTarget({
          eventTargetName: "newTarget",
          className: "file",
          config: config_,
        }),
        new $SDKClient.EventTarget({
          eventTargetName: "newTarget222",
          className: "file",
          config: config2_,
        })
      ],
    });
    try {
      let res = await this._sdkClient.updateEventTargets(request);
      Console.log(Util.toJSONString(res.body));
    } catch (err) {
      Console.log("err!");
      Console.log(err.message);
    } finally {
      Console.log("test end!");
    }    
  }

  async testDeleteEventTargets(): Promise<void> {
    let request = new $SDKClient.DeleteEventTargetsRequest({
      eventBusName: "newBus",
      eventRuleName: "newRule",
      eventTargetNames: [
        "newTarget",
        "newTarget222"
      ],
    });
    try {
      let res = await this._sdkClient.deleteEventTargets(request);
      Console.log(Util.toJSONString(res.body));
    } catch (err) {
      Console.log("err!");
      Console.log(err.message);
    } finally {
      Console.log("test end!");
    }    
  }

  async testListEventTargets(): Promise<void> {
    let request = new $SDKClient.ListEventTargetsRequest({
      eventBusName: "newBus",
      eventRuleName: "newRule",
    });
    try {
      let res = await this._sdkClient.listEventTargets(request);
      Console.log(Util.toJSONString(res.body));
    } catch (err) {
      Console.log("err!");
      Console.log(err.message);
    } finally {
      Console.log("test end!");
    }    
  }

}
