package com.api.model.basicArchives;

/**
 * 员工表（负责人附属员工表）
 */
public class UserStaff {
    /**
     * 主键id
     */
    private Integer id;
    /**
     * 员工姓名
     */
    private String name;
    /**
     * 员工手机号
     */
    private String tel;
    /**
     * 证件类型
     */
    private Integer idType;
    /**
     * 证件号码
     */
    private String idNumber;
    /**
     * 身份
     */
    private int identity;

    @Override
    public String toString() {
        return "UserStaff{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", tel='" + tel + '\'' +
                ", idType=" + idType +
                ", idNumber='" + idNumber + '\'' +
                ", identity=" + identity +
                '}';
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
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

    public int getIdentity() {
        return identity;
    }

    public void setIdentity(int identity) {
        this.identity = identity;
    }

    public UserStaff() {
    }

    public UserStaff(Integer id, String name, String tel, Integer idType, String idNumber, int identity) {
        this.id = id;
        this.name = name;
        this.tel = tel;
        this.idType = idType;
        this.idNumber = idNumber;
        this.identity = identity;
    }
}
