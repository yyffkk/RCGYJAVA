package com.api.model.butlerApp;

import java.util.Date;

/**
 * 管家app 物品明细 model
 */
public class ButlerArticleDetail {
    /**
     * 物品明细主键id
     */
    private Integer id;
    /**
     * 物品主键id
     */
    private Integer articleId;
    /**
     * 物品单号（物品编号用于生成二维码）
     */
    private String code;
    /**
     * 物品状态(1.正常，2.破损，3.丢失)
     */
    private Integer status;
    /**
     * 创建人
     */
    private Integer createId;
    /**
     * 创建时间
     */
    private Date createDate;
    /**
     * 修改人
     */
    private Integer modifyId;
    /**
     * 修改时间
     */
    private Date modifyDate;

    @Override
    public String toString() {
        return "ButlerArticleDetail{" +
                "id=" + id +
                ", articleId=" + articleId +
                ", code='" + code + '\'' +
                ", status=" + status +
                ", createId=" + createId +
                ", createDate=" + createDate +
                ", modifyId=" + modifyId +
                ", modifyDate=" + modifyDate +
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

    public Integer getCreateId() {
        return createId;
    }

    public void setCreateId(Integer createId) {
        this.createId = createId;
    }

    public Date getCreateDate() {
        return createDate;
    }

    public void setCreateDate(Date createDate) {
        this.createDate = createDate;
    }

    public Integer getModifyId() {
        return modifyId;
    }

    public void setModifyId(Integer modifyId) {
        this.modifyId = modifyId;
    }

    public Date getModifyDate() {
        return modifyDate;
    }

    public void setModifyDate(Date modifyDate) {
        this.modifyDate = modifyDate;
    }

    public ButlerArticleDetail() {
    }

    public ButlerArticleDetail(Integer id, Integer articleId, String code, Integer status, Integer createId, Date createDate, Integer modifyId, Date modifyDate) {
        this.id = id;
        this.articleId = articleId;
        this.code = code;
        this.status = status;
        this.createId = createId;
        this.createDate = createDate;
        this.modifyId = modifyId;
        this.modifyDate = modifyDate;
    }
}
