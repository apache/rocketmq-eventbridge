<?php

// This file is auto-generated, don't edit it. Thanks.
namespace RocketMQ\Eventbridge\SDK\Demo;

use RocketMQ\Eventbridge\SDK\SDKClient;
use AlibabaCloud\Tea\Utils\Utils;
use AlibabaCloud\Tea\Console\Console;
use \Exception;
use AlibabaCloud\Tea\Exception\TeaError;

use Darabonba\OpenApi\Models\Config;
use RocketMQ\Eventbridge\SDK\Models\CreateApiDestinationRequest;
use RocketMQ\Eventbridge\SDK\Models\CreateApiDestinationRequest\httpApiParameters;
use RocketMQ\Eventbridge\SDK\Models\UpdateApiDestinationRequest;
use RocketMQ\Eventbridge\SDK\Models\GetApiDestinationRequest;
use RocketMQ\Eventbridge\SDK\Models\DeleteApiDestinationRequest;
use RocketMQ\Eventbridge\SDK\Models\ListApiDestinationsRequest;

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
     * ApiDestination Controller apis:
     *     * createApiDestination *
     *     * updateApiDestination *
     *     * getApiDestination    *
     *     * deleteApiDestination *
     *     * listApiDestinations  *
     * @return void
     */
    public function testCreateApiDestination(){
        $request = new CreateApiDestinationRequest([
            "apiDestinationName" => "new-api-destination",
            "connectionName" => "new-connection",
            "description" => "demo api destination for test",
            "httpApiParameters" => new httpApiParameters([
                "endpoint" => $this->_endpoint,
                "method" => "POST"
            ])
        ]);
        try {
            $res = $this->_sdkClient->createApiDestination($request);
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
    public function testUpdateApiDestination(){
        $request = new UpdateApiDestinationRequest([
            "apiDestinationName" => "new-api-destination",
            "connectionName" => "new-connection",
            "description" => "!updated! demo api destination for test",
            "httpApiParameters" => new \RocketMQ\Eventbridge\SDK\Models\UpdateApiDestinationRequest\httpApiParameters([
                "endpoint" => $this->_endpoint,
                "method" => "GET"
            ])
        ]);
        try {
            $res = $this->_sdkClient->updateApiDestination($request);
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
    public function testGetApiDestination(){
        $request = new GetApiDestinationRequest([
            "apiDestinationName" => "new-api-destination"
        ]);
        try {
            $res = $this->_sdkClient->getApiDestination($request);
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
    public function testDeleteApiDestination(){
        $request = new DeleteApiDestinationRequest([
            "apiDestinationName" => "new-api-destination"
        ]);
        try {
            $res = $this->_sdkClient->deleteApiDestination($request);
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
    public function testListApiDestinations(){
        $request = new ListApiDestinationsRequest([
            "maxResults" => 2
        ]);
        try {
            $res = $this->_sdkClient->listApiDestinations($request);
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
