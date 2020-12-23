package com.api.model.butlerService;

/**
 * 语音管家 搜索条件
 */
public class SearchVoiceHousekeeper {
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
     * 姓名
     */
    private String name;
    /**
     * 联系方式
     */
    private String tel;
    /**
     * 状态（1.未处理，2.已处理）
     */
    private Integer status;
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
        return "SearchVoiceHousekeeper{" +
                "pageNum=" + pageNum +
                ", size=" + size +
                ", roomName='" + roomName + '\'' +
                ", name='" + name + '\'' +
                ", tel='" + tel + '\'' +
                ", status=" + status +
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

    public Integer getStatus() {
        return status;
    }

    public void setStatus(Integer status) {
        this.status = status;
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

    public SearchVoiceHousekeeper() {
    }

    public SearchVoiceHousekeeper(int pageNum, int size, String roomName, String name, String tel, Integer status, String roomNumber, Integer unitNo, Integer estateNo) {
        this.pageNum = pageNum;
        this.size = size;
        this.roomName = roomName;
        this.name = name;
        this.tel = tel;
        this.status = status;
        this.roomNumber = roomNumber;
        this.unitNo = unitNo;
        this.estateNo = estateNo;
    }
}
