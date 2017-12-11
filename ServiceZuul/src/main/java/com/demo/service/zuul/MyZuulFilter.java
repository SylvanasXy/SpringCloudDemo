package com.demo.service.zuul;

import com.netflix.zuul.ZuulFilter;
import com.netflix.zuul.context.RequestContext;
import org.apache.commons.lang.StringUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;

import javax.servlet.http.HttpServletRequest;

/**
 * Zuul自带的过滤器
 * @author xy
 */
@Component
public class MyZuulFilter extends ZuulFilter {
    private static final Logger LOG = LoggerFactory.getLogger(MyZuulFilter.class);

    /**
     * 过滤器类型,有4种不同的状态:
     *  1. pre: 路由分发之前
     *  2. routing: 路由分发时
     *  3. post: 路由分发之后
     *  4. error: 发送错误调用
     *
     * 该方法必须重写
     * @return 过滤器类型
     */
    @Override
    public String filterType() {
        return "pre";
    }

    /**
     * 过滤的顺序
     *
     * 该方法必须重写
     * @return
     */
    @Override
    public int filterOrder() {
        return 0;
    }

    /**
     * 该处可以写逻辑判断,是否要过滤, true:过滤  false:不过滤
     *
     * 该方法必须要重写
     * @return
     */
    @Override
    public boolean shouldFilter() {
        return true;
    }

    /**
     * 过滤器的具体逻辑
     *
     * 该方法必须要重写
     * @return
     */
    @Override
    public Object run() {
        RequestContext ctx = RequestContext.getCurrentContext();
        HttpServletRequest request = ctx.getRequest();
        LOG.info("request method: {}, url: {} ", request.getMethod(), request.getRequestURL().toString());
        String token = request.getParameter("token");
        if (StringUtils.isBlank(token)) {
            LOG.error("request miss token parameter...");
            ctx.setResponseStatusCode(401);
            ctx.setSendZuulResponse(false); //必须要设置这个属性=false
            try {
                ctx.getResponse().getWriter().write("request fail, miss token parameter!");
            } catch (Exception e) {
                LOG.error("response error, errorMsg: " + e.toString());
            }
        }
        LOG.info("request pass filter success...");
        return null;
    }
}
