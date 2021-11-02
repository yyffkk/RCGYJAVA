package com.api.vo.butlerApp;

import com.api.vo.resources.VoResourcesImg;

import java.util.Date;
import java.util.List;

/**
 * 管家app 借还管理Vo list 回显
 */
public class ButlerBorrowVo {
    /**
     * 借还管理主键id
     */
    private Integer id;
    /**
     * 物品明细管理主键id
     */
    private Integer articleDetailId;
    /**
     * 借还物品名称
     */
    private String articleName;
    /**
     * 借取状态（-1.出借审核中，0.出借审核失败，1.出借中，2.已还，3.待检查）
     */
    private Integer borrowStatus;
    /**
     * 物品状态（1.正常，2.损坏，3.丢失）
     */
    private Integer status;
    /**
     * 借用时长
     */
    private Long borrowTime;
    /**
     * 借出时间
     */
    private Date beginDate;
    /**
     * 归还时间
     */
    private Date endDate;
    /**
     * 借用人员姓名
     */
    private String borrowName;
    /**
     * 借用人员联系方式
     */
    private String borrowTel;
    /**
     * 创建时间
     */
    private Date createDate;
    /**
     * 照片资源集合
     */
    private List<VoResourcesImg> imgUrls;

    @Override
    public String toString() {
        return "ButlerBorrowVo{" +
                "id=" + id +
                ", articleDetailId=" + articleDetailId +
                ", articleName='" + articleName + '\'' +
                ", borrowStatus=" + borrowStatus +
                ", status=" + status +
                ", borrowTime=" + borrowTime +
                ", beginDate=" + beginDate +
                ", endDate=" + endDate +
                ", borrowName='" + borrowName + '\'' +
                ", borrowTel='" + borrowTel + '\'' +
                ", createDate=" + createDate +
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

    public Long getBorrowTime() {
        return borrowTime;
    }

    public void setBorrowTime(Long borrowTime) {
        this.borrowTime = borrowTime;
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

    public String getBorrowName() {
        return borrowName;
    }

    public void setBorrowName(String borrowName) {
        this.borrowName = borrowName;
    }

    public String getBorrowTel() {
        return borrowTel;
    }

    public void setBorrowTel(String borrowTel) {
        this.borrowTel = borrowTel;
    }

    public Date getCreateDate() {
        return createDate;
    }

    public void setCreateDate(Date createDate) {
        this.createDate = createDate;
    }

    public List<VoResourcesImg> getImgUrls() {
        return imgUrls;
    }

    public void setImgUrls(List<VoResourcesImg> imgUrls) {
        this.imgUrls = imgUrls;
    }

    public ButlerBorrowVo() {
    }

    public ButlerBorrowVo(Integer id, Integer articleDetailId, String articleName, Integer borrowStatus, Integer status, Long borrowTime, Date beginDate, Date endDate, String borrowName, String borrowTel, Date createDate, List<VoResourcesImg> imgUrls) {
        this.id = id;
        this.articleDetailId = articleDetailId;
        this.articleName = articleName;
        this.borrowStatus = borrowStatus;
        this.status = status;
        this.borrowTime = borrowTime;
        this.beginDate = beginDate;
        this.endDate = endDate;
        this.borrowName = borrowName;
        this.borrowTel = borrowTel;
        this.createDate = createDate;
        this.imgUrls = imgUrls;
    }
}
