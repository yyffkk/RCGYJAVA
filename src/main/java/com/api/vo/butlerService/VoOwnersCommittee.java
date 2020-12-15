package com.api.vo.butlerService;


/**
 * 业委会管理 Vo list回显
 */
public class VoOwnersCommittee {
    /**
     * 主键id
     */
    private Integer id;
    /**
     * 职位id(1.业委会主任，2.业委会副主任，3.业委会委员)
     */
    private Integer positionId;
    /**
     * 姓名
     */
    private String name;
    /**
     * 性别
     */
    private Integer sexId;
    /**
     * 年龄
     */
    private Integer age;
    /**
     * 学历id（1.专科，2.本科，3.硕士，4.博士）
     */
    private Integer educationId;
    /**
     * 房屋信息
     */
    private String roomName;
    /**
     * 职业（社会职业）
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
        return "VoOwnersCommittee{" +
                "id=" + id +
                ", positionId=" + positionId +
                ", name='" + name + '\'' +
                ", sexId=" + sexId +
                ", age=" + age +
                ", educationId=" + educationId +
                ", roomName='" + roomName + '\'' +
                ", profession='" + profession + '\'' +
                ", roomNumber='" + roomNumber + '\'' +
                ", unitNo=" + unitNo +
                ", estateNo=" + estateNo +
                '}';
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
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

    public Integer getSexId() {
        return sexId;
    }

    public void setSexId(Integer sexId) {
        this.sexId = sexId;
    }

    public Integer getAge() {
        return age;
    }

    public void setAge(Integer age) {
        this.age = age;
    }

    public Integer getEducationId() {
        return educationId;
    }

    public void setEducationId(Integer educationId) {
        this.educationId = educationId;
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

    public VoOwnersCommittee() {
    }

    public VoOwnersCommittee(Integer id, Integer positionId, String name, Integer sexId, Integer age, Integer educationId, String roomName, String profession, String roomNumber, Integer unitNo, Integer estateNo) {
        this.id = id;
        this.positionId = positionId;
        this.name = name;
        this.sexId = sexId;
        this.age = age;
        this.educationId = educationId;
        this.roomName = roomName;
        this.profession = profession;
        this.roomNumber = roomNumber;
        this.unitNo = unitNo;
        this.estateNo = estateNo;
    }
}
