/*
 * Copyright (c) 2010-2015 meituan.com
 * All rights reserved.
 * 
 */
package com.greek.mythology.cerberus.app.aop;

import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.springframework.stereotype.Component;

/**
 * @author huangpeng
 *         date 2018年07月23日
 *         desc
 */
@Aspect
@Component
public class HttpResponseAspect {

    @SuppressWarnings("unchecked")
    @Around("@annotation(com.greek.mythology.cerberus.app.annotation.HttpResponseAnnotation)")
    public Object logAround(ProceedingJoinPoint joinPoint) throws Throwable {
        return null;
    }
}
