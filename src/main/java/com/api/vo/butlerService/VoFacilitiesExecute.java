package com.api.vo.butlerService;

import com.api.vo.resources.VoResourcesImg;

import java.util.Date;
import java.util.List;

/**
 * 设施设备检查记录Vo list 回显
 */
public class VoFacilitiesExecute {
    /**
     * 主键id
     */
    private Integer id;
    /**
     * 检查执行记录编号（检查计划编号-排序sort）
     */
    private String code;
    /**
     * 分类名称
     */
    private String categoryName;
    /**
     * 设施/设备名称
     */
    private String facilitiesName;
    /**
     * 检查人姓名
     */
    private String examinerName;
    /**
     * 检查人联系方式
     */
    private String examinerTel;
    /**
     * 任务状态
     */
    private Integer status;
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
        return "VoFacilitiesExecute{" +
                "id=" + id +
                ", code='" + code + '\'' +
                ", categoryName='" + categoryName + '\'' +
                ", facilitiesName='" + facilitiesName + '\'' +
                ", examinerName='" + examinerName + '\'' +
                ", examinerTel='" + examinerTel + '\'' +
                ", status=" + status +
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

    public String getCategoryName() {
        return categoryName;
    }

    public void setCategoryName(String categoryName) {
        this.categoryName = categoryName;
    }

    public String getFacilitiesName() {
        return facilitiesName;
    }

    public void setFacilitiesName(String facilitiesName) {
        this.facilitiesName = facilitiesName;
    }

    public String getExaminerName() {
        return examinerName;
    }

    public void setExaminerName(String examinerName) {
        this.examinerName = examinerName;
    }

    public String getExaminerTel() {
        return examinerTel;
    }

    public void setExaminerTel(String examinerTel) {
        this.examinerTel = examinerTel;
    }

    public Integer getStatus() {
        return status;
    }

    public void setStatus(Integer status) {
        this.status = status;
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

    public VoFacilitiesExecute() {
    }

    public VoFacilitiesExecute(Integer id, String code, String categoryName, String facilitiesName, String examinerName, String examinerTel, Integer status, Integer situation, String detail, Date checkDate, List<VoResourcesImg> imgList) {
        this.id = id;
        this.code = code;
        this.categoryName = categoryName;
        this.facilitiesName = facilitiesName;
        this.examinerName = examinerName;
        this.examinerTel = examinerTel;
        this.status = status;
        this.situation = situation;
        this.detail = detail;
        this.checkDate = checkDate;
        this.imgList = imgList;
    }
}
