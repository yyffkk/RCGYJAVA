package com.api.model.entity;

import com.baomidou.mybatisplus.annotation.TableName;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;
import java.util.Date;

/**
 * 系统用户
 */
@Data
@NoArgsConstructor
@AllArgsConstructor
@TableName("sys_user")
public class SysUserDo implements Serializable {
    private static final long serialVersionUID = 1L;

    /**
     * 用户ID
     */
    private Integer id;
    /**
     * 用户名
     */
    private String userName;
    /**
     * 密码
     */
    private String pwd;
    /**
     * 真实姓名
     */
    private String actualName;
    /**
     * 手机号
     */
    private String tel;
    /**
     * 性别
     */
    private Integer sex;
    /**
     * 用户编号
     */
    private String userCode;
    /**
     * 生日
     */
    private Date birthday;
    /**
     * 电子邮箱
     */
    private String email;
    /**
     * 身份证（护照）
     */
    private String idCard;
    /**
     * 组织ID
     */
    private Integer organizationId;
    /**
     * 组织ID全路径  用‘:’分割
     */
    private String organizationIdPath;
    /**
     * 职位ID
     */
    private Integer positionId;
    /**
     * 角色ID，用'，'隔开，格式为(1,2)
     */
    private String roleId;
    /**
     * 用户状态
     */
    private Integer status;
    /**
     * 是否删除
     */
    private Integer isDelete;
    /**
     * 创建人
     */
    private Integer createId;
    /**
     * 创建时间
     */
    private Date createDate;
    /**
     * 修改人
     */
    private Integer modifyId;
    /**
     * 修改时间
     */
    private Date modifyDate;
    /**
     * 最后一次登录IP
     */
    private Integer lastLoginIp;
    /**
     * 最后一次登录时间
     */
    private Date lastLoginDate;
    /**
     * 昵称
     */
    private String nickName;
    /**
     * 验证码（用于用户验证码登录）
     */
    private String code;
    /**
     * 验证码发送时间
     */
    private Date codeSendDate;
    /**
     * 备注
     */
    private String remake;
    /**
     * 汇报对象
     */
    private Integer reportTo;
    /**
     * 入职日期
     */
    private Date entryDate;
}
