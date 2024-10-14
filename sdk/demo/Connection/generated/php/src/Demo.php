<?php

// This file is auto-generated, don't edit it. Thanks.
namespace RocketMQ\Eventbridge\SDK\Demo;

use RocketMQ\Eventbridge\SDK\SDKClient;
use AlibabaCloud\Tea\Utils\Utils;
use AlibabaCloud\Tea\Console\Console;
use \Exception;
use AlibabaCloud\Tea\Exception\TeaError;

use Darabonba\OpenApi\Models\Config;
use RocketMQ\Eventbridge\SDK\Models\CreateConnectionRequest;
use RocketMQ\Eventbridge\SDK\Models\CreateConnectionRequest\networkParameters;
use RocketMQ\Eventbridge\SDK\Models\DeleteConnectionRequest;
use RocketMQ\Eventbridge\SDK\Models\UpdateConnectionRequest;
use RocketMQ\Eventbridge\SDK\Models\GetConnectionRequest;
use RocketMQ\Eventbridge\SDK\Models\ListConnectionsRequest;

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
     * test func for Connection Controller apis:
     *     * createConnection    *
     *     * deleteConnection    *
     *     * updateConnection    *
     *     * getConnection       *
     *     * selectOneConnection *
     *     * listConnections     *
     *     * listEnumsResponse   *
     * @return void
     */
    public function testCreateConnection(){
        $request = new CreateConnectionRequest([
            "connectionName" => "new-connection",
            "networkParameters" => new networkParameters([
                "networkType" => "PublicNetwork"
            ])
        ]);
        try {
            $res = $this->_sdkClient->createConnection($request);
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
    public function testDeleteConnection(){
        $request = new DeleteConnectionRequest([
            "connectionName" => "new-connection"
        ]);
        try {
            $res = $this->_sdkClient->deleteConnection($request);
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
    public function testUpdateConnection(){
        $request = new UpdateConnectionRequest([
            "connectionName" => "new-connection",
            "networkParameters" => new \RocketMQ\Eventbridge\SDK\Models\UpdateConnectionRequest\networkParameters([
                "networkType" => "PrivateNetwork",
                "securityGroupId" => "eb-167adad548759-security_grop/sg-bp1addad26peuh9qh9rtyb",
                "vpcId" => "eb-test/vpc-bp1symadadwnwgmqud",
                "vswitcheId" => "vsw-bp1iu4x7aeradadown1og8,vsw-bp193sqmadadlaszpeqbt2c"
            ])
        ]);
        try {
            $res = $this->_sdkClient->updateConnection($request);
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
    public function testGetConnections(){
        $request = new GetConnectionRequest([
            "connectionName" => "new-connection"
        ]);
        try {
            $res = $this->_sdkClient->getConnection($request);
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
    public function testSelectOneConnection(){
        $request = new GetConnectionRequest([
            "connectionName" => "new-connection"
        ]);
        try {
            $res = $this->_sdkClient->selectOneConnection($request);
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
    public function testListConnections(){
        $request = new ListConnectionsRequest([
            "maxResults" => 2
        ]);
        try {
            $res = $this->_sdkClient->listConnections($request);
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
    public function testListEnumsResponse(){
        try {
            $res = $this->_sdkClient->listEnumsResponse();
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
