/*
 * Copyright (c) 2010-2015
 * All rights reserved.
 * 
 */
package com.greek.mythology.cerberus.app.controller;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.greek.mythology.cerberus.app.annotation.HttpResponseAnnotation;
import com.greek.mythology.cerberus.app.controller.converter.CerberusUserConverter;
import com.greek.mythology.cerberus.common.model.service.user.CerberusUser;
import com.greek.mythology.cerberus.common.threadlocal.PerRequestThreadLocal;
import com.greek.mythology.cerberus.service.user.CerberusUserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

/**
 * @author huangpeng
 *         date 2018年07月20日
 *         desc
 */
@RestController
public class NoAuthController {
    @Autowired
    private CerberusUserService cerberusUserService;

    @HttpResponseAnnotation
    @RequestMapping("/test")
    public Object test() {
        CerberusUser userInfoBO = PerRequestThreadLocal.getUserInfo();
        QueryWrapper<CerberusUser> queryWrapper = new QueryWrapper<>();
        queryWrapper.ge("id", 0L);

        List<CerberusUser> cerberusUsers = cerberusUserService.selectList(queryWrapper);
        return CerberusUserConverter.convertTOCerberusUserVO(cerberusUsers);
    }
}
