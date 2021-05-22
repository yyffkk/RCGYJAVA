package com.api.vo.operationManagement;

/**
 * 物料管理Vo list 回显
 */
public class VoMaterial {
    /**
     * 物料主键id
     */
    private Integer id;
    /**
     * 物料名称
     */
    private String name;
    /**
     * 物料库存
     */
    private Integer stock;

    @Override
    public String toString() {
        return "VoMaterial{" +
                "id=" + id +
                ", name='" + name + '\'' +
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

    public Integer getStock() {
        return stock;
    }

    public void setStock(Integer stock) {
        this.stock = stock;
    }

    public VoMaterial() {
    }

    public VoMaterial(Integer id, String name, Integer stock) {
        this.id = id;
        this.name = name;
        this.stock = stock;
    }
}
