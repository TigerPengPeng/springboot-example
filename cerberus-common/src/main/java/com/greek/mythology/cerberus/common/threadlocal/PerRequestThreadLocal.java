/*
 * Copyright (c) 2010-2015
 * All rights reserved.
 * 
 */
package com.greek.mythology.cerberus.common.threadlocal;

import com.greek.mythology.cerberus.common.model.dao.CerberusUser;
import lombok.Data;

/**
 * @author huangpeng
 *         date 2018年07月22日
 *         desc
 */
public class PerRequestThreadLocal {
    private PerRequestThreadLocal() {}

    private static ThreadLocal<PerRequestBO> threadLocal = new ThreadLocal<PerRequestBO>() {
        @Override
        protected PerRequestBO initialValue() {
            return new PerRequestBO();
        }
    };

    public static void putUserInfo(CerberusUser userInfoBO) {
        threadLocal.get().setUserInfoBO(userInfoBO);
    }

    public static CerberusUser getUserInfo() {
        return threadLocal.get().getUserInfoBO();
    }

    public static void putUuid(String uuid) {
        threadLocal.get().setUuid(uuid);
    }

    public static String getUuid() {
        return threadLocal.get().getUuid();
    }

    public static void clear() {
        threadLocal.remove();
    }

    @Data
    private static class PerRequestBO {
        private CerberusUser userInfoBO;

        private String uuid;
    }
}
