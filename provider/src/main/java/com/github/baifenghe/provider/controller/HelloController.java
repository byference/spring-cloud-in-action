package com.github.baifenghe.provider.controller;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;


/**
 * 测试控制类
 *
 * @author bfh
 * @since 1.0.0
 */
@Api(tags = "provider测试控制类")
@RestController
public class HelloController {

    @ApiOperation("provider测试:GET echo")
    @GetMapping("/echo")
    public String echo() {

        return "echo";
    }

    @ApiOperation("provider测试: Post echo")
    @PostMapping("/echo")
    public String echo(String message) {

        return "hello " + message + ", this is provider 9001";
    }

    @PostMapping("/test")
    public String test(String message) {

        return "hello " + message + ", this is provider 9001";
    }

}
