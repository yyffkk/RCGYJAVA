package com.aku.vo.butlerService;

import java.util.Date;
import java.util.List;

/**
 * 跟踪检查记录Vo 回显list
 */
public class VoUserDecorationTrackRecord {
    /**
     * 主键id
     */
    private Integer id;
    /**
     * 跟踪人/检查人
     */
    private String trackName;
    /**
     * 跟踪检查时间
     */
    private Date trackDate;
    /**
     * 跟踪检查记录明细表集合
     */
    private List<VoUserDecorationTrackRecordDetail> review;
    /**
     * 跟踪描述
     */
    private String description;
    /**
     * 跟踪结果(1.合格，0.不合格)
     */
    private Integer result;

    @Override
    public String toString() {
        return "VoUserDecorationTrackRecord{" +
                "id=" + id +
                ", trackName='" + trackName + '\'' +
                ", trackDate=" + trackDate +
                ", review=" + review +
                ", description='" + description + '\'' +
                ", result=" + result +
                '}';
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getTrackName() {
        return trackName;
    }

    public void setTrackName(String trackName) {
        this.trackName = trackName;
    }

    public Date getTrackDate() {
        return trackDate;
    }

    public void setTrackDate(Date trackDate) {
        this.trackDate = trackDate;
    }

    public List<VoUserDecorationTrackRecordDetail> getReview() {
        return review;
    }

    public void setReview(List<VoUserDecorationTrackRecordDetail> review) {
        this.review = review;
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

    public VoUserDecorationTrackRecord() {
    }

    public VoUserDecorationTrackRecord(Integer id, String trackName, Date trackDate, List<VoUserDecorationTrackRecordDetail> review, String description, Integer result) {
        this.id = id;
        this.trackName = trackName;
        this.trackDate = trackDate;
        this.review = review;
        this.description = description;
        this.result = result;
    }
}
