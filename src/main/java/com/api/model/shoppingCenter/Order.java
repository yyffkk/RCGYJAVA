package com.api.model.shoppingCenter;

import java.math.BigDecimal;
import java.util.Date;

/**
 * 商品预约model（订单）
 */
public class Order {
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
     * 状态：1.待发货，2.已发货，3.已收货，4.申请退换货，5.申请通过，6.申请驳回
     */
    private Integer status;
    /**
     * 发货时间
     */
    private Date sendDate;
    /**
     * 发货信息
     */
    private String sendDetail;
    /**
     * 发货操作人
     */
    private Integer sendOperator;
    /**
     * 到货操作人
     */
    private Integer arrivalOperator;
    /**
     * 到货时间
     */
    private Date arrivalDate;
    /**
     * 收货时间
     */
    private Date receivingDate;
    /**
     * 客户期望：1.退货，2.换货
     */
    private Integer backType;
    /**
     * 申请退货时间
     */
    private Date backDate;
    /**
     * 退换货理由
     */
    private String backReason;
    /**
     * 审核人id
     */
    private Integer reviewer;
    /**
     * 审核时间
     */
    private Date auditDate;
    /**
     * 审核通过/驳回原因
     */
    private String reason;
    /**
     * 评分数1-10
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
     * 用户姓名
     */
    private String userName;
    /**
     * 用户手机号
     */
    private String userTel;
    /**
     * 商品数量
     */
    private Integer num;
    /**
     * 创建人 用户主键id【住户表】
     */
    private Integer createId;
    /**
     * 创建时间
     */
    private Date createDate;
    /**
     * 商品单价
     */
    private BigDecimal unitPrice;
    /**
     * 付款方式（1.支付宝，2.微信，3.现金，3.pos）
     */
    private Integer payType;
    /**
     * 付款金额
     */
    private BigDecimal payPrice;
    /**
     * 是否库存回库，0.未回库，1.已回库
     */
    private Integer backLibrary;

    @Override
    public String toString() {
        return "Order{" +
                "id=" + id +
                ", code='" + code + '\'' +
                ", goodsId=" + goodsId +
                ", status=" + status +
                ", sendDate=" + sendDate +
                ", sendDetail='" + sendDetail + '\'' +
                ", sendOperator=" + sendOperator +
                ", arrivalOperator=" + arrivalOperator +
                ", arrivalDate=" + arrivalDate +
                ", receivingDate=" + receivingDate +
                ", backType=" + backType +
                ", backDate=" + backDate +
                ", backReason='" + backReason + '\'' +
                ", reviewer=" + reviewer +
                ", auditDate=" + auditDate +
                ", reason='" + reason + '\'' +
                ", score=" + score +
                ", evaluationDate=" + evaluationDate +
                ", evaluationReason='" + evaluationReason + '\'' +
                ", userName='" + userName + '\'' +
                ", userTel='" + userTel + '\'' +
                ", num=" + num +
                ", createId=" + createId +
                ", createDate=" + createDate +
                ", unitPrice=" + unitPrice +
                ", payType=" + payType +
                ", payPrice=" + payPrice +
                ", backLibrary=" + backLibrary +
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

    public Integer getSendOperator() {
        return sendOperator;
    }

    public void setSendOperator(Integer sendOperator) {
        this.sendOperator = sendOperator;
    }

    public Integer getArrivalOperator() {
        return arrivalOperator;
    }

    public void setArrivalOperator(Integer arrivalOperator) {
        this.arrivalOperator = arrivalOperator;
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

    public Integer getBackType() {
        return backType;
    }

    public void setBackType(Integer backType) {
        this.backType = backType;
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

    public Integer getReviewer() {
        return reviewer;
    }

    public void setReviewer(Integer reviewer) {
        this.reviewer = reviewer;
    }

    public Date getAuditDate() {
        return auditDate;
    }

    public void setAuditDate(Date auditDate) {
        this.auditDate = auditDate;
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

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public String getUserTel() {
        return userTel;
    }

    public void setUserTel(String userTel) {
        this.userTel = userTel;
    }

    public Integer getNum() {
        return num;
    }

    public void setNum(Integer num) {
        this.num = num;
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

    public BigDecimal getUnitPrice() {
        return unitPrice;
    }

    public void setUnitPrice(BigDecimal unitPrice) {
        this.unitPrice = unitPrice;
    }

    public Integer getPayType() {
        return payType;
    }

    public void setPayType(Integer payType) {
        this.payType = payType;
    }

    public BigDecimal getPayPrice() {
        return payPrice;
    }

    public void setPayPrice(BigDecimal payPrice) {
        this.payPrice = payPrice;
    }

    public Integer getBackLibrary() {
        return backLibrary;
    }

    public void setBackLibrary(Integer backLibrary) {
        this.backLibrary = backLibrary;
    }

    public Order() {
    }

    public Order(Integer id, String code, Integer goodsId, Integer status, Date sendDate, String sendDetail, Integer sendOperator, Integer arrivalOperator, Date arrivalDate, Date receivingDate, Integer backType, Date backDate, String backReason, Integer reviewer, Date auditDate, String reason, Integer score, Date evaluationDate, String evaluationReason, String userName, String userTel, Integer num, Integer createId, Date createDate, BigDecimal unitPrice, Integer payType, BigDecimal payPrice, Integer backLibrary) {
        this.id = id;
        this.code = code;
        this.goodsId = goodsId;
        this.status = status;
        this.sendDate = sendDate;
        this.sendDetail = sendDetail;
        this.sendOperator = sendOperator;
        this.arrivalOperator = arrivalOperator;
        this.arrivalDate = arrivalDate;
        this.receivingDate = receivingDate;
        this.backType = backType;
        this.backDate = backDate;
        this.backReason = backReason;
        this.reviewer = reviewer;
        this.auditDate = auditDate;
        this.reason = reason;
        this.score = score;
        this.evaluationDate = evaluationDate;
        this.evaluationReason = evaluationReason;
        this.userName = userName;
        this.userTel = userTel;
        this.num = num;
        this.createId = createId;
        this.createDate = createDate;
        this.unitPrice = unitPrice;
        this.payType = payType;
        this.payPrice = payPrice;
        this.backLibrary = backLibrary;
    }
}
