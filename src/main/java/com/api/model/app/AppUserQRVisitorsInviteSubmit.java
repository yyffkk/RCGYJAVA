package com.api.model.app;

import java.util.Arrays;
import java.util.Date;

/**
 * 访客邀请提交信息QR(扫码二维码后，H5提交model)
 */
public class AppUserQRVisitorsInviteSubmit {
    /**
     * 主键id
     */
    private Integer id;
    /**
     * 访客姓名
     */
    private String name;
    /**
     * 访客性别，1.男，2.女
     */
    private Integer sex;
    /**
     * 访客车牌号（选填）
     */
    private String carNumber;
    /**
     * 预计到访时间开始
     */
    private Date visitDateStart;
    /**
     * 预计到访时间结束
     */
    private Date visitDateEnd;
    /**
     * 访客自拍照片
     */
    private String[] imgList;
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
        return "AppUserQRVisitorsInviteSubmit{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", sex=" + sex +
                ", carNumber='" + carNumber + '\'' +
                ", visitDateStart=" + visitDateStart +
                ", visitDateEnd=" + visitDateEnd +
                ", imgList=" + Arrays.toString(imgList) +
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

    public String getCarNumber() {
        return carNumber;
    }

    public void setCarNumber(String carNumber) {
        this.carNumber = carNumber;
    }

    public Date getVisitDateStart() {
        return visitDateStart;
    }

    public void setVisitDateStart(Date visitDateStart) {
        this.visitDateStart = visitDateStart;
    }

    public Date getVisitDateEnd() {
        return visitDateEnd;
    }

    public void setVisitDateEnd(Date visitDateEnd) {
        this.visitDateEnd = visitDateEnd;
    }

    public String[] getImgList() {
        return imgList;
    }

    public void setImgList(String[] imgList) {
        this.imgList = imgList;
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

    public AppUserQRVisitorsInviteSubmit() {
    }

    public AppUserQRVisitorsInviteSubmit(Integer id, String name, Integer sex, String carNumber, Date visitDateStart, Date visitDateEnd, String[] imgList, Integer createId, Date createDate) {
        this.id = id;
        this.name = name;
        this.sex = sex;
        this.carNumber = carNumber;
        this.visitDateStart = visitDateStart;
        this.visitDateEnd = visitDateEnd;
        this.imgList = imgList;
        this.createId = createId;
        this.createDate = createDate;
    }
}
