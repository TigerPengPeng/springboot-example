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
 * @since 2018-07-25
 */
@Data
@EqualsAndHashCode(callSuper = false)
@Accessors(chain = true)
public class CerberusUser implements Serializable {

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
