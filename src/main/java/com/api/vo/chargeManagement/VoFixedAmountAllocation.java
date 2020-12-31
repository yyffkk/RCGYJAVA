package com.api.vo.chargeManagement;

import java.math.BigDecimal;
import java.util.Date;

/**
 * 固定金额分摊 Vo list 回显
 */
public class VoFixedAmountAllocation {
    /**
     * 主键id
     */
    private Integer id;
    /**
     * 费用名称
     */
    private String name;
    /**
     * 总金额
     */
    private BigDecimal totalPrice;
    /**
     * 分摊方式（1.按户分摊，2.按面积分摊）
     */
    private Integer shareType;
    /**
     * 开始时间
     */
    private Date startDate;
    /**
     * 截止时间
     */
    private Date endDate;
    /**
     * 创建人
     */
    private String createName;
    /**
     * 创建时间
     */
    private Date createDate;
    /**
     * 分摊时间
     */
    private Date shareDate;
    /**
     * 分摊操作人名称
     */
    private String shareOperatorName;
    /**
     * 状态，1.未分摊，2.已分摊
     */
    private Integer status;
    /**
     * 备注
     */
    private String remake;

    @Override
    public String toString() {
        return "VoFixedAmountAllocation{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", totalPrice=" + totalPrice +
                ", shareType=" + shareType +
                ", startDate=" + startDate +
                ", endDate=" + endDate +
                ", createName='" + createName + '\'' +
                ", createDate=" + createDate +
                ", shareDate=" + shareDate +
                ", shareOperatorName='" + shareOperatorName + '\'' +
                ", status=" + status +
                ", remake='" + remake + '\'' +
                '}';
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public BigDecimal getTotalPrice() {
        return totalPrice;
    }

    public void setTotalPrice(BigDecimal totalPrice) {
        this.totalPrice = totalPrice;
    }

    public Integer getShareType() {
        return shareType;
    }

    public void setShareType(Integer shareType) {
        this.shareType = shareType;
    }

    public Date getStartDate() {
        return startDate;
    }

    public void setStartDate(Date startDate) {
        this.startDate = startDate;
    }

    public Date getEndDate() {
        return endDate;
    }

    public void setEndDate(Date endDate) {
        this.endDate = endDate;
    }

    public String getCreateName() {
        return createName;
    }

    public void setCreateName(String createName) {
        this.createName = createName;
    }

    public Date getCreateDate() {
        return createDate;
    }

    public void setCreateDate(Date createDate) {
        this.createDate = createDate;
    }

    public Date getShareDate() {
        return shareDate;
    }

    public void setShareDate(Date shareDate) {
        this.shareDate = shareDate;
    }

    public String getShareOperatorName() {
        return shareOperatorName;
    }

    public void setShareOperatorName(String shareOperatorName) {
        this.shareOperatorName = shareOperatorName;
    }

    public Integer getStatus() {
        return status;
    }

    public void setStatus(Integer status) {
        this.status = status;
    }

    public String getRemake() {
        return remake;
    }

    public void setRemake(String remake) {
        this.remake = remake;
    }

    public VoFixedAmountAllocation() {
    }

    public VoFixedAmountAllocation(Integer id, String name, BigDecimal totalPrice, Integer shareType, Date startDate, Date endDate, String createName, Date createDate, Date shareDate, String shareOperatorName, Integer status, String remake) {
        this.id = id;
        this.name = name;
        this.totalPrice = totalPrice;
        this.shareType = shareType;
        this.startDate = startDate;
        this.endDate = endDate;
        this.createName = createName;
        this.createDate = createDate;
        this.shareDate = shareDate;
        this.shareOperatorName = shareOperatorName;
        this.status = status;
        this.remake = remake;
    }
}
