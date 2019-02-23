package com.github.baifenghe.consumer.hystric;

import com.github.baifenghe.consumer.feign.HelloControllerRemote;
import org.springframework.stereotype.Component;

/**
 * @author bfh
 * @since 1.0.0
 */
@Component
public class HelloControllerRemoteHystric implements HelloControllerRemote {


    @Override
    public String echo(String message) {
        return "call helloControllerRemote failed!";
    }

}
