package com.api.vo.businessManagement;

/**
 * 角色信息Vo findById 回显
 */
public class VoRoleFBI {
    /**
     * 角色主键id
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
     * 上级角色主键id
     */
    private Integer parentId;
    /**
     * 上级角色名称
     */
    private String parentName;

    @Override
    public String toString() {
        return "VoRole{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", code='" + code + '\'' +
                ", parentId=" + parentId +
                ", parentName='" + parentName + '\'' +
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

    public String getParentName() {
        return parentName;
    }

    public void setParentName(String parentName) {
        this.parentName = parentName;
    }

    public VoRoleFBI() {
    }

    public VoRoleFBI(Integer id, String name, String code, Integer parentId, String parentName) {
        this.id = id;
        this.name = name;
        this.code = code;
        this.parentId = parentId;
        this.parentName = parentName;
    }
}
