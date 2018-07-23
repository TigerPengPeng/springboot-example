/*
 * Copyright (c) 2010-2015 qinlian.com
 * All rights reserved.
 * 
 */
package com.greek.mythology.cerberus.service.dao.impl;

import com.baomidou.mybatisplus.core.conditions.Wrapper;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.greek.mythology.cerberus.common.dao.UserInfoDo;
import com.greek.mythology.cerberus.common.enums.BusinessResultEnum;
import com.greek.mythology.cerberus.common.exception.BusinessException;
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
public class UserDaoImpl extends ServiceImpl<CerberusUserMapper, UserInfoDo> implements UserDao {

    @Autowired
    private CerberusUserMapper userMapper;

    @Override
    public List<UserInfoDo> selectByWrapper(Wrapper wrapper) {
        if (wrapper == null) {
            throw new BusinessException(BusinessResultEnum.EMPTY_WRAPPER);
        }
        return userMapper.selectListByWrapper(wrapper);
    }
}
