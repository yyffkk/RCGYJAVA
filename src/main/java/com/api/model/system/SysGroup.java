package com.api.model.system;

/**
 * 用户组
 */
public class SysGroup {
    /**
     * 主键ID
     */
    private Integer id;
    /**
     * 组名称
     */
    private String name;
    /**
     * 组编码
     */
    private String code;

    @Override
    public String toString() {
        return "SysGroup{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", code='" + code + '\'' +
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

    public SysGroup() {
    }

    public SysGroup(Integer id, String name, String code) {
        this.id = id;
        this.name = name;
        this.code = code;
    }
}
