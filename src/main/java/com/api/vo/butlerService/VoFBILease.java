package com.api.vo.butlerService;

import java.math.BigDecimal;
import java.util.Date;

/**
 * 租赁管理 vo findById 回显
 */
public class VoFBILease {
    /**
     * 租赁管理主键id
     */
    private Integer id;
    /**
     * 合同编号
     */
    private String code;
    /**
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
     * 手机号
     */
    private String tel;
    /**
     * 楼栋id
     */
    private Integer buildingId;
    /**
     * 楼栋号
     */
    private String buildingNo;
    /**
     * 单元id
     */
    private Integer unitId;
    /**
     * 单元号
     */
    private String unitNo;
    /**
     * 房产id
     */
    private Integer estateId;
    /**
     * 房间号
     */
    private String roomNumber;
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
     * 办理状态，1.待签署，2.待提交，3.审核中，4.已驳回，5.待支付，6.已完成,11.申请终止合同，12.申请终止失败，13.申请终止成功，14.已支付剩余租金，15申请退还保证金，16.申请退还保证金驳回，17.申请退还保证金成功（系统自动退还保证金）
     */
    private Integer status;
    /**
     * 收房时间
     */
    private Date takeDate;
    /**
     * 不再计租时间
     */
    private Date notMeterRentDate;
    /**
     * 剩余需结清房租（元）
     */
    private BigDecimal requiredRent;

    @Override
    public String toString() {
        return "VoFBILease{" +
                "id=" + id +
                ", code='" + code + '\'' +
                ", name='" + name + '\'' +
                ", sex=" + sex +
                ", idCard='" + idCard + '\'' +
                ", tel='" + tel + '\'' +
                ", buildingId=" + buildingId +
                ", buildingNo='" + buildingNo + '\'' +
                ", unitId=" + unitId +
                ", unitNo='" + unitNo + '\'' +
                ", estateId=" + estateId +
                ", roomNumber='" + roomNumber + '\'' +
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
                ", takeDate=" + takeDate +
                ", notMeterRentDate=" + notMeterRentDate +
                ", requiredRent=" + requiredRent +
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

    public Integer getBuildingId() {
        return buildingId;
    }

    public void setBuildingId(Integer buildingId) {
        this.buildingId = buildingId;
    }

    public String getBuildingNo() {
        return buildingNo;
    }

    public void setBuildingNo(String buildingNo) {
        this.buildingNo = buildingNo;
    }

    public Integer getUnitId() {
        return unitId;
    }

    public void setUnitId(Integer unitId) {
        this.unitId = unitId;
    }

    public String getUnitNo() {
        return unitNo;
    }

    public void setUnitNo(String unitNo) {
        this.unitNo = unitNo;
    }

    public Integer getEstateId() {
        return estateId;
    }

    public void setEstateId(Integer estateId) {
        this.estateId = estateId;
    }

    public String getRoomNumber() {
        return roomNumber;
    }

    public void setRoomNumber(String roomNumber) {
        this.roomNumber = roomNumber;
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

    public Date getTakeDate() {
        return takeDate;
    }

    public void setTakeDate(Date takeDate) {
        this.takeDate = takeDate;
    }

    public Date getNotMeterRentDate() {
        return notMeterRentDate;
    }

    public void setNotMeterRentDate(Date notMeterRentDate) {
        this.notMeterRentDate = notMeterRentDate;
    }

    public BigDecimal getRequiredRent() {
        return requiredRent;
    }

    public void setRequiredRent(BigDecimal requiredRent) {
        this.requiredRent = requiredRent;
    }

    public VoFBILease() {
    }

    public VoFBILease(Integer id, String code, String name, Integer sex, String idCard, String tel, Integer buildingId, String buildingNo, Integer unitId, String unitNo, Integer estateId, String roomNumber, Integer type, String estateType, String estateStructure, BigDecimal constructionArea, BigDecimal indoorArea, BigDecimal rentStandard, BigDecimal margin, Date leaseDateStart, Date leaseDateEnd, Integer status, Date takeDate, Date notMeterRentDate, BigDecimal requiredRent) {
        this.id = id;
        this.code = code;
        this.name = name;
        this.sex = sex;
        this.idCard = idCard;
        this.tel = tel;
        this.buildingId = buildingId;
        this.buildingNo = buildingNo;
        this.unitId = unitId;
        this.unitNo = unitNo;
        this.estateId = estateId;
        this.roomNumber = roomNumber;
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
        this.takeDate = takeDate;
        this.notMeterRentDate = notMeterRentDate;
        this.requiredRent = requiredRent;
    }
}
