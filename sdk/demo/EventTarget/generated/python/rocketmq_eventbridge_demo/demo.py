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

    def test_create_event_targets(self) -> None:
        """
        EventTarget Controller apis:
        createEventTargets *\
        updateEventTargets *\
        deleteEventTargets *\
        listEventTargets   *\
        """
        config_ = {
            'fileName': '~/Target',
            'line': '{    "form":"JSONPATH",    "value":"$.data"}'
        }
        config_2_ = {
            'fileName': '~/Target222',
            'line': '{    "form":"JSONPATH",    "value":"$.data"}'
        }
        request = sdkclient_models.CreateEventTargetsRequest(
            event_bus_name='newBus',
            event_rule_name='newRule',
            event_targets=[
                sdkclient_models.EventTarget(
                event_target_name='newTarget',
                class_name='file',
                config=config_,
                run_options=sdkclient_models.EventTargetRunOptions(
                    errors_tolerance='',
                    retry_strategy=sdkclient_models.EventTargetRunOptionsRetryStrategy(
                        push_retry_strategy='',
                        maximum_event_age_in_seconds=100,
                        maximum_retry_attempts=100
                    ),
                    dead_letter_queue=sdkclient_models.EventTargetRunOptionsDeadLetterQueue(
                        type=''
                    )
                )
            ),
                sdkclient_models.EventTarget(
                event_target_name='newTarget222',
                class_name='file',
                config=config_2_,
                run_options=sdkclient_models.EventTargetRunOptions(
                    errors_tolerance='',
                    retry_strategy=sdkclient_models.EventTargetRunOptionsRetryStrategy(
                        push_retry_strategy='',
                        maximum_event_age_in_seconds=100,
                        maximum_retry_attempts=100
                    ),
                    dead_letter_queue=sdkclient_models.EventTargetRunOptionsDeadLetterQueue(
                        type=''
                    )
                )
            )
            ]
        )
        try:
            res = self._sdk_client.create_event_targets(request)
            ConsoleClient.log(UtilClient.to_jsonstring(res.body))
        except Exception as err:
            ConsoleClient.log('err!')
            ConsoleClient.log(err.message)
        finally:
            ConsoleClient.log('test end!')

    async def test_create_event_targets_async(self) -> None:
        """
        EventTarget Controller apis:
        createEventTargets *\
        updateEventTargets *\
        deleteEventTargets *\
        listEventTargets   *\
        """
        config_ = {
            'fileName': '~/Target',
            'line': '{    "form":"JSONPATH",    "value":"$.data"}'
        }
        config_2_ = {
            'fileName': '~/Target222',
            'line': '{    "form":"JSONPATH",    "value":"$.data"}'
        }
        request = sdkclient_models.CreateEventTargetsRequest(
            event_bus_name='newBus',
            event_rule_name='newRule',
            event_targets=[
                sdkclient_models.EventTarget(
                event_target_name='newTarget',
                class_name='file',
                config=config_,
                run_options=sdkclient_models.EventTargetRunOptions(
                    errors_tolerance='',
                    retry_strategy=sdkclient_models.EventTargetRunOptionsRetryStrategy(
                        push_retry_strategy='',
                        maximum_event_age_in_seconds=100,
                        maximum_retry_attempts=100
                    ),
                    dead_letter_queue=sdkclient_models.EventTargetRunOptionsDeadLetterQueue(
                        type=''
                    )
                )
            ),
                sdkclient_models.EventTarget(
                event_target_name='newTarget222',
                class_name='file',
                config=config_2_,
                run_options=sdkclient_models.EventTargetRunOptions(
                    errors_tolerance='',
                    retry_strategy=sdkclient_models.EventTargetRunOptionsRetryStrategy(
                        push_retry_strategy='',
                        maximum_event_age_in_seconds=100,
                        maximum_retry_attempts=100
                    ),
                    dead_letter_queue=sdkclient_models.EventTargetRunOptionsDeadLetterQueue(
                        type=''
                    )
                )
            )
            ]
        )
        try:
            res = await self._sdk_client.create_event_targets_async(request)
            ConsoleClient.log(UtilClient.to_jsonstring(res.body))
        except Exception as err:
            ConsoleClient.log('err!')
            ConsoleClient.log(err.message)
        finally:
            ConsoleClient.log('test end!')

    def test_update_event_targets(self) -> None:
        config_ = {
            'fileName': '~/Target',
            'line': '{    "form":"JSONPATH",    "value":"$.data"}'
        }
        config_2_ = {
            'fileName': '~/Target222',
            'line': '{    "form":"JSONPATH",    "value":"$.data"}'
        }
        request = sdkclient_models.UpdateEventTargetsRequest(
            event_bus_name='newBus',
            event_rule_name='newRule',
            event_targets=[
                sdkclient_models.EventTarget(
                event_target_name='newTarget',
                class_name='file',
                config=config_
            ),
                sdkclient_models.EventTarget(
                event_target_name='newTarget222',
                class_name='file',
                config=config_2_
            )
            ]
        )
        try:
            res = self._sdk_client.update_event_targets(request)
            ConsoleClient.log(UtilClient.to_jsonstring(res.body))
        except Exception as err:
            ConsoleClient.log('err!')
            ConsoleClient.log(err.message)
        finally:
            ConsoleClient.log('test end!')

    async def test_update_event_targets_async(self) -> None:
        config_ = {
            'fileName': '~/Target',
            'line': '{    "form":"JSONPATH",    "value":"$.data"}'
        }
        config_2_ = {
            'fileName': '~/Target222',
            'line': '{    "form":"JSONPATH",    "value":"$.data"}'
        }
        request = sdkclient_models.UpdateEventTargetsRequest(
            event_bus_name='newBus',
            event_rule_name='newRule',
            event_targets=[
                sdkclient_models.EventTarget(
                event_target_name='newTarget',
                class_name='file',
                config=config_
            ),
                sdkclient_models.EventTarget(
                event_target_name='newTarget222',
                class_name='file',
                config=config_2_
            )
            ]
        )
        try:
            res = await self._sdk_client.update_event_targets_async(request)
            ConsoleClient.log(UtilClient.to_jsonstring(res.body))
        except Exception as err:
            ConsoleClient.log('err!')
            ConsoleClient.log(err.message)
        finally:
            ConsoleClient.log('test end!')

    def test_delete_event_targets(self) -> None:
        request = sdkclient_models.DeleteEventTargetsRequest(
            event_bus_name='newBus',
            event_rule_name='newRule',
            event_target_names=[
                'newTarget',
                'newTarget222'
            ]
        )
        try:
            res = self._sdk_client.delete_event_targets(request)
            ConsoleClient.log(UtilClient.to_jsonstring(res.body))
        except Exception as err:
            ConsoleClient.log('err!')
            ConsoleClient.log(err.message)
        finally:
            ConsoleClient.log('test end!')

    async def test_delete_event_targets_async(self) -> None:
        request = sdkclient_models.DeleteEventTargetsRequest(
            event_bus_name='newBus',
            event_rule_name='newRule',
            event_target_names=[
                'newTarget',
                'newTarget222'
            ]
        )
        try:
            res = await self._sdk_client.delete_event_targets_async(request)
            ConsoleClient.log(UtilClient.to_jsonstring(res.body))
        except Exception as err:
            ConsoleClient.log('err!')
            ConsoleClient.log(err.message)
        finally:
            ConsoleClient.log('test end!')

    def test_list_event_targets(self) -> None:
        request = sdkclient_models.ListEventTargetsRequest(
            event_bus_name='newBus',
            event_rule_name='newRule'
        )
        try:
            res = self._sdk_client.list_event_targets(request)
            ConsoleClient.log(UtilClient.to_jsonstring(res.body))
        except Exception as err:
            ConsoleClient.log('err!')
            ConsoleClient.log(err.message)
        finally:
            ConsoleClient.log('test end!')

    async def test_list_event_targets_async(self) -> None:
        request = sdkclient_models.ListEventTargetsRequest(
            event_bus_name='newBus',
            event_rule_name='newRule'
        )
        try:
            res = await self._sdk_client.list_event_targets_async(request)
            ConsoleClient.log(UtilClient.to_jsonstring(res.body))
        except Exception as err:
            ConsoleClient.log('err!')
            ConsoleClient.log(err.message)
        finally:
            ConsoleClient.log('test end!')
demo = Demo()
demo.test_list_event_targets()
