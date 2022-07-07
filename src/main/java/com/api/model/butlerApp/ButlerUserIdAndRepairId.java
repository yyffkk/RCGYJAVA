package com.api.model.butlerApp;


/**
 * 管家app 用户主键id 与 报事报修主键id
 */
public class ButlerUserIdAndRepairId {
    /**
     * 用户主键id
     */
    private Integer id;
    /**
     * 报事报修主键id
     */
    private Integer repairId;

    @Override
    public String toString() {
        return "ButlerUserIdAndRepairId{" +
                "id=" + id +
                ", repairId=" + repairId +
                '}';
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Integer getRepairId() {
        return repairId;
    }

    public void setRepairId(Integer repairId) {
        this.repairId = repairId;
    }

    public ButlerUserIdAndRepairId() {
    }

    public ButlerUserIdAndRepairId(Integer id, Integer repairId) {
        this.id = id;
        this.repairId = repairId;
    }
}
