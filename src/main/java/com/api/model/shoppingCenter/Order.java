package com.api.model.shoppingCenter;

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
                ", receivingDate=" + receivingDate +
                ", backType=" + backType +
                ", backDate=" + backDate +
                ", backReason='" + backReason + '\'' +
                ", reviewer=" + reviewer +
                ", auditDate=" + auditDate +
                ", reason='" + reason + '\'' +
                ", userName='" + userName + '\'' +
                ", userTel='" + userTel + '\'' +
                ", num=" + num +
                ", createId=" + createId +
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

    public Order() {
    }

    public Order(Integer id, String code, Integer goodsId, Integer status, Date sendDate, String sendDetail, Integer sendOperator, Date receivingDate, Integer backType, Date backDate, String backReason, Integer reviewer, Date auditDate, String reason, String userName, String userTel, Integer num, Integer createId, Date createDate) {
        this.id = id;
        this.code = code;
        this.goodsId = goodsId;
        this.status = status;
        this.sendDate = sendDate;
        this.sendDetail = sendDetail;
        this.sendOperator = sendOperator;
        this.receivingDate = receivingDate;
        this.backType = backType;
        this.backDate = backDate;
        this.backReason = backReason;
        this.reviewer = reviewer;
        this.auditDate = auditDate;
        this.reason = reason;
        this.userName = userName;
        this.userTel = userTel;
        this.num = num;
        this.createId = createId;
        this.createDate = createDate;
    }
}
