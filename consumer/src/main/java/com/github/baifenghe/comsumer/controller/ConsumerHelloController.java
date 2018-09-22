package com.github.baifenghe.comsumer.controller;

import com.github.baifenghe.comsumer.feign.HelloControllerRemote;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiParam;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author bfh
 * @since 1.0.0
 */
@Api(tags = "消费者测试控制类")
@RestController
public class ConsumerHelloController {

    @Autowired
    private HelloControllerRemote helloControllerRemote;


    @ApiOperation("hello接口")
    @PostMapping("/hello")
    public String hello(@ApiParam("用户名") String userName) {

        return helloControllerRemote.hello(userName);
    }
}
