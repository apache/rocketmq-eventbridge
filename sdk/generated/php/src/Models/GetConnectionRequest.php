<?php

// This file is auto-generated, don't edit it. Thanks.
namespace RocketMQ\Eventbridge\SDK\Models;

use AlibabaCloud\Tea\Model;

class GetConnectionRequest extends Model {
    protected $_name = [
        'connectionName' => 'connectionName',
    ];
    public function validate() {}
    public function toMap() {
        $res = [];
        if (null !== $this->connectionName) {
            $res['connectionName'] = $this->connectionName;
        }
        return $res;
    }
    /**
     * @param array $map
     * @return GetConnectionRequest
     */
    public static function fromMap($map = []) {
        $model = new self();
        if(isset($map['connectionName'])){
            $model->connectionName = $map['connectionName'];
        }
        return $model;
    }
    /**
     * @description The connection name. This parameter is required.
     * @example connection-name
     * @var string
     */
    public $connectionName;

}
