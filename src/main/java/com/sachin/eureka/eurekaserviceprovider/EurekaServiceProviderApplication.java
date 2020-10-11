package com.sachin.eureka.eurekaserviceprovider;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;

@EnableDiscoveryClient
@SpringBootApplication
public class EurekaServiceProviderApplication {
    public static String serverPort = "";

    public static void main(String[] args) {

        for (int i = 0; i < args.length; i++) {
            serverPort=args[0];
            System.out.println("=================================args==>" + "index:" + i + "  value:" + args[i]);
        }


        SpringApplication.run(EurekaServiceProviderApplication.class, args);
    }

}
