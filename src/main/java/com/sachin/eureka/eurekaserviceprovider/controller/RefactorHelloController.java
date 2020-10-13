package com.sachin.eureka.eurekaserviceprovider.controller;

import com.sachin.entity.User;
import com.sachin.springcloud.service.HelloService;
import org.springframework.web.bind.annotation.RestController;

/**
 * @Author Sachin
 * @Date 2020/10/13
 **/

@RestController
public class RefactorHelloController implements HelloService {

    /**
     * 采用继承HelloService的方式， 方法不需要使用@RequestMapping标注请求url，也不需要使用@RequestParam 标注方法入参
     *
     * @param name
     * @return
     */
    @Override
    public String hello(String name) {
        return "Hello" + name;
    }

    @Override
    public User hello(String name, Integer age) {
        return new User(name, age);
    }

    @Override
    public String hello(User user) {
        return user.getName() + user.getAge();
    }
}
