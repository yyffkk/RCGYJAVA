package com.api.model.app;

import java.util.Date;

/**
 * 物品借还信息
 */
public class AppArticleBorrow {
    /**
     * 借还主键id
     */
    private Integer id;
    /**
     * 物品明细id
     */
    private Integer articleDetailId;
    /**
     * 借取状态（1.出借中，2.已还，3.待检查）
     */
    private Integer borrowStatus;
    /**
     * 物品状态（1.正常，2.损坏，3.丢失）
     */
    private Integer status;
    /**
     * 借出时间
     */
    private Date beginDate;
    /**
     * 归还时间
     */
    private Date endDate;
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
    /**
     * 备注（损坏原因）
     */
    private String remake;

    @Override
    public String toString() {
        return "AppArticleBorrow{" +
                "id=" + id +
                ", articleDetailId=" + articleDetailId +
                ", borrowStatus=" + borrowStatus +
                ", status=" + status +
                ", beginDate=" + beginDate +
                ", endDate=" + endDate +
                ", createId=" + createId +
                ", createDate=" + createDate +
                ", modifyId=" + modifyId +
                ", modifyDate=" + modifyDate +
                ", remake='" + remake + '\'' +
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

    public Integer getBorrowStatus() {
        return borrowStatus;
    }

    public void setBorrowStatus(Integer borrowStatus) {
        this.borrowStatus = borrowStatus;
    }

    public Integer getStatus() {
        return status;
    }

    public void setStatus(Integer status) {
        this.status = status;
    }

    public Date getBeginDate() {
        return beginDate;
    }

    public void setBeginDate(Date beginDate) {
        this.beginDate = beginDate;
    }

    public Date getEndDate() {
        return endDate;
    }

    public void setEndDate(Date endDate) {
        this.endDate = endDate;
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

    public String getRemake() {
        return remake;
    }

    public void setRemake(String remake) {
        this.remake = remake;
    }

    public AppArticleBorrow() {
    }

    public AppArticleBorrow(Integer id, Integer articleDetailId, Integer borrowStatus, Integer status, Date beginDate, Date endDate, Integer createId, Date createDate, Integer modifyId, Date modifyDate, String remake) {
        this.id = id;
        this.articleDetailId = articleDetailId;
        this.borrowStatus = borrowStatus;
        this.status = status;
        this.beginDate = beginDate;
        this.endDate = endDate;
        this.createId = createId;
        this.createDate = createDate;
        this.modifyId = modifyId;
        this.modifyDate = modifyDate;
        this.remake = remake;
    }
}
