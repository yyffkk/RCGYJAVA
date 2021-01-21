package com.api.vo.butlerService;

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

    @Override
    public String toString() {
        return "VoArticle{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", quantity=" + quantity +
                ", stock=" + stock +
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

    public VoArticle() {
    }

    public VoArticle(Integer id, String name, Integer quantity, Integer stock) {
        this.id = id;
        this.name = name;
        this.quantity = quantity;
        this.stock = stock;
    }
}
