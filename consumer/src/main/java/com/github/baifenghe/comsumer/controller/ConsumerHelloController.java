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


    @ApiOperation("echo接口")
    @PostMapping("/echo")
    public String echo(@ApiParam("信息") String message) {

        return helloControllerRemote.echo(message);
    }


}
