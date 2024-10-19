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

    def test_list_event_types(self) -> None:
        """
        EventType Controller apis:
        listEventTypes *\
        """
        request = sdkclient_models.ListEventTypesRequest(
            event_bus_name='newBus',
            event_source_name='newSource',
            max_results=10,
            next_token='0'
        )
        try:
            res = self._sdk_client.list_event_types(request)
            ConsoleClient.log(UtilClient.to_jsonstring(res.body))
        except Exception as err:
            ConsoleClient.log('err!')
            ConsoleClient.log(err.message)
        finally:
            ConsoleClient.log('test end!')

    async def test_list_event_types_async(self) -> None:
        """
        EventType Controller apis:
        listEventTypes *\
        """
        request = sdkclient_models.ListEventTypesRequest(
            event_bus_name='newBus',
            event_source_name='newSource',
            max_results=10,
            next_token='0'
        )
        try:
            res = await self._sdk_client.list_event_types_async(request)
            ConsoleClient.log(UtilClient.to_jsonstring(res.body))
        except Exception as err:
            ConsoleClient.log('err!')
            ConsoleClient.log(err.message)
        finally:
            ConsoleClient.log('test end!')
demo = Demo()
demo.test_list_event_types()
