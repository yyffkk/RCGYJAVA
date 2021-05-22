package com.api.vo.operationManagement;

import java.util.Date;

/**
 * 物料出入库记录Vo list 回显
 */
public class VoMaterialRecord {
    /**
     * 物料出入库记录主键id
     */
    private Integer id;
    /**
     * 物料名称
     */
    private String name;
    /**
     * 类型：1.出库，2.入库
     */
    private Integer type;
    /**
     * 数量
     */
    private Integer num;
    /**
     * 创建人名称
     */
    private String createName;
    /**
     * 创建时间
     */
    private Date createDate;

    @Override
    public String toString() {
        return "VoMaterialRecord{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", type=" + type +
                ", num=" + num +
                ", createName='" + createName + '\'' +
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

    public String getCreateName() {
        return createName;
    }

    public void setCreateName(String createName) {
        this.createName = createName;
    }

    public Date getCreateDate() {
        return createDate;
    }

    public void setCreateDate(Date createDate) {
        this.createDate = createDate;
    }

    public VoMaterialRecord() {
    }

    public VoMaterialRecord(Integer id, String name, Integer type, Integer num, String createName, Date createDate) {
        this.id = id;
        this.name = name;
        this.type = type;
        this.num = num;
        this.createName = createName;
        this.createDate = createDate;
    }
}
