package com.api.vo.systemDataBigScreen;

import com.api.vo.resources.VoResourcesImg;

import java.math.BigDecimal;
import java.util.Date;
import java.util.List;

/**
 * 系统数据 报修工单信息
 */
public class SDReportDispatchVo {
    /**
     * 工单主键id
     */
    private Integer id;
    /**
     * 工单编号
     */
    private String code;
    /**
     * 工单状态状态（1.待处理，2.已处理）
     */
    private Integer status;
    /**
     * 处理/上报时间
     */
    private Date dateTime;
    /**
     * 服务类型（1.公区维修（户外报修），2.家庭维修）
     */
    private Integer type;
    /**
     * 房屋名称
     */
    private String roomName;
    /**
     * 联系方式
     */
    private String tel;
    /**
     * 报修时间(下单时间)
     */
    private Date repairDate;
    /**
     * 报修详情
     */
    private String reportDetail;
    /**
     * 报修来源(1.业主来电 2.app提交)
     */
    private Integer froms;
    /**
     * 维修人工费
     */
    private BigDecimal maintenanceLaborCast;
    /**
     * 维修材料费
     */
    private BigDecimal maintenanceMaterialCost;
    /**
     * 评价打分  1-10
     */
    private Integer evaluationLevel;
    /**
     * 评价内容
     */
    private String evaluationContent;
    /**
     * 评价时间
     */
    private Date evaluationDate;
    /**
     * 回访时间
     */
    private Date revisitDate;
    /**
     * 回访情况说明
     */
    private String revisitDetail;
    /**
     * 报修人
     */
    private String repairmanName;
    /**
     * 维修人
     */
    private String operatorName;
    /**
     * 工单时限
     */
    private String workOrderTimeLimit;
    /**
     * 照片资源信息集合
     */
    private List<VoResourcesImg> imgUrls;

    @Override
    public String toString() {
        return "SDReportDispatchVo{" +
                "id=" + id +
                ", code='" + code + '\'' +
                ", status=" + status +
                ", dateTime=" + dateTime +
                ", type=" + type +
                ", roomName='" + roomName + '\'' +
                ", tel='" + tel + '\'' +
                ", repairDate=" + repairDate +
                ", reportDetail='" + reportDetail + '\'' +
                ", froms=" + froms +
                ", maintenanceLaborCast=" + maintenanceLaborCast +
                ", maintenanceMaterialCost=" + maintenanceMaterialCost +
                ", evaluationLevel=" + evaluationLevel +
                ", evaluationContent='" + evaluationContent + '\'' +
                ", evaluationDate=" + evaluationDate +
                ", revisitDate=" + revisitDate +
                ", revisitDetail='" + revisitDetail + '\'' +
                ", repairmanName='" + repairmanName + '\'' +
                ", operatorName='" + operatorName + '\'' +
                ", workOrderTimeLimit='" + workOrderTimeLimit + '\'' +
                ", imgUrls=" + imgUrls +
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

    public Integer getStatus() {
        return status;
    }

    public void setStatus(Integer status) {
        this.status = status;
    }

    public Date getDateTime() {
        return dateTime;
    }

    public void setDateTime(Date dateTime) {
        this.dateTime = dateTime;
    }

    public Integer getType() {
        return type;
    }

    public void setType(Integer type) {
        this.type = type;
    }

    public String getRoomName() {
        return roomName;
    }

    public void setRoomName(String roomName) {
        this.roomName = roomName;
    }

    public String getTel() {
        return tel;
    }

    public void setTel(String tel) {
        this.tel = tel;
    }

    public Date getRepairDate() {
        return repairDate;
    }

    public void setRepairDate(Date repairDate) {
        this.repairDate = repairDate;
    }

    public String getReportDetail() {
        return reportDetail;
    }

    public void setReportDetail(String reportDetail) {
        this.reportDetail = reportDetail;
    }

    public Integer getFroms() {
        return froms;
    }

    public void setFroms(Integer froms) {
        this.froms = froms;
    }

    public BigDecimal getMaintenanceLaborCast() {
        return maintenanceLaborCast;
    }

    public void setMaintenanceLaborCast(BigDecimal maintenanceLaborCast) {
        this.maintenanceLaborCast = maintenanceLaborCast;
    }

    public BigDecimal getMaintenanceMaterialCost() {
        return maintenanceMaterialCost;
    }

    public void setMaintenanceMaterialCost(BigDecimal maintenanceMaterialCost) {
        this.maintenanceMaterialCost = maintenanceMaterialCost;
    }

    public Integer getEvaluationLevel() {
        return evaluationLevel;
    }

    public void setEvaluationLevel(Integer evaluationLevel) {
        this.evaluationLevel = evaluationLevel;
    }

    public String getEvaluationContent() {
        return evaluationContent;
    }

    public void setEvaluationContent(String evaluationContent) {
        this.evaluationContent = evaluationContent;
    }

    public Date getEvaluationDate() {
        return evaluationDate;
    }

    public void setEvaluationDate(Date evaluationDate) {
        this.evaluationDate = evaluationDate;
    }

    public Date getRevisitDate() {
        return revisitDate;
    }

    public void setRevisitDate(Date revisitDate) {
        this.revisitDate = revisitDate;
    }

    public String getRevisitDetail() {
        return revisitDetail;
    }

    public void setRevisitDetail(String revisitDetail) {
        this.revisitDetail = revisitDetail;
    }

    public String getRepairmanName() {
        return repairmanName;
    }

    public void setRepairmanName(String repairmanName) {
        this.repairmanName = repairmanName;
    }

    public String getOperatorName() {
        return operatorName;
    }

    public void setOperatorName(String operatorName) {
        this.operatorName = operatorName;
    }

    public String getWorkOrderTimeLimit() {
        return workOrderTimeLimit;
    }

    public void setWorkOrderTimeLimit(String workOrderTimeLimit) {
        this.workOrderTimeLimit = workOrderTimeLimit;
    }

    public List<VoResourcesImg> getImgUrls() {
        return imgUrls;
    }

    public void setImgUrls(List<VoResourcesImg> imgUrls) {
        this.imgUrls = imgUrls;
    }

    public SDReportDispatchVo() {
    }

    public SDReportDispatchVo(Integer id, String code, Integer status, Date dateTime, Integer type, String roomName, String tel, Date repairDate, String reportDetail, Integer froms, BigDecimal maintenanceLaborCast, BigDecimal maintenanceMaterialCost, Integer evaluationLevel, String evaluationContent, Date evaluationDate, Date revisitDate, String revisitDetail, String repairmanName, String operatorName, String workOrderTimeLimit, List<VoResourcesImg> imgUrls) {
        this.id = id;
        this.code = code;
        this.status = status;
        this.dateTime = dateTime;
        this.type = type;
        this.roomName = roomName;
        this.tel = tel;
        this.repairDate = repairDate;
        this.reportDetail = reportDetail;
        this.froms = froms;
        this.maintenanceLaborCast = maintenanceLaborCast;
        this.maintenanceMaterialCost = maintenanceMaterialCost;
        this.evaluationLevel = evaluationLevel;
        this.evaluationContent = evaluationContent;
        this.evaluationDate = evaluationDate;
        this.revisitDate = revisitDate;
        this.revisitDetail = revisitDetail;
        this.repairmanName = repairmanName;
        this.operatorName = operatorName;
        this.workOrderTimeLimit = workOrderTimeLimit;
        this.imgUrls = imgUrls;
    }
}
