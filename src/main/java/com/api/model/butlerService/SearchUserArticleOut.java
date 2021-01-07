package com.api.model.butlerService;

import java.util.Date;

/**
 * 物品出门搜索条件
 */
public class SearchUserArticleOut {
    /**
     * 当前页数
     */
    private int pageNum;
    /**
     * 每页记录数
     */
    private int size;
    /**
     * 房屋信息
     */
    private String roomName;
    /**
     * 出户出门
     */
    private Integer export;
    /**
     * 申请人姓名
     */
    private String applicantName;
    /**
     * 申请人手机号
     */
    private String applicantTel;
    /**
     * 实际出门时间开始
     */
    private Date actualTimeStart;
    /**
     * 实际出门时间结束
     */
    private Date actualTimeEnd;
    /**
     * 物品名称
     */
    private String name;
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
    /**
     * 状态(1.待出门，2.已出门，3.驳回申请)
     */
    private Integer status;

    @Override
    public String toString() {
        return "SearchUserArticleOut{" +
                "pageNum=" + pageNum +
                ", size=" + size +
                ", roomName='" + roomName + '\'' +
                ", export=" + export +
                ", applicantName='" + applicantName + '\'' +
                ", applicantTel='" + applicantTel + '\'' +
                ", actualTimeStart=" + actualTimeStart +
                ", actualTimeEnd=" + actualTimeEnd +
                ", name='" + name + '\'' +
                ", roomNumber='" + roomNumber + '\'' +
                ", unitNo=" + unitNo +
                ", buildingNo=" + buildingNo +
                ", status=" + status +
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

    public String getRoomName() {
        return roomName;
    }

    public void setRoomName(String roomName) {
        this.roomName = roomName;
    }

    public Integer getExport() {
        return export;
    }

    public void setExport(Integer export) {
        this.export = export;
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

    public Date getActualTimeStart() {
        return actualTimeStart;
    }

    public void setActualTimeStart(Date actualTimeStart) {
        this.actualTimeStart = actualTimeStart;
    }

    public Date getActualTimeEnd() {
        return actualTimeEnd;
    }

    public void setActualTimeEnd(Date actualTimeEnd) {
        this.actualTimeEnd = actualTimeEnd;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
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

    public Integer getStatus() {
        return status;
    }

    public void setStatus(Integer status) {
        this.status = status;
    }

    public SearchUserArticleOut() {
    }

    public SearchUserArticleOut(int pageNum, int size, String roomName, Integer export, String applicantName, String applicantTel, Date actualTimeStart, Date actualTimeEnd, String name, String roomNumber, Integer unitNo, Integer buildingNo, Integer status) {
        this.pageNum = pageNum;
        this.size = size;
        this.roomName = roomName;
        this.export = export;
        this.applicantName = applicantName;
        this.applicantTel = applicantTel;
        this.actualTimeStart = actualTimeStart;
        this.actualTimeEnd = actualTimeEnd;
        this.name = name;
        this.roomNumber = roomNumber;
        this.unitNo = unitNo;
        this.buildingNo = buildingNo;
        this.status = status;
    }
}
