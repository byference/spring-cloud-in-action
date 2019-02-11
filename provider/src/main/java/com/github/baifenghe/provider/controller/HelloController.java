package com.github.baifenghe.provider.controller;

import com.github.baifenghe.common.anno.ParamsCheck;
import com.github.baifenghe.common.util.R;
import com.github.baifenghe.provider.common.Result;
import com.github.baifenghe.provider.entity.User;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.validation.annotation.Validated;
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


    @GetMapping("/test11")
    public Result test11() {

        return new Result<>(1, null, null);
    }

    /**
     * 测试Validated注解
     */
    @ApiOperation("provider测试:test")
    @PostMapping("/test")
    @ParamsCheck(params = "userName")
    public String test(User user) {

        String msg =  "hello, " + user.getUserName() + ", this is provider 9001";
        return R.SUCCESS(msg, "data");

    }

    /**
     * 测试Validated注解
     */
    @ApiOperation("provider测试:hello")
    @PostMapping("/hello")
    public String hello(@Validated User user) {

        String msg =  "hello, " + user.getUserName() + ", this is provider 9001";
        return R.SUCCESS(msg, "data");

    }

    /**
     * 测试 AddRequestParameter
     */
    @GetMapping("/foo")
    public String foo(String foo) {
        return "hello " + foo + " !";
    }


}
