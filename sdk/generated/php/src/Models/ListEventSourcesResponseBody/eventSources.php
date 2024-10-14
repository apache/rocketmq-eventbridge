<?php

// This file is auto-generated, don't edit it. Thanks.
namespace RocketMQ\Eventbridge\SDK\Models\ListEventSourcesResponseBody;

use AlibabaCloud\Tea\Model;

class eventSources extends Model {
    protected $_name = [
        'eventBusName' => 'eventBusName',
        'eventSourceName' => 'eventSourceName',
        'description' => 'description',
        'className' => 'className',
        'config' => 'config',
        'gmtCreate' => 'gmtCreate',
        'gmtModify' => 'gmtModify',
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
        if (null !== $this->config) {
            $res['config'] = $this->config;
        }
        if (null !== $this->gmtCreate) {
            $res['gmtCreate'] = $this->gmtCreate;
        }
        if (null !== $this->gmtModify) {
            $res['gmtModify'] = $this->gmtModify;
        }
        return $res;
    }
    /**
     * @param array $map
     * @return eventSources
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
        if(isset($map['config'])){
            $model->config = $map['config'];
        }
        if(isset($map['gmtCreate'])){
            $model->gmtCreate = $map['gmtCreate'];
        }
        if(isset($map['gmtModify'])){
            $model->gmtModify = $map['gmtModify'];
        }
        return $model;
    }
    /**
     * @description The name of the event bus.
This parameter is required.
     * @example demo
     * @var string
     */
    public $eventBusName;

    /**
     * @description EventSource is required for querying default bus events.
     * @example testEventSourceName
     * @var string
     */
    public $eventSourceName;

    /**
     * @description The description of the event type.
     * @example The description of the event type.
     * @var string
     */
    public $description;

    /**
     * @var string
     */
    public $className;

    /**
     * @var mixed[]
     */
    public $config;

    /**
     * @var string
     */
    public $gmtCreate;

    /**
     * @var string
     */
    public $gmtModify;

}
