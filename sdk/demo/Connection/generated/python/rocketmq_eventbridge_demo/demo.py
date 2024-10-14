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

    def test_create_connection(self) -> None:
        """
        test func for Connection Controller apis:
        createConnection    *\
        deleteConnection    *\
        updateConnection    *\
        getConnection       *\
        selectOneConnection *\
        listConnections     *\
        listEnumsResponse   *\
        """
        request = sdkclient_models.CreateConnectionRequest(
            connection_name='new-connection',
            network_parameters=sdkclient_models.CreateConnectionRequestNetworkParameters(
                network_type='PublicNetwork'
            )
        )
        try:
            res = self._sdk_client.create_connection(request)
            ConsoleClient.log(UtilClient.to_jsonstring(res.body))
        except Exception as err:
            ConsoleClient.log('err!')
            ConsoleClient.log(err.message)
        finally:
            ConsoleClient.log('test end!')

    async def test_create_connection_async(self) -> None:
        """
        test func for Connection Controller apis:
        createConnection    *\
        deleteConnection    *\
        updateConnection    *\
        getConnection       *\
        selectOneConnection *\
        listConnections     *\
        listEnumsResponse   *\
        """
        request = sdkclient_models.CreateConnectionRequest(
            connection_name='new-connection',
            network_parameters=sdkclient_models.CreateConnectionRequestNetworkParameters(
                network_type='PublicNetwork'
            )
        )
        try:
            res = await self._sdk_client.create_connection_async(request)
            ConsoleClient.log(UtilClient.to_jsonstring(res.body))
        except Exception as err:
            ConsoleClient.log('err!')
            ConsoleClient.log(err.message)
        finally:
            ConsoleClient.log('test end!')

    def test_delete_connection(self) -> None:
        request = sdkclient_models.DeleteConnectionRequest(
            connection_name='new-connection'
        )
        try:
            res = self._sdk_client.delete_connection(request)
            ConsoleClient.log(UtilClient.to_jsonstring(res.body))
        except Exception as err:
            ConsoleClient.log('err!')
            ConsoleClient.log(err.message)
        finally:
            ConsoleClient.log('test end!')

    async def test_delete_connection_async(self) -> None:
        request = sdkclient_models.DeleteConnectionRequest(
            connection_name='new-connection'
        )
        try:
            res = await self._sdk_client.delete_connection_async(request)
            ConsoleClient.log(UtilClient.to_jsonstring(res.body))
        except Exception as err:
            ConsoleClient.log('err!')
            ConsoleClient.log(err.message)
        finally:
            ConsoleClient.log('test end!')

    def test_update_connection(self) -> None:
        request = sdkclient_models.UpdateConnectionRequest(
            connection_name='new-connection',
            network_parameters=sdkclient_models.UpdateConnectionRequestNetworkParameters(
                network_type='PrivateNetwork',
                security_group_id='eb-167adad548759-security_grop/sg-bp1addad26peuh9qh9rtyb',
                vpc_id='eb-test/vpc-bp1symadadwnwgmqud',
                vswitche_id='vsw-bp1iu4x7aeradadown1og8,vsw-bp193sqmadadlaszpeqbt2c'
            )
        )
        try:
            res = self._sdk_client.update_connection(request)
            ConsoleClient.log(UtilClient.to_jsonstring(res.body))
        except Exception as err:
            ConsoleClient.log('err!')
            ConsoleClient.log(err.message)
        finally:
            ConsoleClient.log('test end!')

    async def test_update_connection_async(self) -> None:
        request = sdkclient_models.UpdateConnectionRequest(
            connection_name='new-connection',
            network_parameters=sdkclient_models.UpdateConnectionRequestNetworkParameters(
                network_type='PrivateNetwork',
                security_group_id='eb-167adad548759-security_grop/sg-bp1addad26peuh9qh9rtyb',
                vpc_id='eb-test/vpc-bp1symadadwnwgmqud',
                vswitche_id='vsw-bp1iu4x7aeradadown1og8,vsw-bp193sqmadadlaszpeqbt2c'
            )
        )
        try:
            res = await self._sdk_client.update_connection_async(request)
            ConsoleClient.log(UtilClient.to_jsonstring(res.body))
        except Exception as err:
            ConsoleClient.log('err!')
            ConsoleClient.log(err.message)
        finally:
            ConsoleClient.log('test end!')

    def test_get_connections(self) -> None:
        request = sdkclient_models.GetConnectionRequest(
            connection_name='new-connection'
        )
        try:
            res = self._sdk_client.get_connection(request)
            ConsoleClient.log(UtilClient.to_jsonstring(res.body))
        except Exception as err:
            ConsoleClient.log('err!')
            ConsoleClient.log(err.message)
        finally:
            ConsoleClient.log('test end!')

    async def test_get_connections_async(self) -> None:
        request = sdkclient_models.GetConnectionRequest(
            connection_name='new-connection'
        )
        try:
            res = await self._sdk_client.get_connection_async(request)
            ConsoleClient.log(UtilClient.to_jsonstring(res.body))
        except Exception as err:
            ConsoleClient.log('err!')
            ConsoleClient.log(err.message)
        finally:
            ConsoleClient.log('test end!')

    def test_select_one_connection(self) -> None:
        request = sdkclient_models.GetConnectionRequest(
            connection_name='new-connection'
        )
        try:
            res = self._sdk_client.select_one_connection(request)
            ConsoleClient.log(UtilClient.to_jsonstring(res.body))
        except Exception as err:
            ConsoleClient.log('err!')
            ConsoleClient.log(err.message)
        finally:
            ConsoleClient.log('test end!')

    async def test_select_one_connection_async(self) -> None:
        request = sdkclient_models.GetConnectionRequest(
            connection_name='new-connection'
        )
        try:
            res = await self._sdk_client.select_one_connection_async(request)
            ConsoleClient.log(UtilClient.to_jsonstring(res.body))
        except Exception as err:
            ConsoleClient.log('err!')
            ConsoleClient.log(err.message)
        finally:
            ConsoleClient.log('test end!')

    def test_list_connections(self) -> None:
        request = sdkclient_models.ListConnectionsRequest(
            max_results=2
        )
        try:
            res = self._sdk_client.list_connections(request)
            ConsoleClient.log(UtilClient.to_jsonstring(res.body))
        except Exception as err:
            ConsoleClient.log('err!')
            ConsoleClient.log(err.message)
        finally:
            ConsoleClient.log('test end!')

    async def test_list_connections_async(self) -> None:
        request = sdkclient_models.ListConnectionsRequest(
            max_results=2
        )
        try:
            res = await self._sdk_client.list_connections_async(request)
            ConsoleClient.log(UtilClient.to_jsonstring(res.body))
        except Exception as err:
            ConsoleClient.log('err!')
            ConsoleClient.log(err.message)
        finally:
            ConsoleClient.log('test end!')

    def test_list_enums_response(self) -> None:
        try:
            res = self._sdk_client.list_enums_response()
            ConsoleClient.log(UtilClient.to_jsonstring(res.body))
        except Exception as err:
            ConsoleClient.log('err!')
            ConsoleClient.log(err.message)
        finally:
            ConsoleClient.log('test end!')

    async def test_list_enums_response_async(self) -> None:
        try:
            res = await self._sdk_client.list_enums_response_async()
            ConsoleClient.log(UtilClient.to_jsonstring(res.body))
        except Exception as err:
            ConsoleClient.log('err!')
            ConsoleClient.log(err.message)
        finally:
            ConsoleClient.log('test end!')
demo = Demo()
demo.test_list_connections()
