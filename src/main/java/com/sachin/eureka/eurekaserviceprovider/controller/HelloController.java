package com.sachin.eureka.eurekaserviceprovider.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cloud.client.ServiceInstance;
import org.springframework.cloud.client.discovery.DiscoveryClient;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

/**
 * @Author Sachin
 * @Date 2020/9/20
 **/
@RestController
public class HelloController {

    @Autowired
    private DiscoveryClient discoveryClient;


    @RequestMapping(value = "/hello", method = RequestMethod.GET)
    public String hello() {

        List<String> services = discoveryClient.getServices();
        for (String serviceId : services) {
            List<ServiceInstance> instances = discoveryClient.getInstances(serviceId);
            for (ServiceInstance serviceInstance : instances) {
                System.out.println(serviceInstance);

            }


        }
        return "hello world";

    }
}
