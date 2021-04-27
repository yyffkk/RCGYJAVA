package com.api.model.butlerService;


import java.sql.Time;
import java.util.Arrays;
import java.util.Date;

/**
 * 设施分类管理model
 */
public class FacilitiesCategory {
    /**
     * 主键id
     */
    private Integer id;
    /**
     * 设施编号
     */
    private String code;
    /**
     * 设施名称
     */
    private String name;
    /**
     * 设施数量
     */
    private Integer num;
    /**
     * 开放开始时间
     */
    private Time openStartDate;
    /**
     * 开放结束时间
     */
    private Time openEndDate;
    /**
     * 创建人id
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
    /**
     * 是否删除，1.非删，0.删除
     */
    private Integer isDelete;
    /**
     * 照片路径数组
     */
    private String[] imgUrls;

    @Override
    public String toString() {
        return "FacilitiesCategory{" +
                "id=" + id +
                ", code='" + code + '\'' +
                ", name='" + name + '\'' +
                ", num=" + num +
                ", openStartDate=" + openStartDate +
                ", openEndDate=" + openEndDate +
                ", createId=" + createId +
                ", createDate=" + createDate +
                ", modifyId=" + modifyId +
                ", modifyDate=" + modifyDate +
                ", isDelete=" + isDelete +
                ", imgUrls=" + Arrays.toString(imgUrls) +
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

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Integer getNum() {
        return num;
    }

    public void setNum(Integer num) {
        this.num = num;
    }

    public Time getOpenStartDate() {
        return openStartDate;
    }

    public void setOpenStartDate(Time openStartDate) {
        this.openStartDate = openStartDate;
    }

    public Time getOpenEndDate() {
        return openEndDate;
    }

    public void setOpenEndDate(Time openEndDate) {
        this.openEndDate = openEndDate;
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

    public Integer getIsDelete() {
        return isDelete;
    }

    public void setIsDelete(Integer isDelete) {
        this.isDelete = isDelete;
    }

    public String[] getImgUrls() {
        return imgUrls;
    }

    public void setImgUrls(String[] imgUrls) {
        this.imgUrls = imgUrls;
    }

    public FacilitiesCategory() {
    }

    public FacilitiesCategory(Integer id, String code, String name, Integer num, Time openStartDate, Time openEndDate, Integer createId, Date createDate, Integer modifyId, Date modifyDate, Integer isDelete, String[] imgUrls) {
        this.id = id;
        this.code = code;
        this.name = name;
        this.num = num;
        this.openStartDate = openStartDate;
        this.openEndDate = openEndDate;
        this.createId = createId;
        this.createDate = createDate;
        this.modifyId = modifyId;
        this.modifyDate = modifyDate;
        this.isDelete = isDelete;
        this.imgUrls = imgUrls;
    }
}
