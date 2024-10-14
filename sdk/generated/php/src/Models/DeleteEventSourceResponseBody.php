<?php

// This file is auto-generated, don't edit it. Thanks.
namespace RocketMQ\Eventbridge\SDK\Models;

use AlibabaCloud\Tea\Model;

class DeleteEventSourceResponseBody extends Model {
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
     * @return DeleteEventSourceResponseBody
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
     * @description The returned response code. The value Success indicates that the request is successful. Other values indicate that the request failed. For more information about error codes, see Error codes.
     * @example Success
     * @var string
     */
    public $code;

    /**
     * @description The returned error message.
     * @example Remote error. requestId: [78B66E68-E778-1F33-84BD-xxxx], error code: [EventSourceNotExist], message: [The event source in request is not exist! ]
     * @var string
     */
    public $message;

    /**
     * @description The request ID.
     * @example 5f80e9b3-98d5-4f51-8412-c758818a03e4
     * @var string
     */
    public $requestId;

}
