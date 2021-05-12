package com.api.model.operationManagement;

import java.util.Date;

/**
 * 钥匙管理model信息
 */
public class SysKeyManagement {
    /**
     * 钥匙主键ID
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
     * 创建人
     */
    private Integer createId;
    /**
     * 创建时间
     */
    private Date createDate;
    /**
     * 修改人
     */
    private Integer modifyId;
    /**
     * 修改时间
     */
    private Date modifyDate;

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

    public Integer getCreateId() {
        return createId;
    }

    public void setCreateId(Integer createId) {
        this.createId = createId;
    }

    public Date getCreateDate() {
        return createDate;
    }

    public void setCreateDate(Date createDate) {
        this.createDate = createDate;
    }

    public Integer getModifyId() {
        return modifyId;
    }

    public void setModifyId(Integer modifyId) {
        this.modifyId = modifyId;
    }

    public Date getModifyDate() {
        return modifyDate;
    }

    public void setModifyDate(Date modifyDate) {
        this.modifyDate = modifyDate;
    }

    public SysKeyManagement() {
    }

    public SysKeyManagement(Integer id, String code, String facilityName, Integer num, String correspondingPosition, String storageLocation, String administrator, String tel, Integer createId, Date createDate, Integer modifyId, Date modifyDate) {
        this.id = id;
        this.code = code;
        this.facilityName = facilityName;
        this.num = num;
        this.correspondingPosition = correspondingPosition;
        this.storageLocation = storageLocation;
        this.administrator = administrator;
        this.tel = tel;
        this.createId = createId;
        this.createDate = createDate;
        this.modifyId = modifyId;
        this.modifyDate = modifyDate;
    }
}
