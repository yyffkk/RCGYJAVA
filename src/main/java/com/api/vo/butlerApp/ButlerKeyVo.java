package com.api.vo.butlerApp;

import java.util.Date;

/**
 * 管家app 钥匙Vo list 回显
 */
public class ButlerKeyVo {
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
     * 钥匙总数
     */
    private Integer totalNum;
    /**
     * 可申请钥匙数量
     */
    private Integer loanableNum;
    /**
     * 对应设备位置
     */
    private String correspondingPosition;
    /**
     * 存放地址
     */
    private String storageLocation;
    /**
     * 状态，1.可申请，2.使用中，3.钥匙已空
     */
    private Integer status;
    /**
     * 开始时间
     */
    private Date createDate;

    @Override
    public String toString() {
        return "ButlerKeyVo{" +
                "id=" + id +
                ", code='" + code + '\'' +
                ", facilityName='" + facilityName + '\'' +
                ", totalNum=" + totalNum +
                ", loanableNum=" + loanableNum +
                ", correspondingPosition='" + correspondingPosition + '\'' +
                ", storageLocation='" + storageLocation + '\'' +
                ", status=" + status +
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

    public Integer getTotalNum() {
        return totalNum;
    }

    public void setTotalNum(Integer totalNum) {
        this.totalNum = totalNum;
    }

    public Integer getLoanableNum() {
        return loanableNum;
    }

    public void setLoanableNum(Integer loanableNum) {
        this.loanableNum = loanableNum;
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

    public Integer getStatus() {
        return status;
    }

    public void setStatus(Integer status) {
        this.status = status;
    }

    public Date getCreateDate() {
        return createDate;
    }

    public void setCreateDate(Date createDate) {
        this.createDate = createDate;
    }

    public ButlerKeyVo() {
    }

    public ButlerKeyVo(Integer id, String code, String facilityName, Integer totalNum, Integer loanableNum, String correspondingPosition, String storageLocation, Integer status, Date createDate) {
        this.id = id;
        this.code = code;
        this.facilityName = facilityName;
        this.totalNum = totalNum;
        this.loanableNum = loanableNum;
        this.correspondingPosition = correspondingPosition;
        this.storageLocation = storageLocation;
        this.status = status;
        this.createDate = createDate;
    }
}
