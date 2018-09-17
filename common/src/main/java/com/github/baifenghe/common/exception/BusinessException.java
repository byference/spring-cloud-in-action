package com.github.baifenghe.common.exception;

import com.github.baifenghe.common.constant.enums.BusinessEnum;

/**
 * 业务异常类
 *
 * @author bfh
 * @since 1.0.0
 */
public class BusinessException extends RuntimeException {

    private static final long serialVersionUID = 1L;

    /**
     * 自定义错误码
     */
    private Integer code;

    public BusinessException() {}

    public BusinessException(BusinessEnum businessEnum) {
        super(businessEnum.getMsg());
        this.code = businessEnum.getCode();
    }

    public Integer getCode() {
        return code;
    }

    public void setCode(Integer code) {
        this.code = code;
    }

}
