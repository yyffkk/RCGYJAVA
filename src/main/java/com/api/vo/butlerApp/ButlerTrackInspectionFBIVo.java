package com.api.vo.butlerApp;

import java.util.Date;

/**
 * 跟踪检查周期Vo findById 回显
 */
public class ButlerTrackInspectionFBIVo {
    /**
     * 跟踪检查周期表主键id
     */
    private Integer id;
    /**
     * 跟踪人id
     */
    private Integer trackId;
    /**
     * 跟踪人名称
     */
    private String trackName;
    /**
     * 开始日期
     */
    private Date startDate;
    /**
     * 检查周期
     */
    private Integer inspectionCycle;

    @Override
    public String toString() {
        return "ButlerTrackInspectionFBIVo{" +
                "id=" + id +
                ", trackId=" + trackId +
                ", trackName='" + trackName + '\'' +
                ", startDate=" + startDate +
                ", inspectionCycle=" + inspectionCycle +
                '}';
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Integer getTrackId() {
        return trackId;
    }

    public void setTrackId(Integer trackId) {
        this.trackId = trackId;
    }

    public String getTrackName() {
        return trackName;
    }

    public void setTrackName(String trackName) {
        this.trackName = trackName;
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

    public ButlerTrackInspectionFBIVo() {
    }

    public ButlerTrackInspectionFBIVo(Integer id, Integer trackId, String trackName, Date startDate, Integer inspectionCycle) {
        this.id = id;
        this.trackId = trackId;
        this.trackName = trackName;
        this.startDate = startDate;
        this.inspectionCycle = inspectionCycle;
    }
}
