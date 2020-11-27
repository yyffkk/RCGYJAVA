package com.aku.model.basicArchives;

/**
 * 房产信息搜索条件
 */
public class SearchCpmBuildingUnitEstate {
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
     * 业主姓名
     */
    private String residentName;
    /**
     * 房屋状态
     */
    private Integer status;
    /**
     * 业主手机号
     */
    private String residentTel;
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
        return "SearchCpmBuildingUnitEstate{" +
                "pageNum=" + pageNum +
                ", size=" + size +
                ", roomName='" + roomName + '\'' +
                ", residentName='" + residentName + '\'' +
                ", status=" + status +
                ", residentTel='" + residentTel + '\'' +
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

    public Integer getStatus() {
        return status;
    }

    public void setStatus(Integer status) {
        this.status = status;
    }

    public String getResidentTel() {
        return residentTel;
    }

    public void setResidentTel(String residentTel) {
        this.residentTel = residentTel;
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

    public SearchCpmBuildingUnitEstate() {
    }

    public SearchCpmBuildingUnitEstate(int pageNum, int size, String roomName, String residentName, Integer status, String residentTel, String roomNumber, Integer unitNo, Integer buildingNo) {
        this.pageNum = pageNum;
        this.size = size;
        this.roomName = roomName;
        this.residentName = residentName;
        this.status = status;
        this.residentTel = residentTel;
        this.roomNumber = roomNumber;
        this.unitNo = unitNo;
        this.buildingNo = buildingNo;
    }
}
