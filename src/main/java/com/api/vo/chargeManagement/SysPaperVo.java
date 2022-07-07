package com.api.vo.chargeManagement;

import java.math.BigDecimal;
import java.util.Date;

/**
 * 票据 Vo 回显
 */
public class SysPaperVo {
    /**
     * 票据主键id
     */
    private Integer id;
    /**
     * 开票编号
     */
    private String code;
    /**
     * 开票类型：1.增值税专用发票，2.增值税普通发票，3.国税通用机打发票，4.地税通用机打发票，5.收据
     */
    private Integer type;
    /**
     * 项目名称
     */
    private String name;
    /**
     * 总金额
     */
    private BigDecimal totalPrice;
    /**
     * 税率
     */
    private Double rate;
    /**
     * 税额
     */
    private BigDecimal taxation;
    /**
     * 开票房产名称
     */
    private String roomName;
    /**
     * 抬头类型：1.企业单位，2.个人
     */
    private Integer invoiceTitleType;
    /**
     * 抬头名称
     */
    private String invoiceTitleName;
    /**
     * 购方税号
     */
    private String acquiringEin;
    /**
     * 联系电话
     */
    private String tel;
    /**
     * 开户银行
     */
    private String bank;
    /**
     * 开户账号
     */
    private String account;
    /**
     * 开票人姓名
     */
    private String drawer;
    /**
     * 开票时间
     */
    private Date invoiceDate;
    /**
     * 备注
     */
    private String remake;
    /**
     * 领用情况：1.未领用，2.已领用
     */
    private Integer status;
    /**
     * 领用人姓名
     */
    private String recipient;
    /**
     * 领用人手机号
     */
    private String recipientsTel;
    /**
     * 领用时间
     */
    private Date recipientsDate;
    /**
     * 录入人名称
     */
    private String createName;
    /**
     * 录入时间
     */
    private Date createDate;

    @Override
    public String toString() {
        return "SysPaperVo{" +
                "id=" + id +
                ", code='" + code + '\'' +
                ", type=" + type +
                ", name='" + name + '\'' +
                ", totalPrice=" + totalPrice +
                ", rate=" + rate +
                ", taxation=" + taxation +
                ", roomName='" + roomName + '\'' +
                ", invoiceTitleType=" + invoiceTitleType +
                ", invoiceTitleName='" + invoiceTitleName + '\'' +
                ", acquiringEin='" + acquiringEin + '\'' +
                ", tel='" + tel + '\'' +
                ", bank='" + bank + '\'' +
                ", account='" + account + '\'' +
                ", drawer='" + drawer + '\'' +
                ", invoiceDate=" + invoiceDate +
                ", remake='" + remake + '\'' +
                ", status=" + status +
                ", recipient='" + recipient + '\'' +
                ", recipientsTel='" + recipientsTel + '\'' +
                ", recipientsDate=" + recipientsDate +
                ", createName='" + createName + '\'' +
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

    public Integer getType() {
        return type;
    }

    public void setType(Integer type) {
        this.type = type;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public BigDecimal getTotalPrice() {
        return totalPrice;
    }

    public void setTotalPrice(BigDecimal totalPrice) {
        this.totalPrice = totalPrice;
    }

    public Double getRate() {
        return rate;
    }

    public void setRate(Double rate) {
        this.rate = rate;
    }

    public BigDecimal getTaxation() {
        return taxation;
    }

    public void setTaxation(BigDecimal taxation) {
        this.taxation = taxation;
    }

    public String getRoomName() {
        return roomName;
    }

    public void setRoomName(String roomName) {
        this.roomName = roomName;
    }

    public Integer getInvoiceTitleType() {
        return invoiceTitleType;
    }

    public void setInvoiceTitleType(Integer invoiceTitleType) {
        this.invoiceTitleType = invoiceTitleType;
    }

    public String getInvoiceTitleName() {
        return invoiceTitleName;
    }

    public void setInvoiceTitleName(String invoiceTitleName) {
        this.invoiceTitleName = invoiceTitleName;
    }

    public String getAcquiringEin() {
        return acquiringEin;
    }

    public void setAcquiringEin(String acquiringEin) {
        this.acquiringEin = acquiringEin;
    }

    public String getTel() {
        return tel;
    }

    public void setTel(String tel) {
        this.tel = tel;
    }

    public String getBank() {
        return bank;
    }

    public void setBank(String bank) {
        this.bank = bank;
    }

    public String getAccount() {
        return account;
    }

    public void setAccount(String account) {
        this.account = account;
    }

    public String getDrawer() {
        return drawer;
    }

    public void setDrawer(String drawer) {
        this.drawer = drawer;
    }

    public Date getInvoiceDate() {
        return invoiceDate;
    }

    public void setInvoiceDate(Date invoiceDate) {
        this.invoiceDate = invoiceDate;
    }

    public String getRemake() {
        return remake;
    }

    public void setRemake(String remake) {
        this.remake = remake;
    }

    public Integer getStatus() {
        return status;
    }

    public void setStatus(Integer status) {
        this.status = status;
    }

    public String getRecipient() {
        return recipient;
    }

    public void setRecipient(String recipient) {
        this.recipient = recipient;
    }

    public String getRecipientsTel() {
        return recipientsTel;
    }

    public void setRecipientsTel(String recipientsTel) {
        this.recipientsTel = recipientsTel;
    }

    public Date getRecipientsDate() {
        return recipientsDate;
    }

    public void setRecipientsDate(Date recipientsDate) {
        this.recipientsDate = recipientsDate;
    }

    public String getCreateName() {
        return createName;
    }

    public void setCreateName(String createName) {
        this.createName = createName;
    }

    public Date getCreateDate() {
        return createDate;
    }

    public void setCreateDate(Date createDate) {
        this.createDate = createDate;
    }

    public SysPaperVo() {
    }

    public SysPaperVo(Integer id, String code, Integer type, String name, BigDecimal totalPrice, Double rate, BigDecimal taxation, String roomName, Integer invoiceTitleType, String invoiceTitleName, String acquiringEin, String tel, String bank, String account, String drawer, Date invoiceDate, String remake, Integer status, String recipient, String recipientsTel, Date recipientsDate, String createName, Date createDate) {
        this.id = id;
        this.code = code;
        this.type = type;
        this.name = name;
        this.totalPrice = totalPrice;
        this.rate = rate;
        this.taxation = taxation;
        this.roomName = roomName;
        this.invoiceTitleType = invoiceTitleType;
        this.invoiceTitleName = invoiceTitleName;
        this.acquiringEin = acquiringEin;
        this.tel = tel;
        this.bank = bank;
        this.account = account;
        this.drawer = drawer;
        this.invoiceDate = invoiceDate;
        this.remake = remake;
        this.status = status;
        this.recipient = recipient;
        this.recipientsTel = recipientsTel;
        this.recipientsDate = recipientsDate;
        this.createName = createName;
        this.createDate = createDate;
    }
}
