package com.api.vo.app;

import com.api.vo.resources.VoResourcesImg;

import java.util.List;

/**
 * app报事报修Vo list
 */
public class AppReportRepairVo {
    /**
     * 报事报修主键id
     */
    private Integer id;
    /**
     * 绑定房屋
     */
    private String roomName;
    /**
     * 服务类型（1.公区维修（户外报修），2.家庭维修）
     */
    private Integer type;
    /**
     * 状态（1.待分配，2.已分配未接单，3.已分配处理中，4.已处理，5.已确认已完成，6.已关闭，7.已作废）
     */
    private Integer status;
    /**
     * 报修详情
     */
    private String reportDetail;
    /**
     * 照片资源集合
     */
    private List<VoResourcesImg> imgUrls;

    @Override
    public String toString() {
        return "AppReportRepairVo{" +
                "id=" + id +
                ", roomName='" + roomName + '\'' +
                ", type=" + type +
                ", status=" + status +
                ", reportDetail='" + reportDetail + '\'' +
                ", imgUrls=" + imgUrls +
                '}';
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
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

    public Integer getStatus() {
        return status;
    }

    public void setStatus(Integer status) {
        this.status = status;
    }

    public String getReportDetail() {
        return reportDetail;
    }

    public void setReportDetail(String reportDetail) {
        this.reportDetail = reportDetail;
    }

    public List<VoResourcesImg> getImgUrls() {
        return imgUrls;
    }

    public void setImgUrls(List<VoResourcesImg> imgUrls) {
        this.imgUrls = imgUrls;
    }

    public AppReportRepairVo() {
    }

    public AppReportRepairVo(Integer id, String roomName, Integer type, Integer status, String reportDetail, List<VoResourcesImg> imgUrls) {
        this.id = id;
        this.roomName = roomName;
        this.type = type;
        this.status = status;
        this.reportDetail = reportDetail;
        this.imgUrls = imgUrls;
    }
}
