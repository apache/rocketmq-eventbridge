<?php

// This file is auto-generated, don't edit it. Thanks.
namespace RocketMQ\Eventbridge\SDK\Demo;

use RocketMQ\Eventbridge\SDK\SDKClient;
use AlibabaCloud\Tea\Utils\Utils;
use AlibabaCloud\Tea\Console\Console;
use \Exception;
use AlibabaCloud\Tea\Exception\TeaError;

use Darabonba\OpenApi\Models\Config;
use RocketMQ\Eventbridge\SDK\Models\CreateEventSourceRequest;
use RocketMQ\Eventbridge\SDK\Models\UpdateEventSourceRequest;
use RocketMQ\Eventbridge\SDK\Models\DeleteEventSourceRequest;
use RocketMQ\Eventbridge\SDK\Models\GetEventSourceRequest;
use RocketMQ\Eventbridge\SDK\Models\ListEventSourcesRequest;

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
     * EventSource Controller apis:
     *     * createEventSource *
     *     * updateEventSource *
     *     * deleteEventSource *
     *     * getEventSource    *
     *     * listEventSources  *
     * @return void
     */
    public function testCreateEventSource(){
        $request = new CreateEventSourceRequest([
            "eventBusName" => "newBus",
            "eventSourceName" => "newSource",
            "description" => "a source for test"
        ]);
        try {
            $res = $this->_sdkClient->createEventSource($request);
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
    public function testUpdateEventSource(){
        $request = new UpdateEventSourceRequest([
            "eventBusName" => "newBus",
            "eventSourceName" => "newSource",
            "description" => "new description for testing Update API"
        ]);
        try {
            $res = $this->_sdkClient->updateEventSource($request);
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
    public function testDeleteEventSource(){
        $request = new DeleteEventSourceRequest([
            "eventBusName" => "newBus",
            "eventSourceName" => "newSource"
        ]);
        try {
            $res = $this->_sdkClient->deleteEventSource($request);
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
    public function testGetEventSource(){
        $request = new GetEventSourceRequest([
            "eventBusName" => "newBus",
            "eventSourceName" => "newSource"
        ]);
        try {
            $res = $this->_sdkClient->getEventSource($request);
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
    public function testListEventSources(){
        $request = new ListEventSourcesRequest([
            "eventBusName" => "newBus",
            "eventSourceType" => "USER_DEFINED",
            "maxResults" => 10,
            "nextToken" => "0"
        ]);
        try {
            $res = $this->_sdkClient->listEventSources($request);
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
