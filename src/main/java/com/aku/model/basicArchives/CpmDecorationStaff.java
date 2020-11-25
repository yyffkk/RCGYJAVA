package com.aku.model.basicArchives;

/**
 * 附属员工装修关联表
 */
public class CpmDecorationStaff {
    /**
     * 附属员工装修关联表主键id
     */
    private Integer id;
    /**
     * 装修主键id
     */
    private Integer decorationId;
    /**
     * 附属员工主键id
     */
    private Integer staffId;
    /**
     * 身份
     */
    private Integer identity;

    @Override
    public String toString() {
        return "CpmDecorationStaff{" +
                "id=" + id +
                ", decorationId=" + decorationId +
                ", staffId=" + staffId +
                ", identity=" + identity +
                '}';
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Integer getDecorationId() {
        return decorationId;
    }

    public void setDecorationId(Integer decorationId) {
        this.decorationId = decorationId;
    }

    public Integer getStaffId() {
        return staffId;
    }

    public void setStaffId(Integer staffId) {
        this.staffId = staffId;
    }

    public Integer getIdentity() {
        return identity;
    }

    public void setIdentity(Integer identity) {
        this.identity = identity;
    }

    public CpmDecorationStaff() {
    }

    public CpmDecorationStaff(Integer id, Integer decorationId, Integer staffId, Integer identity) {
        this.id = id;
        this.decorationId = decorationId;
        this.staffId = staffId;
        this.identity = identity;
    }
}
