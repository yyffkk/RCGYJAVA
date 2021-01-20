package com.api.model.butlerService;

import java.util.Date;

/**
 * 便民电话表信息
 */
public class SysConveniencePhone {
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
     * 类型（1.业委会，2.绿化，3.快递，4.搬家）
     */
    private Integer type;
    /**
     * 状态（1.正常，2.有误，3.空号）
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
    /**
     * 提醒内容
     */
    private String remindContent;
    /**
     * 创建人
     */
    private Integer createId;
    /**
     * 创建时间
     */
    private Date createDate;
    /**
     * 修改人
     */
    private Integer modifyId;
    /**
     * 修改时间
     */
    private Date modifyDate;

    @Override
    public String toString() {
        return "SysConveniencePhone{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", tel='" + tel + '\'' +
                ", type=" + type +
                ", status=" + status +
                ", nextControlDate=" + nextControlDate +
                ", checkStatus=" + checkStatus +
                ", weight=" + weight +
                ", remindContent='" + remindContent + '\'' +
                ", createId=" + createId +
                ", createDate=" + createDate +
                ", modifyId=" + modifyId +
                ", modifyDate=" + modifyDate +
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

    public Integer getType() {
        return type;
    }

    public void setType(Integer type) {
        this.type = type;
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

    public String getRemindContent() {
        return remindContent;
    }

    public void setRemindContent(String remindContent) {
        this.remindContent = remindContent;
    }

    public Integer getCreateId() {
        return createId;
    }

    public void setCreateId(Integer createId) {
        this.createId = createId;
    }

    public Date getCreateDate() {
        return createDate;
    }

    public void setCreateDate(Date createDate) {
        this.createDate = createDate;
    }

    public Integer getModifyId() {
        return modifyId;
    }

    public void setModifyId(Integer modifyId) {
        this.modifyId = modifyId;
    }

    public Date getModifyDate() {
        return modifyDate;
    }

    public void setModifyDate(Date modifyDate) {
        this.modifyDate = modifyDate;
    }

    public SysConveniencePhone() {
    }

    public SysConveniencePhone(Integer id, String name, String tel, Integer type, Integer status, Date nextControlDate, Integer checkStatus, Integer weight, String remindContent, Integer createId, Date createDate, Integer modifyId, Date modifyDate) {
        this.id = id;
        this.name = name;
        this.tel = tel;
        this.type = type;
        this.status = status;
        this.nextControlDate = nextControlDate;
        this.checkStatus = checkStatus;
        this.weight = weight;
        this.remindContent = remindContent;
        this.createId = createId;
        this.createDate = createDate;
        this.modifyId = modifyId;
        this.modifyDate = modifyDate;
    }
}
