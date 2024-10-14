<?php

// This file is auto-generated, don't edit it. Thanks.
namespace RocketMQ\Eventbridge\SDK\Models;

use AlibabaCloud\Tea\Model;

use RocketMQ\Eventbridge\SDK\Models\ListEventRulesResponseBody\eventRules;

class ListEventRulesResponseBody extends Model {
    protected $_name = [
        'eventRules' => 'eventRules',
        'total' => 'total',
        'maxResults' => 'maxResults',
        'nextToken' => 'nextToken',
    ];
    public function validate() {}
    public function toMap() {
        $res = [];
        if (null !== $this->eventRules) {
            $res['eventRules'] = [];
            if(null !== $this->eventRules && is_array($this->eventRules)){
                $n = 0;
                foreach($this->eventRules as $item){
                    $res['eventRules'][$n++] = null !== $item ? $item->toMap() : $item;
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
     * @return ListEventRulesResponseBody
     */
    public static function fromMap($map = []) {
        $model = new self();
        if(isset($map['eventRules'])){
            if(!empty($map['eventRules'])){
                $model->eventRules = [];
                $n = 0;
                foreach($map['eventRules'] as $item) {
                    $model->eventRules[$n++] = null !== $item ? eventRules::fromMap($item) : $item;
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
     * @var eventRules[]
     */
    public $eventRules;

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
