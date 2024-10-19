// This file is auto-generated, don't edit it
import Util, * as $Util from '@alicloud/tea-util';
import OpenApi, * as $OpenApi from '@alicloud/openapi-client';
import * as $tea from '@alicloud/tea-typescript';

/**
 * @remarks
 * EventBus Controller apis:
 * createEventBus *
 * getEventBus    *
 * deleteEventBus *
 * listEventBuses *
 */
export class CreateEventBusRequest extends $tea.Model {
  /**
   * @remarks
   * The description of the event bus.
   * 
   * @example
   * demo
   */
  description?: string;
  /**
   * @remarks
   * The name of the event bus. This parameter is required.
   * 
   * @example
   * MyEventBus
   */
  eventBusName?: string;
  static names(): { [key: string]: string } {
    return {
      description: 'description',
      eventBusName: 'eventBusName',
    };
  }

  static types(): { [key: string]: any } {
    return {
      description: 'string',
      eventBusName: 'string',
    };
  }

  constructor(map?: { [key: string]: any }) {
    super(map);
  }
}

export class CreateEventBusResponseBody extends $tea.Model {
  /**
   * @remarks
   * The returned response code. The value Success indicates that the request is successful. Other values indicate that the request failed. For more information about error codes, see Error codes.
   * 
   * @example
   * Success
   */
  code?: string;
  /**
   * @remarks
   * The name of the event bus. This parameter is required.
   * 
   * @example
   * MyEventBus
   */
  eventBusName?: string;
  /**
   * @remarks
   * The returned error message.
   * 
   * @example
   * The event bus [xxxx] not existed!
   */
  message?: string;
  /**
   * @remarks
   * The request ID.
   * 
   * @example
   * A995F07C-E503-5881-9962-9CECA8566876
   */
  requestId?: string;
  /**
   * @remarks
   * Indicates whether the request is successful. The value true indicates that the request is successful.
   * 
   * @example
   * true
   */
  success?: boolean;
  static names(): { [key: string]: string } {
    return {
      code: 'code',
      eventBusName: 'eventBusName',
      message: 'message',
      requestId: 'requestId',
      success: 'success',
    };
  }

  static types(): { [key: string]: any } {
    return {
      code: 'string',
      eventBusName: 'string',
      message: 'string',
      requestId: 'string',
      success: 'boolean',
    };
  }

  constructor(map?: { [key: string]: any }) {
    super(map);
  }
}

export class CreateEventBusResponse extends $tea.Model {
  headers?: { [key: string]: string };
  statusCode?: number;
  body?: CreateEventBusResponseBody;
  static names(): { [key: string]: string } {
    return {
      headers: 'headers',
      statusCode: 'statusCode',
      body: 'body',
    };
  }

  static types(): { [key: string]: any } {
    return {
      headers: { 'type': 'map', 'keyType': 'string', 'valueType': 'string' },
      statusCode: 'number',
      body: CreateEventBusResponseBody,
    };
  }

  constructor(map?: { [key: string]: any }) {
    super(map);
  }
}

export class GetEventBusRequest extends $tea.Model {
  /**
   * @remarks
   * The name of the event bus. This parameter is required.
   * 
   * @example
   * MyEventBus
   */
  eventBusName?: string;
  static names(): { [key: string]: string } {
    return {
      eventBusName: 'eventBusName',
    };
  }

  static types(): { [key: string]: any } {
    return {
      eventBusName: 'string',
    };
  }

  constructor(map?: { [key: string]: any }) {
    super(map);
  }
}

export class GetEventBusResponseBody extends $tea.Model {
  /**
   * @remarks
   * The response code. The value Success indicates that the request is successful.
   * 
   * @example
   * Success
   */
  code?: string;
  /**
   * @remarks
   * The timestamp that indicates when the event bus was created.
   * 
   * @example
   * 1641781825000
   */
  createTimestamp?: number;
  /**
   * @remarks
   * The description of the event bus.
   * 
   * @example
   * demo
   */
  description?: string;
  /**
   * @remarks
   * The name of the event bus.
   * 
   * @example
   * MyEventBus
   */
  eventBusName?: string;
  /**
   * @remarks
   * The error message that is returned if the request failed.
   * 
   * @example
   * EventBusNotExist
   */
  message?: string;
  /**
   * @remarks
   * The request ID.
   * 
   * @example
   * d5bfc188-4452-4ba7-b73a-a9005e522439
   */
  requestId?: string;
  static names(): { [key: string]: string } {
    return {
      code: 'code',
      createTimestamp: 'createTimestamp',
      description: 'description',
      eventBusName: 'eventBusName',
      message: 'message',
      requestId: 'requestId',
    };
  }

  static types(): { [key: string]: any } {
    return {
      code: 'string',
      createTimestamp: 'number',
      description: 'string',
      eventBusName: 'string',
      message: 'string',
      requestId: 'string',
    };
  }

  constructor(map?: { [key: string]: any }) {
    super(map);
  }
}

export class GetEventBusResponse extends $tea.Model {
  headers?: { [key: string]: string };
  statusCode?: number;
  body?: GetEventBusResponseBody;
  static names(): { [key: string]: string } {
    return {
      headers: 'headers',
      statusCode: 'statusCode',
      body: 'body',
    };
  }

  static types(): { [key: string]: any } {
    return {
      headers: { 'type': 'map', 'keyType': 'string', 'valueType': 'string' },
      statusCode: 'number',
      body: GetEventBusResponseBody,
    };
  }

  constructor(map?: { [key: string]: any }) {
    super(map);
  }
}

export class ListEventBusesRequest extends $tea.Model {
  /**
   * @remarks
   * The maximum number of entries to be returned in a call. You can use this parameter and NextToken to implement paging. Note: Up to 100 entries can be returned in a call.
   * 
   * @example
   * 10
   */
  maxResults?: number;
  /**
   * @remarks
   * If you set Limit and excess return values exist, this parameter is returned.
   * 
   * @example
   * 10
   */
  nextToken?: string;
  static names(): { [key: string]: string } {
    return {
      maxResults: 'maxResults',
      nextToken: 'nextToken',
    };
  }

  static types(): { [key: string]: any } {
    return {
      maxResults: 'number',
      nextToken: 'string',
    };
  }

  constructor(map?: { [key: string]: any }) {
    super(map);
  }
}

export class ListEventBusesResponseBody extends $tea.Model {
  /**
   * @remarks
   * The returned HTTP status code. The HTTP status code 200 indicates that the request is successful.
   * 
   * @example
   * 200
   */
  code?: string;
  /**
   * @remarks
   * The timestamp that indicates when the event bus was created.
   */
  eventBuses?: ListEventBusesResponseBodyEventBuses[];
  /**
   * @remarks
   * The returned error message.
   * 
   * @example
   * InvalidArgument
   */
  message?: string;
  /**
   * @remarks
   * The request ID.
   * 
   * @example
   * D1DCF64A-3F2C-5323-ADCB-3F4DF30FAD2D
   */
  requestId?: string;
  /**
   * @remarks
   * If excess return values exist, this parameter is returned.
   * 
   * @example
   * 10
   */
  nextToken?: string;
  /**
   * @remarks
   * The total number of entries.
   * 
   * @example
   * 2
   */
  total?: number;
  /**
   * @remarks
   * If you set Limit and excess return values exist, this parameter is returned.
   * 
   * @example
   * 10
   */
  maxResults?: number;
  static names(): { [key: string]: string } {
    return {
      code: 'code',
      eventBuses: 'eventBuses',
      message: 'message',
      requestId: 'requestId',
      nextToken: 'nextToken',
      total: 'total',
      maxResults: 'maxResults',
    };
  }

  static types(): { [key: string]: any } {
    return {
      code: 'string',
      eventBuses: { 'type': 'array', 'itemType': ListEventBusesResponseBodyEventBuses },
      message: 'string',
      requestId: 'string',
      nextToken: 'string',
      total: 'number',
      maxResults: 'number',
    };
  }

  constructor(map?: { [key: string]: any }) {
    super(map);
  }
}

export class ListEventBusesResponse extends $tea.Model {
  headers?: { [key: string]: string };
  statusCode?: number;
  body?: ListEventBusesResponseBody;
  static names(): { [key: string]: string } {
    return {
      headers: 'headers',
      statusCode: 'statusCode',
      body: 'body',
    };
  }

  static types(): { [key: string]: any } {
    return {
      headers: { 'type': 'map', 'keyType': 'string', 'valueType': 'string' },
      statusCode: 'number',
      body: ListEventBusesResponseBody,
    };
  }

  constructor(map?: { [key: string]: any }) {
    super(map);
  }
}

export class DeleteEventBusRequest extends $tea.Model {
  /**
   * @remarks
   * The name of the event bus. This parameter is required.
   * 
   * @example
   * MyEventBus
   */
  eventBusName?: string;
  static names(): { [key: string]: string } {
    return {
      eventBusName: 'eventBusName',
    };
  }

  static types(): { [key: string]: any } {
    return {
      eventBusName: 'string',
    };
  }

  constructor(map?: { [key: string]: any }) {
    super(map);
  }
}

export class DeleteEventBusResponseBody extends $tea.Model {
  /**
   * @remarks
   * The returned HTTP status code. The HTTP status code 200 indicates that the request is successful.
   * 
   * @example
   * 200
   */
  code?: string;
  /**
   * @remarks
   * The returned error message.
   * 
   * @example
   * EventBusNotExist
   */
  message?: string;
  /**
   * @remarks
   * The request ID.
   * 
   * @example
   * C229E140-1A5C-5D55-8904-CFC5BA4CAA98
   */
  requestId?: string;
  static names(): { [key: string]: string } {
    return {
      code: 'code',
      message: 'message',
      requestId: 'requestId',
    };
  }

  static types(): { [key: string]: any } {
    return {
      code: 'string',
      message: 'string',
      requestId: 'string',
    };
  }

  constructor(map?: { [key: string]: any }) {
    super(map);
  }
}

export class DeleteEventBusResponse extends $tea.Model {
  headers?: { [key: string]: string };
  statusCode?: number;
  body?: DeleteEventBusResponseBody;
  static names(): { [key: string]: string } {
    return {
      headers: 'headers',
      statusCode: 'statusCode',
      body: 'body',
    };
  }

  static types(): { [key: string]: any } {
    return {
      headers: { 'type': 'map', 'keyType': 'string', 'valueType': 'string' },
      statusCode: 'number',
      body: DeleteEventBusResponseBody,
    };
  }

  constructor(map?: { [key: string]: any }) {
    super(map);
  }
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
export class CreateApiDestinationRequest extends $tea.Model {
  /**
   * @remarks
   * The name of the API destination. The name must be 2 to 127 characters in length. This parameter is required.
   * 
   * @example
   * api-destination-name
   */
  apiDestinationName?: string;
  /**
   * @remarks
   * The name of the connection. The name must be 2 to 127 characters in length. Before you configure this parameter, you must call the CreateConnection operation to create a connection. Then, set this parameter to the name of the connection that you created. This parameter is required.
   * 
   * @example
   * connection-name
   */
  connectionName?: string;
  /**
   * @remarks
   * The description of the API destination. The description can be up to 255 characters in length.
   */
  description?: string;
  /**
   * @remarks
   * The parameters that are configured for the API destination. This parameter is required.
   */
  httpApiParameters?: CreateApiDestinationRequestHttpApiParameters;
  /**
   * @remarks
   * TODO
   */
  invocationRateLimitPerSecond?: number;
  static names(): { [key: string]: string } {
    return {
      apiDestinationName: 'apiDestinationName',
      connectionName: 'connectionName',
      description: 'description',
      httpApiParameters: 'httpApiParameters',
      invocationRateLimitPerSecond: 'invocationRateLimitPerSecond',
    };
  }

  static types(): { [key: string]: any } {
    return {
      apiDestinationName: 'string',
      connectionName: 'string',
      description: 'string',
      httpApiParameters: CreateApiDestinationRequestHttpApiParameters,
      invocationRateLimitPerSecond: 'number',
    };
  }

  constructor(map?: { [key: string]: any }) {
    super(map);
  }
}

export class CreateApiDestinationResponseBody extends $tea.Model {
  /**
   * @remarks
   * The returned response code. The value Success indicates that the request is successful.
   * 
   * @example
   * Success
   */
  code?: string;
  /**
   * @remarks
   * The name of the API destination.
   * 
   * @example
   * ApiDestinationName
   */
  apiDestinationName?: string;
  /**
   * @remarks
   * The returned message.
   * 
   * @example
   * success
   */
  message?: string;
  /**
   * @remarks
   * The request ID.
   * 
   * @example
   * 5DAF96FB-A4B6-548C-B999-0BFDCB2261B9
   */
  requestId?: string;
  static names(): { [key: string]: string } {
    return {
      code: 'code',
      apiDestinationName: 'apiDestinationName',
      message: 'message',
      requestId: 'requestId',
    };
  }

  static types(): { [key: string]: any } {
    return {
      code: 'string',
      apiDestinationName: 'string',
      message: 'string',
      requestId: 'string',
    };
  }

  constructor(map?: { [key: string]: any }) {
    super(map);
  }
}

export class CreateApiDestinationResponse extends $tea.Model {
  headers?: { [key: string]: string };
  statusCode?: number;
  body?: CreateApiDestinationResponseBody;
  static names(): { [key: string]: string } {
    return {
      headers: 'headers',
      statusCode: 'statusCode',
      body: 'body',
    };
  }

  static types(): { [key: string]: any } {
    return {
      headers: { 'type': 'map', 'keyType': 'string', 'valueType': 'string' },
      statusCode: 'number',
      body: CreateApiDestinationResponseBody,
    };
  }

  constructor(map?: { [key: string]: any }) {
    super(map);
  }
}

export class UpdateApiDestinationRequest extends $tea.Model {
  /**
   * @remarks
   * The name of the API destination. The name must be 2 to 127 characters in length. This parameter is required.
   * 
   * @example
   * api-destination-name
   */
  apiDestinationName?: string;
  /**
   * @remarks
   * The name of the connection. The name must be 2 to 127 characters in length. Before you configure this parameter, you must call the CreateConnection operation to create a connection. Then, set this parameter to the name of the connection that you created. This parameter is required.
   * 
   * @example
   * connection-name
   */
  connectionName?: string;
  /**
   * @remarks
   * The description of the API destination. The description can be up to 255 characters in length.
   */
  description?: string;
  /**
   * @remarks
   * The parameters that are configured for the API destination. This parameter is required.
   */
  httpApiParameters?: UpdateApiDestinationRequestHttpApiParameters;
  /**
   * @remarks
   * TODO
   */
  invocationRateLimitPerSecond?: number;
  static names(): { [key: string]: string } {
    return {
      apiDestinationName: 'apiDestinationName',
      connectionName: 'connectionName',
      description: 'description',
      httpApiParameters: 'httpApiParameters',
      invocationRateLimitPerSecond: 'invocationRateLimitPerSecond',
    };
  }

  static types(): { [key: string]: any } {
    return {
      apiDestinationName: 'string',
      connectionName: 'string',
      description: 'string',
      httpApiParameters: UpdateApiDestinationRequestHttpApiParameters,
      invocationRateLimitPerSecond: 'number',
    };
  }

  constructor(map?: { [key: string]: any }) {
    super(map);
  }
}

export class UpdateApiDestinationResponseBody extends $tea.Model {
  /**
   * @remarks
   * The returned response code. The value Success indicates that the request is successful.
   * 
   * @example
   * Success
   */
  code?: string;
  /**
   * @remarks
   * The returned message.
   * 
   * @example
   * success
   */
  message?: string;
  /**
   * @remarks
   * The request ID.
   * 
   * @example
   * 5DAF96FB-A4B6-548C-B999-0BFDCB2261B9
   */
  requestId?: string;
  static names(): { [key: string]: string } {
    return {
      code: 'code',
      message: 'message',
      requestId: 'requestId',
    };
  }

  static types(): { [key: string]: any } {
    return {
      code: 'string',
      message: 'string',
      requestId: 'string',
    };
  }

  constructor(map?: { [key: string]: any }) {
    super(map);
  }
}

export class UpdateApiDestinationResponse extends $tea.Model {
  headers?: { [key: string]: string };
  statusCode?: number;
  body?: UpdateApiDestinationResponseBody;
  static names(): { [key: string]: string } {
    return {
      headers: 'headers',
      statusCode: 'statusCode',
      body: 'body',
    };
  }

  static types(): { [key: string]: any } {
    return {
      headers: { 'type': 'map', 'keyType': 'string', 'valueType': 'string' },
      statusCode: 'number',
      body: UpdateApiDestinationResponseBody,
    };
  }

  constructor(map?: { [key: string]: any }) {
    super(map);
  }
}

export class GetApiDestinationRequest extends $tea.Model {
  /**
   * @remarks
   * The name of the API destination. This parameter is required.
   * 
   * @example
   * api-destination-name
   */
  apiDestinationName?: string;
  static names(): { [key: string]: string } {
    return {
      apiDestinationName: 'apiDestinationName',
    };
  }

  static types(): { [key: string]: any } {
    return {
      apiDestinationName: 'string',
    };
  }

  constructor(map?: { [key: string]: any }) {
    super(map);
  }
}

export class GetApiDestinationResponseBody extends $tea.Model {
  /**
   * @remarks
   * The returned response code. The value Success indicates that the request is successful.
   * 
   * @example
   * Success
   */
  code?: string;
  /**
   * @remarks
   * The name of the API destination.
   * 
   * @example
   * api-destination-2
   */
  apiDestinationName?: string;
  /**
   * @remarks
   * The connection name.
   * 
   * @example
   * connection-name
   */
  connectionName?: string;
  /**
   * @remarks
   * The description of the connection.
   * 
   * @example
   * demo
   */
  description?: string;
  /**
   * @remarks
   * The time when the API destination was created.
   * 
   * @example
   * 1665223213000
   */
  gmtCreate?: number;
  /**
   * @remarks
   * The request parameters that are configured for the API destination.
   */
  httpApiParameters?: GetApiDestinationResponseBodyHttpApiParameters;
  /**
   * @remarks
   * TODO
   */
  invocationRateLimitPerSecond?: number;
  /**
   * @remarks
   * The returned message. If the request is successful, success is returned. If the request failed, an error code is returned.
   * 
   * @example
   * success
   */
  message?: string;
  /**
   * @remarks
   * The request ID.
   * 
   * @example
   * B896B484-F16D-59DE-9E23-DD0E5C361108
   */
  requestId?: string;
  static names(): { [key: string]: string } {
    return {
      code: 'code',
      apiDestinationName: 'apiDestinationName',
      connectionName: 'connectionName',
      description: 'description',
      gmtCreate: 'gmtCreate',
      httpApiParameters: 'httpApiParameters',
      invocationRateLimitPerSecond: 'invocationRateLimitPerSecond',
      message: 'message',
      requestId: 'requestId',
    };
  }

  static types(): { [key: string]: any } {
    return {
      code: 'string',
      apiDestinationName: 'string',
      connectionName: 'string',
      description: 'string',
      gmtCreate: 'number',
      httpApiParameters: GetApiDestinationResponseBodyHttpApiParameters,
      invocationRateLimitPerSecond: 'number',
      message: 'string',
      requestId: 'string',
    };
  }

  constructor(map?: { [key: string]: any }) {
    super(map);
  }
}

export class GetApiDestinationResponse extends $tea.Model {
  headers?: { [key: string]: string };
  statusCode?: number;
  body?: GetApiDestinationResponseBody;
  static names(): { [key: string]: string } {
    return {
      headers: 'headers',
      statusCode: 'statusCode',
      body: 'body',
    };
  }

  static types(): { [key: string]: any } {
    return {
      headers: { 'type': 'map', 'keyType': 'string', 'valueType': 'string' },
      statusCode: 'number',
      body: GetApiDestinationResponseBody,
    };
  }

  constructor(map?: { [key: string]: any }) {
    super(map);
  }
}

export class DeleteApiDestinationRequest extends $tea.Model {
  /**
   * @remarks
   * The name of the API destination. This parameter is required.
   * 
   * @example
   * ApiDestinationName
   */
  apiDestinationName?: string;
  static names(): { [key: string]: string } {
    return {
      apiDestinationName: 'apiDestinationName',
    };
  }

  static types(): { [key: string]: any } {
    return {
      apiDestinationName: 'string',
    };
  }

  constructor(map?: { [key: string]: any }) {
    super(map);
  }
}

export class DeleteApiDestinationResponseBody extends $tea.Model {
  /**
   * @remarks
   * The returned response code. The value Success indicates that the request is successful.
   * 
   * @example
   * Success
   */
  code?: string;
  /**
   * @remarks
   * The returned message. If the request is successful, success is returned. If the request failed, an error code is returned.
   * 
   * @example
   * success
   */
  message?: string;
  /**
   * @remarks
   * The request ID.
   * 
   * @example
   * 382E6272-8E9C-5681-AC96-A8AF0BFAC1A5
   */
  requestId?: string;
  static names(): { [key: string]: string } {
    return {
      code: 'code',
      message: 'message',
      requestId: 'requestId',
    };
  }

  static types(): { [key: string]: any } {
    return {
      code: 'string',
      message: 'string',
      requestId: 'string',
    };
  }

  constructor(map?: { [key: string]: any }) {
    super(map);
  }
}

export class DeleteApiDestinationResponse extends $tea.Model {
  headers?: { [key: string]: string };
  statusCode?: number;
  body?: DeleteApiDestinationResponseBody;
  static names(): { [key: string]: string } {
    return {
      headers: 'headers',
      statusCode: 'statusCode',
      body: 'body',
    };
  }

  static types(): { [key: string]: any } {
    return {
      headers: { 'type': 'map', 'keyType': 'string', 'valueType': 'string' },
      statusCode: 'number',
      body: DeleteApiDestinationResponseBody,
    };
  }

  constructor(map?: { [key: string]: any }) {
    super(map);
  }
}

export class ListApiDestinationsRequest extends $tea.Model {
  /**
   * @remarks
   * The prefix of the API destination name.
   * 
   * @example
   * api-demo
   */
  apiDestinationNamePrefix?: string;
  /**
   * @remarks
   * The connection name.
   * 
   * @example
   * connection-name
   */
  connectionName?: string;
  /**
   * @remarks
   * The maximum number of entries to be returned in a call. You can use this parameter and NextToken to implement paging. 
   * 
   *     *   Default value: 10.
   * 
   * @example
   * 10
   */
  maxResults?: number;
  /**
   * @remarks
   * If you set Limit and excess return values exist, this parameter is returned.
   * 
   *     *   Default value: 0.
   * 
   * @example
   * 0
   */
  nextToken?: string;
  static names(): { [key: string]: string } {
    return {
      apiDestinationNamePrefix: 'apiDestinationNamePrefix',
      connectionName: 'connectionName',
      maxResults: 'maxResults',
      nextToken: 'nextToken',
    };
  }

  static types(): { [key: string]: any } {
    return {
      apiDestinationNamePrefix: 'string',
      connectionName: 'string',
      maxResults: 'number',
      nextToken: 'string',
    };
  }

  constructor(map?: { [key: string]: any }) {
    super(map);
  }
}

export class ListApiDestinationsResponseBody extends $tea.Model {
  /**
   * @remarks
   * The returned response code. The value Success indicates that the request is successful.
   * 
   * @example
   * Success
   */
  code?: string;
  /**
   * @remarks
   * The API destinations.
   */
  apiDestinations?: ListApiDestinationsResponseBodyApiDestinations[];
  /**
   * @remarks
   * The maximum number of entries returned per page.
   * 
   * @example
   * 10
   */
  maxResults?: number;
  /**
   * @remarks
   * If excess return values exist, this parameter is returned.
   * 
   * @example
   * 1
   */
  nextToken?: string;
  /**
   * @remarks
   * The total number of entries returned.
   * 
   * @example
   * 2
   */
  total?: number;
  /**
   * @remarks
   * The returned message. If the request is successful, success is returned. If the request failed, an error code is returned.
   * 
   * @example
   * success
   */
  message?: string;
  /**
   * @remarks
   * The request ID.
   * 
   * @example
   * 96D7C0AB-DCE5-5E82-96B8-4725E1706BB1
   */
  requestId?: string;
  static names(): { [key: string]: string } {
    return {
      code: 'code',
      apiDestinations: 'apiDestinations',
      maxResults: 'maxResults',
      nextToken: 'nextToken',
      total: 'total',
      message: 'message',
      requestId: 'requestId',
    };
  }

  static types(): { [key: string]: any } {
    return {
      code: 'string',
      apiDestinations: { 'type': 'array', 'itemType': ListApiDestinationsResponseBodyApiDestinations },
      maxResults: 'number',
      nextToken: 'string',
      total: 'number',
      message: 'string',
      requestId: 'string',
    };
  }

  constructor(map?: { [key: string]: any }) {
    super(map);
  }
}

export class ListApiDestinationsResponse extends $tea.Model {
  headers?: { [key: string]: string };
  statusCode?: number;
  body?: ListApiDestinationsResponseBody;
  static names(): { [key: string]: string } {
    return {
      headers: 'headers',
      statusCode: 'statusCode',
      body: 'body',
    };
  }

  static types(): { [key: string]: any } {
    return {
      headers: { 'type': 'map', 'keyType': 'string', 'valueType': 'string' },
      statusCode: 'number',
      body: ListApiDestinationsResponseBody,
    };
  }

  constructor(map?: { [key: string]: any }) {
    super(map);
  }
}

/**
 * @remarks
 * Connection Controller apis:
 * createConnection    *
 * deleteConnection    *
 * updateConnection    *
 * getConnection       *
 * selectOneConnection *
 * listConnections     *
 * listEnumsResponse   *
 */
export class CreateConnectionRequest extends $tea.Model {
  /**
   * @remarks
   * The parameters that are configured for authentication.
   */
  authParameters?: CreateConnectionRequestAuthParameters;
  /**
   * @remarks
   * The name of the connection. The name must be 2 to 127 characters in length.
   * 
   *     This parameter is required.
   * 
   * @example
   * connection-name
   */
  connectionName?: string;
  /**
   * @remarks
   * The description of the connection. The description can be up to 255 characters in length.
   * 
   * @example
   * demo
   */
  description?: string;
  /**
   * @remarks
   * The parameters that are configured for the network. This parameter is required.
   */
  networkParameters?: CreateConnectionRequestNetworkParameters;
  static names(): { [key: string]: string } {
    return {
      authParameters: 'authParameters',
      connectionName: 'connectionName',
      description: 'description',
      networkParameters: 'networkParameters',
    };
  }

  static types(): { [key: string]: any } {
    return {
      authParameters: CreateConnectionRequestAuthParameters,
      connectionName: 'string',
      description: 'string',
      networkParameters: CreateConnectionRequestNetworkParameters,
    };
  }

  constructor(map?: { [key: string]: any }) {
    super(map);
  }
}

export class CreateConnectionResponseBody extends $tea.Model {
  /**
   * @remarks
   * The returned response code. The value Success indicates that the request is successful.
   * 
   * @example
   * Success
   */
  code?: string;
  /**
   * @remarks
   * The connection name.
   * 
   * @example
   * connection-demo
   */
  connectionName?: string;
  /**
   * @remarks
   * The returned message. If the request is successful, success is returned. If the request failed, an error code is returned.
   * 
   * @example
   * success
   */
  message?: string;
  /**
   * @remarks
   * The request ID.
   * 
   * @example
   * 7DA60DED-CD36-5837-B848-C01A23D2****
   */
  requestId?: string;
  static names(): { [key: string]: string } {
    return {
      code: 'code',
      connectionName: 'connectionName',
      message: 'message',
      requestId: 'requestId',
    };
  }

  static types(): { [key: string]: any } {
    return {
      code: 'string',
      connectionName: 'string',
      message: 'string',
      requestId: 'string',
    };
  }

  constructor(map?: { [key: string]: any }) {
    super(map);
  }
}

export class CreateConnectionResponse extends $tea.Model {
  headers?: { [key: string]: string };
  statusCode?: number;
  body?: CreateConnectionResponseBody;
  static names(): { [key: string]: string } {
    return {
      headers: 'headers',
      statusCode: 'statusCode',
      body: 'body',
    };
  }

  static types(): { [key: string]: any } {
    return {
      headers: { 'type': 'map', 'keyType': 'string', 'valueType': 'string' },
      statusCode: 'number',
      body: CreateConnectionResponseBody,
    };
  }

  constructor(map?: { [key: string]: any }) {
    super(map);
  }
}

export class DeleteConnectionRequest extends $tea.Model {
  /**
   * @remarks
   * The name of the connection that you want to delete. This parameter is required.
   * 
   * @example
   * connection-name
   */
  connectionName?: string;
  static names(): { [key: string]: string } {
    return {
      connectionName: 'connectionName',
    };
  }

  static types(): { [key: string]: any } {
    return {
      connectionName: 'string',
    };
  }

  constructor(map?: { [key: string]: any }) {
    super(map);
  }
}

export class DeleteConnectionResponseBody extends $tea.Model {
  /**
   * @remarks
   * The returned response code. The value Success indicates that the request is successful.
   * 
   * @example
   * Success
   */
  code?: string;
  /**
   * @remarks
   * The returned message. If the request is successful, success is returned. If the request failed, an error code is returned.
   * 
   * @example
   * success
   */
  message?: string;
  /**
   * @remarks
   * The request ID.
   * 
   * @example
   * 8EF25E37-1750-5D7A-BA56-F8AE081A69C8
   */
  requestId?: string;
  static names(): { [key: string]: string } {
    return {
      code: 'code',
      message: 'message',
      requestId: 'requestId',
    };
  }

  static types(): { [key: string]: any } {
    return {
      code: 'string',
      message: 'string',
      requestId: 'string',
    };
  }

  constructor(map?: { [key: string]: any }) {
    super(map);
  }
}

export class DeleteConnectionResponse extends $tea.Model {
  headers?: { [key: string]: string };
  statusCode?: number;
  body?: DeleteConnectionResponseBody;
  static names(): { [key: string]: string } {
    return {
      headers: 'headers',
      statusCode: 'statusCode',
      body: 'body',
    };
  }

  static types(): { [key: string]: any } {
    return {
      headers: { 'type': 'map', 'keyType': 'string', 'valueType': 'string' },
      statusCode: 'number',
      body: DeleteConnectionResponseBody,
    };
  }

  constructor(map?: { [key: string]: any }) {
    super(map);
  }
}

export class UpdateConnectionRequest extends $tea.Model {
  /**
   * @remarks
   * The parameters that are configured for authentication.
   */
  authParameters?: UpdateConnectionRequestAuthParameters;
  /**
   * @remarks
   * The name of the connection. The name must be 2 to 127 characters in length.
   * 
   *     This parameter is required.
   * 
   * @example
   * connection-name
   */
  connectionName?: string;
  /**
   * @remarks
   * The description of the connection. The description can be up to 255 characters in length.
   * 
   * @example
   * demo
   */
  description?: string;
  /**
   * @remarks
   * The parameters that are configured for the network. This parameter is required.
   */
  networkParameters?: UpdateConnectionRequestNetworkParameters;
  static names(): { [key: string]: string } {
    return {
      authParameters: 'authParameters',
      connectionName: 'connectionName',
      description: 'description',
      networkParameters: 'networkParameters',
    };
  }

  static types(): { [key: string]: any } {
    return {
      authParameters: UpdateConnectionRequestAuthParameters,
      connectionName: 'string',
      description: 'string',
      networkParameters: UpdateConnectionRequestNetworkParameters,
    };
  }

  constructor(map?: { [key: string]: any }) {
    super(map);
  }
}

export class UpdateConnectionResponseBody extends $tea.Model {
  /**
   * @remarks
   * The returned response code.
   * 
   * @example
   * Success
   */
  code?: string;
  /**
   * @remarks
   * The returned message.
   * 
   * @example
   * success
   */
  message?: string;
  /**
   * @remarks
   * The request ID.
   * 
   * @example
   * 8346BE8F-40F3-533D-A0B8-1359C31BD5BA
   */
  requestId?: string;
  static names(): { [key: string]: string } {
    return {
      code: 'code',
      message: 'message',
      requestId: 'requestId',
    };
  }

  static types(): { [key: string]: any } {
    return {
      code: 'string',
      message: 'string',
      requestId: 'string',
    };
  }

  constructor(map?: { [key: string]: any }) {
    super(map);
  }
}

export class UpdateConnectionResponse extends $tea.Model {
  headers?: { [key: string]: string };
  statusCode?: number;
  body?: UpdateConnectionResponseBody;
  static names(): { [key: string]: string } {
    return {
      headers: 'headers',
      statusCode: 'statusCode',
      body: 'body',
    };
  }

  static types(): { [key: string]: any } {
    return {
      headers: { 'type': 'map', 'keyType': 'string', 'valueType': 'string' },
      statusCode: 'number',
      body: UpdateConnectionResponseBody,
    };
  }

  constructor(map?: { [key: string]: any }) {
    super(map);
  }
}

export class GetConnectionRequest extends $tea.Model {
  /**
   * @remarks
   * The connection name. This parameter is required.
   * 
   * @example
   * connection-name
   */
  connectionName?: string;
  static names(): { [key: string]: string } {
    return {
      connectionName: 'connectionName',
    };
  }

  static types(): { [key: string]: any } {
    return {
      connectionName: 'string',
    };
  }

  constructor(map?: { [key: string]: any }) {
    super(map);
  }
}

export class GetConnectionResponseBody extends $tea.Model {
  /**
   * @remarks
   * The returned response code. The value Success indicates that the request is successful.
   * 
   * @example
   * Success
   */
  code?: string;
  /**
   * @remarks
   * The value of the key in the request path.
   */
  connections?: GetConnectionResponseBodyConnections[];
  /**
   * @remarks
   * The returned message.
   * 
   * @example
   * success
   */
  message?: string;
  /**
   * @remarks
   * The returned request ID.
   * 
   * @example
   * 34AD682D-5B91-5773-8132-AA38C130****
   */
  requestId?: string;
  static names(): { [key: string]: string } {
    return {
      code: 'code',
      connections: 'connections',
      message: 'message',
      requestId: 'requestId',
    };
  }

  static types(): { [key: string]: any } {
    return {
      code: 'string',
      connections: { 'type': 'array', 'itemType': GetConnectionResponseBodyConnections },
      message: 'string',
      requestId: 'string',
    };
  }

  constructor(map?: { [key: string]: any }) {
    super(map);
  }
}

export class GetConnectionResponse extends $tea.Model {
  headers?: { [key: string]: string };
  statusCode?: number;
  body?: GetConnectionResponseBody;
  static names(): { [key: string]: string } {
    return {
      headers: 'headers',
      statusCode: 'statusCode',
      body: 'body',
    };
  }

  static types(): { [key: string]: any } {
    return {
      headers: { 'type': 'map', 'keyType': 'string', 'valueType': 'string' },
      statusCode: 'number',
      body: GetConnectionResponseBody,
    };
  }

  constructor(map?: { [key: string]: any }) {
    super(map);
  }
}

export class ListConnectionsRequest extends $tea.Model {
  /**
   * @remarks
   * The key word that you specify to query connections. Connections can be queried by prefixes.
   * 
   * @example
   * connection-name
   */
  connectionNamePrefix?: string;
  /**
   * @remarks
   * The maximum number of entries to be returned in a single call. You can use this parameter and the NextToken parameter to implement paging.
   * 
   *     *   Default value: 10.
   * 
   * @example
   * 10
   */
  maxResults?: number;
  /**
   * @remarks
   * If you set the Limit parameter and excess return values exist, this parameter is returned.
   * 
   *     *   Default value: 0.
   * 
   * @example
   * 0
   */
  nextToken?: string;
  static names(): { [key: string]: string } {
    return {
      connectionNamePrefix: 'connectionNamePrefix',
      maxResults: 'maxResults',
      nextToken: 'nextToken',
    };
  }

  static types(): { [key: string]: any } {
    return {
      connectionNamePrefix: 'string',
      maxResults: 'number',
      nextToken: 'string',
    };
  }

  constructor(map?: { [key: string]: any }) {
    super(map);
  }
}

export class ListConnectionsResponseBody extends $tea.Model {
  /**
   * @remarks
   * The HTTP status code. The value Success indicates that the request is successful.
   * 
   * @example
   * Success
   */
  code?: string;
  /**
   * @remarks
   * The value of the key in the request path.
   */
  connections?: ListConnectionsResponseBodyConnections[];
  /**
   * @remarks
   * The number of entries returned per page.
   * 
   * @example
   * 10
   */
  maxResults?: number;
  /**
   * @remarks
   * If excess return values exist, this parameter is returned.
   * 
   * @example
   * 0
   */
  nextToken?: string;
  /**
   * @remarks
   * The total number of entries returned.
   * 
   * @example
   * 1
   */
  total?: number;
  /**
   * @remarks
   * The message returned.
   * 
   * @example
   * success
   */
  message?: string;
  /**
   * @remarks
   * The ID of the request. This parameter is a common parameter. Each request has a unique ID. You can use the ID to troubleshoot issues.
   * 
   * @example
   * E3619976-8714-5D88-BBA2-6983D798A8BB
   */
  requestId?: string;
  static names(): { [key: string]: string } {
    return {
      code: 'code',
      connections: 'connections',
      maxResults: 'maxResults',
      nextToken: 'nextToken',
      total: 'total',
      message: 'message',
      requestId: 'requestId',
    };
  }

  static types(): { [key: string]: any } {
    return {
      code: 'string',
      connections: { 'type': 'array', 'itemType': ListConnectionsResponseBodyConnections },
      maxResults: 'number',
      nextToken: 'string',
      total: 'number',
      message: 'string',
      requestId: 'string',
    };
  }

  constructor(map?: { [key: string]: any }) {
    super(map);
  }
}

export class ListConnectionsResponse extends $tea.Model {
  headers?: { [key: string]: string };
  statusCode?: number;
  body?: ListConnectionsResponseBody;
  static names(): { [key: string]: string } {
    return {
      headers: 'headers',
      statusCode: 'statusCode',
      body: 'body',
    };
  }

  static types(): { [key: string]: any } {
    return {
      headers: { 'type': 'map', 'keyType': 'string', 'valueType': 'string' },
      statusCode: 'number',
      body: ListConnectionsResponseBody,
    };
  }

  constructor(map?: { [key: string]: any }) {
    super(map);
  }
}

// enum AuthorizationTypeEnums : string {
//   API_KEY_AUTH(name="API_KEY_AUTH", value="API_KEY_AUTH"),
//   BASIC_AUTH(name="BASIC_AUTH", value="BASIC_AUTH"),
//   OAUTH_AUTH(name="OAUTH_AUTH", value="OAUTH_AUTH"),
// }
// enum NetworkTypeEnum : string {
//   PUBLIC_NETWORK(name="PUBLIC_NETWORK", value="PublicNetwork"),
//   PRIVATE_NETWORK(name="PRIVATE_NETWORK", value="PrivateNetwork")
// }
export class ListEnumsResponseResponseBody extends $tea.Model {
  authorizationTypeEnums?: string;
  networkTypeEnums?: string;
  /**
   * @remarks
   * The returned response code.
   * 
   * @example
   * Success
   */
  code?: string;
  /**
   * @remarks
   * The returned message.
   * 
   * @example
   * success
   */
  message?: string;
  /**
   * @remarks
   * The request ID.
   * 
   * @example
   * 8346BE8F-40F3-533D-A0B8-1359C31BD5BA
   */
  requestId?: string;
  static names(): { [key: string]: string } {
    return {
      authorizationTypeEnums: 'authorizationTypeEnums',
      networkTypeEnums: 'networkTypeEnums',
      code: 'code',
      message: 'message',
      requestId: 'requestId',
    };
  }

  static types(): { [key: string]: any } {
    return {
      authorizationTypeEnums: 'string',
      networkTypeEnums: 'string',
      code: 'string',
      message: 'string',
      requestId: 'string',
    };
  }

  constructor(map?: { [key: string]: any }) {
    super(map);
  }
}

export class ListEnumsResponseResponse extends $tea.Model {
  headers?: { [key: string]: string };
  statusCode?: number;
  body?: UpdateConnectionResponseBody;
  static names(): { [key: string]: string } {
    return {
      headers: 'headers',
      statusCode: 'statusCode',
      body: 'body',
    };
  }

  static types(): { [key: string]: any } {
    return {
      headers: { 'type': 'map', 'keyType': 'string', 'valueType': 'string' },
      statusCode: 'number',
      body: UpdateConnectionResponseBody,
    };
  }

  constructor(map?: { [key: string]: any }) {
    super(map);
  }
}

/**
 * @remarks
 * EventData Controller apis:
 * putEvents
 */
export class PutEventsRequest extends $tea.Model {
  /**
   * @remarks
   * The name of the event bus.
   * This parameter is required.
   * 
   * @example
   * demo
   */
  eventBusName?: string;
  /**
   * @remarks
   * The content of the event.
   * 
   * @example
   * The description of the event.
   */
  event?: string;
  static names(): { [key: string]: string } {
    return {
      eventBusName: 'eventBusName',
      event: 'event',
    };
  }

  static types(): { [key: string]: any } {
    return {
      eventBusName: 'string',
      event: 'string',
    };
  }

  constructor(map?: { [key: string]: any }) {
    super(map);
  }
}

export class PutEventsResponseBody extends $tea.Model {
  failedEntryCount?: number;
  entryList?: PutEventsResponseBodyEntryList[];
  /**
   * @remarks
   * The status code returned. The status code 200 indicates that the request was successful.
   * 
   * @example
   * 200
   */
  code?: string;
  /**
   * @remarks
   * The error message that is returned if the request failed.
   * 
   * @example
   * EventBusNotExist
   */
  message?: string;
  /**
   * @remarks
   * The request ID.
   * 
   * @example
   * 580A938B-6107-586C-8EC7-F22EEBEDA9E6
   */
  requestId?: string;
  static names(): { [key: string]: string } {
    return {
      failedEntryCount: 'failedEntryCount',
      entryList: 'entryList',
      code: 'code',
      message: 'message',
      requestId: 'requestId',
    };
  }

  static types(): { [key: string]: any } {
    return {
      failedEntryCount: 'number',
      entryList: { 'type': 'array', 'itemType': PutEventsResponseBodyEntryList },
      code: 'string',
      message: 'string',
      requestId: 'string',
    };
  }

  constructor(map?: { [key: string]: any }) {
    super(map);
  }
}

export class PutEventsResponse extends $tea.Model {
  headers?: { [key: string]: string };
  statusCode?: number;
  body?: PutEventsResponseBody;
  static names(): { [key: string]: string } {
    return {
      headers: 'headers',
      statusCode: 'statusCode',
      body: 'body',
    };
  }

  static types(): { [key: string]: any } {
    return {
      headers: { 'type': 'map', 'keyType': 'string', 'valueType': 'string' },
      statusCode: 'number',
      body: PutEventsResponseBody,
    };
  }

  constructor(map?: { [key: string]: any }) {
    super(map);
  }
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
export class CreateEventRuleRequest extends $tea.Model {
  /**
   * @remarks
   * The name of the event bus with which the event source is associated.
   * This parameter is required.
   * 
   * @example
   * my-event-bus
   */
  eventBusName?: string;
  /**
   * @remarks
   * The name of the event rule.
   * This parameter is required.
   * 
   * @example
   * myrabbitmq.sourc
   */
  eventRuleName?: string;
  description?: string;
  /**
   * @remarks
   * The event pattern, in JSON format. Valid values: stringEqual and stringExpression. You can specify up to five expressions in the map data structure in each field.
   * 
   *     You can specify up to five expressions in the map data structure in each field.
   * 
   * @example
   * {\"source\": [{\"prefix\": \"acs.\"}],\"type\": [{\"prefix\":\"oss:ObjectReplication\"}],\"subject\":[{\"prefix\":\"acs:oss:cn-hangzhou:123456789098****:my-movie-bucket/\", \"suffix\":\".txt\"}]}
   */
  filterPattern?: string;
  static names(): { [key: string]: string } {
    return {
      eventBusName: 'eventBusName',
      eventRuleName: 'eventRuleName',
      description: 'description',
      filterPattern: 'filterPattern',
    };
  }

  static types(): { [key: string]: any } {
    return {
      eventBusName: 'string',
      eventRuleName: 'string',
      description: 'string',
      filterPattern: 'string',
    };
  }

  constructor(map?: { [key: string]: any }) {
    super(map);
  }
}

export class CreateEventRuleResponseBody extends $tea.Model {
  /**
   * @remarks
   * The returned response code. Valid values:
   * 
   *     *   Success: The request is successful.
   * 
   *     *   Other codes: The request failed. For more information about error codes, see Error codes.
   * 
   * @example
   * Success
   */
  code?: string;
  /**
   * @remarks
   * The name of the event rule.
   * 
   * @example
   * myrabbitmq.sourc
   */
  eventRuleName?: string;
  /**
   * @remarks
   * The returned error message.
   * 
   * @example
   * Remote error. requestId: [A8EFABD2-95B9-1C46-9E01-xxxx], error code: [CreateRelatedResourceFailed], message: [Create related resource failed, EntityNotExist.Role : The role not exists: xxxx. \\r\\nRequestId : xxxx-168C-54ED-8FEB-BF11CB70AEB7]
   */
  message?: string;
  /**
   * @remarks
   * The request ID.
   * 
   * @example
   * 2922208e-e1c6-43ee-bfd1-aca50263bc8a
   */
  requestId?: string;
  static names(): { [key: string]: string } {
    return {
      code: 'code',
      eventRuleName: 'eventRuleName',
      message: 'message',
      requestId: 'requestId',
    };
  }

  static types(): { [key: string]: any } {
    return {
      code: 'string',
      eventRuleName: 'string',
      message: 'string',
      requestId: 'string',
    };
  }

  constructor(map?: { [key: string]: any }) {
    super(map);
  }
}

export class CreateEventRuleResponse extends $tea.Model {
  headers?: { [key: string]: string };
  statusCode?: number;
  body?: CreateEventRuleResponseBody;
  static names(): { [key: string]: string } {
    return {
      headers: 'headers',
      statusCode: 'statusCode',
      body: 'body',
    };
  }

  static types(): { [key: string]: any } {
    return {
      headers: { 'type': 'map', 'keyType': 'string', 'valueType': 'string' },
      statusCode: 'number',
      body: CreateEventRuleResponseBody,
    };
  }

  constructor(map?: { [key: string]: any }) {
    super(map);
  }
}

export class GetEventRuleRequest extends $tea.Model {
  /**
   * @remarks
   * The name of the event bus with which the event source is associated.
   * This parameter is required.
   * 
   * @example
   * my-event-bus
   */
  eventBusName?: string;
  /**
   * @remarks
   * The name of the event rule.
   * This parameter is required.
   * 
   * @example
   * myrabbitmq.sourc
   */
  eventRuleName?: string;
  static names(): { [key: string]: string } {
    return {
      eventBusName: 'eventBusName',
      eventRuleName: 'eventRuleName',
    };
  }

  static types(): { [key: string]: any } {
    return {
      eventBusName: 'string',
      eventRuleName: 'string',
    };
  }

  constructor(map?: { [key: string]: any }) {
    super(map);
  }
}

export class GetEventRuleResponseBody extends $tea.Model {
  /**
   * @remarks
   * The returned response code. Valid values:
   * 
   *     *   Success: The request is successful.
   * 
   *     *   Other codes: The request failed. For more information about error codes, see Error codes.
   * 
   * @example
   * Success
   */
  code?: string;
  /**
   * @remarks
   * The name of the event bus with which the event source is associated.
   * This parameter is required.
   * 
   * @example
   * my-event-bus
   */
  eventBusName?: string;
  /**
   * @remarks
   * The name of the event rule.
   * This parameter is required.
   * 
   * @example
   * myrabbitmq.sourc
   */
  eventRuleName?: string;
  description?: string;
  /**
   * @remarks
   * The event pattern, in JSON format. Valid values: stringEqual and stringExpression. You can specify up to five expressions in the map data structure in each field.
   * 
   *     You can specify up to five expressions in the map data structure in each field.
   * 
   * @example
   * {\"source\": [{\"prefix\": \"acs.\"}],\"type\": [{\"prefix\":\"oss:ObjectReplication\"}],\"subject\":[{\"prefix\":\"acs:oss:cn-hangzhou:123456789098****:my-movie-bucket/\", \"suffix\":\".txt\"}]}
   */
  filterPattern?: string;
  /**
   * @remarks
   * The status of the event rule. Valid values: ENABLE (default): The event rule is enabled. DISABLE: The event rule is disabled.
   * 
   * @example
   * ENABLE
   */
  status?: string;
  gmtCreate?: string;
  gmtModify?: string;
  eventTargets?: GetEventRuleResponseBodyEventTargets[];
  /**
   * @remarks
   * The returned error message.
   * 
   * @example
   * Remote error. requestId: [A8EFABD2-95B9-1C46-9E01-xxxx], error code: [CreateRelatedResourceFailed], message: [Create related resource failed, EntityNotExist.Role : The role not exists: xxxx. \\r\\nRequestId : xxxx-168C-54ED-8FEB-BF11CB70AEB7]
   */
  message?: string;
  /**
   * @remarks
   * The request ID.
   * 
   * @example
   * 2922208e-e1c6-43ee-bfd1-aca50263bc8a
   */
  requestId?: string;
  static names(): { [key: string]: string } {
    return {
      code: 'code',
      eventBusName: 'eventBusName',
      eventRuleName: 'eventRuleName',
      description: 'description',
      filterPattern: 'filterPattern',
      status: 'status',
      gmtCreate: 'gmtCreate',
      gmtModify: 'gmtModify',
      eventTargets: 'eventTargets',
      message: 'message',
      requestId: 'requestId',
    };
  }

  static types(): { [key: string]: any } {
    return {
      code: 'string',
      eventBusName: 'string',
      eventRuleName: 'string',
      description: 'string',
      filterPattern: 'string',
      status: 'string',
      gmtCreate: 'string',
      gmtModify: 'string',
      eventTargets: { 'type': 'array', 'itemType': GetEventRuleResponseBodyEventTargets },
      message: 'string',
      requestId: 'string',
    };
  }

  constructor(map?: { [key: string]: any }) {
    super(map);
  }
}

export class GetEventRuleResponse extends $tea.Model {
  headers?: { [key: string]: string };
  statusCode?: number;
  body?: GetEventRuleResponseBody;
  static names(): { [key: string]: string } {
    return {
      headers: 'headers',
      statusCode: 'statusCode',
      body: 'body',
    };
  }

  static types(): { [key: string]: any } {
    return {
      headers: { 'type': 'map', 'keyType': 'string', 'valueType': 'string' },
      statusCode: 'number',
      body: GetEventRuleResponseBody,
    };
  }

  constructor(map?: { [key: string]: any }) {
    super(map);
  }
}

export class DeleteEventRuleRequest extends $tea.Model {
  /**
   * @remarks
   * The name of the event bus with which the event source is associated.
   * This parameter is required.
   * 
   * @example
   * my-event-bus
   */
  eventBusName?: string;
  /**
   * @remarks
   * The name of the event rule.
   * This parameter is required.
   * 
   * @example
   * myrabbitmq.sourc
   */
  eventRuleName?: string;
  static names(): { [key: string]: string } {
    return {
      eventBusName: 'eventBusName',
      eventRuleName: 'eventRuleName',
    };
  }

  static types(): { [key: string]: any } {
    return {
      eventBusName: 'string',
      eventRuleName: 'string',
    };
  }

  constructor(map?: { [key: string]: any }) {
    super(map);
  }
}

export class DeleteEventRuleResponseBody extends $tea.Model {
  /**
   * @remarks
   * The returned response code. Valid values:
   * 
   *     *   Success: The request is successful.
   * 
   *     *   Other codes: The request failed. For more information about error codes, see Error codes.
   * 
   * @example
   * Success
   */
  code?: string;
  /**
   * @remarks
   * The returned error message.
   * 
   * @example
   * Remote error. requestId: [A8EFABD2-95B9-1C46-9E01-xxxx], error code: [CreateRelatedResourceFailed], message: [Create related resource failed, EntityNotExist.Role : The role not exists: xxxx. \\r\\nRequestId : xxxx-168C-54ED-8FEB-BF11CB70AEB7]
   */
  message?: string;
  /**
   * @remarks
   * The request ID.
   * 
   * @example
   * 2922208e-e1c6-43ee-bfd1-aca50263bc8a
   */
  requestId?: string;
  static names(): { [key: string]: string } {
    return {
      code: 'code',
      message: 'message',
      requestId: 'requestId',
    };
  }

  static types(): { [key: string]: any } {
    return {
      code: 'string',
      message: 'string',
      requestId: 'string',
    };
  }

  constructor(map?: { [key: string]: any }) {
    super(map);
  }
}

export class DeleteEventRuleResponse extends $tea.Model {
  headers?: { [key: string]: string };
  statusCode?: number;
  body?: DeleteEventRuleResponseBody;
  static names(): { [key: string]: string } {
    return {
      headers: 'headers',
      statusCode: 'statusCode',
      body: 'body',
    };
  }

  static types(): { [key: string]: any } {
    return {
      headers: { 'type': 'map', 'keyType': 'string', 'valueType': 'string' },
      statusCode: 'number',
      body: DeleteEventRuleResponseBody,
    };
  }

  constructor(map?: { [key: string]: any }) {
    super(map);
  }
}

export class UpdateEventRuleRequest extends $tea.Model {
  /**
   * @remarks
   * The name of the event bus with which the event source is associated.
   * This parameter is required.
   * 
   * @example
   * my-event-bus
   */
  eventBusName?: string;
  /**
   * @remarks
   * The name of the event rule.
   * This parameter is required.
   * 
   * @example
   * myrabbitmq.sourc
   */
  eventRuleName?: string;
  description?: string;
  /**
   * @remarks
   * The event pattern, in JSON format. Valid values: stringEqual and stringExpression. You can specify up to five expressions in the map data structure in each field.
   * 
   *     You can specify up to five expressions in the map data structure in each field.
   * This parameter is required.
   * 
   * @example
   * {\"source\": [{\"prefix\": \"acs.\"}],\"type\": [{\"prefix\":\"oss:ObjectReplication\"}],\"subject\":[{\"prefix\":\"acs:oss:cn-hangzhou:123456789098****:my-movie-bucket/\", \"suffix\":\".txt\"}]}
   */
  filterPattern?: string;
  static names(): { [key: string]: string } {
    return {
      eventBusName: 'eventBusName',
      eventRuleName: 'eventRuleName',
      description: 'description',
      filterPattern: 'filterPattern',
    };
  }

  static types(): { [key: string]: any } {
    return {
      eventBusName: 'string',
      eventRuleName: 'string',
      description: 'string',
      filterPattern: 'string',
    };
  }

  constructor(map?: { [key: string]: any }) {
    super(map);
  }
}

export class UpdateEventRuleResponseBody extends $tea.Model {
  /**
   * @remarks
   * The returned response code. Valid values:
   * 
   *     *   Success: The request is successful.
   * 
   *     *   Other codes: The request failed. For more information about error codes, see Error codes.
   * 
   * @example
   * Success
   */
  code?: string;
  /**
   * @remarks
   * The returned error message.
   * 
   * @example
   * Remote error. requestId: [A8EFABD2-95B9-1C46-9E01-xxxx], error code: [CreateRelatedResourceFailed], message: [Create related resource failed, EntityNotExist.Role : The role not exists: xxxx. \\r\\nRequestId : xxxx-168C-54ED-8FEB-BF11CB70AEB7]
   */
  message?: string;
  /**
   * @remarks
   * The request ID.
   * 
   * @example
   * 2922208e-e1c6-43ee-bfd1-aca50263bc8a
   */
  requestId?: string;
  static names(): { [key: string]: string } {
    return {
      code: 'code',
      message: 'message',
      requestId: 'requestId',
    };
  }

  static types(): { [key: string]: any } {
    return {
      code: 'string',
      message: 'string',
      requestId: 'string',
    };
  }

  constructor(map?: { [key: string]: any }) {
    super(map);
  }
}

export class UpdateEventRuleResponse extends $tea.Model {
  headers?: { [key: string]: string };
  statusCode?: number;
  body?: UpdateEventRuleResponseBody;
  static names(): { [key: string]: string } {
    return {
      headers: 'headers',
      statusCode: 'statusCode',
      body: 'body',
    };
  }

  static types(): { [key: string]: any } {
    return {
      headers: { 'type': 'map', 'keyType': 'string', 'valueType': 'string' },
      statusCode: 'number',
      body: UpdateEventRuleResponseBody,
    };
  }

  constructor(map?: { [key: string]: any }) {
    super(map);
  }
}

export class ListEventRulesRequest extends $tea.Model {
  eventBusName?: string;
  /**
   * @remarks
   * The number of entries returned per page.
   * 
   * @example
   * 10
   */
  maxResults?: number;
  /**
   * @remarks
   * If excess return values exist, this parameter is returned.
   * 
   * @example
   * 0
   */
  nextToken?: string;
  static names(): { [key: string]: string } {
    return {
      eventBusName: 'eventBusName',
      maxResults: 'maxResults',
      nextToken: 'nextToken',
    };
  }

  static types(): { [key: string]: any } {
    return {
      eventBusName: 'string',
      maxResults: 'number',
      nextToken: 'string',
    };
  }

  constructor(map?: { [key: string]: any }) {
    super(map);
  }
}

export class ListEventRulesResponseBody extends $tea.Model {
  eventRules?: ListEventRulesResponseBodyEventRules[];
  /**
   * @remarks
   * The total number of entries.
   * 
   * @example
   * 2
   */
  total?: number;
  /**
   * @remarks
   * The number of entries returned per page.
   * 
   * @example
   * 10
   */
  maxResults?: number;
  /**
   * @remarks
   * If excess return values exist, this parameter is returned.
   * 
   * @example
   * 0
   */
  nextToken?: string;
  static names(): { [key: string]: string } {
    return {
      eventRules: 'eventRules',
      total: 'total',
      maxResults: 'maxResults',
      nextToken: 'nextToken',
    };
  }

  static types(): { [key: string]: any } {
    return {
      eventRules: { 'type': 'array', 'itemType': ListEventRulesResponseBodyEventRules },
      total: 'number',
      maxResults: 'number',
      nextToken: 'string',
    };
  }

  constructor(map?: { [key: string]: any }) {
    super(map);
  }
}

export class ListEventRulesResponse extends $tea.Model {
  headers?: { [key: string]: string };
  statusCode?: number;
  body?: ListEventRulesResponseBody;
  static names(): { [key: string]: string } {
    return {
      headers: 'headers',
      statusCode: 'statusCode',
      body: 'body',
    };
  }

  static types(): { [key: string]: any } {
    return {
      headers: { 'type': 'map', 'keyType': 'string', 'valueType': 'string' },
      statusCode: 'number',
      body: ListEventRulesResponseBody,
    };
  }

  constructor(map?: { [key: string]: any }) {
    super(map);
  }
}

export class EnableEventRuleRequest extends $tea.Model {
  /**
   * @remarks
   * The name of the event bus with which the event source is associated.
   * This parameter is required.
   * 
   * @example
   * my-event-bus
   */
  eventBusName?: string;
  /**
   * @remarks
   * The name of the event rule.
   * This parameter is required.
   * 
   * @example
   * myrabbitmq.sourc
   */
  eventRuleName?: string;
  static names(): { [key: string]: string } {
    return {
      eventBusName: 'eventBusName',
      eventRuleName: 'eventRuleName',
    };
  }

  static types(): { [key: string]: any } {
    return {
      eventBusName: 'string',
      eventRuleName: 'string',
    };
  }

  constructor(map?: { [key: string]: any }) {
    super(map);
  }
}

export class EnableEventRuleResponseBody extends $tea.Model {
  /**
   * @remarks
   * The returned response code. Valid values:
   * 
   *     *   Success: The request is successful.
   * 
   *     *   Other codes: The request failed. For more information about error codes, see Error codes.
   * 
   * @example
   * Success
   */
  code?: string;
  /**
   * @remarks
   * The returned error message.
   * 
   * @example
   * Remote error. requestId: [A8EFABD2-95B9-1C46-9E01-xxxx], error code: [CreateRelatedResourceFailed], message: [Create related resource failed, EntityNotExist.Role : The role not exists: xxxx. \\r\\nRequestId : xxxx-168C-54ED-8FEB-BF11CB70AEB7]
   */
  message?: string;
  /**
   * @remarks
   * The request ID.
   * 
   * @example
   * 2922208e-e1c6-43ee-bfd1-aca50263bc8a
   */
  requestId?: string;
  static names(): { [key: string]: string } {
    return {
      code: 'code',
      message: 'message',
      requestId: 'requestId',
    };
  }

  static types(): { [key: string]: any } {
    return {
      code: 'string',
      message: 'string',
      requestId: 'string',
    };
  }

  constructor(map?: { [key: string]: any }) {
    super(map);
  }
}

export class EnableEventRuleResponse extends $tea.Model {
  headers?: { [key: string]: string };
  statusCode?: number;
  body?: EnableEventRuleResponseBody;
  static names(): { [key: string]: string } {
    return {
      headers: 'headers',
      statusCode: 'statusCode',
      body: 'body',
    };
  }

  static types(): { [key: string]: any } {
    return {
      headers: { 'type': 'map', 'keyType': 'string', 'valueType': 'string' },
      statusCode: 'number',
      body: EnableEventRuleResponseBody,
    };
  }

  constructor(map?: { [key: string]: any }) {
    super(map);
  }
}

export class DisableEventRuleRequest extends $tea.Model {
  /**
   * @remarks
   * The name of the event bus with which the event source is associated.
   * This parameter is required.
   * 
   * @example
   * my-event-bus
   */
  eventBusName?: string;
  /**
   * @remarks
   * The name of the event rule.
   * This parameter is required.
   * 
   * @example
   * myrabbitmq.sourc
   */
  eventRuleName?: string;
  static names(): { [key: string]: string } {
    return {
      eventBusName: 'eventBusName',
      eventRuleName: 'eventRuleName',
    };
  }

  static types(): { [key: string]: any } {
    return {
      eventBusName: 'string',
      eventRuleName: 'string',
    };
  }

  constructor(map?: { [key: string]: any }) {
    super(map);
  }
}

export class DisableEventRuleResponseBody extends $tea.Model {
  /**
   * @remarks
   * The returned response code. Valid values:
   * 
   *     *   Success: The request is successful.
   * 
   *     *   Other codes: The request failed. For more information about error codes, see Error codes.
   * 
   * @example
   * Success
   */
  code?: string;
  /**
   * @remarks
   * The returned error message.
   * 
   * @example
   * Remote error. requestId: [A8EFABD2-95B9-1C46-9E01-xxxx], error code: [CreateRelatedResourceFailed], message: [Create related resource failed, EntityNotExist.Role : The role not exists: xxxx. \\r\\nRequestId : xxxx-168C-54ED-8FEB-BF11CB70AEB7]
   */
  message?: string;
  /**
   * @remarks
   * The request ID.
   * 
   * @example
   * 2922208e-e1c6-43ee-bfd1-aca50263bc8a
   */
  requestId?: string;
  static names(): { [key: string]: string } {
    return {
      code: 'code',
      message: 'message',
      requestId: 'requestId',
    };
  }

  static types(): { [key: string]: any } {
    return {
      code: 'string',
      message: 'string',
      requestId: 'string',
    };
  }

  constructor(map?: { [key: string]: any }) {
    super(map);
  }
}

export class DisableEventRuleResponse extends $tea.Model {
  headers?: { [key: string]: string };
  statusCode?: number;
  body?: DisableEventRuleResponseBody;
  static names(): { [key: string]: string } {
    return {
      headers: 'headers',
      statusCode: 'statusCode',
      body: 'body',
    };
  }

  static types(): { [key: string]: any } {
    return {
      headers: { 'type': 'map', 'keyType': 'string', 'valueType': 'string' },
      statusCode: 'number',
      body: DisableEventRuleResponseBody,
    };
  }

  constructor(map?: { [key: string]: any }) {
    super(map);
  }
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
export class CreateEventSourceRequest extends $tea.Model {
  /**
   * @remarks
   * The description of the event source.
   */
  description?: string;
  /**
   * @remarks
   * The name of the event bus with which the event source is associated.
   * This parameter is required.
   * 
   * @example
   * my-event-bus
   */
  eventBusName?: string;
  /**
   * @remarks
   * The name of the event source.
   * This parameter is required.
   * 
   * @example
   * myrabbitmq.sourc
   */
  eventSourceName?: string;
  className?: string;
  config?: { [key: string]: any };
  static names(): { [key: string]: string } {
    return {
      description: 'description',
      eventBusName: 'eventBusName',
      eventSourceName: 'eventSourceName',
      className: 'className',
      config: 'config',
    };
  }

  static types(): { [key: string]: any } {
    return {
      description: 'string',
      eventBusName: 'string',
      eventSourceName: 'string',
      className: 'string',
      config: { 'type': 'map', 'keyType': 'string', 'valueType': 'any' },
    };
  }

  constructor(map?: { [key: string]: any }) {
    super(map);
  }
}

export class CreateEventSourceResponseBody extends $tea.Model {
  /**
   * @remarks
   * The returned response code. Valid values:
   * 
   *     *   Success: The request is successful.
   * 
   *     *   Other codes: The request failed. For more information about error codes, see Error codes.
   * 
   * @example
   * Success
   */
  code?: string;
  /**
   * @remarks
   * The name of the event source.
   * 
   * @example
   * myrabbitmq.sourc
   */
  eventSourceName?: string;
  /**
   * @remarks
   * The returned error message.
   * 
   * @example
   * Remote error. requestId: [A8EFABD2-95B9-1C46-9E01-xxxx], error code: [CreateRelatedResourceFailed], message: [Create related resource failed, EntityNotExist.Role : The role not exists: xxxx. \\r\\nRequestId : xxxx-168C-54ED-8FEB-BF11CB70AEB7]
   */
  message?: string;
  /**
   * @remarks
   * The request ID.
   * 
   * @example
   * 2922208e-e1c6-43ee-bfd1-aca50263bc8a
   */
  requestId?: string;
  static names(): { [key: string]: string } {
    return {
      code: 'code',
      eventSourceName: 'eventSourceName',
      message: 'message',
      requestId: 'requestId',
    };
  }

  static types(): { [key: string]: any } {
    return {
      code: 'string',
      eventSourceName: 'string',
      message: 'string',
      requestId: 'string',
    };
  }

  constructor(map?: { [key: string]: any }) {
    super(map);
  }
}

export class CreateEventSourceResponse extends $tea.Model {
  headers?: { [key: string]: string };
  statusCode?: number;
  body?: CreateEventSourceResponseBody;
  static names(): { [key: string]: string } {
    return {
      headers: 'headers',
      statusCode: 'statusCode',
      body: 'body',
    };
  }

  static types(): { [key: string]: any } {
    return {
      headers: { 'type': 'map', 'keyType': 'string', 'valueType': 'string' },
      statusCode: 'number',
      body: CreateEventSourceResponseBody,
    };
  }

  constructor(map?: { [key: string]: any }) {
    super(map);
  }
}

export class UpdateEventSourceRequest extends $tea.Model {
  /**
   * @remarks
   * The name of the event bus with which the event source is associated.
   * This parameter is required.
   * 
   * @example
   * my-event-bus
   */
  eventBusName?: string;
  /**
   * @remarks
   * The name of the event source.
   * This parameter is required.
   * 
   * @example
   * myrabbitmq.sourc
   */
  eventSourceName?: string;
  /**
   * @remarks
   * The description of the event source.
   */
  description?: string;
  className?: string;
  status?: number;
  config?: { [key: string]: any };
  static names(): { [key: string]: string } {
    return {
      eventBusName: 'eventBusName',
      eventSourceName: 'eventSourceName',
      description: 'description',
      className: 'className',
      status: 'status',
      config: 'config',
    };
  }

  static types(): { [key: string]: any } {
    return {
      eventBusName: 'string',
      eventSourceName: 'string',
      description: 'string',
      className: 'string',
      status: 'number',
      config: { 'type': 'map', 'keyType': 'string', 'valueType': 'any' },
    };
  }

  constructor(map?: { [key: string]: any }) {
    super(map);
  }
}

export class UpdateEventSourceResponseBody extends $tea.Model {
  /**
   * @remarks
   * The returned response code. Valid values:
   * 
   *     *   Success: The request is successful.
   * 
   *     *   Other codes: The request failed. For more information about error codes, see Error codes.
   * 
   * @example
   * Success
   */
  code?: string;
  /**
   * @remarks
   * The returned error message.
   * 
   * @example
   * Remote error. requestId: [A8EFABD2-95B9-1C46-9E01-xxxx], error code: [CreateRelatedResourceFailed], message: [Create related resource failed, EntityNotExist.Role : The role not exists: xxxx. \\r\\nRequestId : xxxx-168C-54ED-8FEB-BF11CB70AEB7]
   */
  message?: string;
  /**
   * @remarks
   * The request ID.
   * 
   * @example
   * 2922208e-e1c6-43ee-bfd1-aca50263bc8a
   */
  requestId?: string;
  static names(): { [key: string]: string } {
    return {
      code: 'code',
      message: 'message',
      requestId: 'requestId',
    };
  }

  static types(): { [key: string]: any } {
    return {
      code: 'string',
      message: 'string',
      requestId: 'string',
    };
  }

  constructor(map?: { [key: string]: any }) {
    super(map);
  }
}

export class UpdateEventSourceResponse extends $tea.Model {
  headers?: { [key: string]: string };
  statusCode?: number;
  body?: UpdateEventSourceResponseBody;
  static names(): { [key: string]: string } {
    return {
      headers: 'headers',
      statusCode: 'statusCode',
      body: 'body',
    };
  }

  static types(): { [key: string]: any } {
    return {
      headers: { 'type': 'map', 'keyType': 'string', 'valueType': 'string' },
      statusCode: 'number',
      body: UpdateEventSourceResponseBody,
    };
  }

  constructor(map?: { [key: string]: any }) {
    super(map);
  }
}

export class DeleteEventSourceRequest extends $tea.Model {
  eventBusName?: string;
  /**
   * @remarks
   * The name of the event source.
   * This parameter is required.
   * 
   * @example
   * myrabbitmq.source
   */
  eventSourceName?: string;
  static names(): { [key: string]: string } {
    return {
      eventBusName: 'eventBusName',
      eventSourceName: 'eventSourceName',
    };
  }

  static types(): { [key: string]: any } {
    return {
      eventBusName: 'string',
      eventSourceName: 'string',
    };
  }

  constructor(map?: { [key: string]: any }) {
    super(map);
  }
}

export class DeleteEventSourceResponseBody extends $tea.Model {
  /**
   * @remarks
   * The returned response code. The value Success indicates that the request is successful. Other values indicate that the request failed. For more information about error codes, see Error codes.
   * 
   * @example
   * Success
   */
  code?: string;
  /**
   * @remarks
   * The returned error message.
   * 
   * @example
   * Remote error. requestId: [78B66E68-E778-1F33-84BD-xxxx], error code: [EventSourceNotExist], message: [The event source in request is not exist! ]
   */
  message?: string;
  /**
   * @remarks
   * The request ID.
   * 
   * @example
   * 5f80e9b3-98d5-4f51-8412-c758818a03e4
   */
  requestId?: string;
  static names(): { [key: string]: string } {
    return {
      code: 'code',
      message: 'message',
      requestId: 'requestId',
    };
  }

  static types(): { [key: string]: any } {
    return {
      code: 'string',
      message: 'string',
      requestId: 'string',
    };
  }

  constructor(map?: { [key: string]: any }) {
    super(map);
  }
}

export class DeleteEventSourceResponse extends $tea.Model {
  headers?: { [key: string]: string };
  statusCode?: number;
  body?: DeleteEventSourceResponseBody;
  static names(): { [key: string]: string } {
    return {
      headers: 'headers',
      statusCode: 'statusCode',
      body: 'body',
    };
  }

  static types(): { [key: string]: any } {
    return {
      headers: { 'type': 'map', 'keyType': 'string', 'valueType': 'string' },
      statusCode: 'number',
      body: DeleteEventSourceResponseBody,
    };
  }

  constructor(map?: { [key: string]: any }) {
    super(map);
  }
}

export class GetEventSourceRequest extends $tea.Model {
  eventBusName?: string;
  /**
   * @remarks
   * The name of the event source.
   * This parameter is required.
   * 
   * @example
   * myrabbitmq.source
   */
  eventSourceName?: string;
  static names(): { [key: string]: string } {
    return {
      eventBusName: 'eventBusName',
      eventSourceName: 'eventSourceName',
    };
  }

  static types(): { [key: string]: any } {
    return {
      eventBusName: 'string',
      eventSourceName: 'string',
    };
  }

  constructor(map?: { [key: string]: any }) {
    super(map);
  }
}

export class GetEventSourceResponseBody extends $tea.Model {
  /**
   * @remarks
   * The name of the event bus with which the event source is associated.
   * This parameter is required.
   * 
   * @example
   * my-event-bus
   */
  eventBusName?: string;
  /**
   * @remarks
   * The name of the event source.
   * This parameter is required.
   * 
   * @example
   * myrabbitmq.sourc
   */
  eventSourceName?: string;
  /**
   * @remarks
   * The description of the event source.
   */
  description?: string;
  className?: string;
  config?: { [key: string]: any };
  static names(): { [key: string]: string } {
    return {
      eventBusName: 'eventBusName',
      eventSourceName: 'eventSourceName',
      description: 'description',
      className: 'className',
      config: 'config',
    };
  }

  static types(): { [key: string]: any } {
    return {
      eventBusName: 'string',
      eventSourceName: 'string',
      description: 'string',
      className: 'string',
      config: { 'type': 'map', 'keyType': 'string', 'valueType': 'any' },
    };
  }

  constructor(map?: { [key: string]: any }) {
    super(map);
  }
}

export class GetEventSourceResponse extends $tea.Model {
  headers?: { [key: string]: string };
  statusCode?: number;
  body?: GetEventSourceResponseBody;
  static names(): { [key: string]: string } {
    return {
      headers: 'headers',
      statusCode: 'statusCode',
      body: 'body',
    };
  }

  static types(): { [key: string]: any } {
    return {
      headers: { 'type': 'map', 'keyType': 'string', 'valueType': 'string' },
      statusCode: 'number',
      body: GetEventSourceResponseBody,
    };
  }

  constructor(map?: { [key: string]: any }) {
    super(map);
  }
}

export class ListEventSourcesRequest extends $tea.Model {
  eventBusName?: string;
  /**
   * @remarks
   * The type of the event source.
   * This parameter is required.
   * 
   * @example
   * USER_DEFINED
   */
  eventSourceType?: string;
  /**
   * @remarks
   * The number of entries returned per page.
   * 
   * @example
   * 10
   */
  maxResults?: number;
  /**
   * @remarks
   * If excess return values exist, this parameter is returned.
   * 
   * @example
   * 0
   */
  nextToken?: string;
  static names(): { [key: string]: string } {
    return {
      eventBusName: 'eventBusName',
      eventSourceType: 'eventSourceType',
      maxResults: 'maxResults',
      nextToken: 'nextToken',
    };
  }

  static types(): { [key: string]: any } {
    return {
      eventBusName: 'string',
      eventSourceType: 'string',
      maxResults: 'number',
      nextToken: 'string',
    };
  }

  constructor(map?: { [key: string]: any }) {
    super(map);
  }
}

export class ListEventSourcesResponseBody extends $tea.Model {
  eventSources?: ListEventSourcesResponseBodyEventSources[];
  /**
   * @remarks
   * The total number of entries.
   * 
   * @example
   * 2
   */
  total?: number;
  /**
   * @remarks
   * The number of entries returned per page.
   * 
   * @example
   * 10
   */
  maxResults?: number;
  /**
   * @remarks
   * If excess return values exist, this parameter is returned.
   * 
   * @example
   * 0
   */
  nextToken?: string;
  static names(): { [key: string]: string } {
    return {
      eventSources: 'eventSources',
      total: 'total',
      maxResults: 'maxResults',
      nextToken: 'nextToken',
    };
  }

  static types(): { [key: string]: any } {
    return {
      eventSources: { 'type': 'array', 'itemType': ListEventSourcesResponseBodyEventSources },
      total: 'number',
      maxResults: 'number',
      nextToken: 'string',
    };
  }

  constructor(map?: { [key: string]: any }) {
    super(map);
  }
}

export class ListEventSourcesResponse extends $tea.Model {
  headers?: { [key: string]: string };
  statusCode?: number;
  body?: ListEventSourcesResponseBody;
  static names(): { [key: string]: string } {
    return {
      headers: 'headers',
      statusCode: 'statusCode',
      body: 'body',
    };
  }

  static types(): { [key: string]: any } {
    return {
      headers: { 'type': 'map', 'keyType': 'string', 'valueType': 'string' },
      statusCode: 'number',
      body: ListEventSourcesResponseBody,
    };
  }

  constructor(map?: { [key: string]: any }) {
    super(map);
  }
}

/**
 * @remarks
 * EventTarget Controller apis:
 * createEventTargets *
 * updateEventTargets *
 * deleteEventTargets *
 * listEventTargets   *
 */
export class EventTarget extends $tea.Model {
  eventTargetName?: string;
  className?: string;
  config?: { [key: string]: any };
  runOptions?: EventTargetRunOptions;
  static names(): { [key: string]: string } {
    return {
      eventTargetName: 'eventTargetName',
      className: 'className',
      config: 'config',
      runOptions: 'runOptions',
    };
  }

  static types(): { [key: string]: any } {
    return {
      eventTargetName: 'string',
      className: 'string',
      config: { 'type': 'map', 'keyType': 'string', 'valueType': 'any' },
      runOptions: EventTargetRunOptions,
    };
  }

  constructor(map?: { [key: string]: any }) {
    super(map);
  }
}

export class CreateEventTargetsRequest extends $tea.Model {
  /**
   * @remarks
   * The name of the event bus with which the event target is associated.
   * This parameter is required.
   * 
   * @example
   * my-event-bus
   */
  eventBusName?: string;
  /**
   * @remarks
   * The name of the event rule.
   * This parameter is required.
   * 
   * @example
   * myrabbitmq.sourc
   */
  eventRuleName?: string;
  eventTargets?: EventTarget[];
  static names(): { [key: string]: string } {
    return {
      eventBusName: 'eventBusName',
      eventRuleName: 'eventRuleName',
      eventTargets: 'eventTargets',
    };
  }

  static types(): { [key: string]: any } {
    return {
      eventBusName: 'string',
      eventRuleName: 'string',
      eventTargets: { 'type': 'array', 'itemType': EventTarget },
    };
  }

  constructor(map?: { [key: string]: any }) {
    super(map);
  }
}

export class CreateEventTargetsResponseBody extends $tea.Model {
  /**
   * @remarks
   * The returned response code. Valid values:
   * 
   *     *   Success: The request is successful.
   * 
   *     *   Other codes: The request failed. For more information about error codes, see Error codes.
   * 
   * @example
   * Success
   */
  code?: string;
  /**
   * @remarks
   * The returned error message.
   * 
   * @example
   * Remote error. requestId: [A8EFABD2-95B9-1C46-9E01-xxxx], error code: [CreateRelatedResourceFailed], message: [Create related resource failed, EntityNotExist.Role : The role not exists: xxxx. \\r\\nRequestId : xxxx-168C-54ED-8FEB-BF11CB70AEB7]
   */
  message?: string;
  /**
   * @remarks
   * The request ID.
   * 
   * @example
   * 2922208e-e1c6-43ee-bfd1-aca50263bc8a
   */
  requestId?: string;
  static names(): { [key: string]: string } {
    return {
      code: 'code',
      message: 'message',
      requestId: 'requestId',
    };
  }

  static types(): { [key: string]: any } {
    return {
      code: 'string',
      message: 'string',
      requestId: 'string',
    };
  }

  constructor(map?: { [key: string]: any }) {
    super(map);
  }
}

export class CreateEventTargetsResponse extends $tea.Model {
  headers?: { [key: string]: string };
  statusCode?: number;
  body?: CreateEventTargetsResponseBody;
  static names(): { [key: string]: string } {
    return {
      headers: 'headers',
      statusCode: 'statusCode',
      body: 'body',
    };
  }

  static types(): { [key: string]: any } {
    return {
      headers: { 'type': 'map', 'keyType': 'string', 'valueType': 'string' },
      statusCode: 'number',
      body: CreateEventTargetsResponseBody,
    };
  }

  constructor(map?: { [key: string]: any }) {
    super(map);
  }
}

export class UpdateEventTargetsRequest extends $tea.Model {
  /**
   * @remarks
   * The name of the event bus with which the event target is associated.
   * This parameter is required.
   * 
   * @example
   * my-event-bus
   */
  eventBusName?: string;
  /**
   * @remarks
   * The name of the event rule.
   * This parameter is required.
   * 
   * @example
   * myrabbitmq.sourc
   */
  eventRuleName?: string;
  eventTargets?: EventTarget[];
  static names(): { [key: string]: string } {
    return {
      eventBusName: 'eventBusName',
      eventRuleName: 'eventRuleName',
      eventTargets: 'eventTargets',
    };
  }

  static types(): { [key: string]: any } {
    return {
      eventBusName: 'string',
      eventRuleName: 'string',
      eventTargets: { 'type': 'array', 'itemType': EventTarget },
    };
  }

  constructor(map?: { [key: string]: any }) {
    super(map);
  }
}

export class UpdateEventTargetsResponseBody extends $tea.Model {
  /**
   * @remarks
   * The returned response code. Valid values:
   * 
   *     *   Success: The request is successful.
   * 
   *     *   Other codes: The request failed. For more information about error codes, see Error codes.
   * 
   * @example
   * Success
   */
  code?: string;
  /**
   * @remarks
   * The returned error message.
   * 
   * @example
   * Remote error. requestId: [A8EFABD2-95B9-1C46-9E01-xxxx], error code: [CreateRelatedResourceFailed], message: [Create related resource failed, EntityNotExist.Role : The role not exists: xxxx. \\r\\nRequestId : xxxx-168C-54ED-8FEB-BF11CB70AEB7]
   */
  message?: string;
  /**
   * @remarks
   * The request ID.
   * 
   * @example
   * 2922208e-e1c6-43ee-bfd1-aca50263bc8a
   */
  requestId?: string;
  static names(): { [key: string]: string } {
    return {
      code: 'code',
      message: 'message',
      requestId: 'requestId',
    };
  }

  static types(): { [key: string]: any } {
    return {
      code: 'string',
      message: 'string',
      requestId: 'string',
    };
  }

  constructor(map?: { [key: string]: any }) {
    super(map);
  }
}

export class UpdateEventTargetsResponse extends $tea.Model {
  headers?: { [key: string]: string };
  statusCode?: number;
  body?: UpdateEventTargetsResponseBody;
  static names(): { [key: string]: string } {
    return {
      headers: 'headers',
      statusCode: 'statusCode',
      body: 'body',
    };
  }

  static types(): { [key: string]: any } {
    return {
      headers: { 'type': 'map', 'keyType': 'string', 'valueType': 'string' },
      statusCode: 'number',
      body: UpdateEventTargetsResponseBody,
    };
  }

  constructor(map?: { [key: string]: any }) {
    super(map);
  }
}

export class DeleteEventTargetsRequest extends $tea.Model {
  /**
   * @remarks
   * The name of the event bus.
   * 
   * @example
   * MyEventBus
   */
  eventBusName: string;
  /**
   * @remarks
   * The name of the event rule.
   * 
   * @example
   * ramrolechange-mns
   */
  eventRuleName: string;
  /**
   * @remarks
   * The names of the event targets that you want to delete.
   */
  eventTargetNames?: string[];
  static names(): { [key: string]: string } {
    return {
      eventBusName: 'eventBusName',
      eventRuleName: 'eventRuleName',
      eventTargetNames: 'eventTargetNames',
    };
  }

  static types(): { [key: string]: any } {
    return {
      eventBusName: 'string',
      eventRuleName: 'string',
      eventTargetNames: { 'type': 'array', 'itemType': 'string' },
    };
  }

  constructor(map?: { [key: string]: any }) {
    super(map);
  }
}

export class DeleteEventTargetsResponseBody extends $tea.Model {
  /**
   * @remarks
   * The returned response code. Valid values:
   * 
   *     *   Success: The request is successful.
   * 
   *     *   Other codes: The request failed. For more information about error codes, see Error codes.
   * 
   * @example
   * Success
   */
  code?: string;
  /**
   * @remarks
   * The returned error message.
   * 
   * @example
   * Remote error. requestId: [A8EFABD2-95B9-1C46-9E01-xxxx], error code: [CreateRelatedResourceFailed], message: [Create related resource failed, EntityNotExist.Role : The role not exists: xxxx. \\r\\nRequestId : xxxx-168C-54ED-8FEB-BF11CB70AEB7]
   */
  message?: string;
  /**
   * @remarks
   * The request ID.
   * 
   * @example
   * 2922208e-e1c6-43ee-bfd1-aca50263bc8a
   */
  requestId?: string;
  static names(): { [key: string]: string } {
    return {
      code: 'code',
      message: 'message',
      requestId: 'requestId',
    };
  }

  static types(): { [key: string]: any } {
    return {
      code: 'string',
      message: 'string',
      requestId: 'string',
    };
  }

  constructor(map?: { [key: string]: any }) {
    super(map);
  }
}

export class DeleteEventTargetsResponse extends $tea.Model {
  headers?: { [key: string]: string };
  statusCode?: number;
  body?: DeleteEventTargetsResponseBody;
  static names(): { [key: string]: string } {
    return {
      headers: 'headers',
      statusCode: 'statusCode',
      body: 'body',
    };
  }

  static types(): { [key: string]: any } {
    return {
      headers: { 'type': 'map', 'keyType': 'string', 'valueType': 'string' },
      statusCode: 'number',
      body: DeleteEventTargetsResponseBody,
    };
  }

  constructor(map?: { [key: string]: any }) {
    super(map);
  }
}

export class ListEventTargetsRequest extends $tea.Model {
  /**
   * @remarks
   * The name of the event bus with which the event target is associated.
   * This parameter is required.
   * 
   * @example
   * my-event-bus
   */
  eventBusName?: string;
  /**
   * @remarks
   * The name of the event rule.
   * This parameter is required.
   * 
   * @example
   * myrabbitmq.sourc
   */
  eventRuleName?: string;
  static names(): { [key: string]: string } {
    return {
      eventBusName: 'eventBusName',
      eventRuleName: 'eventRuleName',
    };
  }

  static types(): { [key: string]: any } {
    return {
      eventBusName: 'string',
      eventRuleName: 'string',
    };
  }

  constructor(map?: { [key: string]: any }) {
    super(map);
  }
}

export class ListEventTargetsResponseBody extends $tea.Model {
  /**
   * @remarks
   * The name of the event bus with which the event target is associated.
   * This parameter is required.
   * 
   * @example
   * my-event-bus
   */
  eventBusName?: string;
  /**
   * @remarks
   * The name of the event rule.
   * This parameter is required.
   * 
   * @example
   * myrabbitmq.sourc
   */
  eventRuleName?: string;
  eventTargets?: ListEventTargetsResponseBodyEventTargets[];
  static names(): { [key: string]: string } {
    return {
      eventBusName: 'eventBusName',
      eventRuleName: 'eventRuleName',
      eventTargets: 'eventTargets',
    };
  }

  static types(): { [key: string]: any } {
    return {
      eventBusName: 'string',
      eventRuleName: 'string',
      eventTargets: { 'type': 'array', 'itemType': ListEventTargetsResponseBodyEventTargets },
    };
  }

  constructor(map?: { [key: string]: any }) {
    super(map);
  }
}

export class ListEventTargetsResponse extends $tea.Model {
  headers?: { [key: string]: string };
  statusCode?: number;
  body?: ListEventTargetsResponseBody;
  static names(): { [key: string]: string } {
    return {
      headers: 'headers',
      statusCode: 'statusCode',
      body: 'body',
    };
  }

  static types(): { [key: string]: any } {
    return {
      headers: { 'type': 'map', 'keyType': 'string', 'valueType': 'string' },
      statusCode: 'number',
      body: ListEventTargetsResponseBody,
    };
  }

  constructor(map?: { [key: string]: any }) {
    super(map);
  }
}

/**
 * @remarks
 * EventType Controller apis:
 * listEventTypes *
 */
export class ListEventTypesRequest extends $tea.Model {
  /**
   * @remarks
   * The name of the event bus.
   * This parameter is required.
   * 
   * @example
   * demo
   */
  eventBusName?: string;
  /**
   * @remarks
   * EventSource is required for querying default bus events.
   * 
   * @example
   * testEventSourceName
   */
  eventSourceName?: string;
  /**
   * @remarks
   * The number of entries returned per page.
   * 
   * @example
   * 10
   */
  maxResults?: number;
  /**
   * @remarks
   * If excess return values exist, this parameter is returned.
   * 
   * @example
   * 0
   */
  nextToken?: string;
  static names(): { [key: string]: string } {
    return {
      eventBusName: 'eventBusName',
      eventSourceName: 'eventSourceName',
      maxResults: 'maxResults',
      nextToken: 'nextToken',
    };
  }

  static types(): { [key: string]: any } {
    return {
      eventBusName: 'string',
      eventSourceName: 'string',
      maxResults: 'number',
      nextToken: 'string',
    };
  }

  constructor(map?: { [key: string]: any }) {
    super(map);
  }
}

export class ListEventTypesResponseBody extends $tea.Model {
  eventTypes?: ListEventTypesResponseBodyEventTypes[];
  /**
   * @remarks
   * If excess return values exist, this parameter is returned.
   * 
   * @example
   * 10
   */
  nextToken?: string;
  /**
   * @remarks
   * The total number of entries.
   * 
   * @example
   * 2
   */
  total?: number;
  /**
   * @remarks
   * If you set Limit and excess return values exist, this parameter is returned.
   * 
   * @example
   * 10
   */
  maxResults?: number;
  /**
   * @remarks
   * The status code returned. The status code 200 indicates that the request was successful.
   * 
   * @example
   * 200
   */
  code?: string;
  /**
   * @remarks
   * The error message that is returned if the request failed.
   * 
   * @example
   * EventBusNotExist
   */
  message?: string;
  /**
   * @remarks
   * The request ID.
   * 
   * @example
   * 580A938B-6107-586C-8EC7-F22EEBEDA9E6
   */
  requestId?: string;
  static names(): { [key: string]: string } {
    return {
      eventTypes: 'eventTypes',
      nextToken: 'nextToken',
      total: 'total',
      maxResults: 'maxResults',
      code: 'code',
      message: 'message',
      requestId: 'requestId',
    };
  }

  static types(): { [key: string]: any } {
    return {
      eventTypes: { 'type': 'array', 'itemType': ListEventTypesResponseBodyEventTypes },
      nextToken: 'string',
      total: 'number',
      maxResults: 'number',
      code: 'string',
      message: 'string',
      requestId: 'string',
    };
  }

  constructor(map?: { [key: string]: any }) {
    super(map);
  }
}

export class ListEventTypesResponse extends $tea.Model {
  headers?: { [key: string]: string };
  statusCode?: number;
  body?: ListEventTypesResponseBody;
  static names(): { [key: string]: string } {
    return {
      headers: 'headers',
      statusCode: 'statusCode',
      body: 'body',
    };
  }

  static types(): { [key: string]: any } {
    return {
      headers: { 'type': 'map', 'keyType': 'string', 'valueType': 'string' },
      statusCode: 'number',
      body: ListEventTypesResponseBody,
    };
  }

  constructor(map?: { [key: string]: any }) {
    super(map);
  }
}

export class ListEventBusesResponseBodyEventBuses extends $tea.Model {
  /**
   * @remarks
   * The description of the queried event bus.
   * 
   * @example
   * bus_description
   */
  description?: string;
  /**
   * @remarks
   * The name of the queried event bus.
   * 
   * @example
   * default
   */
  eventBusName?: string;
  static names(): { [key: string]: string } {
    return {
      description: 'description',
      eventBusName: 'eventBusName',
    };
  }

  static types(): { [key: string]: any } {
    return {
      description: 'string',
      eventBusName: 'string',
    };
  }

  constructor(map?: { [key: string]: any }) {
    super(map);
  }
}

export class CreateApiDestinationRequestHttpApiParametersApiParameters extends $tea.Model {
  name?: string;
  /**
   * @remarks
   * The description of the API destination. The description can be up to 255 characters in length.
   */
  description?: string;
  type?: string;
  defaultValue?: string;
  in?: string;
  static names(): { [key: string]: string } {
    return {
      name: 'name',
      description: 'description',
      type: 'type',
      defaultValue: 'defaultValue',
      in: 'in',
    };
  }

  static types(): { [key: string]: any } {
    return {
      name: 'string',
      description: 'string',
      type: 'string',
      defaultValue: 'string',
      in: 'string',
    };
  }

  constructor(map?: { [key: string]: any }) {
    super(map);
  }
}

export class CreateApiDestinationRequestHttpApiParameters extends $tea.Model {
  /**
   * @remarks
   * The endpoint of the API destination. The endpoint can be up to 127 characters in length. This parameter is required.
   * 
   * @example
   * http://127.0.0.1:8001/api
   */
  endpoint?: string;
  /**
   * @remarks
   * The HTTP request method. Valid values: 
   * 
   * 
   *       *   GET 
   * 
   *       *   POST 
   * 
   *       *   HEAD 
   * 
   *       *   DELETE 
   * 
   *       *   PUT 
   * 
   *       *   PATCH 
   * 
   * 
   *       This parameter is required.
   * 
   * @example
   * POST
   */
  method?: string;
  /**
   * @remarks
   * TODO
   */
  apiParameters?: CreateApiDestinationRequestHttpApiParametersApiParameters[];
  static names(): { [key: string]: string } {
    return {
      endpoint: 'endpoint',
      method: 'method',
      apiParameters: 'apiParameters',
    };
  }

  static types(): { [key: string]: any } {
    return {
      endpoint: 'string',
      method: 'string',
      apiParameters: { 'type': 'array', 'itemType': CreateApiDestinationRequestHttpApiParametersApiParameters },
    };
  }

  constructor(map?: { [key: string]: any }) {
    super(map);
  }
}

export class UpdateApiDestinationRequestHttpApiParametersApiParameters extends $tea.Model {
  name?: string;
  /**
   * @remarks
   * The description of the API destination. The description can be up to 255 characters in length.
   */
  description?: string;
  type?: string;
  defaultValue?: string;
  in?: string;
  static names(): { [key: string]: string } {
    return {
      name: 'name',
      description: 'description',
      type: 'type',
      defaultValue: 'defaultValue',
      in: 'in',
    };
  }

  static types(): { [key: string]: any } {
    return {
      name: 'string',
      description: 'string',
      type: 'string',
      defaultValue: 'string',
      in: 'string',
    };
  }

  constructor(map?: { [key: string]: any }) {
    super(map);
  }
}

export class UpdateApiDestinationRequestHttpApiParameters extends $tea.Model {
  /**
   * @remarks
   * The endpoint of the API destination. The endpoint can be up to 127 characters in length. This parameter is required.
   * 
   * @example
   * http://127.0.0.1:8001/api
   */
  endpoint?: string;
  /**
   * @remarks
   * The HTTP request method. Valid values: 
   * 
   * 
   *       *   GET 
   * 
   *       *   POST 
   * 
   *       *   HEAD 
   * 
   *       *   DELETE 
   * 
   *       *   PUT 
   * 
   *       *   PATCH 
   * 
   * 
   *       This parameter is required.
   * 
   * @example
   * POST
   */
  method?: string;
  /**
   * @remarks
   * TODO
   */
  apiParameters?: UpdateApiDestinationRequestHttpApiParametersApiParameters[];
  static names(): { [key: string]: string } {
    return {
      endpoint: 'endpoint',
      method: 'method',
      apiParameters: 'apiParameters',
    };
  }

  static types(): { [key: string]: any } {
    return {
      endpoint: 'string',
      method: 'string',
      apiParameters: { 'type': 'array', 'itemType': UpdateApiDestinationRequestHttpApiParametersApiParameters },
    };
  }

  constructor(map?: { [key: string]: any }) {
    super(map);
  }
}

export class GetApiDestinationResponseBodyHttpApiParametersApiParameters extends $tea.Model {
  name?: string;
  /**
   * @remarks
   * The description of the API destination. The description can be up to 255 characters in length.
   */
  description?: string;
  type?: string;
  defaultValue?: string;
  in?: string;
  static names(): { [key: string]: string } {
    return {
      name: 'name',
      description: 'description',
      type: 'type',
      defaultValue: 'defaultValue',
      in: 'in',
    };
  }

  static types(): { [key: string]: any } {
    return {
      name: 'string',
      description: 'string',
      type: 'string',
      defaultValue: 'string',
      in: 'string',
    };
  }

  constructor(map?: { [key: string]: any }) {
    super(map);
  }
}

export class GetApiDestinationResponseBodyHttpApiParameters extends $tea.Model {
  /**
   * @remarks
   * The endpoint of the API destination.
   * 
   * @example
   * http://127.0.0.1:8001/api
   */
  endpoint?: string;
  /**
   * @remarks
   * The HTTP request method. Valid values:
   * 
   *       - POST
   * 
   *       - GET
   * 
   *       - DELETE
   * 
   *       - PUT
   * 
   *       - HEAD
   * 
   *       - TRACE
   * 
   *       - PATCH
   * 
   * @example
   * POST
   */
  method?: string;
  /**
   * @remarks
   * TODO
   */
  apiParameters?: GetApiDestinationResponseBodyHttpApiParametersApiParameters[];
  static names(): { [key: string]: string } {
    return {
      endpoint: 'endpoint',
      method: 'method',
      apiParameters: 'apiParameters',
    };
  }

  static types(): { [key: string]: any } {
    return {
      endpoint: 'string',
      method: 'string',
      apiParameters: { 'type': 'array', 'itemType': GetApiDestinationResponseBodyHttpApiParametersApiParameters },
    };
  }

  constructor(map?: { [key: string]: any }) {
    super(map);
  }
}

export class ListApiDestinationsResponseBodyApiDestinationsHttpApiParametersApiParameters extends $tea.Model {
  name?: string;
  /**
   * @remarks
   * The description of the API destination. The description can be up to 255 characters in length.
   */
  description?: string;
  type?: string;
  defaultValue?: string;
  in?: string;
  static names(): { [key: string]: string } {
    return {
      name: 'name',
      description: 'description',
      type: 'type',
      defaultValue: 'defaultValue',
      in: 'in',
    };
  }

  static types(): { [key: string]: any } {
    return {
      name: 'string',
      description: 'string',
      type: 'string',
      defaultValue: 'string',
      in: 'string',
    };
  }

  constructor(map?: { [key: string]: any }) {
    super(map);
  }
}

export class ListApiDestinationsResponseBodyApiDestinationsHttpApiParameters extends $tea.Model {
  /**
   * @remarks
   * The endpoint of the API destination.
   * 
   * @example
   * http://127.0.0.1:8001/api
   */
  endpoint?: string;
  /**
   * @remarks
   * The HTTP request method. Valid values:
   * 
   *           - POST
   * 
   *           - GET
   * 
   *           - DELETE
   * 
   *           - PUT
   * 
   *           - HEAD
   * 
   *           - TRACE
   * 
   *           - PATCH
   * 
   * @example
   * POST
   */
  method?: string;
  /**
   * @remarks
   * TODO
   */
  apiParameters?: ListApiDestinationsResponseBodyApiDestinationsHttpApiParametersApiParameters[];
  static names(): { [key: string]: string } {
    return {
      endpoint: 'endpoint',
      method: 'method',
      apiParameters: 'apiParameters',
    };
  }

  static types(): { [key: string]: any } {
    return {
      endpoint: 'string',
      method: 'string',
      apiParameters: { 'type': 'array', 'itemType': ListApiDestinationsResponseBodyApiDestinationsHttpApiParametersApiParameters },
    };
  }

  constructor(map?: { [key: string]: any }) {
    super(map);
  }
}

export class ListApiDestinationsResponseBodyApiDestinations extends $tea.Model {
  /**
   * @remarks
   * The name of the API destination.
   * 
   * @example
   * api-destination-2
   */
  apiDestinationName?: string;
  /**
   * @remarks
   * The connection name.
   * 
   * @example
   * connection-name
   */
  connectionName?: string;
  /**
   * @remarks
   * The description of the connection.
   * 
   * @example
   * demo
   */
  description?: string;
  /**
   * @remarks
   * The time when the API destination was created.
   * 
   * @example
   * 1665223213000
   */
  gmtCreate?: number;
  /**
   * @remarks
   * The request parameters that are configured for the API destination.
   */
  httpApiParameters?: ListApiDestinationsResponseBodyApiDestinationsHttpApiParameters;
  /**
   * @remarks
   * TODO
   */
  invocationRateLimitPerSecond?: number;
  static names(): { [key: string]: string } {
    return {
      apiDestinationName: 'apiDestinationName',
      connectionName: 'connectionName',
      description: 'description',
      gmtCreate: 'gmtCreate',
      httpApiParameters: 'httpApiParameters',
      invocationRateLimitPerSecond: 'invocationRateLimitPerSecond',
    };
  }

  static types(): { [key: string]: any } {
    return {
      apiDestinationName: 'string',
      connectionName: 'string',
      description: 'string',
      gmtCreate: 'number',
      httpApiParameters: ListApiDestinationsResponseBodyApiDestinationsHttpApiParameters,
      invocationRateLimitPerSecond: 'number',
    };
  }

  constructor(map?: { [key: string]: any }) {
    super(map);
  }
}

export class CreateConnectionRequestAuthParametersApiKeyAuthParameters extends $tea.Model {
  /**
   * @remarks
   * The key of the API key.
   * 
   * @example
   * Token
   */
  apiKeyName?: string;
  /**
   * @remarks
   * The value of the API key.
   * 
   * @example
   * adkjnakddh****
   */
  apiKeyValue?: string;
  static names(): { [key: string]: string } {
    return {
      apiKeyName: 'apiKeyName',
      apiKeyValue: 'apiKeyValue',
    };
  }

  static types(): { [key: string]: any } {
    return {
      apiKeyName: 'string',
      apiKeyValue: 'string',
    };
  }

  constructor(map?: { [key: string]: any }) {
    super(map);
  }
}

export class CreateConnectionRequestAuthParametersBasicAuthParameters extends $tea.Model {
  /**
   * @remarks
   * The password for basic authentication.
   * 
   * @example
   * *******
   */
  password?: string;
  /**
   * @remarks
   * The username for basic authentication.
   * 
   * @example
   * admin
   */
  username?: string;
  static names(): { [key: string]: string } {
    return {
      password: 'password',
      username: 'username',
    };
  }

  static types(): { [key: string]: any } {
    return {
      password: 'string',
      username: 'string',
    };
  }

  constructor(map?: { [key: string]: any }) {
    super(map);
  }
}

export class CreateConnectionRequestAuthParametersOauthParametersClientParameters extends $tea.Model {
  /**
   * @remarks
   * The client ID.
   * 
   * @example
   * ClientID
   */
  clientID?: string;
  /**
   * @remarks
   * The client key secret of the application.
   * 
   * @example
   * ClientSecret
   */
  clientSecret?: string;
  static names(): { [key: string]: string } {
    return {
      clientID: 'clientID',
      clientSecret: 'clientSecret',
    };
  }

  static types(): { [key: string]: any } {
    return {
      clientID: 'string',
      clientSecret: 'string',
    };
  }

  constructor(map?: { [key: string]: any }) {
    super(map);
  }
}

export class CreateConnectionRequestAuthParametersOauthParametersOauthHttpParametersBodyParameters extends $tea.Model {
  /**
   * @remarks
   * Indicates whether authentication is enabled.
   * 
   * @example
   * false
   */
  isValueSecret?: string;
  /**
   * @remarks
   * The key in the request body.
   * 
   * @example
   * name
   */
  key?: string;
  /**
   * @remarks
   * The value of the key in the request body.
   * 
   * @example
   * demo
   */
  value?: string;
  static names(): { [key: string]: string } {
    return {
      isValueSecret: 'isValueSecret',
      key: 'key',
      value: 'value',
    };
  }

  static types(): { [key: string]: any } {
    return {
      isValueSecret: 'string',
      key: 'string',
      value: 'string',
    };
  }

  constructor(map?: { [key: string]: any }) {
    super(map);
  }
}

export class CreateConnectionRequestAuthParametersOauthParametersOauthHttpParametersHeaderParameters extends $tea.Model {
  /**
   * @remarks
   * Indicates whether authentication is enabled.
   * 
   * @example
   * false
   */
  isValueSecret?: string;
  /**
   * @remarks
   * The key in the request header.
   * 
   * @example
   * name
   */
  key?: string;
  /**
   * @remarks
   * The value of the key in the request header.
   * 
   * @example
   * demo
   */
  value?: string;
  static names(): { [key: string]: string } {
    return {
      isValueSecret: 'isValueSecret',
      key: 'key',
      value: 'value',
    };
  }

  static types(): { [key: string]: any } {
    return {
      isValueSecret: 'string',
      key: 'string',
      value: 'string',
    };
  }

  constructor(map?: { [key: string]: any }) {
    super(map);
  }
}

export class CreateConnectionRequestAuthParametersOauthParametersOauthHttpParametersQueryStringParameters extends $tea.Model {
  /**
   * @remarks
   * Indicates whether authentication is enabled.
   * 
   * @example
   * false
   */
  isValueSecret?: string;
  /**
   * @remarks
   * The key in the request path.
   * 
   * @example
   * name
   */
  key?: string;
  /**
   * @remarks
   * The value of the key in the request path.
   * 
   * @example
   * demo
   */
  value?: string;
  static names(): { [key: string]: string } {
    return {
      isValueSecret: 'isValueSecret',
      key: 'key',
      value: 'value',
    };
  }

  static types(): { [key: string]: any } {
    return {
      isValueSecret: 'string',
      key: 'string',
      value: 'string',
    };
  }

  constructor(map?: { [key: string]: any }) {
    super(map);
  }
}

export class CreateConnectionRequestAuthParametersOauthParametersOauthHttpParameters extends $tea.Model {
  /**
   * @remarks
   * The parameters that are configured for the request.
   */
  bodyParameters?: CreateConnectionRequestAuthParametersOauthParametersOauthHttpParametersBodyParameters[];
  /**
   * @remarks
   * The parameters that are configured for the request header.
   */
  headerParameters?: CreateConnectionRequestAuthParametersOauthParametersOauthHttpParametersHeaderParameters[];
  /**
   * @remarks
   * The parameters that are configured for the request path.
   */
  queryStringParameters?: CreateConnectionRequestAuthParametersOauthParametersOauthHttpParametersQueryStringParameters[];
  static names(): { [key: string]: string } {
    return {
      bodyParameters: 'bodyParameters',
      headerParameters: 'headerParameters',
      queryStringParameters: 'queryStringParameters',
    };
  }

  static types(): { [key: string]: any } {
    return {
      bodyParameters: { 'type': 'array', 'itemType': CreateConnectionRequestAuthParametersOauthParametersOauthHttpParametersBodyParameters },
      headerParameters: { 'type': 'array', 'itemType': CreateConnectionRequestAuthParametersOauthParametersOauthHttpParametersHeaderParameters },
      queryStringParameters: { 'type': 'array', 'itemType': CreateConnectionRequestAuthParametersOauthParametersOauthHttpParametersQueryStringParameters },
    };
  }

  constructor(map?: { [key: string]: any }) {
    super(map);
  }
}

export class CreateConnectionRequestAuthParametersOauthParameters extends $tea.Model {
  /**
   * @remarks
   * The endpoint that is used to obtain the OAuth token.
   * 
   * @example
   * http://localhost:8080/oauth/token
   */
  authorizationEndpoint?: string;
  /**
   * @remarks
   * The parameters that are configured for the client.
   */
  clientParameters?: CreateConnectionRequestAuthParametersOauthParametersClientParameters;
  /**
   * @remarks
   * The HTTP request method. Valid values:
   * 
   *         - GET
   * 
   *         - POST
   * 
   *         - HEAD
   * 
   * @example
   * POST
   */
  httpMethod?: string;
  /**
   * @remarks
   * The request parameters for OAuth authentication.
   */
  oauthHttpParameters?: CreateConnectionRequestAuthParametersOauthParametersOauthHttpParameters;
  static names(): { [key: string]: string } {
    return {
      authorizationEndpoint: 'authorizationEndpoint',
      clientParameters: 'clientParameters',
      httpMethod: 'httpMethod',
      oauthHttpParameters: 'oauthHttpParameters',
    };
  }

  static types(): { [key: string]: any } {
    return {
      authorizationEndpoint: 'string',
      clientParameters: CreateConnectionRequestAuthParametersOauthParametersClientParameters,
      httpMethod: 'string',
      oauthHttpParameters: CreateConnectionRequestAuthParametersOauthParametersOauthHttpParameters,
    };
  }

  constructor(map?: { [key: string]: any }) {
    super(map);
  }
}

export class CreateConnectionRequestAuthParameters extends $tea.Model {
  /**
   * @remarks
   * The parameters that are configured for API key authentication.
   */
  apiKeyAuthParameters?: CreateConnectionRequestAuthParametersApiKeyAuthParameters;
  /**
   * @remarks
   * The authentication type. Valid values:
   * 
   *       BASIC_AUTH: basic authentication.
   * 
   *       Introduction: Basic authentication is a simple authentication scheme built into the HTTP protocol. When you use the HTTP protocol for communications, the authentication method that the HTTP server uses to authenticate user identities on the client is defined in the protocol. The request header is in the Authorization: Basic Base64-encoded string (Username:Password) format.
   * 
   *       1.  Username and Password are required
   * 
   *       API_KEY_AUTH: API key authentication.
   * 
   *       Introduction: The request header is in the Token: Token value format.
   * 
   *       *   ApiKeyName and ApiKeyValue are required.
   * 
   *       OAUTH_AUTH: OAuth authentication.
   * 
   *       Introduction: OAuth2.0 is an authentication mechanism. In normal cases, a system that does not use OAuth2.0 can access the resources of the server from the client. To ensure access security, access tokens are used to authenticate users in OAuth 2.0. The client must use an access token to access protected resources. This way, OAuth 2.0 protects resources from being accessed from malicious clients and improves system security.
   * 
   *       *   AuthorizationEndpoint, OAuthHttpParameters, and HttpMethod are required.
   * 
   * @example
   * BASIC_AUTH
   */
  authorizationType?: string;
  /**
   * @remarks
   * The parameters that are configured for basic authentication.
   */
  basicAuthParameters?: CreateConnectionRequestAuthParametersBasicAuthParameters;
  /**
   * @remarks
   * The parameters that are configured for OAuth authentication.
   */
  oauthParameters?: CreateConnectionRequestAuthParametersOauthParameters;
  static names(): { [key: string]: string } {
    return {
      apiKeyAuthParameters: 'apiKeyAuthParameters',
      authorizationType: 'authorizationType',
      basicAuthParameters: 'basicAuthParameters',
      oauthParameters: 'oauthParameters',
    };
  }

  static types(): { [key: string]: any } {
    return {
      apiKeyAuthParameters: CreateConnectionRequestAuthParametersApiKeyAuthParameters,
      authorizationType: 'string',
      basicAuthParameters: CreateConnectionRequestAuthParametersBasicAuthParameters,
      oauthParameters: CreateConnectionRequestAuthParametersOauthParameters,
    };
  }

  constructor(map?: { [key: string]: any }) {
    super(map);
  }
}

export class CreateConnectionRequestNetworkParameters extends $tea.Model {
  /**
   * @remarks
   * The network type. Valid values:
   * 
   *       PublicNetwork and PrivateNetwork.
   * 
   *       *   Note: If you set this parameter to PrivateNetwork, you must configure VpcId, VswitcheId, and SecurityGroupId.
   * 
   *       This parameter is required.
   * 
   * @example
   * PublicNetwork
   */
  networkType?: string;
  /**
   * @remarks
   * The ID of the security group.
   * 
   * @example
   * eb-167adad548759-security_grop/sg-bp1addad26peuh9qh9****
   */
  securityGroupId?: string;
  /**
   * @remarks
   * The VPC. ID
   * 
   * @example
   * eb-test/vpc-bp1symadadwnwg****
   */
  vpcId?: string;
  /**
   * @remarks
   * The vSwitch ID.
   * 
   * @example
   * vsw-bp1iu4x7aeradadown1og8,vsw-bp193sqmadadlaszpeq****
   */
  vswitcheId?: string;
  static names(): { [key: string]: string } {
    return {
      networkType: 'networkType',
      securityGroupId: 'securityGroupId',
      vpcId: 'vpcId',
      vswitcheId: 'vswitcheId',
    };
  }

  static types(): { [key: string]: any } {
    return {
      networkType: 'string',
      securityGroupId: 'string',
      vpcId: 'string',
      vswitcheId: 'string',
    };
  }

  constructor(map?: { [key: string]: any }) {
    super(map);
  }
}

export class UpdateConnectionRequestAuthParametersApiKeyAuthParameters extends $tea.Model {
  /**
   * @remarks
   * The key of the API key.
   * 
   * @example
   * Token
   */
  apiKeyName?: string;
  /**
   * @remarks
   * The value of the API key.
   * 
   * @example
   * adkjnakddh****
   */
  apiKeyValue?: string;
  static names(): { [key: string]: string } {
    return {
      apiKeyName: 'apiKeyName',
      apiKeyValue: 'apiKeyValue',
    };
  }

  static types(): { [key: string]: any } {
    return {
      apiKeyName: 'string',
      apiKeyValue: 'string',
    };
  }

  constructor(map?: { [key: string]: any }) {
    super(map);
  }
}

export class UpdateConnectionRequestAuthParametersBasicAuthParameters extends $tea.Model {
  /**
   * @remarks
   * The password for basic authentication.
   * 
   * @example
   * *******
   */
  password?: string;
  /**
   * @remarks
   * The username for basic authentication.
   * 
   * @example
   * admin
   */
  username?: string;
  static names(): { [key: string]: string } {
    return {
      password: 'password',
      username: 'username',
    };
  }

  static types(): { [key: string]: any } {
    return {
      password: 'string',
      username: 'string',
    };
  }

  constructor(map?: { [key: string]: any }) {
    super(map);
  }
}

export class UpdateConnectionRequestAuthParametersOauthParametersClientParameters extends $tea.Model {
  /**
   * @remarks
   * The client ID.
   * 
   * @example
   * ClientID
   */
  clientID?: string;
  /**
   * @remarks
   * The client key secret of the application.
   * 
   * @example
   * ClientSecret
   */
  clientSecret?: string;
  static names(): { [key: string]: string } {
    return {
      clientID: 'clientID',
      clientSecret: 'clientSecret',
    };
  }

  static types(): { [key: string]: any } {
    return {
      clientID: 'string',
      clientSecret: 'string',
    };
  }

  constructor(map?: { [key: string]: any }) {
    super(map);
  }
}

export class UpdateConnectionRequestAuthParametersOauthParametersOauthHttpParametersBodyParameters extends $tea.Model {
  /**
   * @remarks
   * Indicates whether authentication is enabled.
   * 
   * @example
   * false
   */
  isValueSecret?: string;
  /**
   * @remarks
   * The key in the request body.
   * 
   * @example
   * name
   */
  key?: string;
  /**
   * @remarks
   * The value of the key in the request body.
   * 
   * @example
   * demo
   */
  value?: string;
  static names(): { [key: string]: string } {
    return {
      isValueSecret: 'isValueSecret',
      key: 'key',
      value: 'value',
    };
  }

  static types(): { [key: string]: any } {
    return {
      isValueSecret: 'string',
      key: 'string',
      value: 'string',
    };
  }

  constructor(map?: { [key: string]: any }) {
    super(map);
  }
}

export class UpdateConnectionRequestAuthParametersOauthParametersOauthHttpParametersHeaderParameters extends $tea.Model {
  /**
   * @remarks
   * Indicates whether authentication is enabled.
   * 
   * @example
   * false
   */
  isValueSecret?: string;
  /**
   * @remarks
   * The key in the request header.
   * 
   * @example
   * name
   */
  key?: string;
  /**
   * @remarks
   * The value of the key in the request header.
   * 
   * @example
   * demo
   */
  value?: string;
  static names(): { [key: string]: string } {
    return {
      isValueSecret: 'isValueSecret',
      key: 'key',
      value: 'value',
    };
  }

  static types(): { [key: string]: any } {
    return {
      isValueSecret: 'string',
      key: 'string',
      value: 'string',
    };
  }

  constructor(map?: { [key: string]: any }) {
    super(map);
  }
}

export class UpdateConnectionRequestAuthParametersOauthParametersOauthHttpParametersQueryStringParameters extends $tea.Model {
  /**
   * @remarks
   * Indicates whether authentication is enabled.
   * 
   * @example
   * false
   */
  isValueSecret?: string;
  /**
   * @remarks
   * The key in the request path.
   * 
   * @example
   * name
   */
  key?: string;
  /**
   * @remarks
   * The value of the key in the request path.
   * 
   * @example
   * demo
   */
  value?: string;
  static names(): { [key: string]: string } {
    return {
      isValueSecret: 'isValueSecret',
      key: 'key',
      value: 'value',
    };
  }

  static types(): { [key: string]: any } {
    return {
      isValueSecret: 'string',
      key: 'string',
      value: 'string',
    };
  }

  constructor(map?: { [key: string]: any }) {
    super(map);
  }
}

export class UpdateConnectionRequestAuthParametersOauthParametersOauthHttpParameters extends $tea.Model {
  /**
   * @remarks
   * The parameters that are configured for the request.
   */
  bodyParameters?: UpdateConnectionRequestAuthParametersOauthParametersOauthHttpParametersBodyParameters[];
  /**
   * @remarks
   * The parameters that are configured for the request header.
   */
  headerParameters?: UpdateConnectionRequestAuthParametersOauthParametersOauthHttpParametersHeaderParameters[];
  /**
   * @remarks
   * The parameters that are configured for the request path.
   */
  queryStringParameters?: UpdateConnectionRequestAuthParametersOauthParametersOauthHttpParametersQueryStringParameters[];
  static names(): { [key: string]: string } {
    return {
      bodyParameters: 'bodyParameters',
      headerParameters: 'headerParameters',
      queryStringParameters: 'queryStringParameters',
    };
  }

  static types(): { [key: string]: any } {
    return {
      bodyParameters: { 'type': 'array', 'itemType': UpdateConnectionRequestAuthParametersOauthParametersOauthHttpParametersBodyParameters },
      headerParameters: { 'type': 'array', 'itemType': UpdateConnectionRequestAuthParametersOauthParametersOauthHttpParametersHeaderParameters },
      queryStringParameters: { 'type': 'array', 'itemType': UpdateConnectionRequestAuthParametersOauthParametersOauthHttpParametersQueryStringParameters },
    };
  }

  constructor(map?: { [key: string]: any }) {
    super(map);
  }
}

export class UpdateConnectionRequestAuthParametersOauthParameters extends $tea.Model {
  /**
   * @remarks
   * The endpoint that is used to obtain the OAuth token.
   * 
   * @example
   * http://localhost:8080/oauth/token
   */
  authorizationEndpoint?: string;
  /**
   * @remarks
   * The parameters that are configured for the client.
   */
  clientParameters?: UpdateConnectionRequestAuthParametersOauthParametersClientParameters;
  /**
   * @remarks
   * The HTTP request method. Valid values:
   * 
   *         - GET
   * 
   *         - POST
   * 
   *         - HEAD
   * 
   * @example
   * POST
   */
  httpMethod?: string;
  /**
   * @remarks
   * The request parameters for OAuth authentication.
   */
  oauthHttpParameters?: UpdateConnectionRequestAuthParametersOauthParametersOauthHttpParameters;
  static names(): { [key: string]: string } {
    return {
      authorizationEndpoint: 'authorizationEndpoint',
      clientParameters: 'clientParameters',
      httpMethod: 'httpMethod',
      oauthHttpParameters: 'oauthHttpParameters',
    };
  }

  static types(): { [key: string]: any } {
    return {
      authorizationEndpoint: 'string',
      clientParameters: UpdateConnectionRequestAuthParametersOauthParametersClientParameters,
      httpMethod: 'string',
      oauthHttpParameters: UpdateConnectionRequestAuthParametersOauthParametersOauthHttpParameters,
    };
  }

  constructor(map?: { [key: string]: any }) {
    super(map);
  }
}

export class UpdateConnectionRequestAuthParameters extends $tea.Model {
  /**
   * @remarks
   * The parameters that are configured for API key authentication.
   */
  apiKeyAuthParameters?: UpdateConnectionRequestAuthParametersApiKeyAuthParameters;
  /**
   * @remarks
   * The authentication type. Valid values:
   * 
   *       BASIC_AUTH: basic authentication.
   * 
   *       Introduction: Basic authentication is a simple authentication scheme built into the HTTP protocol. When you use the HTTP protocol for communications, the authentication method that the HTTP server uses to authenticate user identities on the client is defined in the protocol. The request header is in the Authorization: Basic Base64-encoded string (Username:Password) format.
   * 
   *       1.  Username and Password are required
   * 
   *       API_KEY_AUTH: API key authentication.
   * 
   *       Introduction: The request header is in the Token: Token value format.
   * 
   *       *   ApiKeyName and ApiKeyValue are required.
   * 
   *       OAUTH_AUTH: OAuth authentication.
   * 
   *       Introduction: OAuth2.0 is an authentication mechanism. In normal cases, a system that does not use OAuth2.0 can access the resources of the server from the client. To ensure access security, access tokens are used to authenticate users in OAuth 2.0. The client must use an access token to access protected resources. This way, OAuth 2.0 protects resources from being accessed from malicious clients and improves system security.
   * 
   *       *   AuthorizationEndpoint, OAuthHttpParameters, and HttpMethod are required.
   * 
   * @example
   * BASIC_AUTH
   */
  authorizationType?: string;
  /**
   * @remarks
   * The parameters that are configured for basic authentication.
   */
  basicAuthParameters?: UpdateConnectionRequestAuthParametersBasicAuthParameters;
  /**
   * @remarks
   * The parameters that are configured for OAuth authentication.
   */
  oauthParameters?: UpdateConnectionRequestAuthParametersOauthParameters;
  static names(): { [key: string]: string } {
    return {
      apiKeyAuthParameters: 'apiKeyAuthParameters',
      authorizationType: 'authorizationType',
      basicAuthParameters: 'basicAuthParameters',
      oauthParameters: 'oauthParameters',
    };
  }

  static types(): { [key: string]: any } {
    return {
      apiKeyAuthParameters: UpdateConnectionRequestAuthParametersApiKeyAuthParameters,
      authorizationType: 'string',
      basicAuthParameters: UpdateConnectionRequestAuthParametersBasicAuthParameters,
      oauthParameters: UpdateConnectionRequestAuthParametersOauthParameters,
    };
  }

  constructor(map?: { [key: string]: any }) {
    super(map);
  }
}

export class UpdateConnectionRequestNetworkParameters extends $tea.Model {
  /**
   * @remarks
   * The network type. Valid values:
   * 
   *       PublicNetwork and PrivateNetwork.
   * 
   *       *   Note: If you set this parameter to PrivateNetwork, you must configure VpcId, VswitcheId, and SecurityGroupId.
   * 
   *       This parameter is required.
   * 
   * @example
   * PublicNetwork
   */
  networkType?: string;
  /**
   * @remarks
   * The ID of the security group.
   * 
   * @example
   * eb-167adad548759-security_grop/sg-bp1addad26peuh9qh9****
   */
  securityGroupId?: string;
  /**
   * @remarks
   * The VPC. ID
   * 
   * @example
   * eb-test/vpc-bp1symadadwnwg****
   */
  vpcId?: string;
  /**
   * @remarks
   * The vSwitch ID.
   * 
   * @example
   * vsw-bp1iu4x7aeradadown1og8,vsw-bp193sqmadadlaszpeq****
   */
  vswitcheId?: string;
  static names(): { [key: string]: string } {
    return {
      networkType: 'networkType',
      securityGroupId: 'securityGroupId',
      vpcId: 'vpcId',
      vswitcheId: 'vswitcheId',
    };
  }

  static types(): { [key: string]: any } {
    return {
      networkType: 'string',
      securityGroupId: 'string',
      vpcId: 'string',
      vswitcheId: 'string',
    };
  }

  constructor(map?: { [key: string]: any }) {
    super(map);
  }
}

export class GetConnectionResponseBodyConnectionsAuthParametersApiKeyAuthParameters extends $tea.Model {
  /**
   * @remarks
   * The API key.
   * 
   * @example
   * Token
   */
  apiKeyName?: string;
  /**
   * @remarks
   * The value of the API key.
   * 
   * @example
   * asdkjnqkwejooa
   */
  apiKeyValue?: string;
  static names(): { [key: string]: string } {
    return {
      apiKeyName: 'apiKeyName',
      apiKeyValue: 'apiKeyValue',
    };
  }

  static types(): { [key: string]: any } {
    return {
      apiKeyName: 'string',
      apiKeyValue: 'string',
    };
  }

  constructor(map?: { [key: string]: any }) {
    super(map);
  }
}

export class GetConnectionResponseBodyConnectionsAuthParametersBasicAuthParameters extends $tea.Model {
  /**
   * @remarks
   * The password for basic authentication.
   * 
   * @example
   * admin
   */
  password?: string;
  /**
   * @remarks
   * The username for basic authentication.
   * 
   * @example
   * admin
   */
  username?: string;
  static names(): { [key: string]: string } {
    return {
      password: 'password',
      username: 'username',
    };
  }

  static types(): { [key: string]: any } {
    return {
      password: 'string',
      username: 'string',
    };
  }

  constructor(map?: { [key: string]: any }) {
    super(map);
  }
}

export class GetConnectionResponseBodyConnectionsAuthParametersOauthParametersClientParameters extends $tea.Model {
  /**
   * @remarks
   * The client ID.
   * 
   * @example
   * ClientID
   */
  clientID?: string;
  /**
   * @remarks
   * The client key secret of the application.
   * 
   * @example
   * ClientSecret
   */
  clientSecret?: string;
  static names(): { [key: string]: string } {
    return {
      clientID: 'clientID',
      clientSecret: 'clientSecret',
    };
  }

  static types(): { [key: string]: any } {
    return {
      clientID: 'string',
      clientSecret: 'string',
    };
  }

  constructor(map?: { [key: string]: any }) {
    super(map);
  }
}

export class GetConnectionResponseBodyConnectionsAuthParametersOauthParametersOauthHttpParametersBodyParameters extends $tea.Model {
  /**
   * @remarks
   * Indicates whether authentication is enabled.
   * 
   * @example
   * false
   */
  isValueSecret?: string;
  /**
   * @remarks
   * The key in the request body.
   * 
   * @example
   * name
   */
  key?: string;
  /**
   * @remarks
   * The value of the key in the request body.
   * 
   * @example
   * demo
   */
  value?: string;
  static names(): { [key: string]: string } {
    return {
      isValueSecret: 'isValueSecret',
      key: 'key',
      value: 'value',
    };
  }

  static types(): { [key: string]: any } {
    return {
      isValueSecret: 'string',
      key: 'string',
      value: 'string',
    };
  }

  constructor(map?: { [key: string]: any }) {
    super(map);
  }
}

export class GetConnectionResponseBodyConnectionsAuthParametersOauthParametersOauthHttpParametersHeaderParameters extends $tea.Model {
  /**
   * @remarks
   * Indicates whether authentication is enabled.
   * 
   * @example
   * false
   */
  isValueSecret?: string;
  /**
   * @remarks
   * The key in the request header.
   * 
   * @example
   * name
   */
  key?: string;
  /**
   * @remarks
   * The value of the key in the request header.
   * 
   * @example
   * demo
   */
  value?: string;
  static names(): { [key: string]: string } {
    return {
      isValueSecret: 'isValueSecret',
      key: 'key',
      value: 'value',
    };
  }

  static types(): { [key: string]: any } {
    return {
      isValueSecret: 'string',
      key: 'string',
      value: 'string',
    };
  }

  constructor(map?: { [key: string]: any }) {
    super(map);
  }
}

export class GetConnectionResponseBodyConnectionsAuthParametersOauthParametersOauthHttpParametersQueryStringParameters extends $tea.Model {
  /**
   * @remarks
   * Indicates whether authentication is enabled.
   * 
   * @example
   * false
   */
  isValueSecret?: string;
  /**
   * @remarks
   * The key in the request path.
   * 
   * @example
   * name
   */
  key?: string;
  /**
   * @remarks
   * The value of the key in the request path.
   * 
   * @example
   * demo
   */
  value?: string;
  static names(): { [key: string]: string } {
    return {
      isValueSecret: 'isValueSecret',
      key: 'key',
      value: 'value',
    };
  }

  static types(): { [key: string]: any } {
    return {
      isValueSecret: 'string',
      key: 'string',
      value: 'string',
    };
  }

  constructor(map?: { [key: string]: any }) {
    super(map);
  }
}

export class GetConnectionResponseBodyConnectionsAuthParametersOauthParametersOauthHttpParameters extends $tea.Model {
  /**
   * @remarks
   * The parameters that are configured for the request.
   */
  bodyParameters?: GetConnectionResponseBodyConnectionsAuthParametersOauthParametersOauthHttpParametersBodyParameters[];
  /**
   * @remarks
   * The parameters that are configured for the request header.
   */
  headerParameters?: GetConnectionResponseBodyConnectionsAuthParametersOauthParametersOauthHttpParametersHeaderParameters[];
  /**
   * @remarks
   * The parameters that are configured for the request path.
   */
  queryStringParameters?: GetConnectionResponseBodyConnectionsAuthParametersOauthParametersOauthHttpParametersQueryStringParameters[];
  static names(): { [key: string]: string } {
    return {
      bodyParameters: 'bodyParameters',
      headerParameters: 'headerParameters',
      queryStringParameters: 'queryStringParameters',
    };
  }

  static types(): { [key: string]: any } {
    return {
      bodyParameters: { 'type': 'array', 'itemType': GetConnectionResponseBodyConnectionsAuthParametersOauthParametersOauthHttpParametersBodyParameters },
      headerParameters: { 'type': 'array', 'itemType': GetConnectionResponseBodyConnectionsAuthParametersOauthParametersOauthHttpParametersHeaderParameters },
      queryStringParameters: { 'type': 'array', 'itemType': GetConnectionResponseBodyConnectionsAuthParametersOauthParametersOauthHttpParametersQueryStringParameters },
    };
  }

  constructor(map?: { [key: string]: any }) {
    super(map);
  }
}

export class GetConnectionResponseBodyConnectionsAuthParametersOauthParameters extends $tea.Model {
  /**
   * @remarks
   * The endpoint that is used to obtain the OAuth token.
   * 
   * @example
   * http://localhost:8080/oauth/token
   */
  authorizationEndpoint?: string;
  /**
   * @remarks
   * The parameters that are configured for the client.
   */
  clientParameters?: GetConnectionResponseBodyConnectionsAuthParametersOauthParametersClientParameters;
  /**
   * @remarks
   * The HTTP request method. Valid values:
   * 
   *             - GET
   * 
   *             - POST
   * 
   *             - HEAD
   * 
   * @example
   * POST
   */
  httpMethod?: string;
  /**
   * @remarks
   * The request parameters for OAuth authentication.
   */
  oauthHttpParameters?: GetConnectionResponseBodyConnectionsAuthParametersOauthParametersOauthHttpParameters;
  static names(): { [key: string]: string } {
    return {
      authorizationEndpoint: 'authorizationEndpoint',
      clientParameters: 'clientParameters',
      httpMethod: 'httpMethod',
      oauthHttpParameters: 'oauthHttpParameters',
    };
  }

  static types(): { [key: string]: any } {
    return {
      authorizationEndpoint: 'string',
      clientParameters: GetConnectionResponseBodyConnectionsAuthParametersOauthParametersClientParameters,
      httpMethod: 'string',
      oauthHttpParameters: GetConnectionResponseBodyConnectionsAuthParametersOauthParametersOauthHttpParameters,
    };
  }

  constructor(map?: { [key: string]: any }) {
    super(map);
  }
}

export class GetConnectionResponseBodyConnectionsAuthParameters extends $tea.Model {
  /**
   * @remarks
   * The parameters that are configured for API key authentication.
   */
  apiKeyAuthParameters?: GetConnectionResponseBodyConnectionsAuthParametersApiKeyAuthParameters;
  /**
   * @remarks
   * The authentication type. Valid values:
   * 
   * 
   *           - BASIC_AUTH: basic authentication.
   * 
   * 
   *           - API_KEY_AUTH: API key authentication.
   * 
   * 
   *           - OAUTH_AUTH: OAuth authentication.
   * 
   * @example
   * BASIC_AUTH
   */
  authorizationType?: string;
  /**
   * @remarks
   * The parameters that are configured for basic authentication.
   */
  basicAuthParameters?: GetConnectionResponseBodyConnectionsAuthParametersBasicAuthParameters;
  /**
   * @remarks
   * The parameters that are configured for OAuth authentication.
   */
  oauthParameters?: GetConnectionResponseBodyConnectionsAuthParametersOauthParameters;
  static names(): { [key: string]: string } {
    return {
      apiKeyAuthParameters: 'apiKeyAuthParameters',
      authorizationType: 'authorizationType',
      basicAuthParameters: 'basicAuthParameters',
      oauthParameters: 'oauthParameters',
    };
  }

  static types(): { [key: string]: any } {
    return {
      apiKeyAuthParameters: GetConnectionResponseBodyConnectionsAuthParametersApiKeyAuthParameters,
      authorizationType: 'string',
      basicAuthParameters: GetConnectionResponseBodyConnectionsAuthParametersBasicAuthParameters,
      oauthParameters: GetConnectionResponseBodyConnectionsAuthParametersOauthParameters,
    };
  }

  constructor(map?: { [key: string]: any }) {
    super(map);
  }
}

export class GetConnectionResponseBodyConnectionsNetworkParameters extends $tea.Model {
  /**
   * @remarks
   * The network type. Valid values:PublicNetwork and PrivateNetwork.
   * 
   * @example
   * PublicNetwork
   */
  networkType?: string;
  /**
   * @remarks
   * The security group ID.
   * 
   * @example
   * eb-167adad548759-security_grop/sg-bp1addad26peuh9qh9rtyb
   */
  securityGroupId?: string;
  /**
   * @remarks
   * The virtual private cloud (VPC) ID.
   * 
   * @example
   * eb-test/vpc-bp1symadadwnwgmqud
   */
  vpcId?: string;
  /**
   * @remarks
   * The vSwitch ID.
   * 
   * @example
   * vsw-bp1iu4x7aeradadown1og8,vsw-bp193sqmadadlaszpeqbt2c
   */
  vswitcheId?: string;
  static names(): { [key: string]: string } {
    return {
      networkType: 'networkType',
      securityGroupId: 'securityGroupId',
      vpcId: 'vpcId',
      vswitcheId: 'vswitcheId',
    };
  }

  static types(): { [key: string]: any } {
    return {
      networkType: 'string',
      securityGroupId: 'string',
      vpcId: 'string',
      vswitcheId: 'string',
    };
  }

  constructor(map?: { [key: string]: any }) {
    super(map);
  }
}

export class GetConnectionResponseBodyConnections extends $tea.Model {
  /**
   * @remarks
   * The parameters that are configured for authentication.
   */
  authParameters?: GetConnectionResponseBodyConnectionsAuthParameters;
  /**
   * @remarks
   * The connection name.
   * 
   * @example
   * connection-name
   */
  connectionName?: string;
  /**
   * @remarks
   * The connection description.
   * 
   * @example
   * The description of the connection.
   */
  description?: string;
  /**
   * @remarks
   * The time when the connection was created.
   * 
   * @example
   * 1592838994234
   */
  gmtCreate?: number;
  /**
   * @remarks
   * The connection ID.
   * 
   * @example
   * 1141093
   */
  id?: number;
  networkParameters?: GetConnectionResponseBodyConnectionsNetworkParameters;
  static names(): { [key: string]: string } {
    return {
      authParameters: 'authParameters',
      connectionName: 'connectionName',
      description: 'description',
      gmtCreate: 'gmtCreate',
      id: 'id',
      networkParameters: 'networkParameters',
    };
  }

  static types(): { [key: string]: any } {
    return {
      authParameters: GetConnectionResponseBodyConnectionsAuthParameters,
      connectionName: 'string',
      description: 'string',
      gmtCreate: 'number',
      id: 'number',
      networkParameters: GetConnectionResponseBodyConnectionsNetworkParameters,
    };
  }

  constructor(map?: { [key: string]: any }) {
    super(map);
  }
}

export class ListConnectionsResponseBodyConnectionsAuthParametersApiKeyAuthParameters extends $tea.Model {
  /**
   * @remarks
   * The API key.
   * 
   * @example
   * Token
   */
  apiKeyName?: string;
  /**
   * @remarks
   * The value of the API key.
   * 
   * @example
   * asdkjnqkwejooa
   */
  apiKeyValue?: string;
  static names(): { [key: string]: string } {
    return {
      apiKeyName: 'apiKeyName',
      apiKeyValue: 'apiKeyValue',
    };
  }

  static types(): { [key: string]: any } {
    return {
      apiKeyName: 'string',
      apiKeyValue: 'string',
    };
  }

  constructor(map?: { [key: string]: any }) {
    super(map);
  }
}

export class ListConnectionsResponseBodyConnectionsAuthParametersBasicAuthParameters extends $tea.Model {
  /**
   * @remarks
   * The password for basic authentication.
   * 
   * @example
   * admin
   */
  password?: string;
  /**
   * @remarks
   * The username for basic authentication.
   * 
   * @example
   * admin
   */
  username?: string;
  static names(): { [key: string]: string } {
    return {
      password: 'password',
      username: 'username',
    };
  }

  static types(): { [key: string]: any } {
    return {
      password: 'string',
      username: 'string',
    };
  }

  constructor(map?: { [key: string]: any }) {
    super(map);
  }
}

export class ListConnectionsResponseBodyConnectionsAuthParametersOauthParametersClientParameters extends $tea.Model {
  /**
   * @remarks
   * The client ID.
   * 
   * @example
   * ClientID
   */
  clientID?: string;
  /**
   * @remarks
   * The client key secret of the application.
   * 
   * @example
   * ClientSecret
   */
  clientSecret?: string;
  static names(): { [key: string]: string } {
    return {
      clientID: 'clientID',
      clientSecret: 'clientSecret',
    };
  }

  static types(): { [key: string]: any } {
    return {
      clientID: 'string',
      clientSecret: 'string',
    };
  }

  constructor(map?: { [key: string]: any }) {
    super(map);
  }
}

export class ListConnectionsResponseBodyConnectionsAuthParametersOauthParametersOauthHttpParametersBodyParameters extends $tea.Model {
  /**
   * @remarks
   * Indicates whether authentication is enabled.
   * 
   * @example
   * false
   */
  isValueSecret?: string;
  /**
   * @remarks
   * The key in the request body.
   * 
   * @example
   * name
   */
  key?: string;
  /**
   * @remarks
   * The value of the key in the request body.
   * 
   * @example
   * demo
   */
  value?: string;
  static names(): { [key: string]: string } {
    return {
      isValueSecret: 'isValueSecret',
      key: 'key',
      value: 'value',
    };
  }

  static types(): { [key: string]: any } {
    return {
      isValueSecret: 'string',
      key: 'string',
      value: 'string',
    };
  }

  constructor(map?: { [key: string]: any }) {
    super(map);
  }
}

export class ListConnectionsResponseBodyConnectionsAuthParametersOauthParametersOauthHttpParametersHeaderParameters extends $tea.Model {
  /**
   * @remarks
   * Indicates whether authentication is enabled.
   * 
   * @example
   * false
   */
  isValueSecret?: string;
  /**
   * @remarks
   * The key in the request header.
   * 
   * @example
   * name
   */
  key?: string;
  /**
   * @remarks
   * The value of the key in the request header.
   * 
   * @example
   * demo
   */
  value?: string;
  static names(): { [key: string]: string } {
    return {
      isValueSecret: 'isValueSecret',
      key: 'key',
      value: 'value',
    };
  }

  static types(): { [key: string]: any } {
    return {
      isValueSecret: 'string',
      key: 'string',
      value: 'string',
    };
  }

  constructor(map?: { [key: string]: any }) {
    super(map);
  }
}

export class ListConnectionsResponseBodyConnectionsAuthParametersOauthParametersOauthHttpParametersQueryStringParameters extends $tea.Model {
  /**
   * @remarks
   * Indicates whether authentication is enabled.
   * 
   * @example
   * false
   */
  isValueSecret?: string;
  /**
   * @remarks
   * The key in the request path.
   * 
   * @example
   * name
   */
  key?: string;
  /**
   * @remarks
   * The value of the key in the request path.
   * 
   * @example
   * demo
   */
  value?: string;
  static names(): { [key: string]: string } {
    return {
      isValueSecret: 'isValueSecret',
      key: 'key',
      value: 'value',
    };
  }

  static types(): { [key: string]: any } {
    return {
      isValueSecret: 'string',
      key: 'string',
      value: 'string',
    };
  }

  constructor(map?: { [key: string]: any }) {
    super(map);
  }
}

export class ListConnectionsResponseBodyConnectionsAuthParametersOauthParametersOauthHttpParameters extends $tea.Model {
  /**
   * @remarks
   * The parameters that are configured for the request.
   */
  bodyParameters?: ListConnectionsResponseBodyConnectionsAuthParametersOauthParametersOauthHttpParametersBodyParameters[];
  /**
   * @remarks
   * The parameters that are configured for the request header.
   */
  headerParameters?: ListConnectionsResponseBodyConnectionsAuthParametersOauthParametersOauthHttpParametersHeaderParameters[];
  /**
   * @remarks
   * The parameters that are configured for the request path.
   */
  queryStringParameters?: ListConnectionsResponseBodyConnectionsAuthParametersOauthParametersOauthHttpParametersQueryStringParameters[];
  static names(): { [key: string]: string } {
    return {
      bodyParameters: 'bodyParameters',
      headerParameters: 'headerParameters',
      queryStringParameters: 'queryStringParameters',
    };
  }

  static types(): { [key: string]: any } {
    return {
      bodyParameters: { 'type': 'array', 'itemType': ListConnectionsResponseBodyConnectionsAuthParametersOauthParametersOauthHttpParametersBodyParameters },
      headerParameters: { 'type': 'array', 'itemType': ListConnectionsResponseBodyConnectionsAuthParametersOauthParametersOauthHttpParametersHeaderParameters },
      queryStringParameters: { 'type': 'array', 'itemType': ListConnectionsResponseBodyConnectionsAuthParametersOauthParametersOauthHttpParametersQueryStringParameters },
    };
  }

  constructor(map?: { [key: string]: any }) {
    super(map);
  }
}

export class ListConnectionsResponseBodyConnectionsAuthParametersOauthParameters extends $tea.Model {
  /**
   * @remarks
   * The endpoint that is used to obtain the OAuth token.
   * 
   * @example
   * http://localhost:8080/oauth/token
   */
  authorizationEndpoint?: string;
  /**
   * @remarks
   * The parameters that are configured for the client.
   */
  clientParameters?: ListConnectionsResponseBodyConnectionsAuthParametersOauthParametersClientParameters;
  /**
   * @remarks
   * The HTTP request method. Valid values:
   * 
   *             - GET
   * 
   *             - POST
   * 
   *             - HEAD
   * 
   * @example
   * POST
   */
  httpMethod?: string;
  /**
   * @remarks
   * The request parameters for OAuth authentication.
   */
  oauthHttpParameters?: ListConnectionsResponseBodyConnectionsAuthParametersOauthParametersOauthHttpParameters;
  static names(): { [key: string]: string } {
    return {
      authorizationEndpoint: 'authorizationEndpoint',
      clientParameters: 'clientParameters',
      httpMethod: 'httpMethod',
      oauthHttpParameters: 'oauthHttpParameters',
    };
  }

  static types(): { [key: string]: any } {
    return {
      authorizationEndpoint: 'string',
      clientParameters: ListConnectionsResponseBodyConnectionsAuthParametersOauthParametersClientParameters,
      httpMethod: 'string',
      oauthHttpParameters: ListConnectionsResponseBodyConnectionsAuthParametersOauthParametersOauthHttpParameters,
    };
  }

  constructor(map?: { [key: string]: any }) {
    super(map);
  }
}

export class ListConnectionsResponseBodyConnectionsAuthParameters extends $tea.Model {
  /**
   * @remarks
   * The parameters that are configured for API key authentication.
   */
  apiKeyAuthParameters?: ListConnectionsResponseBodyConnectionsAuthParametersApiKeyAuthParameters;
  /**
   * @remarks
   * The authentication type. Valid values:
   * 
   * 
   *           - BASIC_AUTH: basic authentication.
   * 
   * 
   *           - API_KEY_AUTH: API key authentication.
   * 
   * 
   *           - OAUTH_AUTH: OAuth authentication.
   * 
   * @example
   * BASIC_AUTH
   */
  authorizationType?: string;
  /**
   * @remarks
   * The parameters that are configured for basic authentication.
   */
  basicAuthParameters?: ListConnectionsResponseBodyConnectionsAuthParametersBasicAuthParameters;
  /**
   * @remarks
   * The parameters that are configured for OAuth authentication.
   */
  oauthParameters?: ListConnectionsResponseBodyConnectionsAuthParametersOauthParameters;
  static names(): { [key: string]: string } {
    return {
      apiKeyAuthParameters: 'apiKeyAuthParameters',
      authorizationType: 'authorizationType',
      basicAuthParameters: 'basicAuthParameters',
      oauthParameters: 'oauthParameters',
    };
  }

  static types(): { [key: string]: any } {
    return {
      apiKeyAuthParameters: ListConnectionsResponseBodyConnectionsAuthParametersApiKeyAuthParameters,
      authorizationType: 'string',
      basicAuthParameters: ListConnectionsResponseBodyConnectionsAuthParametersBasicAuthParameters,
      oauthParameters: ListConnectionsResponseBodyConnectionsAuthParametersOauthParameters,
    };
  }

  constructor(map?: { [key: string]: any }) {
    super(map);
  }
}

export class ListConnectionsResponseBodyConnectionsNetworkParameters extends $tea.Model {
  /**
   * @remarks
   * The network type. Valid values:PublicNetwork and PrivateNetwork.
   * 
   * @example
   * PublicNetwork
   */
  networkType?: string;
  /**
   * @remarks
   * The security group ID.
   * 
   * @example
   * eb-167adad548759-security_grop/sg-bp1addad26peuh9qh9rtyb
   */
  securityGroupId?: string;
  /**
   * @remarks
   * The virtual private cloud (VPC) ID.
   * 
   * @example
   * eb-test/vpc-bp1symadadwnwgmqud
   */
  vpcId?: string;
  /**
   * @remarks
   * The vSwitch ID.
   * 
   * @example
   * vsw-bp1iu4x7aeradadown1og8,vsw-bp193sqmadadlaszpeqbt2c
   */
  vswitcheId?: string;
  static names(): { [key: string]: string } {
    return {
      networkType: 'networkType',
      securityGroupId: 'securityGroupId',
      vpcId: 'vpcId',
      vswitcheId: 'vswitcheId',
    };
  }

  static types(): { [key: string]: any } {
    return {
      networkType: 'string',
      securityGroupId: 'string',
      vpcId: 'string',
      vswitcheId: 'string',
    };
  }

  constructor(map?: { [key: string]: any }) {
    super(map);
  }
}

export class ListConnectionsResponseBodyConnections extends $tea.Model {
  /**
   * @remarks
   * The parameters that are configured for authentication.
   */
  authParameters?: ListConnectionsResponseBodyConnectionsAuthParameters;
  /**
   * @remarks
   * The connection name.
   * 
   * @example
   * connection-name
   */
  connectionName?: string;
  /**
   * @remarks
   * The connection description.
   * 
   * @example
   * The description of the connection.
   */
  description?: string;
  /**
   * @remarks
   * The time when the connection was created.
   * 
   * @example
   * 1592838994234
   */
  gmtCreate?: number;
  /**
   * @remarks
   * The connection ID.
   * 
   * @example
   * 1141093
   */
  id?: number;
  networkParameters?: ListConnectionsResponseBodyConnectionsNetworkParameters;
  static names(): { [key: string]: string } {
    return {
      authParameters: 'authParameters',
      connectionName: 'connectionName',
      description: 'description',
      gmtCreate: 'gmtCreate',
      id: 'id',
      networkParameters: 'networkParameters',
    };
  }

  static types(): { [key: string]: any } {
    return {
      authParameters: ListConnectionsResponseBodyConnectionsAuthParameters,
      connectionName: 'string',
      description: 'string',
      gmtCreate: 'number',
      id: 'number',
      networkParameters: ListConnectionsResponseBodyConnectionsNetworkParameters,
    };
  }

  constructor(map?: { [key: string]: any }) {
    super(map);
  }
}

export class PutEventsResponseBodyEntryList extends $tea.Model {
  /**
   * @remarks
   * The event ID.
   * 
   * @example
   * a5747e4f-2af2-40b6-b262-d0140e995bf7
   */
  eventId?: string;
  /**
   * @remarks
   * The returned error code.
   */
  errorCode?: string;
  /**
   * @remarks
   * The returned error message.
   */
  errorMessage?: string;
  static names(): { [key: string]: string } {
    return {
      eventId: 'eventId',
      errorCode: 'errorCode',
      errorMessage: 'errorMessage',
    };
  }

  static types(): { [key: string]: any } {
    return {
      eventId: 'string',
      errorCode: 'string',
      errorMessage: 'string',
    };
  }

  constructor(map?: { [key: string]: any }) {
    super(map);
  }
}

export class GetEventRuleResponseBodyEventTargetsRunOptionsRetryStrategy extends $tea.Model {
  pushRetryStrategy?: string;
  maximumEventAgeInSeconds?: number;
  maximumRetryAttempts?: number;
  static names(): { [key: string]: string } {
    return {
      pushRetryStrategy: 'pushRetryStrategy',
      maximumEventAgeInSeconds: 'maximumEventAgeInSeconds',
      maximumRetryAttempts: 'maximumRetryAttempts',
    };
  }

  static types(): { [key: string]: any } {
    return {
      pushRetryStrategy: 'string',
      maximumEventAgeInSeconds: 'number',
      maximumRetryAttempts: 'number',
    };
  }

  constructor(map?: { [key: string]: any }) {
    super(map);
  }
}

export class GetEventRuleResponseBodyEventTargetsRunOptionsDeadLetterQueue extends $tea.Model {
  type?: string;
  config?: { [key: string]: any };
  static names(): { [key: string]: string } {
    return {
      type: 'type',
      config: 'config',
    };
  }

  static types(): { [key: string]: any } {
    return {
      type: 'string',
      config: { 'type': 'map', 'keyType': 'string', 'valueType': 'any' },
    };
  }

  constructor(map?: { [key: string]: any }) {
    super(map);
  }
}

export class GetEventRuleResponseBodyEventTargetsRunOptions extends $tea.Model {
  errorsTolerance?: string;
  retryStrategy?: GetEventRuleResponseBodyEventTargetsRunOptionsRetryStrategy;
  deadLetterQueue?: GetEventRuleResponseBodyEventTargetsRunOptionsDeadLetterQueue;
  static names(): { [key: string]: string } {
    return {
      errorsTolerance: 'errorsTolerance',
      retryStrategy: 'retryStrategy',
      deadLetterQueue: 'deadLetterQueue',
    };
  }

  static types(): { [key: string]: any } {
    return {
      errorsTolerance: 'string',
      retryStrategy: GetEventRuleResponseBodyEventTargetsRunOptionsRetryStrategy,
      deadLetterQueue: GetEventRuleResponseBodyEventTargetsRunOptionsDeadLetterQueue,
    };
  }

  constructor(map?: { [key: string]: any }) {
    super(map);
  }
}

export class GetEventRuleResponseBodyEventTargets extends $tea.Model {
  eventTargetName?: string;
  className?: string;
  config?: { [key: string]: any };
  runOptions?: GetEventRuleResponseBodyEventTargetsRunOptions;
  static names(): { [key: string]: string } {
    return {
      eventTargetName: 'eventTargetName',
      className: 'className',
      config: 'config',
      runOptions: 'runOptions',
    };
  }

  static types(): { [key: string]: any } {
    return {
      eventTargetName: 'string',
      className: 'string',
      config: { 'type': 'map', 'keyType': 'string', 'valueType': 'any' },
      runOptions: GetEventRuleResponseBodyEventTargetsRunOptions,
    };
  }

  constructor(map?: { [key: string]: any }) {
    super(map);
  }
}

export class ListEventRulesResponseBodyEventRules extends $tea.Model {
  /**
   * @remarks
   * The name of the event bus with which the event source is associated.
   * This parameter is required.
   * 
   * @example
   * my-event-bus
   */
  eventBusName?: string;
  /**
   * @remarks
   * The name of the event rule.
   * This parameter is required.
   * 
   * @example
   * myrabbitmq.sourc
   */
  eventRuleName?: string;
  description?: string;
  /**
   * @remarks
   * The event pattern, in JSON format. Valid values: stringEqual and stringExpression. You can specify up to five expressions in the map data structure in each field.
   * 
   *         You can specify up to five expressions in the map data structure in each field.
   * 
   * @example
   * {\"source\": [{\"prefix\": \"acs.\"}],\"type\": [{\"prefix\":\"oss:ObjectReplication\"}],\"subject\":[{\"prefix\":\"acs:oss:cn-hangzhou:123456789098****:my-movie-bucket/\", \"suffix\":\".txt\"}]}
   */
  filterPattern?: string;
  /**
   * @remarks
   * The status of the event rule. Valid values: ENABLE (default): The event rule is enabled. DISABLE: The event rule is disabled.
   * 
   * @example
   * ENABLE
   */
  status?: string;
  gmtCreate?: string;
  gmtModify?: string;
  static names(): { [key: string]: string } {
    return {
      eventBusName: 'eventBusName',
      eventRuleName: 'eventRuleName',
      description: 'description',
      filterPattern: 'filterPattern',
      status: 'status',
      gmtCreate: 'gmtCreate',
      gmtModify: 'gmtModify',
    };
  }

  static types(): { [key: string]: any } {
    return {
      eventBusName: 'string',
      eventRuleName: 'string',
      description: 'string',
      filterPattern: 'string',
      status: 'string',
      gmtCreate: 'string',
      gmtModify: 'string',
    };
  }

  constructor(map?: { [key: string]: any }) {
    super(map);
  }
}

export class ListEventSourcesResponseBodyEventSources extends $tea.Model {
  /**
   * @remarks
   * The name of the event bus.
   * This parameter is required.
   * 
   * @example
   * demo
   */
  eventBusName?: string;
  /**
   * @remarks
   * EventSource is required for querying default bus events.
   * 
   * @example
   * testEventSourceName
   */
  eventSourceName?: string;
  /**
   * @remarks
   * The description of the event type.
   * 
   * @example
   * The description of the event type.
   */
  description?: string;
  className?: string;
  config?: { [key: string]: any };
  gmtCreate?: string;
  gmtModify?: string;
  static names(): { [key: string]: string } {
    return {
      eventBusName: 'eventBusName',
      eventSourceName: 'eventSourceName',
      description: 'description',
      className: 'className',
      config: 'config',
      gmtCreate: 'gmtCreate',
      gmtModify: 'gmtModify',
    };
  }

  static types(): { [key: string]: any } {
    return {
      eventBusName: 'string',
      eventSourceName: 'string',
      description: 'string',
      className: 'string',
      config: { 'type': 'map', 'keyType': 'string', 'valueType': 'any' },
      gmtCreate: 'string',
      gmtModify: 'string',
    };
  }

  constructor(map?: { [key: string]: any }) {
    super(map);
  }
}

export class EventTargetRunOptionsRetryStrategy extends $tea.Model {
  pushRetryStrategy?: string;
  maximumEventAgeInSeconds?: number;
  maximumRetryAttempts?: number;
  static names(): { [key: string]: string } {
    return {
      pushRetryStrategy: 'pushRetryStrategy',
      maximumEventAgeInSeconds: 'maximumEventAgeInSeconds',
      maximumRetryAttempts: 'maximumRetryAttempts',
    };
  }

  static types(): { [key: string]: any } {
    return {
      pushRetryStrategy: 'string',
      maximumEventAgeInSeconds: 'number',
      maximumRetryAttempts: 'number',
    };
  }

  constructor(map?: { [key: string]: any }) {
    super(map);
  }
}

export class EventTargetRunOptionsDeadLetterQueue extends $tea.Model {
  type?: string;
  config?: { [key: string]: any };
  static names(): { [key: string]: string } {
    return {
      type: 'type',
      config: 'config',
    };
  }

  static types(): { [key: string]: any } {
    return {
      type: 'string',
      config: { 'type': 'map', 'keyType': 'string', 'valueType': 'any' },
    };
  }

  constructor(map?: { [key: string]: any }) {
    super(map);
  }
}

export class EventTargetRunOptions extends $tea.Model {
  errorsTolerance?: string;
  retryStrategy?: EventTargetRunOptionsRetryStrategy;
  deadLetterQueue?: EventTargetRunOptionsDeadLetterQueue;
  static names(): { [key: string]: string } {
    return {
      errorsTolerance: 'errorsTolerance',
      retryStrategy: 'retryStrategy',
      deadLetterQueue: 'deadLetterQueue',
    };
  }

  static types(): { [key: string]: any } {
    return {
      errorsTolerance: 'string',
      retryStrategy: EventTargetRunOptionsRetryStrategy,
      deadLetterQueue: EventTargetRunOptionsDeadLetterQueue,
    };
  }

  constructor(map?: { [key: string]: any }) {
    super(map);
  }
}

export class ListEventTargetsResponseBodyEventTargetsRunOptionsRetryStrategy extends $tea.Model {
  pushRetryStrategy?: string;
  maximumEventAgeInSeconds?: number;
  maximumRetryAttempts?: number;
  static names(): { [key: string]: string } {
    return {
      pushRetryStrategy: 'pushRetryStrategy',
      maximumEventAgeInSeconds: 'maximumEventAgeInSeconds',
      maximumRetryAttempts: 'maximumRetryAttempts',
    };
  }

  static types(): { [key: string]: any } {
    return {
      pushRetryStrategy: 'string',
      maximumEventAgeInSeconds: 'number',
      maximumRetryAttempts: 'number',
    };
  }

  constructor(map?: { [key: string]: any }) {
    super(map);
  }
}

export class ListEventTargetsResponseBodyEventTargetsRunOptionsDeadLetterQueue extends $tea.Model {
  type?: string;
  config?: { [key: string]: any };
  static names(): { [key: string]: string } {
    return {
      type: 'type',
      config: 'config',
    };
  }

  static types(): { [key: string]: any } {
    return {
      type: 'string',
      config: { 'type': 'map', 'keyType': 'string', 'valueType': 'any' },
    };
  }

  constructor(map?: { [key: string]: any }) {
    super(map);
  }
}

export class ListEventTargetsResponseBodyEventTargetsRunOptions extends $tea.Model {
  errorsTolerance?: string;
  retryStrategy?: ListEventTargetsResponseBodyEventTargetsRunOptionsRetryStrategy;
  deadLetterQueue?: ListEventTargetsResponseBodyEventTargetsRunOptionsDeadLetterQueue;
  static names(): { [key: string]: string } {
    return {
      errorsTolerance: 'errorsTolerance',
      retryStrategy: 'retryStrategy',
      deadLetterQueue: 'deadLetterQueue',
    };
  }

  static types(): { [key: string]: any } {
    return {
      errorsTolerance: 'string',
      retryStrategy: ListEventTargetsResponseBodyEventTargetsRunOptionsRetryStrategy,
      deadLetterQueue: ListEventTargetsResponseBodyEventTargetsRunOptionsDeadLetterQueue,
    };
  }

  constructor(map?: { [key: string]: any }) {
    super(map);
  }
}

export class ListEventTargetsResponseBodyEventTargets extends $tea.Model {
  eventTargetName?: string;
  className?: string;
  config?: { [key: string]: any };
  runOptions?: ListEventTargetsResponseBodyEventTargetsRunOptions;
  static names(): { [key: string]: string } {
    return {
      eventTargetName: 'eventTargetName',
      className: 'className',
      config: 'config',
      runOptions: 'runOptions',
    };
  }

  static types(): { [key: string]: any } {
    return {
      eventTargetName: 'string',
      className: 'string',
      config: { 'type': 'map', 'keyType': 'string', 'valueType': 'any' },
      runOptions: ListEventTargetsResponseBodyEventTargetsRunOptions,
    };
  }

  constructor(map?: { [key: string]: any }) {
    super(map);
  }
}

export class ListEventTypesResponseBodyEventTypes extends $tea.Model {
  /**
   * @remarks
   * The name of the event bus.
   * This parameter is required.
   * 
   * @example
   * demo
   */
  eventBusName?: string;
  /**
   * @remarks
   * EventSource is required for querying default bus events.
   * 
   * @example
   * testEventSourceName
   */
  eventSourceName?: string;
  /**
   * @remarks
   * The name of the event type.
   */
  eventTypeName?: string;
  /**
   * @remarks
   * The description of the event type.
   * 
   * @example
   * The description of the event type.
   */
  description?: string;
  gmtCreate?: string;
  gmtModify?: string;
  static names(): { [key: string]: string } {
    return {
      eventBusName: 'eventBusName',
      eventSourceName: 'eventSourceName',
      eventTypeName: 'eventTypeName',
      description: 'description',
      gmtCreate: 'gmtCreate',
      gmtModify: 'gmtModify',
    };
  }

  static types(): { [key: string]: any } {
    return {
      eventBusName: 'string',
      eventSourceName: 'string',
      eventTypeName: 'string',
      description: 'string',
      gmtCreate: 'string',
      gmtModify: 'string',
    };
  }

  constructor(map?: { [key: string]: any }) {
    super(map);
  }
}


export default class Client extends OpenApi {

  constructor(config: $OpenApi.Config) {
    super(config);
    this._endpointRule = "";
    this.checkConfig(config);
    this._endpoint = this.getEndpoint("eventbridge", this._regionId, this._endpointRule, this._network, this._suffix, this._endpointMap, this._endpoint);
  }


  getEndpoint(productId: string, regionId: string, endpointRule: string, network: string, suffix: string, endpointMap: {[key: string ]: string}, endpoint: string): string {
    if (!Util.empty(endpoint)) {
      return endpoint;
    }

    if (!Util.isUnset(endpointMap) && !Util.empty(endpointMap[regionId])) {
      return endpointMap[regionId];
    }

    let result : string = "";
    if (!Util.empty(network) && !Util.equalString(network, "public")) {
      network = `-${network}`;
    } else {
      network = "";
    }

    if (!Util.isUnset(suffix)) {
      suffix = "";
    } else {
      suffix = `-${suffix}`;
    }

    if (Util.equalString(endpointRule, "regional")) {
      if (Util.empty(regionId)) {
        throw $tea.newError({
          message: "RegionId is empty, please set a valid RegionId",
        });
      }

      result = `${productId}${suffix}${network}.${regionId}.aliyuncs.com`;
    } else {
      result = `${productId}${suffix}${network}.aliyuncs.com`;
    }

    return result;
    // return EndpointUtil.getEndpointRules(productId, regionId, endpointRule, network, suffix);
  }

  /**
   * Creates an event bus.
   * 
   * @remarks
   * You can call this API operation to create an event bus.
   * 
   * @param request - CreateEventBusRequest
   * @param runtime - runtime options for this request RuntimeOptions
   * @returns CreateEventBusResponse
   */
  async createEventBusWithOptions(request: CreateEventBusRequest, runtime: $Util.RuntimeOptions): Promise<CreateEventBusResponse> {
    Util.validateModel(request);
    let body : {[key: string ]: any} = { };
    if (!Util.isUnset(request.description)) {
      body["description"] = request.description;
    }

    if (!Util.isUnset(request.eventBusName)) {
      body["eventBusName"] = request.eventBusName;
    }

    let req = new $OpenApi.OpenApiRequest({
      body: Util.toJSONString(body),
    });
    let params = new $OpenApi.Params({
      action: "CreateEventBus",
      version: "2024-07-01",
      protocol: "HTTP",
      pathname: "/bus/createEventBus",
      method: "POST",
      authType: "Anonymous",
      style: "RPC",
      reqBodyType: "json",
      bodyType: "json",
    });
    return $tea.cast<CreateEventBusResponse>(await this.callApi(params, req, runtime), new CreateEventBusResponse({}));
  }

  /**
   * Creates an event bus.
   * 
   * @remarks
   * You can call this API operation to create an event bus.
   * 
   * @param request - CreateEventBusRequest
   * @returns CreateEventBusResponse
   */
  async createEventBus(request: CreateEventBusRequest): Promise<CreateEventBusResponse> {
    let runtime = new $Util.RuntimeOptions({ });
    return await this.createEventBusWithOptions(request, runtime);
  }

  /**
   * Queries the detailed information about an event bus.
   * 
   * @remarks
   * You can call this API operation to query the detailed information about an event bus.
   * 
   * @param request - GetEventBusRequest
   * @param runtime - runtime options for this request RuntimeOptions
   * @returns GetEventBusResponse
   */
  async getEventBusWithOptions(request: GetEventBusRequest, runtime: $Util.RuntimeOptions): Promise<GetEventBusResponse> {
    Util.validateModel(request);
    let body : {[key: string ]: any} = { };
    if (!Util.isUnset(request.eventBusName)) {
      body["eventBusName"] = request.eventBusName;
    }

    let req = new $OpenApi.OpenApiRequest({
      body: Util.toJSONString(body),
    });
    let params = new $OpenApi.Params({
      action: "GetEventBus",
      version: "2024-07-01",
      protocol: "HTTP",
      pathname: "/bus/getEventBus",
      method: "POST",
      authType: "Anonymous",
      style: "RPC",
      reqBodyType: "json",
      bodyType: "json",
    });
    return $tea.cast<GetEventBusResponse>(await this.callApi(params, req, runtime), new GetEventBusResponse({}));
  }

  /**
   * Queries the detailed information about an event bus.
   * 
   * @remarks
   * You can call this API operation to query the detailed information about an event bus.
   * 
   * @param request - GetEventBusRequest
   * @returns GetEventBusResponse
   */
  async getEventBus(request: GetEventBusRequest): Promise<GetEventBusResponse> {
    let runtime = new $Util.RuntimeOptions({ });
    return await this.getEventBusWithOptions(request, runtime);
  }

  /**
   * Queries all event buses.
   * 
   * @remarks
   * You can call this API operation to query all event buses.
   * 
   * @param request - ListEventBusesRequest
   * @param runtime - runtime options for this request RuntimeOptions
   * @returns ListEventBusesResponse
   */
  async listEventBusesWithOptions(request: ListEventBusesRequest, runtime: $Util.RuntimeOptions): Promise<ListEventBusesResponse> {
    Util.validateModel(request);
    let body : {[key: string ]: any} = { };
    if (!Util.isUnset(request.maxResults)) {
      body["maxResults"] = request.maxResults;
    }

    if (!Util.isUnset(request.nextToken)) {
      body["nextToken"] = request.nextToken;
    }

    let req = new $OpenApi.OpenApiRequest({
      body: Util.toJSONString(body),
    });
    let params = new $OpenApi.Params({
      action: "ListEventBuses",
      version: "2024-07-01",
      protocol: "HTTP",
      pathname: "/bus/listEventBuses",
      method: "POST",
      authType: "Anonymous",
      style: "RPC",
      reqBodyType: "json",
      bodyType: "json",
    });
    return $tea.cast<ListEventBusesResponse>(await this.callApi(params, req, runtime), new ListEventBusesResponse({}));
  }

  /**
   * Queries all event buses.
   * 
   * @remarks
   * You can call this API operation to query all event buses.
   * 
   * @param request - ListEventBusesRequest
   * @returns ListEventBusesResponse
   */
  async listEventBuses(request: ListEventBusesRequest): Promise<ListEventBusesResponse> {
    let runtime = new $Util.RuntimeOptions({ });
    return await this.listEventBusesWithOptions(request, runtime);
  }

  /**
   * Deletes an event bus.
   * 
   * @remarks
   * You can call this API operation to delete an event bus.
   * 
   * @param request - DeleteEventBusRequest
   * @param runtime - runtime options for this request RuntimeOptions
   * @returns DeleteEventBusResponse
   */
  async deleteEventBusWithOptions(request: DeleteEventBusRequest, runtime: $Util.RuntimeOptions): Promise<DeleteEventBusResponse> {
    Util.validateModel(request);
    let body : {[key: string ]: any} = { };
    if (!Util.isUnset(request.eventBusName)) {
      body["eventBusName"] = request.eventBusName;
    }

    let req = new $OpenApi.OpenApiRequest({
      body: Util.toJSONString(body),
    });
    let params = new $OpenApi.Params({
      action: "DeleteEventBus",
      version: "2024-07-01",
      protocol: "HTTP",
      pathname: "/bus/deleteEventBus",
      method: "POST",
      authType: "Anonymous",
      style: "RPC",
      reqBodyType: "json",
      bodyType: "json",
    });
    return $tea.cast<DeleteEventBusResponse>(await this.callApi(params, req, runtime), new DeleteEventBusResponse({}));
  }

  /**
   * Deletes an event bus.
   * 
   * @remarks
   * You can call this API operation to delete an event bus.
   * 
   * @param request - DeleteEventBusRequest
   * @returns DeleteEventBusResponse
   */
  async deleteEventBus(request: DeleteEventBusRequest): Promise<DeleteEventBusResponse> {
    let runtime = new $Util.RuntimeOptions({ });
    return await this.deleteEventBusWithOptions(request, runtime);
  }

  /**
   * Creates an API destination.
   * 
   * @remarks
   * You can call this API operation to create an API destination.
   * 
   * @param request - CreateApiDestinationRequest (tmpReq before)
   * @param runtime - runtime options for this request RuntimeOptions
   * @returns CreateApiDestinationResponse
   */
  async createApiDestinationWithOptions(request: CreateApiDestinationRequest, runtime: $Util.RuntimeOptions): Promise<CreateApiDestinationResponse> {
    Util.validateModel(request);
    let body : {[key: string ]: any} = { };
    if (!Util.isUnset(request.apiDestinationName)) {
      body["apiDestinationName"] = request.apiDestinationName;
    }

    if (!Util.isUnset(request.connectionName)) {
      body["connectionName"] = request.connectionName;
    }

    if (!Util.isUnset(request.description)) {
      body["description"] = request.description;
    }

    if (!Util.isUnset(request.httpApiParameters)) {
      body["httpApiParameters"] = request.httpApiParameters;
    }

    if (!Util.isUnset(request.invocationRateLimitPerSecond)) {
      body["invocationRateLimitPerSecond"] = request.invocationRateLimitPerSecond;
    }

    let req = new $OpenApi.OpenApiRequest({
      body: Util.toJSONString(body),
    });
    let params = new $OpenApi.Params({
      action: "CreateApiDestination",
      version: "2024-07-01",
      protocol: "HTTP",
      pathname: "/api-destination/createApiDestination",
      method: "POST",
      authType: "Anonymous",
      style: "RPC",
      reqBodyType: "json",
      bodyType: "json",
    });
    return $tea.cast<CreateApiDestinationResponse>(await this.callApi(params, req, runtime), new CreateApiDestinationResponse({}));
  }

  /**
   * Creates an API destination.
   * 
   * @remarks
   * You can call this API operation to create an API destination.
   * 
   * @param request - CreateApiDestinationRequest
   * @returns CreateApiDestinationResponse
   */
  async createApiDestination(request: CreateApiDestinationRequest): Promise<CreateApiDestinationResponse> {
    let runtime = new $Util.RuntimeOptions({ });
    return await this.createApiDestinationWithOptions(request, runtime);
  }

  /**
   * Updates an API destination.
   * 
   * @remarks
   * You can call this API operation to update an API destination.
   * 
   * @param request - UpdateApiDestinationRequest
   * @param runtime - runtime options for this request RuntimeOptions
   * @returns UpdateApiDestinationResponse
   */
  async updateApiDestinationWithOptions(request: UpdateApiDestinationRequest, runtime: $Util.RuntimeOptions): Promise<UpdateApiDestinationResponse> {
    Util.validateModel(request);
    let body : {[key: string ]: any} = { };
    if (!Util.isUnset(request.apiDestinationName)) {
      body["apiDestinationName"] = request.apiDestinationName;
    }

    if (!Util.isUnset(request.connectionName)) {
      body["connectionName"] = request.connectionName;
    }

    if (!Util.isUnset(request.description)) {
      body["description"] = request.description;
    }

    if (!Util.isUnset(request.httpApiParameters)) {
      body["httpApiParameters"] = request.httpApiParameters;
    }

    if (!Util.isUnset(request.invocationRateLimitPerSecond)) {
      body["invocationRateLimitPerSecond"] = request.invocationRateLimitPerSecond;
    }

    let req = new $OpenApi.OpenApiRequest({
      body: Util.toJSONString(body),
    });
    let params = new $OpenApi.Params({
      action: "UpdateApiDestination",
      version: "2024-07-01",
      protocol: "HTTP",
      pathname: "/api-destination/updateApiDestination",
      method: "POST",
      authType: "Anonymous",
      style: "RPC",
      reqBodyType: "json",
      bodyType: "json",
    });
    return $tea.cast<UpdateApiDestinationResponse>(await this.callApi(params, req, runtime), new UpdateApiDestinationResponse({}));
  }

  /**
   * Updates an API destination.
   * 
   * @remarks
   * You can call this API operation to update an API destination.
   * 
   * @param request - UpdateApiDestinationRequest
   * @returns UpdateApiDestinationResponse
   */
  async updateApiDestination(request: UpdateApiDestinationRequest): Promise<UpdateApiDestinationResponse> {
    let runtime = new $Util.RuntimeOptions({ });
    return await this.updateApiDestinationWithOptions(request, runtime);
  }

  /**
   * Queries the information about an API destination.
   * 
   * @remarks
   * You can call this API operation to query the information about an API destination.
   * 
   * @param request - GetApiDestinationRequest
   * @param runtime - runtime options for this request RuntimeOptions
   * @returns GetApiDestinationResponse
   */
  async getApiDestinationWithOptions(request: GetApiDestinationRequest, runtime: $Util.RuntimeOptions): Promise<GetApiDestinationResponse> {
    Util.validateModel(request);
    let body : {[key: string ]: any} = { };
    if (!Util.isUnset(request.apiDestinationName)) {
      body["apiDestinationName"] = request.apiDestinationName;
    }

    let req = new $OpenApi.OpenApiRequest({
      body: Util.toJSONString(body),
    });
    let params = new $OpenApi.Params({
      action: "GetApiDestination",
      version: "2024-07-01",
      protocol: "HTTP",
      pathname: "/api-destination/getApiDestination",
      method: "POST",
      authType: "Anonymous",
      style: "RPC",
      reqBodyType: "json",
      bodyType: "json",
    });
    return $tea.cast<GetApiDestinationResponse>(await this.callApi(params, req, runtime), new GetApiDestinationResponse({}));
  }

  /**
   * Queries the information about an API destination.
   * 
   * @remarks
   * You can call this API operation to query the information about an API destination.
   * 
   * @param request - GetApiDestinationRequest
   * @returns GetApiDestinationResponse
   */
  async getApiDestination(request: GetApiDestinationRequest): Promise<GetApiDestinationResponse> {
    let runtime = new $Util.RuntimeOptions({ });
    return await this.getApiDestinationWithOptions(request, runtime);
  }

  /**
   * Deletes an API destination.
   * 
   * @remarks
   * You can call this API operation to delete an API destination.
   * 
   * @param request - DeleteApiDestinationRequest
   * @param runtime - runtime options for this request RuntimeOptions
   * @returns DeleteApiDestinationResponse
   */
  async deleteApiDestinationWithOptions(request: DeleteApiDestinationRequest, runtime: $Util.RuntimeOptions): Promise<DeleteApiDestinationResponse> {
    Util.validateModel(request);
    let body : {[key: string ]: any} = { };
    if (!Util.isUnset(request.apiDestinationName)) {
      body["apiDestinationName"] = request.apiDestinationName;
    }

    let req = new $OpenApi.OpenApiRequest({
      body: Util.toJSONString(body),
    });
    let params = new $OpenApi.Params({
      action: "DeleteApiDestination",
      version: "2024-07-01",
      protocol: "HTTP",
      pathname: "/api-destination/deleteApiDestination",
      method: "POST",
      authType: "Anonymous",
      style: "RPC",
      reqBodyType: "json",
      bodyType: "json",
    });
    return $tea.cast<DeleteApiDestinationResponse>(await this.callApi(params, req, runtime), new DeleteApiDestinationResponse({}));
  }

  /**
   * Deletes an API destination.
   * 
   * @remarks
   * You can call this API operation to delete an API destination.
   * 
   * @param request - DeleteApiDestinationRequest
   * @returns DeleteApiDestinationResponse
   */
  async deleteApiDestination(request: DeleteApiDestinationRequest): Promise<DeleteApiDestinationResponse> {
    let runtime = new $Util.RuntimeOptions({ });
    return await this.deleteApiDestinationWithOptions(request, runtime);
  }

  /**
   * Queries a list of API destinations.
   * 
   * @remarks
   * You can use this API operation to query a list of API destinations.
   * 
   * @param request - ListApiDestinationsRequest
   * @param runtime - runtime options for this request RuntimeOptions
   * @returns ListApiDestinationsResponse
   */
  async listApiDestinationsWithOptions(request: ListApiDestinationsRequest, runtime: $Util.RuntimeOptions): Promise<ListApiDestinationsResponse> {
    Util.validateModel(request);
    let body : {[key: string ]: any} = { };
    if (!Util.isUnset(request.apiDestinationNamePrefix)) {
      body["apiDestinationNamePrefix"] = request.apiDestinationNamePrefix;
    }

    if (!Util.isUnset(request.connectionName)) {
      body["connectionName"] = request.connectionName;
    }

    if (!Util.isUnset(request.maxResults)) {
      body["maxResults"] = request.maxResults;
    }

    if (!Util.isUnset(request.nextToken)) {
      body["nextToken"] = request.nextToken;
    }

    let req = new $OpenApi.OpenApiRequest({
      body: Util.toJSONString(body),
    });
    let params = new $OpenApi.Params({
      action: "ListApiDestinations",
      version: "2024-07-01",
      protocol: "HTTP",
      pathname: "/api-destination/listApiDestinations",
      method: "POST",
      authType: "Anonymous",
      style: "RPC",
      reqBodyType: "json",
      bodyType: "json",
    });
    return $tea.cast<ListApiDestinationsResponse>(await this.callApi(params, req, runtime), new ListApiDestinationsResponse({}));
  }

  /**
   * Queries a list of API destinations.
   * 
   * @remarks
   * You can use this API operation to query a list of API destinations.
   * 
   * @param request - ListApiDestinationsRequest
   * @returns ListApiDestinationsResponse
   */
  async listApiDestinations(request: ListApiDestinationsRequest): Promise<ListApiDestinationsResponse> {
    let runtime = new $Util.RuntimeOptions({ });
    return await this.listApiDestinationsWithOptions(request, runtime);
  }

  /**
   * Creates a connection.
   * 
   * @remarks
   * You can call this API operation to create a connection.
   * 
   * @param request - CreateConnectionRequest
   * @param runtime - runtime options for this request RuntimeOptions
   * @returns CreateConnectionResponse
   */
  async createConnectionWithOptions(request: CreateConnectionRequest, runtime: $Util.RuntimeOptions): Promise<CreateConnectionResponse> {
    Util.validateModel(request);
    let body : {[key: string ]: any} = { };
    if (!Util.isUnset(request.authParameters)) {
      body["authParameters"] = request.authParameters;
    }

    if (!Util.isUnset(request.connectionName)) {
      body["connectionName"] = request.connectionName;
    }

    if (!Util.isUnset(request.description)) {
      body["description"] = request.description;
    }

    if (!Util.isUnset(request.networkParameters)) {
      body["networkParameters"] = request.networkParameters;
    }

    let req = new $OpenApi.OpenApiRequest({
      body: Util.toJSONString(body),
    });
    let params = new $OpenApi.Params({
      action: "CreateConnection",
      version: "2024-07-01",
      protocol: "HTTP",
      pathname: "/connection/createConnection",
      method: "POST",
      authType: "Anonymous",
      style: "RPC",
      reqBodyType: "json",
      bodyType: "json",
    });
    return $tea.cast<CreateConnectionResponse>(await this.callApi(params, req, runtime), new CreateConnectionResponse({}));
  }

  /**
   * Creates a connection.
   * 
   * @remarks
   * You can call this API operation to create a connection.
   * 
   * @param request - CreateConnectionRequest
   * @returns CreateConnectionResponse
   */
  async createConnection(request: CreateConnectionRequest): Promise<CreateConnectionResponse> {
    let runtime = new $Util.RuntimeOptions({ });
    return await this.createConnectionWithOptions(request, runtime);
  }

  /**
   * Deletes a connection.
   * 
   * @remarks
   * You can call this API operation to delete a connection.
   * 
   * @param request - DeleteConnectionRequest
   * @param runtime - runtime options for this request RuntimeOptions
   * @returns DeleteConnectionResponse
   */
  async deleteConnectionWithOptions(request: DeleteConnectionRequest, runtime: $Util.RuntimeOptions): Promise<DeleteConnectionResponse> {
    Util.validateModel(request);
    let body : {[key: string ]: any} = { };
    if (!Util.isUnset(request.connectionName)) {
      body["connectionName"] = request.connectionName;
    }

    let req = new $OpenApi.OpenApiRequest({
      body: Util.toJSONString(body),
    });
    let params = new $OpenApi.Params({
      action: "DeleteConnection",
      version: "2024-07-01",
      protocol: "HTTP",
      pathname: "/connection/deleteConnection",
      method: "POST",
      authType: "Anonymous",
      style: "RPC",
      reqBodyType: "json",
      bodyType: "json",
    });
    return $tea.cast<DeleteConnectionResponse>(await this.callApi(params, req, runtime), new DeleteConnectionResponse({}));
  }

  /**
   * Deletes a connection.
   * 
   * @remarks
   * You can call this API operation to delete a connection.
   * 
   * @param request - DeleteConnectionRequest
   * @returns DeleteConnectionResponse
   */
  async deleteConnection(request: DeleteConnectionRequest): Promise<DeleteConnectionResponse> {
    let runtime = new $Util.RuntimeOptions({ });
    return await this.deleteConnectionWithOptions(request, runtime);
  }

  /**
   * Updates a connection.
   * 
   * @remarks
   * You can call this API operation to update a connection.
   * 
   * @param request - UpdateConnectionRequest
   * @param runtime - runtime options for this request RuntimeOptions
   * @returns UpdateConnectionResponse
   */
  async updateConnectionWithOptions(request: UpdateConnectionRequest, runtime: $Util.RuntimeOptions): Promise<UpdateConnectionResponse> {
    Util.validateModel(request);
    let body : {[key: string ]: any} = { };
    if (!Util.isUnset(request.authParameters)) {
      body["authParameters"] = request.authParameters;
    }

    if (!Util.isUnset(request.connectionName)) {
      body["connectionName"] = request.connectionName;
    }

    if (!Util.isUnset(request.description)) {
      body["description"] = request.description;
    }

    if (!Util.isUnset(request.networkParameters)) {
      body["networkParameters"] = request.networkParameters;
    }

    let req = new $OpenApi.OpenApiRequest({
      body: Util.toJSONString(body),
    });
    let params = new $OpenApi.Params({
      action: "UpdateConnection",
      version: "2024-07-01",
      protocol: "HTTP",
      pathname: "/connection/updateConnection",
      method: "POST",
      authType: "Anonymous",
      style: "RPC",
      reqBodyType: "json",
      bodyType: "json",
    });
    return $tea.cast<UpdateConnectionResponse>(await this.callApi(params, req, runtime), new UpdateConnectionResponse({}));
  }

  /**
   * Updates a connection.
   * 
   * @remarks
   * You can call this API operation to update a connection.
   * 
   * @param request - UpdateConnectionRequest
   * @returns UpdateConnectionResponse
   */
  async updateConnection(request: UpdateConnectionRequest): Promise<UpdateConnectionResponse> {
    let runtime = new $Util.RuntimeOptions({ });
    return await this.updateConnectionWithOptions(request, runtime);
  }

  /**
   * Queries the configurations of a connection.
   * 
   * @remarks
   * You can call this API operation to query the configurations of a connection.
   * 
   * @param request - GetConnectionRequest
   * @param runtime - runtime options for this request RuntimeOptions
   * @returns GetConnectionResponse
   */
  async getConnectionWithOptions(request: GetConnectionRequest, runtime: $Util.RuntimeOptions): Promise<GetConnectionResponse> {
    Util.validateModel(request);
    let body : {[key: string ]: any} = { };
    if (!Util.isUnset(request.connectionName)) {
      body["connectionName"] = request.connectionName;
    }

    let req = new $OpenApi.OpenApiRequest({
      body: Util.toJSONString(body),
    });
    let params = new $OpenApi.Params({
      action: "GetConnection",
      version: "2024-07-01",
      protocol: "HTTP",
      pathname: "/connection/getConnection",
      method: "POST",
      authType: "Anonymous",
      style: "RPC",
      reqBodyType: "json",
      bodyType: "json",
    });
    return $tea.cast<GetConnectionResponse>(await this.callApi(params, req, runtime), new GetConnectionResponse({}));
  }

  /**
   * Queries the configurations of a connection.
   * 
   * @remarks
   * You can call this API operation to query the configurations of a connection.
   * 
   * @param request - GetConnectionRequest
   * @returns GetConnectionResponse
   */
  async getConnection(request: GetConnectionRequest): Promise<GetConnectionResponse> {
    let runtime = new $Util.RuntimeOptions({ });
    return await this.getConnectionWithOptions(request, runtime);
  }

  /**
   * Queries the configurations of a connection.
   * 
   * @remarks
   * You can call this API operation to query the configurations of a connection.
   * 
   * @param request - GetConnectionRequest
   * @param runtime - runtime options for this request RuntimeOptions
   * @returns GetConnectionResponse
   */
  async selectOneConnectionWithOptions(request: GetConnectionRequest, runtime: $Util.RuntimeOptions): Promise<GetConnectionResponse> {
    Util.validateModel(request);
    let body : {[key: string ]: any} = { };
    if (!Util.isUnset(request.connectionName)) {
      body["connectionName"] = request.connectionName;
    }

    let req = new $OpenApi.OpenApiRequest({
      body: Util.toJSONString(body),
    });
    let params = new $OpenApi.Params({
      action: "selectOneConnection",
      version: "2024-07-01",
      protocol: "HTTP",
      pathname: "/connection/selectOneConnection",
      method: "POST",
      authType: "Anonymous",
      style: "RPC",
      reqBodyType: "json",
      bodyType: "json",
    });
    return $tea.cast<GetConnectionResponse>(await this.callApi(params, req, runtime), new GetConnectionResponse({}));
  }

  /**
   * Queries the configurations of a connection.
   * 
   * @remarks
   * You can call this API operation to query the configurations of a connection.
   * 
   * @param request - GetConnectionRequest
   * @returns GetConnectionResponse
   */
  async selectOneConnection(request: GetConnectionRequest): Promise<GetConnectionResponse> {
    let runtime = new $Util.RuntimeOptions({ });
    return await this.selectOneConnectionWithOptions(request, runtime);
  }

  /**
   * Queries connections.
   * 
   * @remarks
   * You can call this API operation to query connections.
   * 
   * @param request - ListConnectionsRequest
   * @param runtime - runtime options for this request RuntimeOptions
   * @returns ListConnectionsResponse
   */
  async listConnectionsWithOptions(request: ListConnectionsRequest, runtime: $Util.RuntimeOptions): Promise<ListConnectionsResponse> {
    Util.validateModel(request);
    let body : {[key: string ]: any} = { };
    if (!Util.isUnset(request.connectionNamePrefix)) {
      body["connectionNamePrefix"] = request.connectionNamePrefix;
    }

    if (!Util.isUnset(request.maxResults)) {
      body["maxResults"] = request.maxResults;
    }

    if (!Util.isUnset(request.nextToken)) {
      body["nextToken"] = request.nextToken;
    }

    let req = new $OpenApi.OpenApiRequest({
      body: Util.toJSONString(body),
    });
    let params = new $OpenApi.Params({
      action: "ListConnections",
      version: "2024-07-01",
      protocol: "HTTP",
      pathname: "/connection/listConnections",
      method: "POST",
      authType: "Anonymous",
      style: "RPC",
      reqBodyType: "json",
      bodyType: "json",
    });
    return $tea.cast<ListConnectionsResponse>(await this.callApi(params, req, runtime), new ListConnectionsResponse({}));
  }

  /**
   * list connections.
   * 
   * @remarks
   * You can call this API operation to list connections.
   * 
   * @param request - ListConnectionsRequest
   * @returns ListConnectionsResponse
   */
  async listConnections(request: ListConnectionsRequest): Promise<ListConnectionsResponse> {
    let runtime = new $Util.RuntimeOptions({ });
    return await this.listConnectionsWithOptions(request, runtime);
  }

  /**
   * Updates a connection.
   * 
   * @remarks
   * You can call this API operation to update a connection.
   * @returns ListEnumsResponseResponse
   */
  async listEnumsResponse(): Promise<ListEnumsResponseResponse> {
    let runtime = new $Util.RuntimeOptions({ });
    let body : {[key: string ]: any} = { };
    let req = new $OpenApi.OpenApiRequest({
      body: Util.toJSONString(body),
    });
    let params = new $OpenApi.Params({
      action: "listEnumsResponse",
      version: "2024-07-01",
      protocol: "HTTP",
      pathname: "/connection/listEnumsResponse",
      method: "POST",
      authType: "Anonymous",
      style: "RPC",
      reqBodyType: "json",
      bodyType: "json",
    });
    return $tea.cast<ListEnumsResponseResponse>(await this.callApi(params, req, runtime), new ListEnumsResponseResponse({}));
  }

  /**
   * Queries the content of an event.
   * 
   * @remarks
   * You can call this API operation to query the content of an event.
   * 
   * @param request - PutEventsRequest
   * @param runtime - runtime options for this request RuntimeOptions
   * @returns PutEventsResponse
   */
  async putEventsWithOptions(request: PutEventsRequest, runtime: $Util.RuntimeOptions): Promise<PutEventsResponse> {
    Util.validateModel(request);
    let headers : {[key: string ]: string} = {
      'ce-specversion': "1.0",
      'ce-type': "com.github.pull_request.opened",
      'ce-source': "https://github.com/cloudevents/spec/pull",
      'ce-subject': "demo",
      'ce-id': "1234-1234-1234",
      'ce-datacontenttype': "application/json",
      'ce-time': "2024-07-01T17:31:00Z",
      'ce-eventbusname': "demo-bus",
    };
    let body : string = "{}";
    if (!Util.isUnset(request.eventBusName)) {
      headers["ce-eventbusname"] = request.eventBusName;
    }

    if (!Util.isUnset(request.event)) {
      body = request.event;
    }

    let req = new $OpenApi.OpenApiRequest({
      body: body,
      headers: headers,
    });
    let params = new $OpenApi.Params({
      action: "putEvents",
      version: "2024-07-01",
      protocol: "HTTP",
      pathname: "/putEvents",
      method: "POST",
      authType: "Anonymous",
      style: "RPC",
      reqBodyType: "json",
      bodyType: "json",
    });
    return $tea.cast<PutEventsResponse>(await this.callApi(params, req, runtime), new PutEventsResponse({}));
  }

  /**
   * Queries the content of an event.
   * 
   * @remarks
   * You can call this API operation to query the content of an event.
   * 
   * @param request - PutEventsRequest
   * @returns PutEventsResponse
   */
  async putEvents(request: PutEventsRequest): Promise<PutEventsResponse> {
    let runtime = new $Util.RuntimeOptions({ });
    return await this.putEventsWithOptions(request, runtime);
  }

  /**
   * Creates an event rule.
   * 
   * @remarks
   * You can call this operation to create an event rule.
   * 
   * @param request - CreateEventRuleRequest
   * @param runtime - runtime options for this request RuntimeOptions
   * @returns CreateEventRuleResponse
   */
  async createEventRuleWithOptions(request: CreateEventRuleRequest, runtime: $Util.RuntimeOptions): Promise<CreateEventRuleResponse> {
    Util.validateModel(request);
    let body : {[key: string ]: any} = { };
    if (!Util.isUnset(request.eventBusName)) {
      body["eventBusName"] = request.eventBusName;
    }

    if (!Util.isUnset(request.eventRuleName)) {
      body["eventRuleName"] = request.eventRuleName;
    }

    if (!Util.isUnset(request.description)) {
      body["description"] = request.description;
    }

    if (!Util.isUnset(request.filterPattern)) {
      body["filterPattern"] = request.filterPattern;
    }

    let req = new $OpenApi.OpenApiRequest({
      body: Util.toJSONString(body),
    });
    let params = new $OpenApi.Params({
      action: "CreateEventRule",
      version: "2024-07-01",
      protocol: "HTTP",
      pathname: "/rule/createEventRule",
      method: "POST",
      authType: "Anonymous",
      style: "RPC",
      reqBodyType: "json",
      bodyType: "json",
    });
    return $tea.cast<CreateEventRuleResponse>(await this.callApi(params, req, runtime), new CreateEventRuleResponse({}));
  }

  /**
   * Creates an event rule.
   * 
   * @remarks
   * You can call this operation to create an event rule.
   * 
   * @param request - CreateEventRuleRequest
   * @returns CreateEventRuleResponse
   */
  async createEventRule(request: CreateEventRuleRequest): Promise<CreateEventRuleResponse> {
    let runtime = new $Util.RuntimeOptions({ });
    return await this.createEventRuleWithOptions(request, runtime);
  }

  /**
   * Gets an event rule.
   * 
   * @remarks
   * You can call this operation to get an event rule.
   * 
   * @param request - GetEventRuleRequest
   * @param runtime - runtime options for this request RuntimeOptions
   * @returns GetEventRuleResponse
   */
  async getEventRuleWithOptions(request: GetEventRuleRequest, runtime: $Util.RuntimeOptions): Promise<GetEventRuleResponse> {
    Util.validateModel(request);
    let body : {[key: string ]: any} = { };
    if (!Util.isUnset(request.eventBusName)) {
      body["eventBusName"] = request.eventBusName;
    }

    if (!Util.isUnset(request.eventRuleName)) {
      body["eventRuleName"] = request.eventRuleName;
    }

    let req = new $OpenApi.OpenApiRequest({
      body: Util.toJSONString(body),
    });
    let params = new $OpenApi.Params({
      action: "GetEventRule",
      version: "2024-07-01",
      protocol: "HTTP",
      pathname: "/rule/getEventRule",
      method: "POST",
      authType: "Anonymous",
      style: "RPC",
      reqBodyType: "json",
      bodyType: "json",
    });
    return $tea.cast<GetEventRuleResponse>(await this.callApi(params, req, runtime), new GetEventRuleResponse({}));
  }

  /**
   * Gets an event rule.
   * 
   * @remarks
   * You can call this operation to get an event rule.
   * 
   * @param request - GetEventRuleRequest
   * @returns GetEventRuleResponse
   */
  async getEventRule(request: GetEventRuleRequest): Promise<GetEventRuleResponse> {
    let runtime = new $Util.RuntimeOptions({ });
    return await this.getEventRuleWithOptions(request, runtime);
  }

  /**
   * Deletes an event rule.
   * 
   * @remarks
   * You can call this operation to delete an event rule.
   * 
   * @param request - DeleteEventRuleRequest
   * @param runtime - runtime options for this request RuntimeOptions
   * @returns DeleteEventRuleResponse
   */
  async deleteEventRuleWithOptions(request: DeleteEventRuleRequest, runtime: $Util.RuntimeOptions): Promise<DeleteEventRuleResponse> {
    Util.validateModel(request);
    let body : {[key: string ]: any} = { };
    if (!Util.isUnset(request.eventBusName)) {
      body["eventBusName"] = request.eventBusName;
    }

    if (!Util.isUnset(request.eventRuleName)) {
      body["eventRuleName"] = request.eventRuleName;
    }

    let req = new $OpenApi.OpenApiRequest({
      body: Util.toJSONString(body),
    });
    let params = new $OpenApi.Params({
      action: "DeleteEventRule",
      version: "2024-07-01",
      protocol: "HTTP",
      pathname: "/rule/deleteEventRule",
      method: "POST",
      authType: "Anonymous",
      style: "RPC",
      reqBodyType: "json",
      bodyType: "json",
    });
    return $tea.cast<DeleteEventRuleResponse>(await this.callApi(params, req, runtime), new DeleteEventRuleResponse({}));
  }

  /**
   * Deletes an event rule.
   * 
   * @remarks
   * You can call this operation to delete an event rule.
   * 
   * @param request - DeleteEventRuleRequest
   * @returns DeleteEventRuleResponse
   */
  async deleteEventRule(request: DeleteEventRuleRequest): Promise<DeleteEventRuleResponse> {
    let runtime = new $Util.RuntimeOptions({ });
    return await this.deleteEventRuleWithOptions(request, runtime);
  }

  /**
   * Updates an event rule.
   * 
   * @remarks
   * You can call this operation to update an event rule.
   * 
   * @param request - UpdateEventRuleRequest
   * @param runtime - runtime options for this request RuntimeOptions
   * @returns UpdateEventRuleResponse
   */
  async updateEventRuleWithOptions(request: UpdateEventRuleRequest, runtime: $Util.RuntimeOptions): Promise<UpdateEventRuleResponse> {
    Util.validateModel(request);
    let body : {[key: string ]: any} = { };
    if (!Util.isUnset(request.eventBusName)) {
      body["eventBusName"] = request.eventBusName;
    }

    if (!Util.isUnset(request.eventRuleName)) {
      body["eventRuleName"] = request.eventRuleName;
    }

    if (!Util.isUnset(request.description)) {
      body["description"] = request.description;
    }

    if (!Util.isUnset(request.filterPattern)) {
      body["filterPattern"] = request.filterPattern;
    }

    let req = new $OpenApi.OpenApiRequest({
      body: Util.toJSONString(body),
    });
    let params = new $OpenApi.Params({
      action: "UpdateEventRule",
      version: "2024-07-01",
      protocol: "HTTP",
      pathname: "/rule/updateEventRule",
      method: "POST",
      authType: "Anonymous",
      style: "RPC",
      reqBodyType: "json",
      bodyType: "json",
    });
    return $tea.cast<UpdateEventRuleResponse>(await this.callApi(params, req, runtime), new UpdateEventRuleResponse({}));
  }

  /**
   * Updates an event rule.
   * 
   * @remarks
   * You can call this operation to update an event rule.
   * 
   * @param request - UpdateEventRuleRequest
   * @returns UpdateEventRuleResponse
   */
  async updateEventRule(request: UpdateEventRuleRequest): Promise<UpdateEventRuleResponse> {
    let runtime = new $Util.RuntimeOptions({ });
    return await this.updateEventRuleWithOptions(request, runtime);
  }

  /**
   * Lists event rules.
   * 
   * @remarks
   * You can call this operation to list event rules.
   * 
   * @param request - ListEventRulesRequest
   * @param runtime - runtime options for this request RuntimeOptions
   * @returns ListEventRulesResponse
   */
  async listEventRulesWithOptions(request: ListEventRulesRequest, runtime: $Util.RuntimeOptions): Promise<ListEventRulesResponse> {
    Util.validateModel(request);
    let body : {[key: string ]: any} = { };
    if (!Util.isUnset(request.eventBusName)) {
      body["eventBusName"] = request.eventBusName;
    }

    if (!Util.isUnset(request.maxResults)) {
      body["maxResults"] = request.maxResults;
    }

    if (!Util.isUnset(request.nextToken)) {
      body["nextToken"] = request.nextToken;
    }

    let req = new $OpenApi.OpenApiRequest({
      body: Util.toJSONString(body),
    });
    let params = new $OpenApi.Params({
      action: "ListEventRules",
      version: "2024-07-01",
      protocol: "HTTP",
      pathname: "/rule/listEventRules",
      method: "POST",
      authType: "Anonymous",
      style: "RPC",
      reqBodyType: "json",
      bodyType: "json",
    });
    return $tea.cast<ListEventRulesResponse>(await this.callApi(params, req, runtime), new ListEventRulesResponse({}));
  }

  /**
   * Lists event rules.
   * 
   * @remarks
   * You can call this operation to list event rules.
   * 
   * @param request - ListEventRulesRequest
   * @returns ListEventRulesResponse
   */
  async listEventRules(request: ListEventRulesRequest): Promise<ListEventRulesResponse> {
    let runtime = new $Util.RuntimeOptions({ });
    return await this.listEventRulesWithOptions(request, runtime);
  }

  /**
   * Enables an event rule.
   * 
   * @remarks
   * You can call this operation to enable an event rule.
   * 
   * @param request - EnableEventRuleRequest
   * @param runtime - runtime options for this request RuntimeOptions
   * @returns EnableEventRuleResponse
   */
  async enableEventRuleWithOptions(request: EnableEventRuleRequest, runtime: $Util.RuntimeOptions): Promise<EnableEventRuleResponse> {
    Util.validateModel(request);
    let body : {[key: string ]: any} = { };
    if (!Util.isUnset(request.eventBusName)) {
      body["eventBusName"] = request.eventBusName;
    }

    if (!Util.isUnset(request.eventRuleName)) {
      body["eventRuleName"] = request.eventRuleName;
    }

    let req = new $OpenApi.OpenApiRequest({
      body: Util.toJSONString(body),
    });
    let params = new $OpenApi.Params({
      action: "EnableEventRule",
      version: "2024-07-01",
      protocol: "HTTP",
      pathname: "/rule/enableEventRule",
      method: "POST",
      authType: "Anonymous",
      style: "RPC",
      reqBodyType: "json",
      bodyType: "json",
    });
    return $tea.cast<EnableEventRuleResponse>(await this.callApi(params, req, runtime), new EnableEventRuleResponse({}));
  }

  /**
   * Enables an event rule.
   * 
   * @remarks
   * You can call this operation to enable an event rule.
   * 
   * @param request - EnableEventRuleRequest
   * @returns EnableEventRuleResponse
   */
  async enableEventRule(request: EnableEventRuleRequest): Promise<EnableEventRuleResponse> {
    let runtime = new $Util.RuntimeOptions({ });
    return await this.enableEventRuleWithOptions(request, runtime);
  }

  /**
   * Disables an event rule.
   * 
   * @remarks
   * You can call this operation to disable an event rule.
   * 
   * @param request - DisableEventRuleRequest
   * @param runtime - runtime options for this request RuntimeOptions
   * @returns DisableEventRuleResponse
   */
  async disableEventRuleWithOptions(request: DisableEventRuleRequest, runtime: $Util.RuntimeOptions): Promise<DisableEventRuleResponse> {
    Util.validateModel(request);
    let body : {[key: string ]: any} = { };
    if (!Util.isUnset(request.eventBusName)) {
      body["eventBusName"] = request.eventBusName;
    }

    if (!Util.isUnset(request.eventRuleName)) {
      body["eventRuleName"] = request.eventRuleName;
    }

    let req = new $OpenApi.OpenApiRequest({
      body: Util.toJSONString(body),
    });
    let params = new $OpenApi.Params({
      action: "DisableEventRule",
      version: "2024-07-01",
      protocol: "HTTP",
      pathname: "/rule/disableEventRule",
      method: "POST",
      authType: "Anonymous",
      style: "RPC",
      reqBodyType: "json",
      bodyType: "json",
    });
    return $tea.cast<DisableEventRuleResponse>(await this.callApi(params, req, runtime), new DisableEventRuleResponse({}));
  }

  /**
   * Disables an event rule.
   * 
   * @remarks
   * You can call this operation to disable an event rule.
   * 
   * @param request - DisableEventRuleRequest
   * @returns DisableEventRuleResponse
   */
  async disableEventRule(request: DisableEventRuleRequest): Promise<DisableEventRuleResponse> {
    let runtime = new $Util.RuntimeOptions({ });
    return await this.disableEventRuleWithOptions(request, runtime);
  }

  /**
   * Creates an event source.
   * 
   * @remarks
   * You can call this operation to create an event source.
   * 
   * @param request - CreateEventSourceRequest
   * @param runtime - runtime options for this request RuntimeOptions
   * @returns CreateEventSourceResponse
   */
  async createEventSourceWithOptions(request: CreateEventSourceRequest, runtime: $Util.RuntimeOptions): Promise<CreateEventSourceResponse> {
    Util.validateModel(request);
    let body : {[key: string ]: any} = { };
    if (!Util.isUnset(request.description)) {
      body["description"] = request.description;
    }

    if (!Util.isUnset(request.eventBusName)) {
      body["eventBusName"] = request.eventBusName;
    }

    if (!Util.isUnset(request.eventSourceName)) {
      body["eventSourceName"] = request.eventSourceName;
    }

    if (!Util.isUnset(request.className)) {
      body["className"] = request.className;
    }

    if (!Util.isUnset(request.config)) {
      body["config"] = request.config;
    }

    let req = new $OpenApi.OpenApiRequest({
      body: Util.toJSONString(body),
    });
    let params = new $OpenApi.Params({
      action: "CreateEventSource",
      version: "2024-07-01",
      protocol: "HTTP",
      pathname: "/source/createEventSource",
      method: "POST",
      authType: "Anonymous",
      style: "RPC",
      reqBodyType: "json",
      bodyType: "json",
    });
    return $tea.cast<CreateEventSourceResponse>(await this.callApi(params, req, runtime), new CreateEventSourceResponse({}));
  }

  /**
   * Creates an event source.
   * 
   * @remarks
   * You can call this operation to create an event source.
   * 
   * @param request - CreateEventSourceRequest
   * @returns CreateEventSourceResponse
   */
  async createEventSource(request: CreateEventSourceRequest): Promise<CreateEventSourceResponse> {
    let runtime = new $Util.RuntimeOptions({ });
    return await this.createEventSourceWithOptions(request, runtime);
  }

  /**
   * Updates an event source.
   * 
   * @remarks
   * You can call this operation to update an event source.
   * 
   * @param request - UpdateEventSourceRequest
   * @param runtime - runtime options for this request RuntimeOptions
   * @returns UpdateEventSourceResponse
   */
  async updateEventSourceWithOptions(request: UpdateEventSourceRequest, runtime: $Util.RuntimeOptions): Promise<UpdateEventSourceResponse> {
    Util.validateModel(request);
    let body : {[key: string ]: any} = { };
    if (!Util.isUnset(request.eventBusName)) {
      body["eventBusName"] = request.eventBusName;
    }

    if (!Util.isUnset(request.eventSourceName)) {
      body["eventSourceName"] = request.eventSourceName;
    }

    if (!Util.isUnset(request.description)) {
      body["description"] = request.description;
    }

    if (!Util.isUnset(request.className)) {
      body["className"] = request.className;
    }

    if (!Util.isUnset(request.status)) {
      body["status"] = request.status;
    }

    if (!Util.isUnset(request.config)) {
      body["config"] = request.config;
    }

    let req = new $OpenApi.OpenApiRequest({
      body: Util.toJSONString(body),
    });
    let params = new $OpenApi.Params({
      action: "UpdateEventSource",
      version: "2024-07-01",
      protocol: "HTTP",
      pathname: "/source/updateEventSource",
      method: "POST",
      authType: "Anonymous",
      style: "RPC",
      reqBodyType: "json",
      bodyType: "json",
    });
    return $tea.cast<UpdateEventSourceResponse>(await this.callApi(params, req, runtime), new UpdateEventSourceResponse({}));
  }

  /**
   * Updates an event source.
   * 
   * @remarks
   * You can call this operation to update an event source.
   * 
   * @param request - UpdateEventSourceRequest
   * @returns UpdateEventSourceResponse
   */
  async updateEventSource(request: UpdateEventSourceRequest): Promise<UpdateEventSourceResponse> {
    let runtime = new $Util.RuntimeOptions({ });
    return await this.updateEventSourceWithOptions(request, runtime);
  }

  /**
   * Deletes an event source.
   * 
   * @remarks
   * You can call this API operation to delete an event source.
   * 
   * @param request - DeleteEventSourceRequest
   * @param runtime - runtime options for this request RuntimeOptions
   * @returns DeleteEventSourceResponse
   */
  async deleteEventSourceWithOptions(request: DeleteEventSourceRequest, runtime: $Util.RuntimeOptions): Promise<DeleteEventSourceResponse> {
    Util.validateModel(request);
    let body : {[key: string ]: any} = { };
    if (!Util.isUnset(request.eventBusName)) {
      body["eventBusName"] = request.eventBusName;
    }

    if (!Util.isUnset(request.eventSourceName)) {
      body["eventSourceName"] = request.eventSourceName;
    }

    let req = new $OpenApi.OpenApiRequest({
      body: Util.toJSONString(body),
    });
    let params = new $OpenApi.Params({
      action: "DeleteEventSource",
      version: "2024-07-01",
      protocol: "HTTP",
      pathname: "/source/deleteEventSource",
      method: "POST",
      authType: "Anonymous",
      style: "RPC",
      reqBodyType: "json",
      bodyType: "json",
    });
    return $tea.cast<DeleteEventSourceResponse>(await this.callApi(params, req, runtime), new DeleteEventSourceResponse({}));
  }

  /**
   * Deletes an event source.
   * 
   * @remarks
   * You can call this API operation to delete an event source.
   * 
   * @param request - DeleteEventSourceRequest
   * @returns DeleteEventSourceResponse
   */
  async deleteEventSource(request: DeleteEventSourceRequest): Promise<DeleteEventSourceResponse> {
    let runtime = new $Util.RuntimeOptions({ });
    return await this.deleteEventSourceWithOptions(request, runtime);
  }

  /**
   * Gets an event source.
   * 
   * @remarks
   * You can call this API operation to get an event source.
   * 
   * @param request - GetEventSourceRequest
   * @param runtime - runtime options for this request RuntimeOptions
   * @returns GetEventSourceResponse
   */
  async getEventSourceWithOptions(request: GetEventSourceRequest, runtime: $Util.RuntimeOptions): Promise<GetEventSourceResponse> {
    Util.validateModel(request);
    let body : {[key: string ]: any} = { };
    if (!Util.isUnset(request.eventBusName)) {
      body["eventBusName"] = request.eventBusName;
    }

    if (!Util.isUnset(request.eventSourceName)) {
      body["eventSourceName"] = request.eventSourceName;
    }

    let req = new $OpenApi.OpenApiRequest({
      body: Util.toJSONString(body),
    });
    let params = new $OpenApi.Params({
      action: "GetEventSource",
      version: "2024-07-01",
      protocol: "HTTP",
      pathname: "/source/getEventSource",
      method: "POST",
      authType: "Anonymous",
      style: "RPC",
      reqBodyType: "json",
      bodyType: "json",
    });
    return $tea.cast<GetEventSourceResponse>(await this.callApi(params, req, runtime), new GetEventSourceResponse({}));
  }

  /**
   * Gets an event source.
   * 
   * @remarks
   * You can call this API operation to get an event source.
   * 
   * @param request - GetEventSourceRequest
   * @returns GetEventSourceResponse
   */
  async getEventSource(request: GetEventSourceRequest): Promise<GetEventSourceResponse> {
    let runtime = new $Util.RuntimeOptions({ });
    return await this.getEventSourceWithOptions(request, runtime);
  }

  /**
   * Lists event sources.
   * 
   * @remarks
   * You can call this API operation to list event sources.
   * 
   * @param request - ListEventSourcesRequest
   * @param runtime - runtime options for this request RuntimeOptions
   * @returns ListEventSourcesResponse
   */
  async listEventSourcesWithOptions(request: ListEventSourcesRequest, runtime: $Util.RuntimeOptions): Promise<ListEventSourcesResponse> {
    Util.validateModel(request);
    let body : {[key: string ]: any} = { };
    if (!Util.isUnset(request.eventBusName)) {
      body["eventBusName"] = request.eventBusName;
    }

    if (!Util.isUnset(request.eventSourceType)) {
      body["eventSourceType"] = request.eventSourceType;
    }

    if (!Util.isUnset(request.maxResults)) {
      body["maxResults"] = request.maxResults;
    }

    if (!Util.isUnset(request.nextToken)) {
      body["nextToken"] = request.nextToken;
    }

    let req = new $OpenApi.OpenApiRequest({
      body: Util.toJSONString(body),
    });
    let params = new $OpenApi.Params({
      action: "ListEventSources",
      version: "2024-07-01",
      protocol: "HTTP",
      pathname: "/source/listEventSources",
      method: "POST",
      authType: "Anonymous",
      style: "RPC",
      reqBodyType: "json",
      bodyType: "json",
    });
    return $tea.cast<ListEventSourcesResponse>(await this.callApi(params, req, runtime), new ListEventSourcesResponse({}));
  }

  /**
   * Lists event sources.
   * 
   * @remarks
   * You can call this API operation to list event sources.
   * 
   * @param request - ListEventSourcesRequest
   * @returns ListEventSourcesResponse
   */
  async listEventSources(request: ListEventSourcesRequest): Promise<ListEventSourcesResponse> {
    let runtime = new $Util.RuntimeOptions({ });
    return await this.listEventSourcesWithOptions(request, runtime);
  }

  /**
   * Creates event targets.
   * 
   * @remarks
   * You can call this operation to create event targets.
   * 
   * @param request - CreateEventTargetsRequest
   * @param runtime - runtime options for this request RuntimeOptions
   * @returns CreateEventTargetsResponse
   */
  async createEventTargetsWithOptions(request: CreateEventTargetsRequest, runtime: $Util.RuntimeOptions): Promise<CreateEventTargetsResponse> {
    Util.validateModel(request);
    let body : {[key: string ]: any} = { };
    if (!Util.isUnset(request.eventBusName)) {
      body["eventBusName"] = request.eventBusName;
    }

    if (!Util.isUnset(request.eventRuleName)) {
      body["eventRuleName"] = request.eventRuleName;
    }

    if (!Util.isUnset(request.eventTargets)) {
      body["eventTargets"] = request.eventTargets;
    }

    let req = new $OpenApi.OpenApiRequest({
      body: Util.toJSONString(body),
    });
    let params = new $OpenApi.Params({
      action: "CreateEventTargets",
      version: "2024-07-01",
      protocol: "HTTP",
      pathname: "/target/createEventTargets",
      method: "POST",
      authType: "Anonymous",
      style: "RPC",
      reqBodyType: "json",
      bodyType: "json",
    });
    return $tea.cast<CreateEventTargetsResponse>(await this.callApi(params, req, runtime), new CreateEventTargetsResponse({}));
  }

  /**
   * Creates event targets.
   * 
   * @remarks
   * You can call this operation to create event targets.
   * 
   * @param request - CreateEventTargetsRequest
   * @returns CreateEventTargetsResponse
   */
  async createEventTargets(request: CreateEventTargetsRequest): Promise<CreateEventTargetsResponse> {
    let runtime = new $Util.RuntimeOptions({ });
    return await this.createEventTargetsWithOptions(request, runtime);
  }

  /**
   * Updates event targets.
   * 
   * @remarks
   * You can call this operation to update event targets.
   * 
   * @param request - UpdateEventTargetsRequest
   * @param runtime - runtime options for this request RuntimeOptions
   * @returns UpdateEventTargetsResponse
   */
  async updateEventTargetsWithOptions(request: UpdateEventTargetsRequest, runtime: $Util.RuntimeOptions): Promise<UpdateEventTargetsResponse> {
    Util.validateModel(request);
    let body : {[key: string ]: any} = { };
    if (!Util.isUnset(request.eventBusName)) {
      body["eventBusName"] = request.eventBusName;
    }

    if (!Util.isUnset(request.eventRuleName)) {
      body["eventRuleName"] = request.eventRuleName;
    }

    if (!Util.isUnset(request.eventTargets)) {
      body["eventTargets"] = request.eventTargets;
    }

    let req = new $OpenApi.OpenApiRequest({
      body: Util.toJSONString(body),
    });
    let params = new $OpenApi.Params({
      action: "UpdateEventTargets",
      version: "2024-07-01",
      protocol: "HTTP",
      pathname: "/target/updateEventTargets",
      method: "POST",
      authType: "Anonymous",
      style: "RPC",
      reqBodyType: "json",
      bodyType: "json",
    });
    return $tea.cast<UpdateEventTargetsResponse>(await this.callApi(params, req, runtime), new UpdateEventTargetsResponse({}));
  }

  /**
   * Updates event targets.
   * 
   * @remarks
   * You can call this operation to update event targets.
   * 
   * @param request - UpdateEventTargetsRequest
   * @returns UpdateEventTargetsResponse
   */
  async updateEventTargets(request: UpdateEventTargetsRequest): Promise<UpdateEventTargetsResponse> {
    let runtime = new $Util.RuntimeOptions({ });
    return await this.updateEventTargetsWithOptions(request, runtime);
  }

  /**
   * Deletes event targets.
   * 
   * @remarks
   * You can call this operation to delete event targets.
   * 
   * @param request - DeleteEventTargetsRequest
   * @param runtime - runtime options for this request RuntimeOptions
   * @returns DeleteEventTargetsResponse
   */
  async deleteEventTargetsWithOptions(request: DeleteEventTargetsRequest, runtime: $Util.RuntimeOptions): Promise<DeleteEventTargetsResponse> {
    Util.validateModel(request);
    let body : {[key: string ]: any} = { };
    if (!Util.isUnset(request.eventBusName)) {
      body["eventBusName"] = request.eventBusName;
    }

    if (!Util.isUnset(request.eventRuleName)) {
      body["eventRuleName"] = request.eventRuleName;
    }

    if (!Util.isUnset(request.eventTargetNames)) {
      body["eventTargetNames"] = request.eventTargetNames;
    }

    let req = new $OpenApi.OpenApiRequest({
      body: Util.toJSONString(body),
    });
    let params = new $OpenApi.Params({
      action: "DeleteEventTargets",
      version: "2024-07-01",
      protocol: "HTTP",
      pathname: "/target/deleteEventTargets",
      method: "POST",
      authType: "Anonymous",
      style: "RPC",
      reqBodyType: "json",
      bodyType: "json",
    });
    return $tea.cast<DeleteEventTargetsResponse>(await this.callApi(params, req, runtime), new DeleteEventTargetsResponse({}));
  }

  /**
   * Deletes event targets.
   * 
   * @remarks
   * You can call this operation to delete event targets.
   * 
   * @param request - DeleteEventTargetsRequest
   * @returns DeleteEventTargetsResponse
   */
  async deleteEventTargets(request: DeleteEventTargetsRequest): Promise<DeleteEventTargetsResponse> {
    let runtime = new $Util.RuntimeOptions({ });
    return await this.deleteEventTargetsWithOptions(request, runtime);
  }

  /**
   * Lists event targets.
   * 
   * @remarks
   * You can call this operation to list event targets.
   * 
   * @param request - ListEventTargetsRequest
   * @param runtime - runtime options for this request RuntimeOptions
   * @returns ListEventTargetsResponse
   */
  async listEventTargetsWithOptions(request: ListEventTargetsRequest, runtime: $Util.RuntimeOptions): Promise<ListEventTargetsResponse> {
    Util.validateModel(request);
    let body : {[key: string ]: any} = { };
    if (!Util.isUnset(request.eventBusName)) {
      body["eventBusName"] = request.eventBusName;
    }

    if (!Util.isUnset(request.eventRuleName)) {
      body["eventRuleName"] = request.eventRuleName;
    }

    let req = new $OpenApi.OpenApiRequest({
      body: Util.toJSONString(body),
    });
    let params = new $OpenApi.Params({
      action: "ListEventTargets",
      version: "2024-07-01",
      protocol: "HTTP",
      pathname: "/target/listEventTargets",
      method: "POST",
      authType: "Anonymous",
      style: "RPC",
      reqBodyType: "json",
      bodyType: "json",
    });
    return $tea.cast<ListEventTargetsResponse>(await this.callApi(params, req, runtime), new ListEventTargetsResponse({}));
  }

  /**
   * Lists event targets.
   * 
   * @remarks
   * You can call this operation to list event targets.
   * 
   * @param request - ListEventTargetsRequest
   * @returns ListEventTargetsResponse
   */
  async listEventTargets(request: ListEventTargetsRequest): Promise<ListEventTargetsResponse> {
    let runtime = new $Util.RuntimeOptions({ });
    return await this.listEventTargetsWithOptions(request, runtime);
  }

  /**
   * Queries all event buses.
   * 
   * @remarks
   * You can call this API operation to query all event buses.
   * 
   * @param request - ListEventTypesRequest
   * @param runtime - runtime options for this request RuntimeOptions
   * @returns ListEventTypesResponse
   */
  async listEventTypesWithOptions(request: ListEventTypesRequest, runtime: $Util.RuntimeOptions): Promise<ListEventTypesResponse> {
    Util.validateModel(request);
    let body : {[key: string ]: any} = { };
    if (!Util.isUnset(request.eventBusName)) {
      body["eventBusName"] = request.eventBusName;
    }

    if (!Util.isUnset(request.eventSourceName)) {
      body["eventSourceName"] = request.eventSourceName;
    }

    if (!Util.isUnset(request.maxResults)) {
      body["maxResults"] = request.maxResults;
    }

    if (!Util.isUnset(request.nextToken)) {
      body["nextToken"] = request.nextToken;
    }

    let req = new $OpenApi.OpenApiRequest({
      body: Util.toJSONString(body),
    });
    let params = new $OpenApi.Params({
      action: "listEventTypes",
      version: "2024-07-01",
      protocol: "HTTP",
      pathname: "/type/listEventTypes",
      method: "POST",
      authType: "Anonymous",
      style: "RPC",
      reqBodyType: "json",
      bodyType: "json",
    });
    return $tea.cast<ListEventTypesResponse>(await this.callApi(params, req, runtime), new ListEventTypesResponse({}));
  }

  /**
   * Queries all event buses.
   * 
   * @remarks
   * You can call this API operation to query all event buses.
   * 
   * @param request - ListEventTypesRequest
   * @returns ListEventTypesResponse
   */
  async listEventTypes(request: ListEventTypesRequest): Promise<ListEventTypesResponse> {
    let runtime = new $Util.RuntimeOptions({ });
    return await this.listEventTypesWithOptions(request, runtime);
  }

}
