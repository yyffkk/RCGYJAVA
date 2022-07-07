package com.api.vo.app;

import java.util.Date;

/**
 * app 包裹代收确认领取 条件
 */
public class AppConfirmCollection {
    /**
     * 包裹代收主键Id
     */
    private Integer packageCollectionId;
    /**
     * 用户手机号
     */
    private String tel;
    /**
     * 包裹领取时间
     */
    private Date receiveDate;

    @Override
    public String toString() {
        return "AppConfirmCollection{" +
                "packageCollectionId=" + packageCollectionId +
                ", tel='" + tel + '\'' +
                ", receiveDate=" + receiveDate +
                '}';
    }

    public Integer getPackageCollectionId() {
        return packageCollectionId;
    }

    public void setPackageCollectionId(Integer packageCollectionId) {
        this.packageCollectionId = packageCollectionId;
    }

    public String getTel() {
        return tel;
    }

    public void setTel(String tel) {
        this.tel = tel;
    }

    public Date getReceiveDate() {
        return receiveDate;
    }

    public void setReceiveDate(Date receiveDate) {
        this.receiveDate = receiveDate;
    }

    public AppConfirmCollection() {
    }

    public AppConfirmCollection(Integer packageCollectionId, String tel, Date receiveDate) {
        this.packageCollectionId = packageCollectionId;
        this.tel = tel;
        this.receiveDate = receiveDate;
    }
}
