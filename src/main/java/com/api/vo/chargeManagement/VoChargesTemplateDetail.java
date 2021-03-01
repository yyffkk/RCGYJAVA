package com.api.vo.chargeManagement;

import java.math.BigDecimal;
import java.util.Date;
import java.util.List;

/**
 * 物业收费标准明细 Vo list 回显
 */
public class VoChargesTemplateDetail {
    /**
     * 物业收费标准明细主键id
     */
    private Integer id;
    /**
     * 收费名称
     */
    private String name;
    /**
     * 物业收费标准明细 状态（1.启用，0.未启用）
     */
    private Integer Status;
    /**
     * 标记符【费用类型名称】（1.物业管理费，2.维修费（报事报修 唯一）,3.押金，4.活动报名费）
     */
    private Integer marker;
    /**
     * 单价
     */
    private BigDecimal unitPrice;
    /**
     * 收费类型
     */
    private Integer type;
    /**
     * 附加或固定费用
     */
    private List<VoChargesTemplateAdditionalCost> additionalCostList;
    /**
     * 创建人姓名
     */
    private String createName;
    /**
     * 更新时间（如果修改时间为空，则为创建时间）
     */
    private Date modifyDate;

    @Override
    public String toString() {
        return "VoChargesTemplateDetail{" +
                "id=" + id +
                ", Status=" + Status +
                ", name='" + name + '\'' +
                ", marker=" + marker +
                ", unitPrice=" + unitPrice +
                ", type=" + type +
                ", additionalCostList=" + additionalCostList +
                ", createName='" + createName + '\'' +
                ", modifyDate=" + modifyDate +
                '}';
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Integer getStatus() {
        return Status;
    }

    public void setStatus(Integer status) {
        Status = status;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Integer getMarker() {
        return marker;
    }

    public void setMarker(Integer marker) {
        this.marker = marker;
    }

    public BigDecimal getUnitPrice() {
        return unitPrice;
    }

    public void setUnitPrice(BigDecimal unitPrice) {
        this.unitPrice = unitPrice;
    }

    public Integer getType() {
        return type;
    }

    public void setType(Integer type) {
        this.type = type;
    }

    public List<VoChargesTemplateAdditionalCost> getAdditionalCostList() {
        return additionalCostList;
    }

    public void setAdditionalCostList(List<VoChargesTemplateAdditionalCost> additionalCostList) {
        this.additionalCostList = additionalCostList;
    }

    public String getCreateName() {
        return createName;
    }

    public void setCreateName(String createName) {
        this.createName = createName;
    }

    public Date getModifyDate() {
        return modifyDate;
    }

    public void setModifyDate(Date modifyDate) {
        this.modifyDate = modifyDate;
    }

    public VoChargesTemplateDetail() {
    }

    public VoChargesTemplateDetail(Integer id, Integer status, String name, Integer marker, BigDecimal unitPrice, Integer type, List<VoChargesTemplateAdditionalCost> additionalCostList, String createName, Date modifyDate) {
        this.id = id;
        Status = status;
        this.name = name;
        this.marker = marker;
        this.unitPrice = unitPrice;
        this.type = type;
        this.additionalCostList = additionalCostList;
        this.createName = createName;
        this.modifyDate = modifyDate;
    }
}
