/*
 * Copyright (c) 2010-2015 meituan.com
 * All rights reserved.
 * 
 */
package com.greek.mythology.cerberus.common.exception;

import com.greek.mythology.cerberus.common.enums.IEnum;
import lombok.Getter;
import org.apache.commons.lang3.StringUtils;

/**
 * @author huangpeng
 *         date 2018年07月22日
 *         desc
 */
@Getter
public class BusinessException extends RuntimeException {

    private final IEnum type;

    private final String detailMessage;

    public BusinessException(IEnum type) {
        this(type, null);
    }

    public BusinessException(IEnum type, String detailMessage) {
        super(detailMessage);
        this.type = type;
        this.detailMessage = detailMessage;
    }

    public String getExceptionMessage() {
        if (StringUtils.isNotBlank(detailMessage)) {
            return type.getMessage() + "_" + detailMessage;
        }
        return type.getMessage();
    }

}
