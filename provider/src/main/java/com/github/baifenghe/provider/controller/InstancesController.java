package com.github.baifenghe.provider.controller;

import com.alibaba.fastjson.JSON;
import com.netflix.appinfo.InstanceInfo;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cloud.client.ServiceInstance;
import org.springframework.cloud.client.discovery.DiscoveryClient;
import org.springframework.cloud.netflix.eureka.EurekaDiscoveryClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;
import java.util.stream.Collectors;

/**
 * Eureka Instances Demo
 *
 * @author byference
 * @since 2019/03/09
 */
@RestController
@Slf4j
public class InstancesController {


    @Autowired
    protected DiscoveryClient discoveryClient;


    /**
     * 根据serviceId 获取 {@link InstanceInfo} 列表
     *
     * @param serviceId applicationName
     * @return {@code List} of @{@link InstanceInfo}
     */
    @GetMapping("/{serviceId}/instances")
    public List<InstanceInfo> getServiceInstance(@PathVariable String serviceId) {


        List<ServiceInstance> instances = discoveryClient.getInstances(serviceId);
        List<InstanceInfo> infos = instances.stream()
                .map(instance -> ((EurekaDiscoveryClient.EurekaServiceInstance) instance).getInstanceInfo())
                .collect(Collectors.toList());

        log.info("infos: {}", JSON.toJSONString(infos));
        return infos;
    }

}
