package com.api.vo.butlerService;

import java.util.Date;

/**
 * 物品出门Vo list
 */
public class VoUserArticleOut {
    /**
     * 主键id
     */
    private Integer id;
    /**
     * 房屋信息
     */
    private String roomName;
    /**
     * 房屋状态
     */
    private Integer estateStatus;
    /**
     * 业主姓名
     */
    private String residentName;
    /**
     * 业主手机号
     */
    private String residentTel;
    /**
     * 物品名称
     */
    private String name;
    /**
     * 物品重量(1. <50kg , 2. 50kg-100kg , 3. >100kg)
     */
    private Integer weight;
    /**
     * 申请人姓名
     */
    private String applicantName;
    /**
     * 申请人手机号
     */
    private String applicantTel;
    /**
     * 搬运方式（1.自己搬运，2.搬家公司）
     */
    private Integer approach;
    /**
     * 预计出门时间
     */
    private Date expectedTime;
    /**
     * 实际出门时间
     */
    private Date actualTime;
    /**
     * 出户出门
     */
    private Integer export;
    /**
     * 状态（待出门，已出门，驳回申请）
     */
    private Integer status;
    /**
     * 备注
     */
    private String remarks;
    /**
     * 房间号
     */
    private String roomNumber;
    /**
     * 单元号
     */
    private Integer unitNo;
    /**
     * 楼栋编号
     */
    private Integer buildingNo;

    @Override
    public String toString() {
        return "VoUserArticleOut{" +
                "id=" + id +
                ", roomName='" + roomName + '\'' +
                ", estateStatus=" + estateStatus +
                ", residentName='" + residentName + '\'' +
                ", residentTel='" + residentTel + '\'' +
                ", name='" + name + '\'' +
                ", weight=" + weight +
                ", applicantName='" + applicantName + '\'' +
                ", applicantTel='" + applicantTel + '\'' +
                ", approach=" + approach +
                ", expectedTime=" + expectedTime +
                ", actualTime=" + actualTime +
                ", export=" + export +
                ", status=" + status +
                ", remarks='" + remarks + '\'' +
                ", roomNumber='" + roomNumber + '\'' +
                ", unitNo=" + unitNo +
                ", buildingNo=" + buildingNo +
                '}';
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getRoomName() {
        return roomName;
    }

    public void setRoomName(String roomName) {
        this.roomName = roomName;
    }

    public Integer getEstateStatus() {
        return estateStatus;
    }

    public void setEstateStatus(Integer estateStatus) {
        this.estateStatus = estateStatus;
    }

    public String getResidentName() {
        return residentName;
    }

    public void setResidentName(String residentName) {
        this.residentName = residentName;
    }

    public String getResidentTel() {
        return residentTel;
    }

    public void setResidentTel(String residentTel) {
        this.residentTel = residentTel;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Integer getWeight() {
        return weight;
    }

    public void setWeight(Integer weight) {
        this.weight = weight;
    }

    public String getApplicantName() {
        return applicantName;
    }

    public void setApplicantName(String applicantName) {
        this.applicantName = applicantName;
    }

    public String getApplicantTel() {
        return applicantTel;
    }

    public void setApplicantTel(String applicantTel) {
        this.applicantTel = applicantTel;
    }

    public Integer getApproach() {
        return approach;
    }

    public void setApproach(Integer approach) {
        this.approach = approach;
    }

    public Date getExpectedTime() {
        return expectedTime;
    }

    public void setExpectedTime(Date expectedTime) {
        this.expectedTime = expectedTime;
    }

    public Date getActualTime() {
        return actualTime;
    }

    public void setActualTime(Date actualTime) {
        this.actualTime = actualTime;
    }

    public Integer getExport() {
        return export;
    }

    public void setExport(Integer export) {
        this.export = export;
    }

    public Integer getStatus() {
        return status;
    }

    public void setStatus(Integer status) {
        this.status = status;
    }

    public String getRemarks() {
        return remarks;
    }

    public void setRemarks(String remarks) {
        this.remarks = remarks;
    }

    public String getRoomNumber() {
        return roomNumber;
    }

    public void setRoomNumber(String roomNumber) {
        this.roomNumber = roomNumber;
    }

    public Integer getUnitNo() {
        return unitNo;
    }

    public void setUnitNo(Integer unitNo) {
        this.unitNo = unitNo;
    }

    public Integer getBuildingNo() {
        return buildingNo;
    }

    public void setBuildingNo(Integer buildingNo) {
        this.buildingNo = buildingNo;
    }

    public VoUserArticleOut() {
    }

    public VoUserArticleOut(Integer id, String roomName, Integer estateStatus, String residentName, String residentTel, String name, Integer weight, String applicantName, String applicantTel, Integer approach, Date expectedTime, Date actualTime, Integer export, Integer status, String remarks, String roomNumber, Integer unitNo, Integer buildingNo) {
        this.id = id;
        this.roomName = roomName;
        this.estateStatus = estateStatus;
        this.residentName = residentName;
        this.residentTel = residentTel;
        this.name = name;
        this.weight = weight;
        this.applicantName = applicantName;
        this.applicantTel = applicantTel;
        this.approach = approach;
        this.expectedTime = expectedTime;
        this.actualTime = actualTime;
        this.export = export;
        this.status = status;
        this.remarks = remarks;
        this.roomNumber = roomNumber;
        this.unitNo = unitNo;
        this.buildingNo = buildingNo;
    }
}
