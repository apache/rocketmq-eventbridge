/*
 * Licensed to the Apache Software Foundation (ASF) under one or more
 * contributor license agreements.  See the NOTICE file distributed with
 * this work for additional information regarding copyright ownership.
 * The ASF licenses this file to You under the Apache License, Version 2.0
 * (the "License"); you may not use this file except in compliance with
 * the License.  You may obtain a copy of the License at
 *
 *     http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */

package org.apache.rocketmq.eventbridge.domain.common.exception;

import org.apache.rocketmq.eventbridge.exception.code.BaseErrorCode;

public enum EventBridgeErrorCode implements BaseErrorCode {
    //Default
    Success(200, "Success", "success"),
    InternalError(500, "InternalError", "InternalError"),
    GenerateTokenError(500, "GenerateTokenError", "Generate token failed, {0}."),

    //Put Events
    PutEventsRequestMoreThanOneEventBus(409, "PutEventsRequestMoreThanOneEventBus",
        "The put events request has more than one  event bus [{0}] "),
    PutEventsRequestSecurityCheckFailed(409, "PutEventsRequestSecurityCheckFailed",
        "The putEvents request failed the webhook security check for {0}. " +
            "Event source configuration is {1}, the parameter in the request is {2}."),
    JSON_ATTRIBUTE_INVALID(409, "JsonAttributeInvalid", "The Json attribute is invalid"),

    //Event Bus
    EventBusNotExist(409, "EventBusNotExist", "The event bus [{0}] not existed!"),
    EventBusNameInvalid(409, "EventBusNameInvalid", "The event bus name [{0}] is invalid!"),
    EventBusAlreadyExist(409, "EventBusAlreadyExist", "The event bus [{0}] already existed!"),
    EventBusCountExceedLimit(409, "EventBusCountExceedLimit",
        "The current count of event bus is [{0}], which will exceed the limit quota [{1}]"),
    EventBusRuleNotEmptyForDelete(409, "EventBusRuleNotEmptyForDelete",
        "The rules of eventbus [{0}] exist, please delete them before delete event bus."),
    EventBusSourceNotEmptyForDelete(409, "EventBusSourceNotEmptyForDelete",
        "The source of eventbus  [{0}] exist, please delete them before delete event bus."),

    //Event Source
    EventSourceNotExist(409, "EventSourceNotExist", "The event source [{0}] of event bus [{1}] not existed!"),
    EventSourceAlreadyExist(409, "EventSourceAlreadyExist",
        "The event source [{0}] of event bus [{1}] already existed!"),
    EventSourceCountExceedLimit(409, "EventSourceCountExceedLimit",
        "The current count of event source is [{0}], which will exceed the limit quota [{1}]"),
    EventSourceNameInvalid(409, "EventSourceNameInvalid", "The event source name [{0}] is invalid!"),
    EventSourceTypeInvalid(409, "EventSourceTypeInvalid", "The event source type[{0}] is invalid!"),
    EventSourceStatusInvalid(409, "EventSourceStatusInvalid", "The event source status[{0}] is invalid!"),
    EventSourceTypeOrClassInvalid(409, "EventSourceTypeOrClassInvalid",
        "The event source type[{0}] or class[{1}] is invalid!"),
    HttpSourceParametersInvalid(409, "HttpSourceParametersInvalid",
        "The parameters of http source is invalid. {0}"),
    HttpSourceParametersEmpty(409, "HttpSourceParametersEmpty",
        "The parameters of http source is empty or contains empty value. Invalid parameter name={0}"),
    ExceedHttpSourceParametersCount(409, "ExceedHttpSourceParametersCount",
        "Exceed http source parameters count limit. Limit count is {0}, and the value of {1} is {2}"),

    //Event Target
    EventTargetNotExist(409, "EventTargetNotExist",
        "The event target [{0}] of event rule [{1}] on eventbus [{2}] is not existed!"),
    EventTargetAlreadyExist(409, "EventTargetAlreadyExist",
        "The event target [{0}] of event rule [{1}] on eventbus [{2}] already existed!"),

    //Event Source Class
    EventSourceClassNotExist(409, "EventSourceClassNotExist", "The event source class [{0}] not existed!"),
    EventSourceMissingAttribute(409, "EventSourceMissingAttribute", "Missing the attribute [{0}:{1}] "),
    EventSourceIneffectiveAttribute(409, "EventSourceIneffectiveAttribute",
        "The attribute [{0}] is ineffective, " + "which effective attribute is [{1}]."),

    //Event Target Class
    EventTargetClassNotExist(409, "EventTargetClassNotExist", "The event target class [{0}] not existed!"),
    EventTargetMissingAttribute(409, "EventTargetMissingAttribute", "Missing the attribute [{0}:{1}] "),
    EventTargetIneffectiveAttribute(409, "EventTargetIneffectiveAttribute",
        "The attribute [{0}] is ineffective, " + "which effective attribute is [{1}]."),

    //Event Rule
    EventRuleNotExist(409, "EventRuleNotExist", "The event rule [{0}] of event bus [{1}] not existed!"),
    EventRuleNameInvalid(409, "EventRuleNameInvalid", "The event rule name [{0}] is invalid!"),
    EventRuleCountExceedLimit(409, "EventRuleCountExceedLimit",
        "The current count of event rule is [{0}], which will exceed the limit quota [{1}]"),
    EventRuleAlreadyExist(409, "EventRuleAlreadyExist", "The event rule [{0}] of event bus [{1}] already existed!"),

    //Connection
    ConnectionBoundApiDestination(409, "ConnectionBoundApiDestination", "The Connection [{0}] has bound API Destination, deletion is not allowed."),
    ConnectionAlreadyExist(409, "ConnectionAlreadyExist", "The Connection [{0}]  already existed!"),
    ConnectionNameInvalid(409, "ConnectionNameInvalid", "The Connection name [{0}] is invalid! Which should match the pattern [{1}]."),
    ConnectionCountExceedLimit(409, "ConnectionCountExceedLimit", "The current count of Connection is [{0}], which will exceed the limit quota [{1}]."),
    ConnectionAuthParametersInvalid(409, "ConnectionAuthParametersInvalid", "The auth parameters of Connection is invalid! Please see the documentation for details."),
    ConnectionNetworkParametersInvalid(409, "ConnectionNetworkParametersInvalid", "The network parameters of Connection is invalid! Please see the documentation for details."),
    ConnectionNotExist(409, "ConnectionNotExist", "The Connection [{0}] not existed!"),
    LimitSizeInvalid(409, "LimitSizeInvalid", "The limit size of page is invalid, which must greater than 0 and less than [{0}]."),
    NextTokenInvalid(409, "NextTokenInvalid", "The next token of page is invalid. which should be {[0]}."),
    OauthHttpParametersEmpty(409, "OauthHttpParametersEmpty", "OauthHttpParameters is Empty."),
    BasicRequiredParameterIsEmpty(409, "BasicRequiredParameterIsEmpty", "Basic required parameters are empty, the required parameters are username and password !"),

    BasicUserNameLengthExceed(409, "BasicUserNameLengthExceed", "Basic username length cannot exceed 127 !"),

    BasicPassWordLengthExceed(409, "BasicPassWordLengthExceed", "Basic password length cannot exceed 127 !"),

    ApiKeyNameLengthExceed(409, "ApiKeyNameLengthExceed", "Api key name length cannot exceed 127 !"),

    ApiKeyValueLengthExceed(409, "ApiKeyValueLengthExceed", "Api key value length cannot exceed 127 !"),
    ApiKeyRequiredParameterIsEmpty(409, "ApiKeyRequiredParameterIsEmpty", "Api Key required parameters are empty, the required parameters are apiKeyName and apiKeyValue !"),
    OAuthRequiredParameterIsEmpty(409, "OAuthRequiredParameterIsEmpty", "OAuth required parameters are empty, the required parameters are authorizationEndpoint and httpMethod !"),

    //API Destination
    ApiDestinationNameInvalid(409, "ApiDestinationNameInvalid", "The api-destination name [{0}] is invalid! Which should match the pattern [{1}]."),
    ApiDestinationCountExceedLimit(409, "ApiDestinationCountExceedLimit", "The current count of api-destination is [{0}], which will exceed the limit quota [{1}]."),
    ApiDestinationAlreadyExist(409, "ApiDestinationAlreadyExist", "The api-destination [{0}]  already existed!"),
    ApiDestinationParametersInvalid(409, "ApiDestinationParametersInvalid", "The api-destination parameters [{0}] is invalid! Please see the documentation for details."),
    ApiDestinationNotExist(409, "ApiDestinationNotExist", "The api-destination [{0}] not existed!"),

    // SecretManagerAPI
    SecretManagerAPICreateSecretNameFailed(409, "SecretManagerAPICreateSecretNameFailed", "Create secret manager api secret name [{0}] failed"),
    SecretManagerAPIDeleteSecretFailed(409, "SecretManagerAPIDeleteSecretFailed", "Delete secret manager api secret [{0}] failed"),
    SecretManagerAPIGetSecretValueFailed(409, "SecretManagerAPIGetSecretValueFailed", "Get secret manager api secret value [{0}] failed"),

    HttpApiParametersIsNull(409, "HttpApiParametersIsNull", "HttpApiParameters is null !"),
    EndpointIsBlank(409, "EndpointIsBlank", "Endpoint is blank !"),
    MethodIsBlank(409, "Method", "Method is blank !"),
    NetworkParametersIsNull(409, "NetworkParametersIsNull", "NetworkParameters is null !"),
    NetworkTypeIsBlank(409, "NetworkTypeIsBlank", "NetworkType is blank !"),
    EndpointLengthExceed(409, "EndpointLengthExceed", "Endpoint length cannot exceed 127 !"),

    ClientIDLengthExceed(409, "ClientIDLengthExceed", "ClientID length cannot exceed 127 !"),

    ClientSecretLengthExceed(409, "ClientSecretLengthExceed", "ClientSecret length cannot exceed 127 !"),
    AuthorizationEndpointLengthExceed(409, "AuthorizationEndpointLengthExceed", "Authorization endpoint length cannot exceed 127 !");

    private final int httpCode;
    private final String code;
    private final String msg;

    EventBridgeErrorCode(int httpCode, String code, String s) {
        this.httpCode = httpCode;
        this.code = code;
        this.msg = s;
    }

    @Override
    public int getHttpCode() {
        return httpCode;
    }

    @Override
    public String getCode() {
        return code;
    }

    @Override
    public String getMsg() {
        return msg;
    }
}
