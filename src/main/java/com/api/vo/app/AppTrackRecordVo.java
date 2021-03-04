package com.api.vo.app;

import java.util.Date;
import java.util.List;

/**
 * app装修跟踪记录Vo list 回显
 */
public class AppTrackRecordVo {
    /**
     * 主键id
     */
    private Integer id;
    /**
     * 跟踪检查时间
     */
    private Date trackDate;
    /**
     * 跟踪描述
     */
    private String description;
    /**
     * 跟踪结果（1.合格，0.不合格）
     */
    private Integer result;
    /**
     * app装修跟踪记录明细Vo集合
     */
    private List<AppTrackRecordDetailVo> recordDetailVoList;

    @Override
    public String toString() {
        return "AppTrackRecordVo{" +
                "id=" + id +
                ", trackDate=" + trackDate +
                ", description='" + description + '\'' +
                ", result=" + result +
                ", recordDetailVoList=" + recordDetailVoList +
                '}';
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Date getTrackDate() {
        return trackDate;
    }

    public void setTrackDate(Date trackDate) {
        this.trackDate = trackDate;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public Integer getResult() {
        return result;
    }

    public void setResult(Integer result) {
        this.result = result;
    }

    public List<AppTrackRecordDetailVo> getRecordDetailVoList() {
        return recordDetailVoList;
    }

    public void setRecordDetailVoList(List<AppTrackRecordDetailVo> recordDetailVoList) {
        this.recordDetailVoList = recordDetailVoList;
    }

    public AppTrackRecordVo() {
    }

    public AppTrackRecordVo(Integer id, Date trackDate, String description, Integer result, List<AppTrackRecordDetailVo> recordDetailVoList) {
        this.id = id;
        this.trackDate = trackDate;
        this.description = description;
        this.result = result;
        this.recordDetailVoList = recordDetailVoList;
    }
}
