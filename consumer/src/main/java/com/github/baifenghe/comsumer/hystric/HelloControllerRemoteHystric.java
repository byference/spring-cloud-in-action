package com.github.baifenghe.comsumer.hystric;

import com.github.baifenghe.comsumer.feign.HelloControllerRemote;
import com.github.baifenghe.toolkit.common.util.ResponseHelper;
import org.springframework.http.ResponseEntity;
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
