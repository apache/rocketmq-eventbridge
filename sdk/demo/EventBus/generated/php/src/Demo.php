<?php

// This file is auto-generated, don't edit it. Thanks.
namespace RocketMQ\Eventbridge\SDK\Demo;

use RocketMQ\Eventbridge\SDK\SDKClient;
use AlibabaCloud\Tea\Utils\Utils;
use AlibabaCloud\Tea\Console\Console;
use \Exception;
use AlibabaCloud\Tea\Exception\TeaError;

use Darabonba\OpenApi\Models\Config;
use RocketMQ\Eventbridge\SDK\Models\CreateEventBusRequest;
use RocketMQ\Eventbridge\SDK\Models\DeleteEventBusRequest;
use RocketMQ\Eventbridge\SDK\Models\GetEventBusRequest;
use RocketMQ\Eventbridge\SDK\Models\ListEventBusesRequest;

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
     * test func for EventBus Controller apis:
     *     * createEventBus *
     *     * getEventBus    *
     *     * deleteEventBus *
     *     * listEventBuses *
     * @return void
     */
    public function testCreateEventBus(){
        $request = new CreateEventBusRequest([
            "eventBusName" => "newBus"
        ]);
        try {
            $res = $this->_sdkClient->createEventBus($request);
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
    public function testDeleteEventBus(){
        $request = new DeleteEventBusRequest([
            "eventBusName" => "newBus"
        ]);
        try {
            $res = $this->_sdkClient->deleteEventBus($request);
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
    public function testGetEventBus(){
        $request = new GetEventBusRequest([
            "eventBusName" => "newBus"
        ]);
        try {
            $res = $this->_sdkClient->getEventBus($request);
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
    public function testListEventBuses(){
        $request = new ListEventBusesRequest([
            "maxResults" => 2
        ]);
        try {
            $res = $this->_sdkClient->listEventBuses($request);
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
