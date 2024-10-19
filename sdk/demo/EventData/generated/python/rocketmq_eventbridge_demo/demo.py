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

    def test_put_events(self) -> None:
        """
        EventData Controller apis:
        putEvents *\
        """
        request = sdkclient_models.PutEventsRequest(
            event_bus_name='demo-bus',
            event='an event for API test'
        )
        try:
            res = self._sdk_client.put_events(request)
            ConsoleClient.log(UtilClient.to_jsonstring(res.body))
        except Exception as err:
            ConsoleClient.log('err!')
            ConsoleClient.log(err.message)
        finally:
            ConsoleClient.log('test end!')

    async def test_put_events_async(self) -> None:
        """
        EventData Controller apis:
        putEvents *\
        """
        request = sdkclient_models.PutEventsRequest(
            event_bus_name='demo-bus',
            event='an event for API test'
        )
        try:
            res = await self._sdk_client.put_events_async(request)
            ConsoleClient.log(UtilClient.to_jsonstring(res.body))
        except Exception as err:
            ConsoleClient.log('err!')
            ConsoleClient.log(err.message)
        finally:
            ConsoleClient.log('test end!')
demo = Demo()
demo.test_put_events()
