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
     * 拜访房产id
     */
    private Integer estateId;
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
     * 状态：1.已分享，2.已提交
     */
    private Integer status;
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
    /**
     * 身份证号
     */
    private String idNumber;
    /**
     * 身份证正面上传路径
     */
    private String[] idCardFrontImgList;
    /**
     * 身份证背面上传路径
     */
    private String[] idCardBackImgList;


    @Override
    public String toString() {
        return "AppUserQRVisitorsInviteSubmit{" +
                "id=" + id +
                ", estateId=" + estateId +
                ", name='" + name + '\'' +
                ", tel='" + tel + '\'' +
                ", sex=" + sex +
                ", carNumber='" + carNumber + '\'' +
                ", visitDateStart=" + visitDateStart +
                ", visitDateEnd=" + visitDateEnd +
                ", peers=" + peers +
                ", status=" + status +
                ", imgList=" + Arrays.toString(imgList) +
                ", createId=" + createId +
                ", createDate=" + createDate +
                ", idNumber='" + idNumber + '\'' +
                ", idCardFrontImgList=" + Arrays.toString(idCardFrontImgList) +
                ", idCardBackImgList=" + Arrays.toString(idCardBackImgList) +
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

    public Integer getStatus() {
        return status;
    }

    public void setStatus(Integer status) {
        this.status = status;
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

    public String getIdNumber() {
        return idNumber;
    }

    public void setIdNumber(String idNumber) {
        this.idNumber = idNumber;
    }

    public String[] getIdCardFrontImgList() {
        return idCardFrontImgList;
    }

    public void setIdCardFrontImgList(String[] idCardFrontImgList) {
        this.idCardFrontImgList = idCardFrontImgList;
    }

    public String[] getIdCardBackImgList() {
        return idCardBackImgList;
    }

    public void setIdCardBackImgList(String[] idCardBackImgList) {
        this.idCardBackImgList = idCardBackImgList;
    }

    public AppUserQRVisitorsInviteSubmit() {
    }

    public AppUserQRVisitorsInviteSubmit(Integer id, Integer estateId, String name, String tel, Integer sex, String carNumber, Date visitDateStart, Date visitDateEnd, Integer peers, Integer status, String[] imgList, Integer createId, Date createDate, String idNumber, String[] idCardFrontImgList, String[] idCardBackImgList) {
        this.id = id;
        this.estateId = estateId;
        this.name = name;
        this.tel = tel;
        this.sex = sex;
        this.carNumber = carNumber;
        this.visitDateStart = visitDateStart;
        this.visitDateEnd = visitDateEnd;
        this.peers = peers;
        this.status = status;
        this.imgList = imgList;
        this.createId = createId;
        this.createDate = createDate;
        this.idNumber = idNumber;
        this.idCardFrontImgList = idCardFrontImgList;
        this.idCardBackImgList = idCardBackImgList;
    }
}
