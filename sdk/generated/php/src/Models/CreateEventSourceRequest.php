<?php

// This file is auto-generated, don't edit it. Thanks.
namespace RocketMQ\Eventbridge\SDK\Models;

use AlibabaCloud\Tea\Model;

/**
 * EventSource Controller apis:
 *     * createEventSource *
 *     * updateEventSource *
 *     * deleteEventSource *
 *     * getEventSource    *
 *     * listEventSources  *
 */
class CreateEventSourceRequest extends Model {
    protected $_name = [
        'description' => 'description',
        'eventBusName' => 'eventBusName',
        'eventSourceName' => 'eventSourceName',
        'className' => 'className',
        'config' => 'config',
    ];
    public function validate() {}
    public function toMap() {
        $res = [];
        if (null !== $this->description) {
            $res['description'] = $this->description;
        }
        if (null !== $this->eventBusName) {
            $res['eventBusName'] = $this->eventBusName;
        }
        if (null !== $this->eventSourceName) {
            $res['eventSourceName'] = $this->eventSourceName;
        }
        if (null !== $this->className) {
            $res['className'] = $this->className;
        }
        if (null !== $this->config) {
            $res['config'] = $this->config;
        }
        return $res;
    }
    /**
     * @param array $map
     * @return CreateEventSourceRequest
     */
    public static function fromMap($map = []) {
        $model = new self();
        if(isset($map['description'])){
            $model->description = $map['description'];
        }
        if(isset($map['eventBusName'])){
            $model->eventBusName = $map['eventBusName'];
        }
        if(isset($map['eventSourceName'])){
            $model->eventSourceName = $map['eventSourceName'];
        }
        if(isset($map['className'])){
            $model->className = $map['className'];
        }
        if(isset($map['config'])){
            $model->config = $map['config'];
        }
        return $model;
    }
    /**
     * @description The description of the event source.
     * @var string
     */
    public $description;

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
     * @var string
     */
    public $className;

    /**
     * @var mixed[]
     */
    public $config;

}
