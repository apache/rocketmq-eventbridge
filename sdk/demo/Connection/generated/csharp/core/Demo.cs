// This file is auto-generated, don't edit it. Thanks.

using System;
using System.Collections;
using System.Collections.Generic;
using System.IO;
using System.Threading.Tasks;

using Tea;
using Tea.Utils;


namespace RocketMQ.Eventbridge.Demo
{
    public class Demo 
    {
        protected RocketMQ.Eventbridge.SDK.SDKClient _sdkClient;
        protected string _endpoint;

        public Demo()
        {
            this._endpoint = "127.0.0.1:7001";
            AlibabaCloud.OpenApiClient.Models.Config config = new AlibabaCloud.OpenApiClient.Models.Config
            {
                Endpoint = _endpoint,
            };
            this._sdkClient = new RocketMQ.Eventbridge.SDK.SDKClient(config);
        }

        static void Main(string[] _args){
            Demo demo = new Demo();
            demo.TestListConnections();
        }

        /// <term><b>Description:</b></term>
        /// <description>
        /// <para>test func for Connection Controller apis:
        /// createConnection    *
        /// deleteConnection    *
        /// updateConnection    *
        /// getConnection       *
        /// selectOneConnection *
        /// listConnections     *
        /// listEnumsResponse   *</para>
        /// </description>
        public void TestCreateConnection()
        {
            RocketMQ.Eventbridge.SDK.Models.CreateConnectionRequest request = new RocketMQ.Eventbridge.SDK.Models.CreateConnectionRequest
            {
                ConnectionName = "new-connection",
                NetworkParameters = new RocketMQ.Eventbridge.SDK.Models.CreateConnectionRequest.CreateConnectionRequestNetworkParameters
                {
                    NetworkType = "PublicNetwork",
                },
            };
            try
            {
                RocketMQ.Eventbridge.SDK.Models.CreateConnectionResponse res = this._sdkClient.CreateConnection(request);
                AlibabaCloud.TeaConsole.Client.Log(AlibabaCloud.TeaUtil.Common.ToJSONString(res.Body));
            }
            catch (TeaException err)
            {
                AlibabaCloud.TeaConsole.Client.Log("err!");
                AlibabaCloud.TeaConsole.Client.Log(err.Message);
            }
            catch (Exception _err)
            {
                TeaException err = new TeaException(new Dictionary<string, object>
                {
                    { "message", _err.Message }
                });
                AlibabaCloud.TeaConsole.Client.Log("err!");
                AlibabaCloud.TeaConsole.Client.Log(err.Message);
            }
            finally
            {
                AlibabaCloud.TeaConsole.Client.Log("test end!");
            }
        }

        /// <term><b>Description:</b></term>
        /// <description>
        /// <para>test func for Connection Controller apis:
        /// createConnection    *
        /// deleteConnection    *
        /// updateConnection    *
        /// getConnection       *
        /// selectOneConnection *
        /// listConnections     *
        /// listEnumsResponse   *</para>
        /// </description>
        public async Task TestCreateConnectionAsync()
        {
            RocketMQ.Eventbridge.SDK.Models.CreateConnectionRequest request = new RocketMQ.Eventbridge.SDK.Models.CreateConnectionRequest
            {
                ConnectionName = "new-connection",
                NetworkParameters = new RocketMQ.Eventbridge.SDK.Models.CreateConnectionRequest.CreateConnectionRequestNetworkParameters
                {
                    NetworkType = "PublicNetwork",
                },
            };
            try
            {
                RocketMQ.Eventbridge.SDK.Models.CreateConnectionResponse res = await this._sdkClient.CreateConnectionAsync(request);
                AlibabaCloud.TeaConsole.Client.Log(AlibabaCloud.TeaUtil.Common.ToJSONString(res.Body));
            }
            catch (TeaException err)
            {
                AlibabaCloud.TeaConsole.Client.Log("err!");
                AlibabaCloud.TeaConsole.Client.Log(err.Message);
            }
            catch (Exception _err)
            {
                TeaException err = new TeaException(new Dictionary<string, object>
                {
                    { "message", _err.Message }
                });
                AlibabaCloud.TeaConsole.Client.Log("err!");
                AlibabaCloud.TeaConsole.Client.Log(err.Message);
            }
            finally
            {
                AlibabaCloud.TeaConsole.Client.Log("test end!");
            }
        }

        public void TestDeleteConnection()
        {
            RocketMQ.Eventbridge.SDK.Models.DeleteConnectionRequest request = new RocketMQ.Eventbridge.SDK.Models.DeleteConnectionRequest
            {
                ConnectionName = "new-connection",
            };
            try
            {
                RocketMQ.Eventbridge.SDK.Models.DeleteConnectionResponse res = this._sdkClient.DeleteConnection(request);
                AlibabaCloud.TeaConsole.Client.Log(AlibabaCloud.TeaUtil.Common.ToJSONString(res.Body));
            }
            catch (TeaException err)
            {
                AlibabaCloud.TeaConsole.Client.Log("err!");
                AlibabaCloud.TeaConsole.Client.Log(err.Message);
            }
            catch (Exception _err)
            {
                TeaException err = new TeaException(new Dictionary<string, object>
                {
                    { "message", _err.Message }
                });
                AlibabaCloud.TeaConsole.Client.Log("err!");
                AlibabaCloud.TeaConsole.Client.Log(err.Message);
            }
            finally
            {
                AlibabaCloud.TeaConsole.Client.Log("test end!");
            }
        }

        public async Task TestDeleteConnectionAsync()
        {
            RocketMQ.Eventbridge.SDK.Models.DeleteConnectionRequest request = new RocketMQ.Eventbridge.SDK.Models.DeleteConnectionRequest
            {
                ConnectionName = "new-connection",
            };
            try
            {
                RocketMQ.Eventbridge.SDK.Models.DeleteConnectionResponse res = await this._sdkClient.DeleteConnectionAsync(request);
                AlibabaCloud.TeaConsole.Client.Log(AlibabaCloud.TeaUtil.Common.ToJSONString(res.Body));
            }
            catch (TeaException err)
            {
                AlibabaCloud.TeaConsole.Client.Log("err!");
                AlibabaCloud.TeaConsole.Client.Log(err.Message);
            }
            catch (Exception _err)
            {
                TeaException err = new TeaException(new Dictionary<string, object>
                {
                    { "message", _err.Message }
                });
                AlibabaCloud.TeaConsole.Client.Log("err!");
                AlibabaCloud.TeaConsole.Client.Log(err.Message);
            }
            finally
            {
                AlibabaCloud.TeaConsole.Client.Log("test end!");
            }
        }

        public void TestUpdateConnection()
        {
            RocketMQ.Eventbridge.SDK.Models.UpdateConnectionRequest request = new RocketMQ.Eventbridge.SDK.Models.UpdateConnectionRequest
            {
                ConnectionName = "new-connection",
                NetworkParameters = new RocketMQ.Eventbridge.SDK.Models.UpdateConnectionRequest.UpdateConnectionRequestNetworkParameters
                {
                    NetworkType = "PrivateNetwork",
                    SecurityGroupId = "eb-167adad548759-security_grop/sg-bp1addad26peuh9qh9rtyb",
                    VpcId = "eb-test/vpc-bp1symadadwnwgmqud",
                    VswitcheId = "vsw-bp1iu4x7aeradadown1og8,vsw-bp193sqmadadlaszpeqbt2c",
                },
            };
            try
            {
                RocketMQ.Eventbridge.SDK.Models.UpdateConnectionResponse res = this._sdkClient.UpdateConnection(request);
                AlibabaCloud.TeaConsole.Client.Log(AlibabaCloud.TeaUtil.Common.ToJSONString(res.Body));
            }
            catch (TeaException err)
            {
                AlibabaCloud.TeaConsole.Client.Log("err!");
                AlibabaCloud.TeaConsole.Client.Log(err.Message);
            }
            catch (Exception _err)
            {
                TeaException err = new TeaException(new Dictionary<string, object>
                {
                    { "message", _err.Message }
                });
                AlibabaCloud.TeaConsole.Client.Log("err!");
                AlibabaCloud.TeaConsole.Client.Log(err.Message);
            }
            finally
            {
                AlibabaCloud.TeaConsole.Client.Log("test end!");
            }
        }

        public async Task TestUpdateConnectionAsync()
        {
            RocketMQ.Eventbridge.SDK.Models.UpdateConnectionRequest request = new RocketMQ.Eventbridge.SDK.Models.UpdateConnectionRequest
            {
                ConnectionName = "new-connection",
                NetworkParameters = new RocketMQ.Eventbridge.SDK.Models.UpdateConnectionRequest.UpdateConnectionRequestNetworkParameters
                {
                    NetworkType = "PrivateNetwork",
                    SecurityGroupId = "eb-167adad548759-security_grop/sg-bp1addad26peuh9qh9rtyb",
                    VpcId = "eb-test/vpc-bp1symadadwnwgmqud",
                    VswitcheId = "vsw-bp1iu4x7aeradadown1og8,vsw-bp193sqmadadlaszpeqbt2c",
                },
            };
            try
            {
                RocketMQ.Eventbridge.SDK.Models.UpdateConnectionResponse res = await this._sdkClient.UpdateConnectionAsync(request);
                AlibabaCloud.TeaConsole.Client.Log(AlibabaCloud.TeaUtil.Common.ToJSONString(res.Body));
            }
            catch (TeaException err)
            {
                AlibabaCloud.TeaConsole.Client.Log("err!");
                AlibabaCloud.TeaConsole.Client.Log(err.Message);
            }
            catch (Exception _err)
            {
                TeaException err = new TeaException(new Dictionary<string, object>
                {
                    { "message", _err.Message }
                });
                AlibabaCloud.TeaConsole.Client.Log("err!");
                AlibabaCloud.TeaConsole.Client.Log(err.Message);
            }
            finally
            {
                AlibabaCloud.TeaConsole.Client.Log("test end!");
            }
        }

        public void TestGetConnections()
        {
            RocketMQ.Eventbridge.SDK.Models.GetConnectionRequest request = new RocketMQ.Eventbridge.SDK.Models.GetConnectionRequest
            {
                ConnectionName = "new-connection",
            };
            try
            {
                RocketMQ.Eventbridge.SDK.Models.GetConnectionResponse res = this._sdkClient.GetConnection(request);
                AlibabaCloud.TeaConsole.Client.Log(AlibabaCloud.TeaUtil.Common.ToJSONString(res.Body));
            }
            catch (TeaException err)
            {
                AlibabaCloud.TeaConsole.Client.Log("err!");
                AlibabaCloud.TeaConsole.Client.Log(err.Message);
            }
            catch (Exception _err)
            {
                TeaException err = new TeaException(new Dictionary<string, object>
                {
                    { "message", _err.Message }
                });
                AlibabaCloud.TeaConsole.Client.Log("err!");
                AlibabaCloud.TeaConsole.Client.Log(err.Message);
            }
            finally
            {
                AlibabaCloud.TeaConsole.Client.Log("test end!");
            }
        }

        public async Task TestGetConnectionsAsync()
        {
            RocketMQ.Eventbridge.SDK.Models.GetConnectionRequest request = new RocketMQ.Eventbridge.SDK.Models.GetConnectionRequest
            {
                ConnectionName = "new-connection",
            };
            try
            {
                RocketMQ.Eventbridge.SDK.Models.GetConnectionResponse res = await this._sdkClient.GetConnectionAsync(request);
                AlibabaCloud.TeaConsole.Client.Log(AlibabaCloud.TeaUtil.Common.ToJSONString(res.Body));
            }
            catch (TeaException err)
            {
                AlibabaCloud.TeaConsole.Client.Log("err!");
                AlibabaCloud.TeaConsole.Client.Log(err.Message);
            }
            catch (Exception _err)
            {
                TeaException err = new TeaException(new Dictionary<string, object>
                {
                    { "message", _err.Message }
                });
                AlibabaCloud.TeaConsole.Client.Log("err!");
                AlibabaCloud.TeaConsole.Client.Log(err.Message);
            }
            finally
            {
                AlibabaCloud.TeaConsole.Client.Log("test end!");
            }
        }

        public void TestSelectOneConnection()
        {
            RocketMQ.Eventbridge.SDK.Models.GetConnectionRequest request = new RocketMQ.Eventbridge.SDK.Models.GetConnectionRequest
            {
                ConnectionName = "new-connection",
            };
            try
            {
                RocketMQ.Eventbridge.SDK.Models.GetConnectionResponse res = this._sdkClient.SelectOneConnection(request);
                AlibabaCloud.TeaConsole.Client.Log(AlibabaCloud.TeaUtil.Common.ToJSONString(res.Body));
            }
            catch (TeaException err)
            {
                AlibabaCloud.TeaConsole.Client.Log("err!");
                AlibabaCloud.TeaConsole.Client.Log(err.Message);
            }
            catch (Exception _err)
            {
                TeaException err = new TeaException(new Dictionary<string, object>
                {
                    { "message", _err.Message }
                });
                AlibabaCloud.TeaConsole.Client.Log("err!");
                AlibabaCloud.TeaConsole.Client.Log(err.Message);
            }
            finally
            {
                AlibabaCloud.TeaConsole.Client.Log("test end!");
            }
        }

        public async Task TestSelectOneConnectionAsync()
        {
            RocketMQ.Eventbridge.SDK.Models.GetConnectionRequest request = new RocketMQ.Eventbridge.SDK.Models.GetConnectionRequest
            {
                ConnectionName = "new-connection",
            };
            try
            {
                RocketMQ.Eventbridge.SDK.Models.GetConnectionResponse res = await this._sdkClient.SelectOneConnectionAsync(request);
                AlibabaCloud.TeaConsole.Client.Log(AlibabaCloud.TeaUtil.Common.ToJSONString(res.Body));
            }
            catch (TeaException err)
            {
                AlibabaCloud.TeaConsole.Client.Log("err!");
                AlibabaCloud.TeaConsole.Client.Log(err.Message);
            }
            catch (Exception _err)
            {
                TeaException err = new TeaException(new Dictionary<string, object>
                {
                    { "message", _err.Message }
                });
                AlibabaCloud.TeaConsole.Client.Log("err!");
                AlibabaCloud.TeaConsole.Client.Log(err.Message);
            }
            finally
            {
                AlibabaCloud.TeaConsole.Client.Log("test end!");
            }
        }

        public void TestListConnections()
        {
            RocketMQ.Eventbridge.SDK.Models.ListConnectionsRequest request = new RocketMQ.Eventbridge.SDK.Models.ListConnectionsRequest
            {
                MaxResults = 2,
            };
            try
            {
                RocketMQ.Eventbridge.SDK.Models.ListConnectionsResponse res = this._sdkClient.ListConnections(request);
                AlibabaCloud.TeaConsole.Client.Log(AlibabaCloud.TeaUtil.Common.ToJSONString(res.Body));
            }
            catch (TeaException err)
            {
                AlibabaCloud.TeaConsole.Client.Log("err!");
                AlibabaCloud.TeaConsole.Client.Log(err.Message);
            }
            catch (Exception _err)
            {
                TeaException err = new TeaException(new Dictionary<string, object>
                {
                    { "message", _err.Message }
                });
                AlibabaCloud.TeaConsole.Client.Log("err!");
                AlibabaCloud.TeaConsole.Client.Log(err.Message);
            }
            finally
            {
                AlibabaCloud.TeaConsole.Client.Log("test end!");
            }
        }

        public async Task TestListConnectionsAsync()
        {
            RocketMQ.Eventbridge.SDK.Models.ListConnectionsRequest request = new RocketMQ.Eventbridge.SDK.Models.ListConnectionsRequest
            {
                MaxResults = 2,
            };
            try
            {
                RocketMQ.Eventbridge.SDK.Models.ListConnectionsResponse res = await this._sdkClient.ListConnectionsAsync(request);
                AlibabaCloud.TeaConsole.Client.Log(AlibabaCloud.TeaUtil.Common.ToJSONString(res.Body));
            }
            catch (TeaException err)
            {
                AlibabaCloud.TeaConsole.Client.Log("err!");
                AlibabaCloud.TeaConsole.Client.Log(err.Message);
            }
            catch (Exception _err)
            {
                TeaException err = new TeaException(new Dictionary<string, object>
                {
                    { "message", _err.Message }
                });
                AlibabaCloud.TeaConsole.Client.Log("err!");
                AlibabaCloud.TeaConsole.Client.Log(err.Message);
            }
            finally
            {
                AlibabaCloud.TeaConsole.Client.Log("test end!");
            }
        }

        public void TestListEnumsResponse()
        {
            try
            {
                RocketMQ.Eventbridge.SDK.Models.ListEnumsResponseResponse res = this._sdkClient.ListEnumsResponse();
                AlibabaCloud.TeaConsole.Client.Log(AlibabaCloud.TeaUtil.Common.ToJSONString(res.Body));
            }
            catch (TeaException err)
            {
                AlibabaCloud.TeaConsole.Client.Log("err!");
                AlibabaCloud.TeaConsole.Client.Log(err.Message);
            }
            catch (Exception _err)
            {
                TeaException err = new TeaException(new Dictionary<string, object>
                {
                    { "message", _err.Message }
                });
                AlibabaCloud.TeaConsole.Client.Log("err!");
                AlibabaCloud.TeaConsole.Client.Log(err.Message);
            }
            finally
            {
                AlibabaCloud.TeaConsole.Client.Log("test end!");
            }
        }

        public async Task TestListEnumsResponseAsync()
        {
            try
            {
                RocketMQ.Eventbridge.SDK.Models.ListEnumsResponseResponse res = await this._sdkClient.ListEnumsResponseAsync();
                AlibabaCloud.TeaConsole.Client.Log(AlibabaCloud.TeaUtil.Common.ToJSONString(res.Body));
            }
            catch (TeaException err)
            {
                AlibabaCloud.TeaConsole.Client.Log("err!");
                AlibabaCloud.TeaConsole.Client.Log(err.Message);
            }
            catch (Exception _err)
            {
                TeaException err = new TeaException(new Dictionary<string, object>
                {
                    { "message", _err.Message }
                });
                AlibabaCloud.TeaConsole.Client.Log("err!");
                AlibabaCloud.TeaConsole.Client.Log(err.Message);
            }
            finally
            {
                AlibabaCloud.TeaConsole.Client.Log("test end!");
            }
        }

    }
}
