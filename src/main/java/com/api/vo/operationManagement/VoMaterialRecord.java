package com.api.vo.operationManagement;

import java.math.BigDecimal;
import java.util.Date;

/**
 * 物料出入库记录Vo list 回显
 */
public class VoMaterialRecord {
    /**
     * 物料出入库记录主键id
     */
    private Integer id;
    /**
     * 记录单号
     */
    private String code;
    /**
     * 物料名称
     */
    private String name;
    /**
     * 类型：1.出库，2.入库
     */
    private Integer type;
    /**
     * 单价
     */
    private BigDecimal unitPrice;
    /**
     * 数量
     */
    private Integer num;
    /**
     * 单位
     */
    private String unit;
    /**
     * 折扣率（填%前面的值）
     */
    private Integer discountRate;
    /**
     * 折扣额
     */
    private BigDecimal discountFrontal;
    /**
     * 总金额（单价*单位*（1-折扣率/100））
     */
    private BigDecimal totalPrice;
    /**
     * 当前可用库存
     */
    private Integer nowStock;
    /**
     * 创建人名称
     */
    private String createName;
    /**
     * 创建时间
     */
    private Date createDate;

    @Override
    public String toString() {
        return "VoMaterialRecord{" +
                "id=" + id +
                ", code='" + code + '\'' +
                ", name='" + name + '\'' +
                ", type=" + type +
                ", unitPrice=" + unitPrice +
                ", num=" + num +
                ", unit='" + unit + '\'' +
                ", discountRate=" + discountRate +
                ", discountFrontal=" + discountFrontal +
                ", totalPrice=" + totalPrice +
                ", nowStock=" + nowStock +
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

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Integer getType() {
        return type;
    }

    public void setType(Integer type) {
        this.type = type;
    }

    public BigDecimal getUnitPrice() {
        return unitPrice;
    }

    public void setUnitPrice(BigDecimal unitPrice) {
        this.unitPrice = unitPrice;
    }

    public Integer getNum() {
        return num;
    }

    public void setNum(Integer num) {
        this.num = num;
    }

    public String getUnit() {
        return unit;
    }

    public void setUnit(String unit) {
        this.unit = unit;
    }

    public Integer getDiscountRate() {
        return discountRate;
    }

    public void setDiscountRate(Integer discountRate) {
        this.discountRate = discountRate;
    }

    public BigDecimal getDiscountFrontal() {
        return discountFrontal;
    }

    public void setDiscountFrontal(BigDecimal discountFrontal) {
        this.discountFrontal = discountFrontal;
    }

    public BigDecimal getTotalPrice() {
        return totalPrice;
    }

    public void setTotalPrice(BigDecimal totalPrice) {
        this.totalPrice = totalPrice;
    }

    public Integer getNowStock() {
        return nowStock;
    }

    public void setNowStock(Integer nowStock) {
        this.nowStock = nowStock;
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

    public VoMaterialRecord() {
    }

    public VoMaterialRecord(Integer id, String code, String name, Integer type, BigDecimal unitPrice, Integer num, String unit, Integer discountRate, BigDecimal discountFrontal, BigDecimal totalPrice, Integer nowStock, String createName, Date createDate) {
        this.id = id;
        this.code = code;
        this.name = name;
        this.type = type;
        this.unitPrice = unitPrice;
        this.num = num;
        this.unit = unit;
        this.discountRate = discountRate;
        this.discountFrontal = discountFrontal;
        this.totalPrice = totalPrice;
        this.nowStock = nowStock;
        this.createName = createName;
        this.createDate = createDate;
    }
}
