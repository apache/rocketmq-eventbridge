<?php

// This file is auto-generated, don't edit it. Thanks.
namespace RocketMQ\Eventbridge\SDK\Models;

use AlibabaCloud\Tea\Model;

class CreateConnectionResponseBody extends Model {
    protected $_name = [
        'code' => 'code',
        'connectionName' => 'connectionName',
        'message' => 'message',
        'requestId' => 'requestId',
    ];
    public function validate() {}
    public function toMap() {
        $res = [];
        if (null !== $this->code) {
            $res['code'] = $this->code;
        }
        if (null !== $this->connectionName) {
            $res['connectionName'] = $this->connectionName;
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
     * @return CreateConnectionResponseBody
     */
    public static function fromMap($map = []) {
        $model = new self();
        if(isset($map['code'])){
            $model->code = $map['code'];
        }
        if(isset($map['connectionName'])){
            $model->connectionName = $map['connectionName'];
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
     * @description The connection name.
     * @example connection-demo
     * @var string
     */
    public $connectionName;

    /**
     * @description The returned message. If the request is successful, success is returned. If the request failed, an error code is returned.
     * @example success
     * @var string
     */
    public $message;

    /**
     * @description The request ID.
     * @example 7DA60DED-CD36-5837-B848-C01A23D2****
     * @var string
     */
    public $requestId;

}
