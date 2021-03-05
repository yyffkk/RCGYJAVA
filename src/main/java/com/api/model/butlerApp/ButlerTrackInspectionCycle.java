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

    public ButlerTrackInspectionCycle() {
    }

    public ButlerTrackInspectionCycle(Integer id, Integer decorationId, Integer trackId, Date startDate, Integer inspectionCycle, Date inspectionDateNext, List<ButlerTrackChecksContent> trackChecksContentList) {
        this.id = id;
        this.decorationId = decorationId;
        this.trackId = trackId;
        this.startDate = startDate;
        this.inspectionCycle = inspectionCycle;
        this.inspectionDateNext = inspectionDateNext;
        this.trackChecksContentList = trackChecksContentList;
    }
}
