<?php

// This file is auto-generated, don't edit it. Thanks.
namespace RocketMQ\Eventbridge\SDK\Models;

use AlibabaCloud\Tea\Model;

class DeleteApiDestinationRequest extends Model {
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
     * @return DeleteApiDestinationRequest
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
     * @example ApiDestinationName
     * @var string
     */
    public $apiDestinationName;

}
