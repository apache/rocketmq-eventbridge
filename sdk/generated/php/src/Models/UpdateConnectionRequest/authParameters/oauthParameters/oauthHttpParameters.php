<?php

// This file is auto-generated, don't edit it. Thanks.
namespace RocketMQ\Eventbridge\SDK\Models\UpdateConnectionRequest\authParameters\oauthParameters;

use AlibabaCloud\Tea\Model;

use RocketMQ\Eventbridge\SDK\Models\UpdateConnectionRequest\authParameters\oauthParameters\oauthHttpParameters\bodyParameters;
use RocketMQ\Eventbridge\SDK\Models\UpdateConnectionRequest\authParameters\oauthParameters\oauthHttpParameters\headerParameters;
use RocketMQ\Eventbridge\SDK\Models\UpdateConnectionRequest\authParameters\oauthParameters\oauthHttpParameters\queryStringParameters;

class oauthHttpParameters extends Model {
    protected $_name = [
        'bodyParameters' => 'bodyParameters',
        'headerParameters' => 'headerParameters',
        'queryStringParameters' => 'queryStringParameters',
    ];
    public function validate() {}
    public function toMap() {
        $res = [];
        if (null !== $this->bodyParameters) {
            $res['bodyParameters'] = [];
            if(null !== $this->bodyParameters && is_array($this->bodyParameters)){
                $n = 0;
                foreach($this->bodyParameters as $item){
                    $res['bodyParameters'][$n++] = null !== $item ? $item->toMap() : $item;
                }
            }
        }
        if (null !== $this->headerParameters) {
            $res['headerParameters'] = [];
            if(null !== $this->headerParameters && is_array($this->headerParameters)){
                $n = 0;
                foreach($this->headerParameters as $item){
                    $res['headerParameters'][$n++] = null !== $item ? $item->toMap() : $item;
                }
            }
        }
        if (null !== $this->queryStringParameters) {
            $res['queryStringParameters'] = [];
            if(null !== $this->queryStringParameters && is_array($this->queryStringParameters)){
                $n = 0;
                foreach($this->queryStringParameters as $item){
                    $res['queryStringParameters'][$n++] = null !== $item ? $item->toMap() : $item;
                }
            }
        }
        return $res;
    }
    /**
     * @param array $map
     * @return oauthHttpParameters
     */
    public static function fromMap($map = []) {
        $model = new self();
        if(isset($map['bodyParameters'])){
            if(!empty($map['bodyParameters'])){
                $model->bodyParameters = [];
                $n = 0;
                foreach($map['bodyParameters'] as $item) {
                    $model->bodyParameters[$n++] = null !== $item ? bodyParameters::fromMap($item) : $item;
                }
            }
        }
        if(isset($map['headerParameters'])){
            if(!empty($map['headerParameters'])){
                $model->headerParameters = [];
                $n = 0;
                foreach($map['headerParameters'] as $item) {
                    $model->headerParameters[$n++] = null !== $item ? headerParameters::fromMap($item) : $item;
                }
            }
        }
        if(isset($map['queryStringParameters'])){
            if(!empty($map['queryStringParameters'])){
                $model->queryStringParameters = [];
                $n = 0;
                foreach($map['queryStringParameters'] as $item) {
                    $model->queryStringParameters[$n++] = null !== $item ? queryStringParameters::fromMap($item) : $item;
                }
            }
        }
        return $model;
    }
    /**
     * @description The parameters that are configured for the request.
     * @var bodyParameters[]
     */
    public $bodyParameters;

    /**
     * @description The parameters that are configured for the request header.
     * @var headerParameters[]
     */
    public $headerParameters;

    /**
     * @description The parameters that are configured for the request path.
     * @var queryStringParameters[]
     */
    public $queryStringParameters;

}
