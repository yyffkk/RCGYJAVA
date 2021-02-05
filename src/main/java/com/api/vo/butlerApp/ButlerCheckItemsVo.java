package com.api.vo.butlerApp;

import com.api.vo.resources.VoResourcesImg;

import java.util.List;

/**
 * 管家app 检查信息Vo findById 回显
 */
public class ButlerCheckItemsVo {
    /**
     * 借还管理主键id
     */
    private Integer id;
    /**
     * 物品明细主键id
     */
    private Integer articleDetailId;
    /**
     * 物品名称
     */
    private String articleName;
    /**
     * 物品单号
     */
    private String code;
    /**
     * 借还管理物品状态
     */
    private Integer status;
    /**
     * 照片资源信息，物品明细照片
     */
    List<VoResourcesImg> imgUrls;

    @Override
    public String toString() {
        return "ButlerCheckItemsVo{" +
                "id=" + id +
                ", articleDetailId=" + articleDetailId +
                ", articleName='" + articleName + '\'' +
                ", code='" + code + '\'' +
                ", status=" + status +
                ", imgUrls=" + imgUrls +
                '}';
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Integer getArticleDetailId() {
        return articleDetailId;
    }

    public void setArticleDetailId(Integer articleDetailId) {
        this.articleDetailId = articleDetailId;
    }

    public String getArticleName() {
        return articleName;
    }

    public void setArticleName(String articleName) {
        this.articleName = articleName;
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

    public List<VoResourcesImg> getImgUrls() {
        return imgUrls;
    }

    public void setImgUrls(List<VoResourcesImg> imgUrls) {
        this.imgUrls = imgUrls;
    }

    public ButlerCheckItemsVo() {
    }

    public ButlerCheckItemsVo(Integer id, Integer articleDetailId, String articleName, String code, Integer status, List<VoResourcesImg> imgUrls) {
        this.id = id;
        this.articleDetailId = articleDetailId;
        this.articleName = articleName;
        this.code = code;
        this.status = status;
        this.imgUrls = imgUrls;
    }
}
