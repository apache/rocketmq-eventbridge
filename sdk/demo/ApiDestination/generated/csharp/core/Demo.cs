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
            demo.TestListApiDestinations();
        }

        /// <term><b>Description:</b></term>
        /// <description>
        /// <para>ApiDestination Controller apis:
        /// createApiDestination *
        /// updateApiDestination *
        /// getApiDestination    *
        /// deleteApiDestination *
        /// listApiDestinations  *</para>
        /// </description>
        public void TestCreateApiDestination()
        {
            RocketMQ.Eventbridge.SDK.Models.CreateApiDestinationRequest request = new RocketMQ.Eventbridge.SDK.Models.CreateApiDestinationRequest
            {
                ApiDestinationName = "new-api-destination",
                ConnectionName = "new-connection",
                Description = "demo api destination for test",
                HttpApiParameters = new RocketMQ.Eventbridge.SDK.Models.CreateApiDestinationRequest.CreateApiDestinationRequestHttpApiParameters
                {
                    Endpoint = _endpoint,
                    Method = "POST",
                },
            };
            try
            {
                RocketMQ.Eventbridge.SDK.Models.CreateApiDestinationResponse res = this._sdkClient.CreateApiDestination(request);
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
        /// <para>ApiDestination Controller apis:
        /// createApiDestination *
        /// updateApiDestination *
        /// getApiDestination    *
        /// deleteApiDestination *
        /// listApiDestinations  *</para>
        /// </description>
        public async Task TestCreateApiDestinationAsync()
        {
            RocketMQ.Eventbridge.SDK.Models.CreateApiDestinationRequest request = new RocketMQ.Eventbridge.SDK.Models.CreateApiDestinationRequest
            {
                ApiDestinationName = "new-api-destination",
                ConnectionName = "new-connection",
                Description = "demo api destination for test",
                HttpApiParameters = new RocketMQ.Eventbridge.SDK.Models.CreateApiDestinationRequest.CreateApiDestinationRequestHttpApiParameters
                {
                    Endpoint = _endpoint,
                    Method = "POST",
                },
            };
            try
            {
                RocketMQ.Eventbridge.SDK.Models.CreateApiDestinationResponse res = await this._sdkClient.CreateApiDestinationAsync(request);
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

        public void TestUpdateApiDestination()
        {
            RocketMQ.Eventbridge.SDK.Models.UpdateApiDestinationRequest request = new RocketMQ.Eventbridge.SDK.Models.UpdateApiDestinationRequest
            {
                ApiDestinationName = "new-api-destination",
                ConnectionName = "new-connection",
                Description = "!updated! demo api destination for test",
                HttpApiParameters = new RocketMQ.Eventbridge.SDK.Models.UpdateApiDestinationRequest.UpdateApiDestinationRequestHttpApiParameters
                {
                    Endpoint = _endpoint,
                    Method = "GET",
                },
            };
            try
            {
                RocketMQ.Eventbridge.SDK.Models.UpdateApiDestinationResponse res = this._sdkClient.UpdateApiDestination(request);
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

        public async Task TestUpdateApiDestinationAsync()
        {
            RocketMQ.Eventbridge.SDK.Models.UpdateApiDestinationRequest request = new RocketMQ.Eventbridge.SDK.Models.UpdateApiDestinationRequest
            {
                ApiDestinationName = "new-api-destination",
                ConnectionName = "new-connection",
                Description = "!updated! demo api destination for test",
                HttpApiParameters = new RocketMQ.Eventbridge.SDK.Models.UpdateApiDestinationRequest.UpdateApiDestinationRequestHttpApiParameters
                {
                    Endpoint = _endpoint,
                    Method = "GET",
                },
            };
            try
            {
                RocketMQ.Eventbridge.SDK.Models.UpdateApiDestinationResponse res = await this._sdkClient.UpdateApiDestinationAsync(request);
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

        public void TestGetApiDestination()
        {
            RocketMQ.Eventbridge.SDK.Models.GetApiDestinationRequest request = new RocketMQ.Eventbridge.SDK.Models.GetApiDestinationRequest
            {
                ApiDestinationName = "new-api-destination",
            };
            try
            {
                RocketMQ.Eventbridge.SDK.Models.GetApiDestinationResponse res = this._sdkClient.GetApiDestination(request);
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

        public async Task TestGetApiDestinationAsync()
        {
            RocketMQ.Eventbridge.SDK.Models.GetApiDestinationRequest request = new RocketMQ.Eventbridge.SDK.Models.GetApiDestinationRequest
            {
                ApiDestinationName = "new-api-destination",
            };
            try
            {
                RocketMQ.Eventbridge.SDK.Models.GetApiDestinationResponse res = await this._sdkClient.GetApiDestinationAsync(request);
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

        public void TestDeleteApiDestination()
        {
            RocketMQ.Eventbridge.SDK.Models.DeleteApiDestinationRequest request = new RocketMQ.Eventbridge.SDK.Models.DeleteApiDestinationRequest
            {
                ApiDestinationName = "new-api-destination",
            };
            try
            {
                RocketMQ.Eventbridge.SDK.Models.DeleteApiDestinationResponse res = this._sdkClient.DeleteApiDestination(request);
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

        public async Task TestDeleteApiDestinationAsync()
        {
            RocketMQ.Eventbridge.SDK.Models.DeleteApiDestinationRequest request = new RocketMQ.Eventbridge.SDK.Models.DeleteApiDestinationRequest
            {
                ApiDestinationName = "new-api-destination",
            };
            try
            {
                RocketMQ.Eventbridge.SDK.Models.DeleteApiDestinationResponse res = await this._sdkClient.DeleteApiDestinationAsync(request);
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

        public void TestListApiDestinations()
        {
            RocketMQ.Eventbridge.SDK.Models.ListApiDestinationsRequest request = new RocketMQ.Eventbridge.SDK.Models.ListApiDestinationsRequest
            {
                MaxResults = 2,
            };
            try
            {
                RocketMQ.Eventbridge.SDK.Models.ListApiDestinationsResponse res = this._sdkClient.ListApiDestinations(request);
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

        public async Task TestListApiDestinationsAsync()
        {
            RocketMQ.Eventbridge.SDK.Models.ListApiDestinationsRequest request = new RocketMQ.Eventbridge.SDK.Models.ListApiDestinationsRequest
            {
                MaxResults = 2,
            };
            try
            {
                RocketMQ.Eventbridge.SDK.Models.ListApiDestinationsResponse res = await this._sdkClient.ListApiDestinationsAsync(request);
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
