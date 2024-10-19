<?php

// This file is auto-generated, don't edit it. Thanks.
namespace RocketMQ\Eventbridge\SDK\Models;

use AlibabaCloud\Tea\Model;

class UpdateEventSourceRequest extends Model {
    protected $_name = [
        'eventBusName' => 'eventBusName',
        'eventSourceName' => 'eventSourceName',
        'description' => 'description',
        'className' => 'className',
        'status' => 'status',
        'config' => 'config',
    ];
    public function validate() {}
    public function toMap() {
        $res = [];
        if (null !== $this->eventBusName) {
            $res['eventBusName'] = $this->eventBusName;
        }
        if (null !== $this->eventSourceName) {
            $res['eventSourceName'] = $this->eventSourceName;
        }
        if (null !== $this->description) {
            $res['description'] = $this->description;
        }
        if (null !== $this->className) {
            $res['className'] = $this->className;
        }
        if (null !== $this->status) {
            $res['status'] = $this->status;
        }
        if (null !== $this->config) {
            $res['config'] = $this->config;
        }
        return $res;
    }
    /**
     * @param array $map
     * @return UpdateEventSourceRequest
     */
    public static function fromMap($map = []) {
        $model = new self();
        if(isset($map['eventBusName'])){
            $model->eventBusName = $map['eventBusName'];
        }
        if(isset($map['eventSourceName'])){
            $model->eventSourceName = $map['eventSourceName'];
        }
        if(isset($map['description'])){
            $model->description = $map['description'];
        }
        if(isset($map['className'])){
            $model->className = $map['className'];
        }
        if(isset($map['status'])){
            $model->status = $map['status'];
        }
        if(isset($map['config'])){
            $model->config = $map['config'];
        }
        return $model;
    }
    /**
     * @description The name of the event bus with which the event source is associated.
This parameter is required.
     * @example my-event-bus
     * @var string
     */
    public $eventBusName;

    /**
     * @description The name of the event source.
This parameter is required.
     * @example myrabbitmq.sourc
     * @var string
     */
    public $eventSourceName;

    /**
     * @description The description of the event source.
     * @var string
     */
    public $description;

    /**
     * @var string
     */
    public $className;

    /**
     * @var int
     */
    public $status;

    /**
     * @var mixed[]
     */
    public $config;

}
