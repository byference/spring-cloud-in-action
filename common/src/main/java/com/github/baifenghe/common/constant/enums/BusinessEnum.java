package com.github.baifenghe.common.constant.enums;

import lombok.Getter;

/**
 * 业务枚举类
 *
 * @author bfh
 * @since 1.0.0
 */
@Getter
public enum BusinessEnum {


    /**
     * 参数校验失败
     */
    PARAMS_CHECK_ERROR(10000, "参数校验失败"),

    /**
     * token不能为空
     */
    TOKEN_EMPTY_ERROR(10001, "token不能为空"),

    /**
     * 未知错误
     */
    UN_KNOW_ERROR(-1, "未知错误"),

    /**
     * 成功
     */
    SUCCESS(1, "成功"),

    /**
     * 失败
     */
    ERROR(0, "失败");

    private Integer code;
    private String msg;

    BusinessEnum(Integer code, String msg) {
        this.code = code;
        this.msg = msg;
    }

}
