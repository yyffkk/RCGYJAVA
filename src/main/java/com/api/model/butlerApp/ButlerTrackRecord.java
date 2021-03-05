package com.api.model.butlerApp;

import java.util.Date;
import java.util.List;

/**
 * 管家app 跟踪记录信息
 */
public class ButlerTrackRecord {
    /**
     * 主键id
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
     * 跟踪检查时间
     */
    private Date trackDate;
    /**
     * 类型：1.周期检查,2.完工检查
     */
    private Integer type;
    /**
     * 跟踪描述
     */
    private String description;
    /**
     * 跟踪结果（1.合格，0.不合格）
     */
    private Integer result;
    /**
     * 创建人（物业）
     */
    private Integer createId;
    /**
     * 创建时间
     */
    private Date createDate;
    /**
     * 修改人（物业）
     */
    private Integer modifyId;
    /**
     * 修改时间
     */
    private Date modifyDate;
    /**
     * 跟踪记录信息详情集合
     */
    private List<ButlerTrackRecordDetail> trackRecordDetails;

    @Override
    public String toString() {
        return "ButlerTrackRecord{" +
                "id=" + id +
                ", decorationId=" + decorationId +
                ", trackId=" + trackId +
                ", trackDate=" + trackDate +
                ", type=" + type +
                ", description='" + description + '\'' +
                ", result=" + result +
                ", createId=" + createId +
                ", createDate=" + createDate +
                ", modifyId=" + modifyId +
                ", modifyDate=" + modifyDate +
                ", trackRecordDetails=" + trackRecordDetails +
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

    public Date getTrackDate() {
        return trackDate;
    }

    public void setTrackDate(Date trackDate) {
        this.trackDate = trackDate;
    }

    public Integer getType() {
        return type;
    }

    public void setType(Integer type) {
        this.type = type;
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

    public Integer getModifyId() {
        return modifyId;
    }

    public void setModifyId(Integer modifyId) {
        this.modifyId = modifyId;
    }

    public Date getModifyDate() {
        return modifyDate;
    }

    public void setModifyDate(Date modifyDate) {
        this.modifyDate = modifyDate;
    }

    public List<ButlerTrackRecordDetail> getTrackRecordDetails() {
        return trackRecordDetails;
    }

    public void setTrackRecordDetails(List<ButlerTrackRecordDetail> trackRecordDetails) {
        this.trackRecordDetails = trackRecordDetails;
    }

    public ButlerTrackRecord() {
    }

    public ButlerTrackRecord(Integer id, Integer decorationId, Integer trackId, Date trackDate, Integer type, String description, Integer result, Integer createId, Date createDate, Integer modifyId, Date modifyDate, List<ButlerTrackRecordDetail> trackRecordDetails) {
        this.id = id;
        this.decorationId = decorationId;
        this.trackId = trackId;
        this.trackDate = trackDate;
        this.type = type;
        this.description = description;
        this.result = result;
        this.createId = createId;
        this.createDate = createDate;
        this.modifyId = modifyId;
        this.modifyDate = modifyDate;
        this.trackRecordDetails = trackRecordDetails;
    }
}
