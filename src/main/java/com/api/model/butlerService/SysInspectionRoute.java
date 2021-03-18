package com.api.model.butlerService;

import java.util.Date;
import java.util.List;

/**
 * 巡检路线model
 */
public class SysInspectionRoute {
    /**
     * 主键id
     */
    private Integer id;
    /**
     * 巡检路线编号(系统自动)
     */
    private String code;
    /**
     * 巡检路线名称
     */
    private String name;
    /**
     * 描述
     */
    private String describes;
    /**
     * 状态（1.启用，2.停用）
     */
    private Integer status;
    /**
     * 持续时间,单位为分钟
     */
    private Integer spaceTime;
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
     * 巡检点-路线 关联表
     */
    private List<SysInspectionPointRoute> pointRouteList;

    @Override
    public String toString() {
        return "SysInspectionRoute{" +
                "id=" + id +
                ", code='" + code + '\'' +
                ", name='" + name + '\'' +
                ", describes='" + describes + '\'' +
                ", status=" + status +
                ", spaceTime=" + spaceTime +
                ", createId=" + createId +
                ", createDate=" + createDate +
                ", modifyId=" + modifyId +
                ", modifyDate=" + modifyDate +
                ", pointRouteList=" + pointRouteList +
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

    public String getDescribes() {
        return describes;
    }

    public void setDescribes(String describes) {
        this.describes = describes;
    }

    public Integer getStatus() {
        return status;
    }

    public void setStatus(Integer status) {
        this.status = status;
    }

    public Integer getSpaceTime() {
        return spaceTime;
    }

    public void setSpaceTime(Integer spaceTime) {
        this.spaceTime = spaceTime;
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

    public List<SysInspectionPointRoute> getPointRouteList() {
        return pointRouteList;
    }

    public void setPointRouteList(List<SysInspectionPointRoute> pointRouteList) {
        this.pointRouteList = pointRouteList;
    }

    public SysInspectionRoute() {
    }

    public SysInspectionRoute(Integer id, String code, String name, String describes, Integer status, Integer spaceTime, Integer createId, Date createDate, Integer modifyId, Date modifyDate, List<SysInspectionPointRoute> pointRouteList) {
        this.id = id;
        this.code = code;
        this.name = name;
        this.describes = describes;
        this.status = status;
        this.spaceTime = spaceTime;
        this.createId = createId;
        this.createDate = createDate;
        this.modifyId = modifyId;
        this.modifyDate = modifyDate;
        this.pointRouteList = pointRouteList;
    }
}
