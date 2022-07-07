package com.api.model.app;

import java.util.Date;

/**
 * 用户注册信息
 */
public class UserRegister {
    /**
     * 房产id
     */
    private Integer estateId;
    /**
     * 住户类型（1业主，2亲属，3租客）
     */
    private Integer type;
    /**
     * 昵称
     */
    private String nickName;
    /**
     * 住户名称
     */
    private String name;
    /**
     * 联系电话
     */
    private String tel;
    /**
     * 证件类型（1身份证，2营业执照，3.军人证）
     */
    private Integer idType;
    /**
     * 证件号码
     */
    private String idNumber;
    /**
     * 创建人
     */
    private Integer createId;
    /**
     * 创建时间
     */
    private Date createDate;

    @Override
    public String toString() {
        return "UserRegister{" +
                "estateId=" + estateId +
                ", type=" + type +
                ", nickName='" + nickName + '\'' +
                ", name='" + name + '\'' +
                ", tel='" + tel + '\'' +
                ", idType=" + idType +
                ", idNumber='" + idNumber + '\'' +
                ", createId=" + createId +
                ", createDate=" + createDate +
                '}';
    }

    public Integer getEstateId() {
        return estateId;
    }

    public void setEstateId(Integer estateId) {
        this.estateId = estateId;
    }

    public Integer getType() {
        return type;
    }

    public void setType(Integer type) {
        this.type = type;
    }

    public String getNickName() {
        return nickName;
    }

    public void setNickName(String nickName) {
        this.nickName = nickName;
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

    public Integer getIdType() {
        return idType;
    }

    public void setIdType(Integer idType) {
        this.idType = idType;
    }

    public String getIdNumber() {
        return idNumber;
    }

    public void setIdNumber(String idNumber) {
        this.idNumber = idNumber;
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

    public UserRegister() {
    }

    public UserRegister(Integer estateId, Integer type, String nickName, String name, String tel, Integer idType, String idNumber, Integer createId, Date createDate) {
        this.estateId = estateId;
        this.type = type;
        this.nickName = nickName;
        this.name = name;
        this.tel = tel;
        this.idType = idType;
        this.idNumber = idNumber;
        this.createId = createId;
        this.createDate = createDate;
    }
}
