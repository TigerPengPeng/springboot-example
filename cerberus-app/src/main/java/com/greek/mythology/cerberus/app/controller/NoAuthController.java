/*
 * Copyright (c) 2010-2015 qinlian.com
 * All rights reserved.
 * 
 */
package com.greek.mythology.cerberus.app.controller;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.greek.mythology.cerberus.app.annotation.HttpResponseAnnotation;
import com.greek.mythology.cerberus.common.dao.UserInfoDo;
import com.greek.mythology.cerberus.common.service.UserInfoBO;
import com.greek.mythology.cerberus.common.threadlocal.PerRequestThreadLocal;
import com.greek.mythology.cerberus.service.dao.UserDao;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author huangpeng
 *         date 2018年07月20日
 *         desc
 */
@RestController
public class NoAuthController {
    @Autowired
    private UserDao userDao;

    @HttpResponseAnnotation
    @RequestMapping("/test")
    public Object test() {
        UserInfoBO userInfoBO = PerRequestThreadLocal.getUserInfo();

        QueryWrapper<UserInfoDo> wrapper = new QueryWrapper<>();
        wrapper.eq("userName", "bb8");

        return userDao.selectByWrapper(wrapper);
    }
}
