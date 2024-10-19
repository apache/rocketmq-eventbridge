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

    def test_create_event_source(self) -> None:
        """
        EventSource Controller apis:
        createEventSource *\
        updateEventSource *\
        deleteEventSource *\
        getEventSource    *\
        listEventSources  *\
        """
        request = sdkclient_models.CreateEventSourceRequest(
            event_bus_name='newBus',
            event_source_name='newSource',
            description='a source for test'
        )
        try:
            res = self._sdk_client.create_event_source(request)
            ConsoleClient.log(UtilClient.to_jsonstring(res.body))
        except Exception as err:
            ConsoleClient.log('err!')
            ConsoleClient.log(err.message)
        finally:
            ConsoleClient.log('test end!')

    async def test_create_event_source_async(self) -> None:
        """
        EventSource Controller apis:
        createEventSource *\
        updateEventSource *\
        deleteEventSource *\
        getEventSource    *\
        listEventSources  *\
        """
        request = sdkclient_models.CreateEventSourceRequest(
            event_bus_name='newBus',
            event_source_name='newSource',
            description='a source for test'
        )
        try:
            res = await self._sdk_client.create_event_source_async(request)
            ConsoleClient.log(UtilClient.to_jsonstring(res.body))
        except Exception as err:
            ConsoleClient.log('err!')
            ConsoleClient.log(err.message)
        finally:
            ConsoleClient.log('test end!')

    def test_update_event_source(self) -> None:
        request = sdkclient_models.UpdateEventSourceRequest(
            event_bus_name='newBus',
            event_source_name='newSource',
            description='new description for testing Update API'
        )
        try:
            res = self._sdk_client.update_event_source(request)
            ConsoleClient.log(UtilClient.to_jsonstring(res.body))
        except Exception as err:
            ConsoleClient.log('err!')
            ConsoleClient.log(err.message)
        finally:
            ConsoleClient.log('test end!')

    async def test_update_event_source_async(self) -> None:
        request = sdkclient_models.UpdateEventSourceRequest(
            event_bus_name='newBus',
            event_source_name='newSource',
            description='new description for testing Update API'
        )
        try:
            res = await self._sdk_client.update_event_source_async(request)
            ConsoleClient.log(UtilClient.to_jsonstring(res.body))
        except Exception as err:
            ConsoleClient.log('err!')
            ConsoleClient.log(err.message)
        finally:
            ConsoleClient.log('test end!')

    def test_delete_event_source(self) -> None:
        request = sdkclient_models.DeleteEventSourceRequest(
            event_bus_name='newBus',
            event_source_name='newSource'
        )
        try:
            res = self._sdk_client.delete_event_source(request)
            ConsoleClient.log(UtilClient.to_jsonstring(res.body))
        except Exception as err:
            ConsoleClient.log('err!')
            ConsoleClient.log(err.message)
        finally:
            ConsoleClient.log('test end!')

    async def test_delete_event_source_async(self) -> None:
        request = sdkclient_models.DeleteEventSourceRequest(
            event_bus_name='newBus',
            event_source_name='newSource'
        )
        try:
            res = await self._sdk_client.delete_event_source_async(request)
            ConsoleClient.log(UtilClient.to_jsonstring(res.body))
        except Exception as err:
            ConsoleClient.log('err!')
            ConsoleClient.log(err.message)
        finally:
            ConsoleClient.log('test end!')

    def test_get_event_source(self) -> None:
        request = sdkclient_models.GetEventSourceRequest(
            event_bus_name='newBus',
            event_source_name='newSource'
        )
        try:
            res = self._sdk_client.get_event_source(request)
            ConsoleClient.log(UtilClient.to_jsonstring(res.body))
        except Exception as err:
            ConsoleClient.log('err!')
            ConsoleClient.log(err.message)
        finally:
            ConsoleClient.log('test end!')

    async def test_get_event_source_async(self) -> None:
        request = sdkclient_models.GetEventSourceRequest(
            event_bus_name='newBus',
            event_source_name='newSource'
        )
        try:
            res = await self._sdk_client.get_event_source_async(request)
            ConsoleClient.log(UtilClient.to_jsonstring(res.body))
        except Exception as err:
            ConsoleClient.log('err!')
            ConsoleClient.log(err.message)
        finally:
            ConsoleClient.log('test end!')

    def test_list_event_sources(self) -> None:
        request = sdkclient_models.ListEventSourcesRequest(
            event_bus_name='newBus',
            event_source_type='USER_DEFINED',
            max_results=10,
            next_token='0'
        )
        try:
            res = self._sdk_client.list_event_sources(request)
            ConsoleClient.log(UtilClient.to_jsonstring(res.body))
        except Exception as err:
            ConsoleClient.log('err!')
            ConsoleClient.log(err.message)
        finally:
            ConsoleClient.log('test end!')

    async def test_list_event_sources_async(self) -> None:
        request = sdkclient_models.ListEventSourcesRequest(
            event_bus_name='newBus',
            event_source_type='USER_DEFINED',
            max_results=10,
            next_token='0'
        )
        try:
            res = await self._sdk_client.list_event_sources_async(request)
            ConsoleClient.log(UtilClient.to_jsonstring(res.body))
        except Exception as err:
            ConsoleClient.log('err!')
            ConsoleClient.log(err.message)
        finally:
            ConsoleClient.log('test end!')
demo = Demo()
demo.test_list_event_sources()
