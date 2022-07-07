package com.api.vo.butlerApp;

import com.api.vo.resources.VoResourcesImg;

import java.util.Date;
import java.util.List;

/**
 * 管家app 报事报修Vo list 回显
 */
public class ButlerRepairVo {
    /**
     * 报事报修主键id
     */
    private Integer id;
    /**
     * 派工单主键id
     */
    private Integer dispatchId;
    /**
     * 报修详情
     */
    private String reportDetail;
    /**
     * 报修时间（下单时间）
     */
    private Date repairDate;
    /**
     * 状态（1.待分配，2.已分配未接单，3.已分配处理中，4.已处理，5.已确认已完成，6.已关闭，7.已作废，8.已取消）
     */
    private Integer status;
    /**
     * 照片资源信息集合
     */
    private List<VoResourcesImg> imgUrls;
    /**
     * 当前用户角色类型 type:1.派单人 2.维修人 3.其他角色
     */
    private Integer type;


    @Override
    public String toString() {
        return "ButlerRepairVo{" +
                "id=" + id +
                ", dispatchId=" + dispatchId +
                ", reportDetail='" + reportDetail + '\'' +
                ", repairDate=" + repairDate +
                ", status=" + status +
                ", imgUrls=" + imgUrls +
                ", type=" + type +
                '}';
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Integer getDispatchId() {
        return dispatchId;
    }

    public void setDispatchId(Integer dispatchId) {
        this.dispatchId = dispatchId;
    }

    public String getReportDetail() {
        return reportDetail;
    }

    public void setReportDetail(String reportDetail) {
        this.reportDetail = reportDetail;
    }

    public Date getRepairDate() {
        return repairDate;
    }

    public void setRepairDate(Date repairDate) {
        this.repairDate = repairDate;
    }

    public Integer getStatus() {
        return status;
    }

    public void setStatus(Integer status) {
        this.status = status;
    }

    public List<VoResourcesImg> getImgUrls() {
        return imgUrls;
    }

    public void setImgUrls(List<VoResourcesImg> imgUrls) {
        this.imgUrls = imgUrls;
    }

    public Integer getType() {
        return type;
    }

    public void setType(Integer type) {
        this.type = type;
    }

    public ButlerRepairVo() {
    }

    public ButlerRepairVo(Integer id, Integer dispatchId, String reportDetail, Date repairDate, Integer status, List<VoResourcesImg> imgUrls, Integer type) {
        this.id = id;
        this.dispatchId = dispatchId;
        this.reportDetail = reportDetail;
        this.repairDate = repairDate;
        this.status = status;
        this.imgUrls = imgUrls;
        this.type = type;
    }
}
