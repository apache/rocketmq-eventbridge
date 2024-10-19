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
            demo.TestListEventBuses();
        }

        /// <term><b>Description:</b></term>
        /// <description>
        /// <para>test func for EventBus Controller apis:
        /// createEventBus *
        /// getEventBus    *
        /// deleteEventBus *
        /// listEventBuses *</para>
        /// </description>
        public void TestCreateEventBus()
        {
            RocketMQ.Eventbridge.SDK.Models.CreateEventBusRequest request = new RocketMQ.Eventbridge.SDK.Models.CreateEventBusRequest
            {
                EventBusName = "newBus",
            };
            try
            {
                RocketMQ.Eventbridge.SDK.Models.CreateEventBusResponse res = this._sdkClient.CreateEventBus(request);
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
        /// <para>test func for EventBus Controller apis:
        /// createEventBus *
        /// getEventBus    *
        /// deleteEventBus *
        /// listEventBuses *</para>
        /// </description>
        public async Task TestCreateEventBusAsync()
        {
            RocketMQ.Eventbridge.SDK.Models.CreateEventBusRequest request = new RocketMQ.Eventbridge.SDK.Models.CreateEventBusRequest
            {
                EventBusName = "newBus",
            };
            try
            {
                RocketMQ.Eventbridge.SDK.Models.CreateEventBusResponse res = await this._sdkClient.CreateEventBusAsync(request);
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

        public void TestDeleteEventBus()
        {
            RocketMQ.Eventbridge.SDK.Models.DeleteEventBusRequest request = new RocketMQ.Eventbridge.SDK.Models.DeleteEventBusRequest
            {
                EventBusName = "newBus",
            };
            try
            {
                RocketMQ.Eventbridge.SDK.Models.DeleteEventBusResponse res = this._sdkClient.DeleteEventBus(request);
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

        public async Task TestDeleteEventBusAsync()
        {
            RocketMQ.Eventbridge.SDK.Models.DeleteEventBusRequest request = new RocketMQ.Eventbridge.SDK.Models.DeleteEventBusRequest
            {
                EventBusName = "newBus",
            };
            try
            {
                RocketMQ.Eventbridge.SDK.Models.DeleteEventBusResponse res = await this._sdkClient.DeleteEventBusAsync(request);
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

        public void TestGetEventBus()
        {
            RocketMQ.Eventbridge.SDK.Models.GetEventBusRequest request = new RocketMQ.Eventbridge.SDK.Models.GetEventBusRequest
            {
                EventBusName = "newBus",
            };
            try
            {
                RocketMQ.Eventbridge.SDK.Models.GetEventBusResponse res = this._sdkClient.GetEventBus(request);
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

        public async Task TestGetEventBusAsync()
        {
            RocketMQ.Eventbridge.SDK.Models.GetEventBusRequest request = new RocketMQ.Eventbridge.SDK.Models.GetEventBusRequest
            {
                EventBusName = "newBus",
            };
            try
            {
                RocketMQ.Eventbridge.SDK.Models.GetEventBusResponse res = await this._sdkClient.GetEventBusAsync(request);
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

        public void TestListEventBuses()
        {
            RocketMQ.Eventbridge.SDK.Models.ListEventBusesRequest request = new RocketMQ.Eventbridge.SDK.Models.ListEventBusesRequest
            {
                MaxResults = 2,
            };
            try
            {
                RocketMQ.Eventbridge.SDK.Models.ListEventBusesResponse res = this._sdkClient.ListEventBuses(request);
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

        public async Task TestListEventBusesAsync()
        {
            RocketMQ.Eventbridge.SDK.Models.ListEventBusesRequest request = new RocketMQ.Eventbridge.SDK.Models.ListEventBusesRequest
            {
                MaxResults = 2,
            };
            try
            {
                RocketMQ.Eventbridge.SDK.Models.ListEventBusesResponse res = await this._sdkClient.ListEventBusesAsync(request);
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
