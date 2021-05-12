package com.api.vo.operationManagement;

import java.util.Date;

/**
 * 钥匙管理 Vo list 回显
 */
public class VoKeyManagement {
    /**
     * 钥匙主键id
     */
    private Integer id;
    /**
     * 钥匙编号
     */
    private String code;
    /**
     * 设备名称
     */
    private String facilityName;
    /**
     * 钥匙数量
     */
    private Integer num;
    /**
     * 对应位置
     */
    private String correspondingPosition;
    /**
     * 存放位置
     */
    private String storageLocation;
    /**
     * 管理人名称
     */
    private String administrator;
    /**
     * 管理人联系方式
     */
    private String tel;
    /**
     * 创建时间
     */
    private Date createDate;

    @Override
    public String toString() {
        return "VoKeyManagement{" +
                "id=" + id +
                ", code='" + code + '\'' +
                ", facilityName='" + facilityName + '\'' +
                ", num=" + num +
                ", correspondingPosition='" + correspondingPosition + '\'' +
                ", storageLocation='" + storageLocation + '\'' +
                ", administrator='" + administrator + '\'' +
                ", tel='" + tel + '\'' +
                ", createDate=" + createDate +
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

    public String getFacilityName() {
        return facilityName;
    }

    public void setFacilityName(String facilityName) {
        this.facilityName = facilityName;
    }

    public Integer getNum() {
        return num;
    }

    public void setNum(Integer num) {
        this.num = num;
    }

    public String getCorrespondingPosition() {
        return correspondingPosition;
    }

    public void setCorrespondingPosition(String correspondingPosition) {
        this.correspondingPosition = correspondingPosition;
    }

    public String getStorageLocation() {
        return storageLocation;
    }

    public void setStorageLocation(String storageLocation) {
        this.storageLocation = storageLocation;
    }

    public String getAdministrator() {
        return administrator;
    }

    public void setAdministrator(String administrator) {
        this.administrator = administrator;
    }

    public String getTel() {
        return tel;
    }

    public void setTel(String tel) {
        this.tel = tel;
    }

    public Date getCreateDate() {
        return createDate;
    }

    public void setCreateDate(Date createDate) {
        this.createDate = createDate;
    }

    public VoKeyManagement() {
    }

    public VoKeyManagement(Integer id, String code, String facilityName, Integer num, String correspondingPosition, String storageLocation, String administrator, String tel, Date createDate) {
        this.id = id;
        this.code = code;
        this.facilityName = facilityName;
        this.num = num;
        this.correspondingPosition = correspondingPosition;
        this.storageLocation = storageLocation;
        this.administrator = administrator;
        this.tel = tel;
        this.createDate = createDate;
    }
}
