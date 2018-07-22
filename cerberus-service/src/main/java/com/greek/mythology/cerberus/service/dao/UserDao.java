/*
 * Copyright (c) 2010-2015 meituan.com
 * All rights reserved.
 * 
 */
package com.greek.mythology.cerberus.service.dao;

import com.greek.mythology.cerberus.common.dao.UserInfoDo;

import java.util.List;

/**
 * @author huangpeng
 *         date 2018年07月23日
 *         desc
 */
public interface UserDao {

    List<UserInfoDo> selectAll();
}