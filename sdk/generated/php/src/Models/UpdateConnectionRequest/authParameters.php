<?php

// This file is auto-generated, don't edit it. Thanks.
namespace RocketMQ\Eventbridge\SDK\Models\UpdateConnectionRequest;

use AlibabaCloud\Tea\Model;

use RocketMQ\Eventbridge\SDK\Models\UpdateConnectionRequest\authParameters\apiKeyAuthParameters;
use RocketMQ\Eventbridge\SDK\Models\UpdateConnectionRequest\authParameters\basicAuthParameters;
use RocketMQ\Eventbridge\SDK\Models\UpdateConnectionRequest\authParameters\oauthParameters;

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

      BASIC_AUTH: basic authentication.

      Introduction: Basic authentication is a simple authentication scheme built into the HTTP protocol. When you use the HTTP protocol for communications, the authentication method that the HTTP server uses to authenticate user identities on the client is defined in the protocol. The request header is in the Authorization: Basic Base64-encoded string (Username:Password) format.

      1.  Username and Password are required

      API_KEY_AUTH: API key authentication.

      Introduction: The request header is in the Token: Token value format.

      *   ApiKeyName and ApiKeyValue are required.

      OAUTH_AUTH: OAuth authentication.

      Introduction: OAuth2.0 is an authentication mechanism. In normal cases, a system that does not use OAuth2.0 can access the resources of the server from the client. To ensure access security, access tokens are used to authenticate users in OAuth 2.0. The client must use an access token to access protected resources. This way, OAuth 2.0 protects resources from being accessed from malicious clients and improves system security.

      *   AuthorizationEndpoint, OAuthHttpParameters, and HttpMethod are required.
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
