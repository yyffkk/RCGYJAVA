package com.aku.model.butlerService;

import java.util.Date;

/**
 * 装修管理 搜索条件
 */
public class SearchUserDecoration {
    /**
     * 当前页数
     */
    private Integer pageNum;
    /**
     * 每页记录数
     */
    private Integer size;
    /**
     * 房屋信息
     */
    private String roomName;
    /**
     * 业主姓名
     */
    private String residentName;
    /**
     * 业主联系方式
     */
    private String residentTel;
    /**
     * 预计开始时间
     */
    private Date expected_begin;
    /**
     * 预计结束时间
     */
    private Date expected_end;
    /**
     * 紧急联系人
     */
    private String emergencyContact;
    /**
     * 紧急联系方式
     */
    private String tel;
    /**
     * 实际开始时间
     */
    private Date actual_begin;
    /**
     * 时间结束时间
     */
    private Date actual_end;
    /**
     * 审批结果
     */
    private Integer approveResults;
    /**
     * 审批人
     */
    private String approveName;
    /**
     * 施工单位
     */
    private String constructionUnit;
    /**
     * 施工负责人
     */
    private String constructionName;
    /**
     * 施工联系方式
     */
    private String constructionTel;
    /**
     * 最后一次完工检查情况
     */
    private Integer isQualified;
    /**
     * 楼栋编号
     */
    private Integer buildingNo;
    /**
     * 单元号
     */
    private Integer unitNo;
    /**
     * 房间号
     */
    private String roomNumber;

    @Override
    public String toString() {
        return "SearchUserDecoration{" +
                "pageNum=" + pageNum +
                ", size=" + size +
                ", roomName='" + roomName + '\'' +
                ", residentName='" + residentName + '\'' +
                ", residentTel='" + residentTel + '\'' +
                ", expected_begin=" + expected_begin +
                ", expected_end=" + expected_end +
                ", emergencyContact='" + emergencyContact + '\'' +
                ", tel='" + tel + '\'' +
                ", actual_begin=" + actual_begin +
                ", actual_end=" + actual_end +
                ", approveResults=" + approveResults +
                ", approveName='" + approveName + '\'' +
                ", constructionUnit='" + constructionUnit + '\'' +
                ", constructionName='" + constructionName + '\'' +
                ", constructionTel='" + constructionTel + '\'' +
                ", isQualified=" + isQualified +
                ", buildingNo=" + buildingNo +
                ", unitNo=" + unitNo +
                ", roomNumber='" + roomNumber + '\'' +
                '}';
    }

    public Integer getPageNum() {
        return pageNum;
    }

    public void setPageNum(Integer pageNum) {
        this.pageNum = pageNum;
    }

    public Integer getSize() {
        return size;
    }

    public void setSize(Integer size) {
        this.size = size;
    }

    public String getRoomName() {
        return roomName;
    }

    public void setRoomName(String roomName) {
        this.roomName = roomName;
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

    public Date getExpected_begin() {
        return expected_begin;
    }

    public void setExpected_begin(Date expected_begin) {
        this.expected_begin = expected_begin;
    }

    public Date getExpected_end() {
        return expected_end;
    }

    public void setExpected_end(Date expected_end) {
        this.expected_end = expected_end;
    }

    public String getEmergencyContact() {
        return emergencyContact;
    }

    public void setEmergencyContact(String emergencyContact) {
        this.emergencyContact = emergencyContact;
    }

    public String getTel() {
        return tel;
    }

    public void setTel(String tel) {
        this.tel = tel;
    }

    public Date getActual_begin() {
        return actual_begin;
    }

    public void setActual_begin(Date actual_begin) {
        this.actual_begin = actual_begin;
    }

    public Date getActual_end() {
        return actual_end;
    }

    public void setActual_end(Date actual_end) {
        this.actual_end = actual_end;
    }

    public Integer getApproveResults() {
        return approveResults;
    }

    public void setApproveResults(Integer approveResults) {
        this.approveResults = approveResults;
    }

    public String getApproveName() {
        return approveName;
    }

    public void setApproveName(String approveName) {
        this.approveName = approveName;
    }

    public String getConstructionUnit() {
        return constructionUnit;
    }

    public void setConstructionUnit(String constructionUnit) {
        this.constructionUnit = constructionUnit;
    }

    public String getConstructionName() {
        return constructionName;
    }

    public void setConstructionName(String constructionName) {
        this.constructionName = constructionName;
    }

    public String getConstructionTel() {
        return constructionTel;
    }

    public void setConstructionTel(String constructionTel) {
        this.constructionTel = constructionTel;
    }

    public Integer getIsQualified() {
        return isQualified;
    }

    public void setIsQualified(Integer isQualified) {
        this.isQualified = isQualified;
    }

    public Integer getBuildingNo() {
        return buildingNo;
    }

    public void setBuildingNo(Integer buildingNo) {
        this.buildingNo = buildingNo;
    }

    public Integer getUnitNo() {
        return unitNo;
    }

    public void setUnitNo(Integer unitNo) {
        this.unitNo = unitNo;
    }

    public String getRoomNumber() {
        return roomNumber;
    }

    public void setRoomNumber(String roomNumber) {
        this.roomNumber = roomNumber;
    }

    public SearchUserDecoration() {
    }

    public SearchUserDecoration(Integer pageNum, Integer size, String roomName, String residentName, String residentTel, Date expected_begin, Date expected_end, String emergencyContact, String tel, Date actual_begin, Date actual_end, Integer approveResults, String approveName, String constructionUnit, String constructionName, String constructionTel, Integer isQualified, Integer buildingNo, Integer unitNo, String roomNumber) {
        this.pageNum = pageNum;
        this.size = size;
        this.roomName = roomName;
        this.residentName = residentName;
        this.residentTel = residentTel;
        this.expected_begin = expected_begin;
        this.expected_end = expected_end;
        this.emergencyContact = emergencyContact;
        this.tel = tel;
        this.actual_begin = actual_begin;
        this.actual_end = actual_end;
        this.approveResults = approveResults;
        this.approveName = approveName;
        this.constructionUnit = constructionUnit;
        this.constructionName = constructionName;
        this.constructionTel = constructionTel;
        this.isQualified = isQualified;
        this.buildingNo = buildingNo;
        this.unitNo = unitNo;
        this.roomNumber = roomNumber;
    }
}
