package com.api.model.operationManagement;

import java.util.Date;

/**
 * 物料出入库记录model信息
 */
public class SysMaterialRecord {
    /**
     * 物料出入库记录主键id
     */
    private Integer id;
    /**
     * 物料管理主键id
     */
    private Integer materialId;
    /**
     * 类型：1.出库，2.入库
     */
    private Integer type;
    /**
     * 数量
     */
    private Integer num;
    /**
     * 创建人
     */
    private Integer createId;
    /**
     * 创建时间
     */
    private Date createDate;

    @Override
    public String toString() {
        return "SysMaterialRecord{" +
                "id=" + id +
                ", materialId=" + materialId +
                ", type=" + type +
                ", num=" + num +
                ", createId=" + createId +
                ", createDate=" + createDate +
                '}';
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Integer getMaterialId() {
        return materialId;
    }

    public void setMaterialId(Integer materialId) {
        this.materialId = materialId;
    }

    public Integer getType() {
        return type;
    }

    public void setType(Integer type) {
        this.type = type;
    }

    public Integer getNum() {
        return num;
    }

    public void setNum(Integer num) {
        this.num = num;
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

    public SysMaterialRecord() {
    }

    public SysMaterialRecord(Integer id, Integer materialId, Integer type, Integer num, Integer createId, Date createDate) {
        this.id = id;
        this.materialId = materialId;
        this.type = type;
        this.num = num;
        this.createId = createId;
        this.createDate = createDate;
    }
}
