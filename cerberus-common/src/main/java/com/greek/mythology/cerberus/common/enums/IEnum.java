package com.greek.mythology.cerberus.common.enums;


public interface IEnum {
    /**
     * 获取错误对应的错误码
     * @return 错误码
     */
    int getCode();

    /**
     * 获取错误的详细信息
     * @return 错误信息
     */
    String getMessage();

    boolean successCode();
}