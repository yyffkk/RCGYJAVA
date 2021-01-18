package com.api.vo.butlerService;

import java.util.Date;

/**
 * 便民电话 Vo 回显 list
 */
public class VoConveniencePhone {
    /**
     * 便民电话主键id
     */
    private Integer id;
    /**
     * 名称
     */
    private String name;
    /**
     * 联系方式
     */
    private String tel;
    /**
     * 状态
     */
    private Integer status;
    /**
     * 下次检查时间
     */
    private Date nextControlDate;
    /**
     * 检查状态(0.未检查，1.已检查)
     */
    private Integer checkStatus;
    /**
     * 权重
     */
    private Integer weight;

    @Override
    public String toString() {
        return "VoConveniencePhone{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", tel='" + tel + '\'' +
                ", status=" + status +
                ", nextControlDate=" + nextControlDate +
                ", checkStatus=" + checkStatus +
                ", weight=" + weight +
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

    public Integer getStatus() {
        return status;
    }

    public void setStatus(Integer status) {
        this.status = status;
    }

    public Date getNextControlDate() {
        return nextControlDate;
    }

    public void setNextControlDate(Date nextControlDate) {
        this.nextControlDate = nextControlDate;
    }

    public Integer getCheckStatus() {
        return checkStatus;
    }

    public void setCheckStatus(Integer checkStatus) {
        this.checkStatus = checkStatus;
    }

    public Integer getWeight() {
        return weight;
    }

    public void setWeight(Integer weight) {
        this.weight = weight;
    }

    public VoConveniencePhone() {
    }

    public VoConveniencePhone(Integer id, String name, String tel, Integer status, Date nextControlDate, Integer checkStatus, Integer weight) {
        this.id = id;
        this.name = name;
        this.tel = tel;
        this.status = status;
        this.nextControlDate = nextControlDate;
        this.checkStatus = checkStatus;
        this.weight = weight;
    }
}
