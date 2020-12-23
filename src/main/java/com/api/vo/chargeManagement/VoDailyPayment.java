package com.api.vo.chargeManagement;

import java.math.BigDecimal;
import java.util.Date;

/**
 * 日常缴费Vo list 回显
 */
public class VoDailyPayment {
    /**
     * 缴费主键id
     */
    private Integer id;
    /**
     * 费用名称
     */
    private String name;
    /**
     * 房屋信息
     */
    private String roomName;
    /**
     * 计费开始时间
     */
    private Date beginDate;
    /**
     * 计费结束时间
     */
    private Date endDate;
    /**
     * 计费单价
     */
    private BigDecimal unitPrice;
    /**
     * 计费单位(数据字典取)
     */
    private Integer type;
    /**
     * 面积/用量/数量
     */
    private Integer num;
    /**
     * 费用金额
     */
    private BigDecimal costPrice;
    /**
     * 已缴金额
     */
    private BigDecimal paidPrice;
    /**
     * 应收总计
     */
    private BigDecimal totalPrice;
    /**
     * 待缴金额
     */
    private BigDecimal paymentPrice;
    /**
     * 状态（1.未缴纳，2.部分缴纳，3.全部缴纳）
     */
    private Integer status;
    /**
     * 备注（订单中的备注信息）
     */
    private String remake;
    /**
     * 创建人
     */
    private String createName;
    /**
     * 更新时间
     */
    private Date updateDate;
    /**
     * 房间号
     */
    private String roomNumber;
    /**
     * 单元号
     */
    private Integer unitNo;
    /**
     * 楼栋编号
     */
    private Integer estateNo;

    @Override
    public String toString() {
        return "VoDailyPayment{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", roomName='" + roomName + '\'' +
                ", beginDate=" + beginDate +
                ", endDate=" + endDate +
                ", unitPrice=" + unitPrice +
                ", type=" + type +
                ", num=" + num +
                ", costPrice=" + costPrice +
                ", paidPrice=" + paidPrice +
                ", totalPrice=" + totalPrice +
                ", paymentPrice=" + paymentPrice +
                ", status=" + status +
                ", remake='" + remake + '\'' +
                ", createName='" + createName + '\'' +
                ", updateDate=" + updateDate +
                ", roomNumber='" + roomNumber + '\'' +
                ", unitNo=" + unitNo +
                ", estateNo=" + estateNo +
                '}';
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getRoomName() {
        return roomName;
    }

    public void setRoomName(String roomName) {
        this.roomName = roomName;
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

    public BigDecimal getUnitPrice() {
        return unitPrice;
    }

    public void setUnitPrice(BigDecimal unitPrice) {
        this.unitPrice = unitPrice;
    }

    public Integer getType() {
        return type;
    }

    public void setType(Integer type) {
        this.type = type;
    }

    public Integer getNum() {
        return num;
    }

    public void setNum(Integer num) {
        this.num = num;
    }

    public BigDecimal getCostPrice() {
        return costPrice;
    }

    public void setCostPrice(BigDecimal costPrice) {
        this.costPrice = costPrice;
    }

    public BigDecimal getPaidPrice() {
        return paidPrice;
    }

    public void setPaidPrice(BigDecimal paidPrice) {
        this.paidPrice = paidPrice;
    }

    public BigDecimal getTotalPrice() {
        return totalPrice;
    }

    public void setTotalPrice(BigDecimal totalPrice) {
        this.totalPrice = totalPrice;
    }

    public BigDecimal getPaymentPrice() {
        return paymentPrice;
    }

    public void setPaymentPrice(BigDecimal paymentPrice) {
        this.paymentPrice = paymentPrice;
    }

    public Integer getStatus() {
        return status;
    }

    public void setStatus(Integer status) {
        this.status = status;
    }

    public String getRemake() {
        return remake;
    }

    public void setRemake(String remake) {
        this.remake = remake;
    }

    public String getCreateName() {
        return createName;
    }

    public void setCreateName(String createName) {
        this.createName = createName;
    }

    public Date getUpdateDate() {
        return updateDate;
    }

    public void setUpdateDate(Date updateDate) {
        this.updateDate = updateDate;
    }

    public String getRoomNumber() {
        return roomNumber;
    }

    public void setRoomNumber(String roomNumber) {
        this.roomNumber = roomNumber;
    }

    public Integer getUnitNo() {
        return unitNo;
    }

    public void setUnitNo(Integer unitNo) {
        this.unitNo = unitNo;
    }

    public Integer getEstateNo() {
        return estateNo;
    }

    public void setEstateNo(Integer estateNo) {
        this.estateNo = estateNo;
    }

    public VoDailyPayment() {
    }

    public VoDailyPayment(Integer id, String name, String roomName, Date beginDate, Date endDate, BigDecimal unitPrice, Integer type, Integer num, BigDecimal costPrice, BigDecimal paidPrice, BigDecimal totalPrice, BigDecimal paymentPrice, Integer status, String remake, String createName, Date updateDate, String roomNumber, Integer unitNo, Integer estateNo) {
        this.id = id;
        this.name = name;
        this.roomName = roomName;
        this.beginDate = beginDate;
        this.endDate = endDate;
        this.unitPrice = unitPrice;
        this.type = type;
        this.num = num;
        this.costPrice = costPrice;
        this.paidPrice = paidPrice;
        this.totalPrice = totalPrice;
        this.paymentPrice = paymentPrice;
        this.status = status;
        this.remake = remake;
        this.createName = createName;
        this.updateDate = updateDate;
        this.roomNumber = roomNumber;
        this.unitNo = unitNo;
        this.estateNo = estateNo;
    }
}
