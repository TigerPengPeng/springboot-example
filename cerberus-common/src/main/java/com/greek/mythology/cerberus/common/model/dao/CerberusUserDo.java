package com.greek.mythology.cerberus.common.model.dao;

import lombok.Data;

import java.io.Serializable;
import java.time.LocalDateTime;

@Data
public class CerberusUserDo implements Serializable{

    private static final long serialVersionUID = 1L;

    private Long id;
    private LocalDateTime createTime;
    private LocalDateTime updateTime;
    private String username;
    private String password;
    private Integer tenantId;
    private String jobId;
    private Integer role;
    private Integer menuAuth;
    private String realName;
    private String tel;
    private String email;

    public CerberusUser toDbEntity(){
        CerberusUser entity = new CerberusUser();
        entity.setId(id);
        entity.setCreateTime(createTime);
        entity.setUpdateTime(updateTime);
        entity.setUsername(username);
        entity.setPassword(password);
        entity.setTenantId(tenantId);
        entity.setJobId(jobId);
        entity.setRole(role);
        entity.setMenuAuth(menuAuth);
        entity.setRealName(realName);
        entity.setTel(tel);
        entity.setEmail(email);
        return entity;
    }
}
