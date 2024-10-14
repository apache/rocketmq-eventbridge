<?php

// This file is auto-generated, don't edit it. Thanks.
namespace RocketMQ\Eventbridge\SDK\Models;

use AlibabaCloud\Tea\Model;

use RocketMQ\Eventbridge\SDK\Models\PutEventsResponseBody\entryList;

class PutEventsResponseBody extends Model {
    protected $_name = [
        'failedEntryCount' => 'failedEntryCount',
        'entryList' => 'entryList',
        'code' => 'code',
        'message' => 'message',
        'requestId' => 'requestId',
    ];
    public function validate() {}
    public function toMap() {
        $res = [];
        if (null !== $this->failedEntryCount) {
            $res['failedEntryCount'] = $this->failedEntryCount;
        }
        if (null !== $this->entryList) {
            $res['entryList'] = [];
            if(null !== $this->entryList && is_array($this->entryList)){
                $n = 0;
                foreach($this->entryList as $item){
                    $res['entryList'][$n++] = null !== $item ? $item->toMap() : $item;
                }
            }
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
     * @return PutEventsResponseBody
     */
    public static function fromMap($map = []) {
        $model = new self();
        if(isset($map['failedEntryCount'])){
            $model->failedEntryCount = $map['failedEntryCount'];
        }
        if(isset($map['entryList'])){
            if(!empty($map['entryList'])){
                $model->entryList = [];
                $n = 0;
                foreach($map['entryList'] as $item) {
                    $model->entryList[$n++] = null !== $item ? entryList::fromMap($item) : $item;
                }
            }
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
     * @var int
     */
    public $failedEntryCount;

    /**
     * @var entryList[]
     */
    public $entryList;

    /**
     * @description The status code returned. The status code 200 indicates that the request was successful.
     * @example 200
     * @var string
     */
    public $code;

    /**
     * @description The error message that is returned if the request failed.
     * @example EventBusNotExist
     * @var string
     */
    public $message;

    /**
     * @description The request ID.
     * @example 580A938B-6107-586C-8EC7-F22EEBEDA9E6
     * @var string
     */
    public $requestId;

}
