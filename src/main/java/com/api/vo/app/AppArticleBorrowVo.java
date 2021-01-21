package com.api.vo.app;

import com.api.vo.resources.VoResourcesImg;

import java.util.List;

/**
 * app物品所有可借信息Vo list 回显
 */
public class AppArticleBorrowVo {
    /**
     * 物品主键id
     */
    private Integer id;
    /**
     * 物品名称
     */
    private String name;
    /**
     * 可借数量剩余
     */
    private Integer quantity;
    /**
     * 照片资源集合
     */
    private List<VoResourcesImg> imgUrls;

    @Override
    public String toString() {
        return "AppArticleBorrowVo{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", quantity=" + quantity +
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

    public List<VoResourcesImg> getImgUrls() {
        return imgUrls;
    }

    public void setImgUrls(List<VoResourcesImg> imgUrls) {
        this.imgUrls = imgUrls;
    }

    public AppArticleBorrowVo() {
    }

    public AppArticleBorrowVo(Integer id, String name, Integer quantity, List<VoResourcesImg> imgUrls) {
        this.id = id;
        this.name = name;
        this.quantity = quantity;
        this.imgUrls = imgUrls;
    }
}
