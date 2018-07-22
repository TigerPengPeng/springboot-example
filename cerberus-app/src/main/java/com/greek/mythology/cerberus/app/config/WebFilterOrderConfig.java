/*
 * Copyright (c) 2010-2015 meituan.com
 * All rights reserved.
 * 
 */
package com.greek.mythology.cerberus.app.config;

import com.greek.mythology.cerberus.app.filter.AuthTokenFilter;
import com.greek.mythology.cerberus.app.filter.ValidUrlFilter;
import org.springframework.boot.web.servlet.FilterRegistrationBean;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import javax.servlet.Filter;

/**
 * @author huangpeng
 *         date 2018年07月22日
 *         desc
 */
@Configuration
public class WebFilterOrderConfig {

    @Bean
    public FilterRegistrationBean filterRegistrationBean() {
        FilterRegistrationBean<Filter> registrationBean = new FilterRegistrationBean<>();
        registrationBean.setFilter(validUrlFilter());
        registrationBean.setOrder(1);
        return registrationBean;
    }

    @Bean
    public FilterRegistrationBean contextFilterRegistrationBean() {
        FilterRegistrationBean<Filter> registrationBean = new FilterRegistrationBean<>();
        registrationBean.setFilter(authTokenFilter());
        registrationBean.setOrder(2);
        return registrationBean;
    }
    @Bean
    public ValidUrlFilter validUrlFilter() {
        return new ValidUrlFilter();
    }

    @Bean
    public AuthTokenFilter authTokenFilter() {
        return new AuthTokenFilter();
    }
}
