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
            demo.TestListEventSources();
        }

        /// <term><b>Description:</b></term>
        /// <description>
        /// <para>EventSource Controller apis:
        /// createEventSource *
        /// updateEventSource *
        /// deleteEventSource *
        /// getEventSource    *
        /// listEventSources  *</para>
        /// </description>
        public void TestCreateEventSource()
        {
            RocketMQ.Eventbridge.SDK.Models.CreateEventSourceRequest request = new RocketMQ.Eventbridge.SDK.Models.CreateEventSourceRequest
            {
                EventBusName = "newBus",
                EventSourceName = "newSource",
                Description = "a source for test",
            };
            try
            {
                RocketMQ.Eventbridge.SDK.Models.CreateEventSourceResponse res = this._sdkClient.CreateEventSource(request);
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
        /// <para>EventSource Controller apis:
        /// createEventSource *
        /// updateEventSource *
        /// deleteEventSource *
        /// getEventSource    *
        /// listEventSources  *</para>
        /// </description>
        public async Task TestCreateEventSourceAsync()
        {
            RocketMQ.Eventbridge.SDK.Models.CreateEventSourceRequest request = new RocketMQ.Eventbridge.SDK.Models.CreateEventSourceRequest
            {
                EventBusName = "newBus",
                EventSourceName = "newSource",
                Description = "a source for test",
            };
            try
            {
                RocketMQ.Eventbridge.SDK.Models.CreateEventSourceResponse res = await this._sdkClient.CreateEventSourceAsync(request);
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

        public void TestUpdateEventSource()
        {
            RocketMQ.Eventbridge.SDK.Models.UpdateEventSourceRequest request = new RocketMQ.Eventbridge.SDK.Models.UpdateEventSourceRequest
            {
                EventBusName = "newBus",
                EventSourceName = "newSource",
                Description = "new description for testing Update API",
            };
            try
            {
                RocketMQ.Eventbridge.SDK.Models.UpdateEventSourceResponse res = this._sdkClient.UpdateEventSource(request);
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

        public async Task TestUpdateEventSourceAsync()
        {
            RocketMQ.Eventbridge.SDK.Models.UpdateEventSourceRequest request = new RocketMQ.Eventbridge.SDK.Models.UpdateEventSourceRequest
            {
                EventBusName = "newBus",
                EventSourceName = "newSource",
                Description = "new description for testing Update API",
            };
            try
            {
                RocketMQ.Eventbridge.SDK.Models.UpdateEventSourceResponse res = await this._sdkClient.UpdateEventSourceAsync(request);
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

        public void TestDeleteEventSource()
        {
            RocketMQ.Eventbridge.SDK.Models.DeleteEventSourceRequest request = new RocketMQ.Eventbridge.SDK.Models.DeleteEventSourceRequest
            {
                EventBusName = "newBus",
                EventSourceName = "newSource",
            };
            try
            {
                RocketMQ.Eventbridge.SDK.Models.DeleteEventSourceResponse res = this._sdkClient.DeleteEventSource(request);
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

        public async Task TestDeleteEventSourceAsync()
        {
            RocketMQ.Eventbridge.SDK.Models.DeleteEventSourceRequest request = new RocketMQ.Eventbridge.SDK.Models.DeleteEventSourceRequest
            {
                EventBusName = "newBus",
                EventSourceName = "newSource",
            };
            try
            {
                RocketMQ.Eventbridge.SDK.Models.DeleteEventSourceResponse res = await this._sdkClient.DeleteEventSourceAsync(request);
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

        public void TestGetEventSource()
        {
            RocketMQ.Eventbridge.SDK.Models.GetEventSourceRequest request = new RocketMQ.Eventbridge.SDK.Models.GetEventSourceRequest
            {
                EventBusName = "newBus",
                EventSourceName = "newSource",
            };
            try
            {
                RocketMQ.Eventbridge.SDK.Models.GetEventSourceResponse res = this._sdkClient.GetEventSource(request);
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

        public async Task TestGetEventSourceAsync()
        {
            RocketMQ.Eventbridge.SDK.Models.GetEventSourceRequest request = new RocketMQ.Eventbridge.SDK.Models.GetEventSourceRequest
            {
                EventBusName = "newBus",
                EventSourceName = "newSource",
            };
            try
            {
                RocketMQ.Eventbridge.SDK.Models.GetEventSourceResponse res = await this._sdkClient.GetEventSourceAsync(request);
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

        public void TestListEventSources()
        {
            RocketMQ.Eventbridge.SDK.Models.ListEventSourcesRequest request = new RocketMQ.Eventbridge.SDK.Models.ListEventSourcesRequest
            {
                EventBusName = "newBus",
                EventSourceType = "USER_DEFINED",
                MaxResults = 10,
                NextToken = "0",
            };
            try
            {
                RocketMQ.Eventbridge.SDK.Models.ListEventSourcesResponse res = this._sdkClient.ListEventSources(request);
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

        public async Task TestListEventSourcesAsync()
        {
            RocketMQ.Eventbridge.SDK.Models.ListEventSourcesRequest request = new RocketMQ.Eventbridge.SDK.Models.ListEventSourcesRequest
            {
                EventBusName = "newBus",
                EventSourceType = "USER_DEFINED",
                MaxResults = 10,
                NextToken = "0",
            };
            try
            {
                RocketMQ.Eventbridge.SDK.Models.ListEventSourcesResponse res = await this._sdkClient.ListEventSourcesAsync(request);
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
