package com.api.vo.butlerService;

import com.api.vo.resources.VoResourcesImg;

import java.util.Date;
import java.util.List;

/**
 * 报修详情
 */
public class VoRepair {
    /**
     * 报修主键id
     */
    private Integer id;
    /**
     * 报修区域（服务类型 1.公区维修（户外维修） 2.家庭维修）
     */
    private Integer type;
    /**
     * 报修地点
     */
    private String roomName;
    /**
     * 报修人姓名
     */
    private String repairName;
    /**
     * 联系电话
     */
    private String tel;
    /**
     * 报修来源
     */
    private Integer froms;
    /**
     * 报修时间
     */
    private Date repairDate;
    /**
     * 分配人
     */
    private String dispatchName;
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
        return "VoRepair{" +
                "id=" + id +
                ", type=" + type +
                ", roomName='" + roomName + '\'' +
                ", repairName='" + repairName + '\'' +
                ", tel='" + tel + '\'' +
                ", froms=" + froms +
                ", repairDate=" + repairDate +
                ", dispatchName='" + dispatchName + '\'' +
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

    public String getRepairName() {
        return repairName;
    }

    public void setRepairName(String repairName) {
        this.repairName = repairName;
    }

    public String getTel() {
        return tel;
    }

    public void setTel(String tel) {
        this.tel = tel;
    }

    public Integer getFroms() {
        return froms;
    }

    public void setFroms(Integer froms) {
        this.froms = froms;
    }

    public Date getRepairDate() {
        return repairDate;
    }

    public void setRepairDate(Date repairDate) {
        this.repairDate = repairDate;
    }

    public String getDispatchName() {
        return dispatchName;
    }

    public void setDispatchName(String dispatchName) {
        this.dispatchName = dispatchName;
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

    public VoRepair() {
    }

    public VoRepair(Integer id, Integer type, String roomName, String repairName, String tel, Integer froms, Date repairDate, String dispatchName, String reportDetail, List<VoResourcesImg> imgUrls) {
        this.id = id;
        this.type = type;
        this.roomName = roomName;
        this.repairName = repairName;
        this.tel = tel;
        this.froms = froms;
        this.repairDate = repairDate;
        this.dispatchName = dispatchName;
        this.reportDetail = reportDetail;
        this.imgUrls = imgUrls;
    }
}
