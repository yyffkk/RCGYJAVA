package com.api.vo.basicArchives;

/**
 * 业主档案list回显数据
 */
public class VoUserResident {
    /**
     * 主键ID
     */
    private Integer id;
    /**
     * 业主名称
     */
    private String name;
    /**
     * 联系电话
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

    @Override
    public String toString() {
        return "VoUserResident{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", tel='" + tel + '\'' +
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

    public VoUserResident() {
    }

    public VoUserResident(Integer id, String name, String tel, Integer idType, String idNumber) {
        this.id = id;
        this.name = name;
        this.tel = tel;
        this.idType = idType;
        this.idNumber = idNumber;
    }
}
