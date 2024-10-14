// This file is auto-generated, don't edit it. Thanks.
package client

import (
  util  "github.com/alibabacloud-go/tea-utils/v2/service"
  openapi  "github.com/alibabacloud-go/darabonba-openapi/v2/client"
  "github.com/alibabacloud-go/tea/tea"
)

// Description:
// 
// EventBus Controller apis:
// 
// createEventBus *
// 
// getEventBus    *
// 
// deleteEventBus *
// 
// listEventBuses *
type CreateEventBusRequest struct {
  // The description of the event bus.
  // 
  // example:
  // 
  // demo
  Description *string `json:"description,omitempty" xml:"description,omitempty"`
  // The name of the event bus. This parameter is required.
  // 
  // example:
  // 
  // MyEventBus
  EventBusName *string `json:"eventBusName,omitempty" xml:"eventBusName,omitempty"`
}

func (s CreateEventBusRequest) String() string {
  return tea.Prettify(s)
}

func (s CreateEventBusRequest) GoString() string {
  return s.String()
}

func (s *CreateEventBusRequest) SetDescription(v string) *CreateEventBusRequest {
  s.Description = &v
  return s
}

func (s *CreateEventBusRequest) SetEventBusName(v string) *CreateEventBusRequest {
  s.EventBusName = &v
  return s
}

type CreateEventBusResponseBody struct {
  // The returned response code. The value Success indicates that the request is successful. Other values indicate that the request failed. For more information about error codes, see Error codes.
  // 
  // example:
  // 
  // Success
  Code *string `json:"code,omitempty" xml:"code,omitempty"`
  // The name of the event bus. This parameter is required.
  // 
  // example:
  // 
  // MyEventBus
  EventBusName *string `json:"eventBusName,omitempty" xml:"eventBusName,omitempty"`
  // The returned error message.
  // 
  // example:
  // 
  // The event bus [xxxx] not existed!
  Message *string `json:"message,omitempty" xml:"message,omitempty"`
  // The request ID.
  // 
  // example:
  // 
  // A995F07C-E503-5881-9962-9CECA8566876
  RequestId *string `json:"requestId,omitempty" xml:"requestId,omitempty"`
  // Indicates whether the request is successful. The value true indicates that the request is successful.
  // 
  // example:
  // 
  // true
  Success *bool `json:"success,omitempty" xml:"success,omitempty"`
}

func (s CreateEventBusResponseBody) String() string {
  return tea.Prettify(s)
}

func (s CreateEventBusResponseBody) GoString() string {
  return s.String()
}

func (s *CreateEventBusResponseBody) SetCode(v string) *CreateEventBusResponseBody {
  s.Code = &v
  return s
}

func (s *CreateEventBusResponseBody) SetEventBusName(v string) *CreateEventBusResponseBody {
  s.EventBusName = &v
  return s
}

func (s *CreateEventBusResponseBody) SetMessage(v string) *CreateEventBusResponseBody {
  s.Message = &v
  return s
}

func (s *CreateEventBusResponseBody) SetRequestId(v string) *CreateEventBusResponseBody {
  s.RequestId = &v
  return s
}

func (s *CreateEventBusResponseBody) SetSuccess(v bool) *CreateEventBusResponseBody {
  s.Success = &v
  return s
}

type CreateEventBusResponse struct {
  Headers map[string]*string `json:"headers,omitempty" xml:"headers,omitempty"`
  StatusCode *int32 `json:"statusCode,omitempty" xml:"statusCode,omitempty"`
  Body *CreateEventBusResponseBody `json:"body,omitempty" xml:"body,omitempty"`
}

func (s CreateEventBusResponse) String() string {
  return tea.Prettify(s)
}

func (s CreateEventBusResponse) GoString() string {
  return s.String()
}

func (s *CreateEventBusResponse) SetHeaders(v map[string]*string) *CreateEventBusResponse {
  s.Headers = v
  return s
}

func (s *CreateEventBusResponse) SetStatusCode(v int32) *CreateEventBusResponse {
  s.StatusCode = &v
  return s
}

func (s *CreateEventBusResponse) SetBody(v *CreateEventBusResponseBody) *CreateEventBusResponse {
  s.Body = v
  return s
}

type GetEventBusRequest struct {
  // The name of the event bus. This parameter is required.
  // 
  // example:
  // 
  // MyEventBus
  EventBusName *string `json:"eventBusName,omitempty" xml:"eventBusName,omitempty"`
}

func (s GetEventBusRequest) String() string {
  return tea.Prettify(s)
}

func (s GetEventBusRequest) GoString() string {
  return s.String()
}

func (s *GetEventBusRequest) SetEventBusName(v string) *GetEventBusRequest {
  s.EventBusName = &v
  return s
}

type GetEventBusResponseBody struct {
  // The response code. The value Success indicates that the request is successful.
  // 
  // example:
  // 
  // Success
  Code *string `json:"code,omitempty" xml:"code,omitempty"`
  // The timestamp that indicates when the event bus was created.
  // 
  // example:
  // 
  // 1641781825000
  CreateTimestamp *int64 `json:"createTimestamp,omitempty" xml:"createTimestamp,omitempty"`
  // The description of the event bus.
  // 
  // example:
  // 
  // demo
  Description *string `json:"description,omitempty" xml:"description,omitempty"`
  // The name of the event bus.
  // 
  // example:
  // 
  // MyEventBus
  EventBusName *string `json:"eventBusName,omitempty" xml:"eventBusName,omitempty"`
  // The error message that is returned if the request failed.
  // 
  // example:
  // 
  // EventBusNotExist
  Message *string `json:"message,omitempty" xml:"message,omitempty"`
  // The request ID.
  // 
  // example:
  // 
  // d5bfc188-4452-4ba7-b73a-a9005e522439
  RequestId *string `json:"requestId,omitempty" xml:"requestId,omitempty"`
}

func (s GetEventBusResponseBody) String() string {
  return tea.Prettify(s)
}

func (s GetEventBusResponseBody) GoString() string {
  return s.String()
}

func (s *GetEventBusResponseBody) SetCode(v string) *GetEventBusResponseBody {
  s.Code = &v
  return s
}

func (s *GetEventBusResponseBody) SetCreateTimestamp(v int64) *GetEventBusResponseBody {
  s.CreateTimestamp = &v
  return s
}

func (s *GetEventBusResponseBody) SetDescription(v string) *GetEventBusResponseBody {
  s.Description = &v
  return s
}

func (s *GetEventBusResponseBody) SetEventBusName(v string) *GetEventBusResponseBody {
  s.EventBusName = &v
  return s
}

func (s *GetEventBusResponseBody) SetMessage(v string) *GetEventBusResponseBody {
  s.Message = &v
  return s
}

func (s *GetEventBusResponseBody) SetRequestId(v string) *GetEventBusResponseBody {
  s.RequestId = &v
  return s
}

type GetEventBusResponse struct {
  Headers map[string]*string `json:"headers,omitempty" xml:"headers,omitempty"`
  StatusCode *int32 `json:"statusCode,omitempty" xml:"statusCode,omitempty"`
  Body *GetEventBusResponseBody `json:"body,omitempty" xml:"body,omitempty"`
}

func (s GetEventBusResponse) String() string {
  return tea.Prettify(s)
}

func (s GetEventBusResponse) GoString() string {
  return s.String()
}

func (s *GetEventBusResponse) SetHeaders(v map[string]*string) *GetEventBusResponse {
  s.Headers = v
  return s
}

func (s *GetEventBusResponse) SetStatusCode(v int32) *GetEventBusResponse {
  s.StatusCode = &v
  return s
}

func (s *GetEventBusResponse) SetBody(v *GetEventBusResponseBody) *GetEventBusResponse {
  s.Body = v
  return s
}

type ListEventBusesRequest struct {
  // The maximum number of entries to be returned in a call. You can use this parameter and NextToken to implement paging. Note: Up to 100 entries can be returned in a call.
  // 
  // example:
  // 
  // 10
  MaxResults *int32 `json:"maxResults,omitempty" xml:"maxResults,omitempty"`
  // If you set Limit and excess return values exist, this parameter is returned.
  // 
  // example:
  // 
  // 10
  NextToken *string `json:"nextToken,omitempty" xml:"nextToken,omitempty"`
}

func (s ListEventBusesRequest) String() string {
  return tea.Prettify(s)
}

func (s ListEventBusesRequest) GoString() string {
  return s.String()
}

func (s *ListEventBusesRequest) SetMaxResults(v int32) *ListEventBusesRequest {
  s.MaxResults = &v
  return s
}

func (s *ListEventBusesRequest) SetNextToken(v string) *ListEventBusesRequest {
  s.NextToken = &v
  return s
}

type ListEventBusesResponseBody struct {
  // The returned HTTP status code. The HTTP status code 200 indicates that the request is successful.
  // 
  // example:
  // 
  // 200
  Code *string `json:"code,omitempty" xml:"code,omitempty"`
  // The timestamp that indicates when the event bus was created.
  EventBuses []*ListEventBusesResponseBodyEventBuses `json:"eventBuses,omitempty" xml:"eventBuses,omitempty" type:"Repeated"`
  // The returned error message.
  // 
  // example:
  // 
  // InvalidArgument
  Message *string `json:"message,omitempty" xml:"message,omitempty"`
  // The request ID.
  // 
  // example:
  // 
  // D1DCF64A-3F2C-5323-ADCB-3F4DF30FAD2D
  RequestId *string `json:"requestId,omitempty" xml:"requestId,omitempty"`
  // If excess return values exist, this parameter is returned.
  // 
  // example:
  // 
  // 10
  NextToken *string `json:"nextToken,omitempty" xml:"nextToken,omitempty"`
  // The total number of entries.
  // 
  // example:
  // 
  // 2
  Total *int `json:"total,omitempty" xml:"total,omitempty"`
  // If you set Limit and excess return values exist, this parameter is returned.
  // 
  // example:
  // 
  // 10
  MaxResults *int32 `json:"maxResults,omitempty" xml:"maxResults,omitempty"`
}

func (s ListEventBusesResponseBody) String() string {
  return tea.Prettify(s)
}

func (s ListEventBusesResponseBody) GoString() string {
  return s.String()
}

func (s *ListEventBusesResponseBody) SetCode(v string) *ListEventBusesResponseBody {
  s.Code = &v
  return s
}

func (s *ListEventBusesResponseBody) SetEventBuses(v []*ListEventBusesResponseBodyEventBuses) *ListEventBusesResponseBody {
  s.EventBuses = v
  return s
}

func (s *ListEventBusesResponseBody) SetMessage(v string) *ListEventBusesResponseBody {
  s.Message = &v
  return s
}

func (s *ListEventBusesResponseBody) SetRequestId(v string) *ListEventBusesResponseBody {
  s.RequestId = &v
  return s
}

func (s *ListEventBusesResponseBody) SetNextToken(v string) *ListEventBusesResponseBody {
  s.NextToken = &v
  return s
}

func (s *ListEventBusesResponseBody) SetTotal(v int) *ListEventBusesResponseBody {
  s.Total = &v
  return s
}

func (s *ListEventBusesResponseBody) SetMaxResults(v int32) *ListEventBusesResponseBody {
  s.MaxResults = &v
  return s
}

type ListEventBusesResponseBodyEventBuses struct     {
  // The description of the queried event bus.
  // 
  // example:
  // 
  // bus_description
  Description *string `json:"description,omitempty" xml:"description,omitempty"`
  // The name of the queried event bus.
  // 
  // example:
  // 
  // default
  EventBusName *string `json:"eventBusName,omitempty" xml:"eventBusName,omitempty"`
}

func (s ListEventBusesResponseBodyEventBuses) String() string {
  return tea.Prettify(s)
}

func (s ListEventBusesResponseBodyEventBuses) GoString() string {
  return s.String()
}

func (s *ListEventBusesResponseBodyEventBuses) SetDescription(v string) *ListEventBusesResponseBodyEventBuses {
  s.Description = &v
  return s
}

func (s *ListEventBusesResponseBodyEventBuses) SetEventBusName(v string) *ListEventBusesResponseBodyEventBuses {
  s.EventBusName = &v
  return s
}

type ListEventBusesResponse struct {
  Headers map[string]*string `json:"headers,omitempty" xml:"headers,omitempty"`
  StatusCode *int32 `json:"statusCode,omitempty" xml:"statusCode,omitempty"`
  Body *ListEventBusesResponseBody `json:"body,omitempty" xml:"body,omitempty"`
}

func (s ListEventBusesResponse) String() string {
  return tea.Prettify(s)
}

func (s ListEventBusesResponse) GoString() string {
  return s.String()
}

func (s *ListEventBusesResponse) SetHeaders(v map[string]*string) *ListEventBusesResponse {
  s.Headers = v
  return s
}

func (s *ListEventBusesResponse) SetStatusCode(v int32) *ListEventBusesResponse {
  s.StatusCode = &v
  return s
}

func (s *ListEventBusesResponse) SetBody(v *ListEventBusesResponseBody) *ListEventBusesResponse {
  s.Body = v
  return s
}

type DeleteEventBusRequest struct {
  // The name of the event bus. This parameter is required.
  // 
  // example:
  // 
  // MyEventBus
  EventBusName *string `json:"eventBusName,omitempty" xml:"eventBusName,omitempty"`
}

func (s DeleteEventBusRequest) String() string {
  return tea.Prettify(s)
}

func (s DeleteEventBusRequest) GoString() string {
  return s.String()
}

func (s *DeleteEventBusRequest) SetEventBusName(v string) *DeleteEventBusRequest {
  s.EventBusName = &v
  return s
}

type DeleteEventBusResponseBody struct {
  // The returned HTTP status code. The HTTP status code 200 indicates that the request is successful.
  // 
  // example:
  // 
  // 200
  Code *string `json:"code,omitempty" xml:"code,omitempty"`
  // The returned error message.
  // 
  // example:
  // 
  // EventBusNotExist
  Message *string `json:"message,omitempty" xml:"message,omitempty"`
  // The request ID.
  // 
  // example:
  // 
  // C229E140-1A5C-5D55-8904-CFC5BA4CAA98
  RequestId *string `json:"requestId,omitempty" xml:"requestId,omitempty"`
}

func (s DeleteEventBusResponseBody) String() string {
  return tea.Prettify(s)
}

func (s DeleteEventBusResponseBody) GoString() string {
  return s.String()
}

func (s *DeleteEventBusResponseBody) SetCode(v string) *DeleteEventBusResponseBody {
  s.Code = &v
  return s
}

func (s *DeleteEventBusResponseBody) SetMessage(v string) *DeleteEventBusResponseBody {
  s.Message = &v
  return s
}

func (s *DeleteEventBusResponseBody) SetRequestId(v string) *DeleteEventBusResponseBody {
  s.RequestId = &v
  return s
}

type DeleteEventBusResponse struct {
  Headers map[string]*string `json:"headers,omitempty" xml:"headers,omitempty"`
  StatusCode *int32 `json:"statusCode,omitempty" xml:"statusCode,omitempty"`
  Body *DeleteEventBusResponseBody `json:"body,omitempty" xml:"body,omitempty"`
}

func (s DeleteEventBusResponse) String() string {
  return tea.Prettify(s)
}

func (s DeleteEventBusResponse) GoString() string {
  return s.String()
}

func (s *DeleteEventBusResponse) SetHeaders(v map[string]*string) *DeleteEventBusResponse {
  s.Headers = v
  return s
}

func (s *DeleteEventBusResponse) SetStatusCode(v int32) *DeleteEventBusResponse {
  s.StatusCode = &v
  return s
}

func (s *DeleteEventBusResponse) SetBody(v *DeleteEventBusResponseBody) *DeleteEventBusResponse {
  s.Body = v
  return s
}

// Description:
// 
// ApiDestination Controller apis:
// 
// createApiDestination *
// 
// updateApiDestination *
// 
// getApiDestination    *
// 
// deleteApiDestination *
// 
// listApiDestinations  *
type CreateApiDestinationRequest struct {
  // The name of the API destination. The name must be 2 to 127 characters in length. This parameter is required.
  // 
  // example:
  // 
  // api-destination-name
  ApiDestinationName *string `json:"apiDestinationName,omitempty" xml:"apiDestinationName,omitempty"`
  // The name of the connection. The name must be 2 to 127 characters in length. Before you configure this parameter, you must call the CreateConnection operation to create a connection. Then, set this parameter to the name of the connection that you created. This parameter is required.
  // 
  // example:
  // 
  // connection-name
  ConnectionName *string `json:"connectionName,omitempty" xml:"connectionName,omitempty"`
  // The description of the API destination. The description can be up to 255 characters in length.
  Description *string `json:"description,omitempty" xml:"description,omitempty"`
  // The parameters that are configured for the API destination. This parameter is required.
  HttpApiParameters *CreateApiDestinationRequestHttpApiParameters `json:"httpApiParameters,omitempty" xml:"httpApiParameters,omitempty" type:"Struct"`
  // TODO
  InvocationRateLimitPerSecond *int `json:"invocationRateLimitPerSecond,omitempty" xml:"invocationRateLimitPerSecond,omitempty"`
}

func (s CreateApiDestinationRequest) String() string {
  return tea.Prettify(s)
}

func (s CreateApiDestinationRequest) GoString() string {
  return s.String()
}

func (s *CreateApiDestinationRequest) SetApiDestinationName(v string) *CreateApiDestinationRequest {
  s.ApiDestinationName = &v
  return s
}

func (s *CreateApiDestinationRequest) SetConnectionName(v string) *CreateApiDestinationRequest {
  s.ConnectionName = &v
  return s
}

func (s *CreateApiDestinationRequest) SetDescription(v string) *CreateApiDestinationRequest {
  s.Description = &v
  return s
}

func (s *CreateApiDestinationRequest) SetHttpApiParameters(v *CreateApiDestinationRequestHttpApiParameters) *CreateApiDestinationRequest {
  s.HttpApiParameters = v
  return s
}

func (s *CreateApiDestinationRequest) SetInvocationRateLimitPerSecond(v int) *CreateApiDestinationRequest {
  s.InvocationRateLimitPerSecond = &v
  return s
}

type CreateApiDestinationRequestHttpApiParameters struct {
  // The endpoint of the API destination. The endpoint can be up to 127 characters in length. This parameter is required.
  // 
  // example:
  // 
  // http://127.0.0.1:8001/api
  Endpoint *string `json:"endpoint,omitempty" xml:"endpoint,omitempty"`
  // The HTTP request method. Valid values: 
  // 
  // 
  //       	- GET 
  // 
  //       	- POST 
  // 
  //       	- HEAD 
  // 
  //       	- DELETE 
  // 
  //       	- PUT 
  // 
  //       	- PATCH 
  // 
  // 
  //       This parameter is required.
  // 
  // example:
  // 
  // POST
  Method *string `json:"method,omitempty" xml:"method,omitempty"`
  // TODO
  ApiParameters []*CreateApiDestinationRequestHttpApiParametersApiParameters `json:"apiParameters,omitempty" xml:"apiParameters,omitempty" type:"Repeated"`
}

func (s CreateApiDestinationRequestHttpApiParameters) String() string {
  return tea.Prettify(s)
}

func (s CreateApiDestinationRequestHttpApiParameters) GoString() string {
  return s.String()
}

func (s *CreateApiDestinationRequestHttpApiParameters) SetEndpoint(v string) *CreateApiDestinationRequestHttpApiParameters {
  s.Endpoint = &v
  return s
}

func (s *CreateApiDestinationRequestHttpApiParameters) SetMethod(v string) *CreateApiDestinationRequestHttpApiParameters {
  s.Method = &v
  return s
}

func (s *CreateApiDestinationRequestHttpApiParameters) SetApiParameters(v []*CreateApiDestinationRequestHttpApiParametersApiParameters) *CreateApiDestinationRequestHttpApiParameters {
  s.ApiParameters = v
  return s
}

type CreateApiDestinationRequestHttpApiParametersApiParameters struct     {
  Name *string `json:"name,omitempty" xml:"name,omitempty"`
  // The description of the API destination. The description can be up to 255 characters in length.
  Description *string `json:"description,omitempty" xml:"description,omitempty"`
  Type *string `json:"type,omitempty" xml:"type,omitempty"`
  DefaultValue *string `json:"defaultValue,omitempty" xml:"defaultValue,omitempty"`
  In *string `json:"in,omitempty" xml:"in,omitempty"`
}

func (s CreateApiDestinationRequestHttpApiParametersApiParameters) String() string {
  return tea.Prettify(s)
}

func (s CreateApiDestinationRequestHttpApiParametersApiParameters) GoString() string {
  return s.String()
}

func (s *CreateApiDestinationRequestHttpApiParametersApiParameters) SetName(v string) *CreateApiDestinationRequestHttpApiParametersApiParameters {
  s.Name = &v
  return s
}

func (s *CreateApiDestinationRequestHttpApiParametersApiParameters) SetDescription(v string) *CreateApiDestinationRequestHttpApiParametersApiParameters {
  s.Description = &v
  return s
}

func (s *CreateApiDestinationRequestHttpApiParametersApiParameters) SetType(v string) *CreateApiDestinationRequestHttpApiParametersApiParameters {
  s.Type = &v
  return s
}

func (s *CreateApiDestinationRequestHttpApiParametersApiParameters) SetDefaultValue(v string) *CreateApiDestinationRequestHttpApiParametersApiParameters {
  s.DefaultValue = &v
  return s
}

func (s *CreateApiDestinationRequestHttpApiParametersApiParameters) SetIn(v string) *CreateApiDestinationRequestHttpApiParametersApiParameters {
  s.In = &v
  return s
}

type CreateApiDestinationResponseBody struct {
  // The returned response code. The value Success indicates that the request is successful.
  // 
  // example:
  // 
  // Success
  Code *string `json:"code,omitempty" xml:"code,omitempty"`
  // The name of the API destination.
  // 
  // example:
  // 
  // ApiDestinationName
  ApiDestinationName *string `json:"apiDestinationName,omitempty" xml:"apiDestinationName,omitempty"`
  // The returned message.
  // 
  // example:
  // 
  // success
  Message *string `json:"message,omitempty" xml:"message,omitempty"`
  // The request ID.
  // 
  // example:
  // 
  // 5DAF96FB-A4B6-548C-B999-0BFDCB2261B9
  RequestId *string `json:"requestId,omitempty" xml:"requestId,omitempty"`
}

func (s CreateApiDestinationResponseBody) String() string {
  return tea.Prettify(s)
}

func (s CreateApiDestinationResponseBody) GoString() string {
  return s.String()
}

func (s *CreateApiDestinationResponseBody) SetCode(v string) *CreateApiDestinationResponseBody {
  s.Code = &v
  return s
}

func (s *CreateApiDestinationResponseBody) SetApiDestinationName(v string) *CreateApiDestinationResponseBody {
  s.ApiDestinationName = &v
  return s
}

func (s *CreateApiDestinationResponseBody) SetMessage(v string) *CreateApiDestinationResponseBody {
  s.Message = &v
  return s
}

func (s *CreateApiDestinationResponseBody) SetRequestId(v string) *CreateApiDestinationResponseBody {
  s.RequestId = &v
  return s
}

type CreateApiDestinationResponse struct {
  Headers map[string]*string `json:"headers,omitempty" xml:"headers,omitempty"`
  StatusCode *int32 `json:"statusCode,omitempty" xml:"statusCode,omitempty"`
  Body *CreateApiDestinationResponseBody `json:"body,omitempty" xml:"body,omitempty"`
}

func (s CreateApiDestinationResponse) String() string {
  return tea.Prettify(s)
}

func (s CreateApiDestinationResponse) GoString() string {
  return s.String()
}

func (s *CreateApiDestinationResponse) SetHeaders(v map[string]*string) *CreateApiDestinationResponse {
  s.Headers = v
  return s
}

func (s *CreateApiDestinationResponse) SetStatusCode(v int32) *CreateApiDestinationResponse {
  s.StatusCode = &v
  return s
}

func (s *CreateApiDestinationResponse) SetBody(v *CreateApiDestinationResponseBody) *CreateApiDestinationResponse {
  s.Body = v
  return s
}

type UpdateApiDestinationRequest struct {
  // The name of the API destination. The name must be 2 to 127 characters in length. This parameter is required.
  // 
  // example:
  // 
  // api-destination-name
  ApiDestinationName *string `json:"apiDestinationName,omitempty" xml:"apiDestinationName,omitempty"`
  // The name of the connection. The name must be 2 to 127 characters in length. Before you configure this parameter, you must call the CreateConnection operation to create a connection. Then, set this parameter to the name of the connection that you created. This parameter is required.
  // 
  // example:
  // 
  // connection-name
  ConnectionName *string `json:"connectionName,omitempty" xml:"connectionName,omitempty"`
  // The description of the API destination. The description can be up to 255 characters in length.
  Description *string `json:"description,omitempty" xml:"description,omitempty"`
  // The parameters that are configured for the API destination. This parameter is required.
  HttpApiParameters *UpdateApiDestinationRequestHttpApiParameters `json:"httpApiParameters,omitempty" xml:"httpApiParameters,omitempty" type:"Struct"`
  // TODO
  InvocationRateLimitPerSecond *int `json:"invocationRateLimitPerSecond,omitempty" xml:"invocationRateLimitPerSecond,omitempty"`
}

func (s UpdateApiDestinationRequest) String() string {
  return tea.Prettify(s)
}

func (s UpdateApiDestinationRequest) GoString() string {
  return s.String()
}

func (s *UpdateApiDestinationRequest) SetApiDestinationName(v string) *UpdateApiDestinationRequest {
  s.ApiDestinationName = &v
  return s
}

func (s *UpdateApiDestinationRequest) SetConnectionName(v string) *UpdateApiDestinationRequest {
  s.ConnectionName = &v
  return s
}

func (s *UpdateApiDestinationRequest) SetDescription(v string) *UpdateApiDestinationRequest {
  s.Description = &v
  return s
}

func (s *UpdateApiDestinationRequest) SetHttpApiParameters(v *UpdateApiDestinationRequestHttpApiParameters) *UpdateApiDestinationRequest {
  s.HttpApiParameters = v
  return s
}

func (s *UpdateApiDestinationRequest) SetInvocationRateLimitPerSecond(v int) *UpdateApiDestinationRequest {
  s.InvocationRateLimitPerSecond = &v
  return s
}

type UpdateApiDestinationRequestHttpApiParameters struct {
  // The endpoint of the API destination. The endpoint can be up to 127 characters in length. This parameter is required.
  // 
  // example:
  // 
  // http://127.0.0.1:8001/api
  Endpoint *string `json:"endpoint,omitempty" xml:"endpoint,omitempty"`
  // The HTTP request method. Valid values: 
  // 
  // 
  //       	- GET 
  // 
  //       	- POST 
  // 
  //       	- HEAD 
  // 
  //       	- DELETE 
  // 
  //       	- PUT 
  // 
  //       	- PATCH 
  // 
  // 
  //       This parameter is required.
  // 
  // example:
  // 
  // POST
  Method *string `json:"method,omitempty" xml:"method,omitempty"`
  // TODO
  ApiParameters []*UpdateApiDestinationRequestHttpApiParametersApiParameters `json:"apiParameters,omitempty" xml:"apiParameters,omitempty" type:"Repeated"`
}

func (s UpdateApiDestinationRequestHttpApiParameters) String() string {
  return tea.Prettify(s)
}

func (s UpdateApiDestinationRequestHttpApiParameters) GoString() string {
  return s.String()
}

func (s *UpdateApiDestinationRequestHttpApiParameters) SetEndpoint(v string) *UpdateApiDestinationRequestHttpApiParameters {
  s.Endpoint = &v
  return s
}

func (s *UpdateApiDestinationRequestHttpApiParameters) SetMethod(v string) *UpdateApiDestinationRequestHttpApiParameters {
  s.Method = &v
  return s
}

func (s *UpdateApiDestinationRequestHttpApiParameters) SetApiParameters(v []*UpdateApiDestinationRequestHttpApiParametersApiParameters) *UpdateApiDestinationRequestHttpApiParameters {
  s.ApiParameters = v
  return s
}

type UpdateApiDestinationRequestHttpApiParametersApiParameters struct     {
  Name *string `json:"name,omitempty" xml:"name,omitempty"`
  // The description of the API destination. The description can be up to 255 characters in length.
  Description *string `json:"description,omitempty" xml:"description,omitempty"`
  Type *string `json:"type,omitempty" xml:"type,omitempty"`
  DefaultValue *string `json:"defaultValue,omitempty" xml:"defaultValue,omitempty"`
  In *string `json:"in,omitempty" xml:"in,omitempty"`
}

func (s UpdateApiDestinationRequestHttpApiParametersApiParameters) String() string {
  return tea.Prettify(s)
}

func (s UpdateApiDestinationRequestHttpApiParametersApiParameters) GoString() string {
  return s.String()
}

func (s *UpdateApiDestinationRequestHttpApiParametersApiParameters) SetName(v string) *UpdateApiDestinationRequestHttpApiParametersApiParameters {
  s.Name = &v
  return s
}

func (s *UpdateApiDestinationRequestHttpApiParametersApiParameters) SetDescription(v string) *UpdateApiDestinationRequestHttpApiParametersApiParameters {
  s.Description = &v
  return s
}

func (s *UpdateApiDestinationRequestHttpApiParametersApiParameters) SetType(v string) *UpdateApiDestinationRequestHttpApiParametersApiParameters {
  s.Type = &v
  return s
}

func (s *UpdateApiDestinationRequestHttpApiParametersApiParameters) SetDefaultValue(v string) *UpdateApiDestinationRequestHttpApiParametersApiParameters {
  s.DefaultValue = &v
  return s
}

func (s *UpdateApiDestinationRequestHttpApiParametersApiParameters) SetIn(v string) *UpdateApiDestinationRequestHttpApiParametersApiParameters {
  s.In = &v
  return s
}

type UpdateApiDestinationResponseBody struct {
  // The returned response code. The value Success indicates that the request is successful.
  // 
  // example:
  // 
  // Success
  Code *string `json:"code,omitempty" xml:"code,omitempty"`
  // The returned message.
  // 
  // example:
  // 
  // success
  Message *string `json:"message,omitempty" xml:"message,omitempty"`
  // The request ID.
  // 
  // example:
  // 
  // 5DAF96FB-A4B6-548C-B999-0BFDCB2261B9
  RequestId *string `json:"requestId,omitempty" xml:"requestId,omitempty"`
}

func (s UpdateApiDestinationResponseBody) String() string {
  return tea.Prettify(s)
}

func (s UpdateApiDestinationResponseBody) GoString() string {
  return s.String()
}

func (s *UpdateApiDestinationResponseBody) SetCode(v string) *UpdateApiDestinationResponseBody {
  s.Code = &v
  return s
}

func (s *UpdateApiDestinationResponseBody) SetMessage(v string) *UpdateApiDestinationResponseBody {
  s.Message = &v
  return s
}

func (s *UpdateApiDestinationResponseBody) SetRequestId(v string) *UpdateApiDestinationResponseBody {
  s.RequestId = &v
  return s
}

type UpdateApiDestinationResponse struct {
  Headers map[string]*string `json:"headers,omitempty" xml:"headers,omitempty"`
  StatusCode *int32 `json:"statusCode,omitempty" xml:"statusCode,omitempty"`
  Body *UpdateApiDestinationResponseBody `json:"body,omitempty" xml:"body,omitempty"`
}

func (s UpdateApiDestinationResponse) String() string {
  return tea.Prettify(s)
}

func (s UpdateApiDestinationResponse) GoString() string {
  return s.String()
}

func (s *UpdateApiDestinationResponse) SetHeaders(v map[string]*string) *UpdateApiDestinationResponse {
  s.Headers = v
  return s
}

func (s *UpdateApiDestinationResponse) SetStatusCode(v int32) *UpdateApiDestinationResponse {
  s.StatusCode = &v
  return s
}

func (s *UpdateApiDestinationResponse) SetBody(v *UpdateApiDestinationResponseBody) *UpdateApiDestinationResponse {
  s.Body = v
  return s
}

type GetApiDestinationRequest struct {
  // The name of the API destination. This parameter is required.
  // 
  // example:
  // 
  // api-destination-name
  ApiDestinationName *string `json:"apiDestinationName,omitempty" xml:"apiDestinationName,omitempty"`
}

func (s GetApiDestinationRequest) String() string {
  return tea.Prettify(s)
}

func (s GetApiDestinationRequest) GoString() string {
  return s.String()
}

func (s *GetApiDestinationRequest) SetApiDestinationName(v string) *GetApiDestinationRequest {
  s.ApiDestinationName = &v
  return s
}

type GetApiDestinationResponseBody struct {
  // The returned response code. The value Success indicates that the request is successful.
  // 
  // example:
  // 
  // Success
  Code *string `json:"code,omitempty" xml:"code,omitempty"`
  // The name of the API destination.
  // 
  // example:
  // 
  // api-destination-2
  ApiDestinationName *string `json:"apiDestinationName,omitempty" xml:"apiDestinationName,omitempty"`
  // The connection name.
  // 
  // example:
  // 
  // connection-name
  ConnectionName *string `json:"connectionName,omitempty" xml:"connectionName,omitempty"`
  // The description of the connection.
  // 
  // example:
  // 
  // demo
  Description *string `json:"description,omitempty" xml:"description,omitempty"`
  // The time when the API destination was created.
  // 
  // example:
  // 
  // 1665223213000
  GmtCreate *int64 `json:"gmtCreate,omitempty" xml:"gmtCreate,omitempty"`
  // The request parameters that are configured for the API destination.
  HttpApiParameters *GetApiDestinationResponseBodyHttpApiParameters `json:"httpApiParameters,omitempty" xml:"httpApiParameters,omitempty" type:"Struct"`
  // TODO
  InvocationRateLimitPerSecond *int `json:"invocationRateLimitPerSecond,omitempty" xml:"invocationRateLimitPerSecond,omitempty"`
  // The returned message. If the request is successful, success is returned. If the request failed, an error code is returned.
  // 
  // example:
  // 
  // success
  Message *string `json:"message,omitempty" xml:"message,omitempty"`
  // The request ID.
  // 
  // example:
  // 
  // B896B484-F16D-59DE-9E23-DD0E5C361108
  RequestId *string `json:"requestId,omitempty" xml:"requestId,omitempty"`
}

func (s GetApiDestinationResponseBody) String() string {
  return tea.Prettify(s)
}

func (s GetApiDestinationResponseBody) GoString() string {
  return s.String()
}

func (s *GetApiDestinationResponseBody) SetCode(v string) *GetApiDestinationResponseBody {
  s.Code = &v
  return s
}

func (s *GetApiDestinationResponseBody) SetApiDestinationName(v string) *GetApiDestinationResponseBody {
  s.ApiDestinationName = &v
  return s
}

func (s *GetApiDestinationResponseBody) SetConnectionName(v string) *GetApiDestinationResponseBody {
  s.ConnectionName = &v
  return s
}

func (s *GetApiDestinationResponseBody) SetDescription(v string) *GetApiDestinationResponseBody {
  s.Description = &v
  return s
}

func (s *GetApiDestinationResponseBody) SetGmtCreate(v int64) *GetApiDestinationResponseBody {
  s.GmtCreate = &v
  return s
}

func (s *GetApiDestinationResponseBody) SetHttpApiParameters(v *GetApiDestinationResponseBodyHttpApiParameters) *GetApiDestinationResponseBody {
  s.HttpApiParameters = v
  return s
}

func (s *GetApiDestinationResponseBody) SetInvocationRateLimitPerSecond(v int) *GetApiDestinationResponseBody {
  s.InvocationRateLimitPerSecond = &v
  return s
}

func (s *GetApiDestinationResponseBody) SetMessage(v string) *GetApiDestinationResponseBody {
  s.Message = &v
  return s
}

func (s *GetApiDestinationResponseBody) SetRequestId(v string) *GetApiDestinationResponseBody {
  s.RequestId = &v
  return s
}

type GetApiDestinationResponseBodyHttpApiParameters struct {
  // The endpoint of the API destination.
  // 
  // example:
  // 
  // http://127.0.0.1:8001/api
  Endpoint *string `json:"endpoint,omitempty" xml:"endpoint,omitempty"`
  // The HTTP request method. Valid values:
  // 
  //       - POST
  // 
  //       - GET
  // 
  //       - DELETE
  // 
  //       - PUT
  // 
  //       - HEAD
  // 
  //       - TRACE
  // 
  //       - PATCH
  // 
  // example:
  // 
  // POST
  Method *string `json:"method,omitempty" xml:"method,omitempty"`
  // TODO
  ApiParameters []*GetApiDestinationResponseBodyHttpApiParametersApiParameters `json:"apiParameters,omitempty" xml:"apiParameters,omitempty" type:"Repeated"`
}

func (s GetApiDestinationResponseBodyHttpApiParameters) String() string {
  return tea.Prettify(s)
}

func (s GetApiDestinationResponseBodyHttpApiParameters) GoString() string {
  return s.String()
}

func (s *GetApiDestinationResponseBodyHttpApiParameters) SetEndpoint(v string) *GetApiDestinationResponseBodyHttpApiParameters {
  s.Endpoint = &v
  return s
}

func (s *GetApiDestinationResponseBodyHttpApiParameters) SetMethod(v string) *GetApiDestinationResponseBodyHttpApiParameters {
  s.Method = &v
  return s
}

func (s *GetApiDestinationResponseBodyHttpApiParameters) SetApiParameters(v []*GetApiDestinationResponseBodyHttpApiParametersApiParameters) *GetApiDestinationResponseBodyHttpApiParameters {
  s.ApiParameters = v
  return s
}

type GetApiDestinationResponseBodyHttpApiParametersApiParameters struct     {
  Name *string `json:"name,omitempty" xml:"name,omitempty"`
  // The description of the API destination. The description can be up to 255 characters in length.
  Description *string `json:"description,omitempty" xml:"description,omitempty"`
  Type *string `json:"type,omitempty" xml:"type,omitempty"`
  DefaultValue *string `json:"defaultValue,omitempty" xml:"defaultValue,omitempty"`
  In *string `json:"in,omitempty" xml:"in,omitempty"`
}

func (s GetApiDestinationResponseBodyHttpApiParametersApiParameters) String() string {
  return tea.Prettify(s)
}

func (s GetApiDestinationResponseBodyHttpApiParametersApiParameters) GoString() string {
  return s.String()
}

func (s *GetApiDestinationResponseBodyHttpApiParametersApiParameters) SetName(v string) *GetApiDestinationResponseBodyHttpApiParametersApiParameters {
  s.Name = &v
  return s
}

func (s *GetApiDestinationResponseBodyHttpApiParametersApiParameters) SetDescription(v string) *GetApiDestinationResponseBodyHttpApiParametersApiParameters {
  s.Description = &v
  return s
}

func (s *GetApiDestinationResponseBodyHttpApiParametersApiParameters) SetType(v string) *GetApiDestinationResponseBodyHttpApiParametersApiParameters {
  s.Type = &v
  return s
}

func (s *GetApiDestinationResponseBodyHttpApiParametersApiParameters) SetDefaultValue(v string) *GetApiDestinationResponseBodyHttpApiParametersApiParameters {
  s.DefaultValue = &v
  return s
}

func (s *GetApiDestinationResponseBodyHttpApiParametersApiParameters) SetIn(v string) *GetApiDestinationResponseBodyHttpApiParametersApiParameters {
  s.In = &v
  return s
}

type GetApiDestinationResponse struct {
  Headers map[string]*string `json:"headers,omitempty" xml:"headers,omitempty"`
  StatusCode *int32 `json:"statusCode,omitempty" xml:"statusCode,omitempty"`
  Body *GetApiDestinationResponseBody `json:"body,omitempty" xml:"body,omitempty"`
}

func (s GetApiDestinationResponse) String() string {
  return tea.Prettify(s)
}

func (s GetApiDestinationResponse) GoString() string {
  return s.String()
}

func (s *GetApiDestinationResponse) SetHeaders(v map[string]*string) *GetApiDestinationResponse {
  s.Headers = v
  return s
}

func (s *GetApiDestinationResponse) SetStatusCode(v int32) *GetApiDestinationResponse {
  s.StatusCode = &v
  return s
}

func (s *GetApiDestinationResponse) SetBody(v *GetApiDestinationResponseBody) *GetApiDestinationResponse {
  s.Body = v
  return s
}

type DeleteApiDestinationRequest struct {
  // The name of the API destination. This parameter is required.
  // 
  // example:
  // 
  // ApiDestinationName
  ApiDestinationName *string `json:"apiDestinationName,omitempty" xml:"apiDestinationName,omitempty"`
}

func (s DeleteApiDestinationRequest) String() string {
  return tea.Prettify(s)
}

func (s DeleteApiDestinationRequest) GoString() string {
  return s.String()
}

func (s *DeleteApiDestinationRequest) SetApiDestinationName(v string) *DeleteApiDestinationRequest {
  s.ApiDestinationName = &v
  return s
}

type DeleteApiDestinationResponseBody struct {
  // The returned response code. The value Success indicates that the request is successful.
  // 
  // example:
  // 
  // Success
  Code *string `json:"code,omitempty" xml:"code,omitempty"`
  // The returned message. If the request is successful, success is returned. If the request failed, an error code is returned.
  // 
  // example:
  // 
  // success
  Message *string `json:"message,omitempty" xml:"message,omitempty"`
  // The request ID.
  // 
  // example:
  // 
  // 382E6272-8E9C-5681-AC96-A8AF0BFAC1A5
  RequestId *string `json:"requestId,omitempty" xml:"requestId,omitempty"`
}

func (s DeleteApiDestinationResponseBody) String() string {
  return tea.Prettify(s)
}

func (s DeleteApiDestinationResponseBody) GoString() string {
  return s.String()
}

func (s *DeleteApiDestinationResponseBody) SetCode(v string) *DeleteApiDestinationResponseBody {
  s.Code = &v
  return s
}

func (s *DeleteApiDestinationResponseBody) SetMessage(v string) *DeleteApiDestinationResponseBody {
  s.Message = &v
  return s
}

func (s *DeleteApiDestinationResponseBody) SetRequestId(v string) *DeleteApiDestinationResponseBody {
  s.RequestId = &v
  return s
}

type DeleteApiDestinationResponse struct {
  Headers map[string]*string `json:"headers,omitempty" xml:"headers,omitempty"`
  StatusCode *int32 `json:"statusCode,omitempty" xml:"statusCode,omitempty"`
  Body *DeleteApiDestinationResponseBody `json:"body,omitempty" xml:"body,omitempty"`
}

func (s DeleteApiDestinationResponse) String() string {
  return tea.Prettify(s)
}

func (s DeleteApiDestinationResponse) GoString() string {
  return s.String()
}

func (s *DeleteApiDestinationResponse) SetHeaders(v map[string]*string) *DeleteApiDestinationResponse {
  s.Headers = v
  return s
}

func (s *DeleteApiDestinationResponse) SetStatusCode(v int32) *DeleteApiDestinationResponse {
  s.StatusCode = &v
  return s
}

func (s *DeleteApiDestinationResponse) SetBody(v *DeleteApiDestinationResponseBody) *DeleteApiDestinationResponse {
  s.Body = v
  return s
}

type ListApiDestinationsRequest struct {
  // The prefix of the API destination name.
  // 
  // example:
  // 
  // api-demo
  ApiDestinationNamePrefix *string `json:"apiDestinationNamePrefix,omitempty" xml:"apiDestinationNamePrefix,omitempty"`
  // The connection name.
  // 
  // example:
  // 
  // connection-name
  ConnectionName *string `json:"connectionName,omitempty" xml:"connectionName,omitempty"`
  // The maximum number of entries to be returned in a call. You can use this parameter and NextToken to implement paging. 
  // 
  //     	- Default value: 10.
  // 
  // example:
  // 
  // 10
  MaxResults *int32 `json:"maxResults,omitempty" xml:"maxResults,omitempty"`
  // If you set Limit and excess return values exist, this parameter is returned.
  // 
  //     	- Default value: 0.
  // 
  // example:
  // 
  // 0
  NextToken *string `json:"nextToken,omitempty" xml:"nextToken,omitempty"`
}

func (s ListApiDestinationsRequest) String() string {
  return tea.Prettify(s)
}

func (s ListApiDestinationsRequest) GoString() string {
  return s.String()
}

func (s *ListApiDestinationsRequest) SetApiDestinationNamePrefix(v string) *ListApiDestinationsRequest {
  s.ApiDestinationNamePrefix = &v
  return s
}

func (s *ListApiDestinationsRequest) SetConnectionName(v string) *ListApiDestinationsRequest {
  s.ConnectionName = &v
  return s
}

func (s *ListApiDestinationsRequest) SetMaxResults(v int32) *ListApiDestinationsRequest {
  s.MaxResults = &v
  return s
}

func (s *ListApiDestinationsRequest) SetNextToken(v string) *ListApiDestinationsRequest {
  s.NextToken = &v
  return s
}

type ListApiDestinationsResponseBody struct {
  // The returned response code. The value Success indicates that the request is successful.
  // 
  // example:
  // 
  // Success
  Code *string `json:"code,omitempty" xml:"code,omitempty"`
  // The API destinations.
  ApiDestinations []*ListApiDestinationsResponseBodyApiDestinations `json:"apiDestinations,omitempty" xml:"apiDestinations,omitempty" type:"Repeated"`
  // The maximum number of entries returned per page.
  // 
  // example:
  // 
  // 10
  MaxResults *int32 `json:"maxResults,omitempty" xml:"maxResults,omitempty"`
  // If excess return values exist, this parameter is returned.
  // 
  // example:
  // 
  // 1
  NextToken *string `json:"nextToken,omitempty" xml:"nextToken,omitempty"`
  // The total number of entries returned.
  // 
  // example:
  // 
  // 2
  Total *int `json:"total,omitempty" xml:"total,omitempty"`
  // The returned message. If the request is successful, success is returned. If the request failed, an error code is returned.
  // 
  // example:
  // 
  // success
  Message *string `json:"message,omitempty" xml:"message,omitempty"`
  // The request ID.
  // 
  // example:
  // 
  // 96D7C0AB-DCE5-5E82-96B8-4725E1706BB1
  RequestId *string `json:"requestId,omitempty" xml:"requestId,omitempty"`
}

func (s ListApiDestinationsResponseBody) String() string {
  return tea.Prettify(s)
}

func (s ListApiDestinationsResponseBody) GoString() string {
  return s.String()
}

func (s *ListApiDestinationsResponseBody) SetCode(v string) *ListApiDestinationsResponseBody {
  s.Code = &v
  return s
}

func (s *ListApiDestinationsResponseBody) SetApiDestinations(v []*ListApiDestinationsResponseBodyApiDestinations) *ListApiDestinationsResponseBody {
  s.ApiDestinations = v
  return s
}

func (s *ListApiDestinationsResponseBody) SetMaxResults(v int32) *ListApiDestinationsResponseBody {
  s.MaxResults = &v
  return s
}

func (s *ListApiDestinationsResponseBody) SetNextToken(v string) *ListApiDestinationsResponseBody {
  s.NextToken = &v
  return s
}

func (s *ListApiDestinationsResponseBody) SetTotal(v int) *ListApiDestinationsResponseBody {
  s.Total = &v
  return s
}

func (s *ListApiDestinationsResponseBody) SetMessage(v string) *ListApiDestinationsResponseBody {
  s.Message = &v
  return s
}

func (s *ListApiDestinationsResponseBody) SetRequestId(v string) *ListApiDestinationsResponseBody {
  s.RequestId = &v
  return s
}

type ListApiDestinationsResponseBodyApiDestinations struct     {
  // The name of the API destination.
  // 
  // example:
  // 
  // api-destination-2
  ApiDestinationName *string `json:"apiDestinationName,omitempty" xml:"apiDestinationName,omitempty"`
  // The connection name.
  // 
  // example:
  // 
  // connection-name
  ConnectionName *string `json:"connectionName,omitempty" xml:"connectionName,omitempty"`
  // The description of the connection.
  // 
  // example:
  // 
  // demo
  Description *string `json:"description,omitempty" xml:"description,omitempty"`
  // The time when the API destination was created.
  // 
  // example:
  // 
  // 1665223213000
  GmtCreate *int64 `json:"gmtCreate,omitempty" xml:"gmtCreate,omitempty"`
  // The request parameters that are configured for the API destination.
  HttpApiParameters *ListApiDestinationsResponseBodyApiDestinationsHttpApiParameters `json:"httpApiParameters,omitempty" xml:"httpApiParameters,omitempty" type:"Struct"`
  // TODO
  InvocationRateLimitPerSecond *int `json:"invocationRateLimitPerSecond,omitempty" xml:"invocationRateLimitPerSecond,omitempty"`
}

func (s ListApiDestinationsResponseBodyApiDestinations) String() string {
  return tea.Prettify(s)
}

func (s ListApiDestinationsResponseBodyApiDestinations) GoString() string {
  return s.String()
}

func (s *ListApiDestinationsResponseBodyApiDestinations) SetApiDestinationName(v string) *ListApiDestinationsResponseBodyApiDestinations {
  s.ApiDestinationName = &v
  return s
}

func (s *ListApiDestinationsResponseBodyApiDestinations) SetConnectionName(v string) *ListApiDestinationsResponseBodyApiDestinations {
  s.ConnectionName = &v
  return s
}

func (s *ListApiDestinationsResponseBodyApiDestinations) SetDescription(v string) *ListApiDestinationsResponseBodyApiDestinations {
  s.Description = &v
  return s
}

func (s *ListApiDestinationsResponseBodyApiDestinations) SetGmtCreate(v int64) *ListApiDestinationsResponseBodyApiDestinations {
  s.GmtCreate = &v
  return s
}

func (s *ListApiDestinationsResponseBodyApiDestinations) SetHttpApiParameters(v *ListApiDestinationsResponseBodyApiDestinationsHttpApiParameters) *ListApiDestinationsResponseBodyApiDestinations {
  s.HttpApiParameters = v
  return s
}

func (s *ListApiDestinationsResponseBodyApiDestinations) SetInvocationRateLimitPerSecond(v int) *ListApiDestinationsResponseBodyApiDestinations {
  s.InvocationRateLimitPerSecond = &v
  return s
}

type ListApiDestinationsResponseBodyApiDestinationsHttpApiParameters struct {
  // The endpoint of the API destination.
  // 
  // example:
  // 
  // http://127.0.0.1:8001/api
  Endpoint *string `json:"endpoint,omitempty" xml:"endpoint,omitempty"`
  // The HTTP request method. Valid values:
  // 
  //           - POST
  // 
  //           - GET
  // 
  //           - DELETE
  // 
  //           - PUT
  // 
  //           - HEAD
  // 
  //           - TRACE
  // 
  //           - PATCH
  // 
  // example:
  // 
  // POST
  Method *string `json:"method,omitempty" xml:"method,omitempty"`
  // TODO
  ApiParameters []*ListApiDestinationsResponseBodyApiDestinationsHttpApiParametersApiParameters `json:"apiParameters,omitempty" xml:"apiParameters,omitempty" type:"Repeated"`
}

func (s ListApiDestinationsResponseBodyApiDestinationsHttpApiParameters) String() string {
  return tea.Prettify(s)
}

func (s ListApiDestinationsResponseBodyApiDestinationsHttpApiParameters) GoString() string {
  return s.String()
}

func (s *ListApiDestinationsResponseBodyApiDestinationsHttpApiParameters) SetEndpoint(v string) *ListApiDestinationsResponseBodyApiDestinationsHttpApiParameters {
  s.Endpoint = &v
  return s
}

func (s *ListApiDestinationsResponseBodyApiDestinationsHttpApiParameters) SetMethod(v string) *ListApiDestinationsResponseBodyApiDestinationsHttpApiParameters {
  s.Method = &v
  return s
}

func (s *ListApiDestinationsResponseBodyApiDestinationsHttpApiParameters) SetApiParameters(v []*ListApiDestinationsResponseBodyApiDestinationsHttpApiParametersApiParameters) *ListApiDestinationsResponseBodyApiDestinationsHttpApiParameters {
  s.ApiParameters = v
  return s
}

type ListApiDestinationsResponseBodyApiDestinationsHttpApiParametersApiParameters struct     {
  Name *string `json:"name,omitempty" xml:"name,omitempty"`
  // The description of the API destination. The description can be up to 255 characters in length.
  Description *string `json:"description,omitempty" xml:"description,omitempty"`
  Type *string `json:"type,omitempty" xml:"type,omitempty"`
  DefaultValue *string `json:"defaultValue,omitempty" xml:"defaultValue,omitempty"`
  In *string `json:"in,omitempty" xml:"in,omitempty"`
}

func (s ListApiDestinationsResponseBodyApiDestinationsHttpApiParametersApiParameters) String() string {
  return tea.Prettify(s)
}

func (s ListApiDestinationsResponseBodyApiDestinationsHttpApiParametersApiParameters) GoString() string {
  return s.String()
}

func (s *ListApiDestinationsResponseBodyApiDestinationsHttpApiParametersApiParameters) SetName(v string) *ListApiDestinationsResponseBodyApiDestinationsHttpApiParametersApiParameters {
  s.Name = &v
  return s
}

func (s *ListApiDestinationsResponseBodyApiDestinationsHttpApiParametersApiParameters) SetDescription(v string) *ListApiDestinationsResponseBodyApiDestinationsHttpApiParametersApiParameters {
  s.Description = &v
  return s
}

func (s *ListApiDestinationsResponseBodyApiDestinationsHttpApiParametersApiParameters) SetType(v string) *ListApiDestinationsResponseBodyApiDestinationsHttpApiParametersApiParameters {
  s.Type = &v
  return s
}

func (s *ListApiDestinationsResponseBodyApiDestinationsHttpApiParametersApiParameters) SetDefaultValue(v string) *ListApiDestinationsResponseBodyApiDestinationsHttpApiParametersApiParameters {
  s.DefaultValue = &v
  return s
}

func (s *ListApiDestinationsResponseBodyApiDestinationsHttpApiParametersApiParameters) SetIn(v string) *ListApiDestinationsResponseBodyApiDestinationsHttpApiParametersApiParameters {
  s.In = &v
  return s
}

type ListApiDestinationsResponse struct {
  Headers map[string]*string `json:"headers,omitempty" xml:"headers,omitempty"`
  StatusCode *int32 `json:"statusCode,omitempty" xml:"statusCode,omitempty"`
  Body *ListApiDestinationsResponseBody `json:"body,omitempty" xml:"body,omitempty"`
}

func (s ListApiDestinationsResponse) String() string {
  return tea.Prettify(s)
}

func (s ListApiDestinationsResponse) GoString() string {
  return s.String()
}

func (s *ListApiDestinationsResponse) SetHeaders(v map[string]*string) *ListApiDestinationsResponse {
  s.Headers = v
  return s
}

func (s *ListApiDestinationsResponse) SetStatusCode(v int32) *ListApiDestinationsResponse {
  s.StatusCode = &v
  return s
}

func (s *ListApiDestinationsResponse) SetBody(v *ListApiDestinationsResponseBody) *ListApiDestinationsResponse {
  s.Body = v
  return s
}

// Description:
// 
// Connection Controller apis:
// 
// createConnection    *
// 
// deleteConnection    *
// 
// updateConnection    *
// 
// getConnection       *
// 
// selectOneConnection *
// 
// listConnections     *
// 
// listEnumsResponse   *
type CreateConnectionRequest struct {
  // The parameters that are configured for authentication.
  AuthParameters *CreateConnectionRequestAuthParameters `json:"authParameters,omitempty" xml:"authParameters,omitempty" type:"Struct"`
  // The name of the connection. The name must be 2 to 127 characters in length.
  // 
  //     This parameter is required.
  // 
  // example:
  // 
  // connection-name
  ConnectionName *string `json:"connectionName,omitempty" xml:"connectionName,omitempty"`
  // The description of the connection. The description can be up to 255 characters in length.
  // 
  // example:
  // 
  // demo
  Description *string `json:"description,omitempty" xml:"description,omitempty"`
  // The parameters that are configured for the network. This parameter is required.
  NetworkParameters *CreateConnectionRequestNetworkParameters `json:"networkParameters,omitempty" xml:"networkParameters,omitempty" type:"Struct"`
}

func (s CreateConnectionRequest) String() string {
  return tea.Prettify(s)
}

func (s CreateConnectionRequest) GoString() string {
  return s.String()
}

func (s *CreateConnectionRequest) SetAuthParameters(v *CreateConnectionRequestAuthParameters) *CreateConnectionRequest {
  s.AuthParameters = v
  return s
}

func (s *CreateConnectionRequest) SetConnectionName(v string) *CreateConnectionRequest {
  s.ConnectionName = &v
  return s
}

func (s *CreateConnectionRequest) SetDescription(v string) *CreateConnectionRequest {
  s.Description = &v
  return s
}

func (s *CreateConnectionRequest) SetNetworkParameters(v *CreateConnectionRequestNetworkParameters) *CreateConnectionRequest {
  s.NetworkParameters = v
  return s
}

type CreateConnectionRequestAuthParameters struct {
  // The parameters that are configured for API key authentication.
  ApiKeyAuthParameters *CreateConnectionRequestAuthParametersApiKeyAuthParameters `json:"apiKeyAuthParameters,omitempty" xml:"apiKeyAuthParameters,omitempty" type:"Struct"`
  // The authentication type. Valid values:
  // 
  //       BASIC_AUTH: basic authentication.
  // 
  //       Introduction: Basic authentication is a simple authentication scheme built into the HTTP protocol. When you use the HTTP protocol for communications, the authentication method that the HTTP server uses to authenticate user identities on the client is defined in the protocol. The request header is in the Authorization: Basic Base64-encoded string (Username:Password) format.
  // 
  //       1.  Username and Password are required
  // 
  //       API_KEY_AUTH: API key authentication.
  // 
  //       Introduction: The request header is in the Token: Token value format.
  // 
  //       	- ApiKeyName and ApiKeyValue are required.
  // 
  //       OAUTH_AUTH: OAuth authentication.
  // 
  //       Introduction: OAuth2.0 is an authentication mechanism. In normal cases, a system that does not use OAuth2.0 can access the resources of the server from the client. To ensure access security, access tokens are used to authenticate users in OAuth 2.0. The client must use an access token to access protected resources. This way, OAuth 2.0 protects resources from being accessed from malicious clients and improves system security.
  // 
  //       	- AuthorizationEndpoint, OAuthHttpParameters, and HttpMethod are required.
  // 
  // example:
  // 
  // BASIC_AUTH
  AuthorizationType *string `json:"authorizationType,omitempty" xml:"authorizationType,omitempty"`
  // The parameters that are configured for basic authentication.
  BasicAuthParameters *CreateConnectionRequestAuthParametersBasicAuthParameters `json:"basicAuthParameters,omitempty" xml:"basicAuthParameters,omitempty" type:"Struct"`
  // The parameters that are configured for OAuth authentication.
  OauthParameters *CreateConnectionRequestAuthParametersOauthParameters `json:"oauthParameters,omitempty" xml:"oauthParameters,omitempty" type:"Struct"`
}

func (s CreateConnectionRequestAuthParameters) String() string {
  return tea.Prettify(s)
}

func (s CreateConnectionRequestAuthParameters) GoString() string {
  return s.String()
}

func (s *CreateConnectionRequestAuthParameters) SetApiKeyAuthParameters(v *CreateConnectionRequestAuthParametersApiKeyAuthParameters) *CreateConnectionRequestAuthParameters {
  s.ApiKeyAuthParameters = v
  return s
}

func (s *CreateConnectionRequestAuthParameters) SetAuthorizationType(v string) *CreateConnectionRequestAuthParameters {
  s.AuthorizationType = &v
  return s
}

func (s *CreateConnectionRequestAuthParameters) SetBasicAuthParameters(v *CreateConnectionRequestAuthParametersBasicAuthParameters) *CreateConnectionRequestAuthParameters {
  s.BasicAuthParameters = v
  return s
}

func (s *CreateConnectionRequestAuthParameters) SetOauthParameters(v *CreateConnectionRequestAuthParametersOauthParameters) *CreateConnectionRequestAuthParameters {
  s.OauthParameters = v
  return s
}

type CreateConnectionRequestAuthParametersApiKeyAuthParameters struct {
  // The key of the API key.
  // 
  // example:
  // 
  // Token
  ApiKeyName *string `json:"apiKeyName,omitempty" xml:"apiKeyName,omitempty"`
  // The value of the API key.
  // 
  // example:
  // 
  // adkjnakddh****
  ApiKeyValue *string `json:"apiKeyValue,omitempty" xml:"apiKeyValue,omitempty"`
}

func (s CreateConnectionRequestAuthParametersApiKeyAuthParameters) String() string {
  return tea.Prettify(s)
}

func (s CreateConnectionRequestAuthParametersApiKeyAuthParameters) GoString() string {
  return s.String()
}

func (s *CreateConnectionRequestAuthParametersApiKeyAuthParameters) SetApiKeyName(v string) *CreateConnectionRequestAuthParametersApiKeyAuthParameters {
  s.ApiKeyName = &v
  return s
}

func (s *CreateConnectionRequestAuthParametersApiKeyAuthParameters) SetApiKeyValue(v string) *CreateConnectionRequestAuthParametersApiKeyAuthParameters {
  s.ApiKeyValue = &v
  return s
}

type CreateConnectionRequestAuthParametersBasicAuthParameters struct {
  // The password for basic authentication.
  // 
  // example:
  // 
  // *******
  Password *string `json:"password,omitempty" xml:"password,omitempty"`
  // The username for basic authentication.
  // 
  // example:
  // 
  // admin
  Username *string `json:"username,omitempty" xml:"username,omitempty"`
}

func (s CreateConnectionRequestAuthParametersBasicAuthParameters) String() string {
  return tea.Prettify(s)
}

func (s CreateConnectionRequestAuthParametersBasicAuthParameters) GoString() string {
  return s.String()
}

func (s *CreateConnectionRequestAuthParametersBasicAuthParameters) SetPassword(v string) *CreateConnectionRequestAuthParametersBasicAuthParameters {
  s.Password = &v
  return s
}

func (s *CreateConnectionRequestAuthParametersBasicAuthParameters) SetUsername(v string) *CreateConnectionRequestAuthParametersBasicAuthParameters {
  s.Username = &v
  return s
}

type CreateConnectionRequestAuthParametersOauthParameters struct {
  // The endpoint that is used to obtain the OAuth token.
  // 
  // example:
  // 
  // http://localhost:8080/oauth/token
  AuthorizationEndpoint *string `json:"authorizationEndpoint,omitempty" xml:"authorizationEndpoint,omitempty"`
  // The parameters that are configured for the client.
  ClientParameters *CreateConnectionRequestAuthParametersOauthParametersClientParameters `json:"clientParameters,omitempty" xml:"clientParameters,omitempty" type:"Struct"`
  // The HTTP request method. Valid values:
  // 
  //         - GET
  // 
  //         - POST
  // 
  //         - HEAD
  // 
  // example:
  // 
  // POST
  HttpMethod *string `json:"httpMethod,omitempty" xml:"httpMethod,omitempty"`
  // The request parameters for OAuth authentication.
  OauthHttpParameters *CreateConnectionRequestAuthParametersOauthParametersOauthHttpParameters `json:"oauthHttpParameters,omitempty" xml:"oauthHttpParameters,omitempty" type:"Struct"`
}

func (s CreateConnectionRequestAuthParametersOauthParameters) String() string {
  return tea.Prettify(s)
}

func (s CreateConnectionRequestAuthParametersOauthParameters) GoString() string {
  return s.String()
}

func (s *CreateConnectionRequestAuthParametersOauthParameters) SetAuthorizationEndpoint(v string) *CreateConnectionRequestAuthParametersOauthParameters {
  s.AuthorizationEndpoint = &v
  return s
}

func (s *CreateConnectionRequestAuthParametersOauthParameters) SetClientParameters(v *CreateConnectionRequestAuthParametersOauthParametersClientParameters) *CreateConnectionRequestAuthParametersOauthParameters {
  s.ClientParameters = v
  return s
}

func (s *CreateConnectionRequestAuthParametersOauthParameters) SetHttpMethod(v string) *CreateConnectionRequestAuthParametersOauthParameters {
  s.HttpMethod = &v
  return s
}

func (s *CreateConnectionRequestAuthParametersOauthParameters) SetOauthHttpParameters(v *CreateConnectionRequestAuthParametersOauthParametersOauthHttpParameters) *CreateConnectionRequestAuthParametersOauthParameters {
  s.OauthHttpParameters = v
  return s
}

type CreateConnectionRequestAuthParametersOauthParametersClientParameters struct {
  // The client ID.
  // 
  // example:
  // 
  // ClientID
  ClientID *string `json:"clientID,omitempty" xml:"clientID,omitempty"`
  // The client key secret of the application.
  // 
  // example:
  // 
  // ClientSecret
  ClientSecret *string `json:"clientSecret,omitempty" xml:"clientSecret,omitempty"`
}

func (s CreateConnectionRequestAuthParametersOauthParametersClientParameters) String() string {
  return tea.Prettify(s)
}

func (s CreateConnectionRequestAuthParametersOauthParametersClientParameters) GoString() string {
  return s.String()
}

func (s *CreateConnectionRequestAuthParametersOauthParametersClientParameters) SetClientID(v string) *CreateConnectionRequestAuthParametersOauthParametersClientParameters {
  s.ClientID = &v
  return s
}

func (s *CreateConnectionRequestAuthParametersOauthParametersClientParameters) SetClientSecret(v string) *CreateConnectionRequestAuthParametersOauthParametersClientParameters {
  s.ClientSecret = &v
  return s
}

type CreateConnectionRequestAuthParametersOauthParametersOauthHttpParameters struct {
  // The parameters that are configured for the request.
  BodyParameters []*CreateConnectionRequestAuthParametersOauthParametersOauthHttpParametersBodyParameters `json:"bodyParameters,omitempty" xml:"bodyParameters,omitempty" type:"Repeated"`
  // The parameters that are configured for the request header.
  HeaderParameters []*CreateConnectionRequestAuthParametersOauthParametersOauthHttpParametersHeaderParameters `json:"headerParameters,omitempty" xml:"headerParameters,omitempty" type:"Repeated"`
  // The parameters that are configured for the request path.
  QueryStringParameters []*CreateConnectionRequestAuthParametersOauthParametersOauthHttpParametersQueryStringParameters `json:"queryStringParameters,omitempty" xml:"queryStringParameters,omitempty" type:"Repeated"`
}

func (s CreateConnectionRequestAuthParametersOauthParametersOauthHttpParameters) String() string {
  return tea.Prettify(s)
}

func (s CreateConnectionRequestAuthParametersOauthParametersOauthHttpParameters) GoString() string {
  return s.String()
}

func (s *CreateConnectionRequestAuthParametersOauthParametersOauthHttpParameters) SetBodyParameters(v []*CreateConnectionRequestAuthParametersOauthParametersOauthHttpParametersBodyParameters) *CreateConnectionRequestAuthParametersOauthParametersOauthHttpParameters {
  s.BodyParameters = v
  return s
}

func (s *CreateConnectionRequestAuthParametersOauthParametersOauthHttpParameters) SetHeaderParameters(v []*CreateConnectionRequestAuthParametersOauthParametersOauthHttpParametersHeaderParameters) *CreateConnectionRequestAuthParametersOauthParametersOauthHttpParameters {
  s.HeaderParameters = v
  return s
}

func (s *CreateConnectionRequestAuthParametersOauthParametersOauthHttpParameters) SetQueryStringParameters(v []*CreateConnectionRequestAuthParametersOauthParametersOauthHttpParametersQueryStringParameters) *CreateConnectionRequestAuthParametersOauthParametersOauthHttpParameters {
  s.QueryStringParameters = v
  return s
}

type CreateConnectionRequestAuthParametersOauthParametersOauthHttpParametersBodyParameters struct     {
  // Indicates whether authentication is enabled.
  // 
  // example:
  // 
  // false
  IsValueSecret *string `json:"isValueSecret,omitempty" xml:"isValueSecret,omitempty"`
  // The key in the request body.
  // 
  // example:
  // 
  // name
  Key *string `json:"key,omitempty" xml:"key,omitempty"`
  // The value of the key in the request body.
  // 
  // example:
  // 
  // demo
  Value *string `json:"value,omitempty" xml:"value,omitempty"`
}

func (s CreateConnectionRequestAuthParametersOauthParametersOauthHttpParametersBodyParameters) String() string {
  return tea.Prettify(s)
}

func (s CreateConnectionRequestAuthParametersOauthParametersOauthHttpParametersBodyParameters) GoString() string {
  return s.String()
}

func (s *CreateConnectionRequestAuthParametersOauthParametersOauthHttpParametersBodyParameters) SetIsValueSecret(v string) *CreateConnectionRequestAuthParametersOauthParametersOauthHttpParametersBodyParameters {
  s.IsValueSecret = &v
  return s
}

func (s *CreateConnectionRequestAuthParametersOauthParametersOauthHttpParametersBodyParameters) SetKey(v string) *CreateConnectionRequestAuthParametersOauthParametersOauthHttpParametersBodyParameters {
  s.Key = &v
  return s
}

func (s *CreateConnectionRequestAuthParametersOauthParametersOauthHttpParametersBodyParameters) SetValue(v string) *CreateConnectionRequestAuthParametersOauthParametersOauthHttpParametersBodyParameters {
  s.Value = &v
  return s
}

type CreateConnectionRequestAuthParametersOauthParametersOauthHttpParametersHeaderParameters struct     {
  // Indicates whether authentication is enabled.
  // 
  // example:
  // 
  // false
  IsValueSecret *string `json:"isValueSecret,omitempty" xml:"isValueSecret,omitempty"`
  // The key in the request header.
  // 
  // example:
  // 
  // name
  Key *string `json:"key,omitempty" xml:"key,omitempty"`
  // The value of the key in the request header.
  // 
  // example:
  // 
  // demo
  Value *string `json:"value,omitempty" xml:"value,omitempty"`
}

func (s CreateConnectionRequestAuthParametersOauthParametersOauthHttpParametersHeaderParameters) String() string {
  return tea.Prettify(s)
}

func (s CreateConnectionRequestAuthParametersOauthParametersOauthHttpParametersHeaderParameters) GoString() string {
  return s.String()
}

func (s *CreateConnectionRequestAuthParametersOauthParametersOauthHttpParametersHeaderParameters) SetIsValueSecret(v string) *CreateConnectionRequestAuthParametersOauthParametersOauthHttpParametersHeaderParameters {
  s.IsValueSecret = &v
  return s
}

func (s *CreateConnectionRequestAuthParametersOauthParametersOauthHttpParametersHeaderParameters) SetKey(v string) *CreateConnectionRequestAuthParametersOauthParametersOauthHttpParametersHeaderParameters {
  s.Key = &v
  return s
}

func (s *CreateConnectionRequestAuthParametersOauthParametersOauthHttpParametersHeaderParameters) SetValue(v string) *CreateConnectionRequestAuthParametersOauthParametersOauthHttpParametersHeaderParameters {
  s.Value = &v
  return s
}

type CreateConnectionRequestAuthParametersOauthParametersOauthHttpParametersQueryStringParameters struct     {
  // Indicates whether authentication is enabled.
  // 
  // example:
  // 
  // false
  IsValueSecret *string `json:"isValueSecret,omitempty" xml:"isValueSecret,omitempty"`
  // The key in the request path.
  // 
  // example:
  // 
  // name
  Key *string `json:"key,omitempty" xml:"key,omitempty"`
  // The value of the key in the request path.
  // 
  // example:
  // 
  // demo
  Value *string `json:"value,omitempty" xml:"value,omitempty"`
}

func (s CreateConnectionRequestAuthParametersOauthParametersOauthHttpParametersQueryStringParameters) String() string {
  return tea.Prettify(s)
}

func (s CreateConnectionRequestAuthParametersOauthParametersOauthHttpParametersQueryStringParameters) GoString() string {
  return s.String()
}

func (s *CreateConnectionRequestAuthParametersOauthParametersOauthHttpParametersQueryStringParameters) SetIsValueSecret(v string) *CreateConnectionRequestAuthParametersOauthParametersOauthHttpParametersQueryStringParameters {
  s.IsValueSecret = &v
  return s
}

func (s *CreateConnectionRequestAuthParametersOauthParametersOauthHttpParametersQueryStringParameters) SetKey(v string) *CreateConnectionRequestAuthParametersOauthParametersOauthHttpParametersQueryStringParameters {
  s.Key = &v
  return s
}

func (s *CreateConnectionRequestAuthParametersOauthParametersOauthHttpParametersQueryStringParameters) SetValue(v string) *CreateConnectionRequestAuthParametersOauthParametersOauthHttpParametersQueryStringParameters {
  s.Value = &v
  return s
}

type CreateConnectionRequestNetworkParameters struct {
  // The network type. Valid values:
  // 
  //       PublicNetwork and PrivateNetwork.
  // 
  //       	- Note: If you set this parameter to PrivateNetwork, you must configure VpcId, VswitcheId, and SecurityGroupId.
  // 
  //       This parameter is required.
  // 
  // example:
  // 
  // PublicNetwork
  NetworkType *string `json:"networkType,omitempty" xml:"networkType,omitempty"`
  // The ID of the security group.
  // 
  // example:
  // 
  // eb-167adad548759-security_grop/sg-bp1addad26peuh9qh9****
  SecurityGroupId *string `json:"securityGroupId,omitempty" xml:"securityGroupId,omitempty"`
  // The VPC. ID
  // 
  // example:
  // 
  // eb-test/vpc-bp1symadadwnwg****
  VpcId *string `json:"vpcId,omitempty" xml:"vpcId,omitempty"`
  // The vSwitch ID.
  // 
  // example:
  // 
  // vsw-bp1iu4x7aeradadown1og8,vsw-bp193sqmadadlaszpeq****
  VswitcheId *string `json:"vswitcheId,omitempty" xml:"vswitcheId,omitempty"`
}

func (s CreateConnectionRequestNetworkParameters) String() string {
  return tea.Prettify(s)
}

func (s CreateConnectionRequestNetworkParameters) GoString() string {
  return s.String()
}

func (s *CreateConnectionRequestNetworkParameters) SetNetworkType(v string) *CreateConnectionRequestNetworkParameters {
  s.NetworkType = &v
  return s
}

func (s *CreateConnectionRequestNetworkParameters) SetSecurityGroupId(v string) *CreateConnectionRequestNetworkParameters {
  s.SecurityGroupId = &v
  return s
}

func (s *CreateConnectionRequestNetworkParameters) SetVpcId(v string) *CreateConnectionRequestNetworkParameters {
  s.VpcId = &v
  return s
}

func (s *CreateConnectionRequestNetworkParameters) SetVswitcheId(v string) *CreateConnectionRequestNetworkParameters {
  s.VswitcheId = &v
  return s
}

type CreateConnectionResponseBody struct {
  // The returned response code. The value Success indicates that the request is successful.
  // 
  // example:
  // 
  // Success
  Code *string `json:"code,omitempty" xml:"code,omitempty"`
  // The connection name.
  // 
  // example:
  // 
  // connection-demo
  ConnectionName *string `json:"connectionName,omitempty" xml:"connectionName,omitempty"`
  // The returned message. If the request is successful, success is returned. If the request failed, an error code is returned.
  // 
  // example:
  // 
  // success
  Message *string `json:"message,omitempty" xml:"message,omitempty"`
  // The request ID.
  // 
  // example:
  // 
  // 7DA60DED-CD36-5837-B848-C01A23D2****
  RequestId *string `json:"requestId,omitempty" xml:"requestId,omitempty"`
}

func (s CreateConnectionResponseBody) String() string {
  return tea.Prettify(s)
}

func (s CreateConnectionResponseBody) GoString() string {
  return s.String()
}

func (s *CreateConnectionResponseBody) SetCode(v string) *CreateConnectionResponseBody {
  s.Code = &v
  return s
}

func (s *CreateConnectionResponseBody) SetConnectionName(v string) *CreateConnectionResponseBody {
  s.ConnectionName = &v
  return s
}

func (s *CreateConnectionResponseBody) SetMessage(v string) *CreateConnectionResponseBody {
  s.Message = &v
  return s
}

func (s *CreateConnectionResponseBody) SetRequestId(v string) *CreateConnectionResponseBody {
  s.RequestId = &v
  return s
}

type CreateConnectionResponse struct {
  Headers map[string]*string `json:"headers,omitempty" xml:"headers,omitempty"`
  StatusCode *int32 `json:"statusCode,omitempty" xml:"statusCode,omitempty"`
  Body *CreateConnectionResponseBody `json:"body,omitempty" xml:"body,omitempty"`
}

func (s CreateConnectionResponse) String() string {
  return tea.Prettify(s)
}

func (s CreateConnectionResponse) GoString() string {
  return s.String()
}

func (s *CreateConnectionResponse) SetHeaders(v map[string]*string) *CreateConnectionResponse {
  s.Headers = v
  return s
}

func (s *CreateConnectionResponse) SetStatusCode(v int32) *CreateConnectionResponse {
  s.StatusCode = &v
  return s
}

func (s *CreateConnectionResponse) SetBody(v *CreateConnectionResponseBody) *CreateConnectionResponse {
  s.Body = v
  return s
}

type DeleteConnectionRequest struct {
  // The name of the connection that you want to delete. This parameter is required.
  // 
  // example:
  // 
  // connection-name
  ConnectionName *string `json:"connectionName,omitempty" xml:"connectionName,omitempty"`
}

func (s DeleteConnectionRequest) String() string {
  return tea.Prettify(s)
}

func (s DeleteConnectionRequest) GoString() string {
  return s.String()
}

func (s *DeleteConnectionRequest) SetConnectionName(v string) *DeleteConnectionRequest {
  s.ConnectionName = &v
  return s
}

type DeleteConnectionResponseBody struct {
  // The returned response code. The value Success indicates that the request is successful.
  // 
  // example:
  // 
  // Success
  Code *string `json:"code,omitempty" xml:"code,omitempty"`
  // The returned message. If the request is successful, success is returned. If the request failed, an error code is returned.
  // 
  // example:
  // 
  // success
  Message *string `json:"message,omitempty" xml:"message,omitempty"`
  // The request ID.
  // 
  // example:
  // 
  // 8EF25E37-1750-5D7A-BA56-F8AE081A69C8
  RequestId *string `json:"requestId,omitempty" xml:"requestId,omitempty"`
}

func (s DeleteConnectionResponseBody) String() string {
  return tea.Prettify(s)
}

func (s DeleteConnectionResponseBody) GoString() string {
  return s.String()
}

func (s *DeleteConnectionResponseBody) SetCode(v string) *DeleteConnectionResponseBody {
  s.Code = &v
  return s
}

func (s *DeleteConnectionResponseBody) SetMessage(v string) *DeleteConnectionResponseBody {
  s.Message = &v
  return s
}

func (s *DeleteConnectionResponseBody) SetRequestId(v string) *DeleteConnectionResponseBody {
  s.RequestId = &v
  return s
}

type DeleteConnectionResponse struct {
  Headers map[string]*string `json:"headers,omitempty" xml:"headers,omitempty"`
  StatusCode *int32 `json:"statusCode,omitempty" xml:"statusCode,omitempty"`
  Body *DeleteConnectionResponseBody `json:"body,omitempty" xml:"body,omitempty"`
}

func (s DeleteConnectionResponse) String() string {
  return tea.Prettify(s)
}

func (s DeleteConnectionResponse) GoString() string {
  return s.String()
}

func (s *DeleteConnectionResponse) SetHeaders(v map[string]*string) *DeleteConnectionResponse {
  s.Headers = v
  return s
}

func (s *DeleteConnectionResponse) SetStatusCode(v int32) *DeleteConnectionResponse {
  s.StatusCode = &v
  return s
}

func (s *DeleteConnectionResponse) SetBody(v *DeleteConnectionResponseBody) *DeleteConnectionResponse {
  s.Body = v
  return s
}

type UpdateConnectionRequest struct {
  // The parameters that are configured for authentication.
  AuthParameters *UpdateConnectionRequestAuthParameters `json:"authParameters,omitempty" xml:"authParameters,omitempty" type:"Struct"`
  // The name of the connection. The name must be 2 to 127 characters in length.
  // 
  //     This parameter is required.
  // 
  // example:
  // 
  // connection-name
  ConnectionName *string `json:"connectionName,omitempty" xml:"connectionName,omitempty"`
  // The description of the connection. The description can be up to 255 characters in length.
  // 
  // example:
  // 
  // demo
  Description *string `json:"description,omitempty" xml:"description,omitempty"`
  // The parameters that are configured for the network. This parameter is required.
  NetworkParameters *UpdateConnectionRequestNetworkParameters `json:"networkParameters,omitempty" xml:"networkParameters,omitempty" type:"Struct"`
}

func (s UpdateConnectionRequest) String() string {
  return tea.Prettify(s)
}

func (s UpdateConnectionRequest) GoString() string {
  return s.String()
}

func (s *UpdateConnectionRequest) SetAuthParameters(v *UpdateConnectionRequestAuthParameters) *UpdateConnectionRequest {
  s.AuthParameters = v
  return s
}

func (s *UpdateConnectionRequest) SetConnectionName(v string) *UpdateConnectionRequest {
  s.ConnectionName = &v
  return s
}

func (s *UpdateConnectionRequest) SetDescription(v string) *UpdateConnectionRequest {
  s.Description = &v
  return s
}

func (s *UpdateConnectionRequest) SetNetworkParameters(v *UpdateConnectionRequestNetworkParameters) *UpdateConnectionRequest {
  s.NetworkParameters = v
  return s
}

type UpdateConnectionRequestAuthParameters struct {
  // The parameters that are configured for API key authentication.
  ApiKeyAuthParameters *UpdateConnectionRequestAuthParametersApiKeyAuthParameters `json:"apiKeyAuthParameters,omitempty" xml:"apiKeyAuthParameters,omitempty" type:"Struct"`
  // The authentication type. Valid values:
  // 
  //       BASIC_AUTH: basic authentication.
  // 
  //       Introduction: Basic authentication is a simple authentication scheme built into the HTTP protocol. When you use the HTTP protocol for communications, the authentication method that the HTTP server uses to authenticate user identities on the client is defined in the protocol. The request header is in the Authorization: Basic Base64-encoded string (Username:Password) format.
  // 
  //       1.  Username and Password are required
  // 
  //       API_KEY_AUTH: API key authentication.
  // 
  //       Introduction: The request header is in the Token: Token value format.
  // 
  //       	- ApiKeyName and ApiKeyValue are required.
  // 
  //       OAUTH_AUTH: OAuth authentication.
  // 
  //       Introduction: OAuth2.0 is an authentication mechanism. In normal cases, a system that does not use OAuth2.0 can access the resources of the server from the client. To ensure access security, access tokens are used to authenticate users in OAuth 2.0. The client must use an access token to access protected resources. This way, OAuth 2.0 protects resources from being accessed from malicious clients and improves system security.
  // 
  //       	- AuthorizationEndpoint, OAuthHttpParameters, and HttpMethod are required.
  // 
  // example:
  // 
  // BASIC_AUTH
  AuthorizationType *string `json:"authorizationType,omitempty" xml:"authorizationType,omitempty"`
  // The parameters that are configured for basic authentication.
  BasicAuthParameters *UpdateConnectionRequestAuthParametersBasicAuthParameters `json:"basicAuthParameters,omitempty" xml:"basicAuthParameters,omitempty" type:"Struct"`
  // The parameters that are configured for OAuth authentication.
  OauthParameters *UpdateConnectionRequestAuthParametersOauthParameters `json:"oauthParameters,omitempty" xml:"oauthParameters,omitempty" type:"Struct"`
}

func (s UpdateConnectionRequestAuthParameters) String() string {
  return tea.Prettify(s)
}

func (s UpdateConnectionRequestAuthParameters) GoString() string {
  return s.String()
}

func (s *UpdateConnectionRequestAuthParameters) SetApiKeyAuthParameters(v *UpdateConnectionRequestAuthParametersApiKeyAuthParameters) *UpdateConnectionRequestAuthParameters {
  s.ApiKeyAuthParameters = v
  return s
}

func (s *UpdateConnectionRequestAuthParameters) SetAuthorizationType(v string) *UpdateConnectionRequestAuthParameters {
  s.AuthorizationType = &v
  return s
}

func (s *UpdateConnectionRequestAuthParameters) SetBasicAuthParameters(v *UpdateConnectionRequestAuthParametersBasicAuthParameters) *UpdateConnectionRequestAuthParameters {
  s.BasicAuthParameters = v
  return s
}

func (s *UpdateConnectionRequestAuthParameters) SetOauthParameters(v *UpdateConnectionRequestAuthParametersOauthParameters) *UpdateConnectionRequestAuthParameters {
  s.OauthParameters = v
  return s
}

type UpdateConnectionRequestAuthParametersApiKeyAuthParameters struct {
  // The key of the API key.
  // 
  // example:
  // 
  // Token
  ApiKeyName *string `json:"apiKeyName,omitempty" xml:"apiKeyName,omitempty"`
  // The value of the API key.
  // 
  // example:
  // 
  // adkjnakddh****
  ApiKeyValue *string `json:"apiKeyValue,omitempty" xml:"apiKeyValue,omitempty"`
}

func (s UpdateConnectionRequestAuthParametersApiKeyAuthParameters) String() string {
  return tea.Prettify(s)
}

func (s UpdateConnectionRequestAuthParametersApiKeyAuthParameters) GoString() string {
  return s.String()
}

func (s *UpdateConnectionRequestAuthParametersApiKeyAuthParameters) SetApiKeyName(v string) *UpdateConnectionRequestAuthParametersApiKeyAuthParameters {
  s.ApiKeyName = &v
  return s
}

func (s *UpdateConnectionRequestAuthParametersApiKeyAuthParameters) SetApiKeyValue(v string) *UpdateConnectionRequestAuthParametersApiKeyAuthParameters {
  s.ApiKeyValue = &v
  return s
}

type UpdateConnectionRequestAuthParametersBasicAuthParameters struct {
  // The password for basic authentication.
  // 
  // example:
  // 
  // *******
  Password *string `json:"password,omitempty" xml:"password,omitempty"`
  // The username for basic authentication.
  // 
  // example:
  // 
  // admin
  Username *string `json:"username,omitempty" xml:"username,omitempty"`
}

func (s UpdateConnectionRequestAuthParametersBasicAuthParameters) String() string {
  return tea.Prettify(s)
}

func (s UpdateConnectionRequestAuthParametersBasicAuthParameters) GoString() string {
  return s.String()
}

func (s *UpdateConnectionRequestAuthParametersBasicAuthParameters) SetPassword(v string) *UpdateConnectionRequestAuthParametersBasicAuthParameters {
  s.Password = &v
  return s
}

func (s *UpdateConnectionRequestAuthParametersBasicAuthParameters) SetUsername(v string) *UpdateConnectionRequestAuthParametersBasicAuthParameters {
  s.Username = &v
  return s
}

type UpdateConnectionRequestAuthParametersOauthParameters struct {
  // The endpoint that is used to obtain the OAuth token.
  // 
  // example:
  // 
  // http://localhost:8080/oauth/token
  AuthorizationEndpoint *string `json:"authorizationEndpoint,omitempty" xml:"authorizationEndpoint,omitempty"`
  // The parameters that are configured for the client.
  ClientParameters *UpdateConnectionRequestAuthParametersOauthParametersClientParameters `json:"clientParameters,omitempty" xml:"clientParameters,omitempty" type:"Struct"`
  // The HTTP request method. Valid values:
  // 
  //         - GET
  // 
  //         - POST
  // 
  //         - HEAD
  // 
  // example:
  // 
  // POST
  HttpMethod *string `json:"httpMethod,omitempty" xml:"httpMethod,omitempty"`
  // The request parameters for OAuth authentication.
  OauthHttpParameters *UpdateConnectionRequestAuthParametersOauthParametersOauthHttpParameters `json:"oauthHttpParameters,omitempty" xml:"oauthHttpParameters,omitempty" type:"Struct"`
}

func (s UpdateConnectionRequestAuthParametersOauthParameters) String() string {
  return tea.Prettify(s)
}

func (s UpdateConnectionRequestAuthParametersOauthParameters) GoString() string {
  return s.String()
}

func (s *UpdateConnectionRequestAuthParametersOauthParameters) SetAuthorizationEndpoint(v string) *UpdateConnectionRequestAuthParametersOauthParameters {
  s.AuthorizationEndpoint = &v
  return s
}

func (s *UpdateConnectionRequestAuthParametersOauthParameters) SetClientParameters(v *UpdateConnectionRequestAuthParametersOauthParametersClientParameters) *UpdateConnectionRequestAuthParametersOauthParameters {
  s.ClientParameters = v
  return s
}

func (s *UpdateConnectionRequestAuthParametersOauthParameters) SetHttpMethod(v string) *UpdateConnectionRequestAuthParametersOauthParameters {
  s.HttpMethod = &v
  return s
}

func (s *UpdateConnectionRequestAuthParametersOauthParameters) SetOauthHttpParameters(v *UpdateConnectionRequestAuthParametersOauthParametersOauthHttpParameters) *UpdateConnectionRequestAuthParametersOauthParameters {
  s.OauthHttpParameters = v
  return s
}

type UpdateConnectionRequestAuthParametersOauthParametersClientParameters struct {
  // The client ID.
  // 
  // example:
  // 
  // ClientID
  ClientID *string `json:"clientID,omitempty" xml:"clientID,omitempty"`
  // The client key secret of the application.
  // 
  // example:
  // 
  // ClientSecret
  ClientSecret *string `json:"clientSecret,omitempty" xml:"clientSecret,omitempty"`
}

func (s UpdateConnectionRequestAuthParametersOauthParametersClientParameters) String() string {
  return tea.Prettify(s)
}

func (s UpdateConnectionRequestAuthParametersOauthParametersClientParameters) GoString() string {
  return s.String()
}

func (s *UpdateConnectionRequestAuthParametersOauthParametersClientParameters) SetClientID(v string) *UpdateConnectionRequestAuthParametersOauthParametersClientParameters {
  s.ClientID = &v
  return s
}

func (s *UpdateConnectionRequestAuthParametersOauthParametersClientParameters) SetClientSecret(v string) *UpdateConnectionRequestAuthParametersOauthParametersClientParameters {
  s.ClientSecret = &v
  return s
}

type UpdateConnectionRequestAuthParametersOauthParametersOauthHttpParameters struct {
  // The parameters that are configured for the request.
  BodyParameters []*UpdateConnectionRequestAuthParametersOauthParametersOauthHttpParametersBodyParameters `json:"bodyParameters,omitempty" xml:"bodyParameters,omitempty" type:"Repeated"`
  // The parameters that are configured for the request header.
  HeaderParameters []*UpdateConnectionRequestAuthParametersOauthParametersOauthHttpParametersHeaderParameters `json:"headerParameters,omitempty" xml:"headerParameters,omitempty" type:"Repeated"`
  // The parameters that are configured for the request path.
  QueryStringParameters []*UpdateConnectionRequestAuthParametersOauthParametersOauthHttpParametersQueryStringParameters `json:"queryStringParameters,omitempty" xml:"queryStringParameters,omitempty" type:"Repeated"`
}

func (s UpdateConnectionRequestAuthParametersOauthParametersOauthHttpParameters) String() string {
  return tea.Prettify(s)
}

func (s UpdateConnectionRequestAuthParametersOauthParametersOauthHttpParameters) GoString() string {
  return s.String()
}

func (s *UpdateConnectionRequestAuthParametersOauthParametersOauthHttpParameters) SetBodyParameters(v []*UpdateConnectionRequestAuthParametersOauthParametersOauthHttpParametersBodyParameters) *UpdateConnectionRequestAuthParametersOauthParametersOauthHttpParameters {
  s.BodyParameters = v
  return s
}

func (s *UpdateConnectionRequestAuthParametersOauthParametersOauthHttpParameters) SetHeaderParameters(v []*UpdateConnectionRequestAuthParametersOauthParametersOauthHttpParametersHeaderParameters) *UpdateConnectionRequestAuthParametersOauthParametersOauthHttpParameters {
  s.HeaderParameters = v
  return s
}

func (s *UpdateConnectionRequestAuthParametersOauthParametersOauthHttpParameters) SetQueryStringParameters(v []*UpdateConnectionRequestAuthParametersOauthParametersOauthHttpParametersQueryStringParameters) *UpdateConnectionRequestAuthParametersOauthParametersOauthHttpParameters {
  s.QueryStringParameters = v
  return s
}

type UpdateConnectionRequestAuthParametersOauthParametersOauthHttpParametersBodyParameters struct     {
  // Indicates whether authentication is enabled.
  // 
  // example:
  // 
  // false
  IsValueSecret *string `json:"isValueSecret,omitempty" xml:"isValueSecret,omitempty"`
  // The key in the request body.
  // 
  // example:
  // 
  // name
  Key *string `json:"key,omitempty" xml:"key,omitempty"`
  // The value of the key in the request body.
  // 
  // example:
  // 
  // demo
  Value *string `json:"value,omitempty" xml:"value,omitempty"`
}

func (s UpdateConnectionRequestAuthParametersOauthParametersOauthHttpParametersBodyParameters) String() string {
  return tea.Prettify(s)
}

func (s UpdateConnectionRequestAuthParametersOauthParametersOauthHttpParametersBodyParameters) GoString() string {
  return s.String()
}

func (s *UpdateConnectionRequestAuthParametersOauthParametersOauthHttpParametersBodyParameters) SetIsValueSecret(v string) *UpdateConnectionRequestAuthParametersOauthParametersOauthHttpParametersBodyParameters {
  s.IsValueSecret = &v
  return s
}

func (s *UpdateConnectionRequestAuthParametersOauthParametersOauthHttpParametersBodyParameters) SetKey(v string) *UpdateConnectionRequestAuthParametersOauthParametersOauthHttpParametersBodyParameters {
  s.Key = &v
  return s
}

func (s *UpdateConnectionRequestAuthParametersOauthParametersOauthHttpParametersBodyParameters) SetValue(v string) *UpdateConnectionRequestAuthParametersOauthParametersOauthHttpParametersBodyParameters {
  s.Value = &v
  return s
}

type UpdateConnectionRequestAuthParametersOauthParametersOauthHttpParametersHeaderParameters struct     {
  // Indicates whether authentication is enabled.
  // 
  // example:
  // 
  // false
  IsValueSecret *string `json:"isValueSecret,omitempty" xml:"isValueSecret,omitempty"`
  // The key in the request header.
  // 
  // example:
  // 
  // name
  Key *string `json:"key,omitempty" xml:"key,omitempty"`
  // The value of the key in the request header.
  // 
  // example:
  // 
  // demo
  Value *string `json:"value,omitempty" xml:"value,omitempty"`
}

func (s UpdateConnectionRequestAuthParametersOauthParametersOauthHttpParametersHeaderParameters) String() string {
  return tea.Prettify(s)
}

func (s UpdateConnectionRequestAuthParametersOauthParametersOauthHttpParametersHeaderParameters) GoString() string {
  return s.String()
}

func (s *UpdateConnectionRequestAuthParametersOauthParametersOauthHttpParametersHeaderParameters) SetIsValueSecret(v string) *UpdateConnectionRequestAuthParametersOauthParametersOauthHttpParametersHeaderParameters {
  s.IsValueSecret = &v
  return s
}

func (s *UpdateConnectionRequestAuthParametersOauthParametersOauthHttpParametersHeaderParameters) SetKey(v string) *UpdateConnectionRequestAuthParametersOauthParametersOauthHttpParametersHeaderParameters {
  s.Key = &v
  return s
}

func (s *UpdateConnectionRequestAuthParametersOauthParametersOauthHttpParametersHeaderParameters) SetValue(v string) *UpdateConnectionRequestAuthParametersOauthParametersOauthHttpParametersHeaderParameters {
  s.Value = &v
  return s
}

type UpdateConnectionRequestAuthParametersOauthParametersOauthHttpParametersQueryStringParameters struct     {
  // Indicates whether authentication is enabled.
  // 
  // example:
  // 
  // false
  IsValueSecret *string `json:"isValueSecret,omitempty" xml:"isValueSecret,omitempty"`
  // The key in the request path.
  // 
  // example:
  // 
  // name
  Key *string `json:"key,omitempty" xml:"key,omitempty"`
  // The value of the key in the request path.
  // 
  // example:
  // 
  // demo
  Value *string `json:"value,omitempty" xml:"value,omitempty"`
}

func (s UpdateConnectionRequestAuthParametersOauthParametersOauthHttpParametersQueryStringParameters) String() string {
  return tea.Prettify(s)
}

func (s UpdateConnectionRequestAuthParametersOauthParametersOauthHttpParametersQueryStringParameters) GoString() string {
  return s.String()
}

func (s *UpdateConnectionRequestAuthParametersOauthParametersOauthHttpParametersQueryStringParameters) SetIsValueSecret(v string) *UpdateConnectionRequestAuthParametersOauthParametersOauthHttpParametersQueryStringParameters {
  s.IsValueSecret = &v
  return s
}

func (s *UpdateConnectionRequestAuthParametersOauthParametersOauthHttpParametersQueryStringParameters) SetKey(v string) *UpdateConnectionRequestAuthParametersOauthParametersOauthHttpParametersQueryStringParameters {
  s.Key = &v
  return s
}

func (s *UpdateConnectionRequestAuthParametersOauthParametersOauthHttpParametersQueryStringParameters) SetValue(v string) *UpdateConnectionRequestAuthParametersOauthParametersOauthHttpParametersQueryStringParameters {
  s.Value = &v
  return s
}

type UpdateConnectionRequestNetworkParameters struct {
  // The network type. Valid values:
  // 
  //       PublicNetwork and PrivateNetwork.
  // 
  //       	- Note: If you set this parameter to PrivateNetwork, you must configure VpcId, VswitcheId, and SecurityGroupId.
  // 
  //       This parameter is required.
  // 
  // example:
  // 
  // PublicNetwork
  NetworkType *string `json:"networkType,omitempty" xml:"networkType,omitempty"`
  // The ID of the security group.
  // 
  // example:
  // 
  // eb-167adad548759-security_grop/sg-bp1addad26peuh9qh9****
  SecurityGroupId *string `json:"securityGroupId,omitempty" xml:"securityGroupId,omitempty"`
  // The VPC. ID
  // 
  // example:
  // 
  // eb-test/vpc-bp1symadadwnwg****
  VpcId *string `json:"vpcId,omitempty" xml:"vpcId,omitempty"`
  // The vSwitch ID.
  // 
  // example:
  // 
  // vsw-bp1iu4x7aeradadown1og8,vsw-bp193sqmadadlaszpeq****
  VswitcheId *string `json:"vswitcheId,omitempty" xml:"vswitcheId,omitempty"`
}

func (s UpdateConnectionRequestNetworkParameters) String() string {
  return tea.Prettify(s)
}

func (s UpdateConnectionRequestNetworkParameters) GoString() string {
  return s.String()
}

func (s *UpdateConnectionRequestNetworkParameters) SetNetworkType(v string) *UpdateConnectionRequestNetworkParameters {
  s.NetworkType = &v
  return s
}

func (s *UpdateConnectionRequestNetworkParameters) SetSecurityGroupId(v string) *UpdateConnectionRequestNetworkParameters {
  s.SecurityGroupId = &v
  return s
}

func (s *UpdateConnectionRequestNetworkParameters) SetVpcId(v string) *UpdateConnectionRequestNetworkParameters {
  s.VpcId = &v
  return s
}

func (s *UpdateConnectionRequestNetworkParameters) SetVswitcheId(v string) *UpdateConnectionRequestNetworkParameters {
  s.VswitcheId = &v
  return s
}

type UpdateConnectionResponseBody struct {
  // The returned response code.
  // 
  // example:
  // 
  // Success
  Code *string `json:"code,omitempty" xml:"code,omitempty"`
  // The returned message.
  // 
  // example:
  // 
  // success
  Message *string `json:"message,omitempty" xml:"message,omitempty"`
  // The request ID.
  // 
  // example:
  // 
  // 8346BE8F-40F3-533D-A0B8-1359C31BD5BA
  RequestId *string `json:"requestId,omitempty" xml:"requestId,omitempty"`
}

func (s UpdateConnectionResponseBody) String() string {
  return tea.Prettify(s)
}

func (s UpdateConnectionResponseBody) GoString() string {
  return s.String()
}

func (s *UpdateConnectionResponseBody) SetCode(v string) *UpdateConnectionResponseBody {
  s.Code = &v
  return s
}

func (s *UpdateConnectionResponseBody) SetMessage(v string) *UpdateConnectionResponseBody {
  s.Message = &v
  return s
}

func (s *UpdateConnectionResponseBody) SetRequestId(v string) *UpdateConnectionResponseBody {
  s.RequestId = &v
  return s
}

type UpdateConnectionResponse struct {
  Headers map[string]*string `json:"headers,omitempty" xml:"headers,omitempty"`
  StatusCode *int32 `json:"statusCode,omitempty" xml:"statusCode,omitempty"`
  Body *UpdateConnectionResponseBody `json:"body,omitempty" xml:"body,omitempty"`
}

func (s UpdateConnectionResponse) String() string {
  return tea.Prettify(s)
}

func (s UpdateConnectionResponse) GoString() string {
  return s.String()
}

func (s *UpdateConnectionResponse) SetHeaders(v map[string]*string) *UpdateConnectionResponse {
  s.Headers = v
  return s
}

func (s *UpdateConnectionResponse) SetStatusCode(v int32) *UpdateConnectionResponse {
  s.StatusCode = &v
  return s
}

func (s *UpdateConnectionResponse) SetBody(v *UpdateConnectionResponseBody) *UpdateConnectionResponse {
  s.Body = v
  return s
}

type GetConnectionRequest struct {
  // The connection name. This parameter is required.
  // 
  // example:
  // 
  // connection-name
  ConnectionName *string `json:"connectionName,omitempty" xml:"connectionName,omitempty"`
}

func (s GetConnectionRequest) String() string {
  return tea.Prettify(s)
}

func (s GetConnectionRequest) GoString() string {
  return s.String()
}

func (s *GetConnectionRequest) SetConnectionName(v string) *GetConnectionRequest {
  s.ConnectionName = &v
  return s
}

type GetConnectionResponseBody struct {
  // The returned response code. The value Success indicates that the request is successful.
  // 
  // example:
  // 
  // Success
  Code *string `json:"code,omitempty" xml:"code,omitempty"`
  // The value of the key in the request path.
  Connections []*GetConnectionResponseBodyConnections `json:"connections,omitempty" xml:"connections,omitempty" type:"Repeated"`
  // The returned message.
  // 
  // example:
  // 
  // success
  Message *string `json:"message,omitempty" xml:"message,omitempty"`
  // The returned request ID.
  // 
  // example:
  // 
  // 34AD682D-5B91-5773-8132-AA38C130****
  RequestId *string `json:"requestId,omitempty" xml:"requestId,omitempty"`
}

func (s GetConnectionResponseBody) String() string {
  return tea.Prettify(s)
}

func (s GetConnectionResponseBody) GoString() string {
  return s.String()
}

func (s *GetConnectionResponseBody) SetCode(v string) *GetConnectionResponseBody {
  s.Code = &v
  return s
}

func (s *GetConnectionResponseBody) SetConnections(v []*GetConnectionResponseBodyConnections) *GetConnectionResponseBody {
  s.Connections = v
  return s
}

func (s *GetConnectionResponseBody) SetMessage(v string) *GetConnectionResponseBody {
  s.Message = &v
  return s
}

func (s *GetConnectionResponseBody) SetRequestId(v string) *GetConnectionResponseBody {
  s.RequestId = &v
  return s
}

type GetConnectionResponseBodyConnections struct     {
  // The parameters that are configured for authentication.
  AuthParameters *GetConnectionResponseBodyConnectionsAuthParameters `json:"authParameters,omitempty" xml:"authParameters,omitempty" type:"Struct"`
  // The connection name.
  // 
  // example:
  // 
  // connection-name
  ConnectionName *string `json:"connectionName,omitempty" xml:"connectionName,omitempty"`
  // The connection description.
  // 
  // example:
  // 
  // The description of the connection.
  Description *string `json:"description,omitempty" xml:"description,omitempty"`
  // The time when the connection was created.
  // 
  // example:
  // 
  // 1592838994234
  GmtCreate *int64 `json:"gmtCreate,omitempty" xml:"gmtCreate,omitempty"`
  // The connection ID.
  // 
  // example:
  // 
  // 1141093
  Id *int `json:"id,omitempty" xml:"id,omitempty"`
  NetworkParameters *GetConnectionResponseBodyConnectionsNetworkParameters `json:"networkParameters,omitempty" xml:"networkParameters,omitempty" type:"Struct"`
}

func (s GetConnectionResponseBodyConnections) String() string {
  return tea.Prettify(s)
}

func (s GetConnectionResponseBodyConnections) GoString() string {
  return s.String()
}

func (s *GetConnectionResponseBodyConnections) SetAuthParameters(v *GetConnectionResponseBodyConnectionsAuthParameters) *GetConnectionResponseBodyConnections {
  s.AuthParameters = v
  return s
}

func (s *GetConnectionResponseBodyConnections) SetConnectionName(v string) *GetConnectionResponseBodyConnections {
  s.ConnectionName = &v
  return s
}

func (s *GetConnectionResponseBodyConnections) SetDescription(v string) *GetConnectionResponseBodyConnections {
  s.Description = &v
  return s
}

func (s *GetConnectionResponseBodyConnections) SetGmtCreate(v int64) *GetConnectionResponseBodyConnections {
  s.GmtCreate = &v
  return s
}

func (s *GetConnectionResponseBodyConnections) SetId(v int) *GetConnectionResponseBodyConnections {
  s.Id = &v
  return s
}

func (s *GetConnectionResponseBodyConnections) SetNetworkParameters(v *GetConnectionResponseBodyConnectionsNetworkParameters) *GetConnectionResponseBodyConnections {
  s.NetworkParameters = v
  return s
}

type GetConnectionResponseBodyConnectionsAuthParameters struct {
  // The parameters that are configured for API key authentication.
  ApiKeyAuthParameters *GetConnectionResponseBodyConnectionsAuthParametersApiKeyAuthParameters `json:"apiKeyAuthParameters,omitempty" xml:"apiKeyAuthParameters,omitempty" type:"Struct"`
  // The authentication type. Valid values:
  // 
  // 
  //           - BASIC_AUTH: basic authentication.
  // 
  // 
  //           - API_KEY_AUTH: API key authentication.
  // 
  // 
  //           - OAUTH_AUTH: OAuth authentication.
  // 
  // example:
  // 
  // BASIC_AUTH
  AuthorizationType *string `json:"authorizationType,omitempty" xml:"authorizationType,omitempty"`
  // The parameters that are configured for basic authentication.
  BasicAuthParameters *GetConnectionResponseBodyConnectionsAuthParametersBasicAuthParameters `json:"basicAuthParameters,omitempty" xml:"basicAuthParameters,omitempty" type:"Struct"`
  // The parameters that are configured for OAuth authentication.
  OauthParameters *GetConnectionResponseBodyConnectionsAuthParametersOauthParameters `json:"oauthParameters,omitempty" xml:"oauthParameters,omitempty" type:"Struct"`
}

func (s GetConnectionResponseBodyConnectionsAuthParameters) String() string {
  return tea.Prettify(s)
}

func (s GetConnectionResponseBodyConnectionsAuthParameters) GoString() string {
  return s.String()
}

func (s *GetConnectionResponseBodyConnectionsAuthParameters) SetApiKeyAuthParameters(v *GetConnectionResponseBodyConnectionsAuthParametersApiKeyAuthParameters) *GetConnectionResponseBodyConnectionsAuthParameters {
  s.ApiKeyAuthParameters = v
  return s
}

func (s *GetConnectionResponseBodyConnectionsAuthParameters) SetAuthorizationType(v string) *GetConnectionResponseBodyConnectionsAuthParameters {
  s.AuthorizationType = &v
  return s
}

func (s *GetConnectionResponseBodyConnectionsAuthParameters) SetBasicAuthParameters(v *GetConnectionResponseBodyConnectionsAuthParametersBasicAuthParameters) *GetConnectionResponseBodyConnectionsAuthParameters {
  s.BasicAuthParameters = v
  return s
}

func (s *GetConnectionResponseBodyConnectionsAuthParameters) SetOauthParameters(v *GetConnectionResponseBodyConnectionsAuthParametersOauthParameters) *GetConnectionResponseBodyConnectionsAuthParameters {
  s.OauthParameters = v
  return s
}

type GetConnectionResponseBodyConnectionsAuthParametersApiKeyAuthParameters struct {
  // The API key.
  // 
  // example:
  // 
  // Token
  ApiKeyName *string `json:"apiKeyName,omitempty" xml:"apiKeyName,omitempty"`
  // The value of the API key.
  // 
  // example:
  // 
  // asdkjnqkwejooa
  ApiKeyValue *string `json:"apiKeyValue,omitempty" xml:"apiKeyValue,omitempty"`
}

func (s GetConnectionResponseBodyConnectionsAuthParametersApiKeyAuthParameters) String() string {
  return tea.Prettify(s)
}

func (s GetConnectionResponseBodyConnectionsAuthParametersApiKeyAuthParameters) GoString() string {
  return s.String()
}

func (s *GetConnectionResponseBodyConnectionsAuthParametersApiKeyAuthParameters) SetApiKeyName(v string) *GetConnectionResponseBodyConnectionsAuthParametersApiKeyAuthParameters {
  s.ApiKeyName = &v
  return s
}

func (s *GetConnectionResponseBodyConnectionsAuthParametersApiKeyAuthParameters) SetApiKeyValue(v string) *GetConnectionResponseBodyConnectionsAuthParametersApiKeyAuthParameters {
  s.ApiKeyValue = &v
  return s
}

type GetConnectionResponseBodyConnectionsAuthParametersBasicAuthParameters struct {
  // The password for basic authentication.
  // 
  // example:
  // 
  // admin
  Password *string `json:"password,omitempty" xml:"password,omitempty"`
  // The username for basic authentication.
  // 
  // example:
  // 
  // admin
  Username *string `json:"username,omitempty" xml:"username,omitempty"`
}

func (s GetConnectionResponseBodyConnectionsAuthParametersBasicAuthParameters) String() string {
  return tea.Prettify(s)
}

func (s GetConnectionResponseBodyConnectionsAuthParametersBasicAuthParameters) GoString() string {
  return s.String()
}

func (s *GetConnectionResponseBodyConnectionsAuthParametersBasicAuthParameters) SetPassword(v string) *GetConnectionResponseBodyConnectionsAuthParametersBasicAuthParameters {
  s.Password = &v
  return s
}

func (s *GetConnectionResponseBodyConnectionsAuthParametersBasicAuthParameters) SetUsername(v string) *GetConnectionResponseBodyConnectionsAuthParametersBasicAuthParameters {
  s.Username = &v
  return s
}

type GetConnectionResponseBodyConnectionsAuthParametersOauthParameters struct {
  // The endpoint that is used to obtain the OAuth token.
  // 
  // example:
  // 
  // http://localhost:8080/oauth/token
  AuthorizationEndpoint *string `json:"authorizationEndpoint,omitempty" xml:"authorizationEndpoint,omitempty"`
  // The parameters that are configured for the client.
  ClientParameters *GetConnectionResponseBodyConnectionsAuthParametersOauthParametersClientParameters `json:"clientParameters,omitempty" xml:"clientParameters,omitempty" type:"Struct"`
  // The HTTP request method. Valid values:
  // 
  //             - GET
  // 
  //             - POST
  // 
  //             - HEAD
  // 
  // example:
  // 
  // POST
  HttpMethod *string `json:"httpMethod,omitempty" xml:"httpMethod,omitempty"`
  // The request parameters for OAuth authentication.
  OauthHttpParameters *GetConnectionResponseBodyConnectionsAuthParametersOauthParametersOauthHttpParameters `json:"oauthHttpParameters,omitempty" xml:"oauthHttpParameters,omitempty" type:"Struct"`
}

func (s GetConnectionResponseBodyConnectionsAuthParametersOauthParameters) String() string {
  return tea.Prettify(s)
}

func (s GetConnectionResponseBodyConnectionsAuthParametersOauthParameters) GoString() string {
  return s.String()
}

func (s *GetConnectionResponseBodyConnectionsAuthParametersOauthParameters) SetAuthorizationEndpoint(v string) *GetConnectionResponseBodyConnectionsAuthParametersOauthParameters {
  s.AuthorizationEndpoint = &v
  return s
}

func (s *GetConnectionResponseBodyConnectionsAuthParametersOauthParameters) SetClientParameters(v *GetConnectionResponseBodyConnectionsAuthParametersOauthParametersClientParameters) *GetConnectionResponseBodyConnectionsAuthParametersOauthParameters {
  s.ClientParameters = v
  return s
}

func (s *GetConnectionResponseBodyConnectionsAuthParametersOauthParameters) SetHttpMethod(v string) *GetConnectionResponseBodyConnectionsAuthParametersOauthParameters {
  s.HttpMethod = &v
  return s
}

func (s *GetConnectionResponseBodyConnectionsAuthParametersOauthParameters) SetOauthHttpParameters(v *GetConnectionResponseBodyConnectionsAuthParametersOauthParametersOauthHttpParameters) *GetConnectionResponseBodyConnectionsAuthParametersOauthParameters {
  s.OauthHttpParameters = v
  return s
}

type GetConnectionResponseBodyConnectionsAuthParametersOauthParametersClientParameters struct {
  // The client ID.
  // 
  // example:
  // 
  // ClientID
  ClientID *string `json:"clientID,omitempty" xml:"clientID,omitempty"`
  // The client key secret of the application.
  // 
  // example:
  // 
  // ClientSecret
  ClientSecret *string `json:"clientSecret,omitempty" xml:"clientSecret,omitempty"`
}

func (s GetConnectionResponseBodyConnectionsAuthParametersOauthParametersClientParameters) String() string {
  return tea.Prettify(s)
}

func (s GetConnectionResponseBodyConnectionsAuthParametersOauthParametersClientParameters) GoString() string {
  return s.String()
}

func (s *GetConnectionResponseBodyConnectionsAuthParametersOauthParametersClientParameters) SetClientID(v string) *GetConnectionResponseBodyConnectionsAuthParametersOauthParametersClientParameters {
  s.ClientID = &v
  return s
}

func (s *GetConnectionResponseBodyConnectionsAuthParametersOauthParametersClientParameters) SetClientSecret(v string) *GetConnectionResponseBodyConnectionsAuthParametersOauthParametersClientParameters {
  s.ClientSecret = &v
  return s
}

type GetConnectionResponseBodyConnectionsAuthParametersOauthParametersOauthHttpParameters struct {
  // The parameters that are configured for the request.
  BodyParameters []*GetConnectionResponseBodyConnectionsAuthParametersOauthParametersOauthHttpParametersBodyParameters `json:"bodyParameters,omitempty" xml:"bodyParameters,omitempty" type:"Repeated"`
  // The parameters that are configured for the request header.
  HeaderParameters []*GetConnectionResponseBodyConnectionsAuthParametersOauthParametersOauthHttpParametersHeaderParameters `json:"headerParameters,omitempty" xml:"headerParameters,omitempty" type:"Repeated"`
  // The parameters that are configured for the request path.
  QueryStringParameters []*GetConnectionResponseBodyConnectionsAuthParametersOauthParametersOauthHttpParametersQueryStringParameters `json:"queryStringParameters,omitempty" xml:"queryStringParameters,omitempty" type:"Repeated"`
}

func (s GetConnectionResponseBodyConnectionsAuthParametersOauthParametersOauthHttpParameters) String() string {
  return tea.Prettify(s)
}

func (s GetConnectionResponseBodyConnectionsAuthParametersOauthParametersOauthHttpParameters) GoString() string {
  return s.String()
}

func (s *GetConnectionResponseBodyConnectionsAuthParametersOauthParametersOauthHttpParameters) SetBodyParameters(v []*GetConnectionResponseBodyConnectionsAuthParametersOauthParametersOauthHttpParametersBodyParameters) *GetConnectionResponseBodyConnectionsAuthParametersOauthParametersOauthHttpParameters {
  s.BodyParameters = v
  return s
}

func (s *GetConnectionResponseBodyConnectionsAuthParametersOauthParametersOauthHttpParameters) SetHeaderParameters(v []*GetConnectionResponseBodyConnectionsAuthParametersOauthParametersOauthHttpParametersHeaderParameters) *GetConnectionResponseBodyConnectionsAuthParametersOauthParametersOauthHttpParameters {
  s.HeaderParameters = v
  return s
}

func (s *GetConnectionResponseBodyConnectionsAuthParametersOauthParametersOauthHttpParameters) SetQueryStringParameters(v []*GetConnectionResponseBodyConnectionsAuthParametersOauthParametersOauthHttpParametersQueryStringParameters) *GetConnectionResponseBodyConnectionsAuthParametersOauthParametersOauthHttpParameters {
  s.QueryStringParameters = v
  return s
}

type GetConnectionResponseBodyConnectionsAuthParametersOauthParametersOauthHttpParametersBodyParameters struct     {
  // Indicates whether authentication is enabled.
  // 
  // example:
  // 
  // false
  IsValueSecret *string `json:"isValueSecret,omitempty" xml:"isValueSecret,omitempty"`
  // The key in the request body.
  // 
  // example:
  // 
  // name
  Key *string `json:"key,omitempty" xml:"key,omitempty"`
  // The value of the key in the request body.
  // 
  // example:
  // 
  // demo
  Value *string `json:"value,omitempty" xml:"value,omitempty"`
}

func (s GetConnectionResponseBodyConnectionsAuthParametersOauthParametersOauthHttpParametersBodyParameters) String() string {
  return tea.Prettify(s)
}

func (s GetConnectionResponseBodyConnectionsAuthParametersOauthParametersOauthHttpParametersBodyParameters) GoString() string {
  return s.String()
}

func (s *GetConnectionResponseBodyConnectionsAuthParametersOauthParametersOauthHttpParametersBodyParameters) SetIsValueSecret(v string) *GetConnectionResponseBodyConnectionsAuthParametersOauthParametersOauthHttpParametersBodyParameters {
  s.IsValueSecret = &v
  return s
}

func (s *GetConnectionResponseBodyConnectionsAuthParametersOauthParametersOauthHttpParametersBodyParameters) SetKey(v string) *GetConnectionResponseBodyConnectionsAuthParametersOauthParametersOauthHttpParametersBodyParameters {
  s.Key = &v
  return s
}

func (s *GetConnectionResponseBodyConnectionsAuthParametersOauthParametersOauthHttpParametersBodyParameters) SetValue(v string) *GetConnectionResponseBodyConnectionsAuthParametersOauthParametersOauthHttpParametersBodyParameters {
  s.Value = &v
  return s
}

type GetConnectionResponseBodyConnectionsAuthParametersOauthParametersOauthHttpParametersHeaderParameters struct     {
  // Indicates whether authentication is enabled.
  // 
  // example:
  // 
  // false
  IsValueSecret *string `json:"isValueSecret,omitempty" xml:"isValueSecret,omitempty"`
  // The key in the request header.
  // 
  // example:
  // 
  // name
  Key *string `json:"key,omitempty" xml:"key,omitempty"`
  // The value of the key in the request header.
  // 
  // example:
  // 
  // demo
  Value *string `json:"value,omitempty" xml:"value,omitempty"`
}

func (s GetConnectionResponseBodyConnectionsAuthParametersOauthParametersOauthHttpParametersHeaderParameters) String() string {
  return tea.Prettify(s)
}

func (s GetConnectionResponseBodyConnectionsAuthParametersOauthParametersOauthHttpParametersHeaderParameters) GoString() string {
  return s.String()
}

func (s *GetConnectionResponseBodyConnectionsAuthParametersOauthParametersOauthHttpParametersHeaderParameters) SetIsValueSecret(v string) *GetConnectionResponseBodyConnectionsAuthParametersOauthParametersOauthHttpParametersHeaderParameters {
  s.IsValueSecret = &v
  return s
}

func (s *GetConnectionResponseBodyConnectionsAuthParametersOauthParametersOauthHttpParametersHeaderParameters) SetKey(v string) *GetConnectionResponseBodyConnectionsAuthParametersOauthParametersOauthHttpParametersHeaderParameters {
  s.Key = &v
  return s
}

func (s *GetConnectionResponseBodyConnectionsAuthParametersOauthParametersOauthHttpParametersHeaderParameters) SetValue(v string) *GetConnectionResponseBodyConnectionsAuthParametersOauthParametersOauthHttpParametersHeaderParameters {
  s.Value = &v
  return s
}

type GetConnectionResponseBodyConnectionsAuthParametersOauthParametersOauthHttpParametersQueryStringParameters struct     {
  // Indicates whether authentication is enabled.
  // 
  // example:
  // 
  // false
  IsValueSecret *string `json:"isValueSecret,omitempty" xml:"isValueSecret,omitempty"`
  // The key in the request path.
  // 
  // example:
  // 
  // name
  Key *string `json:"key,omitempty" xml:"key,omitempty"`
  // The value of the key in the request path.
  // 
  // example:
  // 
  // demo
  Value *string `json:"value,omitempty" xml:"value,omitempty"`
}

func (s GetConnectionResponseBodyConnectionsAuthParametersOauthParametersOauthHttpParametersQueryStringParameters) String() string {
  return tea.Prettify(s)
}

func (s GetConnectionResponseBodyConnectionsAuthParametersOauthParametersOauthHttpParametersQueryStringParameters) GoString() string {
  return s.String()
}

func (s *GetConnectionResponseBodyConnectionsAuthParametersOauthParametersOauthHttpParametersQueryStringParameters) SetIsValueSecret(v string) *GetConnectionResponseBodyConnectionsAuthParametersOauthParametersOauthHttpParametersQueryStringParameters {
  s.IsValueSecret = &v
  return s
}

func (s *GetConnectionResponseBodyConnectionsAuthParametersOauthParametersOauthHttpParametersQueryStringParameters) SetKey(v string) *GetConnectionResponseBodyConnectionsAuthParametersOauthParametersOauthHttpParametersQueryStringParameters {
  s.Key = &v
  return s
}

func (s *GetConnectionResponseBodyConnectionsAuthParametersOauthParametersOauthHttpParametersQueryStringParameters) SetValue(v string) *GetConnectionResponseBodyConnectionsAuthParametersOauthParametersOauthHttpParametersQueryStringParameters {
  s.Value = &v
  return s
}

type GetConnectionResponseBodyConnectionsNetworkParameters struct {
  // The network type. Valid values:PublicNetwork and PrivateNetwork.
  // 
  // example:
  // 
  // PublicNetwork
  NetworkType *string `json:"networkType,omitempty" xml:"networkType,omitempty"`
  // The security group ID.
  // 
  // example:
  // 
  // eb-167adad548759-security_grop/sg-bp1addad26peuh9qh9rtyb
  SecurityGroupId *string `json:"securityGroupId,omitempty" xml:"securityGroupId,omitempty"`
  // The virtual private cloud (VPC) ID.
  // 
  // example:
  // 
  // eb-test/vpc-bp1symadadwnwgmqud
  VpcId *string `json:"vpcId,omitempty" xml:"vpcId,omitempty"`
  // The vSwitch ID.
  // 
  // example:
  // 
  // vsw-bp1iu4x7aeradadown1og8,vsw-bp193sqmadadlaszpeqbt2c
  VswitcheId *string `json:"vswitcheId,omitempty" xml:"vswitcheId,omitempty"`
}

func (s GetConnectionResponseBodyConnectionsNetworkParameters) String() string {
  return tea.Prettify(s)
}

func (s GetConnectionResponseBodyConnectionsNetworkParameters) GoString() string {
  return s.String()
}

func (s *GetConnectionResponseBodyConnectionsNetworkParameters) SetNetworkType(v string) *GetConnectionResponseBodyConnectionsNetworkParameters {
  s.NetworkType = &v
  return s
}

func (s *GetConnectionResponseBodyConnectionsNetworkParameters) SetSecurityGroupId(v string) *GetConnectionResponseBodyConnectionsNetworkParameters {
  s.SecurityGroupId = &v
  return s
}

func (s *GetConnectionResponseBodyConnectionsNetworkParameters) SetVpcId(v string) *GetConnectionResponseBodyConnectionsNetworkParameters {
  s.VpcId = &v
  return s
}

func (s *GetConnectionResponseBodyConnectionsNetworkParameters) SetVswitcheId(v string) *GetConnectionResponseBodyConnectionsNetworkParameters {
  s.VswitcheId = &v
  return s
}

type GetConnectionResponse struct {
  Headers map[string]*string `json:"headers,omitempty" xml:"headers,omitempty"`
  StatusCode *int32 `json:"statusCode,omitempty" xml:"statusCode,omitempty"`
  Body *GetConnectionResponseBody `json:"body,omitempty" xml:"body,omitempty"`
}

func (s GetConnectionResponse) String() string {
  return tea.Prettify(s)
}

func (s GetConnectionResponse) GoString() string {
  return s.String()
}

func (s *GetConnectionResponse) SetHeaders(v map[string]*string) *GetConnectionResponse {
  s.Headers = v
  return s
}

func (s *GetConnectionResponse) SetStatusCode(v int32) *GetConnectionResponse {
  s.StatusCode = &v
  return s
}

func (s *GetConnectionResponse) SetBody(v *GetConnectionResponseBody) *GetConnectionResponse {
  s.Body = v
  return s
}

type ListConnectionsRequest struct {
  // The key word that you specify to query connections. Connections can be queried by prefixes.
  // 
  // example:
  // 
  // connection-name
  ConnectionNamePrefix *string `json:"connectionNamePrefix,omitempty" xml:"connectionNamePrefix,omitempty"`
  // The maximum number of entries to be returned in a single call. You can use this parameter and the NextToken parameter to implement paging.
  // 
  //     	- Default value: 10.
  // 
  // example:
  // 
  // 10
  MaxResults *int32 `json:"maxResults,omitempty" xml:"maxResults,omitempty"`
  // If you set the Limit parameter and excess return values exist, this parameter is returned.
  // 
  //     	- Default value: 0.
  // 
  // example:
  // 
  // 0
  NextToken *string `json:"nextToken,omitempty" xml:"nextToken,omitempty"`
}

func (s ListConnectionsRequest) String() string {
  return tea.Prettify(s)
}

func (s ListConnectionsRequest) GoString() string {
  return s.String()
}

func (s *ListConnectionsRequest) SetConnectionNamePrefix(v string) *ListConnectionsRequest {
  s.ConnectionNamePrefix = &v
  return s
}

func (s *ListConnectionsRequest) SetMaxResults(v int32) *ListConnectionsRequest {
  s.MaxResults = &v
  return s
}

func (s *ListConnectionsRequest) SetNextToken(v string) *ListConnectionsRequest {
  s.NextToken = &v
  return s
}

type ListConnectionsResponseBody struct {
  // The HTTP status code. The value Success indicates that the request is successful.
  // 
  // example:
  // 
  // Success
  Code *string `json:"code,omitempty" xml:"code,omitempty"`
  // The value of the key in the request path.
  Connections []*ListConnectionsResponseBodyConnections `json:"connections,omitempty" xml:"connections,omitempty" type:"Repeated"`
  // The number of entries returned per page.
  // 
  // example:
  // 
  // 10
  MaxResults *int32 `json:"maxResults,omitempty" xml:"maxResults,omitempty"`
  // If excess return values exist, this parameter is returned.
  // 
  // example:
  // 
  // 0
  NextToken *string `json:"nextToken,omitempty" xml:"nextToken,omitempty"`
  // The total number of entries returned.
  // 
  // example:
  // 
  // 1
  Total *int `json:"total,omitempty" xml:"total,omitempty"`
  // The message returned.
  // 
  // example:
  // 
  // success
  Message *string `json:"message,omitempty" xml:"message,omitempty"`
  // The ID of the request. This parameter is a common parameter. Each request has a unique ID. You can use the ID to troubleshoot issues.
  // 
  // example:
  // 
  // E3619976-8714-5D88-BBA2-6983D798A8BB
  RequestId *string `json:"requestId,omitempty" xml:"requestId,omitempty"`
}

func (s ListConnectionsResponseBody) String() string {
  return tea.Prettify(s)
}

func (s ListConnectionsResponseBody) GoString() string {
  return s.String()
}

func (s *ListConnectionsResponseBody) SetCode(v string) *ListConnectionsResponseBody {
  s.Code = &v
  return s
}

func (s *ListConnectionsResponseBody) SetConnections(v []*ListConnectionsResponseBodyConnections) *ListConnectionsResponseBody {
  s.Connections = v
  return s
}

func (s *ListConnectionsResponseBody) SetMaxResults(v int32) *ListConnectionsResponseBody {
  s.MaxResults = &v
  return s
}

func (s *ListConnectionsResponseBody) SetNextToken(v string) *ListConnectionsResponseBody {
  s.NextToken = &v
  return s
}

func (s *ListConnectionsResponseBody) SetTotal(v int) *ListConnectionsResponseBody {
  s.Total = &v
  return s
}

func (s *ListConnectionsResponseBody) SetMessage(v string) *ListConnectionsResponseBody {
  s.Message = &v
  return s
}

func (s *ListConnectionsResponseBody) SetRequestId(v string) *ListConnectionsResponseBody {
  s.RequestId = &v
  return s
}

type ListConnectionsResponseBodyConnections struct     {
  // The parameters that are configured for authentication.
  AuthParameters *ListConnectionsResponseBodyConnectionsAuthParameters `json:"authParameters,omitempty" xml:"authParameters,omitempty" type:"Struct"`
  // The connection name.
  // 
  // example:
  // 
  // connection-name
  ConnectionName *string `json:"connectionName,omitempty" xml:"connectionName,omitempty"`
  // The connection description.
  // 
  // example:
  // 
  // The description of the connection.
  Description *string `json:"description,omitempty" xml:"description,omitempty"`
  // The time when the connection was created.
  // 
  // example:
  // 
  // 1592838994234
  GmtCreate *int64 `json:"gmtCreate,omitempty" xml:"gmtCreate,omitempty"`
  // The connection ID.
  // 
  // example:
  // 
  // 1141093
  Id *int `json:"id,omitempty" xml:"id,omitempty"`
  NetworkParameters *ListConnectionsResponseBodyConnectionsNetworkParameters `json:"networkParameters,omitempty" xml:"networkParameters,omitempty" type:"Struct"`
}

func (s ListConnectionsResponseBodyConnections) String() string {
  return tea.Prettify(s)
}

func (s ListConnectionsResponseBodyConnections) GoString() string {
  return s.String()
}

func (s *ListConnectionsResponseBodyConnections) SetAuthParameters(v *ListConnectionsResponseBodyConnectionsAuthParameters) *ListConnectionsResponseBodyConnections {
  s.AuthParameters = v
  return s
}

func (s *ListConnectionsResponseBodyConnections) SetConnectionName(v string) *ListConnectionsResponseBodyConnections {
  s.ConnectionName = &v
  return s
}

func (s *ListConnectionsResponseBodyConnections) SetDescription(v string) *ListConnectionsResponseBodyConnections {
  s.Description = &v
  return s
}

func (s *ListConnectionsResponseBodyConnections) SetGmtCreate(v int64) *ListConnectionsResponseBodyConnections {
  s.GmtCreate = &v
  return s
}

func (s *ListConnectionsResponseBodyConnections) SetId(v int) *ListConnectionsResponseBodyConnections {
  s.Id = &v
  return s
}

func (s *ListConnectionsResponseBodyConnections) SetNetworkParameters(v *ListConnectionsResponseBodyConnectionsNetworkParameters) *ListConnectionsResponseBodyConnections {
  s.NetworkParameters = v
  return s
}

type ListConnectionsResponseBodyConnectionsAuthParameters struct {
  // The parameters that are configured for API key authentication.
  ApiKeyAuthParameters *ListConnectionsResponseBodyConnectionsAuthParametersApiKeyAuthParameters `json:"apiKeyAuthParameters,omitempty" xml:"apiKeyAuthParameters,omitempty" type:"Struct"`
  // The authentication type. Valid values:
  // 
  // 
  //           - BASIC_AUTH: basic authentication.
  // 
  // 
  //           - API_KEY_AUTH: API key authentication.
  // 
  // 
  //           - OAUTH_AUTH: OAuth authentication.
  // 
  // example:
  // 
  // BASIC_AUTH
  AuthorizationType *string `json:"authorizationType,omitempty" xml:"authorizationType,omitempty"`
  // The parameters that are configured for basic authentication.
  BasicAuthParameters *ListConnectionsResponseBodyConnectionsAuthParametersBasicAuthParameters `json:"basicAuthParameters,omitempty" xml:"basicAuthParameters,omitempty" type:"Struct"`
  // The parameters that are configured for OAuth authentication.
  OauthParameters *ListConnectionsResponseBodyConnectionsAuthParametersOauthParameters `json:"oauthParameters,omitempty" xml:"oauthParameters,omitempty" type:"Struct"`
}

func (s ListConnectionsResponseBodyConnectionsAuthParameters) String() string {
  return tea.Prettify(s)
}

func (s ListConnectionsResponseBodyConnectionsAuthParameters) GoString() string {
  return s.String()
}

func (s *ListConnectionsResponseBodyConnectionsAuthParameters) SetApiKeyAuthParameters(v *ListConnectionsResponseBodyConnectionsAuthParametersApiKeyAuthParameters) *ListConnectionsResponseBodyConnectionsAuthParameters {
  s.ApiKeyAuthParameters = v
  return s
}

func (s *ListConnectionsResponseBodyConnectionsAuthParameters) SetAuthorizationType(v string) *ListConnectionsResponseBodyConnectionsAuthParameters {
  s.AuthorizationType = &v
  return s
}

func (s *ListConnectionsResponseBodyConnectionsAuthParameters) SetBasicAuthParameters(v *ListConnectionsResponseBodyConnectionsAuthParametersBasicAuthParameters) *ListConnectionsResponseBodyConnectionsAuthParameters {
  s.BasicAuthParameters = v
  return s
}

func (s *ListConnectionsResponseBodyConnectionsAuthParameters) SetOauthParameters(v *ListConnectionsResponseBodyConnectionsAuthParametersOauthParameters) *ListConnectionsResponseBodyConnectionsAuthParameters {
  s.OauthParameters = v
  return s
}

type ListConnectionsResponseBodyConnectionsAuthParametersApiKeyAuthParameters struct {
  // The API key.
  // 
  // example:
  // 
  // Token
  ApiKeyName *string `json:"apiKeyName,omitempty" xml:"apiKeyName,omitempty"`
  // The value of the API key.
  // 
  // example:
  // 
  // asdkjnqkwejooa
  ApiKeyValue *string `json:"apiKeyValue,omitempty" xml:"apiKeyValue,omitempty"`
}

func (s ListConnectionsResponseBodyConnectionsAuthParametersApiKeyAuthParameters) String() string {
  return tea.Prettify(s)
}

func (s ListConnectionsResponseBodyConnectionsAuthParametersApiKeyAuthParameters) GoString() string {
  return s.String()
}

func (s *ListConnectionsResponseBodyConnectionsAuthParametersApiKeyAuthParameters) SetApiKeyName(v string) *ListConnectionsResponseBodyConnectionsAuthParametersApiKeyAuthParameters {
  s.ApiKeyName = &v
  return s
}

func (s *ListConnectionsResponseBodyConnectionsAuthParametersApiKeyAuthParameters) SetApiKeyValue(v string) *ListConnectionsResponseBodyConnectionsAuthParametersApiKeyAuthParameters {
  s.ApiKeyValue = &v
  return s
}

type ListConnectionsResponseBodyConnectionsAuthParametersBasicAuthParameters struct {
  // The password for basic authentication.
  // 
  // example:
  // 
  // admin
  Password *string `json:"password,omitempty" xml:"password,omitempty"`
  // The username for basic authentication.
  // 
  // example:
  // 
  // admin
  Username *string `json:"username,omitempty" xml:"username,omitempty"`
}

func (s ListConnectionsResponseBodyConnectionsAuthParametersBasicAuthParameters) String() string {
  return tea.Prettify(s)
}

func (s ListConnectionsResponseBodyConnectionsAuthParametersBasicAuthParameters) GoString() string {
  return s.String()
}

func (s *ListConnectionsResponseBodyConnectionsAuthParametersBasicAuthParameters) SetPassword(v string) *ListConnectionsResponseBodyConnectionsAuthParametersBasicAuthParameters {
  s.Password = &v
  return s
}

func (s *ListConnectionsResponseBodyConnectionsAuthParametersBasicAuthParameters) SetUsername(v string) *ListConnectionsResponseBodyConnectionsAuthParametersBasicAuthParameters {
  s.Username = &v
  return s
}

type ListConnectionsResponseBodyConnectionsAuthParametersOauthParameters struct {
  // The endpoint that is used to obtain the OAuth token.
  // 
  // example:
  // 
  // http://localhost:8080/oauth/token
  AuthorizationEndpoint *string `json:"authorizationEndpoint,omitempty" xml:"authorizationEndpoint,omitempty"`
  // The parameters that are configured for the client.
  ClientParameters *ListConnectionsResponseBodyConnectionsAuthParametersOauthParametersClientParameters `json:"clientParameters,omitempty" xml:"clientParameters,omitempty" type:"Struct"`
  // The HTTP request method. Valid values:
  // 
  //             - GET
  // 
  //             - POST
  // 
  //             - HEAD
  // 
  // example:
  // 
  // POST
  HttpMethod *string `json:"httpMethod,omitempty" xml:"httpMethod,omitempty"`
  // The request parameters for OAuth authentication.
  OauthHttpParameters *ListConnectionsResponseBodyConnectionsAuthParametersOauthParametersOauthHttpParameters `json:"oauthHttpParameters,omitempty" xml:"oauthHttpParameters,omitempty" type:"Struct"`
}

func (s ListConnectionsResponseBodyConnectionsAuthParametersOauthParameters) String() string {
  return tea.Prettify(s)
}

func (s ListConnectionsResponseBodyConnectionsAuthParametersOauthParameters) GoString() string {
  return s.String()
}

func (s *ListConnectionsResponseBodyConnectionsAuthParametersOauthParameters) SetAuthorizationEndpoint(v string) *ListConnectionsResponseBodyConnectionsAuthParametersOauthParameters {
  s.AuthorizationEndpoint = &v
  return s
}

func (s *ListConnectionsResponseBodyConnectionsAuthParametersOauthParameters) SetClientParameters(v *ListConnectionsResponseBodyConnectionsAuthParametersOauthParametersClientParameters) *ListConnectionsResponseBodyConnectionsAuthParametersOauthParameters {
  s.ClientParameters = v
  return s
}

func (s *ListConnectionsResponseBodyConnectionsAuthParametersOauthParameters) SetHttpMethod(v string) *ListConnectionsResponseBodyConnectionsAuthParametersOauthParameters {
  s.HttpMethod = &v
  return s
}

func (s *ListConnectionsResponseBodyConnectionsAuthParametersOauthParameters) SetOauthHttpParameters(v *ListConnectionsResponseBodyConnectionsAuthParametersOauthParametersOauthHttpParameters) *ListConnectionsResponseBodyConnectionsAuthParametersOauthParameters {
  s.OauthHttpParameters = v
  return s
}

type ListConnectionsResponseBodyConnectionsAuthParametersOauthParametersClientParameters struct {
  // The client ID.
  // 
  // example:
  // 
  // ClientID
  ClientID *string `json:"clientID,omitempty" xml:"clientID,omitempty"`
  // The client key secret of the application.
  // 
  // example:
  // 
  // ClientSecret
  ClientSecret *string `json:"clientSecret,omitempty" xml:"clientSecret,omitempty"`
}

func (s ListConnectionsResponseBodyConnectionsAuthParametersOauthParametersClientParameters) String() string {
  return tea.Prettify(s)
}

func (s ListConnectionsResponseBodyConnectionsAuthParametersOauthParametersClientParameters) GoString() string {
  return s.String()
}

func (s *ListConnectionsResponseBodyConnectionsAuthParametersOauthParametersClientParameters) SetClientID(v string) *ListConnectionsResponseBodyConnectionsAuthParametersOauthParametersClientParameters {
  s.ClientID = &v
  return s
}

func (s *ListConnectionsResponseBodyConnectionsAuthParametersOauthParametersClientParameters) SetClientSecret(v string) *ListConnectionsResponseBodyConnectionsAuthParametersOauthParametersClientParameters {
  s.ClientSecret = &v
  return s
}

type ListConnectionsResponseBodyConnectionsAuthParametersOauthParametersOauthHttpParameters struct {
  // The parameters that are configured for the request.
  BodyParameters []*ListConnectionsResponseBodyConnectionsAuthParametersOauthParametersOauthHttpParametersBodyParameters `json:"bodyParameters,omitempty" xml:"bodyParameters,omitempty" type:"Repeated"`
  // The parameters that are configured for the request header.
  HeaderParameters []*ListConnectionsResponseBodyConnectionsAuthParametersOauthParametersOauthHttpParametersHeaderParameters `json:"headerParameters,omitempty" xml:"headerParameters,omitempty" type:"Repeated"`
  // The parameters that are configured for the request path.
  QueryStringParameters []*ListConnectionsResponseBodyConnectionsAuthParametersOauthParametersOauthHttpParametersQueryStringParameters `json:"queryStringParameters,omitempty" xml:"queryStringParameters,omitempty" type:"Repeated"`
}

func (s ListConnectionsResponseBodyConnectionsAuthParametersOauthParametersOauthHttpParameters) String() string {
  return tea.Prettify(s)
}

func (s ListConnectionsResponseBodyConnectionsAuthParametersOauthParametersOauthHttpParameters) GoString() string {
  return s.String()
}

func (s *ListConnectionsResponseBodyConnectionsAuthParametersOauthParametersOauthHttpParameters) SetBodyParameters(v []*ListConnectionsResponseBodyConnectionsAuthParametersOauthParametersOauthHttpParametersBodyParameters) *ListConnectionsResponseBodyConnectionsAuthParametersOauthParametersOauthHttpParameters {
  s.BodyParameters = v
  return s
}

func (s *ListConnectionsResponseBodyConnectionsAuthParametersOauthParametersOauthHttpParameters) SetHeaderParameters(v []*ListConnectionsResponseBodyConnectionsAuthParametersOauthParametersOauthHttpParametersHeaderParameters) *ListConnectionsResponseBodyConnectionsAuthParametersOauthParametersOauthHttpParameters {
  s.HeaderParameters = v
  return s
}

func (s *ListConnectionsResponseBodyConnectionsAuthParametersOauthParametersOauthHttpParameters) SetQueryStringParameters(v []*ListConnectionsResponseBodyConnectionsAuthParametersOauthParametersOauthHttpParametersQueryStringParameters) *ListConnectionsResponseBodyConnectionsAuthParametersOauthParametersOauthHttpParameters {
  s.QueryStringParameters = v
  return s
}

type ListConnectionsResponseBodyConnectionsAuthParametersOauthParametersOauthHttpParametersBodyParameters struct     {
  // Indicates whether authentication is enabled.
  // 
  // example:
  // 
  // false
  IsValueSecret *string `json:"isValueSecret,omitempty" xml:"isValueSecret,omitempty"`
  // The key in the request body.
  // 
  // example:
  // 
  // name
  Key *string `json:"key,omitempty" xml:"key,omitempty"`
  // The value of the key in the request body.
  // 
  // example:
  // 
  // demo
  Value *string `json:"value,omitempty" xml:"value,omitempty"`
}

func (s ListConnectionsResponseBodyConnectionsAuthParametersOauthParametersOauthHttpParametersBodyParameters) String() string {
  return tea.Prettify(s)
}

func (s ListConnectionsResponseBodyConnectionsAuthParametersOauthParametersOauthHttpParametersBodyParameters) GoString() string {
  return s.String()
}

func (s *ListConnectionsResponseBodyConnectionsAuthParametersOauthParametersOauthHttpParametersBodyParameters) SetIsValueSecret(v string) *ListConnectionsResponseBodyConnectionsAuthParametersOauthParametersOauthHttpParametersBodyParameters {
  s.IsValueSecret = &v
  return s
}

func (s *ListConnectionsResponseBodyConnectionsAuthParametersOauthParametersOauthHttpParametersBodyParameters) SetKey(v string) *ListConnectionsResponseBodyConnectionsAuthParametersOauthParametersOauthHttpParametersBodyParameters {
  s.Key = &v
  return s
}

func (s *ListConnectionsResponseBodyConnectionsAuthParametersOauthParametersOauthHttpParametersBodyParameters) SetValue(v string) *ListConnectionsResponseBodyConnectionsAuthParametersOauthParametersOauthHttpParametersBodyParameters {
  s.Value = &v
  return s
}

type ListConnectionsResponseBodyConnectionsAuthParametersOauthParametersOauthHttpParametersHeaderParameters struct     {
  // Indicates whether authentication is enabled.
  // 
  // example:
  // 
  // false
  IsValueSecret *string `json:"isValueSecret,omitempty" xml:"isValueSecret,omitempty"`
  // The key in the request header.
  // 
  // example:
  // 
  // name
  Key *string `json:"key,omitempty" xml:"key,omitempty"`
  // The value of the key in the request header.
  // 
  // example:
  // 
  // demo
  Value *string `json:"value,omitempty" xml:"value,omitempty"`
}

func (s ListConnectionsResponseBodyConnectionsAuthParametersOauthParametersOauthHttpParametersHeaderParameters) String() string {
  return tea.Prettify(s)
}

func (s ListConnectionsResponseBodyConnectionsAuthParametersOauthParametersOauthHttpParametersHeaderParameters) GoString() string {
  return s.String()
}

func (s *ListConnectionsResponseBodyConnectionsAuthParametersOauthParametersOauthHttpParametersHeaderParameters) SetIsValueSecret(v string) *ListConnectionsResponseBodyConnectionsAuthParametersOauthParametersOauthHttpParametersHeaderParameters {
  s.IsValueSecret = &v
  return s
}

func (s *ListConnectionsResponseBodyConnectionsAuthParametersOauthParametersOauthHttpParametersHeaderParameters) SetKey(v string) *ListConnectionsResponseBodyConnectionsAuthParametersOauthParametersOauthHttpParametersHeaderParameters {
  s.Key = &v
  return s
}

func (s *ListConnectionsResponseBodyConnectionsAuthParametersOauthParametersOauthHttpParametersHeaderParameters) SetValue(v string) *ListConnectionsResponseBodyConnectionsAuthParametersOauthParametersOauthHttpParametersHeaderParameters {
  s.Value = &v
  return s
}

type ListConnectionsResponseBodyConnectionsAuthParametersOauthParametersOauthHttpParametersQueryStringParameters struct     {
  // Indicates whether authentication is enabled.
  // 
  // example:
  // 
  // false
  IsValueSecret *string `json:"isValueSecret,omitempty" xml:"isValueSecret,omitempty"`
  // The key in the request path.
  // 
  // example:
  // 
  // name
  Key *string `json:"key,omitempty" xml:"key,omitempty"`
  // The value of the key in the request path.
  // 
  // example:
  // 
  // demo
  Value *string `json:"value,omitempty" xml:"value,omitempty"`
}

func (s ListConnectionsResponseBodyConnectionsAuthParametersOauthParametersOauthHttpParametersQueryStringParameters) String() string {
  return tea.Prettify(s)
}

func (s ListConnectionsResponseBodyConnectionsAuthParametersOauthParametersOauthHttpParametersQueryStringParameters) GoString() string {
  return s.String()
}

func (s *ListConnectionsResponseBodyConnectionsAuthParametersOauthParametersOauthHttpParametersQueryStringParameters) SetIsValueSecret(v string) *ListConnectionsResponseBodyConnectionsAuthParametersOauthParametersOauthHttpParametersQueryStringParameters {
  s.IsValueSecret = &v
  return s
}

func (s *ListConnectionsResponseBodyConnectionsAuthParametersOauthParametersOauthHttpParametersQueryStringParameters) SetKey(v string) *ListConnectionsResponseBodyConnectionsAuthParametersOauthParametersOauthHttpParametersQueryStringParameters {
  s.Key = &v
  return s
}

func (s *ListConnectionsResponseBodyConnectionsAuthParametersOauthParametersOauthHttpParametersQueryStringParameters) SetValue(v string) *ListConnectionsResponseBodyConnectionsAuthParametersOauthParametersOauthHttpParametersQueryStringParameters {
  s.Value = &v
  return s
}

type ListConnectionsResponseBodyConnectionsNetworkParameters struct {
  // The network type. Valid values:PublicNetwork and PrivateNetwork.
  // 
  // example:
  // 
  // PublicNetwork
  NetworkType *string `json:"networkType,omitempty" xml:"networkType,omitempty"`
  // The security group ID.
  // 
  // example:
  // 
  // eb-167adad548759-security_grop/sg-bp1addad26peuh9qh9rtyb
  SecurityGroupId *string `json:"securityGroupId,omitempty" xml:"securityGroupId,omitempty"`
  // The virtual private cloud (VPC) ID.
  // 
  // example:
  // 
  // eb-test/vpc-bp1symadadwnwgmqud
  VpcId *string `json:"vpcId,omitempty" xml:"vpcId,omitempty"`
  // The vSwitch ID.
  // 
  // example:
  // 
  // vsw-bp1iu4x7aeradadown1og8,vsw-bp193sqmadadlaszpeqbt2c
  VswitcheId *string `json:"vswitcheId,omitempty" xml:"vswitcheId,omitempty"`
}

func (s ListConnectionsResponseBodyConnectionsNetworkParameters) String() string {
  return tea.Prettify(s)
}

func (s ListConnectionsResponseBodyConnectionsNetworkParameters) GoString() string {
  return s.String()
}

func (s *ListConnectionsResponseBodyConnectionsNetworkParameters) SetNetworkType(v string) *ListConnectionsResponseBodyConnectionsNetworkParameters {
  s.NetworkType = &v
  return s
}

func (s *ListConnectionsResponseBodyConnectionsNetworkParameters) SetSecurityGroupId(v string) *ListConnectionsResponseBodyConnectionsNetworkParameters {
  s.SecurityGroupId = &v
  return s
}

func (s *ListConnectionsResponseBodyConnectionsNetworkParameters) SetVpcId(v string) *ListConnectionsResponseBodyConnectionsNetworkParameters {
  s.VpcId = &v
  return s
}

func (s *ListConnectionsResponseBodyConnectionsNetworkParameters) SetVswitcheId(v string) *ListConnectionsResponseBodyConnectionsNetworkParameters {
  s.VswitcheId = &v
  return s
}

type ListConnectionsResponse struct {
  Headers map[string]*string `json:"headers,omitempty" xml:"headers,omitempty"`
  StatusCode *int32 `json:"statusCode,omitempty" xml:"statusCode,omitempty"`
  Body *ListConnectionsResponseBody `json:"body,omitempty" xml:"body,omitempty"`
}

func (s ListConnectionsResponse) String() string {
  return tea.Prettify(s)
}

func (s ListConnectionsResponse) GoString() string {
  return s.String()
}

func (s *ListConnectionsResponse) SetHeaders(v map[string]*string) *ListConnectionsResponse {
  s.Headers = v
  return s
}

func (s *ListConnectionsResponse) SetStatusCode(v int32) *ListConnectionsResponse {
  s.StatusCode = &v
  return s
}

func (s *ListConnectionsResponse) SetBody(v *ListConnectionsResponseBody) *ListConnectionsResponse {
  s.Body = v
  return s
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
type ListEnumsResponseResponseBody struct {
  AuthorizationTypeEnums *string `json:"authorizationTypeEnums,omitempty" xml:"authorizationTypeEnums,omitempty"`
  NetworkTypeEnums *string `json:"networkTypeEnums,omitempty" xml:"networkTypeEnums,omitempty"`
  // The returned response code.
  // 
  // example:
  // 
  // Success
  Code *string `json:"code,omitempty" xml:"code,omitempty"`
  // The returned message.
  // 
  // example:
  // 
  // success
  Message *string `json:"message,omitempty" xml:"message,omitempty"`
  // The request ID.
  // 
  // example:
  // 
  // 8346BE8F-40F3-533D-A0B8-1359C31BD5BA
  RequestId *string `json:"requestId,omitempty" xml:"requestId,omitempty"`
}

func (s ListEnumsResponseResponseBody) String() string {
  return tea.Prettify(s)
}

func (s ListEnumsResponseResponseBody) GoString() string {
  return s.String()
}

func (s *ListEnumsResponseResponseBody) SetAuthorizationTypeEnums(v string) *ListEnumsResponseResponseBody {
  s.AuthorizationTypeEnums = &v
  return s
}

func (s *ListEnumsResponseResponseBody) SetNetworkTypeEnums(v string) *ListEnumsResponseResponseBody {
  s.NetworkTypeEnums = &v
  return s
}

func (s *ListEnumsResponseResponseBody) SetCode(v string) *ListEnumsResponseResponseBody {
  s.Code = &v
  return s
}

func (s *ListEnumsResponseResponseBody) SetMessage(v string) *ListEnumsResponseResponseBody {
  s.Message = &v
  return s
}

func (s *ListEnumsResponseResponseBody) SetRequestId(v string) *ListEnumsResponseResponseBody {
  s.RequestId = &v
  return s
}

type ListEnumsResponseResponse struct {
  Headers map[string]*string `json:"headers,omitempty" xml:"headers,omitempty"`
  StatusCode *int32 `json:"statusCode,omitempty" xml:"statusCode,omitempty"`
  Body *UpdateConnectionResponseBody `json:"body,omitempty" xml:"body,omitempty"`
}

func (s ListEnumsResponseResponse) String() string {
  return tea.Prettify(s)
}

func (s ListEnumsResponseResponse) GoString() string {
  return s.String()
}

func (s *ListEnumsResponseResponse) SetHeaders(v map[string]*string) *ListEnumsResponseResponse {
  s.Headers = v
  return s
}

func (s *ListEnumsResponseResponse) SetStatusCode(v int32) *ListEnumsResponseResponse {
  s.StatusCode = &v
  return s
}

func (s *ListEnumsResponseResponse) SetBody(v *UpdateConnectionResponseBody) *ListEnumsResponseResponse {
  s.Body = v
  return s
}

// Description:
// 
// EventData Controller apis:
// 
// putEvents
type PutEventsRequest struct {
  // The name of the event bus.
  // 
  // This parameter is required.
  // 
  // example:
  // 
  // demo
  EventBusName *string `json:"eventBusName,omitempty" xml:"eventBusName,omitempty"`
  // The content of the event.
  // 
  // example:
  // 
  // The description of the event.
  Event *string `json:"event,omitempty" xml:"event,omitempty"`
}

func (s PutEventsRequest) String() string {
  return tea.Prettify(s)
}

func (s PutEventsRequest) GoString() string {
  return s.String()
}

func (s *PutEventsRequest) SetEventBusName(v string) *PutEventsRequest {
  s.EventBusName = &v
  return s
}

func (s *PutEventsRequest) SetEvent(v string) *PutEventsRequest {
  s.Event = &v
  return s
}

type PutEventsResponseBody struct {
  FailedEntryCount *int `json:"failedEntryCount,omitempty" xml:"failedEntryCount,omitempty"`
  EntryList []*PutEventsResponseBodyEntryList `json:"entryList,omitempty" xml:"entryList,omitempty" type:"Repeated"`
  // The status code returned. The status code 200 indicates that the request was successful.
  // 
  // example:
  // 
  // 200
  Code *string `json:"code,omitempty" xml:"code,omitempty"`
  // The error message that is returned if the request failed.
  // 
  // example:
  // 
  // EventBusNotExist
  Message *string `json:"message,omitempty" xml:"message,omitempty"`
  // The request ID.
  // 
  // example:
  // 
  // 580A938B-6107-586C-8EC7-F22EEBEDA9E6
  RequestId *string `json:"requestId,omitempty" xml:"requestId,omitempty"`
}

func (s PutEventsResponseBody) String() string {
  return tea.Prettify(s)
}

func (s PutEventsResponseBody) GoString() string {
  return s.String()
}

func (s *PutEventsResponseBody) SetFailedEntryCount(v int) *PutEventsResponseBody {
  s.FailedEntryCount = &v
  return s
}

func (s *PutEventsResponseBody) SetEntryList(v []*PutEventsResponseBodyEntryList) *PutEventsResponseBody {
  s.EntryList = v
  return s
}

func (s *PutEventsResponseBody) SetCode(v string) *PutEventsResponseBody {
  s.Code = &v
  return s
}

func (s *PutEventsResponseBody) SetMessage(v string) *PutEventsResponseBody {
  s.Message = &v
  return s
}

func (s *PutEventsResponseBody) SetRequestId(v string) *PutEventsResponseBody {
  s.RequestId = &v
  return s
}

type PutEventsResponseBodyEntryList struct     {
  // The event ID.
  // 
  // example:
  // 
  // a5747e4f-2af2-40b6-b262-d0140e995bf7
  EventId *string `json:"eventId,omitempty" xml:"eventId,omitempty"`
  // The returned error code.
  ErrorCode *string `json:"errorCode,omitempty" xml:"errorCode,omitempty"`
  // The returned error message.
  ErrorMessage *string `json:"errorMessage,omitempty" xml:"errorMessage,omitempty"`
}

func (s PutEventsResponseBodyEntryList) String() string {
  return tea.Prettify(s)
}

func (s PutEventsResponseBodyEntryList) GoString() string {
  return s.String()
}

func (s *PutEventsResponseBodyEntryList) SetEventId(v string) *PutEventsResponseBodyEntryList {
  s.EventId = &v
  return s
}

func (s *PutEventsResponseBodyEntryList) SetErrorCode(v string) *PutEventsResponseBodyEntryList {
  s.ErrorCode = &v
  return s
}

func (s *PutEventsResponseBodyEntryList) SetErrorMessage(v string) *PutEventsResponseBodyEntryList {
  s.ErrorMessage = &v
  return s
}

type PutEventsResponse struct {
  Headers map[string]*string `json:"headers,omitempty" xml:"headers,omitempty"`
  StatusCode *int32 `json:"statusCode,omitempty" xml:"statusCode,omitempty"`
  Body *PutEventsResponseBody `json:"body,omitempty" xml:"body,omitempty"`
}

func (s PutEventsResponse) String() string {
  return tea.Prettify(s)
}

func (s PutEventsResponse) GoString() string {
  return s.String()
}

func (s *PutEventsResponse) SetHeaders(v map[string]*string) *PutEventsResponse {
  s.Headers = v
  return s
}

func (s *PutEventsResponse) SetStatusCode(v int32) *PutEventsResponse {
  s.StatusCode = &v
  return s
}

func (s *PutEventsResponse) SetBody(v *PutEventsResponseBody) *PutEventsResponse {
  s.Body = v
  return s
}

// Description:
// 
// EventRule Controller apis:
// 
// createEventRule  *
// 
// getEventRule     *
// 
// deleteEventRule  *
// 
// updateEventRule  *
// 
// listEventRules   *
// 
// enableEventRule  *
// 
// disableEventRule *
type CreateEventRuleRequest struct {
  // The name of the event bus with which the event source is associated.
  // 
  // This parameter is required.
  // 
  // example:
  // 
  // my-event-bus
  EventBusName *string `json:"eventBusName,omitempty" xml:"eventBusName,omitempty"`
  // The name of the event rule.
  // 
  // This parameter is required.
  // 
  // example:
  // 
  // myrabbitmq.sourc
  EventRuleName *string `json:"eventRuleName,omitempty" xml:"eventRuleName,omitempty"`
  Description *string `json:"description,omitempty" xml:"description,omitempty"`
  // The event pattern, in JSON format. Valid values: stringEqual and stringExpression. You can specify up to five expressions in the map data structure in each field.
  // 
  //     You can specify up to five expressions in the map data structure in each field.
  // 
  // example:
  // 
  // {\"source\": [{\"prefix\": \"acs.\"}],\"type\": [{\"prefix\":\"oss:ObjectReplication\"}],\"subject\":[{\"prefix\":\"acs:oss:cn-hangzhou:123456789098****:my-movie-bucket/\", \"suffix\":\".txt\"}]}
  FilterPattern *string `json:"filterPattern,omitempty" xml:"filterPattern,omitempty"`
}

func (s CreateEventRuleRequest) String() string {
  return tea.Prettify(s)
}

func (s CreateEventRuleRequest) GoString() string {
  return s.String()
}

func (s *CreateEventRuleRequest) SetEventBusName(v string) *CreateEventRuleRequest {
  s.EventBusName = &v
  return s
}

func (s *CreateEventRuleRequest) SetEventRuleName(v string) *CreateEventRuleRequest {
  s.EventRuleName = &v
  return s
}

func (s *CreateEventRuleRequest) SetDescription(v string) *CreateEventRuleRequest {
  s.Description = &v
  return s
}

func (s *CreateEventRuleRequest) SetFilterPattern(v string) *CreateEventRuleRequest {
  s.FilterPattern = &v
  return s
}

type CreateEventRuleResponseBody struct {
  // The returned response code. Valid values:
  // 
  //     	- Success: The request is successful.
  // 
  //     	- Other codes: The request failed. For more information about error codes, see Error codes.
  // 
  // example:
  // 
  // Success
  Code *string `json:"code,omitempty" xml:"code,omitempty"`
  // The name of the event rule.
  // 
  // example:
  // 
  // myrabbitmq.sourc
  EventRuleName *string `json:"eventRuleName,omitempty" xml:"eventRuleName,omitempty"`
  // The returned error message.
  // 
  // example:
  // 
  // Remote error. requestId: [A8EFABD2-95B9-1C46-9E01-xxxx], error code: [CreateRelatedResourceFailed], message: [Create related resource failed, EntityNotExist.Role : The role not exists: xxxx. \\r\\nRequestId : xxxx-168C-54ED-8FEB-BF11CB70AEB7]
  Message *string `json:"message,omitempty" xml:"message,omitempty"`
  // The request ID.
  // 
  // example:
  // 
  // 2922208e-e1c6-43ee-bfd1-aca50263bc8a
  RequestId *string `json:"requestId,omitempty" xml:"requestId,omitempty"`
}

func (s CreateEventRuleResponseBody) String() string {
  return tea.Prettify(s)
}

func (s CreateEventRuleResponseBody) GoString() string {
  return s.String()
}

func (s *CreateEventRuleResponseBody) SetCode(v string) *CreateEventRuleResponseBody {
  s.Code = &v
  return s
}

func (s *CreateEventRuleResponseBody) SetEventRuleName(v string) *CreateEventRuleResponseBody {
  s.EventRuleName = &v
  return s
}

func (s *CreateEventRuleResponseBody) SetMessage(v string) *CreateEventRuleResponseBody {
  s.Message = &v
  return s
}

func (s *CreateEventRuleResponseBody) SetRequestId(v string) *CreateEventRuleResponseBody {
  s.RequestId = &v
  return s
}

type CreateEventRuleResponse struct {
  Headers map[string]*string `json:"headers,omitempty" xml:"headers,omitempty"`
  StatusCode *int32 `json:"statusCode,omitempty" xml:"statusCode,omitempty"`
  Body *CreateEventRuleResponseBody `json:"body,omitempty" xml:"body,omitempty"`
}

func (s CreateEventRuleResponse) String() string {
  return tea.Prettify(s)
}

func (s CreateEventRuleResponse) GoString() string {
  return s.String()
}

func (s *CreateEventRuleResponse) SetHeaders(v map[string]*string) *CreateEventRuleResponse {
  s.Headers = v
  return s
}

func (s *CreateEventRuleResponse) SetStatusCode(v int32) *CreateEventRuleResponse {
  s.StatusCode = &v
  return s
}

func (s *CreateEventRuleResponse) SetBody(v *CreateEventRuleResponseBody) *CreateEventRuleResponse {
  s.Body = v
  return s
}

type GetEventRuleRequest struct {
  // The name of the event bus with which the event source is associated.
  // 
  // This parameter is required.
  // 
  // example:
  // 
  // my-event-bus
  EventBusName *string `json:"eventBusName,omitempty" xml:"eventBusName,omitempty"`
  // The name of the event rule.
  // 
  // This parameter is required.
  // 
  // example:
  // 
  // myrabbitmq.sourc
  EventRuleName *string `json:"eventRuleName,omitempty" xml:"eventRuleName,omitempty"`
}

func (s GetEventRuleRequest) String() string {
  return tea.Prettify(s)
}

func (s GetEventRuleRequest) GoString() string {
  return s.String()
}

func (s *GetEventRuleRequest) SetEventBusName(v string) *GetEventRuleRequest {
  s.EventBusName = &v
  return s
}

func (s *GetEventRuleRequest) SetEventRuleName(v string) *GetEventRuleRequest {
  s.EventRuleName = &v
  return s
}

type GetEventRuleResponseBody struct {
  // The returned response code. Valid values:
  // 
  //     	- Success: The request is successful.
  // 
  //     	- Other codes: The request failed. For more information about error codes, see Error codes.
  // 
  // example:
  // 
  // Success
  Code *string `json:"code,omitempty" xml:"code,omitempty"`
  // The name of the event bus with which the event source is associated.
  // 
  // This parameter is required.
  // 
  // example:
  // 
  // my-event-bus
  EventBusName *string `json:"eventBusName,omitempty" xml:"eventBusName,omitempty"`
  // The name of the event rule.
  // 
  // This parameter is required.
  // 
  // example:
  // 
  // myrabbitmq.sourc
  EventRuleName *string `json:"eventRuleName,omitempty" xml:"eventRuleName,omitempty"`
  Description *string `json:"description,omitempty" xml:"description,omitempty"`
  // The event pattern, in JSON format. Valid values: stringEqual and stringExpression. You can specify up to five expressions in the map data structure in each field.
  // 
  //     You can specify up to five expressions in the map data structure in each field.
  // 
  // example:
  // 
  // {\"source\": [{\"prefix\": \"acs.\"}],\"type\": [{\"prefix\":\"oss:ObjectReplication\"}],\"subject\":[{\"prefix\":\"acs:oss:cn-hangzhou:123456789098****:my-movie-bucket/\", \"suffix\":\".txt\"}]}
  FilterPattern *string `json:"filterPattern,omitempty" xml:"filterPattern,omitempty"`
  // The status of the event rule. Valid values: ENABLE (default): The event rule is enabled. DISABLE: The event rule is disabled.
  // 
  // example:
  // 
  // ENABLE
  Status *string `json:"status,omitempty" xml:"status,omitempty"`
  GmtCreate *string `json:"gmtCreate,omitempty" xml:"gmtCreate,omitempty"`
  GmtModify *string `json:"gmtModify,omitempty" xml:"gmtModify,omitempty"`
  EventTargets []*GetEventRuleResponseBodyEventTargets `json:"eventTargets,omitempty" xml:"eventTargets,omitempty" type:"Repeated"`
  // The returned error message.
  // 
  // example:
  // 
  // Remote error. requestId: [A8EFABD2-95B9-1C46-9E01-xxxx], error code: [CreateRelatedResourceFailed], message: [Create related resource failed, EntityNotExist.Role : The role not exists: xxxx. \\r\\nRequestId : xxxx-168C-54ED-8FEB-BF11CB70AEB7]
  Message *string `json:"message,omitempty" xml:"message,omitempty"`
  // The request ID.
  // 
  // example:
  // 
  // 2922208e-e1c6-43ee-bfd1-aca50263bc8a
  RequestId *string `json:"requestId,omitempty" xml:"requestId,omitempty"`
}

func (s GetEventRuleResponseBody) String() string {
  return tea.Prettify(s)
}

func (s GetEventRuleResponseBody) GoString() string {
  return s.String()
}

func (s *GetEventRuleResponseBody) SetCode(v string) *GetEventRuleResponseBody {
  s.Code = &v
  return s
}

func (s *GetEventRuleResponseBody) SetEventBusName(v string) *GetEventRuleResponseBody {
  s.EventBusName = &v
  return s
}

func (s *GetEventRuleResponseBody) SetEventRuleName(v string) *GetEventRuleResponseBody {
  s.EventRuleName = &v
  return s
}

func (s *GetEventRuleResponseBody) SetDescription(v string) *GetEventRuleResponseBody {
  s.Description = &v
  return s
}

func (s *GetEventRuleResponseBody) SetFilterPattern(v string) *GetEventRuleResponseBody {
  s.FilterPattern = &v
  return s
}

func (s *GetEventRuleResponseBody) SetStatus(v string) *GetEventRuleResponseBody {
  s.Status = &v
  return s
}

func (s *GetEventRuleResponseBody) SetGmtCreate(v string) *GetEventRuleResponseBody {
  s.GmtCreate = &v
  return s
}

func (s *GetEventRuleResponseBody) SetGmtModify(v string) *GetEventRuleResponseBody {
  s.GmtModify = &v
  return s
}

func (s *GetEventRuleResponseBody) SetEventTargets(v []*GetEventRuleResponseBodyEventTargets) *GetEventRuleResponseBody {
  s.EventTargets = v
  return s
}

func (s *GetEventRuleResponseBody) SetMessage(v string) *GetEventRuleResponseBody {
  s.Message = &v
  return s
}

func (s *GetEventRuleResponseBody) SetRequestId(v string) *GetEventRuleResponseBody {
  s.RequestId = &v
  return s
}

type GetEventRuleResponseBodyEventTargets struct     {
  EventTargetName *string `json:"eventTargetName,omitempty" xml:"eventTargetName,omitempty"`
  ClassName *string `json:"className,omitempty" xml:"className,omitempty"`
  Config map[string]interface{} `json:"config,omitempty" xml:"config,omitempty"`
  RunOptions *GetEventRuleResponseBodyEventTargetsRunOptions `json:"runOptions,omitempty" xml:"runOptions,omitempty" type:"Struct"`
}

func (s GetEventRuleResponseBodyEventTargets) String() string {
  return tea.Prettify(s)
}

func (s GetEventRuleResponseBodyEventTargets) GoString() string {
  return s.String()
}

func (s *GetEventRuleResponseBodyEventTargets) SetEventTargetName(v string) *GetEventRuleResponseBodyEventTargets {
  s.EventTargetName = &v
  return s
}

func (s *GetEventRuleResponseBodyEventTargets) SetClassName(v string) *GetEventRuleResponseBodyEventTargets {
  s.ClassName = &v
  return s
}

func (s *GetEventRuleResponseBodyEventTargets) SetConfig(v map[string]interface{}) *GetEventRuleResponseBodyEventTargets {
  s.Config = v
  return s
}

func (s *GetEventRuleResponseBodyEventTargets) SetRunOptions(v *GetEventRuleResponseBodyEventTargetsRunOptions) *GetEventRuleResponseBodyEventTargets {
  s.RunOptions = v
  return s
}

type GetEventRuleResponseBodyEventTargetsRunOptions struct {
  ErrorsTolerance *string `json:"errorsTolerance,omitempty" xml:"errorsTolerance,omitempty"`
  RetryStrategy *GetEventRuleResponseBodyEventTargetsRunOptionsRetryStrategy `json:"retryStrategy,omitempty" xml:"retryStrategy,omitempty" type:"Struct"`
  DeadLetterQueue *GetEventRuleResponseBodyEventTargetsRunOptionsDeadLetterQueue `json:"deadLetterQueue,omitempty" xml:"deadLetterQueue,omitempty" type:"Struct"`
}

func (s GetEventRuleResponseBodyEventTargetsRunOptions) String() string {
  return tea.Prettify(s)
}

func (s GetEventRuleResponseBodyEventTargetsRunOptions) GoString() string {
  return s.String()
}

func (s *GetEventRuleResponseBodyEventTargetsRunOptions) SetErrorsTolerance(v string) *GetEventRuleResponseBodyEventTargetsRunOptions {
  s.ErrorsTolerance = &v
  return s
}

func (s *GetEventRuleResponseBodyEventTargetsRunOptions) SetRetryStrategy(v *GetEventRuleResponseBodyEventTargetsRunOptionsRetryStrategy) *GetEventRuleResponseBodyEventTargetsRunOptions {
  s.RetryStrategy = v
  return s
}

func (s *GetEventRuleResponseBodyEventTargetsRunOptions) SetDeadLetterQueue(v *GetEventRuleResponseBodyEventTargetsRunOptionsDeadLetterQueue) *GetEventRuleResponseBodyEventTargetsRunOptions {
  s.DeadLetterQueue = v
  return s
}

type GetEventRuleResponseBodyEventTargetsRunOptionsRetryStrategy struct {
  PushRetryStrategy *string `json:"pushRetryStrategy,omitempty" xml:"pushRetryStrategy,omitempty"`
  MaximumEventAgeInSeconds *int32 `json:"maximumEventAgeInSeconds,omitempty" xml:"maximumEventAgeInSeconds,omitempty"`
  MaximumRetryAttempts *int32 `json:"maximumRetryAttempts,omitempty" xml:"maximumRetryAttempts,omitempty"`
}

func (s GetEventRuleResponseBodyEventTargetsRunOptionsRetryStrategy) String() string {
  return tea.Prettify(s)
}

func (s GetEventRuleResponseBodyEventTargetsRunOptionsRetryStrategy) GoString() string {
  return s.String()
}

func (s *GetEventRuleResponseBodyEventTargetsRunOptionsRetryStrategy) SetPushRetryStrategy(v string) *GetEventRuleResponseBodyEventTargetsRunOptionsRetryStrategy {
  s.PushRetryStrategy = &v
  return s
}

func (s *GetEventRuleResponseBodyEventTargetsRunOptionsRetryStrategy) SetMaximumEventAgeInSeconds(v int32) *GetEventRuleResponseBodyEventTargetsRunOptionsRetryStrategy {
  s.MaximumEventAgeInSeconds = &v
  return s
}

func (s *GetEventRuleResponseBodyEventTargetsRunOptionsRetryStrategy) SetMaximumRetryAttempts(v int32) *GetEventRuleResponseBodyEventTargetsRunOptionsRetryStrategy {
  s.MaximumRetryAttempts = &v
  return s
}

type GetEventRuleResponseBodyEventTargetsRunOptionsDeadLetterQueue struct {
  Type *string `json:"type,omitempty" xml:"type,omitempty"`
  Config map[string]interface{} `json:"config,omitempty" xml:"config,omitempty"`
}

func (s GetEventRuleResponseBodyEventTargetsRunOptionsDeadLetterQueue) String() string {
  return tea.Prettify(s)
}

func (s GetEventRuleResponseBodyEventTargetsRunOptionsDeadLetterQueue) GoString() string {
  return s.String()
}

func (s *GetEventRuleResponseBodyEventTargetsRunOptionsDeadLetterQueue) SetType(v string) *GetEventRuleResponseBodyEventTargetsRunOptionsDeadLetterQueue {
  s.Type = &v
  return s
}

func (s *GetEventRuleResponseBodyEventTargetsRunOptionsDeadLetterQueue) SetConfig(v map[string]interface{}) *GetEventRuleResponseBodyEventTargetsRunOptionsDeadLetterQueue {
  s.Config = v
  return s
}

type GetEventRuleResponse struct {
  Headers map[string]*string `json:"headers,omitempty" xml:"headers,omitempty"`
  StatusCode *int32 `json:"statusCode,omitempty" xml:"statusCode,omitempty"`
  Body *GetEventRuleResponseBody `json:"body,omitempty" xml:"body,omitempty"`
}

func (s GetEventRuleResponse) String() string {
  return tea.Prettify(s)
}

func (s GetEventRuleResponse) GoString() string {
  return s.String()
}

func (s *GetEventRuleResponse) SetHeaders(v map[string]*string) *GetEventRuleResponse {
  s.Headers = v
  return s
}

func (s *GetEventRuleResponse) SetStatusCode(v int32) *GetEventRuleResponse {
  s.StatusCode = &v
  return s
}

func (s *GetEventRuleResponse) SetBody(v *GetEventRuleResponseBody) *GetEventRuleResponse {
  s.Body = v
  return s
}

type DeleteEventRuleRequest struct {
  // The name of the event bus with which the event source is associated.
  // 
  // This parameter is required.
  // 
  // example:
  // 
  // my-event-bus
  EventBusName *string `json:"eventBusName,omitempty" xml:"eventBusName,omitempty"`
  // The name of the event rule.
  // 
  // This parameter is required.
  // 
  // example:
  // 
  // myrabbitmq.sourc
  EventRuleName *string `json:"eventRuleName,omitempty" xml:"eventRuleName,omitempty"`
}

func (s DeleteEventRuleRequest) String() string {
  return tea.Prettify(s)
}

func (s DeleteEventRuleRequest) GoString() string {
  return s.String()
}

func (s *DeleteEventRuleRequest) SetEventBusName(v string) *DeleteEventRuleRequest {
  s.EventBusName = &v
  return s
}

func (s *DeleteEventRuleRequest) SetEventRuleName(v string) *DeleteEventRuleRequest {
  s.EventRuleName = &v
  return s
}

type DeleteEventRuleResponseBody struct {
  // The returned response code. Valid values:
  // 
  //     	- Success: The request is successful.
  // 
  //     	- Other codes: The request failed. For more information about error codes, see Error codes.
  // 
  // example:
  // 
  // Success
  Code *string `json:"code,omitempty" xml:"code,omitempty"`
  // The returned error message.
  // 
  // example:
  // 
  // Remote error. requestId: [A8EFABD2-95B9-1C46-9E01-xxxx], error code: [CreateRelatedResourceFailed], message: [Create related resource failed, EntityNotExist.Role : The role not exists: xxxx. \\r\\nRequestId : xxxx-168C-54ED-8FEB-BF11CB70AEB7]
  Message *string `json:"message,omitempty" xml:"message,omitempty"`
  // The request ID.
  // 
  // example:
  // 
  // 2922208e-e1c6-43ee-bfd1-aca50263bc8a
  RequestId *string `json:"requestId,omitempty" xml:"requestId,omitempty"`
}

func (s DeleteEventRuleResponseBody) String() string {
  return tea.Prettify(s)
}

func (s DeleteEventRuleResponseBody) GoString() string {
  return s.String()
}

func (s *DeleteEventRuleResponseBody) SetCode(v string) *DeleteEventRuleResponseBody {
  s.Code = &v
  return s
}

func (s *DeleteEventRuleResponseBody) SetMessage(v string) *DeleteEventRuleResponseBody {
  s.Message = &v
  return s
}

func (s *DeleteEventRuleResponseBody) SetRequestId(v string) *DeleteEventRuleResponseBody {
  s.RequestId = &v
  return s
}

type DeleteEventRuleResponse struct {
  Headers map[string]*string `json:"headers,omitempty" xml:"headers,omitempty"`
  StatusCode *int32 `json:"statusCode,omitempty" xml:"statusCode,omitempty"`
  Body *DeleteEventRuleResponseBody `json:"body,omitempty" xml:"body,omitempty"`
}

func (s DeleteEventRuleResponse) String() string {
  return tea.Prettify(s)
}

func (s DeleteEventRuleResponse) GoString() string {
  return s.String()
}

func (s *DeleteEventRuleResponse) SetHeaders(v map[string]*string) *DeleteEventRuleResponse {
  s.Headers = v
  return s
}

func (s *DeleteEventRuleResponse) SetStatusCode(v int32) *DeleteEventRuleResponse {
  s.StatusCode = &v
  return s
}

func (s *DeleteEventRuleResponse) SetBody(v *DeleteEventRuleResponseBody) *DeleteEventRuleResponse {
  s.Body = v
  return s
}

type UpdateEventRuleRequest struct {
  // The name of the event bus with which the event source is associated.
  // 
  // This parameter is required.
  // 
  // example:
  // 
  // my-event-bus
  EventBusName *string `json:"eventBusName,omitempty" xml:"eventBusName,omitempty"`
  // The name of the event rule.
  // 
  // This parameter is required.
  // 
  // example:
  // 
  // myrabbitmq.sourc
  EventRuleName *string `json:"eventRuleName,omitempty" xml:"eventRuleName,omitempty"`
  Description *string `json:"description,omitempty" xml:"description,omitempty"`
  // The event pattern, in JSON format. Valid values: stringEqual and stringExpression. You can specify up to five expressions in the map data structure in each field.
  // 
  //     You can specify up to five expressions in the map data structure in each field.
  // 
  // This parameter is required.
  // 
  // example:
  // 
  // {\"source\": [{\"prefix\": \"acs.\"}],\"type\": [{\"prefix\":\"oss:ObjectReplication\"}],\"subject\":[{\"prefix\":\"acs:oss:cn-hangzhou:123456789098****:my-movie-bucket/\", \"suffix\":\".txt\"}]}
  FilterPattern *string `json:"filterPattern,omitempty" xml:"filterPattern,omitempty"`
}

func (s UpdateEventRuleRequest) String() string {
  return tea.Prettify(s)
}

func (s UpdateEventRuleRequest) GoString() string {
  return s.String()
}

func (s *UpdateEventRuleRequest) SetEventBusName(v string) *UpdateEventRuleRequest {
  s.EventBusName = &v
  return s
}

func (s *UpdateEventRuleRequest) SetEventRuleName(v string) *UpdateEventRuleRequest {
  s.EventRuleName = &v
  return s
}

func (s *UpdateEventRuleRequest) SetDescription(v string) *UpdateEventRuleRequest {
  s.Description = &v
  return s
}

func (s *UpdateEventRuleRequest) SetFilterPattern(v string) *UpdateEventRuleRequest {
  s.FilterPattern = &v
  return s
}

type UpdateEventRuleResponseBody struct {
  // The returned response code. Valid values:
  // 
  //     	- Success: The request is successful.
  // 
  //     	- Other codes: The request failed. For more information about error codes, see Error codes.
  // 
  // example:
  // 
  // Success
  Code *string `json:"code,omitempty" xml:"code,omitempty"`
  // The returned error message.
  // 
  // example:
  // 
  // Remote error. requestId: [A8EFABD2-95B9-1C46-9E01-xxxx], error code: [CreateRelatedResourceFailed], message: [Create related resource failed, EntityNotExist.Role : The role not exists: xxxx. \\r\\nRequestId : xxxx-168C-54ED-8FEB-BF11CB70AEB7]
  Message *string `json:"message,omitempty" xml:"message,omitempty"`
  // The request ID.
  // 
  // example:
  // 
  // 2922208e-e1c6-43ee-bfd1-aca50263bc8a
  RequestId *string `json:"requestId,omitempty" xml:"requestId,omitempty"`
}

func (s UpdateEventRuleResponseBody) String() string {
  return tea.Prettify(s)
}

func (s UpdateEventRuleResponseBody) GoString() string {
  return s.String()
}

func (s *UpdateEventRuleResponseBody) SetCode(v string) *UpdateEventRuleResponseBody {
  s.Code = &v
  return s
}

func (s *UpdateEventRuleResponseBody) SetMessage(v string) *UpdateEventRuleResponseBody {
  s.Message = &v
  return s
}

func (s *UpdateEventRuleResponseBody) SetRequestId(v string) *UpdateEventRuleResponseBody {
  s.RequestId = &v
  return s
}

type UpdateEventRuleResponse struct {
  Headers map[string]*string `json:"headers,omitempty" xml:"headers,omitempty"`
  StatusCode *int32 `json:"statusCode,omitempty" xml:"statusCode,omitempty"`
  Body *UpdateEventRuleResponseBody `json:"body,omitempty" xml:"body,omitempty"`
}

func (s UpdateEventRuleResponse) String() string {
  return tea.Prettify(s)
}

func (s UpdateEventRuleResponse) GoString() string {
  return s.String()
}

func (s *UpdateEventRuleResponse) SetHeaders(v map[string]*string) *UpdateEventRuleResponse {
  s.Headers = v
  return s
}

func (s *UpdateEventRuleResponse) SetStatusCode(v int32) *UpdateEventRuleResponse {
  s.StatusCode = &v
  return s
}

func (s *UpdateEventRuleResponse) SetBody(v *UpdateEventRuleResponseBody) *UpdateEventRuleResponse {
  s.Body = v
  return s
}

type ListEventRulesRequest struct {
  EventBusName *string `json:"eventBusName,omitempty" xml:"eventBusName,omitempty"`
  // The number of entries returned per page.
  // 
  // example:
  // 
  // 10
  MaxResults *int32 `json:"maxResults,omitempty" xml:"maxResults,omitempty"`
  // If excess return values exist, this parameter is returned.
  // 
  // example:
  // 
  // 0
  NextToken *string `json:"nextToken,omitempty" xml:"nextToken,omitempty"`
}

func (s ListEventRulesRequest) String() string {
  return tea.Prettify(s)
}

func (s ListEventRulesRequest) GoString() string {
  return s.String()
}

func (s *ListEventRulesRequest) SetEventBusName(v string) *ListEventRulesRequest {
  s.EventBusName = &v
  return s
}

func (s *ListEventRulesRequest) SetMaxResults(v int32) *ListEventRulesRequest {
  s.MaxResults = &v
  return s
}

func (s *ListEventRulesRequest) SetNextToken(v string) *ListEventRulesRequest {
  s.NextToken = &v
  return s
}

type ListEventRulesResponseBody struct {
  EventRules []*ListEventRulesResponseBodyEventRules `json:"eventRules,omitempty" xml:"eventRules,omitempty" type:"Repeated"`
  // The total number of entries.
  // 
  // example:
  // 
  // 2
  Total *int `json:"total,omitempty" xml:"total,omitempty"`
  // The number of entries returned per page.
  // 
  // example:
  // 
  // 10
  MaxResults *int32 `json:"maxResults,omitempty" xml:"maxResults,omitempty"`
  // If excess return values exist, this parameter is returned.
  // 
  // example:
  // 
  // 0
  NextToken *string `json:"nextToken,omitempty" xml:"nextToken,omitempty"`
}

func (s ListEventRulesResponseBody) String() string {
  return tea.Prettify(s)
}

func (s ListEventRulesResponseBody) GoString() string {
  return s.String()
}

func (s *ListEventRulesResponseBody) SetEventRules(v []*ListEventRulesResponseBodyEventRules) *ListEventRulesResponseBody {
  s.EventRules = v
  return s
}

func (s *ListEventRulesResponseBody) SetTotal(v int) *ListEventRulesResponseBody {
  s.Total = &v
  return s
}

func (s *ListEventRulesResponseBody) SetMaxResults(v int32) *ListEventRulesResponseBody {
  s.MaxResults = &v
  return s
}

func (s *ListEventRulesResponseBody) SetNextToken(v string) *ListEventRulesResponseBody {
  s.NextToken = &v
  return s
}

type ListEventRulesResponseBodyEventRules struct     {
  // The name of the event bus with which the event source is associated.
  // 
  // This parameter is required.
  // 
  // example:
  // 
  // my-event-bus
  EventBusName *string `json:"eventBusName,omitempty" xml:"eventBusName,omitempty"`
  // The name of the event rule.
  // 
  // This parameter is required.
  // 
  // example:
  // 
  // myrabbitmq.sourc
  EventRuleName *string `json:"eventRuleName,omitempty" xml:"eventRuleName,omitempty"`
  Description *string `json:"description,omitempty" xml:"description,omitempty"`
  // The event pattern, in JSON format. Valid values: stringEqual and stringExpression. You can specify up to five expressions in the map data structure in each field.
  // 
  //         You can specify up to five expressions in the map data structure in each field.
  // 
  // example:
  // 
  // {\"source\": [{\"prefix\": \"acs.\"}],\"type\": [{\"prefix\":\"oss:ObjectReplication\"}],\"subject\":[{\"prefix\":\"acs:oss:cn-hangzhou:123456789098****:my-movie-bucket/\", \"suffix\":\".txt\"}]}
  FilterPattern *string `json:"filterPattern,omitempty" xml:"filterPattern,omitempty"`
  // The status of the event rule. Valid values: ENABLE (default): The event rule is enabled. DISABLE: The event rule is disabled.
  // 
  // example:
  // 
  // ENABLE
  Status *string `json:"status,omitempty" xml:"status,omitempty"`
  GmtCreate *string `json:"gmtCreate,omitempty" xml:"gmtCreate,omitempty"`
  GmtModify *string `json:"gmtModify,omitempty" xml:"gmtModify,omitempty"`
}

func (s ListEventRulesResponseBodyEventRules) String() string {
  return tea.Prettify(s)
}

func (s ListEventRulesResponseBodyEventRules) GoString() string {
  return s.String()
}

func (s *ListEventRulesResponseBodyEventRules) SetEventBusName(v string) *ListEventRulesResponseBodyEventRules {
  s.EventBusName = &v
  return s
}

func (s *ListEventRulesResponseBodyEventRules) SetEventRuleName(v string) *ListEventRulesResponseBodyEventRules {
  s.EventRuleName = &v
  return s
}

func (s *ListEventRulesResponseBodyEventRules) SetDescription(v string) *ListEventRulesResponseBodyEventRules {
  s.Description = &v
  return s
}

func (s *ListEventRulesResponseBodyEventRules) SetFilterPattern(v string) *ListEventRulesResponseBodyEventRules {
  s.FilterPattern = &v
  return s
}

func (s *ListEventRulesResponseBodyEventRules) SetStatus(v string) *ListEventRulesResponseBodyEventRules {
  s.Status = &v
  return s
}

func (s *ListEventRulesResponseBodyEventRules) SetGmtCreate(v string) *ListEventRulesResponseBodyEventRules {
  s.GmtCreate = &v
  return s
}

func (s *ListEventRulesResponseBodyEventRules) SetGmtModify(v string) *ListEventRulesResponseBodyEventRules {
  s.GmtModify = &v
  return s
}

type ListEventRulesResponse struct {
  Headers map[string]*string `json:"headers,omitempty" xml:"headers,omitempty"`
  StatusCode *int32 `json:"statusCode,omitempty" xml:"statusCode,omitempty"`
  Body *ListEventRulesResponseBody `json:"body,omitempty" xml:"body,omitempty"`
}

func (s ListEventRulesResponse) String() string {
  return tea.Prettify(s)
}

func (s ListEventRulesResponse) GoString() string {
  return s.String()
}

func (s *ListEventRulesResponse) SetHeaders(v map[string]*string) *ListEventRulesResponse {
  s.Headers = v
  return s
}

func (s *ListEventRulesResponse) SetStatusCode(v int32) *ListEventRulesResponse {
  s.StatusCode = &v
  return s
}

func (s *ListEventRulesResponse) SetBody(v *ListEventRulesResponseBody) *ListEventRulesResponse {
  s.Body = v
  return s
}

type EnableEventRuleRequest struct {
  // The name of the event bus with which the event source is associated.
  // 
  // This parameter is required.
  // 
  // example:
  // 
  // my-event-bus
  EventBusName *string `json:"eventBusName,omitempty" xml:"eventBusName,omitempty"`
  // The name of the event rule.
  // 
  // This parameter is required.
  // 
  // example:
  // 
  // myrabbitmq.sourc
  EventRuleName *string `json:"eventRuleName,omitempty" xml:"eventRuleName,omitempty"`
}

func (s EnableEventRuleRequest) String() string {
  return tea.Prettify(s)
}

func (s EnableEventRuleRequest) GoString() string {
  return s.String()
}

func (s *EnableEventRuleRequest) SetEventBusName(v string) *EnableEventRuleRequest {
  s.EventBusName = &v
  return s
}

func (s *EnableEventRuleRequest) SetEventRuleName(v string) *EnableEventRuleRequest {
  s.EventRuleName = &v
  return s
}

type EnableEventRuleResponseBody struct {
  // The returned response code. Valid values:
  // 
  //     	- Success: The request is successful.
  // 
  //     	- Other codes: The request failed. For more information about error codes, see Error codes.
  // 
  // example:
  // 
  // Success
  Code *string `json:"code,omitempty" xml:"code,omitempty"`
  // The returned error message.
  // 
  // example:
  // 
  // Remote error. requestId: [A8EFABD2-95B9-1C46-9E01-xxxx], error code: [CreateRelatedResourceFailed], message: [Create related resource failed, EntityNotExist.Role : The role not exists: xxxx. \\r\\nRequestId : xxxx-168C-54ED-8FEB-BF11CB70AEB7]
  Message *string `json:"message,omitempty" xml:"message,omitempty"`
  // The request ID.
  // 
  // example:
  // 
  // 2922208e-e1c6-43ee-bfd1-aca50263bc8a
  RequestId *string `json:"requestId,omitempty" xml:"requestId,omitempty"`
}

func (s EnableEventRuleResponseBody) String() string {
  return tea.Prettify(s)
}

func (s EnableEventRuleResponseBody) GoString() string {
  return s.String()
}

func (s *EnableEventRuleResponseBody) SetCode(v string) *EnableEventRuleResponseBody {
  s.Code = &v
  return s
}

func (s *EnableEventRuleResponseBody) SetMessage(v string) *EnableEventRuleResponseBody {
  s.Message = &v
  return s
}

func (s *EnableEventRuleResponseBody) SetRequestId(v string) *EnableEventRuleResponseBody {
  s.RequestId = &v
  return s
}

type EnableEventRuleResponse struct {
  Headers map[string]*string `json:"headers,omitempty" xml:"headers,omitempty"`
  StatusCode *int32 `json:"statusCode,omitempty" xml:"statusCode,omitempty"`
  Body *EnableEventRuleResponseBody `json:"body,omitempty" xml:"body,omitempty"`
}

func (s EnableEventRuleResponse) String() string {
  return tea.Prettify(s)
}

func (s EnableEventRuleResponse) GoString() string {
  return s.String()
}

func (s *EnableEventRuleResponse) SetHeaders(v map[string]*string) *EnableEventRuleResponse {
  s.Headers = v
  return s
}

func (s *EnableEventRuleResponse) SetStatusCode(v int32) *EnableEventRuleResponse {
  s.StatusCode = &v
  return s
}

func (s *EnableEventRuleResponse) SetBody(v *EnableEventRuleResponseBody) *EnableEventRuleResponse {
  s.Body = v
  return s
}

type DisableEventRuleRequest struct {
  // The name of the event bus with which the event source is associated.
  // 
  // This parameter is required.
  // 
  // example:
  // 
  // my-event-bus
  EventBusName *string `json:"eventBusName,omitempty" xml:"eventBusName,omitempty"`
  // The name of the event rule.
  // 
  // This parameter is required.
  // 
  // example:
  // 
  // myrabbitmq.sourc
  EventRuleName *string `json:"eventRuleName,omitempty" xml:"eventRuleName,omitempty"`
}

func (s DisableEventRuleRequest) String() string {
  return tea.Prettify(s)
}

func (s DisableEventRuleRequest) GoString() string {
  return s.String()
}

func (s *DisableEventRuleRequest) SetEventBusName(v string) *DisableEventRuleRequest {
  s.EventBusName = &v
  return s
}

func (s *DisableEventRuleRequest) SetEventRuleName(v string) *DisableEventRuleRequest {
  s.EventRuleName = &v
  return s
}

type DisableEventRuleResponseBody struct {
  // The returned response code. Valid values:
  // 
  //     	- Success: The request is successful.
  // 
  //     	- Other codes: The request failed. For more information about error codes, see Error codes.
  // 
  // example:
  // 
  // Success
  Code *string `json:"code,omitempty" xml:"code,omitempty"`
  // The returned error message.
  // 
  // example:
  // 
  // Remote error. requestId: [A8EFABD2-95B9-1C46-9E01-xxxx], error code: [CreateRelatedResourceFailed], message: [Create related resource failed, EntityNotExist.Role : The role not exists: xxxx. \\r\\nRequestId : xxxx-168C-54ED-8FEB-BF11CB70AEB7]
  Message *string `json:"message,omitempty" xml:"message,omitempty"`
  // The request ID.
  // 
  // example:
  // 
  // 2922208e-e1c6-43ee-bfd1-aca50263bc8a
  RequestId *string `json:"requestId,omitempty" xml:"requestId,omitempty"`
}

func (s DisableEventRuleResponseBody) String() string {
  return tea.Prettify(s)
}

func (s DisableEventRuleResponseBody) GoString() string {
  return s.String()
}

func (s *DisableEventRuleResponseBody) SetCode(v string) *DisableEventRuleResponseBody {
  s.Code = &v
  return s
}

func (s *DisableEventRuleResponseBody) SetMessage(v string) *DisableEventRuleResponseBody {
  s.Message = &v
  return s
}

func (s *DisableEventRuleResponseBody) SetRequestId(v string) *DisableEventRuleResponseBody {
  s.RequestId = &v
  return s
}

type DisableEventRuleResponse struct {
  Headers map[string]*string `json:"headers,omitempty" xml:"headers,omitempty"`
  StatusCode *int32 `json:"statusCode,omitempty" xml:"statusCode,omitempty"`
  Body *DisableEventRuleResponseBody `json:"body,omitempty" xml:"body,omitempty"`
}

func (s DisableEventRuleResponse) String() string {
  return tea.Prettify(s)
}

func (s DisableEventRuleResponse) GoString() string {
  return s.String()
}

func (s *DisableEventRuleResponse) SetHeaders(v map[string]*string) *DisableEventRuleResponse {
  s.Headers = v
  return s
}

func (s *DisableEventRuleResponse) SetStatusCode(v int32) *DisableEventRuleResponse {
  s.StatusCode = &v
  return s
}

func (s *DisableEventRuleResponse) SetBody(v *DisableEventRuleResponseBody) *DisableEventRuleResponse {
  s.Body = v
  return s
}

// Description:
// 
// EventSource Controller apis:
// 
// createEventSource *
// 
// updateEventSource *
// 
// deleteEventSource *
// 
// getEventSource    *
// 
// listEventSources  *
type CreateEventSourceRequest struct {
  // The description of the event source.
  Description *string `json:"description,omitempty" xml:"description,omitempty"`
  // The name of the event bus with which the event source is associated.
  // 
  // This parameter is required.
  // 
  // example:
  // 
  // my-event-bus
  EventBusName *string `json:"eventBusName,omitempty" xml:"eventBusName,omitempty"`
  // The name of the event source.
  // 
  // This parameter is required.
  // 
  // example:
  // 
  // myrabbitmq.sourc
  EventSourceName *string `json:"eventSourceName,omitempty" xml:"eventSourceName,omitempty"`
  ClassName *string `json:"className,omitempty" xml:"className,omitempty"`
  Config map[string]interface{} `json:"config,omitempty" xml:"config,omitempty"`
}

func (s CreateEventSourceRequest) String() string {
  return tea.Prettify(s)
}

func (s CreateEventSourceRequest) GoString() string {
  return s.String()
}

func (s *CreateEventSourceRequest) SetDescription(v string) *CreateEventSourceRequest {
  s.Description = &v
  return s
}

func (s *CreateEventSourceRequest) SetEventBusName(v string) *CreateEventSourceRequest {
  s.EventBusName = &v
  return s
}

func (s *CreateEventSourceRequest) SetEventSourceName(v string) *CreateEventSourceRequest {
  s.EventSourceName = &v
  return s
}

func (s *CreateEventSourceRequest) SetClassName(v string) *CreateEventSourceRequest {
  s.ClassName = &v
  return s
}

func (s *CreateEventSourceRequest) SetConfig(v map[string]interface{}) *CreateEventSourceRequest {
  s.Config = v
  return s
}

type CreateEventSourceResponseBody struct {
  // The returned response code. Valid values:
  // 
  //     	- Success: The request is successful.
  // 
  //     	- Other codes: The request failed. For more information about error codes, see Error codes.
  // 
  // example:
  // 
  // Success
  Code *string `json:"code,omitempty" xml:"code,omitempty"`
  // The name of the event source.
  // 
  // example:
  // 
  // myrabbitmq.sourc
  EventSourceName *string `json:"eventSourceName,omitempty" xml:"eventSourceName,omitempty"`
  // The returned error message.
  // 
  // example:
  // 
  // Remote error. requestId: [A8EFABD2-95B9-1C46-9E01-xxxx], error code: [CreateRelatedResourceFailed], message: [Create related resource failed, EntityNotExist.Role : The role not exists: xxxx. \\r\\nRequestId : xxxx-168C-54ED-8FEB-BF11CB70AEB7]
  Message *string `json:"message,omitempty" xml:"message,omitempty"`
  // The request ID.
  // 
  // example:
  // 
  // 2922208e-e1c6-43ee-bfd1-aca50263bc8a
  RequestId *string `json:"requestId,omitempty" xml:"requestId,omitempty"`
}

func (s CreateEventSourceResponseBody) String() string {
  return tea.Prettify(s)
}

func (s CreateEventSourceResponseBody) GoString() string {
  return s.String()
}

func (s *CreateEventSourceResponseBody) SetCode(v string) *CreateEventSourceResponseBody {
  s.Code = &v
  return s
}

func (s *CreateEventSourceResponseBody) SetEventSourceName(v string) *CreateEventSourceResponseBody {
  s.EventSourceName = &v
  return s
}

func (s *CreateEventSourceResponseBody) SetMessage(v string) *CreateEventSourceResponseBody {
  s.Message = &v
  return s
}

func (s *CreateEventSourceResponseBody) SetRequestId(v string) *CreateEventSourceResponseBody {
  s.RequestId = &v
  return s
}

type CreateEventSourceResponse struct {
  Headers map[string]*string `json:"headers,omitempty" xml:"headers,omitempty"`
  StatusCode *int32 `json:"statusCode,omitempty" xml:"statusCode,omitempty"`
  Body *CreateEventSourceResponseBody `json:"body,omitempty" xml:"body,omitempty"`
}

func (s CreateEventSourceResponse) String() string {
  return tea.Prettify(s)
}

func (s CreateEventSourceResponse) GoString() string {
  return s.String()
}

func (s *CreateEventSourceResponse) SetHeaders(v map[string]*string) *CreateEventSourceResponse {
  s.Headers = v
  return s
}

func (s *CreateEventSourceResponse) SetStatusCode(v int32) *CreateEventSourceResponse {
  s.StatusCode = &v
  return s
}

func (s *CreateEventSourceResponse) SetBody(v *CreateEventSourceResponseBody) *CreateEventSourceResponse {
  s.Body = v
  return s
}

type UpdateEventSourceRequest struct {
  // The name of the event bus with which the event source is associated.
  // 
  // This parameter is required.
  // 
  // example:
  // 
  // my-event-bus
  EventBusName *string `json:"eventBusName,omitempty" xml:"eventBusName,omitempty"`
  // The name of the event source.
  // 
  // This parameter is required.
  // 
  // example:
  // 
  // myrabbitmq.sourc
  EventSourceName *string `json:"eventSourceName,omitempty" xml:"eventSourceName,omitempty"`
  // The description of the event source.
  Description *string `json:"description,omitempty" xml:"description,omitempty"`
  ClassName *string `json:"className,omitempty" xml:"className,omitempty"`
  Status *int `json:"status,omitempty" xml:"status,omitempty"`
  Config map[string]interface{} `json:"config,omitempty" xml:"config,omitempty"`
}

func (s UpdateEventSourceRequest) String() string {
  return tea.Prettify(s)
}

func (s UpdateEventSourceRequest) GoString() string {
  return s.String()
}

func (s *UpdateEventSourceRequest) SetEventBusName(v string) *UpdateEventSourceRequest {
  s.EventBusName = &v
  return s
}

func (s *UpdateEventSourceRequest) SetEventSourceName(v string) *UpdateEventSourceRequest {
  s.EventSourceName = &v
  return s
}

func (s *UpdateEventSourceRequest) SetDescription(v string) *UpdateEventSourceRequest {
  s.Description = &v
  return s
}

func (s *UpdateEventSourceRequest) SetClassName(v string) *UpdateEventSourceRequest {
  s.ClassName = &v
  return s
}

func (s *UpdateEventSourceRequest) SetStatus(v int) *UpdateEventSourceRequest {
  s.Status = &v
  return s
}

func (s *UpdateEventSourceRequest) SetConfig(v map[string]interface{}) *UpdateEventSourceRequest {
  s.Config = v
  return s
}

type UpdateEventSourceResponseBody struct {
  // The returned response code. Valid values:
  // 
  //     	- Success: The request is successful.
  // 
  //     	- Other codes: The request failed. For more information about error codes, see Error codes.
  // 
  // example:
  // 
  // Success
  Code *string `json:"code,omitempty" xml:"code,omitempty"`
  // The returned error message.
  // 
  // example:
  // 
  // Remote error. requestId: [A8EFABD2-95B9-1C46-9E01-xxxx], error code: [CreateRelatedResourceFailed], message: [Create related resource failed, EntityNotExist.Role : The role not exists: xxxx. \\r\\nRequestId : xxxx-168C-54ED-8FEB-BF11CB70AEB7]
  Message *string `json:"message,omitempty" xml:"message,omitempty"`
  // The request ID.
  // 
  // example:
  // 
  // 2922208e-e1c6-43ee-bfd1-aca50263bc8a
  RequestId *string `json:"requestId,omitempty" xml:"requestId,omitempty"`
}

func (s UpdateEventSourceResponseBody) String() string {
  return tea.Prettify(s)
}

func (s UpdateEventSourceResponseBody) GoString() string {
  return s.String()
}

func (s *UpdateEventSourceResponseBody) SetCode(v string) *UpdateEventSourceResponseBody {
  s.Code = &v
  return s
}

func (s *UpdateEventSourceResponseBody) SetMessage(v string) *UpdateEventSourceResponseBody {
  s.Message = &v
  return s
}

func (s *UpdateEventSourceResponseBody) SetRequestId(v string) *UpdateEventSourceResponseBody {
  s.RequestId = &v
  return s
}

type UpdateEventSourceResponse struct {
  Headers map[string]*string `json:"headers,omitempty" xml:"headers,omitempty"`
  StatusCode *int32 `json:"statusCode,omitempty" xml:"statusCode,omitempty"`
  Body *UpdateEventSourceResponseBody `json:"body,omitempty" xml:"body,omitempty"`
}

func (s UpdateEventSourceResponse) String() string {
  return tea.Prettify(s)
}

func (s UpdateEventSourceResponse) GoString() string {
  return s.String()
}

func (s *UpdateEventSourceResponse) SetHeaders(v map[string]*string) *UpdateEventSourceResponse {
  s.Headers = v
  return s
}

func (s *UpdateEventSourceResponse) SetStatusCode(v int32) *UpdateEventSourceResponse {
  s.StatusCode = &v
  return s
}

func (s *UpdateEventSourceResponse) SetBody(v *UpdateEventSourceResponseBody) *UpdateEventSourceResponse {
  s.Body = v
  return s
}

type DeleteEventSourceRequest struct {
  EventBusName *string `json:"eventBusName,omitempty" xml:"eventBusName,omitempty"`
  // The name of the event source.
  // 
  // This parameter is required.
  // 
  // example:
  // 
  // myrabbitmq.source
  EventSourceName *string `json:"eventSourceName,omitempty" xml:"eventSourceName,omitempty"`
}

func (s DeleteEventSourceRequest) String() string {
  return tea.Prettify(s)
}

func (s DeleteEventSourceRequest) GoString() string {
  return s.String()
}

func (s *DeleteEventSourceRequest) SetEventBusName(v string) *DeleteEventSourceRequest {
  s.EventBusName = &v
  return s
}

func (s *DeleteEventSourceRequest) SetEventSourceName(v string) *DeleteEventSourceRequest {
  s.EventSourceName = &v
  return s
}

type DeleteEventSourceResponseBody struct {
  // The returned response code. The value Success indicates that the request is successful. Other values indicate that the request failed. For more information about error codes, see Error codes.
  // 
  // example:
  // 
  // Success
  Code *string `json:"code,omitempty" xml:"code,omitempty"`
  // The returned error message.
  // 
  // example:
  // 
  // Remote error. requestId: [78B66E68-E778-1F33-84BD-xxxx], error code: [EventSourceNotExist], message: [The event source in request is not exist! ]
  Message *string `json:"message,omitempty" xml:"message,omitempty"`
  // The request ID.
  // 
  // example:
  // 
  // 5f80e9b3-98d5-4f51-8412-c758818a03e4
  RequestId *string `json:"requestId,omitempty" xml:"requestId,omitempty"`
}

func (s DeleteEventSourceResponseBody) String() string {
  return tea.Prettify(s)
}

func (s DeleteEventSourceResponseBody) GoString() string {
  return s.String()
}

func (s *DeleteEventSourceResponseBody) SetCode(v string) *DeleteEventSourceResponseBody {
  s.Code = &v
  return s
}

func (s *DeleteEventSourceResponseBody) SetMessage(v string) *DeleteEventSourceResponseBody {
  s.Message = &v
  return s
}

func (s *DeleteEventSourceResponseBody) SetRequestId(v string) *DeleteEventSourceResponseBody {
  s.RequestId = &v
  return s
}

type DeleteEventSourceResponse struct {
  Headers map[string]*string `json:"headers,omitempty" xml:"headers,omitempty"`
  StatusCode *int32 `json:"statusCode,omitempty" xml:"statusCode,omitempty"`
  Body *DeleteEventSourceResponseBody `json:"body,omitempty" xml:"body,omitempty"`
}

func (s DeleteEventSourceResponse) String() string {
  return tea.Prettify(s)
}

func (s DeleteEventSourceResponse) GoString() string {
  return s.String()
}

func (s *DeleteEventSourceResponse) SetHeaders(v map[string]*string) *DeleteEventSourceResponse {
  s.Headers = v
  return s
}

func (s *DeleteEventSourceResponse) SetStatusCode(v int32) *DeleteEventSourceResponse {
  s.StatusCode = &v
  return s
}

func (s *DeleteEventSourceResponse) SetBody(v *DeleteEventSourceResponseBody) *DeleteEventSourceResponse {
  s.Body = v
  return s
}

type GetEventSourceRequest struct {
  EventBusName *string `json:"eventBusName,omitempty" xml:"eventBusName,omitempty"`
  // The name of the event source.
  // 
  // This parameter is required.
  // 
  // example:
  // 
  // myrabbitmq.source
  EventSourceName *string `json:"eventSourceName,omitempty" xml:"eventSourceName,omitempty"`
}

func (s GetEventSourceRequest) String() string {
  return tea.Prettify(s)
}

func (s GetEventSourceRequest) GoString() string {
  return s.String()
}

func (s *GetEventSourceRequest) SetEventBusName(v string) *GetEventSourceRequest {
  s.EventBusName = &v
  return s
}

func (s *GetEventSourceRequest) SetEventSourceName(v string) *GetEventSourceRequest {
  s.EventSourceName = &v
  return s
}

type GetEventSourceResponseBody struct {
  // The name of the event bus with which the event source is associated.
  // 
  // This parameter is required.
  // 
  // example:
  // 
  // my-event-bus
  EventBusName *string `json:"eventBusName,omitempty" xml:"eventBusName,omitempty"`
  // The name of the event source.
  // 
  // This parameter is required.
  // 
  // example:
  // 
  // myrabbitmq.sourc
  EventSourceName *string `json:"eventSourceName,omitempty" xml:"eventSourceName,omitempty"`
  // The description of the event source.
  Description *string `json:"description,omitempty" xml:"description,omitempty"`
  ClassName *string `json:"className,omitempty" xml:"className,omitempty"`
  Config map[string]interface{} `json:"config,omitempty" xml:"config,omitempty"`
}

func (s GetEventSourceResponseBody) String() string {
  return tea.Prettify(s)
}

func (s GetEventSourceResponseBody) GoString() string {
  return s.String()
}

func (s *GetEventSourceResponseBody) SetEventBusName(v string) *GetEventSourceResponseBody {
  s.EventBusName = &v
  return s
}

func (s *GetEventSourceResponseBody) SetEventSourceName(v string) *GetEventSourceResponseBody {
  s.EventSourceName = &v
  return s
}

func (s *GetEventSourceResponseBody) SetDescription(v string) *GetEventSourceResponseBody {
  s.Description = &v
  return s
}

func (s *GetEventSourceResponseBody) SetClassName(v string) *GetEventSourceResponseBody {
  s.ClassName = &v
  return s
}

func (s *GetEventSourceResponseBody) SetConfig(v map[string]interface{}) *GetEventSourceResponseBody {
  s.Config = v
  return s
}

type GetEventSourceResponse struct {
  Headers map[string]*string `json:"headers,omitempty" xml:"headers,omitempty"`
  StatusCode *int32 `json:"statusCode,omitempty" xml:"statusCode,omitempty"`
  Body *GetEventSourceResponseBody `json:"body,omitempty" xml:"body,omitempty"`
}

func (s GetEventSourceResponse) String() string {
  return tea.Prettify(s)
}

func (s GetEventSourceResponse) GoString() string {
  return s.String()
}

func (s *GetEventSourceResponse) SetHeaders(v map[string]*string) *GetEventSourceResponse {
  s.Headers = v
  return s
}

func (s *GetEventSourceResponse) SetStatusCode(v int32) *GetEventSourceResponse {
  s.StatusCode = &v
  return s
}

func (s *GetEventSourceResponse) SetBody(v *GetEventSourceResponseBody) *GetEventSourceResponse {
  s.Body = v
  return s
}

type ListEventSourcesRequest struct {
  EventBusName *string `json:"eventBusName,omitempty" xml:"eventBusName,omitempty"`
  // The type of the event source.
  // 
  // This parameter is required.
  // 
  // example:
  // 
  // USER_DEFINED
  EventSourceType *string `json:"eventSourceType,omitempty" xml:"eventSourceType,omitempty"`
  // The number of entries returned per page.
  // 
  // example:
  // 
  // 10
  MaxResults *int32 `json:"maxResults,omitempty" xml:"maxResults,omitempty"`
  // If excess return values exist, this parameter is returned.
  // 
  // example:
  // 
  // 0
  NextToken *string `json:"nextToken,omitempty" xml:"nextToken,omitempty"`
}

func (s ListEventSourcesRequest) String() string {
  return tea.Prettify(s)
}

func (s ListEventSourcesRequest) GoString() string {
  return s.String()
}

func (s *ListEventSourcesRequest) SetEventBusName(v string) *ListEventSourcesRequest {
  s.EventBusName = &v
  return s
}

func (s *ListEventSourcesRequest) SetEventSourceType(v string) *ListEventSourcesRequest {
  s.EventSourceType = &v
  return s
}

func (s *ListEventSourcesRequest) SetMaxResults(v int32) *ListEventSourcesRequest {
  s.MaxResults = &v
  return s
}

func (s *ListEventSourcesRequest) SetNextToken(v string) *ListEventSourcesRequest {
  s.NextToken = &v
  return s
}

type ListEventSourcesResponseBody struct {
  EventSources []*ListEventSourcesResponseBodyEventSources `json:"eventSources,omitempty" xml:"eventSources,omitempty" type:"Repeated"`
  // The total number of entries.
  // 
  // example:
  // 
  // 2
  Total *int `json:"total,omitempty" xml:"total,omitempty"`
  // The number of entries returned per page.
  // 
  // example:
  // 
  // 10
  MaxResults *int32 `json:"maxResults,omitempty" xml:"maxResults,omitempty"`
  // If excess return values exist, this parameter is returned.
  // 
  // example:
  // 
  // 0
  NextToken *string `json:"nextToken,omitempty" xml:"nextToken,omitempty"`
}

func (s ListEventSourcesResponseBody) String() string {
  return tea.Prettify(s)
}

func (s ListEventSourcesResponseBody) GoString() string {
  return s.String()
}

func (s *ListEventSourcesResponseBody) SetEventSources(v []*ListEventSourcesResponseBodyEventSources) *ListEventSourcesResponseBody {
  s.EventSources = v
  return s
}

func (s *ListEventSourcesResponseBody) SetTotal(v int) *ListEventSourcesResponseBody {
  s.Total = &v
  return s
}

func (s *ListEventSourcesResponseBody) SetMaxResults(v int32) *ListEventSourcesResponseBody {
  s.MaxResults = &v
  return s
}

func (s *ListEventSourcesResponseBody) SetNextToken(v string) *ListEventSourcesResponseBody {
  s.NextToken = &v
  return s
}

type ListEventSourcesResponseBodyEventSources struct     {
  // The name of the event bus.
  // 
  // This parameter is required.
  // 
  // example:
  // 
  // demo
  EventBusName *string `json:"eventBusName,omitempty" xml:"eventBusName,omitempty"`
  // EventSource is required for querying default bus events.
  // 
  // example:
  // 
  // testEventSourceName
  EventSourceName *string `json:"eventSourceName,omitempty" xml:"eventSourceName,omitempty"`
  // The description of the event type.
  // 
  // example:
  // 
  // The description of the event type.
  Description *string `json:"description,omitempty" xml:"description,omitempty"`
  ClassName *string `json:"className,omitempty" xml:"className,omitempty"`
  Config map[string]interface{} `json:"config,omitempty" xml:"config,omitempty"`
  GmtCreate *string `json:"gmtCreate,omitempty" xml:"gmtCreate,omitempty"`
  GmtModify *string `json:"gmtModify,omitempty" xml:"gmtModify,omitempty"`
}

func (s ListEventSourcesResponseBodyEventSources) String() string {
  return tea.Prettify(s)
}

func (s ListEventSourcesResponseBodyEventSources) GoString() string {
  return s.String()
}

func (s *ListEventSourcesResponseBodyEventSources) SetEventBusName(v string) *ListEventSourcesResponseBodyEventSources {
  s.EventBusName = &v
  return s
}

func (s *ListEventSourcesResponseBodyEventSources) SetEventSourceName(v string) *ListEventSourcesResponseBodyEventSources {
  s.EventSourceName = &v
  return s
}

func (s *ListEventSourcesResponseBodyEventSources) SetDescription(v string) *ListEventSourcesResponseBodyEventSources {
  s.Description = &v
  return s
}

func (s *ListEventSourcesResponseBodyEventSources) SetClassName(v string) *ListEventSourcesResponseBodyEventSources {
  s.ClassName = &v
  return s
}

func (s *ListEventSourcesResponseBodyEventSources) SetConfig(v map[string]interface{}) *ListEventSourcesResponseBodyEventSources {
  s.Config = v
  return s
}

func (s *ListEventSourcesResponseBodyEventSources) SetGmtCreate(v string) *ListEventSourcesResponseBodyEventSources {
  s.GmtCreate = &v
  return s
}

func (s *ListEventSourcesResponseBodyEventSources) SetGmtModify(v string) *ListEventSourcesResponseBodyEventSources {
  s.GmtModify = &v
  return s
}

type ListEventSourcesResponse struct {
  Headers map[string]*string `json:"headers,omitempty" xml:"headers,omitempty"`
  StatusCode *int32 `json:"statusCode,omitempty" xml:"statusCode,omitempty"`
  Body *ListEventSourcesResponseBody `json:"body,omitempty" xml:"body,omitempty"`
}

func (s ListEventSourcesResponse) String() string {
  return tea.Prettify(s)
}

func (s ListEventSourcesResponse) GoString() string {
  return s.String()
}

func (s *ListEventSourcesResponse) SetHeaders(v map[string]*string) *ListEventSourcesResponse {
  s.Headers = v
  return s
}

func (s *ListEventSourcesResponse) SetStatusCode(v int32) *ListEventSourcesResponse {
  s.StatusCode = &v
  return s
}

func (s *ListEventSourcesResponse) SetBody(v *ListEventSourcesResponseBody) *ListEventSourcesResponse {
  s.Body = v
  return s
}

// Description:
// 
// EventTarget Controller apis:
// 
// createEventTargets *
// 
// updateEventTargets *
// 
// deleteEventTargets *
// 
// listEventTargets   *
type EventTarget struct {
  EventTargetName *string `json:"eventTargetName,omitempty" xml:"eventTargetName,omitempty"`
  ClassName *string `json:"className,omitempty" xml:"className,omitempty"`
  Config map[string]interface{} `json:"config,omitempty" xml:"config,omitempty"`
  RunOptions *EventTargetRunOptions `json:"runOptions,omitempty" xml:"runOptions,omitempty" type:"Struct"`
}

func (s EventTarget) String() string {
  return tea.Prettify(s)
}

func (s EventTarget) GoString() string {
  return s.String()
}

func (s *EventTarget) SetEventTargetName(v string) *EventTarget {
  s.EventTargetName = &v
  return s
}

func (s *EventTarget) SetClassName(v string) *EventTarget {
  s.ClassName = &v
  return s
}

func (s *EventTarget) SetConfig(v map[string]interface{}) *EventTarget {
  s.Config = v
  return s
}

func (s *EventTarget) SetRunOptions(v *EventTargetRunOptions) *EventTarget {
  s.RunOptions = v
  return s
}

type EventTargetRunOptions struct {
  ErrorsTolerance *string `json:"errorsTolerance,omitempty" xml:"errorsTolerance,omitempty"`
  RetryStrategy *EventTargetRunOptionsRetryStrategy `json:"retryStrategy,omitempty" xml:"retryStrategy,omitempty" type:"Struct"`
  DeadLetterQueue *EventTargetRunOptionsDeadLetterQueue `json:"deadLetterQueue,omitempty" xml:"deadLetterQueue,omitempty" type:"Struct"`
}

func (s EventTargetRunOptions) String() string {
  return tea.Prettify(s)
}

func (s EventTargetRunOptions) GoString() string {
  return s.String()
}

func (s *EventTargetRunOptions) SetErrorsTolerance(v string) *EventTargetRunOptions {
  s.ErrorsTolerance = &v
  return s
}

func (s *EventTargetRunOptions) SetRetryStrategy(v *EventTargetRunOptionsRetryStrategy) *EventTargetRunOptions {
  s.RetryStrategy = v
  return s
}

func (s *EventTargetRunOptions) SetDeadLetterQueue(v *EventTargetRunOptionsDeadLetterQueue) *EventTargetRunOptions {
  s.DeadLetterQueue = v
  return s
}

type EventTargetRunOptionsRetryStrategy struct {
  PushRetryStrategy *string `json:"pushRetryStrategy,omitempty" xml:"pushRetryStrategy,omitempty"`
  MaximumEventAgeInSeconds *int32 `json:"maximumEventAgeInSeconds,omitempty" xml:"maximumEventAgeInSeconds,omitempty"`
  MaximumRetryAttempts *int32 `json:"maximumRetryAttempts,omitempty" xml:"maximumRetryAttempts,omitempty"`
}

func (s EventTargetRunOptionsRetryStrategy) String() string {
  return tea.Prettify(s)
}

func (s EventTargetRunOptionsRetryStrategy) GoString() string {
  return s.String()
}

func (s *EventTargetRunOptionsRetryStrategy) SetPushRetryStrategy(v string) *EventTargetRunOptionsRetryStrategy {
  s.PushRetryStrategy = &v
  return s
}

func (s *EventTargetRunOptionsRetryStrategy) SetMaximumEventAgeInSeconds(v int32) *EventTargetRunOptionsRetryStrategy {
  s.MaximumEventAgeInSeconds = &v
  return s
}

func (s *EventTargetRunOptionsRetryStrategy) SetMaximumRetryAttempts(v int32) *EventTargetRunOptionsRetryStrategy {
  s.MaximumRetryAttempts = &v
  return s
}

type EventTargetRunOptionsDeadLetterQueue struct {
  Type *string `json:"type,omitempty" xml:"type,omitempty"`
  Config map[string]interface{} `json:"config,omitempty" xml:"config,omitempty"`
}

func (s EventTargetRunOptionsDeadLetterQueue) String() string {
  return tea.Prettify(s)
}

func (s EventTargetRunOptionsDeadLetterQueue) GoString() string {
  return s.String()
}

func (s *EventTargetRunOptionsDeadLetterQueue) SetType(v string) *EventTargetRunOptionsDeadLetterQueue {
  s.Type = &v
  return s
}

func (s *EventTargetRunOptionsDeadLetterQueue) SetConfig(v map[string]interface{}) *EventTargetRunOptionsDeadLetterQueue {
  s.Config = v
  return s
}

type CreateEventTargetsRequest struct {
  // The name of the event bus with which the event target is associated.
  // 
  // This parameter is required.
  // 
  // example:
  // 
  // my-event-bus
  EventBusName *string `json:"eventBusName,omitempty" xml:"eventBusName,omitempty"`
  // The name of the event rule.
  // 
  // This parameter is required.
  // 
  // example:
  // 
  // myrabbitmq.sourc
  EventRuleName *string `json:"eventRuleName,omitempty" xml:"eventRuleName,omitempty"`
  EventTargets []*EventTarget `json:"eventTargets,omitempty" xml:"eventTargets,omitempty" type:"Repeated"`
}

func (s CreateEventTargetsRequest) String() string {
  return tea.Prettify(s)
}

func (s CreateEventTargetsRequest) GoString() string {
  return s.String()
}

func (s *CreateEventTargetsRequest) SetEventBusName(v string) *CreateEventTargetsRequest {
  s.EventBusName = &v
  return s
}

func (s *CreateEventTargetsRequest) SetEventRuleName(v string) *CreateEventTargetsRequest {
  s.EventRuleName = &v
  return s
}

func (s *CreateEventTargetsRequest) SetEventTargets(v []*EventTarget) *CreateEventTargetsRequest {
  s.EventTargets = v
  return s
}

type CreateEventTargetsResponseBody struct {
  // The returned response code. Valid values:
  // 
  //     	- Success: The request is successful.
  // 
  //     	- Other codes: The request failed. For more information about error codes, see Error codes.
  // 
  // example:
  // 
  // Success
  Code *string `json:"code,omitempty" xml:"code,omitempty"`
  // The returned error message.
  // 
  // example:
  // 
  // Remote error. requestId: [A8EFABD2-95B9-1C46-9E01-xxxx], error code: [CreateRelatedResourceFailed], message: [Create related resource failed, EntityNotExist.Role : The role not exists: xxxx. \\r\\nRequestId : xxxx-168C-54ED-8FEB-BF11CB70AEB7]
  Message *string `json:"message,omitempty" xml:"message,omitempty"`
  // The request ID.
  // 
  // example:
  // 
  // 2922208e-e1c6-43ee-bfd1-aca50263bc8a
  RequestId *string `json:"requestId,omitempty" xml:"requestId,omitempty"`
}

func (s CreateEventTargetsResponseBody) String() string {
  return tea.Prettify(s)
}

func (s CreateEventTargetsResponseBody) GoString() string {
  return s.String()
}

func (s *CreateEventTargetsResponseBody) SetCode(v string) *CreateEventTargetsResponseBody {
  s.Code = &v
  return s
}

func (s *CreateEventTargetsResponseBody) SetMessage(v string) *CreateEventTargetsResponseBody {
  s.Message = &v
  return s
}

func (s *CreateEventTargetsResponseBody) SetRequestId(v string) *CreateEventTargetsResponseBody {
  s.RequestId = &v
  return s
}

type CreateEventTargetsResponse struct {
  Headers map[string]*string `json:"headers,omitempty" xml:"headers,omitempty"`
  StatusCode *int32 `json:"statusCode,omitempty" xml:"statusCode,omitempty"`
  Body *CreateEventTargetsResponseBody `json:"body,omitempty" xml:"body,omitempty"`
}

func (s CreateEventTargetsResponse) String() string {
  return tea.Prettify(s)
}

func (s CreateEventTargetsResponse) GoString() string {
  return s.String()
}

func (s *CreateEventTargetsResponse) SetHeaders(v map[string]*string) *CreateEventTargetsResponse {
  s.Headers = v
  return s
}

func (s *CreateEventTargetsResponse) SetStatusCode(v int32) *CreateEventTargetsResponse {
  s.StatusCode = &v
  return s
}

func (s *CreateEventTargetsResponse) SetBody(v *CreateEventTargetsResponseBody) *CreateEventTargetsResponse {
  s.Body = v
  return s
}

type UpdateEventTargetsRequest struct {
  // The name of the event bus with which the event target is associated.
  // 
  // This parameter is required.
  // 
  // example:
  // 
  // my-event-bus
  EventBusName *string `json:"eventBusName,omitempty" xml:"eventBusName,omitempty"`
  // The name of the event rule.
  // 
  // This parameter is required.
  // 
  // example:
  // 
  // myrabbitmq.sourc
  EventRuleName *string `json:"eventRuleName,omitempty" xml:"eventRuleName,omitempty"`
  EventTargets []*EventTarget `json:"eventTargets,omitempty" xml:"eventTargets,omitempty" type:"Repeated"`
}

func (s UpdateEventTargetsRequest) String() string {
  return tea.Prettify(s)
}

func (s UpdateEventTargetsRequest) GoString() string {
  return s.String()
}

func (s *UpdateEventTargetsRequest) SetEventBusName(v string) *UpdateEventTargetsRequest {
  s.EventBusName = &v
  return s
}

func (s *UpdateEventTargetsRequest) SetEventRuleName(v string) *UpdateEventTargetsRequest {
  s.EventRuleName = &v
  return s
}

func (s *UpdateEventTargetsRequest) SetEventTargets(v []*EventTarget) *UpdateEventTargetsRequest {
  s.EventTargets = v
  return s
}

type UpdateEventTargetsResponseBody struct {
  // The returned response code. Valid values:
  // 
  //     	- Success: The request is successful.
  // 
  //     	- Other codes: The request failed. For more information about error codes, see Error codes.
  // 
  // example:
  // 
  // Success
  Code *string `json:"code,omitempty" xml:"code,omitempty"`
  // The returned error message.
  // 
  // example:
  // 
  // Remote error. requestId: [A8EFABD2-95B9-1C46-9E01-xxxx], error code: [CreateRelatedResourceFailed], message: [Create related resource failed, EntityNotExist.Role : The role not exists: xxxx. \\r\\nRequestId : xxxx-168C-54ED-8FEB-BF11CB70AEB7]
  Message *string `json:"message,omitempty" xml:"message,omitempty"`
  // The request ID.
  // 
  // example:
  // 
  // 2922208e-e1c6-43ee-bfd1-aca50263bc8a
  RequestId *string `json:"requestId,omitempty" xml:"requestId,omitempty"`
}

func (s UpdateEventTargetsResponseBody) String() string {
  return tea.Prettify(s)
}

func (s UpdateEventTargetsResponseBody) GoString() string {
  return s.String()
}

func (s *UpdateEventTargetsResponseBody) SetCode(v string) *UpdateEventTargetsResponseBody {
  s.Code = &v
  return s
}

func (s *UpdateEventTargetsResponseBody) SetMessage(v string) *UpdateEventTargetsResponseBody {
  s.Message = &v
  return s
}

func (s *UpdateEventTargetsResponseBody) SetRequestId(v string) *UpdateEventTargetsResponseBody {
  s.RequestId = &v
  return s
}

type UpdateEventTargetsResponse struct {
  Headers map[string]*string `json:"headers,omitempty" xml:"headers,omitempty"`
  StatusCode *int32 `json:"statusCode,omitempty" xml:"statusCode,omitempty"`
  Body *UpdateEventTargetsResponseBody `json:"body,omitempty" xml:"body,omitempty"`
}

func (s UpdateEventTargetsResponse) String() string {
  return tea.Prettify(s)
}

func (s UpdateEventTargetsResponse) GoString() string {
  return s.String()
}

func (s *UpdateEventTargetsResponse) SetHeaders(v map[string]*string) *UpdateEventTargetsResponse {
  s.Headers = v
  return s
}

func (s *UpdateEventTargetsResponse) SetStatusCode(v int32) *UpdateEventTargetsResponse {
  s.StatusCode = &v
  return s
}

func (s *UpdateEventTargetsResponse) SetBody(v *UpdateEventTargetsResponseBody) *UpdateEventTargetsResponse {
  s.Body = v
  return s
}

type DeleteEventTargetsRequest struct {
  // The name of the event bus.
  // 
  // example:
  // 
  // MyEventBus
  EventBusName *string `json:"eventBusName,omitempty" xml:"eventBusName,omitempty" require:"true"`
  // The name of the event rule.
  // 
  // example:
  // 
  // ramrolechange-mns
  EventRuleName *string `json:"eventRuleName,omitempty" xml:"eventRuleName,omitempty" require:"true"`
  // The names of the event targets that you want to delete.
  EventTargetNames []*string `json:"eventTargetNames,omitempty" xml:"eventTargetNames,omitempty" type:"Repeated"`
}

func (s DeleteEventTargetsRequest) String() string {
  return tea.Prettify(s)
}

func (s DeleteEventTargetsRequest) GoString() string {
  return s.String()
}

func (s *DeleteEventTargetsRequest) SetEventBusName(v string) *DeleteEventTargetsRequest {
  s.EventBusName = &v
  return s
}

func (s *DeleteEventTargetsRequest) SetEventRuleName(v string) *DeleteEventTargetsRequest {
  s.EventRuleName = &v
  return s
}

func (s *DeleteEventTargetsRequest) SetEventTargetNames(v []*string) *DeleteEventTargetsRequest {
  s.EventTargetNames = v
  return s
}

type DeleteEventTargetsResponseBody struct {
  // The returned response code. Valid values:
  // 
  //     	- Success: The request is successful.
  // 
  //     	- Other codes: The request failed. For more information about error codes, see Error codes.
  // 
  // example:
  // 
  // Success
  Code *string `json:"code,omitempty" xml:"code,omitempty"`
  // The returned error message.
  // 
  // example:
  // 
  // Remote error. requestId: [A8EFABD2-95B9-1C46-9E01-xxxx], error code: [CreateRelatedResourceFailed], message: [Create related resource failed, EntityNotExist.Role : The role not exists: xxxx. \\r\\nRequestId : xxxx-168C-54ED-8FEB-BF11CB70AEB7]
  Message *string `json:"message,omitempty" xml:"message,omitempty"`
  // The request ID.
  // 
  // example:
  // 
  // 2922208e-e1c6-43ee-bfd1-aca50263bc8a
  RequestId *string `json:"requestId,omitempty" xml:"requestId,omitempty"`
}

func (s DeleteEventTargetsResponseBody) String() string {
  return tea.Prettify(s)
}

func (s DeleteEventTargetsResponseBody) GoString() string {
  return s.String()
}

func (s *DeleteEventTargetsResponseBody) SetCode(v string) *DeleteEventTargetsResponseBody {
  s.Code = &v
  return s
}

func (s *DeleteEventTargetsResponseBody) SetMessage(v string) *DeleteEventTargetsResponseBody {
  s.Message = &v
  return s
}

func (s *DeleteEventTargetsResponseBody) SetRequestId(v string) *DeleteEventTargetsResponseBody {
  s.RequestId = &v
  return s
}

type DeleteEventTargetsResponse struct {
  Headers map[string]*string `json:"headers,omitempty" xml:"headers,omitempty"`
  StatusCode *int32 `json:"statusCode,omitempty" xml:"statusCode,omitempty"`
  Body *DeleteEventTargetsResponseBody `json:"body,omitempty" xml:"body,omitempty"`
}

func (s DeleteEventTargetsResponse) String() string {
  return tea.Prettify(s)
}

func (s DeleteEventTargetsResponse) GoString() string {
  return s.String()
}

func (s *DeleteEventTargetsResponse) SetHeaders(v map[string]*string) *DeleteEventTargetsResponse {
  s.Headers = v
  return s
}

func (s *DeleteEventTargetsResponse) SetStatusCode(v int32) *DeleteEventTargetsResponse {
  s.StatusCode = &v
  return s
}

func (s *DeleteEventTargetsResponse) SetBody(v *DeleteEventTargetsResponseBody) *DeleteEventTargetsResponse {
  s.Body = v
  return s
}

type ListEventTargetsRequest struct {
  // The name of the event bus with which the event target is associated.
  // 
  // This parameter is required.
  // 
  // example:
  // 
  // my-event-bus
  EventBusName *string `json:"eventBusName,omitempty" xml:"eventBusName,omitempty"`
  // The name of the event rule.
  // 
  // This parameter is required.
  // 
  // example:
  // 
  // myrabbitmq.sourc
  EventRuleName *string `json:"eventRuleName,omitempty" xml:"eventRuleName,omitempty"`
}

func (s ListEventTargetsRequest) String() string {
  return tea.Prettify(s)
}

func (s ListEventTargetsRequest) GoString() string {
  return s.String()
}

func (s *ListEventTargetsRequest) SetEventBusName(v string) *ListEventTargetsRequest {
  s.EventBusName = &v
  return s
}

func (s *ListEventTargetsRequest) SetEventRuleName(v string) *ListEventTargetsRequest {
  s.EventRuleName = &v
  return s
}

type ListEventTargetsResponseBody struct {
  // The name of the event bus with which the event target is associated.
  // 
  // This parameter is required.
  // 
  // example:
  // 
  // my-event-bus
  EventBusName *string `json:"eventBusName,omitempty" xml:"eventBusName,omitempty"`
  // The name of the event rule.
  // 
  // This parameter is required.
  // 
  // example:
  // 
  // myrabbitmq.sourc
  EventRuleName *string `json:"eventRuleName,omitempty" xml:"eventRuleName,omitempty"`
  EventTargets []*ListEventTargetsResponseBodyEventTargets `json:"eventTargets,omitempty" xml:"eventTargets,omitempty" type:"Repeated"`
}

func (s ListEventTargetsResponseBody) String() string {
  return tea.Prettify(s)
}

func (s ListEventTargetsResponseBody) GoString() string {
  return s.String()
}

func (s *ListEventTargetsResponseBody) SetEventBusName(v string) *ListEventTargetsResponseBody {
  s.EventBusName = &v
  return s
}

func (s *ListEventTargetsResponseBody) SetEventRuleName(v string) *ListEventTargetsResponseBody {
  s.EventRuleName = &v
  return s
}

func (s *ListEventTargetsResponseBody) SetEventTargets(v []*ListEventTargetsResponseBodyEventTargets) *ListEventTargetsResponseBody {
  s.EventTargets = v
  return s
}

type ListEventTargetsResponseBodyEventTargets struct     {
  EventTargetName *string `json:"eventTargetName,omitempty" xml:"eventTargetName,omitempty"`
  ClassName *string `json:"className,omitempty" xml:"className,omitempty"`
  Config map[string]interface{} `json:"config,omitempty" xml:"config,omitempty"`
  RunOptions *ListEventTargetsResponseBodyEventTargetsRunOptions `json:"runOptions,omitempty" xml:"runOptions,omitempty" type:"Struct"`
}

func (s ListEventTargetsResponseBodyEventTargets) String() string {
  return tea.Prettify(s)
}

func (s ListEventTargetsResponseBodyEventTargets) GoString() string {
  return s.String()
}

func (s *ListEventTargetsResponseBodyEventTargets) SetEventTargetName(v string) *ListEventTargetsResponseBodyEventTargets {
  s.EventTargetName = &v
  return s
}

func (s *ListEventTargetsResponseBodyEventTargets) SetClassName(v string) *ListEventTargetsResponseBodyEventTargets {
  s.ClassName = &v
  return s
}

func (s *ListEventTargetsResponseBodyEventTargets) SetConfig(v map[string]interface{}) *ListEventTargetsResponseBodyEventTargets {
  s.Config = v
  return s
}

func (s *ListEventTargetsResponseBodyEventTargets) SetRunOptions(v *ListEventTargetsResponseBodyEventTargetsRunOptions) *ListEventTargetsResponseBodyEventTargets {
  s.RunOptions = v
  return s
}

type ListEventTargetsResponseBodyEventTargetsRunOptions struct {
  ErrorsTolerance *string `json:"errorsTolerance,omitempty" xml:"errorsTolerance,omitempty"`
  RetryStrategy *ListEventTargetsResponseBodyEventTargetsRunOptionsRetryStrategy `json:"retryStrategy,omitempty" xml:"retryStrategy,omitempty" type:"Struct"`
  DeadLetterQueue *ListEventTargetsResponseBodyEventTargetsRunOptionsDeadLetterQueue `json:"deadLetterQueue,omitempty" xml:"deadLetterQueue,omitempty" type:"Struct"`
}

func (s ListEventTargetsResponseBodyEventTargetsRunOptions) String() string {
  return tea.Prettify(s)
}

func (s ListEventTargetsResponseBodyEventTargetsRunOptions) GoString() string {
  return s.String()
}

func (s *ListEventTargetsResponseBodyEventTargetsRunOptions) SetErrorsTolerance(v string) *ListEventTargetsResponseBodyEventTargetsRunOptions {
  s.ErrorsTolerance = &v
  return s
}

func (s *ListEventTargetsResponseBodyEventTargetsRunOptions) SetRetryStrategy(v *ListEventTargetsResponseBodyEventTargetsRunOptionsRetryStrategy) *ListEventTargetsResponseBodyEventTargetsRunOptions {
  s.RetryStrategy = v
  return s
}

func (s *ListEventTargetsResponseBodyEventTargetsRunOptions) SetDeadLetterQueue(v *ListEventTargetsResponseBodyEventTargetsRunOptionsDeadLetterQueue) *ListEventTargetsResponseBodyEventTargetsRunOptions {
  s.DeadLetterQueue = v
  return s
}

type ListEventTargetsResponseBodyEventTargetsRunOptionsRetryStrategy struct {
  PushRetryStrategy *string `json:"pushRetryStrategy,omitempty" xml:"pushRetryStrategy,omitempty"`
  MaximumEventAgeInSeconds *int32 `json:"maximumEventAgeInSeconds,omitempty" xml:"maximumEventAgeInSeconds,omitempty"`
  MaximumRetryAttempts *int32 `json:"maximumRetryAttempts,omitempty" xml:"maximumRetryAttempts,omitempty"`
}

func (s ListEventTargetsResponseBodyEventTargetsRunOptionsRetryStrategy) String() string {
  return tea.Prettify(s)
}

func (s ListEventTargetsResponseBodyEventTargetsRunOptionsRetryStrategy) GoString() string {
  return s.String()
}

func (s *ListEventTargetsResponseBodyEventTargetsRunOptionsRetryStrategy) SetPushRetryStrategy(v string) *ListEventTargetsResponseBodyEventTargetsRunOptionsRetryStrategy {
  s.PushRetryStrategy = &v
  return s
}

func (s *ListEventTargetsResponseBodyEventTargetsRunOptionsRetryStrategy) SetMaximumEventAgeInSeconds(v int32) *ListEventTargetsResponseBodyEventTargetsRunOptionsRetryStrategy {
  s.MaximumEventAgeInSeconds = &v
  return s
}

func (s *ListEventTargetsResponseBodyEventTargetsRunOptionsRetryStrategy) SetMaximumRetryAttempts(v int32) *ListEventTargetsResponseBodyEventTargetsRunOptionsRetryStrategy {
  s.MaximumRetryAttempts = &v
  return s
}

type ListEventTargetsResponseBodyEventTargetsRunOptionsDeadLetterQueue struct {
  Type *string `json:"type,omitempty" xml:"type,omitempty"`
  Config map[string]interface{} `json:"config,omitempty" xml:"config,omitempty"`
}

func (s ListEventTargetsResponseBodyEventTargetsRunOptionsDeadLetterQueue) String() string {
  return tea.Prettify(s)
}

func (s ListEventTargetsResponseBodyEventTargetsRunOptionsDeadLetterQueue) GoString() string {
  return s.String()
}

func (s *ListEventTargetsResponseBodyEventTargetsRunOptionsDeadLetterQueue) SetType(v string) *ListEventTargetsResponseBodyEventTargetsRunOptionsDeadLetterQueue {
  s.Type = &v
  return s
}

func (s *ListEventTargetsResponseBodyEventTargetsRunOptionsDeadLetterQueue) SetConfig(v map[string]interface{}) *ListEventTargetsResponseBodyEventTargetsRunOptionsDeadLetterQueue {
  s.Config = v
  return s
}

type ListEventTargetsResponse struct {
  Headers map[string]*string `json:"headers,omitempty" xml:"headers,omitempty"`
  StatusCode *int32 `json:"statusCode,omitempty" xml:"statusCode,omitempty"`
  Body *ListEventTargetsResponseBody `json:"body,omitempty" xml:"body,omitempty"`
}

func (s ListEventTargetsResponse) String() string {
  return tea.Prettify(s)
}

func (s ListEventTargetsResponse) GoString() string {
  return s.String()
}

func (s *ListEventTargetsResponse) SetHeaders(v map[string]*string) *ListEventTargetsResponse {
  s.Headers = v
  return s
}

func (s *ListEventTargetsResponse) SetStatusCode(v int32) *ListEventTargetsResponse {
  s.StatusCode = &v
  return s
}

func (s *ListEventTargetsResponse) SetBody(v *ListEventTargetsResponseBody) *ListEventTargetsResponse {
  s.Body = v
  return s
}

// Description:
// 
// EventType Controller apis:
// 
// listEventTypes *
type ListEventTypesRequest struct {
  // The name of the event bus.
  // 
  // This parameter is required.
  // 
  // example:
  // 
  // demo
  EventBusName *string `json:"eventBusName,omitempty" xml:"eventBusName,omitempty"`
  // EventSource is required for querying default bus events.
  // 
  // example:
  // 
  // testEventSourceName
  EventSourceName *string `json:"eventSourceName,omitempty" xml:"eventSourceName,omitempty"`
  // The number of entries returned per page.
  // 
  // example:
  // 
  // 10
  MaxResults *int32 `json:"maxResults,omitempty" xml:"maxResults,omitempty"`
  // If excess return values exist, this parameter is returned.
  // 
  // example:
  // 
  // 0
  NextToken *string `json:"nextToken,omitempty" xml:"nextToken,omitempty"`
}

func (s ListEventTypesRequest) String() string {
  return tea.Prettify(s)
}

func (s ListEventTypesRequest) GoString() string {
  return s.String()
}

func (s *ListEventTypesRequest) SetEventBusName(v string) *ListEventTypesRequest {
  s.EventBusName = &v
  return s
}

func (s *ListEventTypesRequest) SetEventSourceName(v string) *ListEventTypesRequest {
  s.EventSourceName = &v
  return s
}

func (s *ListEventTypesRequest) SetMaxResults(v int32) *ListEventTypesRequest {
  s.MaxResults = &v
  return s
}

func (s *ListEventTypesRequest) SetNextToken(v string) *ListEventTypesRequest {
  s.NextToken = &v
  return s
}

type ListEventTypesResponseBody struct {
  EventTypes []*ListEventTypesResponseBodyEventTypes `json:"eventTypes,omitempty" xml:"eventTypes,omitempty" type:"Repeated"`
  // If excess return values exist, this parameter is returned.
  // 
  // example:
  // 
  // 10
  NextToken *string `json:"nextToken,omitempty" xml:"nextToken,omitempty"`
  // The total number of entries.
  // 
  // example:
  // 
  // 2
  Total *int `json:"total,omitempty" xml:"total,omitempty"`
  // If you set Limit and excess return values exist, this parameter is returned.
  // 
  // example:
  // 
  // 10
  MaxResults *int32 `json:"maxResults,omitempty" xml:"maxResults,omitempty"`
  // The status code returned. The status code 200 indicates that the request was successful.
  // 
  // example:
  // 
  // 200
  Code *string `json:"code,omitempty" xml:"code,omitempty"`
  // The error message that is returned if the request failed.
  // 
  // example:
  // 
  // EventBusNotExist
  Message *string `json:"message,omitempty" xml:"message,omitempty"`
  // The request ID.
  // 
  // example:
  // 
  // 580A938B-6107-586C-8EC7-F22EEBEDA9E6
  RequestId *string `json:"requestId,omitempty" xml:"requestId,omitempty"`
}

func (s ListEventTypesResponseBody) String() string {
  return tea.Prettify(s)
}

func (s ListEventTypesResponseBody) GoString() string {
  return s.String()
}

func (s *ListEventTypesResponseBody) SetEventTypes(v []*ListEventTypesResponseBodyEventTypes) *ListEventTypesResponseBody {
  s.EventTypes = v
  return s
}

func (s *ListEventTypesResponseBody) SetNextToken(v string) *ListEventTypesResponseBody {
  s.NextToken = &v
  return s
}

func (s *ListEventTypesResponseBody) SetTotal(v int) *ListEventTypesResponseBody {
  s.Total = &v
  return s
}

func (s *ListEventTypesResponseBody) SetMaxResults(v int32) *ListEventTypesResponseBody {
  s.MaxResults = &v
  return s
}

func (s *ListEventTypesResponseBody) SetCode(v string) *ListEventTypesResponseBody {
  s.Code = &v
  return s
}

func (s *ListEventTypesResponseBody) SetMessage(v string) *ListEventTypesResponseBody {
  s.Message = &v
  return s
}

func (s *ListEventTypesResponseBody) SetRequestId(v string) *ListEventTypesResponseBody {
  s.RequestId = &v
  return s
}

type ListEventTypesResponseBodyEventTypes struct     {
  // The name of the event bus.
  // 
  // This parameter is required.
  // 
  // example:
  // 
  // demo
  EventBusName *string `json:"eventBusName,omitempty" xml:"eventBusName,omitempty"`
  // EventSource is required for querying default bus events.
  // 
  // example:
  // 
  // testEventSourceName
  EventSourceName *string `json:"eventSourceName,omitempty" xml:"eventSourceName,omitempty"`
  // The name of the event type.
  EventTypeName *string `json:"eventTypeName,omitempty" xml:"eventTypeName,omitempty"`
  // The description of the event type.
  // 
  // example:
  // 
  // The description of the event type.
  Description *string `json:"description,omitempty" xml:"description,omitempty"`
  GmtCreate *string `json:"gmtCreate,omitempty" xml:"gmtCreate,omitempty"`
  GmtModify *string `json:"gmtModify,omitempty" xml:"gmtModify,omitempty"`
}

func (s ListEventTypesResponseBodyEventTypes) String() string {
  return tea.Prettify(s)
}

func (s ListEventTypesResponseBodyEventTypes) GoString() string {
  return s.String()
}

func (s *ListEventTypesResponseBodyEventTypes) SetEventBusName(v string) *ListEventTypesResponseBodyEventTypes {
  s.EventBusName = &v
  return s
}

func (s *ListEventTypesResponseBodyEventTypes) SetEventSourceName(v string) *ListEventTypesResponseBodyEventTypes {
  s.EventSourceName = &v
  return s
}

func (s *ListEventTypesResponseBodyEventTypes) SetEventTypeName(v string) *ListEventTypesResponseBodyEventTypes {
  s.EventTypeName = &v
  return s
}

func (s *ListEventTypesResponseBodyEventTypes) SetDescription(v string) *ListEventTypesResponseBodyEventTypes {
  s.Description = &v
  return s
}

func (s *ListEventTypesResponseBodyEventTypes) SetGmtCreate(v string) *ListEventTypesResponseBodyEventTypes {
  s.GmtCreate = &v
  return s
}

func (s *ListEventTypesResponseBodyEventTypes) SetGmtModify(v string) *ListEventTypesResponseBodyEventTypes {
  s.GmtModify = &v
  return s
}

type ListEventTypesResponse struct {
  Headers map[string]*string `json:"headers,omitempty" xml:"headers,omitempty"`
  StatusCode *int32 `json:"statusCode,omitempty" xml:"statusCode,omitempty"`
  Body *ListEventTypesResponseBody `json:"body,omitempty" xml:"body,omitempty"`
}

func (s ListEventTypesResponse) String() string {
  return tea.Prettify(s)
}

func (s ListEventTypesResponse) GoString() string {
  return s.String()
}

func (s *ListEventTypesResponse) SetHeaders(v map[string]*string) *ListEventTypesResponse {
  s.Headers = v
  return s
}

func (s *ListEventTypesResponse) SetStatusCode(v int32) *ListEventTypesResponse {
  s.StatusCode = &v
  return s
}

func (s *ListEventTypesResponse) SetBody(v *ListEventTypesResponseBody) *ListEventTypesResponse {
  s.Body = v
  return s
}

type ClientInterface interface {
  GetEndpoint (productId *string, regionId *string, endpointRule *string, network *string, suffix *string, endpointMap map[string]*string, endpoint *string) (_result *string, _err error) 
  CreateEventBusWithOptions (request *CreateEventBusRequest, runtime *util.RuntimeOptions) (_result *CreateEventBusResponse, _err error) 
  CreateEventBus (request *CreateEventBusRequest) (_result *CreateEventBusResponse, _err error) 
  GetEventBusWithOptions (request *GetEventBusRequest, runtime *util.RuntimeOptions) (_result *GetEventBusResponse, _err error) 
  GetEventBus (request *GetEventBusRequest) (_result *GetEventBusResponse, _err error) 
  ListEventBusesWithOptions (request *ListEventBusesRequest, runtime *util.RuntimeOptions) (_result *ListEventBusesResponse, _err error) 
  ListEventBuses (request *ListEventBusesRequest) (_result *ListEventBusesResponse, _err error) 
  DeleteEventBusWithOptions (request *DeleteEventBusRequest, runtime *util.RuntimeOptions) (_result *DeleteEventBusResponse, _err error) 
  DeleteEventBus (request *DeleteEventBusRequest) (_result *DeleteEventBusResponse, _err error) 
  CreateApiDestinationWithOptions (request *CreateApiDestinationRequest, runtime *util.RuntimeOptions) (_result *CreateApiDestinationResponse, _err error) 
  CreateApiDestination (request *CreateApiDestinationRequest) (_result *CreateApiDestinationResponse, _err error) 
  UpdateApiDestinationWithOptions (request *UpdateApiDestinationRequest, runtime *util.RuntimeOptions) (_result *UpdateApiDestinationResponse, _err error) 
  UpdateApiDestination (request *UpdateApiDestinationRequest) (_result *UpdateApiDestinationResponse, _err error) 
  GetApiDestinationWithOptions (request *GetApiDestinationRequest, runtime *util.RuntimeOptions) (_result *GetApiDestinationResponse, _err error) 
  GetApiDestination (request *GetApiDestinationRequest) (_result *GetApiDestinationResponse, _err error) 
  DeleteApiDestinationWithOptions (request *DeleteApiDestinationRequest, runtime *util.RuntimeOptions) (_result *DeleteApiDestinationResponse, _err error) 
  DeleteApiDestination (request *DeleteApiDestinationRequest) (_result *DeleteApiDestinationResponse, _err error) 
  ListApiDestinationsWithOptions (request *ListApiDestinationsRequest, runtime *util.RuntimeOptions) (_result *ListApiDestinationsResponse, _err error) 
  ListApiDestinations (request *ListApiDestinationsRequest) (_result *ListApiDestinationsResponse, _err error) 
  CreateConnectionWithOptions (request *CreateConnectionRequest, runtime *util.RuntimeOptions) (_result *CreateConnectionResponse, _err error) 
  CreateConnection (request *CreateConnectionRequest) (_result *CreateConnectionResponse, _err error) 
  DeleteConnectionWithOptions (request *DeleteConnectionRequest, runtime *util.RuntimeOptions) (_result *DeleteConnectionResponse, _err error) 
  DeleteConnection (request *DeleteConnectionRequest) (_result *DeleteConnectionResponse, _err error) 
  UpdateConnectionWithOptions (request *UpdateConnectionRequest, runtime *util.RuntimeOptions) (_result *UpdateConnectionResponse, _err error) 
  UpdateConnection (request *UpdateConnectionRequest) (_result *UpdateConnectionResponse, _err error) 
  GetConnectionWithOptions (request *GetConnectionRequest, runtime *util.RuntimeOptions) (_result *GetConnectionResponse, _err error) 
  GetConnection (request *GetConnectionRequest) (_result *GetConnectionResponse, _err error) 
  SelectOneConnectionWithOptions (request *GetConnectionRequest, runtime *util.RuntimeOptions) (_result *GetConnectionResponse, _err error) 
  SelectOneConnection (request *GetConnectionRequest) (_result *GetConnectionResponse, _err error) 
  ListConnectionsWithOptions (request *ListConnectionsRequest, runtime *util.RuntimeOptions) (_result *ListConnectionsResponse, _err error) 
  ListConnections (request *ListConnectionsRequest) (_result *ListConnectionsResponse, _err error) 
  ListEnumsResponse () (_result *ListEnumsResponseResponse, _err error) 
  PutEventsWithOptions (request *PutEventsRequest, runtime *util.RuntimeOptions) (_result *PutEventsResponse, _err error) 
  PutEvents (request *PutEventsRequest) (_result *PutEventsResponse, _err error) 
  CreateEventRuleWithOptions (request *CreateEventRuleRequest, runtime *util.RuntimeOptions) (_result *CreateEventRuleResponse, _err error) 
  CreateEventRule (request *CreateEventRuleRequest) (_result *CreateEventRuleResponse, _err error) 
  GetEventRuleWithOptions (request *GetEventRuleRequest, runtime *util.RuntimeOptions) (_result *GetEventRuleResponse, _err error) 
  GetEventRule (request *GetEventRuleRequest) (_result *GetEventRuleResponse, _err error) 
  DeleteEventRuleWithOptions (request *DeleteEventRuleRequest, runtime *util.RuntimeOptions) (_result *DeleteEventRuleResponse, _err error) 
  DeleteEventRule (request *DeleteEventRuleRequest) (_result *DeleteEventRuleResponse, _err error) 
  UpdateEventRuleWithOptions (request *UpdateEventRuleRequest, runtime *util.RuntimeOptions) (_result *UpdateEventRuleResponse, _err error) 
  UpdateEventRule (request *UpdateEventRuleRequest) (_result *UpdateEventRuleResponse, _err error) 
  ListEventRulesWithOptions (request *ListEventRulesRequest, runtime *util.RuntimeOptions) (_result *ListEventRulesResponse, _err error) 
  ListEventRules (request *ListEventRulesRequest) (_result *ListEventRulesResponse, _err error) 
  EnableEventRuleWithOptions (request *EnableEventRuleRequest, runtime *util.RuntimeOptions) (_result *EnableEventRuleResponse, _err error) 
  EnableEventRule (request *EnableEventRuleRequest) (_result *EnableEventRuleResponse, _err error) 
  DisableEventRuleWithOptions (request *DisableEventRuleRequest, runtime *util.RuntimeOptions) (_result *DisableEventRuleResponse, _err error) 
  DisableEventRule (request *DisableEventRuleRequest) (_result *DisableEventRuleResponse, _err error) 
  CreateEventSourceWithOptions (request *CreateEventSourceRequest, runtime *util.RuntimeOptions) (_result *CreateEventSourceResponse, _err error) 
  CreateEventSource (request *CreateEventSourceRequest) (_result *CreateEventSourceResponse, _err error) 
  UpdateEventSourceWithOptions (request *UpdateEventSourceRequest, runtime *util.RuntimeOptions) (_result *UpdateEventSourceResponse, _err error) 
  UpdateEventSource (request *UpdateEventSourceRequest) (_result *UpdateEventSourceResponse, _err error) 
  DeleteEventSourceWithOptions (request *DeleteEventSourceRequest, runtime *util.RuntimeOptions) (_result *DeleteEventSourceResponse, _err error) 
  DeleteEventSource (request *DeleteEventSourceRequest) (_result *DeleteEventSourceResponse, _err error) 
  GetEventSourceWithOptions (request *GetEventSourceRequest, runtime *util.RuntimeOptions) (_result *GetEventSourceResponse, _err error) 
  GetEventSource (request *GetEventSourceRequest) (_result *GetEventSourceResponse, _err error) 
  ListEventSourcesWithOptions (request *ListEventSourcesRequest, runtime *util.RuntimeOptions) (_result *ListEventSourcesResponse, _err error) 
  ListEventSources (request *ListEventSourcesRequest) (_result *ListEventSourcesResponse, _err error) 
  CreateEventTargetsWithOptions (request *CreateEventTargetsRequest, runtime *util.RuntimeOptions) (_result *CreateEventTargetsResponse, _err error) 
  CreateEventTargets (request *CreateEventTargetsRequest) (_result *CreateEventTargetsResponse, _err error) 
  UpdateEventTargetsWithOptions (request *UpdateEventTargetsRequest, runtime *util.RuntimeOptions) (_result *UpdateEventTargetsResponse, _err error) 
  UpdateEventTargets (request *UpdateEventTargetsRequest) (_result *UpdateEventTargetsResponse, _err error) 
  DeleteEventTargetsWithOptions (request *DeleteEventTargetsRequest, runtime *util.RuntimeOptions) (_result *DeleteEventTargetsResponse, _err error) 
  DeleteEventTargets (request *DeleteEventTargetsRequest) (_result *DeleteEventTargetsResponse, _err error) 
  ListEventTargetsWithOptions (request *ListEventTargetsRequest, runtime *util.RuntimeOptions) (_result *ListEventTargetsResponse, _err error) 
  ListEventTargets (request *ListEventTargetsRequest) (_result *ListEventTargetsResponse, _err error) 
  ListEventTypesWithOptions (request *ListEventTypesRequest, runtime *util.RuntimeOptions) (_result *ListEventTypesResponse, _err error) 
  ListEventTypes (request *ListEventTypesRequest) (_result *ListEventTypesResponse, _err error) 
}

type Client struct {
  openapi.Client
}

func NewClient(config *openapi.Config)(*Client, error) {
  client := new(Client)
  err := client.Init(config)
  return client, err
}

func (client *Client)Init(config *openapi.Config)(_err error) {
  _err = client.Client.Init(config  )
  if _err != nil {
    return _err
  }
  client.EndpointRule = tea.String("")
  _err = client.CheckConfig(config)
  if _err != nil {
    return _err
  }
  client.Endpoint, _err = client.GetEndpoint(tea.String("eventbridge"), client.RegionId, client.EndpointRule, client.Network, client.Suffix, client.EndpointMap, client.Endpoint)
  if _err != nil {
    return _err
  }

  return nil
}



func (client *Client) GetEndpoint (productId *string, regionId *string, endpointRule *string, network *string, suffix *string, endpointMap map[string]*string, endpoint *string) (_result *string, _err error) {
  if !tea.BoolValue(util.Empty(endpoint)) {
    _result = endpoint
    return _result , _err
  }

  if !tea.BoolValue(util.IsUnset(endpointMap)) && !tea.BoolValue(util.Empty(endpointMap[tea.StringValue(regionId)])) {
    _result = endpointMap[tea.StringValue(regionId)]
    return _result, _err
  }

  result := tea.String("")
  if !tea.BoolValue(util.Empty(network)) && !tea.BoolValue(util.EqualString(network, tea.String("public"))) {
    network = tea.String("-" + tea.StringValue(network))
  } else {
    network = tea.String("")
  }

  if !tea.BoolValue(util.IsUnset(suffix)) {
    suffix = tea.String("")
  } else {
    suffix = tea.String("-" + tea.StringValue(suffix))
  }

  if tea.BoolValue(util.EqualString(endpointRule, tea.String("regional"))) {
    if tea.BoolValue(util.Empty(regionId)) {
      _err = tea.NewSDKError(map[string]interface{}{
        "message": "RegionId is empty, please set a valid RegionId",
      })
      return _result, _err
    }

    result = tea.String(tea.StringValue(productId) + tea.StringValue(suffix) + tea.StringValue(network) + "." + tea.StringValue(regionId) + ".aliyuncs.com")
  } else {
    result = tea.String(tea.StringValue(productId) + tea.StringValue(suffix) + tea.StringValue(network) + ".aliyuncs.com")
  }

  _result = result
  return _result , _err
  // return EndpointUtil.getEndpointRules(productId, regionId, endpointRule, network, suffix);
}

// Summary:
// 
// Creates an event bus.
// 
// Description:
// 
// You can call this API operation to create an event bus.
// 
// @param request - CreateEventBusRequest
// 
// @param runtime - runtime options for this request RuntimeOptions
// 
// @return CreateEventBusResponse
func (client *Client) CreateEventBusWithOptions (request *CreateEventBusRequest, runtime *util.RuntimeOptions) (_result *CreateEventBusResponse, _err error) {
  _err = util.ValidateModel(request)
  if _err != nil {
    return _result, _err
  }
  body := map[string]interface{}{}
  if !tea.BoolValue(util.IsUnset(request.Description)) {
    body["description"] = request.Description
  }

  if !tea.BoolValue(util.IsUnset(request.EventBusName)) {
    body["eventBusName"] = request.EventBusName
  }

  req := &openapi.OpenApiRequest{
    Body: util.ToJSONString(body),
  }
  params := &openapi.Params{
    Action: tea.String("CreateEventBus"),
    Version: tea.String("2024-07-01"),
    Protocol: tea.String("HTTP"),
    Pathname: tea.String("/bus/createEventBus"),
    Method: tea.String("POST"),
    AuthType: tea.String("Anonymous"),
    Style: tea.String("RPC"),
    ReqBodyType: tea.String("json"),
    BodyType: tea.String("json"),
  }
  _result = &CreateEventBusResponse{}
  _body, _err := client.CallApi(params, req, runtime)
  if _err != nil {
    return _result, _err
  }
  _err = tea.Convert(_body, &_result)
  return _result, _err
}

// Summary:
// 
// Creates an event bus.
// 
// Description:
// 
// You can call this API operation to create an event bus.
// 
// @param request - CreateEventBusRequest
// 
// @return CreateEventBusResponse
func (client *Client) CreateEventBus (request *CreateEventBusRequest) (_result *CreateEventBusResponse, _err error) {
  runtime := &util.RuntimeOptions{}
  _result = &CreateEventBusResponse{}
  _body, _err := client.CreateEventBusWithOptions(request, runtime)
  if _err != nil {
    return _result, _err
  }
  _result = _body
  return _result, _err
}

// Summary:
// 
// Queries the detailed information about an event bus.
// 
// Description:
// 
// You can call this API operation to query the detailed information about an event bus.
// 
// @param request - GetEventBusRequest
// 
// @param runtime - runtime options for this request RuntimeOptions
// 
// @return GetEventBusResponse
func (client *Client) GetEventBusWithOptions (request *GetEventBusRequest, runtime *util.RuntimeOptions) (_result *GetEventBusResponse, _err error) {
  _err = util.ValidateModel(request)
  if _err != nil {
    return _result, _err
  }
  body := map[string]interface{}{}
  if !tea.BoolValue(util.IsUnset(request.EventBusName)) {
    body["eventBusName"] = request.EventBusName
  }

  req := &openapi.OpenApiRequest{
    Body: util.ToJSONString(body),
  }
  params := &openapi.Params{
    Action: tea.String("GetEventBus"),
    Version: tea.String("2024-07-01"),
    Protocol: tea.String("HTTP"),
    Pathname: tea.String("/bus/getEventBus"),
    Method: tea.String("POST"),
    AuthType: tea.String("Anonymous"),
    Style: tea.String("RPC"),
    ReqBodyType: tea.String("json"),
    BodyType: tea.String("json"),
  }
  _result = &GetEventBusResponse{}
  _body, _err := client.CallApi(params, req, runtime)
  if _err != nil {
    return _result, _err
  }
  _err = tea.Convert(_body, &_result)
  return _result, _err
}

// Summary:
// 
// Queries the detailed information about an event bus.
// 
// Description:
// 
// You can call this API operation to query the detailed information about an event bus.
// 
// @param request - GetEventBusRequest
// 
// @return GetEventBusResponse
func (client *Client) GetEventBus (request *GetEventBusRequest) (_result *GetEventBusResponse, _err error) {
  runtime := &util.RuntimeOptions{}
  _result = &GetEventBusResponse{}
  _body, _err := client.GetEventBusWithOptions(request, runtime)
  if _err != nil {
    return _result, _err
  }
  _result = _body
  return _result, _err
}

// Summary:
// 
// Queries all event buses.
// 
// Description:
// 
// You can call this API operation to query all event buses.
// 
// @param request - ListEventBusesRequest
// 
// @param runtime - runtime options for this request RuntimeOptions
// 
// @return ListEventBusesResponse
func (client *Client) ListEventBusesWithOptions (request *ListEventBusesRequest, runtime *util.RuntimeOptions) (_result *ListEventBusesResponse, _err error) {
  _err = util.ValidateModel(request)
  if _err != nil {
    return _result, _err
  }
  body := map[string]interface{}{}
  if !tea.BoolValue(util.IsUnset(request.MaxResults)) {
    body["maxResults"] = request.MaxResults
  }

  if !tea.BoolValue(util.IsUnset(request.NextToken)) {
    body["nextToken"] = request.NextToken
  }

  req := &openapi.OpenApiRequest{
    Body: util.ToJSONString(body),
  }
  params := &openapi.Params{
    Action: tea.String("ListEventBuses"),
    Version: tea.String("2024-07-01"),
    Protocol: tea.String("HTTP"),
    Pathname: tea.String("/bus/listEventBuses"),
    Method: tea.String("POST"),
    AuthType: tea.String("Anonymous"),
    Style: tea.String("RPC"),
    ReqBodyType: tea.String("json"),
    BodyType: tea.String("json"),
  }
  _result = &ListEventBusesResponse{}
  _body, _err := client.CallApi(params, req, runtime)
  if _err != nil {
    return _result, _err
  }
  _err = tea.Convert(_body, &_result)
  return _result, _err
}

// Summary:
// 
// Queries all event buses.
// 
// Description:
// 
// You can call this API operation to query all event buses.
// 
// @param request - ListEventBusesRequest
// 
// @return ListEventBusesResponse
func (client *Client) ListEventBuses (request *ListEventBusesRequest) (_result *ListEventBusesResponse, _err error) {
  runtime := &util.RuntimeOptions{}
  _result = &ListEventBusesResponse{}
  _body, _err := client.ListEventBusesWithOptions(request, runtime)
  if _err != nil {
    return _result, _err
  }
  _result = _body
  return _result, _err
}

// Summary:
// 
// Deletes an event bus.
// 
// Description:
// 
// You can call this API operation to delete an event bus.
// 
// @param request - DeleteEventBusRequest
// 
// @param runtime - runtime options for this request RuntimeOptions
// 
// @return DeleteEventBusResponse
func (client *Client) DeleteEventBusWithOptions (request *DeleteEventBusRequest, runtime *util.RuntimeOptions) (_result *DeleteEventBusResponse, _err error) {
  _err = util.ValidateModel(request)
  if _err != nil {
    return _result, _err
  }
  body := map[string]interface{}{}
  if !tea.BoolValue(util.IsUnset(request.EventBusName)) {
    body["eventBusName"] = request.EventBusName
  }

  req := &openapi.OpenApiRequest{
    Body: util.ToJSONString(body),
  }
  params := &openapi.Params{
    Action: tea.String("DeleteEventBus"),
    Version: tea.String("2024-07-01"),
    Protocol: tea.String("HTTP"),
    Pathname: tea.String("/bus/deleteEventBus"),
    Method: tea.String("POST"),
    AuthType: tea.String("Anonymous"),
    Style: tea.String("RPC"),
    ReqBodyType: tea.String("json"),
    BodyType: tea.String("json"),
  }
  _result = &DeleteEventBusResponse{}
  _body, _err := client.CallApi(params, req, runtime)
  if _err != nil {
    return _result, _err
  }
  _err = tea.Convert(_body, &_result)
  return _result, _err
}

// Summary:
// 
// Deletes an event bus.
// 
// Description:
// 
// You can call this API operation to delete an event bus.
// 
// @param request - DeleteEventBusRequest
// 
// @return DeleteEventBusResponse
func (client *Client) DeleteEventBus (request *DeleteEventBusRequest) (_result *DeleteEventBusResponse, _err error) {
  runtime := &util.RuntimeOptions{}
  _result = &DeleteEventBusResponse{}
  _body, _err := client.DeleteEventBusWithOptions(request, runtime)
  if _err != nil {
    return _result, _err
  }
  _result = _body
  return _result, _err
}

// Summary:
// 
// Creates an API destination.
// 
// Description:
// 
// You can call this API operation to create an API destination.
// 
// @param request - CreateApiDestinationRequest (tmpReq before)
// 
// @param runtime - runtime options for this request RuntimeOptions
// 
// @return CreateApiDestinationResponse
func (client *Client) CreateApiDestinationWithOptions (request *CreateApiDestinationRequest, runtime *util.RuntimeOptions) (_result *CreateApiDestinationResponse, _err error) {
  _err = util.ValidateModel(request)
  if _err != nil {
    return _result, _err
  }
  body := map[string]interface{}{}
  if !tea.BoolValue(util.IsUnset(request.ApiDestinationName)) {
    body["apiDestinationName"] = request.ApiDestinationName
  }

  if !tea.BoolValue(util.IsUnset(request.ConnectionName)) {
    body["connectionName"] = request.ConnectionName
  }

  if !tea.BoolValue(util.IsUnset(request.Description)) {
    body["description"] = request.Description
  }

  if !tea.BoolValue(util.IsUnset(request.HttpApiParameters)) {
    body["httpApiParameters"] = request.HttpApiParameters
  }

  if !tea.BoolValue(util.IsUnset(request.InvocationRateLimitPerSecond)) {
    body["invocationRateLimitPerSecond"] = request.InvocationRateLimitPerSecond
  }

  req := &openapi.OpenApiRequest{
    Body: util.ToJSONString(body),
  }
  params := &openapi.Params{
    Action: tea.String("CreateApiDestination"),
    Version: tea.String("2024-07-01"),
    Protocol: tea.String("HTTP"),
    Pathname: tea.String("/api-destination/createApiDestination"),
    Method: tea.String("POST"),
    AuthType: tea.String("Anonymous"),
    Style: tea.String("RPC"),
    ReqBodyType: tea.String("json"),
    BodyType: tea.String("json"),
  }
  _result = &CreateApiDestinationResponse{}
  _body, _err := client.CallApi(params, req, runtime)
  if _err != nil {
    return _result, _err
  }
  _err = tea.Convert(_body, &_result)
  return _result, _err
}

// Summary:
// 
// Creates an API destination.
// 
// Description:
// 
// You can call this API operation to create an API destination.
// 
// @param request - CreateApiDestinationRequest
// 
// @return CreateApiDestinationResponse
func (client *Client) CreateApiDestination (request *CreateApiDestinationRequest) (_result *CreateApiDestinationResponse, _err error) {
  runtime := &util.RuntimeOptions{}
  _result = &CreateApiDestinationResponse{}
  _body, _err := client.CreateApiDestinationWithOptions(request, runtime)
  if _err != nil {
    return _result, _err
  }
  _result = _body
  return _result, _err
}

// Summary:
// 
// Updates an API destination.
// 
// Description:
// 
// You can call this API operation to update an API destination.
// 
// @param request - UpdateApiDestinationRequest
// 
// @param runtime - runtime options for this request RuntimeOptions
// 
// @return UpdateApiDestinationResponse
func (client *Client) UpdateApiDestinationWithOptions (request *UpdateApiDestinationRequest, runtime *util.RuntimeOptions) (_result *UpdateApiDestinationResponse, _err error) {
  _err = util.ValidateModel(request)
  if _err != nil {
    return _result, _err
  }
  body := map[string]interface{}{}
  if !tea.BoolValue(util.IsUnset(request.ApiDestinationName)) {
    body["apiDestinationName"] = request.ApiDestinationName
  }

  if !tea.BoolValue(util.IsUnset(request.ConnectionName)) {
    body["connectionName"] = request.ConnectionName
  }

  if !tea.BoolValue(util.IsUnset(request.Description)) {
    body["description"] = request.Description
  }

  if !tea.BoolValue(util.IsUnset(request.HttpApiParameters)) {
    body["httpApiParameters"] = request.HttpApiParameters
  }

  if !tea.BoolValue(util.IsUnset(request.InvocationRateLimitPerSecond)) {
    body["invocationRateLimitPerSecond"] = request.InvocationRateLimitPerSecond
  }

  req := &openapi.OpenApiRequest{
    Body: util.ToJSONString(body),
  }
  params := &openapi.Params{
    Action: tea.String("UpdateApiDestination"),
    Version: tea.String("2024-07-01"),
    Protocol: tea.String("HTTP"),
    Pathname: tea.String("/api-destination/updateApiDestination"),
    Method: tea.String("POST"),
    AuthType: tea.String("Anonymous"),
    Style: tea.String("RPC"),
    ReqBodyType: tea.String("json"),
    BodyType: tea.String("json"),
  }
  _result = &UpdateApiDestinationResponse{}
  _body, _err := client.CallApi(params, req, runtime)
  if _err != nil {
    return _result, _err
  }
  _err = tea.Convert(_body, &_result)
  return _result, _err
}

// Summary:
// 
// Updates an API destination.
// 
// Description:
// 
// You can call this API operation to update an API destination.
// 
// @param request - UpdateApiDestinationRequest
// 
// @return UpdateApiDestinationResponse
func (client *Client) UpdateApiDestination (request *UpdateApiDestinationRequest) (_result *UpdateApiDestinationResponse, _err error) {
  runtime := &util.RuntimeOptions{}
  _result = &UpdateApiDestinationResponse{}
  _body, _err := client.UpdateApiDestinationWithOptions(request, runtime)
  if _err != nil {
    return _result, _err
  }
  _result = _body
  return _result, _err
}

// Summary:
// 
// Queries the information about an API destination.
// 
// Description:
// 
// You can call this API operation to query the information about an API destination.
// 
// @param request - GetApiDestinationRequest
// 
// @param runtime - runtime options for this request RuntimeOptions
// 
// @return GetApiDestinationResponse
func (client *Client) GetApiDestinationWithOptions (request *GetApiDestinationRequest, runtime *util.RuntimeOptions) (_result *GetApiDestinationResponse, _err error) {
  _err = util.ValidateModel(request)
  if _err != nil {
    return _result, _err
  }
  body := map[string]interface{}{}
  if !tea.BoolValue(util.IsUnset(request.ApiDestinationName)) {
    body["apiDestinationName"] = request.ApiDestinationName
  }

  req := &openapi.OpenApiRequest{
    Body: util.ToJSONString(body),
  }
  params := &openapi.Params{
    Action: tea.String("GetApiDestination"),
    Version: tea.String("2024-07-01"),
    Protocol: tea.String("HTTP"),
    Pathname: tea.String("/api-destination/getApiDestination"),
    Method: tea.String("POST"),
    AuthType: tea.String("Anonymous"),
    Style: tea.String("RPC"),
    ReqBodyType: tea.String("json"),
    BodyType: tea.String("json"),
  }
  _result = &GetApiDestinationResponse{}
  _body, _err := client.CallApi(params, req, runtime)
  if _err != nil {
    return _result, _err
  }
  _err = tea.Convert(_body, &_result)
  return _result, _err
}

// Summary:
// 
// Queries the information about an API destination.
// 
// Description:
// 
// You can call this API operation to query the information about an API destination.
// 
// @param request - GetApiDestinationRequest
// 
// @return GetApiDestinationResponse
func (client *Client) GetApiDestination (request *GetApiDestinationRequest) (_result *GetApiDestinationResponse, _err error) {
  runtime := &util.RuntimeOptions{}
  _result = &GetApiDestinationResponse{}
  _body, _err := client.GetApiDestinationWithOptions(request, runtime)
  if _err != nil {
    return _result, _err
  }
  _result = _body
  return _result, _err
}

// Summary:
// 
// Deletes an API destination.
// 
// Description:
// 
// You can call this API operation to delete an API destination.
// 
// @param request - DeleteApiDestinationRequest
// 
// @param runtime - runtime options for this request RuntimeOptions
// 
// @return DeleteApiDestinationResponse
func (client *Client) DeleteApiDestinationWithOptions (request *DeleteApiDestinationRequest, runtime *util.RuntimeOptions) (_result *DeleteApiDestinationResponse, _err error) {
  _err = util.ValidateModel(request)
  if _err != nil {
    return _result, _err
  }
  body := map[string]interface{}{}
  if !tea.BoolValue(util.IsUnset(request.ApiDestinationName)) {
    body["apiDestinationName"] = request.ApiDestinationName
  }

  req := &openapi.OpenApiRequest{
    Body: util.ToJSONString(body),
  }
  params := &openapi.Params{
    Action: tea.String("DeleteApiDestination"),
    Version: tea.String("2024-07-01"),
    Protocol: tea.String("HTTP"),
    Pathname: tea.String("/api-destination/deleteApiDestination"),
    Method: tea.String("POST"),
    AuthType: tea.String("Anonymous"),
    Style: tea.String("RPC"),
    ReqBodyType: tea.String("json"),
    BodyType: tea.String("json"),
  }
  _result = &DeleteApiDestinationResponse{}
  _body, _err := client.CallApi(params, req, runtime)
  if _err != nil {
    return _result, _err
  }
  _err = tea.Convert(_body, &_result)
  return _result, _err
}

// Summary:
// 
// Deletes an API destination.
// 
// Description:
// 
// You can call this API operation to delete an API destination.
// 
// @param request - DeleteApiDestinationRequest
// 
// @return DeleteApiDestinationResponse
func (client *Client) DeleteApiDestination (request *DeleteApiDestinationRequest) (_result *DeleteApiDestinationResponse, _err error) {
  runtime := &util.RuntimeOptions{}
  _result = &DeleteApiDestinationResponse{}
  _body, _err := client.DeleteApiDestinationWithOptions(request, runtime)
  if _err != nil {
    return _result, _err
  }
  _result = _body
  return _result, _err
}

// Summary:
// 
// Queries a list of API destinations.
// 
// Description:
// 
// You can use this API operation to query a list of API destinations.
// 
// @param request - ListApiDestinationsRequest
// 
// @param runtime - runtime options for this request RuntimeOptions
// 
// @return ListApiDestinationsResponse
func (client *Client) ListApiDestinationsWithOptions (request *ListApiDestinationsRequest, runtime *util.RuntimeOptions) (_result *ListApiDestinationsResponse, _err error) {
  _err = util.ValidateModel(request)
  if _err != nil {
    return _result, _err
  }
  body := map[string]interface{}{}
  if !tea.BoolValue(util.IsUnset(request.ApiDestinationNamePrefix)) {
    body["apiDestinationNamePrefix"] = request.ApiDestinationNamePrefix
  }

  if !tea.BoolValue(util.IsUnset(request.ConnectionName)) {
    body["connectionName"] = request.ConnectionName
  }

  if !tea.BoolValue(util.IsUnset(request.MaxResults)) {
    body["maxResults"] = request.MaxResults
  }

  if !tea.BoolValue(util.IsUnset(request.NextToken)) {
    body["nextToken"] = request.NextToken
  }

  req := &openapi.OpenApiRequest{
    Body: util.ToJSONString(body),
  }
  params := &openapi.Params{
    Action: tea.String("ListApiDestinations"),
    Version: tea.String("2024-07-01"),
    Protocol: tea.String("HTTP"),
    Pathname: tea.String("/api-destination/listApiDestinations"),
    Method: tea.String("POST"),
    AuthType: tea.String("Anonymous"),
    Style: tea.String("RPC"),
    ReqBodyType: tea.String("json"),
    BodyType: tea.String("json"),
  }
  _result = &ListApiDestinationsResponse{}
  _body, _err := client.CallApi(params, req, runtime)
  if _err != nil {
    return _result, _err
  }
  _err = tea.Convert(_body, &_result)
  return _result, _err
}

// Summary:
// 
// Queries a list of API destinations.
// 
// Description:
// 
// You can use this API operation to query a list of API destinations.
// 
// @param request - ListApiDestinationsRequest
// 
// @return ListApiDestinationsResponse
func (client *Client) ListApiDestinations (request *ListApiDestinationsRequest) (_result *ListApiDestinationsResponse, _err error) {
  runtime := &util.RuntimeOptions{}
  _result = &ListApiDestinationsResponse{}
  _body, _err := client.ListApiDestinationsWithOptions(request, runtime)
  if _err != nil {
    return _result, _err
  }
  _result = _body
  return _result, _err
}

// Summary:
// 
// Creates a connection.
// 
// Description:
// 
// You can call this API operation to create a connection.
// 
// @param request - CreateConnectionRequest
// 
// @param runtime - runtime options for this request RuntimeOptions
// 
// @return CreateConnectionResponse
func (client *Client) CreateConnectionWithOptions (request *CreateConnectionRequest, runtime *util.RuntimeOptions) (_result *CreateConnectionResponse, _err error) {
  _err = util.ValidateModel(request)
  if _err != nil {
    return _result, _err
  }
  body := map[string]interface{}{}
  if !tea.BoolValue(util.IsUnset(request.AuthParameters)) {
    body["authParameters"] = request.AuthParameters
  }

  if !tea.BoolValue(util.IsUnset(request.ConnectionName)) {
    body["connectionName"] = request.ConnectionName
  }

  if !tea.BoolValue(util.IsUnset(request.Description)) {
    body["description"] = request.Description
  }

  if !tea.BoolValue(util.IsUnset(request.NetworkParameters)) {
    body["networkParameters"] = request.NetworkParameters
  }

  req := &openapi.OpenApiRequest{
    Body: util.ToJSONString(body),
  }
  params := &openapi.Params{
    Action: tea.String("CreateConnection"),
    Version: tea.String("2024-07-01"),
    Protocol: tea.String("HTTP"),
    Pathname: tea.String("/connection/createConnection"),
    Method: tea.String("POST"),
    AuthType: tea.String("Anonymous"),
    Style: tea.String("RPC"),
    ReqBodyType: tea.String("json"),
    BodyType: tea.String("json"),
  }
  _result = &CreateConnectionResponse{}
  _body, _err := client.CallApi(params, req, runtime)
  if _err != nil {
    return _result, _err
  }
  _err = tea.Convert(_body, &_result)
  return _result, _err
}

// Summary:
// 
// Creates a connection.
// 
// Description:
// 
// You can call this API operation to create a connection.
// 
// @param request - CreateConnectionRequest
// 
// @return CreateConnectionResponse
func (client *Client) CreateConnection (request *CreateConnectionRequest) (_result *CreateConnectionResponse, _err error) {
  runtime := &util.RuntimeOptions{}
  _result = &CreateConnectionResponse{}
  _body, _err := client.CreateConnectionWithOptions(request, runtime)
  if _err != nil {
    return _result, _err
  }
  _result = _body
  return _result, _err
}

// Summary:
// 
// Deletes a connection.
// 
// Description:
// 
// You can call this API operation to delete a connection.
// 
// @param request - DeleteConnectionRequest
// 
// @param runtime - runtime options for this request RuntimeOptions
// 
// @return DeleteConnectionResponse
func (client *Client) DeleteConnectionWithOptions (request *DeleteConnectionRequest, runtime *util.RuntimeOptions) (_result *DeleteConnectionResponse, _err error) {
  _err = util.ValidateModel(request)
  if _err != nil {
    return _result, _err
  }
  body := map[string]interface{}{}
  if !tea.BoolValue(util.IsUnset(request.ConnectionName)) {
    body["connectionName"] = request.ConnectionName
  }

  req := &openapi.OpenApiRequest{
    Body: util.ToJSONString(body),
  }
  params := &openapi.Params{
    Action: tea.String("DeleteConnection"),
    Version: tea.String("2024-07-01"),
    Protocol: tea.String("HTTP"),
    Pathname: tea.String("/connection/deleteConnection"),
    Method: tea.String("POST"),
    AuthType: tea.String("Anonymous"),
    Style: tea.String("RPC"),
    ReqBodyType: tea.String("json"),
    BodyType: tea.String("json"),
  }
  _result = &DeleteConnectionResponse{}
  _body, _err := client.CallApi(params, req, runtime)
  if _err != nil {
    return _result, _err
  }
  _err = tea.Convert(_body, &_result)
  return _result, _err
}

// Summary:
// 
// Deletes a connection.
// 
// Description:
// 
// You can call this API operation to delete a connection.
// 
// @param request - DeleteConnectionRequest
// 
// @return DeleteConnectionResponse
func (client *Client) DeleteConnection (request *DeleteConnectionRequest) (_result *DeleteConnectionResponse, _err error) {
  runtime := &util.RuntimeOptions{}
  _result = &DeleteConnectionResponse{}
  _body, _err := client.DeleteConnectionWithOptions(request, runtime)
  if _err != nil {
    return _result, _err
  }
  _result = _body
  return _result, _err
}

// Summary:
// 
// Updates a connection.
// 
// Description:
// 
// You can call this API operation to update a connection.
// 
// @param request - UpdateConnectionRequest
// 
// @param runtime - runtime options for this request RuntimeOptions
// 
// @return UpdateConnectionResponse
func (client *Client) UpdateConnectionWithOptions (request *UpdateConnectionRequest, runtime *util.RuntimeOptions) (_result *UpdateConnectionResponse, _err error) {
  _err = util.ValidateModel(request)
  if _err != nil {
    return _result, _err
  }
  body := map[string]interface{}{}
  if !tea.BoolValue(util.IsUnset(request.AuthParameters)) {
    body["authParameters"] = request.AuthParameters
  }

  if !tea.BoolValue(util.IsUnset(request.ConnectionName)) {
    body["connectionName"] = request.ConnectionName
  }

  if !tea.BoolValue(util.IsUnset(request.Description)) {
    body["description"] = request.Description
  }

  if !tea.BoolValue(util.IsUnset(request.NetworkParameters)) {
    body["networkParameters"] = request.NetworkParameters
  }

  req := &openapi.OpenApiRequest{
    Body: util.ToJSONString(body),
  }
  params := &openapi.Params{
    Action: tea.String("UpdateConnection"),
    Version: tea.String("2024-07-01"),
    Protocol: tea.String("HTTP"),
    Pathname: tea.String("/connection/updateConnection"),
    Method: tea.String("POST"),
    AuthType: tea.String("Anonymous"),
    Style: tea.String("RPC"),
    ReqBodyType: tea.String("json"),
    BodyType: tea.String("json"),
  }
  _result = &UpdateConnectionResponse{}
  _body, _err := client.CallApi(params, req, runtime)
  if _err != nil {
    return _result, _err
  }
  _err = tea.Convert(_body, &_result)
  return _result, _err
}

// Summary:
// 
// Updates a connection.
// 
// Description:
// 
// You can call this API operation to update a connection.
// 
// @param request - UpdateConnectionRequest
// 
// @return UpdateConnectionResponse
func (client *Client) UpdateConnection (request *UpdateConnectionRequest) (_result *UpdateConnectionResponse, _err error) {
  runtime := &util.RuntimeOptions{}
  _result = &UpdateConnectionResponse{}
  _body, _err := client.UpdateConnectionWithOptions(request, runtime)
  if _err != nil {
    return _result, _err
  }
  _result = _body
  return _result, _err
}

// Summary:
// 
// Queries the configurations of a connection.
// 
// Description:
// 
// You can call this API operation to query the configurations of a connection.
// 
// @param request - GetConnectionRequest
// 
// @param runtime - runtime options for this request RuntimeOptions
// 
// @return GetConnectionResponse
func (client *Client) GetConnectionWithOptions (request *GetConnectionRequest, runtime *util.RuntimeOptions) (_result *GetConnectionResponse, _err error) {
  _err = util.ValidateModel(request)
  if _err != nil {
    return _result, _err
  }
  body := map[string]interface{}{}
  if !tea.BoolValue(util.IsUnset(request.ConnectionName)) {
    body["connectionName"] = request.ConnectionName
  }

  req := &openapi.OpenApiRequest{
    Body: util.ToJSONString(body),
  }
  params := &openapi.Params{
    Action: tea.String("GetConnection"),
    Version: tea.String("2024-07-01"),
    Protocol: tea.String("HTTP"),
    Pathname: tea.String("/connection/getConnection"),
    Method: tea.String("POST"),
    AuthType: tea.String("Anonymous"),
    Style: tea.String("RPC"),
    ReqBodyType: tea.String("json"),
    BodyType: tea.String("json"),
  }
  _result = &GetConnectionResponse{}
  _body, _err := client.CallApi(params, req, runtime)
  if _err != nil {
    return _result, _err
  }
  _err = tea.Convert(_body, &_result)
  return _result, _err
}

// Summary:
// 
// Queries the configurations of a connection.
// 
// Description:
// 
// You can call this API operation to query the configurations of a connection.
// 
// @param request - GetConnectionRequest
// 
// @return GetConnectionResponse
func (client *Client) GetConnection (request *GetConnectionRequest) (_result *GetConnectionResponse, _err error) {
  runtime := &util.RuntimeOptions{}
  _result = &GetConnectionResponse{}
  _body, _err := client.GetConnectionWithOptions(request, runtime)
  if _err != nil {
    return _result, _err
  }
  _result = _body
  return _result, _err
}

// Summary:
// 
// Queries the configurations of a connection.
// 
// Description:
// 
// You can call this API operation to query the configurations of a connection.
// 
// @param request - GetConnectionRequest
// 
// @param runtime - runtime options for this request RuntimeOptions
// 
// @return GetConnectionResponse
func (client *Client) SelectOneConnectionWithOptions (request *GetConnectionRequest, runtime *util.RuntimeOptions) (_result *GetConnectionResponse, _err error) {
  _err = util.ValidateModel(request)
  if _err != nil {
    return _result, _err
  }
  body := map[string]interface{}{}
  if !tea.BoolValue(util.IsUnset(request.ConnectionName)) {
    body["connectionName"] = request.ConnectionName
  }

  req := &openapi.OpenApiRequest{
    Body: util.ToJSONString(body),
  }
  params := &openapi.Params{
    Action: tea.String("selectOneConnection"),
    Version: tea.String("2024-07-01"),
    Protocol: tea.String("HTTP"),
    Pathname: tea.String("/connection/selectOneConnection"),
    Method: tea.String("POST"),
    AuthType: tea.String("Anonymous"),
    Style: tea.String("RPC"),
    ReqBodyType: tea.String("json"),
    BodyType: tea.String("json"),
  }
  _result = &GetConnectionResponse{}
  _body, _err := client.CallApi(params, req, runtime)
  if _err != nil {
    return _result, _err
  }
  _err = tea.Convert(_body, &_result)
  return _result, _err
}

// Summary:
// 
// Queries the configurations of a connection.
// 
// Description:
// 
// You can call this API operation to query the configurations of a connection.
// 
// @param request - GetConnectionRequest
// 
// @return GetConnectionResponse
func (client *Client) SelectOneConnection (request *GetConnectionRequest) (_result *GetConnectionResponse, _err error) {
  runtime := &util.RuntimeOptions{}
  _result = &GetConnectionResponse{}
  _body, _err := client.SelectOneConnectionWithOptions(request, runtime)
  if _err != nil {
    return _result, _err
  }
  _result = _body
  return _result, _err
}

// Summary:
// 
// Queries connections.
// 
// Description:
// 
// You can call this API operation to query connections.
// 
// @param request - ListConnectionsRequest
// 
// @param runtime - runtime options for this request RuntimeOptions
// 
// @return ListConnectionsResponse
func (client *Client) ListConnectionsWithOptions (request *ListConnectionsRequest, runtime *util.RuntimeOptions) (_result *ListConnectionsResponse, _err error) {
  _err = util.ValidateModel(request)
  if _err != nil {
    return _result, _err
  }
  body := map[string]interface{}{}
  if !tea.BoolValue(util.IsUnset(request.ConnectionNamePrefix)) {
    body["connectionNamePrefix"] = request.ConnectionNamePrefix
  }

  if !tea.BoolValue(util.IsUnset(request.MaxResults)) {
    body["maxResults"] = request.MaxResults
  }

  if !tea.BoolValue(util.IsUnset(request.NextToken)) {
    body["nextToken"] = request.NextToken
  }

  req := &openapi.OpenApiRequest{
    Body: util.ToJSONString(body),
  }
  params := &openapi.Params{
    Action: tea.String("ListConnections"),
    Version: tea.String("2024-07-01"),
    Protocol: tea.String("HTTP"),
    Pathname: tea.String("/connection/listConnections"),
    Method: tea.String("POST"),
    AuthType: tea.String("Anonymous"),
    Style: tea.String("RPC"),
    ReqBodyType: tea.String("json"),
    BodyType: tea.String("json"),
  }
  _result = &ListConnectionsResponse{}
  _body, _err := client.CallApi(params, req, runtime)
  if _err != nil {
    return _result, _err
  }
  _err = tea.Convert(_body, &_result)
  return _result, _err
}

// Summary:
// 
// list connections.
// 
// Description:
// 
// You can call this API operation to list connections.
// 
// @param request - ListConnectionsRequest
// 
// @return ListConnectionsResponse
func (client *Client) ListConnections (request *ListConnectionsRequest) (_result *ListConnectionsResponse, _err error) {
  runtime := &util.RuntimeOptions{}
  _result = &ListConnectionsResponse{}
  _body, _err := client.ListConnectionsWithOptions(request, runtime)
  if _err != nil {
    return _result, _err
  }
  _result = _body
  return _result, _err
}

// Summary:
// 
// Updates a connection.
// 
// Description:
// 
// You can call this API operation to update a connection.
// 
// @return ListEnumsResponseResponse
func (client *Client) ListEnumsResponse () (_result *ListEnumsResponseResponse, _err error) {
  runtime := &util.RuntimeOptions{}
  body := map[string]interface{}{}
  req := &openapi.OpenApiRequest{
    Body: util.ToJSONString(body),
  }
  params := &openapi.Params{
    Action: tea.String("listEnumsResponse"),
    Version: tea.String("2024-07-01"),
    Protocol: tea.String("HTTP"),
    Pathname: tea.String("/connection/listEnumsResponse"),
    Method: tea.String("POST"),
    AuthType: tea.String("Anonymous"),
    Style: tea.String("RPC"),
    ReqBodyType: tea.String("json"),
    BodyType: tea.String("json"),
  }
  _result = &ListEnumsResponseResponse{}
  _body, _err := client.CallApi(params, req, runtime)
  if _err != nil {
    return _result, _err
  }
  _err = tea.Convert(_body, &_result)
  return _result, _err
}

// Summary:
// 
// Queries the content of an event.
// 
// Description:
// 
// You can call this API operation to query the content of an event.
// 
// @param request - PutEventsRequest
// 
// @param runtime - runtime options for this request RuntimeOptions
// 
// @return PutEventsResponse
func (client *Client) PutEventsWithOptions (request *PutEventsRequest, runtime *util.RuntimeOptions) (_result *PutEventsResponse, _err error) {
  _err = util.ValidateModel(request)
  if _err != nil {
    return _result, _err
  }
  headers := map[string]*string{
    "ce-specversion": tea.String("1.0"),
    "ce-type": tea.String("com.github.pull_request.opened"),
    "ce-source": tea.String("https://github.com/cloudevents/spec/pull"),
    "ce-subject": tea.String("demo"),
    "ce-id": tea.String("1234-1234-1234"),
    "ce-datacontenttype": tea.String("application/json"),
    "ce-time": tea.String("2024-07-01T17:31:00Z"),
    "ce-eventbusname": tea.String("demo-bus"),
  }
  body := tea.String("{}")
  if !tea.BoolValue(util.IsUnset(request.EventBusName)) {
    headers["ce-eventbusname"] = request.EventBusName
  }

  if !tea.BoolValue(util.IsUnset(request.Event)) {
    body = request.Event
  }

  req := &openapi.OpenApiRequest{
    Body: body,
    Headers: headers,
  }
  params := &openapi.Params{
    Action: tea.String("putEvents"),
    Version: tea.String("2024-07-01"),
    Protocol: tea.String("HTTP"),
    Pathname: tea.String("/putEvents"),
    Method: tea.String("POST"),
    AuthType: tea.String("Anonymous"),
    Style: tea.String("RPC"),
    ReqBodyType: tea.String("json"),
    BodyType: tea.String("json"),
  }
  _result = &PutEventsResponse{}
  _body, _err := client.CallApi(params, req, runtime)
  if _err != nil {
    return _result, _err
  }
  _err = tea.Convert(_body, &_result)
  return _result, _err
}

// Summary:
// 
// Queries the content of an event.
// 
// Description:
// 
// You can call this API operation to query the content of an event.
// 
// @param request - PutEventsRequest
// 
// @return PutEventsResponse
func (client *Client) PutEvents (request *PutEventsRequest) (_result *PutEventsResponse, _err error) {
  runtime := &util.RuntimeOptions{}
  _result = &PutEventsResponse{}
  _body, _err := client.PutEventsWithOptions(request, runtime)
  if _err != nil {
    return _result, _err
  }
  _result = _body
  return _result, _err
}

// Summary:
// 
// Creates an event rule.
// 
// Description:
// 
// You can call this operation to create an event rule.
// 
// @param request - CreateEventRuleRequest
// 
// @param runtime - runtime options for this request RuntimeOptions
// 
// @return CreateEventRuleResponse
func (client *Client) CreateEventRuleWithOptions (request *CreateEventRuleRequest, runtime *util.RuntimeOptions) (_result *CreateEventRuleResponse, _err error) {
  _err = util.ValidateModel(request)
  if _err != nil {
    return _result, _err
  }
  body := map[string]interface{}{}
  if !tea.BoolValue(util.IsUnset(request.EventBusName)) {
    body["eventBusName"] = request.EventBusName
  }

  if !tea.BoolValue(util.IsUnset(request.EventRuleName)) {
    body["eventRuleName"] = request.EventRuleName
  }

  if !tea.BoolValue(util.IsUnset(request.Description)) {
    body["description"] = request.Description
  }

  if !tea.BoolValue(util.IsUnset(request.FilterPattern)) {
    body["filterPattern"] = request.FilterPattern
  }

  req := &openapi.OpenApiRequest{
    Body: util.ToJSONString(body),
  }
  params := &openapi.Params{
    Action: tea.String("CreateEventRule"),
    Version: tea.String("2024-07-01"),
    Protocol: tea.String("HTTP"),
    Pathname: tea.String("/rule/createEventRule"),
    Method: tea.String("POST"),
    AuthType: tea.String("Anonymous"),
    Style: tea.String("RPC"),
    ReqBodyType: tea.String("json"),
    BodyType: tea.String("json"),
  }
  _result = &CreateEventRuleResponse{}
  _body, _err := client.CallApi(params, req, runtime)
  if _err != nil {
    return _result, _err
  }
  _err = tea.Convert(_body, &_result)
  return _result, _err
}

// Summary:
// 
// Creates an event rule.
// 
// Description:
// 
// You can call this operation to create an event rule.
// 
// @param request - CreateEventRuleRequest
// 
// @return CreateEventRuleResponse
func (client *Client) CreateEventRule (request *CreateEventRuleRequest) (_result *CreateEventRuleResponse, _err error) {
  runtime := &util.RuntimeOptions{}
  _result = &CreateEventRuleResponse{}
  _body, _err := client.CreateEventRuleWithOptions(request, runtime)
  if _err != nil {
    return _result, _err
  }
  _result = _body
  return _result, _err
}

// Summary:
// 
// Gets an event rule.
// 
// Description:
// 
// You can call this operation to get an event rule.
// 
// @param request - GetEventRuleRequest
// 
// @param runtime - runtime options for this request RuntimeOptions
// 
// @return GetEventRuleResponse
func (client *Client) GetEventRuleWithOptions (request *GetEventRuleRequest, runtime *util.RuntimeOptions) (_result *GetEventRuleResponse, _err error) {
  _err = util.ValidateModel(request)
  if _err != nil {
    return _result, _err
  }
  body := map[string]interface{}{}
  if !tea.BoolValue(util.IsUnset(request.EventBusName)) {
    body["eventBusName"] = request.EventBusName
  }

  if !tea.BoolValue(util.IsUnset(request.EventRuleName)) {
    body["eventRuleName"] = request.EventRuleName
  }

  req := &openapi.OpenApiRequest{
    Body: util.ToJSONString(body),
  }
  params := &openapi.Params{
    Action: tea.String("GetEventRule"),
    Version: tea.String("2024-07-01"),
    Protocol: tea.String("HTTP"),
    Pathname: tea.String("/rule/getEventRule"),
    Method: tea.String("POST"),
    AuthType: tea.String("Anonymous"),
    Style: tea.String("RPC"),
    ReqBodyType: tea.String("json"),
    BodyType: tea.String("json"),
  }
  _result = &GetEventRuleResponse{}
  _body, _err := client.CallApi(params, req, runtime)
  if _err != nil {
    return _result, _err
  }
  _err = tea.Convert(_body, &_result)
  return _result, _err
}

// Summary:
// 
// Gets an event rule.
// 
// Description:
// 
// You can call this operation to get an event rule.
// 
// @param request - GetEventRuleRequest
// 
// @return GetEventRuleResponse
func (client *Client) GetEventRule (request *GetEventRuleRequest) (_result *GetEventRuleResponse, _err error) {
  runtime := &util.RuntimeOptions{}
  _result = &GetEventRuleResponse{}
  _body, _err := client.GetEventRuleWithOptions(request, runtime)
  if _err != nil {
    return _result, _err
  }
  _result = _body
  return _result, _err
}

// Summary:
// 
// Deletes an event rule.
// 
// Description:
// 
// You can call this operation to delete an event rule.
// 
// @param request - DeleteEventRuleRequest
// 
// @param runtime - runtime options for this request RuntimeOptions
// 
// @return DeleteEventRuleResponse
func (client *Client) DeleteEventRuleWithOptions (request *DeleteEventRuleRequest, runtime *util.RuntimeOptions) (_result *DeleteEventRuleResponse, _err error) {
  _err = util.ValidateModel(request)
  if _err != nil {
    return _result, _err
  }
  body := map[string]interface{}{}
  if !tea.BoolValue(util.IsUnset(request.EventBusName)) {
    body["eventBusName"] = request.EventBusName
  }

  if !tea.BoolValue(util.IsUnset(request.EventRuleName)) {
    body["eventRuleName"] = request.EventRuleName
  }

  req := &openapi.OpenApiRequest{
    Body: util.ToJSONString(body),
  }
  params := &openapi.Params{
    Action: tea.String("DeleteEventRule"),
    Version: tea.String("2024-07-01"),
    Protocol: tea.String("HTTP"),
    Pathname: tea.String("/rule/deleteEventRule"),
    Method: tea.String("POST"),
    AuthType: tea.String("Anonymous"),
    Style: tea.String("RPC"),
    ReqBodyType: tea.String("json"),
    BodyType: tea.String("json"),
  }
  _result = &DeleteEventRuleResponse{}
  _body, _err := client.CallApi(params, req, runtime)
  if _err != nil {
    return _result, _err
  }
  _err = tea.Convert(_body, &_result)
  return _result, _err
}

// Summary:
// 
// Deletes an event rule.
// 
// Description:
// 
// You can call this operation to delete an event rule.
// 
// @param request - DeleteEventRuleRequest
// 
// @return DeleteEventRuleResponse
func (client *Client) DeleteEventRule (request *DeleteEventRuleRequest) (_result *DeleteEventRuleResponse, _err error) {
  runtime := &util.RuntimeOptions{}
  _result = &DeleteEventRuleResponse{}
  _body, _err := client.DeleteEventRuleWithOptions(request, runtime)
  if _err != nil {
    return _result, _err
  }
  _result = _body
  return _result, _err
}

// Summary:
// 
// Updates an event rule.
// 
// Description:
// 
// You can call this operation to update an event rule.
// 
// @param request - UpdateEventRuleRequest
// 
// @param runtime - runtime options for this request RuntimeOptions
// 
// @return UpdateEventRuleResponse
func (client *Client) UpdateEventRuleWithOptions (request *UpdateEventRuleRequest, runtime *util.RuntimeOptions) (_result *UpdateEventRuleResponse, _err error) {
  _err = util.ValidateModel(request)
  if _err != nil {
    return _result, _err
  }
  body := map[string]interface{}{}
  if !tea.BoolValue(util.IsUnset(request.EventBusName)) {
    body["eventBusName"] = request.EventBusName
  }

  if !tea.BoolValue(util.IsUnset(request.EventRuleName)) {
    body["eventRuleName"] = request.EventRuleName
  }

  if !tea.BoolValue(util.IsUnset(request.Description)) {
    body["description"] = request.Description
  }

  if !tea.BoolValue(util.IsUnset(request.FilterPattern)) {
    body["filterPattern"] = request.FilterPattern
  }

  req := &openapi.OpenApiRequest{
    Body: util.ToJSONString(body),
  }
  params := &openapi.Params{
    Action: tea.String("UpdateEventRule"),
    Version: tea.String("2024-07-01"),
    Protocol: tea.String("HTTP"),
    Pathname: tea.String("/rule/updateEventRule"),
    Method: tea.String("POST"),
    AuthType: tea.String("Anonymous"),
    Style: tea.String("RPC"),
    ReqBodyType: tea.String("json"),
    BodyType: tea.String("json"),
  }
  _result = &UpdateEventRuleResponse{}
  _body, _err := client.CallApi(params, req, runtime)
  if _err != nil {
    return _result, _err
  }
  _err = tea.Convert(_body, &_result)
  return _result, _err
}

// Summary:
// 
// Updates an event rule.
// 
// Description:
// 
// You can call this operation to update an event rule.
// 
// @param request - UpdateEventRuleRequest
// 
// @return UpdateEventRuleResponse
func (client *Client) UpdateEventRule (request *UpdateEventRuleRequest) (_result *UpdateEventRuleResponse, _err error) {
  runtime := &util.RuntimeOptions{}
  _result = &UpdateEventRuleResponse{}
  _body, _err := client.UpdateEventRuleWithOptions(request, runtime)
  if _err != nil {
    return _result, _err
  }
  _result = _body
  return _result, _err
}

// Summary:
// 
// Lists event rules.
// 
// Description:
// 
// You can call this operation to list event rules.
// 
// @param request - ListEventRulesRequest
// 
// @param runtime - runtime options for this request RuntimeOptions
// 
// @return ListEventRulesResponse
func (client *Client) ListEventRulesWithOptions (request *ListEventRulesRequest, runtime *util.RuntimeOptions) (_result *ListEventRulesResponse, _err error) {
  _err = util.ValidateModel(request)
  if _err != nil {
    return _result, _err
  }
  body := map[string]interface{}{}
  if !tea.BoolValue(util.IsUnset(request.EventBusName)) {
    body["eventBusName"] = request.EventBusName
  }

  if !tea.BoolValue(util.IsUnset(request.MaxResults)) {
    body["maxResults"] = request.MaxResults
  }

  if !tea.BoolValue(util.IsUnset(request.NextToken)) {
    body["nextToken"] = request.NextToken
  }

  req := &openapi.OpenApiRequest{
    Body: util.ToJSONString(body),
  }
  params := &openapi.Params{
    Action: tea.String("ListEventRules"),
    Version: tea.String("2024-07-01"),
    Protocol: tea.String("HTTP"),
    Pathname: tea.String("/rule/listEventRules"),
    Method: tea.String("POST"),
    AuthType: tea.String("Anonymous"),
    Style: tea.String("RPC"),
    ReqBodyType: tea.String("json"),
    BodyType: tea.String("json"),
  }
  _result = &ListEventRulesResponse{}
  _body, _err := client.CallApi(params, req, runtime)
  if _err != nil {
    return _result, _err
  }
  _err = tea.Convert(_body, &_result)
  return _result, _err
}

// Summary:
// 
// Lists event rules.
// 
// Description:
// 
// You can call this operation to list event rules.
// 
// @param request - ListEventRulesRequest
// 
// @return ListEventRulesResponse
func (client *Client) ListEventRules (request *ListEventRulesRequest) (_result *ListEventRulesResponse, _err error) {
  runtime := &util.RuntimeOptions{}
  _result = &ListEventRulesResponse{}
  _body, _err := client.ListEventRulesWithOptions(request, runtime)
  if _err != nil {
    return _result, _err
  }
  _result = _body
  return _result, _err
}

// Summary:
// 
// Enables an event rule.
// 
// Description:
// 
// You can call this operation to enable an event rule.
// 
// @param request - EnableEventRuleRequest
// 
// @param runtime - runtime options for this request RuntimeOptions
// 
// @return EnableEventRuleResponse
func (client *Client) EnableEventRuleWithOptions (request *EnableEventRuleRequest, runtime *util.RuntimeOptions) (_result *EnableEventRuleResponse, _err error) {
  _err = util.ValidateModel(request)
  if _err != nil {
    return _result, _err
  }
  body := map[string]interface{}{}
  if !tea.BoolValue(util.IsUnset(request.EventBusName)) {
    body["eventBusName"] = request.EventBusName
  }

  if !tea.BoolValue(util.IsUnset(request.EventRuleName)) {
    body["eventRuleName"] = request.EventRuleName
  }

  req := &openapi.OpenApiRequest{
    Body: util.ToJSONString(body),
  }
  params := &openapi.Params{
    Action: tea.String("EnableEventRule"),
    Version: tea.String("2024-07-01"),
    Protocol: tea.String("HTTP"),
    Pathname: tea.String("/rule/enableEventRule"),
    Method: tea.String("POST"),
    AuthType: tea.String("Anonymous"),
    Style: tea.String("RPC"),
    ReqBodyType: tea.String("json"),
    BodyType: tea.String("json"),
  }
  _result = &EnableEventRuleResponse{}
  _body, _err := client.CallApi(params, req, runtime)
  if _err != nil {
    return _result, _err
  }
  _err = tea.Convert(_body, &_result)
  return _result, _err
}

// Summary:
// 
// Enables an event rule.
// 
// Description:
// 
// You can call this operation to enable an event rule.
// 
// @param request - EnableEventRuleRequest
// 
// @return EnableEventRuleResponse
func (client *Client) EnableEventRule (request *EnableEventRuleRequest) (_result *EnableEventRuleResponse, _err error) {
  runtime := &util.RuntimeOptions{}
  _result = &EnableEventRuleResponse{}
  _body, _err := client.EnableEventRuleWithOptions(request, runtime)
  if _err != nil {
    return _result, _err
  }
  _result = _body
  return _result, _err
}

// Summary:
// 
// Disables an event rule.
// 
// Description:
// 
// You can call this operation to disable an event rule.
// 
// @param request - DisableEventRuleRequest
// 
// @param runtime - runtime options for this request RuntimeOptions
// 
// @return DisableEventRuleResponse
func (client *Client) DisableEventRuleWithOptions (request *DisableEventRuleRequest, runtime *util.RuntimeOptions) (_result *DisableEventRuleResponse, _err error) {
  _err = util.ValidateModel(request)
  if _err != nil {
    return _result, _err
  }
  body := map[string]interface{}{}
  if !tea.BoolValue(util.IsUnset(request.EventBusName)) {
    body["eventBusName"] = request.EventBusName
  }

  if !tea.BoolValue(util.IsUnset(request.EventRuleName)) {
    body["eventRuleName"] = request.EventRuleName
  }

  req := &openapi.OpenApiRequest{
    Body: util.ToJSONString(body),
  }
  params := &openapi.Params{
    Action: tea.String("DisableEventRule"),
    Version: tea.String("2024-07-01"),
    Protocol: tea.String("HTTP"),
    Pathname: tea.String("/rule/disableEventRule"),
    Method: tea.String("POST"),
    AuthType: tea.String("Anonymous"),
    Style: tea.String("RPC"),
    ReqBodyType: tea.String("json"),
    BodyType: tea.String("json"),
  }
  _result = &DisableEventRuleResponse{}
  _body, _err := client.CallApi(params, req, runtime)
  if _err != nil {
    return _result, _err
  }
  _err = tea.Convert(_body, &_result)
  return _result, _err
}

// Summary:
// 
// Disables an event rule.
// 
// Description:
// 
// You can call this operation to disable an event rule.
// 
// @param request - DisableEventRuleRequest
// 
// @return DisableEventRuleResponse
func (client *Client) DisableEventRule (request *DisableEventRuleRequest) (_result *DisableEventRuleResponse, _err error) {
  runtime := &util.RuntimeOptions{}
  _result = &DisableEventRuleResponse{}
  _body, _err := client.DisableEventRuleWithOptions(request, runtime)
  if _err != nil {
    return _result, _err
  }
  _result = _body
  return _result, _err
}

// Summary:
// 
// Creates an event source.
// 
// Description:
// 
// You can call this operation to create an event source.
// 
// @param request - CreateEventSourceRequest
// 
// @param runtime - runtime options for this request RuntimeOptions
// 
// @return CreateEventSourceResponse
func (client *Client) CreateEventSourceWithOptions (request *CreateEventSourceRequest, runtime *util.RuntimeOptions) (_result *CreateEventSourceResponse, _err error) {
  _err = util.ValidateModel(request)
  if _err != nil {
    return _result, _err
  }
  body := map[string]interface{}{}
  if !tea.BoolValue(util.IsUnset(request.Description)) {
    body["description"] = request.Description
  }

  if !tea.BoolValue(util.IsUnset(request.EventBusName)) {
    body["eventBusName"] = request.EventBusName
  }

  if !tea.BoolValue(util.IsUnset(request.EventSourceName)) {
    body["eventSourceName"] = request.EventSourceName
  }

  if !tea.BoolValue(util.IsUnset(request.ClassName)) {
    body["className"] = request.ClassName
  }

  if !tea.BoolValue(util.IsUnset(request.Config)) {
    body["config"] = request.Config
  }

  req := &openapi.OpenApiRequest{
    Body: util.ToJSONString(body),
  }
  params := &openapi.Params{
    Action: tea.String("CreateEventSource"),
    Version: tea.String("2024-07-01"),
    Protocol: tea.String("HTTP"),
    Pathname: tea.String("/source/createEventSource"),
    Method: tea.String("POST"),
    AuthType: tea.String("Anonymous"),
    Style: tea.String("RPC"),
    ReqBodyType: tea.String("json"),
    BodyType: tea.String("json"),
  }
  _result = &CreateEventSourceResponse{}
  _body, _err := client.CallApi(params, req, runtime)
  if _err != nil {
    return _result, _err
  }
  _err = tea.Convert(_body, &_result)
  return _result, _err
}

// Summary:
// 
// Creates an event source.
// 
// Description:
// 
// You can call this operation to create an event source.
// 
// @param request - CreateEventSourceRequest
// 
// @return CreateEventSourceResponse
func (client *Client) CreateEventSource (request *CreateEventSourceRequest) (_result *CreateEventSourceResponse, _err error) {
  runtime := &util.RuntimeOptions{}
  _result = &CreateEventSourceResponse{}
  _body, _err := client.CreateEventSourceWithOptions(request, runtime)
  if _err != nil {
    return _result, _err
  }
  _result = _body
  return _result, _err
}

// Summary:
// 
// Updates an event source.
// 
// Description:
// 
// You can call this operation to update an event source.
// 
// @param request - UpdateEventSourceRequest
// 
// @param runtime - runtime options for this request RuntimeOptions
// 
// @return UpdateEventSourceResponse
func (client *Client) UpdateEventSourceWithOptions (request *UpdateEventSourceRequest, runtime *util.RuntimeOptions) (_result *UpdateEventSourceResponse, _err error) {
  _err = util.ValidateModel(request)
  if _err != nil {
    return _result, _err
  }
  body := map[string]interface{}{}
  if !tea.BoolValue(util.IsUnset(request.EventBusName)) {
    body["eventBusName"] = request.EventBusName
  }

  if !tea.BoolValue(util.IsUnset(request.EventSourceName)) {
    body["eventSourceName"] = request.EventSourceName
  }

  if !tea.BoolValue(util.IsUnset(request.Description)) {
    body["description"] = request.Description
  }

  if !tea.BoolValue(util.IsUnset(request.ClassName)) {
    body["className"] = request.ClassName
  }

  if !tea.BoolValue(util.IsUnset(request.Status)) {
    body["status"] = request.Status
  }

  if !tea.BoolValue(util.IsUnset(request.Config)) {
    body["config"] = request.Config
  }

  req := &openapi.OpenApiRequest{
    Body: util.ToJSONString(body),
  }
  params := &openapi.Params{
    Action: tea.String("UpdateEventSource"),
    Version: tea.String("2024-07-01"),
    Protocol: tea.String("HTTP"),
    Pathname: tea.String("/source/updateEventSource"),
    Method: tea.String("POST"),
    AuthType: tea.String("Anonymous"),
    Style: tea.String("RPC"),
    ReqBodyType: tea.String("json"),
    BodyType: tea.String("json"),
  }
  _result = &UpdateEventSourceResponse{}
  _body, _err := client.CallApi(params, req, runtime)
  if _err != nil {
    return _result, _err
  }
  _err = tea.Convert(_body, &_result)
  return _result, _err
}

// Summary:
// 
// Updates an event source.
// 
// Description:
// 
// You can call this operation to update an event source.
// 
// @param request - UpdateEventSourceRequest
// 
// @return UpdateEventSourceResponse
func (client *Client) UpdateEventSource (request *UpdateEventSourceRequest) (_result *UpdateEventSourceResponse, _err error) {
  runtime := &util.RuntimeOptions{}
  _result = &UpdateEventSourceResponse{}
  _body, _err := client.UpdateEventSourceWithOptions(request, runtime)
  if _err != nil {
    return _result, _err
  }
  _result = _body
  return _result, _err
}

// Summary:
// 
// Deletes an event source.
// 
// Description:
// 
// You can call this API operation to delete an event source.
// 
// @param request - DeleteEventSourceRequest
// 
// @param runtime - runtime options for this request RuntimeOptions
// 
// @return DeleteEventSourceResponse
func (client *Client) DeleteEventSourceWithOptions (request *DeleteEventSourceRequest, runtime *util.RuntimeOptions) (_result *DeleteEventSourceResponse, _err error) {
  _err = util.ValidateModel(request)
  if _err != nil {
    return _result, _err
  }
  body := map[string]interface{}{}
  if !tea.BoolValue(util.IsUnset(request.EventBusName)) {
    body["eventBusName"] = request.EventBusName
  }

  if !tea.BoolValue(util.IsUnset(request.EventSourceName)) {
    body["eventSourceName"] = request.EventSourceName
  }

  req := &openapi.OpenApiRequest{
    Body: util.ToJSONString(body),
  }
  params := &openapi.Params{
    Action: tea.String("DeleteEventSource"),
    Version: tea.String("2024-07-01"),
    Protocol: tea.String("HTTP"),
    Pathname: tea.String("/source/deleteEventSource"),
    Method: tea.String("POST"),
    AuthType: tea.String("Anonymous"),
    Style: tea.String("RPC"),
    ReqBodyType: tea.String("json"),
    BodyType: tea.String("json"),
  }
  _result = &DeleteEventSourceResponse{}
  _body, _err := client.CallApi(params, req, runtime)
  if _err != nil {
    return _result, _err
  }
  _err = tea.Convert(_body, &_result)
  return _result, _err
}

// Summary:
// 
// Deletes an event source.
// 
// Description:
// 
// You can call this API operation to delete an event source.
// 
// @param request - DeleteEventSourceRequest
// 
// @return DeleteEventSourceResponse
func (client *Client) DeleteEventSource (request *DeleteEventSourceRequest) (_result *DeleteEventSourceResponse, _err error) {
  runtime := &util.RuntimeOptions{}
  _result = &DeleteEventSourceResponse{}
  _body, _err := client.DeleteEventSourceWithOptions(request, runtime)
  if _err != nil {
    return _result, _err
  }
  _result = _body
  return _result, _err
}

// Summary:
// 
// Gets an event source.
// 
// Description:
// 
// You can call this API operation to get an event source.
// 
// @param request - GetEventSourceRequest
// 
// @param runtime - runtime options for this request RuntimeOptions
// 
// @return GetEventSourceResponse
func (client *Client) GetEventSourceWithOptions (request *GetEventSourceRequest, runtime *util.RuntimeOptions) (_result *GetEventSourceResponse, _err error) {
  _err = util.ValidateModel(request)
  if _err != nil {
    return _result, _err
  }
  body := map[string]interface{}{}
  if !tea.BoolValue(util.IsUnset(request.EventBusName)) {
    body["eventBusName"] = request.EventBusName
  }

  if !tea.BoolValue(util.IsUnset(request.EventSourceName)) {
    body["eventSourceName"] = request.EventSourceName
  }

  req := &openapi.OpenApiRequest{
    Body: util.ToJSONString(body),
  }
  params := &openapi.Params{
    Action: tea.String("GetEventSource"),
    Version: tea.String("2024-07-01"),
    Protocol: tea.String("HTTP"),
    Pathname: tea.String("/source/getEventSource"),
    Method: tea.String("POST"),
    AuthType: tea.String("Anonymous"),
    Style: tea.String("RPC"),
    ReqBodyType: tea.String("json"),
    BodyType: tea.String("json"),
  }
  _result = &GetEventSourceResponse{}
  _body, _err := client.CallApi(params, req, runtime)
  if _err != nil {
    return _result, _err
  }
  _err = tea.Convert(_body, &_result)
  return _result, _err
}

// Summary:
// 
// Gets an event source.
// 
// Description:
// 
// You can call this API operation to get an event source.
// 
// @param request - GetEventSourceRequest
// 
// @return GetEventSourceResponse
func (client *Client) GetEventSource (request *GetEventSourceRequest) (_result *GetEventSourceResponse, _err error) {
  runtime := &util.RuntimeOptions{}
  _result = &GetEventSourceResponse{}
  _body, _err := client.GetEventSourceWithOptions(request, runtime)
  if _err != nil {
    return _result, _err
  }
  _result = _body
  return _result, _err
}

// Summary:
// 
// Lists event sources.
// 
// Description:
// 
// You can call this API operation to list event sources.
// 
// @param request - ListEventSourcesRequest
// 
// @param runtime - runtime options for this request RuntimeOptions
// 
// @return ListEventSourcesResponse
func (client *Client) ListEventSourcesWithOptions (request *ListEventSourcesRequest, runtime *util.RuntimeOptions) (_result *ListEventSourcesResponse, _err error) {
  _err = util.ValidateModel(request)
  if _err != nil {
    return _result, _err
  }
  body := map[string]interface{}{}
  if !tea.BoolValue(util.IsUnset(request.EventBusName)) {
    body["eventBusName"] = request.EventBusName
  }

  if !tea.BoolValue(util.IsUnset(request.EventSourceType)) {
    body["eventSourceType"] = request.EventSourceType
  }

  if !tea.BoolValue(util.IsUnset(request.MaxResults)) {
    body["maxResults"] = request.MaxResults
  }

  if !tea.BoolValue(util.IsUnset(request.NextToken)) {
    body["nextToken"] = request.NextToken
  }

  req := &openapi.OpenApiRequest{
    Body: util.ToJSONString(body),
  }
  params := &openapi.Params{
    Action: tea.String("ListEventSources"),
    Version: tea.String("2024-07-01"),
    Protocol: tea.String("HTTP"),
    Pathname: tea.String("/source/listEventSources"),
    Method: tea.String("POST"),
    AuthType: tea.String("Anonymous"),
    Style: tea.String("RPC"),
    ReqBodyType: tea.String("json"),
    BodyType: tea.String("json"),
  }
  _result = &ListEventSourcesResponse{}
  _body, _err := client.CallApi(params, req, runtime)
  if _err != nil {
    return _result, _err
  }
  _err = tea.Convert(_body, &_result)
  return _result, _err
}

// Summary:
// 
// Lists event sources.
// 
// Description:
// 
// You can call this API operation to list event sources.
// 
// @param request - ListEventSourcesRequest
// 
// @return ListEventSourcesResponse
func (client *Client) ListEventSources (request *ListEventSourcesRequest) (_result *ListEventSourcesResponse, _err error) {
  runtime := &util.RuntimeOptions{}
  _result = &ListEventSourcesResponse{}
  _body, _err := client.ListEventSourcesWithOptions(request, runtime)
  if _err != nil {
    return _result, _err
  }
  _result = _body
  return _result, _err
}

// Summary:
// 
// Creates event targets.
// 
// Description:
// 
// You can call this operation to create event targets.
// 
// @param request - CreateEventTargetsRequest
// 
// @param runtime - runtime options for this request RuntimeOptions
// 
// @return CreateEventTargetsResponse
func (client *Client) CreateEventTargetsWithOptions (request *CreateEventTargetsRequest, runtime *util.RuntimeOptions) (_result *CreateEventTargetsResponse, _err error) {
  _err = util.ValidateModel(request)
  if _err != nil {
    return _result, _err
  }
  body := map[string]interface{}{}
  if !tea.BoolValue(util.IsUnset(request.EventBusName)) {
    body["eventBusName"] = request.EventBusName
  }

  if !tea.BoolValue(util.IsUnset(request.EventRuleName)) {
    body["eventRuleName"] = request.EventRuleName
  }

  if !tea.BoolValue(util.IsUnset(request.EventTargets)) {
    body["eventTargets"] = request.EventTargets
  }

  req := &openapi.OpenApiRequest{
    Body: util.ToJSONString(body),
  }
  params := &openapi.Params{
    Action: tea.String("CreateEventTargets"),
    Version: tea.String("2024-07-01"),
    Protocol: tea.String("HTTP"),
    Pathname: tea.String("/target/createEventTargets"),
    Method: tea.String("POST"),
    AuthType: tea.String("Anonymous"),
    Style: tea.String("RPC"),
    ReqBodyType: tea.String("json"),
    BodyType: tea.String("json"),
  }
  _result = &CreateEventTargetsResponse{}
  _body, _err := client.CallApi(params, req, runtime)
  if _err != nil {
    return _result, _err
  }
  _err = tea.Convert(_body, &_result)
  return _result, _err
}

// Summary:
// 
// Creates event targets.
// 
// Description:
// 
// You can call this operation to create event targets.
// 
// @param request - CreateEventTargetsRequest
// 
// @return CreateEventTargetsResponse
func (client *Client) CreateEventTargets (request *CreateEventTargetsRequest) (_result *CreateEventTargetsResponse, _err error) {
  runtime := &util.RuntimeOptions{}
  _result = &CreateEventTargetsResponse{}
  _body, _err := client.CreateEventTargetsWithOptions(request, runtime)
  if _err != nil {
    return _result, _err
  }
  _result = _body
  return _result, _err
}

// Summary:
// 
// Updates event targets.
// 
// Description:
// 
// You can call this operation to update event targets.
// 
// @param request - UpdateEventTargetsRequest
// 
// @param runtime - runtime options for this request RuntimeOptions
// 
// @return UpdateEventTargetsResponse
func (client *Client) UpdateEventTargetsWithOptions (request *UpdateEventTargetsRequest, runtime *util.RuntimeOptions) (_result *UpdateEventTargetsResponse, _err error) {
  _err = util.ValidateModel(request)
  if _err != nil {
    return _result, _err
  }
  body := map[string]interface{}{}
  if !tea.BoolValue(util.IsUnset(request.EventBusName)) {
    body["eventBusName"] = request.EventBusName
  }

  if !tea.BoolValue(util.IsUnset(request.EventRuleName)) {
    body["eventRuleName"] = request.EventRuleName
  }

  if !tea.BoolValue(util.IsUnset(request.EventTargets)) {
    body["eventTargets"] = request.EventTargets
  }

  req := &openapi.OpenApiRequest{
    Body: util.ToJSONString(body),
  }
  params := &openapi.Params{
    Action: tea.String("UpdateEventTargets"),
    Version: tea.String("2024-07-01"),
    Protocol: tea.String("HTTP"),
    Pathname: tea.String("/target/updateEventTargets"),
    Method: tea.String("POST"),
    AuthType: tea.String("Anonymous"),
    Style: tea.String("RPC"),
    ReqBodyType: tea.String("json"),
    BodyType: tea.String("json"),
  }
  _result = &UpdateEventTargetsResponse{}
  _body, _err := client.CallApi(params, req, runtime)
  if _err != nil {
    return _result, _err
  }
  _err = tea.Convert(_body, &_result)
  return _result, _err
}

// Summary:
// 
// Updates event targets.
// 
// Description:
// 
// You can call this operation to update event targets.
// 
// @param request - UpdateEventTargetsRequest
// 
// @return UpdateEventTargetsResponse
func (client *Client) UpdateEventTargets (request *UpdateEventTargetsRequest) (_result *UpdateEventTargetsResponse, _err error) {
  runtime := &util.RuntimeOptions{}
  _result = &UpdateEventTargetsResponse{}
  _body, _err := client.UpdateEventTargetsWithOptions(request, runtime)
  if _err != nil {
    return _result, _err
  }
  _result = _body
  return _result, _err
}

// Summary:
// 
// Deletes event targets.
// 
// Description:
// 
// You can call this operation to delete event targets.
// 
// @param request - DeleteEventTargetsRequest
// 
// @param runtime - runtime options for this request RuntimeOptions
// 
// @return DeleteEventTargetsResponse
func (client *Client) DeleteEventTargetsWithOptions (request *DeleteEventTargetsRequest, runtime *util.RuntimeOptions) (_result *DeleteEventTargetsResponse, _err error) {
  _err = util.ValidateModel(request)
  if _err != nil {
    return _result, _err
  }
  body := map[string]interface{}{}
  if !tea.BoolValue(util.IsUnset(request.EventBusName)) {
    body["eventBusName"] = request.EventBusName
  }

  if !tea.BoolValue(util.IsUnset(request.EventRuleName)) {
    body["eventRuleName"] = request.EventRuleName
  }

  if !tea.BoolValue(util.IsUnset(request.EventTargetNames)) {
    body["eventTargetNames"] = request.EventTargetNames
  }

  req := &openapi.OpenApiRequest{
    Body: util.ToJSONString(body),
  }
  params := &openapi.Params{
    Action: tea.String("DeleteEventTargets"),
    Version: tea.String("2024-07-01"),
    Protocol: tea.String("HTTP"),
    Pathname: tea.String("/target/deleteEventTargets"),
    Method: tea.String("POST"),
    AuthType: tea.String("Anonymous"),
    Style: tea.String("RPC"),
    ReqBodyType: tea.String("json"),
    BodyType: tea.String("json"),
  }
  _result = &DeleteEventTargetsResponse{}
  _body, _err := client.CallApi(params, req, runtime)
  if _err != nil {
    return _result, _err
  }
  _err = tea.Convert(_body, &_result)
  return _result, _err
}

// Summary:
// 
// Deletes event targets.
// 
// Description:
// 
// You can call this operation to delete event targets.
// 
// @param request - DeleteEventTargetsRequest
// 
// @return DeleteEventTargetsResponse
func (client *Client) DeleteEventTargets (request *DeleteEventTargetsRequest) (_result *DeleteEventTargetsResponse, _err error) {
  runtime := &util.RuntimeOptions{}
  _result = &DeleteEventTargetsResponse{}
  _body, _err := client.DeleteEventTargetsWithOptions(request, runtime)
  if _err != nil {
    return _result, _err
  }
  _result = _body
  return _result, _err
}

// Summary:
// 
// Lists event targets.
// 
// Description:
// 
// You can call this operation to list event targets.
// 
// @param request - ListEventTargetsRequest
// 
// @param runtime - runtime options for this request RuntimeOptions
// 
// @return ListEventTargetsResponse
func (client *Client) ListEventTargetsWithOptions (request *ListEventTargetsRequest, runtime *util.RuntimeOptions) (_result *ListEventTargetsResponse, _err error) {
  _err = util.ValidateModel(request)
  if _err != nil {
    return _result, _err
  }
  body := map[string]interface{}{}
  if !tea.BoolValue(util.IsUnset(request.EventBusName)) {
    body["eventBusName"] = request.EventBusName
  }

  if !tea.BoolValue(util.IsUnset(request.EventRuleName)) {
    body["eventRuleName"] = request.EventRuleName
  }

  req := &openapi.OpenApiRequest{
    Body: util.ToJSONString(body),
  }
  params := &openapi.Params{
    Action: tea.String("ListEventTargets"),
    Version: tea.String("2024-07-01"),
    Protocol: tea.String("HTTP"),
    Pathname: tea.String("/target/listEventTargets"),
    Method: tea.String("POST"),
    AuthType: tea.String("Anonymous"),
    Style: tea.String("RPC"),
    ReqBodyType: tea.String("json"),
    BodyType: tea.String("json"),
  }
  _result = &ListEventTargetsResponse{}
  _body, _err := client.CallApi(params, req, runtime)
  if _err != nil {
    return _result, _err
  }
  _err = tea.Convert(_body, &_result)
  return _result, _err
}

// Summary:
// 
// Lists event targets.
// 
// Description:
// 
// You can call this operation to list event targets.
// 
// @param request - ListEventTargetsRequest
// 
// @return ListEventTargetsResponse
func (client *Client) ListEventTargets (request *ListEventTargetsRequest) (_result *ListEventTargetsResponse, _err error) {
  runtime := &util.RuntimeOptions{}
  _result = &ListEventTargetsResponse{}
  _body, _err := client.ListEventTargetsWithOptions(request, runtime)
  if _err != nil {
    return _result, _err
  }
  _result = _body
  return _result, _err
}

// Summary:
// 
// Queries all event buses.
// 
// Description:
// 
// You can call this API operation to query all event buses.
// 
// @param request - ListEventTypesRequest
// 
// @param runtime - runtime options for this request RuntimeOptions
// 
// @return ListEventTypesResponse
func (client *Client) ListEventTypesWithOptions (request *ListEventTypesRequest, runtime *util.RuntimeOptions) (_result *ListEventTypesResponse, _err error) {
  _err = util.ValidateModel(request)
  if _err != nil {
    return _result, _err
  }
  body := map[string]interface{}{}
  if !tea.BoolValue(util.IsUnset(request.EventBusName)) {
    body["eventBusName"] = request.EventBusName
  }

  if !tea.BoolValue(util.IsUnset(request.EventSourceName)) {
    body["eventSourceName"] = request.EventSourceName
  }

  if !tea.BoolValue(util.IsUnset(request.MaxResults)) {
    body["maxResults"] = request.MaxResults
  }

  if !tea.BoolValue(util.IsUnset(request.NextToken)) {
    body["nextToken"] = request.NextToken
  }

  req := &openapi.OpenApiRequest{
    Body: util.ToJSONString(body),
  }
  params := &openapi.Params{
    Action: tea.String("listEventTypes"),
    Version: tea.String("2024-07-01"),
    Protocol: tea.String("HTTP"),
    Pathname: tea.String("/type/listEventTypes"),
    Method: tea.String("POST"),
    AuthType: tea.String("Anonymous"),
    Style: tea.String("RPC"),
    ReqBodyType: tea.String("json"),
    BodyType: tea.String("json"),
  }
  _result = &ListEventTypesResponse{}
  _body, _err := client.CallApi(params, req, runtime)
  if _err != nil {
    return _result, _err
  }
  _err = tea.Convert(_body, &_result)
  return _result, _err
}

// Summary:
// 
// Queries all event buses.
// 
// Description:
// 
// You can call this API operation to query all event buses.
// 
// @param request - ListEventTypesRequest
// 
// @return ListEventTypesResponse
func (client *Client) ListEventTypes (request *ListEventTypesRequest) (_result *ListEventTypesResponse, _err error) {
  runtime := &util.RuntimeOptions{}
  _result = &ListEventTypesResponse{}
  _body, _err := client.ListEventTypesWithOptions(request, runtime)
  if _err != nil {
    return _result, _err
  }
  _result = _body
  return _result, _err
}

