package com.api.model.butlerApp;

import java.util.Date;
import java.util.List;

/**
 * 管家app 跟踪检查周期信息
 */
public class ButlerTrackInspectionCycle {
    /**
     * 跟踪检查周期主键id
     */
    private Integer id;
    /**
     * 装修主键id
     */
    private Integer decorationId;
    /**
     * 跟踪人id
     */
    private Integer trackId;
    /**
     * 开始日期
     */
    private Date startDate;
    /**
     * 检查周期
     */
    private Integer inspectionCycle;
    /**
     * 下一次检查日期
     */
    private Date inspectionDateNext;
    /**
     * 跟踪检查内容信息集合
     */
    private List<ButlerTrackChecksContent> trackChecksContentList;
    /**
     * 创建人
     */
    private Integer createId;
    /**
     * 创建时间
     */
    private Date createDate;

    @Override
    public String toString() {
        return "ButlerTrackInspectionCycle{" +
                "id=" + id +
                ", decorationId=" + decorationId +
                ", trackId=" + trackId +
                ", startDate=" + startDate +
                ", inspectionCycle=" + inspectionCycle +
                ", inspectionDateNext=" + inspectionDateNext +
                ", trackChecksContentList=" + trackChecksContentList +
                ", createId=" + createId +
                ", createDate=" + createDate +
                '}';
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Integer getDecorationId() {
        return decorationId;
    }

    public void setDecorationId(Integer decorationId) {
        this.decorationId = decorationId;
    }

    public Integer getTrackId() {
        return trackId;
    }

    public void setTrackId(Integer trackId) {
        this.trackId = trackId;
    }

    public Date getStartDate() {
        return startDate;
    }

    public void setStartDate(Date startDate) {
        this.startDate = startDate;
    }

    public Integer getInspectionCycle() {
        return inspectionCycle;
    }

    public void setInspectionCycle(Integer inspectionCycle) {
        this.inspectionCycle = inspectionCycle;
    }

    public Date getInspectionDateNext() {
        return inspectionDateNext;
    }

    public void setInspectionDateNext(Date inspectionDateNext) {
        this.inspectionDateNext = inspectionDateNext;
    }

    public List<ButlerTrackChecksContent> getTrackChecksContentList() {
        return trackChecksContentList;
    }

    public void setTrackChecksContentList(List<ButlerTrackChecksContent> trackChecksContentList) {
        this.trackChecksContentList = trackChecksContentList;
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

    public ButlerTrackInspectionCycle() {
    }

    public ButlerTrackInspectionCycle(Integer id, Integer decorationId, Integer trackId, Date startDate, Integer inspectionCycle, Date inspectionDateNext, List<ButlerTrackChecksContent> trackChecksContentList, Integer createId, Date createDate) {
        this.id = id;
        this.decorationId = decorationId;
        this.trackId = trackId;
        this.startDate = startDate;
        this.inspectionCycle = inspectionCycle;
        this.inspectionDateNext = inspectionDateNext;
        this.trackChecksContentList = trackChecksContentList;
        this.createId = createId;
        this.createDate = createDate;
    }
}
