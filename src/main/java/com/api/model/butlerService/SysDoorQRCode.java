package com.api.model.butlerService;

import java.util.Date;

/**
 * 门禁二维码 model
 */
public class SysDoorQRCode {
    /**
     * 门禁二维码主键id
     */
    private Integer id;
    /**
     * 房产主键id
     */
    private Integer estateId;
    /**
     * 用户姓名
     */
    private String name;
    /**
     * 手机号
     */
    private String tel;
    /**
     * 身份证号
     */
    private String idCard;
    /**
     * 生效时间
     */
    private Date startTime;
    /**
     * 失效时间
     */
    private Date endTime;
    /**
     * 创建人id
     */
    private Integer createId;
    /**
     * 创建时间
     */
    private Date createDate;

    @Override
    public String toString() {
        return "SysDoorQRCode{" +
                "id=" + id +
                ", estateId=" + estateId +
                ", name='" + name + '\'' +
                ", tel='" + tel + '\'' +
                ", idCard='" + idCard + '\'' +
                ", startTime=" + startTime +
                ", endTime=" + endTime +
                ", createId=" + createId +
                ", createDate=" + createDate +
                '}';
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Integer getEstateId() {
        return estateId;
    }

    public void setEstateId(Integer estateId) {
        this.estateId = estateId;
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

    public String getIdCard() {
        return idCard;
    }

    public void setIdCard(String idCard) {
        this.idCard = idCard;
    }

    public Date getStartTime() {
        return startTime;
    }

    public void setStartTime(Date startTime) {
        this.startTime = startTime;
    }

    public Date getEndTime() {
        return endTime;
    }

    public void setEndTime(Date endTime) {
        this.endTime = endTime;
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

    public SysDoorQRCode() {
    }

    public SysDoorQRCode(Integer id, Integer estateId, String name, String tel, String idCard, Date startTime, Date endTime, Integer createId, Date createDate) {
        this.id = id;
        this.estateId = estateId;
        this.name = name;
        this.tel = tel;
        this.idCard = idCard;
        this.startTime = startTime;
        this.endTime = endTime;
        this.createId = createId;
        this.createDate = createDate;
    }
}
