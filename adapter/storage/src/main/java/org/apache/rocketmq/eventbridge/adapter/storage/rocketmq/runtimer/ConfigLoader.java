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
 *  Unless required by applicable law or agreed to in writing, software
 *  distributed under the License is distributed on an "AS IS" BASIS,
 *  WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 *  See the License for the specific language governing permissions and
 *  limitations under the License.
 */

package org.apache.rocketmq.eventbridge.adapter.storage.rocketmq.runtimer;

import lombok.extern.slf4j.Slf4j;
import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.io.support.PropertiesLoaderUtils;
import org.springframework.stereotype.Component;

import java.io.IOException;
import java.util.Properties;

/**
 * support loading from runtime.properties and spring properties
 */
@Component
@Slf4j
public class ConfigLoader {

    @Autowired
    private PropertiesResolveService propertiesResolveService;

    private Properties properties;

    public ConfigLoader() {
        try {
            this.properties = PropertiesLoaderUtils.loadAllProperties("runtime.properties");
        } catch (IOException e) {
            log.warn("init runtime properties failed ", e);
        }
    }

    public String getString(String name, String defaultValue){
        String result = getValue(name);
        if (StringUtils.isBlank(result)) {
            result = defaultValue;
        }
        log.debug("Load property '" + name + "' = " + result);
        return result;
    }

    public String getString(String name){
        String result = getValue(name);
        log.debug("Load property '" + name + "' = " + result);
        return result;
    }

    private String getValue(String name){
        if (StringUtils.isBlank(name)) {
            return null;
        }
        String value = null;
        try {
            if (propertiesResolveService != null) {
                value = propertiesResolveService.getPropertiesValue(name);
            }
        } catch (IllegalArgumentException e) {
            log.warn("Failed load property '" + name + "' from spring.");
        }
        if (properties != null && StringUtils.isBlank((value))) {
            value = properties.getProperty(name);
        }
        return value;
    }
}
