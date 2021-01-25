package com.api.model.app;

/**
 * 生活缴费详情条件
 */
public class AppDailyPaymentDetail {
    /**
     * 房产id
     */
    private Integer estateId;
    /**
     * 年份
     */
    private Integer years;
    /**
     * 费用名称类型(取自 物业收费标准明细表)
     */
    private Integer chargesTemplateDetailId;
    /**
     * 分组 1.上半年 2.下半年
     */
    private Integer groupId;

    @Override
    public String toString() {
        return "AppDailyPaymentDetail{" +
                "estateId=" + estateId +
                ", years=" + years +
                ", chargesTemplateDetailId=" + chargesTemplateDetailId +
                ", groupId=" + groupId +
                '}';
    }

    public Integer getEstateId() {
        return estateId;
    }

    public void setEstateId(Integer estateId) {
        this.estateId = estateId;
    }

    public Integer getYears() {
        return years;
    }

    public void setYears(Integer years) {
        this.years = years;
    }

    public Integer getChargesTemplateDetailId() {
        return chargesTemplateDetailId;
    }

    public void setChargesTemplateDetailId(Integer chargesTemplateDetailId) {
        this.chargesTemplateDetailId = chargesTemplateDetailId;
    }

    public Integer getGroupId() {
        return groupId;
    }

    public void setGroupId(Integer groupId) {
        this.groupId = groupId;
    }

    public AppDailyPaymentDetail() {
    }

    public AppDailyPaymentDetail(Integer estateId, Integer years, Integer chargesTemplateDetailId, Integer groupId) {
        this.estateId = estateId;
        this.years = years;
        this.chargesTemplateDetailId = chargesTemplateDetailId;
        this.groupId = groupId;
    }
}
