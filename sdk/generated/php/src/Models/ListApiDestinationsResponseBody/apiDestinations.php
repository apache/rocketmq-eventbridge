<?php

// This file is auto-generated, don't edit it. Thanks.
namespace RocketMQ\Eventbridge\SDK\Models\ListApiDestinationsResponseBody;

use AlibabaCloud\Tea\Model;

use RocketMQ\Eventbridge\SDK\Models\ListApiDestinationsResponseBody\apiDestinations\httpApiParameters;

class apiDestinations extends Model {
    protected $_name = [
        'apiDestinationName' => 'apiDestinationName',
        'connectionName' => 'connectionName',
        'description' => 'description',
        'gmtCreate' => 'gmtCreate',
        'httpApiParameters' => 'httpApiParameters',
        'invocationRateLimitPerSecond' => 'invocationRateLimitPerSecond',
    ];
    public function validate() {}
    public function toMap() {
        $res = [];
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
        return $res;
    }
    /**
     * @param array $map
     * @return apiDestinations
     */
    public static function fromMap($map = []) {
        $model = new self();
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
        return $model;
    }
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

}
