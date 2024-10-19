<?php

// This file is auto-generated, don't edit it. Thanks.
namespace RocketMQ\Eventbridge\SDK\Models;

use AlibabaCloud\Tea\Model;

use RocketMQ\Eventbridge\SDK\Models\GetApiDestinationResponseBody\httpApiParameters;

class GetApiDestinationResponseBody extends Model {
    protected $_name = [
        'code' => 'code',
        'apiDestinationName' => 'apiDestinationName',
        'connectionName' => 'connectionName',
        'description' => 'description',
        'gmtCreate' => 'gmtCreate',
        'httpApiParameters' => 'httpApiParameters',
        'invocationRateLimitPerSecond' => 'invocationRateLimitPerSecond',
        'message' => 'message',
        'requestId' => 'requestId',
    ];
    public function validate() {}
    public function toMap() {
        $res = [];
        if (null !== $this->code) {
            $res['code'] = $this->code;
        }
        if (null !== $this->apiDestinationName) {
            $res['apiDestinationName'] = $this->apiDestinationName;
        }
        if (null !== $this->connectionName) {
            $res['connectionName'] = $this->connectionName;
        }
        if (null !== $this->description) {
            $res['description'] = $this->description;
        }
        if (null !== $this->gmtCreate) {
            $res['gmtCreate'] = $this->gmtCreate;
        }
        if (null !== $this->httpApiParameters) {
            $res['httpApiParameters'] = null !== $this->httpApiParameters ? $this->httpApiParameters->toMap() : null;
        }
        if (null !== $this->invocationRateLimitPerSecond) {
            $res['invocationRateLimitPerSecond'] = $this->invocationRateLimitPerSecond;
        }
        if (null !== $this->message) {
            $res['message'] = $this->message;
        }
        if (null !== $this->requestId) {
            $res['requestId'] = $this->requestId;
        }
        return $res;
    }
    /**
     * @param array $map
     * @return GetApiDestinationResponseBody
     */
    public static function fromMap($map = []) {
        $model = new self();
        if(isset($map['code'])){
            $model->code = $map['code'];
        }
        if(isset($map['apiDestinationName'])){
            $model->apiDestinationName = $map['apiDestinationName'];
        }
        if(isset($map['connectionName'])){
            $model->connectionName = $map['connectionName'];
        }
        if(isset($map['description'])){
            $model->description = $map['description'];
        }
        if(isset($map['gmtCreate'])){
            $model->gmtCreate = $map['gmtCreate'];
        }
        if(isset($map['httpApiParameters'])){
            $model->httpApiParameters = httpApiParameters::fromMap($map['httpApiParameters']);
        }
        if(isset($map['invocationRateLimitPerSecond'])){
            $model->invocationRateLimitPerSecond = $map['invocationRateLimitPerSecond'];
        }
        if(isset($map['message'])){
            $model->message = $map['message'];
        }
        if(isset($map['requestId'])){
            $model->requestId = $map['requestId'];
        }
        return $model;
    }
    /**
     * @description The returned response code. The value Success indicates that the request is successful.
     * @example Success
     * @var string
     */
    public $code;

    /**
     * @description The name of the API destination.
     * @example api-destination-2
     * @var string
     */
    public $apiDestinationName;

    /**
     * @description The connection name.
     * @example connection-name
     * @var string
     */
    public $connectionName;

    /**
     * @description The description of the connection.
     * @example demo
     * @var string
     */
    public $description;

    /**
     * @description The time when the API destination was created.
     * @example 1665223213000
     * @var int
     */
    public $gmtCreate;

    /**
     * @description The request parameters that are configured for the API destination.
     * @var httpApiParameters
     */
    public $httpApiParameters;

    /**
     * @description TODO
     * @var int
     */
    public $invocationRateLimitPerSecond;

    /**
     * @description The returned message. If the request is successful, success is returned. If the request failed, an error code is returned.
     * @example success
     * @var string
     */
    public $message;

    /**
     * @description The request ID.
     * @example B896B484-F16D-59DE-9E23-DD0E5C361108
     * @var string
     */
    public $requestId;

}
