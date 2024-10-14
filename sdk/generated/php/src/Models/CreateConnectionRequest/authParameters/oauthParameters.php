<?php

// This file is auto-generated, don't edit it. Thanks.
namespace RocketMQ\Eventbridge\SDK\Models\CreateConnectionRequest\authParameters;

use AlibabaCloud\Tea\Model;

use RocketMQ\Eventbridge\SDK\Models\CreateConnectionRequest\authParameters\oauthParameters\clientParameters;
use RocketMQ\Eventbridge\SDK\Models\CreateConnectionRequest\authParameters\oauthParameters\oauthHttpParameters;

class oauthParameters extends Model {
    protected $_name = [
        'authorizationEndpoint' => 'authorizationEndpoint',
        'clientParameters' => 'clientParameters',
        'httpMethod' => 'httpMethod',
        'oauthHttpParameters' => 'oauthHttpParameters',
    ];
    public function validate() {}
    public function toMap() {
        $res = [];
        if (null !== $this->authorizationEndpoint) {
            $res['authorizationEndpoint'] = $this->authorizationEndpoint;
        }
        if (null !== $this->clientParameters) {
            $res['clientParameters'] = null !== $this->clientParameters ? $this->clientParameters->toMap() : null;
        }
        if (null !== $this->httpMethod) {
            $res['httpMethod'] = $this->httpMethod;
        }
        if (null !== $this->oauthHttpParameters) {
            $res['oauthHttpParameters'] = null !== $this->oauthHttpParameters ? $this->oauthHttpParameters->toMap() : null;
        }
        return $res;
    }
    /**
     * @param array $map
     * @return oauthParameters
     */
    public static function fromMap($map = []) {
        $model = new self();
        if(isset($map['authorizationEndpoint'])){
            $model->authorizationEndpoint = $map['authorizationEndpoint'];
        }
        if(isset($map['clientParameters'])){
            $model->clientParameters = clientParameters::fromMap($map['clientParameters']);
        }
        if(isset($map['httpMethod'])){
            $model->httpMethod = $map['httpMethod'];
        }
        if(isset($map['oauthHttpParameters'])){
            $model->oauthHttpParameters = oauthHttpParameters::fromMap($map['oauthHttpParameters']);
        }
        return $model;
    }
    /**
     * @description The endpoint that is used to obtain the OAuth token.
     * @example http://localhost:8080/oauth/token
     * @var string
     */
    public $authorizationEndpoint;

    /**
     * @description The parameters that are configured for the client.
     * @var clientParameters
     */
    public $clientParameters;

    /**
     * @description The HTTP request method. Valid values:

        - GET

        - POST

        - HEAD
     * @example POST
     * @var string
     */
    public $httpMethod;

    /**
     * @description The request parameters for OAuth authentication.
     * @var oauthHttpParameters
     */
    public $oauthHttpParameters;

}
