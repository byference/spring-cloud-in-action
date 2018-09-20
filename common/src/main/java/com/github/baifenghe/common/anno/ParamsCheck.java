package com.github.baifenghe.common.anno;

import java.lang.annotation.*;

/**
 * 参数校验注解
 *
 * @author bfh
 * @since 1.0.0
 */
@Target({ElementType.PARAMETER, ElementType.METHOD})
@Retention(RetentionPolicy.RUNTIME)
@Documented
public @interface ParamsCheck {
    String params() default "";
}
