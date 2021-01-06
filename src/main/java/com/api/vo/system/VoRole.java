package com.api.vo.system;

import java.util.List;

/**
 * 角色信息Vo list 回显
 */
public class VoRole {
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
     * 下级角色集合
     */
    private List<VoRole> voRoleList;

    @Override
    public String toString() {
        return "VoRole{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", code='" + code + '\'' +
                ", parentId=" + parentId +
                ", actionId=" + actionId +
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

    public List<VoRole> getVoRoleList() {
        return voRoleList;
    }

    public void setVoRoleList(List<VoRole> voRoleList) {
        this.voRoleList = voRoleList;
    }

    public VoRole() {
    }

    public VoRole(Integer id, String name, String code, Integer parentId, Integer actionId, List<VoRole> voRoleList) {
        this.id = id;
        this.name = name;
        this.code = code;
        this.parentId = parentId;
        this.actionId = actionId;
        this.voRoleList = voRoleList;
    }
}
