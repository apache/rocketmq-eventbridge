<?php

// This file is auto-generated, don't edit it. Thanks.
namespace RocketMQ\Eventbridge\SDK\Models;

use AlibabaCloud\Tea\Model;

use RocketMQ\Eventbridge\SDK\Models\UpdateConnectionRequest\authParameters;
use RocketMQ\Eventbridge\SDK\Models\UpdateConnectionRequest\networkParameters;

class UpdateConnectionRequest extends Model {
    protected $_name = [
        'authParameters' => 'authParameters',
        'connectionName' => 'connectionName',
        'description' => 'description',
        'networkParameters' => 'networkParameters',
    ];
    public function validate() {}
    public function toMap() {
        $res = [];
        if (null !== $this->authParameters) {
            $res['authParameters'] = null !== $this->authParameters ? $this->authParameters->toMap() : null;
        }
        if (null !== $this->connectionName) {
            $res['connectionName'] = $this->connectionName;
        }
        if (null !== $this->description) {
            $res['description'] = $this->description;
        }
        if (null !== $this->networkParameters) {
            $res['networkParameters'] = null !== $this->networkParameters ? $this->networkParameters->toMap() : null;
        }
        return $res;
    }
    /**
     * @param array $map
     * @return UpdateConnectionRequest
     */
    public static function fromMap($map = []) {
        $model = new self();
        if(isset($map['authParameters'])){
            $model->authParameters = authParameters::fromMap($map['authParameters']);
        }
        if(isset($map['connectionName'])){
            $model->connectionName = $map['connectionName'];
        }
        if(isset($map['description'])){
            $model->description = $map['description'];
        }
        if(isset($map['networkParameters'])){
            $model->networkParameters = networkParameters::fromMap($map['networkParameters']);
        }
        return $model;
    }
    /**
     * @description The parameters that are configured for authentication.
     * @var authParameters
     */
    public $authParameters;

    /**
     * @description The name of the connection. The name must be 2 to 127 characters in length.

    This parameter is required.
     * @example connection-name
     * @var string
     */
    public $connectionName;

    /**
     * @description The description of the connection. The description can be up to 255 characters in length.
     * @example demo
     * @var string
     */
    public $description;

    /**
     * @description The parameters that are configured for the network. This parameter is required.
     * @var networkParameters
     */
    public $networkParameters;

}
