<?php

// This file is auto-generated, don't edit it. Thanks.
namespace RocketMQ\Eventbridge\SDK\Models;

use AlibabaCloud\Tea\Model;

class UpdateConnectionResponseBody extends Model {
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
     * @return UpdateConnectionResponseBody
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
     * @description The returned response code.
     * @example Success
     * @var string
     */
    public $code;

    /**
     * @description The returned message.
     * @example success
     * @var string
     */
    public $message;

    /**
     * @description The request ID.
     * @example 8346BE8F-40F3-533D-A0B8-1359C31BD5BA
     * @var string
     */
    public $requestId;

}
