package com.api.vo.chargeManagement;

/**
 * 押金退款装修情况Vo 回显（查装修管理表的 状态 和 最后一次检查信息 ）
 */
public class VoRefundDecorationDetail {
    /**
     * 押金管理主键id
     */
    private Integer id;
    /**
     * 状态(-1.申请中，-2.申请不通过，-3.申请通过，1.未开始（已付押金），2.装修中，3.完工检查申请中，4.完工检查不通过，5.完工检查通过，6.申请退款中，7.装修结束（已退押金），8.已作废)
     */
    private Integer status;
    /**
     * 最后一次检查是否合格（1.合格，0.不合格）
     */
    private Integer isQualified;

    @Override
    public String toString() {
        return "VoRefundDecorationDetail{" +
                "id=" + id +
                ", status=" + status +
                ", isQualified=" + isQualified +
                '}';
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Integer getStatus() {
        return status;
    }

    public void setStatus(Integer status) {
        this.status = status;
    }

    public Integer getIsQualified() {
        return isQualified;
    }

    public void setIsQualified(Integer isQualified) {
        this.isQualified = isQualified;
    }

    public VoRefundDecorationDetail() {
    }

    public VoRefundDecorationDetail(Integer id, Integer status, Integer isQualified) {
        this.id = id;
        this.status = status;
        this.isQualified = isQualified;
    }
}
