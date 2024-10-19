<?php

// This file is auto-generated, don't edit it. Thanks.
namespace RocketMQ\Eventbridge\SDK\Models;

use AlibabaCloud\Tea\Model;

use RocketMQ\Eventbridge\SDK\Models\GetConnectionResponseBody\connections;

class GetConnectionResponseBody extends Model {
    protected $_name = [
        'code' => 'code',
        'connections' => 'connections',
        'message' => 'message',
        'requestId' => 'requestId',
    ];
    public function validate() {}
    public function toMap() {
        $res = [];
        if (null !== $this->code) {
            $res['code'] = $this->code;
        }
        if (null !== $this->connections) {
            $res['connections'] = [];
            if(null !== $this->connections && is_array($this->connections)){
                $n = 0;
                foreach($this->connections as $item){
                    $res['connections'][$n++] = null !== $item ? $item->toMap() : $item;
                }
            }
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
     * @return GetConnectionResponseBody
     */
    public static function fromMap($map = []) {
        $model = new self();
        if(isset($map['code'])){
            $model->code = $map['code'];
        }
        if(isset($map['connections'])){
            if(!empty($map['connections'])){
                $model->connections = [];
                $n = 0;
                foreach($map['connections'] as $item) {
                    $model->connections[$n++] = null !== $item ? connections::fromMap($item) : $item;
                }
            }
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
     * @description The value of the key in the request path.
     * @var connections[]
     */
    public $connections;

    /**
     * @description The returned message.
     * @example success
     * @var string
     */
    public $message;

    /**
     * @description The returned request ID.
     * @example 34AD682D-5B91-5773-8132-AA38C130****
     * @var string
     */
    public $requestId;

}
