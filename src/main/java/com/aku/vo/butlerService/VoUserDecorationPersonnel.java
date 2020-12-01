package com.aku.vo.butlerService;

/**
 * 装修人员情况 Vo list
 */
public class VoUserDecorationPersonnel {
    /**
     * 主键id
     */
    private Integer id;
    /**
     * 姓名
     */
    private String name;
    /**
     * 身份
     */
    private Integer identity;
    /**
     * 证件类型
     */
    private Integer cardType;
    /**
     * 证件号
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

    @Override
    public String toString() {
        return "VoUserDecorationPersonnel{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", identity=" + identity +
                ", cardType=" + cardType +
                ", cardCode='" + cardCode + '\'' +
                ", tel='" + tel + '\'' +
                ", address='" + address + '\'' +
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

    public VoUserDecorationPersonnel() {
    }

    public VoUserDecorationPersonnel(Integer id, String name, Integer identity, Integer cardType, String cardCode, String tel, String address) {
        this.id = id;
        this.name = name;
        this.identity = identity;
        this.cardType = cardType;
        this.cardCode = cardCode;
        this.tel = tel;
        this.address = address;
    }
}
