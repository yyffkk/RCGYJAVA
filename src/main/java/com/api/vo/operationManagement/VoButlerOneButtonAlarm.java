package com.api.vo.operationManagement;

import java.util.Date;

/**
 * 管家端 一键报警Vo list 回显
 */
public class VoButlerOneButtonAlarm {
    /**
     * 主键id
     */
    private Integer id;
    /**
     * 用户名称
     */
    private String name;
    /**
     * 用户手机号
     */
    private String tel;
    /**
     * 部门名称
     */
    private String organizationName;
    /**
     * 报警时间
     */
    private Date createDate;

    @Override
    public String toString() {
        return "VoButlerOneButtonAlarm{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", tel='" + tel + '\'' +
                ", organizationName='" + organizationName + '\'' +
                ", createDate=" + createDate +
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

    public String getTel() {
        return tel;
    }

    public void setTel(String tel) {
        this.tel = tel;
    }

    public String getOrganizationName() {
        return organizationName;
    }

    public void setOrganizationName(String organizationName) {
        this.organizationName = organizationName;
    }

    public Date getCreateDate() {
        return createDate;
    }

    public void setCreateDate(Date createDate) {
        this.createDate = createDate;
    }

    public VoButlerOneButtonAlarm() {
    }

    public VoButlerOneButtonAlarm(Integer id, String name, String tel, String organizationName, Date createDate) {
        this.id = id;
        this.name = name;
        this.tel = tel;
        this.organizationName = organizationName;
        this.createDate = createDate;
    }
}
