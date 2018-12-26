package com.github.baifenghe.comsumer.feign;

import com.github.baifenghe.comsumer.hystric.HelloControllerRemoteHystric;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

/**
 * @author bfh
 * @since 1.0.0
 */
@FeignClient(name = "provider", fallback = HelloControllerRemoteHystric.class)
public interface HelloControllerRemote {

    @PostMapping("/hello")
    String hello(@RequestParam("userName") String userName);

}
