package com.github.baifenghe.apigateway.filter;

import com.netflix.zuul.ZuulFilter;
import com.netflix.zuul.context.RequestContext;
import org.springframework.stereotype.Component;
import org.springframework.util.ReflectionUtils;

import javax.servlet.http.HttpServletResponse;
import java.io.ByteArrayInputStream;
import java.io.InputStream;
import java.io.OutputStream;

/**
 * 重写了SendErrorFilter，自定义返回体格式
 *
 * @author bfh
 * @since 1.0.0
 */
@Component
public class MySendErrorFilter extends ZuulFilter {

    @Override
    public String filterType() {
        return "error";
    }

    @Override
    public int filterOrder() {
        return 1000;
    }

    @Override
    public boolean shouldFilter() {
        RequestContext ctx = RequestContext.getCurrentContext();
        return ctx.getThrowable() != null && !ctx.getBoolean("sendErrorFilter.ran", false);
    }

    @Override
    public Object run() {
        try {
            RequestContext ctx = RequestContext.getCurrentContext();
            Throwable throwable = ctx.getThrowable();
            String message = throwable.getCause().toString();
            throwable.printStackTrace();

            HttpServletResponse servletResponse = ctx.getResponse();
            servletResponse.setCharacterEncoding("UTF-8");
            OutputStream outStream = servletResponse.getOutputStream();
            String errorMessage = "==>  自定义返回格式，返回数据为：" + message;

            InputStream is = new ByteArrayInputStream(errorMessage.getBytes(servletResponse.getCharacterEncoding()));
            writeResponse(is, outStream);
        }
        catch (Exception ex) {
            ReflectionUtils.rethrowRuntimeException(ex);
        }
        return null;
    }


    private void writeResponse(InputStream zin, OutputStream out) throws Exception {
        byte[] bytes = new byte[1024];
        int bytesRead = -1;
        while ((bytesRead = zin.read(bytes)) != -1) {
            out.write(bytes, 0, bytesRead);
        }
    }


}
