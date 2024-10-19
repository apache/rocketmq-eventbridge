# -*- coding: utf-8 -*-
# This file is auto-generated, don't edit it. Thanks.
from Tea.exceptions import TeaException
from typing import Dict
from Tea.core import TeaCore

from alibabacloud_tea_openapi.client import Client as OpenApiClient
from alibabacloud_tea_openapi import models as open_api_models
from alibabacloud_tea_util.client import Client as UtilClient
from rocketmq_eventbridge import models as sdk_client_models
from alibabacloud_tea_util import models as util_models


class Client(OpenApiClient):
    def __init__(
        self, 
        config: open_api_models.Config,
    ):
        super().__init__(config)
        self._endpoint_rule = ''
        self.check_config(config)
        self._endpoint = self.get_endpoint('eventbridge', self._region_id, self._endpoint_rule, self._network, self._suffix, self._endpoint_map, self._endpoint)

    def get_endpoint(
        self,
        product_id: str,
        region_id: str,
        endpoint_rule: str,
        network: str,
        suffix: str,
        endpoint_map: Dict[str, str],
        endpoint: str,
    ) -> str:
        if not UtilClient.empty(endpoint):
            return endpoint
        if not UtilClient.is_unset(endpoint_map) and not UtilClient.empty(endpoint_map.get(region_id)):
            return endpoint_map.get(region_id)
        result = ''
        if not UtilClient.empty(network) and not UtilClient.equal_string(network, 'public'):
            network = f'-{network}'
        else:
            network = ''
        if not UtilClient.is_unset(suffix):
            suffix = ''
        else:
            suffix = f'-{suffix}'
        if UtilClient.equal_string(endpoint_rule, 'regional'):
            if UtilClient.empty(region_id):
                raise TeaException({
                    'message': 'RegionId is empty, please set a valid RegionId'
                })
            result = f'{product_id}{suffix}{network}.{region_id}.aliyuncs.com'
        else:
            result = f'{product_id}{suffix}{network}.aliyuncs.com'
        return result

    def create_event_bus_with_options(
        self,
        request: sdk_client_models.CreateEventBusRequest,
        runtime: util_models.RuntimeOptions,
    ) -> sdk_client_models.CreateEventBusResponse:
        """
        @summary Creates an event bus.
        
        @description You can call this API operation to create an event bus.
        
        @param request: CreateEventBusRequest
        @param runtime: runtime options for this request RuntimeOptions
        @return: CreateEventBusResponse
        """
        UtilClient.validate_model(request)
        body = {}
        if not UtilClient.is_unset(request.description):
            body['description'] = request.description
        if not UtilClient.is_unset(request.event_bus_name):
            body['eventBusName'] = request.event_bus_name
        req = open_api_models.OpenApiRequest(
            body=UtilClient.to_jsonstring(body)
        )
        params = open_api_models.Params(
            action='CreateEventBus',
            version='2024-07-01',
            protocol='HTTP',
            pathname='/bus/createEventBus',
            method='POST',
            auth_type='Anonymous',
            style='RPC',
            req_body_type='json',
            body_type='json'
        )
        return TeaCore.from_map(
            sdk_client_models.CreateEventBusResponse(),
            self.call_api(params, req, runtime)
        )

    async def create_event_bus_with_options_async(
        self,
        request: sdk_client_models.CreateEventBusRequest,
        runtime: util_models.RuntimeOptions,
    ) -> sdk_client_models.CreateEventBusResponse:
        """
        @summary Creates an event bus.
        
        @description You can call this API operation to create an event bus.
        
        @param request: CreateEventBusRequest
        @param runtime: runtime options for this request RuntimeOptions
        @return: CreateEventBusResponse
        """
        UtilClient.validate_model(request)
        body = {}
        if not UtilClient.is_unset(request.description):
            body['description'] = request.description
        if not UtilClient.is_unset(request.event_bus_name):
            body['eventBusName'] = request.event_bus_name
        req = open_api_models.OpenApiRequest(
            body=UtilClient.to_jsonstring(body)
        )
        params = open_api_models.Params(
            action='CreateEventBus',
            version='2024-07-01',
            protocol='HTTP',
            pathname='/bus/createEventBus',
            method='POST',
            auth_type='Anonymous',
            style='RPC',
            req_body_type='json',
            body_type='json'
        )
        return TeaCore.from_map(
            sdk_client_models.CreateEventBusResponse(),
            await self.call_api_async(params, req, runtime)
        )

    def create_event_bus(
        self,
        request: sdk_client_models.CreateEventBusRequest,
    ) -> sdk_client_models.CreateEventBusResponse:
        """
        @summary Creates an event bus.
        
        @description You can call this API operation to create an event bus.
        
        @param request: CreateEventBusRequest
        @return: CreateEventBusResponse
        """
        runtime = util_models.RuntimeOptions()
        return self.create_event_bus_with_options(request, runtime)

    async def create_event_bus_async(
        self,
        request: sdk_client_models.CreateEventBusRequest,
    ) -> sdk_client_models.CreateEventBusResponse:
        """
        @summary Creates an event bus.
        
        @description You can call this API operation to create an event bus.
        
        @param request: CreateEventBusRequest
        @return: CreateEventBusResponse
        """
        runtime = util_models.RuntimeOptions()
        return await self.create_event_bus_with_options_async(request, runtime)

    def get_event_bus_with_options(
        self,
        request: sdk_client_models.GetEventBusRequest,
        runtime: util_models.RuntimeOptions,
    ) -> sdk_client_models.GetEventBusResponse:
        """
        @summary Queries the detailed information about an event bus.
        
        @description You can call this API operation to query the detailed information about an event bus.
        
        @param request: GetEventBusRequest
        @param runtime: runtime options for this request RuntimeOptions
        @return: GetEventBusResponse
        """
        UtilClient.validate_model(request)
        body = {}
        if not UtilClient.is_unset(request.event_bus_name):
            body['eventBusName'] = request.event_bus_name
        req = open_api_models.OpenApiRequest(
            body=UtilClient.to_jsonstring(body)
        )
        params = open_api_models.Params(
            action='GetEventBus',
            version='2024-07-01',
            protocol='HTTP',
            pathname='/bus/getEventBus',
            method='POST',
            auth_type='Anonymous',
            style='RPC',
            req_body_type='json',
            body_type='json'
        )
        return TeaCore.from_map(
            sdk_client_models.GetEventBusResponse(),
            self.call_api(params, req, runtime)
        )

    async def get_event_bus_with_options_async(
        self,
        request: sdk_client_models.GetEventBusRequest,
        runtime: util_models.RuntimeOptions,
    ) -> sdk_client_models.GetEventBusResponse:
        """
        @summary Queries the detailed information about an event bus.
        
        @description You can call this API operation to query the detailed information about an event bus.
        
        @param request: GetEventBusRequest
        @param runtime: runtime options for this request RuntimeOptions
        @return: GetEventBusResponse
        """
        UtilClient.validate_model(request)
        body = {}
        if not UtilClient.is_unset(request.event_bus_name):
            body['eventBusName'] = request.event_bus_name
        req = open_api_models.OpenApiRequest(
            body=UtilClient.to_jsonstring(body)
        )
        params = open_api_models.Params(
            action='GetEventBus',
            version='2024-07-01',
            protocol='HTTP',
            pathname='/bus/getEventBus',
            method='POST',
            auth_type='Anonymous',
            style='RPC',
            req_body_type='json',
            body_type='json'
        )
        return TeaCore.from_map(
            sdk_client_models.GetEventBusResponse(),
            await self.call_api_async(params, req, runtime)
        )

    def get_event_bus(
        self,
        request: sdk_client_models.GetEventBusRequest,
    ) -> sdk_client_models.GetEventBusResponse:
        """
        @summary Queries the detailed information about an event bus.
        
        @description You can call this API operation to query the detailed information about an event bus.
        
        @param request: GetEventBusRequest
        @return: GetEventBusResponse
        """
        runtime = util_models.RuntimeOptions()
        return self.get_event_bus_with_options(request, runtime)

    async def get_event_bus_async(
        self,
        request: sdk_client_models.GetEventBusRequest,
    ) -> sdk_client_models.GetEventBusResponse:
        """
        @summary Queries the detailed information about an event bus.
        
        @description You can call this API operation to query the detailed information about an event bus.
        
        @param request: GetEventBusRequest
        @return: GetEventBusResponse
        """
        runtime = util_models.RuntimeOptions()
        return await self.get_event_bus_with_options_async(request, runtime)

    def list_event_buses_with_options(
        self,
        request: sdk_client_models.ListEventBusesRequest,
        runtime: util_models.RuntimeOptions,
    ) -> sdk_client_models.ListEventBusesResponse:
        """
        @summary Queries all event buses.
        
        @description You can call this API operation to query all event buses.
        
        @param request: ListEventBusesRequest
        @param runtime: runtime options for this request RuntimeOptions
        @return: ListEventBusesResponse
        """
        UtilClient.validate_model(request)
        body = {}
        if not UtilClient.is_unset(request.max_results):
            body['maxResults'] = request.max_results
        if not UtilClient.is_unset(request.next_token):
            body['nextToken'] = request.next_token
        req = open_api_models.OpenApiRequest(
            body=UtilClient.to_jsonstring(body)
        )
        params = open_api_models.Params(
            action='ListEventBuses',
            version='2024-07-01',
            protocol='HTTP',
            pathname='/bus/listEventBuses',
            method='POST',
            auth_type='Anonymous',
            style='RPC',
            req_body_type='json',
            body_type='json'
        )
        return TeaCore.from_map(
            sdk_client_models.ListEventBusesResponse(),
            self.call_api(params, req, runtime)
        )

    async def list_event_buses_with_options_async(
        self,
        request: sdk_client_models.ListEventBusesRequest,
        runtime: util_models.RuntimeOptions,
    ) -> sdk_client_models.ListEventBusesResponse:
        """
        @summary Queries all event buses.
        
        @description You can call this API operation to query all event buses.
        
        @param request: ListEventBusesRequest
        @param runtime: runtime options for this request RuntimeOptions
        @return: ListEventBusesResponse
        """
        UtilClient.validate_model(request)
        body = {}
        if not UtilClient.is_unset(request.max_results):
            body['maxResults'] = request.max_results
        if not UtilClient.is_unset(request.next_token):
            body['nextToken'] = request.next_token
        req = open_api_models.OpenApiRequest(
            body=UtilClient.to_jsonstring(body)
        )
        params = open_api_models.Params(
            action='ListEventBuses',
            version='2024-07-01',
            protocol='HTTP',
            pathname='/bus/listEventBuses',
            method='POST',
            auth_type='Anonymous',
            style='RPC',
            req_body_type='json',
            body_type='json'
        )
        return TeaCore.from_map(
            sdk_client_models.ListEventBusesResponse(),
            await self.call_api_async(params, req, runtime)
        )

    def list_event_buses(
        self,
        request: sdk_client_models.ListEventBusesRequest,
    ) -> sdk_client_models.ListEventBusesResponse:
        """
        @summary Queries all event buses.
        
        @description You can call this API operation to query all event buses.
        
        @param request: ListEventBusesRequest
        @return: ListEventBusesResponse
        """
        runtime = util_models.RuntimeOptions()
        return self.list_event_buses_with_options(request, runtime)

    async def list_event_buses_async(
        self,
        request: sdk_client_models.ListEventBusesRequest,
    ) -> sdk_client_models.ListEventBusesResponse:
        """
        @summary Queries all event buses.
        
        @description You can call this API operation to query all event buses.
        
        @param request: ListEventBusesRequest
        @return: ListEventBusesResponse
        """
        runtime = util_models.RuntimeOptions()
        return await self.list_event_buses_with_options_async(request, runtime)

    def delete_event_bus_with_options(
        self,
        request: sdk_client_models.DeleteEventBusRequest,
        runtime: util_models.RuntimeOptions,
    ) -> sdk_client_models.DeleteEventBusResponse:
        """
        @summary Deletes an event bus.
        
        @description You can call this API operation to delete an event bus.
        
        @param request: DeleteEventBusRequest
        @param runtime: runtime options for this request RuntimeOptions
        @return: DeleteEventBusResponse
        """
        UtilClient.validate_model(request)
        body = {}
        if not UtilClient.is_unset(request.event_bus_name):
            body['eventBusName'] = request.event_bus_name
        req = open_api_models.OpenApiRequest(
            body=UtilClient.to_jsonstring(body)
        )
        params = open_api_models.Params(
            action='DeleteEventBus',
            version='2024-07-01',
            protocol='HTTP',
            pathname='/bus/deleteEventBus',
            method='POST',
            auth_type='Anonymous',
            style='RPC',
            req_body_type='json',
            body_type='json'
        )
        return TeaCore.from_map(
            sdk_client_models.DeleteEventBusResponse(),
            self.call_api(params, req, runtime)
        )

    async def delete_event_bus_with_options_async(
        self,
        request: sdk_client_models.DeleteEventBusRequest,
        runtime: util_models.RuntimeOptions,
    ) -> sdk_client_models.DeleteEventBusResponse:
        """
        @summary Deletes an event bus.
        
        @description You can call this API operation to delete an event bus.
        
        @param request: DeleteEventBusRequest
        @param runtime: runtime options for this request RuntimeOptions
        @return: DeleteEventBusResponse
        """
        UtilClient.validate_model(request)
        body = {}
        if not UtilClient.is_unset(request.event_bus_name):
            body['eventBusName'] = request.event_bus_name
        req = open_api_models.OpenApiRequest(
            body=UtilClient.to_jsonstring(body)
        )
        params = open_api_models.Params(
            action='DeleteEventBus',
            version='2024-07-01',
            protocol='HTTP',
            pathname='/bus/deleteEventBus',
            method='POST',
            auth_type='Anonymous',
            style='RPC',
            req_body_type='json',
            body_type='json'
        )
        return TeaCore.from_map(
            sdk_client_models.DeleteEventBusResponse(),
            await self.call_api_async(params, req, runtime)
        )

    def delete_event_bus(
        self,
        request: sdk_client_models.DeleteEventBusRequest,
    ) -> sdk_client_models.DeleteEventBusResponse:
        """
        @summary Deletes an event bus.
        
        @description You can call this API operation to delete an event bus.
        
        @param request: DeleteEventBusRequest
        @return: DeleteEventBusResponse
        """
        runtime = util_models.RuntimeOptions()
        return self.delete_event_bus_with_options(request, runtime)

    async def delete_event_bus_async(
        self,
        request: sdk_client_models.DeleteEventBusRequest,
    ) -> sdk_client_models.DeleteEventBusResponse:
        """
        @summary Deletes an event bus.
        
        @description You can call this API operation to delete an event bus.
        
        @param request: DeleteEventBusRequest
        @return: DeleteEventBusResponse
        """
        runtime = util_models.RuntimeOptions()
        return await self.delete_event_bus_with_options_async(request, runtime)

    def create_api_destination_with_options(
        self,
        request: sdk_client_models.CreateApiDestinationRequest,
        runtime: util_models.RuntimeOptions,
    ) -> sdk_client_models.CreateApiDestinationResponse:
        """
        @summary Creates an API destination.
        
        @description You can call this API operation to create an API destination.
        
        @param request: CreateApiDestinationRequest (tmpReq before)
        @param runtime: runtime options for this request RuntimeOptions
        @return: CreateApiDestinationResponse
        """
        UtilClient.validate_model(request)
        body = {}
        if not UtilClient.is_unset(request.api_destination_name):
            body['apiDestinationName'] = request.api_destination_name
        if not UtilClient.is_unset(request.connection_name):
            body['connectionName'] = request.connection_name
        if not UtilClient.is_unset(request.description):
            body['description'] = request.description
        if not UtilClient.is_unset(request.http_api_parameters):
            body['httpApiParameters'] = request.http_api_parameters
        if not UtilClient.is_unset(request.invocation_rate_limit_per_second):
            body['invocationRateLimitPerSecond'] = request.invocation_rate_limit_per_second
        req = open_api_models.OpenApiRequest(
            body=UtilClient.to_jsonstring(body)
        )
        params = open_api_models.Params(
            action='CreateApiDestination',
            version='2024-07-01',
            protocol='HTTP',
            pathname='/api-destination/createApiDestination',
            method='POST',
            auth_type='Anonymous',
            style='RPC',
            req_body_type='json',
            body_type='json'
        )
        return TeaCore.from_map(
            sdk_client_models.CreateApiDestinationResponse(),
            self.call_api(params, req, runtime)
        )

    async def create_api_destination_with_options_async(
        self,
        request: sdk_client_models.CreateApiDestinationRequest,
        runtime: util_models.RuntimeOptions,
    ) -> sdk_client_models.CreateApiDestinationResponse:
        """
        @summary Creates an API destination.
        
        @description You can call this API operation to create an API destination.
        
        @param request: CreateApiDestinationRequest (tmpReq before)
        @param runtime: runtime options for this request RuntimeOptions
        @return: CreateApiDestinationResponse
        """
        UtilClient.validate_model(request)
        body = {}
        if not UtilClient.is_unset(request.api_destination_name):
            body['apiDestinationName'] = request.api_destination_name
        if not UtilClient.is_unset(request.connection_name):
            body['connectionName'] = request.connection_name
        if not UtilClient.is_unset(request.description):
            body['description'] = request.description
        if not UtilClient.is_unset(request.http_api_parameters):
            body['httpApiParameters'] = request.http_api_parameters
        if not UtilClient.is_unset(request.invocation_rate_limit_per_second):
            body['invocationRateLimitPerSecond'] = request.invocation_rate_limit_per_second
        req = open_api_models.OpenApiRequest(
            body=UtilClient.to_jsonstring(body)
        )
        params = open_api_models.Params(
            action='CreateApiDestination',
            version='2024-07-01',
            protocol='HTTP',
            pathname='/api-destination/createApiDestination',
            method='POST',
            auth_type='Anonymous',
            style='RPC',
            req_body_type='json',
            body_type='json'
        )
        return TeaCore.from_map(
            sdk_client_models.CreateApiDestinationResponse(),
            await self.call_api_async(params, req, runtime)
        )

    def create_api_destination(
        self,
        request: sdk_client_models.CreateApiDestinationRequest,
    ) -> sdk_client_models.CreateApiDestinationResponse:
        """
        @summary Creates an API destination.
        
        @description You can call this API operation to create an API destination.
        
        @param request: CreateApiDestinationRequest
        @return: CreateApiDestinationResponse
        """
        runtime = util_models.RuntimeOptions()
        return self.create_api_destination_with_options(request, runtime)

    async def create_api_destination_async(
        self,
        request: sdk_client_models.CreateApiDestinationRequest,
    ) -> sdk_client_models.CreateApiDestinationResponse:
        """
        @summary Creates an API destination.
        
        @description You can call this API operation to create an API destination.
        
        @param request: CreateApiDestinationRequest
        @return: CreateApiDestinationResponse
        """
        runtime = util_models.RuntimeOptions()
        return await self.create_api_destination_with_options_async(request, runtime)

    def update_api_destination_with_options(
        self,
        request: sdk_client_models.UpdateApiDestinationRequest,
        runtime: util_models.RuntimeOptions,
    ) -> sdk_client_models.UpdateApiDestinationResponse:
        """
        @summary Updates an API destination.
        
        @description You can call this API operation to update an API destination.
        
        @param request: UpdateApiDestinationRequest
        @param runtime: runtime options for this request RuntimeOptions
        @return: UpdateApiDestinationResponse
        """
        UtilClient.validate_model(request)
        body = {}
        if not UtilClient.is_unset(request.api_destination_name):
            body['apiDestinationName'] = request.api_destination_name
        if not UtilClient.is_unset(request.connection_name):
            body['connectionName'] = request.connection_name
        if not UtilClient.is_unset(request.description):
            body['description'] = request.description
        if not UtilClient.is_unset(request.http_api_parameters):
            body['httpApiParameters'] = request.http_api_parameters
        if not UtilClient.is_unset(request.invocation_rate_limit_per_second):
            body['invocationRateLimitPerSecond'] = request.invocation_rate_limit_per_second
        req = open_api_models.OpenApiRequest(
            body=UtilClient.to_jsonstring(body)
        )
        params = open_api_models.Params(
            action='UpdateApiDestination',
            version='2024-07-01',
            protocol='HTTP',
            pathname='/api-destination/updateApiDestination',
            method='POST',
            auth_type='Anonymous',
            style='RPC',
            req_body_type='json',
            body_type='json'
        )
        return TeaCore.from_map(
            sdk_client_models.UpdateApiDestinationResponse(),
            self.call_api(params, req, runtime)
        )

    async def update_api_destination_with_options_async(
        self,
        request: sdk_client_models.UpdateApiDestinationRequest,
        runtime: util_models.RuntimeOptions,
    ) -> sdk_client_models.UpdateApiDestinationResponse:
        """
        @summary Updates an API destination.
        
        @description You can call this API operation to update an API destination.
        
        @param request: UpdateApiDestinationRequest
        @param runtime: runtime options for this request RuntimeOptions
        @return: UpdateApiDestinationResponse
        """
        UtilClient.validate_model(request)
        body = {}
        if not UtilClient.is_unset(request.api_destination_name):
            body['apiDestinationName'] = request.api_destination_name
        if not UtilClient.is_unset(request.connection_name):
            body['connectionName'] = request.connection_name
        if not UtilClient.is_unset(request.description):
            body['description'] = request.description
        if not UtilClient.is_unset(request.http_api_parameters):
            body['httpApiParameters'] = request.http_api_parameters
        if not UtilClient.is_unset(request.invocation_rate_limit_per_second):
            body['invocationRateLimitPerSecond'] = request.invocation_rate_limit_per_second
        req = open_api_models.OpenApiRequest(
            body=UtilClient.to_jsonstring(body)
        )
        params = open_api_models.Params(
            action='UpdateApiDestination',
            version='2024-07-01',
            protocol='HTTP',
            pathname='/api-destination/updateApiDestination',
            method='POST',
            auth_type='Anonymous',
            style='RPC',
            req_body_type='json',
            body_type='json'
        )
        return TeaCore.from_map(
            sdk_client_models.UpdateApiDestinationResponse(),
            await self.call_api_async(params, req, runtime)
        )

    def update_api_destination(
        self,
        request: sdk_client_models.UpdateApiDestinationRequest,
    ) -> sdk_client_models.UpdateApiDestinationResponse:
        """
        @summary Updates an API destination.
        
        @description You can call this API operation to update an API destination.
        
        @param request: UpdateApiDestinationRequest
        @return: UpdateApiDestinationResponse
        """
        runtime = util_models.RuntimeOptions()
        return self.update_api_destination_with_options(request, runtime)

    async def update_api_destination_async(
        self,
        request: sdk_client_models.UpdateApiDestinationRequest,
    ) -> sdk_client_models.UpdateApiDestinationResponse:
        """
        @summary Updates an API destination.
        
        @description You can call this API operation to update an API destination.
        
        @param request: UpdateApiDestinationRequest
        @return: UpdateApiDestinationResponse
        """
        runtime = util_models.RuntimeOptions()
        return await self.update_api_destination_with_options_async(request, runtime)

    def get_api_destination_with_options(
        self,
        request: sdk_client_models.GetApiDestinationRequest,
        runtime: util_models.RuntimeOptions,
    ) -> sdk_client_models.GetApiDestinationResponse:
        """
        @summary Queries the information about an API destination.
        
        @description You can call this API operation to query the information about an API destination.
        
        @param request: GetApiDestinationRequest
        @param runtime: runtime options for this request RuntimeOptions
        @return: GetApiDestinationResponse
        """
        UtilClient.validate_model(request)
        body = {}
        if not UtilClient.is_unset(request.api_destination_name):
            body['apiDestinationName'] = request.api_destination_name
        req = open_api_models.OpenApiRequest(
            body=UtilClient.to_jsonstring(body)
        )
        params = open_api_models.Params(
            action='GetApiDestination',
            version='2024-07-01',
            protocol='HTTP',
            pathname='/api-destination/getApiDestination',
            method='POST',
            auth_type='Anonymous',
            style='RPC',
            req_body_type='json',
            body_type='json'
        )
        return TeaCore.from_map(
            sdk_client_models.GetApiDestinationResponse(),
            self.call_api(params, req, runtime)
        )

    async def get_api_destination_with_options_async(
        self,
        request: sdk_client_models.GetApiDestinationRequest,
        runtime: util_models.RuntimeOptions,
    ) -> sdk_client_models.GetApiDestinationResponse:
        """
        @summary Queries the information about an API destination.
        
        @description You can call this API operation to query the information about an API destination.
        
        @param request: GetApiDestinationRequest
        @param runtime: runtime options for this request RuntimeOptions
        @return: GetApiDestinationResponse
        """
        UtilClient.validate_model(request)
        body = {}
        if not UtilClient.is_unset(request.api_destination_name):
            body['apiDestinationName'] = request.api_destination_name
        req = open_api_models.OpenApiRequest(
            body=UtilClient.to_jsonstring(body)
        )
        params = open_api_models.Params(
            action='GetApiDestination',
            version='2024-07-01',
            protocol='HTTP',
            pathname='/api-destination/getApiDestination',
            method='POST',
            auth_type='Anonymous',
            style='RPC',
            req_body_type='json',
            body_type='json'
        )
        return TeaCore.from_map(
            sdk_client_models.GetApiDestinationResponse(),
            await self.call_api_async(params, req, runtime)
        )

    def get_api_destination(
        self,
        request: sdk_client_models.GetApiDestinationRequest,
    ) -> sdk_client_models.GetApiDestinationResponse:
        """
        @summary Queries the information about an API destination.
        
        @description You can call this API operation to query the information about an API destination.
        
        @param request: GetApiDestinationRequest
        @return: GetApiDestinationResponse
        """
        runtime = util_models.RuntimeOptions()
        return self.get_api_destination_with_options(request, runtime)

    async def get_api_destination_async(
        self,
        request: sdk_client_models.GetApiDestinationRequest,
    ) -> sdk_client_models.GetApiDestinationResponse:
        """
        @summary Queries the information about an API destination.
        
        @description You can call this API operation to query the information about an API destination.
        
        @param request: GetApiDestinationRequest
        @return: GetApiDestinationResponse
        """
        runtime = util_models.RuntimeOptions()
        return await self.get_api_destination_with_options_async(request, runtime)

    def delete_api_destination_with_options(
        self,
        request: sdk_client_models.DeleteApiDestinationRequest,
        runtime: util_models.RuntimeOptions,
    ) -> sdk_client_models.DeleteApiDestinationResponse:
        """
        @summary Deletes an API destination.
        
        @description You can call this API operation to delete an API destination.
        
        @param request: DeleteApiDestinationRequest
        @param runtime: runtime options for this request RuntimeOptions
        @return: DeleteApiDestinationResponse
        """
        UtilClient.validate_model(request)
        body = {}
        if not UtilClient.is_unset(request.api_destination_name):
            body['apiDestinationName'] = request.api_destination_name
        req = open_api_models.OpenApiRequest(
            body=UtilClient.to_jsonstring(body)
        )
        params = open_api_models.Params(
            action='DeleteApiDestination',
            version='2024-07-01',
            protocol='HTTP',
            pathname='/api-destination/deleteApiDestination',
            method='POST',
            auth_type='Anonymous',
            style='RPC',
            req_body_type='json',
            body_type='json'
        )
        return TeaCore.from_map(
            sdk_client_models.DeleteApiDestinationResponse(),
            self.call_api(params, req, runtime)
        )

    async def delete_api_destination_with_options_async(
        self,
        request: sdk_client_models.DeleteApiDestinationRequest,
        runtime: util_models.RuntimeOptions,
    ) -> sdk_client_models.DeleteApiDestinationResponse:
        """
        @summary Deletes an API destination.
        
        @description You can call this API operation to delete an API destination.
        
        @param request: DeleteApiDestinationRequest
        @param runtime: runtime options for this request RuntimeOptions
        @return: DeleteApiDestinationResponse
        """
        UtilClient.validate_model(request)
        body = {}
        if not UtilClient.is_unset(request.api_destination_name):
            body['apiDestinationName'] = request.api_destination_name
        req = open_api_models.OpenApiRequest(
            body=UtilClient.to_jsonstring(body)
        )
        params = open_api_models.Params(
            action='DeleteApiDestination',
            version='2024-07-01',
            protocol='HTTP',
            pathname='/api-destination/deleteApiDestination',
            method='POST',
            auth_type='Anonymous',
            style='RPC',
            req_body_type='json',
            body_type='json'
        )
        return TeaCore.from_map(
            sdk_client_models.DeleteApiDestinationResponse(),
            await self.call_api_async(params, req, runtime)
        )

    def delete_api_destination(
        self,
        request: sdk_client_models.DeleteApiDestinationRequest,
    ) -> sdk_client_models.DeleteApiDestinationResponse:
        """
        @summary Deletes an API destination.
        
        @description You can call this API operation to delete an API destination.
        
        @param request: DeleteApiDestinationRequest
        @return: DeleteApiDestinationResponse
        """
        runtime = util_models.RuntimeOptions()
        return self.delete_api_destination_with_options(request, runtime)

    async def delete_api_destination_async(
        self,
        request: sdk_client_models.DeleteApiDestinationRequest,
    ) -> sdk_client_models.DeleteApiDestinationResponse:
        """
        @summary Deletes an API destination.
        
        @description You can call this API operation to delete an API destination.
        
        @param request: DeleteApiDestinationRequest
        @return: DeleteApiDestinationResponse
        """
        runtime = util_models.RuntimeOptions()
        return await self.delete_api_destination_with_options_async(request, runtime)

    def list_api_destinations_with_options(
        self,
        request: sdk_client_models.ListApiDestinationsRequest,
        runtime: util_models.RuntimeOptions,
    ) -> sdk_client_models.ListApiDestinationsResponse:
        """
        @summary Queries a list of API destinations.
        
        @description You can use this API operation to query a list of API destinations.
        
        @param request: ListApiDestinationsRequest
        @param runtime: runtime options for this request RuntimeOptions
        @return: ListApiDestinationsResponse
        """
        UtilClient.validate_model(request)
        body = {}
        if not UtilClient.is_unset(request.api_destination_name_prefix):
            body['apiDestinationNamePrefix'] = request.api_destination_name_prefix
        if not UtilClient.is_unset(request.connection_name):
            body['connectionName'] = request.connection_name
        if not UtilClient.is_unset(request.max_results):
            body['maxResults'] = request.max_results
        if not UtilClient.is_unset(request.next_token):
            body['nextToken'] = request.next_token
        req = open_api_models.OpenApiRequest(
            body=UtilClient.to_jsonstring(body)
        )
        params = open_api_models.Params(
            action='ListApiDestinations',
            version='2024-07-01',
            protocol='HTTP',
            pathname='/api-destination/listApiDestinations',
            method='POST',
            auth_type='Anonymous',
            style='RPC',
            req_body_type='json',
            body_type='json'
        )
        return TeaCore.from_map(
            sdk_client_models.ListApiDestinationsResponse(),
            self.call_api(params, req, runtime)
        )

    async def list_api_destinations_with_options_async(
        self,
        request: sdk_client_models.ListApiDestinationsRequest,
        runtime: util_models.RuntimeOptions,
    ) -> sdk_client_models.ListApiDestinationsResponse:
        """
        @summary Queries a list of API destinations.
        
        @description You can use this API operation to query a list of API destinations.
        
        @param request: ListApiDestinationsRequest
        @param runtime: runtime options for this request RuntimeOptions
        @return: ListApiDestinationsResponse
        """
        UtilClient.validate_model(request)
        body = {}
        if not UtilClient.is_unset(request.api_destination_name_prefix):
            body['apiDestinationNamePrefix'] = request.api_destination_name_prefix
        if not UtilClient.is_unset(request.connection_name):
            body['connectionName'] = request.connection_name
        if not UtilClient.is_unset(request.max_results):
            body['maxResults'] = request.max_results
        if not UtilClient.is_unset(request.next_token):
            body['nextToken'] = request.next_token
        req = open_api_models.OpenApiRequest(
            body=UtilClient.to_jsonstring(body)
        )
        params = open_api_models.Params(
            action='ListApiDestinations',
            version='2024-07-01',
            protocol='HTTP',
            pathname='/api-destination/listApiDestinations',
            method='POST',
            auth_type='Anonymous',
            style='RPC',
            req_body_type='json',
            body_type='json'
        )
        return TeaCore.from_map(
            sdk_client_models.ListApiDestinationsResponse(),
            await self.call_api_async(params, req, runtime)
        )

    def list_api_destinations(
        self,
        request: sdk_client_models.ListApiDestinationsRequest,
    ) -> sdk_client_models.ListApiDestinationsResponse:
        """
        @summary Queries a list of API destinations.
        
        @description You can use this API operation to query a list of API destinations.
        
        @param request: ListApiDestinationsRequest
        @return: ListApiDestinationsResponse
        """
        runtime = util_models.RuntimeOptions()
        return self.list_api_destinations_with_options(request, runtime)

    async def list_api_destinations_async(
        self,
        request: sdk_client_models.ListApiDestinationsRequest,
    ) -> sdk_client_models.ListApiDestinationsResponse:
        """
        @summary Queries a list of API destinations.
        
        @description You can use this API operation to query a list of API destinations.
        
        @param request: ListApiDestinationsRequest
        @return: ListApiDestinationsResponse
        """
        runtime = util_models.RuntimeOptions()
        return await self.list_api_destinations_with_options_async(request, runtime)

    def create_connection_with_options(
        self,
        request: sdk_client_models.CreateConnectionRequest,
        runtime: util_models.RuntimeOptions,
    ) -> sdk_client_models.CreateConnectionResponse:
        """
        @summary Creates a connection.
        
        @description You can call this API operation to create a connection.
        
        @param request: CreateConnectionRequest
        @param runtime: runtime options for this request RuntimeOptions
        @return: CreateConnectionResponse
        """
        UtilClient.validate_model(request)
        body = {}
        if not UtilClient.is_unset(request.auth_parameters):
            body['authParameters'] = request.auth_parameters
        if not UtilClient.is_unset(request.connection_name):
            body['connectionName'] = request.connection_name
        if not UtilClient.is_unset(request.description):
            body['description'] = request.description
        if not UtilClient.is_unset(request.network_parameters):
            body['networkParameters'] = request.network_parameters
        req = open_api_models.OpenApiRequest(
            body=UtilClient.to_jsonstring(body)
        )
        params = open_api_models.Params(
            action='CreateConnection',
            version='2024-07-01',
            protocol='HTTP',
            pathname='/connection/createConnection',
            method='POST',
            auth_type='Anonymous',
            style='RPC',
            req_body_type='json',
            body_type='json'
        )
        return TeaCore.from_map(
            sdk_client_models.CreateConnectionResponse(),
            self.call_api(params, req, runtime)
        )

    async def create_connection_with_options_async(
        self,
        request: sdk_client_models.CreateConnectionRequest,
        runtime: util_models.RuntimeOptions,
    ) -> sdk_client_models.CreateConnectionResponse:
        """
        @summary Creates a connection.
        
        @description You can call this API operation to create a connection.
        
        @param request: CreateConnectionRequest
        @param runtime: runtime options for this request RuntimeOptions
        @return: CreateConnectionResponse
        """
        UtilClient.validate_model(request)
        body = {}
        if not UtilClient.is_unset(request.auth_parameters):
            body['authParameters'] = request.auth_parameters
        if not UtilClient.is_unset(request.connection_name):
            body['connectionName'] = request.connection_name
        if not UtilClient.is_unset(request.description):
            body['description'] = request.description
        if not UtilClient.is_unset(request.network_parameters):
            body['networkParameters'] = request.network_parameters
        req = open_api_models.OpenApiRequest(
            body=UtilClient.to_jsonstring(body)
        )
        params = open_api_models.Params(
            action='CreateConnection',
            version='2024-07-01',
            protocol='HTTP',
            pathname='/connection/createConnection',
            method='POST',
            auth_type='Anonymous',
            style='RPC',
            req_body_type='json',
            body_type='json'
        )
        return TeaCore.from_map(
            sdk_client_models.CreateConnectionResponse(),
            await self.call_api_async(params, req, runtime)
        )

    def create_connection(
        self,
        request: sdk_client_models.CreateConnectionRequest,
    ) -> sdk_client_models.CreateConnectionResponse:
        """
        @summary Creates a connection.
        
        @description You can call this API operation to create a connection.
        
        @param request: CreateConnectionRequest
        @return: CreateConnectionResponse
        """
        runtime = util_models.RuntimeOptions()
        return self.create_connection_with_options(request, runtime)

    async def create_connection_async(
        self,
        request: sdk_client_models.CreateConnectionRequest,
    ) -> sdk_client_models.CreateConnectionResponse:
        """
        @summary Creates a connection.
        
        @description You can call this API operation to create a connection.
        
        @param request: CreateConnectionRequest
        @return: CreateConnectionResponse
        """
        runtime = util_models.RuntimeOptions()
        return await self.create_connection_with_options_async(request, runtime)

    def delete_connection_with_options(
        self,
        request: sdk_client_models.DeleteConnectionRequest,
        runtime: util_models.RuntimeOptions,
    ) -> sdk_client_models.DeleteConnectionResponse:
        """
        @summary Deletes a connection.
        
        @description You can call this API operation to delete a connection.
        
        @param request: DeleteConnectionRequest
        @param runtime: runtime options for this request RuntimeOptions
        @return: DeleteConnectionResponse
        """
        UtilClient.validate_model(request)
        body = {}
        if not UtilClient.is_unset(request.connection_name):
            body['connectionName'] = request.connection_name
        req = open_api_models.OpenApiRequest(
            body=UtilClient.to_jsonstring(body)
        )
        params = open_api_models.Params(
            action='DeleteConnection',
            version='2024-07-01',
            protocol='HTTP',
            pathname='/connection/deleteConnection',
            method='POST',
            auth_type='Anonymous',
            style='RPC',
            req_body_type='json',
            body_type='json'
        )
        return TeaCore.from_map(
            sdk_client_models.DeleteConnectionResponse(),
            self.call_api(params, req, runtime)
        )

    async def delete_connection_with_options_async(
        self,
        request: sdk_client_models.DeleteConnectionRequest,
        runtime: util_models.RuntimeOptions,
    ) -> sdk_client_models.DeleteConnectionResponse:
        """
        @summary Deletes a connection.
        
        @description You can call this API operation to delete a connection.
        
        @param request: DeleteConnectionRequest
        @param runtime: runtime options for this request RuntimeOptions
        @return: DeleteConnectionResponse
        """
        UtilClient.validate_model(request)
        body = {}
        if not UtilClient.is_unset(request.connection_name):
            body['connectionName'] = request.connection_name
        req = open_api_models.OpenApiRequest(
            body=UtilClient.to_jsonstring(body)
        )
        params = open_api_models.Params(
            action='DeleteConnection',
            version='2024-07-01',
            protocol='HTTP',
            pathname='/connection/deleteConnection',
            method='POST',
            auth_type='Anonymous',
            style='RPC',
            req_body_type='json',
            body_type='json'
        )
        return TeaCore.from_map(
            sdk_client_models.DeleteConnectionResponse(),
            await self.call_api_async(params, req, runtime)
        )

    def delete_connection(
        self,
        request: sdk_client_models.DeleteConnectionRequest,
    ) -> sdk_client_models.DeleteConnectionResponse:
        """
        @summary Deletes a connection.
        
        @description You can call this API operation to delete a connection.
        
        @param request: DeleteConnectionRequest
        @return: DeleteConnectionResponse
        """
        runtime = util_models.RuntimeOptions()
        return self.delete_connection_with_options(request, runtime)

    async def delete_connection_async(
        self,
        request: sdk_client_models.DeleteConnectionRequest,
    ) -> sdk_client_models.DeleteConnectionResponse:
        """
        @summary Deletes a connection.
        
        @description You can call this API operation to delete a connection.
        
        @param request: DeleteConnectionRequest
        @return: DeleteConnectionResponse
        """
        runtime = util_models.RuntimeOptions()
        return await self.delete_connection_with_options_async(request, runtime)

    def update_connection_with_options(
        self,
        request: sdk_client_models.UpdateConnectionRequest,
        runtime: util_models.RuntimeOptions,
    ) -> sdk_client_models.UpdateConnectionResponse:
        """
        @summary Updates a connection.
        
        @description You can call this API operation to update a connection.
        
        @param request: UpdateConnectionRequest
        @param runtime: runtime options for this request RuntimeOptions
        @return: UpdateConnectionResponse
        """
        UtilClient.validate_model(request)
        body = {}
        if not UtilClient.is_unset(request.auth_parameters):
            body['authParameters'] = request.auth_parameters
        if not UtilClient.is_unset(request.connection_name):
            body['connectionName'] = request.connection_name
        if not UtilClient.is_unset(request.description):
            body['description'] = request.description
        if not UtilClient.is_unset(request.network_parameters):
            body['networkParameters'] = request.network_parameters
        req = open_api_models.OpenApiRequest(
            body=UtilClient.to_jsonstring(body)
        )
        params = open_api_models.Params(
            action='UpdateConnection',
            version='2024-07-01',
            protocol='HTTP',
            pathname='/connection/updateConnection',
            method='POST',
            auth_type='Anonymous',
            style='RPC',
            req_body_type='json',
            body_type='json'
        )
        return TeaCore.from_map(
            sdk_client_models.UpdateConnectionResponse(),
            self.call_api(params, req, runtime)
        )

    async def update_connection_with_options_async(
        self,
        request: sdk_client_models.UpdateConnectionRequest,
        runtime: util_models.RuntimeOptions,
    ) -> sdk_client_models.UpdateConnectionResponse:
        """
        @summary Updates a connection.
        
        @description You can call this API operation to update a connection.
        
        @param request: UpdateConnectionRequest
        @param runtime: runtime options for this request RuntimeOptions
        @return: UpdateConnectionResponse
        """
        UtilClient.validate_model(request)
        body = {}
        if not UtilClient.is_unset(request.auth_parameters):
            body['authParameters'] = request.auth_parameters
        if not UtilClient.is_unset(request.connection_name):
            body['connectionName'] = request.connection_name
        if not UtilClient.is_unset(request.description):
            body['description'] = request.description
        if not UtilClient.is_unset(request.network_parameters):
            body['networkParameters'] = request.network_parameters
        req = open_api_models.OpenApiRequest(
            body=UtilClient.to_jsonstring(body)
        )
        params = open_api_models.Params(
            action='UpdateConnection',
            version='2024-07-01',
            protocol='HTTP',
            pathname='/connection/updateConnection',
            method='POST',
            auth_type='Anonymous',
            style='RPC',
            req_body_type='json',
            body_type='json'
        )
        return TeaCore.from_map(
            sdk_client_models.UpdateConnectionResponse(),
            await self.call_api_async(params, req, runtime)
        )

    def update_connection(
        self,
        request: sdk_client_models.UpdateConnectionRequest,
    ) -> sdk_client_models.UpdateConnectionResponse:
        """
        @summary Updates a connection.
        
        @description You can call this API operation to update a connection.
        
        @param request: UpdateConnectionRequest
        @return: UpdateConnectionResponse
        """
        runtime = util_models.RuntimeOptions()
        return self.update_connection_with_options(request, runtime)

    async def update_connection_async(
        self,
        request: sdk_client_models.UpdateConnectionRequest,
    ) -> sdk_client_models.UpdateConnectionResponse:
        """
        @summary Updates a connection.
        
        @description You can call this API operation to update a connection.
        
        @param request: UpdateConnectionRequest
        @return: UpdateConnectionResponse
        """
        runtime = util_models.RuntimeOptions()
        return await self.update_connection_with_options_async(request, runtime)

    def get_connection_with_options(
        self,
        request: sdk_client_models.GetConnectionRequest,
        runtime: util_models.RuntimeOptions,
    ) -> sdk_client_models.GetConnectionResponse:
        """
        @summary Queries the configurations of a connection.
        
        @description You can call this API operation to query the configurations of a connection.
        
        @param request: GetConnectionRequest
        @param runtime: runtime options for this request RuntimeOptions
        @return: GetConnectionResponse
        """
        UtilClient.validate_model(request)
        body = {}
        if not UtilClient.is_unset(request.connection_name):
            body['connectionName'] = request.connection_name
        req = open_api_models.OpenApiRequest(
            body=UtilClient.to_jsonstring(body)
        )
        params = open_api_models.Params(
            action='GetConnection',
            version='2024-07-01',
            protocol='HTTP',
            pathname='/connection/getConnection',
            method='POST',
            auth_type='Anonymous',
            style='RPC',
            req_body_type='json',
            body_type='json'
        )
        return TeaCore.from_map(
            sdk_client_models.GetConnectionResponse(),
            self.call_api(params, req, runtime)
        )

    async def get_connection_with_options_async(
        self,
        request: sdk_client_models.GetConnectionRequest,
        runtime: util_models.RuntimeOptions,
    ) -> sdk_client_models.GetConnectionResponse:
        """
        @summary Queries the configurations of a connection.
        
        @description You can call this API operation to query the configurations of a connection.
        
        @param request: GetConnectionRequest
        @param runtime: runtime options for this request RuntimeOptions
        @return: GetConnectionResponse
        """
        UtilClient.validate_model(request)
        body = {}
        if not UtilClient.is_unset(request.connection_name):
            body['connectionName'] = request.connection_name
        req = open_api_models.OpenApiRequest(
            body=UtilClient.to_jsonstring(body)
        )
        params = open_api_models.Params(
            action='GetConnection',
            version='2024-07-01',
            protocol='HTTP',
            pathname='/connection/getConnection',
            method='POST',
            auth_type='Anonymous',
            style='RPC',
            req_body_type='json',
            body_type='json'
        )
        return TeaCore.from_map(
            sdk_client_models.GetConnectionResponse(),
            await self.call_api_async(params, req, runtime)
        )

    def get_connection(
        self,
        request: sdk_client_models.GetConnectionRequest,
    ) -> sdk_client_models.GetConnectionResponse:
        """
        @summary Queries the configurations of a connection.
        
        @description You can call this API operation to query the configurations of a connection.
        
        @param request: GetConnectionRequest
        @return: GetConnectionResponse
        """
        runtime = util_models.RuntimeOptions()
        return self.get_connection_with_options(request, runtime)

    async def get_connection_async(
        self,
        request: sdk_client_models.GetConnectionRequest,
    ) -> sdk_client_models.GetConnectionResponse:
        """
        @summary Queries the configurations of a connection.
        
        @description You can call this API operation to query the configurations of a connection.
        
        @param request: GetConnectionRequest
        @return: GetConnectionResponse
        """
        runtime = util_models.RuntimeOptions()
        return await self.get_connection_with_options_async(request, runtime)

    def select_one_connection_with_options(
        self,
        request: sdk_client_models.GetConnectionRequest,
        runtime: util_models.RuntimeOptions,
    ) -> sdk_client_models.GetConnectionResponse:
        """
        @summary Queries the configurations of a connection.
        
        @description You can call this API operation to query the configurations of a connection.
        
        @param request: GetConnectionRequest
        @param runtime: runtime options for this request RuntimeOptions
        @return: GetConnectionResponse
        """
        UtilClient.validate_model(request)
        body = {}
        if not UtilClient.is_unset(request.connection_name):
            body['connectionName'] = request.connection_name
        req = open_api_models.OpenApiRequest(
            body=UtilClient.to_jsonstring(body)
        )
        params = open_api_models.Params(
            action='selectOneConnection',
            version='2024-07-01',
            protocol='HTTP',
            pathname='/connection/selectOneConnection',
            method='POST',
            auth_type='Anonymous',
            style='RPC',
            req_body_type='json',
            body_type='json'
        )
        return TeaCore.from_map(
            sdk_client_models.GetConnectionResponse(),
            self.call_api(params, req, runtime)
        )

    async def select_one_connection_with_options_async(
        self,
        request: sdk_client_models.GetConnectionRequest,
        runtime: util_models.RuntimeOptions,
    ) -> sdk_client_models.GetConnectionResponse:
        """
        @summary Queries the configurations of a connection.
        
        @description You can call this API operation to query the configurations of a connection.
        
        @param request: GetConnectionRequest
        @param runtime: runtime options for this request RuntimeOptions
        @return: GetConnectionResponse
        """
        UtilClient.validate_model(request)
        body = {}
        if not UtilClient.is_unset(request.connection_name):
            body['connectionName'] = request.connection_name
        req = open_api_models.OpenApiRequest(
            body=UtilClient.to_jsonstring(body)
        )
        params = open_api_models.Params(
            action='selectOneConnection',
            version='2024-07-01',
            protocol='HTTP',
            pathname='/connection/selectOneConnection',
            method='POST',
            auth_type='Anonymous',
            style='RPC',
            req_body_type='json',
            body_type='json'
        )
        return TeaCore.from_map(
            sdk_client_models.GetConnectionResponse(),
            await self.call_api_async(params, req, runtime)
        )

    def select_one_connection(
        self,
        request: sdk_client_models.GetConnectionRequest,
    ) -> sdk_client_models.GetConnectionResponse:
        """
        @summary Queries the configurations of a connection.
        
        @description You can call this API operation to query the configurations of a connection.
        
        @param request: GetConnectionRequest
        @return: GetConnectionResponse
        """
        runtime = util_models.RuntimeOptions()
        return self.select_one_connection_with_options(request, runtime)

    async def select_one_connection_async(
        self,
        request: sdk_client_models.GetConnectionRequest,
    ) -> sdk_client_models.GetConnectionResponse:
        """
        @summary Queries the configurations of a connection.
        
        @description You can call this API operation to query the configurations of a connection.
        
        @param request: GetConnectionRequest
        @return: GetConnectionResponse
        """
        runtime = util_models.RuntimeOptions()
        return await self.select_one_connection_with_options_async(request, runtime)

    def list_connections_with_options(
        self,
        request: sdk_client_models.ListConnectionsRequest,
        runtime: util_models.RuntimeOptions,
    ) -> sdk_client_models.ListConnectionsResponse:
        """
        @summary Queries connections.
        
        @description You can call this API operation to query connections.
        
        @param request: ListConnectionsRequest
        @param runtime: runtime options for this request RuntimeOptions
        @return: ListConnectionsResponse
        """
        UtilClient.validate_model(request)
        body = {}
        if not UtilClient.is_unset(request.connection_name_prefix):
            body['connectionNamePrefix'] = request.connection_name_prefix
        if not UtilClient.is_unset(request.max_results):
            body['maxResults'] = request.max_results
        if not UtilClient.is_unset(request.next_token):
            body['nextToken'] = request.next_token
        req = open_api_models.OpenApiRequest(
            body=UtilClient.to_jsonstring(body)
        )
        params = open_api_models.Params(
            action='ListConnections',
            version='2024-07-01',
            protocol='HTTP',
            pathname='/connection/listConnections',
            method='POST',
            auth_type='Anonymous',
            style='RPC',
            req_body_type='json',
            body_type='json'
        )
        return TeaCore.from_map(
            sdk_client_models.ListConnectionsResponse(),
            self.call_api(params, req, runtime)
        )

    async def list_connections_with_options_async(
        self,
        request: sdk_client_models.ListConnectionsRequest,
        runtime: util_models.RuntimeOptions,
    ) -> sdk_client_models.ListConnectionsResponse:
        """
        @summary Queries connections.
        
        @description You can call this API operation to query connections.
        
        @param request: ListConnectionsRequest
        @param runtime: runtime options for this request RuntimeOptions
        @return: ListConnectionsResponse
        """
        UtilClient.validate_model(request)
        body = {}
        if not UtilClient.is_unset(request.connection_name_prefix):
            body['connectionNamePrefix'] = request.connection_name_prefix
        if not UtilClient.is_unset(request.max_results):
            body['maxResults'] = request.max_results
        if not UtilClient.is_unset(request.next_token):
            body['nextToken'] = request.next_token
        req = open_api_models.OpenApiRequest(
            body=UtilClient.to_jsonstring(body)
        )
        params = open_api_models.Params(
            action='ListConnections',
            version='2024-07-01',
            protocol='HTTP',
            pathname='/connection/listConnections',
            method='POST',
            auth_type='Anonymous',
            style='RPC',
            req_body_type='json',
            body_type='json'
        )
        return TeaCore.from_map(
            sdk_client_models.ListConnectionsResponse(),
            await self.call_api_async(params, req, runtime)
        )

    def list_connections(
        self,
        request: sdk_client_models.ListConnectionsRequest,
    ) -> sdk_client_models.ListConnectionsResponse:
        """
        @summary list connections.
        
        @description You can call this API operation to list connections.
        
        @param request: ListConnectionsRequest
        @return: ListConnectionsResponse
        """
        runtime = util_models.RuntimeOptions()
        return self.list_connections_with_options(request, runtime)

    async def list_connections_async(
        self,
        request: sdk_client_models.ListConnectionsRequest,
    ) -> sdk_client_models.ListConnectionsResponse:
        """
        @summary list connections.
        
        @description You can call this API operation to list connections.
        
        @param request: ListConnectionsRequest
        @return: ListConnectionsResponse
        """
        runtime = util_models.RuntimeOptions()
        return await self.list_connections_with_options_async(request, runtime)

    def list_enums_response(self) -> sdk_client_models.ListEnumsResponseResponse:
        """
        @summary Updates a connection.
        
        @description You can call this API operation to update a connection.
        
        @return: ListEnumsResponseResponse
        """
        runtime = util_models.RuntimeOptions()
        body = {}
        req = open_api_models.OpenApiRequest(
            body=UtilClient.to_jsonstring(body)
        )
        params = open_api_models.Params(
            action='listEnumsResponse',
            version='2024-07-01',
            protocol='HTTP',
            pathname='/connection/listEnumsResponse',
            method='POST',
            auth_type='Anonymous',
            style='RPC',
            req_body_type='json',
            body_type='json'
        )
        return TeaCore.from_map(
            sdk_client_models.ListEnumsResponseResponse(),
            self.call_api(params, req, runtime)
        )

    async def list_enums_response_async(self) -> sdk_client_models.ListEnumsResponseResponse:
        """
        @summary Updates a connection.
        
        @description You can call this API operation to update a connection.
        
        @return: ListEnumsResponseResponse
        """
        runtime = util_models.RuntimeOptions()
        body = {}
        req = open_api_models.OpenApiRequest(
            body=UtilClient.to_jsonstring(body)
        )
        params = open_api_models.Params(
            action='listEnumsResponse',
            version='2024-07-01',
            protocol='HTTP',
            pathname='/connection/listEnumsResponse',
            method='POST',
            auth_type='Anonymous',
            style='RPC',
            req_body_type='json',
            body_type='json'
        )
        return TeaCore.from_map(
            sdk_client_models.ListEnumsResponseResponse(),
            await self.call_api_async(params, req, runtime)
        )

    def put_events_with_options(
        self,
        request: sdk_client_models.PutEventsRequest,
        runtime: util_models.RuntimeOptions,
    ) -> sdk_client_models.PutEventsResponse:
        """
        @summary Queries the content of an event.
        
        @description You can call this API operation to query the content of an event.
        
        @param request: PutEventsRequest
        @param runtime: runtime options for this request RuntimeOptions
        @return: PutEventsResponse
        """
        UtilClient.validate_model(request)
        headers = {
            'ce-specversion': '1.0',
            'ce-type': 'com.github.pull_request.opened',
            'ce-source': 'https://github.com/cloudevents/spec/pull',
            'ce-subject': 'demo',
            'ce-id': '1234-1234-1234',
            'ce-datacontenttype': 'application/json',
            'ce-time': '2024-07-01T17:31:00Z',
            'ce-eventbusname': 'demo-bus'
        }
        body = '{}'
        if not UtilClient.is_unset(request.event_bus_name):
            headers['ce-eventbusname'] = request.event_bus_name
        if not UtilClient.is_unset(request.event):
            body = request.event
        req = open_api_models.OpenApiRequest(
            body=body,
            headers=headers
        )
        params = open_api_models.Params(
            action='putEvents',
            version='2024-07-01',
            protocol='HTTP',
            pathname='/putEvents',
            method='POST',
            auth_type='Anonymous',
            style='RPC',
            req_body_type='json',
            body_type='json'
        )
        return TeaCore.from_map(
            sdk_client_models.PutEventsResponse(),
            self.call_api(params, req, runtime)
        )

    async def put_events_with_options_async(
        self,
        request: sdk_client_models.PutEventsRequest,
        runtime: util_models.RuntimeOptions,
    ) -> sdk_client_models.PutEventsResponse:
        """
        @summary Queries the content of an event.
        
        @description You can call this API operation to query the content of an event.
        
        @param request: PutEventsRequest
        @param runtime: runtime options for this request RuntimeOptions
        @return: PutEventsResponse
        """
        UtilClient.validate_model(request)
        headers = {
            'ce-specversion': '1.0',
            'ce-type': 'com.github.pull_request.opened',
            'ce-source': 'https://github.com/cloudevents/spec/pull',
            'ce-subject': 'demo',
            'ce-id': '1234-1234-1234',
            'ce-datacontenttype': 'application/json',
            'ce-time': '2024-07-01T17:31:00Z',
            'ce-eventbusname': 'demo-bus'
        }
        body = '{}'
        if not UtilClient.is_unset(request.event_bus_name):
            headers['ce-eventbusname'] = request.event_bus_name
        if not UtilClient.is_unset(request.event):
            body = request.event
        req = open_api_models.OpenApiRequest(
            body=body,
            headers=headers
        )
        params = open_api_models.Params(
            action='putEvents',
            version='2024-07-01',
            protocol='HTTP',
            pathname='/putEvents',
            method='POST',
            auth_type='Anonymous',
            style='RPC',
            req_body_type='json',
            body_type='json'
        )
        return TeaCore.from_map(
            sdk_client_models.PutEventsResponse(),
            await self.call_api_async(params, req, runtime)
        )

    def put_events(
        self,
        request: sdk_client_models.PutEventsRequest,
    ) -> sdk_client_models.PutEventsResponse:
        """
        @summary Queries the content of an event.
        
        @description You can call this API operation to query the content of an event.
        
        @param request: PutEventsRequest
        @return: PutEventsResponse
        """
        runtime = util_models.RuntimeOptions()
        return self.put_events_with_options(request, runtime)

    async def put_events_async(
        self,
        request: sdk_client_models.PutEventsRequest,
    ) -> sdk_client_models.PutEventsResponse:
        """
        @summary Queries the content of an event.
        
        @description You can call this API operation to query the content of an event.
        
        @param request: PutEventsRequest
        @return: PutEventsResponse
        """
        runtime = util_models.RuntimeOptions()
        return await self.put_events_with_options_async(request, runtime)

    def create_event_rule_with_options(
        self,
        request: sdk_client_models.CreateEventRuleRequest,
        runtime: util_models.RuntimeOptions,
    ) -> sdk_client_models.CreateEventRuleResponse:
        """
        @summary Creates an event rule.
        
        @description You can call this operation to create an event rule.
        
        @param request: CreateEventRuleRequest
        @param runtime: runtime options for this request RuntimeOptions
        @return: CreateEventRuleResponse
        """
        UtilClient.validate_model(request)
        body = {}
        if not UtilClient.is_unset(request.event_bus_name):
            body['eventBusName'] = request.event_bus_name
        if not UtilClient.is_unset(request.event_rule_name):
            body['eventRuleName'] = request.event_rule_name
        if not UtilClient.is_unset(request.description):
            body['description'] = request.description
        if not UtilClient.is_unset(request.filter_pattern):
            body['filterPattern'] = request.filter_pattern
        req = open_api_models.OpenApiRequest(
            body=UtilClient.to_jsonstring(body)
        )
        params = open_api_models.Params(
            action='CreateEventRule',
            version='2024-07-01',
            protocol='HTTP',
            pathname='/rule/createEventRule',
            method='POST',
            auth_type='Anonymous',
            style='RPC',
            req_body_type='json',
            body_type='json'
        )
        return TeaCore.from_map(
            sdk_client_models.CreateEventRuleResponse(),
            self.call_api(params, req, runtime)
        )

    async def create_event_rule_with_options_async(
        self,
        request: sdk_client_models.CreateEventRuleRequest,
        runtime: util_models.RuntimeOptions,
    ) -> sdk_client_models.CreateEventRuleResponse:
        """
        @summary Creates an event rule.
        
        @description You can call this operation to create an event rule.
        
        @param request: CreateEventRuleRequest
        @param runtime: runtime options for this request RuntimeOptions
        @return: CreateEventRuleResponse
        """
        UtilClient.validate_model(request)
        body = {}
        if not UtilClient.is_unset(request.event_bus_name):
            body['eventBusName'] = request.event_bus_name
        if not UtilClient.is_unset(request.event_rule_name):
            body['eventRuleName'] = request.event_rule_name
        if not UtilClient.is_unset(request.description):
            body['description'] = request.description
        if not UtilClient.is_unset(request.filter_pattern):
            body['filterPattern'] = request.filter_pattern
        req = open_api_models.OpenApiRequest(
            body=UtilClient.to_jsonstring(body)
        )
        params = open_api_models.Params(
            action='CreateEventRule',
            version='2024-07-01',
            protocol='HTTP',
            pathname='/rule/createEventRule',
            method='POST',
            auth_type='Anonymous',
            style='RPC',
            req_body_type='json',
            body_type='json'
        )
        return TeaCore.from_map(
            sdk_client_models.CreateEventRuleResponse(),
            await self.call_api_async(params, req, runtime)
        )

    def create_event_rule(
        self,
        request: sdk_client_models.CreateEventRuleRequest,
    ) -> sdk_client_models.CreateEventRuleResponse:
        """
        @summary Creates an event rule.
        
        @description You can call this operation to create an event rule.
        
        @param request: CreateEventRuleRequest
        @return: CreateEventRuleResponse
        """
        runtime = util_models.RuntimeOptions()
        return self.create_event_rule_with_options(request, runtime)

    async def create_event_rule_async(
        self,
        request: sdk_client_models.CreateEventRuleRequest,
    ) -> sdk_client_models.CreateEventRuleResponse:
        """
        @summary Creates an event rule.
        
        @description You can call this operation to create an event rule.
        
        @param request: CreateEventRuleRequest
        @return: CreateEventRuleResponse
        """
        runtime = util_models.RuntimeOptions()
        return await self.create_event_rule_with_options_async(request, runtime)

    def get_event_rule_with_options(
        self,
        request: sdk_client_models.GetEventRuleRequest,
        runtime: util_models.RuntimeOptions,
    ) -> sdk_client_models.GetEventRuleResponse:
        """
        @summary Gets an event rule.
        
        @description You can call this operation to get an event rule.
        
        @param request: GetEventRuleRequest
        @param runtime: runtime options for this request RuntimeOptions
        @return: GetEventRuleResponse
        """
        UtilClient.validate_model(request)
        body = {}
        if not UtilClient.is_unset(request.event_bus_name):
            body['eventBusName'] = request.event_bus_name
        if not UtilClient.is_unset(request.event_rule_name):
            body['eventRuleName'] = request.event_rule_name
        req = open_api_models.OpenApiRequest(
            body=UtilClient.to_jsonstring(body)
        )
        params = open_api_models.Params(
            action='GetEventRule',
            version='2024-07-01',
            protocol='HTTP',
            pathname='/rule/getEventRule',
            method='POST',
            auth_type='Anonymous',
            style='RPC',
            req_body_type='json',
            body_type='json'
        )
        return TeaCore.from_map(
            sdk_client_models.GetEventRuleResponse(),
            self.call_api(params, req, runtime)
        )

    async def get_event_rule_with_options_async(
        self,
        request: sdk_client_models.GetEventRuleRequest,
        runtime: util_models.RuntimeOptions,
    ) -> sdk_client_models.GetEventRuleResponse:
        """
        @summary Gets an event rule.
        
        @description You can call this operation to get an event rule.
        
        @param request: GetEventRuleRequest
        @param runtime: runtime options for this request RuntimeOptions
        @return: GetEventRuleResponse
        """
        UtilClient.validate_model(request)
        body = {}
        if not UtilClient.is_unset(request.event_bus_name):
            body['eventBusName'] = request.event_bus_name
        if not UtilClient.is_unset(request.event_rule_name):
            body['eventRuleName'] = request.event_rule_name
        req = open_api_models.OpenApiRequest(
            body=UtilClient.to_jsonstring(body)
        )
        params = open_api_models.Params(
            action='GetEventRule',
            version='2024-07-01',
            protocol='HTTP',
            pathname='/rule/getEventRule',
            method='POST',
            auth_type='Anonymous',
            style='RPC',
            req_body_type='json',
            body_type='json'
        )
        return TeaCore.from_map(
            sdk_client_models.GetEventRuleResponse(),
            await self.call_api_async(params, req, runtime)
        )

    def get_event_rule(
        self,
        request: sdk_client_models.GetEventRuleRequest,
    ) -> sdk_client_models.GetEventRuleResponse:
        """
        @summary Gets an event rule.
        
        @description You can call this operation to get an event rule.
        
        @param request: GetEventRuleRequest
        @return: GetEventRuleResponse
        """
        runtime = util_models.RuntimeOptions()
        return self.get_event_rule_with_options(request, runtime)

    async def get_event_rule_async(
        self,
        request: sdk_client_models.GetEventRuleRequest,
    ) -> sdk_client_models.GetEventRuleResponse:
        """
        @summary Gets an event rule.
        
        @description You can call this operation to get an event rule.
        
        @param request: GetEventRuleRequest
        @return: GetEventRuleResponse
        """
        runtime = util_models.RuntimeOptions()
        return await self.get_event_rule_with_options_async(request, runtime)

    def delete_event_rule_with_options(
        self,
        request: sdk_client_models.DeleteEventRuleRequest,
        runtime: util_models.RuntimeOptions,
    ) -> sdk_client_models.DeleteEventRuleResponse:
        """
        @summary Deletes an event rule.
        
        @description You can call this operation to delete an event rule.
        
        @param request: DeleteEventRuleRequest
        @param runtime: runtime options for this request RuntimeOptions
        @return: DeleteEventRuleResponse
        """
        UtilClient.validate_model(request)
        body = {}
        if not UtilClient.is_unset(request.event_bus_name):
            body['eventBusName'] = request.event_bus_name
        if not UtilClient.is_unset(request.event_rule_name):
            body['eventRuleName'] = request.event_rule_name
        req = open_api_models.OpenApiRequest(
            body=UtilClient.to_jsonstring(body)
        )
        params = open_api_models.Params(
            action='DeleteEventRule',
            version='2024-07-01',
            protocol='HTTP',
            pathname='/rule/deleteEventRule',
            method='POST',
            auth_type='Anonymous',
            style='RPC',
            req_body_type='json',
            body_type='json'
        )
        return TeaCore.from_map(
            sdk_client_models.DeleteEventRuleResponse(),
            self.call_api(params, req, runtime)
        )

    async def delete_event_rule_with_options_async(
        self,
        request: sdk_client_models.DeleteEventRuleRequest,
        runtime: util_models.RuntimeOptions,
    ) -> sdk_client_models.DeleteEventRuleResponse:
        """
        @summary Deletes an event rule.
        
        @description You can call this operation to delete an event rule.
        
        @param request: DeleteEventRuleRequest
        @param runtime: runtime options for this request RuntimeOptions
        @return: DeleteEventRuleResponse
        """
        UtilClient.validate_model(request)
        body = {}
        if not UtilClient.is_unset(request.event_bus_name):
            body['eventBusName'] = request.event_bus_name
        if not UtilClient.is_unset(request.event_rule_name):
            body['eventRuleName'] = request.event_rule_name
        req = open_api_models.OpenApiRequest(
            body=UtilClient.to_jsonstring(body)
        )
        params = open_api_models.Params(
            action='DeleteEventRule',
            version='2024-07-01',
            protocol='HTTP',
            pathname='/rule/deleteEventRule',
            method='POST',
            auth_type='Anonymous',
            style='RPC',
            req_body_type='json',
            body_type='json'
        )
        return TeaCore.from_map(
            sdk_client_models.DeleteEventRuleResponse(),
            await self.call_api_async(params, req, runtime)
        )

    def delete_event_rule(
        self,
        request: sdk_client_models.DeleteEventRuleRequest,
    ) -> sdk_client_models.DeleteEventRuleResponse:
        """
        @summary Deletes an event rule.
        
        @description You can call this operation to delete an event rule.
        
        @param request: DeleteEventRuleRequest
        @return: DeleteEventRuleResponse
        """
        runtime = util_models.RuntimeOptions()
        return self.delete_event_rule_with_options(request, runtime)

    async def delete_event_rule_async(
        self,
        request: sdk_client_models.DeleteEventRuleRequest,
    ) -> sdk_client_models.DeleteEventRuleResponse:
        """
        @summary Deletes an event rule.
        
        @description You can call this operation to delete an event rule.
        
        @param request: DeleteEventRuleRequest
        @return: DeleteEventRuleResponse
        """
        runtime = util_models.RuntimeOptions()
        return await self.delete_event_rule_with_options_async(request, runtime)

    def update_event_rule_with_options(
        self,
        request: sdk_client_models.UpdateEventRuleRequest,
        runtime: util_models.RuntimeOptions,
    ) -> sdk_client_models.UpdateEventRuleResponse:
        """
        @summary Updates an event rule.
        
        @description You can call this operation to update an event rule.
        
        @param request: UpdateEventRuleRequest
        @param runtime: runtime options for this request RuntimeOptions
        @return: UpdateEventRuleResponse
        """
        UtilClient.validate_model(request)
        body = {}
        if not UtilClient.is_unset(request.event_bus_name):
            body['eventBusName'] = request.event_bus_name
        if not UtilClient.is_unset(request.event_rule_name):
            body['eventRuleName'] = request.event_rule_name
        if not UtilClient.is_unset(request.description):
            body['description'] = request.description
        if not UtilClient.is_unset(request.filter_pattern):
            body['filterPattern'] = request.filter_pattern
        req = open_api_models.OpenApiRequest(
            body=UtilClient.to_jsonstring(body)
        )
        params = open_api_models.Params(
            action='UpdateEventRule',
            version='2024-07-01',
            protocol='HTTP',
            pathname='/rule/updateEventRule',
            method='POST',
            auth_type='Anonymous',
            style='RPC',
            req_body_type='json',
            body_type='json'
        )
        return TeaCore.from_map(
            sdk_client_models.UpdateEventRuleResponse(),
            self.call_api(params, req, runtime)
        )

    async def update_event_rule_with_options_async(
        self,
        request: sdk_client_models.UpdateEventRuleRequest,
        runtime: util_models.RuntimeOptions,
    ) -> sdk_client_models.UpdateEventRuleResponse:
        """
        @summary Updates an event rule.
        
        @description You can call this operation to update an event rule.
        
        @param request: UpdateEventRuleRequest
        @param runtime: runtime options for this request RuntimeOptions
        @return: UpdateEventRuleResponse
        """
        UtilClient.validate_model(request)
        body = {}
        if not UtilClient.is_unset(request.event_bus_name):
            body['eventBusName'] = request.event_bus_name
        if not UtilClient.is_unset(request.event_rule_name):
            body['eventRuleName'] = request.event_rule_name
        if not UtilClient.is_unset(request.description):
            body['description'] = request.description
        if not UtilClient.is_unset(request.filter_pattern):
            body['filterPattern'] = request.filter_pattern
        req = open_api_models.OpenApiRequest(
            body=UtilClient.to_jsonstring(body)
        )
        params = open_api_models.Params(
            action='UpdateEventRule',
            version='2024-07-01',
            protocol='HTTP',
            pathname='/rule/updateEventRule',
            method='POST',
            auth_type='Anonymous',
            style='RPC',
            req_body_type='json',
            body_type='json'
        )
        return TeaCore.from_map(
            sdk_client_models.UpdateEventRuleResponse(),
            await self.call_api_async(params, req, runtime)
        )

    def update_event_rule(
        self,
        request: sdk_client_models.UpdateEventRuleRequest,
    ) -> sdk_client_models.UpdateEventRuleResponse:
        """
        @summary Updates an event rule.
        
        @description You can call this operation to update an event rule.
        
        @param request: UpdateEventRuleRequest
        @return: UpdateEventRuleResponse
        """
        runtime = util_models.RuntimeOptions()
        return self.update_event_rule_with_options(request, runtime)

    async def update_event_rule_async(
        self,
        request: sdk_client_models.UpdateEventRuleRequest,
    ) -> sdk_client_models.UpdateEventRuleResponse:
        """
        @summary Updates an event rule.
        
        @description You can call this operation to update an event rule.
        
        @param request: UpdateEventRuleRequest
        @return: UpdateEventRuleResponse
        """
        runtime = util_models.RuntimeOptions()
        return await self.update_event_rule_with_options_async(request, runtime)

    def list_event_rules_with_options(
        self,
        request: sdk_client_models.ListEventRulesRequest,
        runtime: util_models.RuntimeOptions,
    ) -> sdk_client_models.ListEventRulesResponse:
        """
        @summary Lists event rules.
        
        @description You can call this operation to list event rules.
        
        @param request: ListEventRulesRequest
        @param runtime: runtime options for this request RuntimeOptions
        @return: ListEventRulesResponse
        """
        UtilClient.validate_model(request)
        body = {}
        if not UtilClient.is_unset(request.event_bus_name):
            body['eventBusName'] = request.event_bus_name
        if not UtilClient.is_unset(request.max_results):
            body['maxResults'] = request.max_results
        if not UtilClient.is_unset(request.next_token):
            body['nextToken'] = request.next_token
        req = open_api_models.OpenApiRequest(
            body=UtilClient.to_jsonstring(body)
        )
        params = open_api_models.Params(
            action='ListEventRules',
            version='2024-07-01',
            protocol='HTTP',
            pathname='/rule/listEventRules',
            method='POST',
            auth_type='Anonymous',
            style='RPC',
            req_body_type='json',
            body_type='json'
        )
        return TeaCore.from_map(
            sdk_client_models.ListEventRulesResponse(),
            self.call_api(params, req, runtime)
        )

    async def list_event_rules_with_options_async(
        self,
        request: sdk_client_models.ListEventRulesRequest,
        runtime: util_models.RuntimeOptions,
    ) -> sdk_client_models.ListEventRulesResponse:
        """
        @summary Lists event rules.
        
        @description You can call this operation to list event rules.
        
        @param request: ListEventRulesRequest
        @param runtime: runtime options for this request RuntimeOptions
        @return: ListEventRulesResponse
        """
        UtilClient.validate_model(request)
        body = {}
        if not UtilClient.is_unset(request.event_bus_name):
            body['eventBusName'] = request.event_bus_name
        if not UtilClient.is_unset(request.max_results):
            body['maxResults'] = request.max_results
        if not UtilClient.is_unset(request.next_token):
            body['nextToken'] = request.next_token
        req = open_api_models.OpenApiRequest(
            body=UtilClient.to_jsonstring(body)
        )
        params = open_api_models.Params(
            action='ListEventRules',
            version='2024-07-01',
            protocol='HTTP',
            pathname='/rule/listEventRules',
            method='POST',
            auth_type='Anonymous',
            style='RPC',
            req_body_type='json',
            body_type='json'
        )
        return TeaCore.from_map(
            sdk_client_models.ListEventRulesResponse(),
            await self.call_api_async(params, req, runtime)
        )

    def list_event_rules(
        self,
        request: sdk_client_models.ListEventRulesRequest,
    ) -> sdk_client_models.ListEventRulesResponse:
        """
        @summary Lists event rules.
        
        @description You can call this operation to list event rules.
        
        @param request: ListEventRulesRequest
        @return: ListEventRulesResponse
        """
        runtime = util_models.RuntimeOptions()
        return self.list_event_rules_with_options(request, runtime)

    async def list_event_rules_async(
        self,
        request: sdk_client_models.ListEventRulesRequest,
    ) -> sdk_client_models.ListEventRulesResponse:
        """
        @summary Lists event rules.
        
        @description You can call this operation to list event rules.
        
        @param request: ListEventRulesRequest
        @return: ListEventRulesResponse
        """
        runtime = util_models.RuntimeOptions()
        return await self.list_event_rules_with_options_async(request, runtime)

    def enable_event_rule_with_options(
        self,
        request: sdk_client_models.EnableEventRuleRequest,
        runtime: util_models.RuntimeOptions,
    ) -> sdk_client_models.EnableEventRuleResponse:
        """
        @summary Enables an event rule.
        
        @description You can call this operation to enable an event rule.
        
        @param request: EnableEventRuleRequest
        @param runtime: runtime options for this request RuntimeOptions
        @return: EnableEventRuleResponse
        """
        UtilClient.validate_model(request)
        body = {}
        if not UtilClient.is_unset(request.event_bus_name):
            body['eventBusName'] = request.event_bus_name
        if not UtilClient.is_unset(request.event_rule_name):
            body['eventRuleName'] = request.event_rule_name
        req = open_api_models.OpenApiRequest(
            body=UtilClient.to_jsonstring(body)
        )
        params = open_api_models.Params(
            action='EnableEventRule',
            version='2024-07-01',
            protocol='HTTP',
            pathname='/rule/enableEventRule',
            method='POST',
            auth_type='Anonymous',
            style='RPC',
            req_body_type='json',
            body_type='json'
        )
        return TeaCore.from_map(
            sdk_client_models.EnableEventRuleResponse(),
            self.call_api(params, req, runtime)
        )

    async def enable_event_rule_with_options_async(
        self,
        request: sdk_client_models.EnableEventRuleRequest,
        runtime: util_models.RuntimeOptions,
    ) -> sdk_client_models.EnableEventRuleResponse:
        """
        @summary Enables an event rule.
        
        @description You can call this operation to enable an event rule.
        
        @param request: EnableEventRuleRequest
        @param runtime: runtime options for this request RuntimeOptions
        @return: EnableEventRuleResponse
        """
        UtilClient.validate_model(request)
        body = {}
        if not UtilClient.is_unset(request.event_bus_name):
            body['eventBusName'] = request.event_bus_name
        if not UtilClient.is_unset(request.event_rule_name):
            body['eventRuleName'] = request.event_rule_name
        req = open_api_models.OpenApiRequest(
            body=UtilClient.to_jsonstring(body)
        )
        params = open_api_models.Params(
            action='EnableEventRule',
            version='2024-07-01',
            protocol='HTTP',
            pathname='/rule/enableEventRule',
            method='POST',
            auth_type='Anonymous',
            style='RPC',
            req_body_type='json',
            body_type='json'
        )
        return TeaCore.from_map(
            sdk_client_models.EnableEventRuleResponse(),
            await self.call_api_async(params, req, runtime)
        )

    def enable_event_rule(
        self,
        request: sdk_client_models.EnableEventRuleRequest,
    ) -> sdk_client_models.EnableEventRuleResponse:
        """
        @summary Enables an event rule.
        
        @description You can call this operation to enable an event rule.
        
        @param request: EnableEventRuleRequest
        @return: EnableEventRuleResponse
        """
        runtime = util_models.RuntimeOptions()
        return self.enable_event_rule_with_options(request, runtime)

    async def enable_event_rule_async(
        self,
        request: sdk_client_models.EnableEventRuleRequest,
    ) -> sdk_client_models.EnableEventRuleResponse:
        """
        @summary Enables an event rule.
        
        @description You can call this operation to enable an event rule.
        
        @param request: EnableEventRuleRequest
        @return: EnableEventRuleResponse
        """
        runtime = util_models.RuntimeOptions()
        return await self.enable_event_rule_with_options_async(request, runtime)

    def disable_event_rule_with_options(
        self,
        request: sdk_client_models.DisableEventRuleRequest,
        runtime: util_models.RuntimeOptions,
    ) -> sdk_client_models.DisableEventRuleResponse:
        """
        @summary Disables an event rule.
        
        @description You can call this operation to disable an event rule.
        
        @param request: DisableEventRuleRequest
        @param runtime: runtime options for this request RuntimeOptions
        @return: DisableEventRuleResponse
        """
        UtilClient.validate_model(request)
        body = {}
        if not UtilClient.is_unset(request.event_bus_name):
            body['eventBusName'] = request.event_bus_name
        if not UtilClient.is_unset(request.event_rule_name):
            body['eventRuleName'] = request.event_rule_name
        req = open_api_models.OpenApiRequest(
            body=UtilClient.to_jsonstring(body)
        )
        params = open_api_models.Params(
            action='DisableEventRule',
            version='2024-07-01',
            protocol='HTTP',
            pathname='/rule/disableEventRule',
            method='POST',
            auth_type='Anonymous',
            style='RPC',
            req_body_type='json',
            body_type='json'
        )
        return TeaCore.from_map(
            sdk_client_models.DisableEventRuleResponse(),
            self.call_api(params, req, runtime)
        )

    async def disable_event_rule_with_options_async(
        self,
        request: sdk_client_models.DisableEventRuleRequest,
        runtime: util_models.RuntimeOptions,
    ) -> sdk_client_models.DisableEventRuleResponse:
        """
        @summary Disables an event rule.
        
        @description You can call this operation to disable an event rule.
        
        @param request: DisableEventRuleRequest
        @param runtime: runtime options for this request RuntimeOptions
        @return: DisableEventRuleResponse
        """
        UtilClient.validate_model(request)
        body = {}
        if not UtilClient.is_unset(request.event_bus_name):
            body['eventBusName'] = request.event_bus_name
        if not UtilClient.is_unset(request.event_rule_name):
            body['eventRuleName'] = request.event_rule_name
        req = open_api_models.OpenApiRequest(
            body=UtilClient.to_jsonstring(body)
        )
        params = open_api_models.Params(
            action='DisableEventRule',
            version='2024-07-01',
            protocol='HTTP',
            pathname='/rule/disableEventRule',
            method='POST',
            auth_type='Anonymous',
            style='RPC',
            req_body_type='json',
            body_type='json'
        )
        return TeaCore.from_map(
            sdk_client_models.DisableEventRuleResponse(),
            await self.call_api_async(params, req, runtime)
        )

    def disable_event_rule(
        self,
        request: sdk_client_models.DisableEventRuleRequest,
    ) -> sdk_client_models.DisableEventRuleResponse:
        """
        @summary Disables an event rule.
        
        @description You can call this operation to disable an event rule.
        
        @param request: DisableEventRuleRequest
        @return: DisableEventRuleResponse
        """
        runtime = util_models.RuntimeOptions()
        return self.disable_event_rule_with_options(request, runtime)

    async def disable_event_rule_async(
        self,
        request: sdk_client_models.DisableEventRuleRequest,
    ) -> sdk_client_models.DisableEventRuleResponse:
        """
        @summary Disables an event rule.
        
        @description You can call this operation to disable an event rule.
        
        @param request: DisableEventRuleRequest
        @return: DisableEventRuleResponse
        """
        runtime = util_models.RuntimeOptions()
        return await self.disable_event_rule_with_options_async(request, runtime)

    def create_event_source_with_options(
        self,
        request: sdk_client_models.CreateEventSourceRequest,
        runtime: util_models.RuntimeOptions,
    ) -> sdk_client_models.CreateEventSourceResponse:
        """
        @summary Creates an event source.
        
        @description You can call this operation to create an event source.
        
        @param request: CreateEventSourceRequest
        @param runtime: runtime options for this request RuntimeOptions
        @return: CreateEventSourceResponse
        """
        UtilClient.validate_model(request)
        body = {}
        if not UtilClient.is_unset(request.description):
            body['description'] = request.description
        if not UtilClient.is_unset(request.event_bus_name):
            body['eventBusName'] = request.event_bus_name
        if not UtilClient.is_unset(request.event_source_name):
            body['eventSourceName'] = request.event_source_name
        if not UtilClient.is_unset(request.class_name):
            body['className'] = request.class_name
        if not UtilClient.is_unset(request.config):
            body['config'] = request.config
        req = open_api_models.OpenApiRequest(
            body=UtilClient.to_jsonstring(body)
        )
        params = open_api_models.Params(
            action='CreateEventSource',
            version='2024-07-01',
            protocol='HTTP',
            pathname='/source/createEventSource',
            method='POST',
            auth_type='Anonymous',
            style='RPC',
            req_body_type='json',
            body_type='json'
        )
        return TeaCore.from_map(
            sdk_client_models.CreateEventSourceResponse(),
            self.call_api(params, req, runtime)
        )

    async def create_event_source_with_options_async(
        self,
        request: sdk_client_models.CreateEventSourceRequest,
        runtime: util_models.RuntimeOptions,
    ) -> sdk_client_models.CreateEventSourceResponse:
        """
        @summary Creates an event source.
        
        @description You can call this operation to create an event source.
        
        @param request: CreateEventSourceRequest
        @param runtime: runtime options for this request RuntimeOptions
        @return: CreateEventSourceResponse
        """
        UtilClient.validate_model(request)
        body = {}
        if not UtilClient.is_unset(request.description):
            body['description'] = request.description
        if not UtilClient.is_unset(request.event_bus_name):
            body['eventBusName'] = request.event_bus_name
        if not UtilClient.is_unset(request.event_source_name):
            body['eventSourceName'] = request.event_source_name
        if not UtilClient.is_unset(request.class_name):
            body['className'] = request.class_name
        if not UtilClient.is_unset(request.config):
            body['config'] = request.config
        req = open_api_models.OpenApiRequest(
            body=UtilClient.to_jsonstring(body)
        )
        params = open_api_models.Params(
            action='CreateEventSource',
            version='2024-07-01',
            protocol='HTTP',
            pathname='/source/createEventSource',
            method='POST',
            auth_type='Anonymous',
            style='RPC',
            req_body_type='json',
            body_type='json'
        )
        return TeaCore.from_map(
            sdk_client_models.CreateEventSourceResponse(),
            await self.call_api_async(params, req, runtime)
        )

    def create_event_source(
        self,
        request: sdk_client_models.CreateEventSourceRequest,
    ) -> sdk_client_models.CreateEventSourceResponse:
        """
        @summary Creates an event source.
        
        @description You can call this operation to create an event source.
        
        @param request: CreateEventSourceRequest
        @return: CreateEventSourceResponse
        """
        runtime = util_models.RuntimeOptions()
        return self.create_event_source_with_options(request, runtime)

    async def create_event_source_async(
        self,
        request: sdk_client_models.CreateEventSourceRequest,
    ) -> sdk_client_models.CreateEventSourceResponse:
        """
        @summary Creates an event source.
        
        @description You can call this operation to create an event source.
        
        @param request: CreateEventSourceRequest
        @return: CreateEventSourceResponse
        """
        runtime = util_models.RuntimeOptions()
        return await self.create_event_source_with_options_async(request, runtime)

    def update_event_source_with_options(
        self,
        request: sdk_client_models.UpdateEventSourceRequest,
        runtime: util_models.RuntimeOptions,
    ) -> sdk_client_models.UpdateEventSourceResponse:
        """
        @summary Updates an event source.
        
        @description You can call this operation to update an event source.
        
        @param request: UpdateEventSourceRequest
        @param runtime: runtime options for this request RuntimeOptions
        @return: UpdateEventSourceResponse
        """
        UtilClient.validate_model(request)
        body = {}
        if not UtilClient.is_unset(request.event_bus_name):
            body['eventBusName'] = request.event_bus_name
        if not UtilClient.is_unset(request.event_source_name):
            body['eventSourceName'] = request.event_source_name
        if not UtilClient.is_unset(request.description):
            body['description'] = request.description
        if not UtilClient.is_unset(request.class_name):
            body['className'] = request.class_name
        if not UtilClient.is_unset(request.status):
            body['status'] = request.status
        if not UtilClient.is_unset(request.config):
            body['config'] = request.config
        req = open_api_models.OpenApiRequest(
            body=UtilClient.to_jsonstring(body)
        )
        params = open_api_models.Params(
            action='UpdateEventSource',
            version='2024-07-01',
            protocol='HTTP',
            pathname='/source/updateEventSource',
            method='POST',
            auth_type='Anonymous',
            style='RPC',
            req_body_type='json',
            body_type='json'
        )
        return TeaCore.from_map(
            sdk_client_models.UpdateEventSourceResponse(),
            self.call_api(params, req, runtime)
        )

    async def update_event_source_with_options_async(
        self,
        request: sdk_client_models.UpdateEventSourceRequest,
        runtime: util_models.RuntimeOptions,
    ) -> sdk_client_models.UpdateEventSourceResponse:
        """
        @summary Updates an event source.
        
        @description You can call this operation to update an event source.
        
        @param request: UpdateEventSourceRequest
        @param runtime: runtime options for this request RuntimeOptions
        @return: UpdateEventSourceResponse
        """
        UtilClient.validate_model(request)
        body = {}
        if not UtilClient.is_unset(request.event_bus_name):
            body['eventBusName'] = request.event_bus_name
        if not UtilClient.is_unset(request.event_source_name):
            body['eventSourceName'] = request.event_source_name
        if not UtilClient.is_unset(request.description):
            body['description'] = request.description
        if not UtilClient.is_unset(request.class_name):
            body['className'] = request.class_name
        if not UtilClient.is_unset(request.status):
            body['status'] = request.status
        if not UtilClient.is_unset(request.config):
            body['config'] = request.config
        req = open_api_models.OpenApiRequest(
            body=UtilClient.to_jsonstring(body)
        )
        params = open_api_models.Params(
            action='UpdateEventSource',
            version='2024-07-01',
            protocol='HTTP',
            pathname='/source/updateEventSource',
            method='POST',
            auth_type='Anonymous',
            style='RPC',
            req_body_type='json',
            body_type='json'
        )
        return TeaCore.from_map(
            sdk_client_models.UpdateEventSourceResponse(),
            await self.call_api_async(params, req, runtime)
        )

    def update_event_source(
        self,
        request: sdk_client_models.UpdateEventSourceRequest,
    ) -> sdk_client_models.UpdateEventSourceResponse:
        """
        @summary Updates an event source.
        
        @description You can call this operation to update an event source.
        
        @param request: UpdateEventSourceRequest
        @return: UpdateEventSourceResponse
        """
        runtime = util_models.RuntimeOptions()
        return self.update_event_source_with_options(request, runtime)

    async def update_event_source_async(
        self,
        request: sdk_client_models.UpdateEventSourceRequest,
    ) -> sdk_client_models.UpdateEventSourceResponse:
        """
        @summary Updates an event source.
        
        @description You can call this operation to update an event source.
        
        @param request: UpdateEventSourceRequest
        @return: UpdateEventSourceResponse
        """
        runtime = util_models.RuntimeOptions()
        return await self.update_event_source_with_options_async(request, runtime)

    def delete_event_source_with_options(
        self,
        request: sdk_client_models.DeleteEventSourceRequest,
        runtime: util_models.RuntimeOptions,
    ) -> sdk_client_models.DeleteEventSourceResponse:
        """
        @summary Deletes an event source.
        
        @description You can call this API operation to delete an event source.
        
        @param request: DeleteEventSourceRequest
        @param runtime: runtime options for this request RuntimeOptions
        @return: DeleteEventSourceResponse
        """
        UtilClient.validate_model(request)
        body = {}
        if not UtilClient.is_unset(request.event_bus_name):
            body['eventBusName'] = request.event_bus_name
        if not UtilClient.is_unset(request.event_source_name):
            body['eventSourceName'] = request.event_source_name
        req = open_api_models.OpenApiRequest(
            body=UtilClient.to_jsonstring(body)
        )
        params = open_api_models.Params(
            action='DeleteEventSource',
            version='2024-07-01',
            protocol='HTTP',
            pathname='/source/deleteEventSource',
            method='POST',
            auth_type='Anonymous',
            style='RPC',
            req_body_type='json',
            body_type='json'
        )
        return TeaCore.from_map(
            sdk_client_models.DeleteEventSourceResponse(),
            self.call_api(params, req, runtime)
        )

    async def delete_event_source_with_options_async(
        self,
        request: sdk_client_models.DeleteEventSourceRequest,
        runtime: util_models.RuntimeOptions,
    ) -> sdk_client_models.DeleteEventSourceResponse:
        """
        @summary Deletes an event source.
        
        @description You can call this API operation to delete an event source.
        
        @param request: DeleteEventSourceRequest
        @param runtime: runtime options for this request RuntimeOptions
        @return: DeleteEventSourceResponse
        """
        UtilClient.validate_model(request)
        body = {}
        if not UtilClient.is_unset(request.event_bus_name):
            body['eventBusName'] = request.event_bus_name
        if not UtilClient.is_unset(request.event_source_name):
            body['eventSourceName'] = request.event_source_name
        req = open_api_models.OpenApiRequest(
            body=UtilClient.to_jsonstring(body)
        )
        params = open_api_models.Params(
            action='DeleteEventSource',
            version='2024-07-01',
            protocol='HTTP',
            pathname='/source/deleteEventSource',
            method='POST',
            auth_type='Anonymous',
            style='RPC',
            req_body_type='json',
            body_type='json'
        )
        return TeaCore.from_map(
            sdk_client_models.DeleteEventSourceResponse(),
            await self.call_api_async(params, req, runtime)
        )

    def delete_event_source(
        self,
        request: sdk_client_models.DeleteEventSourceRequest,
    ) -> sdk_client_models.DeleteEventSourceResponse:
        """
        @summary Deletes an event source.
        
        @description You can call this API operation to delete an event source.
        
        @param request: DeleteEventSourceRequest
        @return: DeleteEventSourceResponse
        """
        runtime = util_models.RuntimeOptions()
        return self.delete_event_source_with_options(request, runtime)

    async def delete_event_source_async(
        self,
        request: sdk_client_models.DeleteEventSourceRequest,
    ) -> sdk_client_models.DeleteEventSourceResponse:
        """
        @summary Deletes an event source.
        
        @description You can call this API operation to delete an event source.
        
        @param request: DeleteEventSourceRequest
        @return: DeleteEventSourceResponse
        """
        runtime = util_models.RuntimeOptions()
        return await self.delete_event_source_with_options_async(request, runtime)

    def get_event_source_with_options(
        self,
        request: sdk_client_models.GetEventSourceRequest,
        runtime: util_models.RuntimeOptions,
    ) -> sdk_client_models.GetEventSourceResponse:
        """
        @summary Gets an event source.
        
        @description You can call this API operation to get an event source.
        
        @param request: GetEventSourceRequest
        @param runtime: runtime options for this request RuntimeOptions
        @return: GetEventSourceResponse
        """
        UtilClient.validate_model(request)
        body = {}
        if not UtilClient.is_unset(request.event_bus_name):
            body['eventBusName'] = request.event_bus_name
        if not UtilClient.is_unset(request.event_source_name):
            body['eventSourceName'] = request.event_source_name
        req = open_api_models.OpenApiRequest(
            body=UtilClient.to_jsonstring(body)
        )
        params = open_api_models.Params(
            action='GetEventSource',
            version='2024-07-01',
            protocol='HTTP',
            pathname='/source/getEventSource',
            method='POST',
            auth_type='Anonymous',
            style='RPC',
            req_body_type='json',
            body_type='json'
        )
        return TeaCore.from_map(
            sdk_client_models.GetEventSourceResponse(),
            self.call_api(params, req, runtime)
        )

    async def get_event_source_with_options_async(
        self,
        request: sdk_client_models.GetEventSourceRequest,
        runtime: util_models.RuntimeOptions,
    ) -> sdk_client_models.GetEventSourceResponse:
        """
        @summary Gets an event source.
        
        @description You can call this API operation to get an event source.
        
        @param request: GetEventSourceRequest
        @param runtime: runtime options for this request RuntimeOptions
        @return: GetEventSourceResponse
        """
        UtilClient.validate_model(request)
        body = {}
        if not UtilClient.is_unset(request.event_bus_name):
            body['eventBusName'] = request.event_bus_name
        if not UtilClient.is_unset(request.event_source_name):
            body['eventSourceName'] = request.event_source_name
        req = open_api_models.OpenApiRequest(
            body=UtilClient.to_jsonstring(body)
        )
        params = open_api_models.Params(
            action='GetEventSource',
            version='2024-07-01',
            protocol='HTTP',
            pathname='/source/getEventSource',
            method='POST',
            auth_type='Anonymous',
            style='RPC',
            req_body_type='json',
            body_type='json'
        )
        return TeaCore.from_map(
            sdk_client_models.GetEventSourceResponse(),
            await self.call_api_async(params, req, runtime)
        )

    def get_event_source(
        self,
        request: sdk_client_models.GetEventSourceRequest,
    ) -> sdk_client_models.GetEventSourceResponse:
        """
        @summary Gets an event source.
        
        @description You can call this API operation to get an event source.
        
        @param request: GetEventSourceRequest
        @return: GetEventSourceResponse
        """
        runtime = util_models.RuntimeOptions()
        return self.get_event_source_with_options(request, runtime)

    async def get_event_source_async(
        self,
        request: sdk_client_models.GetEventSourceRequest,
    ) -> sdk_client_models.GetEventSourceResponse:
        """
        @summary Gets an event source.
        
        @description You can call this API operation to get an event source.
        
        @param request: GetEventSourceRequest
        @return: GetEventSourceResponse
        """
        runtime = util_models.RuntimeOptions()
        return await self.get_event_source_with_options_async(request, runtime)

    def list_event_sources_with_options(
        self,
        request: sdk_client_models.ListEventSourcesRequest,
        runtime: util_models.RuntimeOptions,
    ) -> sdk_client_models.ListEventSourcesResponse:
        """
        @summary Lists event sources.
        
        @description You can call this API operation to list event sources.
        
        @param request: ListEventSourcesRequest
        @param runtime: runtime options for this request RuntimeOptions
        @return: ListEventSourcesResponse
        """
        UtilClient.validate_model(request)
        body = {}
        if not UtilClient.is_unset(request.event_bus_name):
            body['eventBusName'] = request.event_bus_name
        if not UtilClient.is_unset(request.event_source_type):
            body['eventSourceType'] = request.event_source_type
        if not UtilClient.is_unset(request.max_results):
            body['maxResults'] = request.max_results
        if not UtilClient.is_unset(request.next_token):
            body['nextToken'] = request.next_token
        req = open_api_models.OpenApiRequest(
            body=UtilClient.to_jsonstring(body)
        )
        params = open_api_models.Params(
            action='ListEventSources',
            version='2024-07-01',
            protocol='HTTP',
            pathname='/source/listEventSources',
            method='POST',
            auth_type='Anonymous',
            style='RPC',
            req_body_type='json',
            body_type='json'
        )
        return TeaCore.from_map(
            sdk_client_models.ListEventSourcesResponse(),
            self.call_api(params, req, runtime)
        )

    async def list_event_sources_with_options_async(
        self,
        request: sdk_client_models.ListEventSourcesRequest,
        runtime: util_models.RuntimeOptions,
    ) -> sdk_client_models.ListEventSourcesResponse:
        """
        @summary Lists event sources.
        
        @description You can call this API operation to list event sources.
        
        @param request: ListEventSourcesRequest
        @param runtime: runtime options for this request RuntimeOptions
        @return: ListEventSourcesResponse
        """
        UtilClient.validate_model(request)
        body = {}
        if not UtilClient.is_unset(request.event_bus_name):
            body['eventBusName'] = request.event_bus_name
        if not UtilClient.is_unset(request.event_source_type):
            body['eventSourceType'] = request.event_source_type
        if not UtilClient.is_unset(request.max_results):
            body['maxResults'] = request.max_results
        if not UtilClient.is_unset(request.next_token):
            body['nextToken'] = request.next_token
        req = open_api_models.OpenApiRequest(
            body=UtilClient.to_jsonstring(body)
        )
        params = open_api_models.Params(
            action='ListEventSources',
            version='2024-07-01',
            protocol='HTTP',
            pathname='/source/listEventSources',
            method='POST',
            auth_type='Anonymous',
            style='RPC',
            req_body_type='json',
            body_type='json'
        )
        return TeaCore.from_map(
            sdk_client_models.ListEventSourcesResponse(),
            await self.call_api_async(params, req, runtime)
        )

    def list_event_sources(
        self,
        request: sdk_client_models.ListEventSourcesRequest,
    ) -> sdk_client_models.ListEventSourcesResponse:
        """
        @summary Lists event sources.
        
        @description You can call this API operation to list event sources.
        
        @param request: ListEventSourcesRequest
        @return: ListEventSourcesResponse
        """
        runtime = util_models.RuntimeOptions()
        return self.list_event_sources_with_options(request, runtime)

    async def list_event_sources_async(
        self,
        request: sdk_client_models.ListEventSourcesRequest,
    ) -> sdk_client_models.ListEventSourcesResponse:
        """
        @summary Lists event sources.
        
        @description You can call this API operation to list event sources.
        
        @param request: ListEventSourcesRequest
        @return: ListEventSourcesResponse
        """
        runtime = util_models.RuntimeOptions()
        return await self.list_event_sources_with_options_async(request, runtime)

    def create_event_targets_with_options(
        self,
        request: sdk_client_models.CreateEventTargetsRequest,
        runtime: util_models.RuntimeOptions,
    ) -> sdk_client_models.CreateEventTargetsResponse:
        """
        @summary Creates event targets.
        
        @description You can call this operation to create event targets.
        
        @param request: CreateEventTargetsRequest
        @param runtime: runtime options for this request RuntimeOptions
        @return: CreateEventTargetsResponse
        """
        UtilClient.validate_model(request)
        body = {}
        if not UtilClient.is_unset(request.event_bus_name):
            body['eventBusName'] = request.event_bus_name
        if not UtilClient.is_unset(request.event_rule_name):
            body['eventRuleName'] = request.event_rule_name
        if not UtilClient.is_unset(request.event_targets):
            body['eventTargets'] = request.event_targets
        req = open_api_models.OpenApiRequest(
            body=UtilClient.to_jsonstring(body)
        )
        params = open_api_models.Params(
            action='CreateEventTargets',
            version='2024-07-01',
            protocol='HTTP',
            pathname='/target/createEventTargets',
            method='POST',
            auth_type='Anonymous',
            style='RPC',
            req_body_type='json',
            body_type='json'
        )
        return TeaCore.from_map(
            sdk_client_models.CreateEventTargetsResponse(),
            self.call_api(params, req, runtime)
        )

    async def create_event_targets_with_options_async(
        self,
        request: sdk_client_models.CreateEventTargetsRequest,
        runtime: util_models.RuntimeOptions,
    ) -> sdk_client_models.CreateEventTargetsResponse:
        """
        @summary Creates event targets.
        
        @description You can call this operation to create event targets.
        
        @param request: CreateEventTargetsRequest
        @param runtime: runtime options for this request RuntimeOptions
        @return: CreateEventTargetsResponse
        """
        UtilClient.validate_model(request)
        body = {}
        if not UtilClient.is_unset(request.event_bus_name):
            body['eventBusName'] = request.event_bus_name
        if not UtilClient.is_unset(request.event_rule_name):
            body['eventRuleName'] = request.event_rule_name
        if not UtilClient.is_unset(request.event_targets):
            body['eventTargets'] = request.event_targets
        req = open_api_models.OpenApiRequest(
            body=UtilClient.to_jsonstring(body)
        )
        params = open_api_models.Params(
            action='CreateEventTargets',
            version='2024-07-01',
            protocol='HTTP',
            pathname='/target/createEventTargets',
            method='POST',
            auth_type='Anonymous',
            style='RPC',
            req_body_type='json',
            body_type='json'
        )
        return TeaCore.from_map(
            sdk_client_models.CreateEventTargetsResponse(),
            await self.call_api_async(params, req, runtime)
        )

    def create_event_targets(
        self,
        request: sdk_client_models.CreateEventTargetsRequest,
    ) -> sdk_client_models.CreateEventTargetsResponse:
        """
        @summary Creates event targets.
        
        @description You can call this operation to create event targets.
        
        @param request: CreateEventTargetsRequest
        @return: CreateEventTargetsResponse
        """
        runtime = util_models.RuntimeOptions()
        return self.create_event_targets_with_options(request, runtime)

    async def create_event_targets_async(
        self,
        request: sdk_client_models.CreateEventTargetsRequest,
    ) -> sdk_client_models.CreateEventTargetsResponse:
        """
        @summary Creates event targets.
        
        @description You can call this operation to create event targets.
        
        @param request: CreateEventTargetsRequest
        @return: CreateEventTargetsResponse
        """
        runtime = util_models.RuntimeOptions()
        return await self.create_event_targets_with_options_async(request, runtime)

    def update_event_targets_with_options(
        self,
        request: sdk_client_models.UpdateEventTargetsRequest,
        runtime: util_models.RuntimeOptions,
    ) -> sdk_client_models.UpdateEventTargetsResponse:
        """
        @summary Updates event targets.
        
        @description You can call this operation to update event targets.
        
        @param request: UpdateEventTargetsRequest
        @param runtime: runtime options for this request RuntimeOptions
        @return: UpdateEventTargetsResponse
        """
        UtilClient.validate_model(request)
        body = {}
        if not UtilClient.is_unset(request.event_bus_name):
            body['eventBusName'] = request.event_bus_name
        if not UtilClient.is_unset(request.event_rule_name):
            body['eventRuleName'] = request.event_rule_name
        if not UtilClient.is_unset(request.event_targets):
            body['eventTargets'] = request.event_targets
        req = open_api_models.OpenApiRequest(
            body=UtilClient.to_jsonstring(body)
        )
        params = open_api_models.Params(
            action='UpdateEventTargets',
            version='2024-07-01',
            protocol='HTTP',
            pathname='/target/updateEventTargets',
            method='POST',
            auth_type='Anonymous',
            style='RPC',
            req_body_type='json',
            body_type='json'
        )
        return TeaCore.from_map(
            sdk_client_models.UpdateEventTargetsResponse(),
            self.call_api(params, req, runtime)
        )

    async def update_event_targets_with_options_async(
        self,
        request: sdk_client_models.UpdateEventTargetsRequest,
        runtime: util_models.RuntimeOptions,
    ) -> sdk_client_models.UpdateEventTargetsResponse:
        """
        @summary Updates event targets.
        
        @description You can call this operation to update event targets.
        
        @param request: UpdateEventTargetsRequest
        @param runtime: runtime options for this request RuntimeOptions
        @return: UpdateEventTargetsResponse
        """
        UtilClient.validate_model(request)
        body = {}
        if not UtilClient.is_unset(request.event_bus_name):
            body['eventBusName'] = request.event_bus_name
        if not UtilClient.is_unset(request.event_rule_name):
            body['eventRuleName'] = request.event_rule_name
        if not UtilClient.is_unset(request.event_targets):
            body['eventTargets'] = request.event_targets
        req = open_api_models.OpenApiRequest(
            body=UtilClient.to_jsonstring(body)
        )
        params = open_api_models.Params(
            action='UpdateEventTargets',
            version='2024-07-01',
            protocol='HTTP',
            pathname='/target/updateEventTargets',
            method='POST',
            auth_type='Anonymous',
            style='RPC',
            req_body_type='json',
            body_type='json'
        )
        return TeaCore.from_map(
            sdk_client_models.UpdateEventTargetsResponse(),
            await self.call_api_async(params, req, runtime)
        )

    def update_event_targets(
        self,
        request: sdk_client_models.UpdateEventTargetsRequest,
    ) -> sdk_client_models.UpdateEventTargetsResponse:
        """
        @summary Updates event targets.
        
        @description You can call this operation to update event targets.
        
        @param request: UpdateEventTargetsRequest
        @return: UpdateEventTargetsResponse
        """
        runtime = util_models.RuntimeOptions()
        return self.update_event_targets_with_options(request, runtime)

    async def update_event_targets_async(
        self,
        request: sdk_client_models.UpdateEventTargetsRequest,
    ) -> sdk_client_models.UpdateEventTargetsResponse:
        """
        @summary Updates event targets.
        
        @description You can call this operation to update event targets.
        
        @param request: UpdateEventTargetsRequest
        @return: UpdateEventTargetsResponse
        """
        runtime = util_models.RuntimeOptions()
        return await self.update_event_targets_with_options_async(request, runtime)

    def delete_event_targets_with_options(
        self,
        request: sdk_client_models.DeleteEventTargetsRequest,
        runtime: util_models.RuntimeOptions,
    ) -> sdk_client_models.DeleteEventTargetsResponse:
        """
        @summary Deletes event targets.
        
        @description You can call this operation to delete event targets.
        
        @param request: DeleteEventTargetsRequest
        @param runtime: runtime options for this request RuntimeOptions
        @return: DeleteEventTargetsResponse
        """
        UtilClient.validate_model(request)
        body = {}
        if not UtilClient.is_unset(request.event_bus_name):
            body['eventBusName'] = request.event_bus_name
        if not UtilClient.is_unset(request.event_rule_name):
            body['eventRuleName'] = request.event_rule_name
        if not UtilClient.is_unset(request.event_target_names):
            body['eventTargetNames'] = request.event_target_names
        req = open_api_models.OpenApiRequest(
            body=UtilClient.to_jsonstring(body)
        )
        params = open_api_models.Params(
            action='DeleteEventTargets',
            version='2024-07-01',
            protocol='HTTP',
            pathname='/target/deleteEventTargets',
            method='POST',
            auth_type='Anonymous',
            style='RPC',
            req_body_type='json',
            body_type='json'
        )
        return TeaCore.from_map(
            sdk_client_models.DeleteEventTargetsResponse(),
            self.call_api(params, req, runtime)
        )

    async def delete_event_targets_with_options_async(
        self,
        request: sdk_client_models.DeleteEventTargetsRequest,
        runtime: util_models.RuntimeOptions,
    ) -> sdk_client_models.DeleteEventTargetsResponse:
        """
        @summary Deletes event targets.
        
        @description You can call this operation to delete event targets.
        
        @param request: DeleteEventTargetsRequest
        @param runtime: runtime options for this request RuntimeOptions
        @return: DeleteEventTargetsResponse
        """
        UtilClient.validate_model(request)
        body = {}
        if not UtilClient.is_unset(request.event_bus_name):
            body['eventBusName'] = request.event_bus_name
        if not UtilClient.is_unset(request.event_rule_name):
            body['eventRuleName'] = request.event_rule_name
        if not UtilClient.is_unset(request.event_target_names):
            body['eventTargetNames'] = request.event_target_names
        req = open_api_models.OpenApiRequest(
            body=UtilClient.to_jsonstring(body)
        )
        params = open_api_models.Params(
            action='DeleteEventTargets',
            version='2024-07-01',
            protocol='HTTP',
            pathname='/target/deleteEventTargets',
            method='POST',
            auth_type='Anonymous',
            style='RPC',
            req_body_type='json',
            body_type='json'
        )
        return TeaCore.from_map(
            sdk_client_models.DeleteEventTargetsResponse(),
            await self.call_api_async(params, req, runtime)
        )

    def delete_event_targets(
        self,
        request: sdk_client_models.DeleteEventTargetsRequest,
    ) -> sdk_client_models.DeleteEventTargetsResponse:
        """
        @summary Deletes event targets.
        
        @description You can call this operation to delete event targets.
        
        @param request: DeleteEventTargetsRequest
        @return: DeleteEventTargetsResponse
        """
        runtime = util_models.RuntimeOptions()
        return self.delete_event_targets_with_options(request, runtime)

    async def delete_event_targets_async(
        self,
        request: sdk_client_models.DeleteEventTargetsRequest,
    ) -> sdk_client_models.DeleteEventTargetsResponse:
        """
        @summary Deletes event targets.
        
        @description You can call this operation to delete event targets.
        
        @param request: DeleteEventTargetsRequest
        @return: DeleteEventTargetsResponse
        """
        runtime = util_models.RuntimeOptions()
        return await self.delete_event_targets_with_options_async(request, runtime)

    def list_event_targets_with_options(
        self,
        request: sdk_client_models.ListEventTargetsRequest,
        runtime: util_models.RuntimeOptions,
    ) -> sdk_client_models.ListEventTargetsResponse:
        """
        @summary Lists event targets.
        
        @description You can call this operation to list event targets.
        
        @param request: ListEventTargetsRequest
        @param runtime: runtime options for this request RuntimeOptions
        @return: ListEventTargetsResponse
        """
        UtilClient.validate_model(request)
        body = {}
        if not UtilClient.is_unset(request.event_bus_name):
            body['eventBusName'] = request.event_bus_name
        if not UtilClient.is_unset(request.event_rule_name):
            body['eventRuleName'] = request.event_rule_name
        req = open_api_models.OpenApiRequest(
            body=UtilClient.to_jsonstring(body)
        )
        params = open_api_models.Params(
            action='ListEventTargets',
            version='2024-07-01',
            protocol='HTTP',
            pathname='/target/listEventTargets',
            method='POST',
            auth_type='Anonymous',
            style='RPC',
            req_body_type='json',
            body_type='json'
        )
        return TeaCore.from_map(
            sdk_client_models.ListEventTargetsResponse(),
            self.call_api(params, req, runtime)
        )

    async def list_event_targets_with_options_async(
        self,
        request: sdk_client_models.ListEventTargetsRequest,
        runtime: util_models.RuntimeOptions,
    ) -> sdk_client_models.ListEventTargetsResponse:
        """
        @summary Lists event targets.
        
        @description You can call this operation to list event targets.
        
        @param request: ListEventTargetsRequest
        @param runtime: runtime options for this request RuntimeOptions
        @return: ListEventTargetsResponse
        """
        UtilClient.validate_model(request)
        body = {}
        if not UtilClient.is_unset(request.event_bus_name):
            body['eventBusName'] = request.event_bus_name
        if not UtilClient.is_unset(request.event_rule_name):
            body['eventRuleName'] = request.event_rule_name
        req = open_api_models.OpenApiRequest(
            body=UtilClient.to_jsonstring(body)
        )
        params = open_api_models.Params(
            action='ListEventTargets',
            version='2024-07-01',
            protocol='HTTP',
            pathname='/target/listEventTargets',
            method='POST',
            auth_type='Anonymous',
            style='RPC',
            req_body_type='json',
            body_type='json'
        )
        return TeaCore.from_map(
            sdk_client_models.ListEventTargetsResponse(),
            await self.call_api_async(params, req, runtime)
        )

    def list_event_targets(
        self,
        request: sdk_client_models.ListEventTargetsRequest,
    ) -> sdk_client_models.ListEventTargetsResponse:
        """
        @summary Lists event targets.
        
        @description You can call this operation to list event targets.
        
        @param request: ListEventTargetsRequest
        @return: ListEventTargetsResponse
        """
        runtime = util_models.RuntimeOptions()
        return self.list_event_targets_with_options(request, runtime)

    async def list_event_targets_async(
        self,
        request: sdk_client_models.ListEventTargetsRequest,
    ) -> sdk_client_models.ListEventTargetsResponse:
        """
        @summary Lists event targets.
        
        @description You can call this operation to list event targets.
        
        @param request: ListEventTargetsRequest
        @return: ListEventTargetsResponse
        """
        runtime = util_models.RuntimeOptions()
        return await self.list_event_targets_with_options_async(request, runtime)

    def list_event_types_with_options(
        self,
        request: sdk_client_models.ListEventTypesRequest,
        runtime: util_models.RuntimeOptions,
    ) -> sdk_client_models.ListEventTypesResponse:
        """
        @summary Queries all event buses.
        
        @description You can call this API operation to query all event buses.
        
        @param request: ListEventTypesRequest
        @param runtime: runtime options for this request RuntimeOptions
        @return: ListEventTypesResponse
        """
        UtilClient.validate_model(request)
        body = {}
        if not UtilClient.is_unset(request.event_bus_name):
            body['eventBusName'] = request.event_bus_name
        if not UtilClient.is_unset(request.event_source_name):
            body['eventSourceName'] = request.event_source_name
        if not UtilClient.is_unset(request.max_results):
            body['maxResults'] = request.max_results
        if not UtilClient.is_unset(request.next_token):
            body['nextToken'] = request.next_token
        req = open_api_models.OpenApiRequest(
            body=UtilClient.to_jsonstring(body)
        )
        params = open_api_models.Params(
            action='listEventTypes',
            version='2024-07-01',
            protocol='HTTP',
            pathname='/type/listEventTypes',
            method='POST',
            auth_type='Anonymous',
            style='RPC',
            req_body_type='json',
            body_type='json'
        )
        return TeaCore.from_map(
            sdk_client_models.ListEventTypesResponse(),
            self.call_api(params, req, runtime)
        )

    async def list_event_types_with_options_async(
        self,
        request: sdk_client_models.ListEventTypesRequest,
        runtime: util_models.RuntimeOptions,
    ) -> sdk_client_models.ListEventTypesResponse:
        """
        @summary Queries all event buses.
        
        @description You can call this API operation to query all event buses.
        
        @param request: ListEventTypesRequest
        @param runtime: runtime options for this request RuntimeOptions
        @return: ListEventTypesResponse
        """
        UtilClient.validate_model(request)
        body = {}
        if not UtilClient.is_unset(request.event_bus_name):
            body['eventBusName'] = request.event_bus_name
        if not UtilClient.is_unset(request.event_source_name):
            body['eventSourceName'] = request.event_source_name
        if not UtilClient.is_unset(request.max_results):
            body['maxResults'] = request.max_results
        if not UtilClient.is_unset(request.next_token):
            body['nextToken'] = request.next_token
        req = open_api_models.OpenApiRequest(
            body=UtilClient.to_jsonstring(body)
        )
        params = open_api_models.Params(
            action='listEventTypes',
            version='2024-07-01',
            protocol='HTTP',
            pathname='/type/listEventTypes',
            method='POST',
            auth_type='Anonymous',
            style='RPC',
            req_body_type='json',
            body_type='json'
        )
        return TeaCore.from_map(
            sdk_client_models.ListEventTypesResponse(),
            await self.call_api_async(params, req, runtime)
        )

    def list_event_types(
        self,
        request: sdk_client_models.ListEventTypesRequest,
    ) -> sdk_client_models.ListEventTypesResponse:
        """
        @summary Queries all event buses.
        
        @description You can call this API operation to query all event buses.
        
        @param request: ListEventTypesRequest
        @return: ListEventTypesResponse
        """
        runtime = util_models.RuntimeOptions()
        return self.list_event_types_with_options(request, runtime)

    async def list_event_types_async(
        self,
        request: sdk_client_models.ListEventTypesRequest,
    ) -> sdk_client_models.ListEventTypesResponse:
        """
        @summary Queries all event buses.
        
        @description You can call this API operation to query all event buses.
        
        @param request: ListEventTypesRequest
        @return: ListEventTypesResponse
        """
        runtime = util_models.RuntimeOptions()
        return await self.list_event_types_with_options_async(request, runtime)
