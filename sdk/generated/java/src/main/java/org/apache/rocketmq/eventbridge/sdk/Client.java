// This file is auto-generated, don't edit it. Thanks.
package org.apache.rocketmq.eventbridge.sdk;

import com.aliyun.tea.*;
import org.apache.rocketmq.eventbridge.sdk.models.*;

public class Client extends com.aliyun.teaopenapi.Client {

    public Client(com.aliyun.teaopenapi.models.Config config) throws Exception {
        super(config);
        this._endpointRule = "";
        this.checkConfig(config);
        this._endpoint = this.getEndpoint("eventbridge", _regionId, _endpointRule, _network, _suffix, _endpointMap, _endpoint);
    }


    public String getEndpoint(String productId, String regionId, String endpointRule, String network, String suffix, java.util.Map<String, String> endpointMap, String endpoint) throws Exception {
        if (!com.aliyun.teautil.Common.empty(endpoint)) {
            return endpoint;
        }

        if (!com.aliyun.teautil.Common.isUnset(endpointMap) && !com.aliyun.teautil.Common.empty(endpointMap.get(regionId))) {
            return endpointMap.get(regionId);
        }

        String result = "";
        if (!com.aliyun.teautil.Common.empty(network) && !com.aliyun.teautil.Common.equalString(network, "public")) {
            network = "-" + network + "";
        } else {
            network = "";
        }

        if (!com.aliyun.teautil.Common.isUnset(suffix)) {
            suffix = "";
        } else {
            suffix = "-" + suffix + "";
        }

        if (com.aliyun.teautil.Common.equalString(endpointRule, "regional")) {
            if (com.aliyun.teautil.Common.empty(regionId)) {
                throw new TeaException(TeaConverter.buildMap(
                    new TeaPair("message", "RegionId is empty, please set a valid RegionId")
                ));
            }

            result = "" + productId + "" + suffix + "" + network + "." + regionId + ".aliyuncs.com";
        } else {
            result = "" + productId + "" + suffix + "" + network + ".aliyuncs.com";
        }

        return result;
        // return EndpointUtil.getEndpointRules(productId, regionId, endpointRule, network, suffix);
    }

    /**
     * <b>description</b> :
     * <p>You can call this API operation to create an event bus.</p>
     * 
     * <b>summary</b> : 
     * <p>Creates an event bus.</p>
     * 
     * @param request CreateEventBusRequest
     * @param runtime runtime options for this request RuntimeOptions
     * @return CreateEventBusResponse
     */
    public CreateEventBusResponse createEventBusWithOptions(CreateEventBusRequest request, com.aliyun.teautil.models.RuntimeOptions runtime) throws Exception {
        com.aliyun.teautil.Common.validateModel(request);
        java.util.Map<String, Object> body = new java.util.HashMap<>();
        if (!com.aliyun.teautil.Common.isUnset(request.description)) {
            body.put("description", request.description);
        }

        if (!com.aliyun.teautil.Common.isUnset(request.eventBusName)) {
            body.put("eventBusName", request.eventBusName);
        }

        com.aliyun.teaopenapi.models.OpenApiRequest req = com.aliyun.teaopenapi.models.OpenApiRequest.build(TeaConverter.buildMap(
            new TeaPair("body", com.aliyun.teautil.Common.toJSONString(body))
        ));
        com.aliyun.teaopenapi.models.Params params = com.aliyun.teaopenapi.models.Params.build(TeaConverter.buildMap(
            new TeaPair("action", "CreateEventBus"),
            new TeaPair("version", "2024-07-01"),
            new TeaPair("protocol", "HTTP"),
            new TeaPair("pathname", "/bus/createEventBus"),
            new TeaPair("method", "POST"),
            new TeaPair("authType", "Anonymous"),
            new TeaPair("style", "RPC"),
            new TeaPair("reqBodyType", "json"),
            new TeaPair("bodyType", "json")
        ));
        return TeaModel.toModel(this.callApi(params, req, runtime), new CreateEventBusResponse());
    }

    /**
     * <b>description</b> :
     * <p>You can call this API operation to create an event bus.</p>
     * 
     * <b>summary</b> : 
     * <p>Creates an event bus.</p>
     * 
     * @param request CreateEventBusRequest
     * @return CreateEventBusResponse
     */
    public CreateEventBusResponse createEventBus(CreateEventBusRequest request) throws Exception {
        com.aliyun.teautil.models.RuntimeOptions runtime = new com.aliyun.teautil.models.RuntimeOptions();
        return this.createEventBusWithOptions(request, runtime);
    }

    /**
     * <b>description</b> :
     * <p>You can call this API operation to query the detailed information about an event bus.</p>
     * 
     * <b>summary</b> : 
     * <p>Queries the detailed information about an event bus.</p>
     * 
     * @param request GetEventBusRequest
     * @param runtime runtime options for this request RuntimeOptions
     * @return GetEventBusResponse
     */
    public GetEventBusResponse getEventBusWithOptions(GetEventBusRequest request, com.aliyun.teautil.models.RuntimeOptions runtime) throws Exception {
        com.aliyun.teautil.Common.validateModel(request);
        java.util.Map<String, Object> body = new java.util.HashMap<>();
        if (!com.aliyun.teautil.Common.isUnset(request.eventBusName)) {
            body.put("eventBusName", request.eventBusName);
        }

        com.aliyun.teaopenapi.models.OpenApiRequest req = com.aliyun.teaopenapi.models.OpenApiRequest.build(TeaConverter.buildMap(
            new TeaPair("body", com.aliyun.teautil.Common.toJSONString(body))
        ));
        com.aliyun.teaopenapi.models.Params params = com.aliyun.teaopenapi.models.Params.build(TeaConverter.buildMap(
            new TeaPair("action", "GetEventBus"),
            new TeaPair("version", "2024-07-01"),
            new TeaPair("protocol", "HTTP"),
            new TeaPair("pathname", "/bus/getEventBus"),
            new TeaPair("method", "POST"),
            new TeaPair("authType", "Anonymous"),
            new TeaPair("style", "RPC"),
            new TeaPair("reqBodyType", "json"),
            new TeaPair("bodyType", "json")
        ));
        return TeaModel.toModel(this.callApi(params, req, runtime), new GetEventBusResponse());
    }

    /**
     * <b>description</b> :
     * <p>You can call this API operation to query the detailed information about an event bus.</p>
     * 
     * <b>summary</b> : 
     * <p>Queries the detailed information about an event bus.</p>
     * 
     * @param request GetEventBusRequest
     * @return GetEventBusResponse
     */
    public GetEventBusResponse getEventBus(GetEventBusRequest request) throws Exception {
        com.aliyun.teautil.models.RuntimeOptions runtime = new com.aliyun.teautil.models.RuntimeOptions();
        return this.getEventBusWithOptions(request, runtime);
    }

    /**
     * <b>description</b> :
     * <p>You can call this API operation to query all event buses.</p>
     * 
     * <b>summary</b> : 
     * <p>Queries all event buses.</p>
     * 
     * @param request ListEventBusesRequest
     * @param runtime runtime options for this request RuntimeOptions
     * @return ListEventBusesResponse
     */
    public ListEventBusesResponse listEventBusesWithOptions(ListEventBusesRequest request, com.aliyun.teautil.models.RuntimeOptions runtime) throws Exception {
        com.aliyun.teautil.Common.validateModel(request);
        java.util.Map<String, Object> body = new java.util.HashMap<>();
        if (!com.aliyun.teautil.Common.isUnset(request.maxResults)) {
            body.put("maxResults", request.maxResults);
        }

        if (!com.aliyun.teautil.Common.isUnset(request.nextToken)) {
            body.put("nextToken", request.nextToken);
        }

        com.aliyun.teaopenapi.models.OpenApiRequest req = com.aliyun.teaopenapi.models.OpenApiRequest.build(TeaConverter.buildMap(
            new TeaPair("body", com.aliyun.teautil.Common.toJSONString(body))
        ));
        com.aliyun.teaopenapi.models.Params params = com.aliyun.teaopenapi.models.Params.build(TeaConverter.buildMap(
            new TeaPair("action", "ListEventBuses"),
            new TeaPair("version", "2024-07-01"),
            new TeaPair("protocol", "HTTP"),
            new TeaPair("pathname", "/bus/listEventBuses"),
            new TeaPair("method", "POST"),
            new TeaPair("authType", "Anonymous"),
            new TeaPair("style", "RPC"),
            new TeaPair("reqBodyType", "json"),
            new TeaPair("bodyType", "json")
        ));
        return TeaModel.toModel(this.callApi(params, req, runtime), new ListEventBusesResponse());
    }

    /**
     * <b>description</b> :
     * <p>You can call this API operation to query all event buses.</p>
     * 
     * <b>summary</b> : 
     * <p>Queries all event buses.</p>
     * 
     * @param request ListEventBusesRequest
     * @return ListEventBusesResponse
     */
    public ListEventBusesResponse listEventBuses(ListEventBusesRequest request) throws Exception {
        com.aliyun.teautil.models.RuntimeOptions runtime = new com.aliyun.teautil.models.RuntimeOptions();
        return this.listEventBusesWithOptions(request, runtime);
    }

    /**
     * <b>description</b> :
     * <p>You can call this API operation to delete an event bus.</p>
     * 
     * <b>summary</b> : 
     * <p>Deletes an event bus.</p>
     * 
     * @param request DeleteEventBusRequest
     * @param runtime runtime options for this request RuntimeOptions
     * @return DeleteEventBusResponse
     */
    public DeleteEventBusResponse deleteEventBusWithOptions(DeleteEventBusRequest request, com.aliyun.teautil.models.RuntimeOptions runtime) throws Exception {
        com.aliyun.teautil.Common.validateModel(request);
        java.util.Map<String, Object> body = new java.util.HashMap<>();
        if (!com.aliyun.teautil.Common.isUnset(request.eventBusName)) {
            body.put("eventBusName", request.eventBusName);
        }

        com.aliyun.teaopenapi.models.OpenApiRequest req = com.aliyun.teaopenapi.models.OpenApiRequest.build(TeaConverter.buildMap(
            new TeaPair("body", com.aliyun.teautil.Common.toJSONString(body))
        ));
        com.aliyun.teaopenapi.models.Params params = com.aliyun.teaopenapi.models.Params.build(TeaConverter.buildMap(
            new TeaPair("action", "DeleteEventBus"),
            new TeaPair("version", "2024-07-01"),
            new TeaPair("protocol", "HTTP"),
            new TeaPair("pathname", "/bus/deleteEventBus"),
            new TeaPair("method", "POST"),
            new TeaPair("authType", "Anonymous"),
            new TeaPair("style", "RPC"),
            new TeaPair("reqBodyType", "json"),
            new TeaPair("bodyType", "json")
        ));
        return TeaModel.toModel(this.callApi(params, req, runtime), new DeleteEventBusResponse());
    }

    /**
     * <b>description</b> :
     * <p>You can call this API operation to delete an event bus.</p>
     * 
     * <b>summary</b> : 
     * <p>Deletes an event bus.</p>
     * 
     * @param request DeleteEventBusRequest
     * @return DeleteEventBusResponse
     */
    public DeleteEventBusResponse deleteEventBus(DeleteEventBusRequest request) throws Exception {
        com.aliyun.teautil.models.RuntimeOptions runtime = new com.aliyun.teautil.models.RuntimeOptions();
        return this.deleteEventBusWithOptions(request, runtime);
    }

    /**
     * <b>description</b> :
     * <p>You can call this API operation to create an API destination.</p>
     * 
     * <b>summary</b> : 
     * <p>Creates an API destination.</p>
     * 
     * @param request CreateApiDestinationRequest (tmpReq before)
     * @param runtime runtime options for this request RuntimeOptions
     * @return CreateApiDestinationResponse
     */
    public CreateApiDestinationResponse createApiDestinationWithOptions(CreateApiDestinationRequest request, com.aliyun.teautil.models.RuntimeOptions runtime) throws Exception {
        com.aliyun.teautil.Common.validateModel(request);
        java.util.Map<String, Object> body = new java.util.HashMap<>();
        if (!com.aliyun.teautil.Common.isUnset(request.apiDestinationName)) {
            body.put("apiDestinationName", request.apiDestinationName);
        }

        if (!com.aliyun.teautil.Common.isUnset(request.connectionName)) {
            body.put("connectionName", request.connectionName);
        }

        if (!com.aliyun.teautil.Common.isUnset(request.description)) {
            body.put("description", request.description);
        }

        if (!com.aliyun.teautil.Common.isUnset(request.httpApiParameters)) {
            body.put("httpApiParameters", request.httpApiParameters);
        }

        if (!com.aliyun.teautil.Common.isUnset(request.invocationRateLimitPerSecond)) {
            body.put("invocationRateLimitPerSecond", request.invocationRateLimitPerSecond);
        }

        com.aliyun.teaopenapi.models.OpenApiRequest req = com.aliyun.teaopenapi.models.OpenApiRequest.build(TeaConverter.buildMap(
            new TeaPair("body", com.aliyun.teautil.Common.toJSONString(body))
        ));
        com.aliyun.teaopenapi.models.Params params = com.aliyun.teaopenapi.models.Params.build(TeaConverter.buildMap(
            new TeaPair("action", "CreateApiDestination"),
            new TeaPair("version", "2024-07-01"),
            new TeaPair("protocol", "HTTP"),
            new TeaPair("pathname", "/api-destination/createApiDestination"),
            new TeaPair("method", "POST"),
            new TeaPair("authType", "Anonymous"),
            new TeaPair("style", "RPC"),
            new TeaPair("reqBodyType", "json"),
            new TeaPair("bodyType", "json")
        ));
        return TeaModel.toModel(this.callApi(params, req, runtime), new CreateApiDestinationResponse());
    }

    /**
     * <b>description</b> :
     * <p>You can call this API operation to create an API destination.</p>
     * 
     * <b>summary</b> : 
     * <p>Creates an API destination.</p>
     * 
     * @param request CreateApiDestinationRequest
     * @return CreateApiDestinationResponse
     */
    public CreateApiDestinationResponse createApiDestination(CreateApiDestinationRequest request) throws Exception {
        com.aliyun.teautil.models.RuntimeOptions runtime = new com.aliyun.teautil.models.RuntimeOptions();
        return this.createApiDestinationWithOptions(request, runtime);
    }

    /**
     * <b>description</b> :
     * <p>You can call this API operation to update an API destination.</p>
     * 
     * <b>summary</b> : 
     * <p>Updates an API destination.</p>
     * 
     * @param request UpdateApiDestinationRequest
     * @param runtime runtime options for this request RuntimeOptions
     * @return UpdateApiDestinationResponse
     */
    public UpdateApiDestinationResponse updateApiDestinationWithOptions(UpdateApiDestinationRequest request, com.aliyun.teautil.models.RuntimeOptions runtime) throws Exception {
        com.aliyun.teautil.Common.validateModel(request);
        java.util.Map<String, Object> body = new java.util.HashMap<>();
        if (!com.aliyun.teautil.Common.isUnset(request.apiDestinationName)) {
            body.put("apiDestinationName", request.apiDestinationName);
        }

        if (!com.aliyun.teautil.Common.isUnset(request.connectionName)) {
            body.put("connectionName", request.connectionName);
        }

        if (!com.aliyun.teautil.Common.isUnset(request.description)) {
            body.put("description", request.description);
        }

        if (!com.aliyun.teautil.Common.isUnset(request.httpApiParameters)) {
            body.put("httpApiParameters", request.httpApiParameters);
        }

        if (!com.aliyun.teautil.Common.isUnset(request.invocationRateLimitPerSecond)) {
            body.put("invocationRateLimitPerSecond", request.invocationRateLimitPerSecond);
        }

        com.aliyun.teaopenapi.models.OpenApiRequest req = com.aliyun.teaopenapi.models.OpenApiRequest.build(TeaConverter.buildMap(
            new TeaPair("body", com.aliyun.teautil.Common.toJSONString(body))
        ));
        com.aliyun.teaopenapi.models.Params params = com.aliyun.teaopenapi.models.Params.build(TeaConverter.buildMap(
            new TeaPair("action", "UpdateApiDestination"),
            new TeaPair("version", "2024-07-01"),
            new TeaPair("protocol", "HTTP"),
            new TeaPair("pathname", "/api-destination/updateApiDestination"),
            new TeaPair("method", "POST"),
            new TeaPair("authType", "Anonymous"),
            new TeaPair("style", "RPC"),
            new TeaPair("reqBodyType", "json"),
            new TeaPair("bodyType", "json")
        ));
        return TeaModel.toModel(this.callApi(params, req, runtime), new UpdateApiDestinationResponse());
    }

    /**
     * <b>description</b> :
     * <p>You can call this API operation to update an API destination.</p>
     * 
     * <b>summary</b> : 
     * <p>Updates an API destination.</p>
     * 
     * @param request UpdateApiDestinationRequest
     * @return UpdateApiDestinationResponse
     */
    public UpdateApiDestinationResponse updateApiDestination(UpdateApiDestinationRequest request) throws Exception {
        com.aliyun.teautil.models.RuntimeOptions runtime = new com.aliyun.teautil.models.RuntimeOptions();
        return this.updateApiDestinationWithOptions(request, runtime);
    }

    /**
     * <b>description</b> :
     * <p>You can call this API operation to query the information about an API destination.</p>
     * 
     * <b>summary</b> : 
     * <p>Queries the information about an API destination.</p>
     * 
     * @param request GetApiDestinationRequest
     * @param runtime runtime options for this request RuntimeOptions
     * @return GetApiDestinationResponse
     */
    public GetApiDestinationResponse getApiDestinationWithOptions(GetApiDestinationRequest request, com.aliyun.teautil.models.RuntimeOptions runtime) throws Exception {
        com.aliyun.teautil.Common.validateModel(request);
        java.util.Map<String, Object> body = new java.util.HashMap<>();
        if (!com.aliyun.teautil.Common.isUnset(request.apiDestinationName)) {
            body.put("apiDestinationName", request.apiDestinationName);
        }

        com.aliyun.teaopenapi.models.OpenApiRequest req = com.aliyun.teaopenapi.models.OpenApiRequest.build(TeaConverter.buildMap(
            new TeaPair("body", com.aliyun.teautil.Common.toJSONString(body))
        ));
        com.aliyun.teaopenapi.models.Params params = com.aliyun.teaopenapi.models.Params.build(TeaConverter.buildMap(
            new TeaPair("action", "GetApiDestination"),
            new TeaPair("version", "2024-07-01"),
            new TeaPair("protocol", "HTTP"),
            new TeaPair("pathname", "/api-destination/getApiDestination"),
            new TeaPair("method", "POST"),
            new TeaPair("authType", "Anonymous"),
            new TeaPair("style", "RPC"),
            new TeaPair("reqBodyType", "json"),
            new TeaPair("bodyType", "json")
        ));
        return TeaModel.toModel(this.callApi(params, req, runtime), new GetApiDestinationResponse());
    }

    /**
     * <b>description</b> :
     * <p>You can call this API operation to query the information about an API destination.</p>
     * 
     * <b>summary</b> : 
     * <p>Queries the information about an API destination.</p>
     * 
     * @param request GetApiDestinationRequest
     * @return GetApiDestinationResponse
     */
    public GetApiDestinationResponse getApiDestination(GetApiDestinationRequest request) throws Exception {
        com.aliyun.teautil.models.RuntimeOptions runtime = new com.aliyun.teautil.models.RuntimeOptions();
        return this.getApiDestinationWithOptions(request, runtime);
    }

    /**
     * <b>description</b> :
     * <p>You can call this API operation to delete an API destination.</p>
     * 
     * <b>summary</b> : 
     * <p>Deletes an API destination.</p>
     * 
     * @param request DeleteApiDestinationRequest
     * @param runtime runtime options for this request RuntimeOptions
     * @return DeleteApiDestinationResponse
     */
    public DeleteApiDestinationResponse deleteApiDestinationWithOptions(DeleteApiDestinationRequest request, com.aliyun.teautil.models.RuntimeOptions runtime) throws Exception {
        com.aliyun.teautil.Common.validateModel(request);
        java.util.Map<String, Object> body = new java.util.HashMap<>();
        if (!com.aliyun.teautil.Common.isUnset(request.apiDestinationName)) {
            body.put("apiDestinationName", request.apiDestinationName);
        }

        com.aliyun.teaopenapi.models.OpenApiRequest req = com.aliyun.teaopenapi.models.OpenApiRequest.build(TeaConverter.buildMap(
            new TeaPair("body", com.aliyun.teautil.Common.toJSONString(body))
        ));
        com.aliyun.teaopenapi.models.Params params = com.aliyun.teaopenapi.models.Params.build(TeaConverter.buildMap(
            new TeaPair("action", "DeleteApiDestination"),
            new TeaPair("version", "2024-07-01"),
            new TeaPair("protocol", "HTTP"),
            new TeaPair("pathname", "/api-destination/deleteApiDestination"),
            new TeaPair("method", "POST"),
            new TeaPair("authType", "Anonymous"),
            new TeaPair("style", "RPC"),
            new TeaPair("reqBodyType", "json"),
            new TeaPair("bodyType", "json")
        ));
        return TeaModel.toModel(this.callApi(params, req, runtime), new DeleteApiDestinationResponse());
    }

    /**
     * <b>description</b> :
     * <p>You can call this API operation to delete an API destination.</p>
     * 
     * <b>summary</b> : 
     * <p>Deletes an API destination.</p>
     * 
     * @param request DeleteApiDestinationRequest
     * @return DeleteApiDestinationResponse
     */
    public DeleteApiDestinationResponse deleteApiDestination(DeleteApiDestinationRequest request) throws Exception {
        com.aliyun.teautil.models.RuntimeOptions runtime = new com.aliyun.teautil.models.RuntimeOptions();
        return this.deleteApiDestinationWithOptions(request, runtime);
    }

    /**
     * <b>description</b> :
     * <p>You can use this API operation to query a list of API destinations.</p>
     * 
     * <b>summary</b> : 
     * <p>Queries a list of API destinations.</p>
     * 
     * @param request ListApiDestinationsRequest
     * @param runtime runtime options for this request RuntimeOptions
     * @return ListApiDestinationsResponse
     */
    public ListApiDestinationsResponse listApiDestinationsWithOptions(ListApiDestinationsRequest request, com.aliyun.teautil.models.RuntimeOptions runtime) throws Exception {
        com.aliyun.teautil.Common.validateModel(request);
        java.util.Map<String, Object> body = new java.util.HashMap<>();
        if (!com.aliyun.teautil.Common.isUnset(request.apiDestinationNamePrefix)) {
            body.put("apiDestinationNamePrefix", request.apiDestinationNamePrefix);
        }

        if (!com.aliyun.teautil.Common.isUnset(request.connectionName)) {
            body.put("connectionName", request.connectionName);
        }

        if (!com.aliyun.teautil.Common.isUnset(request.maxResults)) {
            body.put("maxResults", request.maxResults);
        }

        if (!com.aliyun.teautil.Common.isUnset(request.nextToken)) {
            body.put("nextToken", request.nextToken);
        }

        com.aliyun.teaopenapi.models.OpenApiRequest req = com.aliyun.teaopenapi.models.OpenApiRequest.build(TeaConverter.buildMap(
            new TeaPair("body", com.aliyun.teautil.Common.toJSONString(body))
        ));
        com.aliyun.teaopenapi.models.Params params = com.aliyun.teaopenapi.models.Params.build(TeaConverter.buildMap(
            new TeaPair("action", "ListApiDestinations"),
            new TeaPair("version", "2024-07-01"),
            new TeaPair("protocol", "HTTP"),
            new TeaPair("pathname", "/api-destination/listApiDestinations"),
            new TeaPair("method", "POST"),
            new TeaPair("authType", "Anonymous"),
            new TeaPair("style", "RPC"),
            new TeaPair("reqBodyType", "json"),
            new TeaPair("bodyType", "json")
        ));
        return TeaModel.toModel(this.callApi(params, req, runtime), new ListApiDestinationsResponse());
    }

    /**
     * <b>description</b> :
     * <p>You can use this API operation to query a list of API destinations.</p>
     * 
     * <b>summary</b> : 
     * <p>Queries a list of API destinations.</p>
     * 
     * @param request ListApiDestinationsRequest
     * @return ListApiDestinationsResponse
     */
    public ListApiDestinationsResponse listApiDestinations(ListApiDestinationsRequest request) throws Exception {
        com.aliyun.teautil.models.RuntimeOptions runtime = new com.aliyun.teautil.models.RuntimeOptions();
        return this.listApiDestinationsWithOptions(request, runtime);
    }

    /**
     * <b>description</b> :
     * <p>You can call this API operation to create a connection.</p>
     * 
     * <b>summary</b> : 
     * <p>Creates a connection.</p>
     * 
     * @param request CreateConnectionRequest
     * @param runtime runtime options for this request RuntimeOptions
     * @return CreateConnectionResponse
     */
    public CreateConnectionResponse createConnectionWithOptions(CreateConnectionRequest request, com.aliyun.teautil.models.RuntimeOptions runtime) throws Exception {
        com.aliyun.teautil.Common.validateModel(request);
        java.util.Map<String, Object> body = new java.util.HashMap<>();
        if (!com.aliyun.teautil.Common.isUnset(request.authParameters)) {
            body.put("authParameters", request.authParameters);
        }

        if (!com.aliyun.teautil.Common.isUnset(request.connectionName)) {
            body.put("connectionName", request.connectionName);
        }

        if (!com.aliyun.teautil.Common.isUnset(request.description)) {
            body.put("description", request.description);
        }

        if (!com.aliyun.teautil.Common.isUnset(request.networkParameters)) {
            body.put("networkParameters", request.networkParameters);
        }

        com.aliyun.teaopenapi.models.OpenApiRequest req = com.aliyun.teaopenapi.models.OpenApiRequest.build(TeaConverter.buildMap(
            new TeaPair("body", com.aliyun.teautil.Common.toJSONString(body))
        ));
        com.aliyun.teaopenapi.models.Params params = com.aliyun.teaopenapi.models.Params.build(TeaConverter.buildMap(
            new TeaPair("action", "CreateConnection"),
            new TeaPair("version", "2024-07-01"),
            new TeaPair("protocol", "HTTP"),
            new TeaPair("pathname", "/connection/createConnection"),
            new TeaPair("method", "POST"),
            new TeaPair("authType", "Anonymous"),
            new TeaPair("style", "RPC"),
            new TeaPair("reqBodyType", "json"),
            new TeaPair("bodyType", "json")
        ));
        return TeaModel.toModel(this.callApi(params, req, runtime), new CreateConnectionResponse());
    }

    /**
     * <b>description</b> :
     * <p>You can call this API operation to create a connection.</p>
     * 
     * <b>summary</b> : 
     * <p>Creates a connection.</p>
     * 
     * @param request CreateConnectionRequest
     * @return CreateConnectionResponse
     */
    public CreateConnectionResponse createConnection(CreateConnectionRequest request) throws Exception {
        com.aliyun.teautil.models.RuntimeOptions runtime = new com.aliyun.teautil.models.RuntimeOptions();
        return this.createConnectionWithOptions(request, runtime);
    }

    /**
     * <b>description</b> :
     * <p>You can call this API operation to delete a connection.</p>
     * 
     * <b>summary</b> : 
     * <p>Deletes a connection.</p>
     * 
     * @param request DeleteConnectionRequest
     * @param runtime runtime options for this request RuntimeOptions
     * @return DeleteConnectionResponse
     */
    public DeleteConnectionResponse deleteConnectionWithOptions(DeleteConnectionRequest request, com.aliyun.teautil.models.RuntimeOptions runtime) throws Exception {
        com.aliyun.teautil.Common.validateModel(request);
        java.util.Map<String, Object> body = new java.util.HashMap<>();
        if (!com.aliyun.teautil.Common.isUnset(request.connectionName)) {
            body.put("connectionName", request.connectionName);
        }

        com.aliyun.teaopenapi.models.OpenApiRequest req = com.aliyun.teaopenapi.models.OpenApiRequest.build(TeaConverter.buildMap(
            new TeaPair("body", com.aliyun.teautil.Common.toJSONString(body))
        ));
        com.aliyun.teaopenapi.models.Params params = com.aliyun.teaopenapi.models.Params.build(TeaConverter.buildMap(
            new TeaPair("action", "DeleteConnection"),
            new TeaPair("version", "2024-07-01"),
            new TeaPair("protocol", "HTTP"),
            new TeaPair("pathname", "/connection/deleteConnection"),
            new TeaPair("method", "POST"),
            new TeaPair("authType", "Anonymous"),
            new TeaPair("style", "RPC"),
            new TeaPair("reqBodyType", "json"),
            new TeaPair("bodyType", "json")
        ));
        return TeaModel.toModel(this.callApi(params, req, runtime), new DeleteConnectionResponse());
    }

    /**
     * <b>description</b> :
     * <p>You can call this API operation to delete a connection.</p>
     * 
     * <b>summary</b> : 
     * <p>Deletes a connection.</p>
     * 
     * @param request DeleteConnectionRequest
     * @return DeleteConnectionResponse
     */
    public DeleteConnectionResponse deleteConnection(DeleteConnectionRequest request) throws Exception {
        com.aliyun.teautil.models.RuntimeOptions runtime = new com.aliyun.teautil.models.RuntimeOptions();
        return this.deleteConnectionWithOptions(request, runtime);
    }

    /**
     * <b>description</b> :
     * <p>You can call this API operation to update a connection.</p>
     * 
     * <b>summary</b> : 
     * <p>Updates a connection.</p>
     * 
     * @param request UpdateConnectionRequest
     * @param runtime runtime options for this request RuntimeOptions
     * @return UpdateConnectionResponse
     */
    public UpdateConnectionResponse updateConnectionWithOptions(UpdateConnectionRequest request, com.aliyun.teautil.models.RuntimeOptions runtime) throws Exception {
        com.aliyun.teautil.Common.validateModel(request);
        java.util.Map<String, Object> body = new java.util.HashMap<>();
        if (!com.aliyun.teautil.Common.isUnset(request.authParameters)) {
            body.put("authParameters", request.authParameters);
        }

        if (!com.aliyun.teautil.Common.isUnset(request.connectionName)) {
            body.put("connectionName", request.connectionName);
        }

        if (!com.aliyun.teautil.Common.isUnset(request.description)) {
            body.put("description", request.description);
        }

        if (!com.aliyun.teautil.Common.isUnset(request.networkParameters)) {
            body.put("networkParameters", request.networkParameters);
        }

        com.aliyun.teaopenapi.models.OpenApiRequest req = com.aliyun.teaopenapi.models.OpenApiRequest.build(TeaConverter.buildMap(
            new TeaPair("body", com.aliyun.teautil.Common.toJSONString(body))
        ));
        com.aliyun.teaopenapi.models.Params params = com.aliyun.teaopenapi.models.Params.build(TeaConverter.buildMap(
            new TeaPair("action", "UpdateConnection"),
            new TeaPair("version", "2024-07-01"),
            new TeaPair("protocol", "HTTP"),
            new TeaPair("pathname", "/connection/updateConnection"),
            new TeaPair("method", "POST"),
            new TeaPair("authType", "Anonymous"),
            new TeaPair("style", "RPC"),
            new TeaPair("reqBodyType", "json"),
            new TeaPair("bodyType", "json")
        ));
        return TeaModel.toModel(this.callApi(params, req, runtime), new UpdateConnectionResponse());
    }

    /**
     * <b>description</b> :
     * <p>You can call this API operation to update a connection.</p>
     * 
     * <b>summary</b> : 
     * <p>Updates a connection.</p>
     * 
     * @param request UpdateConnectionRequest
     * @return UpdateConnectionResponse
     */
    public UpdateConnectionResponse updateConnection(UpdateConnectionRequest request) throws Exception {
        com.aliyun.teautil.models.RuntimeOptions runtime = new com.aliyun.teautil.models.RuntimeOptions();
        return this.updateConnectionWithOptions(request, runtime);
    }

    /**
     * <b>description</b> :
     * <p>You can call this API operation to query the configurations of a connection.</p>
     * 
     * <b>summary</b> : 
     * <p>Queries the configurations of a connection.</p>
     * 
     * @param request GetConnectionRequest
     * @param runtime runtime options for this request RuntimeOptions
     * @return GetConnectionResponse
     */
    public GetConnectionResponse getConnectionWithOptions(GetConnectionRequest request, com.aliyun.teautil.models.RuntimeOptions runtime) throws Exception {
        com.aliyun.teautil.Common.validateModel(request);
        java.util.Map<String, Object> body = new java.util.HashMap<>();
        if (!com.aliyun.teautil.Common.isUnset(request.connectionName)) {
            body.put("connectionName", request.connectionName);
        }

        com.aliyun.teaopenapi.models.OpenApiRequest req = com.aliyun.teaopenapi.models.OpenApiRequest.build(TeaConverter.buildMap(
            new TeaPair("body", com.aliyun.teautil.Common.toJSONString(body))
        ));
        com.aliyun.teaopenapi.models.Params params = com.aliyun.teaopenapi.models.Params.build(TeaConverter.buildMap(
            new TeaPair("action", "GetConnection"),
            new TeaPair("version", "2024-07-01"),
            new TeaPair("protocol", "HTTP"),
            new TeaPair("pathname", "/connection/getConnection"),
            new TeaPair("method", "POST"),
            new TeaPair("authType", "Anonymous"),
            new TeaPair("style", "RPC"),
            new TeaPair("reqBodyType", "json"),
            new TeaPair("bodyType", "json")
        ));
        return TeaModel.toModel(this.callApi(params, req, runtime), new GetConnectionResponse());
    }

    /**
     * <b>description</b> :
     * <p>You can call this API operation to query the configurations of a connection.</p>
     * 
     * <b>summary</b> : 
     * <p>Queries the configurations of a connection.</p>
     * 
     * @param request GetConnectionRequest
     * @return GetConnectionResponse
     */
    public GetConnectionResponse getConnection(GetConnectionRequest request) throws Exception {
        com.aliyun.teautil.models.RuntimeOptions runtime = new com.aliyun.teautil.models.RuntimeOptions();
        return this.getConnectionWithOptions(request, runtime);
    }

    /**
     * <b>description</b> :
     * <p>You can call this API operation to query the configurations of a connection.</p>
     * 
     * <b>summary</b> : 
     * <p>Queries the configurations of a connection.</p>
     * 
     * @param request GetConnectionRequest
     * @param runtime runtime options for this request RuntimeOptions
     * @return GetConnectionResponse
     */
    public GetConnectionResponse selectOneConnectionWithOptions(GetConnectionRequest request, com.aliyun.teautil.models.RuntimeOptions runtime) throws Exception {
        com.aliyun.teautil.Common.validateModel(request);
        java.util.Map<String, Object> body = new java.util.HashMap<>();
        if (!com.aliyun.teautil.Common.isUnset(request.connectionName)) {
            body.put("connectionName", request.connectionName);
        }

        com.aliyun.teaopenapi.models.OpenApiRequest req = com.aliyun.teaopenapi.models.OpenApiRequest.build(TeaConverter.buildMap(
            new TeaPair("body", com.aliyun.teautil.Common.toJSONString(body))
        ));
        com.aliyun.teaopenapi.models.Params params = com.aliyun.teaopenapi.models.Params.build(TeaConverter.buildMap(
            new TeaPair("action", "selectOneConnection"),
            new TeaPair("version", "2024-07-01"),
            new TeaPair("protocol", "HTTP"),
            new TeaPair("pathname", "/connection/selectOneConnection"),
            new TeaPair("method", "POST"),
            new TeaPair("authType", "Anonymous"),
            new TeaPair("style", "RPC"),
            new TeaPair("reqBodyType", "json"),
            new TeaPair("bodyType", "json")
        ));
        return TeaModel.toModel(this.callApi(params, req, runtime), new GetConnectionResponse());
    }

    /**
     * <b>description</b> :
     * <p>You can call this API operation to query the configurations of a connection.</p>
     * 
     * <b>summary</b> : 
     * <p>Queries the configurations of a connection.</p>
     * 
     * @param request GetConnectionRequest
     * @return GetConnectionResponse
     */
    public GetConnectionResponse selectOneConnection(GetConnectionRequest request) throws Exception {
        com.aliyun.teautil.models.RuntimeOptions runtime = new com.aliyun.teautil.models.RuntimeOptions();
        return this.selectOneConnectionWithOptions(request, runtime);
    }

    /**
     * <b>description</b> :
     * <p>You can call this API operation to query connections.</p>
     * 
     * <b>summary</b> : 
     * <p>Queries connections.</p>
     * 
     * @param request ListConnectionsRequest
     * @param runtime runtime options for this request RuntimeOptions
     * @return ListConnectionsResponse
     */
    public ListConnectionsResponse listConnectionsWithOptions(ListConnectionsRequest request, com.aliyun.teautil.models.RuntimeOptions runtime) throws Exception {
        com.aliyun.teautil.Common.validateModel(request);
        java.util.Map<String, Object> body = new java.util.HashMap<>();
        if (!com.aliyun.teautil.Common.isUnset(request.connectionNamePrefix)) {
            body.put("connectionNamePrefix", request.connectionNamePrefix);
        }

        if (!com.aliyun.teautil.Common.isUnset(request.maxResults)) {
            body.put("maxResults", request.maxResults);
        }

        if (!com.aliyun.teautil.Common.isUnset(request.nextToken)) {
            body.put("nextToken", request.nextToken);
        }

        com.aliyun.teaopenapi.models.OpenApiRequest req = com.aliyun.teaopenapi.models.OpenApiRequest.build(TeaConverter.buildMap(
            new TeaPair("body", com.aliyun.teautil.Common.toJSONString(body))
        ));
        com.aliyun.teaopenapi.models.Params params = com.aliyun.teaopenapi.models.Params.build(TeaConverter.buildMap(
            new TeaPair("action", "ListConnections"),
            new TeaPair("version", "2024-07-01"),
            new TeaPair("protocol", "HTTP"),
            new TeaPair("pathname", "/connection/listConnections"),
            new TeaPair("method", "POST"),
            new TeaPair("authType", "Anonymous"),
            new TeaPair("style", "RPC"),
            new TeaPair("reqBodyType", "json"),
            new TeaPair("bodyType", "json")
        ));
        return TeaModel.toModel(this.callApi(params, req, runtime), new ListConnectionsResponse());
    }

    /**
     * <b>description</b> :
     * <p>You can call this API operation to list connections.</p>
     * 
     * <b>summary</b> : 
     * <p>list connections.</p>
     * 
     * @param request ListConnectionsRequest
     * @return ListConnectionsResponse
     */
    public ListConnectionsResponse listConnections(ListConnectionsRequest request) throws Exception {
        com.aliyun.teautil.models.RuntimeOptions runtime = new com.aliyun.teautil.models.RuntimeOptions();
        return this.listConnectionsWithOptions(request, runtime);
    }

    /**
     * <b>description</b> :
     * <p>You can call this API operation to update a connection.</p>
     * 
     * <b>summary</b> : 
     * <p>Updates a connection.</p>
     * @return ListEnumsResponseResponse
     */
    public ListEnumsResponseResponse listEnumsResponse() throws Exception {
        com.aliyun.teautil.models.RuntimeOptions runtime = new com.aliyun.teautil.models.RuntimeOptions();
        java.util.Map<String, Object> body = new java.util.HashMap<>();
        com.aliyun.teaopenapi.models.OpenApiRequest req = com.aliyun.teaopenapi.models.OpenApiRequest.build(TeaConverter.buildMap(
            new TeaPair("body", com.aliyun.teautil.Common.toJSONString(body))
        ));
        com.aliyun.teaopenapi.models.Params params = com.aliyun.teaopenapi.models.Params.build(TeaConverter.buildMap(
            new TeaPair("action", "listEnumsResponse"),
            new TeaPair("version", "2024-07-01"),
            new TeaPair("protocol", "HTTP"),
            new TeaPair("pathname", "/connection/listEnumsResponse"),
            new TeaPair("method", "POST"),
            new TeaPair("authType", "Anonymous"),
            new TeaPair("style", "RPC"),
            new TeaPair("reqBodyType", "json"),
            new TeaPair("bodyType", "json")
        ));
        return TeaModel.toModel(this.callApi(params, req, runtime), new ListEnumsResponseResponse());
    }

    /**
     * <b>description</b> :
     * <p>You can call this API operation to query the content of an event.</p>
     * 
     * <b>summary</b> : 
     * <p>Queries the content of an event.</p>
     * 
     * @param request PutEventsRequest
     * @param runtime runtime options for this request RuntimeOptions
     * @return PutEventsResponse
     */
    public PutEventsResponse putEventsWithOptions(PutEventsRequest request, com.aliyun.teautil.models.RuntimeOptions runtime) throws Exception {
        com.aliyun.teautil.Common.validateModel(request);
        java.util.Map<String, String> headers = TeaConverter.buildMap(
            new TeaPair("ce-specversion", "1.0"),
            new TeaPair("ce-type", "com.github.pull_request.opened"),
            new TeaPair("ce-source", "https://github.com/cloudevents/spec/pull"),
            new TeaPair("ce-subject", "demo"),
            new TeaPair("ce-id", "1234-1234-1234"),
            new TeaPair("ce-datacontenttype", "application/json"),
            new TeaPair("ce-time", "2024-07-01T17:31:00Z"),
            new TeaPair("ce-eventbusname", "demo-bus")
        );
        String body = "{}";
        if (!com.aliyun.teautil.Common.isUnset(request.eventBusName)) {
            headers.put("ce-eventbusname", request.eventBusName);
        }

        if (!com.aliyun.teautil.Common.isUnset(request.event)) {
            body = request.event;
        }

        com.aliyun.teaopenapi.models.OpenApiRequest req = com.aliyun.teaopenapi.models.OpenApiRequest.build(TeaConverter.buildMap(
            new TeaPair("body", body),
            new TeaPair("headers", headers)
        ));
        com.aliyun.teaopenapi.models.Params params = com.aliyun.teaopenapi.models.Params.build(TeaConverter.buildMap(
            new TeaPair("action", "putEvents"),
            new TeaPair("version", "2024-07-01"),
            new TeaPair("protocol", "HTTP"),
            new TeaPair("pathname", "/putEvents"),
            new TeaPair("method", "POST"),
            new TeaPair("authType", "Anonymous"),
            new TeaPair("style", "RPC"),
            new TeaPair("reqBodyType", "json"),
            new TeaPair("bodyType", "json")
        ));
        return TeaModel.toModel(this.callApi(params, req, runtime), new PutEventsResponse());
    }

    /**
     * <b>description</b> :
     * <p>You can call this API operation to query the content of an event.</p>
     * 
     * <b>summary</b> : 
     * <p>Queries the content of an event.</p>
     * 
     * @param request PutEventsRequest
     * @return PutEventsResponse
     */
    public PutEventsResponse putEvents(PutEventsRequest request) throws Exception {
        com.aliyun.teautil.models.RuntimeOptions runtime = new com.aliyun.teautil.models.RuntimeOptions();
        return this.putEventsWithOptions(request, runtime);
    }

    /**
     * <b>description</b> :
     * <p>You can call this operation to create an event rule.</p>
     * 
     * <b>summary</b> : 
     * <p>Creates an event rule.</p>
     * 
     * @param request CreateEventRuleRequest
     * @param runtime runtime options for this request RuntimeOptions
     * @return CreateEventRuleResponse
     */
    public CreateEventRuleResponse createEventRuleWithOptions(CreateEventRuleRequest request, com.aliyun.teautil.models.RuntimeOptions runtime) throws Exception {
        com.aliyun.teautil.Common.validateModel(request);
        java.util.Map<String, Object> body = new java.util.HashMap<>();
        if (!com.aliyun.teautil.Common.isUnset(request.eventBusName)) {
            body.put("eventBusName", request.eventBusName);
        }

        if (!com.aliyun.teautil.Common.isUnset(request.eventRuleName)) {
            body.put("eventRuleName", request.eventRuleName);
        }

        if (!com.aliyun.teautil.Common.isUnset(request.description)) {
            body.put("description", request.description);
        }

        if (!com.aliyun.teautil.Common.isUnset(request.filterPattern)) {
            body.put("filterPattern", request.filterPattern);
        }

        com.aliyun.teaopenapi.models.OpenApiRequest req = com.aliyun.teaopenapi.models.OpenApiRequest.build(TeaConverter.buildMap(
            new TeaPair("body", com.aliyun.teautil.Common.toJSONString(body))
        ));
        com.aliyun.teaopenapi.models.Params params = com.aliyun.teaopenapi.models.Params.build(TeaConverter.buildMap(
            new TeaPair("action", "CreateEventRule"),
            new TeaPair("version", "2024-07-01"),
            new TeaPair("protocol", "HTTP"),
            new TeaPair("pathname", "/rule/createEventRule"),
            new TeaPair("method", "POST"),
            new TeaPair("authType", "Anonymous"),
            new TeaPair("style", "RPC"),
            new TeaPair("reqBodyType", "json"),
            new TeaPair("bodyType", "json")
        ));
        return TeaModel.toModel(this.callApi(params, req, runtime), new CreateEventRuleResponse());
    }

    /**
     * <b>description</b> :
     * <p>You can call this operation to create an event rule.</p>
     * 
     * <b>summary</b> : 
     * <p>Creates an event rule.</p>
     * 
     * @param request CreateEventRuleRequest
     * @return CreateEventRuleResponse
     */
    public CreateEventRuleResponse createEventRule(CreateEventRuleRequest request) throws Exception {
        com.aliyun.teautil.models.RuntimeOptions runtime = new com.aliyun.teautil.models.RuntimeOptions();
        return this.createEventRuleWithOptions(request, runtime);
    }

    /**
     * <b>description</b> :
     * <p>You can call this operation to get an event rule.</p>
     * 
     * <b>summary</b> : 
     * <p>Gets an event rule.</p>
     * 
     * @param request GetEventRuleRequest
     * @param runtime runtime options for this request RuntimeOptions
     * @return GetEventRuleResponse
     */
    public GetEventRuleResponse getEventRuleWithOptions(GetEventRuleRequest request, com.aliyun.teautil.models.RuntimeOptions runtime) throws Exception {
        com.aliyun.teautil.Common.validateModel(request);
        java.util.Map<String, Object> body = new java.util.HashMap<>();
        if (!com.aliyun.teautil.Common.isUnset(request.eventBusName)) {
            body.put("eventBusName", request.eventBusName);
        }

        if (!com.aliyun.teautil.Common.isUnset(request.eventRuleName)) {
            body.put("eventRuleName", request.eventRuleName);
        }

        com.aliyun.teaopenapi.models.OpenApiRequest req = com.aliyun.teaopenapi.models.OpenApiRequest.build(TeaConverter.buildMap(
            new TeaPair("body", com.aliyun.teautil.Common.toJSONString(body))
        ));
        com.aliyun.teaopenapi.models.Params params = com.aliyun.teaopenapi.models.Params.build(TeaConverter.buildMap(
            new TeaPair("action", "GetEventRule"),
            new TeaPair("version", "2024-07-01"),
            new TeaPair("protocol", "HTTP"),
            new TeaPair("pathname", "/rule/getEventRule"),
            new TeaPair("method", "POST"),
            new TeaPair("authType", "Anonymous"),
            new TeaPair("style", "RPC"),
            new TeaPair("reqBodyType", "json"),
            new TeaPair("bodyType", "json")
        ));
        return TeaModel.toModel(this.callApi(params, req, runtime), new GetEventRuleResponse());
    }

    /**
     * <b>description</b> :
     * <p>You can call this operation to get an event rule.</p>
     * 
     * <b>summary</b> : 
     * <p>Gets an event rule.</p>
     * 
     * @param request GetEventRuleRequest
     * @return GetEventRuleResponse
     */
    public GetEventRuleResponse getEventRule(GetEventRuleRequest request) throws Exception {
        com.aliyun.teautil.models.RuntimeOptions runtime = new com.aliyun.teautil.models.RuntimeOptions();
        return this.getEventRuleWithOptions(request, runtime);
    }

    /**
     * <b>description</b> :
     * <p>You can call this operation to delete an event rule.</p>
     * 
     * <b>summary</b> : 
     * <p>Deletes an event rule.</p>
     * 
     * @param request DeleteEventRuleRequest
     * @param runtime runtime options for this request RuntimeOptions
     * @return DeleteEventRuleResponse
     */
    public DeleteEventRuleResponse deleteEventRuleWithOptions(DeleteEventRuleRequest request, com.aliyun.teautil.models.RuntimeOptions runtime) throws Exception {
        com.aliyun.teautil.Common.validateModel(request);
        java.util.Map<String, Object> body = new java.util.HashMap<>();
        if (!com.aliyun.teautil.Common.isUnset(request.eventBusName)) {
            body.put("eventBusName", request.eventBusName);
        }

        if (!com.aliyun.teautil.Common.isUnset(request.eventRuleName)) {
            body.put("eventRuleName", request.eventRuleName);
        }

        com.aliyun.teaopenapi.models.OpenApiRequest req = com.aliyun.teaopenapi.models.OpenApiRequest.build(TeaConverter.buildMap(
            new TeaPair("body", com.aliyun.teautil.Common.toJSONString(body))
        ));
        com.aliyun.teaopenapi.models.Params params = com.aliyun.teaopenapi.models.Params.build(TeaConverter.buildMap(
            new TeaPair("action", "DeleteEventRule"),
            new TeaPair("version", "2024-07-01"),
            new TeaPair("protocol", "HTTP"),
            new TeaPair("pathname", "/rule/deleteEventRule"),
            new TeaPair("method", "POST"),
            new TeaPair("authType", "Anonymous"),
            new TeaPair("style", "RPC"),
            new TeaPair("reqBodyType", "json"),
            new TeaPair("bodyType", "json")
        ));
        return TeaModel.toModel(this.callApi(params, req, runtime), new DeleteEventRuleResponse());
    }

    /**
     * <b>description</b> :
     * <p>You can call this operation to delete an event rule.</p>
     * 
     * <b>summary</b> : 
     * <p>Deletes an event rule.</p>
     * 
     * @param request DeleteEventRuleRequest
     * @return DeleteEventRuleResponse
     */
    public DeleteEventRuleResponse deleteEventRule(DeleteEventRuleRequest request) throws Exception {
        com.aliyun.teautil.models.RuntimeOptions runtime = new com.aliyun.teautil.models.RuntimeOptions();
        return this.deleteEventRuleWithOptions(request, runtime);
    }

    /**
     * <b>description</b> :
     * <p>You can call this operation to update an event rule.</p>
     * 
     * <b>summary</b> : 
     * <p>Updates an event rule.</p>
     * 
     * @param request UpdateEventRuleRequest
     * @param runtime runtime options for this request RuntimeOptions
     * @return UpdateEventRuleResponse
     */
    public UpdateEventRuleResponse updateEventRuleWithOptions(UpdateEventRuleRequest request, com.aliyun.teautil.models.RuntimeOptions runtime) throws Exception {
        com.aliyun.teautil.Common.validateModel(request);
        java.util.Map<String, Object> body = new java.util.HashMap<>();
        if (!com.aliyun.teautil.Common.isUnset(request.eventBusName)) {
            body.put("eventBusName", request.eventBusName);
        }

        if (!com.aliyun.teautil.Common.isUnset(request.eventRuleName)) {
            body.put("eventRuleName", request.eventRuleName);
        }

        if (!com.aliyun.teautil.Common.isUnset(request.description)) {
            body.put("description", request.description);
        }

        if (!com.aliyun.teautil.Common.isUnset(request.filterPattern)) {
            body.put("filterPattern", request.filterPattern);
        }

        com.aliyun.teaopenapi.models.OpenApiRequest req = com.aliyun.teaopenapi.models.OpenApiRequest.build(TeaConverter.buildMap(
            new TeaPair("body", com.aliyun.teautil.Common.toJSONString(body))
        ));
        com.aliyun.teaopenapi.models.Params params = com.aliyun.teaopenapi.models.Params.build(TeaConverter.buildMap(
            new TeaPair("action", "UpdateEventRule"),
            new TeaPair("version", "2024-07-01"),
            new TeaPair("protocol", "HTTP"),
            new TeaPair("pathname", "/rule/updateEventRule"),
            new TeaPair("method", "POST"),
            new TeaPair("authType", "Anonymous"),
            new TeaPair("style", "RPC"),
            new TeaPair("reqBodyType", "json"),
            new TeaPair("bodyType", "json")
        ));
        return TeaModel.toModel(this.callApi(params, req, runtime), new UpdateEventRuleResponse());
    }

    /**
     * <b>description</b> :
     * <p>You can call this operation to update an event rule.</p>
     * 
     * <b>summary</b> : 
     * <p>Updates an event rule.</p>
     * 
     * @param request UpdateEventRuleRequest
     * @return UpdateEventRuleResponse
     */
    public UpdateEventRuleResponse updateEventRule(UpdateEventRuleRequest request) throws Exception {
        com.aliyun.teautil.models.RuntimeOptions runtime = new com.aliyun.teautil.models.RuntimeOptions();
        return this.updateEventRuleWithOptions(request, runtime);
    }

    /**
     * <b>description</b> :
     * <p>You can call this operation to list event rules.</p>
     * 
     * <b>summary</b> : 
     * <p>Lists event rules.</p>
     * 
     * @param request ListEventRulesRequest
     * @param runtime runtime options for this request RuntimeOptions
     * @return ListEventRulesResponse
     */
    public ListEventRulesResponse listEventRulesWithOptions(ListEventRulesRequest request, com.aliyun.teautil.models.RuntimeOptions runtime) throws Exception {
        com.aliyun.teautil.Common.validateModel(request);
        java.util.Map<String, Object> body = new java.util.HashMap<>();
        if (!com.aliyun.teautil.Common.isUnset(request.eventBusName)) {
            body.put("eventBusName", request.eventBusName);
        }

        if (!com.aliyun.teautil.Common.isUnset(request.maxResults)) {
            body.put("maxResults", request.maxResults);
        }

        if (!com.aliyun.teautil.Common.isUnset(request.nextToken)) {
            body.put("nextToken", request.nextToken);
        }

        com.aliyun.teaopenapi.models.OpenApiRequest req = com.aliyun.teaopenapi.models.OpenApiRequest.build(TeaConverter.buildMap(
            new TeaPair("body", com.aliyun.teautil.Common.toJSONString(body))
        ));
        com.aliyun.teaopenapi.models.Params params = com.aliyun.teaopenapi.models.Params.build(TeaConverter.buildMap(
            new TeaPair("action", "ListEventRules"),
            new TeaPair("version", "2024-07-01"),
            new TeaPair("protocol", "HTTP"),
            new TeaPair("pathname", "/rule/listEventRules"),
            new TeaPair("method", "POST"),
            new TeaPair("authType", "Anonymous"),
            new TeaPair("style", "RPC"),
            new TeaPair("reqBodyType", "json"),
            new TeaPair("bodyType", "json")
        ));
        return TeaModel.toModel(this.callApi(params, req, runtime), new ListEventRulesResponse());
    }

    /**
     * <b>description</b> :
     * <p>You can call this operation to list event rules.</p>
     * 
     * <b>summary</b> : 
     * <p>Lists event rules.</p>
     * 
     * @param request ListEventRulesRequest
     * @return ListEventRulesResponse
     */
    public ListEventRulesResponse listEventRules(ListEventRulesRequest request) throws Exception {
        com.aliyun.teautil.models.RuntimeOptions runtime = new com.aliyun.teautil.models.RuntimeOptions();
        return this.listEventRulesWithOptions(request, runtime);
    }

    /**
     * <b>description</b> :
     * <p>You can call this operation to enable an event rule.</p>
     * 
     * <b>summary</b> : 
     * <p>Enables an event rule.</p>
     * 
     * @param request EnableEventRuleRequest
     * @param runtime runtime options for this request RuntimeOptions
     * @return EnableEventRuleResponse
     */
    public EnableEventRuleResponse enableEventRuleWithOptions(EnableEventRuleRequest request, com.aliyun.teautil.models.RuntimeOptions runtime) throws Exception {
        com.aliyun.teautil.Common.validateModel(request);
        java.util.Map<String, Object> body = new java.util.HashMap<>();
        if (!com.aliyun.teautil.Common.isUnset(request.eventBusName)) {
            body.put("eventBusName", request.eventBusName);
        }

        if (!com.aliyun.teautil.Common.isUnset(request.eventRuleName)) {
            body.put("eventRuleName", request.eventRuleName);
        }

        com.aliyun.teaopenapi.models.OpenApiRequest req = com.aliyun.teaopenapi.models.OpenApiRequest.build(TeaConverter.buildMap(
            new TeaPair("body", com.aliyun.teautil.Common.toJSONString(body))
        ));
        com.aliyun.teaopenapi.models.Params params = com.aliyun.teaopenapi.models.Params.build(TeaConverter.buildMap(
            new TeaPair("action", "EnableEventRule"),
            new TeaPair("version", "2024-07-01"),
            new TeaPair("protocol", "HTTP"),
            new TeaPair("pathname", "/rule/enableEventRule"),
            new TeaPair("method", "POST"),
            new TeaPair("authType", "Anonymous"),
            new TeaPair("style", "RPC"),
            new TeaPair("reqBodyType", "json"),
            new TeaPair("bodyType", "json")
        ));
        return TeaModel.toModel(this.callApi(params, req, runtime), new EnableEventRuleResponse());
    }

    /**
     * <b>description</b> :
     * <p>You can call this operation to enable an event rule.</p>
     * 
     * <b>summary</b> : 
     * <p>Enables an event rule.</p>
     * 
     * @param request EnableEventRuleRequest
     * @return EnableEventRuleResponse
     */
    public EnableEventRuleResponse enableEventRule(EnableEventRuleRequest request) throws Exception {
        com.aliyun.teautil.models.RuntimeOptions runtime = new com.aliyun.teautil.models.RuntimeOptions();
        return this.enableEventRuleWithOptions(request, runtime);
    }

    /**
     * <b>description</b> :
     * <p>You can call this operation to disable an event rule.</p>
     * 
     * <b>summary</b> : 
     * <p>Disables an event rule.</p>
     * 
     * @param request DisableEventRuleRequest
     * @param runtime runtime options for this request RuntimeOptions
     * @return DisableEventRuleResponse
     */
    public DisableEventRuleResponse disableEventRuleWithOptions(DisableEventRuleRequest request, com.aliyun.teautil.models.RuntimeOptions runtime) throws Exception {
        com.aliyun.teautil.Common.validateModel(request);
        java.util.Map<String, Object> body = new java.util.HashMap<>();
        if (!com.aliyun.teautil.Common.isUnset(request.eventBusName)) {
            body.put("eventBusName", request.eventBusName);
        }

        if (!com.aliyun.teautil.Common.isUnset(request.eventRuleName)) {
            body.put("eventRuleName", request.eventRuleName);
        }

        com.aliyun.teaopenapi.models.OpenApiRequest req = com.aliyun.teaopenapi.models.OpenApiRequest.build(TeaConverter.buildMap(
            new TeaPair("body", com.aliyun.teautil.Common.toJSONString(body))
        ));
        com.aliyun.teaopenapi.models.Params params = com.aliyun.teaopenapi.models.Params.build(TeaConverter.buildMap(
            new TeaPair("action", "DisableEventRule"),
            new TeaPair("version", "2024-07-01"),
            new TeaPair("protocol", "HTTP"),
            new TeaPair("pathname", "/rule/disableEventRule"),
            new TeaPair("method", "POST"),
            new TeaPair("authType", "Anonymous"),
            new TeaPair("style", "RPC"),
            new TeaPair("reqBodyType", "json"),
            new TeaPair("bodyType", "json")
        ));
        return TeaModel.toModel(this.callApi(params, req, runtime), new DisableEventRuleResponse());
    }

    /**
     * <b>description</b> :
     * <p>You can call this operation to disable an event rule.</p>
     * 
     * <b>summary</b> : 
     * <p>Disables an event rule.</p>
     * 
     * @param request DisableEventRuleRequest
     * @return DisableEventRuleResponse
     */
    public DisableEventRuleResponse disableEventRule(DisableEventRuleRequest request) throws Exception {
        com.aliyun.teautil.models.RuntimeOptions runtime = new com.aliyun.teautil.models.RuntimeOptions();
        return this.disableEventRuleWithOptions(request, runtime);
    }

    /**
     * <b>description</b> :
     * <p>You can call this operation to create an event source.</p>
     * 
     * <b>summary</b> : 
     * <p>Creates an event source.</p>
     * 
     * @param request CreateEventSourceRequest
     * @param runtime runtime options for this request RuntimeOptions
     * @return CreateEventSourceResponse
     */
    public CreateEventSourceResponse createEventSourceWithOptions(CreateEventSourceRequest request, com.aliyun.teautil.models.RuntimeOptions runtime) throws Exception {
        com.aliyun.teautil.Common.validateModel(request);
        java.util.Map<String, Object> body = new java.util.HashMap<>();
        if (!com.aliyun.teautil.Common.isUnset(request.description)) {
            body.put("description", request.description);
        }

        if (!com.aliyun.teautil.Common.isUnset(request.eventBusName)) {
            body.put("eventBusName", request.eventBusName);
        }

        if (!com.aliyun.teautil.Common.isUnset(request.eventSourceName)) {
            body.put("eventSourceName", request.eventSourceName);
        }

        if (!com.aliyun.teautil.Common.isUnset(request.className)) {
            body.put("className", request.className);
        }

        if (!com.aliyun.teautil.Common.isUnset(request.config)) {
            body.put("config", request.config);
        }

        com.aliyun.teaopenapi.models.OpenApiRequest req = com.aliyun.teaopenapi.models.OpenApiRequest.build(TeaConverter.buildMap(
            new TeaPair("body", com.aliyun.teautil.Common.toJSONString(body))
        ));
        com.aliyun.teaopenapi.models.Params params = com.aliyun.teaopenapi.models.Params.build(TeaConverter.buildMap(
            new TeaPair("action", "CreateEventSource"),
            new TeaPair("version", "2024-07-01"),
            new TeaPair("protocol", "HTTP"),
            new TeaPair("pathname", "/source/createEventSource"),
            new TeaPair("method", "POST"),
            new TeaPair("authType", "Anonymous"),
            new TeaPair("style", "RPC"),
            new TeaPair("reqBodyType", "json"),
            new TeaPair("bodyType", "json")
        ));
        return TeaModel.toModel(this.callApi(params, req, runtime), new CreateEventSourceResponse());
    }

    /**
     * <b>description</b> :
     * <p>You can call this operation to create an event source.</p>
     * 
     * <b>summary</b> : 
     * <p>Creates an event source.</p>
     * 
     * @param request CreateEventSourceRequest
     * @return CreateEventSourceResponse
     */
    public CreateEventSourceResponse createEventSource(CreateEventSourceRequest request) throws Exception {
        com.aliyun.teautil.models.RuntimeOptions runtime = new com.aliyun.teautil.models.RuntimeOptions();
        return this.createEventSourceWithOptions(request, runtime);
    }

    /**
     * <b>description</b> :
     * <p>You can call this operation to update an event source.</p>
     * 
     * <b>summary</b> : 
     * <p>Updates an event source.</p>
     * 
     * @param request UpdateEventSourceRequest
     * @param runtime runtime options for this request RuntimeOptions
     * @return UpdateEventSourceResponse
     */
    public UpdateEventSourceResponse updateEventSourceWithOptions(UpdateEventSourceRequest request, com.aliyun.teautil.models.RuntimeOptions runtime) throws Exception {
        com.aliyun.teautil.Common.validateModel(request);
        java.util.Map<String, Object> body = new java.util.HashMap<>();
        if (!com.aliyun.teautil.Common.isUnset(request.eventBusName)) {
            body.put("eventBusName", request.eventBusName);
        }

        if (!com.aliyun.teautil.Common.isUnset(request.eventSourceName)) {
            body.put("eventSourceName", request.eventSourceName);
        }

        if (!com.aliyun.teautil.Common.isUnset(request.description)) {
            body.put("description", request.description);
        }

        if (!com.aliyun.teautil.Common.isUnset(request.className)) {
            body.put("className", request.className);
        }

        if (!com.aliyun.teautil.Common.isUnset(request.status)) {
            body.put("status", request.status);
        }

        if (!com.aliyun.teautil.Common.isUnset(request.config)) {
            body.put("config", request.config);
        }

        com.aliyun.teaopenapi.models.OpenApiRequest req = com.aliyun.teaopenapi.models.OpenApiRequest.build(TeaConverter.buildMap(
            new TeaPair("body", com.aliyun.teautil.Common.toJSONString(body))
        ));
        com.aliyun.teaopenapi.models.Params params = com.aliyun.teaopenapi.models.Params.build(TeaConverter.buildMap(
            new TeaPair("action", "UpdateEventSource"),
            new TeaPair("version", "2024-07-01"),
            new TeaPair("protocol", "HTTP"),
            new TeaPair("pathname", "/source/updateEventSource"),
            new TeaPair("method", "POST"),
            new TeaPair("authType", "Anonymous"),
            new TeaPair("style", "RPC"),
            new TeaPair("reqBodyType", "json"),
            new TeaPair("bodyType", "json")
        ));
        return TeaModel.toModel(this.callApi(params, req, runtime), new UpdateEventSourceResponse());
    }

    /**
     * <b>description</b> :
     * <p>You can call this operation to update an event source.</p>
     * 
     * <b>summary</b> : 
     * <p>Updates an event source.</p>
     * 
     * @param request UpdateEventSourceRequest
     * @return UpdateEventSourceResponse
     */
    public UpdateEventSourceResponse updateEventSource(UpdateEventSourceRequest request) throws Exception {
        com.aliyun.teautil.models.RuntimeOptions runtime = new com.aliyun.teautil.models.RuntimeOptions();
        return this.updateEventSourceWithOptions(request, runtime);
    }

    /**
     * <b>description</b> :
     * <p>You can call this API operation to delete an event source.</p>
     * 
     * <b>summary</b> : 
     * <p>Deletes an event source.</p>
     * 
     * @param request DeleteEventSourceRequest
     * @param runtime runtime options for this request RuntimeOptions
     * @return DeleteEventSourceResponse
     */
    public DeleteEventSourceResponse deleteEventSourceWithOptions(DeleteEventSourceRequest request, com.aliyun.teautil.models.RuntimeOptions runtime) throws Exception {
        com.aliyun.teautil.Common.validateModel(request);
        java.util.Map<String, Object> body = new java.util.HashMap<>();
        if (!com.aliyun.teautil.Common.isUnset(request.eventBusName)) {
            body.put("eventBusName", request.eventBusName);
        }

        if (!com.aliyun.teautil.Common.isUnset(request.eventSourceName)) {
            body.put("eventSourceName", request.eventSourceName);
        }

        com.aliyun.teaopenapi.models.OpenApiRequest req = com.aliyun.teaopenapi.models.OpenApiRequest.build(TeaConverter.buildMap(
            new TeaPair("body", com.aliyun.teautil.Common.toJSONString(body))
        ));
        com.aliyun.teaopenapi.models.Params params = com.aliyun.teaopenapi.models.Params.build(TeaConverter.buildMap(
            new TeaPair("action", "DeleteEventSource"),
            new TeaPair("version", "2024-07-01"),
            new TeaPair("protocol", "HTTP"),
            new TeaPair("pathname", "/source/deleteEventSource"),
            new TeaPair("method", "POST"),
            new TeaPair("authType", "Anonymous"),
            new TeaPair("style", "RPC"),
            new TeaPair("reqBodyType", "json"),
            new TeaPair("bodyType", "json")
        ));
        return TeaModel.toModel(this.callApi(params, req, runtime), new DeleteEventSourceResponse());
    }

    /**
     * <b>description</b> :
     * <p>You can call this API operation to delete an event source.</p>
     * 
     * <b>summary</b> : 
     * <p>Deletes an event source.</p>
     * 
     * @param request DeleteEventSourceRequest
     * @return DeleteEventSourceResponse
     */
    public DeleteEventSourceResponse deleteEventSource(DeleteEventSourceRequest request) throws Exception {
        com.aliyun.teautil.models.RuntimeOptions runtime = new com.aliyun.teautil.models.RuntimeOptions();
        return this.deleteEventSourceWithOptions(request, runtime);
    }

    /**
     * <b>description</b> :
     * <p>You can call this API operation to get an event source.</p>
     * 
     * <b>summary</b> : 
     * <p>Gets an event source.</p>
     * 
     * @param request GetEventSourceRequest
     * @param runtime runtime options for this request RuntimeOptions
     * @return GetEventSourceResponse
     */
    public GetEventSourceResponse getEventSourceWithOptions(GetEventSourceRequest request, com.aliyun.teautil.models.RuntimeOptions runtime) throws Exception {
        com.aliyun.teautil.Common.validateModel(request);
        java.util.Map<String, Object> body = new java.util.HashMap<>();
        if (!com.aliyun.teautil.Common.isUnset(request.eventBusName)) {
            body.put("eventBusName", request.eventBusName);
        }

        if (!com.aliyun.teautil.Common.isUnset(request.eventSourceName)) {
            body.put("eventSourceName", request.eventSourceName);
        }

        com.aliyun.teaopenapi.models.OpenApiRequest req = com.aliyun.teaopenapi.models.OpenApiRequest.build(TeaConverter.buildMap(
            new TeaPair("body", com.aliyun.teautil.Common.toJSONString(body))
        ));
        com.aliyun.teaopenapi.models.Params params = com.aliyun.teaopenapi.models.Params.build(TeaConverter.buildMap(
            new TeaPair("action", "GetEventSource"),
            new TeaPair("version", "2024-07-01"),
            new TeaPair("protocol", "HTTP"),
            new TeaPair("pathname", "/source/getEventSource"),
            new TeaPair("method", "POST"),
            new TeaPair("authType", "Anonymous"),
            new TeaPair("style", "RPC"),
            new TeaPair("reqBodyType", "json"),
            new TeaPair("bodyType", "json")
        ));
        return TeaModel.toModel(this.callApi(params, req, runtime), new GetEventSourceResponse());
    }

    /**
     * <b>description</b> :
     * <p>You can call this API operation to get an event source.</p>
     * 
     * <b>summary</b> : 
     * <p>Gets an event source.</p>
     * 
     * @param request GetEventSourceRequest
     * @return GetEventSourceResponse
     */
    public GetEventSourceResponse getEventSource(GetEventSourceRequest request) throws Exception {
        com.aliyun.teautil.models.RuntimeOptions runtime = new com.aliyun.teautil.models.RuntimeOptions();
        return this.getEventSourceWithOptions(request, runtime);
    }

    /**
     * <b>description</b> :
     * <p>You can call this API operation to list event sources.</p>
     * 
     * <b>summary</b> : 
     * <p>Lists event sources.</p>
     * 
     * @param request ListEventSourcesRequest
     * @param runtime runtime options for this request RuntimeOptions
     * @return ListEventSourcesResponse
     */
    public ListEventSourcesResponse listEventSourcesWithOptions(ListEventSourcesRequest request, com.aliyun.teautil.models.RuntimeOptions runtime) throws Exception {
        com.aliyun.teautil.Common.validateModel(request);
        java.util.Map<String, Object> body = new java.util.HashMap<>();
        if (!com.aliyun.teautil.Common.isUnset(request.eventBusName)) {
            body.put("eventBusName", request.eventBusName);
        }

        if (!com.aliyun.teautil.Common.isUnset(request.eventSourceType)) {
            body.put("eventSourceType", request.eventSourceType);
        }

        if (!com.aliyun.teautil.Common.isUnset(request.maxResults)) {
            body.put("maxResults", request.maxResults);
        }

        if (!com.aliyun.teautil.Common.isUnset(request.nextToken)) {
            body.put("nextToken", request.nextToken);
        }

        com.aliyun.teaopenapi.models.OpenApiRequest req = com.aliyun.teaopenapi.models.OpenApiRequest.build(TeaConverter.buildMap(
            new TeaPair("body", com.aliyun.teautil.Common.toJSONString(body))
        ));
        com.aliyun.teaopenapi.models.Params params = com.aliyun.teaopenapi.models.Params.build(TeaConverter.buildMap(
            new TeaPair("action", "ListEventSources"),
            new TeaPair("version", "2024-07-01"),
            new TeaPair("protocol", "HTTP"),
            new TeaPair("pathname", "/source/listEventSources"),
            new TeaPair("method", "POST"),
            new TeaPair("authType", "Anonymous"),
            new TeaPair("style", "RPC"),
            new TeaPair("reqBodyType", "json"),
            new TeaPair("bodyType", "json")
        ));
        return TeaModel.toModel(this.callApi(params, req, runtime), new ListEventSourcesResponse());
    }

    /**
     * <b>description</b> :
     * <p>You can call this API operation to list event sources.</p>
     * 
     * <b>summary</b> : 
     * <p>Lists event sources.</p>
     * 
     * @param request ListEventSourcesRequest
     * @return ListEventSourcesResponse
     */
    public ListEventSourcesResponse listEventSources(ListEventSourcesRequest request) throws Exception {
        com.aliyun.teautil.models.RuntimeOptions runtime = new com.aliyun.teautil.models.RuntimeOptions();
        return this.listEventSourcesWithOptions(request, runtime);
    }

    /**
     * <b>description</b> :
     * <p>You can call this operation to create event targets.</p>
     * 
     * <b>summary</b> : 
     * <p>Creates event targets.</p>
     * 
     * @param request CreateEventTargetsRequest
     * @param runtime runtime options for this request RuntimeOptions
     * @return CreateEventTargetsResponse
     */
    public CreateEventTargetsResponse createEventTargetsWithOptions(CreateEventTargetsRequest request, com.aliyun.teautil.models.RuntimeOptions runtime) throws Exception {
        com.aliyun.teautil.Common.validateModel(request);
        java.util.Map<String, Object> body = new java.util.HashMap<>();
        if (!com.aliyun.teautil.Common.isUnset(request.eventBusName)) {
            body.put("eventBusName", request.eventBusName);
        }

        if (!com.aliyun.teautil.Common.isUnset(request.eventRuleName)) {
            body.put("eventRuleName", request.eventRuleName);
        }

        if (!com.aliyun.teautil.Common.isUnset(request.eventTargets)) {
            body.put("eventTargets", request.eventTargets);
        }

        com.aliyun.teaopenapi.models.OpenApiRequest req = com.aliyun.teaopenapi.models.OpenApiRequest.build(TeaConverter.buildMap(
            new TeaPair("body", com.aliyun.teautil.Common.toJSONString(body))
        ));
        com.aliyun.teaopenapi.models.Params params = com.aliyun.teaopenapi.models.Params.build(TeaConverter.buildMap(
            new TeaPair("action", "CreateEventTargets"),
            new TeaPair("version", "2024-07-01"),
            new TeaPair("protocol", "HTTP"),
            new TeaPair("pathname", "/target/createEventTargets"),
            new TeaPair("method", "POST"),
            new TeaPair("authType", "Anonymous"),
            new TeaPair("style", "RPC"),
            new TeaPair("reqBodyType", "json"),
            new TeaPair("bodyType", "json")
        ));
        return TeaModel.toModel(this.callApi(params, req, runtime), new CreateEventTargetsResponse());
    }

    /**
     * <b>description</b> :
     * <p>You can call this operation to create event targets.</p>
     * 
     * <b>summary</b> : 
     * <p>Creates event targets.</p>
     * 
     * @param request CreateEventTargetsRequest
     * @return CreateEventTargetsResponse
     */
    public CreateEventTargetsResponse createEventTargets(CreateEventTargetsRequest request) throws Exception {
        com.aliyun.teautil.models.RuntimeOptions runtime = new com.aliyun.teautil.models.RuntimeOptions();
        return this.createEventTargetsWithOptions(request, runtime);
    }

    /**
     * <b>description</b> :
     * <p>You can call this operation to update event targets.</p>
     * 
     * <b>summary</b> : 
     * <p>Updates event targets.</p>
     * 
     * @param request UpdateEventTargetsRequest
     * @param runtime runtime options for this request RuntimeOptions
     * @return UpdateEventTargetsResponse
     */
    public UpdateEventTargetsResponse updateEventTargetsWithOptions(UpdateEventTargetsRequest request, com.aliyun.teautil.models.RuntimeOptions runtime) throws Exception {
        com.aliyun.teautil.Common.validateModel(request);
        java.util.Map<String, Object> body = new java.util.HashMap<>();
        if (!com.aliyun.teautil.Common.isUnset(request.eventBusName)) {
            body.put("eventBusName", request.eventBusName);
        }

        if (!com.aliyun.teautil.Common.isUnset(request.eventRuleName)) {
            body.put("eventRuleName", request.eventRuleName);
        }

        if (!com.aliyun.teautil.Common.isUnset(request.eventTargets)) {
            body.put("eventTargets", request.eventTargets);
        }

        com.aliyun.teaopenapi.models.OpenApiRequest req = com.aliyun.teaopenapi.models.OpenApiRequest.build(TeaConverter.buildMap(
            new TeaPair("body", com.aliyun.teautil.Common.toJSONString(body))
        ));
        com.aliyun.teaopenapi.models.Params params = com.aliyun.teaopenapi.models.Params.build(TeaConverter.buildMap(
            new TeaPair("action", "UpdateEventTargets"),
            new TeaPair("version", "2024-07-01"),
            new TeaPair("protocol", "HTTP"),
            new TeaPair("pathname", "/target/updateEventTargets"),
            new TeaPair("method", "POST"),
            new TeaPair("authType", "Anonymous"),
            new TeaPair("style", "RPC"),
            new TeaPair("reqBodyType", "json"),
            new TeaPair("bodyType", "json")
        ));
        return TeaModel.toModel(this.callApi(params, req, runtime), new UpdateEventTargetsResponse());
    }

    /**
     * <b>description</b> :
     * <p>You can call this operation to update event targets.</p>
     * 
     * <b>summary</b> : 
     * <p>Updates event targets.</p>
     * 
     * @param request UpdateEventTargetsRequest
     * @return UpdateEventTargetsResponse
     */
    public UpdateEventTargetsResponse updateEventTargets(UpdateEventTargetsRequest request) throws Exception {
        com.aliyun.teautil.models.RuntimeOptions runtime = new com.aliyun.teautil.models.RuntimeOptions();
        return this.updateEventTargetsWithOptions(request, runtime);
    }

    /**
     * <b>description</b> :
     * <p>You can call this operation to delete event targets.</p>
     * 
     * <b>summary</b> : 
     * <p>Deletes event targets.</p>
     * 
     * @param request DeleteEventTargetsRequest
     * @param runtime runtime options for this request RuntimeOptions
     * @return DeleteEventTargetsResponse
     */
    public DeleteEventTargetsResponse deleteEventTargetsWithOptions(DeleteEventTargetsRequest request, com.aliyun.teautil.models.RuntimeOptions runtime) throws Exception {
        com.aliyun.teautil.Common.validateModel(request);
        java.util.Map<String, Object> body = new java.util.HashMap<>();
        if (!com.aliyun.teautil.Common.isUnset(request.eventBusName)) {
            body.put("eventBusName", request.eventBusName);
        }

        if (!com.aliyun.teautil.Common.isUnset(request.eventRuleName)) {
            body.put("eventRuleName", request.eventRuleName);
        }

        if (!com.aliyun.teautil.Common.isUnset(request.eventTargetNames)) {
            body.put("eventTargetNames", request.eventTargetNames);
        }

        com.aliyun.teaopenapi.models.OpenApiRequest req = com.aliyun.teaopenapi.models.OpenApiRequest.build(TeaConverter.buildMap(
            new TeaPair("body", com.aliyun.teautil.Common.toJSONString(body))
        ));
        com.aliyun.teaopenapi.models.Params params = com.aliyun.teaopenapi.models.Params.build(TeaConverter.buildMap(
            new TeaPair("action", "DeleteEventTargets"),
            new TeaPair("version", "2024-07-01"),
            new TeaPair("protocol", "HTTP"),
            new TeaPair("pathname", "/target/deleteEventTargets"),
            new TeaPair("method", "POST"),
            new TeaPair("authType", "Anonymous"),
            new TeaPair("style", "RPC"),
            new TeaPair("reqBodyType", "json"),
            new TeaPair("bodyType", "json")
        ));
        return TeaModel.toModel(this.callApi(params, req, runtime), new DeleteEventTargetsResponse());
    }

    /**
     * <b>description</b> :
     * <p>You can call this operation to delete event targets.</p>
     * 
     * <b>summary</b> : 
     * <p>Deletes event targets.</p>
     * 
     * @param request DeleteEventTargetsRequest
     * @return DeleteEventTargetsResponse
     */
    public DeleteEventTargetsResponse deleteEventTargets(DeleteEventTargetsRequest request) throws Exception {
        com.aliyun.teautil.models.RuntimeOptions runtime = new com.aliyun.teautil.models.RuntimeOptions();
        return this.deleteEventTargetsWithOptions(request, runtime);
    }

    /**
     * <b>description</b> :
     * <p>You can call this operation to list event targets.</p>
     * 
     * <b>summary</b> : 
     * <p>Lists event targets.</p>
     * 
     * @param request ListEventTargetsRequest
     * @param runtime runtime options for this request RuntimeOptions
     * @return ListEventTargetsResponse
     */
    public ListEventTargetsResponse listEventTargetsWithOptions(ListEventTargetsRequest request, com.aliyun.teautil.models.RuntimeOptions runtime) throws Exception {
        com.aliyun.teautil.Common.validateModel(request);
        java.util.Map<String, Object> body = new java.util.HashMap<>();
        if (!com.aliyun.teautil.Common.isUnset(request.eventBusName)) {
            body.put("eventBusName", request.eventBusName);
        }

        if (!com.aliyun.teautil.Common.isUnset(request.eventRuleName)) {
            body.put("eventRuleName", request.eventRuleName);
        }

        com.aliyun.teaopenapi.models.OpenApiRequest req = com.aliyun.teaopenapi.models.OpenApiRequest.build(TeaConverter.buildMap(
            new TeaPair("body", com.aliyun.teautil.Common.toJSONString(body))
        ));
        com.aliyun.teaopenapi.models.Params params = com.aliyun.teaopenapi.models.Params.build(TeaConverter.buildMap(
            new TeaPair("action", "ListEventTargets"),
            new TeaPair("version", "2024-07-01"),
            new TeaPair("protocol", "HTTP"),
            new TeaPair("pathname", "/target/listEventTargets"),
            new TeaPair("method", "POST"),
            new TeaPair("authType", "Anonymous"),
            new TeaPair("style", "RPC"),
            new TeaPair("reqBodyType", "json"),
            new TeaPair("bodyType", "json")
        ));
        return TeaModel.toModel(this.callApi(params, req, runtime), new ListEventTargetsResponse());
    }

    /**
     * <b>description</b> :
     * <p>You can call this operation to list event targets.</p>
     * 
     * <b>summary</b> : 
     * <p>Lists event targets.</p>
     * 
     * @param request ListEventTargetsRequest
     * @return ListEventTargetsResponse
     */
    public ListEventTargetsResponse listEventTargets(ListEventTargetsRequest request) throws Exception {
        com.aliyun.teautil.models.RuntimeOptions runtime = new com.aliyun.teautil.models.RuntimeOptions();
        return this.listEventTargetsWithOptions(request, runtime);
    }

    /**
     * <b>description</b> :
     * <p>You can call this API operation to query all event buses.</p>
     * 
     * <b>summary</b> : 
     * <p>Queries all event buses.</p>
     * 
     * @param request ListEventTypesRequest
     * @param runtime runtime options for this request RuntimeOptions
     * @return ListEventTypesResponse
     */
    public ListEventTypesResponse listEventTypesWithOptions(ListEventTypesRequest request, com.aliyun.teautil.models.RuntimeOptions runtime) throws Exception {
        com.aliyun.teautil.Common.validateModel(request);
        java.util.Map<String, Object> body = new java.util.HashMap<>();
        if (!com.aliyun.teautil.Common.isUnset(request.eventBusName)) {
            body.put("eventBusName", request.eventBusName);
        }

        if (!com.aliyun.teautil.Common.isUnset(request.eventSourceName)) {
            body.put("eventSourceName", request.eventSourceName);
        }

        if (!com.aliyun.teautil.Common.isUnset(request.maxResults)) {
            body.put("maxResults", request.maxResults);
        }

        if (!com.aliyun.teautil.Common.isUnset(request.nextToken)) {
            body.put("nextToken", request.nextToken);
        }

        com.aliyun.teaopenapi.models.OpenApiRequest req = com.aliyun.teaopenapi.models.OpenApiRequest.build(TeaConverter.buildMap(
            new TeaPair("body", com.aliyun.teautil.Common.toJSONString(body))
        ));
        com.aliyun.teaopenapi.models.Params params = com.aliyun.teaopenapi.models.Params.build(TeaConverter.buildMap(
            new TeaPair("action", "listEventTypes"),
            new TeaPair("version", "2024-07-01"),
            new TeaPair("protocol", "HTTP"),
            new TeaPair("pathname", "/type/listEventTypes"),
            new TeaPair("method", "POST"),
            new TeaPair("authType", "Anonymous"),
            new TeaPair("style", "RPC"),
            new TeaPair("reqBodyType", "json"),
            new TeaPair("bodyType", "json")
        ));
        return TeaModel.toModel(this.callApi(params, req, runtime), new ListEventTypesResponse());
    }

    /**
     * <b>description</b> :
     * <p>You can call this API operation to query all event buses.</p>
     * 
     * <b>summary</b> : 
     * <p>Queries all event buses.</p>
     * 
     * @param request ListEventTypesRequest
     * @return ListEventTypesResponse
     */
    public ListEventTypesResponse listEventTypes(ListEventTypesRequest request) throws Exception {
        com.aliyun.teautil.models.RuntimeOptions runtime = new com.aliyun.teautil.models.RuntimeOptions();
        return this.listEventTypesWithOptions(request, runtime);
    }
}
