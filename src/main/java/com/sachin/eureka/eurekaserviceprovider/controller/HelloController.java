package com.sachin.eureka.eurekaserviceprovider.controller;

import com.sachin.eureka.eurekaserviceprovider.EurekaServiceProviderApplication;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cloud.client.ServiceInstance;
import org.springframework.cloud.client.discovery.DiscoveryClient;
import org.springframework.core.env.Environment;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;
import java.util.Random;

/**
 * @Author Sachin
 * @Date 2020/9/20
 **/
@RestController
public class HelloController {

    @Autowired
    private DiscoveryClient discoveryClient;
    @Autowired
    private Environment env;


    @RequestMapping(value = "/hello", method = RequestMethod.GET)
    public String hello() {

        List<String> services = discoveryClient.getServices();
        for (String serviceId : services) {
            List<ServiceInstance> instances = discoveryClient.getInstances(serviceId);
            for (ServiceInstance serviceInstance : instances) {
                System.out.println(serviceInstance);

            }


        }

        Random random = new Random();
        int i = random.nextInt(2000);
        try {
            Thread.sleep(i);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        return "hello world- applicationName:" + env.getProperty("spring.application.name") + " applicationPort:" + EurekaServiceProviderApplication.serverPort + "--- sleepTime:" + i;

    }
}
