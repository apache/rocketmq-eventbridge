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

    def test_create_event_rule(self) -> None:
        """
        EventRule Controller apis:
        createEventRule  *\
        getEventRule     *\
        deleteEventRule  *\
        updateEventRule  *\
        listEventRules   *\
        enableEventRule  *\
        disableEventRule *\
        """
        request = sdkclient_models.CreateEventRuleRequest(
            event_bus_name='newBus',
            event_rule_name='newRule',
            description='an event rule for test',
            filter_pattern='{}'
        )
        try:
            res = self._sdk_client.create_event_rule(request)
            ConsoleClient.log(UtilClient.to_jsonstring(res.body))
        except Exception as err:
            ConsoleClient.log('err!')
            ConsoleClient.log(err.message)
        finally:
            ConsoleClient.log('test end!')

    async def test_create_event_rule_async(self) -> None:
        """
        EventRule Controller apis:
        createEventRule  *\
        getEventRule     *\
        deleteEventRule  *\
        updateEventRule  *\
        listEventRules   *\
        enableEventRule  *\
        disableEventRule *\
        """
        request = sdkclient_models.CreateEventRuleRequest(
            event_bus_name='newBus',
            event_rule_name='newRule',
            description='an event rule for test',
            filter_pattern='{}'
        )
        try:
            res = await self._sdk_client.create_event_rule_async(request)
            ConsoleClient.log(UtilClient.to_jsonstring(res.body))
        except Exception as err:
            ConsoleClient.log('err!')
            ConsoleClient.log(err.message)
        finally:
            ConsoleClient.log('test end!')

    def test_get_event_rule(self) -> None:
        request = sdkclient_models.GetEventRuleRequest(
            event_bus_name='newBus',
            event_rule_name='newRule'
        )
        try:
            res = self._sdk_client.get_event_rule(request)
            ConsoleClient.log(UtilClient.to_jsonstring(res.body))
        except Exception as err:
            ConsoleClient.log('err!')
            ConsoleClient.log(err.message)
        finally:
            ConsoleClient.log('test end!')

    async def test_get_event_rule_async(self) -> None:
        request = sdkclient_models.GetEventRuleRequest(
            event_bus_name='newBus',
            event_rule_name='newRule'
        )
        try:
            res = await self._sdk_client.get_event_rule_async(request)
            ConsoleClient.log(UtilClient.to_jsonstring(res.body))
        except Exception as err:
            ConsoleClient.log('err!')
            ConsoleClient.log(err.message)
        finally:
            ConsoleClient.log('test end!')

    def test_delete_event_rule(self) -> None:
        request = sdkclient_models.DeleteEventRuleRequest(
            event_bus_name='newBus',
            event_rule_name='newRule'
        )
        try:
            res = self._sdk_client.delete_event_rule(request)
            ConsoleClient.log(UtilClient.to_jsonstring(res.body))
        except Exception as err:
            ConsoleClient.log('err!')
            ConsoleClient.log(err.message)
        finally:
            ConsoleClient.log('test end!')

    async def test_delete_event_rule_async(self) -> None:
        request = sdkclient_models.DeleteEventRuleRequest(
            event_bus_name='newBus',
            event_rule_name='newRule'
        )
        try:
            res = await self._sdk_client.delete_event_rule_async(request)
            ConsoleClient.log(UtilClient.to_jsonstring(res.body))
        except Exception as err:
            ConsoleClient.log('err!')
            ConsoleClient.log(err.message)
        finally:
            ConsoleClient.log('test end!')

    def test_update_event_rule(self) -> None:
        request = sdkclient_models.UpdateEventRuleRequest(
            event_bus_name='newBus',
            event_rule_name='newRule',
            description='new description for testing update API',
            filter_pattern='{}'
        )
        try:
            res = self._sdk_client.update_event_rule(request)
            ConsoleClient.log(UtilClient.to_jsonstring(res.body))
        except Exception as err:
            ConsoleClient.log('err!')
            ConsoleClient.log(err.message)
        finally:
            ConsoleClient.log('test end!')

    async def test_update_event_rule_async(self) -> None:
        request = sdkclient_models.UpdateEventRuleRequest(
            event_bus_name='newBus',
            event_rule_name='newRule',
            description='new description for testing update API',
            filter_pattern='{}'
        )
        try:
            res = await self._sdk_client.update_event_rule_async(request)
            ConsoleClient.log(UtilClient.to_jsonstring(res.body))
        except Exception as err:
            ConsoleClient.log('err!')
            ConsoleClient.log(err.message)
        finally:
            ConsoleClient.log('test end!')

    def test_list_event_rules(self) -> None:
        request = sdkclient_models.ListEventRulesRequest(
            event_bus_name='newBus',
            max_results=2,
            next_token='0'
        )
        try:
            res = self._sdk_client.list_event_rules(request)
            ConsoleClient.log(UtilClient.to_jsonstring(res.body))
        except Exception as err:
            ConsoleClient.log('err!')
            ConsoleClient.log(err.message)
        finally:
            ConsoleClient.log('test end!')

    async def test_list_event_rules_async(self) -> None:
        request = sdkclient_models.ListEventRulesRequest(
            event_bus_name='newBus',
            max_results=2,
            next_token='0'
        )
        try:
            res = await self._sdk_client.list_event_rules_async(request)
            ConsoleClient.log(UtilClient.to_jsonstring(res.body))
        except Exception as err:
            ConsoleClient.log('err!')
            ConsoleClient.log(err.message)
        finally:
            ConsoleClient.log('test end!')

    def test_enable_event_rule(self) -> None:
        request = sdkclient_models.EnableEventRuleRequest(
            event_bus_name='newBus',
            event_rule_name='newRule'
        )
        try:
            res = self._sdk_client.enable_event_rule(request)
            ConsoleClient.log(UtilClient.to_jsonstring(res.body))
        except Exception as err:
            ConsoleClient.log('err!')
            ConsoleClient.log(err.message)
        finally:
            ConsoleClient.log('test end!')

    async def test_enable_event_rule_async(self) -> None:
        request = sdkclient_models.EnableEventRuleRequest(
            event_bus_name='newBus',
            event_rule_name='newRule'
        )
        try:
            res = await self._sdk_client.enable_event_rule_async(request)
            ConsoleClient.log(UtilClient.to_jsonstring(res.body))
        except Exception as err:
            ConsoleClient.log('err!')
            ConsoleClient.log(err.message)
        finally:
            ConsoleClient.log('test end!')

    def test_disable_event_rule(self) -> None:
        request = sdkclient_models.DisableEventRuleRequest(
            event_bus_name='newBus',
            event_rule_name='newRule'
        )
        try:
            res = self._sdk_client.disable_event_rule(request)
            ConsoleClient.log(UtilClient.to_jsonstring(res.body))
        except Exception as err:
            ConsoleClient.log('err!')
            ConsoleClient.log(err.message)
        finally:
            ConsoleClient.log('test end!')

    async def test_disable_event_rule_async(self) -> None:
        request = sdkclient_models.DisableEventRuleRequest(
            event_bus_name='newBus',
            event_rule_name='newRule'
        )
        try:
            res = await self._sdk_client.disable_event_rule_async(request)
            ConsoleClient.log(UtilClient.to_jsonstring(res.body))
        except Exception as err:
            ConsoleClient.log('err!')
            ConsoleClient.log(err.message)
        finally:
            ConsoleClient.log('test end!')
demo = Demo()
demo.test_list_event_rules()
