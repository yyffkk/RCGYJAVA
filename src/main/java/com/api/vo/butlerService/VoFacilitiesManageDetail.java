package com.api.vo.butlerService;

import java.util.Date;

/**
 * 设施管理 Vo findDetail 回显
 */
public class VoFacilitiesManageDetail {
    /**
     * 主键id
     */
    private Integer id;
    /**
     * 设施名称
     */
    private String name;
    /**
     * 设施编号
     */
    private String code;
    /**
     * 设施状态（1.空置中，2.使用中，3.已停用）
     */
    private Integer status;
    /**
     * 设施分类名称
     */
    private String facilitiesCategoryName;
    /**
     * 设施分类
     */
    private Integer facilitiesCategoryId;
    /**
     * 创建人名称
     */
    private String createName;
    /**
     * 联系方式
     */
    private String tel;
    /**
     * 设施地址
     */
    private String address;
    /**
     * 创建时间
     */
    private Date createDate;

    @Override
    public String toString() {
        return "VoFacilitiesManageDetail{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", code='" + code + '\'' +
                ", status=" + status +
                ", facilitiesCategoryName='" + facilitiesCategoryName + '\'' +
                ", facilitiesCategoryId=" + facilitiesCategoryId +
                ", createName='" + createName + '\'' +
                ", tel='" + tel + '\'' +
                ", address='" + address + '\'' +
                ", createDate=" + createDate +
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

    public String getFacilitiesCategoryName() {
        return facilitiesCategoryName;
    }

    public void setFacilitiesCategoryName(String facilitiesCategoryName) {
        this.facilitiesCategoryName = facilitiesCategoryName;
    }

    public Integer getFacilitiesCategoryId() {
        return facilitiesCategoryId;
    }

    public void setFacilitiesCategoryId(Integer facilitiesCategoryId) {
        this.facilitiesCategoryId = facilitiesCategoryId;
    }

    public String getCreateName() {
        return createName;
    }

    public void setCreateName(String createName) {
        this.createName = createName;
    }

    public String getTel() {
        return tel;
    }

    public void setTel(String tel) {
        this.tel = tel;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public Date getCreateDate() {
        return createDate;
    }

    public void setCreateDate(Date createDate) {
        this.createDate = createDate;
    }

    public VoFacilitiesManageDetail() {
    }

    public VoFacilitiesManageDetail(Integer id, String name, String code, Integer status, String facilitiesCategoryName, Integer facilitiesCategoryId, String createName, String tel, String address, Date createDate) {
        this.id = id;
        this.name = name;
        this.code = code;
        this.status = status;
        this.facilitiesCategoryName = facilitiesCategoryName;
        this.facilitiesCategoryId = facilitiesCategoryId;
        this.createName = createName;
        this.tel = tel;
        this.address = address;
        this.createDate = createDate;
    }
}
