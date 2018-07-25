/*
 * Copyright (c) 2010-2015
 * All rights reserved.
 * 
 */
package com.greek.mythology.cerberus.common.model.service.user;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableId;
import lombok.Data;

import java.time.LocalDateTime;

/**
 * @author huangpeng
 *         date 2018年07月25日
 *         desc
 */
@Data
public class UserInfoBO {
    /**
     * 唯一id
     */
    @TableId(value = "id", type = IdType.ID_WORKER)
    private Long id;

    /**
     * 记录创建时间
     */
    private LocalDateTime createTime;

    /**
     * 记录更新时间
     */
    private LocalDateTime updateTime;

    /**
     * 账号
     */
    private String username;

    /**
     * 密码
     */
    private String password;

    /**
     * 所属机构ID
     */
    private Integer tenantId;

    /**
     * 工号ID
     */
    private String jobId;

    /**
     * 角色. 用bit位来标记角色: 1客户经理／2信审人员／4绿色金融管理人员／8风险管理人员
     */
    private Integer role;

    /**
     * 能看见的菜单列表
     */
    private Integer menuAuth;

    /**
     * 真实姓名
     */
    private String realName;

    /**
     * 联系电话
     */
    private String tel;

    /**
     * 邮箱
     */
    private String email;
}
