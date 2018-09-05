package com.github.baifenghe.comsumer.hystric;

import com.github.baifenghe.comsumer.feign.HelloControllerRemote;
import org.springframework.stereotype.Component;

/**
 * @author bfh
 * @since 1.0.0
 */
@Component
public class HelloControllerRemoteHystric implements HelloControllerRemote {

    @Override
    public String hello(String userName) {
        return "call helloControllerRemote failed!";
    }

}
