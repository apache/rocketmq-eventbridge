# -*- coding: utf-8 -*-
# This file is auto-generated, don't edit it. Thanks.
from Tea.model import TeaModel
from typing import Dict, List, Any


class CreateEventBusRequest(TeaModel):
    """
    EventBus Controller apis:
        * createEventBus *\
        * getEventBus    *\
        * deleteEventBus *\
        * listEventBuses *\
    """
    def __init__(
        self,
        description: str = None,
        event_bus_name: str = None,
    ):
        # The description of the event bus.
        self.description = description
        # The name of the event bus. This parameter is required.
        self.event_bus_name = event_bus_name

    def validate(self):
        pass

    def to_map(self):
        _map = super().to_map()
        if _map is not None:
            return _map

        result = dict()
        if self.description is not None:
            result['description'] = self.description
        if self.event_bus_name is not None:
            result['eventBusName'] = self.event_bus_name
        return result

    def from_map(self, m: dict = None):
        m = m or dict()
        if m.get('description') is not None:
            self.description = m.get('description')
        if m.get('eventBusName') is not None:
            self.event_bus_name = m.get('eventBusName')
        return self


class CreateEventBusResponseBody(TeaModel):
    def __init__(
        self,
        code: str = None,
        event_bus_name: str = None,
        message: str = None,
        request_id: str = None,
        success: bool = None,
    ):
        # The returned response code. The value Success indicates that the request is successful. Other values indicate that the request failed. For more information about error codes, see Error codes.
        self.code = code
        # The name of the event bus. This parameter is required.
        self.event_bus_name = event_bus_name
        # The returned error message.
        self.message = message
        # The request ID.
        self.request_id = request_id
        # Indicates whether the request is successful. The value true indicates that the request is successful.
        self.success = success

    def validate(self):
        pass

    def to_map(self):
        _map = super().to_map()
        if _map is not None:
            return _map

        result = dict()
        if self.code is not None:
            result['code'] = self.code
        if self.event_bus_name is not None:
            result['eventBusName'] = self.event_bus_name
        if self.message is not None:
            result['message'] = self.message
        if self.request_id is not None:
            result['requestId'] = self.request_id
        if self.success is not None:
            result['success'] = self.success
        return result

    def from_map(self, m: dict = None):
        m = m or dict()
        if m.get('code') is not None:
            self.code = m.get('code')
        if m.get('eventBusName') is not None:
            self.event_bus_name = m.get('eventBusName')
        if m.get('message') is not None:
            self.message = m.get('message')
        if m.get('requestId') is not None:
            self.request_id = m.get('requestId')
        if m.get('success') is not None:
            self.success = m.get('success')
        return self


class CreateEventBusResponse(TeaModel):
    def __init__(
        self,
        headers: Dict[str, str] = None,
        status_code: int = None,
        body: CreateEventBusResponseBody = None,
    ):
        self.headers = headers
        self.status_code = status_code
        self.body = body

    def validate(self):
        if self.body:
            self.body.validate()

    def to_map(self):
        _map = super().to_map()
        if _map is not None:
            return _map

        result = dict()
        if self.headers is not None:
            result['headers'] = self.headers
        if self.status_code is not None:
            result['statusCode'] = self.status_code
        if self.body is not None:
            result['body'] = self.body.to_map()
        return result

    def from_map(self, m: dict = None):
        m = m or dict()
        if m.get('headers') is not None:
            self.headers = m.get('headers')
        if m.get('statusCode') is not None:
            self.status_code = m.get('statusCode')
        if m.get('body') is not None:
            temp_model = CreateEventBusResponseBody()
            self.body = temp_model.from_map(m['body'])
        return self


class GetEventBusRequest(TeaModel):
    def __init__(
        self,
        event_bus_name: str = None,
    ):
        # The name of the event bus. This parameter is required.
        self.event_bus_name = event_bus_name

    def validate(self):
        pass

    def to_map(self):
        _map = super().to_map()
        if _map is not None:
            return _map

        result = dict()
        if self.event_bus_name is not None:
            result['eventBusName'] = self.event_bus_name
        return result

    def from_map(self, m: dict = None):
        m = m or dict()
        if m.get('eventBusName') is not None:
            self.event_bus_name = m.get('eventBusName')
        return self


class GetEventBusResponseBody(TeaModel):
    def __init__(
        self,
        code: str = None,
        create_timestamp: int = None,
        description: str = None,
        event_bus_name: str = None,
        message: str = None,
        request_id: str = None,
    ):
        # The response code. The value Success indicates that the request is successful.
        self.code = code
        # The timestamp that indicates when the event bus was created.
        self.create_timestamp = create_timestamp
        # The description of the event bus.
        self.description = description
        # The name of the event bus.
        self.event_bus_name = event_bus_name
        # The error message that is returned if the request failed.
        self.message = message
        # The request ID.
        self.request_id = request_id

    def validate(self):
        pass

    def to_map(self):
        _map = super().to_map()
        if _map is not None:
            return _map

        result = dict()
        if self.code is not None:
            result['code'] = self.code
        if self.create_timestamp is not None:
            result['createTimestamp'] = self.create_timestamp
        if self.description is not None:
            result['description'] = self.description
        if self.event_bus_name is not None:
            result['eventBusName'] = self.event_bus_name
        if self.message is not None:
            result['message'] = self.message
        if self.request_id is not None:
            result['requestId'] = self.request_id
        return result

    def from_map(self, m: dict = None):
        m = m or dict()
        if m.get('code') is not None:
            self.code = m.get('code')
        if m.get('createTimestamp') is not None:
            self.create_timestamp = m.get('createTimestamp')
        if m.get('description') is not None:
            self.description = m.get('description')
        if m.get('eventBusName') is not None:
            self.event_bus_name = m.get('eventBusName')
        if m.get('message') is not None:
            self.message = m.get('message')
        if m.get('requestId') is not None:
            self.request_id = m.get('requestId')
        return self


class GetEventBusResponse(TeaModel):
    def __init__(
        self,
        headers: Dict[str, str] = None,
        status_code: int = None,
        body: GetEventBusResponseBody = None,
    ):
        self.headers = headers
        self.status_code = status_code
        self.body = body

    def validate(self):
        if self.body:
            self.body.validate()

    def to_map(self):
        _map = super().to_map()
        if _map is not None:
            return _map

        result = dict()
        if self.headers is not None:
            result['headers'] = self.headers
        if self.status_code is not None:
            result['statusCode'] = self.status_code
        if self.body is not None:
            result['body'] = self.body.to_map()
        return result

    def from_map(self, m: dict = None):
        m = m or dict()
        if m.get('headers') is not None:
            self.headers = m.get('headers')
        if m.get('statusCode') is not None:
            self.status_code = m.get('statusCode')
        if m.get('body') is not None:
            temp_model = GetEventBusResponseBody()
            self.body = temp_model.from_map(m['body'])
        return self


class ListEventBusesRequest(TeaModel):
    def __init__(
        self,
        max_results: int = None,
        next_token: str = None,
    ):
        # The maximum number of entries to be returned in a call. You can use this parameter and NextToken to implement paging. Note: Up to 100 entries can be returned in a call.
        self.max_results = max_results
        # If you set Limit and excess return values exist, this parameter is returned.
        self.next_token = next_token

    def validate(self):
        pass

    def to_map(self):
        _map = super().to_map()
        if _map is not None:
            return _map

        result = dict()
        if self.max_results is not None:
            result['maxResults'] = self.max_results
        if self.next_token is not None:
            result['nextToken'] = self.next_token
        return result

    def from_map(self, m: dict = None):
        m = m or dict()
        if m.get('maxResults') is not None:
            self.max_results = m.get('maxResults')
        if m.get('nextToken') is not None:
            self.next_token = m.get('nextToken')
        return self


class ListEventBusesResponseBodyEventBuses(TeaModel):
    def __init__(
        self,
        description: str = None,
        event_bus_name: str = None,
    ):
        # The description of the queried event bus.
        self.description = description
        # The name of the queried event bus.
        self.event_bus_name = event_bus_name

    def validate(self):
        pass

    def to_map(self):
        _map = super().to_map()
        if _map is not None:
            return _map

        result = dict()
        if self.description is not None:
            result['description'] = self.description
        if self.event_bus_name is not None:
            result['eventBusName'] = self.event_bus_name
        return result

    def from_map(self, m: dict = None):
        m = m or dict()
        if m.get('description') is not None:
            self.description = m.get('description')
        if m.get('eventBusName') is not None:
            self.event_bus_name = m.get('eventBusName')
        return self


class ListEventBusesResponseBody(TeaModel):
    def __init__(
        self,
        code: str = None,
        event_buses: List[ListEventBusesResponseBodyEventBuses] = None,
        message: str = None,
        request_id: str = None,
        next_token: str = None,
        total: int = None,
        max_results: int = None,
    ):
        # The returned HTTP status code. The HTTP status code 200 indicates that the request is successful.
        self.code = code
        # The timestamp that indicates when the event bus was created.
        self.event_buses = event_buses
        # The returned error message.
        self.message = message
        # The request ID.
        self.request_id = request_id
        # If excess return values exist, this parameter is returned.
        self.next_token = next_token
        # The total number of entries.
        self.total = total
        # If you set Limit and excess return values exist, this parameter is returned.
        self.max_results = max_results

    def validate(self):
        if self.event_buses:
            for k in self.event_buses:
                if k:
                    k.validate()

    def to_map(self):
        _map = super().to_map()
        if _map is not None:
            return _map

        result = dict()
        if self.code is not None:
            result['code'] = self.code
        result['eventBuses'] = []
        if self.event_buses is not None:
            for k in self.event_buses:
                result['eventBuses'].append(k.to_map() if k else None)
        if self.message is not None:
            result['message'] = self.message
        if self.request_id is not None:
            result['requestId'] = self.request_id
        if self.next_token is not None:
            result['nextToken'] = self.next_token
        if self.total is not None:
            result['total'] = self.total
        if self.max_results is not None:
            result['maxResults'] = self.max_results
        return result

    def from_map(self, m: dict = None):
        m = m or dict()
        if m.get('code') is not None:
            self.code = m.get('code')
        self.event_buses = []
        if m.get('eventBuses') is not None:
            for k in m.get('eventBuses'):
                temp_model = ListEventBusesResponseBodyEventBuses()
                self.event_buses.append(temp_model.from_map(k))
        if m.get('message') is not None:
            self.message = m.get('message')
        if m.get('requestId') is not None:
            self.request_id = m.get('requestId')
        if m.get('nextToken') is not None:
            self.next_token = m.get('nextToken')
        if m.get('total') is not None:
            self.total = m.get('total')
        if m.get('maxResults') is not None:
            self.max_results = m.get('maxResults')
        return self


class ListEventBusesResponse(TeaModel):
    def __init__(
        self,
        headers: Dict[str, str] = None,
        status_code: int = None,
        body: ListEventBusesResponseBody = None,
    ):
        self.headers = headers
        self.status_code = status_code
        self.body = body

    def validate(self):
        if self.body:
            self.body.validate()

    def to_map(self):
        _map = super().to_map()
        if _map is not None:
            return _map

        result = dict()
        if self.headers is not None:
            result['headers'] = self.headers
        if self.status_code is not None:
            result['statusCode'] = self.status_code
        if self.body is not None:
            result['body'] = self.body.to_map()
        return result

    def from_map(self, m: dict = None):
        m = m or dict()
        if m.get('headers') is not None:
            self.headers = m.get('headers')
        if m.get('statusCode') is not None:
            self.status_code = m.get('statusCode')
        if m.get('body') is not None:
            temp_model = ListEventBusesResponseBody()
            self.body = temp_model.from_map(m['body'])
        return self


class DeleteEventBusRequest(TeaModel):
    def __init__(
        self,
        event_bus_name: str = None,
    ):
        # The name of the event bus. This parameter is required.
        self.event_bus_name = event_bus_name

    def validate(self):
        pass

    def to_map(self):
        _map = super().to_map()
        if _map is not None:
            return _map

        result = dict()
        if self.event_bus_name is not None:
            result['eventBusName'] = self.event_bus_name
        return result

    def from_map(self, m: dict = None):
        m = m or dict()
        if m.get('eventBusName') is not None:
            self.event_bus_name = m.get('eventBusName')
        return self


class DeleteEventBusResponseBody(TeaModel):
    def __init__(
        self,
        code: str = None,
        message: str = None,
        request_id: str = None,
    ):
        # The returned HTTP status code. The HTTP status code 200 indicates that the request is successful.
        self.code = code
        # The returned error message.
        self.message = message
        # The request ID.
        self.request_id = request_id

    def validate(self):
        pass

    def to_map(self):
        _map = super().to_map()
        if _map is not None:
            return _map

        result = dict()
        if self.code is not None:
            result['code'] = self.code
        if self.message is not None:
            result['message'] = self.message
        if self.request_id is not None:
            result['requestId'] = self.request_id
        return result

    def from_map(self, m: dict = None):
        m = m or dict()
        if m.get('code') is not None:
            self.code = m.get('code')
        if m.get('message') is not None:
            self.message = m.get('message')
        if m.get('requestId') is not None:
            self.request_id = m.get('requestId')
        return self


class DeleteEventBusResponse(TeaModel):
    def __init__(
        self,
        headers: Dict[str, str] = None,
        status_code: int = None,
        body: DeleteEventBusResponseBody = None,
    ):
        self.headers = headers
        self.status_code = status_code
        self.body = body

    def validate(self):
        if self.body:
            self.body.validate()

    def to_map(self):
        _map = super().to_map()
        if _map is not None:
            return _map

        result = dict()
        if self.headers is not None:
            result['headers'] = self.headers
        if self.status_code is not None:
            result['statusCode'] = self.status_code
        if self.body is not None:
            result['body'] = self.body.to_map()
        return result

    def from_map(self, m: dict = None):
        m = m or dict()
        if m.get('headers') is not None:
            self.headers = m.get('headers')
        if m.get('statusCode') is not None:
            self.status_code = m.get('statusCode')
        if m.get('body') is not None:
            temp_model = DeleteEventBusResponseBody()
            self.body = temp_model.from_map(m['body'])
        return self


class CreateApiDestinationRequestHttpApiParametersApiParameters(TeaModel):
    def __init__(
        self,
        name: str = None,
        description: str = None,
        type: str = None,
        default_value: str = None,
        in_: str = None,
    ):
        self.name = name
        # The description of the API destination. The description can be up to 255 characters in length.
        self.description = description
        self.type = type
        self.default_value = default_value
        self.in_ = in_

    def validate(self):
        pass

    def to_map(self):
        _map = super().to_map()
        if _map is not None:
            return _map

        result = dict()
        if self.name is not None:
            result['name'] = self.name
        if self.description is not None:
            result['description'] = self.description
        if self.type is not None:
            result['type'] = self.type
        if self.default_value is not None:
            result['defaultValue'] = self.default_value
        if self.in_ is not None:
            result['in'] = self.in_
        return result

    def from_map(self, m: dict = None):
        m = m or dict()
        if m.get('name') is not None:
            self.name = m.get('name')
        if m.get('description') is not None:
            self.description = m.get('description')
        if m.get('type') is not None:
            self.type = m.get('type')
        if m.get('defaultValue') is not None:
            self.default_value = m.get('defaultValue')
        if m.get('in') is not None:
            self.in_ = m.get('in')
        return self


class CreateApiDestinationRequestHttpApiParameters(TeaModel):
    def __init__(
        self,
        endpoint: str = None,
        method: str = None,
        api_parameters: List[CreateApiDestinationRequestHttpApiParametersApiParameters] = None,
    ):
        # The endpoint of the API destination. The endpoint can be up to 127 characters in length. This parameter is required.
        self.endpoint = endpoint
        # The HTTP request method. Valid values: 
        # 
        # 
        #       *   GET 
        # 
        #       *   POST 
        # 
        #       *   HEAD 
        # 
        #       *   DELETE 
        # 
        #       *   PUT 
        # 
        #       *   PATCH 
        # 
        # 
        #       This parameter is required.
        self.method = method
        # TODO
        self.api_parameters = api_parameters

    def validate(self):
        if self.api_parameters:
            for k in self.api_parameters:
                if k:
                    k.validate()

    def to_map(self):
        _map = super().to_map()
        if _map is not None:
            return _map

        result = dict()
        if self.endpoint is not None:
            result['endpoint'] = self.endpoint
        if self.method is not None:
            result['method'] = self.method
        result['apiParameters'] = []
        if self.api_parameters is not None:
            for k in self.api_parameters:
                result['apiParameters'].append(k.to_map() if k else None)
        return result

    def from_map(self, m: dict = None):
        m = m or dict()
        if m.get('endpoint') is not None:
            self.endpoint = m.get('endpoint')
        if m.get('method') is not None:
            self.method = m.get('method')
        self.api_parameters = []
        if m.get('apiParameters') is not None:
            for k in m.get('apiParameters'):
                temp_model = CreateApiDestinationRequestHttpApiParametersApiParameters()
                self.api_parameters.append(temp_model.from_map(k))
        return self


class CreateApiDestinationRequest(TeaModel):
    """
    ApiDestination Controller apis:
        * createApiDestination *\
        * updateApiDestination *\
        * getApiDestination    *\
        * deleteApiDestination *\
        * listApiDestinations  *\
    """
    def __init__(
        self,
        api_destination_name: str = None,
        connection_name: str = None,
        description: str = None,
        http_api_parameters: CreateApiDestinationRequestHttpApiParameters = None,
        invocation_rate_limit_per_second: int = None,
    ):
        # The name of the API destination. The name must be 2 to 127 characters in length. This parameter is required.
        self.api_destination_name = api_destination_name
        # The name of the connection. The name must be 2 to 127 characters in length. Before you configure this parameter, you must call the CreateConnection operation to create a connection. Then, set this parameter to the name of the connection that you created. This parameter is required.
        self.connection_name = connection_name
        # The description of the API destination. The description can be up to 255 characters in length.
        self.description = description
        # The parameters that are configured for the API destination. This parameter is required.
        self.http_api_parameters = http_api_parameters
        # TODO
        self.invocation_rate_limit_per_second = invocation_rate_limit_per_second

    def validate(self):
        if self.http_api_parameters:
            self.http_api_parameters.validate()

    def to_map(self):
        _map = super().to_map()
        if _map is not None:
            return _map

        result = dict()
        if self.api_destination_name is not None:
            result['apiDestinationName'] = self.api_destination_name
        if self.connection_name is not None:
            result['connectionName'] = self.connection_name
        if self.description is not None:
            result['description'] = self.description
        if self.http_api_parameters is not None:
            result['httpApiParameters'] = self.http_api_parameters.to_map()
        if self.invocation_rate_limit_per_second is not None:
            result['invocationRateLimitPerSecond'] = self.invocation_rate_limit_per_second
        return result

    def from_map(self, m: dict = None):
        m = m or dict()
        if m.get('apiDestinationName') is not None:
            self.api_destination_name = m.get('apiDestinationName')
        if m.get('connectionName') is not None:
            self.connection_name = m.get('connectionName')
        if m.get('description') is not None:
            self.description = m.get('description')
        if m.get('httpApiParameters') is not None:
            temp_model = CreateApiDestinationRequestHttpApiParameters()
            self.http_api_parameters = temp_model.from_map(m['httpApiParameters'])
        if m.get('invocationRateLimitPerSecond') is not None:
            self.invocation_rate_limit_per_second = m.get('invocationRateLimitPerSecond')
        return self


class CreateApiDestinationResponseBody(TeaModel):
    def __init__(
        self,
        code: str = None,
        api_destination_name: str = None,
        message: str = None,
        request_id: str = None,
    ):
        # The returned response code. The value Success indicates that the request is successful.
        self.code = code
        # The name of the API destination.
        self.api_destination_name = api_destination_name
        # The returned message.
        self.message = message
        # The request ID.
        self.request_id = request_id

    def validate(self):
        pass

    def to_map(self):
        _map = super().to_map()
        if _map is not None:
            return _map

        result = dict()
        if self.code is not None:
            result['code'] = self.code
        if self.api_destination_name is not None:
            result['apiDestinationName'] = self.api_destination_name
        if self.message is not None:
            result['message'] = self.message
        if self.request_id is not None:
            result['requestId'] = self.request_id
        return result

    def from_map(self, m: dict = None):
        m = m or dict()
        if m.get('code') is not None:
            self.code = m.get('code')
        if m.get('apiDestinationName') is not None:
            self.api_destination_name = m.get('apiDestinationName')
        if m.get('message') is not None:
            self.message = m.get('message')
        if m.get('requestId') is not None:
            self.request_id = m.get('requestId')
        return self


class CreateApiDestinationResponse(TeaModel):
    def __init__(
        self,
        headers: Dict[str, str] = None,
        status_code: int = None,
        body: CreateApiDestinationResponseBody = None,
    ):
        self.headers = headers
        self.status_code = status_code
        self.body = body

    def validate(self):
        if self.body:
            self.body.validate()

    def to_map(self):
        _map = super().to_map()
        if _map is not None:
            return _map

        result = dict()
        if self.headers is not None:
            result['headers'] = self.headers
        if self.status_code is not None:
            result['statusCode'] = self.status_code
        if self.body is not None:
            result['body'] = self.body.to_map()
        return result

    def from_map(self, m: dict = None):
        m = m or dict()
        if m.get('headers') is not None:
            self.headers = m.get('headers')
        if m.get('statusCode') is not None:
            self.status_code = m.get('statusCode')
        if m.get('body') is not None:
            temp_model = CreateApiDestinationResponseBody()
            self.body = temp_model.from_map(m['body'])
        return self


class UpdateApiDestinationRequestHttpApiParametersApiParameters(TeaModel):
    def __init__(
        self,
        name: str = None,
        description: str = None,
        type: str = None,
        default_value: str = None,
        in_: str = None,
    ):
        self.name = name
        # The description of the API destination. The description can be up to 255 characters in length.
        self.description = description
        self.type = type
        self.default_value = default_value
        self.in_ = in_

    def validate(self):
        pass

    def to_map(self):
        _map = super().to_map()
        if _map is not None:
            return _map

        result = dict()
        if self.name is not None:
            result['name'] = self.name
        if self.description is not None:
            result['description'] = self.description
        if self.type is not None:
            result['type'] = self.type
        if self.default_value is not None:
            result['defaultValue'] = self.default_value
        if self.in_ is not None:
            result['in'] = self.in_
        return result

    def from_map(self, m: dict = None):
        m = m or dict()
        if m.get('name') is not None:
            self.name = m.get('name')
        if m.get('description') is not None:
            self.description = m.get('description')
        if m.get('type') is not None:
            self.type = m.get('type')
        if m.get('defaultValue') is not None:
            self.default_value = m.get('defaultValue')
        if m.get('in') is not None:
            self.in_ = m.get('in')
        return self


class UpdateApiDestinationRequestHttpApiParameters(TeaModel):
    def __init__(
        self,
        endpoint: str = None,
        method: str = None,
        api_parameters: List[UpdateApiDestinationRequestHttpApiParametersApiParameters] = None,
    ):
        # The endpoint of the API destination. The endpoint can be up to 127 characters in length. This parameter is required.
        self.endpoint = endpoint
        # The HTTP request method. Valid values: 
        # 
        # 
        #       *   GET 
        # 
        #       *   POST 
        # 
        #       *   HEAD 
        # 
        #       *   DELETE 
        # 
        #       *   PUT 
        # 
        #       *   PATCH 
        # 
        # 
        #       This parameter is required.
        self.method = method
        # TODO
        self.api_parameters = api_parameters

    def validate(self):
        if self.api_parameters:
            for k in self.api_parameters:
                if k:
                    k.validate()

    def to_map(self):
        _map = super().to_map()
        if _map is not None:
            return _map

        result = dict()
        if self.endpoint is not None:
            result['endpoint'] = self.endpoint
        if self.method is not None:
            result['method'] = self.method
        result['apiParameters'] = []
        if self.api_parameters is not None:
            for k in self.api_parameters:
                result['apiParameters'].append(k.to_map() if k else None)
        return result

    def from_map(self, m: dict = None):
        m = m or dict()
        if m.get('endpoint') is not None:
            self.endpoint = m.get('endpoint')
        if m.get('method') is not None:
            self.method = m.get('method')
        self.api_parameters = []
        if m.get('apiParameters') is not None:
            for k in m.get('apiParameters'):
                temp_model = UpdateApiDestinationRequestHttpApiParametersApiParameters()
                self.api_parameters.append(temp_model.from_map(k))
        return self


class UpdateApiDestinationRequest(TeaModel):
    def __init__(
        self,
        api_destination_name: str = None,
        connection_name: str = None,
        description: str = None,
        http_api_parameters: UpdateApiDestinationRequestHttpApiParameters = None,
        invocation_rate_limit_per_second: int = None,
    ):
        # The name of the API destination. The name must be 2 to 127 characters in length. This parameter is required.
        self.api_destination_name = api_destination_name
        # The name of the connection. The name must be 2 to 127 characters in length. Before you configure this parameter, you must call the CreateConnection operation to create a connection. Then, set this parameter to the name of the connection that you created. This parameter is required.
        self.connection_name = connection_name
        # The description of the API destination. The description can be up to 255 characters in length.
        self.description = description
        # The parameters that are configured for the API destination. This parameter is required.
        self.http_api_parameters = http_api_parameters
        # TODO
        self.invocation_rate_limit_per_second = invocation_rate_limit_per_second

    def validate(self):
        if self.http_api_parameters:
            self.http_api_parameters.validate()

    def to_map(self):
        _map = super().to_map()
        if _map is not None:
            return _map

        result = dict()
        if self.api_destination_name is not None:
            result['apiDestinationName'] = self.api_destination_name
        if self.connection_name is not None:
            result['connectionName'] = self.connection_name
        if self.description is not None:
            result['description'] = self.description
        if self.http_api_parameters is not None:
            result['httpApiParameters'] = self.http_api_parameters.to_map()
        if self.invocation_rate_limit_per_second is not None:
            result['invocationRateLimitPerSecond'] = self.invocation_rate_limit_per_second
        return result

    def from_map(self, m: dict = None):
        m = m or dict()
        if m.get('apiDestinationName') is not None:
            self.api_destination_name = m.get('apiDestinationName')
        if m.get('connectionName') is not None:
            self.connection_name = m.get('connectionName')
        if m.get('description') is not None:
            self.description = m.get('description')
        if m.get('httpApiParameters') is not None:
            temp_model = UpdateApiDestinationRequestHttpApiParameters()
            self.http_api_parameters = temp_model.from_map(m['httpApiParameters'])
        if m.get('invocationRateLimitPerSecond') is not None:
            self.invocation_rate_limit_per_second = m.get('invocationRateLimitPerSecond')
        return self


class UpdateApiDestinationResponseBody(TeaModel):
    def __init__(
        self,
        code: str = None,
        message: str = None,
        request_id: str = None,
    ):
        # The returned response code. The value Success indicates that the request is successful.
        self.code = code
        # The returned message.
        self.message = message
        # The request ID.
        self.request_id = request_id

    def validate(self):
        pass

    def to_map(self):
        _map = super().to_map()
        if _map is not None:
            return _map

        result = dict()
        if self.code is not None:
            result['code'] = self.code
        if self.message is not None:
            result['message'] = self.message
        if self.request_id is not None:
            result['requestId'] = self.request_id
        return result

    def from_map(self, m: dict = None):
        m = m or dict()
        if m.get('code') is not None:
            self.code = m.get('code')
        if m.get('message') is not None:
            self.message = m.get('message')
        if m.get('requestId') is not None:
            self.request_id = m.get('requestId')
        return self


class UpdateApiDestinationResponse(TeaModel):
    def __init__(
        self,
        headers: Dict[str, str] = None,
        status_code: int = None,
        body: UpdateApiDestinationResponseBody = None,
    ):
        self.headers = headers
        self.status_code = status_code
        self.body = body

    def validate(self):
        if self.body:
            self.body.validate()

    def to_map(self):
        _map = super().to_map()
        if _map is not None:
            return _map

        result = dict()
        if self.headers is not None:
            result['headers'] = self.headers
        if self.status_code is not None:
            result['statusCode'] = self.status_code
        if self.body is not None:
            result['body'] = self.body.to_map()
        return result

    def from_map(self, m: dict = None):
        m = m or dict()
        if m.get('headers') is not None:
            self.headers = m.get('headers')
        if m.get('statusCode') is not None:
            self.status_code = m.get('statusCode')
        if m.get('body') is not None:
            temp_model = UpdateApiDestinationResponseBody()
            self.body = temp_model.from_map(m['body'])
        return self


class GetApiDestinationRequest(TeaModel):
    def __init__(
        self,
        api_destination_name: str = None,
    ):
        # The name of the API destination. This parameter is required.
        self.api_destination_name = api_destination_name

    def validate(self):
        pass

    def to_map(self):
        _map = super().to_map()
        if _map is not None:
            return _map

        result = dict()
        if self.api_destination_name is not None:
            result['apiDestinationName'] = self.api_destination_name
        return result

    def from_map(self, m: dict = None):
        m = m or dict()
        if m.get('apiDestinationName') is not None:
            self.api_destination_name = m.get('apiDestinationName')
        return self


class GetApiDestinationResponseBodyHttpApiParametersApiParameters(TeaModel):
    def __init__(
        self,
        name: str = None,
        description: str = None,
        type: str = None,
        default_value: str = None,
        in_: str = None,
    ):
        self.name = name
        # The description of the API destination. The description can be up to 255 characters in length.
        self.description = description
        self.type = type
        self.default_value = default_value
        self.in_ = in_

    def validate(self):
        pass

    def to_map(self):
        _map = super().to_map()
        if _map is not None:
            return _map

        result = dict()
        if self.name is not None:
            result['name'] = self.name
        if self.description is not None:
            result['description'] = self.description
        if self.type is not None:
            result['type'] = self.type
        if self.default_value is not None:
            result['defaultValue'] = self.default_value
        if self.in_ is not None:
            result['in'] = self.in_
        return result

    def from_map(self, m: dict = None):
        m = m or dict()
        if m.get('name') is not None:
            self.name = m.get('name')
        if m.get('description') is not None:
            self.description = m.get('description')
        if m.get('type') is not None:
            self.type = m.get('type')
        if m.get('defaultValue') is not None:
            self.default_value = m.get('defaultValue')
        if m.get('in') is not None:
            self.in_ = m.get('in')
        return self


class GetApiDestinationResponseBodyHttpApiParameters(TeaModel):
    def __init__(
        self,
        endpoint: str = None,
        method: str = None,
        api_parameters: List[GetApiDestinationResponseBodyHttpApiParametersApiParameters] = None,
    ):
        # The endpoint of the API destination.
        self.endpoint = endpoint
        # The HTTP request method. Valid values:
        # 
        #       - POST
        # 
        #       - GET
        # 
        #       - DELETE
        # 
        #       - PUT
        # 
        #       - HEAD
        # 
        #       - TRACE
        # 
        #       - PATCH
        self.method = method
        # TODO
        self.api_parameters = api_parameters

    def validate(self):
        if self.api_parameters:
            for k in self.api_parameters:
                if k:
                    k.validate()

    def to_map(self):
        _map = super().to_map()
        if _map is not None:
            return _map

        result = dict()
        if self.endpoint is not None:
            result['endpoint'] = self.endpoint
        if self.method is not None:
            result['method'] = self.method
        result['apiParameters'] = []
        if self.api_parameters is not None:
            for k in self.api_parameters:
                result['apiParameters'].append(k.to_map() if k else None)
        return result

    def from_map(self, m: dict = None):
        m = m or dict()
        if m.get('endpoint') is not None:
            self.endpoint = m.get('endpoint')
        if m.get('method') is not None:
            self.method = m.get('method')
        self.api_parameters = []
        if m.get('apiParameters') is not None:
            for k in m.get('apiParameters'):
                temp_model = GetApiDestinationResponseBodyHttpApiParametersApiParameters()
                self.api_parameters.append(temp_model.from_map(k))
        return self


class GetApiDestinationResponseBody(TeaModel):
    def __init__(
        self,
        code: str = None,
        api_destination_name: str = None,
        connection_name: str = None,
        description: str = None,
        gmt_create: int = None,
        http_api_parameters: GetApiDestinationResponseBodyHttpApiParameters = None,
        invocation_rate_limit_per_second: int = None,
        message: str = None,
        request_id: str = None,
    ):
        # The returned response code. The value Success indicates that the request is successful.
        self.code = code
        # The name of the API destination.
        self.api_destination_name = api_destination_name
        # The connection name.
        self.connection_name = connection_name
        # The description of the connection.
        self.description = description
        # The time when the API destination was created.
        self.gmt_create = gmt_create
        # The request parameters that are configured for the API destination.
        self.http_api_parameters = http_api_parameters
        # TODO
        self.invocation_rate_limit_per_second = invocation_rate_limit_per_second
        # The returned message. If the request is successful, success is returned. If the request failed, an error code is returned.
        self.message = message
        # The request ID.
        self.request_id = request_id

    def validate(self):
        if self.http_api_parameters:
            self.http_api_parameters.validate()

    def to_map(self):
        _map = super().to_map()
        if _map is not None:
            return _map

        result = dict()
        if self.code is not None:
            result['code'] = self.code
        if self.api_destination_name is not None:
            result['apiDestinationName'] = self.api_destination_name
        if self.connection_name is not None:
            result['connectionName'] = self.connection_name
        if self.description is not None:
            result['description'] = self.description
        if self.gmt_create is not None:
            result['gmtCreate'] = self.gmt_create
        if self.http_api_parameters is not None:
            result['httpApiParameters'] = self.http_api_parameters.to_map()
        if self.invocation_rate_limit_per_second is not None:
            result['invocationRateLimitPerSecond'] = self.invocation_rate_limit_per_second
        if self.message is not None:
            result['message'] = self.message
        if self.request_id is not None:
            result['requestId'] = self.request_id
        return result

    def from_map(self, m: dict = None):
        m = m or dict()
        if m.get('code') is not None:
            self.code = m.get('code')
        if m.get('apiDestinationName') is not None:
            self.api_destination_name = m.get('apiDestinationName')
        if m.get('connectionName') is not None:
            self.connection_name = m.get('connectionName')
        if m.get('description') is not None:
            self.description = m.get('description')
        if m.get('gmtCreate') is not None:
            self.gmt_create = m.get('gmtCreate')
        if m.get('httpApiParameters') is not None:
            temp_model = GetApiDestinationResponseBodyHttpApiParameters()
            self.http_api_parameters = temp_model.from_map(m['httpApiParameters'])
        if m.get('invocationRateLimitPerSecond') is not None:
            self.invocation_rate_limit_per_second = m.get('invocationRateLimitPerSecond')
        if m.get('message') is not None:
            self.message = m.get('message')
        if m.get('requestId') is not None:
            self.request_id = m.get('requestId')
        return self


class GetApiDestinationResponse(TeaModel):
    def __init__(
        self,
        headers: Dict[str, str] = None,
        status_code: int = None,
        body: GetApiDestinationResponseBody = None,
    ):
        self.headers = headers
        self.status_code = status_code
        self.body = body

    def validate(self):
        if self.body:
            self.body.validate()

    def to_map(self):
        _map = super().to_map()
        if _map is not None:
            return _map

        result = dict()
        if self.headers is not None:
            result['headers'] = self.headers
        if self.status_code is not None:
            result['statusCode'] = self.status_code
        if self.body is not None:
            result['body'] = self.body.to_map()
        return result

    def from_map(self, m: dict = None):
        m = m or dict()
        if m.get('headers') is not None:
            self.headers = m.get('headers')
        if m.get('statusCode') is not None:
            self.status_code = m.get('statusCode')
        if m.get('body') is not None:
            temp_model = GetApiDestinationResponseBody()
            self.body = temp_model.from_map(m['body'])
        return self


class DeleteApiDestinationRequest(TeaModel):
    def __init__(
        self,
        api_destination_name: str = None,
    ):
        # The name of the API destination. This parameter is required.
        self.api_destination_name = api_destination_name

    def validate(self):
        pass

    def to_map(self):
        _map = super().to_map()
        if _map is not None:
            return _map

        result = dict()
        if self.api_destination_name is not None:
            result['apiDestinationName'] = self.api_destination_name
        return result

    def from_map(self, m: dict = None):
        m = m or dict()
        if m.get('apiDestinationName') is not None:
            self.api_destination_name = m.get('apiDestinationName')
        return self


class DeleteApiDestinationResponseBody(TeaModel):
    def __init__(
        self,
        code: str = None,
        message: str = None,
        request_id: str = None,
    ):
        # The returned response code. The value Success indicates that the request is successful.
        self.code = code
        # The returned message. If the request is successful, success is returned. If the request failed, an error code is returned.
        self.message = message
        # The request ID.
        self.request_id = request_id

    def validate(self):
        pass

    def to_map(self):
        _map = super().to_map()
        if _map is not None:
            return _map

        result = dict()
        if self.code is not None:
            result['code'] = self.code
        if self.message is not None:
            result['message'] = self.message
        if self.request_id is not None:
            result['requestId'] = self.request_id
        return result

    def from_map(self, m: dict = None):
        m = m or dict()
        if m.get('code') is not None:
            self.code = m.get('code')
        if m.get('message') is not None:
            self.message = m.get('message')
        if m.get('requestId') is not None:
            self.request_id = m.get('requestId')
        return self


class DeleteApiDestinationResponse(TeaModel):
    def __init__(
        self,
        headers: Dict[str, str] = None,
        status_code: int = None,
        body: DeleteApiDestinationResponseBody = None,
    ):
        self.headers = headers
        self.status_code = status_code
        self.body = body

    def validate(self):
        if self.body:
            self.body.validate()

    def to_map(self):
        _map = super().to_map()
        if _map is not None:
            return _map

        result = dict()
        if self.headers is not None:
            result['headers'] = self.headers
        if self.status_code is not None:
            result['statusCode'] = self.status_code
        if self.body is not None:
            result['body'] = self.body.to_map()
        return result

    def from_map(self, m: dict = None):
        m = m or dict()
        if m.get('headers') is not None:
            self.headers = m.get('headers')
        if m.get('statusCode') is not None:
            self.status_code = m.get('statusCode')
        if m.get('body') is not None:
            temp_model = DeleteApiDestinationResponseBody()
            self.body = temp_model.from_map(m['body'])
        return self


class ListApiDestinationsRequest(TeaModel):
    def __init__(
        self,
        api_destination_name_prefix: str = None,
        connection_name: str = None,
        max_results: int = None,
        next_token: str = None,
    ):
        # The prefix of the API destination name.
        self.api_destination_name_prefix = api_destination_name_prefix
        # The connection name.
        self.connection_name = connection_name
        # The maximum number of entries to be returned in a call. You can use this parameter and NextToken to implement paging. 
        # 
        #     *   Default value: 10.
        self.max_results = max_results
        # If you set Limit and excess return values exist, this parameter is returned.
        # 
        #     *   Default value: 0.
        self.next_token = next_token

    def validate(self):
        pass

    def to_map(self):
        _map = super().to_map()
        if _map is not None:
            return _map

        result = dict()
        if self.api_destination_name_prefix is not None:
            result['apiDestinationNamePrefix'] = self.api_destination_name_prefix
        if self.connection_name is not None:
            result['connectionName'] = self.connection_name
        if self.max_results is not None:
            result['maxResults'] = self.max_results
        if self.next_token is not None:
            result['nextToken'] = self.next_token
        return result

    def from_map(self, m: dict = None):
        m = m or dict()
        if m.get('apiDestinationNamePrefix') is not None:
            self.api_destination_name_prefix = m.get('apiDestinationNamePrefix')
        if m.get('connectionName') is not None:
            self.connection_name = m.get('connectionName')
        if m.get('maxResults') is not None:
            self.max_results = m.get('maxResults')
        if m.get('nextToken') is not None:
            self.next_token = m.get('nextToken')
        return self


class ListApiDestinationsResponseBodyApiDestinationsHttpApiParametersApiParameters(TeaModel):
    def __init__(
        self,
        name: str = None,
        description: str = None,
        type: str = None,
        default_value: str = None,
        in_: str = None,
    ):
        self.name = name
        # The description of the API destination. The description can be up to 255 characters in length.
        self.description = description
        self.type = type
        self.default_value = default_value
        self.in_ = in_

    def validate(self):
        pass

    def to_map(self):
        _map = super().to_map()
        if _map is not None:
            return _map

        result = dict()
        if self.name is not None:
            result['name'] = self.name
        if self.description is not None:
            result['description'] = self.description
        if self.type is not None:
            result['type'] = self.type
        if self.default_value is not None:
            result['defaultValue'] = self.default_value
        if self.in_ is not None:
            result['in'] = self.in_
        return result

    def from_map(self, m: dict = None):
        m = m or dict()
        if m.get('name') is not None:
            self.name = m.get('name')
        if m.get('description') is not None:
            self.description = m.get('description')
        if m.get('type') is not None:
            self.type = m.get('type')
        if m.get('defaultValue') is not None:
            self.default_value = m.get('defaultValue')
        if m.get('in') is not None:
            self.in_ = m.get('in')
        return self


class ListApiDestinationsResponseBodyApiDestinationsHttpApiParameters(TeaModel):
    def __init__(
        self,
        endpoint: str = None,
        method: str = None,
        api_parameters: List[ListApiDestinationsResponseBodyApiDestinationsHttpApiParametersApiParameters] = None,
    ):
        # The endpoint of the API destination.
        self.endpoint = endpoint
        # The HTTP request method. Valid values:
        # 
        #           - POST
        # 
        #           - GET
        # 
        #           - DELETE
        # 
        #           - PUT
        # 
        #           - HEAD
        # 
        #           - TRACE
        # 
        #           - PATCH
        self.method = method
        # TODO
        self.api_parameters = api_parameters

    def validate(self):
        if self.api_parameters:
            for k in self.api_parameters:
                if k:
                    k.validate()

    def to_map(self):
        _map = super().to_map()
        if _map is not None:
            return _map

        result = dict()
        if self.endpoint is not None:
            result['endpoint'] = self.endpoint
        if self.method is not None:
            result['method'] = self.method
        result['apiParameters'] = []
        if self.api_parameters is not None:
            for k in self.api_parameters:
                result['apiParameters'].append(k.to_map() if k else None)
        return result

    def from_map(self, m: dict = None):
        m = m or dict()
        if m.get('endpoint') is not None:
            self.endpoint = m.get('endpoint')
        if m.get('method') is not None:
            self.method = m.get('method')
        self.api_parameters = []
        if m.get('apiParameters') is not None:
            for k in m.get('apiParameters'):
                temp_model = ListApiDestinationsResponseBodyApiDestinationsHttpApiParametersApiParameters()
                self.api_parameters.append(temp_model.from_map(k))
        return self


class ListApiDestinationsResponseBodyApiDestinations(TeaModel):
    def __init__(
        self,
        api_destination_name: str = None,
        connection_name: str = None,
        description: str = None,
        gmt_create: int = None,
        http_api_parameters: ListApiDestinationsResponseBodyApiDestinationsHttpApiParameters = None,
        invocation_rate_limit_per_second: int = None,
    ):
        # The name of the API destination.
        self.api_destination_name = api_destination_name
        # The connection name.
        self.connection_name = connection_name
        # The description of the connection.
        self.description = description
        # The time when the API destination was created.
        self.gmt_create = gmt_create
        # The request parameters that are configured for the API destination.
        self.http_api_parameters = http_api_parameters
        # TODO
        self.invocation_rate_limit_per_second = invocation_rate_limit_per_second

    def validate(self):
        if self.http_api_parameters:
            self.http_api_parameters.validate()

    def to_map(self):
        _map = super().to_map()
        if _map is not None:
            return _map

        result = dict()
        if self.api_destination_name is not None:
            result['apiDestinationName'] = self.api_destination_name
        if self.connection_name is not None:
            result['connectionName'] = self.connection_name
        if self.description is not None:
            result['description'] = self.description
        if self.gmt_create is not None:
            result['gmtCreate'] = self.gmt_create
        if self.http_api_parameters is not None:
            result['httpApiParameters'] = self.http_api_parameters.to_map()
        if self.invocation_rate_limit_per_second is not None:
            result['invocationRateLimitPerSecond'] = self.invocation_rate_limit_per_second
        return result

    def from_map(self, m: dict = None):
        m = m or dict()
        if m.get('apiDestinationName') is not None:
            self.api_destination_name = m.get('apiDestinationName')
        if m.get('connectionName') is not None:
            self.connection_name = m.get('connectionName')
        if m.get('description') is not None:
            self.description = m.get('description')
        if m.get('gmtCreate') is not None:
            self.gmt_create = m.get('gmtCreate')
        if m.get('httpApiParameters') is not None:
            temp_model = ListApiDestinationsResponseBodyApiDestinationsHttpApiParameters()
            self.http_api_parameters = temp_model.from_map(m['httpApiParameters'])
        if m.get('invocationRateLimitPerSecond') is not None:
            self.invocation_rate_limit_per_second = m.get('invocationRateLimitPerSecond')
        return self


class ListApiDestinationsResponseBody(TeaModel):
    def __init__(
        self,
        code: str = None,
        api_destinations: List[ListApiDestinationsResponseBodyApiDestinations] = None,
        max_results: int = None,
        next_token: str = None,
        total: int = None,
        message: str = None,
        request_id: str = None,
    ):
        # The returned response code. The value Success indicates that the request is successful.
        self.code = code
        # The API destinations.
        self.api_destinations = api_destinations
        # The maximum number of entries returned per page.
        self.max_results = max_results
        # If excess return values exist, this parameter is returned.
        self.next_token = next_token
        # The total number of entries returned.
        self.total = total
        # The returned message. If the request is successful, success is returned. If the request failed, an error code is returned.
        self.message = message
        # The request ID.
        self.request_id = request_id

    def validate(self):
        if self.api_destinations:
            for k in self.api_destinations:
                if k:
                    k.validate()

    def to_map(self):
        _map = super().to_map()
        if _map is not None:
            return _map

        result = dict()
        if self.code is not None:
            result['code'] = self.code
        result['apiDestinations'] = []
        if self.api_destinations is not None:
            for k in self.api_destinations:
                result['apiDestinations'].append(k.to_map() if k else None)
        if self.max_results is not None:
            result['maxResults'] = self.max_results
        if self.next_token is not None:
            result['nextToken'] = self.next_token
        if self.total is not None:
            result['total'] = self.total
        if self.message is not None:
            result['message'] = self.message
        if self.request_id is not None:
            result['requestId'] = self.request_id
        return result

    def from_map(self, m: dict = None):
        m = m or dict()
        if m.get('code') is not None:
            self.code = m.get('code')
        self.api_destinations = []
        if m.get('apiDestinations') is not None:
            for k in m.get('apiDestinations'):
                temp_model = ListApiDestinationsResponseBodyApiDestinations()
                self.api_destinations.append(temp_model.from_map(k))
        if m.get('maxResults') is not None:
            self.max_results = m.get('maxResults')
        if m.get('nextToken') is not None:
            self.next_token = m.get('nextToken')
        if m.get('total') is not None:
            self.total = m.get('total')
        if m.get('message') is not None:
            self.message = m.get('message')
        if m.get('requestId') is not None:
            self.request_id = m.get('requestId')
        return self


class ListApiDestinationsResponse(TeaModel):
    def __init__(
        self,
        headers: Dict[str, str] = None,
        status_code: int = None,
        body: ListApiDestinationsResponseBody = None,
    ):
        self.headers = headers
        self.status_code = status_code
        self.body = body

    def validate(self):
        if self.body:
            self.body.validate()

    def to_map(self):
        _map = super().to_map()
        if _map is not None:
            return _map

        result = dict()
        if self.headers is not None:
            result['headers'] = self.headers
        if self.status_code is not None:
            result['statusCode'] = self.status_code
        if self.body is not None:
            result['body'] = self.body.to_map()
        return result

    def from_map(self, m: dict = None):
        m = m or dict()
        if m.get('headers') is not None:
            self.headers = m.get('headers')
        if m.get('statusCode') is not None:
            self.status_code = m.get('statusCode')
        if m.get('body') is not None:
            temp_model = ListApiDestinationsResponseBody()
            self.body = temp_model.from_map(m['body'])
        return self


class CreateConnectionRequestAuthParametersApiKeyAuthParameters(TeaModel):
    def __init__(
        self,
        api_key_name: str = None,
        api_key_value: str = None,
    ):
        # The key of the API key.
        self.api_key_name = api_key_name
        # The value of the API key.
        self.api_key_value = api_key_value

    def validate(self):
        pass

    def to_map(self):
        _map = super().to_map()
        if _map is not None:
            return _map

        result = dict()
        if self.api_key_name is not None:
            result['apiKeyName'] = self.api_key_name
        if self.api_key_value is not None:
            result['apiKeyValue'] = self.api_key_value
        return result

    def from_map(self, m: dict = None):
        m = m or dict()
        if m.get('apiKeyName') is not None:
            self.api_key_name = m.get('apiKeyName')
        if m.get('apiKeyValue') is not None:
            self.api_key_value = m.get('apiKeyValue')
        return self


class CreateConnectionRequestAuthParametersBasicAuthParameters(TeaModel):
    def __init__(
        self,
        password: str = None,
        username: str = None,
    ):
        # The password for basic authentication.
        self.password = password
        # The username for basic authentication.
        self.username = username

    def validate(self):
        pass

    def to_map(self):
        _map = super().to_map()
        if _map is not None:
            return _map

        result = dict()
        if self.password is not None:
            result['password'] = self.password
        if self.username is not None:
            result['username'] = self.username
        return result

    def from_map(self, m: dict = None):
        m = m or dict()
        if m.get('password') is not None:
            self.password = m.get('password')
        if m.get('username') is not None:
            self.username = m.get('username')
        return self


class CreateConnectionRequestAuthParametersOauthParametersClientParameters(TeaModel):
    def __init__(
        self,
        client_id: str = None,
        client_secret: str = None,
    ):
        # The client ID.
        self.client_id = client_id
        # The client key secret of the application.
        self.client_secret = client_secret

    def validate(self):
        pass

    def to_map(self):
        _map = super().to_map()
        if _map is not None:
            return _map

        result = dict()
        if self.client_id is not None:
            result['clientID'] = self.client_id
        if self.client_secret is not None:
            result['clientSecret'] = self.client_secret
        return result

    def from_map(self, m: dict = None):
        m = m or dict()
        if m.get('clientID') is not None:
            self.client_id = m.get('clientID')
        if m.get('clientSecret') is not None:
            self.client_secret = m.get('clientSecret')
        return self


class CreateConnectionRequestAuthParametersOauthParametersOauthHttpParametersBodyParameters(TeaModel):
    def __init__(
        self,
        is_value_secret: str = None,
        key: str = None,
        value: str = None,
    ):
        # Indicates whether authentication is enabled.
        self.is_value_secret = is_value_secret
        # The key in the request body.
        self.key = key
        # The value of the key in the request body.
        self.value = value

    def validate(self):
        pass

    def to_map(self):
        _map = super().to_map()
        if _map is not None:
            return _map

        result = dict()
        if self.is_value_secret is not None:
            result['isValueSecret'] = self.is_value_secret
        if self.key is not None:
            result['key'] = self.key
        if self.value is not None:
            result['value'] = self.value
        return result

    def from_map(self, m: dict = None):
        m = m or dict()
        if m.get('isValueSecret') is not None:
            self.is_value_secret = m.get('isValueSecret')
        if m.get('key') is not None:
            self.key = m.get('key')
        if m.get('value') is not None:
            self.value = m.get('value')
        return self


class CreateConnectionRequestAuthParametersOauthParametersOauthHttpParametersHeaderParameters(TeaModel):
    def __init__(
        self,
        is_value_secret: str = None,
        key: str = None,
        value: str = None,
    ):
        # Indicates whether authentication is enabled.
        self.is_value_secret = is_value_secret
        # The key in the request header.
        self.key = key
        # The value of the key in the request header.
        self.value = value

    def validate(self):
        pass

    def to_map(self):
        _map = super().to_map()
        if _map is not None:
            return _map

        result = dict()
        if self.is_value_secret is not None:
            result['isValueSecret'] = self.is_value_secret
        if self.key is not None:
            result['key'] = self.key
        if self.value is not None:
            result['value'] = self.value
        return result

    def from_map(self, m: dict = None):
        m = m or dict()
        if m.get('isValueSecret') is not None:
            self.is_value_secret = m.get('isValueSecret')
        if m.get('key') is not None:
            self.key = m.get('key')
        if m.get('value') is not None:
            self.value = m.get('value')
        return self


class CreateConnectionRequestAuthParametersOauthParametersOauthHttpParametersQueryStringParameters(TeaModel):
    def __init__(
        self,
        is_value_secret: str = None,
        key: str = None,
        value: str = None,
    ):
        # Indicates whether authentication is enabled.
        self.is_value_secret = is_value_secret
        # The key in the request path.
        self.key = key
        # The value of the key in the request path.
        self.value = value

    def validate(self):
        pass

    def to_map(self):
        _map = super().to_map()
        if _map is not None:
            return _map

        result = dict()
        if self.is_value_secret is not None:
            result['isValueSecret'] = self.is_value_secret
        if self.key is not None:
            result['key'] = self.key
        if self.value is not None:
            result['value'] = self.value
        return result

    def from_map(self, m: dict = None):
        m = m or dict()
        if m.get('isValueSecret') is not None:
            self.is_value_secret = m.get('isValueSecret')
        if m.get('key') is not None:
            self.key = m.get('key')
        if m.get('value') is not None:
            self.value = m.get('value')
        return self


class CreateConnectionRequestAuthParametersOauthParametersOauthHttpParameters(TeaModel):
    def __init__(
        self,
        body_parameters: List[CreateConnectionRequestAuthParametersOauthParametersOauthHttpParametersBodyParameters] = None,
        header_parameters: List[CreateConnectionRequestAuthParametersOauthParametersOauthHttpParametersHeaderParameters] = None,
        query_string_parameters: List[CreateConnectionRequestAuthParametersOauthParametersOauthHttpParametersQueryStringParameters] = None,
    ):
        # The parameters that are configured for the request.
        self.body_parameters = body_parameters
        # The parameters that are configured for the request header.
        self.header_parameters = header_parameters
        # The parameters that are configured for the request path.
        self.query_string_parameters = query_string_parameters

    def validate(self):
        if self.body_parameters:
            for k in self.body_parameters:
                if k:
                    k.validate()
        if self.header_parameters:
            for k in self.header_parameters:
                if k:
                    k.validate()
        if self.query_string_parameters:
            for k in self.query_string_parameters:
                if k:
                    k.validate()

    def to_map(self):
        _map = super().to_map()
        if _map is not None:
            return _map

        result = dict()
        result['bodyParameters'] = []
        if self.body_parameters is not None:
            for k in self.body_parameters:
                result['bodyParameters'].append(k.to_map() if k else None)
        result['headerParameters'] = []
        if self.header_parameters is not None:
            for k in self.header_parameters:
                result['headerParameters'].append(k.to_map() if k else None)
        result['queryStringParameters'] = []
        if self.query_string_parameters is not None:
            for k in self.query_string_parameters:
                result['queryStringParameters'].append(k.to_map() if k else None)
        return result

    def from_map(self, m: dict = None):
        m = m or dict()
        self.body_parameters = []
        if m.get('bodyParameters') is not None:
            for k in m.get('bodyParameters'):
                temp_model = CreateConnectionRequestAuthParametersOauthParametersOauthHttpParametersBodyParameters()
                self.body_parameters.append(temp_model.from_map(k))
        self.header_parameters = []
        if m.get('headerParameters') is not None:
            for k in m.get('headerParameters'):
                temp_model = CreateConnectionRequestAuthParametersOauthParametersOauthHttpParametersHeaderParameters()
                self.header_parameters.append(temp_model.from_map(k))
        self.query_string_parameters = []
        if m.get('queryStringParameters') is not None:
            for k in m.get('queryStringParameters'):
                temp_model = CreateConnectionRequestAuthParametersOauthParametersOauthHttpParametersQueryStringParameters()
                self.query_string_parameters.append(temp_model.from_map(k))
        return self


class CreateConnectionRequestAuthParametersOauthParameters(TeaModel):
    def __init__(
        self,
        authorization_endpoint: str = None,
        client_parameters: CreateConnectionRequestAuthParametersOauthParametersClientParameters = None,
        http_method: str = None,
        oauth_http_parameters: CreateConnectionRequestAuthParametersOauthParametersOauthHttpParameters = None,
    ):
        # The endpoint that is used to obtain the OAuth token.
        self.authorization_endpoint = authorization_endpoint
        # The parameters that are configured for the client.
        self.client_parameters = client_parameters
        # The HTTP request method. Valid values:
        # 
        #         - GET
        # 
        #         - POST
        # 
        #         - HEAD
        self.http_method = http_method
        # The request parameters for OAuth authentication.
        self.oauth_http_parameters = oauth_http_parameters

    def validate(self):
        if self.client_parameters:
            self.client_parameters.validate()
        if self.oauth_http_parameters:
            self.oauth_http_parameters.validate()

    def to_map(self):
        _map = super().to_map()
        if _map is not None:
            return _map

        result = dict()
        if self.authorization_endpoint is not None:
            result['authorizationEndpoint'] = self.authorization_endpoint
        if self.client_parameters is not None:
            result['clientParameters'] = self.client_parameters.to_map()
        if self.http_method is not None:
            result['httpMethod'] = self.http_method
        if self.oauth_http_parameters is not None:
            result['oauthHttpParameters'] = self.oauth_http_parameters.to_map()
        return result

    def from_map(self, m: dict = None):
        m = m or dict()
        if m.get('authorizationEndpoint') is not None:
            self.authorization_endpoint = m.get('authorizationEndpoint')
        if m.get('clientParameters') is not None:
            temp_model = CreateConnectionRequestAuthParametersOauthParametersClientParameters()
            self.client_parameters = temp_model.from_map(m['clientParameters'])
        if m.get('httpMethod') is not None:
            self.http_method = m.get('httpMethod')
        if m.get('oauthHttpParameters') is not None:
            temp_model = CreateConnectionRequestAuthParametersOauthParametersOauthHttpParameters()
            self.oauth_http_parameters = temp_model.from_map(m['oauthHttpParameters'])
        return self


class CreateConnectionRequestAuthParameters(TeaModel):
    def __init__(
        self,
        api_key_auth_parameters: CreateConnectionRequestAuthParametersApiKeyAuthParameters = None,
        authorization_type: str = None,
        basic_auth_parameters: CreateConnectionRequestAuthParametersBasicAuthParameters = None,
        oauth_parameters: CreateConnectionRequestAuthParametersOauthParameters = None,
    ):
        # The parameters that are configured for API key authentication.
        self.api_key_auth_parameters = api_key_auth_parameters
        # The authentication type. Valid values:
        # 
        #       BASIC_AUTH: basic authentication.
        # 
        #       Introduction: Basic authentication is a simple authentication scheme built into the HTTP protocol. When you use the HTTP protocol for communications, the authentication method that the HTTP server uses to authenticate user identities on the client is defined in the protocol. The request header is in the Authorization: Basic Base64-encoded string (Username:Password) format.
        # 
        #       1.  Username and Password are required
        # 
        #       API_KEY_AUTH: API key authentication.
        # 
        #       Introduction: The request header is in the Token: Token value format.
        # 
        #       *   ApiKeyName and ApiKeyValue are required.
        # 
        #       OAUTH_AUTH: OAuth authentication.
        # 
        #       Introduction: OAuth2.0 is an authentication mechanism. In normal cases, a system that does not use OAuth2.0 can access the resources of the server from the client. To ensure access security, access tokens are used to authenticate users in OAuth 2.0. The client must use an access token to access protected resources. This way, OAuth 2.0 protects resources from being accessed from malicious clients and improves system security.
        # 
        #       *   AuthorizationEndpoint, OAuthHttpParameters, and HttpMethod are required.
        self.authorization_type = authorization_type
        # The parameters that are configured for basic authentication.
        self.basic_auth_parameters = basic_auth_parameters
        # The parameters that are configured for OAuth authentication.
        self.oauth_parameters = oauth_parameters

    def validate(self):
        if self.api_key_auth_parameters:
            self.api_key_auth_parameters.validate()
        if self.basic_auth_parameters:
            self.basic_auth_parameters.validate()
        if self.oauth_parameters:
            self.oauth_parameters.validate()

    def to_map(self):
        _map = super().to_map()
        if _map is not None:
            return _map

        result = dict()
        if self.api_key_auth_parameters is not None:
            result['apiKeyAuthParameters'] = self.api_key_auth_parameters.to_map()
        if self.authorization_type is not None:
            result['authorizationType'] = self.authorization_type
        if self.basic_auth_parameters is not None:
            result['basicAuthParameters'] = self.basic_auth_parameters.to_map()
        if self.oauth_parameters is not None:
            result['oauthParameters'] = self.oauth_parameters.to_map()
        return result

    def from_map(self, m: dict = None):
        m = m or dict()
        if m.get('apiKeyAuthParameters') is not None:
            temp_model = CreateConnectionRequestAuthParametersApiKeyAuthParameters()
            self.api_key_auth_parameters = temp_model.from_map(m['apiKeyAuthParameters'])
        if m.get('authorizationType') is not None:
            self.authorization_type = m.get('authorizationType')
        if m.get('basicAuthParameters') is not None:
            temp_model = CreateConnectionRequestAuthParametersBasicAuthParameters()
            self.basic_auth_parameters = temp_model.from_map(m['basicAuthParameters'])
        if m.get('oauthParameters') is not None:
            temp_model = CreateConnectionRequestAuthParametersOauthParameters()
            self.oauth_parameters = temp_model.from_map(m['oauthParameters'])
        return self


class CreateConnectionRequestNetworkParameters(TeaModel):
    def __init__(
        self,
        network_type: str = None,
        security_group_id: str = None,
        vpc_id: str = None,
        vswitche_id: str = None,
    ):
        # The network type. Valid values:
        # 
        #       PublicNetwork and PrivateNetwork.
        # 
        #       *   Note: If you set this parameter to PrivateNetwork, you must configure VpcId, VswitcheId, and SecurityGroupId.
        # 
        #       This parameter is required.
        self.network_type = network_type
        # The ID of the security group.
        self.security_group_id = security_group_id
        # The VPC. ID
        self.vpc_id = vpc_id
        # The vSwitch ID.
        self.vswitche_id = vswitche_id

    def validate(self):
        pass

    def to_map(self):
        _map = super().to_map()
        if _map is not None:
            return _map

        result = dict()
        if self.network_type is not None:
            result['networkType'] = self.network_type
        if self.security_group_id is not None:
            result['securityGroupId'] = self.security_group_id
        if self.vpc_id is not None:
            result['vpcId'] = self.vpc_id
        if self.vswitche_id is not None:
            result['vswitcheId'] = self.vswitche_id
        return result

    def from_map(self, m: dict = None):
        m = m or dict()
        if m.get('networkType') is not None:
            self.network_type = m.get('networkType')
        if m.get('securityGroupId') is not None:
            self.security_group_id = m.get('securityGroupId')
        if m.get('vpcId') is not None:
            self.vpc_id = m.get('vpcId')
        if m.get('vswitcheId') is not None:
            self.vswitche_id = m.get('vswitcheId')
        return self


class CreateConnectionRequest(TeaModel):
    """
    Connection Controller apis:
        * createConnection    *\
        * deleteConnection    *\
        * updateConnection    *\
        * getConnection       *\
        * selectOneConnection *\
        * listConnections     *\
        * listEnumsResponse   *\
    """
    def __init__(
        self,
        auth_parameters: CreateConnectionRequestAuthParameters = None,
        connection_name: str = None,
        description: str = None,
        network_parameters: CreateConnectionRequestNetworkParameters = None,
    ):
        # The parameters that are configured for authentication.
        self.auth_parameters = auth_parameters
        # The name of the connection. The name must be 2 to 127 characters in length.
        # 
        #     This parameter is required.
        self.connection_name = connection_name
        # The description of the connection. The description can be up to 255 characters in length.
        self.description = description
        # The parameters that are configured for the network. This parameter is required.
        self.network_parameters = network_parameters

    def validate(self):
        if self.auth_parameters:
            self.auth_parameters.validate()
        if self.network_parameters:
            self.network_parameters.validate()

    def to_map(self):
        _map = super().to_map()
        if _map is not None:
            return _map

        result = dict()
        if self.auth_parameters is not None:
            result['authParameters'] = self.auth_parameters.to_map()
        if self.connection_name is not None:
            result['connectionName'] = self.connection_name
        if self.description is not None:
            result['description'] = self.description
        if self.network_parameters is not None:
            result['networkParameters'] = self.network_parameters.to_map()
        return result

    def from_map(self, m: dict = None):
        m = m or dict()
        if m.get('authParameters') is not None:
            temp_model = CreateConnectionRequestAuthParameters()
            self.auth_parameters = temp_model.from_map(m['authParameters'])
        if m.get('connectionName') is not None:
            self.connection_name = m.get('connectionName')
        if m.get('description') is not None:
            self.description = m.get('description')
        if m.get('networkParameters') is not None:
            temp_model = CreateConnectionRequestNetworkParameters()
            self.network_parameters = temp_model.from_map(m['networkParameters'])
        return self


class CreateConnectionResponseBody(TeaModel):
    def __init__(
        self,
        code: str = None,
        connection_name: str = None,
        message: str = None,
        request_id: str = None,
    ):
        # The returned response code. The value Success indicates that the request is successful.
        self.code = code
        # The connection name.
        self.connection_name = connection_name
        # The returned message. If the request is successful, success is returned. If the request failed, an error code is returned.
        self.message = message
        # The request ID.
        self.request_id = request_id

    def validate(self):
        pass

    def to_map(self):
        _map = super().to_map()
        if _map is not None:
            return _map

        result = dict()
        if self.code is not None:
            result['code'] = self.code
        if self.connection_name is not None:
            result['connectionName'] = self.connection_name
        if self.message is not None:
            result['message'] = self.message
        if self.request_id is not None:
            result['requestId'] = self.request_id
        return result

    def from_map(self, m: dict = None):
        m = m or dict()
        if m.get('code') is not None:
            self.code = m.get('code')
        if m.get('connectionName') is not None:
            self.connection_name = m.get('connectionName')
        if m.get('message') is not None:
            self.message = m.get('message')
        if m.get('requestId') is not None:
            self.request_id = m.get('requestId')
        return self


class CreateConnectionResponse(TeaModel):
    def __init__(
        self,
        headers: Dict[str, str] = None,
        status_code: int = None,
        body: CreateConnectionResponseBody = None,
    ):
        self.headers = headers
        self.status_code = status_code
        self.body = body

    def validate(self):
        if self.body:
            self.body.validate()

    def to_map(self):
        _map = super().to_map()
        if _map is not None:
            return _map

        result = dict()
        if self.headers is not None:
            result['headers'] = self.headers
        if self.status_code is not None:
            result['statusCode'] = self.status_code
        if self.body is not None:
            result['body'] = self.body.to_map()
        return result

    def from_map(self, m: dict = None):
        m = m or dict()
        if m.get('headers') is not None:
            self.headers = m.get('headers')
        if m.get('statusCode') is not None:
            self.status_code = m.get('statusCode')
        if m.get('body') is not None:
            temp_model = CreateConnectionResponseBody()
            self.body = temp_model.from_map(m['body'])
        return self


class DeleteConnectionRequest(TeaModel):
    def __init__(
        self,
        connection_name: str = None,
    ):
        # The name of the connection that you want to delete. This parameter is required.
        self.connection_name = connection_name

    def validate(self):
        pass

    def to_map(self):
        _map = super().to_map()
        if _map is not None:
            return _map

        result = dict()
        if self.connection_name is not None:
            result['connectionName'] = self.connection_name
        return result

    def from_map(self, m: dict = None):
        m = m or dict()
        if m.get('connectionName') is not None:
            self.connection_name = m.get('connectionName')
        return self


class DeleteConnectionResponseBody(TeaModel):
    def __init__(
        self,
        code: str = None,
        message: str = None,
        request_id: str = None,
    ):
        # The returned response code. The value Success indicates that the request is successful.
        self.code = code
        # The returned message. If the request is successful, success is returned. If the request failed, an error code is returned.
        self.message = message
        # The request ID.
        self.request_id = request_id

    def validate(self):
        pass

    def to_map(self):
        _map = super().to_map()
        if _map is not None:
            return _map

        result = dict()
        if self.code is not None:
            result['code'] = self.code
        if self.message is not None:
            result['message'] = self.message
        if self.request_id is not None:
            result['requestId'] = self.request_id
        return result

    def from_map(self, m: dict = None):
        m = m or dict()
        if m.get('code') is not None:
            self.code = m.get('code')
        if m.get('message') is not None:
            self.message = m.get('message')
        if m.get('requestId') is not None:
            self.request_id = m.get('requestId')
        return self


class DeleteConnectionResponse(TeaModel):
    def __init__(
        self,
        headers: Dict[str, str] = None,
        status_code: int = None,
        body: DeleteConnectionResponseBody = None,
    ):
        self.headers = headers
        self.status_code = status_code
        self.body = body

    def validate(self):
        if self.body:
            self.body.validate()

    def to_map(self):
        _map = super().to_map()
        if _map is not None:
            return _map

        result = dict()
        if self.headers is not None:
            result['headers'] = self.headers
        if self.status_code is not None:
            result['statusCode'] = self.status_code
        if self.body is not None:
            result['body'] = self.body.to_map()
        return result

    def from_map(self, m: dict = None):
        m = m or dict()
        if m.get('headers') is not None:
            self.headers = m.get('headers')
        if m.get('statusCode') is not None:
            self.status_code = m.get('statusCode')
        if m.get('body') is not None:
            temp_model = DeleteConnectionResponseBody()
            self.body = temp_model.from_map(m['body'])
        return self


class UpdateConnectionRequestAuthParametersApiKeyAuthParameters(TeaModel):
    def __init__(
        self,
        api_key_name: str = None,
        api_key_value: str = None,
    ):
        # The key of the API key.
        self.api_key_name = api_key_name
        # The value of the API key.
        self.api_key_value = api_key_value

    def validate(self):
        pass

    def to_map(self):
        _map = super().to_map()
        if _map is not None:
            return _map

        result = dict()
        if self.api_key_name is not None:
            result['apiKeyName'] = self.api_key_name
        if self.api_key_value is not None:
            result['apiKeyValue'] = self.api_key_value
        return result

    def from_map(self, m: dict = None):
        m = m or dict()
        if m.get('apiKeyName') is not None:
            self.api_key_name = m.get('apiKeyName')
        if m.get('apiKeyValue') is not None:
            self.api_key_value = m.get('apiKeyValue')
        return self


class UpdateConnectionRequestAuthParametersBasicAuthParameters(TeaModel):
    def __init__(
        self,
        password: str = None,
        username: str = None,
    ):
        # The password for basic authentication.
        self.password = password
        # The username for basic authentication.
        self.username = username

    def validate(self):
        pass

    def to_map(self):
        _map = super().to_map()
        if _map is not None:
            return _map

        result = dict()
        if self.password is not None:
            result['password'] = self.password
        if self.username is not None:
            result['username'] = self.username
        return result

    def from_map(self, m: dict = None):
        m = m or dict()
        if m.get('password') is not None:
            self.password = m.get('password')
        if m.get('username') is not None:
            self.username = m.get('username')
        return self


class UpdateConnectionRequestAuthParametersOauthParametersClientParameters(TeaModel):
    def __init__(
        self,
        client_id: str = None,
        client_secret: str = None,
    ):
        # The client ID.
        self.client_id = client_id
        # The client key secret of the application.
        self.client_secret = client_secret

    def validate(self):
        pass

    def to_map(self):
        _map = super().to_map()
        if _map is not None:
            return _map

        result = dict()
        if self.client_id is not None:
            result['clientID'] = self.client_id
        if self.client_secret is not None:
            result['clientSecret'] = self.client_secret
        return result

    def from_map(self, m: dict = None):
        m = m or dict()
        if m.get('clientID') is not None:
            self.client_id = m.get('clientID')
        if m.get('clientSecret') is not None:
            self.client_secret = m.get('clientSecret')
        return self


class UpdateConnectionRequestAuthParametersOauthParametersOauthHttpParametersBodyParameters(TeaModel):
    def __init__(
        self,
        is_value_secret: str = None,
        key: str = None,
        value: str = None,
    ):
        # Indicates whether authentication is enabled.
        self.is_value_secret = is_value_secret
        # The key in the request body.
        self.key = key
        # The value of the key in the request body.
        self.value = value

    def validate(self):
        pass

    def to_map(self):
        _map = super().to_map()
        if _map is not None:
            return _map

        result = dict()
        if self.is_value_secret is not None:
            result['isValueSecret'] = self.is_value_secret
        if self.key is not None:
            result['key'] = self.key
        if self.value is not None:
            result['value'] = self.value
        return result

    def from_map(self, m: dict = None):
        m = m or dict()
        if m.get('isValueSecret') is not None:
            self.is_value_secret = m.get('isValueSecret')
        if m.get('key') is not None:
            self.key = m.get('key')
        if m.get('value') is not None:
            self.value = m.get('value')
        return self


class UpdateConnectionRequestAuthParametersOauthParametersOauthHttpParametersHeaderParameters(TeaModel):
    def __init__(
        self,
        is_value_secret: str = None,
        key: str = None,
        value: str = None,
    ):
        # Indicates whether authentication is enabled.
        self.is_value_secret = is_value_secret
        # The key in the request header.
        self.key = key
        # The value of the key in the request header.
        self.value = value

    def validate(self):
        pass

    def to_map(self):
        _map = super().to_map()
        if _map is not None:
            return _map

        result = dict()
        if self.is_value_secret is not None:
            result['isValueSecret'] = self.is_value_secret
        if self.key is not None:
            result['key'] = self.key
        if self.value is not None:
            result['value'] = self.value
        return result

    def from_map(self, m: dict = None):
        m = m or dict()
        if m.get('isValueSecret') is not None:
            self.is_value_secret = m.get('isValueSecret')
        if m.get('key') is not None:
            self.key = m.get('key')
        if m.get('value') is not None:
            self.value = m.get('value')
        return self


class UpdateConnectionRequestAuthParametersOauthParametersOauthHttpParametersQueryStringParameters(TeaModel):
    def __init__(
        self,
        is_value_secret: str = None,
        key: str = None,
        value: str = None,
    ):
        # Indicates whether authentication is enabled.
        self.is_value_secret = is_value_secret
        # The key in the request path.
        self.key = key
        # The value of the key in the request path.
        self.value = value

    def validate(self):
        pass

    def to_map(self):
        _map = super().to_map()
        if _map is not None:
            return _map

        result = dict()
        if self.is_value_secret is not None:
            result['isValueSecret'] = self.is_value_secret
        if self.key is not None:
            result['key'] = self.key
        if self.value is not None:
            result['value'] = self.value
        return result

    def from_map(self, m: dict = None):
        m = m or dict()
        if m.get('isValueSecret') is not None:
            self.is_value_secret = m.get('isValueSecret')
        if m.get('key') is not None:
            self.key = m.get('key')
        if m.get('value') is not None:
            self.value = m.get('value')
        return self


class UpdateConnectionRequestAuthParametersOauthParametersOauthHttpParameters(TeaModel):
    def __init__(
        self,
        body_parameters: List[UpdateConnectionRequestAuthParametersOauthParametersOauthHttpParametersBodyParameters] = None,
        header_parameters: List[UpdateConnectionRequestAuthParametersOauthParametersOauthHttpParametersHeaderParameters] = None,
        query_string_parameters: List[UpdateConnectionRequestAuthParametersOauthParametersOauthHttpParametersQueryStringParameters] = None,
    ):
        # The parameters that are configured for the request.
        self.body_parameters = body_parameters
        # The parameters that are configured for the request header.
        self.header_parameters = header_parameters
        # The parameters that are configured for the request path.
        self.query_string_parameters = query_string_parameters

    def validate(self):
        if self.body_parameters:
            for k in self.body_parameters:
                if k:
                    k.validate()
        if self.header_parameters:
            for k in self.header_parameters:
                if k:
                    k.validate()
        if self.query_string_parameters:
            for k in self.query_string_parameters:
                if k:
                    k.validate()

    def to_map(self):
        _map = super().to_map()
        if _map is not None:
            return _map

        result = dict()
        result['bodyParameters'] = []
        if self.body_parameters is not None:
            for k in self.body_parameters:
                result['bodyParameters'].append(k.to_map() if k else None)
        result['headerParameters'] = []
        if self.header_parameters is not None:
            for k in self.header_parameters:
                result['headerParameters'].append(k.to_map() if k else None)
        result['queryStringParameters'] = []
        if self.query_string_parameters is not None:
            for k in self.query_string_parameters:
                result['queryStringParameters'].append(k.to_map() if k else None)
        return result

    def from_map(self, m: dict = None):
        m = m or dict()
        self.body_parameters = []
        if m.get('bodyParameters') is not None:
            for k in m.get('bodyParameters'):
                temp_model = UpdateConnectionRequestAuthParametersOauthParametersOauthHttpParametersBodyParameters()
                self.body_parameters.append(temp_model.from_map(k))
        self.header_parameters = []
        if m.get('headerParameters') is not None:
            for k in m.get('headerParameters'):
                temp_model = UpdateConnectionRequestAuthParametersOauthParametersOauthHttpParametersHeaderParameters()
                self.header_parameters.append(temp_model.from_map(k))
        self.query_string_parameters = []
        if m.get('queryStringParameters') is not None:
            for k in m.get('queryStringParameters'):
                temp_model = UpdateConnectionRequestAuthParametersOauthParametersOauthHttpParametersQueryStringParameters()
                self.query_string_parameters.append(temp_model.from_map(k))
        return self


class UpdateConnectionRequestAuthParametersOauthParameters(TeaModel):
    def __init__(
        self,
        authorization_endpoint: str = None,
        client_parameters: UpdateConnectionRequestAuthParametersOauthParametersClientParameters = None,
        http_method: str = None,
        oauth_http_parameters: UpdateConnectionRequestAuthParametersOauthParametersOauthHttpParameters = None,
    ):
        # The endpoint that is used to obtain the OAuth token.
        self.authorization_endpoint = authorization_endpoint
        # The parameters that are configured for the client.
        self.client_parameters = client_parameters
        # The HTTP request method. Valid values:
        # 
        #         - GET
        # 
        #         - POST
        # 
        #         - HEAD
        self.http_method = http_method
        # The request parameters for OAuth authentication.
        self.oauth_http_parameters = oauth_http_parameters

    def validate(self):
        if self.client_parameters:
            self.client_parameters.validate()
        if self.oauth_http_parameters:
            self.oauth_http_parameters.validate()

    def to_map(self):
        _map = super().to_map()
        if _map is not None:
            return _map

        result = dict()
        if self.authorization_endpoint is not None:
            result['authorizationEndpoint'] = self.authorization_endpoint
        if self.client_parameters is not None:
            result['clientParameters'] = self.client_parameters.to_map()
        if self.http_method is not None:
            result['httpMethod'] = self.http_method
        if self.oauth_http_parameters is not None:
            result['oauthHttpParameters'] = self.oauth_http_parameters.to_map()
        return result

    def from_map(self, m: dict = None):
        m = m or dict()
        if m.get('authorizationEndpoint') is not None:
            self.authorization_endpoint = m.get('authorizationEndpoint')
        if m.get('clientParameters') is not None:
            temp_model = UpdateConnectionRequestAuthParametersOauthParametersClientParameters()
            self.client_parameters = temp_model.from_map(m['clientParameters'])
        if m.get('httpMethod') is not None:
            self.http_method = m.get('httpMethod')
        if m.get('oauthHttpParameters') is not None:
            temp_model = UpdateConnectionRequestAuthParametersOauthParametersOauthHttpParameters()
            self.oauth_http_parameters = temp_model.from_map(m['oauthHttpParameters'])
        return self


class UpdateConnectionRequestAuthParameters(TeaModel):
    def __init__(
        self,
        api_key_auth_parameters: UpdateConnectionRequestAuthParametersApiKeyAuthParameters = None,
        authorization_type: str = None,
        basic_auth_parameters: UpdateConnectionRequestAuthParametersBasicAuthParameters = None,
        oauth_parameters: UpdateConnectionRequestAuthParametersOauthParameters = None,
    ):
        # The parameters that are configured for API key authentication.
        self.api_key_auth_parameters = api_key_auth_parameters
        # The authentication type. Valid values:
        # 
        #       BASIC_AUTH: basic authentication.
        # 
        #       Introduction: Basic authentication is a simple authentication scheme built into the HTTP protocol. When you use the HTTP protocol for communications, the authentication method that the HTTP server uses to authenticate user identities on the client is defined in the protocol. The request header is in the Authorization: Basic Base64-encoded string (Username:Password) format.
        # 
        #       1.  Username and Password are required
        # 
        #       API_KEY_AUTH: API key authentication.
        # 
        #       Introduction: The request header is in the Token: Token value format.
        # 
        #       *   ApiKeyName and ApiKeyValue are required.
        # 
        #       OAUTH_AUTH: OAuth authentication.
        # 
        #       Introduction: OAuth2.0 is an authentication mechanism. In normal cases, a system that does not use OAuth2.0 can access the resources of the server from the client. To ensure access security, access tokens are used to authenticate users in OAuth 2.0. The client must use an access token to access protected resources. This way, OAuth 2.0 protects resources from being accessed from malicious clients and improves system security.
        # 
        #       *   AuthorizationEndpoint, OAuthHttpParameters, and HttpMethod are required.
        self.authorization_type = authorization_type
        # The parameters that are configured for basic authentication.
        self.basic_auth_parameters = basic_auth_parameters
        # The parameters that are configured for OAuth authentication.
        self.oauth_parameters = oauth_parameters

    def validate(self):
        if self.api_key_auth_parameters:
            self.api_key_auth_parameters.validate()
        if self.basic_auth_parameters:
            self.basic_auth_parameters.validate()
        if self.oauth_parameters:
            self.oauth_parameters.validate()

    def to_map(self):
        _map = super().to_map()
        if _map is not None:
            return _map

        result = dict()
        if self.api_key_auth_parameters is not None:
            result['apiKeyAuthParameters'] = self.api_key_auth_parameters.to_map()
        if self.authorization_type is not None:
            result['authorizationType'] = self.authorization_type
        if self.basic_auth_parameters is not None:
            result['basicAuthParameters'] = self.basic_auth_parameters.to_map()
        if self.oauth_parameters is not None:
            result['oauthParameters'] = self.oauth_parameters.to_map()
        return result

    def from_map(self, m: dict = None):
        m = m or dict()
        if m.get('apiKeyAuthParameters') is not None:
            temp_model = UpdateConnectionRequestAuthParametersApiKeyAuthParameters()
            self.api_key_auth_parameters = temp_model.from_map(m['apiKeyAuthParameters'])
        if m.get('authorizationType') is not None:
            self.authorization_type = m.get('authorizationType')
        if m.get('basicAuthParameters') is not None:
            temp_model = UpdateConnectionRequestAuthParametersBasicAuthParameters()
            self.basic_auth_parameters = temp_model.from_map(m['basicAuthParameters'])
        if m.get('oauthParameters') is not None:
            temp_model = UpdateConnectionRequestAuthParametersOauthParameters()
            self.oauth_parameters = temp_model.from_map(m['oauthParameters'])
        return self


class UpdateConnectionRequestNetworkParameters(TeaModel):
    def __init__(
        self,
        network_type: str = None,
        security_group_id: str = None,
        vpc_id: str = None,
        vswitche_id: str = None,
    ):
        # The network type. Valid values:
        # 
        #       PublicNetwork and PrivateNetwork.
        # 
        #       *   Note: If you set this parameter to PrivateNetwork, you must configure VpcId, VswitcheId, and SecurityGroupId.
        # 
        #       This parameter is required.
        self.network_type = network_type
        # The ID of the security group.
        self.security_group_id = security_group_id
        # The VPC. ID
        self.vpc_id = vpc_id
        # The vSwitch ID.
        self.vswitche_id = vswitche_id

    def validate(self):
        pass

    def to_map(self):
        _map = super().to_map()
        if _map is not None:
            return _map

        result = dict()
        if self.network_type is not None:
            result['networkType'] = self.network_type
        if self.security_group_id is not None:
            result['securityGroupId'] = self.security_group_id
        if self.vpc_id is not None:
            result['vpcId'] = self.vpc_id
        if self.vswitche_id is not None:
            result['vswitcheId'] = self.vswitche_id
        return result

    def from_map(self, m: dict = None):
        m = m or dict()
        if m.get('networkType') is not None:
            self.network_type = m.get('networkType')
        if m.get('securityGroupId') is not None:
            self.security_group_id = m.get('securityGroupId')
        if m.get('vpcId') is not None:
            self.vpc_id = m.get('vpcId')
        if m.get('vswitcheId') is not None:
            self.vswitche_id = m.get('vswitcheId')
        return self


class UpdateConnectionRequest(TeaModel):
    def __init__(
        self,
        auth_parameters: UpdateConnectionRequestAuthParameters = None,
        connection_name: str = None,
        description: str = None,
        network_parameters: UpdateConnectionRequestNetworkParameters = None,
    ):
        # The parameters that are configured for authentication.
        self.auth_parameters = auth_parameters
        # The name of the connection. The name must be 2 to 127 characters in length.
        # 
        #     This parameter is required.
        self.connection_name = connection_name
        # The description of the connection. The description can be up to 255 characters in length.
        self.description = description
        # The parameters that are configured for the network. This parameter is required.
        self.network_parameters = network_parameters

    def validate(self):
        if self.auth_parameters:
            self.auth_parameters.validate()
        if self.network_parameters:
            self.network_parameters.validate()

    def to_map(self):
        _map = super().to_map()
        if _map is not None:
            return _map

        result = dict()
        if self.auth_parameters is not None:
            result['authParameters'] = self.auth_parameters.to_map()
        if self.connection_name is not None:
            result['connectionName'] = self.connection_name
        if self.description is not None:
            result['description'] = self.description
        if self.network_parameters is not None:
            result['networkParameters'] = self.network_parameters.to_map()
        return result

    def from_map(self, m: dict = None):
        m = m or dict()
        if m.get('authParameters') is not None:
            temp_model = UpdateConnectionRequestAuthParameters()
            self.auth_parameters = temp_model.from_map(m['authParameters'])
        if m.get('connectionName') is not None:
            self.connection_name = m.get('connectionName')
        if m.get('description') is not None:
            self.description = m.get('description')
        if m.get('networkParameters') is not None:
            temp_model = UpdateConnectionRequestNetworkParameters()
            self.network_parameters = temp_model.from_map(m['networkParameters'])
        return self


class UpdateConnectionResponseBody(TeaModel):
    def __init__(
        self,
        code: str = None,
        message: str = None,
        request_id: str = None,
    ):
        # The returned response code.
        self.code = code
        # The returned message.
        self.message = message
        # The request ID.
        self.request_id = request_id

    def validate(self):
        pass

    def to_map(self):
        _map = super().to_map()
        if _map is not None:
            return _map

        result = dict()
        if self.code is not None:
            result['code'] = self.code
        if self.message is not None:
            result['message'] = self.message
        if self.request_id is not None:
            result['requestId'] = self.request_id
        return result

    def from_map(self, m: dict = None):
        m = m or dict()
        if m.get('code') is not None:
            self.code = m.get('code')
        if m.get('message') is not None:
            self.message = m.get('message')
        if m.get('requestId') is not None:
            self.request_id = m.get('requestId')
        return self


class UpdateConnectionResponse(TeaModel):
    def __init__(
        self,
        headers: Dict[str, str] = None,
        status_code: int = None,
        body: UpdateConnectionResponseBody = None,
    ):
        self.headers = headers
        self.status_code = status_code
        self.body = body

    def validate(self):
        if self.body:
            self.body.validate()

    def to_map(self):
        _map = super().to_map()
        if _map is not None:
            return _map

        result = dict()
        if self.headers is not None:
            result['headers'] = self.headers
        if self.status_code is not None:
            result['statusCode'] = self.status_code
        if self.body is not None:
            result['body'] = self.body.to_map()
        return result

    def from_map(self, m: dict = None):
        m = m or dict()
        if m.get('headers') is not None:
            self.headers = m.get('headers')
        if m.get('statusCode') is not None:
            self.status_code = m.get('statusCode')
        if m.get('body') is not None:
            temp_model = UpdateConnectionResponseBody()
            self.body = temp_model.from_map(m['body'])
        return self


class GetConnectionRequest(TeaModel):
    def __init__(
        self,
        connection_name: str = None,
    ):
        # The connection name. This parameter is required.
        self.connection_name = connection_name

    def validate(self):
        pass

    def to_map(self):
        _map = super().to_map()
        if _map is not None:
            return _map

        result = dict()
        if self.connection_name is not None:
            result['connectionName'] = self.connection_name
        return result

    def from_map(self, m: dict = None):
        m = m or dict()
        if m.get('connectionName') is not None:
            self.connection_name = m.get('connectionName')
        return self


class GetConnectionResponseBodyConnectionsAuthParametersApiKeyAuthParameters(TeaModel):
    def __init__(
        self,
        api_key_name: str = None,
        api_key_value: str = None,
    ):
        # The API key.
        self.api_key_name = api_key_name
        # The value of the API key.
        self.api_key_value = api_key_value

    def validate(self):
        pass

    def to_map(self):
        _map = super().to_map()
        if _map is not None:
            return _map

        result = dict()
        if self.api_key_name is not None:
            result['apiKeyName'] = self.api_key_name
        if self.api_key_value is not None:
            result['apiKeyValue'] = self.api_key_value
        return result

    def from_map(self, m: dict = None):
        m = m or dict()
        if m.get('apiKeyName') is not None:
            self.api_key_name = m.get('apiKeyName')
        if m.get('apiKeyValue') is not None:
            self.api_key_value = m.get('apiKeyValue')
        return self


class GetConnectionResponseBodyConnectionsAuthParametersBasicAuthParameters(TeaModel):
    def __init__(
        self,
        password: str = None,
        username: str = None,
    ):
        # The password for basic authentication.
        self.password = password
        # The username for basic authentication.
        self.username = username

    def validate(self):
        pass

    def to_map(self):
        _map = super().to_map()
        if _map is not None:
            return _map

        result = dict()
        if self.password is not None:
            result['password'] = self.password
        if self.username is not None:
            result['username'] = self.username
        return result

    def from_map(self, m: dict = None):
        m = m or dict()
        if m.get('password') is not None:
            self.password = m.get('password')
        if m.get('username') is not None:
            self.username = m.get('username')
        return self


class GetConnectionResponseBodyConnectionsAuthParametersOauthParametersClientParameters(TeaModel):
    def __init__(
        self,
        client_id: str = None,
        client_secret: str = None,
    ):
        # The client ID.
        self.client_id = client_id
        # The client key secret of the application.
        self.client_secret = client_secret

    def validate(self):
        pass

    def to_map(self):
        _map = super().to_map()
        if _map is not None:
            return _map

        result = dict()
        if self.client_id is not None:
            result['clientID'] = self.client_id
        if self.client_secret is not None:
            result['clientSecret'] = self.client_secret
        return result

    def from_map(self, m: dict = None):
        m = m or dict()
        if m.get('clientID') is not None:
            self.client_id = m.get('clientID')
        if m.get('clientSecret') is not None:
            self.client_secret = m.get('clientSecret')
        return self


class GetConnectionResponseBodyConnectionsAuthParametersOauthParametersOauthHttpParametersBodyParameters(TeaModel):
    def __init__(
        self,
        is_value_secret: str = None,
        key: str = None,
        value: str = None,
    ):
        # Indicates whether authentication is enabled.
        self.is_value_secret = is_value_secret
        # The key in the request body.
        self.key = key
        # The value of the key in the request body.
        self.value = value

    def validate(self):
        pass

    def to_map(self):
        _map = super().to_map()
        if _map is not None:
            return _map

        result = dict()
        if self.is_value_secret is not None:
            result['isValueSecret'] = self.is_value_secret
        if self.key is not None:
            result['key'] = self.key
        if self.value is not None:
            result['value'] = self.value
        return result

    def from_map(self, m: dict = None):
        m = m or dict()
        if m.get('isValueSecret') is not None:
            self.is_value_secret = m.get('isValueSecret')
        if m.get('key') is not None:
            self.key = m.get('key')
        if m.get('value') is not None:
            self.value = m.get('value')
        return self


class GetConnectionResponseBodyConnectionsAuthParametersOauthParametersOauthHttpParametersHeaderParameters(TeaModel):
    def __init__(
        self,
        is_value_secret: str = None,
        key: str = None,
        value: str = None,
    ):
        # Indicates whether authentication is enabled.
        self.is_value_secret = is_value_secret
        # The key in the request header.
        self.key = key
        # The value of the key in the request header.
        self.value = value

    def validate(self):
        pass

    def to_map(self):
        _map = super().to_map()
        if _map is not None:
            return _map

        result = dict()
        if self.is_value_secret is not None:
            result['isValueSecret'] = self.is_value_secret
        if self.key is not None:
            result['key'] = self.key
        if self.value is not None:
            result['value'] = self.value
        return result

    def from_map(self, m: dict = None):
        m = m or dict()
        if m.get('isValueSecret') is not None:
            self.is_value_secret = m.get('isValueSecret')
        if m.get('key') is not None:
            self.key = m.get('key')
        if m.get('value') is not None:
            self.value = m.get('value')
        return self


class GetConnectionResponseBodyConnectionsAuthParametersOauthParametersOauthHttpParametersQueryStringParameters(TeaModel):
    def __init__(
        self,
        is_value_secret: str = None,
        key: str = None,
        value: str = None,
    ):
        # Indicates whether authentication is enabled.
        self.is_value_secret = is_value_secret
        # The key in the request path.
        self.key = key
        # The value of the key in the request path.
        self.value = value

    def validate(self):
        pass

    def to_map(self):
        _map = super().to_map()
        if _map is not None:
            return _map

        result = dict()
        if self.is_value_secret is not None:
            result['isValueSecret'] = self.is_value_secret
        if self.key is not None:
            result['key'] = self.key
        if self.value is not None:
            result['value'] = self.value
        return result

    def from_map(self, m: dict = None):
        m = m or dict()
        if m.get('isValueSecret') is not None:
            self.is_value_secret = m.get('isValueSecret')
        if m.get('key') is not None:
            self.key = m.get('key')
        if m.get('value') is not None:
            self.value = m.get('value')
        return self


class GetConnectionResponseBodyConnectionsAuthParametersOauthParametersOauthHttpParameters(TeaModel):
    def __init__(
        self,
        body_parameters: List[GetConnectionResponseBodyConnectionsAuthParametersOauthParametersOauthHttpParametersBodyParameters] = None,
        header_parameters: List[GetConnectionResponseBodyConnectionsAuthParametersOauthParametersOauthHttpParametersHeaderParameters] = None,
        query_string_parameters: List[GetConnectionResponseBodyConnectionsAuthParametersOauthParametersOauthHttpParametersQueryStringParameters] = None,
    ):
        # The parameters that are configured for the request.
        self.body_parameters = body_parameters
        # The parameters that are configured for the request header.
        self.header_parameters = header_parameters
        # The parameters that are configured for the request path.
        self.query_string_parameters = query_string_parameters

    def validate(self):
        if self.body_parameters:
            for k in self.body_parameters:
                if k:
                    k.validate()
        if self.header_parameters:
            for k in self.header_parameters:
                if k:
                    k.validate()
        if self.query_string_parameters:
            for k in self.query_string_parameters:
                if k:
                    k.validate()

    def to_map(self):
        _map = super().to_map()
        if _map is not None:
            return _map

        result = dict()
        result['bodyParameters'] = []
        if self.body_parameters is not None:
            for k in self.body_parameters:
                result['bodyParameters'].append(k.to_map() if k else None)
        result['headerParameters'] = []
        if self.header_parameters is not None:
            for k in self.header_parameters:
                result['headerParameters'].append(k.to_map() if k else None)
        result['queryStringParameters'] = []
        if self.query_string_parameters is not None:
            for k in self.query_string_parameters:
                result['queryStringParameters'].append(k.to_map() if k else None)
        return result

    def from_map(self, m: dict = None):
        m = m or dict()
        self.body_parameters = []
        if m.get('bodyParameters') is not None:
            for k in m.get('bodyParameters'):
                temp_model = GetConnectionResponseBodyConnectionsAuthParametersOauthParametersOauthHttpParametersBodyParameters()
                self.body_parameters.append(temp_model.from_map(k))
        self.header_parameters = []
        if m.get('headerParameters') is not None:
            for k in m.get('headerParameters'):
                temp_model = GetConnectionResponseBodyConnectionsAuthParametersOauthParametersOauthHttpParametersHeaderParameters()
                self.header_parameters.append(temp_model.from_map(k))
        self.query_string_parameters = []
        if m.get('queryStringParameters') is not None:
            for k in m.get('queryStringParameters'):
                temp_model = GetConnectionResponseBodyConnectionsAuthParametersOauthParametersOauthHttpParametersQueryStringParameters()
                self.query_string_parameters.append(temp_model.from_map(k))
        return self


class GetConnectionResponseBodyConnectionsAuthParametersOauthParameters(TeaModel):
    def __init__(
        self,
        authorization_endpoint: str = None,
        client_parameters: GetConnectionResponseBodyConnectionsAuthParametersOauthParametersClientParameters = None,
        http_method: str = None,
        oauth_http_parameters: GetConnectionResponseBodyConnectionsAuthParametersOauthParametersOauthHttpParameters = None,
    ):
        # The endpoint that is used to obtain the OAuth token.
        self.authorization_endpoint = authorization_endpoint
        # The parameters that are configured for the client.
        self.client_parameters = client_parameters
        # The HTTP request method. Valid values:
        # 
        #             - GET
        # 
        #             - POST
        # 
        #             - HEAD
        self.http_method = http_method
        # The request parameters for OAuth authentication.
        self.oauth_http_parameters = oauth_http_parameters

    def validate(self):
        if self.client_parameters:
            self.client_parameters.validate()
        if self.oauth_http_parameters:
            self.oauth_http_parameters.validate()

    def to_map(self):
        _map = super().to_map()
        if _map is not None:
            return _map

        result = dict()
        if self.authorization_endpoint is not None:
            result['authorizationEndpoint'] = self.authorization_endpoint
        if self.client_parameters is not None:
            result['clientParameters'] = self.client_parameters.to_map()
        if self.http_method is not None:
            result['httpMethod'] = self.http_method
        if self.oauth_http_parameters is not None:
            result['oauthHttpParameters'] = self.oauth_http_parameters.to_map()
        return result

    def from_map(self, m: dict = None):
        m = m or dict()
        if m.get('authorizationEndpoint') is not None:
            self.authorization_endpoint = m.get('authorizationEndpoint')
        if m.get('clientParameters') is not None:
            temp_model = GetConnectionResponseBodyConnectionsAuthParametersOauthParametersClientParameters()
            self.client_parameters = temp_model.from_map(m['clientParameters'])
        if m.get('httpMethod') is not None:
            self.http_method = m.get('httpMethod')
        if m.get('oauthHttpParameters') is not None:
            temp_model = GetConnectionResponseBodyConnectionsAuthParametersOauthParametersOauthHttpParameters()
            self.oauth_http_parameters = temp_model.from_map(m['oauthHttpParameters'])
        return self


class GetConnectionResponseBodyConnectionsAuthParameters(TeaModel):
    def __init__(
        self,
        api_key_auth_parameters: GetConnectionResponseBodyConnectionsAuthParametersApiKeyAuthParameters = None,
        authorization_type: str = None,
        basic_auth_parameters: GetConnectionResponseBodyConnectionsAuthParametersBasicAuthParameters = None,
        oauth_parameters: GetConnectionResponseBodyConnectionsAuthParametersOauthParameters = None,
    ):
        # The parameters that are configured for API key authentication.
        self.api_key_auth_parameters = api_key_auth_parameters
        # The authentication type. Valid values:
        # 
        # 
        #           - BASIC_AUTH: basic authentication.
        # 
        # 
        #           - API_KEY_AUTH: API key authentication.
        # 
        # 
        #           - OAUTH_AUTH: OAuth authentication.
        self.authorization_type = authorization_type
        # The parameters that are configured for basic authentication.
        self.basic_auth_parameters = basic_auth_parameters
        # The parameters that are configured for OAuth authentication.
        self.oauth_parameters = oauth_parameters

    def validate(self):
        if self.api_key_auth_parameters:
            self.api_key_auth_parameters.validate()
        if self.basic_auth_parameters:
            self.basic_auth_parameters.validate()
        if self.oauth_parameters:
            self.oauth_parameters.validate()

    def to_map(self):
        _map = super().to_map()
        if _map is not None:
            return _map

        result = dict()
        if self.api_key_auth_parameters is not None:
            result['apiKeyAuthParameters'] = self.api_key_auth_parameters.to_map()
        if self.authorization_type is not None:
            result['authorizationType'] = self.authorization_type
        if self.basic_auth_parameters is not None:
            result['basicAuthParameters'] = self.basic_auth_parameters.to_map()
        if self.oauth_parameters is not None:
            result['oauthParameters'] = self.oauth_parameters.to_map()
        return result

    def from_map(self, m: dict = None):
        m = m or dict()
        if m.get('apiKeyAuthParameters') is not None:
            temp_model = GetConnectionResponseBodyConnectionsAuthParametersApiKeyAuthParameters()
            self.api_key_auth_parameters = temp_model.from_map(m['apiKeyAuthParameters'])
        if m.get('authorizationType') is not None:
            self.authorization_type = m.get('authorizationType')
        if m.get('basicAuthParameters') is not None:
            temp_model = GetConnectionResponseBodyConnectionsAuthParametersBasicAuthParameters()
            self.basic_auth_parameters = temp_model.from_map(m['basicAuthParameters'])
        if m.get('oauthParameters') is not None:
            temp_model = GetConnectionResponseBodyConnectionsAuthParametersOauthParameters()
            self.oauth_parameters = temp_model.from_map(m['oauthParameters'])
        return self


class GetConnectionResponseBodyConnectionsNetworkParameters(TeaModel):
    def __init__(
        self,
        network_type: str = None,
        security_group_id: str = None,
        vpc_id: str = None,
        vswitche_id: str = None,
    ):
        # The network type. Valid values:PublicNetwork and PrivateNetwork.
        self.network_type = network_type
        # The security group ID.
        self.security_group_id = security_group_id
        # The virtual private cloud (VPC) ID.
        self.vpc_id = vpc_id
        # The vSwitch ID.
        self.vswitche_id = vswitche_id

    def validate(self):
        pass

    def to_map(self):
        _map = super().to_map()
        if _map is not None:
            return _map

        result = dict()
        if self.network_type is not None:
            result['networkType'] = self.network_type
        if self.security_group_id is not None:
            result['securityGroupId'] = self.security_group_id
        if self.vpc_id is not None:
            result['vpcId'] = self.vpc_id
        if self.vswitche_id is not None:
            result['vswitcheId'] = self.vswitche_id
        return result

    def from_map(self, m: dict = None):
        m = m or dict()
        if m.get('networkType') is not None:
            self.network_type = m.get('networkType')
        if m.get('securityGroupId') is not None:
            self.security_group_id = m.get('securityGroupId')
        if m.get('vpcId') is not None:
            self.vpc_id = m.get('vpcId')
        if m.get('vswitcheId') is not None:
            self.vswitche_id = m.get('vswitcheId')
        return self


class GetConnectionResponseBodyConnections(TeaModel):
    def __init__(
        self,
        auth_parameters: GetConnectionResponseBodyConnectionsAuthParameters = None,
        connection_name: str = None,
        description: str = None,
        gmt_create: int = None,
        id: int = None,
        network_parameters: GetConnectionResponseBodyConnectionsNetworkParameters = None,
    ):
        # The parameters that are configured for authentication.
        self.auth_parameters = auth_parameters
        # The connection name.
        self.connection_name = connection_name
        # The connection description.
        self.description = description
        # The time when the connection was created.
        self.gmt_create = gmt_create
        # The connection ID.
        self.id = id
        self.network_parameters = network_parameters

    def validate(self):
        if self.auth_parameters:
            self.auth_parameters.validate()
        if self.network_parameters:
            self.network_parameters.validate()

    def to_map(self):
        _map = super().to_map()
        if _map is not None:
            return _map

        result = dict()
        if self.auth_parameters is not None:
            result['authParameters'] = self.auth_parameters.to_map()
        if self.connection_name is not None:
            result['connectionName'] = self.connection_name
        if self.description is not None:
            result['description'] = self.description
        if self.gmt_create is not None:
            result['gmtCreate'] = self.gmt_create
        if self.id is not None:
            result['id'] = self.id
        if self.network_parameters is not None:
            result['networkParameters'] = self.network_parameters.to_map()
        return result

    def from_map(self, m: dict = None):
        m = m or dict()
        if m.get('authParameters') is not None:
            temp_model = GetConnectionResponseBodyConnectionsAuthParameters()
            self.auth_parameters = temp_model.from_map(m['authParameters'])
        if m.get('connectionName') is not None:
            self.connection_name = m.get('connectionName')
        if m.get('description') is not None:
            self.description = m.get('description')
        if m.get('gmtCreate') is not None:
            self.gmt_create = m.get('gmtCreate')
        if m.get('id') is not None:
            self.id = m.get('id')
        if m.get('networkParameters') is not None:
            temp_model = GetConnectionResponseBodyConnectionsNetworkParameters()
            self.network_parameters = temp_model.from_map(m['networkParameters'])
        return self


class GetConnectionResponseBody(TeaModel):
    def __init__(
        self,
        code: str = None,
        connections: List[GetConnectionResponseBodyConnections] = None,
        message: str = None,
        request_id: str = None,
    ):
        # The returned response code. The value Success indicates that the request is successful.
        self.code = code
        # The value of the key in the request path.
        self.connections = connections
        # The returned message.
        self.message = message
        # The returned request ID.
        self.request_id = request_id

    def validate(self):
        if self.connections:
            for k in self.connections:
                if k:
                    k.validate()

    def to_map(self):
        _map = super().to_map()
        if _map is not None:
            return _map

        result = dict()
        if self.code is not None:
            result['code'] = self.code
        result['connections'] = []
        if self.connections is not None:
            for k in self.connections:
                result['connections'].append(k.to_map() if k else None)
        if self.message is not None:
            result['message'] = self.message
        if self.request_id is not None:
            result['requestId'] = self.request_id
        return result

    def from_map(self, m: dict = None):
        m = m or dict()
        if m.get('code') is not None:
            self.code = m.get('code')
        self.connections = []
        if m.get('connections') is not None:
            for k in m.get('connections'):
                temp_model = GetConnectionResponseBodyConnections()
                self.connections.append(temp_model.from_map(k))
        if m.get('message') is not None:
            self.message = m.get('message')
        if m.get('requestId') is not None:
            self.request_id = m.get('requestId')
        return self


class GetConnectionResponse(TeaModel):
    def __init__(
        self,
        headers: Dict[str, str] = None,
        status_code: int = None,
        body: GetConnectionResponseBody = None,
    ):
        self.headers = headers
        self.status_code = status_code
        self.body = body

    def validate(self):
        if self.body:
            self.body.validate()

    def to_map(self):
        _map = super().to_map()
        if _map is not None:
            return _map

        result = dict()
        if self.headers is not None:
            result['headers'] = self.headers
        if self.status_code is not None:
            result['statusCode'] = self.status_code
        if self.body is not None:
            result['body'] = self.body.to_map()
        return result

    def from_map(self, m: dict = None):
        m = m or dict()
        if m.get('headers') is not None:
            self.headers = m.get('headers')
        if m.get('statusCode') is not None:
            self.status_code = m.get('statusCode')
        if m.get('body') is not None:
            temp_model = GetConnectionResponseBody()
            self.body = temp_model.from_map(m['body'])
        return self


class ListConnectionsRequest(TeaModel):
    def __init__(
        self,
        connection_name_prefix: str = None,
        max_results: int = None,
        next_token: str = None,
    ):
        # The key word that you specify to query connections. Connections can be queried by prefixes.
        self.connection_name_prefix = connection_name_prefix
        # The maximum number of entries to be returned in a single call. You can use this parameter and the NextToken parameter to implement paging.
        # 
        #     *   Default value: 10.
        self.max_results = max_results
        # If you set the Limit parameter and excess return values exist, this parameter is returned.
        # 
        #     *   Default value: 0.
        self.next_token = next_token

    def validate(self):
        pass

    def to_map(self):
        _map = super().to_map()
        if _map is not None:
            return _map

        result = dict()
        if self.connection_name_prefix is not None:
            result['connectionNamePrefix'] = self.connection_name_prefix
        if self.max_results is not None:
            result['maxResults'] = self.max_results
        if self.next_token is not None:
            result['nextToken'] = self.next_token
        return result

    def from_map(self, m: dict = None):
        m = m or dict()
        if m.get('connectionNamePrefix') is not None:
            self.connection_name_prefix = m.get('connectionNamePrefix')
        if m.get('maxResults') is not None:
            self.max_results = m.get('maxResults')
        if m.get('nextToken') is not None:
            self.next_token = m.get('nextToken')
        return self


class ListConnectionsResponseBodyConnectionsAuthParametersApiKeyAuthParameters(TeaModel):
    def __init__(
        self,
        api_key_name: str = None,
        api_key_value: str = None,
    ):
        # The API key.
        self.api_key_name = api_key_name
        # The value of the API key.
        self.api_key_value = api_key_value

    def validate(self):
        pass

    def to_map(self):
        _map = super().to_map()
        if _map is not None:
            return _map

        result = dict()
        if self.api_key_name is not None:
            result['apiKeyName'] = self.api_key_name
        if self.api_key_value is not None:
            result['apiKeyValue'] = self.api_key_value
        return result

    def from_map(self, m: dict = None):
        m = m or dict()
        if m.get('apiKeyName') is not None:
            self.api_key_name = m.get('apiKeyName')
        if m.get('apiKeyValue') is not None:
            self.api_key_value = m.get('apiKeyValue')
        return self


class ListConnectionsResponseBodyConnectionsAuthParametersBasicAuthParameters(TeaModel):
    def __init__(
        self,
        password: str = None,
        username: str = None,
    ):
        # The password for basic authentication.
        self.password = password
        # The username for basic authentication.
        self.username = username

    def validate(self):
        pass

    def to_map(self):
        _map = super().to_map()
        if _map is not None:
            return _map

        result = dict()
        if self.password is not None:
            result['password'] = self.password
        if self.username is not None:
            result['username'] = self.username
        return result

    def from_map(self, m: dict = None):
        m = m or dict()
        if m.get('password') is not None:
            self.password = m.get('password')
        if m.get('username') is not None:
            self.username = m.get('username')
        return self


class ListConnectionsResponseBodyConnectionsAuthParametersOauthParametersClientParameters(TeaModel):
    def __init__(
        self,
        client_id: str = None,
        client_secret: str = None,
    ):
        # The client ID.
        self.client_id = client_id
        # The client key secret of the application.
        self.client_secret = client_secret

    def validate(self):
        pass

    def to_map(self):
        _map = super().to_map()
        if _map is not None:
            return _map

        result = dict()
        if self.client_id is not None:
            result['clientID'] = self.client_id
        if self.client_secret is not None:
            result['clientSecret'] = self.client_secret
        return result

    def from_map(self, m: dict = None):
        m = m or dict()
        if m.get('clientID') is not None:
            self.client_id = m.get('clientID')
        if m.get('clientSecret') is not None:
            self.client_secret = m.get('clientSecret')
        return self


class ListConnectionsResponseBodyConnectionsAuthParametersOauthParametersOauthHttpParametersBodyParameters(TeaModel):
    def __init__(
        self,
        is_value_secret: str = None,
        key: str = None,
        value: str = None,
    ):
        # Indicates whether authentication is enabled.
        self.is_value_secret = is_value_secret
        # The key in the request body.
        self.key = key
        # The value of the key in the request body.
        self.value = value

    def validate(self):
        pass

    def to_map(self):
        _map = super().to_map()
        if _map is not None:
            return _map

        result = dict()
        if self.is_value_secret is not None:
            result['isValueSecret'] = self.is_value_secret
        if self.key is not None:
            result['key'] = self.key
        if self.value is not None:
            result['value'] = self.value
        return result

    def from_map(self, m: dict = None):
        m = m or dict()
        if m.get('isValueSecret') is not None:
            self.is_value_secret = m.get('isValueSecret')
        if m.get('key') is not None:
            self.key = m.get('key')
        if m.get('value') is not None:
            self.value = m.get('value')
        return self


class ListConnectionsResponseBodyConnectionsAuthParametersOauthParametersOauthHttpParametersHeaderParameters(TeaModel):
    def __init__(
        self,
        is_value_secret: str = None,
        key: str = None,
        value: str = None,
    ):
        # Indicates whether authentication is enabled.
        self.is_value_secret = is_value_secret
        # The key in the request header.
        self.key = key
        # The value of the key in the request header.
        self.value = value

    def validate(self):
        pass

    def to_map(self):
        _map = super().to_map()
        if _map is not None:
            return _map

        result = dict()
        if self.is_value_secret is not None:
            result['isValueSecret'] = self.is_value_secret
        if self.key is not None:
            result['key'] = self.key
        if self.value is not None:
            result['value'] = self.value
        return result

    def from_map(self, m: dict = None):
        m = m or dict()
        if m.get('isValueSecret') is not None:
            self.is_value_secret = m.get('isValueSecret')
        if m.get('key') is not None:
            self.key = m.get('key')
        if m.get('value') is not None:
            self.value = m.get('value')
        return self


class ListConnectionsResponseBodyConnectionsAuthParametersOauthParametersOauthHttpParametersQueryStringParameters(TeaModel):
    def __init__(
        self,
        is_value_secret: str = None,
        key: str = None,
        value: str = None,
    ):
        # Indicates whether authentication is enabled.
        self.is_value_secret = is_value_secret
        # The key in the request path.
        self.key = key
        # The value of the key in the request path.
        self.value = value

    def validate(self):
        pass

    def to_map(self):
        _map = super().to_map()
        if _map is not None:
            return _map

        result = dict()
        if self.is_value_secret is not None:
            result['isValueSecret'] = self.is_value_secret
        if self.key is not None:
            result['key'] = self.key
        if self.value is not None:
            result['value'] = self.value
        return result

    def from_map(self, m: dict = None):
        m = m or dict()
        if m.get('isValueSecret') is not None:
            self.is_value_secret = m.get('isValueSecret')
        if m.get('key') is not None:
            self.key = m.get('key')
        if m.get('value') is not None:
            self.value = m.get('value')
        return self


class ListConnectionsResponseBodyConnectionsAuthParametersOauthParametersOauthHttpParameters(TeaModel):
    def __init__(
        self,
        body_parameters: List[ListConnectionsResponseBodyConnectionsAuthParametersOauthParametersOauthHttpParametersBodyParameters] = None,
        header_parameters: List[ListConnectionsResponseBodyConnectionsAuthParametersOauthParametersOauthHttpParametersHeaderParameters] = None,
        query_string_parameters: List[ListConnectionsResponseBodyConnectionsAuthParametersOauthParametersOauthHttpParametersQueryStringParameters] = None,
    ):
        # The parameters that are configured for the request.
        self.body_parameters = body_parameters
        # The parameters that are configured for the request header.
        self.header_parameters = header_parameters
        # The parameters that are configured for the request path.
        self.query_string_parameters = query_string_parameters

    def validate(self):
        if self.body_parameters:
            for k in self.body_parameters:
                if k:
                    k.validate()
        if self.header_parameters:
            for k in self.header_parameters:
                if k:
                    k.validate()
        if self.query_string_parameters:
            for k in self.query_string_parameters:
                if k:
                    k.validate()

    def to_map(self):
        _map = super().to_map()
        if _map is not None:
            return _map

        result = dict()
        result['bodyParameters'] = []
        if self.body_parameters is not None:
            for k in self.body_parameters:
                result['bodyParameters'].append(k.to_map() if k else None)
        result['headerParameters'] = []
        if self.header_parameters is not None:
            for k in self.header_parameters:
                result['headerParameters'].append(k.to_map() if k else None)
        result['queryStringParameters'] = []
        if self.query_string_parameters is not None:
            for k in self.query_string_parameters:
                result['queryStringParameters'].append(k.to_map() if k else None)
        return result

    def from_map(self, m: dict = None):
        m = m or dict()
        self.body_parameters = []
        if m.get('bodyParameters') is not None:
            for k in m.get('bodyParameters'):
                temp_model = ListConnectionsResponseBodyConnectionsAuthParametersOauthParametersOauthHttpParametersBodyParameters()
                self.body_parameters.append(temp_model.from_map(k))
        self.header_parameters = []
        if m.get('headerParameters') is not None:
            for k in m.get('headerParameters'):
                temp_model = ListConnectionsResponseBodyConnectionsAuthParametersOauthParametersOauthHttpParametersHeaderParameters()
                self.header_parameters.append(temp_model.from_map(k))
        self.query_string_parameters = []
        if m.get('queryStringParameters') is not None:
            for k in m.get('queryStringParameters'):
                temp_model = ListConnectionsResponseBodyConnectionsAuthParametersOauthParametersOauthHttpParametersQueryStringParameters()
                self.query_string_parameters.append(temp_model.from_map(k))
        return self


class ListConnectionsResponseBodyConnectionsAuthParametersOauthParameters(TeaModel):
    def __init__(
        self,
        authorization_endpoint: str = None,
        client_parameters: ListConnectionsResponseBodyConnectionsAuthParametersOauthParametersClientParameters = None,
        http_method: str = None,
        oauth_http_parameters: ListConnectionsResponseBodyConnectionsAuthParametersOauthParametersOauthHttpParameters = None,
    ):
        # The endpoint that is used to obtain the OAuth token.
        self.authorization_endpoint = authorization_endpoint
        # The parameters that are configured for the client.
        self.client_parameters = client_parameters
        # The HTTP request method. Valid values:
        # 
        #             - GET
        # 
        #             - POST
        # 
        #             - HEAD
        self.http_method = http_method
        # The request parameters for OAuth authentication.
        self.oauth_http_parameters = oauth_http_parameters

    def validate(self):
        if self.client_parameters:
            self.client_parameters.validate()
        if self.oauth_http_parameters:
            self.oauth_http_parameters.validate()

    def to_map(self):
        _map = super().to_map()
        if _map is not None:
            return _map

        result = dict()
        if self.authorization_endpoint is not None:
            result['authorizationEndpoint'] = self.authorization_endpoint
        if self.client_parameters is not None:
            result['clientParameters'] = self.client_parameters.to_map()
        if self.http_method is not None:
            result['httpMethod'] = self.http_method
        if self.oauth_http_parameters is not None:
            result['oauthHttpParameters'] = self.oauth_http_parameters.to_map()
        return result

    def from_map(self, m: dict = None):
        m = m or dict()
        if m.get('authorizationEndpoint') is not None:
            self.authorization_endpoint = m.get('authorizationEndpoint')
        if m.get('clientParameters') is not None:
            temp_model = ListConnectionsResponseBodyConnectionsAuthParametersOauthParametersClientParameters()
            self.client_parameters = temp_model.from_map(m['clientParameters'])
        if m.get('httpMethod') is not None:
            self.http_method = m.get('httpMethod')
        if m.get('oauthHttpParameters') is not None:
            temp_model = ListConnectionsResponseBodyConnectionsAuthParametersOauthParametersOauthHttpParameters()
            self.oauth_http_parameters = temp_model.from_map(m['oauthHttpParameters'])
        return self


class ListConnectionsResponseBodyConnectionsAuthParameters(TeaModel):
    def __init__(
        self,
        api_key_auth_parameters: ListConnectionsResponseBodyConnectionsAuthParametersApiKeyAuthParameters = None,
        authorization_type: str = None,
        basic_auth_parameters: ListConnectionsResponseBodyConnectionsAuthParametersBasicAuthParameters = None,
        oauth_parameters: ListConnectionsResponseBodyConnectionsAuthParametersOauthParameters = None,
    ):
        # The parameters that are configured for API key authentication.
        self.api_key_auth_parameters = api_key_auth_parameters
        # The authentication type. Valid values:
        # 
        # 
        #           - BASIC_AUTH: basic authentication.
        # 
        # 
        #           - API_KEY_AUTH: API key authentication.
        # 
        # 
        #           - OAUTH_AUTH: OAuth authentication.
        self.authorization_type = authorization_type
        # The parameters that are configured for basic authentication.
        self.basic_auth_parameters = basic_auth_parameters
        # The parameters that are configured for OAuth authentication.
        self.oauth_parameters = oauth_parameters

    def validate(self):
        if self.api_key_auth_parameters:
            self.api_key_auth_parameters.validate()
        if self.basic_auth_parameters:
            self.basic_auth_parameters.validate()
        if self.oauth_parameters:
            self.oauth_parameters.validate()

    def to_map(self):
        _map = super().to_map()
        if _map is not None:
            return _map

        result = dict()
        if self.api_key_auth_parameters is not None:
            result['apiKeyAuthParameters'] = self.api_key_auth_parameters.to_map()
        if self.authorization_type is not None:
            result['authorizationType'] = self.authorization_type
        if self.basic_auth_parameters is not None:
            result['basicAuthParameters'] = self.basic_auth_parameters.to_map()
        if self.oauth_parameters is not None:
            result['oauthParameters'] = self.oauth_parameters.to_map()
        return result

    def from_map(self, m: dict = None):
        m = m or dict()
        if m.get('apiKeyAuthParameters') is not None:
            temp_model = ListConnectionsResponseBodyConnectionsAuthParametersApiKeyAuthParameters()
            self.api_key_auth_parameters = temp_model.from_map(m['apiKeyAuthParameters'])
        if m.get('authorizationType') is not None:
            self.authorization_type = m.get('authorizationType')
        if m.get('basicAuthParameters') is not None:
            temp_model = ListConnectionsResponseBodyConnectionsAuthParametersBasicAuthParameters()
            self.basic_auth_parameters = temp_model.from_map(m['basicAuthParameters'])
        if m.get('oauthParameters') is not None:
            temp_model = ListConnectionsResponseBodyConnectionsAuthParametersOauthParameters()
            self.oauth_parameters = temp_model.from_map(m['oauthParameters'])
        return self


class ListConnectionsResponseBodyConnectionsNetworkParameters(TeaModel):
    def __init__(
        self,
        network_type: str = None,
        security_group_id: str = None,
        vpc_id: str = None,
        vswitche_id: str = None,
    ):
        # The network type. Valid values:PublicNetwork and PrivateNetwork.
        self.network_type = network_type
        # The security group ID.
        self.security_group_id = security_group_id
        # The virtual private cloud (VPC) ID.
        self.vpc_id = vpc_id
        # The vSwitch ID.
        self.vswitche_id = vswitche_id

    def validate(self):
        pass

    def to_map(self):
        _map = super().to_map()
        if _map is not None:
            return _map

        result = dict()
        if self.network_type is not None:
            result['networkType'] = self.network_type
        if self.security_group_id is not None:
            result['securityGroupId'] = self.security_group_id
        if self.vpc_id is not None:
            result['vpcId'] = self.vpc_id
        if self.vswitche_id is not None:
            result['vswitcheId'] = self.vswitche_id
        return result

    def from_map(self, m: dict = None):
        m = m or dict()
        if m.get('networkType') is not None:
            self.network_type = m.get('networkType')
        if m.get('securityGroupId') is not None:
            self.security_group_id = m.get('securityGroupId')
        if m.get('vpcId') is not None:
            self.vpc_id = m.get('vpcId')
        if m.get('vswitcheId') is not None:
            self.vswitche_id = m.get('vswitcheId')
        return self


class ListConnectionsResponseBodyConnections(TeaModel):
    def __init__(
        self,
        auth_parameters: ListConnectionsResponseBodyConnectionsAuthParameters = None,
        connection_name: str = None,
        description: str = None,
        gmt_create: int = None,
        id: int = None,
        network_parameters: ListConnectionsResponseBodyConnectionsNetworkParameters = None,
    ):
        # The parameters that are configured for authentication.
        self.auth_parameters = auth_parameters
        # The connection name.
        self.connection_name = connection_name
        # The connection description.
        self.description = description
        # The time when the connection was created.
        self.gmt_create = gmt_create
        # The connection ID.
        self.id = id
        self.network_parameters = network_parameters

    def validate(self):
        if self.auth_parameters:
            self.auth_parameters.validate()
        if self.network_parameters:
            self.network_parameters.validate()

    def to_map(self):
        _map = super().to_map()
        if _map is not None:
            return _map

        result = dict()
        if self.auth_parameters is not None:
            result['authParameters'] = self.auth_parameters.to_map()
        if self.connection_name is not None:
            result['connectionName'] = self.connection_name
        if self.description is not None:
            result['description'] = self.description
        if self.gmt_create is not None:
            result['gmtCreate'] = self.gmt_create
        if self.id is not None:
            result['id'] = self.id
        if self.network_parameters is not None:
            result['networkParameters'] = self.network_parameters.to_map()
        return result

    def from_map(self, m: dict = None):
        m = m or dict()
        if m.get('authParameters') is not None:
            temp_model = ListConnectionsResponseBodyConnectionsAuthParameters()
            self.auth_parameters = temp_model.from_map(m['authParameters'])
        if m.get('connectionName') is not None:
            self.connection_name = m.get('connectionName')
        if m.get('description') is not None:
            self.description = m.get('description')
        if m.get('gmtCreate') is not None:
            self.gmt_create = m.get('gmtCreate')
        if m.get('id') is not None:
            self.id = m.get('id')
        if m.get('networkParameters') is not None:
            temp_model = ListConnectionsResponseBodyConnectionsNetworkParameters()
            self.network_parameters = temp_model.from_map(m['networkParameters'])
        return self


class ListConnectionsResponseBody(TeaModel):
    def __init__(
        self,
        code: str = None,
        connections: List[ListConnectionsResponseBodyConnections] = None,
        max_results: int = None,
        next_token: str = None,
        total: int = None,
        message: str = None,
        request_id: str = None,
    ):
        # The HTTP status code. The value Success indicates that the request is successful.
        self.code = code
        # The value of the key in the request path.
        self.connections = connections
        # The number of entries returned per page.
        self.max_results = max_results
        # If excess return values exist, this parameter is returned.
        self.next_token = next_token
        # The total number of entries returned.
        self.total = total
        # The message returned.
        self.message = message
        # The ID of the request. This parameter is a common parameter. Each request has a unique ID. You can use the ID to troubleshoot issues.
        self.request_id = request_id

    def validate(self):
        if self.connections:
            for k in self.connections:
                if k:
                    k.validate()

    def to_map(self):
        _map = super().to_map()
        if _map is not None:
            return _map

        result = dict()
        if self.code is not None:
            result['code'] = self.code
        result['connections'] = []
        if self.connections is not None:
            for k in self.connections:
                result['connections'].append(k.to_map() if k else None)
        if self.max_results is not None:
            result['maxResults'] = self.max_results
        if self.next_token is not None:
            result['nextToken'] = self.next_token
        if self.total is not None:
            result['total'] = self.total
        if self.message is not None:
            result['message'] = self.message
        if self.request_id is not None:
            result['requestId'] = self.request_id
        return result

    def from_map(self, m: dict = None):
        m = m or dict()
        if m.get('code') is not None:
            self.code = m.get('code')
        self.connections = []
        if m.get('connections') is not None:
            for k in m.get('connections'):
                temp_model = ListConnectionsResponseBodyConnections()
                self.connections.append(temp_model.from_map(k))
        if m.get('maxResults') is not None:
            self.max_results = m.get('maxResults')
        if m.get('nextToken') is not None:
            self.next_token = m.get('nextToken')
        if m.get('total') is not None:
            self.total = m.get('total')
        if m.get('message') is not None:
            self.message = m.get('message')
        if m.get('requestId') is not None:
            self.request_id = m.get('requestId')
        return self


class ListConnectionsResponse(TeaModel):
    def __init__(
        self,
        headers: Dict[str, str] = None,
        status_code: int = None,
        body: ListConnectionsResponseBody = None,
    ):
        self.headers = headers
        self.status_code = status_code
        self.body = body

    def validate(self):
        if self.body:
            self.body.validate()

    def to_map(self):
        _map = super().to_map()
        if _map is not None:
            return _map

        result = dict()
        if self.headers is not None:
            result['headers'] = self.headers
        if self.status_code is not None:
            result['statusCode'] = self.status_code
        if self.body is not None:
            result['body'] = self.body.to_map()
        return result

    def from_map(self, m: dict = None):
        m = m or dict()
        if m.get('headers') is not None:
            self.headers = m.get('headers')
        if m.get('statusCode') is not None:
            self.status_code = m.get('statusCode')
        if m.get('body') is not None:
            temp_model = ListConnectionsResponseBody()
            self.body = temp_model.from_map(m['body'])
        return self


class ListEnumsResponseResponseBody(TeaModel):
    def __init__(
        self,
        authorization_type_enums: str = None,
        network_type_enums: str = None,
        code: str = None,
        message: str = None,
        request_id: str = None,
    ):
        self.authorization_type_enums = authorization_type_enums
        self.network_type_enums = network_type_enums
        # The returned response code.
        self.code = code
        # The returned message.
        self.message = message
        # The request ID.
        self.request_id = request_id

    def validate(self):
        pass

    def to_map(self):
        _map = super().to_map()
        if _map is not None:
            return _map

        result = dict()
        if self.authorization_type_enums is not None:
            result['authorizationTypeEnums'] = self.authorization_type_enums
        if self.network_type_enums is not None:
            result['networkTypeEnums'] = self.network_type_enums
        if self.code is not None:
            result['code'] = self.code
        if self.message is not None:
            result['message'] = self.message
        if self.request_id is not None:
            result['requestId'] = self.request_id
        return result

    def from_map(self, m: dict = None):
        m = m or dict()
        if m.get('authorizationTypeEnums') is not None:
            self.authorization_type_enums = m.get('authorizationTypeEnums')
        if m.get('networkTypeEnums') is not None:
            self.network_type_enums = m.get('networkTypeEnums')
        if m.get('code') is not None:
            self.code = m.get('code')
        if m.get('message') is not None:
            self.message = m.get('message')
        if m.get('requestId') is not None:
            self.request_id = m.get('requestId')
        return self


class ListEnumsResponseResponse(TeaModel):
    def __init__(
        self,
        headers: Dict[str, str] = None,
        status_code: int = None,
        body: UpdateConnectionResponseBody = None,
    ):
        self.headers = headers
        self.status_code = status_code
        self.body = body

    def validate(self):
        if self.body:
            self.body.validate()

    def to_map(self):
        _map = super().to_map()
        if _map is not None:
            return _map

        result = dict()
        if self.headers is not None:
            result['headers'] = self.headers
        if self.status_code is not None:
            result['statusCode'] = self.status_code
        if self.body is not None:
            result['body'] = self.body.to_map()
        return result

    def from_map(self, m: dict = None):
        m = m or dict()
        if m.get('headers') is not None:
            self.headers = m.get('headers')
        if m.get('statusCode') is not None:
            self.status_code = m.get('statusCode')
        if m.get('body') is not None:
            temp_model = UpdateConnectionResponseBody()
            self.body = temp_model.from_map(m['body'])
        return self


class PutEventsRequest(TeaModel):
    """
    EventData Controller apis:
        * putEvents
    """
    def __init__(
        self,
        event_bus_name: str = None,
        event: str = None,
    ):
        # The name of the event bus.
        # This parameter is required.
        self.event_bus_name = event_bus_name
        # The content of the event.
        self.event = event

    def validate(self):
        pass

    def to_map(self):
        _map = super().to_map()
        if _map is not None:
            return _map

        result = dict()
        if self.event_bus_name is not None:
            result['eventBusName'] = self.event_bus_name
        if self.event is not None:
            result['event'] = self.event
        return result

    def from_map(self, m: dict = None):
        m = m or dict()
        if m.get('eventBusName') is not None:
            self.event_bus_name = m.get('eventBusName')
        if m.get('event') is not None:
            self.event = m.get('event')
        return self


class PutEventsResponseBodyEntryList(TeaModel):
    def __init__(
        self,
        event_id: str = None,
        error_code: str = None,
        error_message: str = None,
    ):
        # The event ID.
        self.event_id = event_id
        # The returned error code.
        self.error_code = error_code
        # The returned error message.
        self.error_message = error_message

    def validate(self):
        pass

    def to_map(self):
        _map = super().to_map()
        if _map is not None:
            return _map

        result = dict()
        if self.event_id is not None:
            result['eventId'] = self.event_id
        if self.error_code is not None:
            result['errorCode'] = self.error_code
        if self.error_message is not None:
            result['errorMessage'] = self.error_message
        return result

    def from_map(self, m: dict = None):
        m = m or dict()
        if m.get('eventId') is not None:
            self.event_id = m.get('eventId')
        if m.get('errorCode') is not None:
            self.error_code = m.get('errorCode')
        if m.get('errorMessage') is not None:
            self.error_message = m.get('errorMessage')
        return self


class PutEventsResponseBody(TeaModel):
    def __init__(
        self,
        failed_entry_count: int = None,
        entry_list: List[PutEventsResponseBodyEntryList] = None,
        code: str = None,
        message: str = None,
        request_id: str = None,
    ):
        self.failed_entry_count = failed_entry_count
        self.entry_list = entry_list
        # The status code returned. The status code 200 indicates that the request was successful.
        self.code = code
        # The error message that is returned if the request failed.
        self.message = message
        # The request ID.
        self.request_id = request_id

    def validate(self):
        if self.entry_list:
            for k in self.entry_list:
                if k:
                    k.validate()

    def to_map(self):
        _map = super().to_map()
        if _map is not None:
            return _map

        result = dict()
        if self.failed_entry_count is not None:
            result['failedEntryCount'] = self.failed_entry_count
        result['entryList'] = []
        if self.entry_list is not None:
            for k in self.entry_list:
                result['entryList'].append(k.to_map() if k else None)
        if self.code is not None:
            result['code'] = self.code
        if self.message is not None:
            result['message'] = self.message
        if self.request_id is not None:
            result['requestId'] = self.request_id
        return result

    def from_map(self, m: dict = None):
        m = m or dict()
        if m.get('failedEntryCount') is not None:
            self.failed_entry_count = m.get('failedEntryCount')
        self.entry_list = []
        if m.get('entryList') is not None:
            for k in m.get('entryList'):
                temp_model = PutEventsResponseBodyEntryList()
                self.entry_list.append(temp_model.from_map(k))
        if m.get('code') is not None:
            self.code = m.get('code')
        if m.get('message') is not None:
            self.message = m.get('message')
        if m.get('requestId') is not None:
            self.request_id = m.get('requestId')
        return self


class PutEventsResponse(TeaModel):
    def __init__(
        self,
        headers: Dict[str, str] = None,
        status_code: int = None,
        body: PutEventsResponseBody = None,
    ):
        self.headers = headers
        self.status_code = status_code
        self.body = body

    def validate(self):
        if self.body:
            self.body.validate()

    def to_map(self):
        _map = super().to_map()
        if _map is not None:
            return _map

        result = dict()
        if self.headers is not None:
            result['headers'] = self.headers
        if self.status_code is not None:
            result['statusCode'] = self.status_code
        if self.body is not None:
            result['body'] = self.body.to_map()
        return result

    def from_map(self, m: dict = None):
        m = m or dict()
        if m.get('headers') is not None:
            self.headers = m.get('headers')
        if m.get('statusCode') is not None:
            self.status_code = m.get('statusCode')
        if m.get('body') is not None:
            temp_model = PutEventsResponseBody()
            self.body = temp_model.from_map(m['body'])
        return self


class CreateEventRuleRequest(TeaModel):
    """
    EventRule Controller apis:
        * createEventRule  *\
        * getEventRule     *\
        * deleteEventRule  *\
        * updateEventRule  *\
        * listEventRules   *\
        * enableEventRule  *\
        * disableEventRule *\
    """
    def __init__(
        self,
        event_bus_name: str = None,
        event_rule_name: str = None,
        description: str = None,
        filter_pattern: str = None,
    ):
        # The name of the event bus with which the event source is associated.
        # This parameter is required.
        self.event_bus_name = event_bus_name
        # The name of the event rule.
        # This parameter is required.
        self.event_rule_name = event_rule_name
        self.description = description
        # The event pattern, in JSON format. Valid values: stringEqual and stringExpression. You can specify up to five expressions in the map data structure in each field.
        # 
        #     You can specify up to five expressions in the map data structure in each field.
        self.filter_pattern = filter_pattern

    def validate(self):
        pass

    def to_map(self):
        _map = super().to_map()
        if _map is not None:
            return _map

        result = dict()
        if self.event_bus_name is not None:
            result['eventBusName'] = self.event_bus_name
        if self.event_rule_name is not None:
            result['eventRuleName'] = self.event_rule_name
        if self.description is not None:
            result['description'] = self.description
        if self.filter_pattern is not None:
            result['filterPattern'] = self.filter_pattern
        return result

    def from_map(self, m: dict = None):
        m = m or dict()
        if m.get('eventBusName') is not None:
            self.event_bus_name = m.get('eventBusName')
        if m.get('eventRuleName') is not None:
            self.event_rule_name = m.get('eventRuleName')
        if m.get('description') is not None:
            self.description = m.get('description')
        if m.get('filterPattern') is not None:
            self.filter_pattern = m.get('filterPattern')
        return self


class CreateEventRuleResponseBody(TeaModel):
    def __init__(
        self,
        code: str = None,
        event_rule_name: str = None,
        message: str = None,
        request_id: str = None,
    ):
        # The returned response code. Valid values:
        # 
        #     *   Success: The request is successful.
        # 
        #     *   Other codes: The request failed. For more information about error codes, see Error codes.
        self.code = code
        # The name of the event rule.
        self.event_rule_name = event_rule_name
        # The returned error message.
        self.message = message
        # The request ID.
        self.request_id = request_id

    def validate(self):
        pass

    def to_map(self):
        _map = super().to_map()
        if _map is not None:
            return _map

        result = dict()
        if self.code is not None:
            result['code'] = self.code
        if self.event_rule_name is not None:
            result['eventRuleName'] = self.event_rule_name
        if self.message is not None:
            result['message'] = self.message
        if self.request_id is not None:
            result['requestId'] = self.request_id
        return result

    def from_map(self, m: dict = None):
        m = m or dict()
        if m.get('code') is not None:
            self.code = m.get('code')
        if m.get('eventRuleName') is not None:
            self.event_rule_name = m.get('eventRuleName')
        if m.get('message') is not None:
            self.message = m.get('message')
        if m.get('requestId') is not None:
            self.request_id = m.get('requestId')
        return self


class CreateEventRuleResponse(TeaModel):
    def __init__(
        self,
        headers: Dict[str, str] = None,
        status_code: int = None,
        body: CreateEventRuleResponseBody = None,
    ):
        self.headers = headers
        self.status_code = status_code
        self.body = body

    def validate(self):
        if self.body:
            self.body.validate()

    def to_map(self):
        _map = super().to_map()
        if _map is not None:
            return _map

        result = dict()
        if self.headers is not None:
            result['headers'] = self.headers
        if self.status_code is not None:
            result['statusCode'] = self.status_code
        if self.body is not None:
            result['body'] = self.body.to_map()
        return result

    def from_map(self, m: dict = None):
        m = m or dict()
        if m.get('headers') is not None:
            self.headers = m.get('headers')
        if m.get('statusCode') is not None:
            self.status_code = m.get('statusCode')
        if m.get('body') is not None:
            temp_model = CreateEventRuleResponseBody()
            self.body = temp_model.from_map(m['body'])
        return self


class GetEventRuleRequest(TeaModel):
    def __init__(
        self,
        event_bus_name: str = None,
        event_rule_name: str = None,
    ):
        # The name of the event bus with which the event source is associated.
        # This parameter is required.
        self.event_bus_name = event_bus_name
        # The name of the event rule.
        # This parameter is required.
        self.event_rule_name = event_rule_name

    def validate(self):
        pass

    def to_map(self):
        _map = super().to_map()
        if _map is not None:
            return _map

        result = dict()
        if self.event_bus_name is not None:
            result['eventBusName'] = self.event_bus_name
        if self.event_rule_name is not None:
            result['eventRuleName'] = self.event_rule_name
        return result

    def from_map(self, m: dict = None):
        m = m or dict()
        if m.get('eventBusName') is not None:
            self.event_bus_name = m.get('eventBusName')
        if m.get('eventRuleName') is not None:
            self.event_rule_name = m.get('eventRuleName')
        return self


class GetEventRuleResponseBodyEventTargetsRunOptionsRetryStrategy(TeaModel):
    def __init__(
        self,
        push_retry_strategy: str = None,
        maximum_event_age_in_seconds: int = None,
        maximum_retry_attempts: int = None,
    ):
        self.push_retry_strategy = push_retry_strategy
        self.maximum_event_age_in_seconds = maximum_event_age_in_seconds
        self.maximum_retry_attempts = maximum_retry_attempts

    def validate(self):
        pass

    def to_map(self):
        _map = super().to_map()
        if _map is not None:
            return _map

        result = dict()
        if self.push_retry_strategy is not None:
            result['pushRetryStrategy'] = self.push_retry_strategy
        if self.maximum_event_age_in_seconds is not None:
            result['maximumEventAgeInSeconds'] = self.maximum_event_age_in_seconds
        if self.maximum_retry_attempts is not None:
            result['maximumRetryAttempts'] = self.maximum_retry_attempts
        return result

    def from_map(self, m: dict = None):
        m = m or dict()
        if m.get('pushRetryStrategy') is not None:
            self.push_retry_strategy = m.get('pushRetryStrategy')
        if m.get('maximumEventAgeInSeconds') is not None:
            self.maximum_event_age_in_seconds = m.get('maximumEventAgeInSeconds')
        if m.get('maximumRetryAttempts') is not None:
            self.maximum_retry_attempts = m.get('maximumRetryAttempts')
        return self


class GetEventRuleResponseBodyEventTargetsRunOptionsDeadLetterQueue(TeaModel):
    def __init__(
        self,
        type: str = None,
        config: Dict[str, Any] = None,
    ):
        self.type = type
        self.config = config

    def validate(self):
        pass

    def to_map(self):
        _map = super().to_map()
        if _map is not None:
            return _map

        result = dict()
        if self.type is not None:
            result['type'] = self.type
        if self.config is not None:
            result['config'] = self.config
        return result

    def from_map(self, m: dict = None):
        m = m or dict()
        if m.get('type') is not None:
            self.type = m.get('type')
        if m.get('config') is not None:
            self.config = m.get('config')
        return self


class GetEventRuleResponseBodyEventTargetsRunOptions(TeaModel):
    def __init__(
        self,
        errors_tolerance: str = None,
        retry_strategy: GetEventRuleResponseBodyEventTargetsRunOptionsRetryStrategy = None,
        dead_letter_queue: GetEventRuleResponseBodyEventTargetsRunOptionsDeadLetterQueue = None,
    ):
        self.errors_tolerance = errors_tolerance
        self.retry_strategy = retry_strategy
        self.dead_letter_queue = dead_letter_queue

    def validate(self):
        if self.retry_strategy:
            self.retry_strategy.validate()
        if self.dead_letter_queue:
            self.dead_letter_queue.validate()

    def to_map(self):
        _map = super().to_map()
        if _map is not None:
            return _map

        result = dict()
        if self.errors_tolerance is not None:
            result['errorsTolerance'] = self.errors_tolerance
        if self.retry_strategy is not None:
            result['retryStrategy'] = self.retry_strategy.to_map()
        if self.dead_letter_queue is not None:
            result['deadLetterQueue'] = self.dead_letter_queue.to_map()
        return result

    def from_map(self, m: dict = None):
        m = m or dict()
        if m.get('errorsTolerance') is not None:
            self.errors_tolerance = m.get('errorsTolerance')
        if m.get('retryStrategy') is not None:
            temp_model = GetEventRuleResponseBodyEventTargetsRunOptionsRetryStrategy()
            self.retry_strategy = temp_model.from_map(m['retryStrategy'])
        if m.get('deadLetterQueue') is not None:
            temp_model = GetEventRuleResponseBodyEventTargetsRunOptionsDeadLetterQueue()
            self.dead_letter_queue = temp_model.from_map(m['deadLetterQueue'])
        return self


class GetEventRuleResponseBodyEventTargets(TeaModel):
    def __init__(
        self,
        event_target_name: str = None,
        class_name: str = None,
        config: Dict[str, Any] = None,
        run_options: GetEventRuleResponseBodyEventTargetsRunOptions = None,
    ):
        self.event_target_name = event_target_name
        self.class_name = class_name
        self.config = config
        self.run_options = run_options

    def validate(self):
        if self.run_options:
            self.run_options.validate()

    def to_map(self):
        _map = super().to_map()
        if _map is not None:
            return _map

        result = dict()
        if self.event_target_name is not None:
            result['eventTargetName'] = self.event_target_name
        if self.class_name is not None:
            result['className'] = self.class_name
        if self.config is not None:
            result['config'] = self.config
        if self.run_options is not None:
            result['runOptions'] = self.run_options.to_map()
        return result

    def from_map(self, m: dict = None):
        m = m or dict()
        if m.get('eventTargetName') is not None:
            self.event_target_name = m.get('eventTargetName')
        if m.get('className') is not None:
            self.class_name = m.get('className')
        if m.get('config') is not None:
            self.config = m.get('config')
        if m.get('runOptions') is not None:
            temp_model = GetEventRuleResponseBodyEventTargetsRunOptions()
            self.run_options = temp_model.from_map(m['runOptions'])
        return self


class GetEventRuleResponseBody(TeaModel):
    def __init__(
        self,
        code: str = None,
        event_bus_name: str = None,
        event_rule_name: str = None,
        description: str = None,
        filter_pattern: str = None,
        status: str = None,
        gmt_create: str = None,
        gmt_modify: str = None,
        event_targets: List[GetEventRuleResponseBodyEventTargets] = None,
        message: str = None,
        request_id: str = None,
    ):
        # The returned response code. Valid values:
        # 
        #     *   Success: The request is successful.
        # 
        #     *   Other codes: The request failed. For more information about error codes, see Error codes.
        self.code = code
        # The name of the event bus with which the event source is associated.
        # This parameter is required.
        self.event_bus_name = event_bus_name
        # The name of the event rule.
        # This parameter is required.
        self.event_rule_name = event_rule_name
        self.description = description
        # The event pattern, in JSON format. Valid values: stringEqual and stringExpression. You can specify up to five expressions in the map data structure in each field.
        # 
        #     You can specify up to five expressions in the map data structure in each field.
        self.filter_pattern = filter_pattern
        # The status of the event rule. Valid values: ENABLE (default): The event rule is enabled. DISABLE: The event rule is disabled.
        self.status = status
        self.gmt_create = gmt_create
        self.gmt_modify = gmt_modify
        self.event_targets = event_targets
        # The returned error message.
        self.message = message
        # The request ID.
        self.request_id = request_id

    def validate(self):
        if self.event_targets:
            for k in self.event_targets:
                if k:
                    k.validate()

    def to_map(self):
        _map = super().to_map()
        if _map is not None:
            return _map

        result = dict()
        if self.code is not None:
            result['code'] = self.code
        if self.event_bus_name is not None:
            result['eventBusName'] = self.event_bus_name
        if self.event_rule_name is not None:
            result['eventRuleName'] = self.event_rule_name
        if self.description is not None:
            result['description'] = self.description
        if self.filter_pattern is not None:
            result['filterPattern'] = self.filter_pattern
        if self.status is not None:
            result['status'] = self.status
        if self.gmt_create is not None:
            result['gmtCreate'] = self.gmt_create
        if self.gmt_modify is not None:
            result['gmtModify'] = self.gmt_modify
        result['eventTargets'] = []
        if self.event_targets is not None:
            for k in self.event_targets:
                result['eventTargets'].append(k.to_map() if k else None)
        if self.message is not None:
            result['message'] = self.message
        if self.request_id is not None:
            result['requestId'] = self.request_id
        return result

    def from_map(self, m: dict = None):
        m = m or dict()
        if m.get('code') is not None:
            self.code = m.get('code')
        if m.get('eventBusName') is not None:
            self.event_bus_name = m.get('eventBusName')
        if m.get('eventRuleName') is not None:
            self.event_rule_name = m.get('eventRuleName')
        if m.get('description') is not None:
            self.description = m.get('description')
        if m.get('filterPattern') is not None:
            self.filter_pattern = m.get('filterPattern')
        if m.get('status') is not None:
            self.status = m.get('status')
        if m.get('gmtCreate') is not None:
            self.gmt_create = m.get('gmtCreate')
        if m.get('gmtModify') is not None:
            self.gmt_modify = m.get('gmtModify')
        self.event_targets = []
        if m.get('eventTargets') is not None:
            for k in m.get('eventTargets'):
                temp_model = GetEventRuleResponseBodyEventTargets()
                self.event_targets.append(temp_model.from_map(k))
        if m.get('message') is not None:
            self.message = m.get('message')
        if m.get('requestId') is not None:
            self.request_id = m.get('requestId')
        return self


class GetEventRuleResponse(TeaModel):
    def __init__(
        self,
        headers: Dict[str, str] = None,
        status_code: int = None,
        body: GetEventRuleResponseBody = None,
    ):
        self.headers = headers
        self.status_code = status_code
        self.body = body

    def validate(self):
        if self.body:
            self.body.validate()

    def to_map(self):
        _map = super().to_map()
        if _map is not None:
            return _map

        result = dict()
        if self.headers is not None:
            result['headers'] = self.headers
        if self.status_code is not None:
            result['statusCode'] = self.status_code
        if self.body is not None:
            result['body'] = self.body.to_map()
        return result

    def from_map(self, m: dict = None):
        m = m or dict()
        if m.get('headers') is not None:
            self.headers = m.get('headers')
        if m.get('statusCode') is not None:
            self.status_code = m.get('statusCode')
        if m.get('body') is not None:
            temp_model = GetEventRuleResponseBody()
            self.body = temp_model.from_map(m['body'])
        return self


class DeleteEventRuleRequest(TeaModel):
    def __init__(
        self,
        event_bus_name: str = None,
        event_rule_name: str = None,
    ):
        # The name of the event bus with which the event source is associated.
        # This parameter is required.
        self.event_bus_name = event_bus_name
        # The name of the event rule.
        # This parameter is required.
        self.event_rule_name = event_rule_name

    def validate(self):
        pass

    def to_map(self):
        _map = super().to_map()
        if _map is not None:
            return _map

        result = dict()
        if self.event_bus_name is not None:
            result['eventBusName'] = self.event_bus_name
        if self.event_rule_name is not None:
            result['eventRuleName'] = self.event_rule_name
        return result

    def from_map(self, m: dict = None):
        m = m or dict()
        if m.get('eventBusName') is not None:
            self.event_bus_name = m.get('eventBusName')
        if m.get('eventRuleName') is not None:
            self.event_rule_name = m.get('eventRuleName')
        return self


class DeleteEventRuleResponseBody(TeaModel):
    def __init__(
        self,
        code: str = None,
        message: str = None,
        request_id: str = None,
    ):
        # The returned response code. Valid values:
        # 
        #     *   Success: The request is successful.
        # 
        #     *   Other codes: The request failed. For more information about error codes, see Error codes.
        self.code = code
        # The returned error message.
        self.message = message
        # The request ID.
        self.request_id = request_id

    def validate(self):
        pass

    def to_map(self):
        _map = super().to_map()
        if _map is not None:
            return _map

        result = dict()
        if self.code is not None:
            result['code'] = self.code
        if self.message is not None:
            result['message'] = self.message
        if self.request_id is not None:
            result['requestId'] = self.request_id
        return result

    def from_map(self, m: dict = None):
        m = m or dict()
        if m.get('code') is not None:
            self.code = m.get('code')
        if m.get('message') is not None:
            self.message = m.get('message')
        if m.get('requestId') is not None:
            self.request_id = m.get('requestId')
        return self


class DeleteEventRuleResponse(TeaModel):
    def __init__(
        self,
        headers: Dict[str, str] = None,
        status_code: int = None,
        body: DeleteEventRuleResponseBody = None,
    ):
        self.headers = headers
        self.status_code = status_code
        self.body = body

    def validate(self):
        if self.body:
            self.body.validate()

    def to_map(self):
        _map = super().to_map()
        if _map is not None:
            return _map

        result = dict()
        if self.headers is not None:
            result['headers'] = self.headers
        if self.status_code is not None:
            result['statusCode'] = self.status_code
        if self.body is not None:
            result['body'] = self.body.to_map()
        return result

    def from_map(self, m: dict = None):
        m = m or dict()
        if m.get('headers') is not None:
            self.headers = m.get('headers')
        if m.get('statusCode') is not None:
            self.status_code = m.get('statusCode')
        if m.get('body') is not None:
            temp_model = DeleteEventRuleResponseBody()
            self.body = temp_model.from_map(m['body'])
        return self


class UpdateEventRuleRequest(TeaModel):
    def __init__(
        self,
        event_bus_name: str = None,
        event_rule_name: str = None,
        description: str = None,
        filter_pattern: str = None,
    ):
        # The name of the event bus with which the event source is associated.
        # This parameter is required.
        self.event_bus_name = event_bus_name
        # The name of the event rule.
        # This parameter is required.
        self.event_rule_name = event_rule_name
        self.description = description
        # The event pattern, in JSON format. Valid values: stringEqual and stringExpression. You can specify up to five expressions in the map data structure in each field.
        # 
        #     You can specify up to five expressions in the map data structure in each field.
        # This parameter is required.
        self.filter_pattern = filter_pattern

    def validate(self):
        pass

    def to_map(self):
        _map = super().to_map()
        if _map is not None:
            return _map

        result = dict()
        if self.event_bus_name is not None:
            result['eventBusName'] = self.event_bus_name
        if self.event_rule_name is not None:
            result['eventRuleName'] = self.event_rule_name
        if self.description is not None:
            result['description'] = self.description
        if self.filter_pattern is not None:
            result['filterPattern'] = self.filter_pattern
        return result

    def from_map(self, m: dict = None):
        m = m or dict()
        if m.get('eventBusName') is not None:
            self.event_bus_name = m.get('eventBusName')
        if m.get('eventRuleName') is not None:
            self.event_rule_name = m.get('eventRuleName')
        if m.get('description') is not None:
            self.description = m.get('description')
        if m.get('filterPattern') is not None:
            self.filter_pattern = m.get('filterPattern')
        return self


class UpdateEventRuleResponseBody(TeaModel):
    def __init__(
        self,
        code: str = None,
        message: str = None,
        request_id: str = None,
    ):
        # The returned response code. Valid values:
        # 
        #     *   Success: The request is successful.
        # 
        #     *   Other codes: The request failed. For more information about error codes, see Error codes.
        self.code = code
        # The returned error message.
        self.message = message
        # The request ID.
        self.request_id = request_id

    def validate(self):
        pass

    def to_map(self):
        _map = super().to_map()
        if _map is not None:
            return _map

        result = dict()
        if self.code is not None:
            result['code'] = self.code
        if self.message is not None:
            result['message'] = self.message
        if self.request_id is not None:
            result['requestId'] = self.request_id
        return result

    def from_map(self, m: dict = None):
        m = m or dict()
        if m.get('code') is not None:
            self.code = m.get('code')
        if m.get('message') is not None:
            self.message = m.get('message')
        if m.get('requestId') is not None:
            self.request_id = m.get('requestId')
        return self


class UpdateEventRuleResponse(TeaModel):
    def __init__(
        self,
        headers: Dict[str, str] = None,
        status_code: int = None,
        body: UpdateEventRuleResponseBody = None,
    ):
        self.headers = headers
        self.status_code = status_code
        self.body = body

    def validate(self):
        if self.body:
            self.body.validate()

    def to_map(self):
        _map = super().to_map()
        if _map is not None:
            return _map

        result = dict()
        if self.headers is not None:
            result['headers'] = self.headers
        if self.status_code is not None:
            result['statusCode'] = self.status_code
        if self.body is not None:
            result['body'] = self.body.to_map()
        return result

    def from_map(self, m: dict = None):
        m = m or dict()
        if m.get('headers') is not None:
            self.headers = m.get('headers')
        if m.get('statusCode') is not None:
            self.status_code = m.get('statusCode')
        if m.get('body') is not None:
            temp_model = UpdateEventRuleResponseBody()
            self.body = temp_model.from_map(m['body'])
        return self


class ListEventRulesRequest(TeaModel):
    def __init__(
        self,
        event_bus_name: str = None,
        max_results: int = None,
        next_token: str = None,
    ):
        self.event_bus_name = event_bus_name
        # The number of entries returned per page.
        self.max_results = max_results
        # If excess return values exist, this parameter is returned.
        self.next_token = next_token

    def validate(self):
        pass

    def to_map(self):
        _map = super().to_map()
        if _map is not None:
            return _map

        result = dict()
        if self.event_bus_name is not None:
            result['eventBusName'] = self.event_bus_name
        if self.max_results is not None:
            result['maxResults'] = self.max_results
        if self.next_token is not None:
            result['nextToken'] = self.next_token
        return result

    def from_map(self, m: dict = None):
        m = m or dict()
        if m.get('eventBusName') is not None:
            self.event_bus_name = m.get('eventBusName')
        if m.get('maxResults') is not None:
            self.max_results = m.get('maxResults')
        if m.get('nextToken') is not None:
            self.next_token = m.get('nextToken')
        return self


class ListEventRulesResponseBodyEventRules(TeaModel):
    def __init__(
        self,
        event_bus_name: str = None,
        event_rule_name: str = None,
        description: str = None,
        filter_pattern: str = None,
        status: str = None,
        gmt_create: str = None,
        gmt_modify: str = None,
    ):
        # The name of the event bus with which the event source is associated.
        # This parameter is required.
        self.event_bus_name = event_bus_name
        # The name of the event rule.
        # This parameter is required.
        self.event_rule_name = event_rule_name
        self.description = description
        # The event pattern, in JSON format. Valid values: stringEqual and stringExpression. You can specify up to five expressions in the map data structure in each field.
        # 
        #         You can specify up to five expressions in the map data structure in each field.
        self.filter_pattern = filter_pattern
        # The status of the event rule. Valid values: ENABLE (default): The event rule is enabled. DISABLE: The event rule is disabled.
        self.status = status
        self.gmt_create = gmt_create
        self.gmt_modify = gmt_modify

    def validate(self):
        pass

    def to_map(self):
        _map = super().to_map()
        if _map is not None:
            return _map

        result = dict()
        if self.event_bus_name is not None:
            result['eventBusName'] = self.event_bus_name
        if self.event_rule_name is not None:
            result['eventRuleName'] = self.event_rule_name
        if self.description is not None:
            result['description'] = self.description
        if self.filter_pattern is not None:
            result['filterPattern'] = self.filter_pattern
        if self.status is not None:
            result['status'] = self.status
        if self.gmt_create is not None:
            result['gmtCreate'] = self.gmt_create
        if self.gmt_modify is not None:
            result['gmtModify'] = self.gmt_modify
        return result

    def from_map(self, m: dict = None):
        m = m or dict()
        if m.get('eventBusName') is not None:
            self.event_bus_name = m.get('eventBusName')
        if m.get('eventRuleName') is not None:
            self.event_rule_name = m.get('eventRuleName')
        if m.get('description') is not None:
            self.description = m.get('description')
        if m.get('filterPattern') is not None:
            self.filter_pattern = m.get('filterPattern')
        if m.get('status') is not None:
            self.status = m.get('status')
        if m.get('gmtCreate') is not None:
            self.gmt_create = m.get('gmtCreate')
        if m.get('gmtModify') is not None:
            self.gmt_modify = m.get('gmtModify')
        return self


class ListEventRulesResponseBody(TeaModel):
    def __init__(
        self,
        event_rules: List[ListEventRulesResponseBodyEventRules] = None,
        total: int = None,
        max_results: int = None,
        next_token: str = None,
    ):
        self.event_rules = event_rules
        # The total number of entries.
        self.total = total
        # The number of entries returned per page.
        self.max_results = max_results
        # If excess return values exist, this parameter is returned.
        self.next_token = next_token

    def validate(self):
        if self.event_rules:
            for k in self.event_rules:
                if k:
                    k.validate()

    def to_map(self):
        _map = super().to_map()
        if _map is not None:
            return _map

        result = dict()
        result['eventRules'] = []
        if self.event_rules is not None:
            for k in self.event_rules:
                result['eventRules'].append(k.to_map() if k else None)
        if self.total is not None:
            result['total'] = self.total
        if self.max_results is not None:
            result['maxResults'] = self.max_results
        if self.next_token is not None:
            result['nextToken'] = self.next_token
        return result

    def from_map(self, m: dict = None):
        m = m or dict()
        self.event_rules = []
        if m.get('eventRules') is not None:
            for k in m.get('eventRules'):
                temp_model = ListEventRulesResponseBodyEventRules()
                self.event_rules.append(temp_model.from_map(k))
        if m.get('total') is not None:
            self.total = m.get('total')
        if m.get('maxResults') is not None:
            self.max_results = m.get('maxResults')
        if m.get('nextToken') is not None:
            self.next_token = m.get('nextToken')
        return self


class ListEventRulesResponse(TeaModel):
    def __init__(
        self,
        headers: Dict[str, str] = None,
        status_code: int = None,
        body: ListEventRulesResponseBody = None,
    ):
        self.headers = headers
        self.status_code = status_code
        self.body = body

    def validate(self):
        if self.body:
            self.body.validate()

    def to_map(self):
        _map = super().to_map()
        if _map is not None:
            return _map

        result = dict()
        if self.headers is not None:
            result['headers'] = self.headers
        if self.status_code is not None:
            result['statusCode'] = self.status_code
        if self.body is not None:
            result['body'] = self.body.to_map()
        return result

    def from_map(self, m: dict = None):
        m = m or dict()
        if m.get('headers') is not None:
            self.headers = m.get('headers')
        if m.get('statusCode') is not None:
            self.status_code = m.get('statusCode')
        if m.get('body') is not None:
            temp_model = ListEventRulesResponseBody()
            self.body = temp_model.from_map(m['body'])
        return self


class EnableEventRuleRequest(TeaModel):
    def __init__(
        self,
        event_bus_name: str = None,
        event_rule_name: str = None,
    ):
        # The name of the event bus with which the event source is associated.
        # This parameter is required.
        self.event_bus_name = event_bus_name
        # The name of the event rule.
        # This parameter is required.
        self.event_rule_name = event_rule_name

    def validate(self):
        pass

    def to_map(self):
        _map = super().to_map()
        if _map is not None:
            return _map

        result = dict()
        if self.event_bus_name is not None:
            result['eventBusName'] = self.event_bus_name
        if self.event_rule_name is not None:
            result['eventRuleName'] = self.event_rule_name
        return result

    def from_map(self, m: dict = None):
        m = m or dict()
        if m.get('eventBusName') is not None:
            self.event_bus_name = m.get('eventBusName')
        if m.get('eventRuleName') is not None:
            self.event_rule_name = m.get('eventRuleName')
        return self


class EnableEventRuleResponseBody(TeaModel):
    def __init__(
        self,
        code: str = None,
        message: str = None,
        request_id: str = None,
    ):
        # The returned response code. Valid values:
        # 
        #     *   Success: The request is successful.
        # 
        #     *   Other codes: The request failed. For more information about error codes, see Error codes.
        self.code = code
        # The returned error message.
        self.message = message
        # The request ID.
        self.request_id = request_id

    def validate(self):
        pass

    def to_map(self):
        _map = super().to_map()
        if _map is not None:
            return _map

        result = dict()
        if self.code is not None:
            result['code'] = self.code
        if self.message is not None:
            result['message'] = self.message
        if self.request_id is not None:
            result['requestId'] = self.request_id
        return result

    def from_map(self, m: dict = None):
        m = m or dict()
        if m.get('code') is not None:
            self.code = m.get('code')
        if m.get('message') is not None:
            self.message = m.get('message')
        if m.get('requestId') is not None:
            self.request_id = m.get('requestId')
        return self


class EnableEventRuleResponse(TeaModel):
    def __init__(
        self,
        headers: Dict[str, str] = None,
        status_code: int = None,
        body: EnableEventRuleResponseBody = None,
    ):
        self.headers = headers
        self.status_code = status_code
        self.body = body

    def validate(self):
        if self.body:
            self.body.validate()

    def to_map(self):
        _map = super().to_map()
        if _map is not None:
            return _map

        result = dict()
        if self.headers is not None:
            result['headers'] = self.headers
        if self.status_code is not None:
            result['statusCode'] = self.status_code
        if self.body is not None:
            result['body'] = self.body.to_map()
        return result

    def from_map(self, m: dict = None):
        m = m or dict()
        if m.get('headers') is not None:
            self.headers = m.get('headers')
        if m.get('statusCode') is not None:
            self.status_code = m.get('statusCode')
        if m.get('body') is not None:
            temp_model = EnableEventRuleResponseBody()
            self.body = temp_model.from_map(m['body'])
        return self


class DisableEventRuleRequest(TeaModel):
    def __init__(
        self,
        event_bus_name: str = None,
        event_rule_name: str = None,
    ):
        # The name of the event bus with which the event source is associated.
        # This parameter is required.
        self.event_bus_name = event_bus_name
        # The name of the event rule.
        # This parameter is required.
        self.event_rule_name = event_rule_name

    def validate(self):
        pass

    def to_map(self):
        _map = super().to_map()
        if _map is not None:
            return _map

        result = dict()
        if self.event_bus_name is not None:
            result['eventBusName'] = self.event_bus_name
        if self.event_rule_name is not None:
            result['eventRuleName'] = self.event_rule_name
        return result

    def from_map(self, m: dict = None):
        m = m or dict()
        if m.get('eventBusName') is not None:
            self.event_bus_name = m.get('eventBusName')
        if m.get('eventRuleName') is not None:
            self.event_rule_name = m.get('eventRuleName')
        return self


class DisableEventRuleResponseBody(TeaModel):
    def __init__(
        self,
        code: str = None,
        message: str = None,
        request_id: str = None,
    ):
        # The returned response code. Valid values:
        # 
        #     *   Success: The request is successful.
        # 
        #     *   Other codes: The request failed. For more information about error codes, see Error codes.
        self.code = code
        # The returned error message.
        self.message = message
        # The request ID.
        self.request_id = request_id

    def validate(self):
        pass

    def to_map(self):
        _map = super().to_map()
        if _map is not None:
            return _map

        result = dict()
        if self.code is not None:
            result['code'] = self.code
        if self.message is not None:
            result['message'] = self.message
        if self.request_id is not None:
            result['requestId'] = self.request_id
        return result

    def from_map(self, m: dict = None):
        m = m or dict()
        if m.get('code') is not None:
            self.code = m.get('code')
        if m.get('message') is not None:
            self.message = m.get('message')
        if m.get('requestId') is not None:
            self.request_id = m.get('requestId')
        return self


class DisableEventRuleResponse(TeaModel):
    def __init__(
        self,
        headers: Dict[str, str] = None,
        status_code: int = None,
        body: DisableEventRuleResponseBody = None,
    ):
        self.headers = headers
        self.status_code = status_code
        self.body = body

    def validate(self):
        if self.body:
            self.body.validate()

    def to_map(self):
        _map = super().to_map()
        if _map is not None:
            return _map

        result = dict()
        if self.headers is not None:
            result['headers'] = self.headers
        if self.status_code is not None:
            result['statusCode'] = self.status_code
        if self.body is not None:
            result['body'] = self.body.to_map()
        return result

    def from_map(self, m: dict = None):
        m = m or dict()
        if m.get('headers') is not None:
            self.headers = m.get('headers')
        if m.get('statusCode') is not None:
            self.status_code = m.get('statusCode')
        if m.get('body') is not None:
            temp_model = DisableEventRuleResponseBody()
            self.body = temp_model.from_map(m['body'])
        return self


class CreateEventSourceRequest(TeaModel):
    """
    EventSource Controller apis:
        * createEventSource *\
        * updateEventSource *\
        * deleteEventSource *\
        * getEventSource    *\
        * listEventSources  *\
    """
    def __init__(
        self,
        description: str = None,
        event_bus_name: str = None,
        event_source_name: str = None,
        class_name: str = None,
        config: Dict[str, Any] = None,
    ):
        # The description of the event source.
        self.description = description
        # The name of the event bus with which the event source is associated.
        # This parameter is required.
        self.event_bus_name = event_bus_name
        # The name of the event source.
        # This parameter is required.
        self.event_source_name = event_source_name
        self.class_name = class_name
        self.config = config

    def validate(self):
        pass

    def to_map(self):
        _map = super().to_map()
        if _map is not None:
            return _map

        result = dict()
        if self.description is not None:
            result['description'] = self.description
        if self.event_bus_name is not None:
            result['eventBusName'] = self.event_bus_name
        if self.event_source_name is not None:
            result['eventSourceName'] = self.event_source_name
        if self.class_name is not None:
            result['className'] = self.class_name
        if self.config is not None:
            result['config'] = self.config
        return result

    def from_map(self, m: dict = None):
        m = m or dict()
        if m.get('description') is not None:
            self.description = m.get('description')
        if m.get('eventBusName') is not None:
            self.event_bus_name = m.get('eventBusName')
        if m.get('eventSourceName') is not None:
            self.event_source_name = m.get('eventSourceName')
        if m.get('className') is not None:
            self.class_name = m.get('className')
        if m.get('config') is not None:
            self.config = m.get('config')
        return self


class CreateEventSourceResponseBody(TeaModel):
    def __init__(
        self,
        code: str = None,
        event_source_name: str = None,
        message: str = None,
        request_id: str = None,
    ):
        # The returned response code. Valid values:
        # 
        #     *   Success: The request is successful.
        # 
        #     *   Other codes: The request failed. For more information about error codes, see Error codes.
        self.code = code
        # The name of the event source.
        self.event_source_name = event_source_name
        # The returned error message.
        self.message = message
        # The request ID.
        self.request_id = request_id

    def validate(self):
        pass

    def to_map(self):
        _map = super().to_map()
        if _map is not None:
            return _map

        result = dict()
        if self.code is not None:
            result['code'] = self.code
        if self.event_source_name is not None:
            result['eventSourceName'] = self.event_source_name
        if self.message is not None:
            result['message'] = self.message
        if self.request_id is not None:
            result['requestId'] = self.request_id
        return result

    def from_map(self, m: dict = None):
        m = m or dict()
        if m.get('code') is not None:
            self.code = m.get('code')
        if m.get('eventSourceName') is not None:
            self.event_source_name = m.get('eventSourceName')
        if m.get('message') is not None:
            self.message = m.get('message')
        if m.get('requestId') is not None:
            self.request_id = m.get('requestId')
        return self


class CreateEventSourceResponse(TeaModel):
    def __init__(
        self,
        headers: Dict[str, str] = None,
        status_code: int = None,
        body: CreateEventSourceResponseBody = None,
    ):
        self.headers = headers
        self.status_code = status_code
        self.body = body

    def validate(self):
        if self.body:
            self.body.validate()

    def to_map(self):
        _map = super().to_map()
        if _map is not None:
            return _map

        result = dict()
        if self.headers is not None:
            result['headers'] = self.headers
        if self.status_code is not None:
            result['statusCode'] = self.status_code
        if self.body is not None:
            result['body'] = self.body.to_map()
        return result

    def from_map(self, m: dict = None):
        m = m or dict()
        if m.get('headers') is not None:
            self.headers = m.get('headers')
        if m.get('statusCode') is not None:
            self.status_code = m.get('statusCode')
        if m.get('body') is not None:
            temp_model = CreateEventSourceResponseBody()
            self.body = temp_model.from_map(m['body'])
        return self


class UpdateEventSourceRequest(TeaModel):
    def __init__(
        self,
        event_bus_name: str = None,
        event_source_name: str = None,
        description: str = None,
        class_name: str = None,
        status: int = None,
        config: Dict[str, Any] = None,
    ):
        # The name of the event bus with which the event source is associated.
        # This parameter is required.
        self.event_bus_name = event_bus_name
        # The name of the event source.
        # This parameter is required.
        self.event_source_name = event_source_name
        # The description of the event source.
        self.description = description
        self.class_name = class_name
        self.status = status
        self.config = config

    def validate(self):
        pass

    def to_map(self):
        _map = super().to_map()
        if _map is not None:
            return _map

        result = dict()
        if self.event_bus_name is not None:
            result['eventBusName'] = self.event_bus_name
        if self.event_source_name is not None:
            result['eventSourceName'] = self.event_source_name
        if self.description is not None:
            result['description'] = self.description
        if self.class_name is not None:
            result['className'] = self.class_name
        if self.status is not None:
            result['status'] = self.status
        if self.config is not None:
            result['config'] = self.config
        return result

    def from_map(self, m: dict = None):
        m = m or dict()
        if m.get('eventBusName') is not None:
            self.event_bus_name = m.get('eventBusName')
        if m.get('eventSourceName') is not None:
            self.event_source_name = m.get('eventSourceName')
        if m.get('description') is not None:
            self.description = m.get('description')
        if m.get('className') is not None:
            self.class_name = m.get('className')
        if m.get('status') is not None:
            self.status = m.get('status')
        if m.get('config') is not None:
            self.config = m.get('config')
        return self


class UpdateEventSourceResponseBody(TeaModel):
    def __init__(
        self,
        code: str = None,
        message: str = None,
        request_id: str = None,
    ):
        # The returned response code. Valid values:
        # 
        #     *   Success: The request is successful.
        # 
        #     *   Other codes: The request failed. For more information about error codes, see Error codes.
        self.code = code
        # The returned error message.
        self.message = message
        # The request ID.
        self.request_id = request_id

    def validate(self):
        pass

    def to_map(self):
        _map = super().to_map()
        if _map is not None:
            return _map

        result = dict()
        if self.code is not None:
            result['code'] = self.code
        if self.message is not None:
            result['message'] = self.message
        if self.request_id is not None:
            result['requestId'] = self.request_id
        return result

    def from_map(self, m: dict = None):
        m = m or dict()
        if m.get('code') is not None:
            self.code = m.get('code')
        if m.get('message') is not None:
            self.message = m.get('message')
        if m.get('requestId') is not None:
            self.request_id = m.get('requestId')
        return self


class UpdateEventSourceResponse(TeaModel):
    def __init__(
        self,
        headers: Dict[str, str] = None,
        status_code: int = None,
        body: UpdateEventSourceResponseBody = None,
    ):
        self.headers = headers
        self.status_code = status_code
        self.body = body

    def validate(self):
        if self.body:
            self.body.validate()

    def to_map(self):
        _map = super().to_map()
        if _map is not None:
            return _map

        result = dict()
        if self.headers is not None:
            result['headers'] = self.headers
        if self.status_code is not None:
            result['statusCode'] = self.status_code
        if self.body is not None:
            result['body'] = self.body.to_map()
        return result

    def from_map(self, m: dict = None):
        m = m or dict()
        if m.get('headers') is not None:
            self.headers = m.get('headers')
        if m.get('statusCode') is not None:
            self.status_code = m.get('statusCode')
        if m.get('body') is not None:
            temp_model = UpdateEventSourceResponseBody()
            self.body = temp_model.from_map(m['body'])
        return self


class DeleteEventSourceRequest(TeaModel):
    def __init__(
        self,
        event_bus_name: str = None,
        event_source_name: str = None,
    ):
        self.event_bus_name = event_bus_name
        # The name of the event source.
        # This parameter is required.
        self.event_source_name = event_source_name

    def validate(self):
        pass

    def to_map(self):
        _map = super().to_map()
        if _map is not None:
            return _map

        result = dict()
        if self.event_bus_name is not None:
            result['eventBusName'] = self.event_bus_name
        if self.event_source_name is not None:
            result['eventSourceName'] = self.event_source_name
        return result

    def from_map(self, m: dict = None):
        m = m or dict()
        if m.get('eventBusName') is not None:
            self.event_bus_name = m.get('eventBusName')
        if m.get('eventSourceName') is not None:
            self.event_source_name = m.get('eventSourceName')
        return self


class DeleteEventSourceResponseBody(TeaModel):
    def __init__(
        self,
        code: str = None,
        message: str = None,
        request_id: str = None,
    ):
        # The returned response code. The value Success indicates that the request is successful. Other values indicate that the request failed. For more information about error codes, see Error codes.
        self.code = code
        # The returned error message.
        self.message = message
        # The request ID.
        self.request_id = request_id

    def validate(self):
        pass

    def to_map(self):
        _map = super().to_map()
        if _map is not None:
            return _map

        result = dict()
        if self.code is not None:
            result['code'] = self.code
        if self.message is not None:
            result['message'] = self.message
        if self.request_id is not None:
            result['requestId'] = self.request_id
        return result

    def from_map(self, m: dict = None):
        m = m or dict()
        if m.get('code') is not None:
            self.code = m.get('code')
        if m.get('message') is not None:
            self.message = m.get('message')
        if m.get('requestId') is not None:
            self.request_id = m.get('requestId')
        return self


class DeleteEventSourceResponse(TeaModel):
    def __init__(
        self,
        headers: Dict[str, str] = None,
        status_code: int = None,
        body: DeleteEventSourceResponseBody = None,
    ):
        self.headers = headers
        self.status_code = status_code
        self.body = body

    def validate(self):
        if self.body:
            self.body.validate()

    def to_map(self):
        _map = super().to_map()
        if _map is not None:
            return _map

        result = dict()
        if self.headers is not None:
            result['headers'] = self.headers
        if self.status_code is not None:
            result['statusCode'] = self.status_code
        if self.body is not None:
            result['body'] = self.body.to_map()
        return result

    def from_map(self, m: dict = None):
        m = m or dict()
        if m.get('headers') is not None:
            self.headers = m.get('headers')
        if m.get('statusCode') is not None:
            self.status_code = m.get('statusCode')
        if m.get('body') is not None:
            temp_model = DeleteEventSourceResponseBody()
            self.body = temp_model.from_map(m['body'])
        return self


class GetEventSourceRequest(TeaModel):
    def __init__(
        self,
        event_bus_name: str = None,
        event_source_name: str = None,
    ):
        self.event_bus_name = event_bus_name
        # The name of the event source.
        # This parameter is required.
        self.event_source_name = event_source_name

    def validate(self):
        pass

    def to_map(self):
        _map = super().to_map()
        if _map is not None:
            return _map

        result = dict()
        if self.event_bus_name is not None:
            result['eventBusName'] = self.event_bus_name
        if self.event_source_name is not None:
            result['eventSourceName'] = self.event_source_name
        return result

    def from_map(self, m: dict = None):
        m = m or dict()
        if m.get('eventBusName') is not None:
            self.event_bus_name = m.get('eventBusName')
        if m.get('eventSourceName') is not None:
            self.event_source_name = m.get('eventSourceName')
        return self


class GetEventSourceResponseBody(TeaModel):
    def __init__(
        self,
        event_bus_name: str = None,
        event_source_name: str = None,
        description: str = None,
        class_name: str = None,
        config: Dict[str, Any] = None,
    ):
        # The name of the event bus with which the event source is associated.
        # This parameter is required.
        self.event_bus_name = event_bus_name
        # The name of the event source.
        # This parameter is required.
        self.event_source_name = event_source_name
        # The description of the event source.
        self.description = description
        self.class_name = class_name
        self.config = config

    def validate(self):
        pass

    def to_map(self):
        _map = super().to_map()
        if _map is not None:
            return _map

        result = dict()
        if self.event_bus_name is not None:
            result['eventBusName'] = self.event_bus_name
        if self.event_source_name is not None:
            result['eventSourceName'] = self.event_source_name
        if self.description is not None:
            result['description'] = self.description
        if self.class_name is not None:
            result['className'] = self.class_name
        if self.config is not None:
            result['config'] = self.config
        return result

    def from_map(self, m: dict = None):
        m = m or dict()
        if m.get('eventBusName') is not None:
            self.event_bus_name = m.get('eventBusName')
        if m.get('eventSourceName') is not None:
            self.event_source_name = m.get('eventSourceName')
        if m.get('description') is not None:
            self.description = m.get('description')
        if m.get('className') is not None:
            self.class_name = m.get('className')
        if m.get('config') is not None:
            self.config = m.get('config')
        return self


class GetEventSourceResponse(TeaModel):
    def __init__(
        self,
        headers: Dict[str, str] = None,
        status_code: int = None,
        body: GetEventSourceResponseBody = None,
    ):
        self.headers = headers
        self.status_code = status_code
        self.body = body

    def validate(self):
        if self.body:
            self.body.validate()

    def to_map(self):
        _map = super().to_map()
        if _map is not None:
            return _map

        result = dict()
        if self.headers is not None:
            result['headers'] = self.headers
        if self.status_code is not None:
            result['statusCode'] = self.status_code
        if self.body is not None:
            result['body'] = self.body.to_map()
        return result

    def from_map(self, m: dict = None):
        m = m or dict()
        if m.get('headers') is not None:
            self.headers = m.get('headers')
        if m.get('statusCode') is not None:
            self.status_code = m.get('statusCode')
        if m.get('body') is not None:
            temp_model = GetEventSourceResponseBody()
            self.body = temp_model.from_map(m['body'])
        return self


class ListEventSourcesRequest(TeaModel):
    def __init__(
        self,
        event_bus_name: str = None,
        event_source_type: str = None,
        max_results: int = None,
        next_token: str = None,
    ):
        self.event_bus_name = event_bus_name
        # The type of the event source.
        # This parameter is required.
        self.event_source_type = event_source_type
        # The number of entries returned per page.
        self.max_results = max_results
        # If excess return values exist, this parameter is returned.
        self.next_token = next_token

    def validate(self):
        pass

    def to_map(self):
        _map = super().to_map()
        if _map is not None:
            return _map

        result = dict()
        if self.event_bus_name is not None:
            result['eventBusName'] = self.event_bus_name
        if self.event_source_type is not None:
            result['eventSourceType'] = self.event_source_type
        if self.max_results is not None:
            result['maxResults'] = self.max_results
        if self.next_token is not None:
            result['nextToken'] = self.next_token
        return result

    def from_map(self, m: dict = None):
        m = m or dict()
        if m.get('eventBusName') is not None:
            self.event_bus_name = m.get('eventBusName')
        if m.get('eventSourceType') is not None:
            self.event_source_type = m.get('eventSourceType')
        if m.get('maxResults') is not None:
            self.max_results = m.get('maxResults')
        if m.get('nextToken') is not None:
            self.next_token = m.get('nextToken')
        return self


class ListEventSourcesResponseBodyEventSources(TeaModel):
    def __init__(
        self,
        event_bus_name: str = None,
        event_source_name: str = None,
        description: str = None,
        class_name: str = None,
        config: Dict[str, Any] = None,
        gmt_create: str = None,
        gmt_modify: str = None,
    ):
        # The name of the event bus.
        # This parameter is required.
        self.event_bus_name = event_bus_name
        # EventSource is required for querying default bus events.
        self.event_source_name = event_source_name
        # The description of the event type.
        self.description = description
        self.class_name = class_name
        self.config = config
        self.gmt_create = gmt_create
        self.gmt_modify = gmt_modify

    def validate(self):
        pass

    def to_map(self):
        _map = super().to_map()
        if _map is not None:
            return _map

        result = dict()
        if self.event_bus_name is not None:
            result['eventBusName'] = self.event_bus_name
        if self.event_source_name is not None:
            result['eventSourceName'] = self.event_source_name
        if self.description is not None:
            result['description'] = self.description
        if self.class_name is not None:
            result['className'] = self.class_name
        if self.config is not None:
            result['config'] = self.config
        if self.gmt_create is not None:
            result['gmtCreate'] = self.gmt_create
        if self.gmt_modify is not None:
            result['gmtModify'] = self.gmt_modify
        return result

    def from_map(self, m: dict = None):
        m = m or dict()
        if m.get('eventBusName') is not None:
            self.event_bus_name = m.get('eventBusName')
        if m.get('eventSourceName') is not None:
            self.event_source_name = m.get('eventSourceName')
        if m.get('description') is not None:
            self.description = m.get('description')
        if m.get('className') is not None:
            self.class_name = m.get('className')
        if m.get('config') is not None:
            self.config = m.get('config')
        if m.get('gmtCreate') is not None:
            self.gmt_create = m.get('gmtCreate')
        if m.get('gmtModify') is not None:
            self.gmt_modify = m.get('gmtModify')
        return self


class ListEventSourcesResponseBody(TeaModel):
    def __init__(
        self,
        event_sources: List[ListEventSourcesResponseBodyEventSources] = None,
        total: int = None,
        max_results: int = None,
        next_token: str = None,
    ):
        self.event_sources = event_sources
        # The total number of entries.
        self.total = total
        # The number of entries returned per page.
        self.max_results = max_results
        # If excess return values exist, this parameter is returned.
        self.next_token = next_token

    def validate(self):
        if self.event_sources:
            for k in self.event_sources:
                if k:
                    k.validate()

    def to_map(self):
        _map = super().to_map()
        if _map is not None:
            return _map

        result = dict()
        result['eventSources'] = []
        if self.event_sources is not None:
            for k in self.event_sources:
                result['eventSources'].append(k.to_map() if k else None)
        if self.total is not None:
            result['total'] = self.total
        if self.max_results is not None:
            result['maxResults'] = self.max_results
        if self.next_token is not None:
            result['nextToken'] = self.next_token
        return result

    def from_map(self, m: dict = None):
        m = m or dict()
        self.event_sources = []
        if m.get('eventSources') is not None:
            for k in m.get('eventSources'):
                temp_model = ListEventSourcesResponseBodyEventSources()
                self.event_sources.append(temp_model.from_map(k))
        if m.get('total') is not None:
            self.total = m.get('total')
        if m.get('maxResults') is not None:
            self.max_results = m.get('maxResults')
        if m.get('nextToken') is not None:
            self.next_token = m.get('nextToken')
        return self


class ListEventSourcesResponse(TeaModel):
    def __init__(
        self,
        headers: Dict[str, str] = None,
        status_code: int = None,
        body: ListEventSourcesResponseBody = None,
    ):
        self.headers = headers
        self.status_code = status_code
        self.body = body

    def validate(self):
        if self.body:
            self.body.validate()

    def to_map(self):
        _map = super().to_map()
        if _map is not None:
            return _map

        result = dict()
        if self.headers is not None:
            result['headers'] = self.headers
        if self.status_code is not None:
            result['statusCode'] = self.status_code
        if self.body is not None:
            result['body'] = self.body.to_map()
        return result

    def from_map(self, m: dict = None):
        m = m or dict()
        if m.get('headers') is not None:
            self.headers = m.get('headers')
        if m.get('statusCode') is not None:
            self.status_code = m.get('statusCode')
        if m.get('body') is not None:
            temp_model = ListEventSourcesResponseBody()
            self.body = temp_model.from_map(m['body'])
        return self


class EventTargetRunOptionsRetryStrategy(TeaModel):
    def __init__(
        self,
        push_retry_strategy: str = None,
        maximum_event_age_in_seconds: int = None,
        maximum_retry_attempts: int = None,
    ):
        self.push_retry_strategy = push_retry_strategy
        self.maximum_event_age_in_seconds = maximum_event_age_in_seconds
        self.maximum_retry_attempts = maximum_retry_attempts

    def validate(self):
        pass

    def to_map(self):
        _map = super().to_map()
        if _map is not None:
            return _map

        result = dict()
        if self.push_retry_strategy is not None:
            result['pushRetryStrategy'] = self.push_retry_strategy
        if self.maximum_event_age_in_seconds is not None:
            result['maximumEventAgeInSeconds'] = self.maximum_event_age_in_seconds
        if self.maximum_retry_attempts is not None:
            result['maximumRetryAttempts'] = self.maximum_retry_attempts
        return result

    def from_map(self, m: dict = None):
        m = m or dict()
        if m.get('pushRetryStrategy') is not None:
            self.push_retry_strategy = m.get('pushRetryStrategy')
        if m.get('maximumEventAgeInSeconds') is not None:
            self.maximum_event_age_in_seconds = m.get('maximumEventAgeInSeconds')
        if m.get('maximumRetryAttempts') is not None:
            self.maximum_retry_attempts = m.get('maximumRetryAttempts')
        return self


class EventTargetRunOptionsDeadLetterQueue(TeaModel):
    def __init__(
        self,
        type: str = None,
        config: Dict[str, Any] = None,
    ):
        self.type = type
        self.config = config

    def validate(self):
        pass

    def to_map(self):
        _map = super().to_map()
        if _map is not None:
            return _map

        result = dict()
        if self.type is not None:
            result['type'] = self.type
        if self.config is not None:
            result['config'] = self.config
        return result

    def from_map(self, m: dict = None):
        m = m or dict()
        if m.get('type') is not None:
            self.type = m.get('type')
        if m.get('config') is not None:
            self.config = m.get('config')
        return self


class EventTargetRunOptions(TeaModel):
    def __init__(
        self,
        errors_tolerance: str = None,
        retry_strategy: EventTargetRunOptionsRetryStrategy = None,
        dead_letter_queue: EventTargetRunOptionsDeadLetterQueue = None,
    ):
        self.errors_tolerance = errors_tolerance
        self.retry_strategy = retry_strategy
        self.dead_letter_queue = dead_letter_queue

    def validate(self):
        if self.retry_strategy:
            self.retry_strategy.validate()
        if self.dead_letter_queue:
            self.dead_letter_queue.validate()

    def to_map(self):
        _map = super().to_map()
        if _map is not None:
            return _map

        result = dict()
        if self.errors_tolerance is not None:
            result['errorsTolerance'] = self.errors_tolerance
        if self.retry_strategy is not None:
            result['retryStrategy'] = self.retry_strategy.to_map()
        if self.dead_letter_queue is not None:
            result['deadLetterQueue'] = self.dead_letter_queue.to_map()
        return result

    def from_map(self, m: dict = None):
        m = m or dict()
        if m.get('errorsTolerance') is not None:
            self.errors_tolerance = m.get('errorsTolerance')
        if m.get('retryStrategy') is not None:
            temp_model = EventTargetRunOptionsRetryStrategy()
            self.retry_strategy = temp_model.from_map(m['retryStrategy'])
        if m.get('deadLetterQueue') is not None:
            temp_model = EventTargetRunOptionsDeadLetterQueue()
            self.dead_letter_queue = temp_model.from_map(m['deadLetterQueue'])
        return self


class EventTarget(TeaModel):
    """
    EventTarget Controller apis:
        * createEventTargets *\
        * updateEventTargets *\
        * deleteEventTargets *\
        * listEventTargets   *\
    """
    def __init__(
        self,
        event_target_name: str = None,
        class_name: str = None,
        config: Dict[str, Any] = None,
        run_options: EventTargetRunOptions = None,
    ):
        self.event_target_name = event_target_name
        self.class_name = class_name
        self.config = config
        self.run_options = run_options

    def validate(self):
        if self.run_options:
            self.run_options.validate()

    def to_map(self):
        _map = super().to_map()
        if _map is not None:
            return _map

        result = dict()
        if self.event_target_name is not None:
            result['eventTargetName'] = self.event_target_name
        if self.class_name is not None:
            result['className'] = self.class_name
        if self.config is not None:
            result['config'] = self.config
        if self.run_options is not None:
            result['runOptions'] = self.run_options.to_map()
        return result

    def from_map(self, m: dict = None):
        m = m or dict()
        if m.get('eventTargetName') is not None:
            self.event_target_name = m.get('eventTargetName')
        if m.get('className') is not None:
            self.class_name = m.get('className')
        if m.get('config') is not None:
            self.config = m.get('config')
        if m.get('runOptions') is not None:
            temp_model = EventTargetRunOptions()
            self.run_options = temp_model.from_map(m['runOptions'])
        return self


class CreateEventTargetsRequest(TeaModel):
    def __init__(
        self,
        event_bus_name: str = None,
        event_rule_name: str = None,
        event_targets: List[EventTarget] = None,
    ):
        # The name of the event bus with which the event target is associated.
        # This parameter is required.
        self.event_bus_name = event_bus_name
        # The name of the event rule.
        # This parameter is required.
        self.event_rule_name = event_rule_name
        self.event_targets = event_targets

    def validate(self):
        if self.event_targets:
            for k in self.event_targets:
                if k:
                    k.validate()

    def to_map(self):
        _map = super().to_map()
        if _map is not None:
            return _map

        result = dict()
        if self.event_bus_name is not None:
            result['eventBusName'] = self.event_bus_name
        if self.event_rule_name is not None:
            result['eventRuleName'] = self.event_rule_name
        result['eventTargets'] = []
        if self.event_targets is not None:
            for k in self.event_targets:
                result['eventTargets'].append(k.to_map() if k else None)
        return result

    def from_map(self, m: dict = None):
        m = m or dict()
        if m.get('eventBusName') is not None:
            self.event_bus_name = m.get('eventBusName')
        if m.get('eventRuleName') is not None:
            self.event_rule_name = m.get('eventRuleName')
        self.event_targets = []
        if m.get('eventTargets') is not None:
            for k in m.get('eventTargets'):
                temp_model = EventTarget()
                self.event_targets.append(temp_model.from_map(k))
        return self


class CreateEventTargetsResponseBody(TeaModel):
    def __init__(
        self,
        code: str = None,
        message: str = None,
        request_id: str = None,
    ):
        # The returned response code. Valid values:
        # 
        #     *   Success: The request is successful.
        # 
        #     *   Other codes: The request failed. For more information about error codes, see Error codes.
        self.code = code
        # The returned error message.
        self.message = message
        # The request ID.
        self.request_id = request_id

    def validate(self):
        pass

    def to_map(self):
        _map = super().to_map()
        if _map is not None:
            return _map

        result = dict()
        if self.code is not None:
            result['code'] = self.code
        if self.message is not None:
            result['message'] = self.message
        if self.request_id is not None:
            result['requestId'] = self.request_id
        return result

    def from_map(self, m: dict = None):
        m = m or dict()
        if m.get('code') is not None:
            self.code = m.get('code')
        if m.get('message') is not None:
            self.message = m.get('message')
        if m.get('requestId') is not None:
            self.request_id = m.get('requestId')
        return self


class CreateEventTargetsResponse(TeaModel):
    def __init__(
        self,
        headers: Dict[str, str] = None,
        status_code: int = None,
        body: CreateEventTargetsResponseBody = None,
    ):
        self.headers = headers
        self.status_code = status_code
        self.body = body

    def validate(self):
        if self.body:
            self.body.validate()

    def to_map(self):
        _map = super().to_map()
        if _map is not None:
            return _map

        result = dict()
        if self.headers is not None:
            result['headers'] = self.headers
        if self.status_code is not None:
            result['statusCode'] = self.status_code
        if self.body is not None:
            result['body'] = self.body.to_map()
        return result

    def from_map(self, m: dict = None):
        m = m or dict()
        if m.get('headers') is not None:
            self.headers = m.get('headers')
        if m.get('statusCode') is not None:
            self.status_code = m.get('statusCode')
        if m.get('body') is not None:
            temp_model = CreateEventTargetsResponseBody()
            self.body = temp_model.from_map(m['body'])
        return self


class UpdateEventTargetsRequest(TeaModel):
    def __init__(
        self,
        event_bus_name: str = None,
        event_rule_name: str = None,
        event_targets: List[EventTarget] = None,
    ):
        # The name of the event bus with which the event target is associated.
        # This parameter is required.
        self.event_bus_name = event_bus_name
        # The name of the event rule.
        # This parameter is required.
        self.event_rule_name = event_rule_name
        self.event_targets = event_targets

    def validate(self):
        if self.event_targets:
            for k in self.event_targets:
                if k:
                    k.validate()

    def to_map(self):
        _map = super().to_map()
        if _map is not None:
            return _map

        result = dict()
        if self.event_bus_name is not None:
            result['eventBusName'] = self.event_bus_name
        if self.event_rule_name is not None:
            result['eventRuleName'] = self.event_rule_name
        result['eventTargets'] = []
        if self.event_targets is not None:
            for k in self.event_targets:
                result['eventTargets'].append(k.to_map() if k else None)
        return result

    def from_map(self, m: dict = None):
        m = m or dict()
        if m.get('eventBusName') is not None:
            self.event_bus_name = m.get('eventBusName')
        if m.get('eventRuleName') is not None:
            self.event_rule_name = m.get('eventRuleName')
        self.event_targets = []
        if m.get('eventTargets') is not None:
            for k in m.get('eventTargets'):
                temp_model = EventTarget()
                self.event_targets.append(temp_model.from_map(k))
        return self


class UpdateEventTargetsResponseBody(TeaModel):
    def __init__(
        self,
        code: str = None,
        message: str = None,
        request_id: str = None,
    ):
        # The returned response code. Valid values:
        # 
        #     *   Success: The request is successful.
        # 
        #     *   Other codes: The request failed. For more information about error codes, see Error codes.
        self.code = code
        # The returned error message.
        self.message = message
        # The request ID.
        self.request_id = request_id

    def validate(self):
        pass

    def to_map(self):
        _map = super().to_map()
        if _map is not None:
            return _map

        result = dict()
        if self.code is not None:
            result['code'] = self.code
        if self.message is not None:
            result['message'] = self.message
        if self.request_id is not None:
            result['requestId'] = self.request_id
        return result

    def from_map(self, m: dict = None):
        m = m or dict()
        if m.get('code') is not None:
            self.code = m.get('code')
        if m.get('message') is not None:
            self.message = m.get('message')
        if m.get('requestId') is not None:
            self.request_id = m.get('requestId')
        return self


class UpdateEventTargetsResponse(TeaModel):
    def __init__(
        self,
        headers: Dict[str, str] = None,
        status_code: int = None,
        body: UpdateEventTargetsResponseBody = None,
    ):
        self.headers = headers
        self.status_code = status_code
        self.body = body

    def validate(self):
        if self.body:
            self.body.validate()

    def to_map(self):
        _map = super().to_map()
        if _map is not None:
            return _map

        result = dict()
        if self.headers is not None:
            result['headers'] = self.headers
        if self.status_code is not None:
            result['statusCode'] = self.status_code
        if self.body is not None:
            result['body'] = self.body.to_map()
        return result

    def from_map(self, m: dict = None):
        m = m or dict()
        if m.get('headers') is not None:
            self.headers = m.get('headers')
        if m.get('statusCode') is not None:
            self.status_code = m.get('statusCode')
        if m.get('body') is not None:
            temp_model = UpdateEventTargetsResponseBody()
            self.body = temp_model.from_map(m['body'])
        return self


class DeleteEventTargetsRequest(TeaModel):
    def __init__(
        self,
        event_bus_name: str = None,
        event_rule_name: str = None,
        event_target_names: List[str] = None,
    ):
        # The name of the event bus.
        self.event_bus_name = event_bus_name
        # The name of the event rule.
        self.event_rule_name = event_rule_name
        # The names of the event targets that you want to delete.
        self.event_target_names = event_target_names

    def validate(self):
        self.validate_required(self.event_bus_name, 'event_bus_name')
        self.validate_required(self.event_rule_name, 'event_rule_name')

    def to_map(self):
        _map = super().to_map()
        if _map is not None:
            return _map

        result = dict()
        if self.event_bus_name is not None:
            result['eventBusName'] = self.event_bus_name
        if self.event_rule_name is not None:
            result['eventRuleName'] = self.event_rule_name
        if self.event_target_names is not None:
            result['eventTargetNames'] = self.event_target_names
        return result

    def from_map(self, m: dict = None):
        m = m or dict()
        if m.get('eventBusName') is not None:
            self.event_bus_name = m.get('eventBusName')
        if m.get('eventRuleName') is not None:
            self.event_rule_name = m.get('eventRuleName')
        if m.get('eventTargetNames') is not None:
            self.event_target_names = m.get('eventTargetNames')
        return self


class DeleteEventTargetsResponseBody(TeaModel):
    def __init__(
        self,
        code: str = None,
        message: str = None,
        request_id: str = None,
    ):
        # The returned response code. Valid values:
        # 
        #     *   Success: The request is successful.
        # 
        #     *   Other codes: The request failed. For more information about error codes, see Error codes.
        self.code = code
        # The returned error message.
        self.message = message
        # The request ID.
        self.request_id = request_id

    def validate(self):
        pass

    def to_map(self):
        _map = super().to_map()
        if _map is not None:
            return _map

        result = dict()
        if self.code is not None:
            result['code'] = self.code
        if self.message is not None:
            result['message'] = self.message
        if self.request_id is not None:
            result['requestId'] = self.request_id
        return result

    def from_map(self, m: dict = None):
        m = m or dict()
        if m.get('code') is not None:
            self.code = m.get('code')
        if m.get('message') is not None:
            self.message = m.get('message')
        if m.get('requestId') is not None:
            self.request_id = m.get('requestId')
        return self


class DeleteEventTargetsResponse(TeaModel):
    def __init__(
        self,
        headers: Dict[str, str] = None,
        status_code: int = None,
        body: DeleteEventTargetsResponseBody = None,
    ):
        self.headers = headers
        self.status_code = status_code
        self.body = body

    def validate(self):
        if self.body:
            self.body.validate()

    def to_map(self):
        _map = super().to_map()
        if _map is not None:
            return _map

        result = dict()
        if self.headers is not None:
            result['headers'] = self.headers
        if self.status_code is not None:
            result['statusCode'] = self.status_code
        if self.body is not None:
            result['body'] = self.body.to_map()
        return result

    def from_map(self, m: dict = None):
        m = m or dict()
        if m.get('headers') is not None:
            self.headers = m.get('headers')
        if m.get('statusCode') is not None:
            self.status_code = m.get('statusCode')
        if m.get('body') is not None:
            temp_model = DeleteEventTargetsResponseBody()
            self.body = temp_model.from_map(m['body'])
        return self


class ListEventTargetsRequest(TeaModel):
    def __init__(
        self,
        event_bus_name: str = None,
        event_rule_name: str = None,
    ):
        # The name of the event bus with which the event target is associated.
        # This parameter is required.
        self.event_bus_name = event_bus_name
        # The name of the event rule.
        # This parameter is required.
        self.event_rule_name = event_rule_name

    def validate(self):
        pass

    def to_map(self):
        _map = super().to_map()
        if _map is not None:
            return _map

        result = dict()
        if self.event_bus_name is not None:
            result['eventBusName'] = self.event_bus_name
        if self.event_rule_name is not None:
            result['eventRuleName'] = self.event_rule_name
        return result

    def from_map(self, m: dict = None):
        m = m or dict()
        if m.get('eventBusName') is not None:
            self.event_bus_name = m.get('eventBusName')
        if m.get('eventRuleName') is not None:
            self.event_rule_name = m.get('eventRuleName')
        return self


class ListEventTargetsResponseBodyEventTargetsRunOptionsRetryStrategy(TeaModel):
    def __init__(
        self,
        push_retry_strategy: str = None,
        maximum_event_age_in_seconds: int = None,
        maximum_retry_attempts: int = None,
    ):
        self.push_retry_strategy = push_retry_strategy
        self.maximum_event_age_in_seconds = maximum_event_age_in_seconds
        self.maximum_retry_attempts = maximum_retry_attempts

    def validate(self):
        pass

    def to_map(self):
        _map = super().to_map()
        if _map is not None:
            return _map

        result = dict()
        if self.push_retry_strategy is not None:
            result['pushRetryStrategy'] = self.push_retry_strategy
        if self.maximum_event_age_in_seconds is not None:
            result['maximumEventAgeInSeconds'] = self.maximum_event_age_in_seconds
        if self.maximum_retry_attempts is not None:
            result['maximumRetryAttempts'] = self.maximum_retry_attempts
        return result

    def from_map(self, m: dict = None):
        m = m or dict()
        if m.get('pushRetryStrategy') is not None:
            self.push_retry_strategy = m.get('pushRetryStrategy')
        if m.get('maximumEventAgeInSeconds') is not None:
            self.maximum_event_age_in_seconds = m.get('maximumEventAgeInSeconds')
        if m.get('maximumRetryAttempts') is not None:
            self.maximum_retry_attempts = m.get('maximumRetryAttempts')
        return self


class ListEventTargetsResponseBodyEventTargetsRunOptionsDeadLetterQueue(TeaModel):
    def __init__(
        self,
        type: str = None,
        config: Dict[str, Any] = None,
    ):
        self.type = type
        self.config = config

    def validate(self):
        pass

    def to_map(self):
        _map = super().to_map()
        if _map is not None:
            return _map

        result = dict()
        if self.type is not None:
            result['type'] = self.type
        if self.config is not None:
            result['config'] = self.config
        return result

    def from_map(self, m: dict = None):
        m = m or dict()
        if m.get('type') is not None:
            self.type = m.get('type')
        if m.get('config') is not None:
            self.config = m.get('config')
        return self


class ListEventTargetsResponseBodyEventTargetsRunOptions(TeaModel):
    def __init__(
        self,
        errors_tolerance: str = None,
        retry_strategy: ListEventTargetsResponseBodyEventTargetsRunOptionsRetryStrategy = None,
        dead_letter_queue: ListEventTargetsResponseBodyEventTargetsRunOptionsDeadLetterQueue = None,
    ):
        self.errors_tolerance = errors_tolerance
        self.retry_strategy = retry_strategy
        self.dead_letter_queue = dead_letter_queue

    def validate(self):
        if self.retry_strategy:
            self.retry_strategy.validate()
        if self.dead_letter_queue:
            self.dead_letter_queue.validate()

    def to_map(self):
        _map = super().to_map()
        if _map is not None:
            return _map

        result = dict()
        if self.errors_tolerance is not None:
            result['errorsTolerance'] = self.errors_tolerance
        if self.retry_strategy is not None:
            result['retryStrategy'] = self.retry_strategy.to_map()
        if self.dead_letter_queue is not None:
            result['deadLetterQueue'] = self.dead_letter_queue.to_map()
        return result

    def from_map(self, m: dict = None):
        m = m or dict()
        if m.get('errorsTolerance') is not None:
            self.errors_tolerance = m.get('errorsTolerance')
        if m.get('retryStrategy') is not None:
            temp_model = ListEventTargetsResponseBodyEventTargetsRunOptionsRetryStrategy()
            self.retry_strategy = temp_model.from_map(m['retryStrategy'])
        if m.get('deadLetterQueue') is not None:
            temp_model = ListEventTargetsResponseBodyEventTargetsRunOptionsDeadLetterQueue()
            self.dead_letter_queue = temp_model.from_map(m['deadLetterQueue'])
        return self


class ListEventTargetsResponseBodyEventTargets(TeaModel):
    def __init__(
        self,
        event_target_name: str = None,
        class_name: str = None,
        config: Dict[str, Any] = None,
        run_options: ListEventTargetsResponseBodyEventTargetsRunOptions = None,
    ):
        self.event_target_name = event_target_name
        self.class_name = class_name
        self.config = config
        self.run_options = run_options

    def validate(self):
        if self.run_options:
            self.run_options.validate()

    def to_map(self):
        _map = super().to_map()
        if _map is not None:
            return _map

        result = dict()
        if self.event_target_name is not None:
            result['eventTargetName'] = self.event_target_name
        if self.class_name is not None:
            result['className'] = self.class_name
        if self.config is not None:
            result['config'] = self.config
        if self.run_options is not None:
            result['runOptions'] = self.run_options.to_map()
        return result

    def from_map(self, m: dict = None):
        m = m or dict()
        if m.get('eventTargetName') is not None:
            self.event_target_name = m.get('eventTargetName')
        if m.get('className') is not None:
            self.class_name = m.get('className')
        if m.get('config') is not None:
            self.config = m.get('config')
        if m.get('runOptions') is not None:
            temp_model = ListEventTargetsResponseBodyEventTargetsRunOptions()
            self.run_options = temp_model.from_map(m['runOptions'])
        return self


class ListEventTargetsResponseBody(TeaModel):
    def __init__(
        self,
        event_bus_name: str = None,
        event_rule_name: str = None,
        event_targets: List[ListEventTargetsResponseBodyEventTargets] = None,
    ):
        # The name of the event bus with which the event target is associated.
        # This parameter is required.
        self.event_bus_name = event_bus_name
        # The name of the event rule.
        # This parameter is required.
        self.event_rule_name = event_rule_name
        self.event_targets = event_targets

    def validate(self):
        if self.event_targets:
            for k in self.event_targets:
                if k:
                    k.validate()

    def to_map(self):
        _map = super().to_map()
        if _map is not None:
            return _map

        result = dict()
        if self.event_bus_name is not None:
            result['eventBusName'] = self.event_bus_name
        if self.event_rule_name is not None:
            result['eventRuleName'] = self.event_rule_name
        result['eventTargets'] = []
        if self.event_targets is not None:
            for k in self.event_targets:
                result['eventTargets'].append(k.to_map() if k else None)
        return result

    def from_map(self, m: dict = None):
        m = m or dict()
        if m.get('eventBusName') is not None:
            self.event_bus_name = m.get('eventBusName')
        if m.get('eventRuleName') is not None:
            self.event_rule_name = m.get('eventRuleName')
        self.event_targets = []
        if m.get('eventTargets') is not None:
            for k in m.get('eventTargets'):
                temp_model = ListEventTargetsResponseBodyEventTargets()
                self.event_targets.append(temp_model.from_map(k))
        return self


class ListEventTargetsResponse(TeaModel):
    def __init__(
        self,
        headers: Dict[str, str] = None,
        status_code: int = None,
        body: ListEventTargetsResponseBody = None,
    ):
        self.headers = headers
        self.status_code = status_code
        self.body = body

    def validate(self):
        if self.body:
            self.body.validate()

    def to_map(self):
        _map = super().to_map()
        if _map is not None:
            return _map

        result = dict()
        if self.headers is not None:
            result['headers'] = self.headers
        if self.status_code is not None:
            result['statusCode'] = self.status_code
        if self.body is not None:
            result['body'] = self.body.to_map()
        return result

    def from_map(self, m: dict = None):
        m = m or dict()
        if m.get('headers') is not None:
            self.headers = m.get('headers')
        if m.get('statusCode') is not None:
            self.status_code = m.get('statusCode')
        if m.get('body') is not None:
            temp_model = ListEventTargetsResponseBody()
            self.body = temp_model.from_map(m['body'])
        return self


class ListEventTypesRequest(TeaModel):
    """
    EventType Controller apis:
        * listEventTypes *\
    """
    def __init__(
        self,
        event_bus_name: str = None,
        event_source_name: str = None,
        max_results: int = None,
        next_token: str = None,
    ):
        # The name of the event bus.
        # This parameter is required.
        self.event_bus_name = event_bus_name
        # EventSource is required for querying default bus events.
        self.event_source_name = event_source_name
        # The number of entries returned per page.
        self.max_results = max_results
        # If excess return values exist, this parameter is returned.
        self.next_token = next_token

    def validate(self):
        pass

    def to_map(self):
        _map = super().to_map()
        if _map is not None:
            return _map

        result = dict()
        if self.event_bus_name is not None:
            result['eventBusName'] = self.event_bus_name
        if self.event_source_name is not None:
            result['eventSourceName'] = self.event_source_name
        if self.max_results is not None:
            result['maxResults'] = self.max_results
        if self.next_token is not None:
            result['nextToken'] = self.next_token
        return result

    def from_map(self, m: dict = None):
        m = m or dict()
        if m.get('eventBusName') is not None:
            self.event_bus_name = m.get('eventBusName')
        if m.get('eventSourceName') is not None:
            self.event_source_name = m.get('eventSourceName')
        if m.get('maxResults') is not None:
            self.max_results = m.get('maxResults')
        if m.get('nextToken') is not None:
            self.next_token = m.get('nextToken')
        return self


class ListEventTypesResponseBodyEventTypes(TeaModel):
    def __init__(
        self,
        event_bus_name: str = None,
        event_source_name: str = None,
        event_type_name: str = None,
        description: str = None,
        gmt_create: str = None,
        gmt_modify: str = None,
    ):
        # The name of the event bus.
        # This parameter is required.
        self.event_bus_name = event_bus_name
        # EventSource is required for querying default bus events.
        self.event_source_name = event_source_name
        # The name of the event type.
        self.event_type_name = event_type_name
        # The description of the event type.
        self.description = description
        self.gmt_create = gmt_create
        self.gmt_modify = gmt_modify

    def validate(self):
        pass

    def to_map(self):
        _map = super().to_map()
        if _map is not None:
            return _map

        result = dict()
        if self.event_bus_name is not None:
            result['eventBusName'] = self.event_bus_name
        if self.event_source_name is not None:
            result['eventSourceName'] = self.event_source_name
        if self.event_type_name is not None:
            result['eventTypeName'] = self.event_type_name
        if self.description is not None:
            result['description'] = self.description
        if self.gmt_create is not None:
            result['gmtCreate'] = self.gmt_create
        if self.gmt_modify is not None:
            result['gmtModify'] = self.gmt_modify
        return result

    def from_map(self, m: dict = None):
        m = m or dict()
        if m.get('eventBusName') is not None:
            self.event_bus_name = m.get('eventBusName')
        if m.get('eventSourceName') is not None:
            self.event_source_name = m.get('eventSourceName')
        if m.get('eventTypeName') is not None:
            self.event_type_name = m.get('eventTypeName')
        if m.get('description') is not None:
            self.description = m.get('description')
        if m.get('gmtCreate') is not None:
            self.gmt_create = m.get('gmtCreate')
        if m.get('gmtModify') is not None:
            self.gmt_modify = m.get('gmtModify')
        return self


class ListEventTypesResponseBody(TeaModel):
    def __init__(
        self,
        event_types: List[ListEventTypesResponseBodyEventTypes] = None,
        next_token: str = None,
        total: int = None,
        max_results: int = None,
        code: str = None,
        message: str = None,
        request_id: str = None,
    ):
        self.event_types = event_types
        # If excess return values exist, this parameter is returned.
        self.next_token = next_token
        # The total number of entries.
        self.total = total
        # If you set Limit and excess return values exist, this parameter is returned.
        self.max_results = max_results
        # The status code returned. The status code 200 indicates that the request was successful.
        self.code = code
        # The error message that is returned if the request failed.
        self.message = message
        # The request ID.
        self.request_id = request_id

    def validate(self):
        if self.event_types:
            for k in self.event_types:
                if k:
                    k.validate()

    def to_map(self):
        _map = super().to_map()
        if _map is not None:
            return _map

        result = dict()
        result['eventTypes'] = []
        if self.event_types is not None:
            for k in self.event_types:
                result['eventTypes'].append(k.to_map() if k else None)
        if self.next_token is not None:
            result['nextToken'] = self.next_token
        if self.total is not None:
            result['total'] = self.total
        if self.max_results is not None:
            result['maxResults'] = self.max_results
        if self.code is not None:
            result['code'] = self.code
        if self.message is not None:
            result['message'] = self.message
        if self.request_id is not None:
            result['requestId'] = self.request_id
        return result

    def from_map(self, m: dict = None):
        m = m or dict()
        self.event_types = []
        if m.get('eventTypes') is not None:
            for k in m.get('eventTypes'):
                temp_model = ListEventTypesResponseBodyEventTypes()
                self.event_types.append(temp_model.from_map(k))
        if m.get('nextToken') is not None:
            self.next_token = m.get('nextToken')
        if m.get('total') is not None:
            self.total = m.get('total')
        if m.get('maxResults') is not None:
            self.max_results = m.get('maxResults')
        if m.get('code') is not None:
            self.code = m.get('code')
        if m.get('message') is not None:
            self.message = m.get('message')
        if m.get('requestId') is not None:
            self.request_id = m.get('requestId')
        return self


class ListEventTypesResponse(TeaModel):
    def __init__(
        self,
        headers: Dict[str, str] = None,
        status_code: int = None,
        body: ListEventTypesResponseBody = None,
    ):
        self.headers = headers
        self.status_code = status_code
        self.body = body

    def validate(self):
        if self.body:
            self.body.validate()

    def to_map(self):
        _map = super().to_map()
        if _map is not None:
            return _map

        result = dict()
        if self.headers is not None:
            result['headers'] = self.headers
        if self.status_code is not None:
            result['statusCode'] = self.status_code
        if self.body is not None:
            result['body'] = self.body.to_map()
        return result

    def from_map(self, m: dict = None):
        m = m or dict()
        if m.get('headers') is not None:
            self.headers = m.get('headers')
        if m.get('statusCode') is not None:
            self.status_code = m.get('statusCode')
        if m.get('body') is not None:
            temp_model = ListEventTypesResponseBody()
            self.body = temp_model.from_map(m['body'])
        return self


