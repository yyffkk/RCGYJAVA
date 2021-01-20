package com.api.vo.app;

import com.api.vo.resources.VoResourcesImg;

import java.math.BigDecimal;
import java.util.List;

/**
 * 维修结果Vo 显示信息
 */
public class AppMaintenanceResultVo {
    /**
     * 主键id
     */
    private Integer id;
    /**
     * 人工费
     */
    private BigDecimal laborCost;
    /**
     * 材料费
     */
    private BigDecimal materialCost;
    /**
     * 总计费
     */
    private BigDecimal totalCost;
    /**
     * 照片资源信息集合
     */
    private List<VoResourcesImg> imgUrls;

    @Override
    public String toString() {
        return "AppMaintenanceResultVo{" +
                "id=" + id +
                ", laborCost=" + laborCost +
                ", materialCost=" + materialCost +
                ", totalCost=" + totalCost +
                ", imgUrls=" + imgUrls +
                '}';
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public BigDecimal getLaborCost() {
        return laborCost;
    }

    public void setLaborCost(BigDecimal laborCost) {
        this.laborCost = laborCost;
    }

    public BigDecimal getMaterialCost() {
        return materialCost;
    }

    public void setMaterialCost(BigDecimal materialCost) {
        this.materialCost = materialCost;
    }

    public BigDecimal getTotalCost() {
        return totalCost;
    }

    public void setTotalCost(BigDecimal totalCost) {
        this.totalCost = totalCost;
    }

    public List<VoResourcesImg> getImgUrls() {
        return imgUrls;
    }

    public void setImgUrls(List<VoResourcesImg> imgUrls) {
        this.imgUrls = imgUrls;
    }

    public AppMaintenanceResultVo() {
    }

    public AppMaintenanceResultVo(Integer id, BigDecimal laborCost, BigDecimal materialCost, BigDecimal totalCost, List<VoResourcesImg> imgUrls) {
        this.id = id;
        this.laborCost = laborCost;
        this.materialCost = materialCost;
        this.totalCost = totalCost;
        this.imgUrls = imgUrls;
    }
}
