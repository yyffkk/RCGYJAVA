package com.aku.vo.basicArchives;

/**
 * 车位信息Vo   list
 */
public class VoParkingSpace {
    /**
     * 车位主键id
     */
    private Integer id;
    /**
     * 车位编号
     */
    private String code;
    /**
     * 车位状态
     */
    private Integer status;
    /**
     * 车位类型
     */
    private Integer type;
    /**
     * 业主姓名
     */
    private String residentName;
    /**
     * 使用者姓名
     */
    private String userName;
    /**
     * 使用者电话
     */
    private String tel;

    @Override
    public String toString() {
        return "VoParkingSpace{" +
                "id=" + id +
                ", code='" + code + '\'' +
                ", status=" + status +
                ", type=" + type +
                ", residentName='" + residentName + '\'' +
                ", userName='" + userName + '\'' +
                ", tel='" + tel + '\'' +
                '}';
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getCode() {
        return code;
    }

    public void setCode(String code) {
        this.code = code;
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

    public String getResidentName() {
        return residentName;
    }

    public void setResidentName(String residentName) {
        this.residentName = residentName;
    }

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public String getTel() {
        return tel;
    }

    public void setTel(String tel) {
        this.tel = tel;
    }

    public VoParkingSpace() {
    }

    public VoParkingSpace(Integer id, String code, Integer status, Integer type, String residentName, String userName, String tel) {
        this.id = id;
        this.code = code;
        this.status = status;
        this.type = type;
        this.residentName = residentName;
        this.userName = userName;
        this.tel = tel;
    }
}
