package com.github.baifenghe.common.handle;

import com.github.baifenghe.common.exception.BusinessException;
import com.github.baifenghe.common.constant.enums.BusinessEnum;
import com.github.baifenghe.common.util.R;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

/**
 * 全局异常处理
 *
 * @author bfh
 * @since 1.0.0
 */
@RestControllerAdvice
public class GlobalExceptionHandler {

    @ExceptionHandler(Exception.class)
    public String defaultExceptionHandler(Exception e) {

        e.printStackTrace();
        if (e instanceof BusinessException) {
            BusinessException businessException = (BusinessException) e;
            return R.FAILED(businessException.getCode(), businessException.getMessage(), null);
        }
        return R.FAILED(BusinessEnum.ERROR.getCode(), "系统异常：" + e, null);

    }

}
