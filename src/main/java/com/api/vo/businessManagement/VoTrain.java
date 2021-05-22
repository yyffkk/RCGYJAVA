package com.api.vo.businessManagement;

import java.util.Date;

/**
 * 培训管理Vo list 回显
 */
public class VoTrain {
    /**
     * 培训主键id
     */
    private Integer id;
    /**
     * 部门名称
     */
    private String organizationName;
    /**
     * 姓名
     */
    private String name;
    /**
     * 性别
     */
    private Integer sex;
    /**
     * 手机号
     */
    private String tel;
    /**
     * 培训时间
     */
    private Date trainDate;

    @Override
    public String toString() {
        return "VoTrain{" +
                "id=" + id +
                ", organizationName='" + organizationName + '\'' +
                ", name='" + name + '\'' +
                ", sex=" + sex +
                ", tel='" + tel + '\'' +
                ", trainDate=" + trainDate +
                '}';
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getOrganizationName() {
        return organizationName;
    }

    public void setOrganizationName(String organizationName) {
        this.organizationName = organizationName;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Integer getSex() {
        return sex;
    }

    public void setSex(Integer sex) {
        this.sex = sex;
    }

    public String getTel() {
        return tel;
    }

    public void setTel(String tel) {
        this.tel = tel;
    }

    public Date getTrainDate() {
        return trainDate;
    }

    public void setTrainDate(Date trainDate) {
        this.trainDate = trainDate;
    }

    public VoTrain() {
    }

    public VoTrain(Integer id, String organizationName, String name, Integer sex, String tel, Date trainDate) {
        this.id = id;
        this.organizationName = organizationName;
        this.name = name;
        this.sex = sex;
        this.tel = tel;
        this.trainDate = trainDate;
    }
}
