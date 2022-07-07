package com.api.vo.app;

import java.util.List;

/**
 * app 生活缴费明细类别Vo list 回显
 */
public class AppDailyPaymentTypeVo {
    /**
     * 费用名称类型id
     */
    private Integer id;
    /**
     * 费用名称类型名称
     */
    private String name;
    /**
     * app 生活缴费明细Vo list 回显
     */
    private List<AppDailyPaymentDetailedVo> detailedVoList;

    @Override
    public String toString() {
        return "AppDailyPaymentTypeVo{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", detailedVoList=" + detailedVoList +
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

    public List<AppDailyPaymentDetailedVo> getDetailedVoList() {
        return detailedVoList;
    }

    public void setDetailedVoList(List<AppDailyPaymentDetailedVo> detailedVoList) {
        this.detailedVoList = detailedVoList;
    }

    public AppDailyPaymentTypeVo() {
    }

    public AppDailyPaymentTypeVo(Integer id, String name, List<AppDailyPaymentDetailedVo> detailedVoList) {
        this.id = id;
        this.name = name;
        this.detailedVoList = detailedVoList;
    }
}
