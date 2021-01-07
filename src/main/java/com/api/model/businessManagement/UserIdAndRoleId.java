package com.api.model.businessManagement;


/**
 * 员工主键id 和 角色ID
 */
public class UserIdAndRoleId {
    /**
     * 员工主键id
     */
    private Integer id;
    /**
     * 角色ID，用'，'隔开，格式为(1,2)
     */
    private String roleId;

    @Override
    public String toString() {
        return "UserIdAndRoleId{" +
                "id=" + id +
                ", roleId='" + roleId + '\'' +
                '}';
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getRoleId() {
        return roleId;
    }

    public void setRoleId(String roleId) {
        this.roleId = roleId;
    }

    public UserIdAndRoleId() {
    }

    public UserIdAndRoleId(Integer id, String roleId) {

        this.id = id;
        this.roleId = roleId;
    }
}
