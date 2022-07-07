package com.api.model.system;

/**
 * 权限互斥
 */
public class SysJurisdictionRepel {
    /**
     * 主键ID
     */
    private Integer id;
    /**
     * 权限1
     */
    private Integer jurisdictionOneId;
    /**
     * 权限2
     */
    private Integer jurisdictionTwoId;
    /**
     * 系统编码
     */
    private Integer actionId;

    @Override
    public String toString() {
        return "SysJurisdictionRepel{" +
                "id=" + id +
                ", jurisdictionOneId=" + jurisdictionOneId +
                ", jurisdictionTwoId=" + jurisdictionTwoId +
                ", actionId=" + actionId +
                '}';
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Integer getJurisdictionOneId() {
        return jurisdictionOneId;
    }

    public void setJurisdictionOneId(Integer jurisdictionOneId) {
        this.jurisdictionOneId = jurisdictionOneId;
    }

    public Integer getJurisdictionTwoId() {
        return jurisdictionTwoId;
    }

    public void setJurisdictionTwoId(Integer jurisdictionTwoId) {
        this.jurisdictionTwoId = jurisdictionTwoId;
    }

    public Integer getActionId() {
        return actionId;
    }

    public void setActionId(Integer actionId) {
        this.actionId = actionId;
    }

    public SysJurisdictionRepel() {
    }

    public SysJurisdictionRepel(Integer id, Integer jurisdictionOneId, Integer jurisdictionTwoId, Integer actionId) {
        this.id = id;
        this.jurisdictionOneId = jurisdictionOneId;
        this.jurisdictionTwoId = jurisdictionTwoId;
        this.actionId = actionId;
    }
}
