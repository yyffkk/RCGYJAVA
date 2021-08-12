package com.api.model.system;

/**
 * 模块功能开关model
 */
public class SysFunctionSwitch {
    /**
     * 主键id
     */
    private Integer id;
    /**
     * 功能名称
     */
    private String name;
    /**
     * 状态:1.开启，2.关闭
     */
    private Integer status;

    @Override
    public String toString() {
        return "SysFunctionSwitch{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", status=" + status +
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

    public Integer getStatus() {
        return status;
    }

    public void setStatus(Integer status) {
        this.status = status;
    }

    public SysFunctionSwitch() {
    }

    public SysFunctionSwitch(Integer id, String name, Integer status) {
        this.id = id;
        this.name = name;
        this.status = status;
    }
}
