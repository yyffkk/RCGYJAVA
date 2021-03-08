package com.api.model.butlerService;

import java.util.Date;

/**
 * 装修人员表信息
 */
public class UserDecorationPersonnel {
    /**
     * 装修人员主键id
     */
    private Integer id;
    /**
     * 装修信息主键id
     */
    private Integer decorationId;
    /**
     * 装修人员姓名
     */
    private String name;
    /**
     * 身份(1.施工队负责人，2.工人)
     */
    private Integer identity;
    /**
     * 证件类型
     */
    private Integer cardType;
    /**
     * 证件号码
     */
    private String cardCode;
    /**
     * 联系电话
     */
    private String tel;
    /**
     * 联系地址
     */
    private String address;
    /**
     * 创建人（业主，物业，装修公司）
     */
    private Integer createId;
    /**
     * 创建时间
     */
    private Date createDate;
    /**
     * 修改人（业主，物业，装修公司）
     */
    private Integer modifyId;
    /**
     * 修改时间
     */
    private Date modifyDate;

    @Override
    public String toString() {
        return "UserDecorationPersonnel{" +
                "id=" + id +
                ", decorationId=" + decorationId +
                ", name='" + name + '\'' +
                ", identity=" + identity +
                ", cardType=" + cardType +
                ", cardCode='" + cardCode + '\'' +
                ", tel='" + tel + '\'' +
                ", address='" + address + '\'' +
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

    public Integer getDecorationId() {
        return decorationId;
    }

    public void setDecorationId(Integer decorationId) {
        this.decorationId = decorationId;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Integer getIdentity() {
        return identity;
    }

    public void setIdentity(Integer identity) {
        this.identity = identity;
    }

    public Integer getCardType() {
        return cardType;
    }

    public void setCardType(Integer cardType) {
        this.cardType = cardType;
    }

    public String getCardCode() {
        return cardCode;
    }

    public void setCardCode(String cardCode) {
        this.cardCode = cardCode;
    }

    public String getTel() {
        return tel;
    }

    public void setTel(String tel) {
        this.tel = tel;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
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

    public UserDecorationPersonnel() {
    }

    public UserDecorationPersonnel(Integer id, Integer decorationId, String name, Integer identity, Integer cardType, String cardCode, String tel, String address, Integer createId, Date createDate, Integer modifyId, Date modifyDate) {
        this.id = id;
        this.decorationId = decorationId;
        this.name = name;
        this.identity = identity;
        this.cardType = cardType;
        this.cardCode = cardCode;
        this.tel = tel;
        this.address = address;
        this.createId = createId;
        this.createDate = createDate;
        this.modifyId = modifyId;
        this.modifyDate = modifyDate;
    }
}
