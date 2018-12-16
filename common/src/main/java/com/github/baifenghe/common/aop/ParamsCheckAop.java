package com.github.baifenghe.common.aop;

import com.github.baifenghe.common.anno.ParamsCheck;
import com.github.baifenghe.common.constant.enums.BusinessEnum;
import com.github.baifenghe.common.exception.BusinessException;
import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.aspectj.lang.annotation.Pointcut;
import org.aspectj.lang.reflect.MethodSignature;
import org.springframework.stereotype.Component;
import org.springframework.util.StringUtils;
import org.springframework.web.context.request.RequestAttributes;
import org.springframework.web.context.request.RequestContextHolder;
import org.springframework.web.context.request.ServletRequestAttributes;

import javax.servlet.http.HttpServletRequest;
import java.lang.reflect.Method;

/**
 * 参数校验切面
 * 可以使用拦截器来做，目前还不支持json格式的参数校验
 *
 * @author bfh
 * @since 1.0.0
 */
@Aspect
@Component
public class ParamsCheckAop {

    @Pointcut("@annotation(com.github.baifenghe.common.anno.ParamsCheck)")
    public void MyMethod(){}


    @Before("MyMethod()")
    public void doAfterReturning(JoinPoint joinPoint) {

        RequestAttributes ra = RequestContextHolder.getRequestAttributes();
        ServletRequestAttributes sra = (ServletRequestAttributes) ra;
        HttpServletRequest request = sra.getRequest();

        MethodSignature methodSignature = (MethodSignature) joinPoint.getSignature();
        Method method = methodSignature.getMethod();
        ParamsCheck paramsCheck = method.getAnnotation(ParamsCheck.class);
        String params = paramsCheck.params();
        if (!StringUtils.isEmpty(params)) {
            String[] split = params.split(",");
            for (String parameter : split) {
                if (StringUtils.isEmpty(request.getParameter(parameter))) {
                    throw new BusinessException(parameter + " 不能为空", BusinessEnum.PARAMS_CHECK_ERROR.getCode());
                }
                // TODO: 支持json
            }
        }

    }


}
