/*
 * Copyright (c) 2010-2015 qinlian.com
 * All rights reserved.
 * 
 */
package com.greek.mythology.cerberus.app.filter;

import com.google.common.collect.Sets;
import com.greek.mythology.cerberus.common.service.UserInfoBO;
import com.greek.mythology.cerberus.common.threadlocal.PerRequestThreadLocal;
import com.greek.mythology.cerberus.common.util.UuidUtil;
import com.greek.mythology.cerberus.service.login.UserTokenService;
import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;

import javax.servlet.*;
import javax.servlet.http.HttpServletRequest;
import java.io.IOException;
import java.util.Set;

/**
 * @author huangpeng
 *         date 2018年07月22日
 *         desc
 */
public class AuthTokenFilter extends AbstractWriteResponseFilter implements Filter {

    @Autowired
    private UserTokenService userTokenService;

    private Set<String> excludedUrls = Sets.newHashSet("/login", "/monitor/alive");


    @Override
    public void init(FilterConfig filterConfig) throws ServletException {

    }

    @Override
    public void doFilter(ServletRequest servletRequest, ServletResponse servletResponse, FilterChain filterChain)
            throws IOException, ServletException {

        HttpServletRequest httpServletRequest = (HttpServletRequest) servletRequest;
        String path = httpServletRequest.getServletPath();
        if (excludedUrls.contains(path)) {
            filterChain.doFilter(servletRequest, servletResponse);
            return;
        }

        String token = httpServletRequest.getHeader("Authorization");

        if (StringUtils.isBlank(token)) {
            writeResponse(servletResponse, HttpStatus.UNAUTHORIZED);
            return;
        }

        UserInfoBO userInfoBO = userTokenService.getUserByToken(token);
        if (userInfoBO == null) {
            writeResponse(servletResponse, HttpStatus.UNAUTHORIZED);
            return;
        }

        try {

            PerRequestThreadLocal.putUserInfo(userInfoBO);
            PerRequestThreadLocal.putUuid(UuidUtil.getUuid());

            filterChain.doFilter(servletRequest, servletResponse);

        } finally {
            PerRequestThreadLocal.clear();
        }

    }

    @Override
    public void destroy() {

    }
}
