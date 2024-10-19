<?php

// This file is auto-generated, don't edit it. Thanks.
namespace RocketMQ\Eventbridge\SDK\Demo;

use RocketMQ\Eventbridge\SDK\SDKClient;
use AlibabaCloud\Tea\Utils\Utils;
use AlibabaCloud\Tea\Console\Console;
use \Exception;
use AlibabaCloud\Tea\Exception\TeaError;

use Darabonba\OpenApi\Models\Config;
use RocketMQ\Eventbridge\SDK\Models\CreateEventRuleRequest;
use RocketMQ\Eventbridge\SDK\Models\GetEventRuleRequest;
use RocketMQ\Eventbridge\SDK\Models\DeleteEventRuleRequest;
use RocketMQ\Eventbridge\SDK\Models\UpdateEventRuleRequest;
use RocketMQ\Eventbridge\SDK\Models\ListEventRulesRequest;
use RocketMQ\Eventbridge\SDK\Models\EnableEventRuleRequest;
use RocketMQ\Eventbridge\SDK\Models\DisableEventRuleRequest;

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
     * EventRule Controller apis:
     *     * createEventRule  *
     *     * getEventRule     *
     *     * deleteEventRule  *
     *     * updateEventRule  *
     *     * listEventRules   *
     *     * enableEventRule  *
     *     * disableEventRule *
     * @return void
     */
    public function testCreateEventRule(){
        $request = new CreateEventRuleRequest([
            "eventBusName" => "newBus",
            "eventRuleName" => "newRule",
            "description" => "an event rule for test",
            "filterPattern" => "{}"
        ]);
        try {
            $res = $this->_sdkClient->createEventRule($request);
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
    public function testGetEventRule(){
        $request = new GetEventRuleRequest([
            "eventBusName" => "newBus",
            "eventRuleName" => "newRule"
        ]);
        try {
            $res = $this->_sdkClient->getEventRule($request);
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
    public function testDeleteEventRule(){
        $request = new DeleteEventRuleRequest([
            "eventBusName" => "newBus",
            "eventRuleName" => "newRule"
        ]);
        try {
            $res = $this->_sdkClient->deleteEventRule($request);
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
    public function testUpdateEventRule(){
        $request = new UpdateEventRuleRequest([
            "eventBusName" => "newBus",
            "eventRuleName" => "newRule",
            "description" => "new description for testing update API",
            "filterPattern" => "{}"
        ]);
        try {
            $res = $this->_sdkClient->updateEventRule($request);
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
    public function testListEventRules(){
        $request = new ListEventRulesRequest([
            "eventBusName" => "newBus",
            "maxResults" => 2,
            "nextToken" => "0"
        ]);
        try {
            $res = $this->_sdkClient->listEventRules($request);
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
    public function testEnableEventRule(){
        $request = new EnableEventRuleRequest([
            "eventBusName" => "newBus",
            "eventRuleName" => "newRule"
        ]);
        try {
            $res = $this->_sdkClient->enableEventRule($request);
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
    public function testDisableEventRule(){
        $request = new DisableEventRuleRequest([
            "eventBusName" => "newBus",
            "eventRuleName" => "newRule"
        ]);
        try {
            $res = $this->_sdkClient->disableEventRule($request);
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
