package com.github.baifenghe.comsumer.controller;

import com.github.baifenghe.comsumer.feign.HelloControllerRemote;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author bfh
 * @since 1.0.0
 */
@RestController
public class ConsumerHelloController {

    @Autowired
    private HelloControllerRemote helloControllerRemote;


    @PostMapping("/hello")
    public String hello(String userName) {

        return helloControllerRemote.hello(userName);
    }
}
