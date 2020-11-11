package com.aku.model.basicArchives;

import java.util.Date;

/**
 * 楼宇管理
 */
public class CpmBuilding {
    /**
     * 主键id
     */
    private Integer id;
    /**
     * 楼宇编号
     */
    private Integer no;
    /**
     * 楼宇名称
     */
    private String name;
    /**
     * 楼宇编码
     */
    private String code;
    /**
     * 楼宇坐标
     */
    private String coordinate;
    /**
     * 总楼层数
     */
    private Integer totalFloor;
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

    @Override
    public String toString() {
        return "CpmBuilding{" +
                "id=" + id +
                ", no=" + no +
                ", name='" + name + '\'' +
                ", code='" + code + '\'' +
                ", coordinate='" + coordinate + '\'' +
                ", totalFloor=" + totalFloor +
                ", createId=" + createId +
                ", createDate=" + createDate +
                ", modifyId=" + modifyId +
                ", modifyDate=" + modifyDate +
                '}';
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Integer getNo() {
        return no;
    }

    public void setNo(Integer no) {
        this.no = no;
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

    public String getCoordinate() {
        return coordinate;
    }

    public void setCoordinate(String coordinate) {
        this.coordinate = coordinate;
    }

    public Integer getTotalFloor() {
        return totalFloor;
    }

    public void setTotalFloor(Integer totalFloor) {
        this.totalFloor = totalFloor;
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

    public CpmBuilding() {
    }

    public CpmBuilding(Integer id, Integer no, String name, String code, String coordinate, Integer totalFloor, Integer createId, Date createDate, Integer modifyId, Date modifyDate) {
        this.id = id;
        this.no = no;
        this.name = name;
        this.code = code;
        this.coordinate = coordinate;
        this.totalFloor = totalFloor;
        this.createId = createId;
        this.createDate = createDate;
        this.modifyId = modifyId;
        this.modifyDate = modifyDate;
    }
}
