package com.github.baifenghe.common.entity;

import java.io.Serializable;

/**
 * 自定义返回体格式
 *
 * @author bfh
 * @since 1.0.0
 */
public class ResponseModel implements Serializable {

    private int flag;

    private Integer code;

    private String msg;

    private Object data;

    public int getFlag() {
        return flag;
    }

    public void setFlag(int flag) {
        this.flag = flag;
    }

    public String getMsg() {
        return msg;
    }

    public void setMsg(String msg) {
        this.msg = msg;
    }

    public Object getData() {
        return data;
    }

    public void setData(Object data) {
        this.data = data;
    }

    public Integer getCode() {
        return code;
    }

    public void setCode(Integer code) {
        this.code = code;
    }

}
