package com.github.baifenghe.provider.common;


import lombok.AllArgsConstructor;
import lombok.Data;

/**
 * @author bfh
 * @since 2019/02/07
 */
@Data
@AllArgsConstructor
public class Result<T> {

    private Integer code;

    private String message;

    private T data;

}
