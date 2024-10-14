<?php

// This file is auto-generated, don't edit it. Thanks.
namespace RocketMQ\Eventbridge\SDK\Models;

use AlibabaCloud\Tea\Model;

use RocketMQ\Eventbridge\SDK\Models\ListEventSourcesResponseBody\eventSources;

class ListEventSourcesResponseBody extends Model {
    protected $_name = [
        'eventSources' => 'eventSources',
        'total' => 'total',
        'maxResults' => 'maxResults',
        'nextToken' => 'nextToken',
    ];
    public function validate() {}
    public function toMap() {
        $res = [];
        if (null !== $this->eventSources) {
            $res['eventSources'] = [];
            if(null !== $this->eventSources && is_array($this->eventSources)){
                $n = 0;
                foreach($this->eventSources as $item){
                    $res['eventSources'][$n++] = null !== $item ? $item->toMap() : $item;
                }
            }
        }
        if (null !== $this->total) {
            $res['total'] = $this->total;
        }
        if (null !== $this->maxResults) {
            $res['maxResults'] = $this->maxResults;
        }
        if (null !== $this->nextToken) {
            $res['nextToken'] = $this->nextToken;
        }
        return $res;
    }
    /**
     * @param array $map
     * @return ListEventSourcesResponseBody
     */
    public static function fromMap($map = []) {
        $model = new self();
        if(isset($map['eventSources'])){
            if(!empty($map['eventSources'])){
                $model->eventSources = [];
                $n = 0;
                foreach($map['eventSources'] as $item) {
                    $model->eventSources[$n++] = null !== $item ? eventSources::fromMap($item) : $item;
                }
            }
        }
        if(isset($map['total'])){
            $model->total = $map['total'];
        }
        if(isset($map['maxResults'])){
            $model->maxResults = $map['maxResults'];
        }
        if(isset($map['nextToken'])){
            $model->nextToken = $map['nextToken'];
        }
        return $model;
    }
    /**
     * @var eventSources[]
     */
    public $eventSources;

    /**
     * @description The total number of entries.
     * @example 2
     * @var int
     */
    public $total;

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

}
