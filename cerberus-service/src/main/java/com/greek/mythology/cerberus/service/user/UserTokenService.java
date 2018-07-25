/*
 * Copyright (c) 2010-2015
 * All rights reserved.
 * 
 */
package com.greek.mythology.cerberus.service.user;

import com.greek.mythology.cerberus.common.model.dao.CerberusUser;

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
     CerberusUser getUserByToken(String token);
}
