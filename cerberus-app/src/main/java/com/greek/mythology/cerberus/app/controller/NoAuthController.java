/*
 * Copyright (c) 2010-2015 meituan.com
 * All rights reserved.
 * 
 */
package com.greek.mythology.cerberus.app.controller;

import com.greek.mythology.cerberus.common.service.UserInfoBO;
import com.greek.mythology.cerberus.common.threadlocal.PerRequestThreadLocal;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author huangpeng
 *         date 2018年07月20日
 *         desc
 */
@RestController
public class NoAuthController {

    @RequestMapping("/auth")
    public String monitorAlive() {
        UserInfoBO userInfoBO = PerRequestThreadLocal.getUserInfo();
        return "ok";
    }
}
