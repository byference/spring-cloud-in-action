package com.github.baifenghe.gateway.filter;

import com.alibaba.fastjson.JSON;
import com.github.baifenghe.common.constant.enums.BusinessEnum;
import com.github.baifenghe.toolkit.common.model.Result;
import com.netflix.zuul.ZuulFilter;
import com.netflix.zuul.context.RequestContext;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;
import org.springframework.util.StringUtils;

import javax.servlet.http.HttpServletRequest;

/**
 * Api网关过滤器
 *
 * @author bfh
 * @since 1.0.0
 */
@Component
public class AccessFilter extends ZuulFilter {


    private Logger log = LoggerFactory.getLogger(this.getClass());

    /**
     * 过滤器执行的生命周期
     */
    @Override
    public String filterType() {
        return "pre";
    }

    /**
     * 指定过滤器的执行顺序
     */
    @Override
    public int filterOrder() {
        return 0;
    }

    /**
     * 表示是否要执行该filter
     */
    @Override
    public boolean shouldFilter() {
        return true;
    }

    @Override
    public Object run() {

        RequestContext ctx = RequestContext.getCurrentContext();
        HttpServletRequest request = ctx.getRequest();
        log.info("==> send {} request to  ==> {}", request.getMethod(), request.getRequestURL());

        String swaggerApiAddress = "/v2/api-docs";
        String uri = request.getRequestURI();
        if (uri.contains(swaggerApiAddress)) {
            return null;
        }

        String token = request.getHeader("token");
        if(StringUtils.isEmpty(token)) {
            log.warn(">> access token is empty");
            ctx.setSendZuulResponse(false);
            /// 设置ContentType
            // ctx.getResponse().setContentType("application/json;charset=UTF-8");
            String body = JSON.toJSONString(Result.builder()
                    .code(BusinessEnum.TOKEN_EMPTY_ERROR.getCode())
                    .message(BusinessEnum.TOKEN_EMPTY_ERROR.getMsg())
                    .build());
            ctx.setResponseBody(body);
            return null;
        }
        return null;
    }
}
