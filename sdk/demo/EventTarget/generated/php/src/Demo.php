<?php

// This file is auto-generated, don't edit it. Thanks.
namespace RocketMQ\Eventbridge\SDK\Demo;

use RocketMQ\Eventbridge\SDK\SDKClient;
use AlibabaCloud\Tea\Utils\Utils;
use AlibabaCloud\Tea\Console\Console;
use \Exception;
use AlibabaCloud\Tea\Exception\TeaError;

use Darabonba\OpenApi\Models\Config;
use RocketMQ\Eventbridge\SDK\Models\CreateEventTargetsRequest;
use RocketMQ\Eventbridge\SDK\Models\EventTarget;
use RocketMQ\Eventbridge\SDK\Models\EventTarget\runOptions;
use RocketMQ\Eventbridge\SDK\Models\EventTarget\runOptions\retryStrategy;
use RocketMQ\Eventbridge\SDK\Models\EventTarget\runOptions\deadLetterQueue;
use RocketMQ\Eventbridge\SDK\Models\UpdateEventTargetsRequest;
use RocketMQ\Eventbridge\SDK\Models\DeleteEventTargetsRequest;
use RocketMQ\Eventbridge\SDK\Models\ListEventTargetsRequest;

class Demo {
    protected $_sdkClient;

    protected $_endpoint;

    public function __construct(){
        $this->_endpoint = "127.0.0.1:7001";
        $config = new Config([
            "endpoint" => $this->_endpoint
        ]);
        $this->_sdkClient = new SDKClient($config);
    }

    /**
     * EventTarget Controller apis:
     *     * createEventTargets *
     *     * updateEventTargets *
     *     * deleteEventTargets *
     *     * listEventTargets   *
     * @return void
     */
    public function testCreateEventTargets(){
        $config_ = [
            "fileName" => "~/Target",
            "line" => "{    \"form\":\"JSONPATH\",    \"value\":\"\$.data\"}"
        ];
        $config2_ = [
            "fileName" => "~/Target222",
            "line" => "{    \"form\":\"JSONPATH\",    \"value\":\"\$.data\"}"
        ];
        $request = new CreateEventTargetsRequest([
            "eventBusName" => "newBus",
            "eventRuleName" => "newRule",
            "eventTargets" => [
                new EventTarget([
                    "eventTargetName" => "newTarget",
                    "className" => "file",
                    "config" => $config_,
                    "runOptions" => new runOptions([
                        "errorsTolerance" => "",
                        "retryStrategy" => new retryStrategy([
                            "pushRetryStrategy" => "",
                            "maximumEventAgeInSeconds" => 100,
                            "maximumRetryAttempts" => 100
                        ]),
                        "deadLetterQueue" => new deadLetterQueue([
                            "type" => ""
                        ])
                    ])
                ]),
                new EventTarget([
                    "eventTargetName" => "newTarget222",
                    "className" => "file",
                    "config" => $config2_,
                    "runOptions" => new runOptions([
                        "errorsTolerance" => "",
                        "retryStrategy" => new retryStrategy([
                            "pushRetryStrategy" => "",
                            "maximumEventAgeInSeconds" => 100,
                            "maximumRetryAttempts" => 100
                        ]),
                        "deadLetterQueue" => new deadLetterQueue([
                            "type" => ""
                        ])
                    ])
                ])
            ]
        ]);
        try {
            $res = $this->_sdkClient->createEventTargets($request);
            Console::log(Utils::toJSONString($res->body));
        }
        catch (Exception $err) {
            if (!($err instanceof TeaError)) {
                $err = new TeaError([], $err->getMessage(), $err->getCode(), $err);
            }
            Console::log("err!");
            Console::log($err->message);
        }
        finally {
            Console::log("test end!");
        }
    }

    /**
     * @return void
     */
    public function testUpdateEventTargets(){
        $config_ = [
            "fileName" => "~/Target",
            "line" => "{    \"form\":\"JSONPATH\",    \"value\":\"\$.data\"}"
        ];
        $config2_ = [
            "fileName" => "~/Target222",
            "line" => "{    \"form\":\"JSONPATH\",    \"value\":\"\$.data\"}"
        ];
        $request = new UpdateEventTargetsRequest([
            "eventBusName" => "newBus",
            "eventRuleName" => "newRule",
            "eventTargets" => [
                new EventTarget([
                    "eventTargetName" => "newTarget",
                    "className" => "file",
                    "config" => $config_
                ]),
                new EventTarget([
                    "eventTargetName" => "newTarget222",
                    "className" => "file",
                    "config" => $config2_
                ])
            ]
        ]);
        try {
            $res = $this->_sdkClient->updateEventTargets($request);
            Console::log(Utils::toJSONString($res->body));
        }
        catch (Exception $err) {
            if (!($err instanceof TeaError)) {
                $err = new TeaError([], $err->getMessage(), $err->getCode(), $err);
            }
            Console::log("err!");
            Console::log($err->message);
        }
        finally {
            Console::log("test end!");
        }
    }

    /**
     * @return void
     */
    public function testDeleteEventTargets(){
        $request = new DeleteEventTargetsRequest([
            "eventBusName" => "newBus",
            "eventRuleName" => "newRule",
            "eventTargetNames" => [
                "newTarget",
                "newTarget222"
            ]
        ]);
        try {
            $res = $this->_sdkClient->deleteEventTargets($request);
            Console::log(Utils::toJSONString($res->body));
        }
        catch (Exception $err) {
            if (!($err instanceof TeaError)) {
                $err = new TeaError([], $err->getMessage(), $err->getCode(), $err);
            }
            Console::log("err!");
            Console::log($err->message);
        }
        finally {
            Console::log("test end!");
        }
    }

    /**
     * @return void
     */
    public function testListEventTargets(){
        $request = new ListEventTargetsRequest([
            "eventBusName" => "newBus",
            "eventRuleName" => "newRule"
        ]);
        try {
            $res = $this->_sdkClient->listEventTargets($request);
            Console::log(Utils::toJSONString($res->body));
        }
        catch (Exception $err) {
            if (!($err instanceof TeaError)) {
                $err = new TeaError([], $err->getMessage(), $err->getCode(), $err);
            }
            Console::log("err!");
            Console::log($err->message);
        }
        finally {
            Console::log("test end!");
        }
    }
}
