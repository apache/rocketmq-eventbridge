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

package org.apache.rocketmq.eventbridge.adapter.runtimer.config;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.core.io.support.PropertiesLoaderUtils;

import java.io.IOException;
import java.util.Properties;

/**
 * runtimer properties factory
 */
public class RuntimerConfigProps {

    private final static Logger logger = LoggerFactory.getLogger(RuntimerConfigProps.class);

    private Properties properties;

    private RuntimerConfigProps(){
        try {
             properties = PropertiesLoaderUtils.loadAllProperties("runtimer.properties");
        } catch (IOException exception) {
            logger.error("runtime load properties failed, stackTrace-", exception);
        }
    }

    private static class  RuntimerConfigPropsHolder{
        private static final RuntimerConfigProps instance = new RuntimerConfigProps();
    }

    public static RuntimerConfigProps build(){
        return RuntimerConfigPropsHolder.instance;
    }


}
