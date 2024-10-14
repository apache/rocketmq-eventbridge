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
            demo.TestListEventTargets();
        }

        /// <term><b>Description:</b></term>
        /// <description>
        /// <para>EventTarget Controller apis:
        /// createEventTargets *
        /// updateEventTargets *
        /// deleteEventTargets *
        /// listEventTargets   *</para>
        /// </description>
        public void TestCreateEventTargets()
        {
            Dictionary<string, object> config_ = new Dictionary<string, object>
            {
                {"fileName", "~/Target"},
                {"line", "{    \"form\":\"JSONPATH\",    \"value\":\"$.data\"}"},
            };
            Dictionary<string, object> config2_ = new Dictionary<string, object>
            {
                {"fileName", "~/Target222"},
                {"line", "{    \"form\":\"JSONPATH\",    \"value\":\"$.data\"}"},
            };
            RocketMQ.Eventbridge.SDK.Models.CreateEventTargetsRequest request = new RocketMQ.Eventbridge.SDK.Models.CreateEventTargetsRequest
            {
                EventBusName = "newBus",
                EventRuleName = "newRule",
                EventTargets = new List<RocketMQ.Eventbridge.SDK.Models.EventTarget>
                {
                    new RocketMQ.Eventbridge.SDK.Models.EventTarget
                    {
                        EventTargetName = "newTarget",
                        ClassName = "file",
                        Config = config_,
                        RunOptions = new RocketMQ.Eventbridge.SDK.Models.EventTarget.EventTargetRunOptions
                        {
                            ErrorsTolerance = "",
                            RetryStrategy = new RocketMQ.Eventbridge.SDK.Models.EventTarget.EventTargetRunOptions.EventTargetRunOptionsRetryStrategy
                            {
                                PushRetryStrategy = "",
                                MaximumEventAgeInSeconds = 100,
                                MaximumRetryAttempts = 100,
                            },
                            DeadLetterQueue = new RocketMQ.Eventbridge.SDK.Models.EventTarget.EventTargetRunOptions.EventTargetRunOptionsDeadLetterQueue
                            {
                                Type = "",
                            },
                        },
                    },
                    new RocketMQ.Eventbridge.SDK.Models.EventTarget
                    {
                        EventTargetName = "newTarget222",
                        ClassName = "file",
                        Config = config2_,
                        RunOptions = new RocketMQ.Eventbridge.SDK.Models.EventTarget.EventTargetRunOptions
                        {
                            ErrorsTolerance = "",
                            RetryStrategy = new RocketMQ.Eventbridge.SDK.Models.EventTarget.EventTargetRunOptions.EventTargetRunOptionsRetryStrategy
                            {
                                PushRetryStrategy = "",
                                MaximumEventAgeInSeconds = 100,
                                MaximumRetryAttempts = 100,
                            },
                            DeadLetterQueue = new RocketMQ.Eventbridge.SDK.Models.EventTarget.EventTargetRunOptions.EventTargetRunOptionsDeadLetterQueue
                            {
                                Type = "",
                            },
                        },
                    }
                },
            };
            try
            {
                RocketMQ.Eventbridge.SDK.Models.CreateEventTargetsResponse res = this._sdkClient.CreateEventTargets(request);
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
        /// <para>EventTarget Controller apis:
        /// createEventTargets *
        /// updateEventTargets *
        /// deleteEventTargets *
        /// listEventTargets   *</para>
        /// </description>
        public async Task TestCreateEventTargetsAsync()
        {
            Dictionary<string, object> config_ = new Dictionary<string, object>
            {
                {"fileName", "~/Target"},
                {"line", "{    \"form\":\"JSONPATH\",    \"value\":\"$.data\"}"},
            };
            Dictionary<string, object> config2_ = new Dictionary<string, object>
            {
                {"fileName", "~/Target222"},
                {"line", "{    \"form\":\"JSONPATH\",    \"value\":\"$.data\"}"},
            };
            RocketMQ.Eventbridge.SDK.Models.CreateEventTargetsRequest request = new RocketMQ.Eventbridge.SDK.Models.CreateEventTargetsRequest
            {
                EventBusName = "newBus",
                EventRuleName = "newRule",
                EventTargets = new List<RocketMQ.Eventbridge.SDK.Models.EventTarget>
                {
                    new RocketMQ.Eventbridge.SDK.Models.EventTarget
                    {
                        EventTargetName = "newTarget",
                        ClassName = "file",
                        Config = config_,
                        RunOptions = new RocketMQ.Eventbridge.SDK.Models.EventTarget.EventTargetRunOptions
                        {
                            ErrorsTolerance = "",
                            RetryStrategy = new RocketMQ.Eventbridge.SDK.Models.EventTarget.EventTargetRunOptions.EventTargetRunOptionsRetryStrategy
                            {
                                PushRetryStrategy = "",
                                MaximumEventAgeInSeconds = 100,
                                MaximumRetryAttempts = 100,
                            },
                            DeadLetterQueue = new RocketMQ.Eventbridge.SDK.Models.EventTarget.EventTargetRunOptions.EventTargetRunOptionsDeadLetterQueue
                            {
                                Type = "",
                            },
                        },
                    },
                    new RocketMQ.Eventbridge.SDK.Models.EventTarget
                    {
                        EventTargetName = "newTarget222",
                        ClassName = "file",
                        Config = config2_,
                        RunOptions = new RocketMQ.Eventbridge.SDK.Models.EventTarget.EventTargetRunOptions
                        {
                            ErrorsTolerance = "",
                            RetryStrategy = new RocketMQ.Eventbridge.SDK.Models.EventTarget.EventTargetRunOptions.EventTargetRunOptionsRetryStrategy
                            {
                                PushRetryStrategy = "",
                                MaximumEventAgeInSeconds = 100,
                                MaximumRetryAttempts = 100,
                            },
                            DeadLetterQueue = new RocketMQ.Eventbridge.SDK.Models.EventTarget.EventTargetRunOptions.EventTargetRunOptionsDeadLetterQueue
                            {
                                Type = "",
                            },
                        },
                    }
                },
            };
            try
            {
                RocketMQ.Eventbridge.SDK.Models.CreateEventTargetsResponse res = await this._sdkClient.CreateEventTargetsAsync(request);
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

        public void TestUpdateEventTargets()
        {
            Dictionary<string, object> config_ = new Dictionary<string, object>
            {
                {"fileName", "~/Target"},
                {"line", "{    \"form\":\"JSONPATH\",    \"value\":\"$.data\"}"},
            };
            Dictionary<string, object> config2_ = new Dictionary<string, object>
            {
                {"fileName", "~/Target222"},
                {"line", "{    \"form\":\"JSONPATH\",    \"value\":\"$.data\"}"},
            };
            RocketMQ.Eventbridge.SDK.Models.UpdateEventTargetsRequest request = new RocketMQ.Eventbridge.SDK.Models.UpdateEventTargetsRequest
            {
                EventBusName = "newBus",
                EventRuleName = "newRule",
                EventTargets = new List<RocketMQ.Eventbridge.SDK.Models.EventTarget>
                {
                    new RocketMQ.Eventbridge.SDK.Models.EventTarget
                    {
                        EventTargetName = "newTarget",
                        ClassName = "file",
                        Config = config_,
                    },
                    new RocketMQ.Eventbridge.SDK.Models.EventTarget
                    {
                        EventTargetName = "newTarget222",
                        ClassName = "file",
                        Config = config2_,
                    }
                },
            };
            try
            {
                RocketMQ.Eventbridge.SDK.Models.UpdateEventTargetsResponse res = this._sdkClient.UpdateEventTargets(request);
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

        public async Task TestUpdateEventTargetsAsync()
        {
            Dictionary<string, object> config_ = new Dictionary<string, object>
            {
                {"fileName", "~/Target"},
                {"line", "{    \"form\":\"JSONPATH\",    \"value\":\"$.data\"}"},
            };
            Dictionary<string, object> config2_ = new Dictionary<string, object>
            {
                {"fileName", "~/Target222"},
                {"line", "{    \"form\":\"JSONPATH\",    \"value\":\"$.data\"}"},
            };
            RocketMQ.Eventbridge.SDK.Models.UpdateEventTargetsRequest request = new RocketMQ.Eventbridge.SDK.Models.UpdateEventTargetsRequest
            {
                EventBusName = "newBus",
                EventRuleName = "newRule",
                EventTargets = new List<RocketMQ.Eventbridge.SDK.Models.EventTarget>
                {
                    new RocketMQ.Eventbridge.SDK.Models.EventTarget
                    {
                        EventTargetName = "newTarget",
                        ClassName = "file",
                        Config = config_,
                    },
                    new RocketMQ.Eventbridge.SDK.Models.EventTarget
                    {
                        EventTargetName = "newTarget222",
                        ClassName = "file",
                        Config = config2_,
                    }
                },
            };
            try
            {
                RocketMQ.Eventbridge.SDK.Models.UpdateEventTargetsResponse res = await this._sdkClient.UpdateEventTargetsAsync(request);
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

        public void TestDeleteEventTargets()
        {
            RocketMQ.Eventbridge.SDK.Models.DeleteEventTargetsRequest request = new RocketMQ.Eventbridge.SDK.Models.DeleteEventTargetsRequest
            {
                EventBusName = "newBus",
                EventRuleName = "newRule",
                EventTargetNames = new List<string>
                {
                    "newTarget",
                    "newTarget222"
                },
            };
            try
            {
                RocketMQ.Eventbridge.SDK.Models.DeleteEventTargetsResponse res = this._sdkClient.DeleteEventTargets(request);
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

        public async Task TestDeleteEventTargetsAsync()
        {
            RocketMQ.Eventbridge.SDK.Models.DeleteEventTargetsRequest request = new RocketMQ.Eventbridge.SDK.Models.DeleteEventTargetsRequest
            {
                EventBusName = "newBus",
                EventRuleName = "newRule",
                EventTargetNames = new List<string>
                {
                    "newTarget",
                    "newTarget222"
                },
            };
            try
            {
                RocketMQ.Eventbridge.SDK.Models.DeleteEventTargetsResponse res = await this._sdkClient.DeleteEventTargetsAsync(request);
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

        public void TestListEventTargets()
        {
            RocketMQ.Eventbridge.SDK.Models.ListEventTargetsRequest request = new RocketMQ.Eventbridge.SDK.Models.ListEventTargetsRequest
            {
                EventBusName = "newBus",
                EventRuleName = "newRule",
            };
            try
            {
                RocketMQ.Eventbridge.SDK.Models.ListEventTargetsResponse res = this._sdkClient.ListEventTargets(request);
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

        public async Task TestListEventTargetsAsync()
        {
            RocketMQ.Eventbridge.SDK.Models.ListEventTargetsRequest request = new RocketMQ.Eventbridge.SDK.Models.ListEventTargetsRequest
            {
                EventBusName = "newBus",
                EventRuleName = "newRule",
            };
            try
            {
                RocketMQ.Eventbridge.SDK.Models.ListEventTargetsResponse res = await this._sdkClient.ListEventTargetsAsync(request);
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
