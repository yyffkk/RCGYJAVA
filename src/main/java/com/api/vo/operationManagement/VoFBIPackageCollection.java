package com.api.vo.operationManagement;

import java.util.Date;

/**
 * 包裹代收 Vo findById 回显
 */
public class VoFBIPackageCollection {
    /**
     * 包裹代收主键id
     */
    private Integer id;
    /**
     * 包裹单号
     */
    private String code;
    /**
     * 收件人名称
     */
    private String addresseeName;
    /**
     * 收件人联系方式
     */
    private String addresseeTel;
    /**
     * 收件人地址
     */
    private String address;
    /**
     * 放置位置
     */
    private String placePosition;
    /**
     * 状态 ，1.未领取，2.已领取
     */
    private Integer status;
    /**
     * 包裹领取时间
     */
    private Date receiveDate;

    @Override
    public String toString() {
        return "VoFBIPackageCollection{" +
                "id=" + id +
                ", code='" + code + '\'' +
                ", addresseeName='" + addresseeName + '\'' +
                ", addresseeTel='" + addresseeTel + '\'' +
                ", address='" + address + '\'' +
                ", placePosition='" + placePosition + '\'' +
                ", status=" + status +
                ", receiveDate=" + receiveDate +
                '}';
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getCode() {
        return code;
    }

    public void setCode(String code) {
        this.code = code;
    }

    public String getAddresseeName() {
        return addresseeName;
    }

    public void setAddresseeName(String addresseeName) {
        this.addresseeName = addresseeName;
    }

    public String getAddresseeTel() {
        return addresseeTel;
    }

    public void setAddresseeTel(String addresseeTel) {
        this.addresseeTel = addresseeTel;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public String getPlacePosition() {
        return placePosition;
    }

    public void setPlacePosition(String placePosition) {
        this.placePosition = placePosition;
    }

    public Integer getStatus() {
        return status;
    }

    public void setStatus(Integer status) {
        this.status = status;
    }

    public Date getReceiveDate() {
        return receiveDate;
    }

    public void setReceiveDate(Date receiveDate) {
        this.receiveDate = receiveDate;
    }

    public VoFBIPackageCollection() {
    }

    public VoFBIPackageCollection(Integer id, String code, String addresseeName, String addresseeTel, String address, String placePosition, Integer status, Date receiveDate) {
        this.id = id;
        this.code = code;
        this.addresseeName = addresseeName;
        this.addresseeTel = addresseeTel;
        this.address = address;
        this.placePosition = placePosition;
        this.status = status;
        this.receiveDate = receiveDate;
    }
}
