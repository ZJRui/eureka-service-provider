package com.sachin.eureka.eurekaserviceprovider;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;

@EnableDiscoveryClient
@SpringBootApplication
public class EurekaServiceProviderApplication {

    public static void main(String[] args) {
        SpringApplication.run(EurekaServiceProviderApplication.class, args);
    }

}
