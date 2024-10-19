<?php

// This file is auto-generated, don't edit it. Thanks.
namespace RocketMQ\Eventbridge\SDK\Models;

use AlibabaCloud\Tea\Model;

use RocketMQ\Eventbridge\SDK\Models\ListConnectionsResponseBody\connections;

class ListConnectionsResponseBody extends Model {
    protected $_name = [
        'code' => 'code',
        'connections' => 'connections',
        'maxResults' => 'maxResults',
        'nextToken' => 'nextToken',
        'total' => 'total',
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
        if (null !== $this->maxResults) {
            $res['maxResults'] = $this->maxResults;
        }
        if (null !== $this->nextToken) {
            $res['nextToken'] = $this->nextToken;
        }
        if (null !== $this->total) {
            $res['total'] = $this->total;
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
     * @return ListConnectionsResponseBody
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
        if(isset($map['maxResults'])){
            $model->maxResults = $map['maxResults'];
        }
        if(isset($map['nextToken'])){
            $model->nextToken = $map['nextToken'];
        }
        if(isset($map['total'])){
            $model->total = $map['total'];
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
     * @description The HTTP status code. The value Success indicates that the request is successful.
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
     * @description The number of entries returned per page.
     * @example 10
     * @var int
     */
    public $maxResults;

    /**
     * @description If excess return values exist, this parameter is returned.
     * @example 0
     * @var string
     */
    public $nextToken;

    /**
     * @description The total number of entries returned.
     * @example 1
     * @var int
     */
    public $total;

    /**
     * @description The message returned.
     * @example success
     * @var string
     */
    public $message;

    /**
     * @description The ID of the request. This parameter is a common parameter. Each request has a unique ID. You can use the ID to troubleshoot issues.
     * @example E3619976-8714-5D88-BBA2-6983D798A8BB
     * @var string
     */
    public $requestId;

}
