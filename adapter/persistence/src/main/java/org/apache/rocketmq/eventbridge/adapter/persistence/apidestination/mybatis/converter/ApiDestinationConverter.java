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

package org.apache.rocketmq.eventbridge.adapter.persistence.apidestination.mybatis.converter;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONObject;
import org.apache.rocketmq.eventbridge.adapter.persistence.apidestination.mybatis.dataobject.ApiDestinationDO;
import org.apache.rocketmq.eventbridge.domain.model.apidestination.ApiDestinationDTO;
import org.apache.rocketmq.eventbridge.domain.model.apidestination.parameter.HttpApiParameters;
import org.springframework.beans.BeanUtils;

import java.util.List;
import java.util.stream.Collectors;

public class ApiDestinationConverter {

    public static ApiDestinationDO dtoConverterDo(ApiDestinationDTO apiDestinationDTO) {
        if (apiDestinationDTO == null) {
            return null;
        }
        ApiDestinationDO apiDestinationDO = new ApiDestinationDO();
        BeanUtils.copyProperties(apiDestinationDTO, apiDestinationDO);
        apiDestinationDO.setApiParams(JSON.toJSONString(apiDestinationDTO.getApiParams()));
        return apiDestinationDO;
    }

    public static ApiDestinationDTO doConverterDto(ApiDestinationDO apiDestinationDO) {
        if (apiDestinationDO == null) {
            return null;
        }
        ApiDestinationDTO apiDestinationDTO = new ApiDestinationDTO();
        BeanUtils.copyProperties(apiDestinationDO, apiDestinationDTO);
        apiDestinationDTO.setApiParams(JSONObject.parseObject(apiDestinationDO.getApiParams(), HttpApiParameters.class));
        return apiDestinationDTO;
    }

    public static List<ApiDestinationDTO> doListConverterDtoList(List<ApiDestinationDO> apiDestinationDOS) {
        return apiDestinationDOS.stream().map(ApiDestinationConverter::doConverterDto).collect(Collectors.toList());
    }

}
