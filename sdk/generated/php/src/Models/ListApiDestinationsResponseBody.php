<?php

// This file is auto-generated, don't edit it. Thanks.
namespace RocketMQ\Eventbridge\SDK\Models;

use AlibabaCloud\Tea\Model;

use RocketMQ\Eventbridge\SDK\Models\ListApiDestinationsResponseBody\apiDestinations;

class ListApiDestinationsResponseBody extends Model {
    protected $_name = [
        'code' => 'code',
        'apiDestinations' => 'apiDestinations',
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
        if (null !== $this->apiDestinations) {
            $res['apiDestinations'] = [];
            if(null !== $this->apiDestinations && is_array($this->apiDestinations)){
                $n = 0;
                foreach($this->apiDestinations as $item){
                    $res['apiDestinations'][$n++] = null !== $item ? $item->toMap() : $item;
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
     * @return ListApiDestinationsResponseBody
     */
    public static function fromMap($map = []) {
        $model = new self();
        if(isset($map['code'])){
            $model->code = $map['code'];
        }
        if(isset($map['apiDestinations'])){
            if(!empty($map['apiDestinations'])){
                $model->apiDestinations = [];
                $n = 0;
                foreach($map['apiDestinations'] as $item) {
                    $model->apiDestinations[$n++] = null !== $item ? apiDestinations::fromMap($item) : $item;
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
     * @description The returned response code. The value Success indicates that the request is successful.
     * @example Success
     * @var string
     */
    public $code;

    /**
     * @description The API destinations.
     * @var apiDestinations[]
     */
    public $apiDestinations;

    /**
     * @description The maximum number of entries returned per page.
     * @example 10
     * @var int
     */
    public $maxResults;

    /**
     * @description If excess return values exist, this parameter is returned.
     * @example 1
     * @var string
     */
    public $nextToken;

    /**
     * @description The total number of entries returned.
     * @example 2
     * @var int
     */
    public $total;

    /**
     * @description The returned message. If the request is successful, success is returned. If the request failed, an error code is returned.
     * @example success
     * @var string
     */
    public $message;

    /**
     * @description The request ID.
     * @example 96D7C0AB-DCE5-5E82-96B8-4725E1706BB1
     * @var string
     */
    public $requestId;

}
