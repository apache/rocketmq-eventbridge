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

package org.apache.rocketmq.eventbridge.adapter.runtime.manager.k8s.config;

import lombok.Getter;
import lombok.Setter;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.boot.context.properties.EnableConfigurationProperties;
import org.springframework.context.annotation.Configuration;

import java.util.List;
import java.util.Map;


@Getter
@Setter
@ConfigurationProperties(prefix="deploy.spec.template.spec.containers")
@EnableConfigurationProperties
@Configuration
public class SpecContainer implements Cloneable{
  private String imagePullPolicy = "IfNotPresent";
  private String registry;
  private List<String> args;
  private List<Map<String, String>> volumeMounts;
  private List<Map<String, String>> env;
  private List<Map<String, String>> ports;

  public Object clone() {
    SpecContainer specContainer = new SpecContainer();
    specContainer.setImagePullPolicy(this.imagePullPolicy);
    specContainer.setRegistry(this.registry);
    specContainer.setArgs(this.args);
    specContainer.setVolumeMounts(this.volumeMounts);
    specContainer.setEnv(this.env);
    specContainer.setPorts(this.ports);
    return specContainer;
  }

}
