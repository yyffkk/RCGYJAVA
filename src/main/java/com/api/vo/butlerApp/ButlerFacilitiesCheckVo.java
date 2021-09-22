package com.api.vo.butlerApp;

import com.api.vo.resources.VoResourcesImg;

import java.util.Date;
import java.util.List;

/**
 * 管家app 设施设备检查Vo list 回显
 */
public class ButlerFacilitiesCheckVo {
    /**
     * 主键id
     */
    private Integer id;
    /**
     * 检查执行记录编号（检查计划编号-排序sort）
     */
    private String code;
    /**
     * 设施/设备名称
     */
    private String facilitiesName;
    /**
     * 设施/设备地址
     */
    private String facilitiesAddress;
    /**
     * 任务状态：1.待完成，3.未完成(当状态为1.待完成，并且当前时间大于检查计划结束时间)，2.已完成
     */
    private Integer status;
    /**
     * 检查计划开始时间
     */
    private Date beginDate;
    /**
     * 检查计划结束时间
     */
    private Date endDate;
    /**
     * 设施/设备情况：1.正常，2.异常
     */
    private Integer situation;
    /**
     * 设施/设备检查报告
     */
    private String detail;
    /**
     * 设施/设备实际检查时间
     */
    private Date checkDate;
    /**
     * 检查照片资源信息集合
     */
    private List<VoResourcesImg> imgList;

    @Override
    public String toString() {
        return "ButlerFacilitiesCheckVo{" +
                "id=" + id +
                ", code='" + code + '\'' +
                ", facilitiesName='" + facilitiesName + '\'' +
                ", facilitiesAddress='" + facilitiesAddress + '\'' +
                ", status=" + status +
                ", beginDate=" + beginDate +
                ", endDate=" + endDate +
                ", situation=" + situation +
                ", detail='" + detail + '\'' +
                ", checkDate=" + checkDate +
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

    public String getFacilitiesName() {
        return facilitiesName;
    }

    public void setFacilitiesName(String facilitiesName) {
        this.facilitiesName = facilitiesName;
    }

    public String getFacilitiesAddress() {
        return facilitiesAddress;
    }

    public void setFacilitiesAddress(String facilitiesAddress) {
        this.facilitiesAddress = facilitiesAddress;
    }

    public Integer getStatus() {
        return status;
    }

    public void setStatus(Integer status) {
        this.status = status;
    }

    public Date getBeginDate() {
        return beginDate;
    }

    public void setBeginDate(Date beginDate) {
        this.beginDate = beginDate;
    }

    public Date getEndDate() {
        return endDate;
    }

    public void setEndDate(Date endDate) {
        this.endDate = endDate;
    }

    public Integer getSituation() {
        return situation;
    }

    public void setSituation(Integer situation) {
        this.situation = situation;
    }

    public String getDetail() {
        return detail;
    }

    public void setDetail(String detail) {
        this.detail = detail;
    }

    public Date getCheckDate() {
        return checkDate;
    }

    public void setCheckDate(Date checkDate) {
        this.checkDate = checkDate;
    }

    public List<VoResourcesImg> getImgList() {
        return imgList;
    }

    public void setImgList(List<VoResourcesImg> imgList) {
        this.imgList = imgList;
    }

    public ButlerFacilitiesCheckVo() {
    }

    public ButlerFacilitiesCheckVo(Integer id, String code, String facilitiesName, String facilitiesAddress, Integer status, Date beginDate, Date endDate, Integer situation, String detail, Date checkDate, List<VoResourcesImg> imgList) {
        this.id = id;
        this.code = code;
        this.facilitiesName = facilitiesName;
        this.facilitiesAddress = facilitiesAddress;
        this.status = status;
        this.beginDate = beginDate;
        this.endDate = endDate;
        this.situation = situation;
        this.detail = detail;
        this.checkDate = checkDate;
        this.imgList = imgList;
    }
}
