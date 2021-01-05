package com.api.vo.chargeManagement;

import java.math.BigDecimal;
import java.util.Date;

/**
 * 固定金额分摊Vo findById 回显
 */
public class VoFindByIdFAA {
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

    @Override
    public String toString() {
        return "VoFindByIdFAA{" +
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

    public VoFindByIdFAA() {
    }

    public VoFindByIdFAA(Integer id, String name, Integer shareType, BigDecimal totalPrice, Date startDate, Date endDate, Integer status, String remake, Integer shareRange, String shareObjects) {
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
    }
}
