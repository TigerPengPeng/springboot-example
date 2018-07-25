/*
 * Copyright (c) 2010-2015
 * All rights reserved.
 * 
 */
package com.greek.mythology.cerberus.app.controller.converter;

import com.greek.mythology.cerberus.common.model.service.user.CerberusUser;
import com.greek.mythology.cerberus.common.model.view.response.CerberusUserVO;
import com.greek.mythology.cerberus.common.util.DateUtil;
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
public class CerberusUserConverter {
    private CerberusUserConverter() {}

    public static List<CerberusUserVO> convertTOCerberusUserVO(Collection<CerberusUser> collection) {
        if (CollectionUtils.isEmpty(collection)) {
            return Collections.emptyList();
        }

        return collection.stream().map(CerberusUserConverter::convertTOCerberusUserVO).collect(Collectors.toList());
    }

    public static CerberusUserVO convertTOCerberusUserVO(CerberusUser o) {
        if (o == null) {
            return null;
        }

        CerberusUserVO v = new CerberusUserVO();
        v.setCreateTime(DateUtil.localDateTimeToDate(o.getCreateTime()));
        v.setUpdateTime(DateUtil.localDateTimeToDate(o.getUpdateTime()));
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
