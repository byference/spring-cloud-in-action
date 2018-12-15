package com.github.baifenghe.common.aop;

import com.alibaba.fastjson.JSON;
import lombok.extern.slf4j.Slf4j;
import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.After;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Pointcut;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;
import org.springframework.util.StringUtils;

/**
 * 日志打印切面
 *
 * @author bfh
 * @since 1.0.0
 */
@Aspect
@Component
@Slf4j
public class LoggerAop {


    /**
     * 切点选择为所有模块的controller层
     */
    @Pointcut("execution(* com.github.baifenghe.*.controller.*.*(..))")
    public void methodLog(){}

    /**
     * 采用后置通知
     */
    @After("methodLog()")
    public void doAfterReturning(JoinPoint joinPoint){

        log.info("==> LoggerAop: {}#{}",
                joinPoint.getTarget().getClass().getName(),
                joinPoint.getSignature().getName());
        log.info("<== params: {}", JSON.toJSON(joinPoint.getArgs()));

    }
}