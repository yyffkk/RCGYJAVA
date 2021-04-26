package com.api.vo.butlerService;

import java.util.Date;

/**
 * 设施管理 Vo list 回显
 */
public class VoFacilitiesManage {
    /**
     * 主键id
     */
    private Integer id;
    /**
     * 设施编号
     */
    private String code;
    /**
     * 设施分类名称
     */
    private String facilitiesCategoryName;
    /**
     * 设施名称
     */
    private String name;
    /**
     * 添加人
     */
    private String createName;
    /**
     * 设施状态（1.空置中，2.使用中，3.已停用）
     */
    private Integer status;
    /**
     * 添加时间
     */
    private Date createDate;

    @Override
    public String toString() {
        return "VoFacilitiesManage{" +
                "id=" + id +
                ", code='" + code + '\'' +
                ", facilitiesCategoryName='" + facilitiesCategoryName + '\'' +
                ", name='" + name + '\'' +
                ", createName='" + createName + '\'' +
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

    public String getFacilitiesCategoryName() {
        return facilitiesCategoryName;
    }

    public void setFacilitiesCategoryName(String facilitiesCategoryName) {
        this.facilitiesCategoryName = facilitiesCategoryName;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getCreateName() {
        return createName;
    }

    public void setCreateName(String createName) {
        this.createName = createName;
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

    public VoFacilitiesManage() {
    }

    public VoFacilitiesManage(Integer id, String code, String facilitiesCategoryName, String name, String createName, Integer status, Date createDate) {
        this.id = id;
        this.code = code;
        this.facilitiesCategoryName = facilitiesCategoryName;
        this.name = name;
        this.createName = createName;
        this.status = status;
        this.createDate = createDate;
    }
}
