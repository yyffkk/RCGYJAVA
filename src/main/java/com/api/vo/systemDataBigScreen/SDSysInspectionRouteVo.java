package com.api.vo.systemDataBigScreen;

import java.util.Date;

/**
 * 巡检路线
 */
public class SDSysInspectionRouteVo {
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
     * 持续时间,单位为分种
     */
    private Integer spaceTime;
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
    /**
     * 是否删除，1.非删 0.删除
     */
    private Integer isDelete;

    @Override
    public String toString() {
        return "SDSysInspectionRouteVo{" +
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
                ", isDelete=" + isDelete +
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

    public Integer getIsDelete() {
        return isDelete;
    }

    public void setIsDelete(Integer isDelete) {
        this.isDelete = isDelete;
    }

    public SDSysInspectionRouteVo() {
    }

    public SDSysInspectionRouteVo(Integer id, String code, String name, String describes, Integer status, Integer spaceTime, Integer createId, Date createDate, Integer modifyId, Date modifyDate, Integer isDelete) {
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
        this.isDelete = isDelete;
    }
}
