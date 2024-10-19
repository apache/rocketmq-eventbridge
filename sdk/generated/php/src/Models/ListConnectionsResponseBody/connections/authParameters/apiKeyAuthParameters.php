<?php

// This file is auto-generated, don't edit it. Thanks.
namespace RocketMQ\Eventbridge\SDK\Models\ListConnectionsResponseBody\connections\authParameters;

use AlibabaCloud\Tea\Model;

class apiKeyAuthParameters extends Model {
    protected $_name = [
        'apiKeyName' => 'apiKeyName',
        'apiKeyValue' => 'apiKeyValue',
    ];
    public function validate() {}
    public function toMap() {
        $res = [];
        if (null !== $this->apiKeyName) {
            $res['apiKeyName'] = $this->apiKeyName;
        }
        if (null !== $this->apiKeyValue) {
            $res['apiKeyValue'] = $this->apiKeyValue;
        }
        return $res;
    }
    /**
     * @param array $map
     * @return apiKeyAuthParameters
     */
    public static function fromMap($map = []) {
        $model = new self();
        if(isset($map['apiKeyName'])){
            $model->apiKeyName = $map['apiKeyName'];
        }
        if(isset($map['apiKeyValue'])){
            $model->apiKeyValue = $map['apiKeyValue'];
        }
        return $model;
    }
    /**
     * @description The API key.
     * @example Token
     * @var string
     */
    public $apiKeyName;

    /**
     * @description The value of the API key.
     * @example asdkjnqkwejooa
     * @var string
     */
    public $apiKeyValue;

}
