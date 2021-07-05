package com.api.vo.operationManagement;

import com.api.vo.resources.VoResourcesImg;

import java.math.BigDecimal;
import java.util.Date;
import java.util.List;

/**
 * 物料出入库记录Vo findById 回显
 */
public class VoFBIMaterialRecord {
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
     * 数量
     */
    private Integer num;
    /**
     * 单价
     */
    private BigDecimal unitPrice;
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
     * 有无发票（1.有，0.无）
     */
    private Integer isInvoice;
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
     * 开票时间
     */
    private Date invoiceDate;
    /**
     * 发票备注
     */
    private String remakes;
    /**
     * 创建人名称
     */
    private String createName;
    /**
     * 创建时间
     */
    private Date createDate;
    /**
     * 发票照片文件
     */
    private List<VoResourcesImg> imgList;

    @Override
    public String toString() {
        return "VoFBIMaterialRecord{" +
                "id=" + id +
                ", code='" + code + '\'' +
                ", name='" + name + '\'' +
                ", type=" + type +
                ", num=" + num +
                ", unitPrice=" + unitPrice +
                ", unit='" + unit + '\'' +
                ", discountRate=" + discountRate +
                ", discountFrontal=" + discountFrontal +
                ", totalPrice=" + totalPrice +
                ", isInvoice=" + isInvoice +
                ", invoiceTitleType=" + invoiceTitleType +
                ", invoiceTitleName='" + invoiceTitleName + '\'' +
                ", acquiringEin='" + acquiringEin + '\'' +
                ", tel='" + tel + '\'' +
                ", invoiceDate=" + invoiceDate +
                ", remakes='" + remakes + '\'' +
                ", createName='" + createName + '\'' +
                ", createDate=" + createDate +
                ", imgList=" + imgList +
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

    public Integer getNum() {
        return num;
    }

    public void setNum(Integer num) {
        this.num = num;
    }

    public BigDecimal getUnitPrice() {
        return unitPrice;
    }

    public void setUnitPrice(BigDecimal unitPrice) {
        this.unitPrice = unitPrice;
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

    public Integer getIsInvoice() {
        return isInvoice;
    }

    public void setIsInvoice(Integer isInvoice) {
        this.isInvoice = isInvoice;
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

    public Date getInvoiceDate() {
        return invoiceDate;
    }

    public void setInvoiceDate(Date invoiceDate) {
        this.invoiceDate = invoiceDate;
    }

    public String getRemakes() {
        return remakes;
    }

    public void setRemakes(String remakes) {
        this.remakes = remakes;
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

    public List<VoResourcesImg> getImgList() {
        return imgList;
    }

    public void setImgList(List<VoResourcesImg> imgList) {
        this.imgList = imgList;
    }

    public VoFBIMaterialRecord() {
    }

    public VoFBIMaterialRecord(Integer id, String code, String name, Integer type, Integer num, BigDecimal unitPrice, String unit, Integer discountRate, BigDecimal discountFrontal, BigDecimal totalPrice, Integer isInvoice, Integer invoiceTitleType, String invoiceTitleName, String acquiringEin, String tel, Date invoiceDate, String remakes, String createName, Date createDate, List<VoResourcesImg> imgList) {
        this.id = id;
        this.code = code;
        this.name = name;
        this.type = type;
        this.num = num;
        this.unitPrice = unitPrice;
        this.unit = unit;
        this.discountRate = discountRate;
        this.discountFrontal = discountFrontal;
        this.totalPrice = totalPrice;
        this.isInvoice = isInvoice;
        this.invoiceTitleType = invoiceTitleType;
        this.invoiceTitleName = invoiceTitleName;
        this.acquiringEin = acquiringEin;
        this.tel = tel;
        this.invoiceDate = invoiceDate;
        this.remakes = remakes;
        this.createName = createName;
        this.createDate = createDate;
        this.imgList = imgList;
    }
}
