<?php

// This file is auto-generated, don't edit it. Thanks.
namespace RocketMQ\Eventbridge\SDK\Models\ListConnectionsResponseBody;

use AlibabaCloud\Tea\Model;

use RocketMQ\Eventbridge\SDK\Models\ListConnectionsResponseBody\connections\authParameters;
use RocketMQ\Eventbridge\SDK\Models\ListConnectionsResponseBody\connections\networkParameters;

class connections extends Model {
    protected $_name = [
        'authParameters' => 'authParameters',
        'connectionName' => 'connectionName',
        'description' => 'description',
        'gmtCreate' => 'gmtCreate',
        'id' => 'id',
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
        if (null !== $this->gmtCreate) {
            $res['gmtCreate'] = $this->gmtCreate;
        }
        if (null !== $this->id) {
            $res['id'] = $this->id;
        }
        if (null !== $this->networkParameters) {
            $res['networkParameters'] = null !== $this->networkParameters ? $this->networkParameters->toMap() : null;
        }
        return $res;
    }
    /**
     * @param array $map
     * @return connections
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
        if(isset($map['gmtCreate'])){
            $model->gmtCreate = $map['gmtCreate'];
        }
        if(isset($map['id'])){
            $model->id = $map['id'];
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
     * @description The connection name.
     * @example connection-name
     * @var string
     */
    public $connectionName;

    /**
     * @description The connection description.
     * @example The description of the connection.
     * @var string
     */
    public $description;

    /**
     * @description The time when the connection was created.
     * @example 1592838994234
     * @var int
     */
    public $gmtCreate;

    /**
     * @description The connection ID.
     * @example 1141093
     * @var int
     */
    public $id;

    /**
     * @var networkParameters
     */
    public $networkParameters;

}
