package com.api.model.system;

/**
 * 系统编码功能对照表
 */
public class SysAction {
    /**
     * 主键ID
     */
    private Integer id;
    /**
     * 方法名称
     */
    private String systemActionName;
    /**
     * 方法编号
     */
    private String systemActionCode;

    @Override
    public String toString() {
        return "SysAction{" +
                "id=" + id +
                ", systemActionName='" + systemActionName + '\'' +
                ", systemActionCode='" + systemActionCode + '\'' +
                '}';
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getSystemActionName() {
        return systemActionName;
    }

    public void setSystemActionName(String systemActionName) {
        this.systemActionName = systemActionName;
    }

    public String getSystemActionCode() {
        return systemActionCode;
    }

    public void setSystemActionCode(String systemActionCode) {
        this.systemActionCode = systemActionCode;
    }

    public SysAction() {
    }

    public SysAction(Integer id, String systemActionName, String systemActionCode) {
        this.id = id;
        this.systemActionName = systemActionName;
        this.systemActionCode = systemActionCode;
    }
}
