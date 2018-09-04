package com.github.baifenghe.provider.controller;

import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * 测试控制类
 *
 * @author bfh
 * @since 1.0.0
 */
@RestController
public class HelloController {


    @PostMapping("/hello")
    public String hello(String userName) {

        return "provider say : hello, " + userName;
    }
}
