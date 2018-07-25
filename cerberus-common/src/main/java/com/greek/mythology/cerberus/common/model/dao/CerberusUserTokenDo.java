package com.greek.mythology.cerberus.common.model.dao;

import com.greek.mythology.cerberus.common.model.service.user.CerberusUserToken;
import lombok.Data;

import java.io.Serializable;
import java.time.LocalDateTime;

@Data
public class CerberusUserTokenDo implements Serializable{

    private static final long serialVersionUID = 1L;

    private Long id;
    private LocalDateTime createTime;
    private LocalDateTime updateTime;
    private String token;
    private Long userId;
    private Integer loginRole;
    private Integer loginTenantId;
    private Integer status;

    public CerberusUserToken toDbEntity(){
        CerberusUserToken entity = new CerberusUserToken();
        entity.setId(id);
        entity.setCreateTime(createTime);
        entity.setUpdateTime(updateTime);
        entity.setToken(token);
        entity.setUserId(userId);
        entity.setLoginRole(loginRole);
        entity.setLoginTenantId(loginTenantId);
        entity.setStatus(status);
        return entity;
    }
}
