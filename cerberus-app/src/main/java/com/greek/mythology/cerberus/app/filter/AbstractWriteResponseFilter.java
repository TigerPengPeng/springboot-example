/*
 * Copyright (c) 2010-2015 qinlian.com
 * All rights reserved.
 * 
 */
package com.greek.mythology.cerberus.app.filter;

import com.alibaba.fastjson.JSON;
import com.greek.mythology.cerberus.common.view.response.HttpResponse;
import org.springframework.http.HttpStatus;

import javax.servlet.ServletResponse;
import java.io.IOException;

/**
 * @author huangpeng
 *         date 2018年07月22日
 *         desc
 */
public abstract class AbstractWriteResponseFilter {

    protected void writeResponse(ServletResponse response, HttpStatus httpStatus) throws IOException {
        response.setContentType("application/json;charset=utf-8");
        response.setCharacterEncoding("UTF-8");
        HttpResponse httpResponse = HttpResponse.newHttpResponse(httpStatus);
        response.getOutputStream().write(JSON.toJSONBytes(httpResponse));
        response.flushBuffer();
    }
}
