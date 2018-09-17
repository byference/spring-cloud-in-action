package com.github.baifenghe.common.util;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.serializer.SerializerFeature;
import com.github.baifenghe.common.constant.CommonConst;
import com.github.baifenghe.common.entity.ResponseModel;

/**
 * 自定义返回体工具类
 *
 * @author bfh
 * @since 1.0.0
 */
public class R {

    public static String SUCCESS(Integer code, String msg, Object data) {

        ResponseModel rm = new ResponseModel();
        rm.setFlag(CommonConst.SUCCESS);
        rm.setCode(code);
        rm.setMsg(msg);
        rm.setData(data);

        return JSON.toJSONString(rm, SerializerFeature.WriteNullStringAsEmpty);
    }

    public static String FAILED(Integer code, String msg, Object data) {

        ResponseModel rm = new ResponseModel();
        rm.setFlag(CommonConst.FAILED);
        rm.setCode(code);
        rm.setMsg(msg);
        rm.setData(data);

        return JSON.toJSONString(rm, SerializerFeature.WriteNullStringAsEmpty);
    }
}
