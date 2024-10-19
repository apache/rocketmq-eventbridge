<?php

// This file is auto-generated, don't edit it. Thanks.
namespace RocketMQ\Eventbridge\SDK\Models;

use AlibabaCloud\Tea\Model;

use RocketMQ\Eventbridge\SDK\Models\EventTarget\runOptions;

/**
 * EventTarget Controller apis:
 *     * createEventTargets *
 *     * updateEventTargets *
 *     * deleteEventTargets *
 *     * listEventTargets   *
 */
class EventTarget extends Model {
    protected $_name = [
        'eventTargetName' => 'eventTargetName',
        'className' => 'className',
        'config' => 'config',
        'runOptions' => 'runOptions',
    ];
    public function validate() {}
    public function toMap() {
        $res = [];
        if (null !== $this->eventTargetName) {
            $res['eventTargetName'] = $this->eventTargetName;
        }
        if (null !== $this->className) {
            $res['className'] = $this->className;
        }
        if (null !== $this->config) {
            $res['config'] = $this->config;
        }
        if (null !== $this->runOptions) {
            $res['runOptions'] = null !== $this->runOptions ? $this->runOptions->toMap() : null;
        }
        return $res;
    }
    /**
     * @param array $map
     * @return EventTarget
     */
    public static function fromMap($map = []) {
        $model = new self();
        if(isset($map['eventTargetName'])){
            $model->eventTargetName = $map['eventTargetName'];
        }
        if(isset($map['className'])){
            $model->className = $map['className'];
        }
        if(isset($map['config'])){
            $model->config = $map['config'];
        }
        if(isset($map['runOptions'])){
            $model->runOptions = runOptions::fromMap($map['runOptions']);
        }
        return $model;
    }
    /**
     * @var string
     */
    public $eventTargetName;

    /**
     * @var string
     */
    public $className;

    /**
     * @var mixed[]
     */
    public $config;

    /**
     * @var runOptions
     */
    public $runOptions;

}
