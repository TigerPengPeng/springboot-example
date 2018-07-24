package com.greek.mythology.cerberus.common.model.service.user;

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
 * @since 2018-07-24
 */
@Data
@EqualsAndHashCode(callSuper = false)
@Accessors(chain = true)
public class CerberusUserToken implements Serializable {

    private static final long serialVersionUID = 1L;

    /**
     * 唯一id（token）
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
    private Integer loginTenandId;

    /**
     * 1:有效 0:无效
     */
    private Integer status;


}
