package com.api.model.app;

import java.util.Arrays;
import java.util.Date;

/**
 * 访客邀请提交信息(H5提交model)
 */
public class AppUserVisitorsInviteSubmit {
    /**
     * 访客邀请主键id
     */
    private Integer id;
    /**
     * 拜访房产id
     */
    private Integer estateId;
    /**
     * 访客连接编号
     */
    private String code;
    /**
     * 访客姓名
     */
    private String name;
    /**
     * 访客手机号
     */
    private String tel;
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
     * 同行（xin）人数【访客数量】
     */
    private Integer peers;
    /**
     * 访客自拍照片
     */
    private String[] imgList;
    /**
     * 状态：1.已分享，2.已提交
     */
    private Integer status;

    @Override
    public String toString() {
        return "AppUserVisitorsInviteSubmit{" +
                "id=" + id +
                ", estateId=" + estateId +
                ", code='" + code + '\'' +
                ", name='" + name + '\'' +
                ", tel='" + tel + '\'' +
                ", sex=" + sex +
                ", carNumber='" + carNumber + '\'' +
                ", visitDateStart=" + visitDateStart +
                ", visitDateEnd=" + visitDateEnd +
                ", peers=" + peers +
                ", imgList=" + Arrays.toString(imgList) +
                ", status=" + status +
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

    public String getCode() {
        return code;
    }

    public void setCode(String code) {
        this.code = code;
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

    public Integer getPeers() {
        return peers;
    }

    public void setPeers(Integer peers) {
        this.peers = peers;
    }

    public String[] getImgList() {
        return imgList;
    }

    public void setImgList(String[] imgList) {
        this.imgList = imgList;
    }

    public Integer getStatus() {
        return status;
    }

    public void setStatus(Integer status) {
        this.status = status;
    }

    public AppUserVisitorsInviteSubmit() {
    }

    public AppUserVisitorsInviteSubmit(Integer id, Integer estateId, String code, String name, String tel, Integer sex, String carNumber, Date visitDateStart, Date visitDateEnd, Integer peers, String[] imgList, Integer status) {
        this.id = id;
        this.estateId = estateId;
        this.code = code;
        this.name = name;
        this.tel = tel;
        this.sex = sex;
        this.carNumber = carNumber;
        this.visitDateStart = visitDateStart;
        this.visitDateEnd = visitDateEnd;
        this.peers = peers;
        this.imgList = imgList;
        this.status = status;
    }
}
