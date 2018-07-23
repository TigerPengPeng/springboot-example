/*
 * Copyright (c) 2010-2015
 * All rights reserved.
 * 
 */
package com.greek.mythology.cerberus.common.enums;

/**
 * @author huangpeng
 *         date 2018年07月23日
 *         desc
 */
public enum  BusinessResultEnum implements IEnum {
    SUCCESS(0, "ok"),

    EMPTY_WRAPPER(100, "empty mybatis wrapper"),

    ;

    private final int code;
    private final String message;

    BusinessResultEnum(int code, String message) {
        this.code = code;
        this.message = message;
    }

    /**
     * 获取错误对应的错误码
     *
     * @return 错误码
     */
    @Override
    public int getCode() {
        return this.code;
    }

    /**
     * 获取错误的详细信息
     *
     * @return 错误信息
     */
    @Override
    public String getMessage() {
        return this.message;
    }

    @Override
    public boolean successCode() {
        return SUCCESS.getCode() == this.code;
    }
}
