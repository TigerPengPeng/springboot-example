/*
 * Copyright (c) 2010-2015 meituan.com
 * All rights reserved.
 * 
 */
package com.greek.mythology.cerberus.common.threadlocal;

import com.greek.mythology.cerberus.common.service.UserInfoBO;

/**
 * @author huangpeng
 *         date 2018年07月22日
 *         desc
 */
public class PerRequestThreadLocal {
    private PerRequestThreadLocal() {}

    private static ThreadLocal<UserInfoBO> threadLocal = new ThreadLocal<>();

    public static void putUserInfo(UserInfoBO userInfoBO) {
        threadLocal.set(userInfoBO);
    }

    public static UserInfoBO getUserInfo() {
        return threadLocal.get();
    }

    public static void clear() {
        threadLocal.remove();
    }
}
