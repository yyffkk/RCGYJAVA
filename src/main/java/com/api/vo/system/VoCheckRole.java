package com.api.vo.system;

import java.util.List;

/**
 * 用户选择角色信息
 */
public class VoCheckRole {
    /**
     * 主键ID
     */
    private Integer id;
    /**
     * 角色名称
     */
    private String name;
    /**
     * 角色编码
     */
    private String code;
    /**
     * 上级角色
     */
    private Integer parentId;
    /**
     * 系统编码ID
     */
    private Integer actionId;
    /**
     * 是否勾选
     */
    private Integer isCheck;
    /**
     * 下级角色集合
     */
    private List<VoCheckRole> voRoleList;

    @Override
    public String toString() {
        return "VoCheckRole{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", code='" + code + '\'' +
                ", parentId=" + parentId +
                ", actionId=" + actionId +
                ", isCheck=" + isCheck +
                ", voRoleList=" + voRoleList +
                '}';
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getCode() {
        return code;
    }

    public void setCode(String code) {
        this.code = code;
    }

    public Integer getParentId() {
        return parentId;
    }

    public void setParentId(Integer parentId) {
        this.parentId = parentId;
    }

    public Integer getActionId() {
        return actionId;
    }

    public void setActionId(Integer actionId) {
        this.actionId = actionId;
    }

    public Integer getIsCheck() {
        return isCheck;
    }

    public void setIsCheck(Integer isCheck) {
        this.isCheck = isCheck;
    }

    public List<VoCheckRole> getVoRoleList() {
        return voRoleList;
    }

    public void setVoRoleList(List<VoCheckRole> voRoleList) {
        this.voRoleList = voRoleList;
    }

    public VoCheckRole() {
    }

    public VoCheckRole(Integer id, String name, String code, Integer parentId, Integer actionId, Integer isCheck, List<VoCheckRole> voRoleList) {
        this.id = id;
        this.name = name;
        this.code = code;
        this.parentId = parentId;
        this.actionId = actionId;
        this.isCheck = isCheck;
        this.voRoleList = voRoleList;
    }
}
