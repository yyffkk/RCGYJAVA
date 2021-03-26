package com.api.model.basicArchives;

/**
 * 审核管理搜索条件
 */
public class AuditManagementSearch {
    /**
     * 当前页数
     */
    private int pageNum;
    /**
     * 每页记录数
     */
    private int size;
    /**
     * 房产名称（格式：楼栋号-单元号-房间号）
     */
    private String roomName;
    /**
     * 审核状态（1.审核中，3.审核失败，4.审核成功）
     */
    private Integer status;
    /**
     * 住户类型（1 审核业主，2审核亲属，3审核租客）
     */
    private Integer type;
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
        return "AuditManagementSearch{" +
                "pageNum=" + pageNum +
                ", size=" + size +
                ", roomName='" + roomName + '\'' +
                ", status=" + status +
                ", type=" + type +
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

    public Integer getStatus() {
        return status;
    }

    public void setStatus(Integer status) {
        this.status = status;
    }

    public Integer getType() {
        return type;
    }

    public void setType(Integer type) {
        this.type = type;
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

    public AuditManagementSearch() {
    }

    public AuditManagementSearch(int pageNum, int size, String roomName, Integer status, Integer type, String roomNumber, Integer unitNo, Integer buildingNo) {
        this.pageNum = pageNum;
        this.size = size;
        this.roomName = roomName;
        this.status = status;
        this.type = type;
        this.roomNumber = roomNumber;
        this.unitNo = unitNo;
        this.buildingNo = buildingNo;
    }
}
