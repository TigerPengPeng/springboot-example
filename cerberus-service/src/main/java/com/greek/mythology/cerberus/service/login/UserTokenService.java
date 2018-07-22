/*
 * Copyright (c) 2010-2015 meituan.com
 * All rights reserved.
 * 
 */
package com.greek.mythology.cerberus.service.login;

import com.greek.mythology.cerberus.common.service.UserInfoBO;

/**
 * @author huangpeng
 *         date 2018年07月22日
 *         desc
 */
public interface UserTokenService {

     /**
      *
      * @param token
      * @return
      */
     UserInfoBO getUserByToken(String token);
}
