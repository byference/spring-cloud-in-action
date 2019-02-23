package com.github.baifenghe.consumer.controller;

import com.github.baifenghe.consumer.feign.HelloControllerRemote;
import com.github.baifenghe.toolkit.common.util.ResponseHelper;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiParam;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
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
    public ResponseEntity echo(@ApiParam("信息") String message) {

        String echo = helloControllerRemote.echo(message);
        return ResponseHelper.ok().body(echo);
    }


}
