<?php

// This file is auto-generated, don't edit it. Thanks.
namespace RocketMQ\Eventbridge\SDK\Models;

use AlibabaCloud\Tea\Model;

class DeleteConnectionResponseBody extends Model {
    protected $_name = [
        'code' => 'code',
        'message' => 'message',
        'requestId' => 'requestId',
    ];
    public function validate() {}
    public function toMap() {
        $res = [];
        if (null !== $this->code) {
            $res['code'] = $this->code;
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
     * @return DeleteConnectionResponseBody
     */
    public static function fromMap($map = []) {
        $model = new self();
        if(isset($map['code'])){
            $model->code = $map['code'];
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
     * @description The returned message. If the request is successful, success is returned. If the request failed, an error code is returned.
     * @example success
     * @var string
     */
    public $message;

    /**
     * @description The request ID.
     * @example 8EF25E37-1750-5D7A-BA56-F8AE081A69C8
     * @var string
     */
    public $requestId;

}
