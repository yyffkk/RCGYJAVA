package com.api.model.system;

/**
 * 身份（职业,岗位）
 */
public class SysIdentity {
    /**
     * 主键ID
     */
    private Integer id;
    /**
     * 职位名称
     */
    private String name;
    /**
     * 职位编号
     */
    private String code;
    /**
     * 上级ID无上级则为0
     */
    private Integer parentId;
    /**
     * 备注
     */
    private String remakes;

    @Override
    public String toString() {
        return "SysIdentity{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", code='" + code + '\'' +
                ", parentId=" + parentId +
                ", remakes='" + remakes + '\'' +
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

    public String getRemakes() {
        return remakes;
    }

    public void setRemakes(String remakes) {
        this.remakes = remakes;
    }

    public SysIdentity() {
    }

    public SysIdentity(Integer id, String name, String code, Integer parentId, String remakes) {
        this.id = id;
        this.name = name;
        this.code = code;
        this.parentId = parentId;
        this.remakes = remakes;
    }
}
