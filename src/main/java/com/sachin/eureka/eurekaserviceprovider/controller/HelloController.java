package com.sachin.eureka.eurekaserviceprovider.controller;

import com.sachin.EurekaServiceProviderApplication;
import com.sachin.entity.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cloud.client.ServiceInstance;
import org.springframework.cloud.client.discovery.DiscoveryClient;
import org.springframework.core.env.Environment;
import org.springframework.web.bind.annotation.*;

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
        int i = random.nextInt(3000);
        try {
            Thread.sleep(i);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        return "hello world- applicationName:" + env.getProperty("spring.application.name") + " applicationPort:" + EurekaServiceProviderApplication.serverPort + "--- sleepTime:" + i;

    }


    @RequestMapping(value = "/hello1", method = RequestMethod.GET)
    public String hello(@RequestParam String name) {
        return " Hello,name:" + name;

    }

    @RequestMapping(value = "/hello2", method = RequestMethod.GET)
    public User hello(@RequestHeader String name, @RequestHeader Integer age) {

        return new User(name, age);

    }

    @RequestMapping(value = "/hello3", method = RequestMethod.POST)
    public String hello(@RequestBody User user) {
        return user.getName() + ":" + user.getAge();
    }


}
