<?php

// This file is auto-generated, don't edit it. Thanks.
namespace RocketMQ\Eventbridge\SDK\Models\ListConnectionsResponseBody\connections\authParameters\oauthParameters\oauthHttpParameters;

use AlibabaCloud\Tea\Model;

class headerParameters extends Model {
    protected $_name = [
        'isValueSecret' => 'isValueSecret',
        'key' => 'key',
        'value' => 'value',
    ];
    public function validate() {}
    public function toMap() {
        $res = [];
        if (null !== $this->isValueSecret) {
            $res['isValueSecret'] = $this->isValueSecret;
        }
        if (null !== $this->key) {
            $res['key'] = $this->key;
        }
        if (null !== $this->value) {
            $res['value'] = $this->value;
        }
        return $res;
    }
    /**
     * @param array $map
     * @return headerParameters
     */
    public static function fromMap($map = []) {
        $model = new self();
        if(isset($map['isValueSecret'])){
            $model->isValueSecret = $map['isValueSecret'];
        }
        if(isset($map['key'])){
            $model->key = $map['key'];
        }
        if(isset($map['value'])){
            $model->value = $map['value'];
        }
        return $model;
    }
    /**
     * @description Indicates whether authentication is enabled.
     * @example false
     * @var string
     */
    public $isValueSecret;

    /**
     * @description The key in the request header.
     * @example name
     * @var string
     */
    public $key;

    /**
     * @description The value of the key in the request header.
     * @example demo
     * @var string
     */
    public $value;

}
