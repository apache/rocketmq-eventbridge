<?php

// This file is auto-generated, don't edit it. Thanks.
namespace RocketMQ\Eventbridge\SDK\Models\GetConnectionResponseBody\connections;

use AlibabaCloud\Tea\Model;

use RocketMQ\Eventbridge\SDK\Models\GetConnectionResponseBody\connections\authParameters\apiKeyAuthParameters;
use RocketMQ\Eventbridge\SDK\Models\GetConnectionResponseBody\connections\authParameters\basicAuthParameters;
use RocketMQ\Eventbridge\SDK\Models\GetConnectionResponseBody\connections\authParameters\oauthParameters;

class authParameters extends Model {
    protected $_name = [
        'apiKeyAuthParameters' => 'apiKeyAuthParameters',
        'authorizationType' => 'authorizationType',
        'basicAuthParameters' => 'basicAuthParameters',
        'oauthParameters' => 'oauthParameters',
    ];
    public function validate() {}
    public function toMap() {
        $res = [];
        if (null !== $this->apiKeyAuthParameters) {
            $res['apiKeyAuthParameters'] = null !== $this->apiKeyAuthParameters ? $this->apiKeyAuthParameters->toMap() : null;
        }
        if (null !== $this->authorizationType) {
            $res['authorizationType'] = $this->authorizationType;
        }
        if (null !== $this->basicAuthParameters) {
            $res['basicAuthParameters'] = null !== $this->basicAuthParameters ? $this->basicAuthParameters->toMap() : null;
        }
        if (null !== $this->oauthParameters) {
            $res['oauthParameters'] = null !== $this->oauthParameters ? $this->oauthParameters->toMap() : null;
        }
        return $res;
    }
    /**
     * @param array $map
     * @return authParameters
     */
    public static function fromMap($map = []) {
        $model = new self();
        if(isset($map['apiKeyAuthParameters'])){
            $model->apiKeyAuthParameters = apiKeyAuthParameters::fromMap($map['apiKeyAuthParameters']);
        }
        if(isset($map['authorizationType'])){
            $model->authorizationType = $map['authorizationType'];
        }
        if(isset($map['basicAuthParameters'])){
            $model->basicAuthParameters = basicAuthParameters::fromMap($map['basicAuthParameters']);
        }
        if(isset($map['oauthParameters'])){
            $model->oauthParameters = oauthParameters::fromMap($map['oauthParameters']);
        }
        return $model;
    }
    /**
     * @description The parameters that are configured for API key authentication.
     * @var apiKeyAuthParameters
     */
    public $apiKeyAuthParameters;

    /**
     * @description The authentication type. Valid values:


          - BASIC_AUTH: basic authentication.


          - API_KEY_AUTH: API key authentication.


          - OAUTH_AUTH: OAuth authentication.
     * @example BASIC_AUTH
     * @var string
     */
    public $authorizationType;

    /**
     * @description The parameters that are configured for basic authentication.
     * @var basicAuthParameters
     */
    public $basicAuthParameters;

    /**
     * @description The parameters that are configured for OAuth authentication.
     * @var oauthParameters
     */
    public $oauthParameters;

}
