/*
 * Copyright (c) 2010-2015 meituan.com
 * All rights reserved.
 * 
 */
package com.greek.mythology.cerberus.common.util;

import java.util.UUID;

/**
 * @author huangpeng
 *         date 2018年07月23日
 *         desc
 */
public class UuidUtil {
    private UuidUtil() {}

    /**
     * get random uuid
     * @return
     */
    public static String getUuid() {
        String s = UUID.randomUUID().toString();
        return s.substring(0, 8) + s.substring(9, 13) + s.substring(14, 18) + s.substring(19, 23) + s.substring(24);
    }
}
