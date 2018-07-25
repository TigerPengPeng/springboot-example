/*
 * Copyright (c) 2010-2015
 * All rights reserved.
 * 
 */
package com.greek.mythology.cerberus.service.user.impl;

import com.greek.mythology.cerberus.common.model.dao.CerberusUser;
import com.greek.mythology.cerberus.service.user.UserTokenService;
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
    public CerberusUser getUserByToken(String token) {
        return new CerberusUser();
    }
}
