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

    def test_create_event_bus(self) -> None:
        """
        test func for EventBus Controller apis:
        createEventBus *\
        getEventBus    *\
        deleteEventBus *\
        listEventBuses *\
        """
        request = sdkclient_models.CreateEventBusRequest(
            event_bus_name='newBus'
        )
        try:
            res = self._sdk_client.create_event_bus(request)
            ConsoleClient.log(UtilClient.to_jsonstring(res.body))
        except Exception as err:
            ConsoleClient.log('err!')
            ConsoleClient.log(err.message)
        finally:
            ConsoleClient.log('test end!')

    async def test_create_event_bus_async(self) -> None:
        """
        test func for EventBus Controller apis:
        createEventBus *\
        getEventBus    *\
        deleteEventBus *\
        listEventBuses *\
        """
        request = sdkclient_models.CreateEventBusRequest(
            event_bus_name='newBus'
        )
        try:
            res = await self._sdk_client.create_event_bus_async(request)
            ConsoleClient.log(UtilClient.to_jsonstring(res.body))
        except Exception as err:
            ConsoleClient.log('err!')
            ConsoleClient.log(err.message)
        finally:
            ConsoleClient.log('test end!')

    def test_delete_event_bus(self) -> None:
        request = sdkclient_models.DeleteEventBusRequest(
            event_bus_name='newBus'
        )
        try:
            res = self._sdk_client.delete_event_bus(request)
            ConsoleClient.log(UtilClient.to_jsonstring(res.body))
        except Exception as err:
            ConsoleClient.log('err!')
            ConsoleClient.log(err.message)
        finally:
            ConsoleClient.log('test end!')

    async def test_delete_event_bus_async(self) -> None:
        request = sdkclient_models.DeleteEventBusRequest(
            event_bus_name='newBus'
        )
        try:
            res = await self._sdk_client.delete_event_bus_async(request)
            ConsoleClient.log(UtilClient.to_jsonstring(res.body))
        except Exception as err:
            ConsoleClient.log('err!')
            ConsoleClient.log(err.message)
        finally:
            ConsoleClient.log('test end!')

    def test_get_event_bus(self) -> None:
        request = sdkclient_models.GetEventBusRequest(
            event_bus_name='newBus'
        )
        try:
            res = self._sdk_client.get_event_bus(request)
            ConsoleClient.log(UtilClient.to_jsonstring(res.body))
        except Exception as err:
            ConsoleClient.log('err!')
            ConsoleClient.log(err.message)
        finally:
            ConsoleClient.log('test end!')

    async def test_get_event_bus_async(self) -> None:
        request = sdkclient_models.GetEventBusRequest(
            event_bus_name='newBus'
        )
        try:
            res = await self._sdk_client.get_event_bus_async(request)
            ConsoleClient.log(UtilClient.to_jsonstring(res.body))
        except Exception as err:
            ConsoleClient.log('err!')
            ConsoleClient.log(err.message)
        finally:
            ConsoleClient.log('test end!')

    def test_list_event_buses(self) -> None:
        request = sdkclient_models.ListEventBusesRequest(
            max_results=2
        )
        try:
            res = self._sdk_client.list_event_buses(request)
            ConsoleClient.log(UtilClient.to_jsonstring(res.body))
        except Exception as err:
            ConsoleClient.log('err!')
            ConsoleClient.log(err.message)
        finally:
            ConsoleClient.log('test end!')

    async def test_list_event_buses_async(self) -> None:
        request = sdkclient_models.ListEventBusesRequest(
            max_results=2
        )
        try:
            res = await self._sdk_client.list_event_buses_async(request)
            ConsoleClient.log(UtilClient.to_jsonstring(res.body))
        except Exception as err:
            ConsoleClient.log('err!')
            ConsoleClient.log(err.message)
        finally:
            ConsoleClient.log('test end!')
demo = Demo()
demo.test_list_event_buses()
