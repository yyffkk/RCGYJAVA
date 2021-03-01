package com.api.vo.app;

import java.math.BigDecimal;
import java.util.List;

/**
 * app装修费用信息Vo list 回显
 */
public class AppDecorationCostVo {
    /**
     * 主键id
     */
    private Integer id;
    /**
     * 费用名称
     */
    private String name;
    /**
     * 装修押金
     */
    private BigDecimal unitPrice;
    /**
     * 装修附加费用
     */
    private List<AppDecorationAdditionalCostVo> additionalCostVos;
    /**
     * 装修须知doc路径
     */
    private String docUrl;

    @Override
    public String toString() {
        return "AppDecorationCostVo{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", unitPrice=" + unitPrice +
                ", additionalCostVos=" + additionalCostVos +
                ", docUrl='" + docUrl + '\'' +
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

    public BigDecimal getUnitPrice() {
        return unitPrice;
    }

    public void setUnitPrice(BigDecimal unitPrice) {
        this.unitPrice = unitPrice;
    }

    public List<AppDecorationAdditionalCostVo> getAdditionalCostVos() {
        return additionalCostVos;
    }

    public void setAdditionalCostVos(List<AppDecorationAdditionalCostVo> additionalCostVos) {
        this.additionalCostVos = additionalCostVos;
    }

    public String getDocUrl() {
        return docUrl;
    }

    public void setDocUrl(String docUrl) {
        this.docUrl = docUrl;
    }

    public AppDecorationCostVo() {
    }

    public AppDecorationCostVo(Integer id, String name, BigDecimal unitPrice, List<AppDecorationAdditionalCostVo> additionalCostVos, String docUrl) {
        this.id = id;
        this.name = name;
        this.unitPrice = unitPrice;
        this.additionalCostVos = additionalCostVos;
        this.docUrl = docUrl;
    }
}
