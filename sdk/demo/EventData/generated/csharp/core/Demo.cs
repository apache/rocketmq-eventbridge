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
            demo.TestPutEvents();
        }

        /// <term><b>Description:</b></term>
        /// <description>
        /// <para>EventData Controller apis:
        /// putEvents *</para>
        /// </description>
        public void TestPutEvents()
        {
            RocketMQ.Eventbridge.SDK.Models.PutEventsRequest request = new RocketMQ.Eventbridge.SDK.Models.PutEventsRequest
            {
                EventBusName = "demo-bus",
                Event = "an event for API test",
            };
            try
            {
                RocketMQ.Eventbridge.SDK.Models.PutEventsResponse res = this._sdkClient.PutEvents(request);
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
        /// <para>EventData Controller apis:
        /// putEvents *</para>
        /// </description>
        public async Task TestPutEventsAsync()
        {
            RocketMQ.Eventbridge.SDK.Models.PutEventsRequest request = new RocketMQ.Eventbridge.SDK.Models.PutEventsRequest
            {
                EventBusName = "demo-bus",
                Event = "an event for API test",
            };
            try
            {
                RocketMQ.Eventbridge.SDK.Models.PutEventsResponse res = await this._sdkClient.PutEventsAsync(request);
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
