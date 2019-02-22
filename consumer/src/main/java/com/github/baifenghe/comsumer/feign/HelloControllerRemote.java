package com.github.baifenghe.comsumer.feign;

import com.github.baifenghe.comsumer.hystric.HelloControllerRemoteHystric;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

/**
 * @author bfh
 * @since 1.0.0
 */
@FeignClient(name = "provider", fallback = HelloControllerRemoteHystric.class)
public interface HelloControllerRemote {


    @PostMapping("/echo")
    String echo(@RequestParam("message") String message);


}
