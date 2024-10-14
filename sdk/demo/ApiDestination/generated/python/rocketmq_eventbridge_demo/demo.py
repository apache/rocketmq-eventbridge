# -*- coding: utf-8 -*-
# This file is auto-generated, don't edit it. Thanks.
from rocketmq_eventbridge.client import Client as SDKClientClient
from alibabacloud_tea_openapi import models as open_api_models
from rocketmq_eventbridge import models as sdkclient_models
from alibabacloud_tea_console.client import Client as ConsoleClient
from alibabacloud_tea_util.client import Client as UtilClient


class Demo:
    _sdk_client: SDKClientClient = None
    _endpoint: str = None

    def __init__(self):
        self._endpoint = '127.0.0.1:7001'
        config = open_api_models.Config(
            endpoint=self._endpoint
        )
        self._sdk_client = SDKClientClient(config)

    def test_create_api_destination(self) -> None:
        """
        ApiDestination Controller apis:
        createApiDestination *\
        updateApiDestination *\
        getApiDestination    *\
        deleteApiDestination *\
        listApiDestinations  *\
        """
        request = sdkclient_models.CreateApiDestinationRequest(
            api_destination_name='new-api-destination',
            connection_name='new-connection',
            description='demo api destination for test',
            http_api_parameters=sdkclient_models.CreateApiDestinationRequestHttpApiParameters(
                endpoint=self._endpoint,
                method='POST'
            )
        )
        try:
            res = self._sdk_client.create_api_destination(request)
            ConsoleClient.log(UtilClient.to_jsonstring(res.body))
        except Exception as err:
            ConsoleClient.log('err!')
            ConsoleClient.log(err.message)
        finally:
            ConsoleClient.log('test end!')

    async def test_create_api_destination_async(self) -> None:
        """
        ApiDestination Controller apis:
        createApiDestination *\
        updateApiDestination *\
        getApiDestination    *\
        deleteApiDestination *\
        listApiDestinations  *\
        """
        request = sdkclient_models.CreateApiDestinationRequest(
            api_destination_name='new-api-destination',
            connection_name='new-connection',
            description='demo api destination for test',
            http_api_parameters=sdkclient_models.CreateApiDestinationRequestHttpApiParameters(
                endpoint=self._endpoint,
                method='POST'
            )
        )
        try:
            res = await self._sdk_client.create_api_destination_async(request)
            ConsoleClient.log(UtilClient.to_jsonstring(res.body))
        except Exception as err:
            ConsoleClient.log('err!')
            ConsoleClient.log(err.message)
        finally:
            ConsoleClient.log('test end!')

    def test_update_api_destination(self) -> None:
        request = sdkclient_models.UpdateApiDestinationRequest(
            api_destination_name='new-api-destination',
            connection_name='new-connection',
            description='!updated! demo api destination for test',
            http_api_parameters=sdkclient_models.UpdateApiDestinationRequestHttpApiParameters(
                endpoint=self._endpoint,
                method='GET'
            )
        )
        try:
            res = self._sdk_client.update_api_destination(request)
            ConsoleClient.log(UtilClient.to_jsonstring(res.body))
        except Exception as err:
            ConsoleClient.log('err!')
            ConsoleClient.log(err.message)
        finally:
            ConsoleClient.log('test end!')

    async def test_update_api_destination_async(self) -> None:
        request = sdkclient_models.UpdateApiDestinationRequest(
            api_destination_name='new-api-destination',
            connection_name='new-connection',
            description='!updated! demo api destination for test',
            http_api_parameters=sdkclient_models.UpdateApiDestinationRequestHttpApiParameters(
                endpoint=self._endpoint,
                method='GET'
            )
        )
        try:
            res = await self._sdk_client.update_api_destination_async(request)
            ConsoleClient.log(UtilClient.to_jsonstring(res.body))
        except Exception as err:
            ConsoleClient.log('err!')
            ConsoleClient.log(err.message)
        finally:
            ConsoleClient.log('test end!')

    def test_get_api_destination(self) -> None:
        request = sdkclient_models.GetApiDestinationRequest(
            api_destination_name='new-api-destination'
        )
        try:
            res = self._sdk_client.get_api_destination(request)
            ConsoleClient.log(UtilClient.to_jsonstring(res.body))
        except Exception as err:
            ConsoleClient.log('err!')
            ConsoleClient.log(err.message)
        finally:
            ConsoleClient.log('test end!')

    async def test_get_api_destination_async(self) -> None:
        request = sdkclient_models.GetApiDestinationRequest(
            api_destination_name='new-api-destination'
        )
        try:
            res = await self._sdk_client.get_api_destination_async(request)
            ConsoleClient.log(UtilClient.to_jsonstring(res.body))
        except Exception as err:
            ConsoleClient.log('err!')
            ConsoleClient.log(err.message)
        finally:
            ConsoleClient.log('test end!')

    def test_delete_api_destination(self) -> None:
        request = sdkclient_models.DeleteApiDestinationRequest(
            api_destination_name='new-api-destination'
        )
        try:
            res = self._sdk_client.delete_api_destination(request)
            ConsoleClient.log(UtilClient.to_jsonstring(res.body))
        except Exception as err:
            ConsoleClient.log('err!')
            ConsoleClient.log(err.message)
        finally:
            ConsoleClient.log('test end!')

    async def test_delete_api_destination_async(self) -> None:
        request = sdkclient_models.DeleteApiDestinationRequest(
            api_destination_name='new-api-destination'
        )
        try:
            res = await self._sdk_client.delete_api_destination_async(request)
            ConsoleClient.log(UtilClient.to_jsonstring(res.body))
        except Exception as err:
            ConsoleClient.log('err!')
            ConsoleClient.log(err.message)
        finally:
            ConsoleClient.log('test end!')

    def test_list_api_destinations(self) -> None:
        request = sdkclient_models.ListApiDestinationsRequest(
            max_results=2
        )
        try:
            res = self._sdk_client.list_api_destinations(request)
            ConsoleClient.log(UtilClient.to_jsonstring(res.body))
        except Exception as err:
            ConsoleClient.log('err!')
            ConsoleClient.log(err.message)
        finally:
            ConsoleClient.log('test end!')

    async def test_list_api_destinations_async(self) -> None:
        request = sdkclient_models.ListApiDestinationsRequest(
            max_results=2
        )
        try:
            res = await self._sdk_client.list_api_destinations_async(request)
            ConsoleClient.log(UtilClient.to_jsonstring(res.body))
        except Exception as err:
            ConsoleClient.log('err!')
            ConsoleClient.log(err.message)
        finally:
            ConsoleClient.log('test end!')
demo = Demo()
demo.test_list_api_destinations()
