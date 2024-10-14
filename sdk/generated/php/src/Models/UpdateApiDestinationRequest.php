<?php

// This file is auto-generated, don't edit it. Thanks.
namespace RocketMQ\Eventbridge\SDK\Models;

use AlibabaCloud\Tea\Model;

use RocketMQ\Eventbridge\SDK\Models\UpdateApiDestinationRequest\httpApiParameters;

class UpdateApiDestinationRequest extends Model {
    protected $_name = [
        'apiDestinationName' => 'apiDestinationName',
        'connectionName' => 'connectionName',
        'description' => 'description',
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
     * @return UpdateApiDestinationRequest
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
        if(isset($map['httpApiParameters'])){
            $model->httpApiParameters = httpApiParameters::fromMap($map['httpApiParameters']);
        }
        if(isset($map['invocationRateLimitPerSecond'])){
            $model->invocationRateLimitPerSecond = $map['invocationRateLimitPerSecond'];
        }
        return $model;
    }
    /**
     * @description The name of the API destination. The name must be 2 to 127 characters in length. This parameter is required.
     * @example api-destination-name
     * @var string
     */
    public $apiDestinationName;

    /**
     * @description The name of the connection. The name must be 2 to 127 characters in length. Before you configure this parameter, you must call the CreateConnection operation to create a connection. Then, set this parameter to the name of the connection that you created. This parameter is required.
     * @example connection-name
     * @var string
     */
    public $connectionName;

    /**
     * @description The description of the API destination. The description can be up to 255 characters in length.
     * @var string
     */
    public $description;

    /**
     * @description The parameters that are configured for the API destination. This parameter is required.
     * @var httpApiParameters
     */
    public $httpApiParameters;

    /**
     * @description TODO
     * @var int
     */
    public $invocationRateLimitPerSecond;

}
