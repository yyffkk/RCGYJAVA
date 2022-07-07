package com.api.vo.butlerService;

import com.api.vo.resources.VoResourcesImg;

import java.util.Date;
import java.util.List;

/**
 * 设施管理情况信息Vo 回显
 */
public class VoFacilitiesManageSituation {
    /**
     * 主键id
     */
    private Integer id;
    /**
     * 停用时间
     */
    private Date stopDate;
    /**
     * 停用原因
     */
    private String stopReason;
    /**
     * 照片集合
     */
    private List<VoResourcesImg> imgList;

    @Override
    public String toString() {
        return "VoFacilitiesManageSituation{" +
                "id=" + id +
                ", stopDate=" + stopDate +
                ", stopReason='" + stopReason + '\'' +
                ", imgList=" + imgList +
                '}';
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Date getStopDate() {
        return stopDate;
    }

    public void setStopDate(Date stopDate) {
        this.stopDate = stopDate;
    }

    public String getStopReason() {
        return stopReason;
    }

    public void setStopReason(String stopReason) {
        this.stopReason = stopReason;
    }

    public List<VoResourcesImg> getImgList() {
        return imgList;
    }

    public void setImgList(List<VoResourcesImg> imgList) {
        this.imgList = imgList;
    }

    public VoFacilitiesManageSituation() {
    }

    public VoFacilitiesManageSituation(Integer id, Date stopDate, String stopReason, List<VoResourcesImg> imgList) {
        this.id = id;
        this.stopDate = stopDate;
        this.stopReason = stopReason;
        this.imgList = imgList;
    }
}
