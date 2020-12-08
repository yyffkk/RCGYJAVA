package com.api.model.basicArchives;

/**
 * 装修id 和 附属员工id
 */
public class DecorationIdAndStaffId {
    /**
     * 装修id
     */
    private Integer decorationId;
    /**
     * 附属员工id
     */
    private Integer staffId;

    @Override
    public String toString() {
        return "DecorationIdAndStaffId{" +
                "decorationId=" + decorationId +
                ", staffId=" + staffId +
                '}';
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

    public DecorationIdAndStaffId() {
    }

    public DecorationIdAndStaffId(Integer decorationId, Integer staffId) {
        this.decorationId = decorationId;
        this.staffId = staffId;
    }
}
