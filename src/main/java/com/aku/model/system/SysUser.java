package com.aku.model.system;

import java.util.Date;

/**
 * 系统用户
 */
public class SysUser {
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
     * 职位ID
     */
    private Integer positionId;
    /**
     * 角色ID
     */
    private Integer roleId;
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

    @Override
    public String toString() {
        return "SysUser{" +
                "id=" + id +
                ", userName='" + userName + '\'' +
                ", pwd='" + pwd + '\'' +
                ", actualName='" + actualName + '\'' +
                ", tel='" + tel + '\'' +
                ", sex=" + sex +
                ", userCode='" + userCode + '\'' +
                ", birthday=" + birthday +
                ", email='" + email + '\'' +
                ", idCard='" + idCard + '\'' +
                ", organizationId=" + organizationId +
                ", positionId=" + positionId +
                ", roleId=" + roleId +
                ", status=" + status +
                ", isDelete=" + isDelete +
                ", createId=" + createId +
                ", createDate=" + createDate +
                ", modifyId=" + modifyId +
                ", modifyDate=" + modifyDate +
                ", lastLoginIp=" + lastLoginIp +
                ", lastLoginDate=" + lastLoginDate +
                '}';
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public String getPwd() {
        return pwd;
    }

    public void setPwd(String pwd) {
        this.pwd = pwd;
    }

    public String getActualName() {
        return actualName;
    }

    public void setActualName(String actualName) {
        this.actualName = actualName;
    }

    public String getTel() {
        return tel;
    }

    public void setTel(String tel) {
        this.tel = tel;
    }

    public Integer getSex() {
        return sex;
    }

    public void setSex(Integer sex) {
        this.sex = sex;
    }

    public String getUserCode() {
        return userCode;
    }

    public void setUserCode(String userCode) {
        this.userCode = userCode;
    }

    public Date getBirthday() {
        return birthday;
    }

    public void setBirthday(Date birthday) {
        this.birthday = birthday;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getIdCard() {
        return idCard;
    }

    public void setIdCard(String idCard) {
        this.idCard = idCard;
    }

    public Integer getOrganizationId() {
        return organizationId;
    }

    public void setOrganizationId(Integer organizationId) {
        this.organizationId = organizationId;
    }

    public Integer getPositionId() {
        return positionId;
    }

    public void setPositionId(Integer positionId) {
        this.positionId = positionId;
    }

    public Integer getRoleId() {
        return roleId;
    }

    public void setRoleId(Integer roleId) {
        this.roleId = roleId;
    }

    public Integer getStatus() {
        return status;
    }

    public void setStatus(Integer status) {
        this.status = status;
    }

    public Integer getIsDelete() {
        return isDelete;
    }

    public void setIsDelete(Integer isDelete) {
        this.isDelete = isDelete;
    }

    public Integer getCreateId() {
        return createId;
    }

    public void setCreateId(Integer createId) {
        this.createId = createId;
    }

    public Date getCreateDate() {
        return createDate;
    }

    public void setCreateDate(Date createDate) {
        this.createDate = createDate;
    }

    public Integer getModifyId() {
        return modifyId;
    }

    public void setModifyId(Integer modifyId) {
        this.modifyId = modifyId;
    }

    public Date getModifyDate() {
        return modifyDate;
    }

    public void setModifyDate(Date modifyDate) {
        this.modifyDate = modifyDate;
    }

    public Integer getLastLoginIp() {
        return lastLoginIp;
    }

    public void setLastLoginIp(Integer lastLoginIp) {
        this.lastLoginIp = lastLoginIp;
    }

    public Date getLastLoginDate() {
        return lastLoginDate;
    }

    public void setLastLoginDate(Date lastLoginDate) {
        this.lastLoginDate = lastLoginDate;
    }

    public SysUser() {
    }

    public SysUser(Integer id, String userName, String pwd, String actualName, String tel, Integer sex, String userCode, Date birthday, String email, String idCard, Integer organizationId, Integer positionId, Integer roleId, Integer status, Integer isDelete, Integer createId, Date createDate, Integer modifyId, Date modifyDate, Integer lastLoginIp, Date lastLoginDate) {
        this.id = id;
        this.userName = userName;
        this.pwd = pwd;
        this.actualName = actualName;
        this.tel = tel;
        this.sex = sex;
        this.userCode = userCode;
        this.birthday = birthday;
        this.email = email;
        this.idCard = idCard;
        this.organizationId = organizationId;
        this.positionId = positionId;
        this.roleId = roleId;
        this.status = status;
        this.isDelete = isDelete;
        this.createId = createId;
        this.createDate = createDate;
        this.modifyId = modifyId;
        this.modifyDate = modifyDate;
        this.lastLoginIp = lastLoginIp;
        this.lastLoginDate = lastLoginDate;
    }
}
