package com.api.model.butlerService;

import java.util.Arrays;
import java.util.Date;

/**
 * 报事报修model insert
 */
public class ReportRepair {
    /**
     * 主键id
     */
    private Integer id;
    /**
     * 报修单号(同工单号相同)
     */
    private String code;
    /**
     * 派工单id
     */
    private Integer dispatchListId;
    /**
     * 服务类型（1.公区维修（户外报修），2.家庭维修）
     */
    private Integer type;
    /**
     * 报修详情
     */
    private String reportDetail;
    /**
     * 报修人
     */
    private Integer repairman;
    /**
     * 联系方式
     */
    private String tel;
    /**
     * 报修时间
     */
    private Date repairDate;
    /**
     * 报修来源(1.业主来电 2.app提交)
     */
    private Integer froms;
    /**
     * 创建人（录单人,app提交为 -1）
     */
    private Integer createId;
    /**
     * 创建时间（录单时间）
     */
    private Date createDate;
    /**
     * 修改人
     */
    private Integer modifyId;
    /**
     * 修改时间
     */
    private Date modifyDate;
    /**
     * 上传文件路径数据
     */
    private String[] fileUrls;

    @Override
    public String toString() {
        return "ReportRepair{" +
                "id=" + id +
                ", code='" + code + '\'' +
                ", dispatchListId=" + dispatchListId +
                ", type=" + type +
                ", reportDetail='" + reportDetail + '\'' +
                ", repairman=" + repairman +
                ", tel='" + tel + '\'' +
                ", repairDate=" + repairDate +
                ", froms=" + froms +
                ", createId=" + createId +
                ", createDate=" + createDate +
                ", modifyId=" + modifyId +
                ", modifyDate=" + modifyDate +
                ", fileUrls=" + Arrays.toString(fileUrls) +
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

    public Integer getDispatchListId() {
        return dispatchListId;
    }

    public void setDispatchListId(Integer dispatchListId) {
        this.dispatchListId = dispatchListId;
    }

    public Integer getType() {
        return type;
    }

    public void setType(Integer type) {
        this.type = type;
    }

    public String getReportDetail() {
        return reportDetail;
    }

    public void setReportDetail(String reportDetail) {
        this.reportDetail = reportDetail;
    }

    public Integer getRepairman() {
        return repairman;
    }

    public void setRepairman(Integer repairman) {
        this.repairman = repairman;
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

    public Integer getFroms() {
        return froms;
    }

    public void setFroms(Integer froms) {
        this.froms = froms;
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

    public Integer getModifyId() {
        return modifyId;
    }

    public void setModifyId(Integer modifyId) {
        this.modifyId = modifyId;
    }

    public Date getModifyDate() {
        return modifyDate;
    }

    public void setModifyDate(Date modifyDate) {
        this.modifyDate = modifyDate;
    }

    public String[] getFileUrls() {
        return fileUrls;
    }

    public void setFileUrls(String[] fileUrls) {
        this.fileUrls = fileUrls;
    }

    public ReportRepair() {
    }

    public ReportRepair(Integer id, String code, Integer dispatchListId, Integer type, String reportDetail, Integer repairman, String tel, Date repairDate, Integer froms, Integer createId, Date createDate, Integer modifyId, Date modifyDate, String[] fileUrls) {
        this.id = id;
        this.code = code;
        this.dispatchListId = dispatchListId;
        this.type = type;
        this.reportDetail = reportDetail;
        this.repairman = repairman;
        this.tel = tel;
        this.repairDate = repairDate;
        this.froms = froms;
        this.createId = createId;
        this.createDate = createDate;
        this.modifyId = modifyId;
        this.modifyDate = modifyDate;
        this.fileUrls = fileUrls;
    }
}
