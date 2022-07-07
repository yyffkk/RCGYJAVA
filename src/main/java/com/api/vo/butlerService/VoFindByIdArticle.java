package com.api.vo.butlerService;

import com.api.model.butlerService.ArticleDetail;
import com.api.model.resources.ResourcesImg;
import com.api.vo.resources.VoResourcesImg;

import java.util.List;

/**
 * 物品信息 Vo findById 回显
 */
public class VoFindByIdArticle {
    /**
     * 物品信息主键id
     */
    private Integer id;
    /**
     * 照片资源信息集合
     */
    private List<VoResourcesImg> imgUrl;
    /**
     * 物品名称
     */
    private String name;
    /**
     * 物品数量
     */
    private Integer quantity;
    /**
     * 物品明细信息集合
     */
    private List<VoFindByIdArticleDetail> voFindByIdArticleDetailList;

    @Override
    public String toString() {
        return "VoFindByIdArticle{" +
                "id=" + id +
                ", imgUrl=" + imgUrl +
                ", name='" + name + '\'' +
                ", quantity=" + quantity +
                ", voFindByIdArticleDetailList=" + voFindByIdArticleDetailList +
                '}';
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public List<VoResourcesImg> getImgUrl() {
        return imgUrl;
    }

    public void setImgUrl(List<VoResourcesImg> imgUrl) {
        this.imgUrl = imgUrl;
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

    public List<VoFindByIdArticleDetail> getVoFindByIdArticleDetailList() {
        return voFindByIdArticleDetailList;
    }

    public void setVoFindByIdArticleDetailList(List<VoFindByIdArticleDetail> voFindByIdArticleDetailList) {
        this.voFindByIdArticleDetailList = voFindByIdArticleDetailList;
    }

    public VoFindByIdArticle() {
    }

    public VoFindByIdArticle(Integer id, List<VoResourcesImg> imgUrl, String name, Integer quantity, List<VoFindByIdArticleDetail> voFindByIdArticleDetailList) {
        this.id = id;
        this.imgUrl = imgUrl;
        this.name = name;
        this.quantity = quantity;
        this.voFindByIdArticleDetailList = voFindByIdArticleDetailList;
    }
}
