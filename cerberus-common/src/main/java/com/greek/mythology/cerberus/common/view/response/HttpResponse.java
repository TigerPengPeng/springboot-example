/*
 * Copyright (c) 2010-2015 qinlian.com
 * All rights reserved.
 * 
 */
package com.greek.mythology.cerberus.common.view.response;

import com.greek.mythology.cerberus.common.enums.BusinessResultEnum;
import com.greek.mythology.cerberus.common.exception.BusinessException;
import lombok.Getter;
import lombok.ToString;
import org.springframework.http.HttpStatus;

/**
 * @author huangpeng
 *         date 2018年07月22日
 *         desc
 */
@ToString
@Getter
public class HttpResponse<T> {
    private T data;

    private int code;

    private String message;

    private HttpResponse() {}

    private static HttpResponse newSuccessHttpResponse() {
        HttpResponse httpResponse = new HttpResponse();
        httpResponse.code = BusinessResultEnum.SUCCESS.getCode();
        httpResponse.message = BusinessResultEnum.SUCCESS.getMessage();
        return httpResponse;
    }

    public static <T> HttpResponse newSuccessHttpResponse(T data) {
        HttpResponse<T> httpResponse = new HttpResponse<>();
        httpResponse.code = BusinessResultEnum.SUCCESS.getCode();
        httpResponse.message = BusinessResultEnum.SUCCESS.getMessage();
        httpResponse.data = data;
        return httpResponse;
    }

    public static HttpResponse newHttpResponse(HttpStatus httpStatus) {
        if (httpStatus == null) {
            return newSuccessHttpResponse();
        }

        HttpResponse httpResponse = new HttpResponse();
        httpResponse.code = httpStatus.value();
        httpResponse.message = httpStatus.getReasonPhrase();
        return httpResponse;
    }

    public static HttpResponse newHttpResponse(BusinessException e) {
        if (e == null) {
            return newSuccessHttpResponse();
        }

        HttpResponse httpResponse = new HttpResponse();
        httpResponse.code = e.getType().getCode();
        httpResponse.message = e.getExceptionMessage();
        return httpResponse;
    }

    public static HttpResponse newHttpResponse(Exception e) {
        if (e == null) {
            return newSuccessHttpResponse();
        }

        return newHttpResponse(HttpStatus.INTERNAL_SERVER_ERROR);
    }


}
