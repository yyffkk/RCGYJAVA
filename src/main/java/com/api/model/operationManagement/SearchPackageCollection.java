package com.api.model.operationManagement;

import java.util.Date;

/**
 * 包裹代收搜索条件
 */
public class SearchPackageCollection {
    /**
     * 当前页数
     */
    private int pageNum;
    /**
     * 每页记录数
     */
    private int size;
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
     * 状态 ,1.未领取，2.已领取
     */
    private Integer status;
    /**
     * 送达时间开始
     */
    private Date createDateStart;
    /**
     * 送达时间结束
     */
    private Date createDateEnd;

    @Override
    public String toString() {
        return "SearchPackageCollection{" +
                "pageNum=" + pageNum +
                ", size=" + size +
                ", code='" + code + '\'' +
                ", addresseeName='" + addresseeName + '\'' +
                ", addresseeTel='" + addresseeTel + '\'' +
                ", address='" + address + '\'' +
                ", status=" + status +
                ", createDateStart=" + createDateStart +
                ", createDateEnd=" + createDateEnd +
                '}';
    }

    public int getPageNum() {
        return pageNum;
    }

    public void setPageNum(int pageNum) {
        this.pageNum = pageNum;
    }

    public int getSize() {
        return size;
    }

    public void setSize(int size) {
        this.size = size;
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

    public Integer getStatus() {
        return status;
    }

    public void setStatus(Integer status) {
        this.status = status;
    }

    public Date getCreateDateStart() {
        return createDateStart;
    }

    public void setCreateDateStart(Date createDateStart) {
        this.createDateStart = createDateStart;
    }

    public Date getCreateDateEnd() {
        return createDateEnd;
    }

    public void setCreateDateEnd(Date createDateEnd) {
        this.createDateEnd = createDateEnd;
    }

    public SearchPackageCollection() {
    }

    public SearchPackageCollection(int pageNum, int size, String code, String addresseeName, String addresseeTel, String address, Integer status, Date createDateStart, Date createDateEnd) {
        this.pageNum = pageNum;
        this.size = size;
        this.code = code;
        this.addresseeName = addresseeName;
        this.addresseeTel = addresseeTel;
        this.address = address;
        this.status = status;
        this.createDateStart = createDateStart;
        this.createDateEnd = createDateEnd;
    }
}
