package com.api.model.butlerService;

import java.math.BigDecimal;
import java.util.Date;

/**
 * 租赁管理model
 */
public class SysLease {
    /**
     * 主键id
     */
    private Integer id;
    /**
     * 租户名称
     */
    private String name;
    /**
     * 性别
     */
    private Integer sex;
    /**
     * 身份证
     */
    private String idCard;
    /**
     * 手机号
     */
    private String tel;
    /**
     * 可租房产id
     */
    private Integer estateId;
    /**
     * 人才类型：1.一类人才，2.二类人才，3.三类人才
     */
    private Integer type;
    /**
     * 房屋户型
     */
    private String estateType;
    /**
     * 房屋结构
     */
    private String estateStructure;
    /**
     * 建筑面积
     */
    private BigDecimal constructionArea;
    /**
     * 使用面积（室内面积）
     */
    private BigDecimal indoorArea;
    /**
     * 租金标准 x/月
     */
    private BigDecimal rentStandard;
    /**
     * 保证金
     */
    private BigDecimal margin;
    /**
     * 租赁开始时间
     */
    private Date leaseDateStart;
    /**
     * 租赁结束时间
     */
    private Date leaseDateEnd;
    /**
     * 办理状态，1.待签署，2.待提交，3.审核中，4.已驳回，5.待支付，6.已完成
     */
    private Integer status;
    /**
     * 审核人id
     */
    private Integer reviewer;
    /**
     * 审核时间
     */
    private Date auditDate;
    /**
     * 审核备注
     */
    private String auditRemake;
    /**
     * 创建人
     */
    private Integer createId;
    /**
     * 创建时间
     */
    private Date createDate;

    @Override
    public String toString() {
        return "SysLease{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", sex=" + sex +
                ", idCard='" + idCard + '\'' +
                ", tel='" + tel + '\'' +
                ", estateId=" + estateId +
                ", type=" + type +
                ", estateType='" + estateType + '\'' +
                ", estateStructure='" + estateStructure + '\'' +
                ", constructionArea=" + constructionArea +
                ", indoorArea=" + indoorArea +
                ", rentStandard=" + rentStandard +
                ", margin=" + margin +
                ", leaseDateStart=" + leaseDateStart +
                ", leaseDateEnd=" + leaseDateEnd +
                ", status=" + status +
                ", reviewer=" + reviewer +
                ", auditDate=" + auditDate +
                ", auditRemake='" + auditRemake + '\'' +
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

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Integer getSex() {
        return sex;
    }

    public void setSex(Integer sex) {
        this.sex = sex;
    }

    public String getIdCard() {
        return idCard;
    }

    public void setIdCard(String idCard) {
        this.idCard = idCard;
    }

    public String getTel() {
        return tel;
    }

    public void setTel(String tel) {
        this.tel = tel;
    }

    public Integer getEstateId() {
        return estateId;
    }

    public void setEstateId(Integer estateId) {
        this.estateId = estateId;
    }

    public Integer getType() {
        return type;
    }

    public void setType(Integer type) {
        this.type = type;
    }

    public String getEstateType() {
        return estateType;
    }

    public void setEstateType(String estateType) {
        this.estateType = estateType;
    }

    public String getEstateStructure() {
        return estateStructure;
    }

    public void setEstateStructure(String estateStructure) {
        this.estateStructure = estateStructure;
    }

    public BigDecimal getConstructionArea() {
        return constructionArea;
    }

    public void setConstructionArea(BigDecimal constructionArea) {
        this.constructionArea = constructionArea;
    }

    public BigDecimal getIndoorArea() {
        return indoorArea;
    }

    public void setIndoorArea(BigDecimal indoorArea) {
        this.indoorArea = indoorArea;
    }

    public BigDecimal getRentStandard() {
        return rentStandard;
    }

    public void setRentStandard(BigDecimal rentStandard) {
        this.rentStandard = rentStandard;
    }

    public BigDecimal getMargin() {
        return margin;
    }

    public void setMargin(BigDecimal margin) {
        this.margin = margin;
    }

    public Date getLeaseDateStart() {
        return leaseDateStart;
    }

    public void setLeaseDateStart(Date leaseDateStart) {
        this.leaseDateStart = leaseDateStart;
    }

    public Date getLeaseDateEnd() {
        return leaseDateEnd;
    }

    public void setLeaseDateEnd(Date leaseDateEnd) {
        this.leaseDateEnd = leaseDateEnd;
    }

    public Integer getStatus() {
        return status;
    }

    public void setStatus(Integer status) {
        this.status = status;
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

    public String getAuditRemake() {
        return auditRemake;
    }

    public void setAuditRemake(String auditRemake) {
        this.auditRemake = auditRemake;
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

    public SysLease() {
    }

    public SysLease(Integer id, String name, Integer sex, String idCard, String tel, Integer estateId, Integer type, String estateType, String estateStructure, BigDecimal constructionArea, BigDecimal indoorArea, BigDecimal rentStandard, BigDecimal margin, Date leaseDateStart, Date leaseDateEnd, Integer status, Integer reviewer, Date auditDate, String auditRemake, Integer createId, Date createDate) {
        this.id = id;
        this.name = name;
        this.sex = sex;
        this.idCard = idCard;
        this.tel = tel;
        this.estateId = estateId;
        this.type = type;
        this.estateType = estateType;
        this.estateStructure = estateStructure;
        this.constructionArea = constructionArea;
        this.indoorArea = indoorArea;
        this.rentStandard = rentStandard;
        this.margin = margin;
        this.leaseDateStart = leaseDateStart;
        this.leaseDateEnd = leaseDateEnd;
        this.status = status;
        this.reviewer = reviewer;
        this.auditDate = auditDate;
        this.auditRemake = auditRemake;
        this.createId = createId;
        this.createDate = createDate;
    }
}
