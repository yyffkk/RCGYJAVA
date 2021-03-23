package com.api.vo.my;

/**
 * 我的房屋,再次认证回显信息 Vo findById 回显
 */
public class MyHouseFBIVo {
    /**
     * 房产审核表主键id
     */
    private Integer id;
    /**
     * 房屋名称
     */
    private String roomName;
    /**
     * 房产id
     */
    private Integer estateId;
    /**
     * 住户类型（1审核业主，2审核亲属，3审核租客）
     */
    private Integer type;
    /**
     * 姓名
     */
    private String name;
    /**
     * 证件类型（1身份证，2营业执照，3.军人证）
     */
    private Integer idType;
    /**
     * 证件号码
     */
    private String idNumber;

    @Override
    public String toString() {
        return "MyHouseFBIVo{" +
                "id=" + id +
                ", roomName='" + roomName + '\'' +
                ", estateId=" + estateId +
                ", type=" + type +
                ", name='" + name + '\'' +
                ", idType=" + idType +
                ", idNumber='" + idNumber + '\'' +
                '}';
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getRoomName() {
        return roomName;
    }

    public void setRoomName(String roomName) {
        this.roomName = roomName;
    }

    public Integer getEstateId() {
        return estateId;
    }

    public void setEstateId(Integer estateId) {
        this.estateId = estateId;
    }

    public Integer getType() {
        return type;
    }

    public void setType(Integer type) {
        this.type = type;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Integer getIdType() {
        return idType;
    }

    public void setIdType(Integer idType) {
        this.idType = idType;
    }

    public String getIdNumber() {
        return idNumber;
    }

    public void setIdNumber(String idNumber) {
        this.idNumber = idNumber;
    }

    public MyHouseFBIVo() {
    }

    public MyHouseFBIVo(Integer id, String roomName, Integer estateId, Integer type, String name, Integer idType, String idNumber) {
        this.id = id;
        this.roomName = roomName;
        this.estateId = estateId;
        this.type = type;
        this.name = name;
        this.idType = idType;
        this.idNumber = idNumber;
    }
}
