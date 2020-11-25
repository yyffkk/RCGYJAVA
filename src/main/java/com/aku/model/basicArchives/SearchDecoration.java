package com.aku.model.basicArchives;

/**
 * 装修搜索条件
 */
public class SearchDecoration {
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
     * 装修负责人姓名
     */
    private String name;
    /**
     * 装修负责人手机号
     */
    private String tel;
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
        return "SearchDecoration{" +
                "pageNum=" + pageNum +
                ", size=" + size +
                ", roomName='" + roomName + '\'' +
                ", residentName='" + residentName + '\'' +
                ", name='" + name + '\'' +
                ", tel='" + tel + '\'' +
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

    public SearchDecoration() {
    }

    public SearchDecoration(int pageNum, int size, String roomName, String residentName, String name, String tel, String roomNumber, Integer unitNo, Integer estateNo) {
        this.pageNum = pageNum;
        this.size = size;
        this.roomName = roomName;
        this.residentName = residentName;
        this.name = name;
        this.tel = tel;
        this.roomNumber = roomNumber;
        this.unitNo = unitNo;
        this.estateNo = estateNo;
    }
}
