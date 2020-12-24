package com.api.model.chargeManagement;

import java.util.Date;

/**
 * 押金管理 搜索条件
 */
public class SearchDepositManagement {
    /**
     * 当前页数
     */
    private int pageNum;
    /**
     * 每页记录数
     */
    private int size;
    /**
     * 费用名称
     */
    private String chargesTemplateDetailName;
    /**
     * 房屋信息
     */
    private String roomName;
    /**
     * 缴费时间开始
     */
    private Date payDateStart;
    /**
     * 缴费时间结束
     */
    private Date payDateEnd;
    /**
     * 押金人
     */
    private String depositName;
    /**
     * 联系方式
     */
    private String tel;
    /**
     * 来源（1.app,2.线下）
     */
    private Integer froms;
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
    private Integer estateNo;

    @Override
    public String toString() {
        return "SearchDepositManagement{" +
                "pageNum=" + pageNum +
                ", size=" + size +
                ", chargesTemplateDetailName='" + chargesTemplateDetailName + '\'' +
                ", roomName='" + roomName + '\'' +
                ", payDateStart=" + payDateStart +
                ", payDateEnd=" + payDateEnd +
                ", depositName='" + depositName + '\'' +
                ", tel='" + tel + '\'' +
                ", froms=" + froms +
                ", roomNumber='" + roomNumber + '\'' +
                ", unitNo=" + unitNo +
                ", estateNo=" + estateNo +
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

    public String getChargesTemplateDetailName() {
        return chargesTemplateDetailName;
    }

    public void setChargesTemplateDetailName(String chargesTemplateDetailName) {
        this.chargesTemplateDetailName = chargesTemplateDetailName;
    }

    public String getRoomName() {
        return roomName;
    }

    public void setRoomName(String roomName) {
        this.roomName = roomName;
    }

    public Date getPayDateStart() {
        return payDateStart;
    }

    public void setPayDateStart(Date payDateStart) {
        this.payDateStart = payDateStart;
    }

    public Date getPayDateEnd() {
        return payDateEnd;
    }

    public void setPayDateEnd(Date payDateEnd) {
        this.payDateEnd = payDateEnd;
    }

    public String getDepositName() {
        return depositName;
    }

    public void setDepositName(String depositName) {
        this.depositName = depositName;
    }

    public String getTel() {
        return tel;
    }

    public void setTel(String tel) {
        this.tel = tel;
    }

    public Integer getFroms() {
        return froms;
    }

    public void setFroms(Integer froms) {
        this.froms = froms;
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

    public Integer getEstateNo() {
        return estateNo;
    }

    public void setEstateNo(Integer estateNo) {
        this.estateNo = estateNo;
    }

    public SearchDepositManagement() {
    }

    public SearchDepositManagement(int pageNum, int size, String chargesTemplateDetailName, String roomName, Date payDateStart, Date payDateEnd, String depositName, String tel, Integer froms, String roomNumber, Integer unitNo, Integer estateNo) {
        this.pageNum = pageNum;
        this.size = size;
        this.chargesTemplateDetailName = chargesTemplateDetailName;
        this.roomName = roomName;
        this.payDateStart = payDateStart;
        this.payDateEnd = payDateEnd;
        this.depositName = depositName;
        this.tel = tel;
        this.froms = froms;
        this.roomNumber = roomNumber;
        this.unitNo = unitNo;
        this.estateNo = estateNo;
    }
}
