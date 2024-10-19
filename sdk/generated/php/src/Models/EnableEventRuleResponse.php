<?php

// This file is auto-generated, don't edit it. Thanks.
namespace RocketMQ\Eventbridge\SDK\Models;

use AlibabaCloud\Tea\Model;

use RocketMQ\Eventbridge\SDK\Models\EnableEventRuleResponseBody;

class EnableEventRuleResponse extends Model {
    protected $_name = [
        'headers' => 'headers',
        'statusCode' => 'statusCode',
        'body' => 'body',
    ];
    public function validate() {}
    public function toMap() {
        $res = [];
        if (null !== $this->headers) {
            $res['headers'] = $this->headers;
        }
        if (null !== $this->statusCode) {
            $res['statusCode'] = $this->statusCode;
        }
        if (null !== $this->body) {
            $res['body'] = null !== $this->body ? $this->body->toMap() : null;
        }
        return $res;
    }
    /**
     * @param array $map
     * @return EnableEventRuleResponse
     */
    public static function fromMap($map = []) {
        $model = new self();
        if(isset($map['headers'])){
            $model->headers = $map['headers'];
        }
        if(isset($map['statusCode'])){
            $model->statusCode = $map['statusCode'];
        }
        if(isset($map['body'])){
            $model->body = EnableEventRuleResponseBody::fromMap($map['body']);
        }
        return $model;
    }
    /**
     * @var string[]
     */
    public $headers;

    /**
     * @var int
     */
    public $statusCode;

    /**
     * @var EnableEventRuleResponseBody
     */
    public $body;

}
