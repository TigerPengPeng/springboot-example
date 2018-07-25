package com.greek.mythology.cerberus.common.model.dao;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableId;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.experimental.Accessors;

import java.io.Serializable;
import java.time.LocalDateTime;

/**
 * <p>
 * 
 * </p>
 *
 * @author huangpeng
 * @since 2018-07-25
 */
@Data
@EqualsAndHashCode(callSuper = false)
@Accessors(chain = true)
public class CerberusUserToken implements Serializable {

    private static final long serialVersionUID = 1L;

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
     * token MD5(id)
     */
    private String token;

    /**
     * cerberus_user.id
     */
    private Long userId;

    /**
     * 当时登录的角色
     */
    private Integer loginRole;

    /**
     * 当时登录的机构ID
     */
    private Integer loginTenantId;

    /**
     * 1:有效 0:无效
     */
    private Integer status;


}
