package com.github.baifenghe.common.entity;

import lombok.Data;

/**
 * 自定义返回体格式
 *
 * @author bfh
 * @since 1.0.0
 */
@Data
public class ResponseInfo<T> {

    private Integer code;

    private String message;

    private T data;
}
