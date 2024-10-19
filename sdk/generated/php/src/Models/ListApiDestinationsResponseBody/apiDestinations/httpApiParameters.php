<?php

// This file is auto-generated, don't edit it. Thanks.
namespace RocketMQ\Eventbridge\SDK\Models\ListApiDestinationsResponseBody\apiDestinations;

use AlibabaCloud\Tea\Model;

use RocketMQ\Eventbridge\SDK\Models\ListApiDestinationsResponseBody\apiDestinations\httpApiParameters\apiParameters;

class httpApiParameters extends Model {
    protected $_name = [
        'endpoint' => 'endpoint',
        'method' => 'method',
        'apiParameters' => 'apiParameters',
    ];
    public function validate() {}
    public function toMap() {
        $res = [];
        if (null !== $this->endpoint) {
            $res['endpoint'] = $this->endpoint;
        }
        if (null !== $this->method) {
            $res['method'] = $this->method;
        }
        if (null !== $this->apiParameters) {
            $res['apiParameters'] = [];
            if(null !== $this->apiParameters && is_array($this->apiParameters)){
                $n = 0;
                foreach($this->apiParameters as $item){
                    $res['apiParameters'][$n++] = null !== $item ? $item->toMap() : $item;
                }
            }
        }
        return $res;
    }
    /**
     * @param array $map
     * @return httpApiParameters
     */
    public static function fromMap($map = []) {
        $model = new self();
        if(isset($map['endpoint'])){
            $model->endpoint = $map['endpoint'];
        }
        if(isset($map['method'])){
            $model->method = $map['method'];
        }
        if(isset($map['apiParameters'])){
            if(!empty($map['apiParameters'])){
                $model->apiParameters = [];
                $n = 0;
                foreach($map['apiParameters'] as $item) {
                    $model->apiParameters[$n++] = null !== $item ? apiParameters::fromMap($item) : $item;
                }
            }
        }
        return $model;
    }
    /**
     * @description The endpoint of the API destination.
     * @example http://127.0.0.1:8001/api
     * @var string
     */
    public $endpoint;

    /**
     * @description The HTTP request method. Valid values:

          - POST

          - GET

          - DELETE

          - PUT

          - HEAD

          - TRACE

          - PATCH
     * @example POST
     * @var string
     */
    public $method;

    /**
     * @description TODO
     * @var apiParameters[]
     */
    public $apiParameters;

}
