package com.api.model.app;

/**
 * 用户id和报事报修主键id
 */
public class UserIdAndRepairId {
    /**
     * 用户id
     */
    private Integer id;
    /**
     * 报事报修主键id
     */
    private Integer repairId;

    @Override
    public String toString() {
        return "UserIdAndRepairId{" +
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

    public UserIdAndRepairId() {
    }

    public UserIdAndRepairId(Integer id, Integer repairId) {
        this.id = id;
        this.repairId = repairId;
    }
}
