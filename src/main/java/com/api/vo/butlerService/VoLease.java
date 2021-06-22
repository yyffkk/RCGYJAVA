package com.api.vo.butlerService;

import com.api.vo.resources.VoResourcesImg;

import java.math.BigDecimal;
import java.util.Date;
import java.util.List;

/**
 * 租赁管理 model
 */
public class VoLease {
    /**
     * 主键id
     */
    private Integer id;
    /***
     * 租户名称
     */
    private String name;
    /**
     * 性别：1.男，2.女
     */
    private Integer sex;
    /**
     * 身份证号
     */
    private String idCard;
    /**
     * 可租房产名称
     */
    private String roomName;
    /**
     * 人才类型：1.一类人才，2.二类人才，3.三类人才
     */
    private Integer type;
    /**
     * 房屋户型
     */
    private String estateType;
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
     * 已签署合同,上传文件路径集合
     */
    private List<VoResourcesImg> imgUrls;
    /**
     * 办理状态，1.待签署，2.待提交，3.审核中，4.已驳回，5.待支付，6.已完成
     */
    private Integer status;
    /**
     * 审核人姓名
     */
    private String reviewerName;
    /**
     * 审核时间
     */
    private Date auditDate;
    /**
     * 创建人姓名
     */
    private String createName;
    /**
     * 创建时间
     */
    private Date createDate;

    @Override
    public String toString() {
        return "VoLease{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", sex=" + sex +
                ", idCard='" + idCard + '\'' +
                ", roomName='" + roomName + '\'' +
                ", type=" + type +
                ", estateType='" + estateType + '\'' +
                ", rentStandard=" + rentStandard +
                ", margin=" + margin +
                ", leaseDateStart=" + leaseDateStart +
                ", leaseDateEnd=" + leaseDateEnd +
                ", imgUrls=" + imgUrls +
                ", status=" + status +
                ", reviewerName='" + reviewerName + '\'' +
                ", auditDate=" + auditDate +
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

    public String getRoomName() {
        return roomName;
    }

    public void setRoomName(String roomName) {
        this.roomName = roomName;
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

    public List<VoResourcesImg> getImgUrls() {
        return imgUrls;
    }

    public void setImgUrls(List<VoResourcesImg> imgUrls) {
        this.imgUrls = imgUrls;
    }

    public Integer getStatus() {
        return status;
    }

    public void setStatus(Integer status) {
        this.status = status;
    }

    public String getReviewerName() {
        return reviewerName;
    }

    public void setReviewerName(String reviewerName) {
        this.reviewerName = reviewerName;
    }

    public Date getAuditDate() {
        return auditDate;
    }

    public void setAuditDate(Date auditDate) {
        this.auditDate = auditDate;
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

    public VoLease() {
    }

    public VoLease(Integer id, String name, Integer sex, String idCard, String roomName, Integer type, String estateType, BigDecimal rentStandard, BigDecimal margin, Date leaseDateStart, Date leaseDateEnd, List<VoResourcesImg> imgUrls, Integer status, String reviewerName, Date auditDate, String createName, Date createDate) {
        this.id = id;
        this.name = name;
        this.sex = sex;
        this.idCard = idCard;
        this.roomName = roomName;
        this.type = type;
        this.estateType = estateType;
        this.rentStandard = rentStandard;
        this.margin = margin;
        this.leaseDateStart = leaseDateStart;
        this.leaseDateEnd = leaseDateEnd;
        this.imgUrls = imgUrls;
        this.status = status;
        this.reviewerName = reviewerName;
        this.auditDate = auditDate;
        this.createName = createName;
        this.createDate = createDate;
    }
}
