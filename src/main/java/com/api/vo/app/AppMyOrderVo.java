package com.api.vo.app;

import com.api.vo.resources.VoResourcesImg;

import java.math.BigDecimal;
import java.util.Date;
import java.util.List;

public class AppMyOrderVo {
    /**
     * 商品预约主键id
     */
    private Integer id;
    /**
     * 商品预约编号
     */
    private String code;
    /**
     * 商品主键id
     */
    private Integer goodsId;
    /**
     * 商品名称
     */
    private String goodsName;
    /**
     * 客户期望：1.退货，2.换货
     */
    private Integer backType;
    /**
     * 商品照片
     */
    private List<VoResourcesImg> goodsImgList;
    /**
     * 售卖价
     */
    private BigDecimal sellingPrice;
    /**
     * 划线价
     */
    private BigDecimal markingPrice;
    /**
     * 商品数量
     */
    private Integer num;
    /**
     * 供应商主键id
     */
    private Integer supplierId;
    /**
     * 供应商名称
     */
    private String supplierName;
    /**
     * 一级分类名称
     */
    private String levelOneCategory;
    /**
     * 二级分类名称
     */
    private String levelTwoCategory;
    /**
     * 状态：状态：1.待发货，2.已发货，3.已到货，4.已收货，6.已评价[当状态>=4.已收货并评价]，8.申请退换货，9.申请通过，10.申请驳回
     */
    private Integer status;
    /**
     * 发货时间
     */
    private Date sendDate;
    /**
     * 发货详情
     */
    private String sendDetail;
    /**
     * 到货时间
     */
    private Date arrivalDate;
    /**
     * 收货时间
     */
    private Date receivingDate;
    /**
     * 申请退货时间
     */
    private Date backDate;
    /**
     * 退换货理由
     */
    private String backReason;
    /**
     * 审核通过/驳回原因
     */
    private String reason;
    /**
     * 评分数1-10分
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
     * 到货时间说明
     */
    private String arrivalTime;
    /**
     * 创建时间
     */
    private Date createDate;

    @Override
    public String toString() {
        return "AppMyOrderVo{" +
                "id=" + id +
                ", code='" + code + '\'' +
                ", goodsId=" + goodsId +
                ", goodsName='" + goodsName + '\'' +
                ", backType=" + backType +
                ", goodsImgList=" + goodsImgList +
                ", sellingPrice=" + sellingPrice +
                ", markingPrice=" + markingPrice +
                ", num=" + num +
                ", supplierId=" + supplierId +
                ", supplierName='" + supplierName + '\'' +
                ", levelOneCategory='" + levelOneCategory + '\'' +
                ", levelTwoCategory='" + levelTwoCategory + '\'' +
                ", status=" + status +
                ", sendDate=" + sendDate +
                ", sendDetail='" + sendDetail + '\'' +
                ", arrivalDate=" + arrivalDate +
                ", receivingDate=" + receivingDate +
                ", backDate=" + backDate +
                ", backReason='" + backReason + '\'' +
                ", reason='" + reason + '\'' +
                ", score=" + score +
                ", evaluationDate=" + evaluationDate +
                ", evaluationReason='" + evaluationReason + '\'' +
                ", arrivalTime='" + arrivalTime + '\'' +
                ", createDate=" + createDate +
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

    public Integer getGoodsId() {
        return goodsId;
    }

    public void setGoodsId(Integer goodsId) {
        this.goodsId = goodsId;
    }

    public String getGoodsName() {
        return goodsName;
    }

    public void setGoodsName(String goodsName) {
        this.goodsName = goodsName;
    }

    public Integer getBackType() {
        return backType;
    }

    public void setBackType(Integer backType) {
        this.backType = backType;
    }

    public List<VoResourcesImg> getGoodsImgList() {
        return goodsImgList;
    }

    public void setGoodsImgList(List<VoResourcesImg> goodsImgList) {
        this.goodsImgList = goodsImgList;
    }

    public BigDecimal getSellingPrice() {
        return sellingPrice;
    }

    public void setSellingPrice(BigDecimal sellingPrice) {
        this.sellingPrice = sellingPrice;
    }

    public BigDecimal getMarkingPrice() {
        return markingPrice;
    }

    public void setMarkingPrice(BigDecimal markingPrice) {
        this.markingPrice = markingPrice;
    }

    public Integer getNum() {
        return num;
    }

    public void setNum(Integer num) {
        this.num = num;
    }

    public Integer getSupplierId() {
        return supplierId;
    }

    public void setSupplierId(Integer supplierId) {
        this.supplierId = supplierId;
    }

    public String getSupplierName() {
        return supplierName;
    }

    public void setSupplierName(String supplierName) {
        this.supplierName = supplierName;
    }

    public String getLevelOneCategory() {
        return levelOneCategory;
    }

    public void setLevelOneCategory(String levelOneCategory) {
        this.levelOneCategory = levelOneCategory;
    }

    public String getLevelTwoCategory() {
        return levelTwoCategory;
    }

    public void setLevelTwoCategory(String levelTwoCategory) {
        this.levelTwoCategory = levelTwoCategory;
    }

    public Integer getStatus() {
        return status;
    }

    public void setStatus(Integer status) {
        this.status = status;
    }

    public Date getSendDate() {
        return sendDate;
    }

    public void setSendDate(Date sendDate) {
        this.sendDate = sendDate;
    }

    public String getSendDetail() {
        return sendDetail;
    }

    public void setSendDetail(String sendDetail) {
        this.sendDetail = sendDetail;
    }

    public Date getArrivalDate() {
        return arrivalDate;
    }

    public void setArrivalDate(Date arrivalDate) {
        this.arrivalDate = arrivalDate;
    }

    public Date getReceivingDate() {
        return receivingDate;
    }

    public void setReceivingDate(Date receivingDate) {
        this.receivingDate = receivingDate;
    }

    public Date getBackDate() {
        return backDate;
    }

    public void setBackDate(Date backDate) {
        this.backDate = backDate;
    }

    public String getBackReason() {
        return backReason;
    }

    public void setBackReason(String backReason) {
        this.backReason = backReason;
    }

    public String getReason() {
        return reason;
    }

    public void setReason(String reason) {
        this.reason = reason;
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

    public String getArrivalTime() {
        return arrivalTime;
    }

    public void setArrivalTime(String arrivalTime) {
        this.arrivalTime = arrivalTime;
    }

    public Date getCreateDate() {
        return createDate;
    }

    public void setCreateDate(Date createDate) {
        this.createDate = createDate;
    }

    public AppMyOrderVo() {
    }

    public AppMyOrderVo(Integer id, String code, Integer goodsId, String goodsName, Integer backType, List<VoResourcesImg> goodsImgList, BigDecimal sellingPrice, BigDecimal markingPrice, Integer num, Integer supplierId, String supplierName, String levelOneCategory, String levelTwoCategory, Integer status, Date sendDate, String sendDetail, Date arrivalDate, Date receivingDate, Date backDate, String backReason, String reason, Integer score, Date evaluationDate, String evaluationReason, String arrivalTime, Date createDate) {
        this.id = id;
        this.code = code;
        this.goodsId = goodsId;
        this.goodsName = goodsName;
        this.backType = backType;
        this.goodsImgList = goodsImgList;
        this.sellingPrice = sellingPrice;
        this.markingPrice = markingPrice;
        this.num = num;
        this.supplierId = supplierId;
        this.supplierName = supplierName;
        this.levelOneCategory = levelOneCategory;
        this.levelTwoCategory = levelTwoCategory;
        this.status = status;
        this.sendDate = sendDate;
        this.sendDetail = sendDetail;
        this.arrivalDate = arrivalDate;
        this.receivingDate = receivingDate;
        this.backDate = backDate;
        this.backReason = backReason;
        this.reason = reason;
        this.score = score;
        this.evaluationDate = evaluationDate;
        this.evaluationReason = evaluationReason;
        this.arrivalTime = arrivalTime;
        this.createDate = createDate;
    }
}
