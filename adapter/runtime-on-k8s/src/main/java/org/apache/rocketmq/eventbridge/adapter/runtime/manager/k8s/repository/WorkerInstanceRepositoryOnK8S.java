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

package org.apache.rocketmq.eventbridge.adapter.runtime.manager.k8s.repository;

import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Objects;

import com.google.common.collect.ImmutableList;
import com.google.common.collect.ImmutableMap;
import io.fabric8.kubernetes.api.model.ConfigMap;
import io.fabric8.kubernetes.api.model.ConfigMapBuilder;
import io.fabric8.kubernetes.api.model.ConfigMapVolumeSource;
import io.fabric8.kubernetes.api.model.ConfigMapVolumeSourceBuilder;
import io.fabric8.kubernetes.api.model.Container;
import io.fabric8.kubernetes.api.model.ContainerBuilder;
import io.fabric8.kubernetes.api.model.ContainerPort;
import io.fabric8.kubernetes.api.model.ContainerPortBuilder;
import io.fabric8.kubernetes.api.model.EnvVar;
import io.fabric8.kubernetes.api.model.EnvVarBuilder;
import io.fabric8.kubernetes.api.model.HostPathVolumeSource;
import io.fabric8.kubernetes.api.model.HostPathVolumeSourceBuilder;
import io.fabric8.kubernetes.api.model.LabelSelector;
import io.fabric8.kubernetes.api.model.ObjectMeta;
import io.fabric8.kubernetes.api.model.ObjectMetaBuilder;
import io.fabric8.kubernetes.api.model.PodSpec;
import io.fabric8.kubernetes.api.model.PodSpecBuilder;
import io.fabric8.kubernetes.api.model.PodTemplateSpec;
import io.fabric8.kubernetes.api.model.PodTemplateSpecBuilder;
import io.fabric8.kubernetes.api.model.Probe;
import io.fabric8.kubernetes.api.model.Quantity;
import io.fabric8.kubernetes.api.model.QuantityBuilder;
import io.fabric8.kubernetes.api.model.ResourceRequirements;
import io.fabric8.kubernetes.api.model.ResourceRequirementsBuilder;
import io.fabric8.kubernetes.api.model.Volume;
import io.fabric8.kubernetes.api.model.VolumeBuilder;
import io.fabric8.kubernetes.api.model.VolumeMount;
import io.fabric8.kubernetes.api.model.VolumeMountBuilder;
import io.fabric8.kubernetes.api.model.apps.Deployment;
import io.fabric8.kubernetes.api.model.apps.DeploymentBuilder;
import lombok.extern.slf4j.Slf4j;
import org.apache.rocketmq.eventbridge.adapter.runtime.manager.k8s.api.K8SDeploymentService;
import org.apache.rocketmq.eventbridge.adapter.runtime.manager.k8s.api.K8SNameSpaceService;
import org.apache.rocketmq.eventbridge.adapter.runtime.manager.k8s.config.DeploySpecTemplateSpec;
import org.apache.rocketmq.eventbridge.adapter.runtime.manager.repository.WorkerInstanceRepository;
import org.apache.rocketmq.eventbridge.adapter.runtime.manager.worker.WorkerResource;
import org.apache.rocketmq.eventbridge.adapter.runtime.manager.worker.WorkerStatusEnum;
import org.apache.rocketmq.eventbridge.tools.JsonUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;

import static org.apache.rocketmq.eventbridge.adapter.runtime.manager.k8s.common.K8SConstants.DEPLOYMENT_KIND;

@Slf4j
@Service
public class WorkerInstanceRepositoryOnK8S implements WorkerInstanceRepository {

    @Autowired
    private K8SDeploymentService k8SDeploymentService;

    @Value("${kubernates.api.deployment.version:apps/v1}")
    private String deploymentApiVersion;

    @Value("${pod.limit.over.request.cpu.factor:1.5}")
    private Double limitOverRequestCpuFactor;

    @Value("${pod.limit.over.request.memory.factor:1.5}")
    private Double limitOverRequestMemoryFactor;

    @Autowired
    private DeploySpecTemplateSpec deploySpecTemplateSpec;

    @Autowired
    private K8SNameSpaceService k8SNameSpaceService;

    @Override
    public boolean applyWorkerInstance(String name, String image, WorkerResource resources, Map<String, Object> environments) {

        PodSpec podSpec = getPodSpec(name,
                image,
                resources,
                environments);

        Map<String, String> specLabes = getSpecLabels(environments.get("specLabels"), name);
        ObjectMeta templateMeta = new ObjectMetaBuilder()
                .withLabels(specLabes)
                .build();

        PodTemplateSpec podTemplateSpec = new PodTemplateSpecBuilder()
                .withMetadata(templateMeta)
                .withSpec(podSpec)
                .build();

        LabelSelector labelSelector = new LabelSelector();
        labelSelector.setMatchLabels(specLabes);

        Deployment deployment = new DeploymentBuilder()
                .withApiVersion(deploymentApiVersion)
                .withKind(DEPLOYMENT_KIND)
                .withNewMetadata()
                    .withName(name)
                    .withNamespace(k8SNameSpaceService.getNameSpace())
                    .withLabels(getMetaLabels(environments.get("metaLabels")))
                .endMetadata()
                .withNewSpec()
                    .withReplicas(getReplicas(environments.get("replicas")))
                    .withSelector(labelSelector)
                    .withTemplate(podTemplateSpec)
                .endSpec()
                .build();

        return k8SDeploymentService.createDeployment((String) environments.get("clientId"), deployment);
    }

    @Override
    public boolean deleteWorkerInstance(String name, Map<String, Object> environments) {
        return k8SDeploymentService.deleteDeployment((String) environments.get("clientId"), name);
    }

    @Override
    public WorkerStatusEnum getWorkerInstanceStatus(String name, Map<String, Object> environments) {
        WorkerStatusEnum workerStatusEnum = k8SDeploymentService.getDeploymentStatus((String) environments.get("clientId"), name);
        return WorkerStatusEnum.valueOf(workerStatusEnum.getValue());
    }

    @Override
    public boolean applyWorkerInstanceConfigFile(String name, String filePath, String config, Map<String, Object> environments) {
        ConfigMap configMap =  new ConfigMapBuilder()
                .withNewMetadata()
                .withNamespace(k8SNameSpaceService.getNameSpace())
                .withName(name)
                .endMetadata()
                .addToData(filePath, config)
                .build();
        return k8SDeploymentService.createConfigMap((String) environments.get("clientId"), configMap);
    }

    @Override
    public String getWorkerInstanceConfigFile(String name, String filePath, Map<String, Object> environments) {
        return k8SDeploymentService.getConfigMap((String) environments.get("clientId"), name, filePath);
    }

    private Integer getReplicas(Object replicas) {
        if (Objects.isNull(replicas)) {
            replicas = 1;
        }
        return (Integer) replicas;
    }

    private PodSpec getPodSpec(String name,String image, WorkerResource resources, Map<String, Object> environments) {
        assert resources.getCpu() != null;
        assert resources.getMemory() != null;
        long cpuCoreLimit = getCpuLimit(resources.getCpu());
        long memoryLimit = getMemoryLimt(resources.getMemory());

        Map<String, Quantity> requests = getResource(resources.getCpu(), resources.getMemory());
        Map<String, Quantity> limits = getResource(cpuCoreLimit, memoryLimit);
        ResourceRequirements resourceRequirements = new ResourceRequirementsBuilder()
                .withRequests(requests)
                .withLimits(limits)
                .build();


        Container container = new ContainerBuilder()
                .withName(name)
                .withImagePullPolicy(getImagePullPolicy(environments.get("imagePullPolicy")))
                .withImage(image)
                .withArgs(getArgs(environments.get("args")))
                .withResources(resourceRequirements)
                .withEnv(getEnvs(environments.get("env")))
                .withLivenessProbe(getLivenessProbe(environments.get("lProbe")))
                .withReadinessProbe(getReadinessProbe(environments.get("rProbe")))
                .withStartupProbe(getStartupProbe(environments.get("sProbe")))
                .withTerminationMessagePolicy(getTerminationMessagePolicy(environments.get("tMesPolicy")))
                .withTerminationMessagePath(getTerminationMessagePath(environments.get("tMesPath")))
                .withVolumeMounts(getVolumeMounts(environments.get("volumeMounts")))
                .withPorts(getContainerPorts(environments.get("ports")))
                .build();

        return new PodSpecBuilder()
                .withTerminationGracePeriodSeconds(getTerminationGracePeriodSeconds(environments.get("tPeriodSec")))
                .withContainers(container)
                .withVolumes(getPodVolumes(environments.get("volums")))
                .withNodeSelector(getPodLabels(environments.get("podLabels")))
                .build();
    }

    private String getImagePullPolicy(Object imagePullPolicy) {
        if (Objects.isNull(imagePullPolicy)) {
            return deploySpecTemplateSpec.getContainers().getImagePullPolicy();
        }
        return (String) imagePullPolicy;
    }

    @SuppressWarnings("unchecked")
    private List<String> getArgs(Object args){
        if (Objects.isNull(args) && Objects.nonNull(deploySpecTemplateSpec.getContainers().getArgs())) {
            args = deploySpecTemplateSpec.getContainers().getArgs();
        } else {
            args = Collections.emptyList();
        }
        return (List<String>) args;
    }

    @SuppressWarnings("unchecked")
    private List<EnvVar> getEnvs(Object env) {
        List<EnvVar> envVarList = new ArrayList<>();
        if(Objects.isNull(env) && Objects.nonNull(deploySpecTemplateSpec.getContainers().getEnv())){
            env = deploySpecTemplateSpec.getContainers().getEnv();
        }
        if (Objects.nonNull(env)) {
            List<Map<String, String>> envs = (List<Map<String, String>>) env;
            for(Map<String, String> envMap : envs) {
                EnvVar envVar = new EnvVarBuilder()
                        .withName(envMap.get("name"))
                        .withValue(envMap.get("value"))
                        .build();
                envVarList.add(envVar);
            }
        }
        return envVarList;
    }

    private Probe getLivenessProbe(Object lProbe) {
        if (Objects.nonNull(lProbe)) {
            return JsonUtil.parse((String) lProbe, Probe.class);
        }
        return null;
    }

    private Probe getReadinessProbe(Object rProbe) {
        if (Objects.nonNull(rProbe)) {
            return JsonUtil.parse((String) rProbe, Probe.class);
        }
        return null;
    }

    private Probe getStartupProbe(Object sProbe) {
        if (Objects.nonNull(sProbe)) {
            return JsonUtil.parse((String) sProbe, Probe.class);
        }
        return null;
    }

    private String getTerminationMessagePolicy(Object tMesPolicy) {
        return (String) tMesPolicy;
    }

    private String getTerminationMessagePath(Object tMesPath) {
        return (String) tMesPath;
    }

    @SuppressWarnings("unchecked")
    private List<ContainerPort> getContainerPorts(Object port) {
        List<ContainerPort> containerPorts = new ArrayList<>();
        if(port == null) {
            port = ImmutableList.of(ImmutableMap.of("name","http1", "containerPort","7001"), ImmutableMap.of("name","http2", "containerPort","7002"));
        }
        List<Map<String, String>> ports = (List<Map<String, String>>) port;
        for(Map<String, String> configPort : ports){
            ContainerPort containerPort = new ContainerPortBuilder()
                    .withName(configPort.get("name"))
                    .withContainerPort(Integer.parseInt(configPort.get("containerPort")))
                    .build();
            containerPorts.add(containerPort);
        }
        return containerPorts;
    }

    @SuppressWarnings("unchecked")
    private List<VolumeMount> getVolumeMounts(Object volumeMount){
        List<VolumeMount> volumeMountList = new ArrayList<>();
        if(volumeMount == null){
            return volumeMountList;
        }
        List<Map<String, String>> volumeMounts = (List<Map<String, String>>) volumeMount;
        for(Map<String, String> volume : volumeMounts){
            VolumeMount mount = new VolumeMountBuilder()
                    .withName(volume.get("name"))
                    .withMountPath(volume.get("mountPath"))
                    .build();
            volumeMountList.add(mount);
        }
        return volumeMountList;
    }

    private Long getTerminationGracePeriodSeconds(Object tPeriodSec) {
        if (Objects.isNull(tPeriodSec) && Objects.nonNull(deploySpecTemplateSpec.getTerminationGracePeriodSeconds())) {
            tPeriodSec = deploySpecTemplateSpec.getTerminationGracePeriodSeconds();
        }
        return (Long) tPeriodSec;
    }

    @SuppressWarnings("unchecked")
    private List<Volume> getPodVolumes(Object volums) {
        if (Objects.isNull(volums) && Objects.nonNull(deploySpecTemplateSpec.getVolumes())) {
            volums = deploySpecTemplateSpec.getVolumes();
        }
        List<Volume> volumeList = new ArrayList<>();
        if (Objects.nonNull(volums)) {
            List<Map<String, Object>> vList = (List<Map<String, Object>>) volums;
            for(Map<String, Object> volume : vList) {
                Volume confVolume =  new VolumeBuilder().build();
                for(Map.Entry<String, Object> yamlConf : volume.entrySet()) {
                    String key = yamlConf.getKey();
                    if("name".equals(key)) {
                        confVolume.setName(String.valueOf(yamlConf.getValue()));
                    } else if("configMap".equals(key)) {
                        Map<String, String> configMap = (Map<String, String>) yamlConf.getValue();
                        String name = configMap.get("name");
                        ConfigMapVolumeSource configMapVolume = new ConfigMapVolumeSourceBuilder()
                                .withName(name)
                                .build();
                        confVolume.setConfigMap(configMapVolume);
                    } else if("hostPath".equals(key)) {
                        Map<String, String> configMap = (Map<String, String>) yamlConf.getValue();
                        String path = configMap.get("path");
                        HostPathVolumeSource hostPathVolumeSource = new HostPathVolumeSourceBuilder()
                                .withPath(path)
                                .build();

                        confVolume.setHostPath(hostPathVolumeSource);
                    } else {
                        log.error("not implements this pod volumes type : {}", key);
                    }
                }
                volumeList.add(confVolume);
            }
        }
        return volumeList;
    }

    @SuppressWarnings("unchecked")
    private Map<String, String> getPodLabels(Object nodeSeletor) {
        if (Objects.isNull(nodeSeletor) && Objects.nonNull(deploySpecTemplateSpec.getNodeSelector())) {
            nodeSeletor = deploySpecTemplateSpec.getNodeSelector();
        }
        return (Map<String, String>) nodeSeletor;
    }

    @SuppressWarnings("unchecked")
    private Map<String, String> getMetaLabels(Object nodeSeletor) {
        if (Objects.isNull(nodeSeletor) && Objects.nonNull(deploySpecTemplateSpec.getNodeSelector())) {
            nodeSeletor = deploySpecTemplateSpec.getNodeSelector();
        }
        return (Map<String, String>) nodeSeletor;
    }

    @SuppressWarnings("unchecked")
    private Map<String, String> getSpecLabels(Object nodeSeletor, String name) {
        if (Objects.isNull(nodeSeletor) && Objects.nonNull(deploySpecTemplateSpec.getNodeSelector())) {
            nodeSeletor = deploySpecTemplateSpec.getNodeSelector();
        }
        Map<String, String> labels = (Map<String, String>) nodeSeletor;
        if (labels == null || labels.isEmpty()) {
            return ImmutableMap.of("app", name);
        }
        return (Map<String, String>) nodeSeletor;
    }

    protected Map<String, Quantity> getResource(Long cpuCore, Long memory){
        Map<String, Quantity> resource = new HashMap<>();
        resource.put("cpu", new QuantityBuilder().withAmount(String.valueOf(cpuCore)).withFormat("m").build());
        resource.put("memory", new QuantityBuilder().withAmount(String.valueOf(memory)).withFormat("Mi").build());
        return resource;
    }


    private Long getCpuLimit(Long requestCore){
        return Math.round(requestCore * limitOverRequestCpuFactor);
    }

    private Long getMemoryLimt(Long requestMemory){
        return Math.round(requestMemory * limitOverRequestMemoryFactor);
    }
}