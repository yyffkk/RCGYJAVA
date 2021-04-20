package com.api.model.butlerService;

import java.math.BigDecimal;
import java.util.Date;
import java.util.List;

/**
 * 巡检点model
 */
public class SysInspectionPoint {
    /**
     * 主键id
     */
    private Integer id;
    /**
     * 编号
     */
    private String code;
    /**
     * 名称
     */
    private String name;
    /**
     * 巡检模式（1.扫码）【就一个模式】
     */
    private Integer type;
    /**
     * 经度
     */
    private BigDecimal longitude;
    /**
     * 纬度
     */
    private BigDecimal latitude;
    /**
     * 创建人id
     */
    private Integer createId;
    /**
     * 创建时间
     */
    private Date createDate;
    /**
     * 修改人id
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
     * 巡检点检查项信息集合
     */
    private List<SysInspectionCheckItems> itemsList;

    @Override
    public String toString() {
        return "SysInspectionPoint{" +
                "id=" + id +
                ", code='" + code + '\'' +
                ", name='" + name + '\'' +
                ", type=" + type +
                ", longitude=" + longitude +
                ", latitude=" + latitude +
                ", createId=" + createId +
                ", createDate=" + createDate +
                ", modifyId=" + modifyId +
                ", modifyDate=" + modifyDate +
                ", isDelete=" + isDelete +
                ", itemsList=" + itemsList +
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

    public Integer getType() {
        return type;
    }

    public void setType(Integer type) {
        this.type = type;
    }

    public BigDecimal getLongitude() {
        return longitude;
    }

    public void setLongitude(BigDecimal longitude) {
        this.longitude = longitude;
    }

    public BigDecimal getLatitude() {
        return latitude;
    }

    public void setLatitude(BigDecimal latitude) {
        this.latitude = latitude;
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

    public List<SysInspectionCheckItems> getItemsList() {
        return itemsList;
    }

    public void setItemsList(List<SysInspectionCheckItems> itemsList) {
        this.itemsList = itemsList;
    }

    public SysInspectionPoint() {
    }

    public SysInspectionPoint(Integer id, String code, String name, Integer type, BigDecimal longitude, BigDecimal latitude, Integer createId, Date createDate, Integer modifyId, Date modifyDate, Integer isDelete, List<SysInspectionCheckItems> itemsList) {
        this.id = id;
        this.code = code;
        this.name = name;
        this.type = type;
        this.longitude = longitude;
        this.latitude = latitude;
        this.createId = createId;
        this.createDate = createDate;
        this.modifyId = modifyId;
        this.modifyDate = modifyDate;
        this.isDelete = isDelete;
        this.itemsList = itemsList;
    }
}
