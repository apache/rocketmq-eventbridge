<?php

// This file is auto-generated, don't edit it. Thanks.
namespace RocketMQ\Eventbridge\SDK\Models;

use AlibabaCloud\Tea\Model;

class GetApiDestinationRequest extends Model {
    protected $_name = [
        'apiDestinationName' => 'apiDestinationName',
    ];
    public function validate() {}
    public function toMap() {
        $res = [];
        if (null !== $this->apiDestinationName) {
            $res['apiDestinationName'] = $this->apiDestinationName;
        }
        return $res;
    }
    /**
     * @param array $map
     * @return GetApiDestinationRequest
     */
    public static function fromMap($map = []) {
        $model = new self();
        if(isset($map['apiDestinationName'])){
            $model->apiDestinationName = $map['apiDestinationName'];
        }
        return $model;
    }
    /**
     * @description The name of the API destination. This parameter is required.
     * @example api-destination-name
     * @var string
     */
    public $apiDestinationName;

}
