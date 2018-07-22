/*
 * Copyright (c) 2010-2015 meituan.com
 * All rights reserved.
 * 
 */
package com.greek.mythology.cerberus.service.login.impl;

import com.greek.mythology.cerberus.common.service.UserInfoBO;
import com.greek.mythology.cerberus.service.login.UserTokenService;
import org.springframework.stereotype.Service;

/**
 * @author huangpeng
 *         date 2018年07月22日
 *         desc
 */
@Service
public class UserTokenServiceImpl implements UserTokenService {
    /**
     * @param token
     * @return
     */
    @Override
    public UserInfoBO getUserByToken(String token) {
        return new UserInfoBO();
    }
}
