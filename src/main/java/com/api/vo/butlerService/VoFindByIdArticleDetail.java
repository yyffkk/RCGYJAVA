package com.api.vo.butlerService;

import com.api.vo.resources.VoResourcesImg;

import java.util.List;

/**
 * 物品明细管理表 Vo findById 回显
 */
public class VoFindByIdArticleDetail {
    /**
     * 物品明细主键id
     */
    private Integer id;
    /**
     * 物品主键id
     */
    private Integer articleId;
    /**
     * 物品明细名称
     */
    private String name;
    /**
     * 物品单号
     */
    private String code;
    /**
     * 状态
     */
    private Integer status;
    /**
     * 照片资源信息集合
     */
    private List<VoResourcesImg> imgUrl;

    @Override
    public String toString() {
        return "VoFindByIdArticleDetail{" +
                "id=" + id +
                ", articleId=" + articleId +
                ", name='" + name + '\'' +
                ", code='" + code + '\'' +
                ", status=" + status +
                ", imgUrl=" + imgUrl +
                '}';
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Integer getArticleId() {
        return articleId;
    }

    public void setArticleId(Integer articleId) {
        this.articleId = articleId;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getCode() {
        return code;
    }

    public void setCode(String code) {
        this.code = code;
    }

    public Integer getStatus() {
        return status;
    }

    public void setStatus(Integer status) {
        this.status = status;
    }

    public List<VoResourcesImg> getImgUrl() {
        return imgUrl;
    }

    public void setImgUrl(List<VoResourcesImg> imgUrl) {
        this.imgUrl = imgUrl;
    }

    public VoFindByIdArticleDetail() {
    }

    public VoFindByIdArticleDetail(Integer id, Integer articleId, String name, String code, Integer status, List<VoResourcesImg> imgUrl) {
        this.id = id;
        this.articleId = articleId;
        this.name = name;
        this.code = code;
        this.status = status;
        this.imgUrl = imgUrl;
    }
}
