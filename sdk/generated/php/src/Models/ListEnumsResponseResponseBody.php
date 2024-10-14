<?php

// This file is auto-generated, don't edit it. Thanks.
namespace RocketMQ\Eventbridge\SDK\Models;

use AlibabaCloud\Tea\Model;

class ListEnumsResponseResponseBody extends Model {
    protected $_name = [
        'authorizationTypeEnums' => 'authorizationTypeEnums',
        'networkTypeEnums' => 'networkTypeEnums',
        'code' => 'code',
        'message' => 'message',
        'requestId' => 'requestId',
    ];
    public function validate() {}
    public function toMap() {
        $res = [];
        if (null !== $this->authorizationTypeEnums) {
            $res['authorizationTypeEnums'] = $this->authorizationTypeEnums;
        }
        if (null !== $this->networkTypeEnums) {
            $res['networkTypeEnums'] = $this->networkTypeEnums;
        }
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
     * @return ListEnumsResponseResponseBody
     */
    public static function fromMap($map = []) {
        $model = new self();
        if(isset($map['authorizationTypeEnums'])){
            $model->authorizationTypeEnums = $map['authorizationTypeEnums'];
        }
        if(isset($map['networkTypeEnums'])){
            $model->networkTypeEnums = $map['networkTypeEnums'];
        }
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
     * @var string
     */
    public $authorizationTypeEnums;

    /**
     * @var string
     */
    public $networkTypeEnums;

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
