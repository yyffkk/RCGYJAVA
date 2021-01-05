package com.api.model.chargeManagement;

import java.math.BigDecimal;

/**
 * 房产id和建筑面积
 */
public class EstateIdAndConstructionArea {
    /**
     * 房产id
     */
    private Integer id;
    /**
     * 建筑面积
     */
    private BigDecimal constructionArea;

    @Override
    public String toString() {
        return "EstateIdAndConstructionArea{" +
                "id=" + id +
                ", constructionArea=" + constructionArea +
                '}';
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public BigDecimal getConstructionArea() {
        return constructionArea;
    }

    public void setConstructionArea(BigDecimal constructionArea) {
        this.constructionArea = constructionArea;
    }

    public EstateIdAndConstructionArea() {
    }

    public EstateIdAndConstructionArea(Integer id, BigDecimal constructionArea) {
        this.id = id;
        this.constructionArea = constructionArea;
    }
}
