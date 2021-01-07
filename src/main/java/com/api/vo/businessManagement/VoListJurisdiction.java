package com.api.vo.businessManagement;

import java.util.List;

/**
 * 角色权限list显示
 */
public class VoListJurisdiction {
    /**
     * 角色Id
     */
    private Integer roleId;
    /**
     * 权限主键id
     */
    private Integer id;
    /**
     * 权限名称
     */
    private String name;
    /**
     * 上级权限id，最上级为0
     */
    private Integer parentId;
    /**
     * 排序
     */
    private Integer sort;
    /**
     * 是否勾选
     */
    private Integer isCheck;
    /**
     * 下级权限集合
     */
    private List<VoListJurisdiction> voListJurisdictionList;

    @Override
    public String toString() {
        return "VoListJurisdiction{" +
                "roleId=" + roleId +
                ", id=" + id +
                ", name='" + name + '\'' +
                ", parentId=" + parentId +
                ", sort=" + sort +
                ", isCheck=" + isCheck +
                ", voListJurisdictionList=" + voListJurisdictionList +
                '}';
    }

    public Integer getRoleId() {
        return roleId;
    }

    public void setRoleId(Integer roleId) {
        this.roleId = roleId;
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

    public Integer getParentId() {
        return parentId;
    }

    public void setParentId(Integer parentId) {
        this.parentId = parentId;
    }

    public Integer getSort() {
        return sort;
    }

    public void setSort(Integer sort) {
        this.sort = sort;
    }

    public Integer getIsCheck() {
        return isCheck;
    }

    public void setIsCheck(Integer isCheck) {
        this.isCheck = isCheck;
    }

    public List<VoListJurisdiction> getVoListJurisdictionList() {
        return voListJurisdictionList;
    }

    public void setVoListJurisdictionList(List<VoListJurisdiction> voListJurisdictionList) {
        this.voListJurisdictionList = voListJurisdictionList;
    }

    public VoListJurisdiction() {
    }

    public VoListJurisdiction(Integer roleId, Integer id, String name, Integer parentId, Integer sort, Integer isCheck, List<VoListJurisdiction> voListJurisdictionList) {
        this.roleId = roleId;
        this.id = id;
        this.name = name;
        this.parentId = parentId;
        this.sort = sort;
        this.isCheck = isCheck;
        this.voListJurisdictionList = voListJurisdictionList;
    }
}
