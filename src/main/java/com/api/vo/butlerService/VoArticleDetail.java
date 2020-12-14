package com.api.vo.butlerService;

/**
 * 物品明细管理Vo list 回显
 */
public class VoArticleDetail {
    /**
     * 物品明细主键id
     */
    private Integer id;
    /**
     * 物品管理主键id
     */
    private Integer articleId;
    /**
     * 物品名称
     */
    private String name;
    /**
     * 物品编号
     */
    private String code;
    /**
     * 状态（1.正常，2.破损）
     */
    private Integer status;

    @Override
    public String toString() {
        return "VoArticleDetail{" +
                "id=" + id +
                ", articleId=" + articleId +
                ", name='" + name + '\'' +
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

    public VoArticleDetail() {
    }

    public VoArticleDetail(Integer id, Integer articleId, String name, String code, Integer status) {
        this.id = id;
        this.articleId = articleId;
        this.name = name;
        this.code = code;
        this.status = status;
    }
}
