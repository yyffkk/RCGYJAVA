package com.api.model.businessManagement;

/**
 * 组织信息
 */
public class SysOrganization {
    /**
     * 主键ID
     */
    private Integer id;
    /**
     * 组织名称
     */
    private String name;
    /**
     * 组织编码
     */
    private String code;
    /**
     * 上级ID无上级则为0
     */
    private Integer parentId;

    @Override
    public String toString() {
        return "SysOrganization{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", code='" + code + '\'' +
                ", parentId=" + parentId +
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

    public SysOrganization() {
    }

    public SysOrganization(Integer id, String name, String code, Integer parentId) {
        this.id = id;
        this.name = name;
        this.code = code;
        this.parentId = parentId;
    }
}
