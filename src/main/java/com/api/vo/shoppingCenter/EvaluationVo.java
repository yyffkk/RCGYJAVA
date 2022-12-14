package com.api.vo.shoppingCenter;

import java.util.Date;

/**
 * 评价管理Vo list 回显
 */
public class EvaluationVo {
    /**
     * 商品预约主键id
     */
    private Integer id;
    /**
     * 商品预约编号
     */
    private String code;
    /**
     * 评价1-10
     */
    private Integer score;
    /**
     * 评价时间
     */
    private Date evaluationDate;
    /**
     * 评价原因
     */
    private String evaluationReason;
    /**
     * 客服回复内容
     */
    private String replyContent;
    /**
     * 客服回复时间
     */
    private Date replyDate;
    /**
     * 商品名称
     */
    private String goodsName;
    /**
     * 一级分类名称
     */
    private String categoryLevelOne;
    /**
     * 二级分类名称
     */
    private String categoryLevelTwo;
    /**
     * 评价人名称
     */
    private String createName;
    /**
     * 评价人手机号
     */
    private String createTel;
    /**
     * 供应商名称
     */
    private String supplierName;

    @Override
    public String toString() {
        return "EvaluationVo{" +
                "id=" + id +
                ", code='" + code + '\'' +
                ", score=" + score +
                ", evaluationDate=" + evaluationDate +
                ", evaluationReason='" + evaluationReason + '\'' +
                ", replyContent='" + replyContent + '\'' +
                ", replyDate=" + replyDate +
                ", goodsName='" + goodsName + '\'' +
                ", categoryLevelOne='" + categoryLevelOne + '\'' +
                ", categoryLevelTwo='" + categoryLevelTwo + '\'' +
                ", createName='" + createName + '\'' +
                ", createTel='" + createTel + '\'' +
                ", supplierName='" + supplierName + '\'' +
                '}';
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getCode() {
        return code;
    }

    public void setCode(String code) {
        this.code = code;
    }

    public Integer getScore() {
        return score;
    }

    public void setScore(Integer score) {
        this.score = score;
    }

    public Date getEvaluationDate() {
        return evaluationDate;
    }

    public void setEvaluationDate(Date evaluationDate) {
        this.evaluationDate = evaluationDate;
    }

    public String getEvaluationReason() {
        return evaluationReason;
    }

    public void setEvaluationReason(String evaluationReason) {
        this.evaluationReason = evaluationReason;
    }

    public String getReplyContent() {
        return replyContent;
    }

    public void setReplyContent(String replyContent) {
        this.replyContent = replyContent;
    }

    public Date getReplyDate() {
        return replyDate;
    }

    public void setReplyDate(Date replyDate) {
        this.replyDate = replyDate;
    }

    public String getGoodsName() {
        return goodsName;
    }

    public void setGoodsName(String goodsName) {
        this.goodsName = goodsName;
    }

    public String getCategoryLevelOne() {
        return categoryLevelOne;
    }

    public void setCategoryLevelOne(String categoryLevelOne) {
        this.categoryLevelOne = categoryLevelOne;
    }

    public String getCategoryLevelTwo() {
        return categoryLevelTwo;
    }

    public void setCategoryLevelTwo(String categoryLevelTwo) {
        this.categoryLevelTwo = categoryLevelTwo;
    }

    public String getCreateName() {
        return createName;
    }

    public void setCreateName(String createName) {
        this.createName = createName;
    }

    public String getCreateTel() {
        return createTel;
    }

    public void setCreateTel(String createTel) {
        this.createTel = createTel;
    }

    public String getSupplierName() {
        return supplierName;
    }

    public void setSupplierName(String supplierName) {
        this.supplierName = supplierName;
    }

    public EvaluationVo() {
    }

    public EvaluationVo(Integer id, String code, Integer score, Date evaluationDate, String evaluationReason, String replyContent, Date replyDate, String goodsName, String categoryLevelOne, String categoryLevelTwo, String createName, String createTel, String supplierName) {
        this.id = id;
        this.code = code;
        this.score = score;
        this.evaluationDate = evaluationDate;
        this.evaluationReason = evaluationReason;
        this.replyContent = replyContent;
        this.replyDate = replyDate;
        this.goodsName = goodsName;
        this.categoryLevelOne = categoryLevelOne;
        this.categoryLevelTwo = categoryLevelTwo;
        this.createName = createName;
        this.createTel = createTel;
        this.supplierName = supplierName;
    }
}
