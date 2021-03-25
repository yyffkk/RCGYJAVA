package com.api.vo.my;

/**
 * 我的房屋 数据库存在的住户回显信息
 */
public class MyHouseResidentInfoVo {
    /**
     * 住户主键id
     */
    private Integer id;
    /**
     * 住户姓名
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
        return "MyHouseResidentInfoVo{" +
                "id=" + id +
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

    public MyHouseResidentInfoVo() {
    }

    public MyHouseResidentInfoVo(Integer id, String name, Integer idType, String idNumber) {
        this.id = id;
        this.name = name;
        this.idType = idType;
        this.idNumber = idNumber;
    }
}
