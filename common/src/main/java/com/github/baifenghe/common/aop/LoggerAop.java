package com.github.baifenghe.common.aop;

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
public class LoggerAop {

    private Logger log = LoggerFactory.getLogger(this.getClass());

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

        log.info("==> targetName: {}", joinPoint.getTarget().getClass().getName());
        log.info("==> methodName: {}", joinPoint.getSignature().getName());

        StringBuilder results = new StringBuilder();
        for (Object param : joinPoint.getArgs()) {
            if (!StringUtils.isEmpty(param)) {
                results.append(param).append(",");
            }
        }
        int length = results.length();
        if (length > 0) {
            String result = results.substring(0, length - 1);
            log.info("<== params: {}", result);
        }

    }
}