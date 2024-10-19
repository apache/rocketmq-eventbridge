<?php

// This file is auto-generated, don't edit it. Thanks.
namespace RocketMQ\Eventbridge\SDK;

use Darabonba\OpenApi\OpenApiClient;
use AlibabaCloud\Tea\Exception\TeaError;
use AlibabaCloud\Tea\Utils\Utils;

use RocketMQ\Eventbridge\SDK\Models\CreateEventBusRequest;
use AlibabaCloud\Tea\Utils\Utils\RuntimeOptions;
use RocketMQ\Eventbridge\SDK\Models\CreateEventBusResponse;
use Darabonba\OpenApi\Models\OpenApiRequest;
use Darabonba\OpenApi\Models\Params;
use RocketMQ\Eventbridge\SDK\Models\GetEventBusRequest;
use RocketMQ\Eventbridge\SDK\Models\GetEventBusResponse;
use RocketMQ\Eventbridge\SDK\Models\ListEventBusesRequest;
use RocketMQ\Eventbridge\SDK\Models\ListEventBusesResponse;
use RocketMQ\Eventbridge\SDK\Models\DeleteEventBusRequest;
use RocketMQ\Eventbridge\SDK\Models\DeleteEventBusResponse;
use RocketMQ\Eventbridge\SDK\Models\CreateApiDestinationRequest;
use RocketMQ\Eventbridge\SDK\Models\CreateApiDestinationResponse;
use RocketMQ\Eventbridge\SDK\Models\UpdateApiDestinationRequest;
use RocketMQ\Eventbridge\SDK\Models\UpdateApiDestinationResponse;
use RocketMQ\Eventbridge\SDK\Models\GetApiDestinationRequest;
use RocketMQ\Eventbridge\SDK\Models\GetApiDestinationResponse;
use RocketMQ\Eventbridge\SDK\Models\DeleteApiDestinationRequest;
use RocketMQ\Eventbridge\SDK\Models\DeleteApiDestinationResponse;
use RocketMQ\Eventbridge\SDK\Models\ListApiDestinationsRequest;
use RocketMQ\Eventbridge\SDK\Models\ListApiDestinationsResponse;
use RocketMQ\Eventbridge\SDK\Models\CreateConnectionRequest;
use RocketMQ\Eventbridge\SDK\Models\CreateConnectionResponse;
use RocketMQ\Eventbridge\SDK\Models\DeleteConnectionRequest;
use RocketMQ\Eventbridge\SDK\Models\DeleteConnectionResponse;
use RocketMQ\Eventbridge\SDK\Models\UpdateConnectionRequest;
use RocketMQ\Eventbridge\SDK\Models\UpdateConnectionResponse;
use RocketMQ\Eventbridge\SDK\Models\GetConnectionRequest;
use RocketMQ\Eventbridge\SDK\Models\GetConnectionResponse;
use RocketMQ\Eventbridge\SDK\Models\ListConnectionsRequest;
use RocketMQ\Eventbridge\SDK\Models\ListConnectionsResponse;
use RocketMQ\Eventbridge\SDK\Models\ListEnumsResponseResponse;
use RocketMQ\Eventbridge\SDK\Models\PutEventsRequest;
use RocketMQ\Eventbridge\SDK\Models\PutEventsResponse;
use RocketMQ\Eventbridge\SDK\Models\CreateEventRuleRequest;
use RocketMQ\Eventbridge\SDK\Models\CreateEventRuleResponse;
use RocketMQ\Eventbridge\SDK\Models\GetEventRuleRequest;
use RocketMQ\Eventbridge\SDK\Models\GetEventRuleResponse;
use RocketMQ\Eventbridge\SDK\Models\DeleteEventRuleRequest;
use RocketMQ\Eventbridge\SDK\Models\DeleteEventRuleResponse;
use RocketMQ\Eventbridge\SDK\Models\UpdateEventRuleRequest;
use RocketMQ\Eventbridge\SDK\Models\UpdateEventRuleResponse;
use RocketMQ\Eventbridge\SDK\Models\ListEventRulesRequest;
use RocketMQ\Eventbridge\SDK\Models\ListEventRulesResponse;
use RocketMQ\Eventbridge\SDK\Models\EnableEventRuleRequest;
use RocketMQ\Eventbridge\SDK\Models\EnableEventRuleResponse;
use RocketMQ\Eventbridge\SDK\Models\DisableEventRuleRequest;
use RocketMQ\Eventbridge\SDK\Models\DisableEventRuleResponse;
use RocketMQ\Eventbridge\SDK\Models\CreateEventSourceRequest;
use RocketMQ\Eventbridge\SDK\Models\CreateEventSourceResponse;
use RocketMQ\Eventbridge\SDK\Models\UpdateEventSourceRequest;
use RocketMQ\Eventbridge\SDK\Models\UpdateEventSourceResponse;
use RocketMQ\Eventbridge\SDK\Models\DeleteEventSourceRequest;
use RocketMQ\Eventbridge\SDK\Models\DeleteEventSourceResponse;
use RocketMQ\Eventbridge\SDK\Models\GetEventSourceRequest;
use RocketMQ\Eventbridge\SDK\Models\GetEventSourceResponse;
use RocketMQ\Eventbridge\SDK\Models\ListEventSourcesRequest;
use RocketMQ\Eventbridge\SDK\Models\ListEventSourcesResponse;
use RocketMQ\Eventbridge\SDK\Models\CreateEventTargetsRequest;
use RocketMQ\Eventbridge\SDK\Models\CreateEventTargetsResponse;
use RocketMQ\Eventbridge\SDK\Models\UpdateEventTargetsRequest;
use RocketMQ\Eventbridge\SDK\Models\UpdateEventTargetsResponse;
use RocketMQ\Eventbridge\SDK\Models\DeleteEventTargetsRequest;
use RocketMQ\Eventbridge\SDK\Models\DeleteEventTargetsResponse;
use RocketMQ\Eventbridge\SDK\Models\ListEventTargetsRequest;
use RocketMQ\Eventbridge\SDK\Models\ListEventTargetsResponse;
use RocketMQ\Eventbridge\SDK\Models\ListEventTypesRequest;
use RocketMQ\Eventbridge\SDK\Models\ListEventTypesResponse;

class SDKClient extends OpenApiClient {
    public function __construct($config){
        parent::__construct($config);
        $this->_endpointRule = "";
        $this->checkConfig($config);
        $this->_endpoint = $this->getEndpoint("eventbridge", $this->_regionId, $this->_endpointRule, $this->_network, $this->_suffix, $this->_endpointMap, $this->_endpoint);
    }

    /**
     * @param string $productId
     * @param string $regionId
     * @param string $endpointRule
     * @param string $network
     * @param string $suffix
     * @param string[] $endpointMap
     * @param string $endpoint
     * @return string
     * @throws TeaError
     */
    public function getEndpoint($productId, $regionId, $endpointRule, $network, $suffix, $endpointMap, $endpoint){
        if (!Utils::empty_($endpoint)) {
            return $endpoint;
        }
        if (!Utils::isUnset($endpointMap) && !Utils::empty_(@$endpointMap[$regionId])) {
            return @$endpointMap[$regionId];
        }
        $result = "";
        if (!Utils::empty_($network) && !Utils::equalString($network, "public")) {
            $network = "-" . $network . "";
        }
        else {
            $network = "";
        }
        if (!Utils::isUnset($suffix)) {
            $suffix = "";
        }
        else {
            $suffix = "-" . $suffix . "";
        }
        if (Utils::equalString($endpointRule, "regional")) {
            if (Utils::empty_($regionId)) {
                throw new TeaError([
                    "message" => "RegionId is empty, please set a valid RegionId"
                ]);
            }
            $result = "" . $productId . "" . $suffix . "" . $network . "." . $regionId . ".aliyuncs.com";
        }
        else {
            $result = "" . $productId . "" . $suffix . "" . $network . ".aliyuncs.com";
        }
        return $result;
    }

    /**
     * @summary Creates an event bus.
     *  *
     * @description You can call this API operation to create an event bus.
     *  *
     * @param CreateEventBusRequest $request CreateEventBusRequest
     * @param RuntimeOptions $runtime runtime options for this request RuntimeOptions
     * @return CreateEventBusResponse CreateEventBusResponse
     */
    public function createEventBusWithOptions($request, $runtime){
        Utils::validateModel($request);
        $body = [];
        if (!Utils::isUnset($request->description)) {
            $body["description"] = $request->description;
        }
        if (!Utils::isUnset($request->eventBusName)) {
            $body["eventBusName"] = $request->eventBusName;
        }
        $req = new OpenApiRequest([
            "body" => Utils::toJSONString($body)
        ]);
        $params = new Params([
            "action" => "CreateEventBus",
            "version" => "2024-07-01",
            "protocol" => "HTTP",
            "pathname" => "/bus/createEventBus",
            "method" => "POST",
            "authType" => "Anonymous",
            "style" => "RPC",
            "reqBodyType" => "json",
            "bodyType" => "json"
        ]);
        return CreateEventBusResponse::fromMap($this->callApi($params, $req, $runtime));
    }

    /**
     * @summary Creates an event bus.
     *  *
     * @description You can call this API operation to create an event bus.
     *  *
     * @param CreateEventBusRequest $request CreateEventBusRequest
     * @return CreateEventBusResponse CreateEventBusResponse
     */
    public function createEventBus($request){
        $runtime = new RuntimeOptions([]);
        return $this->createEventBusWithOptions($request, $runtime);
    }

    /**
     * @summary Queries the detailed information about an event bus.
     *  *
     * @description You can call this API operation to query the detailed information about an event bus.
     *  *
     * @param GetEventBusRequest $request GetEventBusRequest
     * @param RuntimeOptions $runtime runtime options for this request RuntimeOptions
     * @return GetEventBusResponse GetEventBusResponse
     */
    public function getEventBusWithOptions($request, $runtime){
        Utils::validateModel($request);
        $body = [];
        if (!Utils::isUnset($request->eventBusName)) {
            $body["eventBusName"] = $request->eventBusName;
        }
        $req = new OpenApiRequest([
            "body" => Utils::toJSONString($body)
        ]);
        $params = new Params([
            "action" => "GetEventBus",
            "version" => "2024-07-01",
            "protocol" => "HTTP",
            "pathname" => "/bus/getEventBus",
            "method" => "POST",
            "authType" => "Anonymous",
            "style" => "RPC",
            "reqBodyType" => "json",
            "bodyType" => "json"
        ]);
        return GetEventBusResponse::fromMap($this->callApi($params, $req, $runtime));
    }

    /**
     * @summary Queries the detailed information about an event bus.
     *  *
     * @description You can call this API operation to query the detailed information about an event bus.
     *  *
     * @param GetEventBusRequest $request GetEventBusRequest
     * @return GetEventBusResponse GetEventBusResponse
     */
    public function getEventBus($request){
        $runtime = new RuntimeOptions([]);
        return $this->getEventBusWithOptions($request, $runtime);
    }

    /**
     * @summary Queries all event buses.
     *  *
     * @description You can call this API operation to query all event buses.
     *  *
     * @param ListEventBusesRequest $request ListEventBusesRequest
     * @param RuntimeOptions $runtime runtime options for this request RuntimeOptions
     * @return ListEventBusesResponse ListEventBusesResponse
     */
    public function listEventBusesWithOptions($request, $runtime){
        Utils::validateModel($request);
        $body = [];
        if (!Utils::isUnset($request->maxResults)) {
            $body["maxResults"] = $request->maxResults;
        }
        if (!Utils::isUnset($request->nextToken)) {
            $body["nextToken"] = $request->nextToken;
        }
        $req = new OpenApiRequest([
            "body" => Utils::toJSONString($body)
        ]);
        $params = new Params([
            "action" => "ListEventBuses",
            "version" => "2024-07-01",
            "protocol" => "HTTP",
            "pathname" => "/bus/listEventBuses",
            "method" => "POST",
            "authType" => "Anonymous",
            "style" => "RPC",
            "reqBodyType" => "json",
            "bodyType" => "json"
        ]);
        return ListEventBusesResponse::fromMap($this->callApi($params, $req, $runtime));
    }

    /**
     * @summary Queries all event buses.
     *  *
     * @description You can call this API operation to query all event buses.
     *  *
     * @param ListEventBusesRequest $request ListEventBusesRequest
     * @return ListEventBusesResponse ListEventBusesResponse
     */
    public function listEventBuses($request){
        $runtime = new RuntimeOptions([]);
        return $this->listEventBusesWithOptions($request, $runtime);
    }

    /**
     * @summary Deletes an event bus.
     *  *
     * @description You can call this API operation to delete an event bus.
     *  *
     * @param DeleteEventBusRequest $request DeleteEventBusRequest
     * @param RuntimeOptions $runtime runtime options for this request RuntimeOptions
     * @return DeleteEventBusResponse DeleteEventBusResponse
     */
    public function deleteEventBusWithOptions($request, $runtime){
        Utils::validateModel($request);
        $body = [];
        if (!Utils::isUnset($request->eventBusName)) {
            $body["eventBusName"] = $request->eventBusName;
        }
        $req = new OpenApiRequest([
            "body" => Utils::toJSONString($body)
        ]);
        $params = new Params([
            "action" => "DeleteEventBus",
            "version" => "2024-07-01",
            "protocol" => "HTTP",
            "pathname" => "/bus/deleteEventBus",
            "method" => "POST",
            "authType" => "Anonymous",
            "style" => "RPC",
            "reqBodyType" => "json",
            "bodyType" => "json"
        ]);
        return DeleteEventBusResponse::fromMap($this->callApi($params, $req, $runtime));
    }

    /**
     * @summary Deletes an event bus.
     *  *
     * @description You can call this API operation to delete an event bus.
     *  *
     * @param DeleteEventBusRequest $request DeleteEventBusRequest
     * @return DeleteEventBusResponse DeleteEventBusResponse
     */
    public function deleteEventBus($request){
        $runtime = new RuntimeOptions([]);
        return $this->deleteEventBusWithOptions($request, $runtime);
    }

    /**
     * @summary Creates an API destination.
     *  *
     * @description You can call this API operation to create an API destination.
     *  *
     * @param CreateApiDestinationRequest $request CreateApiDestinationRequest (tmpReq before)
     * @param RuntimeOptions $runtime runtime options for this request RuntimeOptions
     * @return CreateApiDestinationResponse CreateApiDestinationResponse
     */
    public function createApiDestinationWithOptions($request, $runtime){
        Utils::validateModel($request);
        $body = [];
        if (!Utils::isUnset($request->apiDestinationName)) {
            $body["apiDestinationName"] = $request->apiDestinationName;
        }
        if (!Utils::isUnset($request->connectionName)) {
            $body["connectionName"] = $request->connectionName;
        }
        if (!Utils::isUnset($request->description)) {
            $body["description"] = $request->description;
        }
        if (!Utils::isUnset($request->httpApiParameters)) {
            $body["httpApiParameters"] = $request->httpApiParameters;
        }
        if (!Utils::isUnset($request->invocationRateLimitPerSecond)) {
            $body["invocationRateLimitPerSecond"] = $request->invocationRateLimitPerSecond;
        }
        $req = new OpenApiRequest([
            "body" => Utils::toJSONString($body)
        ]);
        $params = new Params([
            "action" => "CreateApiDestination",
            "version" => "2024-07-01",
            "protocol" => "HTTP",
            "pathname" => "/api-destination/createApiDestination",
            "method" => "POST",
            "authType" => "Anonymous",
            "style" => "RPC",
            "reqBodyType" => "json",
            "bodyType" => "json"
        ]);
        return CreateApiDestinationResponse::fromMap($this->callApi($params, $req, $runtime));
    }

    /**
     * @summary Creates an API destination.
     *  *
     * @description You can call this API operation to create an API destination.
     *  *
     * @param CreateApiDestinationRequest $request CreateApiDestinationRequest
     * @return CreateApiDestinationResponse CreateApiDestinationResponse
     */
    public function createApiDestination($request){
        $runtime = new RuntimeOptions([]);
        return $this->createApiDestinationWithOptions($request, $runtime);
    }

    /**
     * @summary Updates an API destination.
     *  *
     * @description You can call this API operation to update an API destination.
     *  *
     * @param UpdateApiDestinationRequest $request UpdateApiDestinationRequest
     * @param RuntimeOptions $runtime runtime options for this request RuntimeOptions
     * @return UpdateApiDestinationResponse UpdateApiDestinationResponse
     */
    public function updateApiDestinationWithOptions($request, $runtime){
        Utils::validateModel($request);
        $body = [];
        if (!Utils::isUnset($request->apiDestinationName)) {
            $body["apiDestinationName"] = $request->apiDestinationName;
        }
        if (!Utils::isUnset($request->connectionName)) {
            $body["connectionName"] = $request->connectionName;
        }
        if (!Utils::isUnset($request->description)) {
            $body["description"] = $request->description;
        }
        if (!Utils::isUnset($request->httpApiParameters)) {
            $body["httpApiParameters"] = $request->httpApiParameters;
        }
        if (!Utils::isUnset($request->invocationRateLimitPerSecond)) {
            $body["invocationRateLimitPerSecond"] = $request->invocationRateLimitPerSecond;
        }
        $req = new OpenApiRequest([
            "body" => Utils::toJSONString($body)
        ]);
        $params = new Params([
            "action" => "UpdateApiDestination",
            "version" => "2024-07-01",
            "protocol" => "HTTP",
            "pathname" => "/api-destination/updateApiDestination",
            "method" => "POST",
            "authType" => "Anonymous",
            "style" => "RPC",
            "reqBodyType" => "json",
            "bodyType" => "json"
        ]);
        return UpdateApiDestinationResponse::fromMap($this->callApi($params, $req, $runtime));
    }

    /**
     * @summary Updates an API destination.
     *  *
     * @description You can call this API operation to update an API destination.
     *  *
     * @param UpdateApiDestinationRequest $request UpdateApiDestinationRequest
     * @return UpdateApiDestinationResponse UpdateApiDestinationResponse
     */
    public function updateApiDestination($request){
        $runtime = new RuntimeOptions([]);
        return $this->updateApiDestinationWithOptions($request, $runtime);
    }

    /**
     * @summary Queries the information about an API destination.
     *  *
     * @description You can call this API operation to query the information about an API destination.
     *  *
     * @param GetApiDestinationRequest $request GetApiDestinationRequest
     * @param RuntimeOptions $runtime runtime options for this request RuntimeOptions
     * @return GetApiDestinationResponse GetApiDestinationResponse
     */
    public function getApiDestinationWithOptions($request, $runtime){
        Utils::validateModel($request);
        $body = [];
        if (!Utils::isUnset($request->apiDestinationName)) {
            $body["apiDestinationName"] = $request->apiDestinationName;
        }
        $req = new OpenApiRequest([
            "body" => Utils::toJSONString($body)
        ]);
        $params = new Params([
            "action" => "GetApiDestination",
            "version" => "2024-07-01",
            "protocol" => "HTTP",
            "pathname" => "/api-destination/getApiDestination",
            "method" => "POST",
            "authType" => "Anonymous",
            "style" => "RPC",
            "reqBodyType" => "json",
            "bodyType" => "json"
        ]);
        return GetApiDestinationResponse::fromMap($this->callApi($params, $req, $runtime));
    }

    /**
     * @summary Queries the information about an API destination.
     *  *
     * @description You can call this API operation to query the information about an API destination.
     *  *
     * @param GetApiDestinationRequest $request GetApiDestinationRequest
     * @return GetApiDestinationResponse GetApiDestinationResponse
     */
    public function getApiDestination($request){
        $runtime = new RuntimeOptions([]);
        return $this->getApiDestinationWithOptions($request, $runtime);
    }

    /**
     * @summary Deletes an API destination.
     *  *
     * @description You can call this API operation to delete an API destination.
     *  *
     * @param DeleteApiDestinationRequest $request DeleteApiDestinationRequest
     * @param RuntimeOptions $runtime runtime options for this request RuntimeOptions
     * @return DeleteApiDestinationResponse DeleteApiDestinationResponse
     */
    public function deleteApiDestinationWithOptions($request, $runtime){
        Utils::validateModel($request);
        $body = [];
        if (!Utils::isUnset($request->apiDestinationName)) {
            $body["apiDestinationName"] = $request->apiDestinationName;
        }
        $req = new OpenApiRequest([
            "body" => Utils::toJSONString($body)
        ]);
        $params = new Params([
            "action" => "DeleteApiDestination",
            "version" => "2024-07-01",
            "protocol" => "HTTP",
            "pathname" => "/api-destination/deleteApiDestination",
            "method" => "POST",
            "authType" => "Anonymous",
            "style" => "RPC",
            "reqBodyType" => "json",
            "bodyType" => "json"
        ]);
        return DeleteApiDestinationResponse::fromMap($this->callApi($params, $req, $runtime));
    }

    /**
     * @summary Deletes an API destination.
     *  *
     * @description You can call this API operation to delete an API destination.
     *  *
     * @param DeleteApiDestinationRequest $request DeleteApiDestinationRequest
     * @return DeleteApiDestinationResponse DeleteApiDestinationResponse
     */
    public function deleteApiDestination($request){
        $runtime = new RuntimeOptions([]);
        return $this->deleteApiDestinationWithOptions($request, $runtime);
    }

    /**
     * @summary Queries a list of API destinations.
     *  *
     * @description You can use this API operation to query a list of API destinations.
     *  *
     * @param ListApiDestinationsRequest $request ListApiDestinationsRequest
     * @param RuntimeOptions $runtime runtime options for this request RuntimeOptions
     * @return ListApiDestinationsResponse ListApiDestinationsResponse
     */
    public function listApiDestinationsWithOptions($request, $runtime){
        Utils::validateModel($request);
        $body = [];
        if (!Utils::isUnset($request->apiDestinationNamePrefix)) {
            $body["apiDestinationNamePrefix"] = $request->apiDestinationNamePrefix;
        }
        if (!Utils::isUnset($request->connectionName)) {
            $body["connectionName"] = $request->connectionName;
        }
        if (!Utils::isUnset($request->maxResults)) {
            $body["maxResults"] = $request->maxResults;
        }
        if (!Utils::isUnset($request->nextToken)) {
            $body["nextToken"] = $request->nextToken;
        }
        $req = new OpenApiRequest([
            "body" => Utils::toJSONString($body)
        ]);
        $params = new Params([
            "action" => "ListApiDestinations",
            "version" => "2024-07-01",
            "protocol" => "HTTP",
            "pathname" => "/api-destination/listApiDestinations",
            "method" => "POST",
            "authType" => "Anonymous",
            "style" => "RPC",
            "reqBodyType" => "json",
            "bodyType" => "json"
        ]);
        return ListApiDestinationsResponse::fromMap($this->callApi($params, $req, $runtime));
    }

    /**
     * @summary Queries a list of API destinations.
     *  *
     * @description You can use this API operation to query a list of API destinations.
     *  *
     * @param ListApiDestinationsRequest $request ListApiDestinationsRequest
     * @return ListApiDestinationsResponse ListApiDestinationsResponse
     */
    public function listApiDestinations($request){
        $runtime = new RuntimeOptions([]);
        return $this->listApiDestinationsWithOptions($request, $runtime);
    }

    /**
     * @summary Creates a connection.
     *  *
     * @description You can call this API operation to create a connection.
     *  *
     * @param CreateConnectionRequest $request CreateConnectionRequest
     * @param RuntimeOptions $runtime runtime options for this request RuntimeOptions
     * @return CreateConnectionResponse CreateConnectionResponse
     */
    public function createConnectionWithOptions($request, $runtime){
        Utils::validateModel($request);
        $body = [];
        if (!Utils::isUnset($request->authParameters)) {
            $body["authParameters"] = $request->authParameters;
        }
        if (!Utils::isUnset($request->connectionName)) {
            $body["connectionName"] = $request->connectionName;
        }
        if (!Utils::isUnset($request->description)) {
            $body["description"] = $request->description;
        }
        if (!Utils::isUnset($request->networkParameters)) {
            $body["networkParameters"] = $request->networkParameters;
        }
        $req = new OpenApiRequest([
            "body" => Utils::toJSONString($body)
        ]);
        $params = new Params([
            "action" => "CreateConnection",
            "version" => "2024-07-01",
            "protocol" => "HTTP",
            "pathname" => "/connection/createConnection",
            "method" => "POST",
            "authType" => "Anonymous",
            "style" => "RPC",
            "reqBodyType" => "json",
            "bodyType" => "json"
        ]);
        return CreateConnectionResponse::fromMap($this->callApi($params, $req, $runtime));
    }

    /**
     * @summary Creates a connection.
     *  *
     * @description You can call this API operation to create a connection.
     *  *
     * @param CreateConnectionRequest $request CreateConnectionRequest
     * @return CreateConnectionResponse CreateConnectionResponse
     */
    public function createConnection($request){
        $runtime = new RuntimeOptions([]);
        return $this->createConnectionWithOptions($request, $runtime);
    }

    /**
     * @summary Deletes a connection.
     *  *
     * @description You can call this API operation to delete a connection.
     *  *
     * @param DeleteConnectionRequest $request DeleteConnectionRequest
     * @param RuntimeOptions $runtime runtime options for this request RuntimeOptions
     * @return DeleteConnectionResponse DeleteConnectionResponse
     */
    public function deleteConnectionWithOptions($request, $runtime){
        Utils::validateModel($request);
        $body = [];
        if (!Utils::isUnset($request->connectionName)) {
            $body["connectionName"] = $request->connectionName;
        }
        $req = new OpenApiRequest([
            "body" => Utils::toJSONString($body)
        ]);
        $params = new Params([
            "action" => "DeleteConnection",
            "version" => "2024-07-01",
            "protocol" => "HTTP",
            "pathname" => "/connection/deleteConnection",
            "method" => "POST",
            "authType" => "Anonymous",
            "style" => "RPC",
            "reqBodyType" => "json",
            "bodyType" => "json"
        ]);
        return DeleteConnectionResponse::fromMap($this->callApi($params, $req, $runtime));
    }

    /**
     * @summary Deletes a connection.
     *  *
     * @description You can call this API operation to delete a connection.
     *  *
     * @param DeleteConnectionRequest $request DeleteConnectionRequest
     * @return DeleteConnectionResponse DeleteConnectionResponse
     */
    public function deleteConnection($request){
        $runtime = new RuntimeOptions([]);
        return $this->deleteConnectionWithOptions($request, $runtime);
    }

    /**
     * @summary Updates a connection.
     *  *
     * @description You can call this API operation to update a connection.
     *  *
     * @param UpdateConnectionRequest $request UpdateConnectionRequest
     * @param RuntimeOptions $runtime runtime options for this request RuntimeOptions
     * @return UpdateConnectionResponse UpdateConnectionResponse
     */
    public function updateConnectionWithOptions($request, $runtime){
        Utils::validateModel($request);
        $body = [];
        if (!Utils::isUnset($request->authParameters)) {
            $body["authParameters"] = $request->authParameters;
        }
        if (!Utils::isUnset($request->connectionName)) {
            $body["connectionName"] = $request->connectionName;
        }
        if (!Utils::isUnset($request->description)) {
            $body["description"] = $request->description;
        }
        if (!Utils::isUnset($request->networkParameters)) {
            $body["networkParameters"] = $request->networkParameters;
        }
        $req = new OpenApiRequest([
            "body" => Utils::toJSONString($body)
        ]);
        $params = new Params([
            "action" => "UpdateConnection",
            "version" => "2024-07-01",
            "protocol" => "HTTP",
            "pathname" => "/connection/updateConnection",
            "method" => "POST",
            "authType" => "Anonymous",
            "style" => "RPC",
            "reqBodyType" => "json",
            "bodyType" => "json"
        ]);
        return UpdateConnectionResponse::fromMap($this->callApi($params, $req, $runtime));
    }

    /**
     * @summary Updates a connection.
     *  *
     * @description You can call this API operation to update a connection.
     *  *
     * @param UpdateConnectionRequest $request UpdateConnectionRequest
     * @return UpdateConnectionResponse UpdateConnectionResponse
     */
    public function updateConnection($request){
        $runtime = new RuntimeOptions([]);
        return $this->updateConnectionWithOptions($request, $runtime);
    }

    /**
     * @summary Queries the configurations of a connection.
     *  *
     * @description You can call this API operation to query the configurations of a connection.
     *  *
     * @param GetConnectionRequest $request GetConnectionRequest
     * @param RuntimeOptions $runtime runtime options for this request RuntimeOptions
     * @return GetConnectionResponse GetConnectionResponse
     */
    public function getConnectionWithOptions($request, $runtime){
        Utils::validateModel($request);
        $body = [];
        if (!Utils::isUnset($request->connectionName)) {
            $body["connectionName"] = $request->connectionName;
        }
        $req = new OpenApiRequest([
            "body" => Utils::toJSONString($body)
        ]);
        $params = new Params([
            "action" => "GetConnection",
            "version" => "2024-07-01",
            "protocol" => "HTTP",
            "pathname" => "/connection/getConnection",
            "method" => "POST",
            "authType" => "Anonymous",
            "style" => "RPC",
            "reqBodyType" => "json",
            "bodyType" => "json"
        ]);
        return GetConnectionResponse::fromMap($this->callApi($params, $req, $runtime));
    }

    /**
     * @summary Queries the configurations of a connection.
     *  *
     * @description You can call this API operation to query the configurations of a connection.
     *  *
     * @param GetConnectionRequest $request GetConnectionRequest
     * @return GetConnectionResponse GetConnectionResponse
     */
    public function getConnection($request){
        $runtime = new RuntimeOptions([]);
        return $this->getConnectionWithOptions($request, $runtime);
    }

    /**
     * @summary Queries the configurations of a connection.
     *  *
     * @description You can call this API operation to query the configurations of a connection.
     *  *
     * @param GetConnectionRequest $request GetConnectionRequest
     * @param RuntimeOptions $runtime runtime options for this request RuntimeOptions
     * @return GetConnectionResponse GetConnectionResponse
     */
    public function selectOneConnectionWithOptions($request, $runtime){
        Utils::validateModel($request);
        $body = [];
        if (!Utils::isUnset($request->connectionName)) {
            $body["connectionName"] = $request->connectionName;
        }
        $req = new OpenApiRequest([
            "body" => Utils::toJSONString($body)
        ]);
        $params = new Params([
            "action" => "selectOneConnection",
            "version" => "2024-07-01",
            "protocol" => "HTTP",
            "pathname" => "/connection/selectOneConnection",
            "method" => "POST",
            "authType" => "Anonymous",
            "style" => "RPC",
            "reqBodyType" => "json",
            "bodyType" => "json"
        ]);
        return GetConnectionResponse::fromMap($this->callApi($params, $req, $runtime));
    }

    /**
     * @summary Queries the configurations of a connection.
     *  *
     * @description You can call this API operation to query the configurations of a connection.
     *  *
     * @param GetConnectionRequest $request GetConnectionRequest
     * @return GetConnectionResponse GetConnectionResponse
     */
    public function selectOneConnection($request){
        $runtime = new RuntimeOptions([]);
        return $this->selectOneConnectionWithOptions($request, $runtime);
    }

    /**
     * @summary Queries connections.
     *  *
     * @description You can call this API operation to query connections.
     *  *
     * @param ListConnectionsRequest $request ListConnectionsRequest
     * @param RuntimeOptions $runtime runtime options for this request RuntimeOptions
     * @return ListConnectionsResponse ListConnectionsResponse
     */
    public function listConnectionsWithOptions($request, $runtime){
        Utils::validateModel($request);
        $body = [];
        if (!Utils::isUnset($request->connectionNamePrefix)) {
            $body["connectionNamePrefix"] = $request->connectionNamePrefix;
        }
        if (!Utils::isUnset($request->maxResults)) {
            $body["maxResults"] = $request->maxResults;
        }
        if (!Utils::isUnset($request->nextToken)) {
            $body["nextToken"] = $request->nextToken;
        }
        $req = new OpenApiRequest([
            "body" => Utils::toJSONString($body)
        ]);
        $params = new Params([
            "action" => "ListConnections",
            "version" => "2024-07-01",
            "protocol" => "HTTP",
            "pathname" => "/connection/listConnections",
            "method" => "POST",
            "authType" => "Anonymous",
            "style" => "RPC",
            "reqBodyType" => "json",
            "bodyType" => "json"
        ]);
        return ListConnectionsResponse::fromMap($this->callApi($params, $req, $runtime));
    }

    /**
     * @summary list connections.
     *  *
     * @description You can call this API operation to list connections.
     *  *
     * @param ListConnectionsRequest $request ListConnectionsRequest
     * @return ListConnectionsResponse ListConnectionsResponse
     */
    public function listConnections($request){
        $runtime = new RuntimeOptions([]);
        return $this->listConnectionsWithOptions($request, $runtime);
    }

    /**
     * @summary Updates a connection.
     *  *
     * @description You can call this API operation to update a connection.
     *  *
     * @return ListEnumsResponseResponse ListEnumsResponseResponse
     */
    public function listEnumsResponse(){
        $runtime = new RuntimeOptions([]);
        $body = [];
        $req = new OpenApiRequest([
            "body" => Utils::toJSONString($body)
        ]);
        $params = new Params([
            "action" => "listEnumsResponse",
            "version" => "2024-07-01",
            "protocol" => "HTTP",
            "pathname" => "/connection/listEnumsResponse",
            "method" => "POST",
            "authType" => "Anonymous",
            "style" => "RPC",
            "reqBodyType" => "json",
            "bodyType" => "json"
        ]);
        return ListEnumsResponseResponse::fromMap($this->callApi($params, $req, $runtime));
    }

    /**
     * @summary Queries the content of an event.
     *  *
     * @description You can call this API operation to query the content of an event.
     *  *
     * @param PutEventsRequest $request PutEventsRequest
     * @param RuntimeOptions $runtime runtime options for this request RuntimeOptions
     * @return PutEventsResponse PutEventsResponse
     */
    public function putEventsWithOptions($request, $runtime){
        Utils::validateModel($request);
        $headers = [
            "ce-specversion" => "1.0",
            "ce-type" => "com.github.pull_request.opened",
            "ce-source" => "https://github.com/cloudevents/spec/pull",
            "ce-subject" => "demo",
            "ce-id" => "1234-1234-1234",
            "ce-datacontenttype" => "application/json",
            "ce-time" => "2024-07-01T17:31:00Z",
            "ce-eventbusname" => "demo-bus"
        ];
        $body = "{}";
        if (!Utils::isUnset($request->eventBusName)) {
            $headers["ce-eventbusname"] = $request->eventBusName;
        }
        if (!Utils::isUnset($request->event)) {
            $body = $request->event;
        }
        $req = new OpenApiRequest([
            "body" => $body,
            "headers" => $headers
        ]);
        $params = new Params([
            "action" => "putEvents",
            "version" => "2024-07-01",
            "protocol" => "HTTP",
            "pathname" => "/putEvents",
            "method" => "POST",
            "authType" => "Anonymous",
            "style" => "RPC",
            "reqBodyType" => "json",
            "bodyType" => "json"
        ]);
        return PutEventsResponse::fromMap($this->callApi($params, $req, $runtime));
    }

    /**
     * @summary Queries the content of an event.
     *  *
     * @description You can call this API operation to query the content of an event.
     *  *
     * @param PutEventsRequest $request PutEventsRequest
     * @return PutEventsResponse PutEventsResponse
     */
    public function putEvents($request){
        $runtime = new RuntimeOptions([]);
        return $this->putEventsWithOptions($request, $runtime);
    }

    /**
     * @summary Creates an event rule.
     *  *
     * @description You can call this operation to create an event rule.
     *  *
     * @param CreateEventRuleRequest $request CreateEventRuleRequest
     * @param RuntimeOptions $runtime runtime options for this request RuntimeOptions
     * @return CreateEventRuleResponse CreateEventRuleResponse
     */
    public function createEventRuleWithOptions($request, $runtime){
        Utils::validateModel($request);
        $body = [];
        if (!Utils::isUnset($request->eventBusName)) {
            $body["eventBusName"] = $request->eventBusName;
        }
        if (!Utils::isUnset($request->eventRuleName)) {
            $body["eventRuleName"] = $request->eventRuleName;
        }
        if (!Utils::isUnset($request->description)) {
            $body["description"] = $request->description;
        }
        if (!Utils::isUnset($request->filterPattern)) {
            $body["filterPattern"] = $request->filterPattern;
        }
        $req = new OpenApiRequest([
            "body" => Utils::toJSONString($body)
        ]);
        $params = new Params([
            "action" => "CreateEventRule",
            "version" => "2024-07-01",
            "protocol" => "HTTP",
            "pathname" => "/rule/createEventRule",
            "method" => "POST",
            "authType" => "Anonymous",
            "style" => "RPC",
            "reqBodyType" => "json",
            "bodyType" => "json"
        ]);
        return CreateEventRuleResponse::fromMap($this->callApi($params, $req, $runtime));
    }

    /**
     * @summary Creates an event rule.
     *  *
     * @description You can call this operation to create an event rule.
     *  *
     * @param CreateEventRuleRequest $request CreateEventRuleRequest
     * @return CreateEventRuleResponse CreateEventRuleResponse
     */
    public function createEventRule($request){
        $runtime = new RuntimeOptions([]);
        return $this->createEventRuleWithOptions($request, $runtime);
    }

    /**
     * @summary Gets an event rule.
     *  *
     * @description You can call this operation to get an event rule.
     *  *
     * @param GetEventRuleRequest $request GetEventRuleRequest
     * @param RuntimeOptions $runtime runtime options for this request RuntimeOptions
     * @return GetEventRuleResponse GetEventRuleResponse
     */
    public function getEventRuleWithOptions($request, $runtime){
        Utils::validateModel($request);
        $body = [];
        if (!Utils::isUnset($request->eventBusName)) {
            $body["eventBusName"] = $request->eventBusName;
        }
        if (!Utils::isUnset($request->eventRuleName)) {
            $body["eventRuleName"] = $request->eventRuleName;
        }
        $req = new OpenApiRequest([
            "body" => Utils::toJSONString($body)
        ]);
        $params = new Params([
            "action" => "GetEventRule",
            "version" => "2024-07-01",
            "protocol" => "HTTP",
            "pathname" => "/rule/getEventRule",
            "method" => "POST",
            "authType" => "Anonymous",
            "style" => "RPC",
            "reqBodyType" => "json",
            "bodyType" => "json"
        ]);
        return GetEventRuleResponse::fromMap($this->callApi($params, $req, $runtime));
    }

    /**
     * @summary Gets an event rule.
     *  *
     * @description You can call this operation to get an event rule.
     *  *
     * @param GetEventRuleRequest $request GetEventRuleRequest
     * @return GetEventRuleResponse GetEventRuleResponse
     */
    public function getEventRule($request){
        $runtime = new RuntimeOptions([]);
        return $this->getEventRuleWithOptions($request, $runtime);
    }

    /**
     * @summary Deletes an event rule.
     *  *
     * @description You can call this operation to delete an event rule.
     *  *
     * @param DeleteEventRuleRequest $request DeleteEventRuleRequest
     * @param RuntimeOptions $runtime runtime options for this request RuntimeOptions
     * @return DeleteEventRuleResponse DeleteEventRuleResponse
     */
    public function deleteEventRuleWithOptions($request, $runtime){
        Utils::validateModel($request);
        $body = [];
        if (!Utils::isUnset($request->eventBusName)) {
            $body["eventBusName"] = $request->eventBusName;
        }
        if (!Utils::isUnset($request->eventRuleName)) {
            $body["eventRuleName"] = $request->eventRuleName;
        }
        $req = new OpenApiRequest([
            "body" => Utils::toJSONString($body)
        ]);
        $params = new Params([
            "action" => "DeleteEventRule",
            "version" => "2024-07-01",
            "protocol" => "HTTP",
            "pathname" => "/rule/deleteEventRule",
            "method" => "POST",
            "authType" => "Anonymous",
            "style" => "RPC",
            "reqBodyType" => "json",
            "bodyType" => "json"
        ]);
        return DeleteEventRuleResponse::fromMap($this->callApi($params, $req, $runtime));
    }

    /**
     * @summary Deletes an event rule.
     *  *
     * @description You can call this operation to delete an event rule.
     *  *
     * @param DeleteEventRuleRequest $request DeleteEventRuleRequest
     * @return DeleteEventRuleResponse DeleteEventRuleResponse
     */
    public function deleteEventRule($request){
        $runtime = new RuntimeOptions([]);
        return $this->deleteEventRuleWithOptions($request, $runtime);
    }

    /**
     * @summary Updates an event rule.
     *  *
     * @description You can call this operation to update an event rule.
     *  *
     * @param UpdateEventRuleRequest $request UpdateEventRuleRequest
     * @param RuntimeOptions $runtime runtime options for this request RuntimeOptions
     * @return UpdateEventRuleResponse UpdateEventRuleResponse
     */
    public function updateEventRuleWithOptions($request, $runtime){
        Utils::validateModel($request);
        $body = [];
        if (!Utils::isUnset($request->eventBusName)) {
            $body["eventBusName"] = $request->eventBusName;
        }
        if (!Utils::isUnset($request->eventRuleName)) {
            $body["eventRuleName"] = $request->eventRuleName;
        }
        if (!Utils::isUnset($request->description)) {
            $body["description"] = $request->description;
        }
        if (!Utils::isUnset($request->filterPattern)) {
            $body["filterPattern"] = $request->filterPattern;
        }
        $req = new OpenApiRequest([
            "body" => Utils::toJSONString($body)
        ]);
        $params = new Params([
            "action" => "UpdateEventRule",
            "version" => "2024-07-01",
            "protocol" => "HTTP",
            "pathname" => "/rule/updateEventRule",
            "method" => "POST",
            "authType" => "Anonymous",
            "style" => "RPC",
            "reqBodyType" => "json",
            "bodyType" => "json"
        ]);
        return UpdateEventRuleResponse::fromMap($this->callApi($params, $req, $runtime));
    }

    /**
     * @summary Updates an event rule.
     *  *
     * @description You can call this operation to update an event rule.
     *  *
     * @param UpdateEventRuleRequest $request UpdateEventRuleRequest
     * @return UpdateEventRuleResponse UpdateEventRuleResponse
     */
    public function updateEventRule($request){
        $runtime = new RuntimeOptions([]);
        return $this->updateEventRuleWithOptions($request, $runtime);
    }

    /**
     * @summary Lists event rules.
     *  *
     * @description You can call this operation to list event rules.
     *  *
     * @param ListEventRulesRequest $request ListEventRulesRequest
     * @param RuntimeOptions $runtime runtime options for this request RuntimeOptions
     * @return ListEventRulesResponse ListEventRulesResponse
     */
    public function listEventRulesWithOptions($request, $runtime){
        Utils::validateModel($request);
        $body = [];
        if (!Utils::isUnset($request->eventBusName)) {
            $body["eventBusName"] = $request->eventBusName;
        }
        if (!Utils::isUnset($request->maxResults)) {
            $body["maxResults"] = $request->maxResults;
        }
        if (!Utils::isUnset($request->nextToken)) {
            $body["nextToken"] = $request->nextToken;
        }
        $req = new OpenApiRequest([
            "body" => Utils::toJSONString($body)
        ]);
        $params = new Params([
            "action" => "ListEventRules",
            "version" => "2024-07-01",
            "protocol" => "HTTP",
            "pathname" => "/rule/listEventRules",
            "method" => "POST",
            "authType" => "Anonymous",
            "style" => "RPC",
            "reqBodyType" => "json",
            "bodyType" => "json"
        ]);
        return ListEventRulesResponse::fromMap($this->callApi($params, $req, $runtime));
    }

    /**
     * @summary Lists event rules.
     *  *
     * @description You can call this operation to list event rules.
     *  *
     * @param ListEventRulesRequest $request ListEventRulesRequest
     * @return ListEventRulesResponse ListEventRulesResponse
     */
    public function listEventRules($request){
        $runtime = new RuntimeOptions([]);
        return $this->listEventRulesWithOptions($request, $runtime);
    }

    /**
     * @summary Enables an event rule.
     *  *
     * @description You can call this operation to enable an event rule.
     *  *
     * @param EnableEventRuleRequest $request EnableEventRuleRequest
     * @param RuntimeOptions $runtime runtime options for this request RuntimeOptions
     * @return EnableEventRuleResponse EnableEventRuleResponse
     */
    public function enableEventRuleWithOptions($request, $runtime){
        Utils::validateModel($request);
        $body = [];
        if (!Utils::isUnset($request->eventBusName)) {
            $body["eventBusName"] = $request->eventBusName;
        }
        if (!Utils::isUnset($request->eventRuleName)) {
            $body["eventRuleName"] = $request->eventRuleName;
        }
        $req = new OpenApiRequest([
            "body" => Utils::toJSONString($body)
        ]);
        $params = new Params([
            "action" => "EnableEventRule",
            "version" => "2024-07-01",
            "protocol" => "HTTP",
            "pathname" => "/rule/enableEventRule",
            "method" => "POST",
            "authType" => "Anonymous",
            "style" => "RPC",
            "reqBodyType" => "json",
            "bodyType" => "json"
        ]);
        return EnableEventRuleResponse::fromMap($this->callApi($params, $req, $runtime));
    }

    /**
     * @summary Enables an event rule.
     *  *
     * @description You can call this operation to enable an event rule.
     *  *
     * @param EnableEventRuleRequest $request EnableEventRuleRequest
     * @return EnableEventRuleResponse EnableEventRuleResponse
     */
    public function enableEventRule($request){
        $runtime = new RuntimeOptions([]);
        return $this->enableEventRuleWithOptions($request, $runtime);
    }

    /**
     * @summary Disables an event rule.
     *  *
     * @description You can call this operation to disable an event rule.
     *  *
     * @param DisableEventRuleRequest $request DisableEventRuleRequest
     * @param RuntimeOptions $runtime runtime options for this request RuntimeOptions
     * @return DisableEventRuleResponse DisableEventRuleResponse
     */
    public function disableEventRuleWithOptions($request, $runtime){
        Utils::validateModel($request);
        $body = [];
        if (!Utils::isUnset($request->eventBusName)) {
            $body["eventBusName"] = $request->eventBusName;
        }
        if (!Utils::isUnset($request->eventRuleName)) {
            $body["eventRuleName"] = $request->eventRuleName;
        }
        $req = new OpenApiRequest([
            "body" => Utils::toJSONString($body)
        ]);
        $params = new Params([
            "action" => "DisableEventRule",
            "version" => "2024-07-01",
            "protocol" => "HTTP",
            "pathname" => "/rule/disableEventRule",
            "method" => "POST",
            "authType" => "Anonymous",
            "style" => "RPC",
            "reqBodyType" => "json",
            "bodyType" => "json"
        ]);
        return DisableEventRuleResponse::fromMap($this->callApi($params, $req, $runtime));
    }

    /**
     * @summary Disables an event rule.
     *  *
     * @description You can call this operation to disable an event rule.
     *  *
     * @param DisableEventRuleRequest $request DisableEventRuleRequest
     * @return DisableEventRuleResponse DisableEventRuleResponse
     */
    public function disableEventRule($request){
        $runtime = new RuntimeOptions([]);
        return $this->disableEventRuleWithOptions($request, $runtime);
    }

    /**
     * @summary Creates an event source.
     *  *
     * @description You can call this operation to create an event source.
     *  *
     * @param CreateEventSourceRequest $request CreateEventSourceRequest
     * @param RuntimeOptions $runtime runtime options for this request RuntimeOptions
     * @return CreateEventSourceResponse CreateEventSourceResponse
     */
    public function createEventSourceWithOptions($request, $runtime){
        Utils::validateModel($request);
        $body = [];
        if (!Utils::isUnset($request->description)) {
            $body["description"] = $request->description;
        }
        if (!Utils::isUnset($request->eventBusName)) {
            $body["eventBusName"] = $request->eventBusName;
        }
        if (!Utils::isUnset($request->eventSourceName)) {
            $body["eventSourceName"] = $request->eventSourceName;
        }
        if (!Utils::isUnset($request->className)) {
            $body["className"] = $request->className;
        }
        if (!Utils::isUnset($request->config)) {
            $body["config"] = $request->config;
        }
        $req = new OpenApiRequest([
            "body" => Utils::toJSONString($body)
        ]);
        $params = new Params([
            "action" => "CreateEventSource",
            "version" => "2024-07-01",
            "protocol" => "HTTP",
            "pathname" => "/source/createEventSource",
            "method" => "POST",
            "authType" => "Anonymous",
            "style" => "RPC",
            "reqBodyType" => "json",
            "bodyType" => "json"
        ]);
        return CreateEventSourceResponse::fromMap($this->callApi($params, $req, $runtime));
    }

    /**
     * @summary Creates an event source.
     *  *
     * @description You can call this operation to create an event source.
     *  *
     * @param CreateEventSourceRequest $request CreateEventSourceRequest
     * @return CreateEventSourceResponse CreateEventSourceResponse
     */
    public function createEventSource($request){
        $runtime = new RuntimeOptions([]);
        return $this->createEventSourceWithOptions($request, $runtime);
    }

    /**
     * @summary Updates an event source.
     *  *
     * @description You can call this operation to update an event source.
     *  *
     * @param UpdateEventSourceRequest $request UpdateEventSourceRequest
     * @param RuntimeOptions $runtime runtime options for this request RuntimeOptions
     * @return UpdateEventSourceResponse UpdateEventSourceResponse
     */
    public function updateEventSourceWithOptions($request, $runtime){
        Utils::validateModel($request);
        $body = [];
        if (!Utils::isUnset($request->eventBusName)) {
            $body["eventBusName"] = $request->eventBusName;
        }
        if (!Utils::isUnset($request->eventSourceName)) {
            $body["eventSourceName"] = $request->eventSourceName;
        }
        if (!Utils::isUnset($request->description)) {
            $body["description"] = $request->description;
        }
        if (!Utils::isUnset($request->className)) {
            $body["className"] = $request->className;
        }
        if (!Utils::isUnset($request->status)) {
            $body["status"] = $request->status;
        }
        if (!Utils::isUnset($request->config)) {
            $body["config"] = $request->config;
        }
        $req = new OpenApiRequest([
            "body" => Utils::toJSONString($body)
        ]);
        $params = new Params([
            "action" => "UpdateEventSource",
            "version" => "2024-07-01",
            "protocol" => "HTTP",
            "pathname" => "/source/updateEventSource",
            "method" => "POST",
            "authType" => "Anonymous",
            "style" => "RPC",
            "reqBodyType" => "json",
            "bodyType" => "json"
        ]);
        return UpdateEventSourceResponse::fromMap($this->callApi($params, $req, $runtime));
    }

    /**
     * @summary Updates an event source.
     *  *
     * @description You can call this operation to update an event source.
     *  *
     * @param UpdateEventSourceRequest $request UpdateEventSourceRequest
     * @return UpdateEventSourceResponse UpdateEventSourceResponse
     */
    public function updateEventSource($request){
        $runtime = new RuntimeOptions([]);
        return $this->updateEventSourceWithOptions($request, $runtime);
    }

    /**
     * @summary Deletes an event source.
     *  *
     * @description You can call this API operation to delete an event source.
     *  *
     * @param DeleteEventSourceRequest $request DeleteEventSourceRequest
     * @param RuntimeOptions $runtime runtime options for this request RuntimeOptions
     * @return DeleteEventSourceResponse DeleteEventSourceResponse
     */
    public function deleteEventSourceWithOptions($request, $runtime){
        Utils::validateModel($request);
        $body = [];
        if (!Utils::isUnset($request->eventBusName)) {
            $body["eventBusName"] = $request->eventBusName;
        }
        if (!Utils::isUnset($request->eventSourceName)) {
            $body["eventSourceName"] = $request->eventSourceName;
        }
        $req = new OpenApiRequest([
            "body" => Utils::toJSONString($body)
        ]);
        $params = new Params([
            "action" => "DeleteEventSource",
            "version" => "2024-07-01",
            "protocol" => "HTTP",
            "pathname" => "/source/deleteEventSource",
            "method" => "POST",
            "authType" => "Anonymous",
            "style" => "RPC",
            "reqBodyType" => "json",
            "bodyType" => "json"
        ]);
        return DeleteEventSourceResponse::fromMap($this->callApi($params, $req, $runtime));
    }

    /**
     * @summary Deletes an event source.
     *  *
     * @description You can call this API operation to delete an event source.
     *  *
     * @param DeleteEventSourceRequest $request DeleteEventSourceRequest
     * @return DeleteEventSourceResponse DeleteEventSourceResponse
     */
    public function deleteEventSource($request){
        $runtime = new RuntimeOptions([]);
        return $this->deleteEventSourceWithOptions($request, $runtime);
    }

    /**
     * @summary Gets an event source.
     *  *
     * @description You can call this API operation to get an event source.
     *  *
     * @param GetEventSourceRequest $request GetEventSourceRequest
     * @param RuntimeOptions $runtime runtime options for this request RuntimeOptions
     * @return GetEventSourceResponse GetEventSourceResponse
     */
    public function getEventSourceWithOptions($request, $runtime){
        Utils::validateModel($request);
        $body = [];
        if (!Utils::isUnset($request->eventBusName)) {
            $body["eventBusName"] = $request->eventBusName;
        }
        if (!Utils::isUnset($request->eventSourceName)) {
            $body["eventSourceName"] = $request->eventSourceName;
        }
        $req = new OpenApiRequest([
            "body" => Utils::toJSONString($body)
        ]);
        $params = new Params([
            "action" => "GetEventSource",
            "version" => "2024-07-01",
            "protocol" => "HTTP",
            "pathname" => "/source/getEventSource",
            "method" => "POST",
            "authType" => "Anonymous",
            "style" => "RPC",
            "reqBodyType" => "json",
            "bodyType" => "json"
        ]);
        return GetEventSourceResponse::fromMap($this->callApi($params, $req, $runtime));
    }

    /**
     * @summary Gets an event source.
     *  *
     * @description You can call this API operation to get an event source.
     *  *
     * @param GetEventSourceRequest $request GetEventSourceRequest
     * @return GetEventSourceResponse GetEventSourceResponse
     */
    public function getEventSource($request){
        $runtime = new RuntimeOptions([]);
        return $this->getEventSourceWithOptions($request, $runtime);
    }

    /**
     * @summary Lists event sources.
     *  *
     * @description You can call this API operation to list event sources.
     *  *
     * @param ListEventSourcesRequest $request ListEventSourcesRequest
     * @param RuntimeOptions $runtime runtime options for this request RuntimeOptions
     * @return ListEventSourcesResponse ListEventSourcesResponse
     */
    public function listEventSourcesWithOptions($request, $runtime){
        Utils::validateModel($request);
        $body = [];
        if (!Utils::isUnset($request->eventBusName)) {
            $body["eventBusName"] = $request->eventBusName;
        }
        if (!Utils::isUnset($request->eventSourceType)) {
            $body["eventSourceType"] = $request->eventSourceType;
        }
        if (!Utils::isUnset($request->maxResults)) {
            $body["maxResults"] = $request->maxResults;
        }
        if (!Utils::isUnset($request->nextToken)) {
            $body["nextToken"] = $request->nextToken;
        }
        $req = new OpenApiRequest([
            "body" => Utils::toJSONString($body)
        ]);
        $params = new Params([
            "action" => "ListEventSources",
            "version" => "2024-07-01",
            "protocol" => "HTTP",
            "pathname" => "/source/listEventSources",
            "method" => "POST",
            "authType" => "Anonymous",
            "style" => "RPC",
            "reqBodyType" => "json",
            "bodyType" => "json"
        ]);
        return ListEventSourcesResponse::fromMap($this->callApi($params, $req, $runtime));
    }

    /**
     * @summary Lists event sources.
     *  *
     * @description You can call this API operation to list event sources.
     *  *
     * @param ListEventSourcesRequest $request ListEventSourcesRequest
     * @return ListEventSourcesResponse ListEventSourcesResponse
     */
    public function listEventSources($request){
        $runtime = new RuntimeOptions([]);
        return $this->listEventSourcesWithOptions($request, $runtime);
    }

    /**
     * @summary Creates event targets.
     *  *
     * @description You can call this operation to create event targets.
     *  *
     * @param CreateEventTargetsRequest $request CreateEventTargetsRequest
     * @param RuntimeOptions $runtime runtime options for this request RuntimeOptions
     * @return CreateEventTargetsResponse CreateEventTargetsResponse
     */
    public function createEventTargetsWithOptions($request, $runtime){
        Utils::validateModel($request);
        $body = [];
        if (!Utils::isUnset($request->eventBusName)) {
            $body["eventBusName"] = $request->eventBusName;
        }
        if (!Utils::isUnset($request->eventRuleName)) {
            $body["eventRuleName"] = $request->eventRuleName;
        }
        if (!Utils::isUnset($request->eventTargets)) {
            $body["eventTargets"] = $request->eventTargets;
        }
        $req = new OpenApiRequest([
            "body" => Utils::toJSONString($body)
        ]);
        $params = new Params([
            "action" => "CreateEventTargets",
            "version" => "2024-07-01",
            "protocol" => "HTTP",
            "pathname" => "/target/createEventTargets",
            "method" => "POST",
            "authType" => "Anonymous",
            "style" => "RPC",
            "reqBodyType" => "json",
            "bodyType" => "json"
        ]);
        return CreateEventTargetsResponse::fromMap($this->callApi($params, $req, $runtime));
    }

    /**
     * @summary Creates event targets.
     *  *
     * @description You can call this operation to create event targets.
     *  *
     * @param CreateEventTargetsRequest $request CreateEventTargetsRequest
     * @return CreateEventTargetsResponse CreateEventTargetsResponse
     */
    public function createEventTargets($request){
        $runtime = new RuntimeOptions([]);
        return $this->createEventTargetsWithOptions($request, $runtime);
    }

    /**
     * @summary Updates event targets.
     *  *
     * @description You can call this operation to update event targets.
     *  *
     * @param UpdateEventTargetsRequest $request UpdateEventTargetsRequest
     * @param RuntimeOptions $runtime runtime options for this request RuntimeOptions
     * @return UpdateEventTargetsResponse UpdateEventTargetsResponse
     */
    public function updateEventTargetsWithOptions($request, $runtime){
        Utils::validateModel($request);
        $body = [];
        if (!Utils::isUnset($request->eventBusName)) {
            $body["eventBusName"] = $request->eventBusName;
        }
        if (!Utils::isUnset($request->eventRuleName)) {
            $body["eventRuleName"] = $request->eventRuleName;
        }
        if (!Utils::isUnset($request->eventTargets)) {
            $body["eventTargets"] = $request->eventTargets;
        }
        $req = new OpenApiRequest([
            "body" => Utils::toJSONString($body)
        ]);
        $params = new Params([
            "action" => "UpdateEventTargets",
            "version" => "2024-07-01",
            "protocol" => "HTTP",
            "pathname" => "/target/updateEventTargets",
            "method" => "POST",
            "authType" => "Anonymous",
            "style" => "RPC",
            "reqBodyType" => "json",
            "bodyType" => "json"
        ]);
        return UpdateEventTargetsResponse::fromMap($this->callApi($params, $req, $runtime));
    }

    /**
     * @summary Updates event targets.
     *  *
     * @description You can call this operation to update event targets.
     *  *
     * @param UpdateEventTargetsRequest $request UpdateEventTargetsRequest
     * @return UpdateEventTargetsResponse UpdateEventTargetsResponse
     */
    public function updateEventTargets($request){
        $runtime = new RuntimeOptions([]);
        return $this->updateEventTargetsWithOptions($request, $runtime);
    }

    /**
     * @summary Deletes event targets.
     *  *
     * @description You can call this operation to delete event targets.
     *  *
     * @param DeleteEventTargetsRequest $request DeleteEventTargetsRequest
     * @param RuntimeOptions $runtime runtime options for this request RuntimeOptions
     * @return DeleteEventTargetsResponse DeleteEventTargetsResponse
     */
    public function deleteEventTargetsWithOptions($request, $runtime){
        Utils::validateModel($request);
        $body = [];
        if (!Utils::isUnset($request->eventBusName)) {
            $body["eventBusName"] = $request->eventBusName;
        }
        if (!Utils::isUnset($request->eventRuleName)) {
            $body["eventRuleName"] = $request->eventRuleName;
        }
        if (!Utils::isUnset($request->eventTargetNames)) {
            $body["eventTargetNames"] = $request->eventTargetNames;
        }
        $req = new OpenApiRequest([
            "body" => Utils::toJSONString($body)
        ]);
        $params = new Params([
            "action" => "DeleteEventTargets",
            "version" => "2024-07-01",
            "protocol" => "HTTP",
            "pathname" => "/target/deleteEventTargets",
            "method" => "POST",
            "authType" => "Anonymous",
            "style" => "RPC",
            "reqBodyType" => "json",
            "bodyType" => "json"
        ]);
        return DeleteEventTargetsResponse::fromMap($this->callApi($params, $req, $runtime));
    }

    /**
     * @summary Deletes event targets.
     *  *
     * @description You can call this operation to delete event targets.
     *  *
     * @param DeleteEventTargetsRequest $request DeleteEventTargetsRequest
     * @return DeleteEventTargetsResponse DeleteEventTargetsResponse
     */
    public function deleteEventTargets($request){
        $runtime = new RuntimeOptions([]);
        return $this->deleteEventTargetsWithOptions($request, $runtime);
    }

    /**
     * @summary Lists event targets.
     *  *
     * @description You can call this operation to list event targets.
     *  *
     * @param ListEventTargetsRequest $request ListEventTargetsRequest
     * @param RuntimeOptions $runtime runtime options for this request RuntimeOptions
     * @return ListEventTargetsResponse ListEventTargetsResponse
     */
    public function listEventTargetsWithOptions($request, $runtime){
        Utils::validateModel($request);
        $body = [];
        if (!Utils::isUnset($request->eventBusName)) {
            $body["eventBusName"] = $request->eventBusName;
        }
        if (!Utils::isUnset($request->eventRuleName)) {
            $body["eventRuleName"] = $request->eventRuleName;
        }
        $req = new OpenApiRequest([
            "body" => Utils::toJSONString($body)
        ]);
        $params = new Params([
            "action" => "ListEventTargets",
            "version" => "2024-07-01",
            "protocol" => "HTTP",
            "pathname" => "/target/listEventTargets",
            "method" => "POST",
            "authType" => "Anonymous",
            "style" => "RPC",
            "reqBodyType" => "json",
            "bodyType" => "json"
        ]);
        return ListEventTargetsResponse::fromMap($this->callApi($params, $req, $runtime));
    }

    /**
     * @summary Lists event targets.
     *  *
     * @description You can call this operation to list event targets.
     *  *
     * @param ListEventTargetsRequest $request ListEventTargetsRequest
     * @return ListEventTargetsResponse ListEventTargetsResponse
     */
    public function listEventTargets($request){
        $runtime = new RuntimeOptions([]);
        return $this->listEventTargetsWithOptions($request, $runtime);
    }

    /**
     * @summary Queries all event buses.
     *  *
     * @description You can call this API operation to query all event buses.
     *  *
     * @param ListEventTypesRequest $request ListEventTypesRequest
     * @param RuntimeOptions $runtime runtime options for this request RuntimeOptions
     * @return ListEventTypesResponse ListEventTypesResponse
     */
    public function listEventTypesWithOptions($request, $runtime){
        Utils::validateModel($request);
        $body = [];
        if (!Utils::isUnset($request->eventBusName)) {
            $body["eventBusName"] = $request->eventBusName;
        }
        if (!Utils::isUnset($request->eventSourceName)) {
            $body["eventSourceName"] = $request->eventSourceName;
        }
        if (!Utils::isUnset($request->maxResults)) {
            $body["maxResults"] = $request->maxResults;
        }
        if (!Utils::isUnset($request->nextToken)) {
            $body["nextToken"] = $request->nextToken;
        }
        $req = new OpenApiRequest([
            "body" => Utils::toJSONString($body)
        ]);
        $params = new Params([
            "action" => "listEventTypes",
            "version" => "2024-07-01",
            "protocol" => "HTTP",
            "pathname" => "/type/listEventTypes",
            "method" => "POST",
            "authType" => "Anonymous",
            "style" => "RPC",
            "reqBodyType" => "json",
            "bodyType" => "json"
        ]);
        return ListEventTypesResponse::fromMap($this->callApi($params, $req, $runtime));
    }

    /**
     * @summary Queries all event buses.
     *  *
     * @description You can call this API operation to query all event buses.
     *  *
     * @param ListEventTypesRequest $request ListEventTypesRequest
     * @return ListEventTypesResponse ListEventTypesResponse
     */
    public function listEventTypes($request){
        $runtime = new RuntimeOptions([]);
        return $this->listEventTypesWithOptions($request, $runtime);
    }
}
