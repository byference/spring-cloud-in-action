package com.github.baifenghe.provider.controller;

import com.github.baifenghe.common.anno.ParamsCheck;
import com.github.baifenghe.common.constant.CommonConst;
import com.github.baifenghe.common.util.R;
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
    @ParamsCheck(params = "userName,password")
    public String hello(String userName, String password) {

        String s =  "hello, " + userName + ", this is provider 9001";
        return R.SUCCESS(CommonConst.SUCCESS, s, null);

    }


}
