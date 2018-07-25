/*
 * Copyright (c) 2010-2015
 * All rights reserved.
 * 
 */
package com.greek.mythology.cerberus.app.aop;

import com.greek.mythology.cerberus.common.exception.BusinessException;
import com.greek.mythology.cerberus.common.model.dao.CerberusUser;
import com.greek.mythology.cerberus.common.model.view.response.HttpResponse;
import com.greek.mythology.cerberus.common.threadlocal.PerRequestThreadLocal;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;

/**
 * @author huangpeng
 *         date 2018年07月23日
 *         desc
 */
@Aspect
@Component
public class HttpResponseAspect {

    private static final Logger LOGGER = LoggerFactory.getLogger(HttpResponseAspect.class);

    @SuppressWarnings("unchecked")
    @Around("@annotation(com.greek.mythology.cerberus.app.annotation.HttpResponseAnnotation)")
    public Object logAround(ProceedingJoinPoint joinPoint) throws Throwable {

        Object[] requestArgs = joinPoint.getArgs();
        Object response = null;

        String uuid = PerRequestThreadLocal.getUuid();
        CerberusUser currentUserInfo = PerRequestThreadLocal.getUserInfo();

        try {

            Object data = joinPoint.proceed(requestArgs);
            response = HttpResponse.newSuccessHttpResponse(data);

        } catch (BusinessException e) {
            LOGGER.warn("uuid={}, userInfo={}, requestArgs={}", uuid, currentUserInfo, requestArgs, e);
            response = HttpResponse.newHttpResponse(e);

        } catch (Exception e) {
            LOGGER.error("uuid={}, userInfo={}, requestArgs={}", uuid, currentUserInfo, requestArgs, e);
            response = HttpResponse.newHttpResponse(e);
        }

        return response;
    }
}
