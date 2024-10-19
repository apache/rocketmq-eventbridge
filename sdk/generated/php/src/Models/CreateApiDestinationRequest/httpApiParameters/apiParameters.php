<?php

// This file is auto-generated, don't edit it. Thanks.
namespace RocketMQ\Eventbridge\SDK\Models\CreateApiDestinationRequest\httpApiParameters;

use AlibabaCloud\Tea\Model;

class apiParameters extends Model {
    protected $_name = [
        'name' => 'name',
        'description' => 'description',
        'type' => 'type',
        'defaultValue' => 'defaultValue',
        'in' => 'in',
    ];
    public function validate() {}
    public function toMap() {
        $res = [];
        if (null !== $this->name) {
            $res['name'] = $this->name;
        }
        if (null !== $this->description) {
            $res['description'] = $this->description;
        }
        if (null !== $this->type) {
            $res['type'] = $this->type;
        }
        if (null !== $this->defaultValue) {
            $res['defaultValue'] = $this->defaultValue;
        }
        if (null !== $this->in) {
            $res['in'] = $this->in;
        }
        return $res;
    }
    /**
     * @param array $map
     * @return apiParameters
     */
    public static function fromMap($map = []) {
        $model = new self();
        if(isset($map['name'])){
            $model->name = $map['name'];
        }
        if(isset($map['description'])){
            $model->description = $map['description'];
        }
        if(isset($map['type'])){
            $model->type = $map['type'];
        }
        if(isset($map['defaultValue'])){
            $model->defaultValue = $map['defaultValue'];
        }
        if(isset($map['in'])){
            $model->in = $map['in'];
        }
        return $model;
    }
    /**
     * @var string
     */
    public $name;

    /**
     * @description The description of the API destination. The description can be up to 255 characters in length.
     * @var string
     */
    public $description;

    /**
     * @var string
     */
    public $type;

    /**
     * @var string
     */
    public $defaultValue;

    /**
     * @var string
     */
    public $in;

}
