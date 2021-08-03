package com.api.vo.butlerApp;

import com.api.vo.resources.VoResourcesImg;

import java.util.Date;
import java.util.List;

/**
 * 管家app 报事报修工程维修 Vo list  回显
 */
public class ButlerRepairEngineeringVo {
    /**
     * 主键id
     */
    private Integer id;
    /**
     * 工程报修单号
     */
    private String code;
    /**
     * 服务类型（1.工程维修）
     */
    private Integer type;
    /**
     * 报修详情
     */
    private String reportDetail;
    /**
     * 状态（1.待派单（维修公司），2.待派单（维修人员），3.待接单，4.处理中，5.已处理，7.已作废，8.已取消）
     */
    private Integer status;
    /**
     * 照片资源信息集合
     */
    private List<VoResourcesImg> imgUrls;
    /**
     * 创建时间
     */
    private Date createDate;

    @Override
    public String toString() {
        return "ButlerRepairEngineeringVo{" +
                "id=" + id +
                ", code='" + code + '\'' +
                ", type=" + type +
                ", reportDetail='" + reportDetail + '\'' +
                ", status=" + status +
                ", imgUrls=" + imgUrls +
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

    public String getReportDetail() {
        return reportDetail;
    }

    public void setReportDetail(String reportDetail) {
        this.reportDetail = reportDetail;
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

    public Date getCreateDate() {
        return createDate;
    }

    public void setCreateDate(Date createDate) {
        this.createDate = createDate;
    }

    public ButlerRepairEngineeringVo() {
    }

    public ButlerRepairEngineeringVo(Integer id, String code, Integer type, String reportDetail, Integer status, List<VoResourcesImg> imgUrls, Date createDate) {
        this.id = id;
        this.code = code;
        this.type = type;
        this.reportDetail = reportDetail;
        this.status = status;
        this.imgUrls = imgUrls;
        this.createDate = createDate;
    }
}
