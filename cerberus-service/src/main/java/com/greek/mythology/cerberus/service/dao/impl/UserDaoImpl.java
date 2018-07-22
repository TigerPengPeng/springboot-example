/*
 * Copyright (c) 2010-2015 meituan.com
 * All rights reserved.
 * 
 */
package com.greek.mythology.cerberus.service.dao.impl;

import com.greek.mythology.cerberus.common.dao.UserInfoDo;
import com.greek.mythology.cerberus.service.dao.UserDao;
import com.greek.mythology.cerberus.service.dao.mapper.CerberusUserMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 * @author huangpeng
 *         date 2018年07月23日
 *         desc
 */
@Repository
public class UserDaoImpl implements UserDao {
    @Autowired
    private CerberusUserMapper userMapper;

    @Override
    public List<UserInfoDo> selectAll() {
        return userMapper.selectAll();
    }
}
