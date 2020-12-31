package com.api.model.chargeManagement;

import java.math.BigDecimal;
import java.util.Date;

/**
 * 固定金额分摊model
 */
public class SysFixedAmountAllocation {
    /**
     * 主键id
     */
    private Integer id;
    /**
     * 费用名称
     */
    private String name;
    /**
     * 分摊方式（1.按户分摊，2.按面积分摊）
     */
    private Integer shareType;
    /**
     * 总金额（分摊金额）
     */
    private BigDecimal totalPrice;
    /**
     * 开始时间
     */
    private Date startDate;
    /**
     * 截止时间
     */
    private Date endDate;
    /**
     * 状态，1.未分摊，2.已分摊
     */
    private Integer status;
    /**
     * 备注
     */
    private String remake;
    /**
     * 分摊范围（1.本小区所有房间，2.指定楼宇所有房间，3.指定房间）
     */
    private Integer shareRange;
    /**
     * 分摊对象，形式为:（ xxx,xxx,xxx ）【只有分摊范围为2，3需要填写】
     */
    private String shareObjects;
    /**
     * 分摊时间（点击分摊按钮的时间）
     */
    private Date shareDate;
    /**
     * 分摊操作人
     */
    private Integer shareOperator;
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
     * 是否删除，0.删除，1.非删
     */
    private Integer isDelete;

    @Override
    public String toString() {
        return "SysFixedAmountAllocation{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", shareType=" + shareType +
                ", totalPrice=" + totalPrice +
                ", startDate=" + startDate +
                ", endDate=" + endDate +
                ", status=" + status +
                ", remake='" + remake + '\'' +
                ", shareRange=" + shareRange +
                ", shareObjects='" + shareObjects + '\'' +
                ", shareDate=" + shareDate +
                ", shareOperator=" + shareOperator +
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

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Integer getShareType() {
        return shareType;
    }

    public void setShareType(Integer shareType) {
        this.shareType = shareType;
    }

    public BigDecimal getTotalPrice() {
        return totalPrice;
    }

    public void setTotalPrice(BigDecimal totalPrice) {
        this.totalPrice = totalPrice;
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

    public Integer getShareRange() {
        return shareRange;
    }

    public void setShareRange(Integer shareRange) {
        this.shareRange = shareRange;
    }

    public String getShareObjects() {
        return shareObjects;
    }

    public void setShareObjects(String shareObjects) {
        this.shareObjects = shareObjects;
    }

    public Date getShareDate() {
        return shareDate;
    }

    public void setShareDate(Date shareDate) {
        this.shareDate = shareDate;
    }

    public Integer getShareOperator() {
        return shareOperator;
    }

    public void setShareOperator(Integer shareOperator) {
        this.shareOperator = shareOperator;
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

    public SysFixedAmountAllocation() {
    }

    public SysFixedAmountAllocation(Integer id, String name, Integer shareType, BigDecimal totalPrice, Date startDate, Date endDate, Integer status, String remake, Integer shareRange, String shareObjects, Date shareDate, Integer shareOperator, Integer createId, Date createDate, Integer modifyId, Date modifyDate, Integer isDelete) {
        this.id = id;
        this.name = name;
        this.shareType = shareType;
        this.totalPrice = totalPrice;
        this.startDate = startDate;
        this.endDate = endDate;
        this.status = status;
        this.remake = remake;
        this.shareRange = shareRange;
        this.shareObjects = shareObjects;
        this.shareDate = shareDate;
        this.shareOperator = shareOperator;
        this.createId = createId;
        this.createDate = createDate;
        this.modifyId = modifyId;
        this.modifyDate = modifyDate;
        this.isDelete = isDelete;
    }
}
