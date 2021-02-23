package com.api.vo.butlerService;

import com.api.vo.resources.VoResourcesImg;

import java.util.List;

/**
 * 查询物品管理信息Vo list 回显
 */
public class VoArticle {
    /**
     * 主键id
     */
    private Integer id;
    /**
     * 物品名称
     */
    private String name;
    /**
     * 物品数量
     */
    private Integer quantity;
    /**
     * 库存
     */
    private Integer stock;
    /**
     * 照片资源集合
     */
    private List<VoResourcesImg> imgUrls;

    @Override
    public String toString() {
        return "VoArticle{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", quantity=" + quantity +
                ", stock=" + stock +
                ", imgUrls=" + imgUrls +
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

    public Integer getQuantity() {
        return quantity;
    }

    public void setQuantity(Integer quantity) {
        this.quantity = quantity;
    }

    public Integer getStock() {
        return stock;
    }

    public void setStock(Integer stock) {
        this.stock = stock;
    }

    public List<VoResourcesImg> getImgUrls() {
        return imgUrls;
    }

    public void setImgUrls(List<VoResourcesImg> imgUrls) {
        this.imgUrls = imgUrls;
    }

    public VoArticle() {
    }

    public VoArticle(Integer id, String name, Integer quantity, Integer stock, List<VoResourcesImg> imgUrls) {
        this.id = id;
        this.name = name;
        this.quantity = quantity;
        this.stock = stock;
        this.imgUrls = imgUrls;
    }
}
