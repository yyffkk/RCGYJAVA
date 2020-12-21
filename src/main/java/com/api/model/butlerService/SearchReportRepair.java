package com.api.model.butlerService;

import java.util.Date;

/**
 * 报事报修搜索条件
 */
public class SearchReportRepair {
    /**
     * 当前页数
     */
    private int pageNum;
    /**
     * 每页记录数
     */
    private int size;
    /**
     * 报修单号
     */
    private String code;
    /**
     * 报修人
     */
    private String repairman;
    /**
     * 房屋信息
     */
    private String roomName;
    /**
     * 报修来源
     */
    private Integer froms;
    /**
     * 分配人
     */
    private Integer distributor;
    /**
     * 维修人
     */
    private Integer operator;
    /**
     * 报修时间开始
     */
    private Date repairDateStart;
    /**
     * 报修时间结束
     */
    private Date repairDateEnd;
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
        return "SearchReportRepair{" +
                "pageNum=" + pageNum +
                ", size=" + size +
                ", code='" + code + '\'' +
                ", repairman='" + repairman + '\'' +
                ", roomName='" + roomName + '\'' +
                ", froms=" + froms +
                ", distributor=" + distributor +
                ", operator=" + operator +
                ", repairDateStart=" + repairDateStart +
                ", repairDateEnd=" + repairDateEnd +
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

    public String getCode() {
        return code;
    }

    public void setCode(String code) {
        this.code = code;
    }

    public String getRepairman() {
        return repairman;
    }

    public void setRepairman(String repairman) {
        this.repairman = repairman;
    }

    public String getRoomName() {
        return roomName;
    }

    public void setRoomName(String roomName) {
        this.roomName = roomName;
    }

    public Integer getFroms() {
        return froms;
    }

    public void setFroms(Integer froms) {
        this.froms = froms;
    }

    public Integer getDistributor() {
        return distributor;
    }

    public void setDistributor(Integer distributor) {
        this.distributor = distributor;
    }

    public Integer getOperator() {
        return operator;
    }

    public void setOperator(Integer operator) {
        this.operator = operator;
    }

    public Date getRepairDateStart() {
        return repairDateStart;
    }

    public void setRepairDateStart(Date repairDateStart) {
        this.repairDateStart = repairDateStart;
    }

    public Date getRepairDateEnd() {
        return repairDateEnd;
    }

    public void setRepairDateEnd(Date repairDateEnd) {
        this.repairDateEnd = repairDateEnd;
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

    public SearchReportRepair() {
    }

    public SearchReportRepair(int pageNum, int size, String code, String repairman, String roomName, Integer froms, Integer distributor, Integer operator, Date repairDateStart, Date repairDateEnd, String roomNumber, Integer unitNo, Integer estateNo) {
        this.pageNum = pageNum;
        this.size = size;
        this.code = code;
        this.repairman = repairman;
        this.roomName = roomName;
        this.froms = froms;
        this.distributor = distributor;
        this.operator = operator;
        this.repairDateStart = repairDateStart;
        this.repairDateEnd = repairDateEnd;
        this.roomNumber = roomNumber;
        this.unitNo = unitNo;
        this.estateNo = estateNo;
    }
}
