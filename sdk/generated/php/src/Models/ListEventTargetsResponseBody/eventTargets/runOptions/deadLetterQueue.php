<?php

// This file is auto-generated, don't edit it. Thanks.
namespace RocketMQ\Eventbridge\SDK\Models\ListEventTargetsResponseBody\eventTargets\runOptions;

use AlibabaCloud\Tea\Model;

class deadLetterQueue extends Model {
    protected $_name = [
        'type' => 'type',
        'config' => 'config',
    ];
    public function validate() {}
    public function toMap() {
        $res = [];
        if (null !== $this->type) {
            $res['type'] = $this->type;
        }
        if (null !== $this->config) {
            $res['config'] = $this->config;
        }
        return $res;
    }
    /**
     * @param array $map
     * @return deadLetterQueue
     */
    public static function fromMap($map = []) {
        $model = new self();
        if(isset($map['type'])){
            $model->type = $map['type'];
        }
        if(isset($map['config'])){
            $model->config = $map['config'];
        }
        return $model;
    }
    /**
     * @var string
     */
    public $type;

    /**
     * @var mixed[]
     */
    public $config;

}
