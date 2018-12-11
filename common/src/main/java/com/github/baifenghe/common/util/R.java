package com.github.baifenghe.common.util;

import com.alibaba.fastjson.JSON;
import com.github.baifenghe.common.constant.CommonConst;
import com.github.baifenghe.common.entity.ResponseInfo;

import java.io.Serializable;

/**
 * 自定义返回体工具类
 *
 * @author bfh
 * @since 1.0.0
 */
public class R implements Serializable {

    private static final long serialVersionUID = 1L;

    public static<T> String SUCCESS(String msg, T data) {

        ResponseInfo<T> info = new ResponseInfo<>();
        info.setCode(CommonConst.SUCCESS);
        info.setMessage(msg);
        info.setData(data);
        return JSON.toJSONString(info);

    }

    public static<T> String FAILED(Integer code, String msg, T data) {

        ResponseInfo<T> info = new ResponseInfo<>();
        info.setCode(code);
        info.setMessage(msg);
        info.setData(data);
        return JSON.toJSONString(info);

    }

}
