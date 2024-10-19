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
            demo.TestListEventRules();
        }

        /// <term><b>Description:</b></term>
        /// <description>
        /// <para>EventRule Controller apis:
        /// createEventRule  *
        /// getEventRule     *
        /// deleteEventRule  *
        /// updateEventRule  *
        /// listEventRules   *
        /// enableEventRule  *
        /// disableEventRule *</para>
        /// </description>
        public void TestCreateEventRule()
        {
            RocketMQ.Eventbridge.SDK.Models.CreateEventRuleRequest request = new RocketMQ.Eventbridge.SDK.Models.CreateEventRuleRequest
            {
                EventBusName = "newBus",
                EventRuleName = "newRule",
                Description = "an event rule for test",
                FilterPattern = "{}",
            };
            try
            {
                RocketMQ.Eventbridge.SDK.Models.CreateEventRuleResponse res = this._sdkClient.CreateEventRule(request);
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
        /// <para>EventRule Controller apis:
        /// createEventRule  *
        /// getEventRule     *
        /// deleteEventRule  *
        /// updateEventRule  *
        /// listEventRules   *
        /// enableEventRule  *
        /// disableEventRule *</para>
        /// </description>
        public async Task TestCreateEventRuleAsync()
        {
            RocketMQ.Eventbridge.SDK.Models.CreateEventRuleRequest request = new RocketMQ.Eventbridge.SDK.Models.CreateEventRuleRequest
            {
                EventBusName = "newBus",
                EventRuleName = "newRule",
                Description = "an event rule for test",
                FilterPattern = "{}",
            };
            try
            {
                RocketMQ.Eventbridge.SDK.Models.CreateEventRuleResponse res = await this._sdkClient.CreateEventRuleAsync(request);
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

        public void TestGetEventRule()
        {
            RocketMQ.Eventbridge.SDK.Models.GetEventRuleRequest request = new RocketMQ.Eventbridge.SDK.Models.GetEventRuleRequest
            {
                EventBusName = "newBus",
                EventRuleName = "newRule",
            };
            try
            {
                RocketMQ.Eventbridge.SDK.Models.GetEventRuleResponse res = this._sdkClient.GetEventRule(request);
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

        public async Task TestGetEventRuleAsync()
        {
            RocketMQ.Eventbridge.SDK.Models.GetEventRuleRequest request = new RocketMQ.Eventbridge.SDK.Models.GetEventRuleRequest
            {
                EventBusName = "newBus",
                EventRuleName = "newRule",
            };
            try
            {
                RocketMQ.Eventbridge.SDK.Models.GetEventRuleResponse res = await this._sdkClient.GetEventRuleAsync(request);
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

        public void TestDeleteEventRule()
        {
            RocketMQ.Eventbridge.SDK.Models.DeleteEventRuleRequest request = new RocketMQ.Eventbridge.SDK.Models.DeleteEventRuleRequest
            {
                EventBusName = "newBus",
                EventRuleName = "newRule",
            };
            try
            {
                RocketMQ.Eventbridge.SDK.Models.DeleteEventRuleResponse res = this._sdkClient.DeleteEventRule(request);
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

        public async Task TestDeleteEventRuleAsync()
        {
            RocketMQ.Eventbridge.SDK.Models.DeleteEventRuleRequest request = new RocketMQ.Eventbridge.SDK.Models.DeleteEventRuleRequest
            {
                EventBusName = "newBus",
                EventRuleName = "newRule",
            };
            try
            {
                RocketMQ.Eventbridge.SDK.Models.DeleteEventRuleResponse res = await this._sdkClient.DeleteEventRuleAsync(request);
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

        public void TestUpdateEventRule()
        {
            RocketMQ.Eventbridge.SDK.Models.UpdateEventRuleRequest request = new RocketMQ.Eventbridge.SDK.Models.UpdateEventRuleRequest
            {
                EventBusName = "newBus",
                EventRuleName = "newRule",
                Description = "new description for testing update API",
                FilterPattern = "{}",
            };
            try
            {
                RocketMQ.Eventbridge.SDK.Models.UpdateEventRuleResponse res = this._sdkClient.UpdateEventRule(request);
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

        public async Task TestUpdateEventRuleAsync()
        {
            RocketMQ.Eventbridge.SDK.Models.UpdateEventRuleRequest request = new RocketMQ.Eventbridge.SDK.Models.UpdateEventRuleRequest
            {
                EventBusName = "newBus",
                EventRuleName = "newRule",
                Description = "new description for testing update API",
                FilterPattern = "{}",
            };
            try
            {
                RocketMQ.Eventbridge.SDK.Models.UpdateEventRuleResponse res = await this._sdkClient.UpdateEventRuleAsync(request);
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

        public void TestListEventRules()
        {
            RocketMQ.Eventbridge.SDK.Models.ListEventRulesRequest request = new RocketMQ.Eventbridge.SDK.Models.ListEventRulesRequest
            {
                EventBusName = "newBus",
                MaxResults = 2,
                NextToken = "0",
            };
            try
            {
                RocketMQ.Eventbridge.SDK.Models.ListEventRulesResponse res = this._sdkClient.ListEventRules(request);
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

        public async Task TestListEventRulesAsync()
        {
            RocketMQ.Eventbridge.SDK.Models.ListEventRulesRequest request = new RocketMQ.Eventbridge.SDK.Models.ListEventRulesRequest
            {
                EventBusName = "newBus",
                MaxResults = 2,
                NextToken = "0",
            };
            try
            {
                RocketMQ.Eventbridge.SDK.Models.ListEventRulesResponse res = await this._sdkClient.ListEventRulesAsync(request);
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

        public void TestEnableEventRule()
        {
            RocketMQ.Eventbridge.SDK.Models.EnableEventRuleRequest request = new RocketMQ.Eventbridge.SDK.Models.EnableEventRuleRequest
            {
                EventBusName = "newBus",
                EventRuleName = "newRule",
            };
            try
            {
                RocketMQ.Eventbridge.SDK.Models.EnableEventRuleResponse res = this._sdkClient.EnableEventRule(request);
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

        public async Task TestEnableEventRuleAsync()
        {
            RocketMQ.Eventbridge.SDK.Models.EnableEventRuleRequest request = new RocketMQ.Eventbridge.SDK.Models.EnableEventRuleRequest
            {
                EventBusName = "newBus",
                EventRuleName = "newRule",
            };
            try
            {
                RocketMQ.Eventbridge.SDK.Models.EnableEventRuleResponse res = await this._sdkClient.EnableEventRuleAsync(request);
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

        public void TestDisableEventRule()
        {
            RocketMQ.Eventbridge.SDK.Models.DisableEventRuleRequest request = new RocketMQ.Eventbridge.SDK.Models.DisableEventRuleRequest
            {
                EventBusName = "newBus",
                EventRuleName = "newRule",
            };
            try
            {
                RocketMQ.Eventbridge.SDK.Models.DisableEventRuleResponse res = this._sdkClient.DisableEventRule(request);
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

        public async Task TestDisableEventRuleAsync()
        {
            RocketMQ.Eventbridge.SDK.Models.DisableEventRuleRequest request = new RocketMQ.Eventbridge.SDK.Models.DisableEventRuleRequest
            {
                EventBusName = "newBus",
                EventRuleName = "newRule",
            };
            try
            {
                RocketMQ.Eventbridge.SDK.Models.DisableEventRuleResponse res = await this._sdkClient.DisableEventRuleAsync(request);
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
