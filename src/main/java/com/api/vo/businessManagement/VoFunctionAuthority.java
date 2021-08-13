package com.api.vo.businessManagement;

/**
 * 功能权限管理Vo list 回显
 */
public class VoFunctionAuthority {
    /**
     * 员工主键id
     */
    private Integer id;
    /**
     * 昵称（系统名）
     */
    private String nickName;
    /**
     * 真实名称
     */
    private String actualName;
    /**
     * 联系方式
     */
    private String tel;
    /**
     * 主属部门名称
     */
    private String organizationName;
    /**
     * 职位名称
     */
    private String positionName;
    /**
     * 角色ID，用'，'隔开，格式为(1,2)
     */
    private String roleId;
    /**
     * 角色名称
     */
    private String roleName;

    @Override
    public String toString() {
        return "VoFunctionAuthority{" +
                "id=" + id +
                ", nickName='" + nickName + '\'' +
                ", actualName='" + actualName + '\'' +
                ", tel='" + tel + '\'' +
                ", organizationName='" + organizationName + '\'' +
                ", positionName='" + positionName + '\'' +
                ", roleId='" + roleId + '\'' +
                ", roleName='" + roleName + '\'' +
                '}';
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getNickName() {
        return nickName;
    }

    public void setNickName(String nickName) {
        this.nickName = nickName;
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

    public String getOrganizationName() {
        return organizationName;
    }

    public void setOrganizationName(String organizationName) {
        this.organizationName = organizationName;
    }

    public String getPositionName() {
        return positionName;
    }

    public void setPositionName(String positionName) {
        this.positionName = positionName;
    }

    public String getRoleId() {
        return roleId;
    }

    public void setRoleId(String roleId) {
        this.roleId = roleId;
    }

    public String getRoleName() {
        return roleName;
    }

    public void setRoleName(String roleName) {
        this.roleName = roleName;
    }

    public VoFunctionAuthority() {
    }

    public VoFunctionAuthority(Integer id, String nickName, String actualName, String tel, String organizationName, String positionName, String roleId, String roleName) {
        this.id = id;
        this.nickName = nickName;
        this.actualName = actualName;
        this.tel = tel;
        this.organizationName = organizationName;
        this.positionName = positionName;
        this.roleId = roleId;
        this.roleName = roleName;
    }
}
