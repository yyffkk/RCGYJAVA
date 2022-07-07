package com.api.model.system;

/**
 * 系统设置model
 */
public class SysSettings {
    /**
     * 主键id
     */
    private Integer id;
    /**
     * 设置名称
     */
    private String name;
    /**
     * 开关：1.开启，2.关闭
     */
    private Integer onOff;

    @Override
    public String toString() {
        return "SysSettings{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", onOff=" + onOff +
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

    public Integer getOnOff() {
        return onOff;
    }

    public void setOnOff(Integer onOff) {
        this.onOff = onOff;
    }

    public SysSettings() {
    }

    public SysSettings(Integer id, String name, Integer onOff) {
        this.id = id;
        this.name = name;
        this.onOff = onOff;
    }
}
