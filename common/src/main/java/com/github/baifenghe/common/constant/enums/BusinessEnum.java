package com.github.baifenghe.common.constant.enums;

/**
 * 业务枚举类
 *
 * @author bfh
 * @since 1.0.0
 */
public enum BusinessEnum {

    UNKNOW_ERROR(-1, "未知错误"),
    SUCCESS(1, "成功"),
    ERROR(0, "失败"),
    PARAMS_CHECK_ERROR(10000, "参数校验失败");

    private Integer code;
    private String msg;

    BusinessEnum(Integer code, String msg) {
        this.code = code;
        this.msg = msg;
    }

    public Integer getCode() {
        return code;
    }

    public String getMsg() {
        return msg;
    }

}
