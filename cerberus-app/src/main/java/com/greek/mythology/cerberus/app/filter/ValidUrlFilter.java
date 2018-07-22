/*
 * Copyright (c) 2010-2015 meituan.com
 * All rights reserved.
 * 
 */
package com.greek.mythology.cerberus.app.filter;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.context.WebApplicationContext;
import org.springframework.web.method.HandlerMethod;
import org.springframework.web.servlet.mvc.condition.PatternsRequestCondition;
import org.springframework.web.servlet.mvc.method.RequestMappingInfo;
import org.springframework.web.servlet.mvc.method.annotation.RequestMappingHandlerMapping;

import javax.servlet.*;
import javax.servlet.http.HttpServletRequest;
import java.io.IOException;
import java.util.Collection;
import java.util.Map;
import java.util.Set;
import java.util.stream.Collectors;

/**
 * @author huangpeng
 *         date 2018年07月22日
 *         desc
 */
public class ValidUrlFilter extends AbstractWriteResponseFilter implements Filter {

    @Autowired
    private WebApplicationContext applicationContext;

    private Set<String> registeredUrls;

    @Override
    public void init(FilterConfig filterConfig) throws ServletException {
        registeredUrls = getRegisteredUrls();
    }

    @Override
    public void doFilter(ServletRequest servletRequest, ServletResponse servletResponse, FilterChain filterChain) throws IOException, ServletException {
        HttpServletRequest httpServletRequest = (HttpServletRequest) servletRequest;
        String path = httpServletRequest.getServletPath();

        if (!registeredUrls.contains(path)) {
            writeResponse(servletResponse, HttpStatus.NOT_FOUND);
            return;
        }

        filterChain.doFilter(servletRequest, servletResponse);
    }

    @Override
    public void destroy() {

    }

    private Set<String> getRegisteredUrls() {

        RequestMappingHandlerMapping mapping = applicationContext.getBean(RequestMappingHandlerMapping.class);

        Map<RequestMappingInfo, HandlerMethod> map = mapping.getHandlerMethods();

        return map.keySet().stream()
                .map(RequestMappingInfo::getPatternsCondition)
                .map(PatternsRequestCondition::getPatterns)
                .flatMap(Collection::stream)
                .collect(Collectors.toSet());
    }
}
