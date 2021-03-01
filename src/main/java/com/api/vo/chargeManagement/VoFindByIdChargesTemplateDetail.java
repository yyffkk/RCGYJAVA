package com.api.vo.chargeManagement;

import java.math.BigDecimal;
import java.util.List;

/**
 * 物业收费标准明细Vo findById 回显
 */
public class VoFindByIdChargesTemplateDetail {
    /**
     * 主键id
     */
    private Integer id;
    /**
     * 模版id
     */
    private Integer chargesTemplateId;
    /**
     * 收费名称
     */
    private String name;
    /**
     * 状态（1.启用，0.未启用）
     */
    private Integer status;
    /**
     * 单价
     */
    private BigDecimal unitPrice;
    /**
     * 收费类型
     */
    private Integer type;
    /**
     * 附加或固定费用集合
     */
    private List<VoChargesTemplateAdditionalCost> additionalCostList;
    /**
     * 标记符【费用类型名称】（1.物业管理费，2.维修费（报事报修 唯一）,3.押金，4.活动报名费）
     */
    private Integer marker;

    @Override
    public String toString() {
        return "VoFindByIdChargesTemplateDetail{" +
                "id=" + id +
                ", chargesTemplateId=" + chargesTemplateId +
                ", name='" + name + '\'' +
                ", status=" + status +
                ", unitPrice=" + unitPrice +
                ", type=" + type +
                ", additionalCostList=" + additionalCostList +
                ", marker=" + marker +
                '}';
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Integer getChargesTemplateId() {
        return chargesTemplateId;
    }

    public void setChargesTemplateId(Integer chargesTemplateId) {
        this.chargesTemplateId = chargesTemplateId;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Integer getStatus() {
        return status;
    }

    public void setStatus(Integer status) {
        this.status = status;
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

    public Integer getMarker() {
        return marker;
    }

    public void setMarker(Integer marker) {
        this.marker = marker;
    }

    public VoFindByIdChargesTemplateDetail() {
    }

    public VoFindByIdChargesTemplateDetail(Integer id, Integer chargesTemplateId, String name, Integer status, BigDecimal unitPrice, Integer type, List<VoChargesTemplateAdditionalCost> additionalCostList, Integer marker) {
        this.id = id;
        this.chargesTemplateId = chargesTemplateId;
        this.name = name;
        this.status = status;
        this.unitPrice = unitPrice;
        this.type = type;
        this.additionalCostList = additionalCostList;
        this.marker = marker;
    }
}
