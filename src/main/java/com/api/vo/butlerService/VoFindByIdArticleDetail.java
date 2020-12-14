package com.api.vo.butlerService;
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
     * 物品单号
     */
    private String code;
    /**
     * 状态
     */
    private Integer status;

    @Override
    public String toString() {
        return "VoFindByIdArticleDetail{" +
                "id=" + id +
                ", articleId=" + articleId +
                ", code='" + code + '\'' +
                ", status=" + status +
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

    public VoFindByIdArticleDetail() {
    }

    public VoFindByIdArticleDetail(Integer id, Integer articleId, String code, Integer status) {
        this.id = id;
        this.articleId = articleId;
        this.code = code;
        this.status = status;
    }
}
