/*
 * Copyright (c) 2010-2015 qinlian.com
 * All rights reserved.
 * 
 */
package com.greek.mythology.cerberus.service.dao.mapper;

import com.baomidou.mybatisplus.core.conditions.Wrapper;
import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.greek.mythology.cerberus.common.dao.UserInfoDo;
import org.apache.ibatis.annotations.Param;

import java.util.List;

/**
 * @author huangpeng
 *         date 2018年07月23日
 *         desc
 */
public interface CerberusUserMapper extends BaseMapper<UserInfoDo> {

    List<UserInfoDo> selectListByWrapper(@Param("ew") Wrapper wrapper);
}
