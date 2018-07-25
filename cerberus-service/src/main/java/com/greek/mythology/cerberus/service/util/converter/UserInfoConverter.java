/*
 * Copyright (c) 2010-2015
 * All rights reserved.
 * 
 */
package com.greek.mythology.cerberus.service.util.converter;

import com.greek.mythology.cerberus.common.model.dao.CerberusUser;
import com.greek.mythology.cerberus.common.model.service.user.UserInfoBO;
import org.springframework.util.CollectionUtils;

import java.util.Collection;
import java.util.Collections;
import java.util.List;
import java.util.stream.Collectors;

/**
 * @author huangpeng
 *         date 2018年07月25日
 *         desc
 */
public class UserInfoConverter {
    private UserInfoConverter() {}

    public static List<UserInfoBO> convertTOCerberusUserVO(Collection<CerberusUser> collection) {
        if (CollectionUtils.isEmpty(collection)) {
            return Collections.emptyList();
        }

        return collection.stream().map(UserInfoConverter::convertTOCerberusUserVO).collect(Collectors.toList());
    }

    public static UserInfoBO convertTOCerberusUserVO(CerberusUser o) {
        if (o == null) {
            return null;
        }

        UserInfoBO v = new UserInfoBO();
        v.setCreateTime(o.getCreateTime());
        v.setUpdateTime(o.getUpdateTime());
        v.setUsername(o.getUsername());
        v.setTenantId(o.getTenantId());
        v.setJobId(o.getJobId());
        v.setRole(o.getRole());
        v.setMenuAuth(o.getMenuAuth());
        v.setRealName(o.getRealName());
        v.setTel(o.getTel());
        v.setEmail(o.getEmail());
        return v;
    }
}
