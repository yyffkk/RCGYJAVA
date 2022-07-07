package com.api.vo.operationManagement;

import java.util.Date;

/**
 * 活动报名记录 回显
 */
public class VoActivityRegistration {
    /**
     * 主键id
     */
    private Integer id;
    /**
     * 活动标题
     */
    private String title;
    /**
     * 报名人姓名
     */
    private String residentName;
    /**
     * 报名人联系方式
     */
    private String residentTel;
    /**
     * 报名时间
     */
    private Date registrationDate;

    @Override
    public String toString() {
        return "VoActivityRegistration{" +
                "id=" + id +
                ", title='" + title + '\'' +
                ", residentName='" + residentName + '\'' +
                ", residentTel='" + residentTel + '\'' +
                ", registrationDate=" + registrationDate +
                '}';
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getResidentName() {
        return residentName;
    }

    public void setResidentName(String residentName) {
        this.residentName = residentName;
    }

    public String getResidentTel() {
        return residentTel;
    }

    public void setResidentTel(String residentTel) {
        this.residentTel = residentTel;
    }

    public Date getRegistrationDate() {
        return registrationDate;
    }

    public void setRegistrationDate(Date registrationDate) {
        this.registrationDate = registrationDate;
    }

    public VoActivityRegistration() {
    }

    public VoActivityRegistration(Integer id, String title, String residentName, String residentTel, Date registrationDate) {
        this.id = id;
        this.title = title;
        this.residentName = residentName;
        this.residentTel = residentTel;
        this.registrationDate = registrationDate;
    }
}
