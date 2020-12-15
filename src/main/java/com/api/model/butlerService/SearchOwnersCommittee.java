package com.api.model.butlerService;

/**
 * 委员会管理 搜索条件
 */
public class SearchOwnersCommittee {
    /**
     * 当前页数
     */
    private int pageNum;
    /**
     * 每页记录数
     */
    private int size;
    /**
     * 职位id(1.业委会主任，2.业委会副主任，3.业委会委员)
     */
    private Integer positionId;
    /**
     * 姓名
     */
    private String name;
    /**
     * 学历id（1.专科，2.本科，3.硕士，4.博士）
     */
    private Integer educationId;
    /**
     * 性别id
     */
    private Integer sexId;
    /**
     * 房产信息
     */
    private String roomName;
    /**
     * 职业
     */
    private String profession;
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
        return "SearchOwnersCommittee{" +
                "pageNum=" + pageNum +
                ", size=" + size +
                ", positionId=" + positionId +
                ", name='" + name + '\'' +
                ", educationId=" + educationId +
                ", sexId=" + sexId +
                ", roomName='" + roomName + '\'' +
                ", profession='" + profession + '\'' +
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

    public Integer getPositionId() {
        return positionId;
    }

    public void setPositionId(Integer positionId) {
        this.positionId = positionId;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Integer getEducationId() {
        return educationId;
    }

    public void setEducationId(Integer educationId) {
        this.educationId = educationId;
    }

    public Integer getSexId() {
        return sexId;
    }

    public void setSexId(Integer sexId) {
        this.sexId = sexId;
    }

    public String getRoomName() {
        return roomName;
    }

    public void setRoomName(String roomName) {
        this.roomName = roomName;
    }

    public String getProfession() {
        return profession;
    }

    public void setProfession(String profession) {
        this.profession = profession;
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

    public SearchOwnersCommittee() {
    }

    public SearchOwnersCommittee(int pageNum, int size, Integer positionId, String name, Integer educationId, Integer sexId, String roomName, String profession, String roomNumber, Integer unitNo, Integer estateNo) {
        this.pageNum = pageNum;
        this.size = size;
        this.positionId = positionId;
        this.name = name;
        this.educationId = educationId;
        this.sexId = sexId;
        this.roomName = roomName;
        this.profession = profession;
        this.roomNumber = roomNumber;
        this.unitNo = unitNo;
        this.estateNo = estateNo;
    }
}
