package com.escalab.zuul;

import com.netflix.zuul.ZuulFilter;
import com.netflix.zuul.context.RequestContext;
import com.netflix.zuul.exception.ZuulException;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;

import javax.servlet.http.HttpServletRequest;
@Component
public class PreFilro extends ZuulFilter {
    private static Logger LOGGER = LoggerFactory.getLogger(PreFilro.class);
    private static final String FILTERTYPE = "pre";
    private static final Integer FILTERORDER = 1;
    @Override
    public String filterType() {
        return FILTERTYPE;
    }

    @Override
    public int filterOrder() {
        return FILTERORDER;
    }

    @Override
    public boolean shouldFilter() {
        return true;
    }

    @Override
    public Object run() throws ZuulException {
        final HttpServletRequest request = RequestContext.getCurrentContext().getRequest();
        LOGGER.info("request: -****- ", request.getServerName(), request.getMethod());
        request.getHeader("Authorization");
        return null;
    }
}
