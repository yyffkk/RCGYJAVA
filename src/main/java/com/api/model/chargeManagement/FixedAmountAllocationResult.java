package com.api.model.chargeManagement;

import java.math.BigDecimal;
import java.util.Date;

/**
 * 固定金额分摊结果model
 */
public class FixedAmountAllocationResult {
    /**
     * 主键id
     */
    private Integer id;
    /**
     * 固定金额分摊id
     */
    private Integer fixedAmountAllocationId;
    /**
     * 房产id
     */
    private Integer estateId;
    /**
     * 分摊金额
     */
    private BigDecimal sharePrice;
    /**
     * 状态，1.未缴纳，2.已缴纳但无凭证，3.已缴纳有凭证
     */
    private Integer status;
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
        return "FixedAmountAllocationResult{" +
                "id=" + id +
                ", fixedAmountAllocationId=" + fixedAmountAllocationId +
                ", estateId=" + estateId +
                ", sharePrice=" + sharePrice +
                ", status=" + status +
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

    public Integer getFixedAmountAllocationId() {
        return fixedAmountAllocationId;
    }

    public void setFixedAmountAllocationId(Integer fixedAmountAllocationId) {
        this.fixedAmountAllocationId = fixedAmountAllocationId;
    }

    public Integer getEstateId() {
        return estateId;
    }

    public void setEstateId(Integer estateId) {
        this.estateId = estateId;
    }

    public BigDecimal getSharePrice() {
        return sharePrice;
    }

    public void setSharePrice(BigDecimal sharePrice) {
        this.sharePrice = sharePrice;
    }

    public Integer getStatus() {
        return status;
    }

    public void setStatus(Integer status) {
        this.status = status;
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

    public FixedAmountAllocationResult() {
    }

    public FixedAmountAllocationResult(Integer id, Integer fixedAmountAllocationId, Integer estateId, BigDecimal sharePrice, Integer status, Integer createId, Date createDate, Integer modifyId, Date modifyDate) {
        this.id = id;
        this.fixedAmountAllocationId = fixedAmountAllocationId;
        this.estateId = estateId;
        this.sharePrice = sharePrice;
        this.status = status;
        this.createId = createId;
        this.createDate = createDate;
        this.modifyId = modifyId;
        this.modifyDate = modifyDate;
    }
}
