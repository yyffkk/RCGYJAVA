package com.api.model.chargeManagement;

/**
 * 预缴搜索条件
 */
public class SearchAdvancePayment {
    /**
     * 当前页数
     */
    private int pageNum;
    /**
     * 每页记录数
     */
    private int size;
    /**
     * 房屋名称
     */
    private String roomName;
    /**
     * 住户名称
     */
    private String residentName;
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
        return "SearchAdvancePayment{" +
                "pageNum=" + pageNum +
                ", size=" + size +
                ", roomName='" + roomName + '\'' +
                ", residentName='" + residentName + '\'' +
                ", roomNumber='" + roomNumber + '\'' +
                ", unitNo=" + unitNo +
                ", buildingNo=" + buildingNo +
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

    public String getResidentName() {
        return residentName;
    }

    public void setResidentName(String residentName) {
        this.residentName = residentName;
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

    public SearchAdvancePayment() {
    }

    public SearchAdvancePayment(int pageNum, int size, String roomName, String residentName, String roomNumber, Integer unitNo, Integer buildingNo) {
        this.pageNum = pageNum;
        this.size = size;
        this.roomName = roomName;
        this.residentName = residentName;
        this.roomNumber = roomNumber;
        this.unitNo = unitNo;
        this.buildingNo = buildingNo;
    }
}
